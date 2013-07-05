package edu.hm.hafner.tdd;

import java.util.Observable;
import java.util.Observer;

/**
 * Ein Schalter basierend auf der Java {@link Observer} Implementierung.
 *
 * @author Ulli Hafner
 */
public class Switch extends Observable {
    private boolean istGedrueckt;

    /**
     * Drückt den Schalter.
     */
    public void druecke() {
        istGedrueckt = !istGedrueckt;

        setChanged();
        notifyObservers(istGedrueckt);
    }

    /**
     * Zeigt, ob der Schalter an oder aus ist.
     *
     * @return <code>true</code>, falls der Schalter an ist, <code>false</code> falle er aus ist
     */
    public boolean istAn() {
        return istGedrueckt;
    }
}

