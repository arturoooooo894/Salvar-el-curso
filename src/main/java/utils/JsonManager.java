package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Cofradia;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonManager {

    private static final String RUTA_JSON = "D:\\2DAM\\RECUPERACIONES\\ACCESODATOS\\FICHEROS\\Pract1Ficheros\\datos\\cofradias.json";

    /**
     * Guarda la lista de cofradías en un archivo JSON.
     */
    public static void guardarEnJSON(List<Cofradia> cofradias) {
        try {
            // 1. Crear el directorio "datos" si no existe
            File directorio = new File("datos");
            if (!directorio.exists()) {
                directorio.mkdir();
            }

            // 2. Inicializar ObjectMapper y escribir el archivo JSON
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(RUTA_JSON), cofradias);

            System.out.println("✅ Datos guardados correctamente en 'datos/cofradias.json'");
        } catch (IOException e) {
            System.err.println("❌ Error al guardar en JSON: " + e.getMessage());
        }
    }

    /**
     * Lee los datos de cofradías desde un archivo JSON.
     */
    public static List<Cofradia> leerDesdeJSON() {
        try {
            File archivoJSON = new File(RUTA_JSON);
            if (!archivoJSON.exists()) {
                System.out.println("⚠️ No se encontró el archivo JSON.");
                return null;
            }

            // 1. Inicializar ObjectMapper para leer el JSON
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(archivoJSON, objectMapper.getTypeFactory().constructCollectionType(List.class, Cofradia.class));
        } catch (IOException e) {
            System.err.println("❌ Error al leer desde JSON: " + e.getMessage());
            return null;
        }
    }
}

