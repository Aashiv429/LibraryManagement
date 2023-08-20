package com.digit.javaTraining.bean;

import org.hibernate.Transaction;

import com.digit.hibernateServlet.Model.HibernateManager;

public class Book {
int bid;
String bname;
int user_id;
String author;
int cost;
String category;
int status;

public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
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
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}


public int getBookAmount(int bid) {
	HibernateManager hbm =  new HibernateManager();
	Transaction t = hbm.session.beginTransaction();
	Book p =(Book) hbm.session.get(Book.class,bid);
	t.commit();
	if(p==null || p.getStatus()==0) {
		return -1;
	}
	this.bid = p.getBid();
	this.bname = p.getBname();
	this.cost = p.getCost();
	return cost;
}

public String getBookName(int bid) {
	HibernateManager hbm =  new HibernateManager();
	Book p =(Book) hbm.session.get(Book.class,bid);
	this.bid = p.getBid();
	this.bname = p.getBname();
	this.cost = p.getCost();
	return bname;
}
}