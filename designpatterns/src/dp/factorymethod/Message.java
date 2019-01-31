package dp.factorymethod;

public abstract class Message {

    public abstract String getContent();

    public void addDefaultHeader(){
        //Adds default header.
    }

    public void encrypt(){
        //Encrypt the message.
    }

}
