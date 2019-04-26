package fr.eni.GestionListesCourses.dal;

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
