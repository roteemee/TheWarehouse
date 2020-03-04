package com.example.TheWareHouse;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemCatDAO {

	@Autowired
	private ItemCatRepo srep;

	public ItemCatDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void additemCat(ItemCat itemCat) {
		srep.save(itemCat);

	}

	public ItemCat getitemCat(int itemCatId) {
		Optional<ItemCat> sopt = srep.findById(itemCatId);

		if (sopt.isPresent())
			return sopt.get();
		else
			return null;

	}

	public void updateitemCat(ItemCat itemCat) {

		srep.save(itemCat);

	}

	public void removeitemCat(int itemCatId) {

		srep.deleteById(itemCatId);

	}

	public List<ItemCat> listItemCats() {

		List<ItemCat> itemCats = srep.findAll();
		return itemCats;
	}

}
