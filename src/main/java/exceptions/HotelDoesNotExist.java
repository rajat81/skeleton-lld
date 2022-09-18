package exceptions;

public class HotelDoesNotExist extends Exception {
    public HotelDoesNotExist(String msg) {
        super(msg);
    }
}
