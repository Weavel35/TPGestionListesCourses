package fr.eni.GestionsListeCourses.dal;

import java.util.List;

import fr.eni.GestionListesCourses.bo.Liste;

public interface ListeDAO {
	public void insert();
	public Liste select(int id);
	public List<Liste> selectAll();
	public void delete(int id);
}
