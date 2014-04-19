package com.programmeren4.turnahead.shared.dto;


/**
 * Locatie
 * 
 */
public class LocationDTO {
	//private static final long serialVersionUID = 1L;
	private Long locationId; 
    private String locationName;
    private String locationDescription;

    //constructor (?)
    
    
    //getters en setters
	public Long getLocationId() {
        return locationId;
    }

    
    public String getFirstName() {
        return locationName;
    }
    public void setFirstName(String locationName) {
        this.locationName = locationName;
    }

    
    public String getLocationDescription() {
        return locationDescription;
    }
    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationDTO other = (LocationDTO) obj;
		if (locationId == null) {
			if (other.locationId != null)
				return false;
		} else if (!locationId.equals(other.locationId))
			return false;
		return true;
	}
    

}
