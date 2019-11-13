package task;

import java.util.List;

public class MainMess {
    public static void main(String[] args) {
        List<Message> workble = MessageGenerator.generate(22);
        System.out.println(workble);
        MessageTask.countEachPriority(workble);
        MessageTask.countEachCode(workble);
        MessageTask.uniqueMessageCount(workble);
//        MessageTask.uniqueMessagesInOriginalOrder(workble);  пока не доделано


    }
}
