package de.mide.kilometer_umrechnung;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;


/**
 * App zur Umrechnung von (metrischen) Kilometern in englische/nautische/chinesische Meilen.
 * <br><br>
 *
 * This file is licensed under the terms of the BSD 3-Clause License.
 */
public class MainActivity extends AppCompatActivity {

    /** UI-Element zur Eingabe der umzurechnenden Kilometerzahl. */
    private EditText _eingabeEditText = null;

    /** RadioButton, der für Umrechnung in englische Meilen auszuwählen ist. */
    private RadioButton _englischMeilenRadioButton = null;

    /** RadioButton, der für Umrechnung in nautische Meilen auszuwählen ist. */
    private RadioButton _nautischMeilenRadioButton = null;

    /** RadioButton, der für Umrechnung in chinesische Meilen (Li) auszuwählen ist. */
    private RadioButton _chinesischMeilenRadioButton = null;


    /**
     * Lifecycle-Methode, füllt Member-Variablen mit UI-Objekten.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _eingabeEditText = findViewById(R.id.kilometerInput);

        _englischMeilenRadioButton   = findViewById( R.id.radio_button_meileEnglisch   );
        _nautischMeilenRadioButton   = findViewById( R.id.radio_button_meileNautisch   );
        _chinesischMeilenRadioButton = findViewById( R.id.radio_button_meileChinesisch );
    }


    /**
     * Event-Handler-Methode für Button "Umrechnen", wird in Layout-Datei zugewiesen.
     *
     * @param view  Button, der Event ausgelöst hat.
     */
    public void onUmrechnenButton(View view) {

        String eingabeStr = _eingabeEditText.getText().toString();

        if (eingabeStr.length() == 0) {

            zeigeDialog("Ungültige Eingabe", "Bitte Kilometer eingeben.");

        } else {

            umrechnungDurchfuehren(eingabeStr);
        }
   }


    /**
     * Methode zur Durchführung der eigentlichen Berechnung; liest den RadioButton
     * für die Zieleinheit aus und zeigt das Ergebnis mit einem AlertDialog an.
     *
     * @param eingabeStr  Eingabe Kilometer als String
     */
    private void umrechnungDurchfuehren(String eingabeStr) {

        try {

            KilometerUmrechner umrechner = new KilometerUmrechner(eingabeStr);

            String ergebnisStr = "";

            if ( _englischMeilenRadioButton.isChecked() ) {

                ergebnisStr = umrechner.getMeilenEnglischAlsString();

            } else if ( _nautischMeilenRadioButton.isChecked() ) {

                ergebnisStr = umrechner.getMeilenNautischAlsString();

            } else if ( _chinesischMeilenRadioButton.isChecked() ) {

                ergebnisStr = umrechner.getMeilenChinesischAlsString();

            } else {

                zeigeDialog("Interner Fehler", "Keine Ziel-Einheit ausgewählt.");
            }

            zeigeDialog("Ergebnis", ergebnisStr);

        } catch (KilometerException ex) {

            zeigeDialog("Interner Fehler:", ex.getMessage() );
        }
    }


    /**
     * AlertDialog öffnen und als Argument übergebenen Text anzeigen.
     *
     * @param title  Titel des Dialogs.
     *
     * @param meldung  Anzuzeigender Text.
     */
    public void zeigeDialog(String title, String meldung) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

        dialogBuilder.setTitle(title);
        dialogBuilder.setMessage(meldung);
        dialogBuilder.setPositiveButton("Zur Kenntnis genommen", null);

        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }

}
