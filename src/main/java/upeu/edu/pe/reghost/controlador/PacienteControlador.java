package upeu.edu.pe.reghost.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.reghost.entidades.Pacientes;
import upeu.edu.pe.reghost.servicio.PacienteServicio;
import upeu.edu.pe.reghost.servicio.DoctorServicio;

import java.util.List;

@Controller
public class PacienteControlador {

    @Autowired
    private PacienteServicio pacienteServicio;

    @Autowired
    private DoctorServicio doctorServicio;

    @GetMapping("/")
    public String verpagina(Model modelo) {
        return "redirect:/menu";
    }

    @GetMapping("/pacientes")
    public String listarPacientes(Model modelo) {
        List<Pacientes> listaPacientes = pacienteServicio.listAll();
        modelo.addAttribute("listaPacientes", listaPacientes);
        return "pacientes/lista";
    }

    @GetMapping("/pacientes/nuevo")
    public String mostrarFormularioNuevo(Model modelo) {
        Pacientes paciente = new Pacientes();
        modelo.addAttribute("paciente", paciente);
        modelo.addAttribute("listaDoctores", doctorServicio.getDoctoresDisponibles());
        return "pacientes/nuevo";
    }

    @PostMapping("/pacientes/guardar")
    public String guardarPaciente(@ModelAttribute("paciente") Pacientes paciente) {
        pacienteServicio.save(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/pacientes/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model modelo) {
        Pacientes paciente = pacienteServicio.get(id);
        modelo.addAttribute("paciente", paciente);
        modelo.addAttribute("listaDoctores", doctorServicio.listAll());
        return "pacientes/editar";
    }

    @GetMapping("/pacientes/eliminar/{id}")
    public String eliminarPaciente(@PathVariable("id") Long id) {
        pacienteServicio.delete(id);
        return "redirect:/pacientes";
    }
}