package de.thluebeck.schulung.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/** Model-Klasse Seminar, jedes Objekt repraesentiert ein Seminar, eine spezielle Form der Schulung.
 * @author Holger Hinrichs
 * @version 1.0
*/ 
public class Seminar extends Schulung {

	protected static final int TAGESSATZ = 500;
	protected IntegerProperty anzahlTage;

	/** Einfacher Konstruktor ohne Parameter, Werte muessen per set...() geschrieben werden
	 */
	public Seminar() {
		this(0, "", "", 0);   //mit 0 und "" initialisieren
	}
	
	/** Konstruktor zum Erzeugen eines Seminar-Objekts mit seinen Eigenschaften
	  * @param nummer Die Nummer des Seminars.
	  * @param ort Die Stadt, in dem das Seminar stattfindet
	  * @param thema Das Thema des Seminars.
	  * @param anzahlTage Die Anzahl an Tagen, die das Seminar dauert
	 */ 
	public Seminar(int nummer, String ort, String thema, int anzahlTage) {
		//Konstruktor der Oberklasse aufrufen
		super(nummer, ort, thema);
		this.anzahlTage = new SimpleIntegerProperty(anzahlTage);
	}
	
	/** Setzt die Anzahl der Tage auf den uebergebenen Wert.
	  * @param anzahlTage Die Anzahl der Seminartage.
	 */ 
	public void setAnzahlTage(int anzahlTage) {
		this.anzahlTage.set(anzahlTage);
	}

	/** Gibt die Anzahl der Tage zurueck.
	  * @return Die Anzahl der Seminartage.
	 */ 
	public int getAnzahlTage() {
		return anzahlTage.get();
	}
	
	/** Gibt die Anzahl der Tage als Property zurueck.
	  * @return Die Anzahl der Seminartage.
	 */ 
	public IntegerProperty anzahlTageProperty() {
		return anzahlTage;
	}

	/** Berechnet den Preis p. P. des Seminars als Produkt aus Anzahl Tage und Tagessatz.
	  * @return Der Preis p. P. des Seminars.
	 */ 
	@Override
	public int getPreisProPerson() {
		// Kosten = #Tage x Tagessatz
		return anzahlTage.get() * TAGESSATZ;
	}

	/** Gibt eine Textrepraesentation des Objekts zurueck.
	  * @return Die Textrepraesentation des Objekts.
	 */ 
	@Override
	public String toString() {
		return "Seminar: Nummer: " + nummer + ", Ort: " + ort
				+ ", Thema: " + thema + ", Anzahl Tage: " + anzahlTage;
	}
}
