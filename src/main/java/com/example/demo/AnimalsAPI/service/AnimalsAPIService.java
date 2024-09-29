package com.example.demo.AnimalsAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.AnimalsAPI.data.AnimalsAPIData;
import com.example.demo.AnimalsAPI.repository.AnimalsAPIRepository;

@Service
public class AnimalsAPIService {

	private final AnimalsAPIRepository animalsAPIRepository;

	public AnimalsAPIService(AnimalsAPIRepository animalsAPIRepository) {
		this.animalsAPIRepository = animalsAPIRepository;
	}

	public List<AnimalsAPIData> getAnimals() throws IOException {

		AnimalsAPIData[] animalsList = animalsAPIRepository.getAnimals();

		return Arrays.asList(animalsList);

	}
	public AnimalsAPIData getAnimalById(int id) throws IOException {
		AnimalsAPIData[] animalsList = animalsAPIRepository.getAnimals();
		return Arrays.stream(animalsList)
                .filter(animal -> animal.getId() == id)
                .findFirst()
                .orElse(null);
}
}