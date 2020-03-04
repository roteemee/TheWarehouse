package com.example.TheWareHouse;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierDAO {

	@Autowired
	private SupplierRepo srep;

	public SupplierDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addSupplier(Supplier supplier) {
		srep.save(supplier);

	}

	public Supplier getSupplier(int supplierId) {
		Optional<Supplier> sopt = srep.findById(supplierId);

		if (sopt.isPresent())
			return sopt.get();
		else
			return null;

	}

	public void updateSupplier(Supplier supplier) {

		srep.save(supplier);

	}

	public void removeSupplier(int supplierId) {

		srep.deleteById(supplierId);

	}

	public List<Supplier> listSuppliers() {

		List<Supplier> suppliers = srep.findAll();
		return suppliers;
	}

}
