package observer;

public class Message {
    private final String messageContent;

    public Message(String messageContent){
        this.messageContent =  messageContent;
    }

    public String getMessageContent(){
        return this.messageContent;
    }
}
