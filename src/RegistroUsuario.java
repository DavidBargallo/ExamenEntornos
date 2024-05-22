//Importo todos los util que voy a utilizar en esta clase.//
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

//Añado los atributos de la clase persona.//
class Persona {
    private String dni;
    private String correo;
    private String contrasena;
    private String nombre;
    private String apellidos;
    private String direccionPostal;
    private String codigoPostal;
    private String telefono;
    private int edad;

    /*En el set DNI, hago que tenga que ser de 8 dígitos usando el .matches. Si el DNI introducido tiene 8 dígitos,
     el DNI se guarda, mientras que si no tiene 8 dígitos (tiene menos o más de 8) entonces salta un mensaje de error.*/
    public boolean setDni(String dni) {
        if (dni.matches("\\d{8}")) {
            this.dni = dni;
            return true;
        } else {
            System.out.println("DNI no válido. Debe tener 8 dígitos.");
            return false;
        }
    }
/*En el set del correo creo una plantilla que dice que el correo puede tener texto logos etc, pero que debe tener un @ y un . para seguir la plantilla
 que usa un correo (correo33@correo.com) si cumple con las restricciones, se guarda. Le aplico dicha plantilla al correo que el
 usuario me ingrese y le digo que si coincide, se guarda el correo, mientras que si no coincide salta el mensaje de error.*/
    public boolean setCorreo(String correo) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        if (matcher.matches()) {
            this.correo = correo;
            return true;
        } else {
            System.out.println("Correo electrónico no válido.");
            return false;
        }
    }

    /*Le digo que si la contraseña introducida por el usuario tiene una longitud mayor de 8 carácteres, es válida y por
     tanto se guarda la contraseña. Si no es válida, no la guarda y salta el mensaje.*/
    public boolean setContrasena(String contrasena) {
        if (contrasena.length() > 8) {
            this.contrasena = contrasena;
            return true;
        } else {
            System.out.println("Contraseña no válida. Debe tener más de 8 caracteres.");
            return false;
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDireccionPostal(String direccionPostal) {
        this.direccionPostal = direccionPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /*En el de edad, le decimos que si la edad es 18 o mayor a 18, guardamos la edad pues es mayor de edad.
     Si por el contrario, la edad es menos de 18, salta el mensaje de que debe ser mayor de 18 años.*/
    public boolean setEdad(int edad) {
        if (edad >= 18) {
            this.edad = edad;
            return true;
        } else {
            System.out.println("Debes ser mayor de 18 años.");
            return false;
        }
    }

    @Override
    /*El texto que le pondrás al usuario para que vea sus datos.*/
    public String toString() {
        return "DNI: " + dni + "\n" +
               "Correo: " + correo + "\n" +
               "Nombre: " + nombre + "\n" +
               "Apellidos: " + apellidos + "\n" +
               "Dirección Postal: " + direccionPostal + "\n" +
               "Código Postal: " + codigoPostal + "\n" +
               "Teléfono: " + telefono + "\n" +
               "Edad: " + edad;
    }
}
public class RegistroUsuario {
    /*Aquí le voy pidiendo los diferentes datos al usuario. En los métodos que tengo para comprobar que me ingrese los datos
     de una forma específica, como la edad, la contraseña o el correo, le digo que mientras el método no de un return true,
     siga pidiendo los datos, y si hace return true (que cumple los requisitos) entonces se guarda.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Persona persona = new Persona();

        System.out.print("Ingrese el DNI: ");
        while (!persona.setDni(scanner.nextLine()));

        System.out.print("Ingrese el correo electrónico: ");
        while (!persona.setCorreo(scanner.nextLine()));

        System.out.print("Ingrese la contraseña: ");
        while (!persona.setContrasena(scanner.nextLine()));

        System.out.print("Ingrese el nombre: ");
        persona.setNombre(scanner.nextLine());

        System.out.print("Ingrese los apellidos: ");
        persona.setApellidos(scanner.nextLine());

        System.out.print("Ingrese la dirección postal: ");
        persona.setDireccionPostal(scanner.nextLine());

        System.out.print("Ingrese el código postal: ");
        persona.setCodigoPostal(scanner.nextLine());

        System.out.print("Ingrese el teléfono: ");
        persona.setTelefono(scanner.nextLine());

        System.out.print("Ingrese la edad: ");
        while (!persona.setEdad(scanner.nextInt()));

        System.out.println("Registro exitoso!");
        System.out.println("Detalles del usuario:");
        System.out.println(persona);
    }
}


