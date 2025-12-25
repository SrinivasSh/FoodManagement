package com.food.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;

	private String landMark;

	private String city;

	private String pinCode;

	private String district;

	private String state;

	public Address(String landMark, String city, String pinCode, String district, String state) {
		super();
		this.landMark = landMark;
		this.city = city;
		this.pinCode = pinCode;
		this.district = district;
		this.state = state;
	}

}
