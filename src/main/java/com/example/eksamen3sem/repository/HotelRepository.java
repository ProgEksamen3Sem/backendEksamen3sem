package com.example.eksamen3sem.repository;

import com.example.eksamen3sem.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

 List<Hotel> findByNameContaining(String name);

 @Query("SELECT h FROM Hotel h WHERE h.type = :type")
 List<Hotel> findByHotelType(@Param("type") String hotelType);
}

