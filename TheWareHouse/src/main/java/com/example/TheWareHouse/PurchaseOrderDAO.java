package com.example.TheWareHouse;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderDAO {

	@Autowired
	private PurchaseOrderRepo srep;

	public PurchaseOrderDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addpurchaseOrder(PurchaseOrder purchaseOrder) {
		srep.save(purchaseOrder);

	}

	public PurchaseOrder getpurchaseOrder(int purchaseOrderId) {
		Optional<PurchaseOrder> sopt = srep.findById(purchaseOrderId);

		if (sopt.isPresent())
			return sopt.get();
		else
			return null;

	}

	public void updatepurchaseOrder(PurchaseOrder purchaseOrder) {

		srep.save(purchaseOrder);

	}

	public void removepurchaseOrder(int purchaseOrderId) {

		srep.deleteById(purchaseOrderId);

	}

	public List<PurchaseOrder> listpurchaseOrders() {

		List<PurchaseOrder> purchaseOrders = srep.findAll();
		return purchaseOrders;
	}

}
