package fquintana_nanton.calculadora;

import java.util.Arrays;
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
    private Double nums[];
    private double rdo;

    public Operacion getOp() {
        return op;
    }

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

        for(int i=0; i< calc.getOp().getNargs(); i++)
            calc.ponNum(i,leeDouble(String.format("Introduce el operando %d:",i+1)));

        try {
            calc.opera();
            double resultado = calc.dameResultado();
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }


    }

    /**
     * Ajusta un operando a un valor
     *
     * @param narg el numero de argumento
     * @param value el valor del parametro
     *
     */
    public void ponNum(int narg, double value)
    {
        nums[narg] = value;
    }

    /**
     * Devuelve el valor de un operando
     *
     */
    public Double getNum(int narg)
    {
       return nums[narg];
    }


    /**
     * Realiza la operacion indicada en {@link #ponOperacion(String) ponOperacion}.
     * Con los operandos ajustados usando {@link #ponNum ponNum}.
     * Para ver el resultado usar {@link #dameResultado() dameResultado}.
     * @throws IllegalArgumentException Cuando alguno de los operandos no es valido
     */
    public void opera() throws Exception
    {
        switch(op){
            case SUMA:
                check();
                rdo=getNum(0) + getNum(1);
                break;
            case RESTA:
                check();
                rdo=getNum(0) - getNum(1);
                break;
            case MULTIPLICACION:
                check();
                rdo=getNum(0) * getNum(1);
                break;
            case DIVISION:
                if (getNum(1) == 0)
                    throw new IllegalArgumentException("El segundo operando no puede ser cero");
                rdo=getNum(0) / getNum(1);
                break;
            case POTENCIA:
                rdo=Math.pow(getNum(0),getNum(1));
                break;
            case RAIZ:
                rdo=Math.pow(getNum(0), 1/getNum(1));
                break;
            case LOGARITMO:
                rdo=(Math.log10(getNum(0)) / Math.log10(getNum(1)));
                break;
            case FACTORIAL:
                rdo=factorial(getNum(0));
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
        if (nums == null)
            nums = new Double[op.getNargs()];
        if (nums.length<op.getNargs())
            Arrays.copyOf(nums,op.getNargs());
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
        if(getNum(0) == Double.MAX_VALUE || getNum(1) == Double.MAX_VALUE || getNum(0) == -Double.MAX_VALUE || getNum(1) == -Double.MAX_VALUE)
            throw new IllegalArgumentException("Uno de los operando excede el máximo permitido");
    }

    public double factorial (double numero) {
        if (numero == 0)
            return 1;
        else
            return numero * factorial(numero-1);
    }

}
