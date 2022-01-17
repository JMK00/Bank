package bf.isge.Bank.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "client")
@AllArgsConstructor
@EqualsAndHashCode(of = {"email"})
@Getter
@Setter

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )

    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "password", length =4, nullable = false)
    private String password;

    @Column(name = "tel", nullable = false)
    private int tel;

    @Column(name = "dateNaissance", nullable = false)
    private String dateNaissance;

    @Column(name = "nationalite", nullable = false)
    private String nationalite;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private List<Account>accountList;


    public User() {

    }
}
