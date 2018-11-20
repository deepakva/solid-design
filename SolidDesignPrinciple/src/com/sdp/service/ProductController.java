package com.sdp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class ProductController {

	private final String sharedKey = "SHARED_KEY";

	private static final String SUCCESS_STATUS = "success";
	private static final String ERROR_STATUS = "error";
	private static final int CODE_SUCCESS = 100;
	private static final int AUTH_FAILURE = 102;

	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public PurchaseResponse pay(@RequestParam(value = "key") String key, @RequestBody PurchaseRequest request) {

		PurchaseResponse response = new PurchaseResponse();
		if (sharedKey.equalsIgnoreCase(key)) {
			int userId = request.getUserId();
			String itemId = request.getItemId();
			double discount = request.getDiscount();

			// Process the request
			// ....
			// Return success response to the client.

			response.setStatus(SUCCESS_STATUS);
			response.setCode(CODE_SUCCESS);
		} else {
			response.setStatus(ERROR_STATUS);
			response.setCode(AUTH_FAILURE);
		}
		return response;
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public List<String> getAvailableProducts(){
		List<String> availablePrds = new ArrayList<>();
		availablePrds.add("7PAP");
		availablePrds.add("UPMM");
		return availablePrds;
	}
}