package dto;

import java.io.Serializable;

public class StudentDTO implements Serializable {
    
    private final int stuID;
    private final String username;
    private final String name;
    private final String password1;
    private final String password2;
    private final int age;

    public StudentDTO(int stuID, String username, String name, String password1, String password2, int age) {
        this.stuID = stuID;
        this.username = username;
        this.name = name;
        this.password1 = password1;
        this.password2 = password2;
        this.age = age;
    }

    public int getStuID() {
        return stuID;
    }

    
    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword1() {
        return password1;
    }

    public String getPassword2() {
        return password2;
    }

    public int getAge() {
        return age;
    }

}
