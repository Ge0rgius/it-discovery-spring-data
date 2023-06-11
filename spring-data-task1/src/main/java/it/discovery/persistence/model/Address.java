package it.discovery.persistence.model;

import jakarta.persistence.Embeddable;
import lombok.Builder;

@Embeddable
@Builder
public record Address(String city, String street, int apartment, String zip) {
}
