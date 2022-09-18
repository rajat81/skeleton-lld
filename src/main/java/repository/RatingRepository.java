package repository;

import exceptions.RatingAlreadyDoneByUser;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RatingRepository {

    private final Map<UUID, Map<UUID, Integer>> hotelRatingMap;

    public RatingRepository() {
        this.hotelRatingMap = new HashMap<>();
    }

    public void rateHotel(int rating, UUID hotelId, UUID userId) throws RatingAlreadyDoneByUser {
        var hotelRating =hotelRatingMap.getOrDefault(hotelId, new HashMap<>());
        if(hotelRating.containsKey(userId)) {
            throw new RatingAlreadyDoneByUser("You have already rated for this hotel.");
        }

        hotelRating.put(userId, rating);
    }

}
