import java.util.ArrayList;

public class CircularQueueUsingArrayList {
    /**
     * Declare variables for size, front index and rear index.
     */
    private int size, front, rear;

    /**
     * Declare array list for queue.
     */
    private ArrayList<Integer> queue = new ArrayList<>();

    public CircularQueueUsingArrayList(int size) {
        this.size = size;
        this.front = this.rear = -1;
    }

    /**
     * Check if queue is full or not.
     *
     * @return true if queue is full.
     */
    public boolean isFull() {
        return (front == 0 && rear == size - 1) || ((rear == (front - 1) % (size - 1)));
    }

    /**
     * Check if queue is empty or not.
     *
     * @return true if queue is empty.
     */
    public boolean isEmpty() {
        return front == -1;
    }


    /**
     * Method to insert a new element to the end of the queue.
     *
     * @param data new data needed to be inserted
     */
    public void enQueue(int data) {
        // if queue is full
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }

        // if queue is empty
        else if (front == -1) {
            front = 0;
            rear = 0;
            queue.add(rear, data);
        }

        // otherwise
        else {
            rear++;
            if (front <= rear) {
                queue.add(rear, data);
            }
        }
    }

    /**
     * Remove the queue from the front.
     *
     * @return the element at the front of the queue.
     */
    public int dequeue() {
        int temp;
        // if the queue is empty
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        temp = queue.get(front);

        // if there is only one element
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        // if front is at the end of queue
        else if (front == size - 1) {
            front = 0;
        } else {
            front++;
        }
        return temp;
    }

    /**
     * Display the queue.
     */
    public void displayQueue() {
        // if the queue is empty
        if (front == -1) {
            System.out.println("Queue is empty!");
            return;
        }

        if (rear >= front) {
            for (int i = front; i <= rear; i++) {
                System.out.println(queue.get(i));
            }
        }

        // if rear crossed the max index and indexing started in loop
        else {
            // print elements at indexes from front to size-1
            for (int i = front; i < size; i++) {
                System.out.println(queue.get(i));
            }

            // print elements at indexes from 0 to rear
            for (int i = 0; i <= rear; i++) {
                System.out.println(queue.get(i));
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 7; i++) {
            System.out.println(i);
        }
    }


}
