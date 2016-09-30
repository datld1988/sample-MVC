package com.vtc.serviceproxy.test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.swing.SortOrder;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.google.api.services.analyticsreporting.v4.model.Dimension;
import com.google.api.services.analyticsreporting.v4.model.DimensionFilter;
import com.google.api.services.analyticsreporting.v4.model.DimensionFilterClause;
import com.google.api.services.analyticsreporting.v4.model.GetReportsResponse;
import com.google.api.services.analyticsreporting.v4.model.Metric;
import com.google.api.services.analyticsreporting.v4.model.OrderBy;
import com.google.api.services.analyticsreporting.v4.model.Pivot;
import com.google.api.services.analyticsreporting.v4.model.Report;
import com.google.api.services.analyticsreporting.v4.model.ReportData;
import com.google.api.services.analyticsreporting.v4.model.ReportRequest;
import com.google.api.services.analyticsreporting.v4.model.ReportRow;
import com.google.api.services.analyticsreporting.v4.model.Segment;
import com.vtc.dataconstant.DataConstants;
import com.vtc.dataconstant.GaParams;
import com.vtc.model.CMSFilterDataModel;
import com.vtc.response.CmsQueryResponse;
import com.vtc.serviceproxy.GaBuilder;
import com.vtc.serviceproxy.GaConfiguration;
import com.vtc.serviceproxy.LoadConfig;
import com.vtc.serviceproxy.impl.GaBuilderImpl;
import com.vtc.serviceproxy.impl.GaConfigurationImpl;
import com.vtc.serviceproxy.impl.GaReportImpl;
import com.vtc.serviceproxy.impl.LoadConfigImpl;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;


@RunWith(JUnitParamsRunner.class)
public class GaReportTest {

//	@InjectMocks
	private GaReportImpl gaReport = new GaReportImpl();
	
//	@Spy
	private GaBuilderImpl gaBuilder = new GaBuilderImpl();
	
//	@Spy
	private GaConfigurationImpl configuration = new GaConfigurationImpl();
	
//	@Spy
	private LoadConfig loadConfig = new LoadConfigImpl();
	
