package DoublyLinkedList;

/**
 * Created by root on 4/17/17.
 */
public class DoublyLinkedListTester {

    public static void main(String[] args){
        DoublyLinkedList list = new DoublyLinkedList();

       // System.out.println("Adding 4 items to the list...");
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);


        DoublyLinkedListIterator it = (DoublyLinkedListIterator) list.iterator();

        it.display();

        System.out.println("\nLast value traversed: " + it.next());

        System.out.println("it.remove()");
        it.remove();
        it.display();

        System.out.println("iterator.remove(1)");
        it.remove(1);
        it.display();

        System.out.println("iterator.replace(0, 'hey'):");
        it.replace(1, "Hey");
        it.display();

        System.out.println("\nLast value traversed: " + it.next());

        it.replace("2017");
        it.display();



        /**
        it = (DoublyLinkedList.DoublyLinkedListIterator) list.iterator();
         //list.show();
        System.out.println("Adding numbers 4 - 8 to the list using list.addAll()...");
        ArrayList<Integer> ints = new ArrayList<>();
        for(int i = 4; i < 9 ; i++){
            ints.add(i);
        }
        list.addAll(ints);
        list.show();



        System.out.println("\nChecking that we are at the start of this list using iterator.atStart(): " + it.atStart());

        System.out.println("Walking up the list using iterator.next()");
        for(int i = 0; i < list.size() - 1; i++){
            System.out.println("DoublyLinkedList.Node index " + it.nextIndex() + ": " + it.next());
        }

        System.out.println("\nChecking that we are at the end of the list using iterator.atEnd(): " + it.atEnd());

        System.out.println("Walking back down the list using iterator.previous()");
        for(int i = list.size() - 1; i > 0; i--){
            System.out.println("DoublyLinkedList.Node index " + it.previousIndex() + ": " + it.previous());
        }

        System.out.println("\nAdding the boolean True to the 3rd position using list.add(index, element)");
        list.add(3, true);

        System.out.println("\nSetting first element to string 'Rick and Morty'");
        list.set(0, "Rick and Morty");

        System.out.println("Printing that first item using list.get()");
        System.out.println(list.get(0));
        System.out.println("Printing that same first item using list.getFirst()");
        System.out.println(list.getFirst());



        list.display();
        list.remove(0);
        list.display();
        list.remove(0);
        list.display();

        list.remove(2);
        list.display();


**/
    }

}
