package managedbean;

import dto.StudentDTO;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import studentUI.StudentCommandFactory;

@Named(value = "studentLoginBean")
@SessionScoped

public class StudentLoginBean implements Serializable {

    private final int stuID = 0;
    private String username;
    private String name;
    private String password1;
    private String password2;
    private int age;
    static boolean loginOK = false;

    public String login() {

        boolean loginOK = false;

        StudentDTO loginStudent;

        loginStudent = new StudentDTO(
                stuID,
                username,
                name,
                password1,
                password2,
                age
        );

        loginOK = (boolean) StudentCommandFactory.createCommand(StudentCommandFactory.DO_LOGIN, loginStudent)
                .execute();
        return loginOK ? "/protected/studentHome" : "";

    }
    
    public String logout() throws IOException {
        
        
        loginOK = false;

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        ec.redirect("../index.xhtml");

        return "";

    }

    public boolean isLoginOK() {
        return loginOK;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
