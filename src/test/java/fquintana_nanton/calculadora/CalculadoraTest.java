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
    public void pruebaSuma() {
        calculadora.ponNum1(1);
        calculadora.ponNum2(2);
        calculadora.ponOperacion("SUMA");
        calculadora.opera();
        Assert.assertEquals(3, calculadora.dameResultado(), 0);
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
