package com.app.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.pojo.Admin;
import com.app.pojo.User;
import com.app.util.HibernateUtil;

public class AdminDao {
	public static boolean loginAdmin(String email, String password) {
		Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Query<Admin> query = session.createQuery("FROM Admin WHERE email = :email AND password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        Admin checkAdmin = query.uniqueResult();

        tx.commit();
        if (checkAdmin!=null)
        		return true;
        else
        		return false;
	}
	public static boolean changeUserPwd(String email,String oldPwd,String newPwd) {
		Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Query<Admin> query = session.createQuery("FROM Admin WHERE email = :email AND password = :password");
        query.setParameter("email", email);
        query.setParameter("password", oldPwd);
        Admin checkAdmin = query.uniqueResult();
        if (checkAdmin== null)
    	{
    	tx.rollback();
    	return false;
    	}
        else {
        Query q=session.createQuery("UPDATE Admin SET password=:password WHERE email=:email");
        q.setParameter("password",newPwd);
        q.setParameter("email", email);
        q.executeUpdate(); 
        tx.commit();
    	return true;
        }
	}
}
