package com.example.eksamen3sem.service;

import com.example.eksamen3sem.entity.Hotel;
import com.example.eksamen3sem.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    // Save a hotel
    public Hotel saveHotel(Hotel hotel) {
        // Add any business logic/validation if needed before saving
        hotel.setCreated(LocalDateTime.now());
        return hotelRepository.save(hotel);
    }

    // Get all hotels
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    // Get hotel by ID
    public Optional<Hotel> getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId);
    }

    // Update a hotel
    public Hotel updateHotel(Hotel hotel) {
        // Add any business logic/validation if needed before updating
        hotel.setUpdated(LocalDateTime.now());
        return hotelRepository.save(hotel);
    }

    // Delete a hotel
    public void deleteHotel(Long hotelId) {
        hotelRepository.deleteById(hotelId);
    }
}
