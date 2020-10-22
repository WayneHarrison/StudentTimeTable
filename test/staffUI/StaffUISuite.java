/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffUI;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Wayne Jnr
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{
    staffUI.StaffCommandFactoryTest.class, staffUI.DoRegisterCommandTest.class, staffUI.DoLoginCommandTest.class, staffUI.StaffCommandTest.class
})
public class StaffUISuite
{
    
}
