package com.meanlam.te.entity;

public class CommentType {
	
 private String uType;
 private int countsNum;
 
public int getCountsNum() {
	return countsNum;
}
public void setCountsNum(int countsNum) {
	this.countsNum = countsNum;
}
public String getuType() {
	return uType;
}
public void setuType(String uType) {
	this.uType = uType;
}
@Override
public String toString() {
	return "CommentType [uType=" + uType + ", countsNum=" + countsNum + "]";
}

}
