package task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        int prcount =0;
        int prcount1 =0;
        int prcount2 =0;
        int prcount3 =0;
        for (int i =0; i<messageList.size(); i++){
            switch (messageList.get(i).getPriority()){
                case LOW: {prcount++;
                break;}
                case MEDIUM: {
                    prcount1++;
                    break;
                } case HIGH:{
                    prcount2++;
                    break;
                } case URGENT:{
                    prcount3++;
                    break;
                }
            }
        }

        // TODO:  Подсчитать количество сообщений для каждого приоритела
        //  Ответ в консоль
        System.out.println("Mesages with LOW priority - " +prcount);
        System.out.println("Mesages with MEDIUM priority - " +prcount1);
        System.out.println("Mesages with HIGHT priority - " +prcount2);
        System.out.println("Mesages with Urgent priority - " +prcount3);
    }

    public static void countEachCode(List<Message> messageList) {
        Set codekeeper = new HashSet();
        for (int i = 0; i < messageList.size(); i++) {
            codekeeper.add(messageList.get(i).getCode());
        }
        ArrayList codes = new ArrayList();
        codes.addAll(codekeeper);
        System.out.println("Уникальные коды "+codes);
        for (int z = 0; z < codes.size(); z++) {
            int quant = 0;
            for (int i = 0; i < messageList.size(); i++) {
                if (messageList.get(i).getCode() == (int) codes.get(z)) {
                    quant++;
                }
            }  System.out.println("Код " + (int) codes.get(z) + " содержится в " + quant + " сообщенях");
        }
    }


        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль


    public static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        Set uniks =new HashSet();
        uniks.addAll(messageList);
        System.out.println("unical messages " + uniks.size());
    }


    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList){
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        Set uniks =new HashSet();
        uniks.addAll(messageList);
        System.out.println("до обработки " + messageList);
        System.out.println("длинной " +messageList.size());
        System.out.println(uniks);
//        messageList.addAll(uniks);
//        System.out.println("после обработки " + messageList);
//        System.out.println("длинной " +messageList.size());
        return messageList;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority){
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority){
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
    }

    public static void main(String[] args) {
        // вызов методов
    }


}
