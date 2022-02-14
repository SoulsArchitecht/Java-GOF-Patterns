package gof_patterns.Pattern8_Facade.GoodsOrderAndShippingFacade.subcomponents;

import gof_patterns.Pattern8_Facade.GoodsOrderAndShippingFacade.domain.Product;

public class InventoryService {

    public static boolean isAvailable (Product product) {
        /*Check Warehouse database for product availability*/
        return true;
    }
}
