package fr.eni.GestionListesCourses.bll;

import fr.eni.GestionListesCourses.bo.Article;
import fr.eni.GestionListesCourses.bo.Liste;

import java.util.ArrayList;
import java.util.List;

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
