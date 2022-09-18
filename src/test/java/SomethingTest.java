import exceptions.FoodItemNotFound;
import exceptions.HotelDoesNotExist;
import exceptions.OrderNotFoundException;
import models.Food;
import models.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.HotelService;
import services.OrderService;
import services.ProfileService;

import java.util.UUID;

public class SomethingTest {

    Main main;
    UUID h1 = UUID.randomUUID();
    UUID h2 = UUID.randomUUID();
    UUID u1 = UUID.randomUUID();
    UUID u2 = UUID.randomUUID();
    UUID fId1 = UUID.randomUUID();
    UUID fId2 = UUID.randomUUID();
    public SomethingTest() {
        this.main = new Main();
    }

    @Before
    public void init() {

        main.registerHotel("Sadanad Hotel", h1);
        main.registerHotel("Sandeep Hotel", h2);

        Food f1 = Food.builder().id(fId1).dishName("Mutton").price(120).build();
        Food f2 = Food.builder().id(fId2).dishName("Chicken").price(220).build();
        main.addFoodItem(f1, h1);
        main.addFoodItem(f2, h2);

        main.addUser("Rajat", u1);
        main.addUser("Vindie", u2);
    }

    @Test(expected = HotelDoesNotExist.class)
    public void getThisTested() throws FoodItemNotFound, HotelDoesNotExist, OrderNotFoundException {

        main.createOrder(UUID.randomUUID(), fId1, u1);
        Order order = main.getOrderByUserId(u1);
    }


    @Test
    public void testHappyOrderCreation() throws FoodItemNotFound, HotelDoesNotExist, OrderNotFoundException {
        main.createOrder(h1, fId1, u1);
        Order order = main.getOrderByUserId(u1);
    }

}
