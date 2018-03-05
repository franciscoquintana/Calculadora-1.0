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


    @org.junit.Before
    public void setUp() throws Exception {
        calculadora = new Calculadora();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }



    @Test
    public void pruebaSumaLSuperior() {
        calculadora.ponNum1(Double.MAX_VALUE);
        calculadora.ponNum2(Double.MAX_VALUE);
        calculadora.ponOperacion("SUMA");
        calculadora.opera();
        Assert.assertEquals(Double.POSITIVE_INFINITY , calculadora.dameResultado(), TOLERANCIA);
    }

    @Test
    public void pruebaSumaLInferior() {
        calculadora.ponNum1(-Double.MAX_VALUE);
        calculadora.ponNum2(-Double.MAX_VALUE);
        calculadora.ponOperacion("SUMA");
        calculadora.opera();
        Assert.assertEquals(Double.NEGATIVE_INFINITY , calculadora.dameResultado(), TOLERANCIA);
    }

    @Test
    public void pruebaSumaNormal() {
        calculadora.ponNum1(5.43);
        calculadora.ponNum2(6.69);
        calculadora.ponOperacion("SUMA");
        calculadora.opera();
        Assert.assertEquals(12.12 , calculadora.dameResultado(), TOLERANCIA);
    }

    @Test
    public void pruebaRestaLSuperior() {
        calculadora.ponNum1(Double.MAX_VALUE);
        calculadora.ponNum2(-Double.MAX_VALUE);
        calculadora.ponOperacion("RESTA");
        calculadora.opera();
        Assert.assertEquals(Double.POSITIVE_INFINITY, calculadora.dameResultado(), TOLERANCIA);
    }

    @Test
    public void pruebaRestaLInferior() {
        calculadora.ponNum1(-Double.MAX_VALUE);
        calculadora.ponNum2(Double.MAX_VALUE);
        calculadora.ponOperacion("RESTA");
        calculadora.opera();
        Assert.assertEquals(Double.NEGATIVE_INFINITY, calculadora.dameResultado(), TOLERANCIA);
    }

    @Test
    public void pruebaRestaNormal() {
        calculadora.ponNum1(1);
        calculadora.ponNum2(2);
        calculadora.ponOperacion("RESTA");
        calculadora.opera();
        Assert.assertEquals(-1, calculadora.dameResultado(), TOLERANCIA);
    }

    @Test
    public void pruebaMultiplicación() {
        calculadora.ponNum1(1);
        calculadora.ponNum2(2);
        calculadora.ponOperacion("MULTIPLICACION");
        calculadora.opera();
        Assert.assertEquals(2, calculadora.dameResultado(), TOLERANCIA);
    }

    @Test
    public void pruebaDivision() {
        calculadora.ponNum1(1);
        calculadora.ponNum2(2);
        calculadora.ponOperacion("DIVISION");
        calculadora.opera();
        Assert.assertEquals(0.5, calculadora.dameResultado(), TOLERANCIA);
    }
}
