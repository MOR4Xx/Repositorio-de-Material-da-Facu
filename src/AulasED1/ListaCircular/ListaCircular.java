package AulasED1.ListaCircular;

class ListaCircular {
    private Node head = null;
    private Node tail = null;

    // Add a new node to the list
    public void addNode(int value ){
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
        tail.nextNode = head;
    }

    // Search for a value in the list
    public boolean containsNode(int searchValue) {
        Node currentNode = head;

        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.value == searchValue) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            return false;
        }
    }

    // Delete a value from the list
    public void deleteNode(int valueToDelete) {
        Node currentNode = head;
        Node previousNode = null;

        if (head == null) {
            return;
        }

        do {
            if (currentNode.value == valueToDelete) {
                if (tail == head) { // the list has only one single element
                    head = null;
                    tail = null;
                } else if (head == currentNode) { // we're deleting the head
                    head = head.nextNode;
                } else if (tail == currentNode) { // we're deleting the tail
                    tail = previousNode;
                    tail.nextNode = head;
                } else {
                    previousNode.nextNode = currentNode.nextNode;
                }
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        } while (currentNode != head);
    }

    // Traverse the list
    public void traverseList() {
        Node currentNode = head;

        if (head != null) {
            do {
                System.out.println(currentNode.value + " ");
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
        }
    }
}