package task;

import java.util.List;

public class MainMess {
    public static void main(String[] args) {
        List<Message> workble = MessageGenerator.generate(17
        );
        System.out.println(workble);
//        MessageTask.removeOther(workble,MessagePriority.LOW);
//        MessageTask.countEachPriority(workble);
//        MessageTask.countEachCode(workble);
        MessageTask.uniqueMessageCount(workble);
//        MessageTask.removeEach(workble,MessagePriority.LOW);
        MessageTask.uniqueMessagesInOriginalOrder(workble);

//        MessageTask.uniqueMessagesInOriginalOrder(workble); // пока не доделано
//        for (int i =0; i < 10; i++ )


    }
}
