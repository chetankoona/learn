package ds.stack;

public class Stack {
    private Long[] stackArray;
    private int maxSize;
    private int top = -1;

    public Stack(int maxSize) {
        super();
        this.maxSize = maxSize;
        this.stackArray = new Long[this.maxSize];
    }

    public void push(Long value){
        if(isFull()){
            System.out.println("Stack is full...");
        }else{
            this.stackArray[++top]=value;
        }
    }

    public long pop(){
        if (isEmpty()){
            System.out.println("Stack is empty...");
            return 0;
        }else{
            return this.stackArray[top--];
        }
    }

    public long peak(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public boolean isFull(){
        return top == maxSize-1;
    }
}
