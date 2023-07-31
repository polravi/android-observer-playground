package com.example.playground.domain.order

import androidx.lifecycle.MutableLiveData
import com.example.playground.common.Flow
import com.example.playground.common.OrderState
import com.example.playground.domain.order.OrderFlowState
import com.example.playground.flows.OrderFlow

@Suppress("TooManyFunctions")
sealed interface OrderFlowDomain {
    fun orderFlowState(): MutableLiveData<OrderFlowState?>

//    fun orderStateDelivery(): MutableLiveData<OrderSummary?>

    fun currentOrderState(): OrderState?
    fun postOrder()

    //fun pollingOrderState(): OrderState?

//    fun currentOrder(): Order?
//
//    fun updateCurrentOrder(
//        order: Order? = null,
//        cartUpdateResult: CartUpdateResult? = null,
//        orderSummary: OrderSummary? = null,
//        orderError: OrderError? = null,
//        cartError: CartError? = null,
//        exception: Exception? = null,
//        cartValidationFailureResult: CartValidationResult? = null)
//
//    fun updateErrorInformation(orderError: OrderError? = null, cartError: CartError? = null, exception: Exception? = null)
//    fun updateOrderSummary(orderSummary: OrderSummary? = null)
//
//    fun getFulfillmentArea(): OrderFulfillmentArea?
//    fun getFulfillmentChannel(): String
//    fun setFulfillmentArea(fulfillmentArea: OrderFulfillmentArea, channel: String = DEFAULT_CHANNEL, doNotCallApi: Boolean = false)
//    fun getFundingSource(): PreselectedFundingSource?
//    fun setFundingSource(fundingSource: PreselectedFundingSource)
//    fun setAppName(appName: String)
//    fun loadOrderFlowState()
//    fun enabledFlowEnum(): Flow
//    fun startPollingOrderSummary()
//    fun stopPollingOrderSummary()
//
//    fun api(): API
//
//    interface API {
//        fun getOrderSummary()
//
//        fun postPreorderCart(
//            channel: String = DEFAULT_CHANNEL,
//            orderRequest: OrderInitializationDataOrderRequest,
//            orderFulfillmentArea: OrderFulfillmentArea,
//            fundingSource: PreselectedFundingSource,
//            deliveryInformation: DeliveryInformation?,
//            restaurantId: Long
//        )
//
//        fun updatePreorderCart(
//            restaurantId: Long? = null,
//            convertCartOnSuccess: Boolean = false
//        )
//
//        fun convertPreorderCart(advanceOnSuccess: Boolean = false)
//
//        // Call the API to create a new order and set currentOrder to it's value
//        // observe OrderFlowDomain.currentOrder() to be notified when this is complete
//        @Suppress("LongParameterList")
//        fun postOrder(
//            channel: String,
//            restaurantId: Long,
//            fundingSource: PreselectedFundingSource,
//            orderRequest: OrderInitializationDataOrderRequest,
//            deliveryInformation: DeliveryInformation? = null,
//            orderFulfillmentArea: OrderFulfillmentArea
//        )
//
//        fun patchPayment(
//            advanceOnSuccess: Boolean = false
//        )
//
//        fun patchFulfillmentArea(
//            advanceOnSuccess: Boolean = false
//        )
//
//        fun patchReleaseToKitchen(advanceOnSuccess: Boolean = false)
//
//        fun getOrder(id: String)
//
//        fun refreshOrder()
//
//        // Delete an order from our database
//        fun deleteOrderFromRealm(order: Order)
//    }
//
//    // Perform the next action in the flow
    fun advanceOrder()
    fun setState(state:String)
//    fun resetCurrentOrder()
    fun overrideFlow(flow: Flow)
    fun getEnabledFlow(): OrderFlow
//    fun storeArea(): String?
//    fun cartUpdateResult(): CartUpdateResult?
//    fun updateRestaurant(restaurant: Restaurant)
//    fun updateFees(feeChoices: List<OrderRequestCartAdditionalChargeChoices>)
}

const val DEFAULT_CHANNEL = "GMA_PICKUP"
