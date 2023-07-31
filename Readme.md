**This Code have example of showing how Observer should be listening to the changing states and trigger the underlying functions**

Main functions in this code
---
###postOrder 

**making the backend api call**

    - response will call OnSuccess DeliveryFlowObserver - trigger advanceOrder

###advanceOrder -

*transitioning from one state to another*

    - check the state
        - call the Callback function on DeliveryFlow  like onSubmittablePendingPayment, OnSubmittable ....

###DeliveryVM 
>
    - onSubmittablePendingPayment - call patch payment api  
        - update the state of OrderFlowDomain.OrderFlowState
            - trigger the DeliveryFlowObserver.OnSuccess

    - OnSubmittable
        - call Order Summary
             -- update the state of OrderFlowDomain.OrderFlowState
                -- trigger the DeliveryFlowObserver.OnSuccess

###DeliveryFlowObserver
>
    - OnSuccess
        -- advanceOrder
            --jump to advanceOrder function above for state transition
