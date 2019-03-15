package udec.pruebasunitarias;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *clase que maneja la logica del proyecto
 * @author Jonathan
 */
public class Logic {
    /**
     * mapa que recibe los datos del arbol genealogico
     */
    Map<Integer, Persona> arbol = new HashMap();
    /**
     * constructor de la clase
     */
    public Logic() {
    }//constructor 
    /**
     * metodo que realiza la busqueda de las relaciones familiares de una persona especifica
     * @param busqueda llave que identifica la persona con la cual se va a realizar el filtrado de la busqueda
     * @param arbol2 mapa donde se envian los datos de todos los familiares para realizar la busqueda
     * @return 
     */
    public String impresion(Integer busqueda, Map arbol2){
        String lista=""; //string que va a recibir los nombres de las personas correspondientes segun el parametro de busqueda
        arbol.putAll(arbol2);
        for (Integer llave : arbol.keySet()) { //busqueda de familiares desde abuelo hacia nietos
            if(llave == busqueda){
                lista = lista.concat(arbol.get(llave).getNombre());
                System.out.println("Soy \n Identificacion: "+arbol.get(llave).getIdentificacion()+" Nombre: "+arbol.get(llave).getNombre()+" Apellido: "+arbol.get(llave).getApellidos());
                for (Integer key : arbol.get(llave).getHijo().keySet()) {
                    lista = lista.concat(arbol.get(llave).getHijo().get(key).getNombre());
                    System.out.println("Hijo\nIdentificacion: "+arbol.get(llave).getHijo().get(key).getIdentificacion()+" Nombre: "+arbol.get(llave).getHijo().get(key).getNombre()+" Apellido: "+arbol.get(llave).getHijo().get(key).getApellidos());
                    for (Integer nieto : arbol.get(llave).getHijo().get(key).getHijo().keySet()) {
                        lista = lista.concat(arbol.get(llave).getHijo().get(key).getHijo().get(nieto).getNombre());
                        System.out.println("Nieto\nIdentificacion: "+arbol.get(llave).getHijo().get(key).getHijo().get(nieto).getIdentificacion()+" Nombre: "+arbol.get(llave).getHijo().get(key).getHijo().get(nieto).getNombre()+" Apellido: "+arbol.get(llave).getHijo().get(key).getHijo().get(nieto).getApellidos());
                    }//for
                }//for
                break;
            }else
                for (Integer key : arbol.get(llave).getHijo().keySet()) {
                    if(arbol.get(llave).getHijo().containsKey(busqueda)){//busqueda de familiares desde un padre mostrando abuelo e hijos correspondientes al padre
                        if(key == busqueda){
                            lista = lista.concat(arbol.get(llave).getHijo().get(key).getNombre());
                            System.out.println("Soy padre\nIdentificacion: "+arbol.get(llave).getHijo().get(key).getIdentificacion()+" Nombre: "+arbol.get(llave).getHijo().get(key).getNombre()+" Apellido: "+arbol.get(llave).getHijo().get(key).getApellidos());
                            lista = lista.concat(arbol.get(llave).getNombre());
                            System.out.println("Mi padre es\n Identificacion: "+arbol.get(llave).getIdentificacion()+" Nombre: "+arbol.get(llave).getNombre()+" Apellido: "+arbol.get(llave).getApellidos());
                            for (Integer nieto : arbol.get(llave).getHijo().get(key).getHijo().keySet()) {
                                lista = lista.concat(arbol.get(llave).getHijo().get(key).getHijo().get(nieto).getNombre());
                                System.out.println("Hijo\nIdentificacion: "+arbol.get(llave).getHijo().get(key).getHijo().get(nieto).getIdentificacion()+" Nombre: "+arbol.get(llave).getHijo().get(key).getHijo().get(nieto).getNombre()+" Apellido: "+arbol.get(llave).getHijo().get(key).getHijo().get(nieto).getApellidos());
                            }//for
                        }//if
                }else if(arbol.get(llave).getHijo().get(key).getHijo().containsKey(busqueda)){ //busqueda de familiares desde un hijo hacia su abuelo
                            for (Integer nieto : arbol.get(llave).getHijo().get(key).getHijo().keySet()) {
                                if(nieto == busqueda){
                                    lista = lista.concat(arbol.get(llave).getHijo().get(key).getHijo().get(nieto).getNombre());
                                    System.out.println("Soy\nIdenificacion: "+arbol.get(llave).getHijo().get(key).getHijo().get(nieto).getIdentificacion()+" Nombre: "+arbol.get(llave).getHijo().get(key).getHijo().get(nieto).getNombre()+" Apellido: "+arbol.get(llave).getHijo().get(key).getHijo().get(nieto).getApellidos());
                                    lista = lista.concat(arbol.get(llave).getHijo().get(key).getNombre());
                                    System.out.println("Mi padre es\nIdentificacion: "+arbol.get(llave).getHijo().get(key).getIdentificacion()+" Nombre: "+arbol.get(llave).getHijo().get(key).getNombre()+" Apellido: "+arbol.get(llave).getHijo().get(key).getApellidos());
                                    lista = lista.concat(arbol.get(llave).getNombre());
                                    System.out.println("Mi abuelo es\nIdentificacion: "+arbol.get(llave).getIdentificacion()+" Nombre: "+arbol.get(llave).getNombre()+" Apellido: "+arbol.get(llave).getApellidos());
                                }//if
                            }//for
                        }//if
            }//for
        }//for
        return lista;
    }//impresion
}//Logic
