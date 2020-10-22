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
public class GetStuAppointmentsCommandTest
{
    
    public GetStuAppointmentsCommandTest()
    {
    }

    @Test
    public void testExecute() throws SQLException
    {
        AppointmentManager appMgr = new AppointmentManager();
        int stuID = 1;
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentApp", "stuAdmin", "admin");
        
        System.out.println("execute");
        GetStuAppointmentsCommand instance = new GetStuAppointmentsCommand(stuID);
        Object result = instance.execute();
        assertNotNull(result);

    }
    
}
