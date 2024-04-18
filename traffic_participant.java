package org.example;

import java.util.Arrays;

public class traffic_participant {
    public double speed;
    public int [] position=new int[2];
    public String route;

    public traffic_participant(double predkosc, int poziom, int pion, String route) {
        this.speed = predkosc;
        this.position[0]=pion;
        this.position[1]=poziom;
        this.route= route;
    }
    public int[] getPosition() {
        return position;
    }
    void enter_the_map (traffic_participant ex,  int[][] map_of_objects){
        if(ex.getPosition()[0]==0||ex.getPosition()[0]==49||ex.getPosition()[1]==0||ex.getPosition()[1]==49){
            map_of_objects[ex.position[0]][ex.position[1]]=0;
            ex=null;
        }

    }
    public void going(traffic_participant ex, int[][] map_of_objects, char[][] traffic_map,Lights [] tablica_swiatel, Bus_stop[] przystanki){
        if (ex.route.isEmpty()) {
            enter_the_map(ex,map_of_objects);}
        else if (ex.route.charAt(0) == 'r') {// w prawo
            if (ex.position[1]<49&&map_of_objects[ex.position[0]][ex.position[1]+1] !=0){} // uniknięcie wypadku
             else if (ex.position[1]<49&&traffic_map[ex.position[0]][ex.position[1]+1] == 'v') {//pasy
                if (ex.position[0]+1==49||ex.position[0]-1==0) {}
                else {
                    if (map_of_objects[ex.position[0] + 1][ex.position[1] + 1] == 0 || map_of_objects[ex.position[0] - 1][ex.position[1] + 1]== 0) {
                        ex.moving(ex.route.charAt(0),map_of_objects);
                    }

                }
            }else if (traffic_map[ex.position[0]+1][ex.position[1]] == 'l') { //swiatła
                for (int i = 0; i < tablica_swiatel.length; i++) {// czekanie na światłach na zielone
                    if (tablica_swiatel[i].green_light[0]==ex.position[0] && tablica_swiatel[i].green_light[1]==ex.position[1]+1) {
                        ex.moving(ex.route.charAt(0),map_of_objects);
                    } else
                        for (int j = 0; j < tablica_swiatel[i].position.length; j++) { // jak wjedzie na światła to nie zatrzymuje sie
                            if ( tablica_swiatel[i].position[j][0]==ex.position[0] &&tablica_swiatel[i].position[j][1]==ex.position[1]) {
                                ex.moving(ex.route.charAt(0),map_of_objects);
                            }
                        }
                }
            }
            else {
                ex.moving(ex.route.charAt(0),map_of_objects);
            }
        }else if (ex.route.charAt(0) == 'l') {//w lewo
            if (ex.position[1]>0&&map_of_objects[ex.position[0]][ex.position[1]-1] !=0){}// uniknięcie wypadku
             else if (ex.position[1]>0&&traffic_map[ex.position[0]][ex.position[1]-1] == 'v') {//pasy
                if (ex.position[0]+1==49||ex.position[0]-1==0) {}
                else {
                    if (map_of_objects[ex.position[0] + 1][ex.position[1] - 1] == 0 || map_of_objects[ex.position[0] - 1][ex.position[1] - 1]== 0) {
                        ex.moving(ex.route.charAt(0),map_of_objects);
                    }

                }
            }else if (traffic_map[ex.position[0]+1][ex.position[1]] == 'l') { //swiatła
                for (int i = 0; i < tablica_swiatel.length; i++) {// czekanie na światłach na zielone
                    if (tablica_swiatel[i].green_light[0]==ex.position[0] && tablica_swiatel[i].green_light[1]==ex.position[1]-1) {
                        ex.moving(ex.route.charAt(0),map_of_objects);
                    } else
                        for (int j = 0; j < tablica_swiatel[i].position.length; j++) { // jak wjedzie na światła to nie zatrzymuje sie
                            if ( tablica_swiatel[i].position[j][0]==ex.position[0] &&tablica_swiatel[i].position[j][1]==ex.position[1]) {
                                ex.moving(ex.route.charAt(0),map_of_objects);
                            }
                        }
                }
            }
            else {
                ex.moving(ex.route.charAt(0),map_of_objects);
            }
        }
        else if (ex.route.charAt(0) == 'd') {// w dół
            if (map_of_objects[ex.position[0]-1][ex.position[1]] !=0){}// uniknięcie wypadku
            else if (traffic_map[ex.position[0]-1][ex.position[1]] == 'v') {//pasy
                if (ex.position[1]+1==49||ex.position[1]-1==0) {}
                else {
                    if (map_of_objects[ex.position[0] - 1][ex.position[1] - 1] == 0 || map_of_objects[ex.position[0] - 1][ex.position[1] + 1]== 0) {
                        ex.moving(ex.route.charAt(0),map_of_objects);
                    }

                }
            } else if (traffic_map[ex.position[0]][ex.position[1]+1] == 'l') {//światła
                for (int i = 0; i < tablica_swiatel.length; i++) {// czekanie na światłach na zielone
                    if (tablica_swiatel[i].green_light[0]==ex.position[0]-1 && tablica_swiatel[i].green_light[1]==ex.position[1]) {
                        ex.moving(ex.route.charAt(0),map_of_objects);
                    } else
                        for (int j = 0; j < tablica_swiatel[i].position.length; j++) { // jak wjedzie na światła to nie zatrzymuje sie
                            if ( tablica_swiatel[i].position[j][0]==ex.position[0] &&tablica_swiatel[i].position[j][1]==ex.position[1]) {
                                ex.moving(ex.route.charAt(0),map_of_objects);
                            }
                        }
                }
            }
            else {
                ex.moving(ex.route.charAt(0),map_of_objects);

            }
        }
        else if (ex.route.charAt(0) == 'u') {// w góre
            if (ex.position[0]<49&&map_of_objects[ex.position[0]+ 1][ex.position[1]] != 0) {
            } else if (ex.position[0]<49&&traffic_map[ex.position[0] + 1][ex.position[1]] == 'v') {//pasy
                if (ex.position[1] - 1 == 0 || ex.position[1] ==49) {}
                else {
                    if (map_of_objects[ex.position[0] + 1][ex.position[1] - 1] == 0 || map_of_objects[ex.position[0] + 1][ex.position[1] + 1]== 0) {
                        ex.moving(ex.route.charAt(0),map_of_objects);
                    }

                }
            } else if (traffic_map[ex.position[0]][ex.position[1] + 1] == 'l') {//światła
                for (int i = 0; i < tablica_swiatel.length; i++) {// czekanie na światłach na zielone
                    if (tablica_swiatel[i].green_light[0]==ex.position[0]+1 && tablica_swiatel[i].green_light[1]==ex.position[1]) {
                        ex.moving(ex.route.charAt(0),map_of_objects);
                    } else
                        for (int j = 0; j < tablica_swiatel[i].position.length; j++) { // jak wjedzie na światła to nie zatrzymuje sie
                            if ( tablica_swiatel[i].position[j][0]==ex.position[0] &&tablica_swiatel[i].position[j][1]==ex.position[1]) {
                                ex.moving(ex.route.charAt(0),map_of_objects);
                            }
                        }
                }
            }else {

                ex.moving(ex.route.charAt(0),map_of_objects);
            }
        }
    }
    void moving (char a,int[][] map_of_objects){
        if (a == 'u') {
            map_of_objects[this.position[0] - 1][this.position[1]] = map_of_objects[this.position[0]][this.position[1]];
            map_of_objects[this.position[0]][this.position[1]] = 0;
            this.position[0] -= 1;
            this.route = this.route.substring(1);
        }
        if (a == 'd') {
            map_of_objects[this.position[0] + 1][this.position[1]] = map_of_objects[this.position[0]][this.position[1]];
            map_of_objects[this.position[0]][this.position[1]] = 0;
            this.position[0] += 1;
            this.route = this.route.substring(1);
        }if (a == 'r') {
            map_of_objects[this.position[0] ][this.position[1]+ 1] = map_of_objects[this.position[0]][this.position[1]];
            map_of_objects[this.position[0]][this.position[1]] = 0;
            this.position[1] += 1;
            this.route = this.route.substring(1);
        }if (a == 'l') {
            map_of_objects[this.position[0] ][this.position[1]- 1] = map_of_objects[this.position[0]][this.position[1]];
            map_of_objects[this.position[0]][this.position[1]] = 0;
            this.position[1] -= 1;
            this.route = this.route.substring(1);
        }
    }
}
