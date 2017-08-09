public class ListeL<I extends Comparable<I>> {

	static class ElementL<K> {
		private K inhalt; // Inhalt des Listenelements
		private ElementL<K> next; // Verweis auf den Nachfolger

		public ElementL(K o) {
			inhalt = o;
			next = null;
		}
	}

	private ElementL<I> head; // Referenz auf den Anfang der Liste

	public ListeL() {
		head = null;
	}

	public ListeL(I o) {
		head = new ElementL<I>(o);
	}

	public int find1(I o) { // -------------------->> Eigene Methode zum Aufinden eines Bestimmten Wertes
							// (Übungsblatt 5 aufgabe 11)

		int ausgabe = -2;
		ElementL<I> temp = new ElementL<I>(o);
		temp = head;
		int count = 0;

		while (ausgabe == -2) {
			if (temp.inhalt.compareTo(o) == 0) {
				return count;
			} else if (temp.next == null) {
				return -1;
			}
			temp = temp.next;
			count++;
		}

		return -1;
	}

	public void sort1() { // ----------------------------------------->> Selectionsort Methode
							// (Übungsblatt 5 Aufgabe 12)

	}

	public int get(int index) { // ---------------------------->> Gibt Wert an bestimmtem Index

		return -1;
	}

	public int length() { // ------------------------------->> Gibt Länge des Arrays zurück
		ElementL<I> temp = null;
		int count = 0;
		temp = head;
		if (temp != null) {
			count++;
		}
		while (temp.next != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

	public ElementL<I> insert(I o) { // am Anfang einf�gen
		ElementL<I> newEl = new ElementL<I>(o);
		if (head == null) { // Liste ist noch leer
			head = newEl;
		} else {
			newEl.next = head;
			head = newEl;
		}
		return newEl;
	}

	public ElementL<I> insert(I o, ElementL<I> pred) { // nach pred (Vorg�nger) einf�gen
		ElementL<I> newEl = new ElementL<I>(o);
		if (pred == null) { // am Anfang einf�gen
			newEl.next = head;
			head = newEl;
		} else { // nach pred (Vorg�nger) einf�gen
			newEl.next = pred.next;
			pred.next = newEl;
		}
		return newEl;
	}

	public void remove(ElementL<I> pred) { // Element nach pred (Vorg�nger) l�schen
		if (pred == null) // erstes Element l�schen
			head = head.next;
		else if (pred.next != null) // Element nach pred (Vorg�nger) l�schen
			pred.next = pred.next.next;
	}

	public String toString() {
		String s = "(";
		ElementL<I> help = head;
		while (help != null && help.next != null) {
			s = s + help.inhalt + ", ";
			help = help.next;
		}
		if (help != null)
			s = s + help.inhalt;
		return s + ")";
	}

	// Test

	public static void main(String[] args) {
		ListeL<Integer> l = new ListeL<Integer>();
		l.insert(0);
		ElementL<Integer> eins = l.insert(new Integer(1));
		l.insert(3);
		l.insert(45);
		l.insert(12);
		l.insert(18);
		l.insert(97);
		l.insert(67);
		System.out.println(l);
		l.insert(2, eins); // nach eins einf�gen
		System.out.println(l);
		l.remove(eins); // Nachfolger von eins l�schen
		System.out.println(l);

		int test = l.find1(97);
		if (test > -1) {
			System.out.println("Der Wert liegt an folgender Stelle: " + test);
		} else {
			System.out.println("Nicht verfügbar!");
		}

		l.sort1();
		System.out.println(l);
		System.out.println(l.length());
	}

}
