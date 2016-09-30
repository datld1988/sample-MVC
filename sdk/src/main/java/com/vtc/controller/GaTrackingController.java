package com.vtc.controller;

import java.io.IOException;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vtc.business.TrackingService;
import com.vtc.model.TrackingModel;
import com.vtc.mongocore.Tracking;
import com.vtc.response.ResponseModel;
import com.vtc.util.PConstants;

@Controller
public class GaTrackingController {
	private static final Logger log = Logger.getLogger(GaTrackingController.class); 
	
	@Autowired
	TrackingService trackingBiz;
	
	/**
	 * Api Hit EventSingle  (send data to GA and insert to DB)
	 * 
	 * @param gaTrackingId
	 * @param gaClientId
	 * @param category
	 * @param action
	 * @param label
	 * @param value
	 * @return
	 */
	@RequestMapping(value="/tracking/hitevent", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel HitEventSingle(@RequestBody TrackingModel data){
//			@RequestParam(value="gaTrackingId", required=true, defaultValue="") String gaTrackingId,
//			@RequestParam(value="gaClientId", required=true, defaultValue="") String gaClientId,
//			@RequestParam(value="hitType", required=true, defaultValue="") String hitType,
//			@RequestParam(value="category", required=false, defaultValue="") String category,
//			@RequestParam(value="action", required=false, defaultValue="") String action,
//			@RequestParam(value="label", required=false, defaultValue="") String label,
//			@RequestParam(value="value", required=false, defaultValue="") String value,
//			@RequestParam(value="campagin", required=false, defaultValue="") String campaign,
//			@RequestParam(value="source", required=false, defaultValue="") String source,
//			@RequestParam(value="medium", required=false, defaultValue="") String medium){
		ResponseModel response = new ResponseModel();
		
//		log.info(new StringBuffer("[START] HitEventSingle  ")
//				.append(", gaTrackingId:").append(gaTrackingId)
//				.append(", gaClientId:").append(gaClientId)
//				.append(", category:").append(category)
//				.append(", action:").append(action)
//				.append(", label:").append(label)
//				.append(", value:").append(value)
//				.append(", campagin:").append(campaign)
//				.append(", source:").append(source)
//				.append(", medium:").append(medium)
//				);

//		TrackingModel data = new TrackingModel();
//		data.setGaTrackingId(gaTrackingId);
//		data.setGaClientId(gaClientId);
//		data.setHitType(hitType);
//		data.setCategory(category);
//		data.setAction(action);
//		data.setLabel(label);
//		data.setValue(value);
//		data.setCampaignName(campaign);
//		data.setCampaignSource(source);
//		data.setCampaignMedium(medium);
		
		try {
			if(data == null){
				response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
				return response;
			}
			Tracking tracking = trackingBiz.HitSingleEvent(data);
			log.info(new StringBuffer("[END] HitEventSingle Success!!! "));
			
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, tracking);
			return response;
		} catch (IOException e) {
			response.setError(PConstants.RESPONSE.CODE_ERROR);
			response.setMessage(PConstants.RESPONSE.MESS_SYSTEM);
			log.error(e.toString());
			log.info(new StringBuffer("[END] HitEventSingle Error!!! "));
			
			return response;
		}
	}
}
