package com.example.eksamen3sem.api;

import com.example.eksamen3sem.entity.Hotel;
import com.example.eksamen3sem.service.HotelService;
import com.example.eksamen3sem.service.RoomService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        try {
            Hotel createdHotel = hotelService.saveHotel(hotel);
            return new ResponseEntity<>(createdHotel, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle any exception (e.g., validation error, conflicting hotel)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        System.out.println("Getting all hotels");
        List<Hotel> hotels = hotelService.getAllHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long hotelId) {
        System.out.println("Search hotel id " + hotelId);
        Optional<Hotel> hotel = hotelService.getHotelById(hotelId);
        System.out.println("Search hotel found " + hotel.isPresent());
        return hotel.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/search")
    public ResponseEntity<Hotel> search(@PathParam("name") String name) {
        List<Hotel> hotel = hotelService.search(name);
        return hotel.stream().findAny().map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
        try {
            Hotel updatedHotel = hotelService.updateHotel(hotel);
            return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
        } catch (Exception e) {
            // Handle any exception (e.g., validation error, conflicting hotel)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{hotelId}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long hotelId) {
        hotelService.deleteHotel(hotelId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byType/{type}")
    public List<Hotel> getHotelsByType(@PathVariable String type) {
        return hotelService.findByHotelType(type);
    }
}
