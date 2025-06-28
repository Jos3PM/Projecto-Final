package upeu.edu.pe.reghost.entidades;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false, length = 60)
    private String apellido;

    @Column(nullable = false, length = 15, unique = true)
    private String dni;

    @Column(nullable = false, length = 100)
    private String especialidad;

    @Column(nullable = false, length = 20, unique = true)
    private String colegioMedico;

    @Column(nullable = false, length = 15)
    private String telefono;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 200)
    private String direccion;

    @Column(nullable = false)
    private LocalDate fechaIngreso;

    @Column(nullable = false, length = 20)
    private String estado; // Activo, Inactivo, Vacaciones

    @Column(length = 500)
    private String observaciones;

    // Horarios de trabajo
    @Column(nullable = false)
    private LocalTime horaInicioMañana;

    @Column(nullable = false)
    private LocalTime horaFinMañana;

    @Column
    private LocalTime horaInicioTarde;

    @Column
    private LocalTime horaFinTarde;

    @Column(nullable = false, length = 100)
    private String diasTrabajo; // Lunes,Martes,Miércoles,etc.

    @Column(nullable = false)
    private Boolean disponible = true;

    // Relación con pacientes
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pacientes> pacientes;

    // Constructores
    public Doctor() {
        super();
    }

    public Doctor(Long id, String nombre, String apellido, String dni, String especialidad,
                  String colegioMedico, String telefono, String email, String direccion,
                  LocalDate fechaIngreso, String estado, String observaciones,
                  LocalTime horaInicioMañana, LocalTime horaFinMañana,
                  LocalTime horaInicioTarde, LocalTime horaFinTarde,
                  String diasTrabajo, Boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.especialidad = especialidad;
        this.colegioMedico = colegioMedico;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
        this.observaciones = observaciones;
        this.horaInicioMañana = horaInicioMañana;
        this.horaFinMañana = horaFinMañana;
        this.horaInicioTarde = horaInicioTarde;
        this.horaFinTarde = horaFinTarde;
        this.diasTrabajo = diasTrabajo;
        this.disponible = disponible;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getColegioMedico() {
        return colegioMedico;
    }

    public void setColegioMedico(String colegioMedico) {
        this.colegioMedico = colegioMedico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalTime getHoraInicioMañana() {
        return horaInicioMañana;
    }

    public void setHoraInicioMañana(LocalTime horaInicioMañana) {
        this.horaInicioMañana = horaInicioMañana;
    }

    public LocalTime getHoraFinMañana() {
        return horaFinMañana;
    }

    public void setHoraFinMañana(LocalTime horaFinMañana) {
        this.horaFinMañana = horaFinMañana;
    }

    public LocalTime getHoraInicioTarde() {
        return horaInicioTarde;
    }

    public void setHoraInicioTarde(LocalTime horaInicioTarde) {
        this.horaInicioTarde = horaInicioTarde;
    }

    public LocalTime getHoraFinTarde() {
        return horaFinTarde;
    }

    public void setHoraFinTarde(LocalTime horaFinTarde) {
        this.horaFinTarde = horaFinTarde;
    }

    public String getDiasTrabajo() {
        return diasTrabajo;
    }

    public void setDiasTrabajo(String diasTrabajo) {
        this.diasTrabajo = diasTrabajo;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public List<Pacientes> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Pacientes> pacientes) {
        this.pacientes = pacientes;
    }

    // Método para obtener nombre completo
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    // Método para verificar si está disponible en un día específico
    public boolean estaDisponibleEn(String dia) {
        return disponible && diasTrabajo.contains(dia);
    }
}