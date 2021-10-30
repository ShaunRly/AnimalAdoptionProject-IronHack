package com.Ironhack.PetAdoption.DataBase.dao;

import com.Ironhack.PetAdoption.DataBase.DTO.AdopterDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Adopter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long petId;

    public Adopter(AdopterDTO adopterDTO) {
        this.name = adopterDTO.getName();
        this.petId = adopterDTO.getPetId();
    }
}
