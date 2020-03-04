package com.example.TheWareHouse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepo extends JpaRepository<Brand, Integer>{
	
	public Brand findByShortName (String brandname);
	public Brand findByShortNameAndFullName (String shortName, String longName);

}
