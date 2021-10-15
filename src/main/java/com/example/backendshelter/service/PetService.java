package com.example.backendshelter.service;
import com.example.backendshelter.exception.PetNotFound;
import com.example.backendshelter.model.Pet;
import com.example.backendshelter.model.Shelter;
import com.example.backendshelter.repository.PetRepository;
import com.example.backendshelter.controller.request.CreatePetFeedRQ;
import com.example.backendshelter.controller.request.CreatePetRQ;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final ShelterService shelterService;

    public PetService(PetRepository petRepository, ShelterService shelterService) {
        this.petRepository = petRepository;
        this.shelterService = shelterService;
    }


    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    //Saving several Pets using a List<petId> into a Shelter
    public List<Pet> save(List<CreatePetRQ> createPetRQList) {
        List<Pet> newPetList = new ArrayList<>();
        Pet newPet;
        Shelter shelter;
        for (CreatePetRQ createPetRQ : createPetRQList) {
            shelter = shelterService.getShelterById(createPetRQ.getShelterId());
            newPet = Pet.builder().petType(createPetRQ.getPetType()).name(createPetRQ.getName()).shelter(shelter).build();
            petRepository.save(newPet);
            newPetList.add(newPet);
        }
        return newPetList;
    }

    public Pet findById(Long id) {
        return petRepository.findById(id).orElseThrow(() -> new PetNotFound("Pet doesn't exists."));
    }

    public Pet addNewPetFeed(CreatePetFeedRQ createPetFeedRQ) {

        return null;
    }

    public boolean checkIfPetIsOnShelter(Pet pet) {
        if (pet.getId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Pet not found in the refugee.");
        }
        return this.petRepository.existsById(pet.getId());
    }
}
