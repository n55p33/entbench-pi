package org.apache.batik.ext.awt.color;
public class ICCColorSpaceExt extends java.awt.color.ICC_ColorSpace {
    public static final int PERCEPTUAL = 0;
    public static final int RELATIVE_COLORIMETRIC = 1;
    public static final int ABSOLUTE_COLORIMETRIC = 2;
    public static final int SATURATION = 3;
    public static final int AUTO = 4;
    static final java.awt.color.ColorSpace sRGB = java.awt.color.ColorSpace.
      getInstance(
        java.awt.color.ColorSpace.
          CS_sRGB);
    int intent;
    public ICCColorSpaceExt(java.awt.color.ICC_Profile p, int intent) { super(
                                                                          p);
                                                                        this.
                                                                          intent =
                                                                          intent;
                                                                        switch (intent) {
                                                                            case AUTO:
                                                                            case RELATIVE_COLORIMETRIC:
                                                                            case ABSOLUTE_COLORIMETRIC:
                                                                            case SATURATION:
                                                                            case PERCEPTUAL:
                                                                                break;
                                                                            default:
                                                                                throw new java.lang.IllegalArgumentException(
                                                                                  );
                                                                        }
                                                                        if (intent !=
                                                                              AUTO) {
                                                                            byte[] hdr =
                                                                              p.
                                                                              getData(
                                                                                java.awt.color.ICC_Profile.
                                                                                  icSigHead);
                                                                            hdr[java.awt.color.ICC_Profile.
                                                                                  icHdrRenderingIntent] =
                                                                              (byte)
                                                                                intent;
                                                                        }
    }
    public float[] intendedToRGB(float[] values) {
        switch (intent) {
            case ABSOLUTE_COLORIMETRIC:
                return absoluteColorimetricToRGB(
                         values);
            case PERCEPTUAL:
            case AUTO:
                return perceptualToRGB(
                         values);
            case RELATIVE_COLORIMETRIC:
                return relativeColorimetricToRGB(
                         values);
            case SATURATION:
                return saturationToRGB(
                         values);
            default:
                throw new java.lang.Error(
                  "invalid intent:" +
                  intent);
        }
    }
    public float[] perceptualToRGB(float[] values) {
        return toRGB(
                 values);
    }
    public float[] relativeColorimetricToRGB(float[] values) {
        float[] ciexyz =
          toCIEXYZ(
            values);
        return sRGB.
          fromCIEXYZ(
            ciexyz);
    }
    public float[] absoluteColorimetricToRGB(float[] values) {
        return perceptualToRGB(
                 values);
    }
    public float[] saturationToRGB(float[] values) {
        return perceptualToRGB(
                 values);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "b7gkAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "jtyma35fmfJ4h52OJKWRz5sive3J6jrtExPVDo0+YudjazVIedfEeuNBPNRW" +
       "CmGG4LUm0jqxsluYYsb5RL8TDrmm7RAEt2gqNdipeXowJFb16mCDeQ1kS2QI" +
       "a0QDagSMxOyg3I3aVVpFlckmsNy+ZE9wVfb7tLsI4g5F5xwEe7GyWPl5bEFu" +
       "e0rKCZYRqjGXdiMD4sGO5ATNHASw1aSNhEZqdgbztbjO3REib1BTc+24iWCT" +
       "mlNb7OBAm0NcPt3sxlm8m3oKHzKDRUtSzWkax82xOVy5Y47B3Hq3AzHNVRg5" +
       "EQHWR78O96kNm8Ok3IRC11XcZaB0p3Sv2Y01bjreJj0X3hHdtEGaqhuv002K" +
       "rT3I9v2u05UHUKhPmyCeafBeSHQ2G7D1m1SEsrYybm1qBgjAaK3djDIOZ7Ym" +
       "HG/FNjNGNlpodDqN2c40AtZtVlehPuwlO4zVsdo8nNv1WazNJ9CAm4QEFghm" +
       "3ud7iL5u6r4QtKpZc5EKQ4jY5KZM92fzMEm5ljPM5lVVF+ZhHPRXzc5itchl" +
       "hJqPoHnQUNPepu+PCTLcDAJmI8EsHxj2ekrGljaKNMdgUG/N2/FgEtX7ZDuG" +
       "g8jIXbWlKPoWM/OG4jGIJtSR+qAhYVUijNtWvb1CR0IkmUZMUzPcSIb4RGnZ" +
       "fi1XFKzvu31OGqSO3guE3aSG95wllul1G82JCeyKjSYur9eNWpVuxQEV6BSg" +
       "93Vb5nqyPa8LtS7OOt1RlKy35nY2aSKapBPqTETrVAbPwk5d5syVYSqsSrbT" +
       "4ZLtDqo+FyrdmoKIw1W0kpfRtGMIO2Kc+b5cTXl7KTFWFNdsFHhsqg8YuU4P" +
       "11BzkxBJ3IhGNXK+zcVGi4CGrhvldZQYTJqmLdVCKCPi3Q4J/KaBYFYDasXR" +
       "1psGhqz3nTVu2w262a7LI42dhIyD0o7FavOp64GxWnO850FeUO97cQ6zJkfr" +
       "hDLf2cuxFtQ2c9mhVYjFvazTT+qbJbasAnXa+johOrZspnWsrjQmHX4uDunV" +
       "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" +
       "o+fXi+L3k8q7I82Vi5yLcsVZgEpA8H2R");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("xl/7fmjsH2rs/4A0/m+30fi/F8U3gcbyKg7cNHlbjf/r98OXs0ONsx+Qxn/8" +
       "1hpfKsf7X8CX4yKZt2TSi/T8ozvRc5tUrp3PEixSnh6/JS15n0qrfP71q/e9" +
       "63XxX+23taN01/uZyn166rqnUylO1S+HkaZbpYL37xMrwlKje5PKU7dPYSwo" +
       "r/hfAL90ed/qSlJ5/K1aJZW7QHla+kHA3RdJA0lQnpa8BmxxXhKMX/4/Lfdo" +
       "UrlyIgd2mH3ltMhjoHcgUlTfFR5tIU9ekAx2YvjtpbNh4vF8PvJ283kqsnz+" +
       "TDhTZqAfxW7pPgf9pvKF1yn2x7/d+bl9yqDiyrtd0ct9IPLYZy8ex3/PvmVv" +
       "R31dHr74nYd+8f4XjmLVh/aATxbDKWxPX5yfh3thUmbU7f7hu37pR/7O679b" +
       "psD8X2ABCXAaMAAA");
}
