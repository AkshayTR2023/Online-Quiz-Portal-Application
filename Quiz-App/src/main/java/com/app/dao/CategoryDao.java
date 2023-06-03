package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.pojo.Category;
import com.app.util.HibernateUtil;

public class CategoryDao {

    public static void addCategory(String name) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Category newCategory = new Category();
        newCategory.setName(name);
        session.save(newCategory);

        transaction.commit();
    }

    public static List<Category> getAllCategories() {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = null;
        List<Category> categories = null;
        
        try {
            transaction = session.beginTransaction();
            Query<Category> query = session.createQuery("FROM Category", Category.class);
            categories = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return categories;
    }

    public static Category getCategoryById(int id) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = null;
        Category category = null;
        
        try {
            transaction = session.beginTransaction();
            category = session.get(Category.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return category;
    }

    public static void updateCategory(Category category) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.update(category);

        transaction.commit();
    }

    public static void deleteCategory(Category category) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.delete(category);

        transaction.commit();
    }
}

