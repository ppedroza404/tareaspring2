package com.centotec.app.lab6.domain;

import org.springframework.boot.convert.PeriodFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private Date dNacimineto;
    private String puesto;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    public Persona(String nombre, String apellido, String dNacimineto, String puesto) throws ParseException {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dNacimineto = format.parse(dNacimineto);
        this.puesto = puesto;
    }

    public Persona() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
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

    public Date getdNacimineto() {
        return dNacimineto;
    }

    public void setdNacimineto(Date dNacimineto) {
        this.dNacimineto = dNacimineto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getdNacimientodAsShort() {
        return format.format(dNacimineto);
    }

    public String getEdad() {
        LocalDate curDate = LocalDate.now();
        Date ddnacimiento = dNacimineto;
        int years = Period.between(curDate,dNacimineto.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).getYears();

        return String.valueOf(years);
    }



    public String toString() {
        StringBuilder value = new StringBuilder("PersonaEntry(");
        value.append("Id: ");
        value.append(id);
        value.append(",Nombre: ");
        value.append(nombre);
        value.append(",Apellido: ");
        value.append(apellido);
        value.append(",DNacimiento: ");
        value.append(getdNacimientodAsShort());
        value.append(",Puesto: ");
        value.append(puesto);
        value.append(")");
        return value.toString();
    }

}