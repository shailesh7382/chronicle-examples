package org.example.chronicle.helloworld;

import net.openhft.chronicle.queue.ExcerptAppender;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueue;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueueBuilder;

import java.util.Scanner;

public class QueueCreator {
    public static void main(String[] args) {
        SingleChronicleQueue queue = SingleChronicleQueueBuilder.binary(CodeStatics.queue_path).build();
        ExcerptAppender appender = queue.acquireAppender();
        Scanner read = new Scanner(System.in);
        while (true) {
            System.out.println("type something");
            String line = read.nextLine();
            if (line.isEmpty())
                break;
            appender.writeText(line);
        }
        System.out.println("... bye.");
    }
}
