package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping("/")
public class UsersController {

//    @GetMapping
//    public String showGet(Model model) {
//        return getUsersView(model);
//    }

//    @PostMapping
//    public String showPost(Model model) {
//        return getUsersView(model);
//    }
//
//    private String getUsersView(Model model) {
//        model.addAttribute("message", "Список пользователей");
//        model.addAttribute("url", "/users");
//        return "index";
//    }

    private final UserService userService;


    public UsersController(UserService userService) {
        this.userService = userService;
        addUsers();
    }

    private void addUsers() {
        userService.create(new User("Paul", "Mccartney", "paul@beatles.com"));
        userService.create(new User("John", "Lennon", "john@beatles.com"));
        userService.create(new User("George", "Harrison", "george@beatles.com"));
        userService.create(new User("Ringo", "Starr", "ringo@beatles.com"));
        userService.create(new User("Иосиф", "Кобзон", "jesus@mail.ru"));
    }

    // Create

    @GetMapping("users/new")
    public String createForm(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("users")
    public String create(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:users";
    }

    // Read

    @GetMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", userService.getList());
        return "all";
    }

    @GetMapping("user/{id}")
    public String read(Model model, @PathVariable(name = "id") long id) {
        model.addAttribute("user", userService.show(id));
        return "show";
    }

    // Update

    @GetMapping("users/{id}/edit")
    public String editForm(Model model, @PathVariable() long id) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PatchMapping("users/{id}")
    public String edit(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(id, user);
        return "redirect:/users";
    }

    // Delete

    @DeleteMapping("users/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
