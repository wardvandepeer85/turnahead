package com.programmeren4.turnahead.server.model.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.programmeren4.turnahead.server.model.EMFService;
import com.programmeren4.turnahead.shared.exception.DAOException;


public class CharacterEntDao {
	EntityManager em;
	EntityTransaction tx;
	
	public CharacterEntDao addCharacterEnt(CharacterEntDao account) throws DAOException {
		em = EMFService.get().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(account);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			Logger.getLogger("AccountDAO").log(Level.SEVERE, e.getMessage());
			throw new DAOException();
		} finally {
			em.close();
		}
		return account;
	}
	
	/**
	 * Character 
	 * @param account
	 * @return
	 * @throws DAOException
	 */
	public CharacterEntDao deleteCharacterEnt(CharacterEntDao account) throws DAOException {
		em = EMFService.get().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		//account opzoeken
		
		try {
			em.remove(account);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			Logger.getLogger("AccountDAO").log(Level.SEVERE, e.getMessage());
			throw new DAOException();
		} finally {
			em.close();
		}
		return account;
	}

	/**
	 * 
	 * @param account
	 * @return
	 * @throws DAOException
	 */
	public CharacterEntDao UpdateCharacterEnt(CharacterEntDao account) throws DAOException {
		em = EMFService.get().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		//account opzoeken
		//gegevens vergelijken en wijzigen
		
		try {
			em.remove(account);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			Logger.getLogger("AccountDAO").log(Level.SEVERE, e.getMessage());
			throw new DAOException();
		} finally {
			em.close();
		}
		return account;
	}


}
