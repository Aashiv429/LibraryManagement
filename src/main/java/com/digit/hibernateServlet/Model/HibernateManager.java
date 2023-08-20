package com.digit.hibernateServlet.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.digit.javaTraining.bean.Bank;
import com.digit.javaTraining.bean.Book;
import com.digit.javaTraining.bean.Plans;
import com.digit.javaTraining.bean.PurchaseHistory;

import com.digit.javaTraining.bean.Subscription;
import com.digit.javaTraining.bean.User;

public class HibernateManager {
	public static Session session;

	public HibernateManager() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());
		session = sessionFactory.openSession();
		System.out.println("Connected to pf..........");
	}  
	
	public boolean removeBook(int bid) {
		Transaction t = session.beginTransaction();
		Book b = (Book) session.get(Book.class, bid); 
		if (b != null) {
			b.setStatus(0);
			session.update(b);
			t.commit();
			return true;
		} else {
			t.commit();
			return false;
		}
	}

	public boolean removeUser(int user_id) {
		Transaction t = session.beginTransaction();
		User u = (User) session.get(User.class, user_id); 
		if (u != null) {
			u.setStatus(0);
			session.update(u);
			t.commit();
			return true;
		} else {
			t.commit();
			return false;
		}
	}

	public boolean saveObj(Object object) {
		Transaction t = session.beginTransaction();
		Serializable save = session.save(object);
		t.commit();
		if (save != null) {
			return true;
		}
		return false;
	}

	public boolean Adminlogin(int adminID, int password) {
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("FROM Admin where admin_id=:aid and secret_pin=:apin");
		q.setInteger("aid", adminID);
		q.setInteger("apin", password);
		List l = q.list();
		t.commit();
		if (l.isEmpty()) {
			return false;
		}
		return true;
	}

	public static boolean Banklogin(int bid, int pin) {
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("FROM Bank where bank_id=:id and pin=:pin");
		q.setInteger("id", bid);
		q.setInteger("pin", pin);
		List l = q.list();
		t.commit();
		if (l.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean userLogin(int uids, String pwd) {
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("FROM User where user_id=:uid and pwd=:pwd and status=:status");
		q.setInteger("status", 1);
		q.setInteger("uid", uids);
		q.setString("pwd", pwd);
		List l = q.list();
		t.commit();
		if (l.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean authUsers(int user_id, int status) {
		Transaction t = session.beginTransaction();
		User au = (User) session.get(User.class, user_id);
		if (au != null) {
			au.setStatus(status);
			session.update(au);
			t.commit();
			return true;
		} else {
			t.commit();
			return false;
		}
	}

	public void updateAmount(int user_id, int amount) {
		Transaction t = session.beginTransaction();
		Bank b = (Bank) session.get(Bank.class, user_id);
		b.setAmount(amount);
		session.update(b);
		t.commit();
	}

	public boolean authoriseBook(int bid, int status) {
		Transaction t = session.beginTransaction();
		Book b = (Book) session.get(Book.class, bid);
		if (b != null) {
			b.setStatus(status);
			session.update(b);
			t.commit();
			return true;
		} else {
			t.commit();
			return false;
		}
	}

//	public static ArrayList<Subscription> readAll() {
//		ArrayList<Subscription> a = new ArrayList<Subscription>();
//		Transaction t = session.beginTransaction();
//		Query q = session.createQuery("From Subscription");
//		
//		List list = q.list();
//		Iterator itr = list.iterator();
//		while (itr.hasNext()) {
//			Subscription s = (Subscription) itr.next();
//			int sub_id = s.getSub_id();
//			int user_id = s.getUser_id();
//			int amount = s.getAmount();
//			int invoice = s.getInvoice();
//			String date = s.getDate();
//			Subscription sub = new Subscription(sub_id, user_id, amount, invoice, date);
//			a.add(sub);
//		}
//		t.commit();
//		return a;
//	}

	public static int generateRandomInvoiceNumber() {
		int curGenNum = 0;
		curGenNum = (int) (Math.random() * (99999 - 1000) + 10000);
		return curGenNum;
	}

	public static ArrayList<Subscription> getAllSubscriptions() {
		ArrayList<Subscription> ViewAllSubscriptions = new ArrayList<Subscription>();
		Transaction t = session.beginTransaction();
		Query ListQuery = session.createQuery("FROM Subscription");
		List list = ListQuery.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Subscription currSub = (Subscription) it.next();
			ViewAllSubscriptions.add(currSub);
		}
		t.commit();
		return ViewAllSubscriptions;
	}

	public static ArrayList<Book> getAllBooks() {
		ArrayList<Book> ViewAllBook = new ArrayList<Book>();
		Transaction t = session.beginTransaction();
		Query ListQuery = session.createQuery("FROM Book");
		List list = ListQuery.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Book currBook = (Book) it.next();
			ViewAllBook.add(currBook);
		}
		t.commit();
		return ViewAllBook;
	}

	public static ArrayList<User> getAllUser() {
		ArrayList<User> ViewAllUser = new ArrayList<User>();
		Transaction t = session.beginTransaction();
		Query ListQuery = session.createQuery("FROM User");
		List list = ListQuery.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			User currUser = (User) it.next();
			ViewAllUser.add(currUser);
		}
		t.commit();
		return ViewAllUser;
	}

	public static ArrayList<PurchaseHistory> getAllPurchasesHistory() {
		ArrayList<PurchaseHistory> allPurchaseHistory = new ArrayList<PurchaseHistory>();
		Transaction t = session.beginTransaction();
		Query allList = session.createQuery("FROM PurchaseHistory");
		List list = allList.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			PurchaseHistory curSub = (PurchaseHistory) it.next();
			allPurchaseHistory.add(curSub);
		}
		t.commit();
		return allPurchaseHistory;
	}
}