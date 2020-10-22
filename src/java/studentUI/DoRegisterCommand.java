package studentUI;

import dto.StudentDTO;
import manager.StudentManager;
        
public class DoRegisterCommand implements StudentCommand {
    
    private final StudentManager stuMgr;
    private final StudentDTO studentDTO;
    
    public DoRegisterCommand(StudentDTO studentDTO) {
        
        this.studentDTO = studentDTO;
        stuMgr = new StudentManager();
    }
    
    @Override
    public Object execute()
    {
        return stuMgr.registerStudent(studentDTO);
    }
}
