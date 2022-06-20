
package com.yoprogramo.dsicu23;

import java.util.Date;

public class AsignacionCientificoDelCI {
    private Date fechaDesde;
    private Date fechaHasta;
    
    private PersonalCientifico personalCientifico;
    
     /* Constructor de la clase */
    
    
    
    /* Definición de los metodos de la clase*/

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
    public boolean esCientificoActivo(){
        return true;
        
    }
    
}
