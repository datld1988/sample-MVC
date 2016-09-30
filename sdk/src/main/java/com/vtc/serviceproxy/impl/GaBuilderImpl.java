package com.vtc.serviceproxy.impl;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.services.analyticsreporting.v4.AnalyticsReporting;
import com.google.api.services.analyticsreporting.v4.AnalyticsReportingScopes;
import com.google.api.services.analyticsreporting.v4.model.CohortGroup;
import com.google.api.services.analyticsreporting.v4.model.DateRange;
import com.google.api.services.analyticsreporting.v4.model.Dimension;
import com.google.api.services.analyticsreporting.v4.model.DimensionFilter;
import com.google.api.services.analyticsreporting.v4.model.DimensionFilterClause;
import com.google.api.services.analyticsreporting.v4.model.DynamicSegment;
import com.google.api.services.analyticsreporting.v4.model.Metric;
import com.google.api.services.analyticsreporting.v4.model.MetricFilter;
import com.google.api.services.analyticsreporting.v4.model.MetricFilterClause;
import com.google.api.services.analyticsreporting.v4.model.OrFiltersForSegment;
import com.google.api.services.analyticsreporting.v4.model.OrderBy;
import com.google.api.services.analyticsreporting.v4.model.Pivot;
import com.google.api.services.analyticsreporting.v4.model.ReportRequest;
import com.google.api.services.analyticsreporting.v4.model.Segment;
import com.google.api.services.analyticsreporting.v4.model.SegmentDefinition;
import com.google.api.services.analyticsreporting.v4.model.SegmentDimensionFilter;
import com.google.api.services.analyticsreporting.v4.model.SegmentFilter;
import com.google.api.services.analyticsreporting.v4.model.SegmentFilterClause;
import com.google.api.services.analyticsreporting.v4.model.SegmentMetricFilter;
import com.google.api.services.analyticsreporting.v4.model.SegmentSequenceStep;
import com.google.api.services.analyticsreporting.v4.model.SequenceSegment;
import com.google.api.services.analyticsreporting.v4.model.SimpleSegment;
import com.vtc.aspect.Loggable;
import com.vtc.dataconstant.DataConstants;
import com.vtc.dataconstant.GaParams;
import com.vtc.serviceproxy.GaBuilder;
import com.vtc.serviceproxy.GaConfiguration;

public class GaBuilderImpl implements GaBuilder {

	@Autowired
	private GaConfiguration configuration;

	// public GaBuilderImpl(GaConfiguration configuration) {
	// this.configuration = configuration;
	// }

	@Override
	public AnalyticsReporting initializeAnalyticsReporting() {
		try {
			HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
			GoogleCredential credential = new GoogleCredential.Builder().setTransport(httpTransport)
					.setJsonFactory(configuration.GetJsonFactory())
					.setServiceAccountId(configuration.GetServiceAccountEmail())
					.setServiceAccountPrivateKeyFromP12File(new File(configuration.GetKeyFileLocation()))
					.setServiceAccountScopes(AnalyticsReportingScopes.all()).build();

			// Construct the Analytics Reporting service object.
			return new AnalyticsReporting.Builder(httpTransport, configuration.GetJsonFactory(), credential)
					.setApplicationName(configuration.GetApplicationName()).build();
		} catch (GeneralSecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getViewId() throws IOException {
		return configuration.GetViewId();
	}

	@Loggable
	@Override
	public byte[] getPostData(Map<String, String> map) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			sb.append(entry.getKey());
			sb.append('=');
			sb.append(entry.getValue());
			sb.append('&');
		}
		if (sb.length() > 0) {
			sb.setLength(sb.length() - 1); // Remove the trailing &.
		}

		return sb.toString().getBytes(StandardCharsets.UTF_8);
	}

	@Override
	public String encode(String value, boolean required) throws UnsupportedEncodingException {
		if (value == null) {
			if (required) {
				throw new IllegalArgumentException("Required parameter not set.");
			}
			return "";
		}

		return URLEncoder.encode(value, StandardCharsets.UTF_8.name());
	}

	@Override
	public String getContentType() throws IOException {
		return configuration.GetContentType();
	}

	@Override
	public String getEndpointSingle() throws IOException {
		return configuration.GetUrlEndpointSingle();
	}

