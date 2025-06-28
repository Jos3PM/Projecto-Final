package upeu.edu.pe.reghost.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import upeu.edu.pe.reghost.entidades.Doctor;

import java.util.List;

public interface DoctorRepositorio extends JpaRepository<Doctor, Long> {
    
    List<Doctor> findByDisponibleTrue();
    
    List<Doctor> findByEspecialidad(String especialidad);
    
    List<Doctor> findByEstado(String estado);
    
    @Query("SELECT COUNT(d) FROM Doctor d WHERE d.disponible = true")
    Long countDoctoresDisponibles();
    
    @Query("SELECT d.especialidad, COUNT(d) FROM Doctor d GROUP BY d.especialidad")
    List<Object[]> countDoctoresPorEspecialidad();
}