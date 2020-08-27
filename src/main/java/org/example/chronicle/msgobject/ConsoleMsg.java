package org.example.chronicle.msgobject;

import net.openhft.chronicle.wire.SelfDescribingMarshallable;

public class ConsoleMsg extends SelfDescribingMarshallable {
    private String msg;
    private long time;

    public ConsoleMsg msg(String message){
        this.msg = message;
        return this;
    }

    public ConsoleMsg time(long time){
        this.time = time;
        return this;
    }

    @Override
    public String toString() {
        return "Message -> " + msg + " time -> " + time;
    }
}
