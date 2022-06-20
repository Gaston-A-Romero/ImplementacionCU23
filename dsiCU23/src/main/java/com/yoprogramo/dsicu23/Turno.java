
package com.yoprogramo.dsicu23;

import java.util.Date;


public class Turno {
    private Date fechaGeneracion;
    private String diaSemana;
    private Date fechaHoraInicio;
    private Date fechaHoraFin;
    
    private CambioEstadoTurno[] cambioEstadoTurno;  /* Relacion a cambio de estados*/
    
    
    
    
    /*Contructor*/
    public Turno(Date fechaGeneracion, String diaSemana, Date fechaHoraInicio, Date fechaHoraFin, CambioEstadoTurno[] cambioEstadoTurno) {
        this.fechaGeneracion = fechaGeneracion;
        this.diaSemana = diaSemana;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.cambioEstadoTurno = cambioEstadoTurno;
    }
    
    
    /*Metodos*/

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Date getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Date fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Date getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Date fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public CambioEstadoTurno[] getCambioEstadoTurno() {
        return cambioEstadoTurno;
    }

    public void setCambioEstadoTurno(CambioEstadoTurno[] cambioEstadoTurno) {
        this.cambioEstadoTurno = cambioEstadoTurno;
    }
    
}
