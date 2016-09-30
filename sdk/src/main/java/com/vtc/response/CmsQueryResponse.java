package com.vtc.response;

public class CmsQueryResponse {
	private String channel;
	
	private long install;
	
	private long nru;
	
	private long pu;
	
	private long revenue;

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public long getInstall() {
		return install;
	}

	public void setInstall(long install) {
		this.install = install;
	}

	public long getNru() {
		return nru;
	}

	public void setNru(long nru) {
		this.nru = nru;
	}

	public long getPu() {
		return pu;
	}

	public void setPu(long pu) {
		this.pu = pu;
	}

	public long getRevenue() {
		return revenue;
	}

	public void setRevenue(long revenue) {
		this.revenue = revenue;
	}
}
