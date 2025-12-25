package com.food.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;

	private String itemName;

	private double itemPrice;

	private boolean isAvailable;

	private String itemCategory;

	private String itemType;

	private double itemRating;

	public Item(String itemName, double itemPrice, boolean isAvailable, String itemCategory, String itemType,
			double itemRating) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.isAvailable = isAvailable;
		this.itemCategory = itemCategory;
		this.itemType = itemType;
		this.itemRating = itemRating;

	}

}
