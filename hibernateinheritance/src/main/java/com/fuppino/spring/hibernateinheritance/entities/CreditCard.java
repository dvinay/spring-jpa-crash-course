package com.fuppino.spring.hibernateinheritance.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
/* -- SINGLE_TABLE strategy
@DiscriminatorValue("cc")
*/
@Table(name="creditcard")
@PrimaryKeyJoinColumn(name="id")
public class CreditCard extends Payment {
	private String cardnumber;

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	

}
