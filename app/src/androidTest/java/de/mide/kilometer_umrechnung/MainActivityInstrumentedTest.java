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

import androidx.test.rule.ActivityTestRule;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Instrumented Tests (d.h. laufen im Emulator oder auf Gerät) mit "Espresso".
 * <br><br>
 *
 * This file is licensed under the terms of the BSD 3-Clause License.
 *
 * @link https://developer.android.com/training/testing/espresso
 * @link https://developer.android.com/reference/android/support/test/espresso/matcher/ViewMatchers
 * @link https://developer.android.com/reference/androidx/test/espresso/action/ViewActions
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    /**
     * Mit einer JUnit Rule kann man bestimmte Dinge vor oder nach der Ausführung einer Testmethode
     * ausführen lassen. Die hier verwendete ActivityTestRule sorgt dafür, dass die MainActivity
     * vor jeder Testmethode gestartet wird.
     * <br><br>
     *
     * Damit die ActivityTestRule gefunden wird muss die folgende Zeile im Block dependencies{} in der
     * Datei app/build.gradle eingetragen werden: androidTestImplementation 'androidx.test:rules:1.1.0'
     */
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);


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