	@Override
	public MetricFilterClause createMetricFilterClause(String fieldFilter, String operator, String value) {
		MetricFilter filterMetric = new MetricFilter().setMetricName(fieldFilter).setOperator(operator)
				.setComparisonValue(value);

		MetricFilterClause metricFilterClause = new MetricFilterClause().setFilters(Arrays.asList(filterMetric));

		return metricFilterClause;
	}

	@Override
	public DimensionFilterClause createDimensionFilterClause(String fieldFilter, String operator, List<String> values) {
		if (values == null || values.isEmpty()) {
			return null;
		}
		DimensionFilter filterDimension = new DimensionFilter().setDimensionName(fieldFilter).setOperator(operator)
				.setExpressions(values);

		DimensionFilterClause dimensionFilterClause = new DimensionFilterClause()
				.setFilters(Arrays.asList(filterDimension));

		return dimensionFilterClause;
	}

	@Override
	public OrderBy createOrderBy(String fieldName, String orderBy) {
		OrderBy order = new OrderBy().setFieldName(fieldName).setSortOrder(orderBy);

		return order;
	}

	@Override
	public Segment createSegment(String nameOfDymamicSegment, List<SegmentFilter> segmentFilters) {
		SegmentDefinition sessionSegment = new SegmentDefinition().setSegmentFilters(segmentFilters);

		DynamicSegment dynamicSegment = new DynamicSegment().setName(nameOfDymamicSegment)
				.setUserSegment(sessionSegment);

		Segment segment = new Segment().setDynamicSegment(dynamicSegment);

		return segment;
	}

	@Override
	public SegmentFilter createSegmentFilter(SimpleSegment simpleSegment, SequenceSegment sequenceSegment) {
		SegmentFilter segmentFilter = new SegmentFilter();
		if (simpleSegment != null) {
			segmentFilter.setSimpleSegment(simpleSegment);
		}

		if (sequenceSegment != null) {
			segmentFilter.setSequenceSegment(sequenceSegment);
		}

		return segmentFilter;
	}

	@Override
	public SimpleSegment createSimpleSegment(SegmentMetricFilter segmentMetricFilter,
			SegmentDimensionFilter segmentDimensionFilter) {
		SegmentFilterClause segmentFilterClauses = new SegmentFilterClause();

		if (segmentMetricFilter != null) {
			segmentFilterClauses.setMetricFilter(segmentMetricFilter);
		}

		if (segmentDimensionFilter != null) {
			segmentFilterClauses.setDimensionFilter(segmentDimensionFilter);
		}

		OrFiltersForSegment orFiltersForSegment = new OrFiltersForSegment()
				.setSegmentFilterClauses(Arrays.asList(segmentFilterClauses));

		SimpleSegment simpleSegment = new SimpleSegment().setOrFiltersForSegment(Arrays.asList(orFiltersForSegment));

		return simpleSegment;
	}

	@Override
	public SequenceSegment createSequenceSegment(SegmentMetricFilter segmentMetricFilter,
			SegmentDimensionFilter segmentDimensionFilter) {
		SegmentFilterClause segmentFilterClauses = new SegmentFilterClause();

		if (segmentMetricFilter != null) {
			segmentFilterClauses.setMetricFilter(segmentMetricFilter);
		}

		if (segmentDimensionFilter != null) {
			segmentFilterClauses.setDimensionFilter(segmentDimensionFilter);
		}

		OrFiltersForSegment orFiltersForSegment = new OrFiltersForSegment()
				.setSegmentFilterClauses(Arrays.asList(segmentFilterClauses));

		SegmentSequenceStep segmentSequenceStep = new SegmentSequenceStep()
				.setOrFiltersForSegment(Arrays.asList(orFiltersForSegment));

		SequenceSegment simpleSegment = new SequenceSegment()
				.setSegmentSequenceSteps(Arrays.asList(segmentSequenceStep));

		return simpleSegment;
	}

	@Override
	public SegmentMetricFilter createSegmentMetricFilter(String fieldMetricFilter, String operator, String value) {
		SegmentMetricFilter segmentMetricFilter = new SegmentMetricFilter().setMetricName(fieldMetricFilter)
				.setOperator(operator).setComparisonValue(value);

		return segmentMetricFilter;
	}

