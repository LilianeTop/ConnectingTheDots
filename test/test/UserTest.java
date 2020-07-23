package test;

import model.PasswordGenerator;
import model.UsernameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class UserTest {

    @Test
    public void createUsername() {
        //todo:not working as null pointer exception => while statement to if
        //fixme: how to display 001 instead if just 1

        UsernameGenerator usernameGenerator = new UsernameGenerator("Tessa", "de", "Janssen");
        String expected = "JanTes001";
        String actual = usernameGenerator.createUsername();
        assertEquals(expected, actual);

        usernameGenerator = new UsernameGenerator("Te", "de", "Janssen");
        expected = "JanTex001";
        actual = usernameGenerator.createUsername();
        assertEquals(expected, actual);

        usernameGenerator = new UsernameGenerator("Tessa", "de", "Ja");
        expected = "JaxTes001";
        actual = usernameGenerator.createUsername();
        assertEquals(expected, actual);

        usernameGenerator = new UsernameGenerator("Lilore", null, "Topaz");
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