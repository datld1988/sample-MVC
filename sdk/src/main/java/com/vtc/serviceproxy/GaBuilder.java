package com.vtc.serviceproxy;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import com.google.api.services.analyticsreporting.v4.AnalyticsReporting;
import com.google.api.services.analyticsreporting.v4.model.CohortGroup;
import com.google.api.services.analyticsreporting.v4.model.Dimension;
import com.google.api.services.analyticsreporting.v4.model.DimensionFilterClause;
import com.google.api.services.analyticsreporting.v4.model.Metric;
import com.google.api.services.analyticsreporting.v4.model.MetricFilterClause;
import com.google.api.services.analyticsreporting.v4.model.OrderBy;
import com.google.api.services.analyticsreporting.v4.model.Pivot;
import com.google.api.services.analyticsreporting.v4.model.ReportRequest;
import com.google.api.services.analyticsreporting.v4.model.Segment;
import com.google.api.services.analyticsreporting.v4.model.SegmentDimensionFilter;
import com.google.api.services.analyticsreporting.v4.model.SegmentFilter;
import com.google.api.services.analyticsreporting.v4.model.SegmentMetricFilter;
import com.google.api.services.analyticsreporting.v4.model.SequenceSegment;
import com.google.api.services.analyticsreporting.v4.model.SimpleSegment;

public interface GaBuilder {
	AnalyticsReporting initializeAnalyticsReporting();

	String getViewId() throws IOException;

	byte[] getPostData(Map<String, String> map);

	String encode(String value, boolean required) throws UnsupportedEncodingException;

	String getContentType() throws IOException;

	String getEndpointSingle() throws IOException;

	MetricFilterClause createMetricFilterClause(String fieldFilter, String operator, String value);

	DimensionFilterClause createDimensionFilterClause(String fieldFilter, String operator, List<String> values);

	OrderBy createOrderBy(String fieldName, String orderBy);

	Segment createSegment(String nameOfDymamicSegment, List<SegmentFilter> segmentFilters);

	SegmentFilter createSegmentFilter(SimpleSegment simpleSegment, SequenceSegment sequenceSegment);
	
	SimpleSegment createSimpleSegment(SegmentMetricFilter segmentMetricFilter,
			SegmentDimensionFilter segmentDimensionFilter);

	SequenceSegment createSequenceSegment(SegmentMetricFilter segmentMetricFilter,
			SegmentDimensionFilter segmentDimensionFilter);

	SegmentMetricFilter createSegmentMetricFilter(String fieldMetricFilter, String operator, String value);

	SegmentDimensionFilter createSegmentDimensionFilter(String fieldDimensionFilter, String operator,
			List<String> values);

	Metric createMetric(String metricName, String formattingType);
	
	Metric createMetricWithAlias(String metricName, String formattingType, String alias);

	Pivot createPivot(List<Dimension> dimensions, List<DimensionFilterClause> dimensionFilterClauses,
			List<Metric> metrics, Integer maxGroupCount, Integer startGroup);
	
	ReportRequest createReportRequest(String viewId, String fromDate, String toDate, List<Metric> metrics,
			List<MetricFilterClause> metricFilterClauses, List<String> dimensions,
			List<DimensionFilterClause> dimensionFilterClauses, List<OrderBy> orderBys, List<Segment> segments,
			List<Pivot> pivots, CohortGroup cohortGroup, String samplingLevel);
}
