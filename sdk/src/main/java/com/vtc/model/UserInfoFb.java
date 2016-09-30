package com.vtc.model;


import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfoFb {

	/**
	 * The user's email address. The value may be {@code null}.
	 */
	@JsonProperty("email")
	private java.lang.String email;

	/**
	 * The user's last name. The value may be {@code null}.
	 */
	private java.lang.String last_name;

	/**
	 * The user's gender. The value may be {@code null}.
	 */
	private java.lang.String gender;

	/**
	 * The user's first name. The value may be {@code null}.
	 */
	private java.lang.String first_name;

	/**
	 * The obfuscated ID of the user. The value may be {@code null}.
	 */
	@JsonProperty("id")
	private java.lang.String id;

	/**
	 * URL of the profile page. The value may be {@code null}.
	 */
	@JsonProperty("link")
	private java.lang.String link;

	/**
	 * The user's preferred locale. The value may be {@code null}.
	 */
	private java.lang.String locale;

	/**
	 * The user's full name. The value may be {@code null}.
	 */
	@JsonProperty("name")
	private java.lang.String name;

	/**
	 * URL of the user's picture image. The value may be {@code null}.
	 */
	private java.lang.String picture;

	/**
	 * Boolean flag which is true if the email address is verified. Always
	 * verified because we only return the user's primary email address. The
	 * value may be {@code null}.
	 */
	private java.lang.Boolean verified;

	@JsonProperty("ids_for_business")
	private IdsForBusiness ids_for_business;
	
	@JsonProperty("error")
	private FbError error;

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getLastName() {
		return last_name;
	}

	public void setLastName(java.lang.String last_name) {
		this.last_name = last_name;
	}

	public java.lang.String getGender() {
		return gender;
	}

	public void setGender(java.lang.String gender) {
		this.gender = gender;
	}

	public java.lang.String getFirstName() {
		return first_name;
	}

	public void setFirstName(java.lang.String first_name) {
		this.first_name = first_name;
	}

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getLink() {
		return link;
	}

	public void setLink(java.lang.String link) {
		this.link = link;
	}

	public java.lang.String getLocale() {
		return locale;
	}

	public void setLocale(java.lang.String locale) {
		this.locale = locale;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getPicture() {
		return picture;
	}

	public void setPicture(java.lang.String picture) {
		this.picture = picture;
	}

	public java.lang.Boolean getVerified() {
		return verified;
	}

	public void setVerified(java.lang.Boolean verified) {
		this.verified = verified;
	}

	public IdsForBusiness getIdsForBusiness() {
		return ids_for_business;
	}

	public void setIdsForBusiness(IdsForBusiness ids_for_business) {
		this.ids_for_business = ids_for_business;
	}
	
	public FbError getError() {
		return error;
	}

	public void setError(FbError error) {
		this.error = error;
	}

	public String toString() {
		ObjectMapper objectMapper = new ObjectMapper();//.writer().withDefaultPrettyPrinter();
		try {
			return objectMapper.writeValueAsString(this);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
