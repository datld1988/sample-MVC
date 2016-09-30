package com.vtc.business.impl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.vtc.business.AppActivityService;
import com.vtc.business.CommonUtils;
import com.vtc.business.ModelUtils;
import com.vtc.business.ServiceUtils;
import com.vtc.dataconstant.DataConstants;
import com.vtc.mongocore.AppActivityMetadata;
import com.vtc.mongocore.Events;
import com.vtc.mongocore.Tracking;
import com.vtc.mongorepository.EventsRepository;
import com.vtc.mongorepository.TrackingRepository;
import com.vtc.request.AppActivityRequest;
import com.vtc.serviceproxy.GaTracking;

@Service
public class AppActivityServiceImpl implements AppActivityService {
	private static final Logger log = Logger.getLogger(AppActivityServiceImpl.class);

	@Autowired
	private GaTracking gaTracking;
	@Autowired
	private EventsRepository eventsRepository;
	@Autowired
	private TrackingRepository trackingRepository;
	@Autowired
	private ModelUtils modelUtils;
	@Autowired
	private CommonUtils commonUtils;
	@Autowired
	private ServiceUtils serviceUtils;

	@Override
	public Events<AppActivityMetadata> appActivity(AppActivityRequest request) throws IOException {
		if(request == null){
			return null;
		}
		String activityType = commonUtils.mappingActivityType(request.getActivityType());
		if (activityType.isEmpty()) {
			log.error(new StringBuffer("[ERROR]").append("ActivityType is not mapping"));
			return null;
		}
		
		request = (AppActivityRequest) serviceUtils.modifyRequest(request);
		
		// Check FirstOpen
		

		log.info(new StringBuffer("1. Save trackingGA information to DB"));
		Tracking tracking = trackingRepository
				.save(modelUtils.createTrackingObj(request.getTrackingModel(), request.getClientId()));

		log.info(new StringBuffer("2. Save Event Information to DB"));
		Events<AppActivityMetadata> eventAppActivity = eventsRepository.save(modelUtils.createEvent(activityType,
				request, modelUtils.createActivityMetadata(tracking.getId().toString(), tracking.getMetadata())));

		return eventAppActivity;
	}

	@Override
	public Integer checkFirst(String type, String adsId) {
		List<Events> response = eventsRepository.findAllByTypeAndAdsId(type, adsId);
		if(CollectionUtils.isEmpty(response)){
			return DataConstants.Zero;
		}
		
		return response.size();
	}

}
