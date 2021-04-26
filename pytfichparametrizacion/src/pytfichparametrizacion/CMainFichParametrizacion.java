package pytfichparametrizacion;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
class ${public static void  $(String is){System.out.print  (is);}
        public static void $$(String is){System.out.println(is);}}

public class CMainFichParametrizacion {

    static Scanner poTeclado = new Scanner(System.in);  
    static String psFicheroPrincipal= "FchPrincipal.txt";
    static String psFicheroAuxiliar = "FchAuxiliar";    
    static File pof1, pof2; 
    static FileReader pofr; 
    static FileWriter pofw; 
    static int piOrdenDelUltimoCampo = 2;
    
    public static void main(String[] args) throws IOException, FileNotFoundException { 
        mvFicherosDeTextoV1(); 
        //mvFicherosDeTextoV2(); 
    }//main()

    static void     mvFicherosDeTextoV1() throws IOException, FileNotFoundException{           
        boolean wbTerminar= false;
        while (!wbTerminar){
            String ws = msPedirOpcionDeMenuV1().toLowerCase();
            File wof1 = new File(psFicheroPrincipal);
            if ( !wof1.exists() && ("afbmcl".contains(ws)) ){
                $.$$(">> Lo siento. Aún NO EXISTE el fichero. Primero debe crearlo.");
                continue;
            }  
            switch (ws){
                case ("s"): {wbTerminar = true;   $.$$(">> FIN del programa.");             break;}
                case ("v"): { mvCrearFicheroVacio();                                        break;}
                case ("l"): { mvListado();                                                  break;}     
                case ("c"): { mvConsulta(   msPedir("Clave del registro a consultar: "  )); break;}                                  
                case ("b"): { mvBaja(       msPedir("Clave del registro a BORRAR: "     )); break;} 
                case ("m"): { mvModificar(  msPedir("Clave del registro a MODIFICAR: "  ), 
                                            msPedir("Valor del registro a MODIFICAR: "  )); break;} 
                case ("f"): { mvNuevo(      msPedir("Clave del registro a CREAR: "      ), 
                                            msPedir("Valor del registro a CREAR: "      )); break;}
                case ("a"): { mvAlta(       msPedir("Clave del registro a CREAR: "      ), 
                                            msPedir("Valor del registro a CREAR: "      )); break;}
            }//switch
        }// while         
    }//mvFicherosDeTextoV1()
    static void     mvFicherosDeTextoV2() throws IOException, FileNotFoundException{           
        boolean wbTerminar= false;
        while (!wbTerminar){
            String ws = msPedirOpcionDeMenuV1().toLowerCase();            
            File wof1 = new File(psFicheroPrincipal);
            if ( !wof1.exists() && ("afbmcl".contains(ws)) ){
                $.$$(">> Lo siento. Aún NO EXISTE el fichero. Primero debe crearlo.");
                continue;
            }             
            switch (ws){
                case ("s"): { wbTerminar = true; $.$$(">> FIN del programa.");                                                       break;}
                case ("v"): { mvCrearFicheroVacio();                                                    break;}
                case ("l"): { mvTratarFichero(ws,   "0", "");                                           break;}     
                case ("c"): { mvTratarFichero(ws,   msPedir("Clave del registro a consultar? "  ), ""); break;}                                  
                case ("b"): { mvTratarFichero(ws,   msPedir("Clave del registro a BORRAR?    "  ), ""); break;} 
                case ("m"): { mvTratarFichero(ws,   msPedir("Clave del registro a MODIFICAR? "  ), 
                                                    msPedir("Valor del registro a MODIFICAR? "  ));     break;} 
                case ("f"): { mvTratarFichero(ws,   msPedir("Clave del registro a CREAR? "      ), 
                                                    msPedir("Valor del registro a CREAR? "      ));     break;}
                case ("a"): { mvTratarFichero(ws,   msPedir("Clave del registro a CREAR? "      ), 
                                                    msPedir("Valor del registro a CREAR? "      ));     break;}
            }//switch
        }// while         
    }//mvFicherosDeTextoV2()
   
