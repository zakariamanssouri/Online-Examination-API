package ma.enset.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Test {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String link;

    @Column(unique = true)
    private String code;

    @ManyToOne
    private User owner;

    @ManyToMany
    @Column(name = "user_id")
    @JoinTable(name = "passed_tests")
    private List<User> users;
}
