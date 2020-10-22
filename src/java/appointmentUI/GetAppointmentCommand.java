package appointmentUI;

import manager.AppointmentManager;

public class GetAppointmentCommand implements AppointmentCommand {

    private final AppointmentManager appMgr;
    private final int staffID;

    public GetAppointmentCommand(int staffID) {
        appMgr = new AppointmentManager();
        this.staffID = staffID;
    }

    @Override
    public Object execute() {
        return appMgr.getAppointment(staffID);
    }
}
