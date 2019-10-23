package com.pojo;

import java.util.Date;

public class TransactionRecord {
private int id;
private String cardNo;
private Date transactionDate;
private float transactionAmount;
private float balance;
private String transactionType;
private String remark;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCardNo() {
	return cardNo;
}
public void setCardNo(String cardNo) {
	this.cardNo = cardNo;
}
public Date getTransactionDate() {
	return transactionDate;
}
public void setTransactionDate(Date transactionDate) {
	this.transactionDate = transactionDate;
}
public float getTransactionAmount() {
	return transactionAmount;
}
public void setTransactionAmount(float transactionAmount) {
	this.transactionAmount = transactionAmount;
}
public float getBalance() {
	return balance;
}
public void setBalance(float balance) {
	this.balance = balance;
}
public String getTransactionType() {
	return transactionType;
}
public void setTransactionType(String transactionType) {
	this.transactionType = transactionType;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
}
