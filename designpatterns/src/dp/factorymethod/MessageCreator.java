package dp.factorymethod;

public abstract class MessageCreator {
    public Message getMessage(){
        Message msg = createMessage();
        msg.addDefaultHeader();
        msg.encrypt();
        return msg;
    }

    /**
     * Factory Method
     */
    protected abstract Message createMessage();
}
