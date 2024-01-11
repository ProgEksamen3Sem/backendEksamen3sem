package com.example.eksamen3sem.service;

import com.example.eksamen3sem.entity.Reservation;
import com.example.eksamen3sem.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // Save a reservation
    public Reservation saveReservation(Reservation reservation) {
        // Add any business logic/validation if needed before saving
        reservation.setCreated(LocalDateTime.now());
        return reservationRepository.save(reservation);
    }

    // Get all reservations
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // Get reservation by ID
    public Optional<Reservation> getReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId);
    }

    // Update a reservation
    public Reservation updateReservation(Reservation reservation) {
        // Add any business logic/validation if needed before updating
        reservation.setUpdated(LocalDateTime.now());
        return reservationRepository.save(reservation);
    }

    // Delete a reservation
    public void deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}
