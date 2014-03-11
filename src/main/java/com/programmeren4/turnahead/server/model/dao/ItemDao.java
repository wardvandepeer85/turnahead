package com.programmeren4.turnahead.server.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.programmeren4.turnahead.server.model.EMFService;
import com.programmeren4.turnahead.server.model.jpa.Item;
import com.programmeren4.turnahead.shared.exception.DAOException;



public class ItemDao {
	EntityManager em;
	EntityTransaction tx;
	
	/**
	 * 
	 * @param item
	 * @return
	 * @throws DAOException
	 */
	public ItemDao addItem(ItemDao item) throws DAOException {
		em = EMFService.get().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(item);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			Logger.getLogger("ItemDAO").log(Level.SEVERE, e.getMessage());
			throw new DAOException();
		} finally {
			em.close();
		}
		return item;
	}
	
	/**
	 * 
	 * @param item
	 * @return
	 * @throws DAOException
	 */
	public ItemDao deleteItem(ItemDao item) throws DAOException {
		em = EMFService.get().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		
	
		try {
			em.remove(item);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			Logger.getLogger("ItemDAO").log(Level.SEVERE, e.getMessage());
			throw new DAOException();
		} finally {
			em.close();
		}
		return item;
	}

	/**
	 * 
	 * @param item
	 * @return
	 * @throws DAOException
	 */
	public ItemDao updateItem(ItemDao item) throws DAOException {
		em = EMFService.get().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		try {
			em.merge(item);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			Logger.getLogger("ItemDAO").log(Level.SEVERE, e.getMessage());
			throw new DAOException();
		} finally {
			em.close();
		}
		return item;
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Item> getItems() {
		em = EMFService.get().createEntityManager();
		tx = em.getTransaction();
		Query q = em.createQuery("SELECT a FROM Item a");
		List<Item> itemList = new ArrayList<Item>(q.getResultList());
		em.close();
		return itemList;
	}
}
