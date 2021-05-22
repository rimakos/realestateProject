package com.example.demo.controller.thymeleafController;

import com.example.demo.entity.Reservation;
import com.example.demo.service.category.CategoryService;
import com.example.demo.service.property.PropertyService;
import com.example.demo.service.reservation.ReservationService;
import com.example.demo.service.reservation.SaveNewClientReservationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ReservationThymeController {
    private ReservationService reservationService;
    private PropertyService propertyService;
    private CategoryService categoryService;

    public ReservationThymeController(final PropertyService propertyService
            , CategoryService categoryService, ReservationService reservationService) {
        this.propertyService = propertyService;
        this.categoryService = categoryService;
        this.reservationService = reservationService;

    }


    @GetMapping("/showreservationsform/{id}")
    public String showReservationForm(@PathVariable int id, Model theModel) {
        var property = this.propertyService.findById(id);
        theModel.addAttribute("property", property);

        var reservation = new SaveNewClientReservationDTO();
        reservation.setPropertyId(property.getId());
        reservation.setFinalPrice(property.getPrice());
        theModel.addAttribute("reservation", reservation);
        return "property-details";
    }


    @PostMapping("reservations/save")
    public String SaveReservation(@Valid SaveNewClientReservationDTO reservation, ModelMap model) {
        reservationService.save(reservation);
        return "redirect:/";
    }


    @GetMapping("/properties/{propertyId}")
    public String getProperties(@PathVariable int propertyId, final ModelMap modelMap) {
        var properties = this.propertyService.findById(propertyId);
        modelMap.addAttribute("properties", properties);
        var categories = this.categoryService.findAll();
        modelMap.addAttribute("categories", categories);
        return "property-details";
    }
}
