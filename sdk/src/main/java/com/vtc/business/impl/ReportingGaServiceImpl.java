package com.vtc.business.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import javax.swing.SortOrder;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.services.analyticsreporting.v4.model.DateRange;
import com.google.api.services.analyticsreporting.v4.model.Dimension;
import com.google.api.services.analyticsreporting.v4.model.DimensionFilterClause;
import com.google.api.services.analyticsreporting.v4.model.GetReportsRequest;
import com.google.api.services.analyticsreporting.v4.model.GetReportsResponse;
import com.google.api.services.analyticsreporting.v4.model.Metric;
import com.google.api.services.analyticsreporting.v4.model.OrderBy;
import com.google.api.services.analyticsreporting.v4.model.ReportRequest;
import com.vtc.business.CommonUtils;
import com.vtc.business.ReportingGaService;
import com.vtc.config.ISysConfig;
import com.vtc.dataconstant.DataConstants;
import com.vtc.dataconstant.GaParams;
import com.vtc.model.CMSFilterDataModel;
import com.vtc.response.CmsQueryResponse;
import com.vtc.serviceproxy.GaBuilder;
import com.vtc.serviceproxy.GaReport;

@Service
public class ReportingGaServiceImpl implements ReportingGaService{
	private static Logger log = Logger.getLogger(ReportingGaServiceImpl.class);

	@Autowired
	private GaReport gaReport;
	
	@Autowired
	private GaBuilder gaBuilder;
	
	@Autowired
	private CommonUtils commonUtils;
	
	@Autowired
	private ISysConfig sysConfig;
	
	@Override
	public GetReportsResponse reportCampaign(String viewId, String fromDate, String toDate, List<String> filterValues) throws IOException {
		log.info(new StringBuffer("[START] ReportingGaServiceImpl.reportCampaign(). "));
		List<Metric> metrics = Arrays.asList(
				gaBuilder.createMetric(GaParams.Metric.NewUsers, DataConstants.FormattingTypes.Integer),
				gaBuilder.createMetric(GaParams.Metric.Sessions, DataConstants.FormattingTypes.Integer),
				gaBuilder.createMetric(GaParams.Metric.AvgSessionDuration, DataConstants.FormattingTypes.Time));
		List<String> dimensions = Arrays.asList(GaParams.Dimension.Campaign);
		List<OrderBy> orderBys = Arrays.asList(gaBuilder.createOrderBy(GaParams.Dimension.Campaign, SortOrder.ASCENDING.toString()));
		DimensionFilterClause dimensionFilterClause =  gaBuilder.createDimensionFilterClause(GaParams.Dimension.Campaign, GaParams.Operator.PARTIAL, filterValues);
		
		ReportRequest reportRequest = gaBuilder.createReportRequest(viewId, fromDate, toDate, metrics, null, dimensions, Arrays.asList(dimensionFilterClause), orderBys, null, null, null, null);
		GetReportsResponse response = gaReport.getReportWithParams(Arrays.asList(reportRequest));
		
		log.info(new StringBuffer("[END] ReportingGaServiceImpl.reportCampaign() is successfully!!!. "));
		return response;
	}

