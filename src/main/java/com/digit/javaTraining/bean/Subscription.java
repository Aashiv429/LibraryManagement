package com.digit.javaTraining.bean;

import java.util.ArrayList;



public class Subscription {
int invoice;
int sub_id;
int user_id;
int amount;
String date;
 
public Subscription() {
	
}

public Subscription(int sub_id, int user_id, int amount, int invoice, String date) {
	super();
	this.sub_id = sub_id;
	this.user_id = user_id;
	this.amount = amount;
	this.invoice = invoice;
	this.date = date;
}

public int getSub_id() {
	return sub_id;
}
public void setSub_id(int sub_id) {
	this.sub_id = sub_id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public int getInvoice() {
	return invoice;
}
public void setInvoice(int invoice) {
	this.invoice = invoice;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}

}

