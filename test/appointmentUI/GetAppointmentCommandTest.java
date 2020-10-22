/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentUI;

import dto.AppointmentDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import manager.AppointmentManager;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wayne Jnr
 */
public class GetAppointmentCommandTest
{
    
    public GetAppointmentCommandTest()
    {
    }

    @Test
    public void testExecute() throws SQLException
    {
        AppointmentDTO appointment = null;
        AppointmentManager appMgr = new AppointmentManager();
        int staffID = 2;
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentApp", "stuAdmin", "admin");
        
        System.out.println("execute");
        GetAppointmentCommand instance = new GetAppointmentCommand(staffID);
        Object result = instance.execute();
        assertNotNull(result);
        
    }
    @Test
    public void testExecute2() throws SQLException
    {
        AppointmentDTO appointment = null;
        AppointmentManager appMgr = new AppointmentManager();
        int staffID = 0;
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentApp", "stuAdmin", "admin");
        
        System.out.println("execute");
        GetAppointmentCommand instance = new GetAppointmentCommand(staffID);
        Object result = instance.execute();
        assertNull(result);
        
    }
}
