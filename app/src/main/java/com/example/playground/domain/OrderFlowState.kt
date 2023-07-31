package com.example.playground.domain

import com.example.playground.common.OrderState

data class OrderFlowState
    (
    val order: Order? = null,
    val exception: Exception? = null,
            )
{

    //This function an only be used for FCI workflow and not ROA

    fun orderState(): OrderState? {
        return order?.state?.let { OrderState.valueOf(it) }
    }
    }
//
//    fun pollingOrderState(): OrderState? {
//        return orderSummary?.orderState?.let { OrderState.valueOf(it) }
//    }
//
//    fun cartId(): String? = cartUpdateResult?.cart?.id
//
////    fun cartFulfillmentArea(): OrderFulfillmentArea? = cartUpdateResult?.cart?.orderInitializationData?.fulfillmentArea
//
//    fun restaurantId(): Long? = order?.restaurantID ?: cartUpdateResult?.cart?.restaurantID
//
//    fun shortCode(): String? = order?.shortCode ?: cartUpdateResult?.cart?.shortCode

//    fun feeChoices(): RealmList<OrderRequestCartAdditionalChargeChoices>? =
//        order?.orderRequest?.cart?.feeChoices ?:
//        cartUpdateResult?.cart?.orderInitializationData?.orderRequest?.cart?.feeChoices

//    fun getLastOrderTime(): String {
//        order?.let { order ->
//            return order.creationTime
//        }
//        return AppCoreConstants.ZERO_STRING
//    }
//}