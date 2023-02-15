package ui_tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditValidator {

    public static Pattern TITLE_PATTERN = Pattern.compile("^(\\s*([А-я]|[A-z])\\s*)+$");
    public static Pattern MONEY_PATTERN = Pattern.compile("^\\d+\\.?\\d+$");
    public static Pattern D_PATTERN = Pattern.compile("^\\d+$");



    public String Validate(String text,  Pattern pattern) throws ValidateExcepsion
    {
        Matcher matcher = pattern.matcher(text);
        if(matcher.find())
        {
            return text.substring(matcher.start(), matcher.end());
        }
        else
        {
            throw new ValidateExcepsion("Failed validation");
        }
    }

    public boolean IsValid(String text, Pattern pattern)
    {
        Matcher matcher = pattern.matcher(text);
        if(matcher.find())
        {
            return true;
        }
        else{
            return false;
        }
    }
}
