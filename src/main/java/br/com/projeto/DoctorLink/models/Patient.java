package br.com.projeto.DoctorLink.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "tb_patients")
public class Patient {
    @Id
    private long id_user_fk;
    @OneToOne
    @MapsId
    @JoinColumn(name="id")
    private User user;
    @NotNull
    @Column(nullable = false, name = "date_birth")
    private Date dateBirth;
    @NotNull
    @Column(nullable = false)
    private int telephone;
}
