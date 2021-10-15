package com.example.backendshelter.service;

import com.example.backendshelter.model.Pet;
import com.example.backendshelter.model.Shelter;
import com.example.backendshelter.repository.PetRepository;
import com.example.backendshelter.repository.ShelterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShelterService {

    private final ShelterRepository shelterRepository;
    private final PetRepository petRepository;

    public ShelterService(ShelterRepository shelterRepository, PetRepository petRepository) {
        this.shelterRepository = shelterRepository;
        this.petRepository = petRepository;
    }


    public Shelter createShelter(Shelter newShelter){
        return shelterRepository.save(newShelter);
    }

    public Shelter getShelterById(Long aLong){
        return shelterRepository.getById(aLong);
    }

    //Creating a List<Pet> based in a List<Long> petIdList and saving it to the shelter
    public Shelter addPetsToShelter(Shelter getShelter, List<Long> petIdList) {
        List<Pet> petList = new ArrayList<>();
        for( Long i : petIdList){
            petList.add(petRepository.getById(i));
        }
        getShelter.setPetList(petList);
        return shelterRepository.save(getShelter);
    }

    //Going throw all existing Shelters names and comparing them with Client input, returning the Shelter that matches
    public Shelter getShelterByName(String name) {
        List<Shelter> allShelters = shelterRepository.findAll();
        Shelter shelter;
        for(int i = 0; i < allShelters.size(); i++){
            if(allShelters.get(i).getName() == name)
            return allShelters.get(i);
        }
        return null;
    }

    public void deleteById(Long shelterId) {
        shelterRepository.deleteById(shelterId);
    }
}
