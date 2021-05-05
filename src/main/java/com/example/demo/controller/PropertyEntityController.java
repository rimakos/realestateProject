package com.example.demo.controller;


import com.example.demo.entity.PropertyEntity;
import com.example.demo.enumerations.CategoryName;
import com.example.demo.service.categoryEntity.CategoryEntityService;
import com.example.demo.service.propertyEntity.PropertyEntityService;
import com.example.demo.service.reservationEntity.ReservationEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PropertyEntityController {

    private PropertyEntityService propertyEntityService;
    private ReservationEntityService reservationEntityService;
    private CategoryEntityService categoryEntityService;

    @Autowired
    public PropertyEntityController
            (PropertyEntityService propertyEntityService,
             ReservationEntityService reservationEntityService,
             CategoryEntityService categoryEntityService) {
        this.propertyEntityService = propertyEntityService;
        this.reservationEntityService = reservationEntityService;
        this.categoryEntityService = categoryEntityService;
    }

    @GetMapping("/properties")
    public List<PropertyEntity> findAll() {
        return propertyEntityService.findAll();
    }

    @GetMapping("/properties/{propertyId}")
    public ResponseEntity getPropertyById(@PathVariable int propertyId) {

        PropertyEntity propertyEntity = propertyEntityService.findById(propertyId);
        if (propertyEntity == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(propertyEntity);

    }

    @PostMapping("/properties/add")
    public PropertyEntity addProperty(@RequestBody @Valid PropertyEntity propertyEntity) {
        propertyEntityService.save(propertyEntity);

        return propertyEntity;
    }

    @DeleteMapping("/properties/delete/{id}")

    public String deleteProperty(@PathVariable("id") int id) {
        String result = propertyEntityService.deleteById(id);
        return result;
    }
}
