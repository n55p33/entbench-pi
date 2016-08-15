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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "UYq1jLqHyow9hM1PmfcgwOkuwmaFUKzb8345ZMy4rqtU0oLHZvy3N+da8P5J" +
       "sCAvoJfC823bDFdP3IJXl2ANWKmKC1KVB3nR+L8n5Es3XimKKuGa+ud/Y93/" +
       "98fFMbFYYRi4wXzwUK38bub5DxzIvjgvMh6HyCJ41tsi819GBr+hu7UU1TOR" +
       "nmxckZ1bu0maGfPWktJ477He+M86Xr1hvOMvvJqoVSzIIJBwitwde3g+O/z+" +
       "R8ca2x7lmaoK8xEH5OCle+Gduu+qnNu+CZunPQWZtyzE/wcFgX0Y+F3xs2gI" +
       "X8MMTsGKJql8thVQbapUS7F0sZCqBNHw9VnDDYSQmMopC8W1BJ7FIePrGpWc" +
       "whXGxKWkoofznyxgMFdU/ltcBZ/1RAkXpwxMvFlm7C1sjoG2Msol1ChD/k6p" +
       "UPeggg9RONdTZWY8js0TjNQCnPPL2mImrhrWlYQLTk9OAjjNcsJVs8NVmzg4" +
       "lWINqF/NBakOgpMHubF9qQxE/9J2taPi+uFZwzBK2B/bT3n7cZlN+BybDxmp" +
       "dzZhiz7COV2bn/gmbJ6DtO29mMeif07B1z/xxUp+dLypdvb4VW8JZHC+KjXA" +
       "aTSZVVVvWep5rzZMmlS4Ug2iSBUmOsVIe/kvBhAD/JfL/qXg+oqROaW4IPCh" +
       "9VBXQBU7oxg1UELrpaxipDlICevzXy9dDeR2lw5QSLx4SepgdiDB13rDwZTl" +
       "p/k4shoSmQlVAd+EXIW/Sslv+czTbbmnsOnwJQj+3dfJnFnx5TcmHxnfsOn6" +
       "kxc9IG7AZVUa41VYPWC5uIzPFwCLSs7mzFW9vuvUtMemLnHybosQ2I3ReR73" +
       "3grhYKCvzQ1cD1ud+Vvitw9e9swf9lQfg9y1jVRIgNnbCm9QckYWKq9t0cIL" +
       "Rkh1/N66u+ue0ZXLk5++y++oiLiQnF+aPia/ceja1/fOOdgeIvV94IJagub4" +
       "1c7aUW0LlYfNIdKoWL05EBFmgQThu72chmEh4RdhbhfbnI35Xvx+wsjiwrvb" +
       "wq9Odao+Qs01elZL2Bm43u1xkq6vhsoaRoDB7fGk5bUC08TppzIW3WgYztV2" +
       "1Y0GR4bekuBV0c5f8W3B/wFuaY7SEyIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Cdml8wH1iWoffTPVnonBnzu3bZZpzcdR");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("brJPbH5Z+dJrY/Invt38hX1OmuJIeXlBfQ3scPv0uJNI+dm7jnY81tXRC995" +
       "+MsPPH8c1T+8Z/gUC87w9t47J4D13SAuU7byf/HEL//IP37tj8or4P8HGgVY" +
       "QW8uAAA=");
}
