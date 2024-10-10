package imf.hackato.entity;

import jakarta.validation.constraints.Email;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {
    private String id;
    private String name;
    private String lname;
    private byte age;
    @Email
    private String email;
    private String telephone;


}
