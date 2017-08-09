public class ListeL<I extends Comparable<I>> {

  static class ElementL<K> {
    private K inhalt;           // Inhalt des Listenelements
    private ElementL<K> next;   // Verweis auf den Nachfolger
    public ElementL (K o) {
      inhalt = o;
      next = null;
    }
  }
  
  private ElementL<I> head;       // Referenz auf den Anfang der Liste
  
  public ListeL () {
    head = null;
  }

  public ListeL (I o) {
    head = new ElementL<I>(o);
  }
  
  public ElementL<I> insert (I o) {   // am Anfang einfügen
    ElementL<I> newEl = new ElementL<I>(o);
    if (head == null) { // Liste ist noch leer
      head = newEl;
    }
    else {
      newEl.next = head;
      head = newEl;
    }
    return newEl;
  }

  public ElementL<I> insert (I o, ElementL<I> pred) { // nach pred (Vorgänger) einfügen
    ElementL<I> newEl = new ElementL<I>(o);
    if (pred == null) { // am Anfang einfügen
      newEl.next = head;
      head = newEl;
    }
    else {  // nach pred (Vorgänger) einfügen
      newEl.next = pred.next;
      pred.next = newEl;
    }
    return newEl;
  }
  
  public void remove (ElementL<I> pred) {  // Element nach pred (Vorgänger) löschen
    if (pred == null) // erstes Element löschen
      head = head.next;
    else if (pred.next != null)  // Element nach pred (Vorgänger) löschen
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
  
  public static void main (String[] args) {
    ListeL<Integer> l = new ListeL<Integer>();
    l.insert(0);
    ElementL<Integer> eins = l.insert(new Integer(1));
    l.insert(3);
    System.out.println(l);
    l.insert(2, eins);  // nach eins einfügen
    System.out.println(l);
    l.remove(eins);  // Nachfolger von eins löschen
    System.out.println(l);
  }
  
}
