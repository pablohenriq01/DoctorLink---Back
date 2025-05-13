package br.com.projeto.DoctorLink.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_patients")
public class Patients {
    @Id
    private long id;
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
