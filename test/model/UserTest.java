package model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class UserTest {


    @Test
    public void createUsername() {
        UsernameGenerator usernameGenerator = new UsernameGenerator();
        String expected = "JanTes001";
        String actual = usernameGenerator.createUsername("Tessa", "Janssen");
        assertEquals(expected, actual);

        expected = "LuiRos001";
        actual = usernameGenerator.createUsername("Rose", "Luifje");
        assertEquals(expected, actual);

        expected = "GasYox001";
        actual = usernameGenerator.createUsername("Yo", "Gasselt");
        assertEquals(expected, actual);

        expected = "JanTex001";
        actual = usernameGenerator.createUsername("Te", "Janssen");
        assertEquals(expected, actual);

        expected = "JaxTes001";
        actual = usernameGenerator.createUsername("Tessa", "Ja");
        assertEquals(expected, actual);

        expected = "TopLil004";
        actual = usernameGenerator.createUsername("Lilore", "Topaz");
        assertEquals(expected, actual);

        expected = "TeiMar003";
        actual = usernameGenerator.createUsername("Martje", "Teissen");
        assertEquals(expected, actual);

        expected = "UpxMox001";
        actual = usernameGenerator.createUsername("Mo", "Up");
        assertEquals(expected, actual);

    }

    @Test
    //fixme: how to test randomly created Strings?
    void createPassword() {
        PasswordGenerator passwordGenerator = new PasswordGenerator(new PasswordGenerator.PasswordGeneratorBuilder());
        for (int i = 0; i < 10; i++) {
            String actual = passwordGenerator.generate(10);
            System.out.println(actual);
        }
    }
}