	/**
	 * Get report info by operation system (Android or IOS)
	 * @param viewId
	 * @param osType
	 * @param fromDate
	 * @param toDate
	 * @param eventCategory
	 * @param eventAction
	 * @return Reports info
	 */
	@Override
	public GetReportsResponse reportByDevice(
			String viewId,
			String fromDate,
			String toDate) throws IOException {

		// Create the DateRange object.
		DateRange dateRange = new DateRange();
		dateRange.setStartDate(fromDate);
		dateRange.setEndDate(toDate);

		// Set metric info
		List<Metric> metrics = Arrays.asList(
				gaBuilder.createMetric(GaParams.Metric.Users, DataConstants.FormattingTypes.Integer)
				,gaBuilder.createMetric(GaParams.Metric.TRANSACTION_REVENUE, DataConstants.FormattingTypes.Integer)
				,gaBuilder.createMetric(GaParams.Metric.REVENUE_PER_USER, DataConstants.FormattingTypes.Integer));

		// Set dimension info
		List<Dimension> dimensions = Arrays.asList(
				new Dimension().setName(GaParams.Dimension.DEVICE_CATEGORY),
				new Dimension().setName(GaParams.Dimension.MOBILE_DEVICE_BRANDING),
				new Dimension().setName(GaParams.Dimension.SCREEN_RESOLUTION)
				);

		// Create the ReportRequest object.
		ReportRequest request = new ReportRequest()
				.setViewId(viewId)
				.setDateRanges(Arrays.asList(dateRange))
				.setDimensions(dimensions)
				.setMetrics(metrics);

		// Create the GetReportsRequest object.
		GetReportsRequest getReport = new GetReportsRequest()
				.setReportRequests(Arrays.asList(request));

		// Call the batchGet method.
		GetReportsResponse response = gaBuilder.initializeAnalyticsReporting().reports()
				.batchGet(getReport).execute();
		return response;
	}

	/**
	 * Get report by marketing
	 * @param viewId
	 * @param fromDate
	 * @param toDate
	 * @param marketingType
	 * @return Reports info
	 */
	@Override
	public GetReportsResponse getMarketingReport(
			String viewId,
			String fromDate,
			String toDate,
			Integer marketingType) throws IOException {

		// Create the DateRange object.
		DateRange dateRange = new DateRange();
		dateRange.setStartDate(fromDate);
		dateRange.setEndDate(toDate);

		// Set metric info
		List<Metric> metrics = Arrays.asList(
				gaBuilder.createMetric(GaParams.Metric.Users, DataConstants.FormattingTypes.Integer)
				,gaBuilder.createMetric(GaParams.Metric.NewUsers, DataConstants.FormattingTypes.Integer));

		// Set dimension info
		List<Dimension> dimensions = Arrays.asList(
				new Dimension().setName(GaParams.Dimension.Campaign)
				, new Dimension().setName(GaParams.Dimension.Source)
				, new Dimension().setName(GaParams.Dimension.Medium));

		// Create Dimension Filter.
		// Set dimension filter value
		List<String> filterCampainValues = new ArrayList<String>();
		if (marketingType == DataConstants.MarketingType.FACEBOOK.getCode()) {
			filterCampainValues = Arrays.asList(DataConstants.MarketingType.FACEBOOK.getDisplay());
		} else if (marketingType == DataConstants.MarketingType.GOOGLE.getCode()) {
			filterCampainValues = Arrays.asList(DataConstants.MarketingType.GOOGLE.getDisplay());
		} else if (marketingType == DataConstants.MarketingType.PROVIDER.getCode()) {
			filterCampainValues = Arrays.asList(DataConstants.MarketingType.PROVIDER.getDisplay());
		}

		// Create Dimension filter by source.
		DimensionFilterClause filterSourceDimension = 
				gaBuilder.createDimensionFilterClause(GaParams.Dimension.Source, GaParams.Operator.PARTIAL, filterCampainValues);

		// Create the ReportRequest object.
		ReportRequest request = new ReportRequest()
				.setViewId(viewId)
				.setDateRanges(Arrays.asList(dateRange))
				.setDimensions(dimensions)
				.setMetrics(metrics)
				.setDimensionFilterClauses(Arrays.asList(filterSourceDimension));

		// Create the GetReportsRequest object.
		GetReportsRequest getReport = new GetReportsRequest()
				.setReportRequests(Arrays.asList(request));

		// Call the batchGet method.
		GetReportsResponse response = gaBuilder.initializeAnalyticsReporting().reports()
				.batchGet(getReport).execute();
		return response;
	}

