package com.tallermecanico.entity;

import com.tallermecanico.enums.CargoEmpleado;
import com.tallermecanico.enums.Escolaridad;
import com.tallermecanico.enums.EstadoCivil;
import com.tallermecanico.enums.Parentesco;
import com.tallermecanico.enums.Talla;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 12, unique = true, nullable = false)
    private String rut;

    @Column(length = 30, nullable = false)
    private String nombres;

    @Column(name = "apellido_paterno", length = 20, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 20, nullable = false)
    private String apellidoMaterno;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CargoEmpleado cargo;

    @Column(length = 15)
    private String telefono;

    @Column(nullable = false)
    private Boolean activo = true;

    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;

    @Column(name = "licencia_conducir", length = 10)
    private String licenciaConducir;

    @Column(name = "fecha_vencimiento_licencia")
    private LocalDate fechaVencimientoLicencia;

    // --- Nuevos campos ---

    @Enumerated(EnumType.STRING)
    @Column(name = "talla", length = 3)
    private Talla talla;

    @Column(name = "calzado")
    private Short calzado;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_civil", length = 15)
    private EstadoCivil estadoCivil;

    @Column(name = "hijos")
    private Short hijos;

    @Column(name = "direccion", length = 50)
    private String direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comuna")
    private Comuna comuna;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciudad")
    private Ciudad ciudad;

    @Column(name = "telefono2", length = 15)
    private String telefono2;

    @Enumerated(EnumType.STRING)
    @Column(name = "escolaridad", length = 15)
    private Escolaridad escolaridad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nacionalidad")
    private Nacionalidad nacionalidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_visa")
    private TipoVisa tipoVisa;

    @Column(name = "contacto_emergencia", length = 30)
    private String contactoEmergencia;

    @Column(name = "fono_contacto_emergencia", length = 15)
    private String fonoContactoEmergencia;

    @Enumerated(EnumType.STRING)
    @Column(name = "parentesco", length = 10)
    private Parentesco parentesco;

    @Column(name = "ex_trabajador")
    private Boolean exTrabajador = false;

    @Column(name = "observaciones", length = 500)
    private String observaciones;

    @Column(name = "costo", precision = 18, scale = 0)
    private BigDecimal costo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_taller")
    private Taller taller;

    // Constructors
    public Empleado() {
    }

    public Empleado(String rut, String nombres, String apellidoPaterno, String apellidoMaterno,
                    CargoEmpleado cargo, String telefono, LocalDate fechaIngreso) {
        this.rut = rut;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.cargo = cargo;
        this.telefono = telefono;
        this.fechaIngreso = fechaIngreso;
        this.activo = true;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public CargoEmpleado getCargo() {
        return cargo;
    }

    public void setCargo(CargoEmpleado cargo) {
        this.cargo = cargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getLicenciaConducir() {
        return licenciaConducir;
    }

    public void setLicenciaConducir(String licenciaConducir) {
        this.licenciaConducir = licenciaConducir;
    }

    public LocalDate getFechaVencimientoLicencia() {
        return fechaVencimientoLicencia;
    }

    public void setFechaVencimientoLicencia(LocalDate fechaVencimientoLicencia) {
        this.fechaVencimientoLicencia = fechaVencimientoLicencia;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public Short getCalzado() {
        return calzado;
    }

    public void setCalzado(Short calzado) {
        this.calzado = calzado;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Short getHijos() {
        return hijos;
    }

    public void setHijos(Short hijos) {
        this.hijos = hijos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public Escolaridad getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(Escolaridad escolaridad) {
        this.escolaridad = escolaridad;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public TipoVisa getTipoVisa() {
        return tipoVisa;
    }

    public void setTipoVisa(TipoVisa tipoVisa) {
        this.tipoVisa = tipoVisa;
    }

    public String getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(String contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }

    public String getFonoContactoEmergencia() {
        return fonoContactoEmergencia;
    }

    public void setFonoContactoEmergencia(String fonoContactoEmergencia) {
        this.fonoContactoEmergencia = fonoContactoEmergencia;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }

    public Boolean getExTrabajador() {
        return exTrabajador;
    }

    public void setExTrabajador(Boolean exTrabajador) {
        this.exTrabajador = exTrabajador;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }

    // Helper method for nombre completo
    public String getNombreCompleto() {
        return nombres + " " + apellidoPaterno + " " + apellidoMaterno;
    }
}
