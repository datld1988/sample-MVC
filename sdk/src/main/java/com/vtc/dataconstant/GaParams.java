package com.vtc.dataconstant;

public interface GaParams {
	public interface SamplingLevel{
		public String SMALL = "SMALL";
		public String LARGE = "LARGE";
		public String DEFAULT = "DEFAULT";
	}
	
	public interface OrderType{
		public String ORDER_TYPE_UNSPECIFIED = "ORDER_TYPE_UNSPECIFIED";
		public String VALUE = "VALUE";
		public String DELTA = "DELTA";
		public String SMART = "SMART";
		public String HISTOGRAM_BUCKET = "HISTOGRAM_BUCKET";
		public String DIMENSION_AS_INTEGER = "DIMENSION_AS_INTEGER";
	}
	
	public interface LogicalOperator{
		public String OPERATOR_UNSPECIFIED = "OPERATOR_UNSPECIFIED";
		public String OR = "OR";
		public String AND = "AND";
	}
	
	public interface Operator{
		public String OPERATOR_UNSPECIFIED = "OPERATOR_UNSPECIFIED";	// 
		public String REGEXP = "REGEXP";
		public String BEGINS_WITH = "BEGINS_WITH";
		public String ENDS_WITH = "ENDS_WITH";
		public String PARTIAL = "PARTIAL";
		public String EXACT = "EXACT";
		public String NUMERIC_EQUAL = "NUMERIC_EQUAL";
		public String NUMERIC_GREATER_THAN = "NUMERIC_GREATER_THAN";
		public String NUMERIC_LESS_THAN = "NUMERIC_LESS_THAN";
		public String IN_LIST = "IN_LIST";
		public String EQUAL = "EQUAL";
		public String LESS_THAN = "LESS_THAN";
		public String GREATER_THAN = "GREATER_THAN";
		public String IS_MISSING = "IS_MISSING";
	}
	
	public interface DateRange{
		public String OneWeekAgo = "7daysAgo";
		public String OneMonthAgo = "30daysAgo";
		public String Today = "today";
	}
	
	public interface Metric{
		public String Users = "ga:users";
		public String NewUsers = "ga:newUsers";
		public String PercentNewSessions = "ga:percentNewSessions";
		public String Sessions = "ga:sessions";
		public String _1DayUsers = "ga:1dayUsers";
		public String _7DayUsers = "ga:7dayUsers";
		public String _30DayUsers = "ga:30dayUsers";
		public String Bounces = "ga:bounces";
		public String BounceRate = "ga:bounceRate";
		public String SessionDuration = "ga:sessionDuration";
		public String AvgSessionDuration = "ga:avgSessionDuration";
		public String OrganicSearches = "ga:organicSearches";
		public String AdClick = "ga:adClicks";
		public String PageView = "ga:pageviews";
		public String PageViewPerSession = "ga:pageviewPerSession";
		public String TOTAL_EVENTS = "ga:totalEvents";
		public String UNIQUE_EVENTS = "ga:uniqueEvents";
		public String EVENT_VALUE = "ga:eventValue";
		public String TRANSACTION_REVENUE = "ga:transactionRevenue";
		public String REVENUE_PER_USER = "ga:revenuePerUser";
	}
	
	public interface Dimension{
		public String UserType = "ga:userType";
		public String ReferralPath = "ga:referralPath";
		public String FullReferrer = "ga:fullReferrer";
		public String Campaign = "ga:campaign";
		public String Source = "ga:source";
		public String Medium = "ga:medium";
		public String SourceMedium = "ga:sourceMedium";
		public String AdContent = "ga:adContent";
		public String SocialNetwork = "ga:socialNetwork";
		public String HasSocialSourceReferral = "ga:hasSocialSourceReferral";
		public String CampaignCode = "ga:campaignCode";
		public String Continent = "ga:continent";
		public String Country = "ga:country";
		public String Date = "ga:date";
		public String OPERATING_SYSTEM = "ga:operatingSystem";
		public String EVENT_CATEGORY = "ga:eventCategory";
		public String EVENT_ACTION = "ga:eventAction";
		public String EVENT_LABEL = "ga:eventLabel";
		public String SEGMENT = "ga:segment";
		public String DEVICE_CATEGORY = "ga:deviceCategory";
		public String MOBILE_DEVICE_BRANDING = "ga:mobileDeviceBranding";
		public String SCREEN_RESOLUTION = "ga:screenResolution";
	}
	
	public interface ParamTracking{
		public String Version = "v";
		public String TrackingId = "tid";
		public String ClientId = "cid";
		public String EventHitType = "t";
		public String Category = "ec";
		public String Action = "ea";
		public String Label = "el";
		public String Value = "ev";
		public String CampaignName = "cn";
		public String CampaignSource = "cs";
		public String CampaignMedium = "cm";
		public String AnonymizeIp = "aip";
		public String DataSource = "ds";
		public String QueueTime = "qt";
		public String TransactionId = "ti";
		public String TransactionRevenue = "tr";
	}
	
	public static final String Sessions = "sessions";
	
	public interface TypeEventHit{
		public String Pageview = "pageview";
		public String Screenview = "screenview";
		public String Event = "event";
		public String Transaction = "transaction";
		public String Item = "item";
		public String Social = "social";
		public String Exception = "exception";
		public String Timing = "timing";
	}
	
}
