package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder @AllArgsConstructor @Getter @Setter
public class Food {
    private final String dishName;
    private final UUID id;
    private final float price;

}
