package model;

//import org.apache.commons.validator.routines.EmailValidator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private static final String EMAIL_REGEX = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public boolean isValid(String email) {
        if (email == null){
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }


    //Fixme: how to import the validator
   /* public static boolean emailValidator(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        if(!validator.isValid(email)){
            return false;
        }
        return true;
    }*/
    /*Regex
    * between ""
    * ^ beginning of the line
    * $ the end of a line
    * \\w a word character [a-zA-Z_0-9] the extra \ for java to read the next backlash as a backlash
    * -_.+ allowed as characters but none of the others
    * the * means matches zero or more occurences and so the last word can't end with a + as the next [] doesn't include a +
    * the meaning of + in between two sets of backets means match as many times as possible but at least once?
    * @ is not within brackets why? it is compulsory
    * () defines a group hence you need a word and then a dot
    * \. a literal dot
    * if the [] is between() => ([\\w+\\.]) any word + a dot as a group
    * + compulsory another word
    * why is it twice? otherwise it doesn't work why?
    * */

}
