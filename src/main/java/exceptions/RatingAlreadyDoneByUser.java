package exceptions;

import repository.RatingRepository;

public class RatingAlreadyDoneByUser extends  Exception {
    public RatingAlreadyDoneByUser(String msg) {
        super(msg);
    }
}