    static String   msPedirOpcionDeMenuV1(){
        $.$( "Menú de Ficheros de Texto:");
            $.$$("\n s) Salir");
            $.$$("\n v) Crear un fichero Vacío");            
            $.$$("\n l) Listado");
            $.$$("\n c) Consulta");                
            $.$$("\n b) Baja");
            $.$$("\n m) Modificación");                       
            $.$$("\n f) Alta al Final");                
            $.$$("\n a) Alta en su sitio");                
            $.$$("");
        return poTeclado.nextLine();
    }//miPedirOpcionDeMenuV1()
    static String   msPedirOpcionDeMenuV2(){
        $.$( "\nMenú:"
            +"\n s   v   l   c    b    m   f       a:"+
             "\n Salir   Listado  Baja     Añadir  Alta" +
             "\n     Vacío   Consulta  Modificación"
            +"\n");
        return poTeclado.nextLine();
    }//miPedirOpcionDeMenuV2()
    static String   msPedir(String is){ $.$(is); return poTeclado.nextLine();}
    
    static void     mvCrearFicheroVacio() throws IOException {
        /*pof1= new File(psFicheroPrincipal);
        pof1.createNewFile();
        pof1= null;  */   
        (pof1= new File(psFicheroPrincipal)).createNewFile(); 
        FileWriter pofw = new FileWriter(pof1); pofw.write("0; ;"); pofw.close();
        $.$$(">> Se ha CREADO el fichero \'"+pof1.getName()+"\'.");
        pof1= null;
    }//mvCrearFicheroVacio
    static void     mvListado() throws IOException, FileNotFoundException  {
        $.$$(">> COMIENZO-3 del listado.");
        pofr = new FileReader(new File(psFicheroPrincipal));
        

        int wiFinDeCampo=0;
        String wsRegistro= "";
        int wi;
        while ( ( wi=pofr.read()) != -1 ) {
            char wc = (char) wi;
            wsRegistro += wc;
            if (wc == ';') wiFinDeCampo++;
            if (wiFinDeCampo == 2) {
                $.$$(wsRegistro);
                wsRegistro="";
                wiFinDeCampo = 0;
            }
        }//while   
        
        pofr.close();  
        $.$$(">> FINAL del listado.\n");
    }//mvListado

