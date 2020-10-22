package managedbean;

import dto.StudentDTO;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import studentUI.StudentCommandFactory;

@Named(value = "registerBean")
@RequestScoped

public class StudentRegisterBean {

    private final int stuID = 0;
    private String username;
    private String name;
    private String password1;
    private String password2;
    private int age;

    public String register() {

        boolean studentRegistered = false;
        if (password1.equals(password2)) {
        
            StudentDTO newStudent
                    = new StudentDTO(
                            stuID,
                            username,
                            name,
                            password1,
                            password2,
                            age
                    );
            studentRegistered = (boolean) 
                    StudentCommandFactory.createCommand(StudentCommandFactory.DO_REGISTER, newStudent)
                            .execute();
        }
        return studentRegistered ? "login" : "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        try {
            byte[] hash
                    = MessageDigest.getInstance("SHA-256")
                            .digest(password1.getBytes(StandardCharsets.UTF_8));

            password1 = Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
        }
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        try {
            byte[] hash
                    = MessageDigest.getInstance("SHA-256")
                            .digest(password2.getBytes(StandardCharsets.UTF_8));

            password2 = Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
        }
        this.password2 = password2;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
