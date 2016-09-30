package com.vtc.model;

import java.io.Serializable;

/**
 * Balance Model. transfer to client
 * 
 * 
 * @author xuanbach
 *
 */
public class BalanceModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer accountId;
	private String userName;
	private String fullName;
	private Integer vcoin;
	private Integer vcoinPayment;
	private Long sao;
	private Long xu;
	private Long responseStatus;
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Integer getVcoin() {
		return vcoin;
	}
	public void setVcoin(Integer vcoin) {
		this.vcoin = vcoin;
	}
	public Integer getVcoinPayment() {
		return vcoinPayment;
	}
	public void setVcoinPayment(Integer vcoinPayment) {
		this.vcoinPayment = vcoinPayment;
	}
	public Long getSao() {
		return sao;
	}
	public void setSao(Long sao) {
		this.sao = sao;
	}
	public Long getXu() {
		return xu;
	}
	public void setXu(Long xu) {
		this.xu = xu;
	}
	public Long getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(Long responseStatus) {
		this.responseStatus = responseStatus;
	}
	@Override
	public String toString() {
		return new StringBuffer("BalanceModel [accountId=").append(accountId).append(", userName=").append(userName).append(", fullName=").append(fullName).append(", vcoin="
				+ vcoin).append(", vcoinPayment=").append(vcoinPayment).append(", sao=").append(sao).append(", xu=").append(xu).append(", responseStatus="
				+ responseStatus).append("]").toString();
	}

}
