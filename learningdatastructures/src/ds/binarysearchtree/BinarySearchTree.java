package ds.binarysearchtree;

public class BinarySearchTree {

    private Node root;

    public void insert(int key, String value) {
        Node newNode = new Node(key, value);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if (key < current.key) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node findMinNode() {
        Node current = root;
        Node minNode = null;

        while (current != null) {
            minNode = current;
            current = current.leftChild;
        }
        return minNode;
    }

    public Node findMaxNode() {
        Node current = root;
        Node maxNode = null;

        while (current != null) {
            maxNode = current;
            current = current.rightChild;
        }
        return maxNode;
    }

    public void deleteNode(int key) {
        Node current = root;
        Node parent = null;
        while (current != null) {
            if (current.key == key) {
                deleteLogic(current, parent);
                System.out.println("Key " + key + " deleted from tree.");
                return;
            } else {
                parent = current;
                if (key < current.key) {
                    current = current.leftChild;
                } else {
                    current = current.rightChild;
                }
            }
        }
        System.out.println("Key " + key + " does not exist in tree.");
    }

    private void deleteLogic(Node deleteNode, Node parent) {
        /*
        Three steps
        1. removing the leaf node, node with no children.
        2. removing node with one children.
        3. removing node with two children.
        */
        if (deleteNode.leftChild == null || deleteNode.rightChild == null) {
            Node joinNode = null;
            if (deleteNode.leftChild != null) {
                joinNode = deleteNode.leftChild;
            } else if (deleteNode.rightChild != null) {
                joinNode = deleteNode.rightChild;
            }
            if (parent.leftChild != null && deleteNode.key == parent.leftChild.key) {
                parent.leftChild = joinNode;
            } else {
                parent.rightChild = joinNode;
            }
        } else {
            Node jumpNode = detachAndGetJumpNode(deleteNode.rightChild, deleteNode);
            if (parent.leftChild != null && deleteNode.key == parent.leftChild.key) {
                parent.leftChild = jumpNode;
            } else {
                parent.rightChild = jumpNode;
            }
            jumpNode.rightChild = deleteNode.rightChild;
            jumpNode.leftChild = deleteNode.leftChild;
        }
    }

    public Node detachAndGetJumpNode(Node fromNode, Node parent) {
        Node current = fromNode;
        Node jumpNode = parent;

        while (current != null) {
            parent = jumpNode;
            jumpNode = current;
            current = current.leftChild;
        }
        parent.leftChild = null;
        return jumpNode;
    }

}
