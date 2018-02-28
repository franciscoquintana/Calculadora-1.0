package fquintana_nanton.calculadora;

/**
 * Enumeration class Operacion
 * 
 * @author fquintana nanton
 * @version 1.0
 */
public enum Operacion
{
    SUMA,RESTA,MULTIPLICA,DIVIDE;

    public static Operacion fromString(String soperacion) throws IllegalArgumentException {
        for (Operacion op: values())
            if (op.name().toLowerCase().equals(soperacion.toLowerCase()))
                return op;

        throw new IllegalArgumentException(soperacion + " no es una operación valida");

    }
}
