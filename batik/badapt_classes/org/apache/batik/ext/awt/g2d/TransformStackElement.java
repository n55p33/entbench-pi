package org.apache.batik.ext.awt.g2d;
public abstract class TransformStackElement implements java.lang.Cloneable {
    private org.apache.batik.ext.awt.g2d.TransformType type;
    private double[] transformParameters;
    protected TransformStackElement(org.apache.batik.ext.awt.g2d.TransformType type,
                                    double[] transformParameters) {
        super(
          );
        this.
          type =
          type;
        this.
          transformParameters =
          transformParameters;
    }
    public java.lang.Object clone() { org.apache.batik.ext.awt.g2d.TransformStackElement newElement =
                                        null;
                                      try { newElement = (org.apache.batik.ext.awt.g2d.TransformStackElement)
                                                           super.
                                                           clone(
                                                             );
                                      }
                                      catch (java.lang.CloneNotSupportedException ex) {
                                          
                                      }
                                      double[] transformParameters =
                                        new double[this.
                                                     transformParameters.
                                                     length];
                                      java.lang.System.
                                        arraycopy(
                                          this.
                                            transformParameters,
                                          0,
                                          transformParameters,
                                          0,
                                          transformParameters.
                                            length);
                                      newElement.
                                        transformParameters =
                                        transformParameters;
                                      return newElement;
    }
    public static org.apache.batik.ext.awt.g2d.TransformStackElement createTranslateElement(double tx,
                                                                                            double ty) {
        return new org.apache.batik.ext.awt.g2d.TransformStackElement(
          org.apache.batik.ext.awt.g2d.TransformType.
            TRANSLATE,
          new double[] { tx,
          ty }) {
            boolean isIdentity(double[] parameters) {
                return parameters[0] ==
                  0 &&
                  parameters[1] ==
                  0;
            }
        };
    }
    public static org.apache.batik.ext.awt.g2d.TransformStackElement createRotateElement(double theta) {
        return new org.apache.batik.ext.awt.g2d.TransformStackElement(
          org.apache.batik.ext.awt.g2d.TransformType.
            ROTATE,
          new double[] { theta }) {
            boolean isIdentity(double[] parameters) {
                return java.lang.Math.
                  cos(
                    parameters[0]) ==
                  1;
            }
        };
    }
    public static org.apache.batik.ext.awt.g2d.TransformStackElement createScaleElement(double scaleX,
                                                                                        double scaleY) {
        return new org.apache.batik.ext.awt.g2d.TransformStackElement(
          org.apache.batik.ext.awt.g2d.TransformType.
            SCALE,
          new double[] { scaleX,
          scaleY }) {
            boolean isIdentity(double[] parameters) {
                return parameters[0] ==
                  1 &&
                  parameters[1] ==
                  1;
            }
        };
    }
    public static org.apache.batik.ext.awt.g2d.TransformStackElement createShearElement(double shearX,
                                                                                        double shearY) {
        return new org.apache.batik.ext.awt.g2d.TransformStackElement(
          org.apache.batik.ext.awt.g2d.TransformType.
            SHEAR,
          new double[] { shearX,
          shearY }) {
            boolean isIdentity(double[] parameters) {
                return parameters[0] ==
                  0 &&
                  parameters[1] ==
                  0;
            }
        };
    }
    public static org.apache.batik.ext.awt.g2d.TransformStackElement createGeneralTransformElement(java.awt.geom.AffineTransform txf) {
        double[] matrix =
          new double[6];
        txf.
          getMatrix(
            matrix);
        return new org.apache.batik.ext.awt.g2d.TransformStackElement(
          org.apache.batik.ext.awt.g2d.TransformType.
            GENERAL,
          matrix) {
            boolean isIdentity(double[] m) {
                return m[0] ==
                  1 &&
                  m[2] ==
                  0 &&
                  m[4] ==
                  0 &&
                  m[1] ==
                  0 &&
                  m[3] ==
                  1 &&
                  m[5] ==
                  0;
            }
        };
    }
    abstract boolean isIdentity(double[] parameters);
    public boolean isIdentity() { return isIdentity(
                                           transformParameters);
    }
    public double[] getTransformParameters() {
        return transformParameters;
    }
    public org.apache.batik.ext.awt.g2d.TransformType getType() {
        return type;
    }
    public boolean concatenate(org.apache.batik.ext.awt.g2d.TransformStackElement stackElement) {
        boolean canConcatenate =
          false;
        if (type.
              toInt(
                ) ==
              stackElement.
                type.
              toInt(
                )) {
            canConcatenate =
              true;
            switch (type.
                      toInt(
                        )) {
                case org.apache.batik.ext.awt.g2d.TransformType.
                       TRANSFORM_TRANSLATE:
                    transformParameters[0] +=
                      stackElement.
                        transformParameters[0];
                    transformParameters[1] +=
                      stackElement.
                        transformParameters[1];
                    break;
                case org.apache.batik.ext.awt.g2d.TransformType.
                       TRANSFORM_ROTATE:
                    transformParameters[0] +=
                      stackElement.
                        transformParameters[0];
                    break;
                case org.apache.batik.ext.awt.g2d.TransformType.
                       TRANSFORM_SCALE:
                    transformParameters[0] *=
                      stackElement.
                        transformParameters[0];
                    transformParameters[1] *=
                      stackElement.
                        transformParameters[1];
                    break;
                case org.apache.batik.ext.awt.g2d.TransformType.
                       TRANSFORM_GENERAL:
                    transformParameters =
                      matrixMultiply(
                        transformParameters,
                        stackElement.
                          transformParameters);
                    break;
                default:
                    canConcatenate =
                      false;
            }
        }
        return canConcatenate;
    }
    private double[] matrixMultiply(double[] matrix1,
                                    double[] matrix2) {
        double[] product =
          new double[6];
        java.awt.geom.AffineTransform transform1 =
          new java.awt.geom.AffineTransform(
          matrix1);
        transform1.
          concatenate(
            new java.awt.geom.AffineTransform(
              matrix2));
        transform1.
          getMatrix(
            product);
        return product;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "zeAhIFG6YEPD5SMJvGP/BYEUq8wVKQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/9ui+GpUeWiPeqFI9i1A/5t3ArR5ANr8");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("cwf922eA/k9F8e+OQRuaFNwc9G/dLugheMID0OE7b9qHbunJ0i2VN1M0z7na" +
       "03XT1Y4uqJQj/NczBPKHRfF7YJi9QPZ3DOyj/jeXze/fhmweKSqLj3IfPZDN" +
       "R9+GbMoF/dm3WvFwSfA/z0D9naL4o6i4BTBRAT4T5AxF1akPNnfJnmdrknuM" +
       "/Fu3gfzhovJJ8LxygPyVt4v8LcPauQtntF0sKv/kBtBFzR8fo/vebaB7V1FZ" +
       "fMn8xAG6T7zz6C6f0fZgUdwDAtdai9hbfBI9Qnru3ttA+n1F5TPg+fQB0k+/" +
       "80i//4y24o7CuUeBdRZIDz9HH0N77HZN9CnwfP4A2uffGWgnFueVEsMPnoHv" +
       "xaJ4Nqrcq3iuAnySC54bDfXcc7frgIq7m185wPiVt4sxeKtgBB95oXPNM4C2" +
       "iuJqVHnAKW+tEbEdmb69O2Wq0NvBmkWVR256ibi4Dvn4m/59YX/lXvnia5cv" +
       "PfYa9+/3twwPr8XfjVcu6bFtn7zEdOL9Tj/QdLMUxd37WyJ+iQpsYN591u3J" +
       "qHIBlAXn567te4B9weO36gGoQXmSuh9V3nUzakAJypOUQ5C0n6YEWX35+yTd" +
       "GPjEY7qocuf+5SQJ2DRdACTFK15ayevZPgI/ftLISif60Fvp66jLycu6Bdzy" +
       "n1AO7zvF+39Dua586bUp+SPfbn9+f1lYsaU8L0a5hFfu2t9bLgct7ky955aj" +
       "HY515/jF7z7ws3e/cLgje2DP8LHBn+Dt6Ztfyx06flRepM1/8bGff+8/fO13" +
       "yksU/x8wllkvHTQAAA==");
}
