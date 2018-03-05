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
    @Test(expected = IllegalArgumentException.class)
    public void pruebaSumaLSuperior() throws Exception{
        calculadora.ponOperacion("SUMA");
        calculadora.ponNum(0,Double.MAX_VALUE);
        calculadora.ponNum(1,Double.MAX_VALUE);
        calculadora.opera();
    }


    /**
     * Realiza una prueba para comprobar que la Calculadora realiza sumas
     * y no falla frente al desbordamiento al usar numeros inferiores de los permitidos
     *
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaSumaLInferior() throws Exception{
        calculadora.ponOperacion("SUMA");
        calculadora.ponNum(0,-Double.MAX_VALUE);
        calculadora.ponNum(1,-Double.MAX_VALUE);
        calculadora.opera();
    }


    /**
     * Realiza una prueba para comprobar que la Calculadora realiza sumas
     *
     *
     */
    @Test
    public void pruebaSumaNormal() throws Exception {
        calculadora.ponOperacion("SUMA");
        calculadora.ponNum(0,5.43);
        calculadora.ponNum(1,6.69);
        calculadora.opera();
        Assert.assertEquals(12.12 , calculadora.dameResultado(), TOLERANCIA);
    }


    /**
     * Realiza una prueba para comprobar que la Calculadora realiza restas
     * y no falla frente al desbordamiento al usar numeros superiores de los permitidos
     *
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaRestaLSuperior() throws Exception {
        calculadora.ponOperacion("RESTA");
        calculadora.ponNum(0,Double.MAX_VALUE);
        calculadora.ponNum(1,-Double.MAX_VALUE);
        calculadora.opera();
    }


    /**
     * Realiza una prueba para comprobar que la Calculadora realiza restas
     * y no falla frente al desbordamiento al usar numeros inferiores de los permitidos
     *
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaRestaLInferior() throws Exception {
        calculadora.ponOperacion("RESTA");
        calculadora.ponNum(0,-Double.MAX_VALUE);
        calculadora.ponNum(1,Double.MAX_VALUE);
        calculadora.opera();
    }


    /**
     * Realiza una prueba para comprobar que la Calculadora realiza restas
     *
     */
    @Test
    public void pruebaRestaNormal() throws Exception {
        calculadora.ponOperacion("RESTA");
        calculadora.ponNum(0,1);
        calculadora.ponNum(1,2);
        calculadora.opera();
        Assert.assertEquals(-1, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza multiplicaciones
     * y no falla frente al desbordamiento al usar numeros inferiores de los permitidos
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaMultiplicacionLInferior() throws Exception {
        calculadora.ponOperacion("MULTIPLICACION");
        calculadora.ponNum(0,-2);
        calculadora.ponNum(1,Double.MAX_VALUE);
        calculadora.opera();
        Assert.assertEquals(Double.NEGATIVE_INFINITY, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza multiplicaciones
     * y no falla frente al desbordamiento al usar numeros superiores de los permitidos
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void pruebaMultiplicacionLSuperior() throws Exception {
        calculadora.ponOperacion("MULTIPLICACION");
        calculadora.ponNum(0,Double.MAX_VALUE);
        calculadora.ponNum(1,2);
        calculadora.opera();
    }


    /**
     * Realiza una prueba para comprobar que la Calculadora realiza multiplicaciones
     *
     *
     */
    @Test
    public void pruebaMultiplicacion() throws Exception {
        calculadora.ponOperacion("MULTIPLICACION");
        calculadora.ponNum(0,1);
        calculadora.ponNum(1,2);
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
        calculadora.ponOperacion("MULTIPLICACION");
        calculadora.ponNum(0,0);
        calculadora.ponNum(1,2);
        calculadora.opera();
        Assert.assertEquals(0, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza divisiones
     * y no falla al dividir 0 entre otros numeros
     *
     */
    @Test
    public void pruebaDivisionNum1Zero() throws Exception {
        calculadora.ponOperacion("DIVISION");
        calculadora.ponNum(0,0);
        calculadora.ponNum(1,5);
        calculadora.opera();
        Assert.assertEquals(0, calculadora.dameResultado(), TOLERANCIA);
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza divisiones
     * y no falla al dividir numeros entre 0
     *
     */
    @Test( expected = IllegalArgumentException.class)
    public void pruebaDivisionNum2Zero() throws Exception {
        calculadora.ponOperacion("DIVISION");
        calculadora.ponNum(0,5);
        calculadora.ponNum(1,0);
        calculadora.opera();
    }

    /**
     * Realiza una prueba para comprobar que la Calculadora realiza divisiones
     *
     *
     */
    @Test
    public void pruebaDivision() throws Exception {
        calculadora.ponOperacion("DIVISION");
        calculadora.ponNum(0,1);
        calculadora.ponNum(1,2);
        calculadora.opera();
        Assert.assertEquals(0.5, calculadora.dameResultado(), TOLERANCIA);
    }


}
