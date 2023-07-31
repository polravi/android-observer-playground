package com.example.playground.flows

import android.util.Log
import com.example.playground.common.OrderState
import com.example.playground.domain.order.ORDER_FLOW_LOGGING_TAG
import com.example.playground.domain.order.OrderFlowState

import com.example.playground.common.OrderState.*

@Suppress("TooManyFunctions")
open // we'll have to discuss this, we should have one per state
class OrderFlow {
    // This function performs the next step in the business logic for a given
    // order, including API calls and Order object manipulation
    @Suppress("ComplexMethod") // This should be all right - we need to cover all cases
    fun advanceOrder(orderFlowState: OrderFlowState) {


            orderFlowState.order?.state?.let { state ->
                Log.i(ORDER_FLOW_LOGGING_TAG, "Advancing order to :  ${state}")
                when (OrderState.valueOf(state)) {
                  INITIALIZED -> onInitialized()
                   PULLABLE -> onPullable()
                    SUBMITTABLE_PENDING_PAYMENT -> onSubmittablePendingPayment()
                        SUBMITTABLE -> onSubmittable()
                    PULLED -> onPulled()
                    SUBMITTED_PENDING_PAYMENT -> onSubmittedPendingPayment()
                    SUBMITTED -> onSubmitted()
                    FULFILLING_SUBMITTABLE_PENDING_PAYMENT -> onFulfillingSubmittablePendingPayment()
                    FULFILLING_SUBMITTABLE -> onFulfillingSubmittable()
                    FULFILLING_WAITING -> onFulfillingWaiting()
                    FULFILLING_SUBMITING -> onFulfillingSubmitting()
                    FULFILLING_PREPARING -> onFulfillingPreparing()
                    FULFILLING_READY -> onFulfillingReady()
                    FULFILLING_SERVING_PENDING_FULFILLMENT_AREA ->
                        onFulfillingServingPendingFulfillmentArea()
                    FULFILLING_SERVING -> onFulfillingServing()
                    MONITORING_FOR_RECONCILIATION -> onMonitoringForReconciliation()
                    FULFILLED_PENDING_PAYMENT_REVERSAL -> onFulfilledPendingPaymentReversal()
                    FAILED_TO_FULFILL_PENDING_PAYMENT_REVERSAL ->
                        onFailedToFulfillPendingPaymentReversal()
                    CANCELLED_PENDING_PAYMENT_REVERSAL -> onCancelledPendingPaymentReversal()
                    FULFILLED,
                    FAILED_TO_FULFILL,
                    CANCELLED -> onCompleted()

                }
            }

    }

    // We have one abstract function for each possible Order State, except finished states
    // This allows us to implement tem in OrderFlow where the behavior is the same and implement
    // Separate paths for ROA and FCI where necessary
    // Most of these functions will likely be removed as we discover where the differences are
    open fun onInitialized() {}
    open fun onPullable() {}
    open fun onSubmittablePendingPayment() {}
    open fun onSubmittable() {}
    open fun onPulled() {}
    open fun onSubmittedPendingPayment() {}
    open fun onSubmitted() {}
    open fun onFulfillingSubmittablePendingPayment() {}
    open fun onFulfillingSubmittable() {}
    open fun onFulfillingWaiting() {}
    open fun onFulfillingSubmitting() {}
    open fun onFulfillingPreparing() {}
    open fun onFulfillingReady() {}
    open fun onFulfillingServingPendingFulfillmentArea() {}
    open fun onFulfillingServing() {}
    open fun onMonitoringForReconciliation() {}
    open fun onFulfilledPendingPaymentReversal() {}
    open fun onCancelledPendingPaymentReversal() {}
    open fun onFailedToFulfillPendingPaymentReversal() {}
    open fun onPreorderCartAvailable() {}

    open fun onFulfillmentAreaUpdated() {}
    open fun onRestaurantUpdated(id: Long) {}

    open fun onCompleted(){}

    companion object {
        val completedStates = listOf(FULFILLED, FAILED_TO_FULFILL, CANCELLED)
    }

}
