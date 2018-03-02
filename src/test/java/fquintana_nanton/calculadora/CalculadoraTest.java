package fquintana_nanton.calculadora;


import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTest {

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
        Assert.assertEquals(Double.POSITIVE_INFINITY , calculadora.dameResultado(), 0);
    }

    @Test
    public void pruebaSumaLInferior() {
        calculadora.ponNum1(Double.MIN_VALUE);
        calculadora.ponNum2(-1);
        calculadora.ponOperacion("SUMA");
        calculadora.opera();
        System.out.println(calculadora.dameResultado());
        Assert.assertEquals(Double.NEGATIVE_INFINITY , calculadora.dameResultado(), 0);
    }

    @Test
    public void pruebaResta() {
        calculadora.ponNum1(1);
        calculadora.ponNum2(2);
        calculadora.ponOperacion("RESTA");
        calculadora.opera();
        Assert.assertEquals(-1, calculadora.dameResultado(), 0);
    }

    @Test
    public void pruebaMultiplicación() {
        calculadora.ponNum1(1);
        calculadora.ponNum2(2);
        calculadora.ponOperacion("MULTIPLICA");
        calculadora.opera();
        Assert.assertEquals(2, calculadora.dameResultado(), 0);
    }

    @Test
    public void pruebaDivision() {
        calculadora.ponNum1(1);
        calculadora.ponNum2(2);
        calculadora.ponOperacion("DIVIDE");
        calculadora.opera();
        Assert.assertEquals(0.5, calculadora.dameResultado(), 0);
    }
}
