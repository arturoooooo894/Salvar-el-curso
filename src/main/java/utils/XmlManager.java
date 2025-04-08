package utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import model.Cofradia;
import model.CofradiaWrapper;

import java.io.File;
import java.util.List;

public class XmlManager {

    private static final String RUTA_XML = "D:\\2DAM\\RECUPERACIONES\\ACCESODATOS\\FICHEROS\\Pract1Ficheros\\datos\\cofradias.xml";


    /**
     * Guarda la lista de cofradías en un archivo XML.
     */
    public static void guardarEnXML(List<Cofradia> cofradias) {
        try {
            // 1. Crear el directorio "datos" si no existe
            File directorio = new File("datos");
            if (!directorio.exists()) {
                directorio.mkdir();
            }

            // 2. Inicializar JAXB y configurar la salida
            JAXBContext contexto = JAXBContext.newInstance(CofradiaWrapper.class);
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // 3. Envolver las cofradías en el wrapper y guardarlas en XML
            CofradiaWrapper wrapper = new CofradiaWrapper();
            wrapper.setCofradias(cofradias);
            marshaller.marshal(wrapper, new File(RUTA_XML));

            System.out.println("✅ Datos guardados correctamente en 'datos/cofradias.xml'");
        } catch (JAXBException e) {
            System.err.println("❌ Error al guardar en XML: " + e.getMessage());
        }
    }

    /**
     * Lee los datos de cofradías desde un archivo XML.
     */
    public static List<Cofradia> leerDesdeXML() {
        try {
            File archivoXML = new File(RUTA_XML);
            if (!archivoXML.exists()) {
                System.out.println("⚠️ No se encontró el archivo XML.");
                return null;
            }

            // 1. Inicializar JAXB para leer el XML
            JAXBContext contexto = JAXBContext.newInstance(CofradiaWrapper.class);
            Unmarshaller unmarshaller = contexto.createUnmarshaller();

            // 2. Leer el archivo y convertirlo en objetos Java
            CofradiaWrapper wrapper = (CofradiaWrapper) unmarshaller.unmarshal(archivoXML);
            return wrapper.getCofradias();
        } catch (JAXBException e) {
            System.err.println("❌ Error al leer desde XML: " + e.getMessage());
            return null;
        }
    }
}
