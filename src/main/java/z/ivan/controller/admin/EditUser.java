package z.ivan.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import z.ivan.dao.UserDao;
import z.ivan.model.Role;
import z.ivan.model.User;

import java.util.Objects;

@Controller
public class EditUser {
    private UserDao userDao;

    public EditUser(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "edit_user/{userId}")
    public String editPage(@PathVariable String userId, Model model) {
        User user = userDao.getById(Long.valueOf(userId));
        model.addAttribute("rolesNames", Role.getRolesNames());
        model.addAttribute("user", user);
        return "adminUI/edit_user";
    }

    @PostMapping(value = "edit_user")
    public String editUser(
            @RequestParam("userId") String userId,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("login") String login,
            @RequestParam("password") String password,
            @RequestParam("roleName") String roleName
    ) {
        int pwdHash = Objects.hashCode(password);
        password = new String();

        int roleId;
        if ("admin".equalsIgnoreCase(roleName)) {
            roleId = 1;
        } else if ("tutor".equalsIgnoreCase(roleName)) {
            roleId = 2;
        } else {
            roleId = 3;
        }

        User user = new User();
        user.setUserId(Long.valueOf(userId));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(pwdHash);
        user.setRoleId(roleId);

        userDao.update(user);
        return "requests";
    }
}
