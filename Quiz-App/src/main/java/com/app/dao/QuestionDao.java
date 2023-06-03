package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.pojo.Question;
import com.app.pojo.Quiz;
import com.app.util.HibernateUtil;

public class QuestionDao {

    public static void addQuestion(String question, String option1, String option2, String option3, String option4, int correctOption, Quiz quiz) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Question newQuestion = new Question();
        newQuestion.setQuestion(question);
        newQuestion.setOption1(option1);
        newQuestion.setOption2(option2);
        newQuestion.setOption3(option3);
        newQuestion.setOption4(option4);
        newQuestion.setCorrectOption(correctOption);
        newQuestion.setQuiz(quiz);
        session.save(newQuestion);

        transaction.commit();
    }

    public static List<Question> getAllQuestions() {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = null;
        List<Question> questions = null;
        
        try {
            transaction = session.beginTransaction();
            Query<Question> query = session.createQuery("FROM Question", Question.class);
            questions = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return questions;
    }

    public static Question getQuestionById(int id) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = null;
        Question question = null;
        
        try {
            transaction = session.beginTransaction();
            question = session.get(Question.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return question;
    }
    public static List<Question> getQuestionsByQuizId(int quizId) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        // Query the database to retrieve the questions based on the quiz ID
        Query<Question> query = session.createQuery("FROM Question WHERE quiz.id = :quizId", Question.class);
        query.setParameter("quizId", quizId);
        List<Question> questions = query.getResultList();
        
        transaction.commit();
        
        return questions;
    }
    public static void updateQuestion(Question question) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.update(question);

        transaction.commit();
    }

    public static void deleteQuestion(Question question) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.delete(question);

        transaction.commit();
    }
}

