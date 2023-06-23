/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package examenjava;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexc
 */
public class ElementoTest {
    public ElementoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testStart() throws Exception {
        //este metodo requiere conexion a API
        System.out.println("start");
        URL url = new URL("http://127.0.0.1:5000");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();
        int responseCode = con.getResponseCode();
        
        JLabel fecha = new JLabel();
        JTextArea jtad = new JTextArea();
        Elemento instance = new Elemento();
        String expResult = "[{carpeta: topquicklinks tipo: video, titulo: ? En un minuto}\n" +
", {carpeta: topquicklinks tipo: image, titulo: Eso y mas}\n" +
"]";
        String result = instance.start(responseCode, url, fecha, jtad);
        assertEquals(expResult, result);
        if(!expResult.equals(result)){
            fail("The test case is a prototype.");
        }
        else
            System.out.println("Metodo 'start' se ejecuto de manera correcta");
    }

    @Test
    public void testFecha() {
        System.out.println("fecha");
        Elemento instance = new Elemento();
        Calendar calendario= Calendar.getInstance();
        String expResult = "ultima actualizacion: "+LocalDate.now().toString()+" "+
                calendario.get(Calendar.HOUR_OF_DAY)+":"+calendario.get(Calendar.MINUTE);
        String result = instance.fecha();
        assertEquals(expResult, result);
        if(!expResult.equals(result))
            fail("The test case is a prototype.");
        else
            System.out.println("Metodo Fecha se ejecuto correctamente");
    }

    @Test
    public void testHora() {
        System.out.println("hora");
        Elemento instance = new Elemento();
        Calendar calendario= Calendar.getInstance();
        String expResult = calendario.get(Calendar.HOUR_OF_DAY)+":"+calendario.get(Calendar.MINUTE);
        String result = instance.hora();
        assertEquals(expResult, result);
        if(!expResult.equals(result))
            fail("The test case is a prototype.");
        else
            System.out.println("Metodo Hora se ejecuto correctamente");
    }

    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        String busqueda = "video";
        Elemento instance = new Elemento("topquicklinks","video","? En un minuto");
        String expResult = "[{carpeta: topquicklinks tipo: video, titulo: ? En un minuto}\n" +"]";
        String result = instance.buscar(busqueda);
        assertEquals(expResult, result);
        if(!expResult.equals(result))
            fail("The test case is a prototype.");
        else
            System.out.println("Metodo Buscar se ejecuto correctamente");
    }

    @Test
    public void testMostrarAllDatos() {
        System.out.println("mostrarAllDatos");
        Elemento instance = new Elemento("topquicklinks","video","? En un minuto");
        String expResult = "[{carpeta: topquicklinks tipo: video, titulo: ? En un minuto}\n" +"]";
        String result = instance.mostrarAllDatos();
        assertEquals(expResult, result);
        if(!expResult.equals(result))
            fail("The test case is a prototype.");
        else
            System.out.println("Metodo MostrarAllDatos se ejecuto correctamente");
    }

    @Test
    public void testMosItem() {
        System.out.println("mosItem");
        Elemento instance = new Elemento("topquicklinks","video","? En un minuto");
        String[] expResult = {"1 topquicklinks"};
        String[] result = instance.mosItem();
        assertArrayEquals(expResult, result);
        if(!expResult[0].equals(result[0]))
            fail("The test case is a prototype.");
        else
            System.out.println("Metodo MosItem se ejecuto correctamente");
    }

    @Test
    public void testMostrarPorCarpeta() {
        System.out.println("mostrarPorCarpeta");
        int i = 0;
        int tam = 1;
        Elemento instance = new Elemento("topquicklinks","video","? En un minuto");
        String expResult = "{carpeta: topquicklinks tipo: video, titulo: ? En un minuto}\n";
        String result = instance.mostrarPorCarpeta(i, tam);
        assertEquals(expResult, result);
         if(!expResult.equals(result))
            fail("The test case is a prototype.");
        else
            System.out.println("Metodo MostrarPorCarpeta se ejecuto correctamente");
    }
    
}
