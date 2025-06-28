package upeu.edu.pe.reghost.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.edu.pe.reghost.entidades.Emergencia;
import upeu.edu.pe.reghost.repositorio.EmergenciaRepositorio;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmergenciaServicio {
    
    @Autowired
    private EmergenciaRepositorio emergenciaRepositorio;

    public List<Emergencia> listAll() {
        return emergenciaRepositorio.findAll();
    }

    public void save(Emergencia emergencia) {
        emergenciaRepositorio.save(emergencia);
    }

    public Emergencia get(Long id) {
        return emergenciaRepositorio.findById(id).orElse(null);
    }

    public void delete(Long id) {
        emergenciaRepositorio.deleteById(id);
    }

    public List<Emergencia> getEmergenciasPorEstado(String estado) {
        return emergenciaRepositorio.findByEstado(estado);
    }

    public List<Emergencia> getEmergenciasPorPrioridad(String prioridad) {
        return emergenciaRepositorio.findByPrioridad(prioridad);
    }

    public Long countEmergenciasEnAtencion() {
        return emergenciaRepositorio.countEmergenciasEnAtencion();
    }

    public Long countEmergenciasHoy() {
        LocalDateTime inicioHoy = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        return emergenciaRepositorio.countEmergenciasHoy(inicioHoy);
    }

    public List<Object[]> getEstadisticasPorPrioridad() {
        return emergenciaRepositorio.countEmergenciasPorPrioridad();
    }

    public List<Object[]> getEstadisticasPorTipo() {
        return emergenciaRepositorio.countEmergenciasPorTipo();
    }
}