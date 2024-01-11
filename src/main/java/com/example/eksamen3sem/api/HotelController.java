package com.example.eksamen3sem.api;

import com.example.eksamen3sem.entity.Hotel;
import com.example.eksamen3sem.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }
}

