
package com.yoprogramo.dsicu23;


import java.util.ArrayList;



public class PantallaRegistrarReservaTurnoDeRT {
        private int btnOpcionReservarTurnoDeRT;
        private String[] cmbTiposDeRecursos;
        private String tipoRecursoSeleccionado; /*Agregado este atributo a la clase ya que lo toma al seleccionar el tipo que quiere buscar*/
        private ArrayList<RecursoTecnologico> listaRT;
        private Turno[] grillaTurnos;
        private String radioBtnNotificacion;
        private boolean btnConfirmarReserva;
        private boolean btnCancelar;
        /*Constructor y metodos get y set de los atributos */

        public int getBtnOpcionReservarTurnoDeRT() {
            return btnOpcionReservarTurnoDeRT;
        }

        public void setBtnOpcionReservarTurnoDeRT(int btnOpcionReservarTurnoDeRT) {
            this.btnOpcionReservarTurnoDeRT = btnOpcionReservarTurnoDeRT;
        }

        public String getTipoRecursoSeleccionado() {
            return tipoRecursoSeleccionado;
        }

        public void setTipoRecursoSeleccionado(String tipoRecursoSeleccionado) {
            this.tipoRecursoSeleccionado = tipoRecursoSeleccionado;
        }
        

        public String[] getCmbTiposDeRecursos() {
            return cmbTiposDeRecursos;
        }

        public void setCmbTiposDeRecursos(String[] cmbTiposDeRecursos) {
            this.cmbTiposDeRecursos = cmbTiposDeRecursos;
        }

        public ArrayList<RecursoTecnologico> getListaRT() {
            return listaRT;
        }

        public void setListaRT(ArrayList<RecursoTecnologico> listaRT) {
            this.listaRT = listaRT;
        }

        

        public Turno[] getGrillaTurnos() {
            return grillaTurnos;
        }

        public void setGrillaTurnos(Turno[] grillaTurnos) {
            this.grillaTurnos = grillaTurnos;
        }

        public String getRadioBtnNotificacion() {
            return radioBtnNotificacion;
        }

        public void setRadioBtnNotificacion(String radioBtnNotificacion) {
            this.radioBtnNotificacion = radioBtnNotificacion;
        }

        public boolean isBtnConfirmarReserva() {
            return btnConfirmarReserva;
        }

        public void setBtnConfirmarReserva(boolean btnConfirmarReserva) {
            this.btnConfirmarReserva = btnConfirmarReserva;
        }

        public boolean isBtnCancelar() {
            return btnCancelar;
        }

        public void setBtnCancelar(boolean btnCancelar) {
            this.btnCancelar = btnCancelar;
        }
        /*SE SUPONE QUE TIENE Q LLAMAR A UN FORM QUE HASTA QUE NO HACE CLICK NO SETEA EL PARAMETRO DE LA OPCION PERO NO SE COMO HACERLO*/
        public void habilitarPantalla() {            
            MenuOpciones menu = new MenuOpciones();
            menu.setVisible(true);
            if(menu.isClickeo() == true){
                this.btnOpcionReservarTurnoDeRT = 1;
            }
            /*ESTO NO TENDRIA Q IR*/
            this.btnOpcionReservarTurnoDeRT = 1; 
        }
        
        public String mostrarTiposDeRecursos(InterfazPrincipal gui,String[] cmb){ 
            /*LA PANTALLA OBTIENE LOS TIPOS DE RECURSOS*/
            this.setCmbTiposDeRecursos(cmb);
            /*Se lo paso a la interfaz*/
            gui.setCmb(cmb);
            gui.setVisible(true);
            
            /*ACA DEBERIA TRAER LA VARIABLE QUE SE SELECCIONA AL HACER CLICK EN LA GUI*/
            String seleccion = "MICROSCOPIO";
            this.solicitarSeleccionTipoDeRecurso(seleccion);
            
            return seleccion;
            
            
        
        }
        /*Setea el tipo de recurso que este al momento de hacer click en el form como atributo de la pantalla*/
        private void solicitarSeleccionTipoDeRecurso(String a) {
            this.setTipoRecursoSeleccionado(a);
            
        }
        /*YA LA TOME CUANDO HICE EL SET EN SOLICITAR SELECCION TIPO...*/
        private void tomarSeleccionDeTipoDeRecurso(){
            
        }

    public RecursoTecnologico mostrarRTAgrupados(ArrayList<RecursoTecnologico> recursosAll) {
        /*crea la gui y devuelve el rt seleccionado, creo q se tendria q agregar como atributo*/
        RecursoTecnologico seleccionado =  recursosAll.get(1);
        return seleccionado;
    }
    
}
