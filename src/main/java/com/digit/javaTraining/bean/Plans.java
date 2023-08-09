package com.digit.javaTraining.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class Plans {
	int Sub_id;
	String plan;
	int amount;
	private Session session;

	public Plans() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());
		session = sessionFactory.openSession();
		System.out.println("Connected");
	}

	public Plans(int sub_id, String plan, int amount) {
		super();
		Sub_id = sub_id;
		this.plan = plan;
		this.amount = amount;
	}

	public int getSub_id() {
		return Sub_id;
	}

	public void setSub_id(int sub_id) {
		Sub_id = sub_id;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public ArrayList<Plans> readAll() {

		ArrayList<Plans> a = new ArrayList<Plans>();
		Transaction trn = session.beginTransaction();
		Query q = session.createQuery("From Plans");
		List list = q.list();
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			Plans s = (Plans) itr.next();
			this.Sub_id = s.getSub_id();
			this.plan = s.getPlan();
			this.amount = s.getAmount();
			a.add(s);
		}
		trn.commit();
		return a;
	}
}