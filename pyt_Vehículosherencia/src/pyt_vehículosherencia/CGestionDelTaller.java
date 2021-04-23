package pyt_Vehículosherencia;
import java.util.ArrayList;
import java.util.Scanner;
public class CGestionDelTaller{

    static Scanner poTCD = new Scanner(System.in);
    static ArrayList<CVehiculo> plVehiculo = new ArrayList<CVehiculo>();

    public static void main(String[] args) {
        String wsTipoVehiculo, wsCarb;
        int wicc, wiejes;
        while (true) {
            System.out.println("Número de matrícula del vehículo(- para terminar): ");
            String wsMa = poTCD.nextLine();
            if (wsMa.equals("-")) {
                break;
            }
            System.out.println("¿Qué tipo de vehículo es? ¿Coche, Camion o Moto?");
            wsTipoVehiculo = poTCD.nextLine();
            System.out.println("Teléfono del cliente: ");
            int wiTelf = poTCD.nextInt();
            poTCD.nextLine();
            System.out.println("Fecha de entrada del vehículo (formato 2021/02/11)");
            String wsfech = poTCD.nextLine();
            if (wsTipoVehiculo.equals("Coche") || wsTipoVehiculo.equals("coche")) {
                System.out.println("¿Qué tipo de carburante usa? (diesel, gasolina, electrico) ");
                wsCarb = poTCD.nextLine();
                CCoches woCoches = new CCoches(wsMa, wiTelf, wsfech, wsCarb);
                plVehiculo.add(woCoches);
            }
            if (wsTipoVehiculo.equals("Moto") || wsTipoVehiculo.equals("moto")) {
                System.out.println("¿Cuántos cc tiene?");
                wicc = poTCD.nextInt();
                poTCD.nextLine();
                CMotos woMotos = new CMotos(wsMa, wiTelf, wsfech, wicc);
                plVehiculo.add(woMotos);
            }
            if (wsTipoVehiculo.equals("Camion") || wsTipoVehiculo.equals("camion")) {
                System.out.println("¿Cuántos ejes tiene?");
                wiejes = poTCD.nextInt();
                poTCD.nextLine();
                CCamiones woCamiones = new CCamiones(wsMa, wiTelf, wsfech, wiejes);
                plVehiculo.add(woCamiones);
            }
        }// while
        for (CVehiculo wo : plVehiculo) {
            if (wo instanceof CCoches) {
                System.out.println("Tipo de vehículo: Coche");
            }
            if (wo instanceof CMotos) {
                System.out.println("Tipo de vehículo: Moto");
            }
            if (wo instanceof CCamiones) {
                System.out.println("Tipo de vehículo: Camión");
            }
            System.out.println(wo.toString());
            System.out.println("Días de reparación: " + wo.miDiasPrevistos());
            System.out.print("----------------------------------------------------------------------------------------------");
            System.out.println();
        }
    }// main()
}// CGestionDelTaller

abstract class CVehiculo {

    String psmatricula;
    int pitelefono;
    String psfechaDeEntrada;

    CVehiculo(String ismatricula, int iitelefono, String isfechaDeEntrada) {
        psmatricula = ismatricula;
        pitelefono = iitelefono;
        psfechaDeEntrada = isfechaDeEntrada;
    }

    public CVehiculo() {
    }

    ;
        @Override
    public String toString() {
        String wsFecha = psfechaDeEntrada.substring(8, 10) + "/"
                + psfechaDeEntrada.substring(5, 7) + "/"
                + psfechaDeEntrada.substring(0, 4);
        return "Matrícula: " + psmatricula + ". Teléfono: " + pitelefono + ". Fecha de entrada: " + wsFecha;
    }

    public int miDiasPrevistos() {
        return (psfechaDeEntrada.compareTo("2021/02/11") > 0 ? 4 : 2);
    }
}// CVehiculo

class CCoches extends CVehiculo {

    String pscarburante;

    public CCoches(String ismatricula, int iitelefono, String isfechaDeEntrada, String iscarburante) {
        super(ismatricula, iitelefono, isfechaDeEntrada);
        pscarburante = iscarburante;
    }

    @Override
    public String toString() {
        return (super.toString() + ". Tipo de carburante: " + pscarburante);
    }

    @Override
    public int miDiasPrevistos() {
        return (pscarburante.equals("diesel")) ? (1 + super.miDiasPrevistos()) : (0 + super.miDiasPrevistos());
    }
}// CCoche

class CMotos extends CVehiculo {

    int pscc;

    public CMotos(String ismatricula, int iitelefono, String isfechaDeEntrada, int iicc) {
        super(ismatricula, iitelefono, isfechaDeEntrada);
        pscc = iicc;
    }

    @Override
    public String toString() {
        return (super.toString() + ". Potencia: " + pscc);
    }

    @Override
    public int miDiasPrevistos() {
        return super.miDiasPrevistos() + (pscc < 500 ? -1 : 0);
    }
}// CMotos

class CCamiones extends CVehiculo {

    int pinumejes;

    public CCamiones(String ismatricula, int iitelefono, String isfechaDeEntrada, int iinumejes) {
        super(ismatricula, iitelefono, isfechaDeEntrada);
        pinumejes = iinumejes;
    }

    @Override
    public String toString() {
        return (super.toString() + ". Ejes: " + pinumejes);
    }

    @Override
    public int miDiasPrevistos() {
        return super.miDiasPrevistos() + (pinumejes == 3 ? 7 : 0);
    }
}// CCamiones