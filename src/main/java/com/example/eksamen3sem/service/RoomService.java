package com.example.eksamen3sem.service;

import com.example.eksamen3sem.entity.Room;
import com.example.eksamen3sem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    // Save a room
    public Room saveRoom(Room room) {
        // Add any business logic/validation if needed before saving
        return roomRepository.save(room);
    }

    // Get all rooms
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    // Get room by ID
    public Optional<Room> getRoomById(Long roomId) {
        return roomRepository.findById(roomId);
    }


    // Update a room
    public Room updateRoom(Room room) {
        // Add any business logic/validation if needed before updating
        return roomRepository.save(room);
    }

    // Delete a room
    public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);
    }

    //find all rooms in specific hotel
    public List<Room> findAllRoomsByHotelId(Long hotelId) {
        return roomRepository.findAllRoomsByHotelId(hotelId);
    }


}

