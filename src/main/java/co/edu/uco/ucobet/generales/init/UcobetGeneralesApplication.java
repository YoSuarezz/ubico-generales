package co.edu.uco.ucobet.generales.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("co.edu.uco.ucobet")
public class UcobetGeneralesApplication {

    public static void main(String[] args) {
        SpringApplication.run(UcobetGeneralesApplication.class, args);
    }
}
