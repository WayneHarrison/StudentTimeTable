package dto;

import java.io.Serializable;

public class TimeTableDTO implements Serializable {

    private final String class1;
    private final String class2;
    private final String class3;
    private final String class4;
    private final String class5;

    private final String days;

    public TimeTableDTO(String class1, String class2, String class3, String class4, String class5, String days) {
        this.class1 = class1;
        this.class2 = class2;
        this.class3 = class3;
        this.class4 = class4;
        this.class5 = class5;
        this.days = days;
    }

    public String getClass1() {
        return class1;
    }

    public String getClass2() {
        return class2;
    }

    public String getClass3() {
        return class3;
    }

    public String getClass4() {
        return class4;
    }

    public String getClass5() {
        return class5;
    }

    public String getDays() {
        return days;
    }

}
