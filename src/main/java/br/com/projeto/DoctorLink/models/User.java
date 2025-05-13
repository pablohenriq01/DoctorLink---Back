package br.com.projeto.DoctorLink.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "tb_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(nullable = false)
    private String name;
    @NotNull
    @Email(message = "Coloque um email valido!")
    @Column(nullable = false,unique = true)
    private String email;
    @NotNull
    @Column(nullable = false)
    private String password;
    @NotNull
    @Column(nullable = false)
    private int type_user;

    public User(String name, String email, String password, int type_user) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type_user = type_user;
    }
}
