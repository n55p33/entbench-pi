package org.apache.batik.ext.awt.image;
public abstract class AbstractLight implements org.apache.batik.ext.awt.image.Light {
    public static final double sRGBToLsRGB(double value) { if (value <= 0.003928)
                                                               return value /
                                                                 12.92;
                                                           return java.lang.Math.
                                                             pow(
                                                               (value +
                                                                  0.055) /
                                                                 1.055,
                                                               2.4);
    }
    private double[] color;
    public double[] getColor(boolean linear) { double[] ret =
                                                 new double[3];
                                               if (linear) {
                                                   ret[0] =
                                                     sRGBToLsRGB(
                                                       color[0]);
                                                   ret[1] =
                                                     sRGBToLsRGB(
                                                       color[1]);
                                                   ret[2] =
                                                     sRGBToLsRGB(
                                                       color[2]);
                                               }
                                               else {
                                                   ret[0] =
                                                     color[0];
                                                   ret[1] =
                                                     color[1];
                                                   ret[2] =
                                                     color[2];
                                               }
                                               return ret;
    }
    public AbstractLight(java.awt.Color color) { super();
                                                 setColor(
                                                   color);
    }
    public void setColor(java.awt.Color newColor) { color =
                                                      (new double[3]);
                                                    color[0] =
                                                      newColor.
                                                        getRed(
                                                          ) /
                                                        255.0;
                                                    color[1] =
                                                      newColor.
                                                        getGreen(
                                                          ) /
                                                        255.0;
                                                    color[2] =
                                                      newColor.
                                                        getBlue(
                                                          ) /
                                                        255.0;
    }
    public boolean isConstant() { return true; }
    public double[][][] getLightMap(double x, double y, final double dx,
                                    final double dy,
                                    final int width,
                                    final int height,
                                    final double[][][] z) {
        double[][][] L =
          new double[height][][];
        for (int i =
               0;
             i <
               height;
             i++) {
            L[i] =
              getLightRow(
                x,
                y,
                dx,
                width,
                z[i],
                null);
            y +=
              dy;
        }
        return L;
    }
    public double[][] getLightRow(double x, double y, final double dx,
                                  final int width,
                                  final double[][] z,
                                  final double[][] lightRow) {
        double[][] ret =
          lightRow;
        if (ret ==
              null)
            ret =
              (new double[width][3]);
        for (int i =
               0;
             i <
               width;
             i++) {
            getLight(
              x,
              y,
              z[i][3],
              ret[i]);
            x +=
              dx;
        }
        return ret;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6knEnp8I6LzHWuOdxHWXRjabZG67UCS+ya3lTSBpbJcgN52daAme0a87OxzG" +
       "Jw4lbhaM24dX09BO8MSOCou3NvQKm07FoOhOZr7f0vaBgBlMNDCbCCk0p1pc" +
       "Y4U1a9JZmqJh1sAbk6A5D5vrYdZTuPHAMeqUI7FdR2itGGonyK1dnVZ2g826" +
       "ufHYTF2RQcQyjSlHYImC0nm73dWYVPPMIGNW0x0Z8EyAN+AazhmZT+GtmddS" +
       "Rim9TdpbsWhKk3CZ14xW2OKF5bhr75iM2UxWcLFFyYLwKX6YJyttOMb72+XC" +
       "adiUTzn8lu57O1Xxdhuvt2WKvJj2CXq730ZKkPtwAe/FUU/opMOwsLcLhoaV" +
       "cZ8uDMyeIZt5nyOsFacMNxKupFS9g6Zes8vUOupcmenciBxsIscbmPiih6lG" +
       "Ekz2ozodcNECh9GotQpSjOm7hJllGUMlzb4Pp1MHjfqxs5tp/RrQh12fKYq3" +
       "UPY05XLJuqHgsJqriGeQUa05G0XGVB3AtcUeGK0qNrDOGjHqsONgQB1yYXYL" +
       "OU3VCO7BppTKA34ae6mBzB0X6XeCLPI2UyFklbhX9wUjqMlwpsMKyY7gQsxH" +
       "tRU1kVarDrZuZEOMxjFzxznyol7U20E8wjvZRk0bykwrppM9QVImT+ajDr8i" +
       "luPVtC6oRRfT+cDA0IDtNAQJpjR+ueNtPiXBQkCtN0QPReB1m02IEZXOmnK4" +
       "sOD+tIlIWjSJFTjWXX293kv2eG/WeyuR38uZTm863X24cGh5yxm7jpcg3abG" +
       "8fIcE7FxLRZnuoP1k31RBMnOn85dMVtgs4VbJ+rJvsO1mn23O+cN1xuvs2gN" +
       "wutKbBXNBdIY2Xtgo2DWiPR4kyM9Dstpf4b0dKqd0X27hyVpBssCZmcI1zTF" +
       "9n4WDtC5N1o6yFyM2y1yulFmE9fBhpNwVnOzodxvFVijt9m362in16YzMNmu" +
       "Zt1+yO+mAS/5KFHkrQCjNG9pbmZxo99FF3J7SdcWBraz55zF4/Gi00zHq5GS" +
       "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" +
       "r8MNi/zSmXThyAor/T32vfR3gnL2XlQp");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("gup27/FxZ3K43/uS8uVXJuyPvt7+6cO9LMWRiio9u5+Grh6uiJ0cmT57x96O" +
       "+7oyev93H/n5B54/Tn8eORB86hFnaHvm9pegCDeIq2tLxS+/659+8J+88vXq" +
       "JO7/AjZg5vx2LQAA");
}
