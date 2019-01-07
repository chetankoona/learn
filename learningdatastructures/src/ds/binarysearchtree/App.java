package ds.binarysearchtree;

public class App {

    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(30,"THIRTY");
        bst.insert(2,"TWO");
        bst.insert(1,"ONE");
        bst.insert(20,"TWENTY");
        bst.insert(40,"FORTY");
        bst.insert(38,"THIRTY EIGHT");
        bst.insert(50,"FIFTY");
        bst.insert(35,"THIRTY FIVE");
        bst.insert(39,"THIRTY NINE");
        bst.insert(45,"FORTY FIVE");
        bst.insert(60,"SIXTY");
        bst.insert(43,"FORTY THREE");
        bst.insert(48,"FORTY EIGHT");
        bst.insert(70,"SEVENTY");
        bst.insert(65,"SIXTY FIVE");
        bst.insert(75,"SEVENTY FIVE");
        bst.insert(41,"FORTY ONE");
        bst.insert(44,"FORTY FOUR");
        bst.insert(49,"FORTY NINE");

        System.out.println("Min value in tree = "+bst.findMinNode().toString());
        System.out.println("Max value in tree = "+bst.findMaxNode().toString());

        int deleteKey=30;
        bst.deleteNode(deleteKey);
        String result = bst.isExists(deleteKey)?"Exists":"Not found";
        System.out.println("Key "+deleteKey+" "+result);
    }

}
