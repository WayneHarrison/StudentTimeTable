package managedbean;

import dto.TimeTableDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import studentUI.StudentCommandFactory;

@Named(value = "timeTableBean")
@SessionScoped

public class TimeTableBean implements Serializable {

    int stuID = manager.StudentManager.stuID;

    public ArrayList<TimeTableDTO> getTimetable() {
        ArrayList<TimeTableDTO> timetable
                = (ArrayList<TimeTableDTO>) StudentCommandFactory.createCommand(
                        StudentCommandFactory.GETTIMETABLE, stuID)
                        .execute();

        return timetable;
    }

    public int getStuID() {
        return stuID;
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

}
