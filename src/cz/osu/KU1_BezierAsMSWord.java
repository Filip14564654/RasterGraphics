package cz.osu;

import java.awt.*;
import java.lang.reflect.Array;

public class KU1_BezierAsMSWord {

    public static void drawBezier(V_RAM v_ram, Point[] points, int step,  int red, int green, int blue){
        Point[] newPoints = new Point[points.length+2];
        Point[] L = new Point[newPoints.length];
        Point[] R = new Point[newPoints.length];

        newPoints[0] = new Point(points[0].x, points[0].y);
        for (int i = 0; i<points.length; i++){
            newPoints[i+1] = new Point(points[i].x, points[i].y);
        }
        newPoints[newPoints.length-1] = new Point(points[newPoints.length-2].x, points[newPoints.length-2].y);

        for (int i=1; i<newPoints.length-2; i++){
            L[i] = new Point(newPoints[i].x-(newPoints[i+1].x-newPoints[i-1].x)/6,
                    newPoints[i].y-(newPoints[i+1].y-newPoints[i-1].y)/6);
            R[i] = new Point(newPoints[i].x+(newPoints[i+1].x-newPoints[i-1].x)/6,
                    newPoints[i].y+(newPoints[i+1].y-newPoints[i-1].y)/6);
        }

        for (int i=1; i<newPoints.length-2; i++){
            Cv03_Bezier.drawBezier(v_ram, step, points[i], R[i], L[i+1], points[i+1], red, green, blue);
        }

    }
}
