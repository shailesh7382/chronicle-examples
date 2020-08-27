package org.example.chronicle.msgobject;

import net.openhft.chronicle.bytes.MethodReader;
import net.openhft.chronicle.core.Jvm;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueue;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueueBuilder;
import org.example.chronicle.CodeStatics;

public class QueueReader {
    public static void main(String[] args) {
        SingleChronicleQueue queue = SingleChronicleQueueBuilder.binary(CodeStatics.queue_path + QueueReader.class.getPackage().getName()).build();
        MethodReader methodReader =  queue.createTailer().methodReader(new MsgHandlerImpl());

        while (true) {
            if (!methodReader.readOne())
                Jvm.pause(50);
        }
    }
}
