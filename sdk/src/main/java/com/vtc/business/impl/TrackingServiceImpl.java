package com.vtc.business.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.vtc.business.ModelUtils;
import com.vtc.business.TrackingService;
import com.vtc.dataconstant.GaParams;
import com.vtc.model.TrackingModel;
import com.vtc.mongocore.Tracking;
import com.vtc.mongorepository.TrackingRepository;
import com.vtc.response.ResponseModel;
import com.vtc.serviceproxy.GaTracking;

public class TrackingServiceImpl implements TrackingService {
	private static final Logger log = Logger.getLogger(TrackingServiceImpl.class); 

	@Autowired
	private GaTracking gaTracking;
	
	@Autowired
	TrackingRepository trackingRepository;
	
	@Autowired
	private ModelUtils modelUtils;
	
//	public TrackingBizImpl(GaTracking gaTracking, ModelUtils modelUtils) {
//		this.gaTracking = gaTracking;
//		this.modelUtils = modelUtils;
//	}
	
	@Override
	public Tracking HitSingleEvent(TrackingModel data) throws IOException {
		log.info(new StringBuffer(" 1. Send data to GA"));
		Map<String, String> params = new HashMap<String, String>();
		params.put(GaParams.ParamTracking.Category, data.getCategory());
		params.put(GaParams.ParamTracking.Action, data.getAction());
		params.put(GaParams.ParamTracking.Label, data.getLabel());
		params.put(GaParams.ParamTracking.Value, data.getValue());
		params.put(GaParams.ParamTracking.CampaignName, data.getCampaignName());
		params.put(GaParams.ParamTracking.CampaignSource, data.getCampaignSource());
		params.put(GaParams.ParamTracking.CampaignMedium, data.getCampaignMedium());
		params.put(GaParams.ParamTracking.TransactionId, data.getTransactionId());
		params.put(GaParams.ParamTracking.TransactionRevenue, data.getTransactionRevenue());
		
		int responseCode = gaTracking.TrackEvent(data.getGaTrackingId(), data.getGaClientId(), data.getHitType(), params);
		
		log.info(new StringBuffer(" 2. Save Tracking to MongoDB"));
		Tracking tracking = null;//(Tracking)  trackingRepository.save(modelUtils.createTrackingObj(data, ));
		
		return tracking;
	}
}
