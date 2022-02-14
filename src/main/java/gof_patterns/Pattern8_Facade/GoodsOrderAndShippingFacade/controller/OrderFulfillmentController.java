package gof_patterns.Pattern8_Facade.GoodsOrderAndShippingFacade.controller;

import gof_patterns.Pattern8_Facade.GoodsOrderAndShippingFacade.servicefacade.OrderServiceFacade;

public class OrderFulfillmentController {
    OrderServiceFacade orderServiceFacade;
    boolean orderFulfilled = false;

    public void orderProduct(int productId) {
        orderFulfilled = orderServiceFacade.placeOrder(productId);
        System.out.println("OrderFulfillmentController: Order fulfillment completed. ");
    }
}
