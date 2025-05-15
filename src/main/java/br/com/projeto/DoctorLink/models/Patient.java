package br.com.projeto.DoctorLink.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_patients")
public class Patient {
    @Id
    private long id_user_fk;
    @OneToOne
    @MapsId
    @JoinColumn(name="id")
    private User user;
    @NotNull
    @Column(nullable = false)
    private String name;
    @NotNull
    @Column(nullable = false, name = "date_birth")
    private LocalDate dateBirth;
    @NotNull
    @Column(nullable = false)
    private String telephone;
}
