package com.vtc.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.api.services.analyticsreporting.v4.model.ColumnHeader;
import com.google.api.services.analyticsreporting.v4.model.DateRangeValues;
import com.google.api.services.analyticsreporting.v4.model.GetReportsResponse;
import com.google.api.services.analyticsreporting.v4.model.MetricHeaderEntry;
import com.google.api.services.analyticsreporting.v4.model.Report;
import com.google.api.services.analyticsreporting.v4.model.ReportRow;
import com.vtc.mongorepository.EventsRepository;
import com.vtc.mongorepository.AccountRepository;
import com.vtc.response.ResponseModel;
import com.vtc.serviceproxy.GaReport;

@Controller
public class PaymentTransactionController {
	private static final Logger log = Logger.getLogger(PaymentTransactionController.class);
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private EventsRepository eventsRepository;
	
	@Autowired
	private GaReport gaReport;
	
	@RequestMapping(value = "/tracker/pu", method = RequestMethod.POST)
	@ResponseBody
	public ResponseModel PaymentUserTracker(
			@RequestParam(value="device_id", required=true, defaultValue="") String deviceId,
			@RequestParam(value="mobile", required=false, defaultValue="") String mobile,
			@RequestParam(value="password", required=false, defaultValue="") String password,
			@RequestParam(value="fullname", required=false, defaultValue="") String fullname){
		return null;
	}
	
	private String printResponse(GetReportsResponse response) {
		StringBuilder builder = new StringBuilder();
		for (Report report : response.getReports()) {
			ColumnHeader header = report.getColumnHeader();
			List<String> dimensionHeaders = header.getDimensions();
			List<MetricHeaderEntry> metricHeaders = header.getMetricHeader().getMetricHeaderEntries();
			List<ReportRow> rows = report.getData().getRows();

			if (rows == null) {
				return "No data found for ";
			}

			for (ReportRow row : rows) {
				List<String> dimensions = row.getDimensions();
				List<DateRangeValues> metrics = row.getMetrics();
				for (int i = 0; i < dimensionHeaders.size() && i < dimensions.size(); i++) {
					builder.append(" \n ");
					builder.append(dimensionHeaders.get(i));
					builder.append(": ");
					builder.append(dimensions.get(i));
				}

				for (int j = 0; j < metrics.size(); j++) {
					builder.append(" \n ");
					builder.append("Date Range (");
					builder.append(j);
					builder.append("): ");
					
					DateRangeValues values = metrics.get(j);
					for (int k = 0; k < values.size() && k < metricHeaders.size(); k++) {
						builder.append(metricHeaders.get(k).getName());
						builder.append(": ");
						builder.append(values.get(k));
					}
					
					builder.append(" \n ");
					builder.append("Value: ");
					builder.append(values.getValues().get(0));
				}
			}
		}
		return builder.toString();
	}
	
	@RequestMapping(value = "/tracker/ga", method = RequestMethod.POST)
	@ResponseBody
	public ResponseModel CallGa(
			@RequestParam(value="from", required=true, defaultValue="") String from,
			@RequestParam(value="to", required=true, defaultValue="") String to,
			@RequestParam(value="metric", required=true, defaultValue="") String metric,
			@RequestParam(value="dimension", required=true, defaultValue="") String dimension,
			@RequestParam(value="view", required=true, defaultValue="") String view){
		ResponseModel response = new ResponseModel();
		try {
			GetReportsResponse report = gaReport.getReportWithParam(from, to, metric, dimension, view);
			response.setInfo(report);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
}
