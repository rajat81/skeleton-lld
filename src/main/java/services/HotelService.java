package services;

import exceptions.HotelDoesNotExist;
import exceptions.RatingAlreadyDoneByUser;
import models.Food;
import repository.HotelRepository;

import java.util.UUID;

public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {

        this.hotelRepository = hotelRepository;
    }

    // register new hotel
    public void registerHotel(String hotel, UUID id) {
        this.hotelRepository.addHotel(hotel, id);
    }


    // add food item
    public void addFoodItem(Food food, UUID hotel) {
        this.hotelRepository.addFoodForHotel(food, hotel);
    }

    // check availability
    public boolean isAvailableFood(UUID hotelId, UUID foodId) throws HotelDoesNotExist {
        return this.hotelRepository.checkIfAvailable(hotelId, foodId);
    }

    // save rating for hotel
    public void rateHotel(int rating, UUID hotelId, UUID userId) throws RatingAlreadyDoneByUser {
        this.hotelRepository.rateHotel(rating, hotelId, userId);
    }
}
