
package com.yoprogramo.dsicu23;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GestorRegistrarReservaTurnoDeRT {
    private int btnOpcionReservarTurnoDeRT;
    private TipoRecursoTecnologico[] tiposDeRecursosTecnologicos;
    private String[] cmbTiposDeRecursos;
    private String tipoRecursoSeleccionado;/*Agregar en el diagrama*/
    private ArrayList<RecursoTecnologico> recursosTecnologicos;
    private RecursoTecnologico recursoTecnologicoSeleccionado;
    private PersonalCientifico usuarioLogueado;
    private Date fechaActual; /*Te da tanto la fecha como la hora, no se si usar otro atributo mas*/
    private Turno[] turnoDelRT;
    private Turno turnoSeleccionado;
    private boolean esReservado;
    private String notificacionMail;
    
    /*Constructor de la clase*/

    
    public String getTipoRecursoSeleccionado() {
        return tipoRecursoSeleccionado;
    }

    /*Metodos de la clase*/
    public void setTipoRecursoSeleccionado(String tipoRecursoSeleccionado) {    
        this.tipoRecursoSeleccionado = tipoRecursoSeleccionado;
    }

    public int getBtnOpcionReservarTurnoDeRT() {
        return btnOpcionReservarTurnoDeRT;
    }
    
    public void setBtnOpcionReservarTurnoDeRT(int btnOpcionReservarTurnoDeRT) {
        this.btnOpcionReservarTurnoDeRT = btnOpcionReservarTurnoDeRT;
    }

    public TipoRecursoTecnologico[] getTiposDeRecursosTecnologicos() {
        return tiposDeRecursosTecnologicos;
    }

    public void setTiposDeRecursosTecnologicos(TipoRecursoTecnologico[] tiposDeRecursosTecnologicos) {
        this.tiposDeRecursosTecnologicos = tiposDeRecursosTecnologicos;
    }

    public ArrayList<RecursoTecnologico> getRecursosTecnologicos() {
        return recursosTecnologicos;
    }

    public void setRecursosTecnologicos(ArrayList<RecursoTecnologico> recursosTecnologicos) {
        this.recursosTecnologicos = recursosTecnologicos;
    }

    

    public RecursoTecnologico getRecursoTecnologicoSeleccionado() {
        return recursoTecnologicoSeleccionado;
    }

    public void setRecursoTecnologicoSeleccionado(RecursoTecnologico recursoTecnologicoSeleccionado) {
        this.recursoTecnologicoSeleccionado = recursoTecnologicoSeleccionado;
    }

    public PersonalCientifico getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(PersonalCientifico usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public Turno[] getTurnoDelRT() {
        return turnoDelRT;
    }

    public void setTurnoDelRT(Turno[] turnoDelRT) {
        this.turnoDelRT = turnoDelRT;
    }

    public Turno getTurnoSeleccionado() {
        return turnoSeleccionado;
    }

    public void setTurnoSeleccionado(Turno turnoSeleccionado) {
        this.turnoSeleccionado = turnoSeleccionado;
    }

    public boolean isEsReservado() {
        return esReservado;
    }

    public void setEsReservado(boolean esReservado) {
        this.esReservado = esReservado;
    }

    public String getNotificacionMail() {
        return notificacionMail;
    }

    public void setNotificacionMail(String notificacionMail) {
        this.notificacionMail = notificacionMail;
    }

    public String[] getCmbTiposDeRecursos() {
        return cmbTiposDeRecursos;
    }

    public void setCmbTiposDeRecursos(String[] cmbTiposDeRecursos) {
        this.cmbTiposDeRecursos = cmbTiposDeRecursos;
    }
    /*Metodo que valida que la opcion haya sido la de reservar turno, llama al metodo que busca los tipos de recurso y los devuelve*/
    public String[] opcionReservaTurnoDeRT(int a) {
        if(a == 1){
            this.buscarTiposDeRecursos();
            return this.cmbTiposDeRecursos;
        }
        return null;
        
    }
    /*Metodo que busca los tipos de recursos y los trae*/
    public void buscarTiposDeRecursos() {
        String[] a = new String [4];
        for(int i=0;i<this.tiposDeRecursosTecnologicos.length;i++){           
            
            a[i] = tiposDeRecursosTecnologicos[i].getNombre();         
        
        }        
        this.setCmbTiposDeRecursos(a);
        
    }
    /*Busco todos los recursos que coincidan con el tipo y luego valido que sean reservables*/
    public ArrayList<RecursoTecnologico> buscarRTDeTipoSeleccionado(String tipo) {
        ArrayList<RecursoTecnologico> tipoS = new ArrayList<>();
        for(int i = 0; i<this.recursosTecnologicos.size() ; i++){ 
                       
            if(this.recursosTecnologicos.get(i).getTipoRecurso().getNombre().equals(tipo) && this.recursosTecnologicos.get(i).obtenerRTReservables() == true){
                tipoS.add(i,recursosTecnologicos.get(i));
                
            }
            
            
            
        }
            
        return tipoS;
        
    }

    
    /*Desencadena todos los mensajes para obtener atributos de los recursos ya filtrados por tipo de recurso*/
    public ArrayList<RecursoTecnologico> buscarInformacionRecursosTecnologicos(ArrayList<RecursoTecnologico> recursos) {        
        /*CAMBIARLO POR mostrarRT*/
        for(int i = 0; i < recursos.size(); i++){
           System.out.print(recursos.get(i).mostrarRT());
        
        }
        return recursos;
        
    }

    public void agruparRTPorCI(ArrayList<RecursoTecnologico> recursosAll) {
        /**/
    }
    /*Busca al usuario y obtiene su legajo, esto no creo q este bien u hay que ver como se implementa lo de la sesion, capaz puede pedir el legajo o algo en la interfaz*/
    public int buscarUsuarioLogueado() {        
        return this.usuarioLogueado.getLegajo();
        
    }

    public void verificarCIDeCientifico(int usuario) {
        
        
    }

    public String obtenerFechaYHoraActual() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
        
    }

    public void reservarTurnoDeRT(String ambito) {
        this.buscarEstadoReservado(ambito);
        
    }

    private void buscarEstadoReservado(String ambito) {
        /*Recorrer la clase estado con todos y preguntar si el string ambito es igual a el atributo ambito*/
    }
    
        
    
    
}
