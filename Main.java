package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String output = "build/resources/traffic_map_output.txt";
        int[][] map_of_objects = new int[50][50];
        for (int[] wiersz : map_of_objects) {
            for (int znak : wiersz) {
                znak = 0;
            }
            System.out.println();
        }
        char[][] traffic_map = new char[50][50];
        try {
            File plik = new File("build/resources/traffic_map.txt");

            Scanner scanner = new Scanner(plik);
            // Wpisanie zawartości pliku do tablicy
            int wierszIndex = 0;
            while (scanner.hasNextLine()) {
                String wiersz = scanner.nextLine();
                for (int kolumnaIndex = 0; kolumnaIndex < wiersz.length(); kolumnaIndex++) {
                    traffic_map[wierszIndex][kolumnaIndex] = wiersz.charAt(kolumnaIndex);
                }
                wierszIndex++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
//        // Wyświetlenie zawartości tablicy
        for (char[] wiersz : traffic_map) {
            for (char znak : wiersz) {
                System.out.print(znak);
            }
            System.out.println();
        }
        Auto auto1 = new Auto(300, 0, 5, "rrddddddddrrrrrrrrdddddddddddrrrrrrrrrrrrrrrrrrrrruuuuuuuuuuuuuuuuuuuuuuuu");
        map_of_objects[auto1.position[0]][auto1.position[1]] = 1;
        Auto auto2 = new Auto(400, 49, 34, "lllllllllllllllllluuuuullllllllluuuuuullllllllllllddddddllllllllll");
        map_of_objects[auto2.position[0]][auto2.position[1]] = 2;
        Auto auto3 = new Auto(500, 11, 49, "uuuuuuuuuuuuuurrrrrrrrrrrrrrrrrrrdddddddrrrrrrrrruuuuuuuuuuuuuuuuuuuuuuuuuuuuuulllllllluuuuuuuuuuuu");
        map_of_objects[auto3.position[0]][auto3.position[1]] = 3;
        Bus bus1 = new Bus(80, 3, "lllddddddddllllllllddddddlllllllllllllllllllllllllllldddddddddddddddddrrrrrrrrrrrrrrrrrrrrrrrrrrrrdddddddddddllllllllddd", 200, 49,4 );
        map_of_objects[bus1.position[0]][bus1.position[1]] = 4;
        System.out.println(Arrays.toString(bus1.start_point));
        Bus bus2 = new Bus(70, 10, "lllddddddddddddddddddllllllllllllllluuuuuuuuuuuulllllllllllllllllllllddddddddddddllllllluuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuurrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrruuuu", 100, 49,22 );
        map_of_objects[bus2.position[0]][bus2.position[1]] = 5;
        Person osoba = new Person(700, 6, 3, "rruuu");
        map_of_objects[osoba.position[0]][osoba.position[1]] = 6;
        Lights swiatla1 = new Lights(4,10);
        Lights swiatla2 = new Lights( 4,38);
        Lights swiatla3 = new Lights(18,21 );
        Lights swiatla4 = new Lights( 18,47);
        Lights swiatla5 = new Lights(23,10 );
        Lights swiatla6 = new Lights(29,2 );
        Lights swiatla7 = new Lights( 29,38);
        Lights swiatla8 = new Lights(41,10 );
        Lights swiatla9 = new Lights( 41,30);
        Lights[] tablica_swiatel = new Lights[]{swiatla1, swiatla2, swiatla3, swiatla4, swiatla5, swiatla6, swiatla7, swiatla8, swiatla9};
        Bus_stop przystanek1 = new Bus_stop(40,1,  0);
        Bus_stop przystanek2 = new Bus_stop(28,6, 0);
        Bus_stop przystanek3 = new Bus_stop(4,7, 3);
        Bus_stop przystanek4 = new Bus_stop(45, 9,1);
        Bus_stop przystanek5 = new Bus_stop(17,17, 5);
        Bus_stop przystanek6 = new Bus_stop(35, 17,10);
        Bus_stop przystanek7 = new Bus_stop(4,21, 3);
        Bus_stop przystanek8 = new Bus_stop(9, 26,1);
        Bus_stop przystanek9 = new Bus_stop(45,26, 6);
        Bus_stop przystanek10 = new Bus_stop(17, 28,0);
        Bus_stop przystanek11 = new Bus_stop(18,36, 9);
        Bus_stop przystanek12 = new Bus_stop(45,39, 6);
        Bus_stop przystanek13 = new Bus_stop(9, 39, 0);
        Bus_stop przystanek14 = new Bus_stop(36, 40,0);
        Bus_stop przystanek15 = new Bus_stop(36, 45,7);
        Bus_stop[] przystanki = new Bus_stop[]{przystanek1, przystanek2, przystanek3, przystanek4, przystanek5, przystanek6,
                przystanek7, przystanek8, przystanek9, przystanek10, przystanek11, przystanek12, przystanek13, przystanek14, przystanek15};
        Auto[] tab_aut = new Auto[]{auto1, auto2, auto3};
        Bus[] tab_bus = new Bus[]{bus1, bus2};
        int loop=100;
        boolean if_clean=false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output,false))) {
            for (int[] wiersz : map_of_objects) {
                for (int znak : wiersz) {
                    writer.write(String.valueOf(znak));
                    writer.write(" ");
                }
                writer.newLine();
            }
            writer.newLine();
        } catch (IOException e) {}
        for (int[] wiersz : map_of_objects) {
            for (int znak : wiersz) {
                System.out.print(znak);
            }
            System.out.println();
        }
        System.out.println();
        do {
            if_clean=true;
            for (int i = 0; i < tab_aut.length; i++) {
                if (loop %tab_aut[i].speed == 0) {
                    tab_aut[i].going(tab_aut[i], map_of_objects, traffic_map, tablica_swiatel, przystanki);}
            }
            for (int i = 0; i < tab_bus.length; i++) {
                if (loop % tab_bus[i].speed == 0) {
                    tab_bus[i].going(map_of_objects, traffic_map, tablica_swiatel, przystanki);}
            }
            if (loop % osoba.speed  == 0) {
                osoba.going(osoba, map_of_objects,przystanki);}
            for (int[] wiersz : map_of_objects) {
                for (int znak : wiersz) {
                    System.out.print(znak);
                }
                System.out.println();
            } System.out.println();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(output,true))) {
                for (int[] wiersz : map_of_objects) {
                    for (int znak : wiersz) {
                        writer.write(String.valueOf(znak));
                        writer.write(" ");
                    }
                    writer.newLine();
                }
                writer.newLine();
            } catch (IOException e) {}
            if (loop % 700==0) {
                for (int i = 0; i < tablica_swiatel.length; i++) {
                    tablica_swiatel[i].change_light();
                }
            }
            for (int[] wiersz : map_of_objects) {
                for (int znak : wiersz) {
                    if (znak != 0) {
                        if_clean=false;
                    }
                }
            }
            for (int i = 0; i <przystanki.length; i++) {
                if(przystanki[i].numberOfPeople>0){
                    if_clean=false;
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(output,true))) {
                    for (int i= 0; i < przystanki.length; i++) {
                        writer.write("Na przystanku "+(i+1)+" jest "+przystanki[i].numberOfPeople+" ludzi");
                        writer.newLine();
                    }
                writer.newLine();
            } catch (IOException e) {}
            for (int i = 0; i < przystanki.length; i++) {
                System.out.println("Na przystanku "+(i+1)+" jest "+przystanki[i].numberOfPeople+"ludzi");
            }
            loop += 100;
        }  while (!if_clean);
    }
}