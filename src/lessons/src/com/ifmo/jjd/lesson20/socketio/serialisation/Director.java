package com.ifmo.jjd.lesson20.socketio.serialisation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Director extends Human implements Externalizable {
    private String speech;
    private int rating;

    public Director(String speech) {
        this.speech = speech;
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Director)) return false;

        Director director = (Director) o;

        return speech != null ? speech.equals(director.speech) : director.speech == null;
    }

    @Override
    public int hashCode() {
        return speech != null ? speech.hashCode() : 0;
    }


    @Override
    public String toString() {
        return "Director{" +
                "speech='" + speech + '\'' +
                ", rating=" + rating +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeUTF(speech);
        objectOutput.write(rating);
        objectOutput.write(age); // the sequence is critiacl!
//        objectOutput.writeObject(QWER);
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        speech = objectInput.readUTF();
        rating = objectInput.readInt();
        age =  objectInput.readInt(); // the sequence is critiacl!
//        field =(QWER.class) objectInput.readObject();

    }
}