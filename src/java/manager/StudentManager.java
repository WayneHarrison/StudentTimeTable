package manager;

import dto.StudentDTO;
import dto.TimeTableDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentManager extends DatabaseOperation {
    public static int stuID;
    
    public boolean registerStudent(StudentDTO studentDTO) {
        boolean registerOK = false;
        try {

            Connection conn = getConnection();

            PreparedStatement stmtCheck = conn.prepareStatement("SELECT USERNAME FROM STUDENT WHERE USERNAME = ?");
            stmtCheck.setString(1, studentDTO.getUsername());
            ResultSet rs = stmtCheck.executeQuery();
            if (!rs.next()) {
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO STUDENT (USERNAME, STUDENTNAME, PASSWORD, AGE) VALUES (?, ?, ?, ?)");
                stmt.setString(1, studentDTO.getUsername());
                stmt.setString(2, studentDTO.getName());
                stmt.setString(3, studentDTO.getPassword1());
                stmt.setInt(4, studentDTO.getAge());
                int rows = stmt.executeUpdate();

                registerOK = rows == 1;

                stmt.close();
            }
            conn.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return registerOK;

    }

    public boolean loginStudent(StudentDTO studentDTO) {

        boolean credentialsOK = false;

        try {
            Connection conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM STUDENT WHERE USERNAME =?");
            stmt.setString(1, studentDTO.getUsername());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                stuID = rs.getInt("ID");
                credentialsOK = rs.getString("PASSWORD").equals(studentDTO.getPassword1());
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return credentialsOK;
    }
    

    public ArrayList<TimeTableDTO> getTimeTable(int stuID) {
        
        ArrayList<TimeTableDTO> allTimetables = new ArrayList<>();
        try {
            Connection conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM TIMETABLE WHERE STUDENTID =?");
            stmt.setInt(1, stuID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                TimeTableDTO timetables = new TimeTableDTO(rs.getString("TIMETABLECLASS1"),
                        rs.getString("TIMETABLECLASS2"),
                        rs.getString("TIMETABLECLASS3"),
                        rs.getString("TIMETABLECLASS4"),
                        rs.getString("TIMETABLECLASS5"),
                        rs.getString("TIMETABLEDAYS"));
                
                allTimetables.add(timetables);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return allTimetables;
    }

}
