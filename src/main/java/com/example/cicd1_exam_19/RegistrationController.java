package com.example.cicd1_exam_19;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    private final RegistrationService service;

    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Registration createController(@Valid @RequestBody Registration registration) {
        return service.create(registration);
    }

    @GetMapping("/{ticketCode}")
    public ResponseEntity<Optional<Registration>> readController(@Valid @PathVariable String ticketCode) {
        if (ticketCode != null) {
            return ResponseEntity.ok(service.read(ticketCode));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{ticketCode}")
    public ResponseEntity<Optional<Registration>> updateController(@Valid @RequestBody Registration registration, @Valid @PathVariable String ticketCode) {
        if (ticketCode != null) {
            return ResponseEntity.ok(service.update(registration,ticketCode));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{ticketCode}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Registration deleteController(@Valid @PathVariable String ticketCode) {
        return service.delete(ticketCode);
    }

}
