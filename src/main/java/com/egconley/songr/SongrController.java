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
            new Album("Revolver", "The Beatles", 10, 60, "https://dvfnvgxhycwzf.cloudfront.net/media/SharedImage/image450/.f11pRD9T/SharedImage-18245.jpg?t=1c473f4d0f94ab09549b"),
            new Album("Please, please me", "The Beatles", 10, 60, "https://d2s36jztkuk7aw.cloudfront.net/sites/default/files/styles/tile_2_column_x2/public/tile/image/PleasePleaseMe_1.jpg?itok=dBEFCozM&timestamp=1373996074"),
            new Album("The White Album", "The Beatles", 20, 120, "https://d2s36jztkuk7aw.cloudfront.net/sites/default/files/styles/tile_2_column_x2/public/tile/image/original_442.jpg?itok=AeZJfLPf&timestamp=1354886431"),
        };
        m.addAttribute("albums", albums);
        return "album";
    }
}
