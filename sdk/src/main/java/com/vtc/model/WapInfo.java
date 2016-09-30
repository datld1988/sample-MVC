package com.vtc.model;

import com.vtc.ws.v2.model.ResponseData;

public class WapInfo extends ResponseData {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String wapUrl;
	private String accountName;
	private Integer accountId;
	private Integer vcoin;
	private Integer vcoinFreeze;
	private Integer vcoinGame;
	
	public String getWapUrl() {
		return wapUrl;
	}
	public WapInfo setWapUrl(String wapUrl) {
		this.wapUrl = wapUrl;
		return this;
	}
	public String getAccountName() {
		return accountName;
	}
	public WapInfo setAccountName(String accountName) {
		this.accountName = accountName;
		return this;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public WapInfo setAccountId(Integer accountId) {
		this.accountId = accountId;
		return this;
	}
	public Integer getVcoin() {
		return vcoin;
	}
	public WapInfo setVcoin(Integer vcoin) {
		this.vcoin = vcoin;
		return this;
	}
	public Integer getVcoinFreeze() {
		return vcoinFreeze;
	}
	public WapInfo setVcoinFreeze(Integer vcoinFreeze) {
		this.vcoinFreeze = vcoinFreeze;
		return this;
	}
	public Integer getVcoinGame() {
		return vcoinGame;
	}
	public WapInfo setVcoinGame(Integer vcoinGame) {
		this.vcoinGame = vcoinGame;
		return this;
	}
}
