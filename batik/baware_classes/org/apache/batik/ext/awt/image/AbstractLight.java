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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "V+wvnUkXjqyw0t9j301/Jyhn70SVIqhu");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("9h4fdaaHu70val96ZTz9odfbP3O4k6W5SlGlZ/cz0NXD9bCT49Jn7zja8VhX" +
       "qA9855FfeOB9x+nPIweCTz3iDG3P3P4C1NALk+rKUvEr7/pnH/qnr3ytOoX7" +
       "v+lpg+ZyLQAA");
}
