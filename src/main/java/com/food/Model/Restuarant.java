package com.food.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restuarants")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restuarant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int restaurantId;

	private String restuarantName;

	private String phoneNumber;

	private double restuarantRating;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="restuarant_id")
	private List<Item> items;

	public Restuarant(String restuarantName, String phoneNumber, double restuarantRating, Address address,
			List<Item> items) {
		super();
		this.restuarantName = restuarantName;
		this.phoneNumber = phoneNumber;
		this.restuarantRating = restuarantRating;
		this.address = address;
		this.items = items;
	}

}
