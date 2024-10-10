package imf.hackato.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Activity {
    private String name;
    private List<User> participants;
    private short maxCapacity;
    private String description;

    public Activity(String name, short maxCapacity, String description) {
        this.name = name;
        this.participants = new ArrayList<>();
        this.maxCapacity = maxCapacity;
        this.description = description;
    }
}
