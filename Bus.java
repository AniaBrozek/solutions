package org.example;

import java.util.Arrays;

public class Bus extends Auto {
    public final int[] start_point=new int[2];
    public int totalSeats;
    public int currentPassengers;
    private final String static_route;

    public Bus(int totalSeats, int currentPassengers, String route,double predkosc, int poziom, int pion) {
        super(predkosc,poziom,pion, route);
        this.totalSeats = totalSeats;
        this.currentPassengers = currentPassengers;
        this.start_point[0]=pion;
        this.start_point[1]=poziom;
        this.static_route=route;
    }

    public void going(int[][] map_of_objects, char[][] traffic_map,Lights [] tablica_swiatel, Bus_stop[] przystanki){
            if (this.route.isEmpty()) {
            enter_the_map(map_of_objects);}
            else if (this.route.charAt(0) == 'r') {// w prawo
                if (this.position[1]<49&&map_of_objects[this.position[0]][this.position[1]+1] !=0){} // uniknięcie wypadku
                else if (this.position[0]<49&&this.position[1]<49&&traffic_map[this.position[0]+1][this.position[1]+1] == 'b') {//przystanek
                    this.moving(this.route.charAt(0),map_of_objects);
                    for (int i = 0; i < przystanki.length; i++) {
                        if (przystanki[i].position[0]==this.position[0]+1 && przystanki[i].position[1]==this.position[1]){
                            wsiadanie_przystanek(przystanki[i]);
                        }
                    }
                } else if (this.position[1]<49&&traffic_map[this.position[0]][this.position[1]+1] == 'v') {//pasy
                    if (this.position[0]+1==49||this.position[0]-1==0) {}
                    else {
                        if (map_of_objects[this.position[0] + 1][this.position[1] + 1] == 0 || map_of_objects[this.position[0] - 1][this.position[1] + 1]== 0) {
                            this.moving(this.route.charAt(0),map_of_objects);
                        }

                    }
                }else if (traffic_map[this.position[0]+1][this.position[1]] == 'l') { //swiatła
                    for (int i = 0; i < tablica_swiatel.length; i++) {// czekanie na światłach na zielone
                        if (tablica_swiatel[i].green_light[0]==this.position[0] && tablica_swiatel[i].green_light[1]==this.position[1]+1) {
                            this.moving(this.route.charAt(0),map_of_objects);
                        } else
                            for (int j = 0; j < tablica_swiatel[i].position.length; j++) { // jak wjedzie na światła to nie zatrzymuje się
                                if ( tablica_swiatel[i].position[j][0]==this.position[0] &&tablica_swiatel[i].position[j][1]==this.position[1]) {
                                    this.moving(this.route.charAt(0),map_of_objects);
                                }
                            }
                    }
                }
                else {
                    this.moving(this.route.charAt(0),map_of_objects);
                }
            }else if (this.route.charAt(0) == 'l') {//w lewo
                if (this.position[1]>0&&map_of_objects[this.position[0]][this.position[1]-1] !=0){}// uniknięcie wypadku
                else if (this.position[0]>0&&this.position[1]>0&&traffic_map[this.position[0]-1][this.position[1]-1] == 'b') {//przystanek
                    this.moving(this.route.charAt(0),map_of_objects);
                    for (int i = 0; i < przystanki.length; i++) {
                        if (przystanki[i].position[0]==this.position[0]-1 && przystanki[i].position[1]==this.position[1]){
                            wsiadanie_przystanek(przystanki[i]);
                        }
                    }
                } else if (this.position[1]>0&&traffic_map[this.position[0]][this.position[1]-1] == 'v') {//pasy
                        if (this.position[0]<49&&map_of_objects[this.position[0] + 1][this.position[1] - 1] == 0 || map_of_objects[this.position[0] - 1][this.position[1] - 1]== 0) {
                            this.moving(this.route.charAt(0),map_of_objects);
                        }
                }else if (this.position[0]<49&&traffic_map[this.position[0]+1][this.position[1]] == 'l') { //swiatła
                    for (int i = 0; i < tablica_swiatel.length; i++) {// czekanie na światłach na zielone
                        if (tablica_swiatel[i].green_light[0]==this.position[0] && tablica_swiatel[i].green_light[1]==this.position[1]-1) {
                            this.moving(this.route.charAt(0),map_of_objects);
                        } else
                            for (int j = 0; j < tablica_swiatel[i].position.length; j++) { // jak wjedzie na światła to nie zatrzymuje się
                                if ( tablica_swiatel[i].position[j][0]==this.position[0] &&tablica_swiatel[i].position[j][1]==this.position[1]) {
                                    this.moving(this.route.charAt(0),map_of_objects);
                                }
                            }
                    }
                }
                else {
                    this.moving(this.route.charAt(0),map_of_objects);
                }
            }
            else if (this.route.charAt(0) == 'd') {// w dół
                if (this.position[0]>0&&map_of_objects[this.position[0]-1][this.position[1]] !=0){}// uniknięcie wypadku
                else if(this.position[1]>0&&this.position[0]<49&&traffic_map[this.position[0]+1][this.position[1]-1] == 'b') { //przystanek
                    this.moving(this.route.charAt(0),map_of_objects);
                    for (int i = 0; i < przystanki.length; i++) {
                        if (przystanki[i].position[0]==this.position[0] && przystanki[i].position[1]==this.position[1]-1){
                            wsiadanie_przystanek(przystanki[i]);
                        }
                    }
                }
                else if (this.position[0]>0&&traffic_map[this.position[0]-1][this.position[1]] == 'v') {//pasy
                    if (this.position[1]+1==49||this.position[1]-1==0) {}
                         else {
                        if (map_of_objects[this.position[0] - 1][this.position[1] - 1] == 0 || map_of_objects[this.position[0] - 1][this.position[1] + 1]== 0) {
                            this.moving(this.route.charAt(0),map_of_objects);
                        }

                    }
                } else if (traffic_map[this.position[0]][this.position[1]+1] == 'l') {//światła
                    for (int i = 0; i < tablica_swiatel.length; i++) {// czekanie na światłach na zielone
                        if (tablica_swiatel[i].green_light[0]==this.position[0]-1 && tablica_swiatel[i].green_light[1]==this.position[1]) {
                            this.moving(this.route.charAt(0),map_of_objects);
                        } else
                            for (int j = 0; j < tablica_swiatel[i].position.length; j++) { // jak wjedzie na światła to nie zatrzymuje się
                                if ( tablica_swiatel[i].position[j][0]==this.position[0] &&tablica_swiatel[i].position[j][1]==this.position[1]) {
                                    this.moving(this.route.charAt(0),map_of_objects);
                                }
                            }
                    }
                }
                else {
                    this.moving(this.route.charAt(0),map_of_objects);

                }
            }
            else if (this.route.charAt(0) == 'u') {// w góre
                    if (map_of_objects[this.position[0]+ 1][this.position[1]] != 0) {
                    } else if (traffic_map[this.position[0] - 1][this.position[1]+1] == 'b') {//przystanek
                        this.moving(this.route.charAt(0),map_of_objects);
                        for (int i = 0; i < przystanki.length; i++) {
                            if (przystanki[i].position[0] == this.position[0]  && przystanki[i].position[1] == this.position[1]+ 1) {
                                wsiadanie_przystanek(przystanki[i]);
                            }
                        }
                    } else if (traffic_map[this.position[0] + 1][this.position[1]] == 'v') {//pasy
                        if (this.position[1] - 1 == 0 || this.position[1] ==49) {}
                        else {
                            if (map_of_objects[this.position[0] + 1][this.position[1] - 1] == 0 || map_of_objects[this.position[0] + 1][this.position[1] + 1]== 0) {
                                this.moving(this.route.charAt(0),map_of_objects);
                            }

                        }
                    } else if (traffic_map[this.position[0]][this.position[1] + 1] == 'l') {//światła
                        for (int i = 0; i < tablica_swiatel.length; i++) {// czekanie na światłach na zielone
                            if (tablica_swiatel[i].green_light[0]==this.position[0]+1 && tablica_swiatel[i].green_light[1]==this.position[1]) {
                                this.moving(this.route.charAt(0),map_of_objects);
                            } else
                                for (int j = 0; j < tablica_swiatel[i].position.length; j++) { // jak wjedzie na światła to nie zatrzymuje się
                                    if ( tablica_swiatel[i].position[j][0]==this.position[0] &&tablica_swiatel[i].position[j][1]==this.position[1]) {
                                        this.moving(this.route.charAt(0),map_of_objects);
                                    }
                                }
                        }
                    }else {
                        this.moving(this.route.charAt(0),map_of_objects);
                    }
                }

    }

    void enter_the_map(int[][] map_of_objects) {
            if(this.getPosition()[0]==0||this.getPosition()[0]==49||this.getPosition()[1]==0||this.getPosition()[1]==49){
                map_of_objects[this.start_point[0]][this.start_point[1]]=map_of_objects[this.position[0]][this.position[1]];
                map_of_objects[this.position[0]][this.position[1]]=0;
                this.position=this.start_point;
                this.currentPassengers=0;
                this.route=this.static_route;
                System.out.println("new");
            }
    }
    void wsiadanie_przystanek (Bus_stop przystanek){
        if(this.totalSeats-this.currentPassengers>przystanek.numberOfPeople){
            this.currentPassengers+=przystanek.numberOfPeople;
            przystanek.numberOfPeople=0;
        } else if (this.totalSeats!=this.currentPassengers) {
            przystanek.numberOfPeople-=this.totalSeats-this.currentPassengers;
            this.currentPassengers=this.totalSeats;
        }
    }
}

