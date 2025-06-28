package upeu.edu.pe.reghost.entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Emergencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Pacientes paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(nullable = false)
    private LocalDateTime fechaHoraIngreso;

    @Column(nullable = false, length = 50)
    private String tipoEmergencia; // Crítica, Alta, Media, Baja

    @Column(nullable = false, length = 500)
    private String motivoIngreso;

    @Column(nullable = false, length = 500)
    private String sintomasPrincipales;

    @Column(length = 200)
    private String signosVitales;

    @Column(nullable = false, length = 30)
    private String estado; // En Atención, Estable, Crítico, Alta, Fallecido

    @Column(length = 1000)
    private String tratamientoAplicado;

    @Column(length = 1000)
    private String observacionesMedicas;

    @Column
    private LocalDateTime fechaHoraAlta;

    @Column(length = 500)
    private String diagnosticoFinal;

    @Column(length = 200)
    private String medicamentosRecetados;

    @Column(length = 500)
    private String recomendaciones;

    @Column(nullable = false, length = 50)
    private String prioridad; // 1-Crítica, 2-Urgente, 3-Menos Urgente, 4-No Urgente

    // Constructores
    public Emergencia() {
        super();
    }

    public Emergencia(Long id, Pacientes paciente, Doctor doctor, LocalDateTime fechaHoraIngreso,
                      String tipoEmergencia, String motivoIngreso, String sintomasPrincipales,
                      String signosVitales, String estado, String tratamientoAplicado,
                      String observacionesMedicas, LocalDateTime fechaHoraAlta,
                      String diagnosticoFinal, String medicamentosRecetados,
                      String recomendaciones, String prioridad) {
        this.id = id;
        this.paciente = paciente;
        this.doctor = doctor;
        this.fechaHoraIngreso = fechaHoraIngreso;
        this.tipoEmergencia = tipoEmergencia;
        this.motivoIngreso = motivoIngreso;
        this.sintomasPrincipales = sintomasPrincipales;
        this.signosVitales = signosVitales;
        this.estado = estado;
        this.tratamientoAplicado = tratamientoAplicado;
        this.observacionesMedicas = observacionesMedicas;
        this.fechaHoraAlta = fechaHoraAlta;
        this.diagnosticoFinal = diagnosticoFinal;
        this.medicamentosRecetados = medicamentosRecetados;
        this.recomendaciones = recomendaciones;
        this.prioridad = prioridad;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public void setFechaHoraIngreso(LocalDateTime fechaHoraIngreso) {
        this.fechaHoraIngreso = fechaHoraIngreso;
    }

    public String getTipoEmergencia() {
        return tipoEmergencia;
    }

    public void setTipoEmergencia(String tipoEmergencia) {
        this.tipoEmergencia = tipoEmergencia;
    }

    public String getMotivoIngreso() {
        return motivoIngreso;
    }

    public void setMotivoIngreso(String motivoIngreso) {
        this.motivoIngreso = motivoIngreso;
    }

    public String getSintomasPrincipales() {
        return sintomasPrincipales;
    }

    public void setSintomasPrincipales(String sintomasPrincipales) {
        this.sintomasPrincipales = sintomasPrincipales;
    }

    public String getSignosVitales() {
        return signosVitales;
    }

    public void setSignosVitales(String signosVitales) {
        this.signosVitales = signosVitales;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTratamientoAplicado() {
        return tratamientoAplicado;
    }

    public void setTratamientoAplicado(String tratamientoAplicado) {
        this.tratamientoAplicado = tratamientoAplicado;
    }

    public String getObservacionesMedicas() {
        return observacionesMedicas;
    }

    public void setObservacionesMedicas(String observacionesMedicas) {
        this.observacionesMedicas = observacionesMedicas;
    }

    public LocalDateTime getFechaHoraAlta() {
        return fechaHoraAlta;
    }

    public void setFechaHoraAlta(LocalDateTime fechaHoraAlta) {
        this.fechaHoraAlta = fechaHoraAlta;
    }

    public String getDiagnosticoFinal() {
        return diagnosticoFinal;
    }

    public void setDiagnosticoFinal(String diagnosticoFinal) {
        this.diagnosticoFinal = diagnosticoFinal;
    }

    public String getMedicamentosRecetados() {
        return medicamentosRecetados;
    }

    public void setMedicamentosRecetados(String medicamentosRecetados) {
        this.medicamentosRecetados = medicamentosRecetados;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
}