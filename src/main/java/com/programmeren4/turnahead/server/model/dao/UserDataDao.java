package com.programmeren4.turnahead.server.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

import com.programmeren4.turnahead.server.database.DBConnector;
import com.programmeren4.turnahead.shared.dto.UserDataDTO;
import com.programmeren4.turnahead.shared.exception.DAOException;


public class UserDataDao {
	//attributen
	private Connection conn;
	private String sql;
	
	//constructor
	public  UserDataDao(){}
	
	
	/**
	 * Gebruikerinformatie opvragen uit de database
	 */
	public UserDataDTO getUserData(UserDataDTO userData) throws DAOException {
		UserDataDTO userDataReturn = null;
		ResultSet rs = null;
		
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			this.conn = DBConnector.getConn();
			sql = "SELECT * FROM USER WHERE USERID=" + userData.getUserId() + ")";
			rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				userDataReturn = new UserDataDTO();
				userDataReturn.setUserId(rs.getLong("USERID"));
				userDataReturn.setFirstName(rs.getString("FIRSTNAME"));
				userDataReturn.setLastName(rs.getString("LASTNAME"));
				userDataReturn.setEMail(rs.getString("EMAIL"));
				userDataReturn.setPassword(rs.getString("PASSWORD"));
			}
			
		} catch(SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.close(rs);
			DBConnector.closeConn();
		}
		return userDataReturn;
	}
	
	
	/**
	 * Gebruiker toevoegen aan de database
	 */
	public void addUserData(UserDataDTO userData) throws DAOException {
		
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			this.conn = DBConnector.getConn();
			String sql = "INSERT INTO USER VALUES (" + userData.getUserId() +")" ;
			conn.createStatement().executeUpdate(sql);	
		} catch(SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.closeConn();
		}
	}
	
	
	/**
	 * record van een bestaande Gebruiker bijwerken
	 */
	public UserDataDTO updateUserData(UserDataDTO userData) throws DAOException {
				
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			this.conn = DBConnector.getConn();
			String sql = "UPDATE USER SET *=*,*=*, WHERE USERID=" + userData.getUserId();
			conn.createStatement().executeUpdate(sql);
			//DTO to database (vergelijken of er aanpassingen mooeten gebeuren)
			
		} catch(SQLException se) {
			se.printStackTrace();	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.closeConn();
		}
		return userData;
	}
	
	
	/**
	 * Gebruiker verwijderen uit de db
	 */
	public UserDataDTO deleteUserData(UserDataDTO userData) throws DAOException {
		
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			this.conn = DBConnector.getConn();
			sql = "DELETE FROM USER WHERE userid = " + userData.getUserId() ;
			conn.createStatement().executeUpdate(sql);
		}catch(SQLException se){
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.closeConn();
		}
		return userData;
	}
	
	/**
	 * Alle gebruikers uit de db ophalen
	 */
	
}
