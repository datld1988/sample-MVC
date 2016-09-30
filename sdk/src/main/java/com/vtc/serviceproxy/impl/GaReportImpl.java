package com.vtc.serviceproxy.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.SortOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.google.api.services.analyticsreporting.v4.model.CohortGroup;
import com.google.api.services.analyticsreporting.v4.model.DateRange;
import com.google.api.services.analyticsreporting.v4.model.Dimension;
import com.google.api.services.analyticsreporting.v4.model.DimensionFilterClause;
import com.google.api.services.analyticsreporting.v4.model.DynamicSegment;
import com.google.api.services.analyticsreporting.v4.model.GetReportsRequest;
import com.google.api.services.analyticsreporting.v4.model.GetReportsResponse;
import com.google.api.services.analyticsreporting.v4.model.Metric;
import com.google.api.services.analyticsreporting.v4.model.MetricFilterClause;
import com.google.api.services.analyticsreporting.v4.model.OrFiltersForSegment;
import com.google.api.services.analyticsreporting.v4.model.OrderBy;
import com.google.api.services.analyticsreporting.v4.model.Pivot;
import com.google.api.services.analyticsreporting.v4.model.ReportRequest;
import com.google.api.services.analyticsreporting.v4.model.Segment;
import com.google.api.services.analyticsreporting.v4.model.SegmentDefinition;
import com.google.api.services.analyticsreporting.v4.model.SegmentFilter;
import com.google.api.services.analyticsreporting.v4.model.SegmentFilterClause;
import com.google.api.services.analyticsreporting.v4.model.SegmentMetricFilter;
import com.google.api.services.analyticsreporting.v4.model.SimpleSegment;
import com.vtc.dataconstant.GaParams;
import com.vtc.serviceproxy.GaBuilder;
import com.vtc.serviceproxy.GaReport;

@Service
public class GaReportImpl implements GaReport{
	
	@Autowired
	private GaBuilder builder;
	
//	public GaReportImpl(GaBuilder builder){
//		this.builder = builder;
//	}
	
