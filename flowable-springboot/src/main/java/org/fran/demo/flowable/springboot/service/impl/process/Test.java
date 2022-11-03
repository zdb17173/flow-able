package org.fran.demo.flowable.springboot.service.impl.process;

import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(f.parse("1986-11-14").getTime());
        System.out.println(f.parse("1900-11-14").getTime() > f.parse("2021-01-10").getTime());

        File file = new File("C:\\Users\\fran\\Desktop\\测试数据\\ended.jpg");
        try {
            FileInputStream in = new FileInputStream(file);

            byte[] b = new byte[Long.valueOf(file.length()).intValue()];
            in.read(b);
            byte[] bb = Base64.getEncoder().encode(b);
            System.out.println(new String(bb));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
