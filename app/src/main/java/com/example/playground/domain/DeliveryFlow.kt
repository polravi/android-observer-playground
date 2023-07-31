package com.example.playground.domain

import android.util.Log
import com.example.playground.common.OrderState
import com.mcdonalds.domain.flows.OrderFlow

class DeliveryFlow(private val orderFlowDomain: OrderFlowDomain
) : OrderFlow() {

    override fun onPullable() {

    }

    override fun onSubmittablePendingPayment() {
       // orderFlowDomain.api().patchPayment(true)
        Log.d("Orders2.0","Patching Payment : calling patch payment API")
        orderFlowDomain.setState(OrderState.SUBMITTABLE.value)
    }

    override fun onSubmittedPendingPayment() {

    }

    override fun onFulfillingSubmittablePendingPayment() {

    }

    override fun onSubmittable() {
        //orderFlowDomain.api().getOrderSummary()
        Log.d("Orders2.0","checking Order Status: calling OrderSummary API")
        orderFlowDomain.setState(OrderState.FULFILLED.value)
    }

    override fun onCompleted() {
        Log.d("Orders2.0", "Order is in ${orderFlowDomain.currentOrderState().toString()} state")
        Log.d("Orders2.0", "Order is completed. Do clean up!!")
    }
}
