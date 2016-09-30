package com.vtc.dataconstant;

public interface DataConstants {
	public Integer Zero = new Integer(0);
	public Integer One = new Integer(1);
	
	public String SandboxUriAppleVerify = "https://sandbox.itunes.apple.com/verifyReceipt";
	
	public String PrefixOrder = "OrderNo-";
	public String PartnerCode = "SDK";
	public String PaymentFromVTC = "VTC";
	public String BankCodeVTCPay = "VTCPay";
	
	public interface OrderStatus{
		public Integer Created = 1;
		public Integer Finished = 2;
		public Integer Deleted = -1;
	}
	
	public interface TypeInAppPurchase{
		public Integer Apple = 1;
		public Integer Google = 2;
	}
	
	public interface GooglePurchaseState{
		public Integer Purchased = 0;
		public Integer Cancelled = 1;
	}
	
	public interface GoogleConsumptionState{
		public Integer YetToBeConsumed = 0;
		public Integer Consumed = 1;
	}
	
	
	public enum AccountType{
		YAHOO(1, "YAHOO"),
		GOOGLE(2, "GOOGLE"),
		FB(3, "FB"),
		VTC(4, "VTC"),
		OTHER(5, "OTHER");
		
		private Integer value;
		private String display;
		
		AccountType(Integer value, String display){
			this.value = value;
			this.display = display;
		}
		
		public Integer getValue(){
			return value;
		}
		
		public String getDisplay(){
			return display;
		}
	}
	
	public interface Status{
		public Integer Activated = 1;
		public Integer Deactivated = -1;
	}
	
	public enum PackagePaymentType{
		ALL(1, "ALL"),
		VCOIN(2, "VCOIN"),
		IAP(3, "IAP");
		
		private Integer value;
		private String display;
		
		PackagePaymentType(Integer value, String display){
			this.value = value;
			this.display = display;
		}
		
		public Integer getValue(){
			return value;
		}
		
		public String getDisplay(){
			return display;
		}
	}
	
	public enum PackageType{
		NORMAL(1, "NORMAL"),
		MONTH_CARD(2, "MONTH_CARD");
		
		
		private Integer value;
		private String display;
		
		PackageType(Integer value, String display){
			this.value = value;
			this.display = display;
		}
		
		public Integer getValue(){
			return value;
		}
		
		public String getDisplay(){
			return display;
		}
	}
	public interface GamePaymentType{
		public String CARDGPC = "CARDGPC"; // The VinaPhone
		public String CARDVMS = "CARDVMS"; // The MobiFone
		public String CARDVTEL = "CARDVTEL"; // The Viettel
		public String CARDVNM = "CARDVNM"; // The VietnameMobile
		public String CARDVCOIN = "CARDVCOIN"; // The Vcoin
		public String BUYVCOIN = "BUYVCOIN"; // Vcoin trong tai khoan VTCID
		public String BUYVTCPAY = "BUYVTCPAY"; // Tien trong vi VTC Pay
		public String BUYBANK = "BUYBANK"; // Thanh toan tu ngan hang
		public String BUYIAP = "BUYIAP"; // Thanh toan tu InApp Purchase
	}
	
	public interface GamePaymentFunctionName{
		public String CREATE = "CREATE";
		public String UPDATE = "UPDATE";
	}
	
