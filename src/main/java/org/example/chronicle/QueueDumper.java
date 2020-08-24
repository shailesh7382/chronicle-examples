package org.example.chronicle;

import net.openhft.chronicle.queue.DumpQueueMain;

import java.io.FileNotFoundException;

public class QueueDumper {
    public static void main(String[] args) throws FileNotFoundException {
        DumpQueueMain.dump("queue");
    }
}
