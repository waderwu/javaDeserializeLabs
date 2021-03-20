package com.yxxx.javasec.deserialize;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

@Controller
public class IndexController {
    @RequestMapping("/basic")
    public String greeting(@RequestParam(name="data", required=true) String data, Model model) throws Exception {
        byte[] b = Utils.hexStringToBytes(data);
        InputStream inputStream = new ByteArrayInputStream(b);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        objectInputStream.readObject();
        return "index";
    }
}
