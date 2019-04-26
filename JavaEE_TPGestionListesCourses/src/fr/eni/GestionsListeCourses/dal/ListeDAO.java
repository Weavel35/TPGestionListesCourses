package fr.eni.GestionsListeCourses.dal;

import fr.eni.GestionListesCourses.bo.Liste;

import java.util.List;

public interface ListeDAO {
	public void insert();
	public Liste select(int id);
	public List<Liste> selectAll();
	public void delete(int id);
}
