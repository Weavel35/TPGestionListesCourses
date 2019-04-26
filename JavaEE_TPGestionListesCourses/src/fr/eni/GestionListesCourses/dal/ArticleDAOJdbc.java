package fr.eni.GestionListesCourses.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.GestionListesCourses.bo.Article;
import fr.eni.GestionListesCourses.test.JDBCTestTools;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ArticleDAOJdbc implements ArticleDAO {

	private static final String INSERT_ARTICLE = 
			"INSERT INTO Articles\r\n"  
					+ "(nom, prixUnitaire, quantite, id_liste, coche)\r\n" 
					+ " VALUES\r\n" 
					+ " (?,?,?,?,?);";
	private static final String SELECT_ALL_ARTICLES = 
			"SELECT * FROM Articles;" ;
	
	private static final String SELECT_ARTICLE_BY_ID = 
			"SELECT * FROM Articles \r\n"  
					+ "WHERE id=%d;";
	
	private static final String SELECT_ARTICLE_BY_LISTE_ID = 
			"SELECT * FROM Articles \r\n"  
					+ "WHERE id_liste=%d;";
	
	private static final String DELETE_ARTICLE_BY_ID = 
			"DELETE FROM Articles \r\n"  
					+ "WHERE id=%d;";
	
	private static final String UPDATE_ARTICLE_BY_ID = 
			"UPDATE Articles\r\n"
					+ " SET nom=?, prixUnitaire=?, quantite=?, id_liste=?, coche=?"  
					+ " WHERE id=?;";
	
	/**
	 * Variable booléenne qui permet de déterminer quelle méthode de connexion utiliser: 
	 * TRUE: utilise JDBCTestTool pour obtenir les informations de connexion.
	 * FALSE: utilise la configuration du serveur via ConnectionProvider 
	 * qui ne fonctionne que sur le serveur et utilise /WebContent/META-INF/context.xml.
	 */
	private static boolean isTest = false;
	
	public static boolean isTest() {
		return isTest;
	}

	public static void setTest(boolean isTest) {
		ArticleDAOJdbc.isTest = isTest;
	}

	@Override
	public void insert(Article article, int idListe) {
		try {
			Connection uneConnexion = null;
			if(isTest) {
				uneConnexion = JDBCTestTools.getConnection();
			} else {
				uneConnexion = ConnectionProvider.getConnection();
			}
			PreparedStatement psmt = uneConnexion.prepareStatement(INSERT_ARTICLE, Statement.RETURN_GENERATED_KEYS);
			psmt.setString(1, article.getNom());
			psmt.setFloat(2, article.getPrixUnitaire());
			psmt.setInt(3, article.getQuantite());
			psmt.setInt(4, idListe);
			psmt.setBoolean(5, article.isCoche());
			psmt.executeUpdate();
			
			ResultSet rs = psmt.getGeneratedKeys();
			if(rs.next()) {
				article.setId(rs.getInt(1));
			}
			uneConnexion.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Article select(int id) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public List<Article> selectAll() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public List<Article> selectByListe(int listId) {
		List<Article> selectedArticles = null;
		Statement stmt = null;
		Connection uneConnexion = null;
				
		try {
			if(isTest) {
				uneConnexion = JDBCTestTools.getConnection();
			} else {
				uneConnexion = ConnectionProvider.getConnection();
			}
			String sql = String.format(SELECT_ARTICLE_BY_LISTE_ID, listId);
			stmt = uneConnexion.createStatement();
			stmt.executeQuery(sql);
			ResultSet rs = stmt.getResultSet();
			
			selectedArticles = new ArrayList<Article>();
			Article article = null;
			while(rs.next()) {
				article = new Article();
				article.setNom(rs.getString("nom"));
				article.setId(rs.getInt("id"));
				article.setCoche(rs.getBoolean("coche"));
				article.setQuantite(rs.getInt("quantite"));
				article.setPrixUnitaire(rs.getFloat("prixUnitaire"));
				selectedArticles.add(article);
			}
			uneConnexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				//Fermer le statement
				if (stmt != null) {
					stmt.close();
				}
				//Fermer la connexion
				uneConnexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return selectedArticles;
	}

	@Override
	public void delete(int id) {
		Statement stmt = null;
		Connection uneConnexion = null;
				
		try {
			if(isTest) {
				uneConnexion = JDBCTestTools.getConnection();
			} else {
				uneConnexion = ConnectionProvider.getConnection();
			}
			String sql = String.format(DELETE_ARTICLE_BY_ID, id);
			stmt = uneConnexion.createStatement();
			int nbRows = stmt.executeUpdate(sql);
			System.out.println(nbRows + " Article(s) supprimées");
			
			uneConnexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				//Fermer le statement
				if (stmt != null) {
					stmt.close();
				}
				//Fermer la connexion
				uneConnexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Article article, int idList) {
		int nbLignes = 0;
		Connection uneConnexion = null;
		PreparedStatement psmt = null;
		try {
			uneConnexion = JDBCTestTools.getConnection();
			
			psmt = uneConnexion.prepareStatement(UPDATE_ARTICLE_BY_ID, Statement.RETURN_GENERATED_KEYS);
			psmt.setString(1, article.getNom());
			psmt.setFloat(2, article.getPrixUnitaire());
			psmt.setInt(3, article.getQuantite());
			psmt.setInt(4, idList);
			psmt.setBoolean(5, article.isCoche());
			psmt.setInt(6, article.getId());			
			nbLignes = psmt.executeUpdate();

			uneConnexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {

			try {
				//Fermer le statement
				if (psmt != null) {
					psmt.close();
				}
				//Fermer la connexion
				uneConnexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(nbLignes + " Article(s) mis a jour");
		
	}

}
