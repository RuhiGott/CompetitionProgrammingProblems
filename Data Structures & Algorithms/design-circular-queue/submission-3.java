class MyCircularQueue {

    private int[] arr;
    private int k;
    private int size;

    private int front;
    private int rear;

    public MyCircularQueue(int k) {
        arr = new int[k];
        this.k = k;
        size = 0;

        front = 0;
        rear = -1;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        
        rear = (rear + 1) % k;

        arr[rear] = value;

        size++;

        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        size--;

        front = (front+ 1) % k;

        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return arr[front];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return arr[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == k;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */