package quene;

/**
 * @author qiweigang
 * @date 2019-12-12 16:59
 */
public class MyCircularQueue {

    private int[] content;
    private int head;
    private int tail;
    private int length;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        length = k + 1;
        content = new int[k + 1];
        head = 0;
        tail = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if ((tail + 1) % length == head) {
            return false;
        }
        content[tail] = value;
        tail = (tail + 1) % length;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (tail == head) {
            return false;
        }
        head = (head + 1) % length;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return content[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return content[(tail - 1 + length) % length];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (tail + 1) % length == head;
    }

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        boolean param_1 = obj.enQueue(1);
        boolean param_2 = obj.enQueue(2);
        boolean param_3 = obj.enQueue(3);
        boolean param_4 = obj.enQueue(4);
        int param_13 = obj.Front();
        int param_10 = obj.Rear();
        boolean param_11 = obj.deQueue();
        boolean param_12 = obj.deQueue();
        boolean param_5 = obj.deQueue();
        int param_6 = obj.Front();
        int param_7 = obj.Rear();
        boolean param_8 = obj.isEmpty();
        boolean param_9 = obj.isFull();
    }
}
