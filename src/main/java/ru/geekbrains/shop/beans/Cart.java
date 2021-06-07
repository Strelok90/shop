package ru.geekbrains.shop.beans;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.shop.model.OrderItem;
import ru.geekbrains.shop.model.Product;
import ru.geekbrains.shop.service.ProductServices;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
@Data
public class Cart {

    private final ProductServices services;
    private List<OrderItem> items;
    private int totalPrice;

    @PostConstruct
    public void init() {
        this.items = new ArrayList<>();
    }

    public List<String> viewCartProductList() {
        List<String> list = new ArrayList<>();
        return list;
    }

    public void addToCart(Long id) {
        for (OrderItem orderItem : items) {
            if (orderItem.getProduct().getId().equals(id)) {
                orderItem.incrementQuantity();
                reCount();
                return;
            }
        }
        Product product = services.findProductById(id).get();
        OrderItem orderItem = new OrderItem(product);
        items.add(orderItem);
        reCount();
    }

    public void removeProductFromCart(Long id) {
        Product p = services.findProductById(id).get();
    }

    public void clear() {
        items.clear();
        reCount();
    }

    public void reCount() {
        totalPrice = 0;
        for (OrderItem orderItem : items) {
            totalPrice += orderItem.getPrice();
        }
    }

}
