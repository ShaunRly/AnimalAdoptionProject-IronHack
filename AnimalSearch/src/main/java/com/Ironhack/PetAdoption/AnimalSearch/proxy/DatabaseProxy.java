package com.Ironhack.PetAdoption.AnimalSearch.proxy;

import com.Ironhack.PetAdoption.AnimalSearch.dto.AnimalGetDTO;
import com.Ironhack.PetAdoption.AnimalSearch.dto.AnimalPostDTO;
import com.Ironhack.PetAdoption.AnimalSearch.dto.AvailableDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("database-service")
@RequestMapping("/database/animal")
public interface DatabaseProxy {

//  @GetMapping("/all")
//  List<AnimalGetDTO> getListOfAllAnimals();
//
//  @GetMapping("/{id}")
//  AnimalGetDTO getAnimalById(@PathVariable Long id);

  @GetMapping("/available")
  List<AnimalGetDTO> getListOfAvailableAnimals();

  @GetMapping
  List<AnimalGetDTO> getListOfAvailableAnimalsByTypeAndAgeRange(@RequestParam Optional<String> type, @RequestParam Optional<Integer> startAge, @RequestParam Optional<Integer> endAge);

  @PostMapping
  AnimalGetDTO postNewAnimal(@RequestBody AnimalPostDTO animalPostDTO);

  @PatchMapping("/{id}")
  AvailableDTO updateAvailability(@PathVariable("id") long id, @RequestBody AvailableDTO isAvailableDTO);

}
