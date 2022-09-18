package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Builder(toBuilder=true) @Setter @Getter
public class Hotel {
    private final String name;
    private final Food foodItem;
    private final UUID id;
    private final float rating;
    private final int ratingCount;
}
