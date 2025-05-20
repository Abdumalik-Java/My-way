package abdumalik.dev.myway.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Email
    private String email;
    @Column(unique = true, nullable = false)
    private String username;
    @Size(min = 6, max = 20)
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String confirmPassword;
    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();

}