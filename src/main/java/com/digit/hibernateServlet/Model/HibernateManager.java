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

import com.digit.javaTraining.bean.Admin;
import com.digit.javaTraining.bean.Book;

import com.digit.javaTraining.bean.PurchaseHistory;

import com.digit.javaTraining.bean.Subscription;
import com.digit.javaTraining.bean.User;



public class HibernateManager {
	public static Session session;
	private int secret_pin;

    private int id;

    private String upwd;

    private int uid;

    private int status;
	public HibernateManager() {

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

		ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());

		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());

		session = sessionFactory.openSession();

		System.out.println("Connected to pf..........");
	}
//REMOVE BOOK
	public void removeBook(int bid) {
		Transaction tran = session.beginTransaction();
		Book s = (Book) session.get(Book.class, bid); // value is based on Primary key

		session.delete(s);

		System.out.println("Delete Success");
		tran.commit();

	}
	//REMOVE USER
	public void removeUser(int user_id) {
		Transaction tran = session.beginTransaction();
		User s = (User) session.get(User.class, user_id); // value is based on Primary key

		session.delete(s);

		System.out.println("Delete Success");
		tran.commit();

	}

//PURCHASE 
	public boolean purchase(PurchaseHistory a1) {

		Transaction tran = session.beginTransaction();

		Serializable save = session.save(a1);

		tran.commit();

		System.out.println("object saved");
		if (save == null) {
			return false;
		}

		return true;

	}
//
	public boolean saveObj(Object object) {

        Transaction tran = session.beginTransaction();

        Serializable save = session.save(object);

        tran.commit();

        if (save != null) {

            return true;

        }

        return false;

    }
	
	
public boolean adminLogin(int admin_id) {

        

        try {

        Transaction tr= session.beginTransaction();

        Admin a= (Admin) session.get(Admin.class, admin_id);

        id= a.getAdmin_id();

        secret_pin=a.getSecret_pin();

        

        if(a.getAdmin_id()==id&& a.getSecret_pin()==secret_pin) {

            return true;

            

        }

 

        }catch(Exception e) {

            System.out.println("Invalid credentials");

        }

        return false;

 

}

    public boolean userLogin(int uids) {

        

        System.out.println(uids);

        

        try {

        Transaction tr= session.beginTransaction();

        User u= (User) session.get(User.class, uids);

        uid=u.getUser_id();

        upwd=u.getPwd();

        status=u.getStatus();

        

        if(u.getUser_id()==uid && u.getPwd()==upwd &&status==1) {

            return true;

            

        }

 

        }catch(Exception e) {

            e.printStackTrace();

            System.out.println("Invalid credentials");

        }

        return false;

        

        

    }
    
    
    public boolean authUsers(int user_id,int status) {

    	 

        Transaction transaction= session.beginTransaction();

 

        User ad=(User)session.get(User.class,user_id);

 

        ad.setStatus(status);

 

        session.update(ad);

 

        System.out.println("Update Success");

 

        transaction.commit();

 

        return true;

 

    }

    
    
public boolean authoriseBook(int bid,int status) {

        

        Transaction tran=session.beginTransaction();

        

        Book b=(Book) session.get(Book.class, bid);

        b.setStatus(status);

        session.update(b);

        System.out.println("Update success");

        tran.commit();

        return true;

 

    }


public ArrayList<Subscription> readAll() {

	ArrayList<Subscription> a = new ArrayList<Subscription>();
	Transaction trn = session.beginTransaction();
	Query q = session.createQuery("From Subscription");
	List list = q.list();
	Iterator itr = list.iterator();
	while (itr.hasNext()) {
		Subscription s = (Subscription) itr.next();
		int sub_id= s.getSub_id();
		int user_id = s.getUser_id();
		int amount = s.getAmount();
		int invoice = s.getInvoice();
		String date = s.getDate();
		Subscription sub = new Subscription(sub_id,user_id,amount,invoice,date);
		a.add(sub);
	}
	trn.commit();
	return a;
}

}

