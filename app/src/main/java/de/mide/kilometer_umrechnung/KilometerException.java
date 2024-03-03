package de.mide.kilometer_umrechnung;


/**
 * Eigene Exception-Klasse; ein Exception-Objekt dieser Klasse wird bei
 * ungültigen Eingaben geworfen.
 *
 * <br><br>
 *
 * This file is licensed under the terms of the BSD 3-Clause License.
 */
public class KilometerException extends Exception {

    public KilometerException(String fehlerbeschreibung) {

        super(fehlerbeschreibung);
    }

}
