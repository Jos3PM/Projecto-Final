package upeu.edu.pe.reghost.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import upeu.edu.pe.reghost.servicio.PacienteServicio;
import upeu.edu.pe.reghost.servicio.DoctorServicio;
import upeu.edu.pe.reghost.servicio.EmergenciaServicio;

@Controller
public class MenuControlador {

    @Autowired
    private PacienteServicio pacienteServicio;

    @Autowired
    private DoctorServicio doctorServicio;

    @Autowired
    private EmergenciaServicio emergenciaServicio;

    @GetMapping("/menu")
    public String mostrarMenu(Model modelo) {
        // Estadísticas generales
        modelo.addAttribute("totalPacientes", pacienteServicio.listAll().size());
        modelo.addAttribute("totalDoctores", doctorServicio.listAll().size());
        modelo.addAttribute("doctoresDisponibles", doctorServicio.countDoctoresDisponibles());
        modelo.addAttribute("emergenciasEnAtencion", emergenciaServicio.countEmergenciasEnAtencion());
        modelo.addAttribute("emergenciasHoy", emergenciaServicio.countEmergenciasHoy());
        
        return "menu";
    }

    @GetMapping("/estadisticas")
    public String mostrarEstadisticas(Model modelo) {
        // Estadísticas detalladas
        modelo.addAttribute("totalPacientes", pacienteServicio.listAll().size());
        modelo.addAttribute("totalDoctores", doctorServicio.listAll().size());
        modelo.addAttribute("doctoresDisponibles", doctorServicio.countDoctoresDisponibles());
        modelo.addAttribute("emergenciasEnAtencion", emergenciaServicio.countEmergenciasEnAtencion());
        modelo.addAttribute("emergenciasHoy", emergenciaServicio.countEmergenciasHoy());
        
        // Estadísticas por especialidad
        modelo.addAttribute("estadisticasEspecialidad", doctorServicio.getEstadisticasPorEspecialidad());
        
        // Estadísticas de emergencias
        modelo.addAttribute("estadisticasPrioridad", emergenciaServicio.getEstadisticasPorPrioridad());
        modelo.addAttribute("estadisticasTipo", emergenciaServicio.getEstadisticasPorTipo());
        
        return "estadisticas";
    }
}