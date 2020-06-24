package ds.heap;

public class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.heapArray = new Node[maxSize];
    }

    public boolean insert(int value){
        if(isFull()){
            System.out.println("Heap is full...");
            return false;
        }else {
            Node newNode = new Node(value);
            heapArray[currentSize++] = newNode;
            trickleUp();
            return true;
        }
    }

    private void trickleUp() {
        int child=currentSize-1;
        int parent=getParentIndex(child);
        while (parent>0 && heapArray[child].getKey()>heapArray[parent].getKey()){
            swap(child,parent);
            child = parent;
            parent = getParentIndex(child);
        }
    }

    public Node remove(){
        if (isEmpty()){
            System.out.println("Heap is empty nothing to remove...");
            return null;
        }else {
            Node removedNode = heapArray[0];
            heapArray[0] = heapArray[--currentSize];
            heapArray[currentSize] = null;
            trickleDown();
            return removedNode;
        }
    }

    private void trickleDown() {
        int parent = 0;
        int leftChild = getLeftChild(parent);
        int rightChild = getRightChild(parent);
        int child = getLargerChild(leftChild, rightChild);
        while (leftChild<currentSize && heapArray[parent].getKey()<heapArray[child].getKey()){
            swap(child,parent);
            parent = child;
            leftChild = getLeftChild(parent);
            rightChild = getRightChild(parent);
            if (leftChild<currentSize) child= getLargerChild(leftChild, rightChild);
        }
    }

    private int getLargerChild(int leftChild, int rightChild) {
        return heapArray[leftChild].getKey() > heapArray[rightChild].getKey() ? leftChild : rightChild;
    }

    private int getRightChild(int parent) {
        return 2*parent+2;
    }

    private int getLeftChild(int parent) {
        return 2*parent+1;
    }

    private void swap(int child, int parent) {
        Node temp = heapArray[child];
        heapArray[child] = heapArray[parent];
        heapArray[parent] = temp;
    }

    private int getParentIndex(int child) {
        return (child-1)/2;
    }

    private boolean isFull() {
        return currentSize==maxSize;
    }
    private boolean isEmpty() {
        return currentSize==0;
    }

    public void displayHeap(){
        //TODO implement printing heap
    }
}
