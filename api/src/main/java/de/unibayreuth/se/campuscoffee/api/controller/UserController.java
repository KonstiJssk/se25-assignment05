package de.unibayreuth.se.campuscoffee.api.controller;

import de.unibayreuth.se.campuscoffee.api.dtos.UserDto;
import de.unibayreuth.se.campuscoffee.domain.ports.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "CampusCoffee",
                version = "0.0.1"
        )
)
@Tag(name = "Users")
@Controller
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    // TODO: implement the required endpoints here.

        private final UserService userService;

        @GetMapping
        public List<UserDto> getAllUsers() {
                return userService.getAllUsers();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Object> getById(@PathVariable Long id) {
                return userService.getById(id)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
        }

        @GetMapping("/by-login/{login}")
        public ResponseEntity<Object> getByLogin(@PathVariable String login) {
                return userService.getByLogin(login)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
        }

        @Valid
        @PostMapping
        public UserDto create(@RequestBody UserDto dto) {
                return userService.create(dto);
        }
        @Valid
        @PutMapping("/{id}")
        public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody UserDto dto) {
                return userService.update(id, dto)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
        }

        @GetMapping("/filter")
        public ResponseEntity<Object> filterByLogin(@RequestParam String login) {
                return userService.getByLogin(login)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
        }


}
