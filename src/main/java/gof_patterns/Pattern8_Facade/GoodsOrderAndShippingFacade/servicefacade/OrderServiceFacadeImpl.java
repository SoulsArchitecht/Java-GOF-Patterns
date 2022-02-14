package gof_patterns.Pattern8_Facade.GoodsOrderAndShippingFacade.servicefacade;

import gof_patterns.Pattern8_Facade.GoodsOrderAndShippingFacade.domain.Product;
import gof_patterns.Pattern8_Facade.GoodsOrderAndShippingFacade.subcomponents.InventoryService;
import gof_patterns.Pattern8_Facade.GoodsOrderAndShippingFacade.subcomponents.ShippingService;

public class OrderServiceFacadeImpl implements OrderServiceFacade {

    @Override
    public boolean placeOrder(int productId) {
        boolean orderFulfilled = false;
        Product product = new Product();
        product.productId = productId;
        if (InventoryService.isAvailable(product)) {
            System.out.println("Product with ID: " + product.productId + " is available.");
            ShippingService.shipProduct(product);
            System.out.println("Product shipped...");
            orderFulfilled = true;

        }
        return orderFulfilled;
    }
}