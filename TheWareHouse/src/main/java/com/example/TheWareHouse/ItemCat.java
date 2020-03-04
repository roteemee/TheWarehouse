package com.example.TheWareHouse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="Item_Categories")
public class ItemCat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_cat")
    @SequenceGenerator(sequenceName = "item_cat_seq", allocationSize = 1, name = "item_cat")
	@Column(name="item_cat_id")
	private int itemCatId;
	
	@Column( length = 50)
	private String description;

	public ItemCat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemCat(String description) {
		super();
		this.description = description;
	}

	public int getItemCatId() {
		return itemCatId;
	}

	public void setItemCatId(int itemCatId) {
		this.itemCatId = itemCatId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + itemCatId;
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
		ItemCat other = (ItemCat) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (itemCatId != other.itemCatId)
			return false;
		return true;
	}

	
	
	
}
