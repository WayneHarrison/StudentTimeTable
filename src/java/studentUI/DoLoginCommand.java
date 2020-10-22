package studentUI;

import dto.StudentDTO;
import manager.StudentManager;

public class DoLoginCommand implements StudentCommand {

    private final StudentManager stuMgr;
    private final StudentDTO studentDTO;

    public DoLoginCommand(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
        stuMgr = new StudentManager();
    }

    @Override
    public Object execute() {
        return stuMgr.loginStudent(studentDTO);
    }
}
