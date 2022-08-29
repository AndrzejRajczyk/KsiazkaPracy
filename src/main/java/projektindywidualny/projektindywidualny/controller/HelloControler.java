package projektindywidualny.projektindywidualny.controller;

import org.springframework.web.bind.annotation.GetMapping;
import projektindywidualny.projektindywidualny.DTO.MessageDto;

public class HelloControler {
    @GetMapping("/")
    public MessageDto hello() {
        return new MessageDto("Hello world - login sukcesfull");
    }
    @GetMapping("/secured")
    public MessageDto helloSecured() {
        return new MessageDto("Hello secured - login failed");
    }
}
