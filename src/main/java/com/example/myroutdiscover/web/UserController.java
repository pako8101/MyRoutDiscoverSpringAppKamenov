package com.example.myroutdiscover.web;

import com.example.myroutdiscover.model.binding.UserLoginBindingModel;
import com.example.myroutdiscover.model.binding.UserRegisterBindingModel;
import com.example.myroutdiscover.model.entity.User;
import com.example.myroutdiscover.model.service.UserServiceModel;
import com.example.myroutdiscover.model.view.UserViewModel;
import com.example.myroutdiscover.repository.UserRepository;
import com.example.myroutdiscover.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
private final UserRepository userRepository;
private final UserService userService;
private final ModelMapper modelMapper;

    public UserController(UserRepository userRepository, UserService userService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }
    @GetMapping("/register")
    public String register(Model model) {

        return "register";

    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel
            , BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel",
                    userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework" +
                    ".validation.BindingResult" +
                    ".userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }
userService.registerUser(
        modelMapper.map(userRegisterBindingModel, UserServiceModel.class));

       return "redirect:login";
    }


    @GetMapping("/login")
    public String login(Model model) {
if (!model.containsAttribute("isFound")){
    model.addAttribute("isFound",true);
}
        return "login";
    }
    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework" +
                    ".validation.BindingResult" +
                    ".userLoginBindingModel", bindingResult);

            return "redirect:login";
        }
        UserServiceModel userServiceModel =
                userService.findByUsernameAndPassword(userLoginBindingModel.getUsername()
                        , userLoginBindingModel.getPassword());
        if (userServiceModel == null) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("isFound", false);
            redirectAttributes.addFlashAttribute("org.springframework" +
                    ".validation.BindingResult" +
                    ".userLoginBindingModel", bindingResult);
            return "redirect:login";
        }

        userService.loginUser(userServiceModel.getId(), userLoginBindingModel.getUsername());
        return "redirect:/";
    }
    @GetMapping("/logout")
    private String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }
    @GetMapping("/profile/{id}")
    private String profile(@PathVariable Long id, Model model){


        model
                .addAttribute("user", modelMapper
                        .map(userService.findById(id), UserViewModel.class));

        return "profile";
    }
}
