package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.pojo.Question;
import com.app.pojo.User;
import com.app.util.HibernateUtil;

public class UserDao {
	public static boolean addUser(String email, String name, String password) {
		Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Query<User> query = session.createQuery("FROM User WHERE email = :email");
        query.setParameter("email", email);
        User checkUser = query.uniqueResult();
        

        if (checkUser!= null)
        	{
        	tx.rollback();
        	return false;
        	}
        else {
        	User user=new User();
        	user.setName(name);
            user.setEmail(email);
            user.setPassword(password);  
            session.persist(user);

            tx.commit();
        	return true;
        }
        	
	}
	public static boolean loginUser(String email, String password) {
		Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Query<User> query = session.createQuery("FROM User WHERE email = :email AND password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        User checkUser = query.uniqueResult();

        tx.commit();
        if (checkUser!=null)
        		return true;
        else
        		return false;
	}
	public static boolean changeUserPwd(String email,String oldPwd,String newPwd) {
		Session session = HibernateUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Query<User> query = session.createQuery("FROM User WHERE email = :email AND password = :password");
        query.setParameter("email", email);
        query.setParameter("password", oldPwd);
        User checkUser = query.uniqueResult();
        if (checkUser== null)
    	{
    	tx.rollback();
    	return false;
    	}
        else {
        Query q=session.createQuery("UPDATE User SET password=:password WHERE email=:email");
        q.setParameter("password",newPwd);
        q.setParameter("email", email);
        q.executeUpdate(); 
        tx.commit();
    	return true;
        }
	}
    public static List<User> getAllUsers() {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = null;
        List<User> users = null;
        
        try {
            transaction = session.beginTransaction();
            Query<User> query = session.createQuery("FROM User", User.class);
            users = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return users;
    }

    public static User getUserById(String id) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = null;
        User user = null;
        
        try {
            transaction = session.beginTransaction();
            user = session.get(User.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return user;
    }

    public static void updateUser(User user) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.update(user);

        transaction.commit();
    }

    public static void deleteUser(User user) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.delete(user);

        transaction.commit();
    
}
}
