package de.mide.kilometer_umrechnung;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Instrumented Tests (d.h. laufen im Emulator oder auf Gerät) mit "Espresso".
 * In Emulator muss Sprache "Englisch" eingestellt sein, damit als Dezimaltrenner
 * "." statt "," verwendet wird.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    /**
     * MainActivity vor jeder Testmethode sichtbar machen.
     */
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
                                    new ActivityScenarioRule<>(MainActivity.class);

    /**
     * In dieser Testmethode werden 10.5km in englische Meilen umgerechnet.
     */
    @Test
    public void kilometer2englischeMeilen() {

        // Umzurechnenden Kilometerwert eintragen
        onView( withId(R.id.kilometerInput) ).perform(
                typeText("10.5"), closeSoftKeyboard()
        );

        // Auf RadioButton mit Zieleinheit "englische Meilen" klicken
        onView( withId(R.id.radio_button_meileEnglisch) ).perform( click() );

        // Auf Button "Umrechnen" klicken
        onView( withId(R.id.umrechnenButton) ).perform( click() );


        // Kontrollieren, ob Dialog mit Ergebnis angezeigt wird
        onView( withText("Ergebnis") ).check( matches(isDisplayed()) );

        // Ergebnis-Wert nur auf erste Nachkommastelle prüfen
        onView( withSubstring("6.52") ).check( matches(isDisplayed()) );


        // Dialog durch Klick auf Button "Zur Kenntnis genommen" schließen
        onView( withText("Zur Kenntnis genommen") ).perform( click() );


        // Dialog muss jetzt verschwunden sein
        onView( withText("Ergebnis") ).check( doesNotExist() );
    }


    /**
     * In dieser Testmethode werden 10.5km in Seemeilen (nautische Meilen).
     */
    @Test
    public void kilometer2seemeilen() {

        // Umzurechnenden Kilometerwert eintragen
        onView( withId(R.id.kilometerInput) ).perform(
                typeText("10.5"), closeSoftKeyboard()
        );

        // Auf RadioButton mit Zieleinheit "englische Meilen" klicken
        onView( withId(R.id.radio_button_meileNautisch) ).perform( click() );

        // Auf Button "Umrechnen" klicken
        onView( withId(R.id.umrechnenButton) ).perform( click() );


        // Kontrollieren, ob Dialog mit Ergebnis angezeigt wird
        onView( withText("Ergebnis") ).check( matches(isDisplayed()) );

        // Ergebnis-Wert nur auf erste Nachkommastelle prüfen
        onView( withSubstring("5.67") ).check( matches(isDisplayed()) );


        // Dialog durch Klick auf Button "Zur Kenntnis genommen" schließen
        onView( withText("Zur Kenntnis genommen") ).perform( click() );


        // Dialog muss jetzt verschwunden sein
        onView( withText("Ergebnis") ).check( doesNotExist() );
    }


    /**
     * In dieser Testmethode werden 10.5km in chinesische Meilen (Li).
     */
    @Test
    public void kilometer2chinesischeMeilen() {

        // Umzurechnenden Kilometerwert eintragen
        onView( withId(R.id.kilometerInput) ).perform(
                typeText("10.5"), closeSoftKeyboard()
        );

        // Auf RadioButton mit Zieleinheit "englische Meilen" klicken
        onView( withId(R.id.radio_button_meileChinesisch) ).perform( click() );

        // Auf Button "Umrechnen" klicken
        onView( withId(R.id.umrechnenButton) ).perform( click() );


        // Kontrollieren, ob Dialog mit Ergebnis angezeigt wird
        onView( withText("Ergebnis") ).check( matches(isDisplayed()) );

        // Ergebnis-Wert nur auf erste Nachkommastelle prüfen
        onView( withSubstring("21.0") ).check( matches(isDisplayed()) );


        // Dialog durch Klick auf Button "Zur Kenntnis genommen" schließen
        onView( withText("Zur Kenntnis genommen") ).perform( click() );


        // Dialog muss jetzt verschwunden sein
        onView( withText("Ergebnis") ).check( doesNotExist() );
    }


    /**
     * Verhalten bei Klick auf Button "Umrechnen" prüfen wenn nichts eingegeben.
     */
    @Test
    public void leereEingabe() {

        onView( withId(R.id.umrechnenButton) ).perform( click() );

        // Kontrollieren, ob Dialog angezeigt wird
        onView( withText("Ungültige Eingabe") ).check( matches(isDisplayed()) );


        // Dialog durch Klick auf Button "Zur Kenntnis genommen" schließen
        onView( withText("Zur Kenntnis genommen") ).perform( click() );


        // Dialog muss jetzt verschwunden sein
        onView( withText("Ungültige Eingabe") ).check( doesNotExist() );
    }


}
