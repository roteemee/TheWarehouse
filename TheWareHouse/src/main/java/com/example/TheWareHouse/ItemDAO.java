package com.example.TheWareHouse;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemDAO {

	@Autowired
	private ItemRepo srep;

	public ItemDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addItem(Item Item) {
		srep.save(Item);

	}

	public Item getItem(int ItemId) {
		Optional<Item> sopt = srep.findById(ItemId);

		if (sopt.isPresent())
			return sopt.get();
		else
			return null;

	}

	public void updateItem(Item Item) {

		srep.save(Item);

	}

	public void removeItem(int ItemId) {

		srep.deleteById(ItemId);

	}

	public List<Item> listItems() {

		List<Item> Items = srep.findAll();
		return Items;
	}

}