	@Before
	public void setUp() throws Exception {
		configuration.setConfig(loadConfig);
		gaBuilder.setConfiguration(configuration);
		gaReport.setBuilder(gaBuilder);
//		MockitoAnnotations.initMocks(this);
//		gaBuilder = new GaBuilderImpl(new GaConfigurationImpl(new LoadConfigImpl()));
//		gaReport = new GaReportImpl(gaBuilder);
	}

//	@Test
	public void CallGetReport() throws IOException {
		GetReportsResponse response = gaReport.getReport();
		
		System.out.println(response);
	}
	
//	@Test
	public void CallGetReportWithParam() throws IOException{
		List<String> metrics = Arrays.asList("ga:pageviews","ga:sessions");
		List<String> dimensions = Arrays.asList("ga:medium");
		GetReportsResponse response = gaReport.getReportWithParams("119839357", "2016-05-01", "2016-06-28", metrics, "", "", dimensions, "ga:sessions", Arrays.asList("10"));
		System.out.println(response);
	}
	
//	@Test
//	@Parameters({
//		"119839357, ga:newUsers, ga:sessions, ga:avgSessionDuration, ga:campaign, ga:date",
//		"119506677, ga:newUsers, INTEGER, ga:sessions, INTEGER, ga:avgSessionDuration, TIME, ga:campaign, ga:date"
//	})
	public void CallGetReportFull() throws IOException{
//		String viewId = "119839357";
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String requiredDate = df.format(new Date()).toString();
		String fromDate = "2016-07-01";
		String toDate = "2016-07-07";
		String viewId = "125114781"; // Test SDK  
//		String viewId = "119506677"; // Long Tướng
		List<Metric> metrics = Arrays.asList(
//								gaBuilder.createMetric(GaParams.Metric.TOTAL_EVENTS, DataConstants.FormattingTypes.Integer)
//								,gaBuilder.createMetric("ga:uniqueEvents", DataConstants.FormattingTypes.Integer)
//								,gaBuilder.createMetric("ga:eventValue", DataConstants.FormattingTypes.Integer)
//								,gaBuilder.createMetric("ga:avgEventValue", DataConstants.FormattingTypes.Integer)
								gaBuilder.createMetric(GaParams.Metric.Sessions, DataConstants.FormattingTypes.Integer)
//								,gaBuilder.createMetric(GaParams.Metric.AvgSessionDuration, DataConstants.FormattingTypes.Time)
								); 
		
		List<String> dimensions = Arrays.asList(GaParams.Dimension.Date, GaParams.Dimension.OPERATING_SYSTEM);
		
//		List<DimensionFilterClause> dimensionFilterClauses = Arrays.asList(
//				gaBuilder.createDimensionFilterClause(GaParams.Dimension.Country, GaParams.Operator.PARTIAL, Arrays.asList("Vietnam")),
//				gaBuilder.createDimensionFilterClause(GaParams.Dimension.OPERATING_SYSTEM, GaParams.Operator.PARTIAL, Arrays.asList("Android")));
		List<OrderBy> orderBys = null;//Arrays.asList(gaBuilder.createOrderBy(GaParams.Dimension.OPERATING_SYSTEM, SortOrder.ASCENDING.toString()));
//		
//		List<Dimension> dimensionRequest = Arrays.asList(
//				new Dimension().setName(GaParams.Dimension.SourceMedium)
//				new Dimension().setName(GaParams.Dimension.Country), 
//				new Dimension().setName(GaParams.Dimension.OPERATING_SYSTEM)
//				);
//		Pivot pivot = gaBuilder.createPivot(dimensionRequest, null, metrics, null, null);
		
//		Segment segment = gaBuilder.createSegment("Segment1", Arrays.asList(
//					gaBuilder.createSegmentFilter(gaBuilder.createSimpleSegment(null, gaBuilder.createSegmentDimensionFilter(GaParams.Dimension.Country, GaParams.Operator.PARTIAL, Arrays.asList("Vietnam"))), null),
//					gaBuilder.createSegmentFilter(gaBuilder.createSimpleSegment(null, gaBuilder.createSegmentDimensionFilter(GaParams.Dimension.OPERATING_SYSTEM, GaParams.Operator.PARTIAL, Arrays.asList("Android"))), null)));
		ReportRequest reportRequest = gaBuilder.createReportRequest(viewId, fromDate, toDate, metrics, null, dimensions, null, orderBys, null, null, null, GaParams.SamplingLevel.LARGE);
		GetReportsResponse response = gaReport.getReportWithParams(Arrays.asList(reportRequest));
		
		System.out.println("----------------------------------------------");
		System.out.println(response);
	}
	
//	@Test
	public void quickTest() throws IOException{
		String gaViewId = "125114781";
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
		
		HashMap<String, List<String>> mapFilterData = new HashMap<>();
		
		
		for (Report report : response.getReports()) {
			String dimension = report.getColumnHeader().getDimensions().stream().findFirst().get();
			mapFilterData.put(dimension, null);
			
			List<ReportRow> rows = report.getData().getRows();
			if (rows == null) {
				continue;
			}
			List<String> dimensionNames = new ArrayList<>();
			for (ReportRow row : rows) {
				String dimensionName = row.getDimensions().stream().findFirst().get();
				dimensionNames.add(dimensionName);
			}
			
			mapFilterData.put(dimension, dimensionNames);
		}	
		CMSFilterDataModel model = new CMSFilterDataModel();
		model.setCampaigns(mapFilterData.get(GaParams.Dimension.Campaign));
		model.setSources(mapFilterData.get(GaParams.Dimension.Source));
		model.setMediums(mapFilterData.get(GaParams.Dimension.Medium));
		
		System.out.println("----------------------------------------------");
//		System.out.println(responseCampaign);
	}
	
//	@Test
	public void TestGA(){
		String gaViewId="125114781";
		String fromDate = "2016-07-01";
		String toDate = "2016-08-03";
		String osSystem = "";
		String campaign = "";
		String source = "";
		String medium = "";
		
		String categoryFilterValueInstall = "inappEvent";
		String actionFilterValueInstall = "firstOpen";
//		ReportRequest reportRequestInstall = this.createRequest("installs", GaParams.Metric.Users,gaViewId, fromDate, toDate, osSystem, campaign, source, medium, categoryFilterValueInstall, actionFilterValueInstall, "");
		
		String categoryFilterValueNRU = "Authen";
		String actionFilterValueNRU = "Register";
		
//		ReportRequest reportRequestNRU = this.createRequest("nrus", GaParams.Metric.Users,gaViewId, fromDate, toDate, osSystem, campaign, source, medium, categoryFilterValueNRU, actionFilterValueNRU, "");
		
//		GetReportsResponse response = gaReport.getReportWithParams(Arrays.asList(reportRequestInstall, reportRequestNRU));
		
//		System.out.println(response);
	}
	
//	@Test
	public void quickTestCMSReport() throws IOException{
		String viewId = "125114781";
		String fromDate = "2016-07-04";
		String toDate = "2016-08-03";
		List<Metric> metrics = Arrays.asList(gaBuilder.createMetric(GaParams.Metric.NewUsers, DataConstants.FormattingTypes.Integer));
		List<String> dimensions = Arrays.asList(GaParams.Dimension.Campaign);
		GetReportsResponse dummyResponse = new GetReportsResponse(); 
		dummyResponse.setReports(Arrays.asList(new Report().setData(new ReportData().setRowCount(new Integer(10)))));
		
		OrderBy orderBy = new OrderBy();
		orderBy.setFieldName(GaParams.Dimension.Campaign);
		orderBy.setSortOrder(SortOrder.ASCENDING.toString());
		
		DimensionFilterClause filterClause = new DimensionFilterClause();
		filterClause.setFilters(Arrays.asList(new DimensionFilter().setDimensionName(GaParams.Dimension.Campaign).setOperator(GaParams.Operator.BEGINS_WITH).setExpressions(Arrays.asList("Campaign"))));
		
		ReportRequest request = gaBuilder.createReportRequest(viewId, fromDate, toDate, metrics, null, dimensions, Arrays.asList(filterClause), Arrays.asList(orderBy), null, null, null, null);
		dummyResponse = gaReport.getReportWithParams(Arrays.asList(request));
		
		System.out.println(dummyResponse);
	}
	
