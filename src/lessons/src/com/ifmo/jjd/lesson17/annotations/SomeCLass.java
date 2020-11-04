package com.ifmo.jjd.lesson17.annotations;

@Config(desc = "jk", version = 2) //no ; after annotation!!!!!!!!!1
public class SomeCLass {
    @Required
    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "SomeCLass{" +
                "string='" + string + '\'' +
                '}';
    }
}
