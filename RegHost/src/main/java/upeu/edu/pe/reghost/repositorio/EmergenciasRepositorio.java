package upeu.edu.pe.reghost.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.edu.pe.reghost.entidades.Emergencias;

public interface EmergenciasRepositorio extends JpaRepository<Emergencias, Long> {
}