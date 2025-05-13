package br.com.projeto.DoctorLink.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "tb_doctors")
public class Doctor {
    @Id
    private long id_user_fk;
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;
    @NotNull
    @Column(nullable = false)
    private String specialty;
    @NotNull
    @Column(nullable = false, name = "start_time")
    private LocalTime startTime;
    @NotNull
    @Column(nullable = false, name = "end_time")
    private LocalTime endTime;

}
