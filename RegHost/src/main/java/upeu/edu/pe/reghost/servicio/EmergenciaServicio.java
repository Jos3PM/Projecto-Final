package upeu.edu.pe.reghost.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.edu.pe.reghost.entidades.Emergencias;
import upeu.edu.pe.reghost.repositorio.EmergenciasRepositorio;

import java.util.List;

@Service
public class EmergenciaServicio {
    @Autowired
    private EmergenciasRepositorio emergenciasRepositorio;

    public List<Emergencias> listAll() {
        return emergenciasRepositorio.findAll();
    }

    public void save(Emergencias emergencia) {
        emergenciasRepositorio.save(emergencia);
    }

    public Emergencias get(Long id) {
        return emergenciasRepositorio.findById(id).get();
    }

    public void delete(Long id) {
        emergenciasRepositorio.deleteById(id);
    }
}