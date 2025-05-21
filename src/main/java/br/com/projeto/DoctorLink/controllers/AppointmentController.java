package br.com.projeto.DoctorLink.controllers;

import br.com.projeto.DoctorLink.DTOs.AppointmentDTO;
import br.com.projeto.DoctorLink.DTOs.AppointmentStatusDTO;
import br.com.projeto.DoctorLink.models.Appointment;
import br.com.projeto.DoctorLink.services.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<?> registerAppointment(@RequestBody @Valid AppointmentDTO dto) {
        Appointment saved = appointmentService.registerAppointment(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatient(@PathVariable Long patientId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByPatientId(patientId);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/consultancy/{consultancyId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByConsultancy(@PathVariable Long consultancyId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByConsultancyId(consultancyId);
        return ResponseEntity.ok(appointments);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable UUID id) {
        appointmentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable UUID id, @RequestBody AppointmentStatusDTO dto){
        try {
            appointmentService.updateStatus(id,dto.status());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
