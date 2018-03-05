package fquintana_nanton.calculadora;

import java.util.Scanner;

/**
 * Esta clase contiene los metodos para poder realizar operaciones
 * 
 * @author fquintana
 * @author nanton
 * @version 1.1
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
            System.out.println("Tipos validos: " + Operacion.getString());
            System.out.println("Introduce el tipo de operación:");
            try {
                calc.ponOperacion(sc.nextLine());
            } catch (IllegalArgumentException ex) {
                System.out.println("Ese tipo no existe.");
                leer = true;
            }

        } while (leer);

        calc.ponNum1(leeDouble("Introduce el primer número:"));

        calc.ponNum2(leeDouble("Introduce el segundo número:"));

        try {
            calc.opera();
            double resultado = calc.dameResultado();
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }


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
     * @throws IllegalArgumentException Cuando alguno de los operandos no es valido
     */
    public void opera() throws Exception
    {
        switch(op){
            case SUMA:
                check();
                rdo=num1+num2;
                break;
            case RESTA:
                check();
                rdo=num1-num2;
                break;
            case MULTIPLICACION:
                check();
                rdo=num1*num2;
                break;
            case DIVISION:
                if (num2 == 0)
                    throw new IllegalArgumentException("El segundo operando no puede ser cero");
                rdo=num1/num2;
                break;
            case POTENCIA:
                rdo=Math.pow(num1,num2);
                break;
            case RAIZ:
                rdo=Math.pow(num1, 1/num2);
                break;
            case LOGARITMO:
                rdo=(Math.log10(num1) / Math.log10(num2));
                break;
            case FACTORIAL:
                rdo=factorial(num1);
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

    public static Double leeDouble(String str){
        Scanner scanner = new Scanner(System.in);
        Boolean read;
        Double number = null;
        do {
            read = false;
            try {
                System.out.println(str);
                number = scanner.nextDouble();
            } catch (Exception ex) {
                System.out.println("Introduce un numero valido");
                read = true;
                scanner.nextLine();
            }
        } while (read);
        return number;
    }

    public void check() throws IllegalArgumentException {
        if(num1 == Double.MAX_VALUE || num2 == Double.MAX_VALUE || num1 == -Double.MAX_VALUE || num2 == -Double.MAX_VALUE)
            throw new IllegalArgumentException("Uno de los operando excede el máximo permitido");
    }

    public double factorial (double numero) {
        if (numero == 0)
            return 1;
        else
            return numero * factorial(numero-1);
    }

}
