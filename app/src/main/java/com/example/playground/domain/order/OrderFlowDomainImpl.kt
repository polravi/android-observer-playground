package com.example.playground.domain.order

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.playground.common.Flow
import com.example.playground.common.OrderState
import com.example.playground.domain.order.OrderFlowState
import com.example.playground.flows.DeliveryFlow
import com.example.playground.flows.OrderFlow
import com.example.playground.models.Order
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random


const val ORDER_FLOW_LOGGING_TAG = "OrderFlow"

@Suppress("TooManyFunctions")
@Singleton
class OrderFlowDomainImpl @Inject constructor(
    //private val orderFlowStateSaver: DataSaver<OrderFlowState>,

    //private val orderRestaurantRepo: OrderRestaurantRepo
) : OrderFlowDomain {
    private val deliveryFlow: DeliveryFlow = DeliveryFlow(this)
    private val orderFlowState: MutableLiveData<OrderFlowState?> = MutableLiveData()

    private var overrideFlowTo: OrderFlow? = null

    override fun overrideFlow(flow: Flow) {
        this.overrideFlowTo = deliveryFlow

    }

    override fun getEnabledFlow(): OrderFlow {
        return deliveryFlow
    }

    override fun orderFlowState(): MutableLiveData<OrderFlowState?> {
        return orderFlowState
    }

    override fun currentOrderState(): OrderState? {
        return orderFlowState.value?.orderState()
    }

    override fun postOrder() {
        Log.d("Orders2.0", "Placing Order : calling post order API")
        setState(OrderState.SUBMITTABLE_PENDING_PAYMENT.value)
    }

//    override fun pollingOrderState(): OrderState? {
//        return if (orderFlowState.value?.orderState() != null)
//            orderFlowState.value?.orderState()?.let { OrderState.valueOf(it) }
//        else
//            null
//    }

    override fun advanceOrder() {
        orderFlowState.value?.let { state ->
            getEnabledFlow().advanceOrder(state)
        }
    }

    override fun setState(state: String) {


        var orderObject = Order(state)
        var orderState = OrderFlowState(orderObject)
        var sleepTime =Random.nextLong(0,10000)
        Thread.sleep(sleepTime)
        Log.d("Orders2.0", "Received API response : Order State changed to : ${state} , response time : ${sleepTime}")
        orderFlowState.postValue(orderState)

    }
}





