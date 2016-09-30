package com.vtc.controller;

import java.net.HttpURLConnection;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vtc.business.ServiceUtils;
import com.vtc.business.TransactionService;
import com.vtc.dataconstant.DataConstants;
import com.vtc.request.GamePaymentRequest;
import com.vtc.request.OrderIAPRequest;
import com.vtc.request.TransactionDeductVcoinRequest;
import com.vtc.request.TransactionTopupByBankRequest;
import com.vtc.request.TransactionTopupByCardRequest;
import com.vtc.request.TransactionTopupByIAPRequest;
import com.vtc.request.TransactionTopupByVtcPayRequest;
import com.vtc.response.GamePaymentResponseData;
import com.vtc.response.ResponseModel;
import com.vtc.util.PConstants;
import com.vtc.ws.v2.model.transaction.TopupByBankResponseData;
import com.vtc.ws.v2.model.transaction.TopupByCardResponseData;
import com.vtc.ws.v2.model.transaction.TopupByVTCPayResponseData;
import com.vtc.ws.v2.model.transaction.TopupIAPResponseData;
import com.vtc.ws.v2.model.transaction.TransactionOutputResponseData;
import com.vtc.ws.v2.service.BillingService;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
	private static final Logger log = Logger.getLogger(TransactionController.class);

	@Autowired
	private BillingService billingService;

	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private ServiceUtils serviceUtils;
	
	@RequestMapping(value = "/topupcard", method = RequestMethod.POST)
	@ResponseBody
	public ResponseModel topupCard(@RequestBody TransactionTopupByCardRequest request,
			@RequestParam(value = DataConstants.RequestParams.UserName, required = true, defaultValue = "0") String userName,
			@RequestParam(value = DataConstants.RequestParams.AccessToken, required = true, defaultValue = "0") String accessToken) {
		ResponseModel response = new ResponseModel();
		try {
			boolean isValid = serviceUtils.validateToken(userName, accessToken);
			if (!isValid) {
				response.setError(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getValue());
				response.setMessage(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getDisplay());
				return response;
			}
			
			TopupByCardResponseData responseData = transactionService.topupCard(request);
			if (responseData == null || responseData.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
				response.setError(responseData == null ? PConstants.RESPONSE.CODE_ERROR : responseData.getResponseCode());
				response.setInfo(responseData);
				return response;
			}
			response.setError(PConstants.RESPONSE.CODE_SUCCESS);
			response.setInfo(responseData);
		} catch (Exception e) {
			log.error("ERROR", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}

	@RequestMapping(value = "/topupbank", method = RequestMethod.POST)
	@ResponseBody
	public ResponseModel topupBank(@RequestBody TransactionTopupByBankRequest request) {
		log.info(new StringBuffer("[START] TransactionController.topupBank() ")
				.append(", Name: ").append(request.getName())
				.append(", AccountName: ").append(request.getAccountName()));
		long t1 = System.currentTimeMillis();
		ResponseModel response = new ResponseModel();
		try {
			TopupByBankResponseData responseData = transactionService.topupBank(request);
			if (responseData == null || responseData.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
				response.setError(responseData == null ? PConstants.RESPONSE.CODE_ERROR : responseData.getResponseCode());
				response.setInfo(responseData);
				return response;
			}
			
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
			long t2 = System.currentTimeMillis();
			log.info("[END] TransactionController.topupBank() TIME = " + (t2 - t1));
		} catch (Exception e) {
			log.error("ERROR", e);
			response.setError(PConstants.RESPONSE.CODE_ERROR);
			response.setMessage(PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}

	@RequestMapping(value = "/topupvtcpay", method = RequestMethod.POST)
	@ResponseBody
	public ResponseModel topupVtcpay(@RequestBody TransactionTopupByVtcPayRequest request){
		log.info(new StringBuffer("[START] TransactionController.topupVtcpay()")
				.append(", Name: ").append(request.getName()));
		long t1 = System.currentTimeMillis();
		ResponseModel response = new ResponseModel();
		try {
			TopupByVTCPayResponseData responseData = transactionService.topupVtcpay(request);
			if (responseData == null || responseData.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
				response.setError(responseData == null ? PConstants.RESPONSE.CODE_ERROR : responseData.getResponseCode());
				response.setInfo(responseData);
				return response;
			}
			
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
			long t2 = System.currentTimeMillis();
			log.info("[END] checkVTCAccount TIME = " + (t2 - t1));
		} catch (Exception e) {
			log.error("ERROR", e);
			response.setError(PConstants.RESPONSE.CODE_ERROR);
			response.setMessage(PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/topupiap", method = RequestMethod.POST)
	@ResponseBody
	public ResponseModel topupIAP(@RequestBody TransactionTopupByIAPRequest request){
		ResponseModel response = new ResponseModel();
		try{
			TopupIAPResponseData responseData = transactionService.topupIAP(request);
			if (responseData == null || responseData.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
				response.setError(responseData == null ? PConstants.RESPONSE.CODE_ERROR : responseData.getResponseCode());
				response.setInfo(responseData);
				return response;
			}

			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
		} catch(Exception e){
			log.error("[ERROR]", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/deductvcoin", method = RequestMethod.POST)
	@ResponseBody
	public ResponseModel deductVcoin(@RequestBody TransactionDeductVcoinRequest request){
		ResponseModel response = new ResponseModel();
		try{
			TransactionOutputResponseData responseData = transactionService.deductVcoin(request);
			if (responseData == null || responseData.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
				response.setError(responseData == null ? PConstants.RESPONSE.CODE_ERROR : responseData.getResponseCode());
				response.setInfo(responseData);
				return response;
			}

			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
		} catch(Exception e){
			log.error("[ERROR]", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		return response;
	}
	
	/**
	 * @api {POST} /transaction/gamepaymentvcoin?username={username}&access_token={access_token} GamePayment By Vcoin
	 * @apiName GamePaymentByVcoin
	 * @apiGroup Transaction
	 * 
	 * @apiHeader {String} Authorization Bearer + accessToken (ex: Bearer 92afc063-3d63-47a2-9ec2-009eb90e0140)
	 * @apiHeader {String} client_id Mandatory client_id header
	 * 
	 * @apiParam {String} manufacture	Manufacture
	 * @apiParam {String} modelName	Model Name of device
	 * @apiParam {String} operatingSystem	Operating system of device
	 * @apiParam {String} operatingSystemVersion	Version of Operation System
	 * @apiParam {String} utm	utm link
	 * @apiParam {String} clientId	Mandatory  ClientId mapping with server
	 * @apiParam {String} deviceToken		Mandatory Id of device
	 * @apiParam {int} deviceType	Mandatory 1:Web, 2:Mobile
	 * @apiParam {String} fromIp	Mandatory IP of Client
	 * @apiParam {int} accountId Mandatory Id of your account
	 * @apiParam {String} toAccountName Mandatory account is receive
	 * @apiParam {int} authenType Mandatory (0: thường; 1: facebook;2: google; 3: yahoo)
	 * @apiParam {String} packageId Mandatory packageId that you choose
	 * @apiParam {Int} packageType Mandatory type of package (1:Normal, 2:MonthCard) 
	 * @apiParam {String} serverGame Mandatory server name of game
	 * @apiParam {String} extendData Optional data extend from agency 
	 * 
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		{
	 *		  "error": 200,
	 *		  "message": "Success",
	 *		  "info": {
	 *			}
	 *		}
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/gamepaymentvcoin", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel gamePaymentVcoin(
			@RequestBody GamePaymentRequest request, 
			@RequestParam(value = DataConstants.RequestParams.UserName, required = true, defaultValue = "0") String userName,
			@RequestParam(value = DataConstants.RequestParams.AccessToken, required = true, defaultValue = "0") String accessToken
			){
		ResponseModel response = new ResponseModel();
		try{
			boolean isValid = serviceUtils.validateToken(userName, accessToken);
			if (!isValid) {
				return new ResponseModel(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getValue(), DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getDisplay());
			}
			request.setAccountName(userName);
			
			GamePaymentResponseData responseData = transactionService.gamePaymentVcoin(request, accessToken);
			if(responseData == null || responseData.getResponseCode().compareTo(HttpURLConnection.HTTP_INTERNAL_ERROR) == 0 
					||responseData.getResponseCode().compareTo(DataConstants.Zero) <= 0){
				response.setError(responseData == null ? PConstants.RESPONSE.CODE_ERROR : responseData.getResponseCode());
				response.setMessage(responseData == null ? PConstants.RESPONSE.MESS_SYSTEM : responseData.getDescription());
				response.setInfo(responseData);
				return response;
			}
			
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
		} catch(Exception e){
			log.error("[ERROR] ", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM); 
		}
		
		return response;
	}
	
	/**
	 * @api {POST} /transaction/gamepaymentiap?username={username}&access_token={access_token} GamePayment By IAP
	 * @apiName GamePaymentByIAP
	 * @apiGroup Transaction
	 * 
	 * @apiHeader {String} Authorization Bearer + accessToken (ex: Bearer 92afc063-3d63-47a2-9ec2-009eb90e0140)
	 * @apiHeader {String} client_id Mandatory client_id header
	 * 
	 * @apiParam {String} manufacture	Manufacture
	 * @apiParam {String} modelName	Model Name of device
	 * @apiParam {String} operatingSystem	Operating system of device
	 * @apiParam {String} operatingSystemVersion	Version of Operation System
	 * @apiParam {String} utm	utm link
	 * @apiParam {String} clientId	Mandatory  ClientId mapping with server
	 * @apiParam {String} deviceToken		Mandatory Id of device
	 * @apiParam {int} deviceType	Mandatory 1:Web, 2:Mobile
	 * @apiParam {String} fromIp	Mandatory IP of client
	 * @apiParam {int} accountId	Mandatory Id of your account
	 * @apiParam {String} toAccountName Mandatory account is receive
	 * @apiParam {int} authenType Mandatory (0: thường; 1: facebook;2: google; 3: yahoo)
	 * @apiParam {String} typeIAP Mandatory type of In-app purchase (1:Apple, 2:Google)
	 * @apiParam {String} receiptData Mandatory receiptData from Apple or Google
	 * @apiParam {String} relatedTransactionId Mandatory relatedTransactionId from Apple or Google
	 * @apiParam {String} purchaseDate Mandatory purchase date of Apple or Google
	 * @apiParam {String} productId Mandatory productId from Apple or Google
	 * @apiParam {String} packageName Mandatory packageName of Google (not for Apple)
	 * @apiParam {String} serverGame Mandatory server name of game
	 * @apiParam {String} extendData Optional data extend from agency
	 * 
	 * @apiParamExample {json} Request-Example:
	 *		{
	 *		    "manufacture":"iPhone",
	 *		    "modelName":"iPhone6",
	 *		    "operatingSystem":"iOS",
	 *		    "operatingSystemVersion":"8.0",
	 *		    "utm":"democlpt://?utm_source=facebook&utm_campaign=demo&utm_medium=1706",
	 *		    "clientId":"353b302c44574f565045687e534e7d6a",
	 *		    "fromIp":"::1",
	 *		    "accountId":117813858,
	 *		    "deviceToken":"a2f2g2ghwerwer",
	 *		    "deviceType": 1,
	 *		    "billingAccessToken":"636063372483530000.6c5dd72164000dac2402b07abc76ba34",
	 *		    "toAccountName":"vtctest90",
	 *		    "receiptData":"diikjfkhipdopfgpffllgogp.AO-J1OwpXv0nziEvi7ucOBkRT_WLbdVrN8ObG1UVfXeNzH2kIoyc4AnT5eBDlOHuY2ZQD1p77JlbguopWaLejPz_a5Gdi_WfFsHkABC2DedPOy1NDclYazd1X2YAg62FbPr_5WZ5z5JH",
	 *		    "relatedTransactionId":"test",
	 *		    "typeIAP": 2,
	 *		    "purchaseDate":"1470708821922",
	 *		    "productId":"com.vtc.sdk",
	 *		    "packageName":"com.strategy.intecom.vtc.vtclib"
	 *		}
	 * 
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		{
	 *		  "error": 200,
	 *		  "message": "Success",
	 *		  "info": {
	 *			}
	 *		}
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/gamepaymentiap", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel gamePaymentIAP(
			@RequestBody GamePaymentRequest request, 
			@RequestParam(value = DataConstants.RequestParams.UserName, required = true, defaultValue = "0") String userName,
			@RequestParam(value = DataConstants.RequestParams.AccessToken, required = true, defaultValue = "0") String accessToken
			){
		ResponseModel response = new ResponseModel();
		try{
			boolean isValid = serviceUtils.validateToken(userName, accessToken);
			if (!isValid) {
				return new ResponseModel(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getValue(), DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getDisplay());
			}
			request.setAccountName(userName);
			
			GamePaymentResponseData responseData = transactionService.gamePaymentIAP(request, accessToken);
			if(responseData == null || responseData.getResponseCode().compareTo(HttpURLConnection.HTTP_INTERNAL_ERROR) == 0 
					||responseData.getResponseCode().compareTo(DataConstants.Zero) <= 0){
				response.setError(responseData == null ? PConstants.RESPONSE.CODE_ERROR : responseData.getResponseCode());
				response.setMessage(responseData == null ? PConstants.RESPONSE.MESS_SYSTEM : responseData.getDescription());
				response.setInfo(responseData);
				return response;
			}
			
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
		} catch(Exception e){
			log.error("[ERROR] ", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM); 
		}
		
		return response;
	}
	
	/**
	 * @api {POST} /transaction/gamepaymentbank?username={username}&access_token={access_token} GamePayment by BANK
	 * @apiName GamePaymentByBank
	 * @apiGroup Transaction
	 * 
	 * @apiHeader {String} Authorization Bearer + accessToken (ex: Bearer 92afc063-3d63-47a2-9ec2-009eb90e0140)
	 * @apiHeader {String} client_id Mandatory client_id header
	 * 
	 * @apiParam {String} manufacture	Manufacture
	 * @apiParam {String} modelName	Model Name of device
	 * @apiParam {String} operatingSystem	Operating system of device
	 * @apiParam {String} operatingSystemVersion	Version of Operation System
	 * @apiParam {String} utm	utm link
	 * @apiParam {String} clientId	Mandatory  ClientId mapping with server
     * @apiParam {int} accountId Mandatory Id of account
	 * @apiParam {String} deviceToken		Mandatory Id of device
	 * @apiParam {int} deviceType	Mandatory 1:Web, 2:Mobile
	 * @apiParam {String} fromIp	Mandatory clientIp
	 * @apiParam {String} toAccountName Mandatory account is receive
	 * @apiParam {int} authenType Mandatory (0: thường; 1: facebook;2: google; 3: yahoo)
	 * @apiParam {String} packageId Mandatory id of package
	 * @apiParam {Int} packageType Mandatory type of package (1:Normal, 2:MonthCard)
	 * @apiParam {String} bankCode Mandatory code of bank
	 * @apiParam {String} serverGame Mandatory server name of game
	 * @apiParam {String} extendData Optional data extend from agency
	 *  
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		{
	 *		  "error": 200,
	 *		  "message": "Success",
	 *		  "info": {
	 *			}
	 *		}
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/gamepaymentbank", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel gamePaymentBank(
			@RequestBody GamePaymentRequest request, 
			@RequestParam(value = DataConstants.RequestParams.UserName, required = true, defaultValue = "0") String userName,
			@RequestParam(value = DataConstants.RequestParams.AccessToken, required = true, defaultValue = "0") String accessToken
			){
		ResponseModel response = new ResponseModel();
		try{
			boolean isValid = serviceUtils.validateToken(userName, accessToken);
			if (!isValid) {
				return new ResponseModel(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getValue(), DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getDisplay());
			}
			request.setAccountName(userName);
			
			GamePaymentResponseData responseData = transactionService.gamePaymentBank(request, accessToken);
			if(responseData == null || responseData.getResponseCode().compareTo(HttpURLConnection.HTTP_INTERNAL_ERROR) == 0 
					||responseData.getResponseCode().compareTo(DataConstants.Zero) <= 0){
				response.setError(responseData == null ? PConstants.RESPONSE.CODE_ERROR : responseData.getResponseCode());
				response.setMessage(responseData == null ? PConstants.RESPONSE.MESS_SYSTEM : responseData.getDescription());
				response.setInfo(responseData);
				return response;
			}
			
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
		} catch(Exception e){
			log.error("[ERROR] ", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM); 
		}
		
		return response;
	}
	
	/**
	 * @api {POST} /transaction/gamepaymentvtcpay?username={username}&access_token={access_token} GamePayment by VTCPay
	 * @apiName GamePaymentByVTCPay
	 * @apiGroup Transaction
	 * 
	 * @apiHeader {String} Authorization Bearer + accessToken (ex: Bearer 92afc063-3d63-47a2-9ec2-009eb90e0140)
	 * @apiHeader {String} client_id Mandatory client_id header
	 * 
	 * @apiParam {String} manufacture	Manufacture
	 * @apiParam {String} modelName	Model Name of device
	 * @apiParam {String} operatingSystem	Operating system of device
	 * @apiParam {String} operatingSystemVersion	Version of Operation System
	 * @apiParam {String} utm	utm link
	 * @apiParam {String} clientId	Mandatory  ClientId mapping with server
     * @apiParam {int} accountId Mandatory Id of account
	 * @apiParam {String} deviceToken		Mandatory Id of device
	 * @apiParam {int} deviceType	Mandatory 1:Web, 2:Mobile
	 * @apiParam {String} fromIp	Mandatory clientIp
	 * @apiParam {String} toAccountName Mandatory account is receive
	 * @apiParam {int} authenType Mandatory (0: thường; 1: facebook;2: google; 3: yahoo)
	 * @apiParam {String} packageId Mandatory id of package
	 * @apiParam {Int} packageType Mandatory type of package (1:Normal, 2:MonthCard) 
	 * @apiParam {String} vtcPayAccount Mandatory account vtc pay
	 * @apiParam {String} serverGame Mandatory server name of game
	 * @apiParam {String} extendData Optional data extend from agency 
	 *  
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		{
	 *		  "error": 200,
	 *		  "message": "Success",
	 *		  "info": {
	 *			}
	 *		}
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/gamepaymentvtcpay", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel gamePaymentVtcPay(
			@RequestBody GamePaymentRequest request, 
			@RequestParam(value = DataConstants.RequestParams.UserName, required = true, defaultValue = "0") String userName,
			@RequestParam(value = DataConstants.RequestParams.AccessToken, required = true, defaultValue = "0") String accessToken
			){
		ResponseModel response = new ResponseModel();
		try{
			boolean isValid = serviceUtils.validateToken(userName, accessToken);
			if (!isValid) {
				return new ResponseModel(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getValue(), DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getDisplay());
			}
			request.setAccountName(userName);
			
			GamePaymentResponseData responseData = transactionService.gamePaymentVtcPay(request, accessToken);
			if(responseData == null || responseData.getResponseCode().compareTo(HttpURLConnection.HTTP_INTERNAL_ERROR) == 0 
					||responseData.getResponseCode().compareTo(DataConstants.Zero) <= 0){
				response.setError(responseData == null ? PConstants.RESPONSE.CODE_ERROR : responseData.getResponseCode());
				response.setMessage(responseData == null ? PConstants.RESPONSE.MESS_SYSTEM : responseData.getDescription());
				response.setInfo(responseData);
				return response;
			}
			
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
		} catch(Exception e){
			log.error("[ERROR] ", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM); 
		}
		
		return response;
	}
	
	/**
	 * @api {POST} /transaction/gamepaymentcard?username={username}&access_token={access_token} GamePayment by Card
	 * @apiName GamePaymentByCard
	 * @apiGroup Transaction
	 * 
	 * @apiHeader {String} Authorization Bearer + accessToken (ex: Bearer 92afc063-3d63-47a2-9ec2-009eb90e0140)
	 * @apiHeader {String} client_id Mandatory client_id header
	 * 
	 * @apiParam {String} manufacture	Manufacture
	 * @apiParam {String} modelName	Model Name of device
	 * @apiParam {String} operatingSystem	Operating system of device
	 * @apiParam {String} operatingSystemVersion	Version of Operation System
	 * @apiParam {String} utm	utm link
	 * @apiParam {String} clientId	Mandatory  ClientId mapping with server
     * @apiParam {int} accountId Mandatory Id of account
	 * @apiParam {String} deviceToken		Mandatory Id of device
	 * @apiParam {int} deviceType	Mandatory 1:Web, 2:Mobile
	 * @apiParam {String} fromIp	Mandatory clientIp
	 * @apiParam {String} toAccountName Mandatory account is receive
	 * @apiParam {String} paymentType Mandatory (CARDGPC: the VinaPhone, CARDVMS: the MobiFone, CARDVTEL: the Viettel, CARDVNM : the VietnamMobile, CARDVCOIN: the Vcoin) 
	 * @apiParam {String} cardSerial Mandatory serial of card
	 * @apiParam {String} cardCode Mandatory code of card
	 * @apiParam {int} authenType Mandatory (0: thường; 1: facebook;2: google; 3: yahoo)
	 * @apiParam {String} packageId Mandatory id of package
	 * @apiParam {Int} packageType Mandatory type of package (1:Normal, 2:MonthCard) 
	 * @apiParam {String} serverGame Mandatory server name of game
	 * @apiParam {String} extendData Optional data extend from agency 
	 *  
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		{
	 *		  "error": 200,
	 *		  "message": "Success",
	 *		  "info": {
	 *			}
	 *		}
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/gamepaymentcard", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel gamePaymentCard(
			@RequestBody GamePaymentRequest request, 
			@RequestParam(value = DataConstants.RequestParams.UserName, required = true, defaultValue = "0") String userName,
			@RequestParam(value = DataConstants.RequestParams.AccessToken, required = true, defaultValue = "0") String accessToken
			){
		ResponseModel response = new ResponseModel();
		try{
			boolean isValid = serviceUtils.validateToken(userName, accessToken);
			if (!isValid) {
				return new ResponseModel(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getValue(), DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getDisplay());
			}
			request.setAccountName(userName);
			
			GamePaymentResponseData responseData = transactionService.gamePaymentCard(request, accessToken);
			if(responseData == null || responseData.getResponseCode().compareTo(HttpURLConnection.HTTP_INTERNAL_ERROR) == 0 
					||responseData.getResponseCode().compareTo(DataConstants.Zero) <= 0){
				response.setError(responseData == null ? PConstants.RESPONSE.CODE_ERROR : responseData.getResponseCode());
				response.setMessage(responseData == null ? PConstants.RESPONSE.MESS_SYSTEM : responseData.getDescription());
				response.setInfo(responseData);
				return response;
			}
			
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
		} catch(Exception e){
			log.error("[ERROR] ", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM); 
		}
		
		return response;
	}
	
	/**
	 * @api {POST} /transaction/createorderpayment?username={username}&access_token={access_token} Create Order Transaction
	 * @apiName CreateOrder
	 * @apiGroup Transaction
	 * 
	 * @apiHeader {String} Authorization Bearer + accessToken (ex: Bearer 92afc063-3d63-47a2-9ec2-009eb90e0140)
	 * @apiHeader {String} client_id Mandatory client_id header
	 * 
	 * @apiParam {String} manufacture	Manufacture
	 * @apiParam {String} modelName	Model Name of device
	 * @apiParam {String} operatingSystem	Operating system of device
	 * @apiParam {String} operatingSystemVersion	Version of Operation System
	 * @apiParam {String} utm	utm link
	 * @apiParam {String} clientId	Mandatory  ClientId mapping with server
	 * @apiParam {String} deviceToken		Mandatory Id of device
	 * @apiParam {int} deviceType	Mandatory 1:Web, 2:Mobile
	 * @apiParam {int} accountId	Mandatory id of account
	 * @apiParam {String} packageId	Mandatory package create order
	 * @apiParam {String} clientIp	Mandatory clientIp
	 * @apiParam {int} authenType Mandatory (0: thường; 1: facebook;2: google; 3: yahoo)
	 * 
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		{
	 *		  "error": 200,
	 *		  "message": "Success",
	 *		  "info": "OrderNo-a1f2d4d4e3e3rrfkr0wkld"
	 *		}
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/createorderpayment", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel initOrder(
			@RequestBody OrderIAPRequest request,
			@RequestParam(value = DataConstants.RequestParams.UserName, required = true, defaultValue = "0") String userName,
			@RequestParam(value = DataConstants.RequestParams.AccessToken, required = true, defaultValue = "0") String accessToken
			){
		ResponseModel response = new ResponseModel();
		try {
			boolean isValid = serviceUtils.validateToken(userName, accessToken);
			if (!isValid) {
				return new ResponseModel(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getValue(), DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getDisplay());
			}
			request.setAccountName(userName);
			
			String orderNo = transactionService.initOrder(request, accessToken);
			if(StringUtils.isEmpty(orderNo)){
				return new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
			}
			
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, orderNo);
		} catch (Exception e) {
			log.error("[ERROR]", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}

	public BillingService getBillingService() {
		return billingService;
	}

	public void setBillingService(BillingService billingService) {
		this.billingService = billingService;
	}

	public TransactionService getTransactionService() {
		return transactionService;
	}

	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

}