    static void     mvConsulta( String isClave) throws IOException, FileNotFoundException {
        pofr = new FileReader(new File(psFicheroPrincipal));


        String wsClave;
        String wsValor;
        int wiClaveABuscar = Integer.parseInt(isClave);

        boolean wbTerminar= false;
        boolean wbEncontrado = false;
        
        int wiClave=0;
        int wiFinDeCampo=0;
        String wsCampoActual= "";
        int wi;   
        while ( (wi=pofr.read()) != -1 ) {
            char wc = (char) wi;
            if (wc != ';') 
                wsCampoActual += wc;              
            else{
                wiFinDeCampo++;
                if (wiFinDeCampo == 1){
                    wiClave = Integer.parseInt(wsCampoActual);
                    wsCampoActual= "";
                }
                if (wiFinDeCampo == 2){
                    wsValor = wsCampoActual;
                    wsCampoActual= "";                    
                    wiFinDeCampo=0;
                    
                    if (wiClave == wiClaveABuscar){
                        $.$("\nValor de la clave buscada: "+wsValor);
                        wbEncontrado= true;
                        wbTerminar= true;
                    }
                }
            }            
            if (wbTerminar)
                    break;
        }//while   
        $.$("\n");
        if (!wbEncontrado) $.$(">> NO se ha ENCONTRADO el registro con clave " + isClave);
        pofr.close();     
    
    
    }//mvConsulta   
    static void     mvBaja(     String isClave) throws IOException, FileNotFoundException {
    
        pof1 = new File(psFicheroPrincipal);        
        pofr = new FileReader(pof1);
        pof2 = new File(psFicheroAuxiliar); 
        pofw = new FileWriter(pof2);

        int     wiOrdenDelCampoActual   = piOrdenDelUltimoCampo;
        String  wsBuffer                = "";
        String  wsRegistro              = "";
        String  wsClave                 = "";
        String  wsValor                 = "";
        int     wiClaveABuscar          = Integer.parseInt(isClave);
        boolean wbEncontrado = false;        
        boolean wbTerminar= false;
        
        while (!wbTerminar){
            int wi;
            if ((wi=pofr.read()) == -1) 
                wbTerminar= true;           //Si es EOF terminar
            else{
                char wc = (char) wi;
                if (wc != ';'){          
                    wsBuffer += wc;         //Si es un carácter normal lo guardamos en el buffer
                }else{                      //Si es un fin de campo, tratamos el campo entero                                              
                    wiOrdenDelCampoActual= (wiOrdenDelCampoActual == piOrdenDelUltimoCampo)? 1 : wiOrdenDelCampoActual+1;
                    switch (wiOrdenDelCampoActual){ //guardamos el buffer en el campo que le corresponde
                        case 1: {   wsClave = wsBuffer; break;}
                        case 2: {   wsValor = wsBuffer; break;}  
                    }//switch
                    wsRegistro += wsBuffer+";";
                    wsBuffer= "";

                    if (wiOrdenDelCampoActual == piOrdenDelUltimoCampo){ //Si ya tenemos el REGISTRO entero 
                        int wiClave = Integer.parseInt(wsClave);
                        if (wiClave == wiClaveABuscar){
                            $.$$(">> El Registro <"+wsClave+"> se ha ELIMINADO.");
                            wbEncontrado= true;
                            mvCopiarRestoDelFichero(pofr, pofw);
                        }else
                            pofw.write(wsRegistro);      

                        wsRegistro= "";
                    }                       
                }  
            }
        }//while            
          
        pofr.close();  
        pofw.close(); 
        pof1.delete();
        pof2.renameTo(pof1);
        pof2 = null;     
        pof1= null;        
        if (!wbEncontrado) $.$$(">> NO se ha ENCONTRADO el registro "+isClave);    
    }//mvBaja    
    static void     mvModificar(String isClave, String isValor) throws IOException, FileNotFoundException {
        pof1 = new File(psFicheroPrincipal);        
        pofr = new FileReader(pof1);        
        pof2 = new File(psFicheroAuxiliar); 
        pofw = new FileWriter(pof2);
                                  
        int     wiOrdenDelCampoActual   = piOrdenDelUltimoCampo;
        String  wsBuffer                = "";
        String  wsRegistro              = "";
        String  wsClave                 = "";
        String  wsValor                 = "";
        int     wiClave;
        int     wiClaveABuscar          = Integer.parseInt(isClave);
        boolean wbEncontrado = false;       
        boolean wbTerminar= false;
        
        while (!wbTerminar){
            int wi;
            if ((wi=pofr.read()) == -1) 
                wbTerminar= true;           //Si es EOF terminar
            else{
                char wc = (char) wi;
                if (wc != ';'){          
                    wsBuffer += wc;         //Si es un carácter normal lo guardamos en el buffer
                }else{                      //Si es un fin de campo, tratamos el campo entero                                              
                    wiOrdenDelCampoActual= (wiOrdenDelCampoActual == piOrdenDelUltimoCampo)? 1 : wiOrdenDelCampoActual+1;
                    switch (wiOrdenDelCampoActual){ //guardamos el buffer en el campo que le corresponde
                        case 1: {   wsClave = wsBuffer; break;}
                        case 2: {   wsValor = wsBuffer; break;}  
                    }//switch
                    wsRegistro += wsBuffer+";";
                    wsBuffer= "";

                    if (wiOrdenDelCampoActual == piOrdenDelUltimoCampo){ //Si ya tenemos el REGISTRO entero 
                        wiClave = Integer.parseInt(wsClave);  
                        
                    if (wiClave == wiClaveABuscar){
                        pofw.write(wsClave+";"+isValor+";"); 
                        $.$$(">> El Registro <"+wsClave+"> se ha MODIFICADO.");
                        wbEncontrado= true;
                        mvCopiarRestoDelFichero(pofr, pofw);
                    }else
                        pofw.write(wsRegistro);   
                    wsRegistro= "";
                    }                       
                }  
            }
        }//while            
          
        pofr.close();  
        pofw.close(); 
        pof1.delete();
        pof2.renameTo(pof1);
        pof2 = null;               
        pof1= null;        
        if (!wbEncontrado) $.$$(">> NO se ha ENCONTRADO el registro "+isClave);        
    }//mvModificar
    static void     mvNuevo(    String isClave, String isValor) throws IOException, FileNotFoundException {
        pof1 = new File(psFicheroPrincipal);        
        pofw = new FileWriter(pof1, true);
        pofw.write(isClave+";"+isValor+";"); 
        pofw.close();
        pof1= null;      
    }//mvNuevo
    static void     mvAlta(     String isClave, String isValor) throws IOException, FileNotFoundException {
    /////////////
        pof1 = new File(psFicheroPrincipal);        
        pofr = new FileReader(pof1);
        pof2 = new File(psFicheroAuxiliar); 
        pofw = new FileWriter(pof2);
                               
        int     wiOrdenDelCampoActual   = piOrdenDelUltimoCampo;
        String  wsBuffer                = "";
        String  wsRegistro              = "";
        String  wsClave                 = "";
        String  wsValor                 = "";
        int     wiClave;
        int     wiClaveABuscar          = Integer.parseInt(isClave);
        boolean wbTerminar= false;
        
        while (!wbTerminar){
            int wi;
            if ((wi=pofr.read()) == -1) 
                wbTerminar= true;           //Si es EOF terminar
            else{
                char wc = (char) wi;
                if (wc != ';'){          
                    wsBuffer += wc;         //Si es un carácter normal lo guardamos en el buffer
                }else{                      //Si es un fin de campo, tratamos el campo entero                                              
                    wiOrdenDelCampoActual= (wiOrdenDelCampoActual == piOrdenDelUltimoCampo)? 1 : wiOrdenDelCampoActual+1;
                    switch (wiOrdenDelCampoActual){ //guardamos el buffer en el campo que le corresponde
                        case 1: {   wsClave = wsBuffer; break;}
                        case 2: {   wsValor = wsBuffer; break;}  
                    }//switch
                    wsRegistro += wsBuffer+";";
                    wsBuffer= "";

                    if (wiOrdenDelCampoActual == piOrdenDelUltimoCampo){ //Si ya tenemos el REGISTRO entero 
                        wiClave = Integer.parseInt(wsClave);

                        if (wiClave < wiClaveABuscar)
                            pofw.write(wsRegistro); 
                        else{                                            
                            pofw.write(isClave+";"+isValor+";"); 
                            pofw.write(wsRegistro); 
                            mvCopiarRestoDelFichero(pofr, pofw);
                            $.$$(">> El Registro <"+wsClave+"> se ha AÑADIDO en su SITIO.");
                            wbTerminar= true;
                        }
                        wsRegistro= "";
                    }                       
                }  
            }
        }//while            
          
        pofr.close(); 
        pofw.close(); 
        pof1.delete();
        pof2.renameTo(pof1);
        pof2 = null;               
        pof1= null;                       
    }//mvAlta
    
