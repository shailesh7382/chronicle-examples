package org.example.chronicle.msgobject;

import net.openhft.chronicle.core.time.SystemTimeProvider;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueue;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueueBuilder;
import org.example.chronicle.CodeStatics;

import java.util.Scanner;

public class QueueWriter {
    public static void main(String[] args) {
        SingleChronicleQueue queue = SingleChronicleQueueBuilder.binary(CodeStatics.queue_path + QueueWriter.class.getPackage().getName()).build();
        MsgHandler appender = queue.acquireAppender().methodWriter(MsgHandler.class);
        Scanner read = new Scanner(System.in);
        while (true) {
            System.out.println("type something");
            String line = read.nextLine();
            if (line.isEmpty())
                break;
            ConsoleMsg consoleMsg = new ConsoleMsg();
            consoleMsg.msg(line).time(now());
            appender.msg(consoleMsg);
        }
        System.out.println("... bye.");
    }

    static long now() {
        return SystemTimeProvider.INSTANCE.currentTimeMicros();
    }
}
