package bf.isge.Bank.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserDto {

    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private int tel;
    private String dateNaissance;
    private String nationalite;
    private String email;
}
