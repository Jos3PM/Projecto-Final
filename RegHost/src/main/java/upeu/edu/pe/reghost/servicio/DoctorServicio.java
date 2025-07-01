package upeu.edu.pe.reghost.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.edu.pe.reghost.entidades.Doctores;
import upeu.edu.pe.reghost.repositorio.DoctoresRepositorio;

import java.util.List;

@Service
public class DoctorServicio {
    @Autowired
    private DoctoresRepositorio doctoresRepositorio;

    public List<Doctores> listAll() {
        return doctoresRepositorio.findAll();
    }

    public void save(Doctores doctor) {
        doctoresRepositorio.save(doctor);
    }

    public Doctores get(Long id) {
        return doctoresRepositorio.findById(id).get();
    }

    public void delete(Long id) {
        doctoresRepositorio.deleteById(id);
    }
}