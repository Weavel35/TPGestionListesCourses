package fr.eni.GestionListesCourses.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.GestionListesCourses.bo.Liste;
import fr.eni.GestionListesCourses.test.JDBCTestTools;

public class ListeDAOJdbc implements ListeDAO {

	private static final String INSERT_LISTE = 
			"INSERT INTO Listes\r\n"  
					+ "(nom)\r\n" 
					+ "VALUES\r\n" 
					+ "(?);";
	private static final String SELECT_ALL_LISTES = 
			"SELECT * FROM Listes;" ;
	
	private static final String SELECT_LISTE_BY_ID = 
			"SELECT * FROM Listes \r\n"  
					+ "WHERE id=%d;";
	
	private static final String DELETE_LISTE_BY_ID = 
			"DELETE FROM Listes \r\n"  
					+ "WHERE id=%d;";
	private static final String UPDATE_LISTE_BY_ID = 
			"UPDATE Listes\r\n"
					+ " SET nom=?"  
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
	public static void setTest(boolean isTesting) {
		isTest = isTesting;
	}

	@Override
	public void insert(Liste liste) {
		try {
			Connection uneConnexion = null;
			if(isTest) {
				uneConnexion = JDBCTestTools.getConnection();
			} else {
				uneConnexion = ConnectionProvider.getConnection();
			}
			PreparedStatement psmt = uneConnexion.prepareStatement(INSERT_LISTE, Statement.RETURN_GENERATED_KEYS);
			psmt.setString(1, liste.getNom());
			psmt.executeUpdate();
			
			ResultSet rs = psmt.getGeneratedKeys();
			if(rs.next()) {
				liste.setId(rs.getInt(1));
			}
			uneConnexion.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Liste select(int id) {
		List<Liste> selectedListes = null;
		Statement stmt = null;
		Connection uneConnexion = null;
				
		try {
			if(isTest) {
				uneConnexion = JDBCTestTools.getConnection();
			} else {
				uneConnexion = ConnectionProvider.getConnection();
			}
			String sql = String.format(SELECT_LISTE_BY_ID, id);
			stmt = uneConnexion.createStatement();
			stmt.executeQuery(sql);
			ResultSet rs = stmt.getResultSet();
			
			selectedListes = new ArrayList<Liste>();
			Liste liste = null;
			while(rs.next()) {
				liste = new Liste();
				liste.setNom(rs.getString("nom"));
				liste.setId(rs.getInt("id"));
				selectedListes.add(liste);
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
		if(selectedListes != null && selectedListes.size() > 0) {
			return selectedListes.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Liste> selectAll() {
		List<Liste> selectedListes = null;
		Statement stmt = null;
		Connection uneConnexion = null;
				
		try {
			if(isTest) {
				uneConnexion = JDBCTestTools.getConnection();
			} else {
				uneConnexion = ConnectionProvider.getConnection();
			}
			stmt = uneConnexion.createStatement();
			stmt.executeQuery(SELECT_ALL_LISTES);
			ResultSet rs = stmt.getResultSet();
			
			selectedListes = new ArrayList<Liste>();
			Liste liste = null;
			while(rs.next()) {
				liste = new Liste();
				liste.setNom(rs.getString("nom"));
				liste.setId(rs.getInt("id"));
				selectedListes.add(liste);
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
		return selectedListes;
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
			String sql = String.format(DELETE_LISTE_BY_ID, id);
			stmt = uneConnexion.createStatement();
			int nbRows = stmt.executeUpdate(sql);
			System.out.println(nbRows + " Ligne(s) supprimées");
			
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
	public void update(Liste liste) {
		int nbLignes = 0;
		Connection uneConnexion = null;
		PreparedStatement psmt = null;
		try {
			uneConnexion = JDBCTestTools.getConnection();
			
			psmt = uneConnexion.prepareStatement(UPDATE_LISTE_BY_ID, Statement.RETURN_GENERATED_KEYS);
			psmt.setString(1, liste.getNom());
			psmt.setInt(2, liste.getId());			
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
		System.out.println(nbLignes + " Liste(s) mis a jour");
		
	}
	
}
