package com.example.eksamen3sem.service;

import com.example.eksamen3sem.entity.Guest;
import com.example.eksamen3sem.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    // Save a guest
    public Guest saveGuest(Guest guest) {
        // Add any business logic/validation if needed before saving
        guest.setCreated(LocalDateTime.now());
        return guestRepository.save(guest);
    }

    // Get all guests
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    // Get guest by ID
    public Optional<Guest> getGuestById(Long guestId) {
        return guestRepository.findById(guestId);
    }

    // Update a guest
    public Guest updateGuest(Guest guest) {
        // Add any business logic/validation if needed before updating
        guest.setUpdated(LocalDateTime.now());
        return guestRepository.save(guest);
    }

    // Delete a guest
    public void deleteGuest(Long guestId) {
        guestRepository.deleteById(guestId);
    }
}

