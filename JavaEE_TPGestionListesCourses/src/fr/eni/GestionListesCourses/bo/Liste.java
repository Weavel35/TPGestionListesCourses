package fr.eni.GestionListesCourses.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Liste implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -197824200973824682L;
	
	private int id;
	private String nom;
	private List<Article> articles;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Article> getArticles() {
		if(articles == null)
			this.articles = new ArrayList<Article>();
		
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public Liste() {
		super();
		this.articles = new ArrayList<Article>();
		// TODO Auto-generated constructor stub
	}
	public Liste(String nom, List<Article> articles) {
		super();
		this.nom = nom;
		this.articles = articles;
	}
	public Liste(String nom) {
		this();
		this.nom = nom;
	}
	@Override
	public String toString() {
		String affArticles = "";
		for(Article article : articles) {
			affArticles += "\n\t" + article.toString();
		}
		
		return String.format("%s : id=%d, nom=%s, articles=%s",
				this.getClass().getSimpleName(),
				getId(),
				getNom(),
				affArticles
				);
	}
}
