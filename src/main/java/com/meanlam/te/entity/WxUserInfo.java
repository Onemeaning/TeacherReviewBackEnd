package com.meanlam.te.entity;

public class WxUserInfo {
	private String uWxid;//维信id
	private String uPhoto;//微信用户照片
	private String uNickname;//微信用户昵称
	
	private String uCountry;//用户所在国家
	private String uCity;//用户所在城市
	private String uProvince;//用户所在省份
	private String uGender;//用户性别
	
	
	public String getuCountry() {
		return uCountry;
	}

	public void setuCountry(String uCountry) {
		this.uCountry = uCountry;
	}

	public String getuCity() {
		return uCity;
	}

	public void setuCity(String uCity) {
		this.uCity = uCity;
	}

	public String getuProvince() {
		return uProvince;
	}

	public void setuProvince(String uProvince) {
		this.uProvince = uProvince;
	}

	public String getuGender() {
		return uGender;
	}

	public void setuGender(String uGender) {
		this.uGender = uGender;
	}

	public String getuWxid() {
		return uWxid;
	}

	public void setuWxid(String uWxid) {
		this.uWxid = uWxid;
	}

	public String getuPhoto() {
		return uPhoto;
	}

	public void setuPhoto(String uPhoto) {
		this.uPhoto = uPhoto;
	}

	public String getuNickname() {
		return uNickname;
	}

	public void setuNickname(String uNickname) {
		this.uNickname = uNickname;
	}

	@Override
	public String toString() {
		return "WxUserInfo [uWxid=" + uWxid + ", uPhoto=" + uPhoto + ", uNickname=" + uNickname + ", uCountry="
				+ uCountry + ", uCity=" + uCity + ", uProvince=" + uProvince + ", uGender=" + uGender + "]";
	}

	

}
