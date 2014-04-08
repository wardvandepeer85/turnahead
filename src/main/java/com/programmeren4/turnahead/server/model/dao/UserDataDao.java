package com.programmeren4.turnahead.server.model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.programmeren4.turnahead.server.database.DBConnector;
import com.programmeren4.turnahead.shared.dto.UserDataDTO;
import com.programmeren4.turnahead.shared.exception.DAOException;



public class UserDataDao {
	private Connection conn;
	private String sql;
	
	
	/**
	 * Gebruikerinformatie opvragen uit de database
	 */
	public UserDataDTO getUserData(UserDataDTO userData) throws DAOException {
				
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			this.conn = DBConnector.getConn();
			sql = "SELECT * FROM USER WHERE USERID=" + userData.getUserId();
			conn.createStatement().executeUpdate(sql);
		} catch(SQLException se) {
			 se.printStackTrace();
		} catch (Exception e) {
			
		} finally {
			DBConnector.closeConn();
		}
		return userData;
	}
	
	
	/**
	 * Gebruiker toevoegen aan de database
	 */
	public UserDataDTO addUserData(UserDataDTO userData) throws DAOException {
		
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			this.conn = DBConnector.getConn();
			String sql = "INSERT INTO USER VALUES (" ;
			conn.createStatement().executeUpdate(sql);
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
	 * record van een bestaande Gebruiker bijwerken
	 */
	public UserDataDTO updateUserData(UserDataDTO userData) throws DAOException {
				
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			this.conn = DBConnector.getConn();
			String sql = "INSERT INTO USER VALUES (" ;
			conn.createStatement().executeUpdate(sql);
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
			sql = "DELETE FROM Character WHERE userid = " + userData.getUserId() ;
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
}
