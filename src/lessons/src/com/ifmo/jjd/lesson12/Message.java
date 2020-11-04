package com.ifmo.jjd.lesson12;

import java.io.IOException;

public class Message {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) throws ChatExaption {
        if (text == null||text.trim().length()<3)
            throw new ChatExaption("Text.lengyh <3");
        this.text = text;
    }

    public Message(String text) throws ChatExaption{
        setText(text);
    }
}
