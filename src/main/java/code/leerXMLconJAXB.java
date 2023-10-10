package code;

import jakarta.xml.bind.Marshaller;
import javaBeans.Alumnos;
import javaBeans.Institutos;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lib.CheckFiles;

import java.nio.file.Path;
import java.util.ArrayList;

public class leerXMLconJAXB {
    public static void leerXMLJAXB(){
        Path p = Path.of("src/main/resources/insti.xml");
        Institutos insti = new Institutos();
        if (CheckFiles.ficheroLegible(p)){
            try {
                //definicion del contexto
                //un contexto se utiliza cuando en nuestro código hemos cargado algo persistente
                JAXBContext contexto = JAXBContext.newInstance(Institutos.class, Alumnos.class);
                //Creamos el unmarchaller ya que pasamos del XML a Codigo
                Unmarshaller unmarshaller = contexto.createUnmarshaller();
                insti=(Institutos) unmarshaller.unmarshal(p.toFile());
                System.out.println(insti.getNombre());
                //para que se vea bien se necesita un ForEach
                for (Alumnos a: insti.getAlumnos()) {
                    System.out.println(a.getNombre());
                }

            }catch (JAXBException e){
                System.out.println("No se encuentra ese contexto");
            }
        }else {
            System.out.println("No se encuentra el fichero");
        }
    }

}
