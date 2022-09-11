package com.spring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
public class Product2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	public int id;
	//@NotNull
    @Size(min = 1,max=15)
    @NotEmpty(message = "You can't leave name empty.")
	public String name;
    @NotNull()
	@Range(min=1000,max=100000)
	public float price;
	@Lob
	private String image;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String bs) {
		this.image = bs;
	}
	public Product2(@NotNull int id,
			@Size(min = 1, max = 15) @NotEmpty(message = "You can't leave name empty.") String name,
			@NotNull @Range(min = 1000, max = 100000) float price, String image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
	}
	public Product2() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + "]";
	}
}

