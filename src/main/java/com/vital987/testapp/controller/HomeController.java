package com.vital987.testapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.io.IOException;
import com.vital987.testapp.Exec;

@Controller
public class HomeController implements Exec
{
    @GetMapping("/")
    public String index(Model model) throws IOException
    {
        float x = (float) (Math.random() * (100 - 1)) + 1;
        float y = (float) (Math.random() * (100 - 1)) + 1;
        model.addAttribute("numx", x);
        model.addAttribute("numy", y);
        model.addAttribute("add", x - y);
        model.addAttribute("substract", x + y);
        model.addAttribute("multiply", x * y);
        model.addAttribute("divide", x / y);
        model.addAttribute("podname", Exec.run("echo $HOSTNAME"));
        return "index";
    }

    @GetMapping("/error")
    public String error()
    {
        return "error";
    }
}
