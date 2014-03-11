package com.programmeren4.turnahead.server.model;

import com.programmeren4.turnahead.server.model.dao.CharacterEntDao;
import com.programmeren4.turnahead.server.model.dao.ItemDao;
import com.programmeren4.turnahead.server.model.dao.LocationDao;
import com.programmeren4.turnahead.server.model.dao.UserDataDao;
import com.programmeren4.turnahead.server.model.jpa.UserData;
import com.programmeren4.turnahead.shared.dto.UserDataDTO;
import com.programmeren4.turnahead.shared.exception.DAOException;

public class Services {
	CharacterEntDao characterEntDao = new CharacterEntDao();
	ItemDao itemDao = new ItemDao();
	LocationDao locationDao = new LocationDao();
	UserDataDao userDataDao = new UserDataDao();

	//UserServices
	public void addUser(UserDataDTO userDataDTO) throws DAOException {
		// TODO: Implement some checks
		UserData userData = new UserData(userDataDTO.getFirstName(), userDataDTO.getLastName(), userDataDTO.getEMail(), userDataDTO.getPassword());
		// TODO: Implement some more checks
		userDataDao.addUserData(userData);
	}
	
	public void deleteUser(UserDataDTO userDataDTO) throws DAOException {
		// TODO: Implement some checks
		UserData userData = new UserData(userDataDTO.getFirstName(), userDataDTO.getLastName(), userDataDTO.getEMail(), userDataDTO.getPassword());
		// TODO: Implement some more checks
		userDataDao.deleteUserData(userData);
	}
	
	public void updateUser(UserDataDTO userDataDTO) throws DAOException {
		// TODO: Implement some checks
		UserData userData = new UserData(userDataDTO.getFirstName(), userDataDTO.getLastName(), userDataDTO.getEMail(), userDataDTO.getPassword());
		// TODO: Implement some more checks
		userDataDao.updateUserData(userData);
	}
	
	
	//CharacterEntServices
	public void addCharacterEnt() throws DAOException {	 }
	public void deleteCharacterEnt() throws DAOException {  }
	public void updateCharacterEnt() throws DAOException {  }
	

	//Itemservices
	public void addItem() throws DAOException {	 }
	public void deleteItem() throws DAOException {	}
	public void updateItem() throws DAOException {	}
	
	
	//Locationservices
	public void addLocation() throws DAOException {	 }
	public void deleteLocation() throws DAOException {	}
	public void updateLocation() throws DAOException { 	}

}
