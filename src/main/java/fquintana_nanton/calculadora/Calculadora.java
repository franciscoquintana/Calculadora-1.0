package fquintana_nanton.calculadora;

import java.util.Scanner;

/**
 * Esta clase contiene los metodos para poder realizar operaciones
 * 
 * @author fquintana
 * @author nanton
 * @version 1.0
 */

public class Calculadora
{
    private double num1;
    private double num2;
    private double rdo;
    private Operacion op;

    /**
     * Metodo principal de la aplicacion
     * @param args No es usado actualmente
     */
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        
        Scanner sc = new Scanner(System.in);

        boolean leer;

        do {
            leer = false;
            System.out.println("Introduce el tipo de operación:");
            try {
                calc.ponOperacion(sc.next());
            } catch (IllegalArgumentException ex) {
                System.out.println("Ese tipo no existe.");
                leer = true;
            }

        } while (leer);
        
        System.out.println("Introduce el primer número:");
        calc.ponNum1(sc.nextDouble());
        
        System.out.println("Introduce el segundo número:");
        calc.ponNum2(sc.nextDouble());

        calc.opera();

        double resultado = calc.dameResultado();
        System.out.println("Resultado: " + resultado);
    }

    /**
     * Ajusta el Primer operando de la Calculadora
     *
     * @param n1 un numero double
     *
     */
    public void ponNum1(double n1)
    {
        this.num1=n1;
    }

    /**
     * Ajusta el segundo operando de la Calculadora
     *
     * @param n2 un numero double
     *
     */
    public void ponNum2(double n2)
    {
        this.num2=n2;
    }

    /**
     * Realiza la operacion indicada en {@link #ponOperacion(String) ponOperacion}.
     * Con los operandos ajustados usando {@link #ponNum1(double) ponNum1} y {@link #ponNum2(double) ponNum2}.
     * Para ver el resultado usar {@link #dameResultado() dameResultado}.
     */
    public void opera()
    {
        switch(op){
            case SUMA:
                rdo=num1+num2;
                break;
            case RESTA:
                rdo=num1-num2;
                break;
            case MULTIPLICA:
                rdo=num1*num2;
                break;
            case DIVIDE:
                rdo=num1/num2;
                break;
        }
    }

    /**
     * Ajusta la operacion que va a realizar la calculadora al usar {@link #opera()}
     *
     * @param operacion una {@link String} que es el nombre de una operacion de {@link Operacion}.
     * @throws IllegalArgumentException Si la operacion indicada no existe en {@link Operacion}.
     * @see Operacion
     */
    public void ponOperacion(String operacion) throws IllegalArgumentException{
        op = Operacion.fromString(operacion);
    }

    /**
     * Devuelve el resultado de la operacion despues de haber usado {@link #opera()}
     *
     * @return Devuelve un {@link Double} como resultado.
     */
    public double dameResultado()
    {
        return rdo;
    }
}
