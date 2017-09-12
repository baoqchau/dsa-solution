/**
 * Created by bao on 9/8/17.
 * adding 2 big numbers using linked list
 */
public class AddTwoBigNumLinkedList {

    static int carry;
    static Node cur, result;

    static class Node {
        int data;
        Node next;
    }

    static Node createLinkedList(int[] a){
        Node head = new Node();
        Node result = head;
        head.data = a[0];
        for (int i=1; i< a.length; i++){
           Node newNode = new Node();
           newNode.data =a[i];
           head.next = newNode;
           head = newNode;
        }
        return result;
    }

    static int getSize(Node head){
        int result = 0;
        Node temp = head;
        while (temp != null){
            result++;
            temp = temp.next;
        }
        return result;
    }

    static void pushNode(int value) {
        Node newNode = new Node();
        newNode.data = value;
        newNode.next = result;
        result = newNode;
    }

    static void addTwoEqualNum(Node head1, Node head2) {
        if (head1 == null)
            return;
        addTwoEqualNum(head1.next, head2.next);
        int sum = head1.data + head2.data + carry;
        carry = sum / 10;
        sum = sum % 10;
        pushNode(sum);
    }

    static void printList(Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static void addRestOfBigNum(Node head1){
        if (head1 != cur) {
            addRestOfBigNum(head1.next);
            int sum = head1.data + carry;
            carry = sum / 10;
            sum = sum % 10;
            pushNode(sum);
        }
    }
    static void addTwoNum(Node head1, Node head2){
        int size1 = getSize(head1);
        int size2 = getSize(head2);
        if (size1 == size2) {
            addTwoEqualNum(head1, head2);
        }
        else {
           Node temp = new Node();
           if (size1 < size2){
               temp = head1;
               head1 = head2;
               head2 = temp;
           }
           int diff = Math.abs(size1 - size2);
           cur = head1;
           while (diff > 0){
               cur = cur.next;
               diff--;
           }
           addTwoEqualNum(cur, head2);
           addRestOfBigNum(head1);
        }
        if (carry > 0)
          pushNode(carry);
        printList(result);
    }

    public static void main(String[] args){
       int[] num1 = {5, 4, 3 ,2 ,1, 0};
       int[] num2 = {9, 6, 9};
       Node head1 = createLinkedList(num1);
       Node head2 = createLinkedList(num2);
       printList(head1);
       printList(head2);
       Node result = new Node();
       addTwoNum(head1, head2);
    }
}
