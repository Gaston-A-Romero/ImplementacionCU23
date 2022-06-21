

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
        TipoRecursoTecnologico a = new TipoRecursoTecnologico("MICROSCOPIO","");
        TipoRecursoTecnologico b = new TipoRecursoTecnologico("BALANZA DE PRECISION","");
        TipoRecursoTecnologico c = new TipoRecursoTecnologico("RESONADOR MAGNETICO","");
        TipoRecursoTecnologico d = new TipoRecursoTecnologico("EQUIPAMENTO COMPUTO","");
        
        /*Agregando los tipos de recursos a un array para poder setearlos en la relacion de uno a muchos*/
        TipoRecursoTecnologico[] arrayTipos = new TipoRecursoTecnologico[4];
        arrayTipos[0] = a;
        arrayTipos[1] = b;
        arrayTipos[2] = c;
        arrayTipos[3] = d;
        /*Creando las relaciones del tipo de recurso con un estado */
        Estado bb = new Estado("Disponible","","",true,false);
        Estado bd = new Estado("Reservado","","",true,false);
        Date desde = new Date();
        Date hasta = new Date();
        
        
        CambioEstadoRT ba = new CambioEstadoRT(desde,hasta,bb);
        CambioEstadoRT bc = new CambioEstadoRT(desde,hasta,bd);
        
        Marca marca = new Marca("marca");
        Marca marca2 = new Marca("marca2");
        Modelo model = new Modelo("model1",marca);
        Modelo model2 = new Modelo("modelo2",marca2);
        
        
        
        RecursoTecnologico aa = new RecursoTecnologico(1,null,null,null,null,null,model,a,ba,null,null);
        RecursoTecnologico ab = new RecursoTecnologico(2,null,null,null,null,null,model2,a,bc,null,null);
        
        RecursoTecnologico ac = new RecursoTecnologico(3,null,null,null,null,null,model,b,bc,null,null);
        RecursoTecnologico ad = new RecursoTecnologico(4,null,null,null,null,null,null,null,null,null,null);
        RecursoTecnologico ae = new RecursoTecnologico(5,null,null,null,null,null,null,null,null,null,null);
        
        ArrayList<RecursoTecnologico> rec = new ArrayList<>();
        rec.add(aa);
        rec.add(ab);
        rec.add(ac);
        /* AL CREAR MAS RECURSOS SE ROMPE TODO PORQUE HAY MUCHOS VALORES DECLARADOS EN NULL, SI QUERES AGREGAR MAS HAY QUE FIJARSE Q ESTEN TODOS LOS DATOS
        
        rec.add(ad);
        rec.add(ae);
        */
        PersonalCientifico aaa = new PersonalCientifico(1,null,null,null,null,null,null);
        PersonalCientifico aab = new PersonalCientifico(2,null,null,null,null,null,null);
        PersonalCientifico aac = new PersonalCientifico(3,null,null,null,null,null,null);
        PersonalCientifico aad = new PersonalCientifico(4,null,null,null,null,null,null);
        Turno aaaa = new Turno(null,null,null,null,null);
        Turno aaab = new Turno(null,null,null,null,null);
        Turno aaac = new Turno(null,null,null,null,null);
        Turno aaad = new Turno(null,null,null,null,null);
        Turno aaae = new Turno(null,null,null,null,null);
        
        
        
        
        
        /*Creamos la pantalla*/
        PantallaRegistrarReservaTurnoDeRT pantalla = new PantallaRegistrarReservaTurnoDeRT();
        
        /*Llamamos al metodo de interfaz*/
        pantalla.habilitarPantalla();
        
        
        
        /*Creamos al gestor y se le setean los tipos de recursos que conforman su relacion*/
        GestorRegistrarReservaTurnoDeRT gestor = new GestorRegistrarReservaTurnoDeRT();  
        /*Esto pasa nomas porq no tenemos base de datos, sino no se inicializarian y se traerian directamente*/
        gestor.setTiposDeRecursosTecnologicos(arrayTipos);
        gestor.setRecursosTecnologicos(rec);
        
        /*Inicia el Caso de Uso*/
        
        
        
        
        
        /*
        if(cmbTiposDeRecursos == null){
            System.out.print("No se cargaron los tipos de recursos...");          
        }else{
            pantalla.mostrarTiposDeRecursos(pantalla, cmbTiposDeRecursos);
        
        
        }      
        */
       
        if(pantalla.getBtnOpcionReservarTurnoDeRT() == 1){
            ArrayList <String> cmbTiposDeRecursos = gestor.opcionReservaTurnoDeRT(pantalla.getBtnOpcionReservarTurnoDeRT());
            /*Manda a la pantalla los datos necesarios para mostrar los tipos de recursos*/
            PantallaRegistrarReservaTurnoDeRT interfaz = new PantallaRegistrarReservaTurnoDeRT();
            
            /*Prueba de que los datos estan aca para poder mandarlos*/
            for(int i = 0;i<cmbTiposDeRecursos.size();i++){
                System.out.print(cmbTiposDeRecursos.get(i));
                
                
            }
            /*Llama a la pantalla para que muestre una interfaz donde se pueda elegir los tipos de recursos*/
            String seleccion = pantalla.mostrarTiposDeRecursos(interfaz,cmbTiposDeRecursos);
            System.out.print(seleccion);
            /*Mando al gestor para que pueda obtener todos los recursos con el tipo pasado por parametro*/
            /*Aca supongo que deberiamos ver si el estado es baja tecnica o baja definitiva, hay que ver eso
            */
            ArrayList<RecursoTecnologico> recursos = gestor.buscarRTDeTipoSeleccionado(seleccion);
            pantalla.setListaRT(recursos);
            
            /*PRUEBA DE QUE EL FILTRO POR TIPOS ESTA FUNCIONANDO, TRAE EL NUMERO 1 Y 2, PERO EL 3 NO*/
            for(int i=0;i<pantalla.getListaRT().size();i++){
                System.out.print(pantalla.getListaRT().get(i).getNumeroRT() + " ");
            
            }
            
            /*Buscar y obtener los datos de los recursos, ACA NO SE SI DEVOLVERIA UN ARRAY DE RECURSOS PORQUE TIENE Q CONTENER EL CENTRO AL QUE PERTENECE */
            ArrayList<RecursoTecnologico> recursosAll = gestor.buscarInformacionRecursosTecnologicos(recursos);
            /*HAY QUE VER COMO SE IMPLEMENTA LA DEPENDENCIA PARA PODER SABER Q RECURSOS TIENE UN CENTRO, ENTONCES LE MANDAS O UN ARRAY Q TIENE EL CENTRO O LOS CENTROS POR SEPARADOS*/
            gestor.agruparRTPorCI(recursosAll);
            /*llama a la pantalla y esta o crea una nueva gui q muestre todos los recursos agrupados y espera a q selecciones una para setearlo como recurso seleccionado*/
            pantalla.mostrarRTAgrupados(recursosAll);
            /*no entiendo lo de agruparlos por colores, donde dice que hay que hacerlo*/
            
            
            int usuario = gestor.buscarUsuarioLogueado();
            /*ya no entiendo como hacer esto*/
            gestor.verificarCIDeCientifico(usuario);
            
            /*Obtiene la hora actual del sistema*/
            String horaActual = gestor.obtenerFechaYHoraActual();
            System.out.print(horaActual);
            
            
            
            
            
            
            /*LA PARTE DEL AMBITO*/
            String amb = "recurso tecnologico";
            
            gestor.reservarTurnoDeRT(amb);
            
            
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
