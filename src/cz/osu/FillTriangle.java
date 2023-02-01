package cz.osu;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FillTriangle {
    public static Point [][] lines(Point p1, Point p2, Point p3, int red, int green, int blue){
        Point [] _12 = line(p1, p2);
        Point [] _23 = line(p2, p3);
        Point [] _13 = line(p1, p3);
        Point[][] p = new Point[][]{_12, _23, _13};
        return p;
    }

    public static Point [] line(Point p1, Point p2){
        Point[] points;
        if (p2.y - p1.y == 0) {
            return FillTriangle.lineX(p1, p2); // horizontala
        } else if (p2.x - p1.x == 0) {
            return FillTriangle.lineY(p1, p2); // vertikala
        } else if (Math.abs(p2.x - p1.x) > Math.abs(p2.y - p1.y)) {
            return FillTriangle.lineX(p1, p2);// maly sklon
        } else if (Math.abs(p2.x - p1.x) < Math.abs(p2.y - p1.y)) {
            return FillTriangle.lineY(p1, p2);// velky sklon
        } else {
            return FillTriangle.lineX(p1, p2);// diagonalny smer
        }
    }

    public static Point [] lineX(Point p1, Point p2){
        ArrayList list = new ArrayList<Point>();
        float a = (float) (p2.y - p1.y) / (float) (p2.x - p1.x);
        float b = (float) p1.y - a * (float) p1.x;

        list.add(new Point(p1.x, p1.y));
        if(p2.x<p1.x) {
            for (int x = p2.x + 1; x < p1.x; x++) {
                list.add(new Point(x, (int) ((double) (a * (float) x + b) + 0.5)));
            }
        }
        if(p2.x>p1.x) {
            for (int x = p1.x + 1; x < p2.x; x++) {
                list.add(new Point(x, (int) ((double) (a * (float) x + b) + 0.5)));
            }
        }
        list.add(new Point(p2.x, p2.y));
        Point [] points = new Point[list.size()];
        return points;
    }

    public static Point [] lineY(Point p1, Point p2) {
        ArrayList list = new ArrayList<Point>();
        float a = (float) (p2.x - p1.x) / (float) (p2.y - p1.y);
        float b = (float) p1.x - a * (float) p1.y;
        list.add(new Point(p1.x, p1.y));
        if(p2.y<p1.y) {
            for (int y = p2.y + 1; y < p1.y; y++) {
                list.add(new Point((int) ((double) (a * (float) y + b) + 0.5D), y));
            }
        }
        if(p2.y>p1.y) {
            for (int y = p1.y + 1; y < p2.y; y++) {
                list.add(new Point((int) ((double) (a * (float) y + b) + 0.5D), y));
            }
        }
        list.add(new Point(p2.x, p2.y));
        Point [] points = new Point[list.size()];
        return points;
    }

    public static void fillTriangle(Point p1, Point p2, Point p3, int red, int green, int blue){

    }

}
