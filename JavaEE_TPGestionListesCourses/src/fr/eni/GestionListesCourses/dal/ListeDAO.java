package fr.eni.GestionListesCourses.dal;

import fr.eni.GestionListesCourses.bo.Liste;

import java.util.List;

public interface ListeDAO {
	public void insert(Liste liste);
	public Liste select(int id);
	public List<Liste> selectAll();
	public void delete(int id);
	public void update(Liste liste);
}
