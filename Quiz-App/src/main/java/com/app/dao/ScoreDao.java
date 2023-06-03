package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.pojo.Category;
import com.app.pojo.Quiz;
import com.app.pojo.QuizScore;
import com.app.pojo.User;
import com.app.util.HibernateUtil;

public class ScoreDao {
	 public static void addScore(int netScore, int quizID, String email) {
	        Session session = HibernateUtil.getCurrentSession();
	        Transaction transaction = session.beginTransaction();

	        QuizScore score = new QuizScore();
	        score.setEmail(email);
	        score.setQuizID(quizID);
	        score.setScore(netScore);
	        session.save(score);

	        transaction.commit();
	    }
	 public static List<QuizScore> getLeaderBoard(int quizID) {
	        Session session = HibernateUtil.getCurrentSession();
	        Transaction transaction = null;
	        List<QuizScore> scores = null;
	        
	        try {
	            transaction = session.beginTransaction();
	            Query<QuizScore> query = session.createQuery("FROM QuizScore qs WHERE qs.quizID = :quiz ORDER BY qs.score DESC", QuizScore.class);
	            query.setParameter("quiz", quizID);
	            scores = query.getResultList();
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return scores;
	 }
}
