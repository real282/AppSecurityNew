package Model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "db_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String LastName;

    @Column(name = "email")
    private String email;

    public User(String name, String lastName, String email) {
        this.name = name;
        this.LastName = lastName;
        this.email = email;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
