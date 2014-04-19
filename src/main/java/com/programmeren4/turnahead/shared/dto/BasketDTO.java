package com.programmeren4.turnahead.shared.dto;

public class BasketDTO {

	//attributen
	private Long basketID; 
	private String karakterName;
	private int itemID;
	private String itemName;
	
	//constructor (?)
	
	
	//getters en setters
	public Long getBasketID() {
		return basketID;
	}
	public void setBasketID(Long basketID) {
		this.basketID = basketID;
	}

	public String getKarakterName() {
		return karakterName;
	}
	public void setKarakterName(String karakterName) {
		this.karakterName = karakterName;
	}

	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
		BasketDTO other = (BasketDTO) obj;
		if (basketID == null) {
			if (other.basketID != null)
				return false;
		} else if (!basketID.equals(other.basketID))
			return false;
		return true;
	}

	
    
    
    
}
