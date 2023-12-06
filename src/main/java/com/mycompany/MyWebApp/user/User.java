package com.mycompany.MyWebApp.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(nullable = false, unique = true, length = 47)
    private String email;

    @Column(nullable = false, length = 17)
    private String password;

    @Column(nullable = false, name = "first_name", length = 47)
    private String firstname;

    @Column(nullable = false, name = "last_name", length = 47)
    private String lastname;

    private Boolean enabled;
}
