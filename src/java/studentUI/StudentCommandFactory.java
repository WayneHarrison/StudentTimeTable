package studentUI;

import dto.StudentDTO;
import dto.TimeTableDTO;

public class StudentCommandFactory {

    public static final int DO_REGISTER = 1;
    public final static int DO_LOGIN = 2;
    public final static int GETTIMETABLE = 3;

    public static StudentCommand createCommand(int commandType, StudentDTO studentDTO) {
        switch (commandType) {
            case DO_REGISTER:
                return new DoRegisterCommand(studentDTO);
            case DO_LOGIN:
                return new DoLoginCommand(studentDTO);
            default:
                return null;
        }
    }
    public static StudentCommand createCommand(int commandType, int stuID){
        switch (commandType){
        case GETTIMETABLE:
            return new GetTimeTableCommand(stuID);
        default:
            return null;
        }
    }
}
