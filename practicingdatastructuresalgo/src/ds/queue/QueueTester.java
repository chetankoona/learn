package ds.queue;

public class QueueTester {

    public static void main(String[] args) {
        Queue myQue = new Queue(5);
        myQue.insert(10);
        myQue.insert(20);
        myQue.insert(30);
        myQue.insert(40);
        myQue.remove();
        myQue.remove();
        myQue.insert(50);
        myQue.insert(60);
        myQue.insert(70);
        myQue.insert(99);

        myQue.view();
    }

}
