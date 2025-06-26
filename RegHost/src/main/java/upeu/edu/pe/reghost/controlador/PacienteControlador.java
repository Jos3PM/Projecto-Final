package upeu.edu.pe.reghost.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.reghost.entidades.Pacientes;
import upeu.edu.pe.reghost.repositorio.PacientesRepositorio;
import upeu.edu.pe.reghost.servicio.PacienteServicio;

import java.util.List;
@Controller
public class PacienteControlador {

    @Autowired
    private PacienteServicio pacienteServicio;

    @GetMapping("/")
    public String verpagina(Model modelo) {
        List<Pacientes> listaPacientes = pacienteServicio.listAll();
        modelo.addAttribute("listaPacientes", listaPacientes);
        return "index";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model modelo) {
        Pacientes paciente = new Pacientes();
        modelo.addAttribute("paciente", paciente);
        return "nuevo_paciente";
    }

    @PostMapping("/guardar")
    public String guardarPaciente(@ModelAttribute("paciente") Pacientes paciente) {
        pacienteServicio.save(paciente);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model modelo) {
        Pacientes paciente = pacienteServicio.get(id);
        modelo.addAttribute("paciente", paciente);
        return "editar_paciente";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPaciente(@PathVariable("id") Long id) {
        pacienteServicio.delete(id);
        return "redirect:/";
    }
}
