package test;

import model.PasswordGenerator;
import model.UsernameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class UserTest {


    @Test
    public void createUsername() {
        UsernameGenerator usernameGenerator = new UsernameGenerator();
        String expected = "JanTes001";
        String actual = usernameGenerator.createUsername("Tessa", "Janssen");
        assertEquals(expected, actual);


        usernameGenerator = new UsernameGenerator();
        expected = "LuiRos001";
        actual = usernameGenerator.createUsername("Rose", "Luifje");
        assertEquals(expected, actual);

        usernameGenerator = new UsernameGenerator();
        expected = "JanTex001";
        actual = usernameGenerator.createUsername("Te", "Janssen");
        assertEquals(expected, actual);

        usernameGenerator = new UsernameGenerator();
        expected = "JaxTes001";
        actual = usernameGenerator.createUsername("Tessa", "Ja");
        assertEquals(expected, actual);

        usernameGenerator = new UsernameGenerator();
        expected = "TopLil001";
        actual = usernameGenerator.createUsername("Lilore", "Topaz");
        assertEquals(expected, actual);

        usernameGenerator = new UsernameGenerator();
        expected = "TeiMar003";
        actual = usernameGenerator.createUsername("Martje", "Teissen");
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