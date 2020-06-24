package sampleannotation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Application {
    public static void main(String[] args) throws Exception {
        Request req = new Request();
        req.validate();
        System.out.println(req);
    }
}
