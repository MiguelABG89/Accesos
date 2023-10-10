public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        String opcion = "";
        do {
            System.out.println("0. Salir");
            System.out.println("1. Leer fichero XML con JAXB");
            System.out.println("2. Escribir fichero XML con JAXB y JSON");
            System.out.println("3. Leer fichero con Json");

            opcion = lib.Leer.pedirCadena("Introduce una opción");
            switch (opcion) {
                case "0" -> {
                    salir = true;
                }
                case "1" -> code.leerXMLconJAXB.leerXMLJAXB();
                case "2" -> code.escribirXMLconJAXB.escribirXML();
                case "3" -> code.leerJson.leerjson();
                default -> {
                    System.out.println("Opción incorrecta");
                }
            }
        } while (!salir);
    }
}
