package imf.hackato.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
@Schema(description = "User entity")
public class User {
    @Id
    private String id;
    private String name;
    private String lname;
    private byte age;
    @Email
    private String email;
    private String telephone;


}
