import exceptions.FoodItemNotFound;
import exceptions.HotelDoesNotExist;
import exceptions.OrderNotFoundException;
import models.Food;
import models.Order;
import repository.HotelRepository;
import repository.OrderRepository;
import repository.ProfileRepository;
import services.HotelService;
import services.OrderService;
import services.ProfileService;

import java.util.UUID;

public class Main {


    // add user -> profile service
    // add hotel/item -> hotel service
    // feed -> servicable -> get hotels by pincode and rating sorting
    // order -> order service -> add orderRepository
    // rating -> Rating obj of that hotel made entry validation for userId if already done rating, update cumulative rating

    private final HotelService hotelService;
    private final OrderService orderService;
    private final ProfileService profileService;
    private final ProfileRepository profileRepository;
    private final OrderRepository orderRepository;
    private final HotelRepository hotelRepository;

    public Main() {
        this.hotelRepository = new HotelRepository();
        this.orderRepository = new OrderRepository();
        this.profileRepository = new ProfileRepository();
        this.hotelService = new HotelService(hotelRepository);
        this.orderService = new OrderService(hotelService, orderRepository);
        this.profileService = new ProfileService(profileRepository);
    }

    public void registerHotel(String name, UUID id) {
        hotelService.registerHotel(name, id);
    }

    public void addFoodItem(Food food, UUID hotelId) {
        hotelService.addFoodItem(food, hotelId);
    }

    public void addUser(String name, UUID id) {
        profileService.addUser(name, id);
    }

    public void createOrder(UUID hotelId, UUID foodId, UUID userId) throws HotelDoesNotExist, FoodItemNotFound {
        orderService.createOrder(hotelId, foodId, userId);
    }

    public Order getOrderByUserId(UUID userId) throws OrderNotFoundException {
        return orderService.getOrderByUserId(userId);
    }
}
