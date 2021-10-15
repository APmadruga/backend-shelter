package com.example.backendshelter.controller;
import com.example.backendshelter.controller.request.CreateShelterRQ;
import com.example.backendshelter.model.Shelter;
import com.example.backendshelter.service.ShelterService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class ShelterController {

    private final ShelterService shelterService;

    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }


    @PostMapping(value ="/shelter", consumes = "application/json", produces = "application/json")
    public Shelter createShelter(@RequestBody @Valid CreateShelterRQ createShelterRQ)  {
        Shelter newShelter = Shelter
                .builder()
                .name(createShelterRQ.getName())
                .shelterColors(createShelterRQ.getShelterColors())
                .location(createShelterRQ.getLocation())
                .build();
        return shelterService.createShelter(newShelter);
    }

    @PostMapping(value ="/shelter/{id}", consumes = "application/json", produces = "application/json")
    public Shelter createShelterWithPets(@RequestBody @Valid List<Long> petIdList, @PathVariable(value = "id") Long shelterId) {
        Shelter getShelter = shelterService.getShelterById(shelterId);
        return shelterService.addPetsToShelter(getShelter, petIdList);
    }

    @GetMapping(value = "/shelter/{name}")
    public Shelter getShelterByName(@PathVariable(value = "name") @Valid String name){
        return shelterService.getShelterByName(name);
    }

    @GetMapping(value = "/shelter/{id}")
    public Shelter getShelterById(@PathVariable(value = "id") Long shelterId) {
        return shelterService.getShelterById(shelterId);
    }

    @DeleteMapping(path = "shelter/{id}")
    public void deleteShelter(@PathVariable(value = "id") Long shelterId) {
        shelterService.deleteById(shelterId);
    }
}
