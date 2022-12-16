package dailyChalange._12_december;

import java.util.Stack;

/**
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 *
 * Implement the MyQueue class:
 *
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 *
 * Example 1:
 *
 * Input
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 *
 * Output
 * [null, null, null, 1, 1, false]
 */
public class _232_ImplementQueueUsingStacks {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public _232_ImplementQueueUsingStacks() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	/**
	 * Push element x to the back of queue.
	 */
	public void push(int x) {
		stack1.push(x);
	}

	/**
	 * Removes the element from in front of queue and returns that element.
	 */
	public int pop() {
		if (stack2.empty()) {
			while (!stack1.empty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	/**
	 * Get the front element.
	 */
	public int peek() {
		if (stack2.empty()) {
			while (!stack1.empty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}

	/**
	 * Returns whether the queue is empty.
	 */
	public boolean empty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
}
