package com.example.backendshelter.controller.request;

import com.example.backendshelter.model.ShelterColors;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateShelterRQ {


    private String name;
    private ShelterColors shelterColors;
    private String location;

    //private List<Long> petIdList;
}
