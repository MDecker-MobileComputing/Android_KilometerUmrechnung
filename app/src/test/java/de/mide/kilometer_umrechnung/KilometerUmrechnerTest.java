package de.mide.kilometer_umrechnung;

import org.junit.Test;

import org.junit.Assert;


/**
 * Unit-Tests für Klasse {@code KilometerUmrechner}.
 * <br><br>
 *
 * This file is licensed under the terms of the BSD 3-Clause License.
 */
public class KilometerUmrechnerTest {

    /** Class/Code under Test (CUT), muss zu Beginn jeder Test-Methode erzeugt werden. */
    private KilometerUmrechner _cut = null;


    /**
     * Tests für Aufruf Konstruktor der Klasse KilometerUmrechner mit unzulässigem
     * String-Wert.
     */
    @Test
    public void illegalerKilometerWert() {

        try {
            _cut = new KilometerUmrechner("");

            Assert.fail("Keine Exception für Konstruktor-Aufruf mit leerem String.");
        }
        catch (KilometerException ex) { /* Erwartete Exception wurde gefangen. */ }

        try {
            _cut = new KilometerUmrechner("0.0");

            Assert.fail("Keine Exception für Konstruktor-Aufruf mit String \"0.0\".");
        }
        catch (KilometerException ex) { /* Erwartete Exception wurde gefangen. */ }

        try {
            _cut = new KilometerUmrechner("-1.23");

            Assert.fail("Keine Exception für Konstruktor-Aufruf mit String \"-1.23\".");
        }
        catch (KilometerException ex) { /* Erwartete Exception wurde gefangen. */ }
    }


    /**
     * Umrechnung von Kilometer in Englische Meilen.
     *
     * @throws KilometerException  Test ist fehlgeschlagen
     */
    @Test
    public void happypath_englischeMeilen() throws KilometerException {

        final double eingabeKilometer   = 12.3;
        final double erwartetesErgebnis = 12.3 * 1.609344;

        _cut = new KilometerUmrechner(eingabeKilometer + "");

        // Aufruf Methode under Test
        double ergebnis = _cut.getMeilenEnglisch();

        Assert.assertTrue( Math.abs(ergebnis - erwartetesErgebnis) < 0.01 );
    }


    /**
     * Umrechnung von Kilometer in nautische Meilen (Seemeilen).
     *
     * @throws KilometerException  Test ist fehlgeschlagen
     */
    @Test
    public void happypath_nautischeMeilen() throws KilometerException {

        final double eingabeKilometer   = 12.3;
        final double erwartetesErgebnis = 12.3 * 1.852;

        _cut = new KilometerUmrechner(eingabeKilometer + "");

        // Aufruf Methode under Test
        double ergebnis = _cut.getMeilenNautisch();

        Assert.assertTrue( Math.abs(ergebnis - erwartetesErgebnis) < 0.01 );
    }


    /**
     * Umrechnung von Kilometer in chinesische Meilen (Li).
     *
     * @throws KilometerException  Test ist fehlgeschlagen
     */
    @Test
    public void happypath_chinesischeMeilen() throws KilometerException {

        final double eingabeKilometer   = 12.3;
        final double erwartetesErgebnis = 12.3 * 0.5;

        _cut = new KilometerUmrechner(eingabeKilometer + "");

        // Aufruf Methode under Test
        double ergebnis = _cut.getMeilenChinesisch();

        Assert.assertTrue( Math.abs(ergebnis - erwartetesErgebnis) < 0.01 );
    }


    /**
     * Vergleich Ausgabe String und Double.
     *
     * @throws KilometerException  Test ist fehlgeschlagen
     */
    @Test
    public void ergebnisAlsString() throws KilometerException {

        final double eingabeKilometer = 123.4;

        double ergebnisDouble = 0.0;
        String ergebnisString = "";

        _cut = new KilometerUmrechner(eingabeKilometer + "");


        // Test für englische Meilen
        ergebnisDouble = _cut.getMeilenEnglisch();
        ergebnisString = _cut.getMeilenEnglischAlsString();

        Assert.assertTrue( ergebnisString.startsWith( (int) ergebnisDouble + "" ) );


        // Test für nautische Meilen
        ergebnisDouble = _cut.getMeilenNautisch();
        ergebnisString = _cut.getMeilenNautischAlsString();

        Assert.assertTrue( ergebnisString.startsWith( (int) ergebnisDouble + "" ) );


        // Test für chinesische Meilen
        ergebnisDouble = _cut.getMeilenChinesisch();
        ergebnisString = _cut.getMeilenChinesischAlsString();

        Assert.assertTrue( ergebnisString.startsWith( (int) ergebnisDouble + "" ) );
    }

}