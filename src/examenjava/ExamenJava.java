/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenjava;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;




/**
 *
 * @author alexc
 */
public class ExamenJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        // TODO code application logic here
        // Crear un proyecto Java 
        //que ejecute una app web
        //debe tener un extremo de API JSON que tome una de las siguientes API
        // https://syndicator.univision.com/web-api/content?url=https://www.univision.com&lazyload=false
        // https://syndicator.univision.com/web-api/content?url=https://www.univision.com/noticias&lazyload=false
//         Cada respuesta de la API tiene una lista de widgets
//         en data.widgets
        // cada uno de estos tiene cero o mas contenidos
        // cada objeto de contenido tiene un campo de tipo y
        // uno de titulo.
        // el extremo de la API debe devolver una lista de:
        // 1.- cada tipo de contenido con el recuento de contenidos
        // de ese tipo y sus titulos
        
        URL url = new URL("http://127.0.0.1:5000");
        //http://127.0.0.1:5000
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
         ArrayList <Argumento> elementos=new ArrayList<>();
         ArrayList<CarpetaDatos>cDatos= new ArrayList<>();
        con.setRequestMethod("GET");
        con.connect();
//        
        int responseCode = con.getResponseCode();
        if(responseCode!=200){
            throw new RuntimeException("ocurrio un error: "+responseCode);
        }
        else{
            StringBuilder infoString = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());
            while(scanner.hasNext()){
                infoString.append(scanner.nextLine());
            }
            scanner.close();
            //System.out.println(infoString);
//            String prueeee= infoString.toString();
//            System.out.println(prueeee);
            JSONObject jsObject = new JSONObject(infoString.toString());
//            //jsObject.append("data", infoString);
            //System.out.println(jsObject.query("/data/widgets"));
            JSONArray jsArray=new JSONArray(jsObject.query("/data/widgets").toString());
//            //System.out.println(jsArray);
//            System.out.println(jsArray.length());
//            JSONObject jsOArre[]=new JSONObject[jsArray.length()];
            JSONObject jsOArre[]=new JSONObject[jsArray.length()];//guardaremos la info de widgets jsOArre= jsOCarpetas
            JSONArray jsAContents[]= new JSONArray[jsOArre.length];// para extraer la info de cada uno de los widgets(contenido)
            JSONObject jsOArre2[];
            
//            JSONArray jsAContents[]= new JSONArray[jsOArre.length];
//                    //(JSONArray)jsOArre[0].get("contents");
//            JSONObject jsOArre2[]=new JSONObject[jsAContents.length];
            for (int i = 0; i < jsOArre.length; i++) {
                jsOArre[i]=jsArray.getJSONObject(i);
                jsAContents[i]=(JSONArray)jsOArre[i].get("contents");
                System.out.println(jsOArre[i].get("contents"));
                //cDatos.add(new CarpetaDatos(jsAContents[i].length(),jsOArre[i].getString("type")));
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
////                    for (int j = 0; j < jsAContents[i].length(); j++) {
//////                    for (int k = 0; k < jsAContents[j].length(); k++) {
////                        jsOArre2[j]=jsAContents[i].getJSONObject(j);
////                        System.out.println(jsOArre2[j].get("type")+" title: "+ jsOArre2[j].get("title"));
////////            
////                    }
////                }
////                
////            }
            //JSONArray jsAContents=(JSONArray)jsOArre[0].get("contents");
            //System.out.println(jsAContents.get(0));
            //System.out.println(jsAContents.length());
            
            //JSONObject jsOArre2[]=new JSONObject[jsAContents.length()];
            
//            for (int i = 0; i < jsOArre2.length; i++) {
//                jsOArre2[i]=jsAContents.getJSONObject(i);
//                System.out.println(jsOArre2[i].get("type")+" title: "+ jsOArre2[i].get("title"));
//            }
//            JSONObject jsOb2=jsArray.getJSONObject(3);
//            System.out.println(jsOb2.get("type"));
        }  
        
    }
    
}
