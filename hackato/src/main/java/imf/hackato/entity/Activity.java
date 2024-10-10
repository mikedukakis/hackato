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
    private String nom;
    private List<User> participants;
    private short capacitat_màxima;
    private String descripció;

    public Activity(String nom, short capacitat_màxima, String descripció) {
        this.nom = nom;
        this.participants = new ArrayList<>();
        this.capacitat_màxima = capacitat_màxima;
        this.descripció = descripció;
    }
}
