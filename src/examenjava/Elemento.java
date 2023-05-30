/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenjava;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author alexc
 */
public class Elemento {
    //creamos arreglo para guardar los elementos a mostrar (carpeta, tipo y titulo)
    private ArrayList <Argumento> elementos;
    // creamos arreglo para contabilizar los datos
    private ArrayList<CarpetaDatos> cDatos;
    
    // cremos contructor para mandar llamar los metodos de esta clase
    public Elemento() {
    }
    
    /*metodo que administra la conexion a la API. si se establece una buena conexion, entonces
    recolecta la informacion, despues la va separando en partes mas peque…‡as hasta guardar unicamente
    los datos que necesitamos.
    este metodo recibe 4 parametros:
    1.- entero: si se establecio una conexion, el numero sera 200
    2.- url: la cual servira para recopilar la informacion de la API
    3.- JLabel: en este mostraremos la fecha en la cual se establecio la conexion
    4.- JTextArea: en este mostraremos los datos contabilizados de los widgets*/
    public String start(int conexion, URL url, JLabel fecha,JTextArea jtad) throws IOException{
        // inicializamos los arreglos, lo hacemos aqui para cuando este la app en ejecucion, no empalme datos
        elementos=new ArrayList<>();
        cDatos= new ArrayList<>();
        
        //verificamos que la conexion sea correcta
        if(conexion!=200){
            //si el numero de conexion es diferente a 200, mandamos un error, ya que no se pudo establecer una buena conexion
            throw new RuntimeException("ocurrio un error: "+conexion);
        }
        else{
            // mostramos ventana emergente de que se pudo establecer una conexion correcta
            JOptionPane.showMessageDialog(null, "Conexion Exitosa");
            // creamos un objeto, en la cual vamos a almacenar los datos de la API
            StringBuilder infoString = new StringBuilder();
            // este objeto nos permitira establecer la conexion a la url
            Scanner scanner = new Scanner(url.openStream());
            // insertamos los datos de la url en la variable 
            infoString.append(scanner.nextLine());
            //terminamos la conexion
            scanner.close();
            //a partir de la cadena obtenida, creamos un JSONObject para manipular la info de manera mas sencilla
            JSONObject jsObject = new JSONObject(infoString.toString());

            //referenciamos la info que se utilizara para trabajar unicamente con esta, la cual esta en data.widgets
            JSONArray jsArray=new JSONArray(jsObject.query("/data/widgets").toString());
            
            //creamos tres arreglos, en los cuales referenciaremos informacion precisa para poder acceder a ella y manipularla
            JSONObject jsOArre[]=new JSONObject[jsArray.length()];//guardaremos la info de widgets jsOArre= jsOCarpetas
            JSONArray jsAContents[]= new JSONArray[jsOArre.length];// para extraer la info de cada uno de los widgets(contenido)
            JSONObject jsOArre2[];//creamos JSONObject para guardar cada uno de los contenidos, este cambia su tama…‡o en tiempo de ejecucion
            
            //el primer for recorre cada una de las carpetas de widgets
            for (int i = 0; i < jsOArre.length; i++) {
                //pasamos los datos de data.widgets a un arreglo de jsonObject
                jsOArre[i]=jsArray.getJSONObject(i);
                //referenciamos unicamente la info con la cual extraeremos los datos (contenido)
                jsAContents[i]=(JSONArray)jsOArre[i].get("contents");
                
                //guardamos los datos que nos serviran para contabilizar los elementos (# de elementos y nombre de carpeta)
                cDatos.add(new CarpetaDatos(jsAContents[i].length(),jsOArre[i].getString("type")));
                //asignamos tama…‡o al arreglo con el cual extraeremos los datos de cada una de las carpetas
                //este tama…‡o estara cambiando en tiempo de ejecucion, ya que estara manipulando diferentes grupos de datos
                jsOArre2=new JSONObject[jsAContents[i].length()];
                /*en este for referenciamos cada uno de los widgets para despues a…‡adirlos al arreglo (elementos)
                en el cual guardaremos todos para despues mostrarlos, guardamos 3 datos
                1.- carpeta a la que pertenece
                2.- tipo de widget
                3.- titulo
                tambien agregamos el elemento a su carpeta, si ya esta alguno de su tipo, solo se aumenta el contador metodo(addDato)*/
                    for (int j = 0; j < jsAContents[i].length(); j++) {
                        //referenciamos cada  uno de los widget
                        jsOArre2[j]=jsAContents[i].getJSONObject(j);
                        //a…‡adimos los widgets a nuestro arreglo, en el cual almacenaremos todos para despues manipularlos a traves de este.
                        //solo guardamos los 3 datos antes mencionados de cada widget
                        elementos.add(new Argumento(jsOArre[i].getString("type"), jsOArre2[j].get("type")+"", jsOArre2[j].get("title")+""));
                        // el metodo addDato, funciona para contabilizar los tipos de widgets, si ya hay uno de su tipo, solo aumenta el contador
                        cDatos.get(i).addDato(new Dato(jsOArre[i].getString("type"),jsOArre2[j].get("type")+""));      
                    }
            }
        } 
        // mostramos los datos generales en el jTextArea
        jtad.setText(cDatos.toString());
        //establecemos la fecha actual en el cual se ejecuto el metodo start 
        fecha.setText(fecha());
    //regresa los datos de los widgets    
    return elementos.toString();
    }
    
    public String fecha(){
        String fech=LocalDate.now().toString();
        String fecha=fech+" "+hora();
        return "ultima actualizacion: "+ fecha;
    }
    public String hora(){
        Calendar calendario= Calendar.getInstance();
        String horamin;
        int hor=calendario.get(Calendar.HOUR_OF_DAY);
        int min=calendario.get(Calendar.MINUTE);
        horamin= hor+":"+min;
        return horamin;
    }
    
    public String buscar(String busqueda){
         ArrayList <Argumento> elemAux=new ArrayList<>();
        for (int i = 0; i < elementos.size(); i++) {
            if(elementos.get(i).getCarpeta().contains(busqueda)||elementos.get(i).getTipo().contains(busqueda)
                    ||elementos.get(i).getTitulo().contains(busqueda)){
                elemAux.add(elementos.get(i));
            }
        }
        if(elemAux.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se encontraron resultados, ingrese otra palabra");
            return mostrarAllDatos();
        }else
            return elemAux.toString();
    }

    public String mostrarAllDatos() {
        return elementos.toString();
    }
    
    public String[]mosItem(){
        
        String[]nomCar=new String[cDatos.size()];
        for (int i = 0; i < cDatos.size(); i++) {
            nomCar[i]=(i+1)+" "+cDatos.get(i).getNombre();
        }
    return nomCar;
    }
    
    public String mostrarPorCarpeta(int i){
        if(i==16||i==-1)
            System.out.println("Muestra todos");
        else{
            int comenzar=0;
        int nElementosM=cDatos.get(i).getnElementos();
        int terminar;
        String datosMostrar="";
            
                for (int j = 0; j < i; j++) {
            comenzar+=cDatos.get(j).getnElementos();
            }
            terminar=comenzar+nElementosM;

            for (int j = comenzar; j < terminar; j++) {
                datosMostrar+=elementos.get(j).toString();
        }
    return datosMostrar;
        }
        return elementos.toString();
    }
    
}
