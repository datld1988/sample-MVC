package com.vtc.serviceproxy;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import com.vtc.request.GamePaymentRequest;
import com.vtc.response.GamePaymentResponseData;

public interface GamePaymentService {
	GamePaymentResponseData transactionPayment(GamePaymentRequest request) throws IOException, NoSuchAlgorithmException;
}
