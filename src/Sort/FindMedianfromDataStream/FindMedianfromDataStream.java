import java.util.*;

class MedianFinder {
    Queue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b - a);
    Queue<Integer> minHeap = new PriorityQueue<>();
    int size = 0;

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        size++;
        // Add element onto the correct heap
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }

        // balance the heaps
        if (minHeap.size() + 1 < maxHeap.size()) {
            Integer element = maxHeap.poll();
            minHeap.add(element);
        }else if(maxHeap.size() < minHeap.size()){
            Integer element = minHeap.poll();
            maxHeap.add(element);
        }
    }

    public double findMedian() {
        //Odd size
        if(size % 2 != 0) return (double) maxHeap.peek();
        //Even size
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */
