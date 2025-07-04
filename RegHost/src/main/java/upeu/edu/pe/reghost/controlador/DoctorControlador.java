package upeu.edu.pe.reghost.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.reghost.entidades.Doctores;
import upeu.edu.pe.reghost.servicio.DoctorServicio;

import java.util.List;

@Controller
@RequestMapping("/doctores")
public class DoctorControlador {

    @Autowired
    private DoctorServicio doctorServicio;

    @GetMapping("/")
    public String listarDoctores(Model modelo) {
        List<Doctores> listaDoctores = doctorServicio.listAll();
        modelo.addAttribute("listaDoctores", listaDoctores);
        return "doctores/lista_doctores";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model modelo) {
        Doctores doctor = new Doctores();
        modelo.addAttribute("doctor", doctor);
        return "doctores/nuevo_doctor";
    }

    @PostMapping("/guardar")
    public String guardarDoctor(@ModelAttribute("doctor") Doctores doctor) {
        doctorServicio.save(doctor);
        return "redirect:/doctores/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model modelo) {
        Doctores doctor = doctorServicio.get(id);
        modelo.addAttribute("doctor", doctor);
        return "doctores/editar_doctor";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarDoctor(@PathVariable("id") Long id) {
        doctorServicio.delete(id);
        return "redirect:/doctores/";
    }
}