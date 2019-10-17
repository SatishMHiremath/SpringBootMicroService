package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@ToString
@Entity
public class Item {
	
	public Item(String name) {
		this.name = name;
	}
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
}
