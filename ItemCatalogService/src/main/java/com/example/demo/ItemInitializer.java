package com.example.demo;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ItemInitializer implements CommandLineRunner {

	private final ItemRepository itemRepository;
	
	ItemInitializer(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		Stream.of("FILA","CREW STREET","Reebok","Nike","Puma","HRX","PEAK").forEach(item -> itemRepository.save(new Item(item)));
		
		itemRepository.findAll().forEach(System.out::println);
	}

}
