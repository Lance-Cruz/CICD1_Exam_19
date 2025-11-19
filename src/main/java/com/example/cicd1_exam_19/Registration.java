package com.example.cicd1_exam_19;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class Registration {

    @NotBlank
    private String attendeeName;
    @Email
    private String email;
    @Pattern(regexp="TK-[0-9]{4}")
    private String ticketCode;
    @Positive
    private int quantity;

    public Registration() {
    }

    public Registration(String attendeeName, String email, String ticketCode, int quantity) {
        this.attendeeName = attendeeName;
        this.email = email;
        this.ticketCode = ticketCode;
        this.quantity = quantity;
    }

    public String getAttendeeName() {
        return attendeeName;
    }

    public void setAttendeeName(String attendeName) {
        this.attendeeName = attendeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
