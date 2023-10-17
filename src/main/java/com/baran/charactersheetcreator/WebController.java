package com.baran.charactersheetcreator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {
    @GetMapping(value = "/Hello")
    @ResponseBody
    public String getRoot() {
        return "Hello World";
    }

    @GetMapping(value = "/")
    public String getCharacterCreator(){
        return "charactercreator";
    }

}
