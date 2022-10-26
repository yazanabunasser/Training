import java.lang.invoke.LambdaConversionException;

public class CircularLinkedList {
    Node head;
    Node tail;
    int size = 1;

    static class Node {

        int data;
       Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    public static CircularLinkedList insert(CircularLinkedList list, int data) {

        Node new_node = new Node(data);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
            list.head.next = list.head;
            list.size ++;
        }
        else {

            Node last = list.head;
            while (last.next != list.head) {
                last = last.next;
            }

            last.next = new_node;
            new_node.next = list.head;
            list.size ++;
        }

        return list;
    }

    public static void printList(CircularLinkedList list)
    {

        int i = 1;
        Node currNode = list.head;

        System.out.print("\nLinkedList: ");

        while (currNode != null && i < list.size) {
            System.out.print(currNode.data + " ");

            currNode = currNode.next;
            i++;
        }
        System.out.println("\n");
        System.out.println(list.size- 1  + " Size of list \n");
    }


    public static CircularLinkedList deleteCircularByKey(CircularLinkedList list, int key) {


       Node currNode = list.head, prev= null;


        if (currNode != null && currNode.data == key) {
            list.head = currNode.next;
            list.head.next = currNode.next.next;
            currNode = null;
            System.out.println(key + " found and deleted11");
            list.size--;
            return list;
        }

        while (currNode != null && currNode.data != key) {

            prev = currNode;
            currNode = currNode.next;
        }

        if (currNode != null) {

            prev.next = currNode.next;

            System.out.println(key + " found and deleted");
        }

        if (currNode == null) {
            System.out.println(key + " not found");
        }
        Node temp = list.head;
        while (temp.next != null ){
            temp = temp.next;
        }


        return list;
    }
    public static void reverse(CircularLinkedList list)
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
        list.head = prev.next;
    }
    public static int midOfCircularlist(CircularLinkedList list){
        int mid = 0;
        int num = (list.size-1) / 2;
        if(list.size % 2 ==0){
            mid = num + 1;
        }else{
            mid = num;
        }
        return mid;
    }
    public static void printMiddleOfCircular(CircularLinkedList list)
    {
        if (list.head != null) {
            Node temp = list.head;

            int middleLength = midOfCircularlist(list) -1;
            while (middleLength != 0) {
                temp = temp.next;
                middleLength--;
            }
            System.out.print("The middle element is ["
                    + temp.data + "]");
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        CircularLinkedList list = new CircularLinkedList();

        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 44);
        list = insert(list, 55);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);
        list = insert(list, 9);
        list = insert(list, 912);


        printList(list);
        reverse(list);
        printList(list);
        printMiddleOfCircular(list);

//        reverse(list);
//        printList(list);
//        printMiddle(list);
    }


}




