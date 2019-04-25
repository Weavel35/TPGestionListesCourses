package fr.eni.GestionListeCourses.dal;

import fr.eni.GestionListeCourses.dal.jdbc.ArticleDAOJdbc;
import fr.eni.GestionListeCourses.dal.jdbc.ListeDAOJdbc;

public abstract class DAOFactory {
	
	public static ListeDAO getListeDAO() {
		ListeDAO listeDAO = new ListeDAOJdbc();
		return listeDAO;
	}
	
	public static ArticleDAO getArticleDAO() {
		ArticleDAO articleDAO = new ArticleDAOJdbc();
		return articleDAO;
	}
}
