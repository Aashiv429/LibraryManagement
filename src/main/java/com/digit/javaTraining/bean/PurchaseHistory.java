package com.digit.javaTraining.bean;

public class PurchaseHistory {
int pid;
int book_id;
String bname;
int user_id;
int amount;
int invoice;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public int getBook_id() {
	return book_id;
}
public void setBook_id(int book_id) {
	this.book_id = book_id;
}
public String getBname() {
	return bname;
}
public void setBname(String bname) {
	this.bname = bname;
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
public PurchaseHistory(int book_id, String bname, int user_id, int amount, int invoice) {
	super();
	this.book_id = book_id;
	this.bname = bname;
	this.user_id = user_id;
	this.amount = amount;
	this.invoice = invoice;
}
public PurchaseHistory() {
	super();
}

}