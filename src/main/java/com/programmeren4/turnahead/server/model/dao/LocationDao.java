package com.programmeren4.turnahead.server.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.programmeren4.turnahead.server.model.EMFService;
import com.programmeren4.turnahead.server.model.jpa.Location;
import com.programmeren4.turnahead.shared.exception.DAOException;



public class LocationDao {
	EntityManager em;
	EntityTransaction tx;
	
	/**
	 * 
	 * @param location
	 * @return
	 * @throws DAOException
	 */
	public LocationDao addLocation(LocationDao location) throws DAOException {
		em = EMFService.get().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(location);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			Logger.getLogger("LocationDAO").log(Level.SEVERE, e.getMessage());
			throw new DAOException();
		} finally {
			em.close();
		}
		return location;
	}
	
	/**
	 * 
	 * @param account
	 * @return
	 * @throws DAOException
	 */
	public LocationDao deleteLocation(LocationDao location) throws DAOException {
		em = EMFService.get().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		try {
			em.remove(location);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			Logger.getLogger("LocationDAO").log(Level.SEVERE, e.getMessage());
			throw new DAOException();
		} finally {
			em.close();
		}
		return location;
	}

	/**
	 * 
	 * @param location
	 * @return
	 * @throws DAOException
	 */
	public LocationDao updateLocation(LocationDao location) throws DAOException {
		em = EMFService.get().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		try {
			em.merge(location);
			tx.commit();	
		} catch (Exception e) {
			tx.rollback();
			Logger.getLogger("LocationDAO").log(Level.SEVERE, e.getMessage());
			throw new DAOException();
		} finally {
			em.close();
		}
		return location;
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Location> getLocations() {
		em = EMFService.get().createEntityManager();
		tx = em.getTransaction();
		Query q = em.createQuery("SELECT a FROM Location a");
		List<Location> LocationList = new ArrayList<Location>(q.getResultList());
		em.close();
		return LocationList;
	}
}
