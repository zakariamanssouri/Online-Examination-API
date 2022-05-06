package ma.enset.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User owner;

    @ManyToMany
    @Column(name = "user_id")
    @JoinTable(name = "passed_tests")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<User> users;
}