	@Override
	public GetReportsResponse getReport() throws IOException {
		// Create the DateRange object.
	    DateRange dateRange = new DateRange();
	    dateRange.setStartDate(GaParams.DateRange.OneMonthAgo);
	    dateRange.setEndDate(GaParams.DateRange.Today);

	    // Create the Metrics object.
	    Metric sessions = new Metric()
	        .setExpression(GaParams.Metric.Users)
	        .setAlias(GaParams.Sessions);

	    
	    //Create the Dimensions object.
	    Dimension browser = new Dimension()
	        .setName(GaParams.Dimension.UserType);

	    // Create the ReportRequest object.
	    ReportRequest request = new ReportRequest()
	        .setViewId(builder.getViewId())
	        .setDateRanges(Arrays.asList(dateRange))
	        .setDimensions(Arrays.asList(browser))
	        .setMetrics(Arrays.asList(sessions));

	    ArrayList<ReportRequest> requests = new ArrayList<ReportRequest>();
	    requests.add(request);

	    // Create the GetReportsRequest object.
	    GetReportsRequest getReport = new GetReportsRequest()
	        .setReportRequests(requests);

	    // Call the batchGet method.
	    GetReportsResponse response;
		try {
			response = builder.initializeAnalyticsReporting().reports().batchGet(getReport).execute();
			
			// Return the response.
			return response;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public GetReportsResponse getReportWithParam(String from, String to, String metric, String dimension, String view)
			throws IOException {
		// Create the DateRange object.
	    DateRange dateRange = new DateRange();
	    dateRange.setStartDate(from);
	    dateRange.setEndDate(to);

	    metric = metric.replace(",", "/");
	    
	    // Create the Metrics object.
	    Metric sessions = new Metric()
	        .setExpression(metric)
	        .setAlias(GaParams.Sessions);
	    
	    //Create the Dimensions object.
	    Dimension browser = new Dimension()
	        .setName(dimension);
	    
	    // Create the ReportRequest object.
	    ReportRequest request = new ReportRequest()
	        .setViewId(view)
	        .setDateRanges(Arrays.asList(dateRange))
	        .setDimensions(Arrays.asList(browser))
	        .setMetrics(Arrays.asList(sessions));

	    System.out.println(request);
	    ArrayList<ReportRequest> requests = new ArrayList<ReportRequest>();
	    requests.add(request);

	    // Create the GetReportsRequest object.
	    GetReportsRequest getReport = new GetReportsRequest()
	        .setReportRequests(requests);

	    // Call the batchGet method.
	    GetReportsResponse response;
		try {
			response = builder.initializeAnalyticsReporting().reports().batchGet(getReport).execute();
			
			// Return the response.
			return response;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public GetReportsResponse getReportWithParams(String viewId, String fromDate, String toDate, List<String> metrics,
			String metricFilter, String metricFilterValue, List<String> dimensions, String dimensionFilter, List<String> dimensionFilterValue) throws IOException {
		// Create the DateRange object.
	    DateRange dateRange = new DateRange();
	    dateRange.setStartDate(fromDate);
	    dateRange.setEndDate(toDate);


	    List<Metric> metricRequest = new ArrayList<>();
	    List<Dimension> dimensionRequest = new ArrayList<>();
	    
	    if(metrics != null && !metrics.isEmpty()){
	    	metrics.stream().forEach(item -> metricRequest.add(new Metric().setExpression(item)));
	    }
	    
	    if(dimensions != null && !dimensions.isEmpty()){
	    	dimensions.stream().forEach(item -> dimensionRequest.add(new Dimension().setName(item)));
	    }
	    
	    OrderBy orderBy = new OrderBy()
	    		.setFieldName("ga:sessions")
	    		.setSortOrder(SortOrder.ASCENDING.toString());
	    
	    SegmentMetricFilter segmentDimensionFilter = new SegmentMetricFilter()
	    		.setMetricName(dimensionFilter)
	    		.setOperator(GaParams.Operator.GREATER_THAN)
	    		.setComparisonValue(dimensionFilterValue.get(0));
	    
	    SegmentFilterClause segmentFilterClauses = new SegmentFilterClause()
	    		.setMetricFilter(segmentDimensionFilter);
	    
	    OrFiltersForSegment orFiltersForSegment = new OrFiltersForSegment()
	    		.setSegmentFilterClauses(Arrays.asList(segmentFilterClauses));
	    
	    SimpleSegment simpleSegment = new SimpleSegment()
	    		.setOrFiltersForSegment(Arrays.asList(orFiltersForSegment));
	    
	    SegmentFilter segmentFilter = new SegmentFilter()
	    		.setSimpleSegment(simpleSegment);
	    
	    SegmentDefinition sessionSegment = new SegmentDefinition()
	    		.setSegmentFilters(Arrays.asList(segmentFilter));
	    
	    DynamicSegment dynamicSegment = new DynamicSegment().setName("my_segment").setUserSegment(sessionSegment);
	    
	    Segment segment = new Segment()
	    		.setDynamicSegment(dynamicSegment);
	    

	    // Create the ReportRequest object.
	    ReportRequest request = new ReportRequest()
	        .setViewId(viewId)
	        .setDateRanges(Arrays.asList(dateRange))
	        .setOrderBys(Arrays.asList(orderBy));
//	        .setSegments(Arrays.asList(segment));
	    
	    if(metrics != null && !metrics.isEmpty()){
	    	request.setMetrics(metricRequest);
	    }
	    
	    if(dimensions != null && !dimensions.isEmpty()){
	    	request.setDimensions(dimensionRequest);
	    }
//	    
//	    if(!metricFilter.isEmpty()){
//	    	// Create the MetricFilter object
//		    MetricFilter filterMetric = new MetricFilter()
//		    		.setMetricName(metricFilter)
//		    		.setOperator(Operators.EQUAL.toString())
//		    		.setComparisonValue(metricFilterValue);
//		    
//		    MetricFilterClause metricFilterClause = new MetricFilterClause()
//		    		.setFilters(Arrays.asList(filterMetric));
//		    
//		    request.setMetricFilterClauses(Arrays.asList(metricFilterClause));
//	    }
	    
//	    if(!dimensionFilter.isEmpty()){
//	    	// Create the Dimensions Filter object
//		    DimensionFilter filterDimension = new DimensionFilter()
//		    		.setDimensionName(dimensionFilter)
//		    		.setOperator(Operators.PARTIAL.toString())
//		    		.setExpressions(dimensionFilterValue);
//		    
//		    DimensionFilterClause dimensionFilterClause = new DimensionFilterClause()
//		    		.setFilters(Arrays.asList(filterDimension));
//		    
//		    request.setDimensionFilterClauses(Arrays.asList(dimensionFilterClause));
//	    }

	    System.out.println(request);
	    ArrayList<ReportRequest> requests = new ArrayList<ReportRequest>();
	    requests.add(request);

	    // Create the GetReportsRequest object.
	    GetReportsRequest getReport = new GetReportsRequest()
	        .setReportRequests(requests);

	    // Call the batchGet method.
	    GetReportsResponse response;
		try {
			response = builder.initializeAnalyticsReporting().reports().batchGet(getReport).execute();
			
			// Return the response.
			return response;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public GetReportsResponse getReportWithParams(List<ReportRequest> requests) throws IOException {
	    System.out.println("------------------------------------------------------------------------------");
//	    System.out.println(request);
//	    ArrayList<ReportRequest> requests = new ArrayList<ReportRequest>();
//	    requests.add(request);

	    // Create the GetReportsRequest object.
	    GetReportsRequest getReport = new GetReportsRequest()
	        .setReportRequests(requests);

	    // Call the batchGet method.
	    GetReportsResponse response = builder.initializeAnalyticsReporting().reports().batchGet(getReport).execute();

		// Return the response.
		return response;
	}

	public GaBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(GaBuilder builder) {
		this.builder = builder;
	}
}
