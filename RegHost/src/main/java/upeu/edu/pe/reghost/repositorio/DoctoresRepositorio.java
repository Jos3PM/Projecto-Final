package upeu.edu.pe.reghost.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.edu.pe.reghost.entidades.Doctores;

public interface DoctoresRepositorio extends JpaRepository<Doctores, Long> {
}