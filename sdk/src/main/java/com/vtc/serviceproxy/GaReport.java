package com.vtc.serviceproxy;

import java.io.IOException;
import java.util.List;

import com.google.api.services.analyticsreporting.v4.model.CohortGroup;
import com.google.api.services.analyticsreporting.v4.model.DimensionFilterClause;
import com.google.api.services.analyticsreporting.v4.model.GetReportsResponse;
import com.google.api.services.analyticsreporting.v4.model.Metric;
import com.google.api.services.analyticsreporting.v4.model.MetricFilterClause;
import com.google.api.services.analyticsreporting.v4.model.OrderBy;
import com.google.api.services.analyticsreporting.v4.model.Pivot;
import com.google.api.services.analyticsreporting.v4.model.ReportRequest;
import com.google.api.services.analyticsreporting.v4.model.Segment;

public interface GaReport {
	GetReportsResponse getReport() throws IOException;

	GetReportsResponse getReportWithParam(String from, String to, String metric, String dimension, String view)
			throws IOException;

	GetReportsResponse getReportWithParams(String viewId, String fromDate, String toDate, List<String> metrics,
			String metricFilter, String metricFilterValue, List<String> dimensions, String dimensionFilter,
			List<String> dimensionFilterValue) throws IOException;

	GetReportsResponse getReportWithParams(List<ReportRequest> requests) throws IOException;
	
}
