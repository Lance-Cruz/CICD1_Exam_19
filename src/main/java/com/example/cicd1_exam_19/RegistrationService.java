package com.example.cicd1_exam_19;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    private List<Registration> store =new ArrayList<>();

    public Registration create(Registration r) {
        store.add(r);
        return r;
    }

    public Optional<Registration> read(String ticketCode) {
        for (Registration r : store) {
            if (r.getTicketCode().equals(ticketCode)) {
                return Optional.of(r);
            }
        }
        return Optional.empty();
    }

    public Optional<Registration> update (Registration registration, String ticketCode) {
        for (Registration r : store) {
            if (r.getTicketCode().equals(ticketCode)) {
                r.setAttendeeName(registration.getAttendeeName());
                r.setEmail(registration.getEmail());
                r.setTicketCode(registration.getTicketCode());
                r.setQuantity(registration.getQuantity());
                return Optional.of(r);
            }
        }
        return Optional.empty();
    }

    public Registration delete(String ticketCode) {
        for (Registration r : store) {
            if(r.getTicketCode().equals(ticketCode)) {
                store.remove(r);
                return r;
            }
        }
        return null;
    }
}