	@Test
	public void quickTestCMSReport1() throws IOException{
		String gaViewId="125114781";
		String fromDate = "2016-07-01";
		String toDate = "2016-08-03";
		String osSystem = "";
		String campaign = "";
		String source = "";
		String medium = "";
		
		ReportRequest reportRequestInstall = this.createRequest(DataConstants.GaMappingValue.AliasInstall, GaParams.Metric.TOTAL_EVENTS, gaViewId, fromDate, toDate, osSystem, campaign, source, medium, Arrays.asList(DataConstants.GaMappingValue.Install_EventCategoryVal), Arrays.asList(DataConstants.GaMappingValue.Install_EventActionVal), null, "");
		ReportRequest reportRequestNRU = this.createRequest(DataConstants.GaMappingValue.AliasNRU, GaParams.Metric.TOTAL_EVENTS, gaViewId, fromDate, toDate, osSystem, campaign, source, medium, Arrays.asList(DataConstants.GaMappingValue.Register_EventCategoryVal), Arrays.asList(DataConstants.GaMappingValue.Register_EventActionVal), null, "");
		ReportRequest reportRequestPU = this.createRequest(DataConstants.GaMappingValue.AliasPU, GaParams.Metric.Users, gaViewId, fromDate, toDate, osSystem, campaign, source, medium, Arrays.asList(DataConstants.GaMappingValue.Payment_EventCategoryVal), Arrays.asList(DataConstants.GaMappingValue.Payment_EventActionVal), Arrays.asList(DataConstants.GaMappingValue.Payment_EventLabelVal), "");
		ReportRequest reportRequestRevenue = this.createRequest(DataConstants.GaMappingValue.AliasRevenues, GaParams.Metric.EVENT_VALUE, gaViewId, fromDate, toDate, osSystem, campaign, source, medium, Arrays.asList(DataConstants.GaMappingValue.Payment_EventCategoryVal), Arrays.asList(DataConstants.GaMappingValue.Payment_EventActionVal), Arrays.asList(DataConstants.GaMappingValue.Payment_EventLabelVal), "");
		
		GetReportsResponse result = gaReport.getReportWithParams(Arrays.asList(reportRequestInstall, reportRequestNRU, reportRequestPU, reportRequestRevenue));
		System.out.println(result);
	}
	
