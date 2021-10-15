package com.example.backendshelter.controller.request;

import com.example.backendshelter.model.FoodType;
import lombok.*;

import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateFoodRQ {
        @Size(max = 255, message = "Description is too large")
        private String description;

        private FoodType brand;
        //private String brand;

}
