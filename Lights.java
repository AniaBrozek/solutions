package org.example;

import java.util.Arrays;

public class Lights {
    public int [][] position=new int[4][2]; ///pozycja dla 4 "kratek"
    public int [] green_light;

    public Lights(int pion, int poziom){
        this.position[0][0]= pion;
        this.position[0][1]=poziom;
        this.position[1][0]= pion +1;
        this.position[1][1]=poziom;
        this.position[2][0]= pion;
        this.position[2][1]=poziom+1;
        this.position[3][0]= pion +1;
        this.position[3][1]=poziom+1;
        this.green_light=this.position[0];
    }
    void change_light(){
        int i=0;
        for (int[] arr : this.position) {

            i++;
            if (Arrays.equals(arr, this.green_light)){
                break;
            }
        }
        if (i==3){
            this.green_light=this.position[0];
        }else {
            this.green_light=this.position[i+1];
        }
    }
}
