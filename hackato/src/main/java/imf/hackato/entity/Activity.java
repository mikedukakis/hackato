package imf.hackato.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "activity")
@Schema(description = "Activity entity")
public class Activity {
    @Id
    private String id;
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
