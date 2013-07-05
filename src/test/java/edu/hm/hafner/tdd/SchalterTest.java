package edu.hm.hafner.tdd;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.hm.hafner.tdd.Schalter.Geraet;

/**
 * Testet die Klasse {@link Schalter}.
 *
 * @author Ulli Hafner
 */
public class SchalterTest {
    /**
     * Prüft, dass nach dem Einschalten alle Geräte eingeschaltet sind.
     */
    @Test
    public void testeEinschalten() {
        // Given
        Schalter schalter = new Schalter();
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
        Schalter schalter = new Schalter();
        Lampe lampe = new Lampe();

        // When
        schalter.schliesseAn(lampe);
        schalter.druecke();

        // Then
        assertTrue("Lampe ist nicht eingeschaltet!", lampe.istAn());
    }

    /**
     * Eine Lampe als einfache Implementierung der {@link Geraet} Schnittstelle.
     */
    public class Lampe implements Geraet {
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
        public void setZustand(final boolean istGedrueckt) {
            istLampeAn = istGedrueckt;
        }
    }
}