	/**
	 * Get report by active user
	 * @param viewId
	 * @param dateFrom
	 * @param dateTo
	 */
	@Override
	public GetReportsResponse getActiveUserReport(String viewId,
			String dateFrom, String dateTo) throws IOException {

		// Create the DateRange object.
		DateRange dateRange = new DateRange();
		dateRange.setStartDate(dateFrom);
		dateRange.setEndDate(dateTo);

		// Set metric info
		List<Metric> metrics = Arrays.asList(
				gaBuilder.createMetric(GaParams.Metric.Users, DataConstants.FormattingTypes.Integer)
				,gaBuilder.createMetric(GaParams.Metric.NewUsers, DataConstants.FormattingTypes.Integer)
				,gaBuilder.createMetric(GaParams.Metric.Sessions, DataConstants.FormattingTypes.Integer)
				,gaBuilder.createMetric(GaParams.Metric.SessionDuration, DataConstants.FormattingTypes.Integer)
				,gaBuilder.createMetric(GaParams.Metric.TRANSACTION_REVENUE, DataConstants.FormattingTypes.Integer));

		// Set dimension info
		List<Dimension> dimensions = Arrays.asList(
				//new Dimension().setName(GaParams.Dimension.Date)
				new Dimension().setName(GaParams.Dimension.Campaign)
				, new Dimension().setName(GaParams.Dimension.Source)
				, new Dimension().setName(GaParams.Dimension.Medium));

		// Create the ReportRequest object.
		ReportRequest request = new ReportRequest()
				.setViewId(viewId)
				.setDateRanges(Arrays.asList(dateRange))
				.setDimensions(dimensions)
				.setMetrics(metrics);

		// Create the GetReportsRequest object.
		GetReportsRequest getReport = new GetReportsRequest()
				.setReportRequests(Arrays.asList(request));

		// Call the batchGet method.
		GetReportsResponse response = gaBuilder.initializeAnalyticsReporting().reports()
				.batchGet(getReport).execute();
		return response;
	}

	/**
	 * Get report by UTM
	 * @param viewId
	 * @param dateFrom
	 * @param dateTo
	 * @param utmType
	 * @return response object
	 */
	@Override
	public GetReportsResponse getUTMReport(
			String viewId
			, String dateFrom
			, String dateTo
			, Integer utmType) throws IOException {
		// Create the DateRange object.
		DateRange dateRange = new DateRange();
		dateRange.setStartDate(dateFrom);
		dateRange.setEndDate(dateTo);

		// Set metric info
		List<Metric> metrics = Arrays.asList(
				gaBuilder.createMetric(GaParams.Metric.Users, DataConstants.FormattingTypes.Integer)
				,gaBuilder.createMetric(GaParams.Metric.NewUsers, DataConstants.FormattingTypes.Integer)
				,gaBuilder.createMetric(GaParams.Metric.TRANSACTION_REVENUE, DataConstants.FormattingTypes.Integer)
				,gaBuilder.createMetric(GaParams.Metric.REVENUE_PER_USER, DataConstants.FormattingTypes.Integer)	);

		// Set dimension info
		List<Dimension> dimensions = new ArrayList<Dimension>();
		if(utmType == DataConstants.UTMType.UTM_CAMPAIGN.getCode()) {
			dimensions.add(new Dimension().setName(GaParams.Dimension.Campaign));
		} else if (utmType == DataConstants.UTMType.UTM_MEDIUM.getCode()) {
			dimensions.add(new Dimension().setName(GaParams.Dimension.Medium));
		} else if (utmType == DataConstants.UTMType.UTM_SOURCE.getCode()) {
			dimensions.add(new Dimension().setName(GaParams.Dimension.Source));
		}

		// Create the ReportRequest object.
		ReportRequest request = new ReportRequest()
				.setViewId(viewId)
				.setDateRanges(Arrays.asList(dateRange))
				.setDimensions(dimensions)
				.setMetrics(metrics);

		// Create the GetReportsRequest object.
		GetReportsRequest getReport = new GetReportsRequest()
				.setReportRequests(Arrays.asList(request));

		// Call the batchGet method.
		GetReportsResponse response = gaBuilder.initializeAnalyticsReporting().reports()
				.batchGet(getReport).execute();
		return response;
	}

