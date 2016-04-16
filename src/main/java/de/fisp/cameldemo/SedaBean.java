package de.fisp.cameldemo;

public class SedaBean {

    public String doSomething(String body) throws InterruptedException {
        System.out.println("body = " + body);
        Thread.sleep(100);
        return "processed!";
    }
}
