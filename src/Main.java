public class Main {
    public static void main(String[] args) {

        System.out.println("Testing MyArrayList:");
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.addFirst(5);
        arrayList.addLast(40);

        System.out.println("ArrayList size: " + arrayList.size());
        System.out.println("First element: " + arrayList.getFirst());
        System.out.println("Last element: " + arrayList.getLast());
        System.out.println("Element at index 2: " + arrayList.get(2));

        arrayList.remove(2);
        System.out.println("After removal, element at index 2: " + arrayList.get(2));

        arrayList.set(1, 25);
        System.out.println("After set, element at index 1: " + arrayList.get(1));


        System.out.println("\nTesting MyLinkedList:");
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(10);
        linkedList.addFirst(5);
        linkedList.addLast(20);
        linkedList.add(1, 15);

        System.out.println("LinkedList size: " + linkedList.size());
        System.out.println("First element: " + linkedList.getFirst());
        System.out.println("Last element: " + linkedList.getLast());
        System.out.println("Element at index 2: " + linkedList.get(2));

        linkedList.remove(1);
        System.out.println("After removal, element at index 1: " + linkedList.get(1));


        System.out.println("\nIterating over LinkedList:");
        for (Integer num : linkedList) {
            System.out.println(num);
        }

        System.out.println("Index of 15 in LinkedList: " + linkedList.indexOf(15));
        System.out.println("Index of 10 in LinkedList: " + linkedList.indexOf(10));
    }

}