	/**
	 * Get report by event
	 * @param viewId
	 * @param dateFrom
	 * @param dateTo
	 * @param utmType
	 * @return response object
	 */
	@Override
	public GetReportsResponse getEventReport(String viewId, String dateFrom,
			String dateTo, Integer eventType) throws IOException {
		// Create the DateRange object.
		DateRange dateRange = new DateRange();
		dateRange.setStartDate(dateFrom);
		dateRange.setEndDate(dateTo);

		// List metric info
		List<Metric> metrics = Arrays.asList(
				gaBuilder.createMetric(GaParams.Metric.TOTAL_EVENTS, DataConstants.FormattingTypes.Integer),
				gaBuilder.createMetric(GaParams.Metric.UNIQUE_EVENTS, DataConstants.FormattingTypes.Integer),
				gaBuilder.createMetric(GaParams.Metric.EVENT_VALUE, DataConstants.FormattingTypes.Integer)
				);

		// List dimension info
		List<Dimension> dimensions = new ArrayList<Dimension>();
		if(eventType == DataConstants.EventType.EVENT_CATEGORY.getCode()) {
			// Set info for dimension
			dimensions.add(new Dimension().setName(GaParams.Dimension.EVENT_CATEGORY));
			dimensions.add(new Dimension().setName(GaParams.Dimension.EVENT_LABEL));
			dimensions.add(new Dimension().setName(GaParams.Dimension.EVENT_ACTION));
			dimensions.add(new Dimension().setName(GaParams.Dimension.Date));
		} else if (eventType == DataConstants.EventType.EVENT_LABEL.getCode()) {
			// Set info for dimension
			dimensions.add(new Dimension().setName(GaParams.Dimension.EVENT_LABEL));
		} else if (eventType == DataConstants.EventType.EVENT_ACTION.getCode()) {
			// Set info for dimension
			dimensions.add(new Dimension().setName(GaParams.Dimension.EVENT_ACTION));
		} else if (eventType == DataConstants.EventType.EVENT_CAMPAGIN.getCode()) {
			// Set info for dimension
			dimensions.add(new Dimension().setName(GaParams.Dimension.Campaign));
			dimensions.add(new Dimension().setName(GaParams.Dimension.Source));
			dimensions.add(new Dimension().setName(GaParams.Dimension.Medium));
			dimensions.add(new Dimension().setName(GaParams.Dimension.Date));
		}

		// Create the ReportRequest object.
		ReportRequest request = new ReportRequest()
				.setViewId(viewId)
				.setDateRanges(Arrays.asList(dateRange))
				.setDimensions(dimensions)
				.setMetrics(metrics);

		// Create the GetReportsRequest object.
		GetReportsRequest getReport = new GetReportsRequest()
				.setReportRequests(Arrays.asList(request));

		// Call the batchGet method.
		GetReportsResponse response = gaBuilder.initializeAnalyticsReporting().reports()
				.batchGet(getReport).execute();
		return response;
	}

	public GaReport getGaReport() {
		return gaReport;
	}

	public void setGaReport(GaReport gaReport) {
		this.gaReport = gaReport;
	}

	public GaBuilder getGaBuilder() {
		return gaBuilder;
	}

	public void setGaBuilder(GaBuilder gaBuilder) {
		this.gaBuilder = gaBuilder;
	}

