package ma.enset.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;

    @NotBlank(message = "cannot be null")
    @Column(unique = true)
    private String username;
    private String email;

    @NotBlank(message = "cannot be null")
    private String password;

    @OneToMany(mappedBy = "user")
    private  List<Test> ownedTests;

    @ManyToMany(mappedBy = "users")
    @Column(name = "test_id")
    private List<Test> passedTests;
}
