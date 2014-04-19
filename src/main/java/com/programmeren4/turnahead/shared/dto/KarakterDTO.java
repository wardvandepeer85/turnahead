package com.programmeren4.turnahead.shared.dto;

import java.util.Date;

/**
 * Karakter DTO
 * 
 */
public class KarakterDTO {
	//attributen
	private Long karakterId; 
	private String karakterName;
    private String currentLocation;
	private Date creationDate;
    private Date lastUseDate;
	
    //constructor(?)
    
    //getters en setters
    public Long getKarakterId() {
		return karakterId;
	}
	public void setKarakterId(Long karakterId) {
		this.karakterId = karakterId;
	}
	
	public String getKarakterName() {
		return karakterName;
	}
	public void setKarakterName(String karakterName) {
		this.karakterName = karakterName;
	}
	
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Date getLastUseDate() {
		return lastUseDate;
	}
	public void setLastUseDate(Date lastUseDate) {
		this.lastUseDate = lastUseDate;
	}
	
	//methoden
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KarakterDTO other = (KarakterDTO) obj;
		if (karakterId == null) {
			if (other.karakterId != null)
				return false;
		} else if (!karakterId.equals(other.karakterId))
			return false;
		return true;
	}
    
}
