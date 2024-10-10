package imf.hackato.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Schema(description = "User entity")
public class User {
    private String id;
    private String name;
    private String lname;
    private byte age;
    @Email
    private String email;
    private String telephone;


}
