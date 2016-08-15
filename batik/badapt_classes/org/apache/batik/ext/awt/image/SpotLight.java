package org.apache.batik.ext.awt.image;
public class SpotLight extends org.apache.batik.ext.awt.image.AbstractLight {
    private double lightX;
    private double lightY;
    private double lightZ;
    private double pointAtX;
    private double pointAtY;
    private double pointAtZ;
    private double specularExponent;
    private double limitingConeAngle;
    private double limitingCos;
    private final double[] S = new double[3];
    public double getLightX() { return lightX; }
    public double getLightY() { return lightY; }
    public double getLightZ() { return lightZ; }
    public double getPointAtX() { return pointAtX; }
    public double getPointAtY() { return pointAtY; }
    public double getPointAtZ() { return pointAtZ; }
    public double getSpecularExponent() { return specularExponent; }
    public double getLimitingConeAngle() { return limitingConeAngle; }
    public SpotLight(double lightX, double lightY, double lightZ, double pointAtX,
                     double pointAtY,
                     double pointAtZ,
                     double specularExponent,
                     double limitingConeAngle,
                     java.awt.Color lightColor) { super(lightColor);
                                                  this.lightX = lightX;
                                                  this.lightY = lightY;
                                                  this.lightZ = lightZ;
                                                  this.pointAtX =
                                                    pointAtX;
                                                  this.pointAtY =
                                                    pointAtY;
                                                  this.pointAtZ =
                                                    pointAtZ;
                                                  this.specularExponent =
                                                    specularExponent;
                                                  this.limitingConeAngle =
                                                    limitingConeAngle;
                                                  this.limitingCos =
                                                    java.lang.Math.
                                                      cos(
                                                        java.lang.Math.
                                                          toRadians(
                                                            limitingConeAngle));
                                                  S[0] = pointAtX -
                                                           lightX;
                                                  S[1] = pointAtY -
                                                           lightY;
                                                  S[2] = pointAtZ -
                                                           lightZ;
                                                  double invNorm =
                                                    1 /
                                                    java.lang.Math.
                                                    sqrt(
                                                      S[0] *
                                                        S[0] +
                                                        S[1] *
                                                        S[1] +
                                                        S[2] *
                                                        S[2]);
                                                  S[0] *= invNorm;
                                                  S[1] *= invNorm;
                                                  S[2] *= invNorm;
    }
    public boolean isConstant() { return false; }
    public final double getLightBase(final double x, final double y,
                                     final double z,
                                     final double[] L) { double L0 =
                                                           lightX -
                                                           x;
                                                         double L1 =
                                                           lightY -
                                                           y;
                                                         double L2 =
                                                           lightZ -
                                                           z;
                                                         final double invNorm =
                                                           1.0 /
                                                           java.lang.Math.
                                                           sqrt(
                                                             L0 *
                                                               L0 +
                                                               L1 *
                                                               L1 +
                                                               L2 *
                                                               L2);
                                                         L0 *= invNorm;
                                                         L1 *= invNorm;
                                                         L2 *= invNorm;
                                                         double LS =
                                                           -(L0 *
                                                               S[0] +
                                                               L1 *
                                                               S[1] +
                                                               L2 *
                                                               S[2]);
                                                         L[0] = L0;
                                                         L[1] = L1;
                                                         L[2] = L2;
                                                         if (LS <=
                                                               limitingCos) {
                                                             return 0;
                                                         }
                                                         else {
                                                             double Iatt =
                                                               limitingCos /
                                                               LS;
                                                             Iatt *=
                                                               Iatt;
                                                             Iatt *=
                                                               Iatt;
                                                             Iatt *=
                                                               Iatt;
                                                             Iatt *=
                                                               Iatt;
                                                             Iatt *=
                                                               Iatt;
                                                             Iatt *=
                                                               Iatt;
                                                             Iatt =
                                                               1 -
                                                                 Iatt;
                                                             return Iatt *
                                                               java.lang.Math.
                                                               pow(
                                                                 LS,
                                                                 specularExponent);
                                                         }
    }
    public final void getLight(final double x, final double y,
                               final double z,
                               final double[] L) { final double s =
                                                     getLightBase(
                                                       x,
                                                       y,
                                                       z,
                                                       L);
                                                   L[0] *=
                                                     s;
                                                   L[1] *=
                                                     s;
                                                   L[2] *=
                                                     s; }
    public final void getLight4(final double x, final double y,
                                final double z,
                                final double[] L) { L[3] =
                                                      getLightBase(
                                                        x,
                                                        y,
                                                        z,
                                                        L);
    }
    public double[][] getLightRow4(double x, double y, final double dx,
                                   final int width,
                                   final double[][] z,
                                   final double[][] lightRow) {
        double[][] ret =
          lightRow;
        if (ret ==
              null)
            ret =
              (new double[width][4]);
        for (int i =
               0;
             i <
               width;
             i++) {
            getLight4(
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
      ("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" +
       "xjDSr6qU3mjwsNDlH7oO80d8OvI/rFrtgNotAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "J+NutTqUekqf7YvzFd1U2E4jNbps0PBn");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("iG0kId21SNQdN8tKc7zpw0EviFa0G7Xb7eKAwDdubkvs/mL37+DIomGhecU/" +
       "uYldr/TIjunBfn/xdxE6ccztyJuPI6/0ofzQwWM3OolYHMz4wkdefkUZf7Fy" +
       "fm+7FI2gOyLX+0lL3ajWsdMB+f0Xj7+A+Qlw/dQeGz918gXMIdDTXwu9M329" +
       "XeA/OqPum3nxB4DZlbo7vrY4fClQCPYPX2878WiPNwLX3gPXvvXgvnNG3Z/k" +
       "xX8+Ak44Ae6PbwU4cg8ceevB/fcz6n6YF396BNzyBLjvv1lwuUeM98CNbzm4" +
       "c9AZdcWrpR9F0F0AHHP0Zf8hvD+7FfD4PXj8rYd39xl1+VGmc5eOwTthmucu" +
       "3wp479+D9/5bD++RM+oezYsHj8E7YZznHnqz8J4Fl7IHT7n18K6eUfdcXjwR" +
       "QQ8CeOxp5xgOYT75ZmHmZz/MPZjmrYdZPqOumhelCHqoCDCnHYg4xPnuN4Hz" +
       "wX1r/cU9nL9463G+54y6AgCYr48cdzvtXdslyXUtVXQOQTffBOhH8of5cZpf" +
       "3gP9yzcB+roX7yfQXSioLhQ6Ol58pkA8PEMaVF70Iuju/WkF2ztfcUTbxJsA" +
       "XuRe+fGXf70H/Os/RuDzM4DnAfjcNIIu7wM/zQgubFxdORQEeysE8Ud7gvj3" +
       "P0ZBaGcIIn9vfU48kljU8gfvO0T9uifszkD9cP7waXB9ew/1t2+Ns18sCC6e" +
       "AvjzBc3fOODgnfmAeZPuHgfFbwTNb+kHKMe+bXmrut6dB/E8LxfgubDQXnCG" +
       "ZovCPuLbUzcplBseKte5GeWmwEoOPnzJT/E/ct1HdbsPweQvv3Lf5be/MvuD" +
       "3Zmt/Y+17hhBl7XYso6eAT5yf9ELVE0vUN6xOxHsFRA+FEGPn/05TgTdXvzm" +
       "HJ/74K7VRyLokRu1iqDbQHmU+qNg4juNGlCC8ijlxyPoyklKMH7xe5TuE2CK" +
       "OaSLoIu7m6MknwS9A5L89lO7wzhvi6B3v86XR20pjAJR3ikh3Z3feuSo9xXp" +
       "8gOvp9cjS91njh2hKj6n3D/uFO8+qHxR/sorA/rnf9D44u6jGNkSsyzv5fII" +
       "urT7PqfoND8y9dQNe9vv6yL5rh/d+9U7nt1fPN+7Y/gwEhzh7YnTv0DBbS8q" +
       "vhnJ/vHb/9F7/u4r3yxO4vw/4WEchuc6AAA=");
}
