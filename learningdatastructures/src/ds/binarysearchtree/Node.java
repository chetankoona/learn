package ds.binarysearchtree;

public class Node {

    int key;
    String value;
    Node leftChild, rightChild;

    public Node(int key, String value) {
        super();
        this.key = key;
        this.value = value;
    }

    public String toString(){
        return "KEY=" + this.key + " VALUE=" + this.value;
    }
}
