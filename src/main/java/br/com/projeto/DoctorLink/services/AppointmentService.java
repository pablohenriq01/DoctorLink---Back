package br.com.projeto.DoctorLink.services;

import br.com.projeto.DoctorLink.DTOs.AppointmentDTO;
import br.com.projeto.DoctorLink.models.Appointment;
import br.com.projeto.DoctorLink.models.Consultancy;
import br.com.projeto.DoctorLink.models.Patient;
import br.com.projeto.DoctorLink.repositories.AppointmentRepositorie;
import br.com.projeto.DoctorLink.repositories.ConsultancyRepository;
import br.com.projeto.DoctorLink.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepositorie appointmentRepositorie;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ConsultancyRepository consultancyRepository;


    public Appointment registerAppointment(AppointmentDTO dto) {
        Patient patient = patientRepository.findById(dto.patientId().longValue())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Consultancy consultancy = consultancyRepository.findById(dto.consultancyId().longValue())
                .orElseThrow(() -> new RuntimeException("Consultório não encontrado"));

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setConsultancy(consultancy);
        appointment.setStatus("Marcado");
        appointment.setDate(LocalDate.now());
        return appointmentRepositorie.save(appointment);
    }

    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepositorie.findByPatientId(patientId);
    }

    public List<Appointment> getAppointmentsByConsultancyId(Long consultancyId) {
        return appointmentRepositorie.findByConsultancyId(consultancyId);
    }

    public void deleteById(UUID id) {
        appointmentRepositorie.deleteById(id);
    }

    public void updateStatus(UUID id, String newStatus){
        Appointment appointment = appointmentRepositorie.findById(id).get();

        appointment.setStatus(newStatus);
        appointmentRepositorie.save(appointment);
    }

}
