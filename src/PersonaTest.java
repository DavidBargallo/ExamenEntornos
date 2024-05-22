import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonaTest {

    /*En este comprueba que el dni es válido, o sea, si tiene 8 dígitos.*/
    @Test
    public void testSetDni_ValidDni() {
        Persona persona = new Persona();
        assertTrue(persona.setDni("12345678"), "DNI válido no aceptado.");
    }

    /*En este test decimos que si tiene menos de 8 dígitos, no es válido por ese mismo motivo*/
    @Test
    public void testSetDni_InvalidDni_LessThan8Digits() {
        Persona persona = new Persona();
        assertFalse(persona.setDni("1234567"), "DNI con menos de 8 dígitos aceptado.");
    }

    /*En este test, decimos que si tiene más de 8 dígitos no es válido por ese motivo*/
    @Test
    public void testSetDni_InvalidDni_MoreThan8Digits() {
        Persona persona = new Persona();
        assertFalse(persona.setDni("123456789"), "DNI con más de 8 dígitos aceptado.");
    }

    /*Aquí le decimos que el DNI no es válido porque tiene carácteres no numéricos (asumimos que el DNI que piden aquí
     es solo números viendo como está escrito el código)*/
    @Test
    public void testSetDni_InvalidDni_NonNumeric() {
        Persona persona = new Persona();
        assertFalse(persona.setDni("1234abcd"), "DNI con caracteres no numéricos aceptado.");
    }

    /*El primer test que comprueba la edad, si la edad es 18 o más años, es válida.*/
    @Test
    public void testSetEdad_ValidAge() {
        Persona persona = new Persona();
        assertTrue(persona.setEdad(18), "Edad válida no aceptada.");
    }

    /*El otro test de edad, lo contrario, si la edad es menos de 18 años, no es válido.S*/
    @Test
    public void testSetEdad_InvalidAge() {
        Persona persona = new Persona();
        assertFalse(persona.setEdad(17), "Edad menor de 18 años aceptada.");
    }
}

