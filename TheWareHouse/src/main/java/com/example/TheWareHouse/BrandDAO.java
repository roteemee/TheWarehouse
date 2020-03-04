package com.example.TheWareHouse;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandDAO {

	@Autowired
	private BrandRepo srep;
	
	
	public Brand findByShortNameAndLastName(String sname, String lname) {
		
		Brand b = srep.findByShortNameAndFullName(sname, lname);
		
		return b;
	}
	

	public BrandDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addBrand(Brand Brand) {
		srep.save(Brand);
	
	

	}

	public Brand getBrand(int brandname) {
		Optional<Brand> sopt = srep.findById(brandname);

		if (sopt.isPresent())
			return sopt.get();
		else
			return null;

	}
	public Brand getBrand(String brandname) {
		Brand brand = srep.findByShortName(brandname);
		if(brand.getShortName()!=null) {
			return brand;
		}
		return null;

	}

	public void updateBrand(Brand brand) {

		srep.save(brand);

	}

	public void removeBrand(int brandId) {

		srep.deleteById(brandId);

	}

	public List<Brand> listBrands() {

		List<Brand> Brands = srep.findAll();
		return Brands;
	}

}
