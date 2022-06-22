

package com.yoprogramo.dsicu23;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * 
 */
public class DsiCU23 {

    public static void main(String[] args) throws InterruptedException {
        /*CREACION DE LOS OBJETOS SIN BASE DE DATOS*/
        TipoRecursoTecnologico tRT1 = new TipoRecursoTecnologico("MICROSCOPIO","");
        TipoRecursoTecnologico tRT2 = new TipoRecursoTecnologico("BALANZA DE PRECISION","");
        TipoRecursoTecnologico tRT3 = new TipoRecursoTecnologico("RESONADOR MAGNETICO","");
        TipoRecursoTecnologico tRT4 = new TipoRecursoTecnologico("EQUIPAMENTO COMPUTO","");
        
        /*Agregando los tipos de recursos a un array para poder setearlos en la relacion de uno a muchos*/
        TipoRecursoTecnologico[] arrayTipos = new TipoRecursoTecnologico[4];
        arrayTipos[0] = tRT1;
        arrayTipos[1] = tRT2;
        arrayTipos[2] = tRT3;
        arrayTipos[3] = tRT4;
        /*Creando las relaciones del tipo de recurso con un estado */
        Estado estado1 = new Estado("Disponible","","Recurso Tecnologico",true,false);
        Estado estado2 = new Estado("En Mantenimiento","","Recurso Tecnologico",true,false);
        Estado estado3 = new Estado("Inicio Mantenimiento Correctivo","","",true,false);
        Estado estado4 = new Estado("Baja Tecnica","","",true,false);
        Estado estado5 = new Estado("Baja Definitiva","","",true,false);
        
        Date desde = new Date();
        Date hasta = new Date();
        
        
        CambioEstadoRT cambioE1 = new CambioEstadoRT(desde,hasta,estado1);
        CambioEstadoRT cambioE2 = new CambioEstadoRT(desde,hasta,estado2);
        CambioEstadoRT cambioE3 = new CambioEstadoRT(desde,hasta,estado3);
        CambioEstadoRT cambioE4 = new CambioEstadoRT(desde,hasta,estado4);
        CambioEstadoRT cambioE5 = new CambioEstadoRT(desde,hasta,estado5);
        
        Marca marca1 = new Marca("Shidmazu");
        Marca marca2 = new Marca("Nikon");
        Marca marca3 = new Marca("General Electric");
        
        Modelo model = new Modelo("TX200",marca1);
        Modelo model2 = new Modelo("M1000",marca2);
        Modelo model3 = new Modelo("X8",marca3);
        
        
        
        
        CentroDeInvestigacion centro = new CentroDeInvestigacion("SERN",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
        CentroDeInvestigacion centro2 = new CentroDeInvestigacion("NASA",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
        CentroDeInvestigacion centro3 = new CentroDeInvestigacion("Space X",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
        
        ArrayList <CentroDeInvestigacion> centrosArray = new ArrayList<>();
        centrosArray.add(centro);
        centrosArray.add(centro2);
        centrosArray.add(centro3);
        
        
        RecursoTecnologico a = new RecursoTecnologico(1,null,null,null,null,null,model,tRT1,cambioE1,null,centro);
        RecursoTecnologico b = new RecursoTecnologico(2,null,null,null,null,null,model2,tRT1,cambioE2,null,centro);        
        RecursoTecnologico c = new RecursoTecnologico(3,null,null,null,null,null,model3,tRT1,cambioE3,null,centro2);
        RecursoTecnologico d = new RecursoTecnologico(4,null,null,null,null,null,model2,tRT3,cambioE4,null,centro2); /*NO DEBERIA PODER RESERVARSE*/
        RecursoTecnologico e = new RecursoTecnologico(5,null,null,null,null,null,model2,tRT4,cambioE4,null,centro3); /*NO DEBERIA PODER RESERVARSE*/
        RecursoTecnologico f = new RecursoTecnologico(6,null,null,null,null,null,model,tRT1,cambioE4,null,centro);
        
        ArrayList <RecursoTecnologico> rtCentro1= new ArrayList<>();
        rtCentro1.add(a);
        rtCentro1.add(b);
        rtCentro1.add(f);
        
        centro.setRecursosTecnologicos(rtCentro1);       
        
        ArrayList <RecursoTecnologico> rtCentro2= new ArrayList<>();
        rtCentro2.add(c);
        rtCentro2.add(d);
        
        
        centro2.setRecursosTecnologicos(rtCentro2);
        
        ArrayList <RecursoTecnologico> rtCentro3= new ArrayList<>();
        rtCentro3.add(e);
        centro3.setRecursosTecnologicos(rtCentro3);
        
        
        ArrayList<RecursoTecnologico> rec = new ArrayList<>();
        rec.add(a);
        rec.add(b);
        rec.add(c);
        rec.add(d);
        rec.add(e);
        rec.add(f);
        
        
        
        
        PersonalCientifico cientifico1 = new PersonalCientifico(1,null,null,null,null,null,null);
        PersonalCientifico cientifico2 = new PersonalCientifico(2,null,null,null,null,null,null);
        PersonalCientifico cientifico3 = new PersonalCientifico(3,null,null,null,null,null,null);
        PersonalCientifico cientifico4 = new PersonalCientifico(4,null,null,null,null,null,null);
        
        Turno turno1 = new Turno(null,null,null,null,null);
        Turno turno2 = new Turno(null,null,null,null,null);
        Turno turno3 = new Turno(null,null,null,null,null);
        Turno turno4 = new Turno(null,null,null,null,null);
        Turno turno5 = new Turno(null,null,null,null,null);
        
        
        
        
        
        
        
        /*Creamos la pantalla*/
        PantallaRegistrarReservaTurnoDeRT pantalla = new PantallaRegistrarReservaTurnoDeRT();
        
        /*Llamamos al metodo de interfaz*/
        
        
        
        
        /*Creamos al gestor y se le setean los tipos de recursos que conforman su relacion*/
        GestorRegistrarReservaTurnoDeRT gestor = new GestorRegistrarReservaTurnoDeRT();  
        /*Esto pasa nomas porq no tenemos base de datos, sino no se inicializarian y se traerian directamente*/
        gestor.setTiposDeRecursosTecnologicos(arrayTipos);
        gestor.setRecursosTecnologicos(rec);
        
        /*Inicia el Caso de Uso*/
        
        while(pantalla.getBtnOpcionReservarTurnoDeRT() == 0){
            pantalla.habilitarPantalla();
        }
        /*Sale del bucle si se presiona el boton que setea la opcion btn reserva en 1*/
        if(pantalla.getBtnOpcionReservarTurnoDeRT() == 1){
            /*DEVUELVE UN ARRAY QUE CONTIENE TODOS LOS TIPOS DE RECURSO POSIBLES*/
            ArrayList <String> cmbTiposDeRecursos = gestor.opcionReservaTurnoDeRT(pantalla.getBtnOpcionReservarTurnoDeRT());
            /*Declaro un string*/
            String seleccion = new String();
            /*Declaro el array que contendra los recursos de tipo elegido*/
            ArrayList<RecursoTecnologico> recursos = new ArrayList <>();   
            /*ENTRA EN UN CICLO PORQ SI ELIGE UN TIPO DE RECURSO QUE NO SE PUEDE RESERVAR ENTONCES VUELVE A PEDIR QUE SELECCIONES UN NUEVO TIPO*/
            while(recursos.size() == 0){     
                /*Llamo a la interfaz que te hace seleccionar un tipo de producto*/
                seleccion = pantalla.mostrarTiposDeRecursos(cmbTiposDeRecursos);
                
                /*Mando al gestor para que pueda obtener todos los recursos con el tipo pasado por parametro*/
                recursos = gestor.buscarRTDeTipoSeleccionado(seleccion);
                
            }
            /*Comprobacion de que lo que se selecciona en el formulario se devuelve*/
            System.out.print(seleccion);
            /*LE PASA LOS RECURSOS A LA PANTALLA*/
            pantalla.setListaRT(recursos);
            
            /*PRUEBA DE QUE EL FILTRO POR TIPOS ESTA FUNCIONANDO, si elegis microscopio trae 1,2,3 y 6 no lo trae porq es baja tecnica*/
            /*
            for(int i=0;i<pantalla.getListaRT().size();i++){
                System.out.print(pantalla.getListaRT().get(i).toString());
            
            }
            
            /*Buscar y obtener los datos de los recursos, ACA NO SE SI DEVOLVERIA UN ARRAY DE RECURSOS PORQUE TIENE Q CONTENER EL CENTRO AL QUE PERTENECE */
            ArrayList<RecursoTecnologico> recursosAll = gestor.buscarInformacionRecursosTecnologicos(recursos);
           /*OBTENIENDO DATOS PARA VER COMO SE PASAN A LA INTERFAZ PARA AGRUPARLOS POR EL CENTRO*/
            for(int i=0;i<recursosAll.size();i++){
                System.out.print(recursosAll.get(i).toString());           
            }
            
            /*HAY QUE VER COMO SE IMPLEMENTA LA DEPENDENCIA PARA PODER SABER Q RECURSOS TIENE UN CENTRO, ENTONCES LE MANDAS O UN ARRAY Q TIENE EL CENTRO O LOS CENTROS POR SEPARADOS*/
            
            gestor.agruparRTPorCI();
            /*setea todos los centros que existen en un array list*/
            pantalla.setCentrosInvestigacion(centrosArray);
            /*llama a la pantalla y esta o crea una nueva gui q muestre todos los recursos agrupados y espera a q selecciones una para setearlo como recurso seleccionado
            ESTE METODO TERMINA HACIENDO UN MONTON DE PASOS Y MENSAJES DEL DIAGRAMA, NO ESTA AGRUPANDO COMO TAL PERO SI VA A MOSTRAR LOS RECURSOS SEGUN EL CENTRO Q TIENEN,
            TENDRIAMOS QUE VER SI ES NECESARIO CAMBIAR LOS METODOS PARA Q HAGAN COSAS O QUE HACER
            */
            pantalla.mostrarRTAgrupados(recursosAll);
            
            /*RECURSO SELECCIONADO POR EL USUARIO*/
            System.out.print(pantalla.getRecursoSeleccionado().toString());
            
            
            
           // int usuario = gestor.buscarUsuarioLogueado();
            /*ya no entiendo como hacer esto*/
            //gestor.verificarCIDeCientifico(usuario);
            
            /*Obtiene la hora actual del sistema*/
            String horaActual = gestor.obtenerFechaYHoraActual();
            System.out.print(horaActual);
            
            
            
            
            
            
            /*LA PARTE DEL AMBITO*/
            String amb = "recurso tecnologico";
            
            //gestor.reservarTurnoDeRT(amb);
            
            
            /* Lo que muestra recursosAll
            for(int i=0;i<recursosAll.size();i++){
                System.out.print(recursosAll.get(i) + " ");
            
            }
            */
            
            
            
            
            
            
            
        }
        else{
            System.out.print("Funcion aun no desarrollada");
        }
                
        
        
        
        
    }
}
