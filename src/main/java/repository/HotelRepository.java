package repository;

import exceptions.HotelDoesNotExist;
import exceptions.RatingAlreadyDoneByUser;
import models.Food;
import models.Hotel;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HotelRepository {

    Map<UUID, Hotel> hotelMap;
    RatingRepository ratingRepo;

    public HotelRepository() {
        this.hotelMap = new HashMap<>();
        this.ratingRepo = new RatingRepository();
    }


    // addHotel(hotel)
    public void addHotel(String hotelName, UUID id) {
        hotelMap.put(id, Hotel.builder().name(hotelName).ratingCount(0).id(id).build());
    }

    // addFoodForHotel(food, hotel);
    public void addFoodForHotel(Food food, UUID hotelId) {
        Hotel hotel = hotelMap.get(hotelId);
        Hotel withFood = hotel.toBuilder().foodItem(food).build();

        hotelMap.put(hotel.getId(), withFood);
    }

    // checkIfAvailable(hotelId, foodId);
    public boolean checkIfAvailable(UUID hotelId, UUID foodId) throws HotelDoesNotExist {
        var hotel = hotelMap.getOrDefault(hotelId, null);
        if(hotel == null) {
            throw new HotelDoesNotExist("Hotel with given hotelId does not exist.");
        }
        return hotel.getFoodItem().getId().equals(foodId);
    }

    // rateHotel(rating, hotelId);
    public void rateHotel(int rating, UUID hotelId, UUID userId) throws RatingAlreadyDoneByUser {
        if(hotelMap.containsKey(hotelId)) {  // ToDO extract this to service than to repo
            this.ratingRepo.rateHotel(rating, hotelId, userId);
            var hotel = hotelMap.get(hotelId);
            float newRating = (hotel.getRating()*hotel.getRatingCount() + rating)/(hotel.getRatingCount()+1);
            var newHotel = hotel.toBuilder().ratingCount(hotel.getRatingCount()+1).rating(newRating).build();

            hotelMap.put(hotelId, newHotel);
        }
    }

}
