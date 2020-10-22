/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentUI;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Wayne Jnr
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{
    studentUI.StudentCommandTest.class, studentUI.DoLoginCommandTest.class, studentUI.DoRegisterCommandTest.class, studentUI.GetTimeTableCommandTest.class, studentUI.StudentCommandFactoryTest.class
})
public class StudentUISuite
{
    
}
