package upeu.edu.pe.reghost.entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Emergencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombreCompleto;

    @Column(nullable = false, length = 60)
    private String doctorAsignado;

    @Column(nullable = false)
    private LocalDateTime fechaHora;

    @Column(nullable = false, length = 30)
    private String estadoSalud;

    @Column(length = 300)
    private String observaciones;

    // Constructor completo
    public Emergencias(Long id, String nombreCompleto, String doctorAsignado, 
                       LocalDateTime fechaHora, String estadoSalud, String observaciones) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.doctorAsignado = doctorAsignado;
        this.fechaHora = fechaHora;
        this.estadoSalud = estadoSalud;
        this.observaciones = observaciones;
    }

    // Constructor vacío
    public Emergencias() {
        super();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDoctorAsignado() {
        return doctorAsignado;
    }

    public void setDoctorAsignado(String doctorAsignado) {
        this.doctorAsignado = doctorAsignado;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstadoSalud() {
        return estadoSalud;
    }

    public void setEstadoSalud(String estadoSalud) {
        this.estadoSalud = estadoSalud;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}