    static void     mvTratarFichero(String isOpcion, String isClave, String isValor) throws IOException, FileNotFoundException {
        pof1 = new File(psFicheroPrincipal);        
        pofr = new FileReader(pof1);
        if ( "fabm".contains(isOpcion) ){
            pof2 = new File(psFicheroAuxiliar); 
            pofw = new FileWriter(pof2);
        }                          
        int     wiOrdenDelCampoActual   = piOrdenDelUltimoCampo;
        String  wsBuffer                = "";
        String  wsRegistro              = "";
        String  wsClave                 = "";
        String  wsValor                 = "";
        int     wiClave;
        int     wiClaveABuscar          = Integer.parseInt(isClave);

        if (isOpcion.equals("l")) $.$$(">> PRINCIPIO del listado.");
        boolean wbEncontrado = false;
        
        boolean wbTerminar= false;
        while (!wbTerminar){
            int wi;
            if ((wi=pofr.read()) == -1) 
                wbTerminar= true;           //Si es EOF terminar
            else{
                char wc = (char) wi;
                if (wc != ';'){          
                    wsBuffer += wc;         //Si es un carácter normal lo guardamos en el buffer
                }else{                      //Si es un fin de campo, tratamos el campo entero                                              
                    wiOrdenDelCampoActual= (wiOrdenDelCampoActual == piOrdenDelUltimoCampo)? 1 : wiOrdenDelCampoActual+1;
                    switch (wiOrdenDelCampoActual){ //guardamos el buffer en el campo que le corresponde
                        case 1: {   wsClave = wsBuffer; break;}
                        case 2: {   wsValor = wsBuffer; break;}  
                    }//switch
                    wsRegistro += wsBuffer+";";
                    wsBuffer= "";

                    if (wiOrdenDelCampoActual == piOrdenDelUltimoCampo){ //Si ya tenemos el REGISTRO entero 
                        wiClave = Integer.parseInt(wsClave);
                        char icOpcion= isOpcion.charAt(0);
                        switch (icOpcion){
                            case 'l': {$.$$(wsRegistro); 
                                break;}
                            case 'c': {
                                if (wiClave == wiClaveABuscar){
                                    $.$$(">> El valor asociado a la clave <"+wsClave+"> es: <"+wsValor+">");
                                    wbEncontrado= true;
                                    wbTerminar= true;                                    
                                }  
                                break;}
                            case 'b': {
                                if (wiClave == wiClaveABuscar){
                                    $.$$(">> El Registro <"+wsClave+"> se ha ELIMINADO.");
                                    wbEncontrado= true;
                                    mvCopiarRestoDelFichero(pofr, pofw);
                                }else
                                    pofw.write(wsRegistro);                                
                                break;}
                            case 'm': {
                                if (wiClave == wiClaveABuscar){
                                    pofw.write(wsClave+";"+isValor+";"); 
                                    $.$$(">> El Registro <"+wsClave+"> se ha MODIFICADO.");
                                    wbEncontrado= true;
                                    mvCopiarRestoDelFichero(pofr, pofw);
                                }else
                                    pofw.write(wsRegistro);                                
                                break;}
                            case 'a': {
                                if (wiClave < wiClaveABuscar)
                                    pofw.write(wsRegistro); 
                                else{                                            
                                    pofw.write(isClave+";"+isValor+";"); 
                                    pofw.write(wsRegistro); 
                                    mvCopiarRestoDelFichero(pofr, pofw);
                                    $.$$(">> El Registro <"+wsClave+"> se ha AÑADIDO en su SITIO.");
                                    wbTerminar= true;
                                }                                
                                break;}                                
                            case 'f': {
                                pofw.write(wsRegistro); 
                                mvCopiarRestoDelFichero(pofr, pofw);
                                pofw.write(isClave+";"+isValor+";"); 
                                $.$$(">> El Registro <"+isClave+"> se ha AÑADIDO al FINAL.");
                                wbTerminar= true;                              
                                break;}                             
                        }//switch
                        wsRegistro= "";
                    }                       
                }  
            }
        }//while            
          
        pofr.close(); 
        if ( "fabm".contains(isOpcion) ){ 
            pofw.close(); 
            pof1.delete();
            pof2.renameTo(pof1);
            pof2 = null;
        }       
        pof1= null;
        
        if ("l".equals(isOpcion)) $.$$(">> FINAL del listado.");
        if ("bmc".contains(isOpcion)) 
           if (!wbEncontrado) 
                $.$$(">> NO se ha ENCONTRADO el registro "+isClave);
        
        
    }//mvTratarFichero    
    static void     mvCopiarRestoDelFichero (FileReader iofr, FileWriter xofw) throws IOException, FileNotFoundException {
        int wi;
        int wiFinDeCampo=piOrdenDelUltimoCampo;
        String wsRegistro= "";
        
        while ( (wi=iofr.read()) != -1 ) {
            char wc = (char) wi;
            wsRegistro += wc;
            if (wc == ';'){
                wiFinDeCampo= (wiFinDeCampo == piOrdenDelUltimoCampo)? 1 : wiFinDeCampo+1;
                if (wiFinDeCampo == piOrdenDelUltimoCampo) {
                    xofw.write(wsRegistro); 
                    wsRegistro="";
                }
            }
        }//while    
    }//mvCopiarRestoDelFichero()
}//CMainFicheroTexto