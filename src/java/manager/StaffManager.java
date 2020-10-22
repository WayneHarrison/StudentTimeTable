package manager;

import dto.StaffDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffManager extends DatabaseOperation {

    public static int staffID;

    public boolean registerStaff(StaffDTO staffDTO) {
        boolean registerOK = false;
        try {
            Connection conn = getConnection();

            PreparedStatement stmtCheck = conn.prepareStatement("SELECT USERNAME FROM STAFF WHERE USERNAME = ?");
            stmtCheck.setString(1, staffDTO.getUsername());
            ResultSet rs = stmtCheck.executeQuery();
            if (!rs.next()) {
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO STAFF (USERNAME, STAFFNAME, PASSWORD) VALUES (?, ?, ?)");
                stmt.setString(1, staffDTO.getUsername());
                stmt.setString(2, staffDTO.getName());
                stmt.setString(3, staffDTO.getPassword1());
                int rows = stmt.executeUpdate();

                registerOK = rows == 1;

                stmt.close();
            }
            stmtCheck.close();
            conn.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return registerOK;
    }

    public boolean loginStaff(StaffDTO staffDTO) {

        boolean credentialsOK = false;

        try {
            Connection conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM STAFF WHERE USERNAME =?");
            stmt.setString(1, staffDTO.getUsername());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                staffID = rs.getInt("ID");
                credentialsOK = rs.getString("PASSWORD").equals(staffDTO.getPassword1());
            }
            
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return credentialsOK;
    }
}
