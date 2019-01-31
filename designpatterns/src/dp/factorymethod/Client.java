package dp.factorymethod;

/**
 * Examples for factory method pattern, java.util.Collection has iterator method.
 */
public class Client {
    public static void main(String[] args) {
        printMessage(new JsonMessageCreator());
        printMessage(new TextMessageCreator());
    }

    private static void printMessage(MessageCreator creator) {
        Message msg = creator.getMessage();
        System.out.println(msg);
    }
}
