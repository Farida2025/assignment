public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(10);
        list.addFirst(5);
        list.addLast(20);

        for (Integer num : list) {
            System.out.println(num);
        }


        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
    }
}