package ru.geekbrains.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.shop.model.entity.User;
import ru.geekbrains.shop.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServices {
    private final UserRepository repository;

    public Optional<User> findProductById(Long id) {
        return repository.findById(id);
    }

    public List<User> findAllProduct() {
        return repository.findAll();
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User saveOrUpdate(User user) {
        return repository.save(user);
    }

    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }
}