	@Override
	public CMSFilterDataModel getFilterData(String gaTrackingId, String gaViewId) throws IOException {
		List<Metric> metrics = Arrays.asList(
				gaBuilder.createMetric(GaParams.Metric.Sessions, DataConstants.FormattingTypes.Integer));
		List<String> dimensionsCampaign = Arrays.asList(GaParams.Dimension.Campaign);
		List<String> dimensionsSource = Arrays.asList(GaParams.Dimension.Source);
		List<String> dimensionsMedium = Arrays.asList(GaParams.Dimension.Medium);
		List<OrderBy> orderBysCampaign = Arrays.asList(gaBuilder.createOrderBy(GaParams.Dimension.Campaign, SortOrder.ASCENDING.toString()));
		List<OrderBy> orderBysSource = Arrays.asList(gaBuilder.createOrderBy(GaParams.Dimension.Source, SortOrder.ASCENDING.toString()));
		List<OrderBy> orderBysMedium = Arrays.asList(gaBuilder.createOrderBy(GaParams.Dimension.Medium, SortOrder.ASCENDING.toString()));
		
		ReportRequest reportRequestCampaign = gaBuilder.createReportRequest(gaViewId, "2015-01-01", null, metrics, null, dimensionsCampaign, null, orderBysCampaign, null, null, null, null);
		ReportRequest reportRequestSource = gaBuilder.createReportRequest(gaViewId, "2015-01-01", null, metrics, null, dimensionsSource, null, orderBysSource, null, null, null, null);
		ReportRequest reportRequestMedium = gaBuilder.createReportRequest(gaViewId, "2015-01-01", null, metrics, null, dimensionsMedium, null, orderBysMedium, null, null, null, null);
				
		GetReportsResponse response = gaReport.getReportWithParams(Arrays.asList(reportRequestCampaign, reportRequestSource, reportRequestMedium));
		
		HashMap<String, List<String>> mapFilterData = commonUtils.getMapDimensionName(response);
		
		CMSFilterDataModel result = new CMSFilterDataModel();
		result.setCampaigns(mapFilterData.get(GaParams.Dimension.Campaign));
		result.setSources(mapFilterData.get(GaParams.Dimension.Source));
		result.setMediums(mapFilterData.get(GaParams.Dimension.Medium));
		
		return result;
	}

	@Override
	public List<CmsQueryResponse> getCMSQueryReport(String gaTrackingId, String gaViewId, String fromDate, String toDate, String osSystem,
			String campaign, String source, String medium, String filterChannel) throws IOException {
		List<CmsQueryResponse> response = new ArrayList<>();
		
		ReportRequest reportRequestInstall = this.createRequest(DataConstants.GaMappingValue.AliasInstall, GaParams.Metric.TOTAL_EVENTS, gaViewId, fromDate, toDate, osSystem, campaign, source, medium, Arrays.asList(DataConstants.GaMappingValue.Install_EventCategoryVal), Arrays.asList(DataConstants.GaMappingValue.Install_EventActionVal), null, filterChannel);
		ReportRequest reportRequestNRU = this.createRequest(DataConstants.GaMappingValue.AliasNRU, GaParams.Metric.TOTAL_EVENTS, gaViewId, fromDate, toDate, osSystem, campaign, source, medium, Arrays.asList(DataConstants.GaMappingValue.Register_EventCategoryVal), Arrays.asList(DataConstants.GaMappingValue.Register_EventActionVal), null, filterChannel);
		ReportRequest reportRequestPU = this.createRequest(DataConstants.GaMappingValue.AliasPU, GaParams.Metric.Users, gaViewId, fromDate, toDate, osSystem, campaign, source, medium, Arrays.asList(DataConstants.GaMappingValue.Payment_EventCategoryVal), Arrays.asList(DataConstants.GaMappingValue.Payment_EventActionVal), Arrays.asList(DataConstants.GaMappingValue.Payment_EventLabelVal), filterChannel);
		ReportRequest reportRequestRevenue = this.createRequest(DataConstants.GaMappingValue.AliasRevenues, GaParams.Metric.EVENT_VALUE, gaViewId, fromDate, toDate, osSystem, campaign, source, medium, Arrays.asList(DataConstants.GaMappingValue.Payment_EventCategoryVal), Arrays.asList(DataConstants.GaMappingValue.Payment_EventActionVal), Arrays.asList(DataConstants.GaMappingValue.Payment_EventLabelVal), filterChannel);
		
		GetReportsResponse result = gaReport.getReportWithParams(Arrays.asList(reportRequestInstall, reportRequestNRU, reportRequestPU, reportRequestRevenue));
		
		HashMap<String, HashMap<String, String>> converter = commonUtils.toMappingCMS(result);
		
		response = commonUtils.convertToCmsQueryResponses(converter);
		
		Collections.sort(response, new Comparator<CmsQueryResponse>() {

			@Override
			public int compare(CmsQueryResponse o1, CmsQueryResponse o2) {
				return o1.getChannel().compareTo(o2.getChannel());
			}
		});
		
		return response;
	}
	
