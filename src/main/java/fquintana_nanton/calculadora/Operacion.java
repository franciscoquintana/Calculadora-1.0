package fquintana_nanton.calculadora;

import java.util.ArrayList;
import java.util.List;

/**
 * Enumeration class Operacion
 * 
 * @author fquintana
 * @author nanton
 * @version 1.1
 */
public enum Operacion
{
    /**
     * Indica que se va a realizar una Suma
     */
    SUMA(new Operando("Sumando"), new Operando("Sumando")),
    /**
     * Indica que se va a realizar una Resta
     */
    RESTA(new Operando("Sustraendo"), new Operando("Minuendo")),
    /**
     * Indica que se va a realizar una Multiplicacion
     */
    MULTIPLICACION(new Operando("Multiplicando"), new Operando("Multiplicador")),
    /**
     * Indica que se va a realizar una Division
     */
    DIVISION(new Operando("Dividendo"), new Operando("Divisor")),
    /**
     * Indica que se va a realizar una Potencia
     */
    POTENCIA(new Operando("Base") , new Operando("Exponente")),
    /**
     * Indica que se va a realizar una Raiz
     */
    RAIZ(new Operando("Radical") , new Operando("Radicando")),
    /**
     * Indica que se va a realizar una Logaritmo
     */
    LOGARITMO(new Operando("Base") , new Operando("Argumento")),
    /**
     * Indica que se va a realizar una Factorial
     */
    FACTORIAL(new Operando("Numero")),
    /**
     * Indica el cierre del programa
     */
    EXIT();

    private List<Operando> Operandos;

    /**
     * Constructor de {@link Operacion}
     * @param operandos Una secuencia de {@link Operando operandos}
     */
    Operacion(Operando... operandos){
        ArrayList<Operando> lista = new ArrayList<>();
        for(Operando op: operandos) {
            lista.add(op);
        }
        Operandos = lista;
    }

    /**
     * Devuelve el numero de operandos de la {@link Operacion}
     * @return Un int como nombre del {@link Operando}
     */
    public int getNargs() {
        return Operandos.size();
    }

    /**
     * Devuelve un {@link Operando} de la {@link Operacion}
     * @param pos un int que indica la posición del operando empezando desde 0
     * @return un {@link Operando}
     */
    public Operando getOperando(int pos) {
        return Operandos.get(pos);
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

