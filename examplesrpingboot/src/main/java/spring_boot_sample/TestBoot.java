package spring_boot_sample;


import org.springframework.boot.SpringApplication;
import spring_boot_sample.controller.NameController;


public class TestBoot {

    public static void main(String[] args) {
        SpringApplication.run(NameController.class , args);
    }

}
