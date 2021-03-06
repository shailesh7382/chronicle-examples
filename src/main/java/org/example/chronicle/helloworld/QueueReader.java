package org.example.chronicle.helloworld;

import net.openhft.chronicle.core.Jvm;
import net.openhft.chronicle.queue.ExcerptTailer;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueue;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueueBuilder;
import org.example.chronicle.CodeStatics;

public class QueueReader {
    public static void main(String[] args) {
        SingleChronicleQueue queue = SingleChronicleQueueBuilder.binary(CodeStatics.queue_path + QueueReader.class.getPackage().getName()).build();
        ExcerptTailer tailer = queue.createTailer();

        while (true) {
            String text = tailer.readText();
            if (text == null)
                Jvm.nanoPause();
            else
                System.out.println(text);
        }
    }
}
