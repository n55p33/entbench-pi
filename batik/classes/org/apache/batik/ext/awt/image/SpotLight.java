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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xjDSr6qUDho8LHT5h67D/BGfjvwPCYBRBtotAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "gduTcbdaHUo9pc/2xflq1FTYTiM1umzQ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("8GfdtdukSK6+bqBdGCM0Y5MwHQGbYpEbtdvt4oDAN29uS+y+Yvfv4MiiYaF5" +
       "xT++iV2v9MiO6cF+f/F3ETpxzO3Im48jr/Sh/NDBozc6iVgczPjiR196WRl/" +
       "qXJ+b7sUjaA7Itf7SUvdqNax0wH5/ZeOv4D5CXD91B4bP3XyBcwh0NNfC70r" +
       "fb1d4D8+o+5befGHgNmVuju+tjh8KVAI9o9ebzvxaI83AtfeA9e+9eC+e0bd" +
       "n+bFfzoCTjgB7k9uBThyDxx568H99zPqfpQX/+0IuOUJcD94s+ByjxjvgRvf" +
       "cnDnoDPqildLr0XQXQAcc/Rl/yG8P7sV8Pg9ePyth3f3GXX5UaZzl47BO2Ga" +
       "5y7fCngf3IP3wVsP7+Ez6h7JiweOwTthnOcefLPwngGXsgdPufXwrp5R92xe" +
       "PB5BDwB47GnnGA5hPvFmYeZnP8w9mOath1k+o66aF6UIerAIMKcdiDjE+Z43" +
       "gfOBfWv9pT2cv3Trcb73jLoCAJivjxx3O+1d2yXJdS1VdA5BN98E6Ifzh/lx" +
       "ml/ZA/0rNwH6uhfvJ9BdKKguFDo6Xny2QDw8Qxp0XvQi6O79aQXbO19xRNvE" +
       "mwBe5F758Zd/tQf8Gz9G4PMzgOcB+Nw0gi7vAz/NCC5sXF05FAR7KwTxx3uC" +
       "+Hc/RkFoZwgi/xbknHgksajlDz5wiPp1T9idgfqh/OFT4PrOHurv3Bpnv1gQ" +
       "XDwF8BcKmr9+wMG78gHzJt09DorfCJrf0g9Qjn3b8lZ1vTsP4nleLsBzYaG9" +
       "4AzNFoV9xLenblIoNzxUrnMzyk2BlRx8+JKf4n/4uo/qdh+CyV95+d7L73h5" +
       "9oe7M1v7H2vdQUGXtdiyjp4BPnJ/0QtUTS9Q3rE7EewVED4SQY+d/TlOBN1e" +
       "/OYcn/vwrtVHI+jhG7WKoNtAeZT6Y2DiO40aUILyKOUnIujKSUowfvF7lO6T" +
       "YIo5pIugi7uboySfAr0Dkvz207vDOG+PoPe8zpdHbSmMAlHeKSHdnd96+Kj3" +
       "Feny/a+n1yNL3aePHaEqPqfcP+4U7z6ofEH+6suD0c/9sPGl3UcxsiVmWd7L" +
       "ZQq6tPs+p+g0PzL15A172+/rIvnu1+752h3P7C+e79kxfBgJjvD2+OlfoOC2" +
       "FxXfjGT/6B3/8L1/5+VvFSdx/h/cBsvM5zoAAA==");
}
