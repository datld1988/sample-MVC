package com.vtc.serviceproxy;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public interface GaTracking {
	int TrackEvent(String gaTrackingId, String gaClientId, String hitType, Map<String, String> params) throws IOException;
}
