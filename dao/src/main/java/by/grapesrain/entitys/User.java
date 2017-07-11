package by.grapesrain.entitys;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Daynekoa on 27.05.2017.
 */
@Entity
@Table(name = "user")
@ToString(callSuper = true)
@NoArgsConstructor
public class User extends BaseEntity {

    public User(String firstName, String lastName, String login, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User(String firstName, String lastName, String login, String password, String email, Departament departament) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.departament = departament;
    }

    @Getter
    @Setter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Setter
    @Column(name = "last_name")
    private String lastName;

    @Getter
    @Setter
    @Column(name = "login")
    private String login;

    @Getter
    @Setter
    @Column(name = "password")
    private String password;

    @Getter
    @Setter
    @Column(name = "email")
    private String email;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "departament_id")
    private Departament departament;

    @Version
    @Setter
    @Getter
    private Long version;
}
