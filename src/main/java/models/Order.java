package models;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;
@Builder @Getter
public class Order {

    UUID userId;
    UUID foodId;
    UUID hotelId;
}
