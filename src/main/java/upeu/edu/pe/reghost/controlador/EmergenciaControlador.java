package upeu.edu.pe.reghost.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.reghost.entidades.Emergencia;
import upeu.edu.pe.reghost.servicio.EmergenciaServicio;
import upeu.edu.pe.reghost.servicio.PacienteServicio;
import upeu.edu.pe.reghost.servicio.DoctorServicio;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/emergencias")
public class EmergenciaControlador {

    @Autowired
    private EmergenciaServicio emergenciaServicio;

    @Autowired
    private PacienteServicio pacienteServicio;

    @Autowired
    private DoctorServicio doctorServicio;

    @GetMapping
    public String listarEmergencias(Model modelo) {
        List<Emergencia> listaEmergencias = emergenciaServicio.listAll();
        modelo.addAttribute("listaEmergencias", listaEmergencias);
        return "emergencias/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model modelo) {
        Emergencia emergencia = new Emergencia();
        emergencia.setFechaHoraIngreso(LocalDateTime.now());
        modelo.addAttribute("emergencia", emergencia);
        modelo.addAttribute("listaPacientes", pacienteServicio.listAll());
        modelo.addAttribute("listaDoctores", doctorServicio.getDoctoresDisponibles());
        return "emergencias/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarEmergencia(@ModelAttribute("emergencia") Emergencia emergencia) {
        if (emergencia.getFechaHoraIngreso() == null) {
            emergencia.setFechaHoraIngreso(LocalDateTime.now());
        }
        emergenciaServicio.save(emergencia);
        return "redirect:/emergencias";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model modelo) {
        Emergencia emergencia = emergenciaServicio.get(id);
        modelo.addAttribute("emergencia", emergencia);
        modelo.addAttribute("listaPacientes", pacienteServicio.listAll());
        modelo.addAttribute("listaDoctores", doctorServicio.listAll());
        return "emergencias/editar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEmergencia(@PathVariable("id") Long id) {
        emergenciaServicio.delete(id);
        return "redirect:/emergencias";
    }

    @GetMapping("/prioridad/{prioridad}")
    public String listarPorPrioridad(@PathVariable("prioridad") String prioridad, Model modelo) {
        List<Emergencia> emergencias = emergenciaServicio.getEmergenciasPorPrioridad(prioridad);
        modelo.addAttribute("listaEmergencias", emergencias);
        modelo.addAttribute("filtro", "Prioridad: " + prioridad);
        return "emergencias/lista";
    }
}