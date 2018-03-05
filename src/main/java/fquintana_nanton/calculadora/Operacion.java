package fquintana_nanton.calculadora;

/**
 * Enumeration class Operacion
 * 
 * @author fquintana
 * @author nanton
 * @version 1.1
 */
public enum Operacion
{
    SUMA(2),RESTA(2),MULTIPLICACION(2),DIVISION(2),POTENCIA(2),RAIZ(2),LOGARITMO(2),FACTORIAL(1);

    private int nargs;

    Operacion(int nargs){
        this.nargs = nargs;
    }

    public int getNargs() {
        return nargs;
    }

    public void setNargs(int nargs) {
        this.nargs = nargs;
    }

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

    /**
     * Devuelve una String que con tiene los tipos de Operacion separados por una coma.
     * @return Una String que contiene los tipos de Operaciones.
     */
    public static String getString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Operacion operacion : values()) {
            stringBuilder.append(operacion.name());
            stringBuilder.append(", ");
        }
        stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
        return stringBuilder.toString();
    }
}

