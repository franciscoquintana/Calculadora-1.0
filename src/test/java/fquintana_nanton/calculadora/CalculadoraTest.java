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
    public void setUp() throws Exception {
        calculadora = new Calculadora();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }


    /**
     * Realiza una prueba para comprobar que la Calculadora realiza sumas
     * y no falla frente al desbordamiento al usar numeros superiores de los permitidos
     *
     *
     */
    @Test
    public void pruebaSumaLSuperior() throws Exception{
        calculadora.ponNum1(Double.MAX_VALUE);
        calculadora.ponNum2(Double.MAX_VALUE);
        calculadora.ponOperacion("SUMA");
        calculadora.opera();
        Assert.assertEquals(Double.POSITIVE_INFINITY , calculadora.dameResultado(), TOLERANCIA);
    }


    /**
     * Realiza una prueba para comprobar que la Calculadora realiza sumas
     * y no falla frente al desbordamiento al usar numeros inferiores de los permitidos
     *
     *
     */
    @Test
    public void pruebaSumaLInferior() throws Exception{
        calculadora.ponNum1(-Double.MAX_VALUE);
        calculadora.ponNum2(-Double.MAX_VALUE);
        calculadora.ponOperacion("SUMA");
        calculadora.opera();
        Assert.assertEquals(Double.NEGATIVE_INFINITY , calculadora.dameResultado(), TOLERANCIA);
    }


    /**
     * Realiza una prueba para comprobar que la Calculadora realiza sumas
     *
     *
     */
    @Test
    public void pruebaSumaNormal() throws Exception {
        calculadora.ponNum1(5.43);
        calculadora.ponNum2(6.69);
        calculadora.ponOperacion("SUMA");
        calculadora.opera();
        Assert.assertEquals(12.12 , calculadora.dameResultado(), TOLERANCIA);
    }


    /**
     * Realiza una prueba para comprobar que la Calculadora realiza restas
     * y no falla frente al desbordamiento al usar numeros superiores de los permitidos
     *
     *
     */
    @Test
    public void pruebaRestaLSuperior() throws Exception {
        calculadora.ponNum1(Double.MAX_VALUE);
        calculadora.ponNum2(-Double.MAX_VALUE);
        calculadora.ponOperacion("RESTA");
        calculadora.opera();
        Assert.assertEquals(Double.POSITIVE_INFINITY, calculadora.dameResultado(), TOLERANCIA);
    }


    /**
     * Realiza una prueba para comprobar que la Calculadora realiza restas
     * y no falla frente al desbordamiento al usar numeros inferiores de los permitidos
     *
     *
     */
    @Test
    public void pruebaRestaLInferior() throws Exception {
        calculadora.ponNum1(-Double.MAX_VALUE);
        calculadora.ponNum2(Double.MAX_VALUE);
        calculadora.ponOperacion("RESTA");
        calculadora.opera();
        Assert.assertEquals(Double.NEGATIVE_INFINITY, calculadora.dameResultado(), TOLERANCIA);
    }


    /**
     * Realiza una prueba para comprobar que la Calculadora realiza restas
     *
     */
    @Test
    public void pruebaRestaNormal() throws Exception {
        calculadora.ponNum1(1);
        calculadora.ponNum2(2);
        calculadora.ponOperacion("RESTA");
        calculadora.opera();
        Assert.assertEquals(-1, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza multiplicaciones
     * y no falla frente al desbordamiento al usar numeros inferiores de los permitidos
     *
     */
    @Test
    public void pruebaMultiplicacionLInferior() throws Exception {
        calculadora.ponNum1(Double.MAX_VALUE);
        calculadora.ponNum2(-2);
        calculadora.ponOperacion("MULTIPLICACION");
        calculadora.opera();
        Assert.assertEquals(Double.NEGATIVE_INFINITY, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza multiplicaciones
     * y no falla frente al desbordamiento al usar numeros superiores de los permitidos
     *
     */
    @Test
    public void pruebaMultiplicacionLSuperior() throws Exception {
        calculadora.ponNum1(Double.MAX_VALUE);
        calculadora.ponNum2(2);
        calculadora.ponOperacion("MULTIPLICACION");
        calculadora.opera();
        Assert.assertEquals(Double.POSITIVE_INFINITY, calculadora.dameResultado(), TOLERANCIA);
    }


    /**
     * Realiza una prueba para comprobar que la Calculadora realiza multiplicaciones
     *
     *
     */
    @Test
    public void pruebaMultiplicacion() throws Exception {
        calculadora.ponNum1(1);
        calculadora.ponNum2(2);
        calculadora.ponOperacion("MULTIPLICACION");
        calculadora.opera();
        Assert.assertEquals(2, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza multiplicaciones
     *
     *
     */
    @Test
    public void pruebaMultiplicacionCero() throws Exception {
        calculadora.ponNum1(0);
        calculadora.ponNum2(2);
        calculadora.ponOperacion("MULTIPLICACION");
        calculadora.opera();
        Assert.assertEquals(0, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza divisiones
     * y no falla frente al desbordamiento al usar numeros inferiores de los permitidos
     *
     */
    @Test
    public void pruebaDivisionNum1Zero() throws Exception {
        calculadora.ponNum1(0);
        calculadora.ponNum2(5);
        calculadora.ponOperacion("DIVISION");
        calculadora.opera();
        Assert.assertEquals(0, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza divisiones
     * y no falla frente al desbordamiento al usar numeros superiores de los permitidos
     *
     */
    @Test( expected = IllegalArgumentException.class)
    public void pruebaDivisionNum2Zero() throws Exception {
        calculadora.ponNum1(5);
        calculadora.ponNum2(0);
        calculadora.ponOperacion("DIVISION");
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza divisiones
     *
     *
     */
    @Test
    public void pruebaDivision() throws Exception {
        calculadora.ponNum1(1);
        calculadora.ponNum2(2);
        calculadora.ponOperacion("DIVISION");
        calculadora.opera();
        Assert.assertEquals(0.5, calculadora.dameResultado(), TOLERANCIA);
    }


}
