package com.vtc.util;

public interface PConstants {
	public interface RESPONSE {
		public int CODE_SUCCESS = 200;
		public int CODE_ERROR = 201;
		public String MESS_SUCCESS = "Success";
		public String MESS_LOGIN_SUCCESS = "Login success";
		public String MESS_REGISTER_SUCCESS = "Register success";
		public String MESS_DUPLICATE_USER_NAME = "Duplicate user name";
		public String MESS_SYSTEM = "Error system";
	}
	public interface USER {
		public int ACTIVE = 1;
	}

	public interface SDK {
		public String GC_ID = "GC_ID";
	}


	public interface TYPE_OS {
		public int ANDROID = 0;;
		public int IOS = 1;;
	}
	
	public interface ERROR_CODE {
//		-33: Tài khoản chưa kích hoạt
//		-48: Tài khoản bị khóa
//		-49: Tài khoản không hoạt động
//		-50: Tài khoản không tồn tại
//		-53: Mật khẩu không đúng
//		-99: Lỗi hệ thống
//		-100: Mã dịch vụ không hợp lệ
//		-600: Dữ liệu đầu vào không hợp lệ hoặc để trống
//		-1000: Có sử dụng bảo mật đăng nhập, yêu cầu xác thực
//		-1001: Mã bảo mật không chính xác
		public int INACTIVE = -33;
		public int BLOCK = -48;
		public int INACTION = -49;
		public int NOTEXIST = -50;
		public int WRONGPASSWORD = -53;
		public int SYSTEM_ERROR = -99;
		public int SERVICE_INVALID = -100;
		public int INPUT_ERROR = -600;
		public int OTP_REQUIRE = -1000;
		public int OTP_WRONG = -1001;
		
	}
	public interface BILLING {
		public int AUTHEN_TYPE_NORMAL = 0;
		public int DEVICE_TYPE_WEB = 1;
		// 1:thông thường;2: đk nhanh; 3: chơi ngay; 4: đk gắn kết Facebook; 5: đk gắn kết Google; 6: đk gắn kết Yahoo
		public int REGISTER_TYPE_NORMAL = 1;
		public int REGISTER_TYPE_FAST = 2;
		public int REGISTER_TYPE_PLAY = 3;
		public int REGISTER_TYPE_FACEBOOK = 4;
		public int REGISTER_TYPE_GOOGLE = 5;
		public int REGISTER_TYPE_YAHOO = 6;
	}
	public interface LOGIN_TYPE {
		public int EMAIL = 0;
		public int PHONE = 1;
	}
	public interface USER_STATUS {
		public int INACTIVE = 0;
		public int ACTIVE = 1;
	}
	public interface BACKUP_STATUS {
		public int RUN = 1;
		public int STOP = 0;
	}
	public interface HOST_STATUS {
		public int USER = 0;
		public int HOST = 1;
	}

	public interface HTTP_STATUS {
		public int OK = 200;
		public int UNAUTHORIZED = 400;
		public int BAD_REQUEST = 401;
	}
	public interface EMAIL {
		public String RESET_PASSWORD = "password.reset";
		public String SUBJECT_RESET = "password.subject";
		public int NUMBER_PINCODE = 4;
	}

	public interface ACCOUNT {
		public interface DEDUCE {
			public String SERVICE_ID = "account.deduce.service.id";
			public String SERVICE_KEY = "account.deduce.service.key";
		}
		public interface TOPUP {
			public String SERVICE_ID = "account.topup.service.id";
			public String SERVICE_KEY = "account.topup.service.key";
		}
	}
}
