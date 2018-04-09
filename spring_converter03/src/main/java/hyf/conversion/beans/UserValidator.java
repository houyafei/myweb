package hyf.conversion.beans;

import hyf.conversion.beans.User;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author yafei.hou
 * Created by yafei.hou on 2017/11/27.
 */
@Repository("userValidator")
public class UserValidator implements Validator{


    public UserValidator() {
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors,"userName","登录名不能为空");
        ValidationUtils.rejectIfEmpty(errors,"password","密码不能为空");

        User user = (User) target;
        if (user.getUserName().length()>10){
            errors.rejectValue("userName",null,"用户名不能超过10个字");
        }
        if (user.getPassword() != null
                && !user.getPassword().equals("")
                && user.getPassword().length()<6) {
            errors.rejectValue("password",null,"密码不能小于六位");
        }
    }


}
