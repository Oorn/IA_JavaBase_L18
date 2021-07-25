
package com.company;



import javax.sound.midi.spi.SoundbankReader;
import java.io.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HW18 {
    public static class ExceptionTaskNumber extends Exception {
        ExceptionTaskNumber() {
            super("Invalid task number");
        }
    }

    public static class ExceptionNegative extends Exception {
        ExceptionNegative() {
            super("value cannot be negative");
        }
    }

    public static void main(String[] args) {
        Random ran = new Random();
        Scanner in = new Scanner(System.in);

        //Logger log = Logger.getLogger(HW11.class.getName());
        Logger log = Logger.getAnonymousLogger();
        log.setUseParentHandlers(false);
        log.setLevel(Level.FINER); //level at which throwing is logged
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.FINER);
        log.addHandler(handler);
        //SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            System.out.print("Enter task number, from 1 to 6: ");
            int taskNumber = in.nextInt();
            in.nextLine();

            switch (taskNumber) {
                case 1:
                    // 1
                    CountryMap c1 = new CountryMap();
                    c1.addCountry("Belarus");
                    c1.addCountry("Russia");
                    c1.addRegionToCountry("Minskaya Voblast", "Belarus");
                    c1.addRegionToCountry("Gomelskaya Voblast", "Belarus");
                    c1.addTownToCountry("Minsk", "Belarus");
                    c1.addTownToRegionCountry("Gomel", "Belarus", "Gomelskaya Voblast");
                    System.out.println(c1);
                    System.out.println(c1.getGeoObjFromCountry("Minsk", "Belarus").adminObjectString());

                    break;

                case 2:
                    //2
                    System.out.println("//todo");

                    break;

                case 3:
                    //3
                    System.out.println("//todo");

                    break;

                case 4:
                    //4
                    CountryMap c4 = new CountryMap();
                    c4.addCountry("Belarus");
                    c4.addCountry("Russia");
                    c4.addRegionToCountry("Minskaya Voblast", "Belarus");
                    c4.addRegionToCountry("Gomelskaya Voblast", "Belarus");
                    c4.addTownToCountry("Minsk", "Belarus");
                    c4.addTownToRegionCountry("Gomel", "Belarus", "Gomelskaya Voblast");
                    ArrayList<GeographicalAdminObject> ral4 = c4.toList();
                    ral4.forEach(System.out::println);
                    System.out.println();

                    GetTopRegionVisitor gtrv4 = new GetTopRegionVisitor();
                    ral4.forEach((o) -> {
                        o.accept(gtrv4);
                        System.out.println(o.adminObjectString() + " - " + gtrv4.getResult());
                        gtrv4.reset();
                    });


                    break;

                case 5:
                    //5
                    PostalOffice po5 = new PostalOffice();
                    Subscriber s51 = new Subscriber("sub1");
                    Subscriber s52 = new Subscriber("sub2");
                    Subscriber s53 = new Subscriber("sub3");
                    po5.subscribe(s51, "journal1");
                    po5.subscribe(s51, "journal2");
                    po5.subscribe(s52, "journal2");
                    po5.subscribe(s52, "journal3");
                    po5.subscribe(s53, "journal3");
                    po5.receivePublishable(new Publishable("journal1", "issue1"));
                    po5.receivePublishable(new Publishable("journal2", "issue1"));
                    po5.receivePublishable(new Publishable("journal3", "issue1"));
                    po5.receivePublishable(new Publishable("journal2", "issue2"));


                    break;
                case 6:
                    //6
                    System.out.println("//todo");


                    break;



                default:
                    throw new ExceptionTaskNumber();
            }
        } catch (InputMismatchException | ExceptionTaskNumber ex) {
            System.out.println("Error - " + ex);
        } finally {
            in.close();
        }
    }


}