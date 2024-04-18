package org.example;

import java.util.Arrays;

public class Person extends traffic_participant {
    public Person(double predkosc, int poziom, int pion,String route) {
        super(predkosc, poziom, pion,route);
    }
    void enter_the_map_or_bus_stop (int[][] map_of_objects,Bus_stop[] przystanki ){
        for (int i = 0; i < przystanki.length ; i++) {
            if (this.position[0] == przystanki[i].position[0]&&this.position[1] == przystanki[i].position[1]) {
                System.out.println("hurra");
                przystanki[i].numberOfPeople++;
                map_of_objects[this.position[0]][this.position[1]]=0;
                this.route="";
                this.position= new int[]{0, 0};
            }
        }
        if(this.position[0]==0||this.position[0]==49||this.position[1]==0||this.position[1]==49){
            map_of_objects[this.position[0]][this.position[1]]=0;
        }
    }
    public void going(Person ex, int[][] map_of_objects,Bus_stop[] przystanki){
        if (ex.route.isEmpty()) {
            enter_the_map_or_bus_stop(map_of_objects,przystanki);}// wychodzenie z planszy
            else if (ex.route.charAt(0) == 'r') {    // przejście w prawo
                if (map_of_objects[ex.position[0]][ex.position[1]+1] !=0){
                }
                else {
                    ex.moving(ex.route.charAt(0),map_of_objects);
                }
            }
            else if (ex.route.charAt(0) == 'u') {//przejście w dół
                if (ex.position[1]-1>0){
                    if (map_of_objects[ex.position[0]-1][ex.position[1]] !=0){
                }
                else {
                        ex.moving(ex.route.charAt(0),map_of_objects);
                }
            }}
            else if (ex.route.charAt(0) == 'd') { //przejście w dół
                if (map_of_objects[ex.position[0]+1][ex.position[1]] !=0){
                }
                else {
                    ex.moving(ex.route.charAt(0),map_of_objects);
                }

            }
            else if (ex.route.charAt(0) == 'l') {  //przjście w lewo
                if (ex.position[1]-1>0){
                    if (map_of_objects[ex.position[0]][ex.position[1]-1] !=0){
                    }
                else {ex.moving(ex.route.charAt(0),map_of_objects);}
                }

            }
    }

}
