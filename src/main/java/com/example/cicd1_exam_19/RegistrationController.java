package com.example.cicd1_exam_19;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.OK)
    public Optional<Registration> readController(@PathVariable String ticketCode) {
        return service.read(ticketCode);
    }

    @PutMapping("/{ticketCode}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Registration> updateController(@Valid @RequestBody Registration registration, @PathVariable String ticketCode) {
        return service.update(registration, ticketCode);
    }

    @DeleteMapping("/{ticketCode}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Registration deleteController(@PathVariable String ticketCode) {
        return service.delete(ticketCode);
    }

}
