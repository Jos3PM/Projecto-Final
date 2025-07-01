package upeu.edu.pe.reghost.servicio;

import org.apache.poi.xwpf.usermodel.*;
import org.springframework.stereotype.Service;
import upeu.edu.pe.reghost.entidades.Pacientes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class DocumentoWordServicio {

    public byte[] generarDocumentoPaciente(Pacientes paciente) throws IOException {
        XWPFDocument document = new XWPFDocument();

        XWPFParagraph titulo = document.createParagraph();
        titulo.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun runTitulo = titulo.createRun();
        runTitulo.setText("FICHA MÉDICA DEL PACIENTE");
        runTitulo.setBold(true);
        runTitulo.setFontSize(18);
        runTitulo.setColor("2E86AB");

        XWPFParagraph separador = document.createParagraph();
        separador.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun runSeparador = separador.createRun();
        runSeparador.setText("═══════════════════════════════════════");
        runSeparador.setColor("2E86AB");

        document.createParagraph();


        // Información Personal
        crearSeccion(document, "📋 INFORMACIÓN PERSONAL", "2E86AB");
        crearCampo(document, "Nombre Completo:", paciente.getNombre() + " " + paciente.getApellido());
        crearCampo(document, "DNI:", paciente.getDni());
        crearCampo(document, "Fecha de Nacimiento:", formatearFecha(paciente.getFechaNacimiento()));
        crearCampo(document, "Edad:", paciente.getEdad() + " años");
        crearCampo(document, "Género:", paciente.getGenero());
        crearCampo(document, "Estado Civil:", paciente.getEstadoCivil());
        crearCampo(document, "Ocupación:", paciente.getOcupacion() != null ? paciente.getOcupacion() : "No especificada");

        document.createParagraph();

        // Información de Contacto
        crearSeccion(document, "📞 INFORMACIÓN DE CONTACTO", "F18F01");
        crearCampo(document, "Teléfono:", paciente.getTelefono());
        crearCampo(document, "Dirección:", paciente.getDireccion());
        crearCampo(document, "Contacto de Emergencia:", paciente.getContactoEmergencia());
        crearCampo(document, "Teléfono de Emergencia:", paciente.getTelefonoEmergencia());

        document.createParagraph();

        // Información Médica
        crearSeccion(document, "🩺 INFORMACIÓN MÉDICA", "C73E1D");
        crearCampo(document, "Tipo de Sangre:", paciente.getTipoSangre());
        crearCampo(document, "Caso Médico:", paciente.getCaso());
        crearCampo(document, "Alergias:", paciente.getAlergias() != null ? paciente.getAlergias() : "Ninguna registrada");
        crearCampo(document, "Medicamentos Actuales:", paciente.getMedicamentos() != null ? paciente.getMedicamentos() : "Ninguno registrado");
        crearCampo(document, "Observaciones:", paciente.getObservaciones() != null ? paciente.getObservaciones() : "Sin observaciones");

        document.createParagraph();

        // Pie de página
        XWPFParagraph pie = document.createParagraph();
        pie.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun runPie = pie.createRun();
        runPie.setText("Documento generado el " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        runPie.setItalic(true);
        runPie.setFontSize(10);
        runPie.setColor("666666");

        XWPFParagraph sistema = document.createParagraph();
        sistema.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun runSistema = sistema.createRun();
        runSistema.setText("RegHost - Sistema de Gestión Hospitalaria");
        runSistema.setBold(true);
        runSistema.setFontSize(12);
        runSistema.setColor("2E86AB");

        // Convertir a bytes
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        document.write(out);
        document.close();

        return out.toByteArray();
    }

    private void crearSeccion(XWPFDocument document, String titulo, String color) {
        XWPFParagraph seccion = document.createParagraph();
        XWPFRun runSeccion = seccion.createRun();
        runSeccion.setText(titulo);
        runSeccion.setBold(true);
        runSeccion.setFontSize(14);
        runSeccion.setColor(color);
        
        // Línea debajo del título
        XWPFParagraph linea = document.createParagraph();
        XWPFRun runLinea = linea.createRun();
        runLinea.setText("─────────────────────────────────────");
        runLinea.setColor(color);
    }

    private void crearCampo(XWPFDocument document, String etiqueta, String valor) {
        XWPFParagraph campo = document.createParagraph();
        
        // Etiqueta en negrita
        XWPFRun runEtiqueta = campo.createRun();
        runEtiqueta.setText(etiqueta + " ");
        runEtiqueta.setBold(true);
        runEtiqueta.setColor("333333");
        
        // Valor normal
        XWPFRun runValor = campo.createRun();
        runValor.setText(valor);
        runValor.setColor("555555");
    }

    private String formatearFecha(LocalDate fecha) {
        if (fecha != null) {
            return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        return "No especificada";
    }
}