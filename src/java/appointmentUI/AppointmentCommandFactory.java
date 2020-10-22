package appointmentUI;

import dto.AppointmentDTO;

public class AppointmentCommandFactory {

    public final static int MAKE_APPOINTMENT = 1;
    public final static int CHANGE_APPOINTMENT = 2;
    public final static int DELETE_APPOINTMENT = 3;
    public final static int GET_APPOINTMENTS = 4;
    public final static int GET_APPOINTMENT = 5;
    public final static int GET_STUAPPOINTMENTS = 6;

    public static AppointmentCommand createCommand(int commandType, AppointmentDTO appointmentDTO) {
        switch (commandType) {
            case MAKE_APPOINTMENT:
                return new MakeAppointmentCommand(appointmentDTO);
            default:
                return null;
        }

    }

    public static AppointmentCommand createCommand(int commandType, AppointmentDTO appointmentDTO, int ID) {
        switch (commandType) {
            case CHANGE_APPOINTMENT:
                return new ChangeAppointmentCommand(appointmentDTO, ID);
            default:
                return null;
        }
    }

    public static AppointmentCommand createCommand(int commandType, int ID) {
        switch (commandType) {
            case GET_APPOINTMENTS:
                return new GetAppointmentsCommand(ID);
            case GET_STUAPPOINTMENTS:
                return new GetStuAppointmentsCommand(ID);
            case DELETE_APPOINTMENT:
                return new DeleteAppointmentCommand(ID);
            case GET_APPOINTMENT:
                return new GetAppointmentCommand(ID);
            default:
                return null;
        }
    }

}
