package upeu.edu.pe.reghost.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuControlador {

    @GetMapping("/menu")
    public String mostrarMenu() {
        return "menu";
    }
}