package upeu.edu.pe.reghost.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.edu.pe.reghost.entidades.Pacientes;

public interface PacientesRepositorio extends JpaRepository <Pacientes, Long> {

}
