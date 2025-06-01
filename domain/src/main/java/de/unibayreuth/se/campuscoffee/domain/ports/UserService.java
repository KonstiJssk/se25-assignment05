package de.unibayreuth.se.campuscoffee.domain.ports;

import de.unibayreuth.se.campuscoffee.api.dtos.UserDto;

import java.util.List;
import java.util.Optional;

/**
 * Interface for the implementation of the user service that the domain module provides as a port and implements itself.
 */
public interface UserService {
    void clear();

    List<UserDto> getAllUsers();

    Optional<Object> getById(Long id);

    Optional<Object> getByLogin(String login);

    de.unibayreuth.se.campuscoffee.api.dtos.UserDto create(de.unibayreuth.se.campuscoffee.api.dtos.UserDto dto);

    Optional<Object> update(Long id, de.unibayreuth.se.campuscoffee.api.dtos.UserDto dto);
    // TODO: Define user service.
}
