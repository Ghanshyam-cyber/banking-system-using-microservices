package com.banking_system.transaction_service.service.client;

import com.banking_system.transaction_service.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/user/{userId}")
    UserDTO getUserById(@PathVariable("userId") Long userId);

    @GetMapping("/user/{firstName}")
    UserDTO getUserByFirstName(@PathVariable("firstName") String firstName);

    @GetMapping("/user/{lastName}")
    UserDTO getUserByLastName(@PathVariable("lastName") String lastName);
}
