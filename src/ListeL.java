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

	public int find1(I o) { // ------------------------->> Eigene Methode zum Aufinden eines Bestimmten
							// Wertes
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

		int minimumindex = 0;

		for (int count = 0; count < length(); count++) {
			minimumindex = getMinimum(count);
			tauschen(count, minimumindex);
		}
	} // (Übungsblatt 5 Aufgabe 12)

	public void sort2() { // -------------------------------------->> BubbleSort Methode
		int maxindex = length();

		while (maxindex > 1) {
			for (int x = 0; x < maxindex - 1; x++) {
				if (get(x).inhalt.compareTo(get(x + 1).inhalt) > 0) {
					tauschen(x, x + 1);
				}
			}
			maxindex--;
		}

	} // Übungsblatt 5 Aufgabe 13

	public void sort3() { // -------------------------------------->> Insertionssort
		
		int templange = length();
		
		for(int x = 0; x < templange-1; x++) {
			if(get(x).inhalt.compareTo(get(x+1).inhalt) > 0) {
				versetzeElement(x+1,x);
			}
		}
		
		
		
		
		
	} // Übungsblatt 5 Aufgabe 14

	public void tauschen(int index1, int index2) { // --------------------------------------->> tauscht zwei
													// inhaltswerte der Liste
		ElementL<I> temp1 = new ElementL<I>(get(index1).inhalt);
		ElementL<I> temp2 = new ElementL<I>(get(index2).inhalt);
		get(index1).inhalt = temp2.inhalt;
		get(index2).inhalt = temp1.inhalt;

	}

	public void versetzeElement(int von, int nach) { // ----------------------------------->> versetzt von nach
		int templange = length();
		ElementL<I> temp1 = get(von);
		ElementL<I> temp2 = null;
		if (nach < templange - 1 && von <= nach) {
			temp2 = get(nach+1);
		} else {
			temp2 = get(nach);
		}
		
		// this.insert(temp1.inhalt, get(nach-1));
		remove(get(von - 1));
		if (nach > 0) {
			get(nach - 1).next = temp1;
		} else {
			head = temp1;
		}

		temp1.next = temp2;


	}

	public int getMinimum(int von) { // ------------------------------->> gibt Index des Minimalen Wertes
		ElementL<I> temp = head;
		int minimum = von;

		for (int x = von + 1; x < length(); x++) {
			if (get(minimum).inhalt.compareTo(get(x).inhalt) > 0) {
				minimum = x;
			}
		}

		return minimum;
	}

	public ElementL<I> get(int index) { // ---------------------------->> Gibt Wert an bestimmtem Index
		ElementL<I> temp = null;
		temp = head;
		int count = 0;
		if (index > length()) {
			return null;
		}
		for (int x = 0; x < length(); x++) {
			if (x == index) {
				return temp;
			}
			temp = temp.next;
		}

		return temp;
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
		l.insert(99);
		ElementL<Integer> neun = l.insert(new Integer(9));
		l.insert(3);
		l.insert(45);
		l.insert(12);
		l.insert(4);
		l.insert(97);
		l.insert(10);
		//System.out.println(l);
		l.insert(5, neun); // nach eins einf�gen
		//System.out.println(l);
		l.remove(neun); // Nachfolger von eins l�schen
		System.out.println(l);

		/*int test = l.find1(97);
		if (test > -1) {
			System.out.println("Der Wert liegt an folgender Stelle: " + test);
		} else {
			System.out.println("Nicht verfügbar!");
		}*/

		l.sort3();
		System.out.println(l);

		//l.versetzeElement(0, 6);
		//System.out.println(l);

	}

}
