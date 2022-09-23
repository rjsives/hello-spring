package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//handle request at path /hello
@Controller
@ResponseBody
@RequestMapping("hello")

public class HelloController {
//

        @GetMapping("goodbye")
        public String goodbye(){

            return "Goodbye, Spring!";
        }

        //Handles a request of the form /hello?name=LaunchCode
        @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value = "hello")
        public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";

        }

        //Handles requests of the form /hello/LaunchCode
   @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
            return "Hello, " + name + "!";
    }

//    @GetMapping("form")
//    @ResponseBody
//    public String helloForm(){
//            return "<html>" +
//                    "<body>" +
//                    "<form action= 'hello'>" +
//                    "<input type= 'text' name= 'name'>" +
//                    "<input type= 'submit' value= 'Greet me!'>" +
//                    "</form>" +
//                    "</body>" +
//                    "<html>";
//    }

        @GetMapping("form")
    public String helloForm(){
            return "<html>" +
                    "<body>" +
                    "<form action = 'hello' method= 'post'>" +
                    "<input type='text' name='name'>" +
                    "<input type= 'submit' value= 'Greet me!'>" +
                    "</form>" +
                    "</body>" +
                    "</html>";
    }
}
