package fr.eni.GestionListesCourses.test;

import java.time.LocalTime;
import java.util.List;

import fr.eni.GestionListesCourses.bo.Liste;
import fr.eni.GestionListesCourses.dal.DAOFactory;
import fr.eni.GestionListesCourses.dal.ListeDAO;
import fr.eni.GestionListesCourses.dal.ListeDAOJdbc;

public class TestDAL {

	public static void main(String[] args) {
		ListeDAOJdbc.setTest(true);
		
		testListesJDBC();
	}

	private static void testListesJDBC() {
		System.out.println("start");
		ListeDAO ldao = DAOFactory.getListeDAO();
		Liste liste = new Liste("testListe" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond());
		ldao.insert(liste);
		System.out.println(liste);
		System.out.println(ldao.select(liste.getId()));
		List<Liste> listes = ldao.selectAll();
		System.out.println();
		for(Liste l : listes) {
			System.out.println(l);
		}
	}

}
