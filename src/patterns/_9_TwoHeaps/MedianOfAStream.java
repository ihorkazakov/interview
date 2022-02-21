package patterns._9_TwoHeaps;

import java.util.PriorityQueue;

/**
 * Design a class to calculate the median of a number stream. The class
 * should have the following two methods:
 * 1. insertNum(int num) : stores the number in the class
 *
 * 2. findMedian() : returns the median of all numbers inserted in the class
 */
public class MedianOfAStream {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianOfAStream() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void insertNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }

        return maxHeap.peek();
    }
}
