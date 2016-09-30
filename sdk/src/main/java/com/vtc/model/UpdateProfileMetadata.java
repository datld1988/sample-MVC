package com.vtc.model;

import java.io.Serializable;

public class UpdateProfileMetadata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mobile;
	private String fullName;
	private String address;
	private String clientIp;
	private String birthday;
	private Integer districtId;
	private Integer gender;
	private Integer locationId;
	private Integer wardId;
	public String getMobile() {
		return mobile;
	}
	public UpdateProfileMetadata setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	public String getFullName() {
		return fullName;
	}
	public UpdateProfileMetadata setFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public UpdateProfileMetadata setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getClientIp() {
		return clientIp;
	}
	public UpdateProfileMetadata setClientIp(String clientIp) {
		this.clientIp = clientIp;
		return this;
	}
	public String getBirthday() {
		return birthday;
	}
	public UpdateProfileMetadata setBirthday(String birthday) {
		this.birthday = birthday;
		return this;
	}
	public Integer getDistrictId() {
		return districtId;
	}
	public UpdateProfileMetadata setDistrictId(Integer districtId) {
		this.districtId = districtId;
		return this;
	}
	public Integer getGender() {
		return gender;
	}
	public UpdateProfileMetadata setGender(Integer gender) {
		this.gender = gender;
		return this;
	}
	public Integer getLocationId() {
		return locationId;
	}
	public UpdateProfileMetadata setLocationId(Integer locationId) {
		this.locationId = locationId;
		return this;
	}
	public Integer getWardId() {
		return wardId;
	}
	public UpdateProfileMetadata setWardId(Integer wardId) {
		this.wardId = wardId;
		return this;
	}
}
