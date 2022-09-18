package services;

import exceptions.FoodItemNotFound;
import exceptions.HotelDoesNotExist;
import exceptions.OrderNotFoundException;
import models.Order;
import repository.OrderRepository;

import java.util.UUID;

public class OrderService {

    private final HotelService hotelService;
    private final OrderRepository orderRepository;

    public OrderService(HotelService hotelService, OrderRepository orderRepository) {
        this.hotelService = hotelService;
        this.orderRepository = orderRepository;
    }


    // create an order
    public void createOrder(UUID hotelId, UUID foodId, UUID userId) throws FoodItemNotFound, HotelDoesNotExist {
        // check if the item available
        if(hotelService.isAvailableFood(hotelId, foodId)) {
            orderRepository.createOrder(userId, hotelId, foodId);
        } else
            throw new FoodItemNotFound("request for ordering is not available");
    }


    public Order getOrderByUserId(UUID userId) throws OrderNotFoundException {
        return orderRepository.getOrderByUserId(userId);
    }


}
