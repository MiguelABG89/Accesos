package code;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import javaBeans.Alumnos;
import javaBeans.Institutos;
import lib.CheckFiles;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class escribirXMLconJAXB {
    public static void escribirXML() {
        Path p = Path.of("target/insti.xml");
        //creamos los objetos a escribiren el XML
        ArrayList<Alumnos> listaAlumnos = new ArrayList<Alumnos>();
        Institutos insti = new Institutos();
        Alumnos a1 = new Alumnos("SMR1", "Lola", 16);
        listaAlumnos.add(a1);
        Alumnos a2 = new Alumnos("DAM1", "Juan", 20);
        listaAlumnos.add(a2);
        Alumnos a3 = new Alumnos("DAM2", "Sofía",21 );
        listaAlumnos.add(a3);
        insti.setNombre("IES San Alberto Magno");
        insti.setAlumnos(listaAlumnos);
        Path pj = Path.of("targer/instiGson.json");

        if (CheckFiles.ficheroEscribible(p)){
            try {
                //definicion del contexto
                //un contexto se utiliza cuando en nuestro código hemos cargado algo persistente
                JAXBContext contexto = JAXBContext.newInstance(Institutos.class, Alumnos.class);
                //Creamos el marshaller ya que pasamos del codigo a XML
                Marshaller marshaller = contexto.createMarshaller();
                //damos formato a la salida
                marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT,true);
                //escribios el objeto en formato xml
                marshaller.marshal(insti,p.toFile());
                //con la api Gson creo mi Json
                GsonBuilder gsonBuilder = new GsonBuilder();
                //Le damos el formato con setPrettyPrinting
                Gson gson = gsonBuilder.setPrettyPrinting().create();
                //creamos el texto del json
                String jsonInsti = gson.toJson(insti);
                if (CheckFiles.ficheroEscribible(p)){
                   try {
                       Files.writeString(pj,jsonInsti);
                   }catch (IOException e){
                       System.out.println("el fichero no se ha podido crear");
                   }
                }else {
                    System.out.println("El fichero no es escribible");
                }
            }catch (JAXBException e){
                System.out.println("No se encuentra ese contexto");
            }
        }else {
            System.out.println("la ruta del fichero no es escribible");
        }
    }

}
