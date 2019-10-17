package com.example.demo;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodItemApiAdapterRestController {
	private final ItemClient itemClient;

	public GoodItemApiAdapterRestController(ItemClient client) {
		this.itemClient = client;
	}

	@GetMapping("/top-brands")
	public Collection<Item> goodItems() {
		return itemClient.readItems()
				.getContent()
				.stream()
				.filter(this::isGreat)
				.collect(Collectors.toList());
	}

	private boolean isGreat(Item item) {
		return !item.getName().equals("Nike") && !item.getName().equals("PUMA") &&
				!item.getName().equals("CREW STREET") && !item.getName().equals("FILA") &&
				!item.getName().equals("Reebok");
	}
}
