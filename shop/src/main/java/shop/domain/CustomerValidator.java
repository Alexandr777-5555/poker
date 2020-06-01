package shop.domain;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class CustomerValidator  implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.isAssignableFrom(aClass);
    }



    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName"  ,
                "firstName is required" , "заполните имя");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName" ,
                "lastName is required" , "заполните фамилию");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth" ,
                "dateOfBirth is required" , "заполните д.р.");




    }
}