	private ReportRequest createRequest(String alias, String metric, String gaViewId, String fromDate, String toDate, String osSytem,
			String campaign, String source, String medium, List<String> filterCategory, List<String> filterAction, List<String> filterLabel, String filterChannel){
		List<Metric> metrics = Arrays.asList(
				gaBuilder.createMetricWithAlias(metric, DataConstants.FormattingTypes.Integer, alias));
		
		List<String> dimensions = Arrays.asList(
					GaParams.Dimension.Campaign
//					,GaParams.Dimension.EVENT_CATEGORY
//					,GaParams.Dimension.EVENT_ACTION
				);
		
//		String categoryFilterValueNRU = "Authen";
//		String actionFilterValueNRU = "Register";
		
		List<OrderBy> orderBys = Arrays.asList(gaBuilder.createOrderBy(GaParams.Dimension.Campaign, SortOrder.ASCENDING.toString()));
		
		DimensionFilterClause dimensionFilterOsSystem =  gaBuilder.createDimensionFilterClause(GaParams.Dimension.OPERATING_SYSTEM, GaParams.Operator.PARTIAL, Arrays.asList(osSytem));
		DimensionFilterClause dimensionFilterEventCategory =  gaBuilder.createDimensionFilterClause(GaParams.Dimension.EVENT_CATEGORY, GaParams.Operator.EXACT, filterCategory);
		DimensionFilterClause dimensionFilterEventAction =  gaBuilder.createDimensionFilterClause(GaParams.Dimension.EVENT_ACTION, GaParams.Operator.EXACT, filterAction);
		DimensionFilterClause dimensionFilterCampaign = gaBuilder.createDimensionFilterClause(GaParams.Dimension.Campaign, GaParams.Operator.EQUAL, Arrays.asList(campaign));
		DimensionFilterClause dimensionFilterSource = gaBuilder.createDimensionFilterClause(GaParams.Dimension.Source, GaParams.Operator.EQUAL, Arrays.asList(source));
		DimensionFilterClause dimensionFilterMedium = gaBuilder.createDimensionFilterClause(GaParams.Dimension.Medium, GaParams.Operator.EQUAL, Arrays.asList(medium));
		DimensionFilterClause dimensionFilterChannel = gaBuilder.createDimensionFilterClause(GaParams.Dimension.Campaign, GaParams.Operator.BEGINS_WITH, Arrays.asList(filterChannel));
		
		List<DimensionFilterClause> filterDimensions = new ArrayList<>();
		if(!StringUtils.isEmpty(osSytem)){
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
		if(!StringUtils.isEmpty(filterChannel)){
			filterDimensions.add(dimensionFilterChannel);
		}
		
		filterDimensions.add(dimensionFilterEventCategory);
		filterDimensions.add(dimensionFilterEventAction);
		
		ReportRequest reportRequest = gaBuilder.createReportRequest(gaViewId, fromDate, toDate, metrics, null, dimensions, filterDimensions, orderBys, null, null, null, null);
		
		return reportRequest;
	}

}
