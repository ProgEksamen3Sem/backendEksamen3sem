// GuestController.java
package com.example.eksamen3sem.api;

import com.example.eksamen3sem.entity.Guest;
import com.example.eksamen3sem.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/guests")
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping("/create")
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) {
        try {
            Guest createdGuest = guestService.createGuest(guest);
            return new ResponseEntity<>(createdGuest, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle any exception (e.g., validation error, duplicate guest)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}


