package com.metao.dp.abstractfactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDesignPatterns {

    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB","500 GB","2.4 GHz"));
        Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB","1 TB","2.9 GHz"));
        System.out.println("AbstractFactory PC Config::"+pc);
        System.out.println("AbstractFactory Server Config::"+server);
    }
}