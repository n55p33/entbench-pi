package org.apache.batik.ext.awt.image;
public class DistantLight extends org.apache.batik.ext.awt.image.AbstractLight {
    private double azimuth;
    private double elevation;
    private double Lx;
    private double Ly;
    private double Lz;
    public double getAzimuth() { return azimuth; }
    public double getElevation() { return elevation; }
    public DistantLight(double azimuth, double elevation, java.awt.Color color) {
        super(
          color);
        this.
          azimuth =
          azimuth;
        this.
          elevation =
          elevation;
        Lx =
          java.lang.Math.
            cos(
              java.lang.Math.
                toRadians(
                  azimuth)) *
            java.lang.Math.
            cos(
              java.lang.Math.
                toRadians(
                  elevation));
        Ly =
          java.lang.Math.
            sin(
              java.lang.Math.
                toRadians(
                  azimuth)) *
            java.lang.Math.
            cos(
              java.lang.Math.
                toRadians(
                  elevation));
        Lz =
          java.lang.Math.
            sin(
              java.lang.Math.
                toRadians(
                  elevation));
    }
    public boolean isConstant() { return true; }
    public void getLight(final double x, final double y, final double z,
                         final double[] L) { L[0] = Lx;
                                             L[1] = Ly;
                                             L[2] = Lz; }
    public double[][] getLightRow(double x, double y, final double dx,
                                  final int width,
                                  final double[][] z,
                                  final double[][] lightRow) { double[][] ret =
                                                                 lightRow;
                                                               if (ret ==
                                                                     null) {
                                                                   ret =
                                                                     (new double[width][]);
                                                                   double[] CL =
                                                                     new double[3];
                                                                   CL[0] =
                                                                     Lx;
                                                                   CL[1] =
                                                                     Ly;
                                                                   CL[2] =
                                                                     Lz;
                                                                   for (int i =
                                                                          0;
                                                                        i <
                                                                          width;
                                                                        i++) {
                                                                       ret[i] =
                                                                         CL;
                                                                   }
                                                               }
                                                               else {
                                                                   final double lx =
                                                                     Lx;
                                                                   final double ly =
                                                                     Ly;
                                                                   final double lz =
                                                                     Lz;
                                                                   for (int i =
                                                                          0;
                                                                        i <
                                                                          width;
                                                                        i++) {
                                                                       ret[i][0] =
                                                                         lx;
                                                                       ret[i][1] =
                                                                         ly;
                                                                       ret[i][2] =
                                                                         lz;
                                                                   }
                                                               }
                                                               return ret;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "lTI4MvSWBK+Kdv6Kbwv+D51rMY8TIgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "T0J66fyG+mRqH32zqT2zB3/u3LJZhjQf");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("73KjfVDzS8qXXiUnP/bt9i/u49EUS8rLy+lrYIXbh8ad7JSfvWtvx31dJZ5/" +
       "4+EvP/CB4139w3uGT7HgDG/vvXPwF257YRmulf/zJ37lh/7Rq39cXv/+P2wI" +
       "IDVrLgAA");
}
