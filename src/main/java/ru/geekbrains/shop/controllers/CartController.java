package ru.geekbrains.shop.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.shop.beans.Cart;
import ru.geekbrains.shop.dto.CartDto;

import java.util.List;

 /*
    http://localhost:8190/market/api/v2/cart/
    http://localhost:8190/market/api/v2/cart/all
    http://localhost:8190/market/api/v2/cart/add/10
    http://localhost:8190/market/api/v2/cart/delete/10
*/

@RestController
@RequestMapping("/api/v2/cart")
@RequiredArgsConstructor
public class CartController {
//    private final ProductServices services;
    private final Cart cart;

    @GetMapping
    public CartDto getCart() {
        return new CartDto(cart);
    }

    @GetMapping("/all")
    public List allItemsToCart() {
        return cart.viewCartProductList();
    }

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id) {
        cart.addToCart(id);
    }


    @GetMapping("/delete/{id}")
    public void removeByIdFromCart(@PathVariable Long id) {
        cart.removeProductFromCart(id);
    }

    @GetMapping("/clear")
    public void clearCart() {
        cart.clear();
    }
}
