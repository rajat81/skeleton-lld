package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@AllArgsConstructor @Setter @Getter
@Builder(toBuilder = true)
public class User {

    private final String name;
    private final UUID id;

}
