package org.example.chronicle.helloworld;

import net.openhft.chronicle.queue.DumpQueueMain;

import java.io.FileNotFoundException;

public class QueueDumper {
    public static void main(String[] args) throws FileNotFoundException {
        DumpQueueMain.dump(CodeStatics.queue_path);
    }
}
