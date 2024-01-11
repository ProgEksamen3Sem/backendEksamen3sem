package com.example.eksamen3sem.config;

import com.example.eksamen3sem.entity.Hotel;
import com.example.eksamen3sem.entity.Room;
import com.example.eksamen3sem.repository.HotelRepository;
import com.example.eksamen3sem.repository.RoomRepository;
import com.example.eksamen3sem.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Random;

@Configuration
public class DummyDataConfig implements CommandLineRunner {

        @Autowired
        private final HotelService hotelService;
        private final HotelRepository hotelRepository;
        private final RoomRepository roomRepository;
        private final Random random = new Random();


    public DummyDataConfig(HotelService hotelService, HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.hotelService = hotelService;
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

    @Override
        public void run(String... args) throws Exception {
            for (int i = 1; i <= 250; i++) {
                Hotel hotel = new Hotel();
                hotel.setName("Dummy Hotel " + i);
                hotel.setStreet("Dummy street " + i);
                hotel.setCity("Dummy city");
                hotel.setZip("2000");
                hotel.setCountry("DummyCountry");
                hotel.setCreated(LocalDateTime.now()); // Set created field
                hotel.setUpdated(LocalDateTime.now()); // Set updated field
                //hotelRepository.save(hotel);

                int numberOfRooms = 10 + random.nextInt(31); // 10-40 rooms
                for (int j = 1; j <= numberOfRooms; j++) {
                    Room room = new Room();
                    room.setRoomNumber("Room " + j);
                    room.setNumberOfBeds(1 + random.nextInt(4)); // 1-4 beds
                    room.setHotel(hotel);
                    room.setPricePerNight(500 * room.getNumberOfBeds()); // price 500 times beds in a room
                    room.setCreated(LocalDateTime.now()); // Set created field for Room
                    room.setUpdated(LocalDateTime.now()); // Set updated field for Room
                    //roomRepository.save(room);
                }
            }
            // System.out.println(hotelService.getNumberOfRooms(1));
        //TODO fiks så alle hoteller har 10-40 værelser!!!

        }
    }


