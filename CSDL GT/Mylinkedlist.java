public class Mylinkedlist {

    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public static void printLinklist(Node head) {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value); // gia tri cua node hien tai
                temp = temp.next; // thao tac con tro next cua node temp tro toi phan tu tiep theo
                if (temp != null) {
                    System.out.print("->");
                } else {
                    System.out.println();
                }
            }
        }
    }

    public static Node addToHead(Node headNode, int value) {
        Node newNode = new Node(value);
        if (headNode != null) {
            newNode.next = headNode;
        }
        return newNode;

    }

    public static Node addToTail(Node headNode, int value) {
        Node newNode = new Node(value);
        if (headNode == null) {
            return newNode;

        } else {
            // Di xac dinh last node
            Node lastNode = headNode;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            // Gan next cho last node= new node
            lastNode.next = newNode;
        }
        return headNode;

    }

    public static Node addToIndex(Node headNode, int value, int index) {
        if (index == 0) {
            return addToHead(headNode, value);
        } else {
            // Tim vi tri can them
            Node newNode = new Node(value);
            Node curNode = headNode;
            int count = 0;
            while (curNode != null) {
                count++;
                if (count == index) {
                    // thuc hien add
                    newNode.next = curNode.next;
                    curNode.next = newNode;
                    break;
                }
            }
        }
        return headNode;

    }

    public static Node removeAtHead(Node headNode) {
        if (headNode != null) {
            return headNode.next;
        }
        return headNode;
    }

    public static Node removeAtTail(Node headNode) {
        if (headNode == null)
            return null;

        // xac dinh last va previous
        Node lastNode = headNode;
        Node preNode = null;
        while (lastNode.next != null) { // neu nhu last node la nut cuoi cung thi lastnode.next= null
            preNode = lastNode;
            lastNode = lastNode.next;
        }
        // Next cua preNode tro toi null
        if (preNode == null) {
            return null;
        } else {
            preNode.next = lastNode.next;
        }
        return headNode;
    }

    public static Node removeAtIndex(Node headNode, int index) {
        if (headNode == null || index < 0)
            return null;
        if (index == 0)
            return removeAtHead(headNode);

        Node currNode = headNode;
        Node preNode = null;
        int count = 0;
        boolean bIsFound = false;
        while (currNode != null) {
            if (count == index) {
                // REmove currNode
                bIsFound = false;
                break;
            }
            preNode = currNode;
            currNode = currNode.next;
            count++;
        }
        // Remove curr
        if (bIsFound) {
            if (preNode == null) { // currNode is Last Node
                return null;
            } else {
                if (currNode != null) {
                    preNode.next = currNode.next;
                }
            }
        }
        return headNode;
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.next = n3;

        printLinklist(n1);
        // printLinklist(n2);
        // printLinklist(n3);

        // n1= addToHead(n1, 0);
        // printLinklist(n1);

        // n1= addToTail(n1, 0);
        // printLinklist(n1);

        // n1= addToIndex(n1, 0, 0);
        // printLinklist(n1);
        // n1= addToIndex(n1, 4, 0);
        // printLinklist(n1);
        // n1= addToIndex(n1, 1, 1);
        // printLinklist(n1);

        // n1= removeAtHead(n1);
        // printLinklist(n1);

        n1 = removeAtTail(n1);
        printLinklist(n1);

        // n1= removeAtIndex(n1, 0);
        // printLinklist(n1);
        // n1= removeAtIndex(n1, 1);
        // printLinklist(n1);

    }
}