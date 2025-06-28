package upeu.edu.pe.reghost.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.edu.pe.reghost.entidades.Doctor;
import upeu.edu.pe.reghost.repositorio.DoctorRepositorio;

import java.util.List;

@Service
public class DoctorServicio {
    
    @Autowired
    private DoctorRepositorio doctorRepositorio;

    public List<Doctor> listAll() {
        return doctorRepositorio.findAll();
    }

    public void save(Doctor doctor) {
        doctorRepositorio.save(doctor);
    }

    public Doctor get(Long id) {
        return doctorRepositorio.findById(id).orElse(null);
    }

    public void delete(Long id) {
        doctorRepositorio.deleteById(id);
    }

    public List<Doctor> getDoctoresDisponibles() {
        return doctorRepositorio.findByDisponibleTrue();
    }

    public List<Doctor> getDoctoresPorEspecialidad(String especialidad) {
        return doctorRepositorio.findByEspecialidad(especialidad);
    }

    public Long countDoctoresDisponibles() {
        return doctorRepositorio.countDoctoresDisponibles();
    }

    public List<Object[]> getEstadisticasPorEspecialidad() {
        return doctorRepositorio.countDoctoresPorEspecialidad();
    }
}