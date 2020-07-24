package test;

import model.PasswordGenerator;
import model.UsernameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class UserTest {

    @Test
    public void createUsername() {
        //todo:not working as null pointer exception => if-else
        UsernameGenerator usernameGenerator = new UsernameGenerator("Tessa", "Janssen");
        String expected = "JanTes001";
        String actual = usernameGenerator.createUsername();
        assertEquals(expected, actual);

        usernameGenerator = new UsernameGenerator("Te", "Janssen");
        expected = "JanTex001";
        actual = usernameGenerator.createUsername();
        assertEquals(expected, actual);

        usernameGenerator = new UsernameGenerator("Tessa", "Ja");
        expected = "JaxTes001";
        actual = usernameGenerator.createUsername();
        assertEquals(expected, actual);

        usernameGenerator = new UsernameGenerator("Lilore", "Topaz");
        expected = "TopLil001";
        actual = usernameGenerator.createUsername();
        assertEquals(expected, actual);


    }

    @Test
    void createPassword() {
        PasswordGenerator passwordGenerator = new PasswordGenerator(new PasswordGenerator.PasswordGeneratorBuilder());
        for (int i = 0; i < 10; i++) {
            String actual = passwordGenerator.generate(10);
            System.out.println(actual);
        }
    }
}