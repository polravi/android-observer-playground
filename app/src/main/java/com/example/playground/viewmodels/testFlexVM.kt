package com.example.playground.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
/*
class testFlexVM {

    fun handlePlaceOrder(context: Context, lifecycleOwner: LifecycleOwner, onSuccessCallback: (OrderFlowState) -> Unit) {
        val basketDomain: BasketDomain? = basketDomain as BasketDomain?
        val orderFlowDomain: OrderFlowDomain? = orderFlowDomain as OrderFlowDomain?
        val orderRestaurantRepo: OrderRestaurantRepo? = orderRestaurantRepo() as OrderRestaurantRepo?
        val restaurantID: Long? = orderRestaurantRepo()?.restaurant?.getValue()?.getId()


        orderFlowDomain?.let { domain ->
            val orderObserver = object : OrderFlowObserver(domain) {
                @Suppress("EmptyFunctionBlock") // TODO
                override fun onOrderInTerminalState() {

                }

                override fun paymentErrorAlert(orderFlowState: OrderFlowState) {
                    TODO("Not yet implemented")
                }

                override fun isSuccess(orderFlowState: OrderFlowState): Boolean =
                    orderFlowState.order != null

                override fun onSuccess(orderFlowState: OrderFlowState) {
                    Log.d(TAG, "Place order success+${orderFlowState.order?.state}")
                    handlePlaceSuccess(context, lifecycleOwner, onSuccessCallback)
                    Log.d(TAG, "Advance order success +${
                        orderFlowState.order?.deliveryStatus?.state
                    }")

                }

                override fun onException(exception: Exception) {
                    Log.e("FAIL", "ERROR")
                }

                override fun onBusinessError(orderError: OrderError?, cartError: CartError?) {
                    Log.e("Business", "error")
                }
            }

            orderFlowDomain?.orderFlowState()?.observe(lifecycleOwner, orderObserver)

            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    orderRestaurantRepo?.orderRestaurant()?.let { restaurant ->
                        mPreselectedFundingSource?.let { fundingSource ->
                            basketDomain?.let { basket ->
                                orderFlowDomain?.api()?.postOrder(
                                    channel = FulfillmentArea.Delivery.channel.channelString,
                                    restaurantId = restaurant.id,
                                    fundingSource = fundingSource,
                                    orderRequest = basket.getOrderInitializationDataOrderRequest(),
                                    orderFulfillmentArea = fulfillmentArea,
                                    deliveryInformation = getDeliveryInformation(fulfillmentArea)
                                )
                            }
                        }
                    }
                }
            }
        }
    }


    fun handlePlaceSuccess(context: Context, lifecycleOwner: LifecycleOwner, onSuccessCallback: (OrderFlowState) -> Unit) {
        val orderFlowDomain: OrderFlowDomain? = orderFlowDomain as OrderFlowDomain?

        val orderObserver = object : OrderFlowObserver(orderFlowDomain!!) {
            @Suppress("EmptyFunctionBlock") // TODO
            override fun onOrderInTerminalState() {

            }

            override fun paymentErrorAlert(orderFlowState: OrderFlowState) {
                TODO("Not yet implemented")
            }

            override fun isSuccess(orderFlowState: OrderFlowState): Boolean =
                orderFlowState.order != null

            override fun onSuccess(orderFlowState: OrderFlowState) {
                orderFlowDomain?.advanceOrder()
            }

            override fun onException(exception: Exception) {
                Log.e("FAIL", "ERROR")
            }

            override fun onBusinessError(orderError: OrderError?, cartError: CartError?) {
                Log.e("Business", "error")
            }
        }

        orderFlowDomain?.orderFlowState()?.observe(lifecycleOwner, orderObserver)

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                orderFlowDomain.advanceOrder();
            }
            var orderFlowState = orderFlowDomain.currentOrderState()?.value

            Log.d(TAG, "Place order successAdvance+${orderFlowState}")
            var ordercheck = orderFlowDomain?.orderStateDelivery()?.value
            Log.d(TAG, "Final State Value + ${ordercheck.toString()}")

        }
    }

}

 */