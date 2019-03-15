import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import udec.pruebasunitarias.Logic;
import udec.pruebasunitarias.Persona;

/**
 *clase donde se realizan pruebas unitarias del proyecto
 * @author Jonathan
 */
public class PruebasUnitarias {
    /**
     * mapa donde se guardan por defecto los integrantes del arbol genealogico
     */
   static Map<Integer, Persona> arbol = new HashMap();
    /**
     * constructor de la clase
     */
    public PruebasUnitarias() {
    }//constructor
    /**
     * metodo que se ejecuta antes de inicializar la clase y agrega por defecto los miembors de la familia
     * al mapa
     */
    @BeforeClass
    public static void setUpClass() {
        agregar();
    }//setUpClass
    /**
     * metodo que se ejecuta al finalizar la clase
     */
    @AfterClass
    public static void tearDownClass() {
    }//tearDownClass
    /**
     * metodo que agrega por defecto miembros de la familia y los agrega al mapa
     */
    private static void agregar(){
        Persona pAbuelo1 = new Persona(1, "Gerardo", "Perez");
        arbol.put(1, pAbuelo1);
        Persona pAbuelo2 = new Persona (2,"Bernarda","Gonzalez");
        arbol.put(2, pAbuelo2);

        Persona pPadre1 = new Persona(3, "Pedro", "Perez");
        pAbuelo1.getHijo().put(3, pPadre1);
        Persona pPadre2 = new Persona(4, "Andres", "Perez");
        pAbuelo1.getHijo().put(4, pPadre2);
        Persona pPadre3 = new Persona(5, "Rodrigo", "Perez");
        pAbuelo1.getHijo().put(5, pPadre3);

        Persona pPadre4 = new Persona(6, "Manuel", "Gonzalez");
        pAbuelo2.getHijo().put(6, pPadre4);
        Persona pPadre5 = new Persona(7, "Luis", "Gonzalez");
        pAbuelo2.getHijo().put(7, pPadre5);
        Persona pPadre6 = new Persona(8, "Fernando", "Gonzalez");
        pAbuelo2.getHijo().put(8, pPadre6);
       
        Persona pHijo1 = new Persona(9, "Felipe", "Perez");
        pPadre1.getHijo().put(9, pHijo1);
        Persona pHijo2 = new Persona(10, "Juan", "Perez");
        pPadre1.getHijo().put(10, pHijo2);
        Persona pHijo3 =  new Persona(11, "Alfredo", "Perez");
        pPadre2.getHijo().put(11, pHijo3);
        Persona pHijo4 =  new Persona(12, "Edwin", "Perez");
        pPadre2.getHijo().put(12, pHijo4);
        Persona pHijo5 =  new Persona(13, "Pedro", "Perez");
        pPadre3.getHijo().put(13, pHijo5);
        Persona pHijo6 = new Persona(14, "Steven", "Perez");
        pPadre3.getHijo().put(14, pHijo6);
        
        Persona pHijo7 = new Persona(15, "Julian", "Gonzalez");
        pPadre4.getHijo().put(15, pHijo7);
        Persona pHijo8 = new Persona(16, "Duvan", "Gonzalez");
        pPadre4.getHijo().put(16, pHijo8);
        Persona pHijo9 = new Persona(17, "Jonathan", "Gonzalez");
        pPadre5.getHijo().put(17, pHijo9);
        Persona pHijo10 = new Persona(18, "Fabian", "Gonzalez");
        pPadre5.getHijo().put(18, pHijo10);
        Persona pHijo11 = new Persona(19, "Jacobo", "Gonzalez");
        pPadre6.getHijo().put(19, pHijo11);
        Persona pHijo12 = new Persona(20, "Mario", "Gonzalez");
        pPadre6.getHijo().put(20, pHijo12);
        
    }//agregar
    /*@Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }*/

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    /**
     * 
     */
    /**
     * metodo que realiza pruebas cuando se busca las relaciones familiares buscando desde un abuelo
     */
    @Test
    public void impresionAbuelo(){
       Logic logic = new Logic();
       String lista1 = logic.impresion(2, arbol);
       assertEquals("BernardaManuelDuvanJulianLuisJonathanFabianFernandoJacoboMario", lista1);
    }//impresionAbuelo
    /**
     * metodo que realiza pruebas cuando se busca las relaciones familiares buscando desde un padre
     */
    @Test
    public void impresionPadre(){
       Logic logic = new Logic();
       String lista1 = logic.impresion(3, arbol);
       assertEquals("PedroGerardoFelipeJuan", lista1);
    }//impresionPadre
    /**
     * metodo que realiza pruebas cuando se busca las relaciones familiares buscando desde un hijo
     */
    @Test
    public void impresionHijo(){
        Logic logic = new Logic();
       String lista1 = logic.impresion(20, arbol);
       assertEquals("MarioFernandoBernarda", lista1);
    }//impresionHijo
    /**
     * metodo que realiza pruebas cuando se busca relaciones familiares buscando con un parametro 
     * inexistente en el mapa
     */
    @Test
    public void impresionNula(){
       Logic logic = new Logic();
       String lista1 = logic.impresion(50, arbol);
       assertEquals("", lista1);
    }//impresionNula
}//PruebasUnitarias
