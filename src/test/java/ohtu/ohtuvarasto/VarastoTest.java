package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.Console;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    Varasto saldoVarasto;
    Varasto pieni;
    Varasto pieniSaldo;
    Varasto negSaldo;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
        saldoVarasto = new Varasto(10, 2);
        pieni = new Varasto(-1);
        pieniSaldo = new Varasto(-1, 5);
        negSaldo = new Varasto(5, -3);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void eiLiianPieniaVarastoja() {
        assertEquals(0, pieni.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void alkuSaldollinenVarastoOikeaTilavuus() {
        assertEquals(10, saldoVarasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void alkuSaldollinenVarastoOikeaSaldo() {
        assertEquals(2, saldoVarasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void saldollinenLiianPieniOikeaTilavuus() {
        assertEquals(0, pieniSaldo.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysYliTilavuudenHeitetaanHukkaan() {
        varasto.lisaaVarastoon(12);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);
        double saatuMaara = varasto.otaVarastosta(2);
        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);
        varasto.otaVarastosta(2);
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void tyhjeneeKunOtetaanYliSaldon() {
        saldoVarasto.otaVarastosta(11);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
   }

    @Test
    public void negOttaminenEiVaikuta() {
        saldoVarasto.otaVarastosta(-5);
        assertEquals(2, saldoVarasto.getSaldo(), vertailuTarkkuus);
   }

    @Test
    public void negLisaaminenEiVaikuta() {
        saldoVarasto.lisaaVarastoon(-5);
        assertEquals(2, saldoVarasto.getSaldo(), vertailuTarkkuus);
   }
  
    @Test
    public void negAlkusaldoTekeeTyhjan() {
        assertEquals(0, negSaldo.getSaldo(), vertailuTarkkuus);
   }



    @Test
    public void merkkijonoesitysOnOikein() {
        String vastaus = "saldo = 2.0, vielä tilaa 8.0";
        assertEquals(vastaus, saldoVarasto.toString());
    }
    


}