/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentUI;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Wayne Jnr
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{
    appointmentUI.GetAppointmentCommandTest.class, appointmentUI.MakeAppointmentCommandTest.class, appointmentUI.GetStuAppointmentsCommandTest.class, appointmentUI.AppointmentCommandFactoryTest.class, appointmentUI.DeleteAppointmentCommandTest.class, appointmentUI.ChangeAppointmentCommandTest.class, appointmentUI.AppointmentCommandTest.class, appointmentUI.GetAppointmentsCommandTest.class
})
public class AppointmentUISuite
{
    
}
