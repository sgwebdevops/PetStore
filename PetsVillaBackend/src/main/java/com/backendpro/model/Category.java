package com.backendpro.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class Category implements Serializable {
	
	@Id
	//@SequenceGenerator(name="catseq", initialValue=1)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int categoryId;
	
	@NotEmpty(message="Kindly fill in the Category Name")
	private String categoryName;
	
	@NotEmpty(message="Kindly fill in the Category Description")
	private String categoryDescription;

	@OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
	private List<Product> products=new ArrayList<Product>();

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDescription="
				+ categoryDescription +  "]";
	}
	
	
	
	
}

