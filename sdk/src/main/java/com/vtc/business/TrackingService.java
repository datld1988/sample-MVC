package com.vtc.business;

import java.io.IOException;

import com.vtc.model.TrackingModel;
import com.vtc.mongocore.Tracking;

public interface TrackingService {
	Tracking HitSingleEvent(TrackingModel data) throws IOException ;
}
