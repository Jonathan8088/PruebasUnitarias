package udec.pruebasunitarias;

import java.util.HashMap;
import java.util.Map;

/**
 *clase que contiene los atributos de una persona
 * @author Jonathan
 */
public class Persona {
    /**
     * atributo que contiene la identificacion de la persona
     */
    private int identificacion;
    /**
     * atributo que contiene el nombre de la persona
     */
    private String nombre;
    /**
     * atributo que contiene el apellido de la persona
     */
    private String apellidos;
    /**
     * mapa que contiene los hijos correspondientes de la persona
     */
    private Map<Integer,Persona> hijo = new HashMap();
    /**
     * constructor de la clase
     * @param identificacion numero de indentificacion de la persona
     * @param nombre nombre de la persona
     * @param apellidos apellidos de la persona
     */
    public Persona(int identificacion, String nombre, String apellidos) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }//constructor
    /**
     * retorna el valor de la identificacion
     * @return identificacion
     */
    public int getIdentificacion() {
        return identificacion;
    }//getIdentificacion
    /**
     * modifica la identificacion de la persona
     * @param identificacion 
     */
    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }//setIdentificacion
    /**
     * retorna el nombre de la persona
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }//getNombre
    /**
     * modifica el nombre de la persona
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }//setNombre
    /**
     * retorna los apellidos de la persona
     * @return apellidos
     */
    public String getApellidos() {
        return apellidos;
    }//getApellidos
    /**
     * modifica los apellidos de la persona
     * @param apellidos 
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }//setApellidos
    /**
     * retorna el mapa con los hijos de la persona
     * @return getHijo
     */
    public Map<Integer, Persona> getHijo() {
        return hijo;
    }//getHijo
    /**
     * modifica el mapa con los hijos de la persona
     * @param hijo 
     */
    public void setHijo(Map<Integer, Persona> hijo) {
        this.hijo = hijo;
    }//setHijo
    
}//Persona
