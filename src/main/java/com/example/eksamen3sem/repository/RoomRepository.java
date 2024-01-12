package com.example.eksamen3sem.repository;

import com.example.eksamen3sem.entity.Hotel;
import com.example.eksamen3sem.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByHotel(Hotel hotel);

    Optional<Room> findById(Long roomId);

    @Query("SELECT r FROM Room r WHERE r.hotel.id = :hotelId")
    List<Room> findAllRoomsByHotelId(@Param("hotelId") Long hotelId);
}
