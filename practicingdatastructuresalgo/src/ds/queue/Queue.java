package ds.queue;

public class Queue {
    private long[] queueArray;
    private int maxSize;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int maxSize) {
        super();
        this.maxSize = maxSize;
        this.queueArray = new long[maxSize];
        this.front=0;
        this.rear=-1;
        this.nItems=0;
    }

    public boolean isEmpty(){
        return this.nItems==0;
    }

    public boolean isFull(){
        return this.nItems == maxSize;
    }

    public void insert(long value){
        if (isFull()){
            System.out.println("Queue is full...");
        }else{
            if (rear == maxSize-1) rear = -1;
            this.queueArray[++rear] = value;
            this.nItems++;
        }
    }

    public long remove(){
        if (isEmpty()){
            System.out.println("Queue is empty...");
            return 0;
        }else {
            long temp = this.queueArray[front];
            if (front == maxSize-1) front=0;
            else ++front;
            nItems--;
            return temp;
        }
    }

    public void view(){
        int index = front;
        System.out.print("[ ");
        while(index!=rear){
            System.out.print(queueArray[index]);
            System.out.print(" ");
            if (index==maxSize-1) index=0;
            else index++;
        }
        System.out.print(queueArray[index]);
        System.out.print(" ");
        System.out.print("]");
    }
}
