package upeu.edu.pe.reghost.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.reghost.entidades.Pacientes;
import upeu.edu.pe.reghost.servicio.PacienteServicio;
import upeu.edu.pe.reghost.servicio.DocumentoWordServicio;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class PacienteControlador {

    @Autowired
    private PacienteServicio pacienteServicio;
    
    @Autowired
    private DocumentoWordServicio documentoWordServicio;

    @GetMapping("/")
    public String listarPacientes(Model modelo) {
        List<Pacientes> listaPacientes = pacienteServicio.listAll();
        modelo.addAttribute("listaPacientes", listaPacientes);
        return "pacientes/lista_pacientes";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model modelo) {
        Pacientes paciente = new Pacientes();
        modelo.addAttribute("paciente", paciente);
        return "pacientes/nuevo_paciente";
    }

    @PostMapping("/guardar")
    public String guardarPaciente(@ModelAttribute("paciente") Pacientes paciente) {
        pacienteServicio.save(paciente);
        return "redirect:/pacientes/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model modelo) {
        Pacientes paciente = pacienteServicio.get(id);
        modelo.addAttribute("paciente", paciente);
        return "pacientes/editar_paciente";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPaciente(@PathVariable("id") Long id) {
        pacienteServicio.delete(id);
        return "redirect:/pacientes/";
    }

    @GetMapping("/descargar-word/{id}")
    public ResponseEntity<byte[]> descargarDocumentoWord(@PathVariable("id") Long id) {
        try {
            Pacientes paciente = pacienteServicio.get(id);
            byte[] documentoBytes = documentoWordServicio.generarDocumentoPaciente(paciente);
            
            String nombreArchivo = "Ficha_Medica_" + paciente.getNombre() + "_" + paciente.getApellido() + ".docx";
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", nombreArchivo);
            headers.setContentLength(documentoBytes.length);
            
            return new ResponseEntity<>(documentoBytes, headers, HttpStatus.OK);
            
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Mantener compatibilidad con rutas anteriores
    @GetMapping
    public String verpagina(Model modelo) {
        return "redirect:/menu";
    }
}