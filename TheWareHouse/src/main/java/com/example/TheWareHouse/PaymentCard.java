package com.example.TheWareHouse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name="payment_card")
public class PaymentCard {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_card")
    @SequenceGenerator(sequenceName = "payment_card_seq", allocationSize = 1, name = "payment_card")
	@Column(name="card_id" ,length = 10)
	private int cardId;
	
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;
	
	@Column(length = 50)
	private String cardName;

	@Column(precision = 10, scale = 2)
	private double balance;

	public PaymentCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentCard(User user,String cardName,  double balance) {
		super();
		this.user = user;
		this.cardName = cardName;
		this.balance = balance;
	}

	public int getCardId() {
		return cardId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + cardId;
		result = prime * result + ((cardName == null) ? 0 : cardName.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		PaymentCard other = (PaymentCard) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (cardId != other.cardId)
			return false;
		if (cardName == null) {
			if (other.cardName != null)
				return false;
		} else if (!cardName.equals(other.cardName))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}



}
