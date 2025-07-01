package upeu.edu.pe.reghost.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.reghost.entidades.Emergencias;
import upeu.edu.pe.reghost.entidades.Doctores;
import upeu.edu.pe.reghost.servicio.EmergenciaServicio;
import upeu.edu.pe.reghost.servicio.DoctorServicio;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/emergencias")
public class EmergenciaControlador {

    @Autowired
    private EmergenciaServicio emergenciaServicio;
    
    @Autowired
    private DoctorServicio doctorServicio;

    @GetMapping("/")
    public String listarEmergencias(Model modelo) {
        List<Emergencias> listaEmergencias = emergenciaServicio.listAll();
        modelo.addAttribute("listaEmergencias", listaEmergencias);
        return "emergencias/lista_emergencias";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model modelo) {
        Emergencias emergencia = new Emergencias();
        emergencia.setFechaHora(LocalDateTime.now());
        
        // Obtener lista de doctores para el select
        List<Doctores> listaDoctores = doctorServicio.listAll();
        
        modelo.addAttribute("emergencia", emergencia);
        modelo.addAttribute("listaDoctores", listaDoctores);
        return "emergencias/nueva_emergencia";
    }

    @PostMapping("/guardar")
    public String guardarEmergencia(@ModelAttribute("emergencia") Emergencias emergencia) {
        if (emergencia.getFechaHora() == null) {
            emergencia.setFechaHora(LocalDateTime.now());
        }
        emergenciaServicio.save(emergencia);
        return "redirect:/emergencias/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model modelo) {
        Emergencias emergencia = emergenciaServicio.get(id);
        List<Doctores> listaDoctores = doctorServicio.listAll();
        
        modelo.addAttribute("emergencia", emergencia);
        modelo.addAttribute("listaDoctores", listaDoctores);
        return "emergencias/editar_emergencia";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEmergencia(@PathVariable("id") Long id) {
        emergenciaServicio.delete(id);
        return "redirect:/emergencias/";
    }
}