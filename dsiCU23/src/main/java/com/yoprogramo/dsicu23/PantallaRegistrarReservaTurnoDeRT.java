
package com.yoprogramo.dsicu23;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * 
 */
public class PantallaRegistrarReservaTurnoDeRT extends javax.swing.JFrame {
    private int btnOpcionReservarTurnoDeRT;
    private ArrayList <String> cmbTiposDeRecursos;
    private String tipoRecursoSeleccionado; /*Agregado este atributo a la clase ya que lo toma al seleccionar el tipo que quiere buscar*/
    private ArrayList<RecursoTecnologico> listaRT;
    private Turno[] grillaTurnos;
    private String radioBtnNotificacion;
    private boolean btnConfirmarReserva;
    private boolean btnCancelar;
    
    
    /*Metodos de la pantalla*/
    
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

    public ArrayList<String> getCmbTiposDeRecursos() {
        return cmbTiposDeRecursos;
    }

    public void setCmbTiposDeRecursos(ArrayList<String> cmbTiposDeRecursos) {
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
    /*HACE VISIBLE EL PRIMER FORMULARIO y espera hasta que el usuario haga click, esto no esta bien implementado porq manda a dormir el proceso y deberia esperar hasta q se haga click*/
    public void habilitarPantalla() throws InterruptedException {   
        this.setVisible(true);
        ActionListener click = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnOpcionReservarTurnoDeRT = 1;
                
            }
        };
        btnOpcionReservar.addActionListener(click);
        do{
            /*CANTIDAD DE TIEMPO DORMIDO*/
            Thread.sleep(8000);
        }while (btnOpcionReservarTurnoDeRT == 0);
        
          
            
    }
        
    public String mostrarTiposDeRecursos(PantallaRegistrarReservaTurnoDeRT gui,ArrayList <String> cmb){ 
            /*LA PANTALLA OBTIENE LOS TIPOS DE RECURSOS*/
            this.setCmbTiposDeRecursos(cmb);
            this.interfazTipoRecurso.setVisible(true);
            interfazTipoRecurso.setBounds(500, 200, 500, 200);
            for(int i = 0; i < cmb.size();i++){
                comboBoxTiposRecursos.addItem(cmb.get(i));
            }
            
            
            ActionListener click = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBoxTiposRecursos.getSelectedItem() != null){
                    tipoRecursoSeleccionado = comboBoxTiposRecursos.getSelectedItem().toString();
                }
                
            }
            };
            btnBuscarXTipo.addActionListener(click);
            
            /*Se lo paso a la interfaz*/
            
            
            /*ACA DEBERIA TRAER LA VARIABLE QUE SE SELECCIONA AL HACER CLICK EN LA GUI*/
            String seleccion = "MICROSCOPIO";
            this.solicitarSeleccionTipoDeRecurso(seleccion);
            
            return seleccion;
            
            
        
    }
    /*Setea el tipo de recurso que este al momento de hacer click en el form como atributo de la pantalla*/
    public void solicitarSeleccionTipoDeRecurso(String a) {
            this.setTipoRecursoSeleccionado(a);
            
    }
        /*YA LA TOME CUANDO HICE EL SET EN SOLICITAR SELECCION TIPO...*/
    public void tomarSeleccionDeTipoDeRecurso(){
            
    }

    public RecursoTecnologico mostrarRTAgrupados(ArrayList<RecursoTecnologico> recursosAll) {
        /*crea la gui y devuelve el rt seleccionado, creo q se tendria q agregar como atributo*/
        RecursoTecnologico seleccionado =  recursosAll.get(1);
        return seleccionado;
    }
    
   
    public PantallaRegistrarReservaTurnoDeRT() {        
        initComponents();
        setLocationRelativeTo(null);/*PARA QUE QUEDE EN EL MEDIO DE LA PANTALLA*/
    }
    
    
    
    /*CODIGO QUE TENGA Q VER CON BOTONES DE LA INTERFAZ Y LAS ACCIONES QUE SE EJECUTAN AL PRESIONAR BOTONES*/

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        interfazTipoRecurso = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        comboBoxTiposRecursos = new javax.swing.JComboBox<>();
        btnBuscarXTipo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnOpcionReservar = new javax.swing.JButton();

        interfazTipoRecurso.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        interfazTipoRecurso.setTitle("Registrar Reserva Turno RT");

        jLabel2.setText("Seleccione el tipo de recurso que desea reservar:");

        btnBuscarXTipo.setText("Buscar");

        javax.swing.GroupLayout interfazTipoRecursoLayout = new javax.swing.GroupLayout(interfazTipoRecurso.getContentPane());
        interfazTipoRecurso.getContentPane().setLayout(interfazTipoRecursoLayout);
        interfazTipoRecursoLayout.setHorizontalGroup(
            interfazTipoRecursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interfazTipoRecursoLayout.createSequentialGroup()
                .addGroup(interfazTipoRecursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(interfazTipoRecursoLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(comboBoxTiposRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnBuscarXTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(interfazTipoRecursoLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel2)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        interfazTipoRecursoLayout.setVerticalGroup(
            interfazTipoRecursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interfazTipoRecursoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(interfazTipoRecursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboBoxTiposRecursos, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(btnBuscarXTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("menuOpciones"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Seleccionar opción:");

        btnOpcionReservar.setText("Registrar Reserva Turno De Recurso Tecnologico");
        btnOpcionReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickBtnOpcion(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnOpcionReservar)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(btnOpcionReservar)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clickBtnOpcion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickBtnOpcion

        this.dispose();
        
        
    }//GEN-LAST:event_clickBtnOpcion
    
    
  
    
    
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaRegistrarReservaTurnoDeRT().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarXTipo;
    private javax.swing.JButton btnOpcionReservar;
    private javax.swing.JComboBox<String> comboBoxTiposRecursos;
    private javax.swing.JFrame interfazTipoRecurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
