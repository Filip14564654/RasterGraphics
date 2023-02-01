package cz.osu;

public class Cv02_Line {

    public static void drawLine(V_RAM v_ram, int x1, int y1, int x2, int y2, int red, int green, int blue){


            if (y2 - y1 == 0) {
                drawLineX(v_ram, x1, y1, x2, y2, red, green, blue);
            } else if (x2 - x1 == 0) {
                drawLineY(v_ram, x1, y1, x2, y2, red, green, blue);
            } else if (Math.abs(x2 - x1) > Math.abs(y2 - y1)) {
                drawLineX(v_ram, x1, y1, x2, y2, red, green, blue);
            } else if (Math.abs(x2 - x1) < Math.abs(y2 - y1)) {
                drawLineY(v_ram, x1, y1, x2, y2, red, green, blue);
            } else {
                drawLineX(v_ram, x1, y1, x2, y2, red, green, blue);
            }
    }

    public static void drawLineX(V_RAM v_ram, int x1, int y1, int x2, int y2, int red, int green, int blue) {
        float a = (float) (y2 - y1) / (float) (x2 - x1);
        float b = (float) y1 - a * (float) x1;

        v_ram.setPixel(x1, y1, red, green, blue);
        if(x2<x1) {
            for (int x = x2 + 1; x < x1; x++) {

                v_ram.setPixel(x, (int) ((double) (a * (float) x + b) + 0.5), red, green, blue);

            }
        }
        if(x2>x1) {
            for (int x = x1 + 1; x < x2; x++) {

                v_ram.setPixel(x, (int) ((double) (a * (float) x + b) + 0.5), red, green, blue);

            }
        }
        v_ram.setPixel(x2, y2, red, green, blue);
    }

    public static void drawLineY(V_RAM v_ram, int x1, int y1, int x2, int y2, int red, int green, int blue) {
        float a = (float) (x2 - x1) / (float) (y2 - y1);
        float b = (float) x1 - a * (float) y1;
        v_ram.setPixel(x1, y1, red, green, blue);

        if(y2<y1) {
            for (int y = y2 + 1; y < y1; y++) {
                v_ram.setPixel((int) ((double) (a * (float) y + b) + 0.5D), y, red, green, blue);
            }
        }
        if(y2>y1) {
            for (int y = y1 + 1; y < y2; y++) {
                v_ram.setPixel((int) ((double) (a * (float) y + b) + 0.5D), y, red, green, blue);
            }
        }

        v_ram.setPixel(x2, y2, red, green, blue);
    }


}
