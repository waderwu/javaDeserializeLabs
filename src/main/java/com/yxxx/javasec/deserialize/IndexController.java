package com.yxxx.javasec.deserialize;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.ObjectInputStream;

@Controller
public class IndexController {
    @RequestMapping("/basic")
    public String greeting(@RequestParam(name="data", required=true) String data, Model model) throws Exception {
        byte[] b = Utils.hexStringToBytes(data);
        InputStream inputStream = new ByteArrayInputStream(b);
        ObjectInputStream objectInputStream = new MyObjectInputStream(inputStream);
        String name = objectInputStream.readUTF();
        int year = objectInputStream.readInt();
        if (name.equals("SJTU") && year == 1896){
            objectInputStream.readObject();
        }
        return "index";
    }
}
