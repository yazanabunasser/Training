

public class LinkedList {
    Node head;
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

    public static LinkedList insert(LinkedList list,
                                    int data)
    {

        Node new_node = new Node(data);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
            list.size ++;
        }
        else {

            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
            list.size ++;
        }

        return list;
    }

    public static void printList(LinkedList list)
    {

        Node currNode = list.head;

        System.out.print("\nLinkedList: ");

        while (currNode != null) {
            System.out.print(currNode.data + " ");

            currNode = currNode.next;
        }
        System.out.println("\n");
        System.out.println(list.size- 1  + " Size of list \n");
    }

    public static LinkedList deleteByKey(LinkedList list,
                                         int key)
    {
        Node currNode = list.head, prev = null;


        if (currNode != null && currNode.data == key) {
            list.head = currNode.next;

            System.out.println(key + " found and deleted");

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

        return list;
    }

    public static LinkedList
    deleteAtPosition(LinkedList list, int index)
    {
        Node currNode = list.head, prev = null;

        if (index == 0 && currNode != null) {
            list.head = currNode.next;

            System.out.println(
                    index + " position element deleted");


            return list;
        }

        int counter = 0;

        while (currNode != null) {

            if (counter == index) {

                prev.next = currNode.next;

                System.out.println(
                        index + " position element deleted");
                break;
            }
            else {

                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        if (currNode == null) {
            System.out.println(
                    index + " position element not found");
        }

        return list;
    }
    public static void printMiddle(LinkedList list)
    {
        if (list.head != null) {
            Node temp = list.head;

            int middleLength = midOflist(list) -1;
            while (middleLength != 0) {
                temp = temp.next;
                middleLength--;
            }
            System.out.print("The middle element is ["
                    + temp.data + "]");
            System.out.println();
        }
    }

    public static void reverse(LinkedList list)
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
    public static int midOflist(LinkedList list){
        int mid = 0;
        int num = (list.size-1) / 2;
        if(list.size % 2 ==0){
            mid = num + 1;
        }else{
             mid = num;
        }
        return mid;
    }

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();

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
        printMiddle(list);
    }



//        deleteByKey(list, 1);
//
//        printList(list);
//
//        deleteByKey(list, 4);
//
//        printList(list);
//
//        deleteByKey(list, 10);
//
//        printList(list);
//
//        deleteAtPosition(list, 0);
//
//        printList(list);
//
//        deleteAtPosition(list, 2);
//
//        printList(list);
//
//        deleteAtPosition(list, 10);
//
//        printList(list);
    }

