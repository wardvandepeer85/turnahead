package com.programmeren4.turnahead.server.model.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;


/**
 * Locatie
 *
 */
@Entity
public class Location implements Serializable {
	
	//attributen
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key locationId; //Long locationId
	private String locationName;
	private String locationDescription;
	
	//constructor
	public Location(String locationName, String locationDescription) {
		
		this.locationName = locationName;
		this.locationDescription = locationDescription;
	}
	
	//getters en setters
	public Key getLocationId() {
        return locationId;
    }
	
	
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	
	public String getLocationDescription() {
		return locationDescription;
	}
	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}


}
