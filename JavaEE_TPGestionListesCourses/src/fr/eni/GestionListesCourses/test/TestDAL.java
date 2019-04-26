package fr.eni.GestionListesCourses.test;

import java.time.LocalTime;
import java.util.List;

import fr.eni.GestionListesCourses.bll.ListeManager;
import fr.eni.GestionListesCourses.bo.Article;
import fr.eni.GestionListesCourses.bo.Liste;
import fr.eni.GestionListesCourses.dal.ArticleDAOJdbc;
import fr.eni.GestionListesCourses.dal.ListeDAOJdbc;

public class TestDAL {

	public static void main(String[] args) {
		ListeDAOJdbc.setTest(true);
		ArticleDAOJdbc.setTest(true);
		
		testListesJDBC();
	}

	private static void testListesJDBC() {
		System.out.println("start");
		//ajouter
		Liste liste = new Liste("testListe" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond());
		//articles
		liste.getArticles().add(new Article("art 1 " + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond(), 5, 18.5f));
		liste.getArticles().add(new Article("art 2 " + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond(), 1, 5f));
		
		ListeManager.ajouterListe(liste);
		System.out.println(liste.toString());
		
		//Update article
		Article a = liste.getArticles().get(0);
		a.setCoche(true);
		a.setQuantite(200);
		a.setNom("blablabla" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond());
		a.setPrixUnitaire(2.53f);
		ListeManager.modifierArticle(liste.getArticles().get(0), liste.getId());
		//select id
		System.out.println(ListeManager.selectionnerListe(liste.getId()));
		
		//select all
		List<Liste> listes = ListeManager.selectionnerToutesListes();
		System.out.println();
		for(Liste l : listes) {
			System.out.println(l);
		}
		
		//supprimer
		ListeManager.supprimerListe(liste);
		
		listes = ListeManager.selectionnerToutesListes();
		System.out.println();
		for(Liste l : listes) {
			System.out.println(l);
		}
	}

}
