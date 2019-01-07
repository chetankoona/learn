package ds.binarysearchtree;

public class BinarySearchTree {

    private Node root;

    public Boolean isExists(int key) {
        Node current = root;
        while (current != null) {
            if (key == current.key) {
                return true;
            } else {
                if (key < current.key) {
                    current = current.leftChild;
                } else {
                    current = current.rightChild;
                }
            }
        }
        return false;
    }

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
        Node parent = root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.key == key) {
                deleteLogic(current, parent, isLeftChild);
                System.out.println("Key " + key + " deleted from tree.");
                return;
            } else {
                parent = current;
                if (key < current.key) {
                    isLeftChild = true;
                    current = current.leftChild;
                } else {
                    isLeftChild = false;
                    current = current.rightChild;
                }
            }
        }
        System.out.println("Key " + key + " does not exist in tree.");
    }

    private void deleteLogic(Node nodeToDelete, Node parent, boolean isLeftChild) {
        /*
        Three steps
        1. removing the leaf node, node with no children.
        2. removing node with one children.
        3. removing node with two children.
        */
        if (nodeToDelete.leftChild == null || nodeToDelete.rightChild == null) {
            Node joinNode = null;
            if (nodeToDelete.leftChild != null) {
                joinNode = nodeToDelete.leftChild;
            } else if (nodeToDelete.rightChild != null) {
                joinNode = nodeToDelete.rightChild;
            }
            if (nodeToDelete == root) {
                root = joinNode;
            } else if (isLeftChild) {
                parent.leftChild = joinNode;
            } else {
                parent.rightChild = joinNode;
            }
        } else {
            Node successor = detachAndGetSuccessorNode(nodeToDelete.rightChild, nodeToDelete);
            if (nodeToDelete == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.rightChild = nodeToDelete.rightChild;
            successor.leftChild = nodeToDelete.leftChild;
        }
    }

    private Node detachAndGetSuccessorNode(Node fromNode, Node successorParent) {
        Node current = fromNode;
        Node successor = successorParent;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != fromNode) {
            successorParent.leftChild = successor.rightChild;
        }
        return successor;
    }

}
