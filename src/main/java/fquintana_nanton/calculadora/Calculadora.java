package fquintana_nanton.calculadora;

import java.util.Scanner;

/**
 * Calculadora proyecto Entornos de desarrollo.
 * 
 * @author fquintana nanton
 * @version 1.0
 */

public class Calculadora
{
    private double num1;
    private double num2;
    private double rdo;
    private Operacion op;

    /**
     * Constructor for objects of class Calculadora
     */
    public Calculadora()
    {
    }

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
    
    public void ponNum2(double n2)
    {
        this.num2=n2;
    }

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
    public void ponOperacion(String opera) throws IllegalArgumentException{
        op = Operacion.fromString(opera);
    }
    public double dameResultado()
    {
        return rdo;
    }
    
    public void muestraTodosResultados(){
        System.out.println("Num1="+Double.toString(num1)+" Num2=" + Double.toString(num2));
        System.out.println("Suma :" + Double.toString(num1+num2));
        System.out.println("Resta :"+ Double.toString(num1-num2));
        System.out.println("Multiplica :" + Double.toString(num1*num2));
        System.out.println("Divide :"+ Double.toString(num1/num2));
    }
}
