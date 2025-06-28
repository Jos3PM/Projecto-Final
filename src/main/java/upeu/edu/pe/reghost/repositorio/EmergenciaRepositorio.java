package upeu.edu.pe.reghost.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import upeu.edu.pe.reghost.entidades.Emergencia;

import java.time.LocalDateTime;
import java.util.List;

public interface EmergenciaRepositorio extends JpaRepository<Emergencia, Long> {
    
    List<Emergencia> findByEstado(String estado);
    
    List<Emergencia> findByPrioridad(String prioridad);
    
    List<Emergencia> findByTipoEmergencia(String tipoEmergencia);
    
    @Query("SELECT COUNT(e) FROM Emergencia e WHERE e.estado = 'En Atención'")
    Long countEmergenciasEnAtencion();
    
    @Query("SELECT COUNT(e) FROM Emergencia e WHERE e.fechaHoraIngreso >= :fechaInicio")
    Long countEmergenciasHoy(@Param("fechaInicio") LocalDateTime fechaInicio);
    
    @Query("SELECT e.prioridad, COUNT(e) FROM Emergencia e GROUP BY e.prioridad")
    List<Object[]> countEmergenciasPorPrioridad();
    
    @Query("SELECT e.tipoEmergencia, COUNT(e) FROM Emergencia e GROUP BY e.tipoEmergencia")
    List<Object[]> countEmergenciasPorTipo();
    
    List<Emergencia> findByFechaHoraIngresoBetween(LocalDateTime inicio, LocalDateTime fin);
}