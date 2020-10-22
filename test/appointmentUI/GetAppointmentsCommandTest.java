/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentUI;

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
public class GetAppointmentsCommandTest
{
    
    public GetAppointmentsCommandTest()
    {
    }

    @Test
    public void testExecute() throws SQLException 
    {
        
        AppointmentManager appMgr = new AppointmentManager();
        int staffID = 1;
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentApp", "stuAdmin", "admin");
        
        System.out.println("execute");
        GetAppointmentsCommand instance = new GetAppointmentsCommand(staffID);
        Object result = instance.execute();
        assertNotNull(result);
        
    }
    
    
}
