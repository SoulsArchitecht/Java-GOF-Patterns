package gof_patterns.Pattern8_Facade.GoodsOrderAndShippingFacade.controller;


import gof_patterns.Pattern8_Facade.GoodsOrderAndShippingFacade.servicefacade.OrderServiceFacadeImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderFulfillmentControllerTest {

    @Test
    public void testOrderProduct() throws  Exception {
        OrderFulfillmentController controller = new OrderFulfillmentController();
        controller.orderServiceFacade = new OrderServiceFacadeImpl();
        controller.orderProduct(7);
        boolean result = controller.orderFulfilled;
        assertTrue(result);
    }
}
