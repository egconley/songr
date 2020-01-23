package com.egconley.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Optional;

@Controller
public class SongrController {

    @Autowired
    AlbumRepository repo;

    @Autowired
    SongRepository songRepo;

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

    @GetMapping("/album")
    public String getAlbums(Model m) {

//        Album[] albums = new Album[] {
//            new Album("Revolver", "The Beatles", 10, 60, "https://dvfnvgxhycwzf.cloudfront.net/media/SharedImage/image450/.f11pRD9T/SharedImage-18245.jpg?t=1c473f4d0f94ab09549b"),
//            new Album("Please, please me", "The Beatles", 10, 60, "https://d2s36jztkuk7aw.cloudfront.net/sites/default/files/styles/tile_2_column_x2/public/tile/image/PleasePleaseMe_1.jpg?itok=dBEFCozM&timestamp=1373996074"),
//            new Album("The White Album", "The Beatles", 20, 120, "https://d2s36jztkuk7aw.cloudfront.net/sites/default/files/styles/tile_2_column_x2/public/tile/image/original_442.jpg?itok=AeZJfLPf&timestamp=1354886431"),
//        };

//        repo.save(new Album("Revolver", "The Beatles", 10, 60, "https://dvfnvgxhycwzf.cloudfront.net/media/SharedImage/image450/.f11pRD9T/SharedImage-18245.jpg?t=1c473f4d0f94ab09549b"));
//        repo.save(new Album("Please, please me", "The Beatles", 10, 60, "https://d2s36jztkuk7aw.cloudfront.net/sites/default/files/styles/tile_2_column_x2/public/tile/image/PleasePleaseMe_1.jpg?itok=dBEFCozM&timestamp=1373996074"));
//        repo.save(new Album("The White Album", "The Beatles", 20, 120, "https://d2s36jztkuk7aw.cloudfront.net/sites/default/files/styles/tile_2_column_x2/public/tile/image/original_442.jpg?itok=AeZJfLPf&timestamp=1354886431"));
        List<Album> albums = repo.findAll();
        m.addAttribute("albums", albums);
        return "albums";
    }

    @PostMapping("/album")
    public RedirectView addAlbum(String title, String artist, Integer songCount, double length, String imageUrl) {
        Album album = new Album(title, artist, songCount, length, imageUrl);
        repo.save(album);
        return new RedirectView("/album");
    }

    @GetMapping("/album/{album_id}")
    public String getAlbum(Model m, @PathVariable Long album_id) {
//        Optional<Album> album = repo.findById(album_id);
        m.addAttribute("album", repo.getOne(album_id));
        return "album";
    }

    @PostMapping("/album/{album_id}/songs")
    public RedirectView addSong(Model m, @PathVariable Long album_id, String title, double length, int trackNumber) {
        Album album = repo.getOne(album_id);
        Song song = new Song(title, length, trackNumber);
        song.setAlbum(album);
        songRepo.save(song);
        return new RedirectView("/album/" + album_id);
    }
}
