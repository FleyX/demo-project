package com.fxb.h5websocket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ${fxb}
 * Email: fanxb.tl@gmail.com
 * Date: 2018-08-01
 */
@RestController
public class HomeController {

    @GetMapping("/broadcast")
    public void broadcast(){
        MyWebSocket.broadcast();
    }
}
