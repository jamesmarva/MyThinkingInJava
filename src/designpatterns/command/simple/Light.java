package designpatterns.command.simple;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.rmi.ssl.SslRMIClientSocketFactory;

/**
 * @author james reall008@163.com  10/20/2018
 */
public class Light {

    public Light() {}

    public Light(String location) {
    }

    public void on() {
        System.out.println("Simple Light is on");
    }

    public void off() {
        System.out.println("Simple Light is off");
    }
}
