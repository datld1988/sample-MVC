package com.vtc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.api.services.analyticsreporting.v4.model.GetReportsResponse;
import com.vtc.business.ReportingGaService;
import com.vtc.model.CMSFilterDataModel;
import com.vtc.request.CmsQueryRequest;
import com.vtc.response.CmsQueryResponse;
import com.vtc.response.ResponseModel;
import com.vtc.util.DateUtil;
import com.vtc.util.PConstants;

@Controller
@RequestMapping("/report")
public class ReportingController {
	private static Logger log = Logger.getLogger(ReportingController.class);
	
	@Autowired
	private ReportingGaService reportingGaService;
	
	@RequestMapping(value={"/getfilterdata/{gaTrackingId}/{gaClientId}"}, method=RequestMethod.GET)
	@ResponseBody
	public ResponseModel getFilterData(
			@PathVariable String gaTrackingId,
			@PathVariable String gaClientId){
		ResponseModel response = new ResponseModel();
		
		try{
			CMSFilterDataModel responseData = reportingGaService.getFilterData(gaTrackingId, gaClientId);
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
		}catch(Exception e){
			log.error("ERROR", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	@RequestMapping(value={"/campaigns/{viewId}", 
							"/campaigns/{viewId}/{fromDate}", 
							"/campaigns/{viewId}/{fromDate}/{toDate}", 
							"/campaigns/{viewId}/{fromDate}/{toDate}/{searchStr}"}, method=RequestMethod.GET)
	@ResponseBody
	public ResponseModel getReportCampaign(@PathVariable String viewId, 
										   @PathVariable Optional<String> fromDate,
										   @PathVariable Optional<String> toDate,
										   @PathVariable Optional<String> searchStr){
		long t1 = System.currentTimeMillis();
		log.info(new StringBuffer("[START] ReportingController.GetReportCampaign(). ")
				.append(" ViewID: ").append(viewId)
				.append(", FromDate: ").append(fromDate)
				.append(", ToDate: ").append(toDate)
				.append(", SearchStr: ").append(searchStr));
		ResponseModel response = new ResponseModel();
		try {
			GetReportsResponse result = reportingGaService.reportCampaign(viewId, 
									fromDate.isPresent() ? fromDate.get() : "", 
									toDate.isPresent() ? toDate.get() : "", 
									searchStr.isPresent() ? Arrays.asList(searchStr.get()) : null);
			response.setError(PConstants.RESPONSE.CODE_SUCCESS);
			response.setInfo(result);
			response.setMessage(PConstants.RESPONSE.MESS_SUCCESS);
//			long t2 = System.currentTimeMillis();
//			log.info(new StringBuffer("[END] ReportingController.GetReportCampaign() is successfully. TOTAL TIME: ").append(String.valueOf(t2 - t1))
//					.toString());
			
		} catch (IOException e) {
			response.setError(PConstants.RESPONSE.CODE_ERROR);
			response.setInfo(PConstants.RESPONSE.MESS_SYSTEM);
			log.error("ERROR", e);
			long t2 = System.currentTimeMillis();
			log.error(new StringBuffer("[END]AppActivityController.AppActivity(). TOTAL TIME: ").append(String.valueOf(t2 - t1))
					.toString());
		}
		
		return response;
	}



	/**
	 * Get report info by operation system (Android or IOS)
	 * 
	 * @param osType
	 * @param dateFrom
	 * @param dateTo
	 * @return report info
	 */
	@RequestMapping(value = "/device", method = RequestMethod.GET)
	@ResponseBody
	public ResponseModel getReportByOS(
			@RequestParam(value = "view_id", required = true, defaultValue = "") String viewId,
			@RequestParam(value = "from", required = true, defaultValue = "") String dateFrom,
			@RequestParam(value = "to", required = true, defaultValue = "") String dateTo) {

		// Log message end process
		String messageEndProcess = "[END] getReportByOS. TOTAL TIME: ";

		// Get start time
		long startTime = System.currentTimeMillis();
		// End time
		long endTime;
		// Get log when start get track info of monitor
		log.info(new StringBuffer("[START] getReportByOS. ")
				.append(". view_id:").append(viewId)
				.append(". from:").append(dateFrom)
				.append(". to:").append(dateTo).toString());
		try {
			// Log message
			String errorMessage = null;

			// Validate parameters
			// Check empty for viewId
			if(StringUtils.isEmpty(viewId)) {
				errorMessage = "viewId is empty";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			// Check empty for date from
			if (StringUtils.isEmpty(dateFrom)) {
				errorMessage = "dateFrom is empty";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			// Check empty for date from
			if (StringUtils.isEmpty(dateTo)) {
				errorMessage = "dateTo is empty";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			// Check format of dateFrom, date to
			if (!validateDateFormat(dateFrom, DateUtil.PATTERN_YYYYMMDD_HYPHEN)) {
				errorMessage = "dateFrom's format is incorrect";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			if (!validateDateFormat(dateTo, DateUtil.PATTERN_YYYYMMDD_HYPHEN)) {
				errorMessage = "dateTo's format is incorrect";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}

			// Set info to get report;
			GetReportsResponse result =
					reportingGaService.reportByDevice(viewId, dateFrom, dateTo);

			// Response info when update info success
			ResponseModel response = new ResponseModel();
			response.setError(PConstants.RESPONSE.CODE_SUCCESS);
			response.setMessage(PConstants.RESPONSE.MESS_SUCCESS);
			response.setInfo(result);
			endTime = System.currentTimeMillis();
			log.info(new StringBuffer(messageEndProcess).append(
					String.valueOf(endTime - startTime)).toString());
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			ResponseModel response = new ResponseModel();
			response.setError(PConstants.RESPONSE.CODE_ERROR);
			response.setMessage(PConstants.RESPONSE.MESS_SYSTEM);
			endTime = System.currentTimeMillis();
			log.error("ERROR", e);
			log.error(new StringBuffer(messageEndProcess).append(
					String.valueOf(endTime - startTime)).toString());
			return response;
		}
	}

	/**
	 * Get report by marketing
	 * @param viewId
	 * @param dateFrom
	 * @param dateTo
	 * @param marketingType
	 * @param eventCategory
	 * @param eventAction
	 * @return Response object
	 */
	@RequestMapping(value = "/marketing", method = RequestMethod.GET)
	@ResponseBody
	public ResponseModel getMarketingReport(
			@RequestParam(value = "view_id", required = true, defaultValue = "") String viewId,
			@RequestParam(value = "from", required = true, defaultValue = "") String dateFrom,
			@RequestParam(value = "to", required = true, defaultValue = "") String dateTo,
			@RequestParam(value = "marketing_type", required = true, defaultValue = "") Integer marketingType
			) {
		// Log message end process
		String messageEndProcess = "[END] getMarketingReport. TOTAL TIME: ";
		// Get start time
		long startTime = System.currentTimeMillis();
		// End time
		long endTime;
		// Get log when start get track info of monitor
		log.info(new StringBuffer("[START] getMarketingReport. ")
				.append(". view_id:").append(viewId)
				.append(". from:").append(dateFrom)
				.append(". to:").append(dateTo)
				.append(". marketing_type:").append(marketingType).toString());
		try {
			// Log message
			String errorMessage = null;
			// Validate parameters
			// Check empty for viewId
			if(StringUtils.isEmpty(viewId)) {
				errorMessage = "viewId is empty";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			// Check empty for date from
			if (StringUtils.isEmpty(dateFrom)) {
				errorMessage = "dateFrom is empty";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			// Check empty for date from
			if (StringUtils.isEmpty(dateTo)) {
				errorMessage = "dateTo is empty";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			// Check format of dateFrom, date to
			if (!validateDateFormat(dateFrom, DateUtil.PATTERN_YYYYMMDD_HYPHEN)) {
				errorMessage = "dateFrom's format is incorrect";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			if (!validateDateFormat(dateTo, DateUtil.PATTERN_YYYYMMDD_HYPHEN)) {
				errorMessage = "dateTo's format is incorrect";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			// Check null for marketingType
			if(marketingType == null) {
				errorMessage = "marketingType is null";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}

			// Set info to get report;
			GetReportsResponse result =
							reportingGaService.getMarketingReport(viewId, dateFrom, dateTo, marketingType);

			// Response info when update info success
			ResponseModel response = new ResponseModel();
			response.setError(PConstants.RESPONSE.CODE_SUCCESS);
			response.setMessage(PConstants.RESPONSE.MESS_SUCCESS);
			response.setInfo(result);
			endTime = System.currentTimeMillis();
			log.info(new StringBuffer(messageEndProcess).append(
					String.valueOf(endTime - startTime)).toString());
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			ResponseModel response = new ResponseModel();
			response.setError(PConstants.RESPONSE.CODE_ERROR);
			response.setMessage(PConstants.RESPONSE.MESS_SYSTEM);
			endTime = System.currentTimeMillis();
			log.error("ERROR", e);
			log.error(new StringBuffer(messageEndProcess).append(
					String.valueOf(endTime - startTime)).toString());
			return response;
		}
	}

	/**
	 * Get active user report
	 * @param viewId
	 * @param dateFrom
	 * @param dateTo
	 * @return active user info
	 */
	@RequestMapping(value = "/activeUser", method = RequestMethod.GET)
	@ResponseBody
	public ResponseModel getActiveUserReport(
			@RequestParam(value = "view_id", required = true, defaultValue = "") String viewId,
			@RequestParam(value = "from", required = true, defaultValue = "") String dateFrom,
			@RequestParam(value = "to", required = true, defaultValue = "") String dateTo
			) {
		// Log message end process
		String messageEndProcess = "[END] getActiveUserReport. TOTAL TIME: ";
		// Get start time
		long startTime = System.currentTimeMillis();
		// End time
		long endTime;
		// Get log when start get track info of monitor
		log.info(new StringBuffer("[START] getActiveUserReport. ")
				.append(". view_id:").append(viewId)
				.append(". from:").append(dateFrom)
				.append(". to:").append(dateTo).toString());
		try {
			// Log message
			String errorMessage = null;
			// Validate parameters
			// Check empty for viewId
			if(StringUtils.isEmpty(viewId)) {
				errorMessage = "viewId is empty";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			// Check empty for date from
			if (StringUtils.isEmpty(dateFrom)) {
				errorMessage = "dateFrom is empty";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			// Check empty for date from
			if (StringUtils.isEmpty(dateTo)) {
				errorMessage = "dateTo is empty";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			// Check format of dateFrom, date to
			if (!validateDateFormat(dateFrom, DateUtil.PATTERN_YYYYMMDD_HYPHEN)) {
				errorMessage = "dateFrom's format is incorrect";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			if (!validateDateFormat(dateTo, DateUtil.PATTERN_YYYYMMDD_HYPHEN)) {
				errorMessage = "dateTo's format is incorrect";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}

			// Set info to get report;
			GetReportsResponse result =
							reportingGaService.getActiveUserReport(viewId, dateFrom, dateTo);

			// Response info when update info success
			ResponseModel response = new ResponseModel();
			response.setError(PConstants.RESPONSE.CODE_SUCCESS);
			response.setMessage(PConstants.RESPONSE.MESS_SUCCESS);
			response.setInfo(result);
			endTime = System.currentTimeMillis();
			log.info(new StringBuffer(messageEndProcess).append(
					String.valueOf(endTime - startTime)).toString());
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			ResponseModel response = new ResponseModel();
			response.setError(PConstants.RESPONSE.CODE_ERROR);
			response.setMessage(PConstants.RESPONSE.MESS_SYSTEM);
			endTime = System.currentTimeMillis();
			log.error("ERROR", e);
			log.error(new StringBuffer(messageEndProcess).append(
					String.valueOf(endTime - startTime)).toString());
			return response;
		}
	}

	/**
	 * Get report by UTM
	 * @param viewId
	 * @param dateFrom
	 * @param dateTo
	 * @return Response object
	 */
	@RequestMapping(value = "/utm", method = RequestMethod.GET)
	@ResponseBody
	public ResponseModel getUTMReport(
			@RequestParam(value = "view_id", required = true, defaultValue = "") String viewId,
			@RequestParam(value = "from", required = true, defaultValue = "") String dateFrom,
			@RequestParam(value = "to", required = true, defaultValue = "") String dateTo,
			@RequestParam(value = "utm_type", required = true, defaultValue = "") Integer utmType
			) {
		// Log message end process
		String messageEndProcess = "[END] getUTMReport. TOTAL TIME: ";
		// Get start time
		long startTime = System.currentTimeMillis();
		// End time
		long endTime;
		// Get log when start get track info of monitor
		log.info(new StringBuffer("[START] getUTMReport. ")
				.append(". view_id:").append(viewId)
				.append(". from:").append(dateFrom)
				.append(". to:").append(dateTo)
				.append(". utm_type:").append(utmType).toString());
		try {
			// Log message
			String errorMessage = null;
			// Validate parameters
			// Check empty for viewId
			if(StringUtils.isEmpty(viewId)) {
				errorMessage = "viewId is empty";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			// Check empty for date from
			if (StringUtils.isEmpty(dateFrom)) {
				errorMessage = "dateFrom is empty";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			// Check empty for date from
			if (StringUtils.isEmpty(dateTo)) {
				errorMessage = "dateTo is empty";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			// Check format of dateFrom, date to
			if (!validateDateFormat(dateFrom, DateUtil.PATTERN_YYYYMMDD_HYPHEN)) {
				errorMessage = "dateFrom's format is incorrect";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			if (!validateDateFormat(dateTo, DateUtil.PATTERN_YYYYMMDD_HYPHEN)) {
				errorMessage = "dateTo's format is incorrect";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			// Check null for UTM type
			if(utmType == null) {
				errorMessage = "utmType is null";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}

			// Set info to get report;
			GetReportsResponse result =
							reportingGaService.getUTMReport(viewId, dateFrom, dateTo, utmType);

			// Response info when update info success
			ResponseModel response = new ResponseModel();
			response.setError(PConstants.RESPONSE.CODE_SUCCESS);
			response.setMessage(PConstants.RESPONSE.MESS_SUCCESS);
			response.setInfo(result);
			endTime = System.currentTimeMillis();
			log.info(new StringBuffer(messageEndProcess).append(
					String.valueOf(endTime - startTime)).toString());
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			ResponseModel response = new ResponseModel();
			response.setError(PConstants.RESPONSE.CODE_ERROR);
			response.setMessage(PConstants.RESPONSE.MESS_SYSTEM);
			endTime = System.currentTimeMillis();
			log.error("ERROR", e);
			log.error(new StringBuffer(messageEndProcess).append(
					String.valueOf(endTime - startTime)).toString());
			return response;
		}
	}

	/**
	 * Get report by Event
	 * @param viewId
	 * @param dateFrom
	 * @param dateTo
	 * @param eventType
	 * @return Response object
	 */
	@RequestMapping(value = "/event", method = RequestMethod.GET)
	@ResponseBody
	public ResponseModel getEventReport(
			@RequestParam(value = "view_id", required = true, defaultValue = "") String viewId,
			@RequestParam(value = "from", required = true, defaultValue = "") String dateFrom,
			@RequestParam(value = "to", required = true, defaultValue = "") String dateTo,
			@RequestParam(value = "event_type", required = true, defaultValue = "") Integer eventType
			) {
		// Log message end process
		String messageEndProcess = "[END] getUTMReport. TOTAL TIME: ";
		// Get start time
		long startTime = System.currentTimeMillis();
		// End time
		long endTime;
		// Get log when start get track info of monitor
		log.info(new StringBuffer("[START] getUTMReport. ")
				.append(". view_id:").append(viewId)
				.append(". from:").append(dateFrom)
				.append(". to:").append(dateTo)
				.append(". event_type:").append(eventType).toString());
		try {
			// Log message
			String errorMessage = null;
			// Validate parameters
			// Check empty for viewId
			if(StringUtils.isEmpty(viewId)) {
				errorMessage = "viewId is empty";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			// Check empty for date from
			if (StringUtils.isEmpty(dateFrom)) {
				errorMessage = "dateFrom is empty";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			// Check empty for date from
			if (StringUtils.isEmpty(dateTo)) {
				errorMessage = "dateTo is empty";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			// Check format of dateFrom, date to
			if (!validateDateFormat(dateFrom, DateUtil.PATTERN_YYYYMMDD_HYPHEN)) {
				errorMessage = "dateFrom's format is incorrect";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			if (!validateDateFormat(dateTo, DateUtil.PATTERN_YYYYMMDD_HYPHEN)) {
				errorMessage = "dateTo's format is incorrect";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			// Check null for UTM type
			if(eventType == null) {
				errorMessage = "utmType is null";
				ResponseModel response = setResponseAndLogInfo(startTime,
						errorMessage, messageEndProcess);
				return response;
			}
			
			// Set info to get report;
			GetReportsResponse result =
							reportingGaService.getEventReport(viewId, dateFrom, dateTo, eventType);

			// Response info when update info success
			ResponseModel response = new ResponseModel();
			response.setError(PConstants.RESPONSE.CODE_SUCCESS);
			response.setMessage(PConstants.RESPONSE.MESS_SUCCESS);
			response.setInfo(result);
			endTime = System.currentTimeMillis();
			log.info(new StringBuffer(messageEndProcess).append(
					String.valueOf(endTime - startTime)).toString());
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			ResponseModel response = new ResponseModel();
			response.setError(PConstants.RESPONSE.CODE_ERROR);
			response.setMessage(PConstants.RESPONSE.MESS_SYSTEM);
			endTime = System.currentTimeMillis();
			log.error("ERROR", e);
			log.error(new StringBuffer(messageEndProcess).append(
					String.valueOf(endTime - startTime)).toString());
			return response;
		}
	}
	
	@RequestMapping(value = "/cmsquery", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel getCMSQueryReportGA(@RequestBody CmsQueryRequest request){
		ResponseModel response = new ResponseModel();
		
		try {
			List<CmsQueryResponse> responseData = reportingGaService.getCMSQueryReport(request.getGaTrackingId(), 
												request.getGaViewId(), request.getFromDate(), request.getToDate(), 
												request.getOsSystem(), request.getCampaign(), request.getSource(),
												request.getMedium(), request.getFilterChannel());
			
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
		} catch (Exception e) {
			log.error("ERROR ", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}	
		
		return response;
	}
	
	
	// ===========================================================
	// Private method
	// ===========================================================
	/**
	 * Set response and log info when occur error
	 * 
	 * @param startTime
	 * @param message
	 * @return response object
	 */
	private ResponseModel setResponseAndLogInfo(long startTime, String message,
			String messageEndProcess) {
		long endTime = System.currentTimeMillis();
		ResponseModel response = new ResponseModel();
		response.setError(PConstants.RESPONSE.CODE_ERROR);
		response.setMessage(message);
		endTime = System.currentTimeMillis();
		log.error(message);
		log.error(new StringBuffer(messageEndProcess).append(
				String.valueOf(endTime - startTime)).toString());
		return response;
	}

	/**
	 * Check correct format of date
	 * 
	 * @param date
	 * @param format
	 * @return boolean value
	 */
	private boolean validateDateFormat(String date, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		formatter.setLenient(false);
		try {
			formatter.parse(date);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
