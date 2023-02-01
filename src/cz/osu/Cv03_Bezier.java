package cz.osu;

import java.awt.*;

public class Cv03_Bezier {

    public static void drawBezier(V_RAM v_ram, int step, Point p1, Point p2, Point p3, Point p4, int red, int green, int blue){
        double xs=0;
        double ys=0;
        double ttt1;
        double tt1;
        double tt;
        double ttt;
        for(double t = 0; t <= 1; t=t+(1.0)/step){
            tt1 = (t-1)*(t-1);
            ttt1 = (t-1)*tt1;
            tt = t*t;
            ttt = tt* t;
            double x =(int)(ttt1*p1.x + 3*tt1*t*p2.x + 3*(1-t)* tt*p3.x + ttt*p4.x);
            double y =(int)(ttt1*p1.y + 3*tt1*t*p2.y + 3*(1-t)* tt*p3.y + ttt*p4.y);
            v_ram.setPixel((int)x,(int)y,red,green,blue);
            if(t>0) {
                Cv02_Line.drawLine(v_ram, (int) xs, (int) ys, (int) x, (int) y, 255, 255, 255);
            }
            xs = x;
            ys = y;
        }
    }

}
