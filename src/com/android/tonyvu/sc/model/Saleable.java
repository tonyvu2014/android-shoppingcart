package com.android.tonyvu.sc.model;

import java.math.BigDecimal;

/**
 * Implements this interface for any product which can be added to shopping cart
 * 
 * The product class must also override {@code equals()} and {@code hashCode()} methods 
 *
 */
public interface Saleable {
	
	public BigDecimal getPrice();
	
	public String getName();
}