	@Override
	public SegmentDimensionFilter createSegmentDimensionFilter(String fieldDimensionFilter, String operator,
			List<String> values) {
		SegmentDimensionFilter segmentDimensionFilter = new SegmentDimensionFilter()
				.setDimensionName(fieldDimensionFilter).setOperator(operator).setExpressions(values);

		return segmentDimensionFilter;
	}

	/**
	 * Create a new pivot object
	 * 
	 * @param dimensions
	 * @param dimensionFilterClauses
	 * @param metrics
	 * @param maxGroupCount
	 * @param startGroup
	 * 
	 * @return pivot object
	 */
	@Override
	public Pivot createPivot(List<Dimension> dimensions, List<DimensionFilterClause> dimensionFilterClauses,
			List<Metric> metrics, Integer maxGroupCount, Integer startGroup) {
		// Set dimension and metric
		Pivot pivot = new Pivot().setDimensions(dimensions).setMetrics(metrics)
				.setDimensionFilterClauses(dimensionFilterClauses);
		// Set max group count
		if (maxGroupCount != null) {
			pivot.setMaxGroupCount(maxGroupCount);
		}
		// Set startGroup
		if (startGroup != null) {
			pivot.setStartGroup(startGroup);
		}
		return pivot;
	}

	public GaConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(GaConfiguration configuration) {
		this.configuration = configuration;
	}

	@Override
	public Metric createMetric(String metricName, String formattingType) {
		Metric metric = new Metric().setExpression(metricName)
				.setFormattingType(formattingType.isEmpty() ? DataConstants.FormattingTypes.Integer : formattingType);

		return metric;
	}
	
	@Override
	public Metric createMetricWithAlias(String metricName, String formattingType, String alias) {
		Metric metric = new Metric().setExpression(metricName)
				.setFormattingType(formattingType.isEmpty() ? DataConstants.FormattingTypes.Integer : formattingType)
				.setAlias(alias);

		return metric;
	}

	@Override
	public ReportRequest createReportRequest(String viewId, String fromDate, String toDate, List<Metric> metrics,
			List<MetricFilterClause> metricFilterClauses, List<String> dimensions,
			List<DimensionFilterClause> dimensionFilterClauses, List<OrderBy> orderBys, List<Segment> segments,
			List<Pivot> pivots, CohortGroup cohortGroup, String samplingLevel) {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		
		SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd");
	    DateRange dateRange = new DateRange();
	    dateRange.setStartDate(StringUtils.isEmpty(fromDate) ? ft.format(date) : fromDate);
	    dateRange.setEndDate(StringUtils.isEmpty(toDate) ? ft.format(date) : toDate);

	    List<Dimension> dimensionRequest = new ArrayList<>();
	    
	    if(dimensions != null && !dimensions.isEmpty()){
	    	dimensions.stream().forEach(item -> dimensionRequest.add(new Dimension().setName(item)));
	    }
	    
		ReportRequest request = new ReportRequest().setViewId(viewId).setDateRanges(Arrays.asList(dateRange));

		if (metrics != null && !metrics.isEmpty()) {
			request.setMetrics(metrics);
		}

		if (dimensions != null && !dimensions.isEmpty()) {
			request.setDimensions(dimensionRequest);
		}

		if (metricFilterClauses != null && !metricFilterClauses.isEmpty()) {
			request.setMetricFilterClauses(metricFilterClauses);
		}

		if (dimensionFilterClauses != null && !dimensionFilterClauses.isEmpty()) {
			request.setDimensionFilterClauses(dimensionFilterClauses);
		}

		if (orderBys != null && !orderBys.isEmpty()) {
			request.setOrderBys(orderBys);
		}

		if (segments != null && !segments.isEmpty()) {
			request.setSegments(segments);
		}

		// Set pivot object
		if (!CollectionUtils.isEmpty(pivots)) {
			request.setPivots(pivots);
		}

		if (cohortGroup != null) {
			request.setCohortGroup(cohortGroup);
		}

		if (samplingLevel != null && !samplingLevel.isEmpty()) {
			request.setSamplingLevel(samplingLevel);
		} else {
			request.setSamplingLevel(GaParams.SamplingLevel.DEFAULT);
		}
		
		return request;
	}
}
