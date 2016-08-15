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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "zOAhIFG6YEPD5SMJvGP/BXuHMmMVKQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "jKsPtxK5Ye1GBNemLGWlGJ8ju46oOkizsWqsVr3tMqiNTSKTh1yE9jdeO2Ik" +
       "cd63OKavhOnIWM/77fV6sh1MZqOJ2KhjjLcIqlAVippxJ2ryLdnPh3m10cmb" +
       "CQQ1E1D4SKKmSJVBvdDqMIvNik8JgZQwPqzZfp8w21J7qTg70iJ1Lmg3WToI" +
       "VAYJ+T5s23PK0m1zVw/jBbMKue1WCnvqzJT6EktObWm8M8gJp6N+X6gzu4XT" +
       "Jr2eI4lCwtiDJb8YBarKjnpue8qSlGOyY3bMpbuGmdDz4QZfYcJCyJMpKdtY" +
       "tU1YdV8ku6LS9S2t63RodDR1mjgXMkawabTnzEwUbdPY4rNMDvKpa/UscpXB" +
       "IueuVnOMSgTfbOeT5Xq1qgvDVJhi4xyuaqqaTmB1bW4Zn4ppkxdjz5fCDdnn" +
       "3AHfScb+0gmoZDqqGaJLMrDZt30zj/HMGTBjNN8uqGiRap1gO5VJlYoUjJKJ" +
       "5didxOho3DJUSrBMx8bH7kLvIWmaLfOppBIwVetC+AI1HZzBc5AVbGKtjQT6" +
       "bEeQvR3Q5SpIq81J2LPGZpr2vME8XwwbwazFm9s5tvAn4121bfqL2XaXImIt" +
       "bHOExOD4OvFUHu/lUh1lg6pt9lfesKHswhyb53i9LY1bLLKqgYRJEHv12ImD" +
       "IY5icYr1pHDZmJqiHQ5ieSrvOsKWF5xF7O6IREDi5byHhlY+4wZa0vIVD4zu" +
       "T8K8xyzV2Vhw62st8ubWSPaESc+ZdAh0WuPDAedq+LrJTEdba7ODDcPrb4m1" +
       "gvKMKbZMfUPAY15MnFqLxGgmi/gO7vf5djRazNmGO5vtzCROepLIYwjhOFvB" +
       "6bPdOTCIqMs2F8hMH3vwvNdl53ooDVqwUHPxYgeeGK05S3X6RHOc8nVOtOxW" +
       "szFAZk2qPdp1k7RR58by1vboCT6lVM0O+hjlEmNmuvGrjJ2FBCHSeO7vSK5J" +
       "1xY0w9l1vO1wKsvLPTbaWglPeNKGSybTbX06F1idX+yWDK7qdLbaTKadmJox" +
       "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" +
       "zkD9b4riq1Hl4T3qhSLZtwH9r98J0OYB");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("aPNPHfRvnQH6PxbFvz0GbWhScGvQv3mnoIfgCQ9Ah++8aR+6padKt1TeTNE8" +
       "52pP101XO7qgUo7wX84QyB8Uxe+CYfYC2d8xsI/631o2v3cHsnm0qCw+yn30" +
       "QDYffRuyKRf0Z99qxcMlwf88A/V3iuJ/RMUtgIkK8JkgZyiqTn2wuUf2PFuT" +
       "3GPk37oD5I8UlU+B59UD5K++XeRvGdbOXTij7WJR+Uc3gC5q/vAY3ffuAN27" +
       "i8riS+YnDtB94p1Hd/mMtoeK4j4QuNZaxN7mk+gR0nP33wHS7ysqnwXPpw+Q" +
       "fvqdR/r9Z7QVdxTOPQass0B6+Dn6GNrjd2qiT4Pn8wfQPv/OQDuxOK+UGH7w" +
       "DHwvFcVzUeV+xXMV4JNc8NxoqOeev1MHVNzd/MoBxq+8XYzBWwUj+MgLnWue" +
       "AbRVFFejyoNOeWuNiO3I9O3dKVOF3g7WLKo8estLxMV1yCdu+veF/ZV75Yuv" +
       "X770+Ovcv9vfMjy8Fn8vXrmkx7Z98hLTife7/UDTzVIU9+5vifglKrCBec9Z" +
       "tyejygVQFpyfu7bvAfYFT9yuB6AG5UnqflR5962oASUoT1IOQdJ+mhJk9eXv" +
       "k3QY8InHdFHl7v3LSRKwaboASIpXvLSSN7J9BH7ipJGVTvTht9LXUZeTl3UL" +
       "uOU/oRzed4r3/4ZyXfnS61PyR77d/vz+srBiS3lejHIJr9yzv7dcDlrcmXrv" +
       "bUc7HOtu7KXvPvgz9754uCN7cM/wscGf4O2ZW1/LHTp+VF6kzX/h8Z973z94" +
       "/bfLSxT/H/v6um8dNAAA");
}
