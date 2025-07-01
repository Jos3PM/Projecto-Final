package upeu.edu.pe.reghost.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.edu.pe.reghost.entidades.Pacientes;
import upeu.edu.pe.reghost.repositorio.PacientesRepositorio;

import java.util.List;


@Service
public class PacienteServicio {
    @Autowired
    private PacientesRepositorio pacientesRepositorio;

    public List<Pacientes> listAll() {
        return pacientesRepositorio.findAll();
    }
    public void save(Pacientes pacientes) {
        pacientesRepositorio.save(pacientes);
    }
    public Pacientes get(Long id) {
        return pacientesRepositorio.findById(id).get();
    }
    public void delete(Long id) {
        pacientesRepositorio.deleteById(id);
    }
}
