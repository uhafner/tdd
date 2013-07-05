package edu.hm.hafner.tdd;

import static org.junit.Assert.*;

import java.util.Observable;
import java.util.Observer;

import org.junit.Test;

/**
 * Tests the class {@link Switch}.
 *
 * @author Ulli Hafner
 */
public class SwitchTest {
    /**
     * Prüft, dass nach dem Einschalten alle Geräte eingeschaltet sind.
     */
    @Test
    public void testeEinschalten() {
        // Given
        Switch schalter = new Switch();
        assertFalse("Geräte sind an!", schalter.istAn());

        // When
        schalter.druecke();

        // Then
        assertTrue("Geräte sind nicht an!", schalter.istAn());
    }

    /**
     * Zeigt, dass alle angeschlossenen Geräte eingeschaltet werden.
     */
    @Test
    public void testeAngeschlosseneGeraeteWerdenEingeschaltet() {
        // Given
        Switch schalter = new Switch();
        Lampe lampe = new Lampe();

        // When
        schalter.addObserver(lampe);
        schalter.druecke();

        // Then
        assertTrue("Lampe ist nicht eingeschaltet!", lampe.istAn());
    }

    /**
     * Eine Lampe als einfache Implementierung der {@link Observer} Schnittstelle.
     */
    public class Lampe implements Observer {
        private boolean istLampeAn;

        /**
         * Liefert zurück, ob die Lampe an ist.
         *
         * @return <code>true</code> falls die Lampe an ist, <code>false</code> sonst
         */
        public boolean istAn() {
            return istLampeAn;
        }

        @Override
        public void update(final Observable o, final Object arg) {
            istLampeAn = (boolean)arg;
        }
    }
}

