package com.egconley.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SongrController {

    String hello = "Hello";

    @GetMapping("/")
    public String getHome(Model m) {
        m.addAttribute("username", "Ellen");
        return "home";
    }

    @GetMapping("/hello")
    public String getHelloWorld(Model m) {
        m.addAttribute("hello", hello + ", world!");
        return "hello";
    }

    @GetMapping("/capitalize/{hello}")
    @ResponseBody
    public String getCapitalizeHello(@PathVariable String hello) {
        return hello.toUpperCase();
    }

    @GetMapping("/Album")
    public String getAlbums(Model m) {

        Album[] albums = new Album[] {
            new Album("Revolver", "The Beatles", 10, 60, "example.jpg"),
            new Album("Please, please me", "The Beatles", 10, 60, "example.jpg"),
            new Album("The White Album", "The Beatles", 20, 120, "example.jpg"),
        };
        m.addAttribute("albums", albums);
        return "album";
    }
}
