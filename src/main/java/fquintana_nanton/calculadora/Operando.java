package fquintana_nanton.calculadora;

/**
 * Esta clase es el objeto Operando
 *
 * @author fquintana
 * @author nanton
 * @version 1.1
 */
public class Operando {

    private String name;

    /**
     * Constructor del {@link Operando}
     * @param name Una string como nombre del {@link Operando}
     */
    public Operando(String name) {
        this.name = name;
    }

    /**
     * Devuelve el nombre del {@link Operando}
     * @return String nombre del {@link Operando}
     */
    public String getName() {
        return name;
    }

    /**
     * Ajusta el nombre del {@link Operando}
     * @param name Una string como nombre del {@link Operando}
     */
    public void setName(String name) {
        this.name = name;
    }
}