	private ReportRequest createRequest(String alias, String metric, String gaViewId, String fromDate, String toDate, String osSystem,
			String campaign, String source, String medium, List<String> filterCategory, List<String> filterAction, List<String> filterLabel, String filterChannel){
		List<Metric> metrics = Arrays.asList(
				gaBuilder.createMetricWithAlias(metric, DataConstants.FormattingTypes.Integer, alias));
		
		List<String> dimensions = Arrays.asList(
					GaParams.Dimension.Campaign
				);
		
		List<OrderBy> orderBys = Arrays.asList(gaBuilder.createOrderBy(GaParams.Dimension.Campaign, SortOrder.ASCENDING.toString()));
		DimensionFilterClause dimensionFilterOsSystem =  gaBuilder.createDimensionFilterClause(GaParams.Dimension.OPERATING_SYSTEM, GaParams.Operator.PARTIAL, Arrays.asList(osSystem));
		DimensionFilterClause dimensionFilterEventCategory =  gaBuilder.createDimensionFilterClause(GaParams.Dimension.EVENT_CATEGORY, GaParams.Operator.IN_LIST, filterCategory);
		DimensionFilterClause dimensionFilterEventAction =  gaBuilder.createDimensionFilterClause(GaParams.Dimension.EVENT_ACTION, GaParams.Operator.IN_LIST, filterAction);
		DimensionFilterClause dimensionFilterEventLabel =  gaBuilder.createDimensionFilterClause(GaParams.Dimension.EVENT_LABEL, GaParams.Operator.IN_LIST, filterLabel);
		
		DimensionFilterClause dimensionFilterCampaign = gaBuilder.createDimensionFilterClause(GaParams.Dimension.Campaign, GaParams.Operator.PARTIAL, Arrays.asList(campaign));
		DimensionFilterClause dimensionFilterSource = gaBuilder.createDimensionFilterClause(GaParams.Dimension.Source, GaParams.Operator.PARTIAL, Arrays.asList(source));
		DimensionFilterClause dimensionFilterMedium = gaBuilder.createDimensionFilterClause(GaParams.Dimension.Medium, GaParams.Operator.PARTIAL, Arrays.asList(medium));
		DimensionFilterClause dimensionFilterChannel = gaBuilder.createDimensionFilterClause(GaParams.Dimension.Campaign, GaParams.Operator.BEGINS_WITH, Arrays.asList(filterChannel));
		
		List<DimensionFilterClause> filterDimensions = new ArrayList<>();
		if(!StringUtils.isEmpty(osSystem)){
			filterDimensions.add(dimensionFilterOsSystem);
		}
		if(!StringUtils.isEmpty(campaign)){
			filterDimensions.add(dimensionFilterCampaign);
		}
		if(!StringUtils.isEmpty(source)){
			filterDimensions.add(dimensionFilterSource);
		}
		if(!StringUtils.isEmpty(medium)){
			filterDimensions.add(dimensionFilterMedium);
		}
		
		filterDimensions.add(dimensionFilterEventCategory);
		filterDimensions.add(dimensionFilterEventAction);
		if(!StringUtils.isEmpty(medium)){
			filterDimensions.add(dimensionFilterEventLabel);
		}
		
		if(!StringUtils.isEmpty(filterChannel)){
			filterDimensions.add(dimensionFilterChannel);
		}
		
		ReportRequest reportRequest = gaBuilder.createReportRequest(gaViewId, fromDate, toDate, metrics, null, dimensions, filterDimensions, orderBys, null, null, null, null);
		
		return reportRequest;
	}

	public CommonUtils getCommonUtils() {
		return commonUtils;
	}

	public void setCommonUtils(CommonUtils commonUtils) {
		this.commonUtils = commonUtils;
	}

	public ISysConfig getSysConfig() {
		return sysConfig;
	}

	public void setSysConfig(ISysConfig sysConfig) {
		this.sysConfig = sysConfig;
	}
}
