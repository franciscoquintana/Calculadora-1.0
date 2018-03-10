package fquintana_nanton.calculadora;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests para la clase Operacion
 *
 * @author fquintana
 * @author nanton
 * @version 1.0
 */
public class CalculadoraTest {

    Double TOLERANCIA = 0.0001;

    Calculadora calculadora;

    /**
     * Crea una instancia de {@link Calculadora}
     *
     * @throws Exception
     */
    @org.junit.Before
    public void setUp() {
        calculadora = new Calculadora();
    }

    @org.junit.After
    public void tearDown() {
    }


    /**
     * Realiza una prueba para comprobar que la Calculadora realiza sumas
     * y no falla frente al desbordamiento al usar un numero superior de lo maximo permitido en el operando 1
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaSumaLSuperior1(){
        calculadora.ponOperacion("SUMA");
        calculadora.ponNum(0,Double.MAX_VALUE);
        calculadora.ponNum(1,5);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza sumas
     * y no falla frente al desbordamiento al usar un numero superior de lo maximo permitido en el operando 2
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaSumaLSuperior2(){
        calculadora.ponOperacion("SUMA");
        calculadora.ponNum(1,Double.MAX_VALUE);
        calculadora.ponNum(0,5);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza sumas
     * y no falla frente al usar un numero inferior de lo minimo permitido en el operando  1
     *
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaSumaLInferior1(){
        calculadora.ponOperacion("SUMA");
        calculadora.ponNum(0,-Double.MAX_VALUE);
        calculadora.ponNum(1,-1);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza sumas
     * y no falla frente al usar un numero inferior de lo minimo permitido en el operando  2
     *
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaSumaLInferior2(){
        calculadora.ponOperacion("SUMA");
        calculadora.ponNum(0,-1);
        calculadora.ponNum(1,-Double.MAX_VALUE);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza sumas correctamente
     *
     *
     */
    @Test
    public void pruebaSumaNormal() {
        calculadora.ponOperacion("SUMA");
        calculadora.ponNum(0,5.43);
        calculadora.ponNum(1,6.69);
        calculadora.opera();
        Assert.assertEquals(12.12 , calculadora.dameResultado(), TOLERANCIA);
    }


