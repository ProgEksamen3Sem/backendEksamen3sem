package com.example.eksamen3sem;

import com.example.eksamen3sem.entity.Hotel;
import com.example.eksamen3sem.repository.HotelRepository;
import com.example.eksamen3sem.repository.RoomRepository;
import com.example.eksamen3sem.service.HotelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HotelServiceTest {

    @Mock
    private HotelRepository hotelRepository;

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private HotelService hotelService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveHotel() {
        // Create a sample hotel
        Hotel hotel = new Hotel();
        hotel.setName("Sample Hotel");

        // Mock the behavior of the repository save method
        when(hotelRepository.save(any())).thenReturn(hotel);

        // Call the service method
        Hotel savedHotel = hotelService.saveHotel(hotel);

        // Verify the save method was called with the correct argument
        verify(hotelRepository, times(1)).save(hotel);

        // Assert that the returned hotel is the same as the mocked one
        assertEquals(hotel, savedHotel);
    }

    @Test
    void getAllHotels() {
        // Create a list of sample hotels
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel());
        hotels.add(new Hotel());

        // Mock the behavior of the repository findAll method
        when(hotelRepository.findAll()).thenReturn(hotels);

        // Call the service method
        List<Hotel> result = hotelService.getAllHotels();

        // Verify the findAll method was called
        verify(hotelRepository, times(1)).findAll();

        // Assert that the returned list is the same as the mocked one
        assertEquals(hotels, result);
    }

    @Test
    void getHotelById() {
        // Create a sample hotel
        Hotel hotel = new Hotel();
        hotel.setId(1L);

        // Mock the behavior of the repository findById method
        when(hotelRepository.findById(1L)).thenReturn(Optional.of(hotel));

        // Call the service method
        Optional<Hotel> result = hotelService.getHotelById(1L);

        // Verify the findById method was called with the correct argument
        verify(hotelRepository, times(1)).findById(1L);

        // Assert that the returned optional contains the correct hotel
        assertTrue(result.isPresent());
        assertEquals(hotel, result.get());
    }


}

