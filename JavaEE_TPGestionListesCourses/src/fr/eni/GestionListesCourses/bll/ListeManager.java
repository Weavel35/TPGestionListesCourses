package fr.eni.GestionListesCourses.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.GestionListesCourses.bo.Article;
import fr.eni.GestionListesCourses.bo.Liste;
import fr.eni.GestionListesCourses.dal.DAOFactory;

public abstract class ListeManager {
	
	public static void ajouterListe(Liste listeArticles) {
		//TODO vérifications ?
		
		DAOFactory.getListeDAO().insert(listeArticles);
		for(Article a : listeArticles.getArticles()) {
			DAOFactory.getArticleDAO().insert(a, listeArticles.getId());
		}
		
	}
	
	public static List<Liste> selectionnerToutesListes(){
		List<Liste> listeDeListes = DAOFactory.getListeDAO().selectAll();
		for(Liste l : listeDeListes) {
			l.setArticles( DAOFactory.getArticleDAO().selectByListe(l.getId()));
		}
		
		return listeDeListes;
	}
	
	public static List<Article> selectionnerPanier(){
		// TODO
		return new ArrayList<Article>();
	}

	public static Liste selectionnerListe(int id) {
		Liste liste = DAOFactory.getListeDAO().select(id);
		//TODO articles
		return liste;
	}
	
	public static void supprimerListe(Liste liste) {
		for(Article art : liste.getArticles()) {
			DAOFactory.getArticleDAO().delete(art.getId());
		}
		
		DAOFactory.getListeDAO().delete(liste.getId());
	}
	
	public static void modifierArticle(Article article, int idList) {
		DAOFactory.getArticleDAO().update(article, idList);
	}
}
