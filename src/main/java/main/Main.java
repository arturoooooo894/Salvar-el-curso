package main;

import utils.CofradiaService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CofradiaService servicio = new CofradiaService();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n📜 MENÚ PRINCIPAL 📜");
            System.out.println("1. Leer datos desde el fichero de texto");
            System.out.println("2. Guardar datos en XML");
            System.out.println("3. Guardar datos en JSON");
            System.out.println("4. Leer datos desde XML y mostrar");
            System.out.println("5. Leer datos desde JSON y mostrar");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    servicio.cargarDesdeArchivoTexto("D:\\2DAM\\RECUPERACIONES\\ACCESODATOS\\FICHEROS\\Pract1Ficheros\\src\\main\\resources\\cofradias.txt");
                    break;
                case 2:
                    servicio.guardarEnXML();
                    break;
                case 3:
                    servicio.guardarEnJSON();
                    break;
                case 4:
                    servicio.leerDesdeXML();
                    break;
                case 5:
                    servicio.leerDesdeJSON();
                    break;
                case 6:
                    System.out.println("👋 ¡Hasta luego!");
                    break;
                default:
                    System.out.println("⚠️ Opción no válida.");
            }
        } while (opcion != 6);
    }
}


