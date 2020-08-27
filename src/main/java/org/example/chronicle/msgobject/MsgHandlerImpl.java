package org.example.chronicle.msgobject;

public class MsgHandlerImpl implements MsgHandler {

    @Override
    public void msg(ConsoleMsg consoleMsg) {
        System.out.println(consoleMsg);
    }
}
