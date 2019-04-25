package fr.eni.GestionsListeCourses.dal;

import fr.eni.GestionListesCourses.dal.jdbc.ArticleDAOJdbc;
import fr.eni.GestionListesCourses.dal.jdbc.ListeDAOJdbc;

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
