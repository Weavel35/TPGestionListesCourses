package fr.eni.GestionListesCourses.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.GestionListesCourses.bo.Article;
import fr.eni.GestionListesCourses.bo.Liste;

public class ListeManager {
	List<Liste> listeDesListes;
	
	public void ajouterListe(Liste listeArticles) {
		//TODO vérifications ?
		listeDesListes.add(listeArticles);
		
	}
	
	public List<Liste> selectionnerToutesListes(){
		// TODO
		return listeDesListes;
	}
	
	public List<Article> selectionnerPanier(){
		// TODO
		return new ArrayList<Article>();
	}
}
