package com.android.tonyvu.sc.exception;

/**
 * Throw this exception to indicate invalid operation on product which does not belong to a shopping cart
 */
public class ProductNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 43L;

    private static final String DEFAULT_MESSAGE = "Product is not found in the shopping cart.";

    public ProductNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
