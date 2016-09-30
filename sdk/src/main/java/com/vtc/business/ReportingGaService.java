package com.vtc.business;

import java.io.IOException;
import java.util.List;

import com.google.api.services.analyticsreporting.v4.model.GetReportsResponse;
import com.vtc.model.CMSFilterDataModel;
import com.vtc.response.CmsQueryResponse;

public interface ReportingGaService {
	GetReportsResponse reportCampaign(String viewId, String fromDate, String toDate, List<String> filterValues) throws IOException ;

	/** Get report by operation system */
	GetReportsResponse reportByDevice(String viewId, String fromDate, String toDate) throws IOException ;

	/** Get report by marketing */
	GetReportsResponse getMarketingReport(String viewId, String dateFrom, String dateTo, Integer marketingType) throws IOException ;

	/** Get report by active user */
	GetReportsResponse getActiveUserReport(String viewId, String dateFrom, String dateTo) throws IOException ;

	/** Get report by UTM */
	GetReportsResponse getUTMReport(String viewId, String dateFrom, String dateTo, Integer utmType) throws IOException ;

	/** Get report by Event */
	GetReportsResponse getEventReport(String viewId, String dateFrom, String dateTo, Integer eventType) throws IOException ;

	CMSFilterDataModel getFilterData(String gaTrackingId, String gaViewId)  throws IOException;
	
	List<CmsQueryResponse> getCMSQueryReport(String gaTrackingId, String gaViewId, String fromDate, String toDate, String osSystem, String campaign, String source, String medium, String filterChannel) throws IOException;
}
