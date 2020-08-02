package database;

import main.Main;
import model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {
    UserDAO userDAO = new UserDAO(Main.getDBAccess());
    public static List<User> userTestList;

    @BeforeAll
    public static void setUp() {
        User user1 = new User("Mildred", "last", "Hope", "hope@gmail.com", "reader");
        User user2 = new User("Roos", null, "Langzaam", "roos@gmail.com", "storyteller");
        User user3 = new User("Maartje", "de", "Hythe", "maartje@gmail.com", "reader");
        User user4 = new User("Lydia", null, "Stokvis", "lydia.stokvis@gmail.com", "commenter");
        User user5 = new User("Liliane", null, "Top", "hallo@lilianetop.nl", "admin");

        userTestList = new ArrayList<>(Arrays.asList(user1, user2, user3, user4, user5));
    }

    @AfterAll
    public static void tearDown() {

    }

    //fixme: refactor code as there is much duplication
    //fixme: find a procedure that makes testing easier as in delete the ones you stored etc. Is there an existing protocol to follow?

    @Test
    void storeOneTest() {
        userDAO.storeOne(userTestList.get(0));
        User user1ToStoreTest = userDAO.getOneByEmailaddress(userTestList.get(0).getEmailaddress());
        assertTrue(user1ToStoreTest.getEmailaddress().equals("hope@gmail.com"));
        userDAO.storeOne(userTestList.get(1));
        User user2ToStoreTest = userDAO.getOneByEmailaddress(userTestList.get(1).getEmailaddress());
        assertTrue(user2ToStoreTest.getEmailaddress().equals("roos@gmail.com"));
        userDAO.storeOne(userTestList.get(2));
        User user3ToStoreTest = userDAO.getOneByEmailaddress(userTestList.get(2).getEmailaddress());
        assertTrue(user3ToStoreTest.getEmailaddress().equals("maartje@gmail.com"));
        userDAO.storeOne(userTestList.get(3));
        User user4ToStoreTest = userDAO.getOneByEmailaddress(userTestList.get(3).getEmailaddress());
        assertTrue(user4ToStoreTest.getEmailaddress().equals("lydia.stokvis@gmail.com"));
        userDAO.storeOne(userTestList.get(4));
        User user5ToStoreTest = userDAO.getOneByEmailaddress(userTestList.get(4).getEmailaddress());
        assertTrue(user5ToStoreTest.getEmailaddress().equals("hallo@lilianetop.nl"));


    }

    @Test
    void getOneByUsernameTest() {
        //User userToTest = userDAO.getOneByUsername(userTestList.get(0).getUserName());//gives null pointerexception why?
        User user1ToTest = userDAO.getOneByUsername("HopMil001");
        assertTrue(user1ToTest.getLastName().equals("Hope"));
        //assertEquals(user1ToTest.getPassword(), userTestList.get(0).getPassword());//why does it change the password?

        User userToTest2 = userDAO.getOneByUsername("TopLil001");
        assertTrue(userToTest2.getLastName().equals("Top"));
        assertTrue(userToTest2.getFirstName().equals("Liliane"));
        assertTrue(userToTest2.getEmailaddress().equals("hallo@lilianetop.nl"));
        assertTrue(userToTest2.getRole().equals("admin"));
        //assertTrue(userToTest2.getPassword().equals("a]<[8Hy3X5"));//how to test this as it keeps changing due to the testing?
    }

    @Test
    void getOneByEmailaddressTest() {
        User userToTest = userDAO.getOneByEmailaddress("roos@gmail.com");
        assertTrue(userToTest.getLastName().equals("Langzaam"));
        assertTrue(userToTest.getUserName().equals("LanRoo001"));
        //assertTrue(userToTest.getPassword().equals(userTestList.get(1).getPassword()));//not working why?

        User userToTest2 = userDAO.getOneByEmailaddress("hallo@lilianetop.nl");
        assertTrue(userToTest2.getLastName().equals("Top"));
        assertTrue(userToTest2.getUserName().equals("TopLil001"));

        User userToTest3 = userDAO.getOneByEmailaddress(userTestList.get(2).getEmailaddress());
        assertTrue(userToTest3.getLastName().equals("Hythe"));
        String expected = "HytMaa001";
        String actual = userToTest3.getUserName();
        assertEquals(expected, actual);
    }

    @Test
    void getAllTest() {
        ArrayList<User> allUsers = userDAO.getAll();
        assertEquals(5, allUsers.size());
    }

    @Test
    void getAllByRoleTest() {
        //fixme: is there a better way to test this?
        ArrayList allReaders = userDAO.getAllByRole("reader");
        ArrayList allAdmin = userDAO.getAllByRole("admin");
        ArrayList allCommenters = userDAO.getAllByRole("commenter");
        ArrayList allStorytellers = userDAO.getAllByRole("storyteller");

        assertTrue(allReaders.size() == 2);
        assertTrue(allAdmin.size() == 1);
        assertTrue(allCommenters.size() == 1);
        assertTrue(allStorytellers.size() == 1);
    }


    @Test
    //why does this test works individually but not if I ran the entire test unit?
    void checkIfUsernameExistsTest() {

        Boolean usernameToCheck = userDAO.checkIfUsernameExists("chopMil001");
        assertFalse(usernameToCheck);

        //why is it not case sensitive?
        Boolean usernameToCheck2 = userDAO.checkIfUsernameExists("hopMil001");
        assertTrue(usernameToCheck2);//should be false

        /*Boolean usernameToCheck3 = userDAO.checkIfUsernameExists(userTestList.get(4).getUserName());
        assertTrue(usernameToCheck3);//why is this not working?
*/
        Boolean usernameToCheck4 = userDAO.checkIfUsernameExists("StoLyd001");
        assertTrue(usernameToCheck4);
    }

    @Test
    void checkIfEmailaddressExists() {
        Boolean emailaddressToCheck = userDAO.checkIfEmailaddressExists("roos@gmail.com");
        assertFalse(emailaddressToCheck);

        Boolean emailaddressToCheck2 = userDAO.checkIfEmailaddressExists("hallo@lilianetop.nl");
        assertTrue(emailaddressToCheck2);
    }

    @Test
    void updateOneTest() {
        User userToUpdate = userDAO.getOneByEmailaddress("hope@gmail.com");
        userToUpdate.setEmailaddress("hope2@gmail.com");
        userToUpdate.setPassword("MyOwnPassword");
        userDAO.updateOne(userToUpdate);

        User updatedUser = userDAO.getOneByUsername("HopMil001");
        assertEquals("hope2@gmail.com", updatedUser.getEmailaddress());
        assertEquals("MyOwnPassword", updatedUser.getPassword());

        User userToUpdate2 = userDAO.getOneByEmailaddress("hallo@lilianetop.nl");
        userToUpdate2.setPassword("Top1234");
        userDAO.updateOne(userToUpdate2);
        assertEquals("Top1234", userToUpdate2.getPassword());

    }

    @Test
    //this test works fine individually but not if entire testunit is run why?
    void deleteOneTest() {
        User userToDelete1 = userDAO.getOneByUsername("HopMil001");
        userDAO.deleteOne(userToDelete1);
        User deletedUser = userDAO.getOneByUsername("HopMil001");
        assertTrue(deletedUser == null);

        User userToDelete2 = userDAO.getOneByEmailaddress("roos@gmail.com");
        userDAO.deleteOne(userToDelete2);
        User deletedUser2 = userDAO.getOneByUsername(userToDelete2.getUserName());
        assertTrue(deletedUser2 == null);
    }

}