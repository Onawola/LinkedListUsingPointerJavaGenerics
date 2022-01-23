package linkedlist;

public class Main {
    public static void main(String[] args) {
        List<Integer> lst = new List<Integer>();
        lst.appendObj(4);
        Integer front = lst.front();
        System.out.println(front);
//        lst.appendObj("Kola");
//        lst.appendObj("Joel");
        lst.enlistObj(7, 2);
//        lst.enlistObj("Paul", 1);
//        lst.enlistObj("Musa", 3);
        lst.display();
//        lst.deleteObj("James");
//        lst.deleteObj("Paul");
//        lst.appendObj("Kehinde");
        lst.appendObj(120);
//        lst.appendObj(new Integer(230));
        lst.enlistObj(270, 1);
        List lst1 = new List(lst);
        System.out.println(lst1.listLength());
        System.out.println("\n\nList after some deletion and insertion:");
        lst1.display();
        System.out.println("\n\n");
    }
}
