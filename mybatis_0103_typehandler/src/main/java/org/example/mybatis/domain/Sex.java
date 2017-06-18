package org.example.mybatis.domain;

/**
 * Created by 刘利民 on 2017/6/18.
 */
public enum Sex {

    MAIL(1, "男"), FMAIL(2, "女");

    private int i;

    private String name;

    Sex(String name) {
        this.name = name;
    }

    Sex(int i, String name) {
        this.i = i;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public static Sex getSex(int i) {
        if (i == 1) {
            return Sex.MAIL;
        } else if (i == 2) {
            return Sex.FMAIL;
        }
        return null;
    }
}