	public interface EventTypes{
		public String LoginByVTC = "LOGIN_VTC";
		public String LoginByYahoo = "LOGIN_YAHOO";
		public String LoginByGoogle = "LOGIN_GOOGLE";
		public String LoginByFB = "LOGIN_FB";
		public String RegisterByVTC = "REGISTER_VTC";
		public String RegisterByFB = "REGISTER_FB";
		public String RegisterByGoogle = "REGISTER_GOOGLE";
		public String RegisterByYahoo = "REGISTER_YAHOO";
		public String ReAuthen = "RE-AUTHEN";
		public String TopupByCard = "TOPUP_CARD";
		public String TopupByBank = "TOPUP_BANK";
		public String TopupByVtcPay = "TOPUP_VTCPAY";
		public String TopupByInAppPurchase = "TOPUP_INAPPPURCHASE";
		public String DeductVcoin = "DEDUCT_VCOIN";
		public String UpdateProfile = "UPDATE_PROFILE";
		public String RegisterAuthenSecure = "REGISTER_AUTHEN_SECURE";
		public String ChangePassword = "CHANGE_PASSWORD";
		public String ActiveSmsPlus = "ACTIVE_SMS_PLUS";
		public String RegisterSmsPlus = "REGISTER_SMS_PLUS";
		public String GamePaymentVcoinCreate = "GAME_PAYMENT_VCOIN_CREATE";
		public String GamePaymentVcoinUpdate = "GAME_PAYMENT_VCOIN_UPDATE";
		public String GamePaymentIAPCreate = "GAME_PAYMENT_IAP_CREATE";
		public String GamePaymentIAPUpdate = "GAME_PAYMENT_IAP_UPDATE";
		public String GamePaymentBankCreate = "GAME_PAYMENT_BANK_CREATE";
		public String GamePaymentBankUpdate = "GAME_PAYMENT_BANK_UPDATE";
		public String GamePaymentVtcPayCreate = "GAME_PAYMENT_VTCPAY_CREATE";
		public String GamePaymentVtcPayUpdate = "GAME_PAYMENT_VTCPAY_UPDATE";
		public String GamePaymentCardCreate = "GAME_PAYMENT_CARD_CREATE";
		public String GamePaymentCardUpdate = "GAME_PAYMENT_CARD_UPDATE";
		public String ResetPasswordBySecureCode = "RESET_PW_BY_SECURE_CODE";
		public String ResetPasswordByEmail = "RESET_PW_BY_EMAIL";
		public String CreateOrder = "CREATE_ORDER";
		public String VerifyMobile = "VERIFY_MOBILE";
		public String GetWapInfo = "GET_WAP_INFO";
	}
	
	public interface GaMappingValue{
		public String Install_EventCategoryVal = "inappEvent";
		public String Install_EventActionVal = "installed";
		
		public String Register_EventCategoryVal = "authen";
		public String Register_EventActionVal = "register";
		
		public String Payment_EventCategoryVal = "payment";
		public String Payment_EventActionVal = "ingame";
		public String Payment_EventLabelVal = "vcoin";
		
		public String AliasInstall = "installs";
		public String AliasNRU = "nrus";
		public String AliasPU = "pus";
		public String AliasRevenues = "revenues";
	}
	
	public enum ResponseCode{
		MISSING_CLIENT_ID(-301, "Missing ClientId"),
		MISSING_PARAMS(-302, "Missing parameter"),
		INVALID_TOKEN_OR_USERNAME(-303, "Invalid AccessToken or UserName"),
		ERROR_SYSTEM(-304, "Error Systems!!!!!"),
		NOT_EXISTED_ORDER(-305, "You must create order before payment"),
		INVALID_PAYMENT_IAP(-306, "Invalid payment of In-app Purchase"),
		INVALID_BILLING_ACCESSTOKEN(-307, "BillingAccessToken has expired"),
		ACCOUNT_NOT_FOUND(-308, "Account not found");
		
		private Integer value;
		private String display;
		
		ResponseCode(Integer value, String display){
			this.value = value;
			this.display = display;
		}
		
		public Integer getValue(){
			return value;
		}
		
		public String getDisplay(){
			return display;
		}
	}
	
	public enum ActivityTypes{
		FIRST_OPEN(1, "FIRST_OPEN"),
		OPEN(2,"OPEN_APP"),
		CLOSE_APP(3,"CLOSE_APP"),
		CRASH_APP(4,"CRASH_APP"),
		CLICK(5,"CLICK"),
		PAYMENT(6, "PAYMENT"),
		INSTALLED(7, "INSTALLED"),
		NOTFOUND(0, "");

		private Integer value;
		private String display;
		
		ActivityTypes(Integer value, String display) {
			this.value = value;
			this.display = display;
		}

		public Integer getValue() {
			return value;
		}

		public String getDisplay() {
			return display;
		}
	}
	
	public interface UtmParams{
		public String Utm_Campaign = "utm_campaign";
		public String Utm_Source = "utm_source";
		public String Utm_Medium = "utm_medium";
	}
	
