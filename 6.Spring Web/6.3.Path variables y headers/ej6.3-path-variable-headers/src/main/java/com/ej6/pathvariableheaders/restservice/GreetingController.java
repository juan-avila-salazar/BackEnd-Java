package com.ej6.pathvariableheaders.restservice;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/greeting")
public class GreetingController {
    List<Greeting> listGreeting = new ArrayList<>();
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = "/hello")
    public Greeting hello(@RequestParam(value = "content", defaultValue = "World") String content) {
        return new Greeting(counter.incrementAndGet(), String.format(template, content));
    }
    @PostMapping(value = "/addgreeting")
    public Greeting addGreeting(@RequestBody Greeting greeting,
                                @RequestParam(value = "content", defaultValue = "World") String content){
        listGreeting.add(greeting);
        return new Greeting(counter.incrementAndGet(), String.format(template, content));
    }
    @PutMapping (value = "/editgreeting")
    public Greeting edit(@RequestParam(value = "content", defaultValue = "World")String content,
                         @RequestParam long id) {
        return new Greeting(id , content);
    }
    @GetMapping("/totallist")
    public List<Greeting> totalList (){
        listGreeting.stream().toList();
        return listGreeting;
    }
    @GetMapping(value = "/search/{id}")
    public List<Greeting> llamar(@PathVariable long id) {
        List<Greeting> listId = listGreeting.stream().filter((ap)->ap.getId()==id).toList();
        return listId;
    }



}
