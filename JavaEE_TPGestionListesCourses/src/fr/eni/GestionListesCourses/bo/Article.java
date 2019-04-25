package fr.eni.GestionListesCourses.bo;

import java.io.Serializable;

public class Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5319162316267253678L;

	private int id;
	private String nom;
	private int quantite;
	private float prixUnitaire;
	private boolean coche = false;
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
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public boolean isCoche() {
		return coche;
	}
	public void setCoche(boolean coche) {
		this.coche = coche;
	}
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(String nom, int quantite, float prixUnitaire) {
		super();
		this.nom = nom;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
	}
	public Article(int id, String nom, int quantite, float prixUnitaire, boolean coche) {
		super();
		this.id = id;
		this.nom = nom;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.coche = coche;
	}
	
}
