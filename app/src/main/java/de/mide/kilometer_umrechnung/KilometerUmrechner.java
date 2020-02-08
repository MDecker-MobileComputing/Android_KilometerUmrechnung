package de.mide.kilometer_umrechnung;


/**
 * Diese Klasse beinhaltet die Logik für die eigentliche Umrechnung von Kilometern
 * in Meilen.
 * <br><br>
 *
 * This file is licensed under the terms of the BSD 3-Clause License.
 */
public class KilometerUmrechner {

    /**
     * Umrechnungsfaktor für Kilometer in englische Meilen,
     * siehe auch https://de.wikipedia.org/wiki/Mile_(Einheit)
     */
    public static final double UMRECHNUNGSFAKTOR_MEILEN_ENGLISCH = 1.609344;

    /**
     * Umrechnungsfaktor für Kilometer in nautische Meilen (Seemeilen),
     * siehe auch https://de.wikipedia.org/wiki/Seemeile
     */
    public static final double UMRECHNUNGSFAKTOR_MEILEN_NAUTISCH = 1.852;

    /**
     * Umrechnungsfaktor für Kilometer in chinesische Meilen (Li),
     * siehe auch https://de.wikipedia.org/wiki/Li_%28Einheit%29
     */
    public static final double UMRECHNUNGSFAKTOR_MEILEN_CHINESISCH = 0.5;


    /** Umzurechnender Kilometer, wird vom Konstruktor gesetzt. */
    private double _kilometer = -1.0;


    /**
     * Konstruktor um umzurechnende Anzahl Kilometer zu setzen.
     *
     * @param kilometer  Kilometer, die in Meilen umgerechnet werden sollen.
     *
     * @throws KilometerException  Ungültiger Kilometer-Wert
     */
    public KilometerUmrechner(double kilometer) throws KilometerException {

        if (kilometer <= 0.0) {

            throw new KilometerException("Unzulässiger Kilometer-Wert " + kilometer);
        }

        _kilometer = kilometer;
    }


    /**
     * Konstruktor um umzurechnende Anzahl Kilometer als String zu setzen.
     *
     * @param kilometerStr  Kilometer-Wert, der umgerechnet werden soll,
     *
     * @throws KilometerException  Ungültiger Kilometer-Wert
     */
    public KilometerUmrechner(String kilometerStr) throws KilometerException {

        try {

            _kilometer = Double.parseDouble(kilometerStr);
        }
        catch (NumberFormatException ex) {

            throw new KilometerException("Ungültiger String für Kilometer: \"" + kilometerStr + "\"");
        }

        if (_kilometer <= 0.0) {

            throw new KilometerException("Unzulässiger Kilometer-Wert " + _kilometer);
        }
    }


    /**
     * Umrechnung in englische Meilen.
     *
     * @return  Ergebnis Umrechnung von Kilometer in englische Meilen.
     */
    public double getMeilenEnglisch() {

        return _kilometer * UMRECHNUNGSFAKTOR_MEILEN_ENGLISCH;
    }


    /**
     * Umrechnung in englische Meilen.
     *
     * @return  Ergebnis Umrechnung von Kilometer in englische Meilen mit Einheit.
     */
    public String getMeilenEnglischAlsString() {

        return getMeilenEnglisch() + " engl. Meilen";
    }


    /**
     * Umrechnung in nautisch Meilen (Seemeilen).
     *
     * @return  Ergebnis Umrechnung von Kilometer in nautische Meilen.
     */
    public double getMeilenNautisch() {

        return _kilometer * UMRECHNUNGSFAKTOR_MEILEN_NAUTISCH;
    }


    /**
     * Umrechnung in nautisch Meilen (Seemeilen).
     *
     * @return  Ergebnis Umrechnung von Kilometer in nautische Meilen mit Einheit.
     */
    public String getMeilenNautischAlsString() {

        return getMeilenNautisch() + " nautische Meilen";
    }


    /**
     * Umrechnung in chinesische Meilen.
     *
     * @return  Ergebnis Umrechnung von Kilometer in chinesischen Meilen.
     */
    public double getMeilenChinesisch() {

        return _kilometer * UMRECHNUNGSFAKTOR_MEILEN_CHINESISCH;
    }

    /**
     * Umrechnung in chinesische Meilen.
     *
     * @return  Ergebnis Umrechnung von Kilometer in chinesischen Meilen mit Einheit.
     */
    public String getMeilenChinesischAlsString() {

        return getMeilenChinesisch() + " chinesische Meilen";
    }

}
