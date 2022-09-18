package repository;

import exceptions.OrderNotFoundException;
import models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderRepository {

    private final List<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>();
    }


    public void createOrder(UUID userId, UUID hotelId, UUID foodId) {

        Order newOrder = Order.builder()
                .foodId(foodId)
                .userId(userId)
                .hotelId(hotelId).build();

        orders.add(newOrder);
    }

    public Order getOrderByUserId(UUID userId) throws OrderNotFoundException {
        for(var order: orders) {
            if(order.getUserId() == userId) {
                return order;
            }
        }

        throw new OrderNotFoundException("order for given userId=" + userId + " is NOT present.");
    }
}
