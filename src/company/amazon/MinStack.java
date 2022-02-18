package company.amazon;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 */
public class MinStack {
    class Node {
        int data;
        int min;
        Node next;

        public Node(int data, int min) {
            this.data = data;
            this.min = min;
            this.next = null;
        }
    }

    Node head;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(head == null) {
            head = new Node(x, x);
        } else {
            Node newNode = new Node(x, Math.min(x, head.min));
            newNode.next = head;
            head = newNode;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.data;
    }

    public int getMin() {
        return head.min;
    }
}
