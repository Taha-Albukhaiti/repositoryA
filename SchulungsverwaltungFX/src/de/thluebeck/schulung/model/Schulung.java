package de.thluebeck.schulung.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/** Abstrakte Model-Klasse Schulung.
 * @author Holger Hinrichs
 * @version 1.0
*/ 
public abstract class Schulung {

	protected IntegerProperty nummer;
	protected StringProperty ort;
	protected StringProperty thema;
	
	/** Einfacher Konstruktor ohne Parameter, Werte muessen per set...() geschrieben werden
	 */
	public Schulung() {
		this(0, "", "");		//mit 0 und "" initialisieren
	}
	
	/** Konstruktor zum Erzeugen eines Schulung-Objekts mit Nummer, Ort und Thema
	  * @param nummer Die Nummer der Schulung.
	  * @param ort Die Stadt, in der die Schulung stattfindet
	  * @param thema Das Thema der Schulung.
	 */ 
	public Schulung(int nummer, String ort, String thema) {
		this.nummer = new SimpleIntegerProperty(nummer);
		this.ort = new SimpleStringProperty(ort);
		this.thema = new SimpleStringProperty(thema);
	}

	/** Setzt die Nummer der Schulung auf den uebergebenen Wert.
	  * @param nummer Die neue Nummer der Schulung.
	 */ 
	public void setNummer(int nummer) {
		this.nummer.set(nummer);
	}
	
	/** Setzt den Ort der Schulung auf den uebergebenen Wert.
	  * @param ort Der neue Ort der Schulung.
	 */ 
	public void setOrt(String ort) {
		this.ort.set(ort);
	}

	/** Setzt das Thema der Schulung auf den uebergebenen Wert.
	  * @param thema Das neue Thema der Schulung.
	 */ 
	public void setThema(String thema) {
		this.thema.set(thema);
	}
	
	/** Gibt die Nummer der Schulung zurueck.
	  * @return Die Nummer der Schulung.
	 */ 
	public int getNummer() {
		return nummer.get();
	}

	/** Gibt den Ort der Schulung zurueck.
	  * @return Der Ort der Schulung.
	 */ 
	public String getOrt() {
		return ort.get();
	}

	/** Gibt das Thema der Schulung zurueck.
	  * @return Das Thema der Schulung.
	 */ 
	public String getThema() {
		return thema.get();
	}
	
	/** Gibt die Nummer der Schulung als Property zurueck.
	  * @return Die Nummer der Schulung.
	 */ 
	public IntegerProperty nummerProperty() {
		return nummer;
	}

	/** Gibt den Ort der Schulung als Property zurueck.
	  * @return Der Ort der Schulung.
	 */ 
	public StringProperty ortProperty() {
		return ort;
	}

	/** Gibt das Thema der Schulung als Property zurueck.
	  * @return Das Thema der Schulung.
	 */ 
	public StringProperty themaProperty() {
		return thema;
	}

	/** Abstrakte Methode zur Berechnung des Preises p. P. der Schulung. 
	  * Dieser berechnet sich je nach konkreter Auspraegung der Schulung unterschiedlich:
	  * @return Der Preis p. P. der Schulung.
	 */ 
	abstract public int getPreisProPerson();

}
