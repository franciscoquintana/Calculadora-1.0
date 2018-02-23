package fquintana_nanton.calculadora;

import java.util.Scanner;

/**
 * Write a description of class Calculadora here.
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
        // initialise instance variables
        num1 = 0;
        num2 = 0;
        op=op.SUMA;
        
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        calc.opera();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce el primer número:");
        
        calc.ponNum1(sc.nextDouble());
        
        System.out.println("Introduce el segundo número:");
        calc.ponNum2(sc.nextDouble());
        

        
        double resultado = calc.dameResultado();
        System.out.println("Resultado: " + resultado);
    }
    
    public void ponNum1(double n1)
    {
        // put your code here
        this.num1=n1;
    }
    
    public void ponNum2(double n2)
    {
        // put your code here
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
    public void ponOperacion(String opera){
        switch(opera){
        
        case "SUMA":
            op=op.SUMA;
            break;
        case "RESTA":
            op=op.RESTA;
            break;
        case "MULTIPLICA":
            op=op.MULTIPLICA;
            break;
        case "DIVIDE":
            op=op.DIVIDE;
            break;
        }
    }
    public double dameResultado()
    {
        // put your code here
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
