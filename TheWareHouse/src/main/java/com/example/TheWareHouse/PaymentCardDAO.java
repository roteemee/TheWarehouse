package com.example.TheWareHouse;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentCardDAO {

	@Autowired
	private PaymentCardRepo srep;

	public PaymentCardDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addPaymentCard(PaymentCard paymentCard) {
		srep.save(paymentCard);

	}

	public PaymentCard getPaymentCard(int paymentCardId) {
		Optional<PaymentCard> sopt = srep.findById(paymentCardId);

		if (sopt.isPresent())
			return sopt.get();
		else
			return null;

	}

	public void updatePaymentCard(PaymentCard paymentCard) {

		srep.save(paymentCard);

	}

	public void removePaymentCard(int paymentCardId) {

		srep.deleteById(paymentCardId);

	}

	public List<PaymentCard> listPaymentCards() {

		List<PaymentCard> paymentCards = srep.findAll();
		return paymentCards;
	}

}
