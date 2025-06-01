package de.unibayreuth.se.campuscoffee.api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

/**
 * DTO for user metadata.
 *
 */
@Data
@Builder(toBuilder = true)
public class UserDto {
    private Long id; // id is null when creating a new task
    // TODO: Implement user DTO.

    private Instant createdAt;
    private Instant updatedAt;

    @NotBlank(message = "Anmeldename darf nicht leer sein")
    @Pattern(regexp = "\\w+", message = "Anmeldename darf nur Wortzeichen enthalten (a-z, A-Z, 0-9, _)")
    private String login;

    @NotBlank(message = "E-Mail-Adresse darf nicht leer sein")
    @Email(message = "Ungültige E-Mail-Adresse")
    private String email;

    @NotBlank(message = "Vorname darf nicht leer sein")
    @Size(min = 1, max = 255, message = "Vorname muss zwischen 1 und 255 Zeichen lang sein")
    private String firstName;

    @NotBlank(message = "Nachname darf nicht leer sein")
    @Size(min = 1, max = 255, message = "Nachname muss zwischen 1 und 255 Zeichen lang sein")
    private String lastName;

}
