package com.programmeren4.turnahead.server.model.jpa;


import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

/**
 * Item
 *
 */
@Entity
public class Item implements Serializable{
	//attributen
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key itemId; // Long voor JPA, Key voor JPA + GAE
	@Basic
	private String itemName;
	@Basic
	private String itemDescription;
	
	
	//constructor
	public Item(String itemName, String itemDescription){
		//this.itemId = ;
		this.itemName = itemName;
		this.itemDescription = itemDescription;	
	}
	
	
	//getters en setters
	public Key getItemId() {
		return itemId;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
 

}
