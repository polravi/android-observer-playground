package com.example.playground.observers

import android.util.Log
import com.example.playground.domain.order.OrderFlowDomain
import com.example.playground.domain.order.OrderFlowState

class DeliveryFlowObserver(orderFlowDomain: OrderFlowDomain) : OrderFlowObserver(orderFlowDomain) {
    @Suppress("EmptyFunctionBlock") // TODO
    override fun onOrderInTerminalState() {
    }

    override fun paymentErrorAlert(orderFlowState: OrderFlowState) {
        TODO("Not yet implemented")
    }

    override fun isSuccess(orderFlowState: OrderFlowState): Boolean =
        orderFlowState.order != null

    override fun onSuccess(orderFlowState: OrderFlowState) {
        orderFlowDomain.advanceOrder()
    }

    override fun onException(exception: Exception) {
        Log.e("FAIL", "ERROR")
    }

}
