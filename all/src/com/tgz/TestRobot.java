package com.tgz;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class TestRobot {

        public boolean robot(String command, int[][] obstacles, int x, int y) {
            int xnow=0, tx = 0, b1 = 0;
            int ynow=0, ty = 0, b2 = 0;
            boolean burn=false;
            int sign = 0;
            int su = 0;
            int [][] temp = new int[command.length()][2];


            for(int i=0;i<command.length();i++) {
                    char next=command.charAt(i);
                if (next == 'R')
                {
                    xnow++;
                    temp[i][0] = xnow;
                    temp[i][1] = ynow;
                }
                else if(next == 'U') {
                    ynow++;
                    temp[i][0] = xnow;
                    temp[i][1] = ynow;

                }

            }

            //
            if (x / xnow <= y / ynow)
            {
                tx = x / xnow;
                y = y - ynow * (x / xnow);
                x = x % xnow;


            }
            else
            {
                tx = y / ynow;
                x = x - xnow * (y / ynow);
                y = y % ynow;

            }

            if (x == 0 && y == 0)
                sign = 1;

            //
            for (int i = 0; i < command.length(); i++) {
                if (x == temp[i][0] && y == temp[i][1]) {
                    b1 = i;
                    sign = 1;
                    break;
                }

            }

            if (sign == 0)
            {
                return false;
            }



            //
            if (obstacles != null) {


                for (int j = 0; j < obstacles.length; j++) {

                    if (obstacles[j][0] / xnow <= obstacles[j][1] / ynow) {
                        ty = obstacles[j][0] / xnow;
                        obstacles[j][1] = obstacles[j][1] - ynow * (obstacles[j][0] / xnow);
                        obstacles[j][0] = obstacles[j][0] % xnow;

                    } else {
                        ty = obstacles[j][1] / ynow;
                        obstacles[j][0] = obstacles[j][0] - xnow * (obstacles[j][1] / ynow);
                        obstacles[j][1] = obstacles[j][1] % ynow;

                    }

                }

                for (int i = 0; i < command.length(); i++) {
                    for (int j = 0; j < obstacles.length; j++) {

                        if(obstacles[j][0] == 0 && obstacles[j][1] == 0)
                        {
                            if(tx * command.length() + b1 > ty * command.length() + i) {
                                return false;
                            }
                            else if(tx * command.length() + b1 < ty * command.length() + i)
                            {
                                return true;
                            }
                        }

                        if (temp[i][0] == obstacles[j][0] && temp[i][1] == obstacles[j][1]) {
                            if(tx * command.length() + b1 > ty * command.length() + i) {
                                return false;
                            }
                            else if(tx * command.length() + b1 < ty * command.length() + i)
                            {
                                return true;
                            }
                        }

                    }
                }
            }

//            while(burn==false){
//                for(int i=0;i<command.length();i++){
//                    char next=command.charAt(i);
//                    if(next=='R'){   //向右走
//                        xnow++;
//                        int[] now={xnow,ynow};
//                        System.out.println("目前机器人位置是X："+xnow+"Y:"+ynow);
//                        if(xnow==x&&ynow==y){
//                            return true;
//                        };
//                        if(xnow>x||ynow>y){
//                            return false;
//                        }
//                        for(int j=0;j<obstacles.length;j++){
//                            if(now[0]==obstacles[j][0]&&now[1]==obstacles[j][1]){
//                                burn=true;
//                                return false;
//                            }
//                        }
//                    }else{           //向上走
//                        ynow++;
//                        int[] now={xnow,ynow};
//                        System.out.println("目前机器人位置是X："+xnow+"Y:"+ynow);
//                        if(xnow==x&&ynow==y){
//                            return true;
//                        };
//                        if(xnow>x||ynow>y){
//                            return false;
//                        }
//                   for(int j=0;j<obstacles.length;j++){
//                     if(now[0]==obstacles[j][0]&&now[1]==obstacles[j][1]){
//                               burn=true;
//                               return false;
//                      }
//                      }
//                    }
//                }
//            }
            return true;
        }

    public static void main(String[] args) {
            int [][] array = new int[][]{{4, 2}};
      boolean a= new TestRobot().robot("URR", array, 3, 2);
      System.out.println(a);
        }



}
