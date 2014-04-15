package com.programmeren4.turnahead.server.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	 * Gebruiker toevoegen aan de database of een bestaande gebruiker 
	 */
	public void addUserData(UserDataDTO userData) throws DAOException {
		
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			this.conn = DBConnector.getConn();
			//User bestaat al > UPDATE "UPDATE USER SET *=*,*=*, WHERE USERID=" + userData.getUserId();
			
			
			//User bestaat nog niet > INSERT INTO db () VALUES ()
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
	 * Gebruiker verwijderen uit de db
	 */
	public void deleteUserData(UserDataDTO userData) throws DAOException {
		
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			this.conn = DBConnector.getConn();
			sql = "DELETE FROM USER WHERE USERID=" + userData.getUserId() ;
			conn.createStatement().executeUpdate(sql);
		}catch(SQLException se){
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.closeConn();
		}
	}
	
	/**
	 * Alle gebruikers uit de db ophalen
	 */
	public List<UserDataDTO> getUsers() throws SQLException {
		String query = "SELECT * FROM USER";
		List<UserDataDTO> list = new ArrayList<UserDataDTO>();
		UserDataDTO userDataReturn = null;
		ResultSet rs = null;
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			this.conn = DBConnector.getConn();
			rs = conn.createStatement().executeQuery(query);
			
			while (rs.next()) {
				userDataReturn = new UserDataDTO();
				userDataReturn.setUserId(rs.getLong("USERID"));
				userDataReturn.setFirstName(rs.getString("FIRSTNAME"));
				userDataReturn.setLastName(rs.getString("LASTNAME"));
				userDataReturn.setEMail(rs.getString("EMAIL"));
				userDataReturn.setPassword(rs.getString("PASSWORD"));
				list.add(userDataReturn);
			}
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			DBConnector.close(rs);
			DBConnector.closeConn();
		}
		return list;
	}
}
