package org.example.senddatatodb.DTO;

public record StudentResponse(
        Long id,
        String firstName,
        String lastName,
        String email
) {
}
