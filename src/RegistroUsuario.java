import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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

    public boolean setDni(String dni) {
        if (dni.matches("\\d{8}")) {
            this.dni = dni;
            return true;
        } else {
            System.out.println("DNI no válido. Debe tener 8 dígitos.");
            return false;
        }
    }

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


