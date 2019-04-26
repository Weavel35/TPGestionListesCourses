package fr.eni.GestionListesCourses.dal;

import java.util.List;

import fr.eni.GestionListesCourses.bo.Liste;

public interface ListeDAO {
	public void insert(Liste liste);
	public Liste select(int id);
	public List<Liste> selectAll();
	public void delete(int id);
}
