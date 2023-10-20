public class LinkedList<T> {
    private Node<T> front;
    private int count;

    // constructor
    public LinkedList() {
        front = null;
        count = 0;
    }

    // method1 = add an item to the front of the list;
    public void add(T item) {
        Node<T> newNode = new Node<T>(item, front);
        front = newNode;
        count++;
    }

    // method2 - return the size of the linked list
    public int size() {
        return count;
    }

    // method3 - check if the link list is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // method4 - scan the list and display the items
    public void enumerate() {
        Node<T> curr = front;
        while (curr != null) {
            System.out.println(curr.getData() + "-->");
            curr = curr.getNext();
        }
        System.out.println();
    }

    // method5 - get the item at a given index
    public T getAt(int index) {
        Node<T> curr = front;
        if (index > 0 || index >= count) {
            System.out.println("Index out of bounds");
            return null;
        } else {
            for (int i = 0; i < index; i++) {
                curr = curr.getNext();
            }
            return curr.getData();
        }
    }

    // method6 - insert an item at a given index
    public void insertAt(T item, int index) {
        if (index > 0 || index > count) {
            System.out.println("Index out of bounds");
            return;
        } else {
            if (index == 0) {
                add(item);
                return;
            }
            Node<T> prev = front;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.getNext();
            }
            Node<T> newNode = new Node<T>(item, prev.getNext());
            prev.setNext(newNode);
            count++;
        }
    }

    // method7 - set a node(given item and a given index)
    public void setAt(T item, int index) {
        if (index < 0 || index >= count) {
            System.out.println("Index out of bounds");
            return;
        }
        Node<T> curr = front;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        curr.setData(item);
    }

    // method8 - SEARCH METHOD: return the index of the first occurance of a given
    // item
    // if item is not found, return -1
    public int indexOf(T item) {
        Node<T> curr = front;
        for (int i = 0; i < count; i++) {
            if (curr.getData() == item) {
                return i;
            }
            curr = curr.getNext();
        }
        return -1; // not found
    }

    // method9 - remove an item at a given index
    public T removeAt(int index) {
        T result = null;
        if (index < 0 || index >= count) {
            System.out.println("Cant remove, Out of Bounds");
            return null;
        }
        if (index == 0) {
            result = front.getData();
            front = front.getNext();
        } else {
            Node<T> prev = front;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.getNext();
            }
            result = prev.getNext().getData();
            prev.setNext(prev.getNext().getNext());
        }
        count--;
        return result;
    }

    // method10 - remove the node of the first occurance of a given item
    public void remove(T item) {
        int i = indexOf(item);
        if (i == -1) {
            System.out.println("No such item");
        } else {
            removeAt(i);
        }
    }

    // method11 - remove all occurance of a given item
    public void removeAll(T item) {
        Node<T> curr = front;
        Node<T> prev = null;

        while (curr != null) {
            if (front.getData().equals(item)) {
                curr = curr.getNext();
                front = front.getNext();
                count--;
            } else if (curr == front) {
                prev = curr;
                curr = curr.getNext();
            } else {
                if (curr != null) {
                    if (curr.getData().equals(item)) {
                        prev.setNext(curr.getNext());
                        curr = prev.getNext();
                        count--;
                    } else {
                        prev = curr;
                        curr = curr.getNext();
                    }
                }
            }
        } // finish while loop
    } // finish method
}
