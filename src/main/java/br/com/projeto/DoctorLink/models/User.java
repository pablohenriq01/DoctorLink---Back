package br.com.projeto.DoctorLink.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Email(message = "Coloque um email valido!")
    @Column(nullable = false,unique = true)
    private String email;
    @NotNull
    @Column(nullable = false)
    private String password;
    @NotNull
    @Column(nullable = false, name = "type_user")
    private int typeUser;

    public User(String email, String password, int typeUser) {
        this.email = email;
        this.password = password;
        this.typeUser = typeUser;
    }
}
