package br.com.projeto.DoctorLink.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "tb_doctors")
public class Doctors {
    @Id
    private long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;
    @NotNull
    @Column(nullable = false)
    private String crm;
    @NotNull
    @Column(nullable = false, name = "start_time")
    private LocalTime startTime;
    @NotNull
    @Column(nullable = false, name = "end_time")
    private LocalTime endTime;

}
