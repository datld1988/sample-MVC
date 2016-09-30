package com.vtc.business.impl.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.SortOrder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.google.api.services.analyticsreporting.v4.model.DimensionFilter;
import com.google.api.services.analyticsreporting.v4.model.DimensionFilterClause;
import com.google.api.services.analyticsreporting.v4.model.GetReportsResponse;
import com.google.api.services.analyticsreporting.v4.model.Metric;
import com.google.api.services.analyticsreporting.v4.model.OrderBy;
import com.google.api.services.analyticsreporting.v4.model.Report;
import com.google.api.services.analyticsreporting.v4.model.ReportData;
import com.google.api.services.analyticsreporting.v4.model.ReportRequest;
import com.vtc.business.impl.ReportingGaServiceImpl;
import com.vtc.dataconstant.DataConstants;
import com.vtc.dataconstant.GaParams;
import com.vtc.serviceproxy.GaBuilder;
import com.vtc.serviceproxy.GaReport;
import com.vtc.serviceproxy.impl.GaBuilderImpl;


public class ReportingGaServiceTest {
	
	@InjectMocks
	private ReportingGaServiceImpl service;
	
	@Mock
	private GaReport gaReport;
	
	@Spy
	private GaBuilder gaBuilder=new GaBuilderImpl();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException {
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
		
//		Mockito.when(gaBuilder.createOrderBy(Mockito.anyString(), Mockito.anyString())).thenReturn(orderBy);
		List<OrderBy> orderBys = Arrays.asList(orderBy);
		System.out.println(orderBys);
		System.out.println(filterClause);
//		Mockito.when(gaBuilder.createDimensionFilterClause(Mockito.anyString(), Mockito.anyString(), Mockito.anyList())).thenReturn(filterClause);
		System.out.println("viewId: " + viewId);
		System.out.println("fromDate: " + fromDate);
		System.out.println("toDate: " + toDate);
		System.out.println("metrics: " + metrics);
		System.out.println("dimensions: " + dimensions);
		System.out.println("Arrays.asList(filterClause): " + Arrays.asList(filterClause));
		System.out.println("orderBys: " + orderBys);
		ReportRequest request = gaBuilder.createReportRequest(viewId, fromDate, toDate, metrics, null, dimensions, Arrays.asList(filterClause), orderBys, null, null, null, null);
		Mockito.when(gaReport.getReportWithParams(Arrays.asList(request))).thenReturn(dummyResponse);
		GetReportsResponse response = service.reportCampaign(viewId, fromDate, toDate, Arrays.asList("Test"));
		
		System.out.println(response);
		Mockito.verify(gaBuilder, Mockito.times(1)).createOrderBy(GaParams.Dimension.Campaign, SortOrder.ASCENDING.toString());
		Mockito.verify(gaBuilder, Mockito.times(1)).createDimensionFilterClause(GaParams.Dimension.Campaign, GaParams.Operator.EXACT, Arrays.asList("Test"));
		Assert.assertNotNull(service);
	}

}
