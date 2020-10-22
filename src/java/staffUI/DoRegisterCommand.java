package staffUI;

import dto.StaffDTO;
import manager.StaffManager;

public class DoRegisterCommand implements StaffCommand {

    private final StaffManager staMgr;
    private final StaffDTO staffDTO;

    public DoRegisterCommand(StaffDTO staffDTO) {
        this.staffDTO = staffDTO;
        staMgr = new StaffManager();
    }

    @Override
    public Object execute() {
        return staMgr.registerStaff(staffDTO);
    }

}
