/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenjava;




/**
 *
 * @author alexc
 */
public class ExamenJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        
//        URL url = new URL("https://syndicator.univision.com/web-api/content?url=https://www.univision.com&lazyload=false");
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        
//        con.setRequestMethod("GET");
//        con.connect();
//        
//        int responseCode = con.getResponseCode();
//        if(responseCode!=200){
//            throw new RuntimeException("ocurrio un error: "+responseCode);
//        }
//        else{
//            StringBuilder infoString = new StringBuilder();
//            Scanner scanner = new Scanner(url.openStream());
//            
//            infoString.append(scanner.nextLine());
//            
//            scanner.close();
//            //System.out.println(infoString);
//            JSONObject jsObject = new JSONObject(infoString.toString());
//            //jsObject.append("data", infoString);
//            //System.out.println(jsObject.query("/data/widgets"));
//            JSONArray jsArray=new JSONArray(jsObject.query("/data/widgets").toString());
//            //System.out.println(jsArray);
//            System.out.println(jsArray.length());
//            JSONObject jsOArre[]=new JSONObject[jsArray.length()];
//            
//            JSONArray jsAContents[]= new JSONArray[jsOArre.length];
//                    //(JSONArray)jsOArre[0].get("contents");
//            JSONObject jsOArre2[]=new JSONObject[jsAContents.length];
//            for (int i = 0; i < jsOArre.length; i++) {
//                jsOArre[i]=jsArray.getJSONObject(i);
//                System.out.println(jsOArre[i].get("type"));
//                System.out.println((i+1)+" aqui vamos");
//                    jsAContents[i]=(JSONArray)jsOArre[i].get("contents");
//                    
//                    for (int j = 0; j < jsAContents[i].length(); j++) {
//////                    for (int k = 0; k < jsAContents[j].length(); k++) {
//                        jsOArre2[j]=jsAContents[i].getJSONObject(j);
//                        System.out.println(jsOArre2[j].get("type")+" title: "+ jsOArre2[j].get("title"));
////////            
//                    }
////                }
//                
//            }
//            //JSONArray jsAContents=(JSONArray)jsOArre[0].get("contents");
//            //System.out.println(jsAContents.get(0));
//            //System.out.println(jsAContents.length());
//            
//            //JSONObject jsOArre2[]=new JSONObject[jsAContents.length()];
//            
////            for (int i = 0; i < jsOArre2.length; i++) {
////                jsOArre2[i]=jsAContents.getJSONObject(i);
////                System.out.println(jsOArre2[i].get("type")+" title: "+ jsOArre2[i].get("title"));
////            }
////            JSONObject jsOb2=jsArray.getJSONObject(3);
////            System.out.println(jsOb2.get("type"));
//        }  
        
    }
    
}
