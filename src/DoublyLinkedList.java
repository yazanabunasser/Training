public class DoublyLinkedList {

    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    int size = 1;

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
        System.out.println("\n" + list.size + " size of list");
        System.out.println("");


        return list;
    }
    public static DoublyLinkedList deleteByKey(DoublyLinkedList list , int key){
        Node currNode = list.head, temp = null;

        if (currNode != null && currNode.data == key){
            list.head = currNode.next;
            list.head.next = currNode.next.next;
            currNode = null;
            list.head.prev = null;
            System.out.println(key + " found and deleted11");
            list.size--;
            return list;
        }
        while (currNode != null && currNode.data != key){

            currNode = list.head.next;
            currNode.prev = list.head;
        }
        if (currNode != null){
            temp = currNode.next;
            list.head.next = temp;
            temp.prev = list.head;
            System.out.println(key + " found and deleted2");
            list.size--;

        }
        if (currNode == null) {
            System.out.println(key + " not found");
        }

        return list;
    }
    public static int midOfDoublelist(DoublyLinkedList list){
        int mid = 0;
        int num = (list.size-1) / 2;
        if(list.size % 2 ==0){
            mid = num + 1;
        }else{
            mid = num;
        }
        return mid;
    }
    public static void reverse(DoublyLinkedList list)
    {
        Node prev = null;
        Node current = list.head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        list.head = prev;
    }
    public static void printMiddleDouble(DoublyLinkedList list)
    {
        if (list.head != null) {
            Node temp = list.head;

            int middleLength = midOfDoublelist(list) ;
            while (middleLength != 0) {
                temp = temp.next;
                middleLength--;
            }
            System.out.print("The middle element is ["
                    + temp.data + "]");
            System.out.println();
        }
    }




    public static void main(String[] args){
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(list , 1);
        list.insert(list , 33);
        list.insert(list , 2);
        list.insert(list , 42);
        list.insert(list , 7);
        list.insert(list , 99);

        list.printList(list);

       deleteByKey(list, 33);
       list.printList(list);

        reverse(list);
        list.printList(list);
        printMiddleDouble(list);



    }


}
