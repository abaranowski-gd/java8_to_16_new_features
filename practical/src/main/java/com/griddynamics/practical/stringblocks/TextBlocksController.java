package com.griddynamics.practical.stringblocks;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class TextBlocksController {
    private static final String AUTHOR = "WALT WHITMAN";
    private static final String POEM = "For You O Democracy\n" +
            "BY %s\n" +
            "Come, I will make the continent indissoluble,\n" +
            "I will make the most splendid race the sun ever shone upon,\n" +
            "I will make divine magnetic lands,\n" +
            "                   With the love of comrades,\n" +
            "                      With the life-long love of comrades.\n" +
            "\n" +
            "I will...";

    @GetMapping("/getPoem")
    public ResponseEntity<String> getRequest(HttpServletRequest request){
        return ResponseEntity.ok().body(POEM.formatted(AUTHOR));
    }

}
