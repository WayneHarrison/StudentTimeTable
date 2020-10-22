package staffUI;

import dto.StaffDTO;
import manager.StaffManager;

public class DoLoginCommand implements StaffCommand {

    private final StaffManager staMgr;
    private final StaffDTO staffDTO;

    public DoLoginCommand(StaffDTO staffDTO) {
        this.staffDTO = staffDTO;
        staMgr = new StaffManager();
    }

    @Override
    public Object execute() {
        return staMgr.loginStaff(staffDTO);
    }

}
