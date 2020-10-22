package appointmentUI;

import manager.AppointmentManager;

public class GetStuAppointmentsCommand implements AppointmentCommand {

    private final AppointmentManager appMgr;
    private final int stuID;

    public GetStuAppointmentsCommand(int stuID) {
        appMgr = new AppointmentManager();
        this.stuID = stuID;
    }

    @Override
    public Object execute() {
        return appMgr.getAppointments(stuID);
    }
}
