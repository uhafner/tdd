package edu.hm.hafner.tdd;

import java.util.HashSet;
import java.util.Set;

/**
 * Schaltet eine beliebige Menge an Elektrogeräten ein.
 *
 * @author Ulli Hafner
 */
public class Schalter {
    private boolean istGedrueckt;

    private final Set<Geraet> angeschlosseneGeraete = new HashSet<>();

    /**
     * Drückt den Schalter.
     */
    public void druecke() {
        istGedrueckt = !istGedrueckt;

        for (Geraet geraet : angeschlosseneGeraete) {
            geraet.setZustand(istGedrueckt);
        }
    }

    /**
     * Zeigt, ob der Schalter an oder aus ist.
     *
     * @return <code>true</code>, falls der Schalter an ist, <code>false</code> falle er aus ist
     */
    public boolean istAn() {
        return istGedrueckt;
    }

    /**
     * Schließt ein neues Gerät an.
     *
     * @param geraet das Gerät
     */
    public void schliesseAn(final Geraet geraet) {
        angeschlosseneGeraete.add(geraet);
    }

    /**
     * Beschreibt angeschlossene Geräte.
     *
     * @author Ulli Hafner
     */
    public interface Geraet {
        /**
         * Informiert das Gerät, ob der Schalter gedrückt ist.
         *
         * @param istGedrueckt <code>true</code> falls der Schalter gedrückt ist, <code>false</code> falls nicht
         */
        void setZustand(boolean istGedrueckt);
    }
}
