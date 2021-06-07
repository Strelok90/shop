package ru.geekbrains.shop.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.shop.model.entity.User;
import ru.geekbrains.shop.service.UserServices;


import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/users")
public class UsersController {
    private final UserServices services;


    @GetMapping
    public List findAllUsers() {

        return services.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
    return new User();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveNewProduct(@RequestBody User user) {
        user.setId(null);
        return services.saveOrUpdate(user);
    }

    @PutMapping
    public User updateProduct(@RequestBody User user) {
        return services.saveOrUpdate(user);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        services.deleteUserById(id);
    }
}
