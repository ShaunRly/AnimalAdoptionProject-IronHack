package com.Ironhack.PetAdoption.AnimalSearch.controller;

import com.Ironhack.PetAdoption.AnimalSearch.dto.AnimalGetDTO;
import com.Ironhack.PetAdoption.AnimalSearch.dto.AnimalPostDTO;
import com.Ironhack.PetAdoption.AnimalSearch.dto.AvailableDTO;
import com.Ironhack.PetAdoption.AnimalSearch.service.AnimalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animal")
public class AnimalControllerImpl {

  @Autowired
  private AnimalServiceImpl animalService;

  @GetMapping("/available")
  public List<AnimalGetDTO> getListOfAvailableAnimals() {
    return animalService.getListOfAvailableAnimals();
  }

  @GetMapping
  public List<AnimalGetDTO> getListOfAvailableAnimalsByTypeAndAgeRange(@RequestParam Optional<String> type, @RequestParam Optional<Integer> age) {
    return animalService.getListOfAvailableAnimalsByTypeAndAgeRange(type, age);
  }

  @PostMapping
  public AnimalGetDTO postNewAnimal(@RequestBody AnimalPostDTO animalPostDTO) {
    return animalService.postNewAnimal(animalPostDTO);
  }

  @PatchMapping("/{id}")
  public AvailableDTO updateAvailability(@PathVariable("id") int id, @RequestBody AvailableDTO isAvailableDTO) {
    return animalService.updateAvailability(id, isAvailableDTO);
  }


}
