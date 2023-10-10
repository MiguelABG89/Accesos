package code;

import com.google.gson.Gson;
import javaBeans.Alumnos;
import javaBeans.Institutos;
import lib.CheckFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class leerJson {
    public static void leerjson() {
        Path p = Path.of("src/main/resources/insti.json");
        //variables para almacenar el contenido del fichero
        Institutos instiJson;
        //leemos el contenido del Json q es un texto
        String txtJson;
        if (CheckFiles.ficheroLegible(p)) {
            //leemos el contenido del archivo del texto y se guarda en la string
            try {
                txtJson = Files.readString(p);
                //creo el gson q transforma de texto a objeto
                Gson gson = new Gson();
                instiJson = gson.fromJson(txtJson, Institutos.class);
                //para comprobar
                System.out.println(instiJson.getNombre());
                for (Alumnos a : instiJson.getAlumnos()) {
                    System.out.println(a.getNombre());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
