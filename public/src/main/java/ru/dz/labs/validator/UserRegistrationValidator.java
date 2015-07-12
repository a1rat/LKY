package ru.dz.labs.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.dz.labs.api.service.UserService;
import ru.dz.labs.form.RegUserForm;


/**
 * Created by Rail on 29.06.2015.
 */
@Component
public class UserRegistrationValidator implements Validator {

    @Autowired
    UserService userService;

    public boolean supports(Class<?> aClass) {
        return RegUserForm.class.isAssignableFrom(aClass);
    }

    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "registrationError.emptyNameField");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "registrationError.emptyPasswordField");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "registrationError.emptyEmailField");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "registrationError.emptyConfPassField");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "registrationError.emptyRoleField");


        if (errors.hasErrors()) {
            return;
        }

        RegUserForm form = (RegUserForm) target;
      /*  if (userService.loadUserByUsername(form.getName()).getLogin() != null) {
            errors.rejectValue("email", "registrationError.emailIsUse");
        }*/
        if (!form.getPassword().equals(form.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "registrationError.confirmConfPassField");
        }
        if (!form.getEmail().contains("@")) {
            errors.rejectValue("email", "registrationError.invalidEmail");
        }
    }
}

