package fr.eni.GestionsListeCourses.dal;

import fr.eni.GestionListesCourses.bo.Article;

import java.util.List;

public interface ArticleDAO {
	public void insert();
	public Article select(int id);
	public List<Article> selectAll();
	public List<Article> selectByListe(int listId);
	public void delete(int id);
}
