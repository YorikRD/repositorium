package com.ifmo.jjd.lesson20.socketio.serialisation;

import java.io.Serializable;
import java.time.LocalDate;

public class Pupil extends Human implements LearnAble  {
    private Group group;
    private int level;
    private LocalDate lastLesson;
    transient private final String info = "Ученик";
    private static final long serialVersionUID = 1L; // Hear we phisicaly written a version. so we take responsibility
    //for it
    //written to stream while serialisation runs
    //while deserialisation is compared to one in programm
    // it is recomended to make such field in programm.



    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pupil)) return false;

        Pupil pupil = (Pupil) o;

        if (level != pupil.level) return false;
        if (group != null ? !group.equals(pupil.group) : pupil.group != null) return false;
        return lastLesson != null ? lastLesson.equals(pupil.lastLesson) : pupil.lastLesson == null;
    }

    @Override
    public int hashCode() {
        int result = group != null ? group.hashCode() : 0;
        result = 31 * result + level;
        result = 31 * result + (lastLesson != null ? lastLesson.hashCode() : 0);
        return result;
    }

    @Override
    public void learn() {
        lastLesson = LocalDate.now();
        level += (int) (Math.random() * group.getMaxKnowledge());
    }


    @Override
    public String toString() {
        return "Pupil{" +
                "group=" + group +
                ", level=" + level +
                ", lastLesson=" + lastLesson +
                ", info='" + info + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
