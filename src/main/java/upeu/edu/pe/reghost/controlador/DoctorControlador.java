package upeu.edu.pe.reghost.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.reghost.entidades.Doctor;
import upeu.edu.pe.reghost.servicio.DoctorServicio;

import java.util.List;

@Controller
@RequestMapping("/doctores")
public class DoctorControlador {

    @Autowired
    private DoctorServicio doctorServicio;

    @GetMapping
    public String listarDoctores(Model modelo) {
        List<Doctor> listaDoctores = doctorServicio.listAll();
        modelo.addAttribute("listaDoctores", listaDoctores);
        return "doctores/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model modelo) {
        Doctor doctor = new Doctor();
        modelo.addAttribute("doctor", doctor);
        return "doctores/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarDoctor(@ModelAttribute("doctor") Doctor doctor) {
        doctorServicio.save(doctor);
        return "redirect:/doctores";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model modelo) {
        Doctor doctor = doctorServicio.get(id);
        modelo.addAttribute("doctor", doctor);
        return "doctores/editar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarDoctor(@PathVariable("id") Long id) {
        doctorServicio.delete(id);
        return "redirect:/doctores";
    }

    @GetMapping("/disponibles")
    public String listarDoctoresDisponibles(Model modelo) {
        List<Doctor> doctoresDisponibles = doctorServicio.getDoctoresDisponibles();
        modelo.addAttribute("listaDoctores", doctoresDisponibles);
        return "doctores/disponibles";
    }
}