package com.android.tonyvu.sc.demo.constant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.android.tonyvu.sc.demo.model.Product;

public final class Constant {
    public static final List<Integer> QUANTITY_LIST = new ArrayList<Integer>();

    static {
        for (int i = 1; i < 11; i++) QUANTITY_LIST.add(i);
    }

    public static final Product PRODUCT1 = new Product(1, "Samsung Galaxy S6", BigDecimal.valueOf(199.99), "Worldly looks and top-notch specs make the impressive, metal Samsung Galaxy S6 the Android phone to beat for 2015");
    public static final Product PRODUCT2 = new Product(2, "HTC One M8", BigDecimal.valueOf(449.99), "Excellent overall phone. Beautifull, battery life more than 20 hours daily and great customization in any way. 100% configuration on any aspect");
    public static final Product PRODUCT3 = new Product(3, "Xiaomi Mi3", BigDecimal.valueOf(319.99), "Xiaomi's Mi 3 is a showcase of how Chinese phonemakers can create quality hardware without breaking the bank. If you don't need 4G LTE, and you can get hold of it, this is one of the best smartphones you can buy in its price range.");

    public static final List<Product> PRODUCT_LIST = new ArrayList<Product>();

    static {
        PRODUCT_LIST.add(PRODUCT1);
        PRODUCT_LIST.add(PRODUCT2);
        PRODUCT_LIST.add(PRODUCT3);
    }
}
