package bf.isge.Bank.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "account")
@AllArgsConstructor
@EqualsAndHashCode(of = {"countNum","password"})
@Setter
@Getter

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )

    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "countNum",length =6, nullable = false, updatable = false)
    private int countNum;

   // @Column(name = "password", nullable = false, updatable = false)
   // private int password;

    @Column(name = "balance", nullable = false)
    private double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User users;


    public Account() {

    }
}
