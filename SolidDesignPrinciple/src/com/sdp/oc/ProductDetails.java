package com.sdp.oc;

import java.math.BigDecimal;
import java.util.Date;

public interface ProductDetails {
	public Date getProductExpiry();

	public BigDecimal getProductPrice();
}