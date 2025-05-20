package abdumalik.dev.myway.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @Email
    private String email;
    @Column(unique = true, nullable = false)
    private String username;
    @Size(min = 6, max = 20)
    private String password;
    private String confirmPassword;

}