	public interface FormattingTypes{
		public String Integer = "INTEGER";
		public String Float = "FLOAT";
		public String Currency = "CURRENCY";
		public String Percent = "PERCENT";
		public String Time = "TIME";
	}
	
	public interface BillingExceptionCode{
	}
	
	public interface RequestParams{
		public String AccessToken = "access_token";
		public String ClientId = "client_id";
		public String ClientSecret = "client_secret";
		public String ServiceId = "service_id";
		public String Grant_Type = "grant_type";
		public String UserName = "username";
		public String Time = "time";
		public String Otp = "otp";
		public String Otp_Check = "otp_check";
		public String AuthenType = "authen_type";
		public String DeviceType = "device_type";
		public String DeviceToken = "device_token";
		public String SecureCode = "secure_code";
		public String SecureType = "secure_type";
		public String Campaign = "campaign";
		public String Medium = "medium";
		public String Source = "source";
		public String Agency = "agency";
		public String ClientIp = "client_ip";
		public String GaTrackingId = "gatracking_id";
		public String GaClientId = "gaclient_id";
		public String EventCategory = "event_category";
		public String EventAction = "event_action";
		public String EventLabel = "event_label";
		public String AuthenSocial = "authen_social";
		public String HitType = "hit_type";
		public String Manufacture = "manufacture";
		public String ModelName = "model_name";
		public String OperatingSystem = "operating_system";
		public String OperatingSystemVersion = "operating_system_version";
		public String Package = "package_key";
		public String PackageType = "package_type";
		
		public String OAuthSystemId = "oauth_system_id";
		public String OAuthAccount = "oauth_account";
		public String IsAutoCreate = "auto_create";
		public String IsAutoAuthen = "auto_authen";
		public String IsDisableCheckSecure = "disable_check_secure";
		public String SignDisableSecure = "sign_disable_secure";
		
		public String ActivityType = "activity_type";
		public String AdsId = "ads_id";
		public String osType = "os_type";
	}

	/**
	 * Operation system type
	 * 
	 * @author CuongNH
	 */
	public enum OsType {
		IOS(1, "iOS"),
		ANDROID(2,"Android"),
		ALL(3,"All");

		private Integer value;
		private String display;
		
		OsType(Integer value, String display) {
			this.value = value;
			this.display = display;
		}

		public Integer getValue() {
			return value;
		}

		public String getDisplay() {
			return display;
		}
	}

	public enum SocialType{
		YAHOO(1, "Yahoo"),
		GOOGLE(2, "Google"),
		FACEBOOK(3, "Facebook");
		
		private Integer value;
		private String display;
		
		private SocialType(Integer value, String display){
			this.value = value;
			this.display = display;
		}
		
		public Integer getValue(){
			return value;
		}
		
		public String getDisplay(){
			return display;
		}
	}
	
	/**
	 * Marketing type
	 * @author CuongNH
	 */
	public enum MarketingType {
		FACEBOOK(1, "facebook"),
		GOOGLE(2,"google"),
		PROVIDER(3,"content_provider");

		private Integer code;
		private String display;

		MarketingType(Integer code, String display) {
			this.code = code;
			this.display = display;
		}

		public Integer getCode() {
			return code;
		}

		public String getDisplay() {
			return display;
		}
	}

	/**
	 * UTM type
	 * @author CuongNH
	 *
	 */
	public enum UTMType {
		UTM_CAMPAIGN(1, "UTM Campaign"),
		UTM_MEDIUM(2, "UTM Medium"),
		UTM_SOURCE(3, "UTM Source");

		private Integer code;
		private String display;

		UTMType(Integer code, String display) {
			this.code = code;
			this.display = display;
		}

		public Integer getCode() {
			return code;
		}

		public String getDisplay() {
			return display;
		}
	}

	/**
	 * Event type
	 * @author CuongNH
	 *
	 */
	public enum EventType {
		EVENT_CATEGORY(1, "Event Category"),
		EVENT_LABEL(2, "Event Label"),
		EVENT_ACTION(3, "Event Action"),
		EVENT_CAMPAGIN(4, "Event Campagin");

		private Integer code;
		private String display;

		EventType(Integer code, String display) {
			this.code = code;
			this.display = display;
		}

		public Integer getCode() {
			return code;
		}

		public String getDisplay() {
			return display;
		}
	}
}
