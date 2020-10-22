package staffUI;

import dto.StaffDTO;

public class StaffCommandFactory {

    public final static int DO_REGISTER = 1;
    public final static int DO_LOGIN = 2;

    public static StaffCommand createCommand(int commandType, StaffDTO staffDTO) {
        switch (commandType) {
            case DO_REGISTER:
                return new DoRegisterCommand(staffDTO);
            case DO_LOGIN:
                return new DoLoginCommand(staffDTO);
            default:
                return null;
        }
    }

}
