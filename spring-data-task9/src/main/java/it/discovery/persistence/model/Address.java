package it.discovery.persistence.model;

import lombok.Builder;

@Builder
public record Address(String city, String street, int apartment, String zip) {
}
