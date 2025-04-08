package utils;

import model.Cofradia;
import utils.XmlManager;
import utils.JsonManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio para gestionar la lectura, guardado y recuperación de cofradías.
 */
public class CofradiaService {

    private List<Cofradia> cofradias = new ArrayList<>();

    /**
     * Lee un fichero de texto y genera una lista de objetos Cofradia.
     *
     * @param ruta Ruta del fichero de texto.
     */
    public void cargarDesdeArchivoTexto(String ruta) {
        cofradias.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Cofradia cofradia = parsearLinea(linea);
                if (cofradia != null) {
                    cofradias.add(cofradia);
                }
            }
            System.out.println("✅ Archivo cargado correctamente.");
        } catch (FileNotFoundException e) {
            System.err.println("❌ Error: El fichero no existe -> " + ruta);
        } catch (IOException e) {
            System.err.println("❌ Error al leer el fichero: " + e.getMessage());
        }
    }

    /**
     * Convierte una línea de texto en un objeto Cofradia.
     *
     * @param linea Línea del fichero con datos de la cofradía.
     * @return Un objeto Cofradia o null si hay un error.
     */
    private Cofradia parsearLinea(String linea) {
        try {
            String[] partes = linea.split(";");
            String nombre = partes[0].split(":")[1].trim();
            int anioFundacion = Integer.parseInt(partes[1].split(":")[1].trim());
            int numeroHermanos = Integer.parseInt(partes[2].split(":")[1].trim());
            String ciudad = partes[3].split(":")[1].trim();

            return new Cofradia(nombre, anioFundacion, numeroHermanos, ciudad);
        } catch (Exception e) {
            System.err.println("⚠️ Error al procesar la línea: " + linea);
            return null;
        }
    }

    /**
     * Guarda la lista de cofradías en un archivo XML.
     */
    public void guardarEnXML() {
        if (cofradias.isEmpty()) {
            System.out.println("⚠️ No hay datos para guardar en XML.");
            return;
        }
        XmlManager.guardarEnXML(cofradias);
        System.out.println("✅ Datos guardados en XML correctamente.");
    }

    /**
     * Guarda la lista de cofradías en un archivo JSON.
     */
    public void guardarEnJSON() {
        if (cofradias.isEmpty()) {
            System.out.println("⚠️ No hay datos para guardar en JSON.");
            return;
        }
        JsonManager.guardarEnJSON(cofradias);
        System.out.println("✅ Datos guardados en JSON correctamente.");
    }

    /**
     * Lee las cofradías desde un archivo XML y las muestra por pantalla.
     */
    public void leerDesdeXML() {
        cofradias = XmlManager.leerDesdeXML();
        if (!cofradias.isEmpty()) {
            System.out.println("✅ Datos cargados desde XML:");
            mostrarCofradias();
        } else {
            System.out.println("⚠️ No se encontraron datos en XML.");
        }
    }

    /**
     * Lee las cofradías desde un archivo JSON y las muestra por pantalla.
     */
    public void leerDesdeJSON() {
        cofradias = JsonManager.leerDesdeJSON();
        if (!cofradias.isEmpty()) {
            System.out.println("✅ Datos cargados desde JSON:");
            mostrarCofradias();
        } else {
            System.out.println("⚠️ No se encontraron datos en JSON.");
        }
    }

    /**
     * Muestra la lista de cofradías por pantalla.
     */
    public void mostrarCofradias() {
        if (cofradias.isEmpty()) {
            System.out.println("⚠️ No hay datos para mostrar.");
        } else {
            System.out.println("📜 Listado de Cofradías:");
            cofradias.forEach(System.out::println);
        }
    }
}



