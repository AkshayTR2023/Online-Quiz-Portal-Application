package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.pojo.Category;
import com.app.pojo.Quiz;
import com.app.util.HibernateUtil;

public class QuizDao {

    public static int addQuiz(String name, Category category) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();

       Quiz newQuiz = new Quiz();
        newQuiz.setName(name);
        newQuiz.setCategory(category);
        session.save(newQuiz);

        transaction.commit();
        return newQuiz.getId();
    }

    public static List<Quiz> getAllQuizzes() {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = null;
        List<Quiz> quizzes = null;
        
        try {
            transaction = session.beginTransaction();
            Query<Quiz> query = session.createQuery("FROM Quiz", Quiz.class);
            quizzes = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return quizzes;
    }

    public static Quiz getQuizById(int id) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = null;
        Quiz quiz = null;
        
        try {
            transaction = session.beginTransaction();
            quiz = session.get(Quiz.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return quiz;
    }
    public static List<Quiz> getQuizzesByCategory(Category category) {
        try (Session session = HibernateUtil.getCurrentSession()) {
            session.beginTransaction();
            String hql = "FROM Quiz WHERE category = :category";
            Query<Quiz> query = session.createQuery(hql, Quiz.class);
            query.setParameter("category", category);
            List<Quiz> quizzes = query.list();
            session.getTransaction().commit();
            return quizzes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void updateQuiz(Quiz quiz) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.update(quiz);

        transaction.commit();
    }

    public static void deleteQuiz(Quiz quiz) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.delete(quiz);

        transaction.commit();
    }
}

