package fquintana_nanton.calculadora;

/**
 * Enumeration class Operacion
 * 
 * @author fquintana
 * @author nanton
 * @version 1.0
 */
public enum Operacion
{
    SUMA,RESTA,MULTIPLICA,DIVIDE;

    /**
     * Devuelve una {@link Operacion} apartir de una {@link String}
     *
     * @param soperacion una {@link String} que es el nombre de una operacion de {@link Operacion}
     *                   independientemente de mayusculas y minusculas.
     * @throws IllegalArgumentException Si la operacion indicada no existe en {@link Operacion}.
     * @return Devuelve una instancia de {@link Operacion}
     */
    public static Operacion fromString(String soperacion) throws IllegalArgumentException {
        for (Operacion op: values())
            if (op.name().toLowerCase().equals(soperacion.toLowerCase()))
                return op;

        throw new IllegalArgumentException(soperacion + " no es una operación valida");

    }
}
