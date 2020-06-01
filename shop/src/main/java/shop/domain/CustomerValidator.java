package shop.domain;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class CustomerValidator  implements Validator {


    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.isAssignableFrom(aClass);
    }



    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName"  ,
                "firstName is required" , "заполните имя");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName" , "заполните фамилию" ,
                "заполните фамилию");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth" ,
                "dateOfBirth is required" , "заполните д.р.");


        Customer customer=(Customer) o;

        String firstName = customer.getFirstName();

        if(firstName.length()<4){
            log.info("first name " + firstName.length());
            errors.reject("length < 4 chars" , "length < 4 chars");
        }

    }
}