    /**
     * Realiza una prueba para comprobar que la Calculadora realiza restas
     * y no falla frente al usar un numero superior de lo maximo permitido en el operando 1
     *
     *
     */
    @Test
    public void pruebaRestaLSuperior1() {
        calculadora.ponOperacion("RESTA");
        calculadora.ponNum(0,Double.MAX_VALUE);
        calculadora.ponNum(1,5);
        calculadora.opera();
        Assert.assertEquals(Double.MAX_VALUE, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza restas
     * y no falla frente al usar un numero superior de lo maximo permitido en el operando 2
     *
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaRestaLSuperior2() {
        calculadora.ponOperacion("RESTA");
        calculadora.ponNum(0,5);
        calculadora.ponNum(1, -Double.MAX_VALUE);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza restas
     * y no falla frente al usar un numero inferior de lo minimo permitido en el operando 1
     *
     *
     */
    @Test
    public void pruebaRestaLInferior1() {
        calculadora.ponOperacion("RESTA");
        calculadora.ponNum(0,-Double.MAX_VALUE);
        calculadora.ponNum(1,5);
        calculadora.opera();
        Assert.assertEquals(-Double.MAX_VALUE, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza restas
     * y no falla frente al usar un numero inferior de lo minimo permitido en el operando 2
     *
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaRestaLInferior2() {
        calculadora.ponOperacion("RESTA");
        calculadora.ponNum(1,-Double.MAX_VALUE);
        calculadora.ponNum(0,5);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza restas correctamente
     *
     */
    @Test
    public void pruebaRestaNormal() {
        calculadora.ponOperacion("RESTA");
        calculadora.ponNum(0,1);
        calculadora.ponNum(1,2);
        calculadora.opera();
        Assert.assertEquals(-1, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza multiplicaciones
     * y no falla frente al desbordamiento al usar un numero inferior de lo minimo permitido en el operando 1
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaMultiplicacionLSuperior1() {
        calculadora.ponOperacion("MULTIPLICACION");
        calculadora.ponNum(0,Double.MAX_VALUE);
        calculadora.ponNum(1,2);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza multiplicaciones
     * y no falla frente al desbordamiento al usar un numero inferior en el limite de lo permitido en el operando 1
     *
     */
    @Test()
    public void pruebaMultiplicacionLSuperior11() {
        calculadora.ponOperacion("MULTIPLICACION");
        calculadora.ponNum(0,Double.MAX_VALUE);
        calculadora.ponNum(1,1);
        calculadora.opera();
        Assert.assertEquals(Double.MAX_VALUE, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza multiplicaciones
     * y no falla frente al desbordamiento al usar un numero inferior de lo minimo permitido en el operando 2
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaMultiplicacionLSuperior2() {
        calculadora.ponOperacion("MULTIPLICACION");
        calculadora.ponNum(1,Double.MAX_VALUE);
        calculadora.ponNum(0,2);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza multiplicaciones
     * y no falla frente al desbordamiento al usar un numero inferior en el limite de lo permitido en el operando 2
     *
     *
     */
    @Test()
    public void pruebaMultiplicacionLSuperior21() {
        calculadora.ponOperacion("MULTIPLICACION");
        calculadora.ponNum(1,Double.MAX_VALUE);
        calculadora.ponNum(0,1);
        calculadora.opera();
        Assert.assertEquals(Double.MAX_VALUE, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza multiplicaciones
     * y no falla frente al desbordamiento al usar un numero inferior de lo minimo permitido en el operando 2
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaMultiplicacionLInferior1() {
        calculadora.ponOperacion("MULTIPLICACION");
        calculadora.ponNum(0,-2);
        calculadora.ponNum(1,Double.MAX_VALUE);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza multiplicaciones
     * y no falla frente al desbordamiento al usar un numero inferior en el limite de lo permitido en el operando 2
     *
     */
    @Test
    public void pruebaMultiplicacionLInferior11() {
        calculadora.ponOperacion("MULTIPLICACION");
        calculadora.ponNum(0,-1);
        calculadora.ponNum(1,Double.MAX_VALUE);
        calculadora.opera();
        Assert.assertEquals(-Double.MAX_VALUE, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza multiplicaciones
     * y no falla frente al desbordamiento al usar un numero inferior de lo minimo permitido en el operando 1
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaMultiplicacionLInferior2() {
        calculadora.ponOperacion("MULTIPLICACION");
        calculadora.ponNum(1,-2);
        calculadora.ponNum(0,Double.MAX_VALUE);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza multiplicaciones
     * y no falla frente al desbordamiento al usar un numero inferior en el limite de lo permitido en el operando 1
     *
     */
    @Test
    public void pruebaMultiplicacionLInferior21() {
        calculadora.ponOperacion("MULTIPLICACION");
        calculadora.ponNum(1,-1);
        calculadora.ponNum(0,Double.MAX_VALUE);
        calculadora.opera();
        Assert.assertEquals(-Double.MAX_VALUE, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza multiplicaciones correctamente
     *
     *
     */
    @Test
    public void pruebaMultiplicacion() {
        calculadora.ponOperacion("MULTIPLICACION");
        calculadora.ponNum(0,1);
        calculadora.ponNum(1,Double.MAX_VALUE);
        calculadora.opera();
        Assert.assertEquals(Double.MAX_VALUE, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza multiplicaciones con el numero 0
     *
     *
     */
    @Test
    public void pruebaMultiplicacionCero() {
        calculadora.ponOperacion("MULTIPLICACION");
        calculadora.ponNum(0,0);
        calculadora.ponNum(1,2);
        calculadora.opera();
        Assert.assertEquals(0, calculadora.dameResultado(), TOLERANCIA);
    }



    /**
     * Realiza una prueba para comprobar que la Calculadora realiza divisiones
     * y no falla frente al desbordamiento al usar un numero superior de lo maximo permitido en el operando 1
     *
     */
    @Test( expected = IllegalArgumentException.class)
    public void pruebaDivisionLSuperior() {
        calculadora.ponOperacion("DIVISION");
        calculadora.ponNum(0, Double.MAX_VALUE);
        calculadora.ponNum(1,2);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza divisiones
     * y no falla frente al desbordamiento al usar un numero inferior de lo minimo permitido en el operando 1
     *
     */
    @Test( expected = IllegalArgumentException.class)
    public void pruebaDivisionLInferior() {
        calculadora.ponOperacion("DIVISION");
        calculadora.ponNum(0, Double.MAX_VALUE);
        calculadora.ponNum(1,5);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza divisiones correctamente
     *
     *
     */
    @Test
    public void pruebaDivision() {
        calculadora.ponOperacion("DIVISION");
        calculadora.ponNum(0,1);
        calculadora.ponNum(1,2);
        calculadora.opera();
        Assert.assertEquals(0.5, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza divisiones
     * y no falla al dividir el numero 0 entre otros numeros
     *
     */
    @Test
    public void pruebaDivisionNum1Zero() {
        calculadora.ponOperacion("DIVISION");
        calculadora.ponNum(0,0);
        calculadora.ponNum(1,5);
        calculadora.opera();
        Assert.assertEquals(0, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza divisiones
     * y no falla al dividir numeros entre el numero 0
     *
     */
    @Test( expected = IllegalArgumentException.class)
    public void pruebaDivisionNum2Zero() {
        calculadora.ponOperacion("DIVISION");
        calculadora.ponNum(0,5);
        calculadora.ponNum(1,0);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza potencias
     * y no falla frente al desbordamiento al usar un numero superior de lo maximo permitido en el operando 1
     *
     *
     */
    @Test( expected = IllegalArgumentException.class)
    public void pruebaPotenciaLSuperior() {
        calculadora.ponOperacion("POTENCIA");
        calculadora.ponNum(0,Double.MAX_VALUE);
        calculadora.ponNum(1,3);
        calculadora.opera();
        Assert.assertEquals(Double.MAX_VALUE, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza potencias
     * y no falla frente al desbordamiento al usar un numero inferior de lo minimo permitido en el operando 1
     *
     *
     */
    @Test( expected = IllegalArgumentException.class)
    public void pruebaPotenciaLInferior() {
        calculadora.ponOperacion("POTENCIA");
        calculadora.ponNum(1, 5);
        calculadora.ponNum(0,-Double.MAX_VALUE);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza potencias correctamente
     *
     *
     */
    @Test
    public void pruebaPotencia() {
        calculadora.ponOperacion("POTENCIA");
        calculadora.ponNum(0,2);
        calculadora.ponNum(1,3);
        calculadora.opera();
        Assert.assertEquals(8, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza potencias correctamente con numeros negativos
     *
     *
     */
    @Test
    public void pruebaPotenciaNegativo() {
        calculadora.ponOperacion("POTENCIA");
        calculadora.ponNum(0,3);
        calculadora.ponNum(1,-1);
        calculadora.opera();
        Assert.assertEquals(1d/3d, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza raices correctamente
     * y no falla frente al desbordamiento al usar un numero superior de lo maximo permitido en el operando 1
     *
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaRaizLSuperior() {
        calculadora.ponOperacion("RAIZ");
        calculadora.ponNum(0,Double.MAX_VALUE);
        calculadora.ponNum(1,2);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza raices correctamente
     * y no falla frente al desbordamiento al usar un numero inferior de lo minimo permitido en el operando 1
     *
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaRaizLInferior() {
        calculadora.ponOperacion("RAIZ");
        calculadora.ponNum(0,-Double.MAX_VALUE);
        calculadora.ponNum(1,16);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza raices correctamente
     *
     *
     */
    @Test
    public void pruebaRaiz() {
        calculadora.ponOperacion("RAIZ");
        calculadora.ponNum(0,16);
        calculadora.ponNum(1,2);
        calculadora.opera();
        Assert.assertEquals(4, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza logaritmos correctamente
     * y no falla frente al desbordamiento al usar un numero superior de lo maximo permitido en el operando 1
     *
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaLogaritmoLSuperior() {
        calculadora.ponOperacion("LOGARITMO");
        calculadora.ponNum(0,Double.MAX_VALUE);
        calculadora.ponNum(1,1);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza logaritmos correctamente
     * y no falla frente al desbordamiento al usar un numero inferior de lo minimo permitido
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaLogaritmoInferior() {
        calculadora.ponOperacion("LOGARITMO");
        calculadora.ponNum(0, 0);
        calculadora.ponNum(1,1);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza logaritmos correctamente
     *
     *
     */
    @Test
    public void pruebaLogaritmo() {
        calculadora.ponOperacion("LOGARITMO");
        calculadora.ponNum(0,32);
        calculadora.ponNum(1,2);
        calculadora.opera();
        Assert.assertEquals(5, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza logaritmos correctamente
     * y no falla frente al desbordamiento al usar un numero negativo en el operando 2
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaLogaritmoNegativoArgumento() {
        calculadora.ponOperacion("LOGARITMO");
        calculadora.ponNum(0,32);
        calculadora.ponNum(1,-2);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza logaritmos correctamente
     * y no falla frente al desbordamiento al usar un numero negativo en el operando 1
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaLogaritmoNegativoBase() {
        calculadora.ponOperacion("LOGARITMO");
        calculadora.ponNum(0,-32);
        calculadora.ponNum(1,2);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza factoriales correctamente
     * y no falla frente al desbordamiento al usar un numero superior de lo maximo permitido en el operando 1
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaFactorialLSuperior() {
        calculadora.ponOperacion("FACTORIAL");
        calculadora.ponNum(0,Double.MAX_VALUE);
        calculadora.opera();
        Assert.assertEquals(1, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza factoriales correctamente
     * y no falla frente al desbordamiento al usar un numero inferior de lo minimo permitido en el operando 1
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaFactorialLInferior() {
        calculadora.ponOperacion("FACTORIAL");
        calculadora.ponNum(0,-Double.MAX_VALUE);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza factoriales correctamente
     *
     *
     */
    @Test
    public void pruebaFactorial() {
        calculadora.ponOperacion("FACTORIAL");
        calculadora.ponNum(0,1);
        calculadora.opera();
        Assert.assertEquals(1, calculadora.dameResultado(), TOLERANCIA);
    }

}
