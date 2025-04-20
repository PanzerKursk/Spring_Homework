package homework3.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@Component
public class User {

    private String Name;
    private Integer Age;
    private String Email;

}
