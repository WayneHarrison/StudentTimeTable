/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentUI;

import dto.AppointmentDTO;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wayne Jnr
 */
public class AppointmentCommandFactoryTest
{

    public AppointmentCommandFactoryTest()
    {
    }

    @Test
    public void testCreateCommand_int_AppointmentDTO()
    {
        int ID = 0;
        AppointmentDTO appointmentDTO = new AppointmentDTO(ID, "1", "1", "2020-10-10", "13:00", "S209");
        System.out.println("createCommand");
        int commandType = AppointmentCommandFactory.MAKE_APPOINTMENT;
        AppointmentCommand result = AppointmentCommandFactory.createCommand(commandType, appointmentDTO);
        assertNotNull(result);

    }

    @Test
    public void testCreateCommand_3args()
    {
        System.out.println("createCommand");
        int ID = 1;
        int commandType = AppointmentCommandFactory.CHANGE_APPOINTMENT;
        AppointmentDTO appointmentDTO = new AppointmentDTO(ID, "1", "1", "2020-10-10", "13:00", "S209");        
        AppointmentCommand result = AppointmentCommandFactory.createCommand(commandType, appointmentDTO, ID);
        assertNotNull(result);

    }

    @Test
    public void testCreateCommand_int_int()
    {
        System.out.println("createCommand");
        int commandType = AppointmentCommandFactory.GET_APPOINTMENT;
        int ID = 1;
        AppointmentCommand result = AppointmentCommandFactory.createCommand(commandType, ID);
        assertNotNull(result);
    }
    
}
