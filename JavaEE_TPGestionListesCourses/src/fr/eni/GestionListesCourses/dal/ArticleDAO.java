package fr.eni.GestionListesCourses.dal;

import java.util.List;

import fr.eni.GestionListesCourses.bo.Article;

public interface ArticleDAO {
	public void insert();
	public Article select(int id);
	public List<Article> selectAll();
	public List<Article> selectByListe(int listId);
	public void delete(int id);
}
