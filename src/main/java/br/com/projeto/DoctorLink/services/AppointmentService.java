package br.com.projeto.DoctorLink.services;

import br.com.projeto.DoctorLink.DTOs.AppointmentDTO;
import br.com.projeto.DoctorLink.models.Appointment;
import br.com.projeto.DoctorLink.models.Consultancy;
import br.com.projeto.DoctorLink.models.Patient;
import br.com.projeto.DoctorLink.repositories.AppointmentRepositories;
import br.com.projeto.DoctorLink.repositories.ConsultancyRepository;
import br.com.projeto.DoctorLink.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepositories appointmentRepositories;

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

        return appointmentRepositories.save(appointment);
    }

    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepositories.findByPatientId(patientId);
    }

    public List<Appointment> getAppointmentsByConsultancyId(Long consultancyId) {
        return appointmentRepositories.findByConsultancyId(consultancyId);
    }
}
