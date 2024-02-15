package com.tomikcode.customer.model;

public record CustomerRegistrationRequest(
        String firstname,
        String lastname,
        String email) {
}
