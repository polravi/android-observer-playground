package com.example.playground.observers

import android.util.Log
import androidx.lifecycle.Observer
import com.example.playground.common.OrderState
import com.example.playground.domain.order.OrderFlowDomain
import com.example.playground.domain.order.OrderFlowState

abstract class OrderFlowObserver(val orderFlowDomain: OrderFlowDomain): Observer<OrderFlowState?> {

    override fun onChanged(orderFlowState: OrderFlowState?) {
        orderFlowState?.let {
            when {
                orderFlowState.exception != null -> {
                    Log.d("Orders2.0" ,"I'm in OrderFlowObserver + exception state")
                    //orderFlowDomain.orderFlowState().removeObserver(this)
                    orderFlowState.exception?.let { onException(it) }
                    // Clear exception so that the observer does not trigger onException multiple times
                    //orderFlowDomain.updateErrorInformation(null, null)
                }
                TERMINAL_ORDER_STATES.contains(orderFlowState.orderState()) ->{
                    Log.d("Orders2.0",this.toString())
                    orderFlowDomain.orderFlowState().removeObserver(this)
                }
//                orderFlowState.orderError != null -> {
//                    orderFlowDomain.orderFlowState().removeObserver(this)
//                    orderFlowState.orderError?.let { onBusinessError(it, null) }
//                    // Clear error so that the observer does not trigger onError multiple times
//                    orderFlowDomain.updateErrorInformation(null, null)
//                }
//                orderFlowState.cartError != null -> {
//                    orderFlowDomain.orderFlowState().removeObserver(this)
//                    orderFlowState.cartError?.let { onBusinessError(null, it) }
//                    // Clear error so that the observer does not trigger onError multiple times
//                    orderFlowDomain.updateErrorInformation(null, null)
//                }
//                TERMINAL_FAILED_STATES.contains(orderFlowState.orderState())
//                        || TERMINAL_FAILED_STATES.contains(orderFlowState.pollingOrderState()) -> {
//                    orderFlowDomain.orderFlowState().removeObserver(this)
//                    if(orderFlowState.order?.paymentData?.channelPaymentResult?.status.equals(AppCoreConstants.PAYMENT_FAILED)){
//                        paymentErrorAlert(orderFlowState)
//                    }else {
//                        onOrderInTerminalState()
//                    }
           //     }
                isSuccess(orderFlowState) -> {
                    //Log.d("Orders2.0" ,"OrderFlowObserver - triggering onSuccess of Implementor")
                    //orderFlowDomain.orderFlowState().removeObserver(this)
                    onSuccess(orderFlowState)
                }
                else -> {}
            }
        }
    }

    abstract fun onOrderInTerminalState()
    abstract fun paymentErrorAlert(orderFlowState: OrderFlowState)
    abstract fun isSuccess(orderFlowState: OrderFlowState): Boolean
    abstract fun onSuccess(orderFlowState: OrderFlowState)
    abstract fun onException(exception: Exception)
   // abstract fun onBusinessError(orderError: OrderError?, cartError: CartError?)

    companion object {
        val TERMINAL_ORDER_STATES = listOf(
            OrderState.FULFILLED,
            OrderState.FULFILLING_PREPARING,
            OrderState.FULFILLING_READY,
            OrderState.FULFILLING_SERVING,
            OrderState.FAILED_TO_FULFILL,
            OrderState.FAILED_TO_FULFILL_PENDING_PAYMENT_REVERSAL,
            OrderState.CANCELLED)

        val TERMINAL_FAILED_STATES = listOf(
            OrderState.FAILED_TO_FULFILL,
            OrderState.CANCELLED,
            OrderState.FAILED_TO_FULFILL_PENDING_PAYMENT_REVERSAL
        )
    }
}
