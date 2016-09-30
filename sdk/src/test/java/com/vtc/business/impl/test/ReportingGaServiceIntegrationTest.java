package com.vtc.business.impl.test;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vtc.business.CommonUtils;
import com.vtc.business.impl.CommonUtilsImpl;
import com.vtc.business.impl.ReportingGaServiceImpl;
import com.vtc.config.ISysConfig;
import com.vtc.config.SysConfig;
import com.vtc.response.CmsQueryResponse;
import com.vtc.serviceproxy.GaBuilder;
import com.vtc.serviceproxy.GaReport;
import com.vtc.serviceproxy.impl.GaBuilderImpl;
import com.vtc.serviceproxy.impl.GaConfigurationImpl;
import com.vtc.serviceproxy.impl.GaReportImpl;
import com.vtc.serviceproxy.impl.LoadConfigImpl;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:/resources/config/server.properties"})
public class ReportingGaServiceIntegrationTest {
	
	private ReportingGaServiceImpl reportingGaService;
	private CommonUtilsImpl commonUtils;
	private GaReportImpl gaReport;
	private GaBuilderImpl gaBuilder;
	private GaConfigurationImpl configuration;
	private SysConfig sysConfig;
	private LoadConfigImpl config;
	
	@Before
	public void setUp() throws Exception {
		commonUtils = new CommonUtilsImpl();
		gaReport = new GaReportImpl();
		gaBuilder = new GaBuilderImpl();
		sysConfig = new SysConfig();
		configuration = new GaConfigurationImpl();
		config = new LoadConfigImpl();
		configuration.setConfig(config);
		gaBuilder.setConfiguration(configuration);
		gaReport.setBuilder(gaBuilder);
		
		reportingGaService = new ReportingGaServiceImpl();
		reportingGaService.setCommonUtils(commonUtils);
		reportingGaService.setGaBuilder(gaBuilder);
		reportingGaService.setGaReport(gaReport);
		reportingGaService.setSysConfig(sysConfig);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException {
		String gaViewId="125114781";
		String fromDate = "2016-07-01";
		String toDate = "2016-08-03";
		String osSystem = "";
		String campaign = "";
		String source = "";
		String medium = "";
		String filterChannel = "Campaign";
		List<CmsQueryResponse> response =  reportingGaService.getCMSQueryReport("", gaViewId, fromDate, toDate, osSystem, campaign, source, medium, filterChannel);
		
		System.out.println("");
	}

}
