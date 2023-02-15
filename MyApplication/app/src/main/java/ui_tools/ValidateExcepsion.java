package ui_tools;

import androidx.annotation.Nullable;

public class ValidateExcepsion extends Exception{
    String massage;
    public ValidateExcepsion(String massage)
    {
        this.massage = massage;
    }
    @Nullable
    @Override
    public String getMessage() {
        return massage;
    }
}
