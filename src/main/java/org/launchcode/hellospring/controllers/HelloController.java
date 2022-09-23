package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//handle request at path /hello
@Controller
@ResponseBody
@RequestMapping("hello")

public class HelloController {
    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
        @GetMapping("goodbye")
        public String goodbye(){

            return "Goodbye, Spring!";
        }

        //Handles a request of the form /hello?name=LaunchCode
//        @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value = "hello")
//        public String helloWithQueryParam(@RequestParam String name, @RequestParam String language){
//        return "Hello, " + name + "!";
//
//        }

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
    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language){
            if(name == ""){
                name = "World";
            }

            return createMessage(name,language);
    }

    public static String createMessage(String chosenName, String chosenLanguage){
            String greeting = "";

            if(chosenLanguage.equals("english")) {
                greeting = "Hello";
            }
            else if (chosenLanguage.equals("")){
                greeting = "Hello";
            }
            else if (chosenLanguage.equals("russian")){
                greeting = "Privet";
            }
            else if (chosenLanguage.equals("german")){
                greeting = "Hallo";
            }
            else if (chosenLanguage.equals("spanish")){
                greeting = "\u00A1" + "Hola";
            }
            else if(chosenLanguage.equals("danish")){
                greeting = "Hej";
            }

            return greeting + " " + chosenName + "!";
    }

    // /hello/form
        @GetMapping("form")
    public String helloForm(){
            return "<html>" +
                    "<body>" +
                    "<form action = 'hello' method= 'post'>" + // submit a request to /hello
                    "<input type='text' name='name'>" +
                    "<select name='language'>" +
                    "<option value=''>--Select Language--<option>" +
                    "<option value='english'>English<option>" +
                    "<option value='russian'>Russian<option>" +
                    "<option value='german'>German<option>" +
                    "<option value='spanish'>Spanish<option>" +
                    "<option value='danish'>Danish<option>" +
                    "</select>" +
                    "<input type= 'submit' value= 'Greet me!'>" +
                    "</form>" +
                    "</body>" +
                    "</html>";
    }
}
