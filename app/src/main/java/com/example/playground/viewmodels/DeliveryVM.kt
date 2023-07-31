package com.example.playground.viewmodels

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.playground.domain.InitialDomainSetter
import com.example.playground.domain.order.OrderFlowDomain
import com.example.playground.domain.order.OrderFlowState
import com.example.playground.observers.DeliveryFlowObserver
import kotlinx.coroutines.*

class DeliveryVM (private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default) : ViewModel() {
    var orderFlowDomain: OrderFlowDomain? = null
    //val orderFlowState: LiveData<OrderFlowState?> get()= orderFlowDomain.orderFlowState()
    private val TAG = "Place Order 2.0"


    init {
        if (orderFlowDomain == null) {
            orderFlowDomain = InitialDomainSetter.getDefaultDomain()
        }
    }

    fun handlePlaceOrder(
        lifecycleOwner: LifecycleOwner,
    ){
        val orderFlowDomain = orderFlowDomain
        var result: OrderFlowState? = null

        //subscribing observer - always make sure, you only subscribe the observer once in your flow
        orderFlowDomain?.let { domain ->
            domain?.orderFlowState()?.observe(lifecycleOwner, DeliveryFlowObserver(domain))

            //your coroutine
            viewModelScope.launch {
                postDeliveryOrder()
                Log.d("Orders2.0", "Coroutine completed")

            }

        }
    }


    suspend fun postDeliveryOrder() {

            orderFlowDomain?.postOrder()

    }

}