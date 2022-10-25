public class DoublyLinkedList {

    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    int size = 0;

    Node head = null;
    Node tail = null;

    public DoublyLinkedList insert(DoublyLinkedList list, int data) {
        Node new_node = new Node(data);
        if (list.head == null) {
            list.head = new_node;
            list.tail = new_node;
            list.head.prev = null;
            list.tail.next = null;
        } else {
            list.tail.next = new_node;
            new_node.prev = tail;
            list.tail = new_node;
            list.tail.next = null;
            list.size++;
        }
        return list;
    }

    public static DoublyLinkedList printList(DoublyLinkedList list) {
        Node current = list.head;

        if (list.head == null) {
            System.out.println("List is empty");

        }
        System.out.println("Doubly linked list: ");

        while (current != null) {

            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");


        return list;
    }


    public static void main(String[] args){
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(list , 1);
        list.insert(list , 33);
        list.insert(list , 2);
        list.insert(list , 42);
        list.insert(list , 2);

        list.printList(list);
        System.out.println(list.size);

        list.printList(list);
    }


}
