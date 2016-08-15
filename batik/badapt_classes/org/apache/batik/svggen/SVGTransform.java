package org.apache.batik.svggen;
public class SVGTransform extends org.apache.batik.svggen.AbstractSVGConverter {
    private static double radiansToDegrees = 180.0 / java.lang.Math.PI;
    public SVGTransform(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return new org.apache.batik.svggen.SVGTransformDescriptor(
          toSVGTransform(
            gc));
    }
    public final java.lang.String toSVGTransform(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVGTransform(
                 gc.
                   getTransformStack(
                     ));
    }
    public final java.lang.String toSVGTransform(org.apache.batik.ext.awt.g2d.TransformStackElement[] transformStack) {
        int nTransforms =
          transformStack.
            length;
        java.util.Stack presentation =
          new java.util.Stack(
          ) {
            public java.lang.Object push(java.lang.Object o) {
                java.lang.Object element;
                if (((org.apache.batik.ext.awt.g2d.TransformStackElement)
                       o).
                      isIdentity(
                        )) {
                    element =
                      pop(
                        );
                }
                else {
                    super.
                      push(
                        o);
                    element =
                      null;
                }
                return element;
            }
            public java.lang.Object pop() {
                java.lang.Object element =
                  null;
                if (!super.
                      empty(
                        )) {
                    element =
                      super.
                        pop(
                          );
                }
                return element;
            }
        };
        boolean canConcatenate =
          false;
        int i =
          0;
        int j =
          0;
        int next =
          0;
        org.apache.batik.ext.awt.g2d.TransformStackElement element =
          null;
        while (i <
                 nTransforms) {
            next =
              i;
            if (element ==
                  null) {
                element =
                  (org.apache.batik.ext.awt.g2d.TransformStackElement)
                    transformStack[i].
                    clone(
                      );
                next++;
            }
            canConcatenate =
              true;
            for (j =
                   next;
                 j <
                   nTransforms;
                 j++) {
                canConcatenate =
                  element.
                    concatenate(
                      transformStack[j]);
                if (!canConcatenate)
                    break;
            }
            i =
              j;
            element =
              (org.apache.batik.ext.awt.g2d.TransformStackElement)
                presentation.
                push(
                  element);
        }
        if (element !=
              null) {
            presentation.
              push(
                element);
        }
        int nPresentations =
          presentation.
          size(
            );
        java.lang.StringBuffer transformStackBuffer =
          new java.lang.StringBuffer(
          nPresentations *
            8);
        for (i =
               0;
             i <
               nPresentations;
             i++) {
            transformStackBuffer.
              append(
                convertTransform(
                  (org.apache.batik.ext.awt.g2d.TransformStackElement)
                    presentation.
                    get(
                      i)));
            transformStackBuffer.
              append(
                SPACE);
        }
        java.lang.String transformValue =
          transformStackBuffer.
          toString(
            ).
          trim(
            );
        return transformValue;
    }
    final java.lang.String convertTransform(org.apache.batik.ext.awt.g2d.TransformStackElement transformElement) {
        java.lang.StringBuffer transformString =
          new java.lang.StringBuffer(
          );
        double[] transformParameters =
          transformElement.
          getTransformParameters(
            );
        switch (transformElement.
                  getType(
                    ).
                  toInt(
                    )) {
            case org.apache.batik.ext.awt.g2d.TransformType.
                   TRANSFORM_TRANSLATE:
                if (!transformElement.
                      isIdentity(
                        )) {
                    transformString.
                      append(
                        TRANSFORM_TRANSLATE);
                    transformString.
                      append(
                        OPEN_PARENTHESIS);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[0]));
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[1]));
                    transformString.
                      append(
                        CLOSE_PARENTHESIS);
                }
                break;
            case org.apache.batik.ext.awt.g2d.TransformType.
                   TRANSFORM_ROTATE:
                if (!transformElement.
                      isIdentity(
                        )) {
                    transformString.
                      append(
                        TRANSFORM_ROTATE);
                    transformString.
                      append(
                        OPEN_PARENTHESIS);
                    transformString.
                      append(
                        doubleString(
                          radiansToDegrees *
                            transformParameters[0]));
                    transformString.
                      append(
                        CLOSE_PARENTHESIS);
                }
                break;
            case org.apache.batik.ext.awt.g2d.TransformType.
                   TRANSFORM_SCALE:
                if (!transformElement.
                      isIdentity(
                        )) {
                    transformString.
                      append(
                        TRANSFORM_SCALE);
                    transformString.
                      append(
                        OPEN_PARENTHESIS);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[0]));
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[1]));
                    transformString.
                      append(
                        CLOSE_PARENTHESIS);
                }
                break;
            case org.apache.batik.ext.awt.g2d.TransformType.
                   TRANSFORM_SHEAR:
                if (!transformElement.
                      isIdentity(
                        )) {
                    transformString.
                      append(
                        TRANSFORM_MATRIX);
                    transformString.
                      append(
                        OPEN_PARENTHESIS);
                    transformString.
                      append(
                        1);
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[1]));
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[0]));
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        1);
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        0);
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        0);
                    transformString.
                      append(
                        CLOSE_PARENTHESIS);
                }
                break;
            case org.apache.batik.ext.awt.g2d.TransformType.
                   TRANSFORM_GENERAL:
                if (!transformElement.
                      isIdentity(
                        )) {
                    transformString.
                      append(
                        TRANSFORM_MATRIX);
                    transformString.
                      append(
                        OPEN_PARENTHESIS);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[0]));
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[1]));
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[2]));
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[3]));
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[4]));
                    transformString.
                      append(
                        COMMA);
                    transformString.
                      append(
                        doubleString(
                          transformParameters[5]));
                    transformString.
                      append(
                        CLOSE_PARENTHESIS);
                }
                break;
            default:
                throw new java.lang.Error(
                  );
        }
        return transformString.
          toString(
            );
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
       "M3gGR1IbvAqpHZzYjnAn0RV/318CfPQOsviZovhwVHmwlMVJzrO0ulNe/8nf" +
       "Ba/sEa/s3z2vwM6evb2dlemn/eH1i7/0zFd+/MVn/nuZjbnPCDkxQAL9FlcR" +
       "zoz59kvf+ObvvvaJz5RZzrslMdwbwsU7HDdf0Th386Ik/4HzGcynAIMv74Wy" +
       "f0eVd3+P2fLiigwwCwiYBXTeLI7z8X/PM6TH9tS4o8meaNo8EmWruFCkHt39" +
       "uWj95envLxwnU37pb6knUeWyrbp6tLnVKfRdYKmK6j/z05MpD/Z4jql/5PTA" +
       "HLM9Vy0Socd9+4sAhnd4ciMIdKa3JD7dE19OdmZjupUqn7XKf3uHvl8vin8N" +
       "vJdc0LVn4w7gv5Hu35+4A8zniuLnX8kJfPx7cALlJvw0eH7zyAn85qvdJl7R" +
       "1/1iCfD5O7D5xaL4j1GZVtypQXQ7Rn/r1TCaRpUHzgqtSH0/dtPts/2NKfkz" +
       "L16979EXl/9l70qObzXdT1bu02LbPpt1PFO/7AeqZpQc3L/PQfrl63eiyqO3" +
       "2bOKhGJZKcn9z3v43wOcX4QHalS+z8L9QVS5cgoHUO0rZ0H+ENgQACmqX/OP" +
       "zeLtt9tAESmMAlGOgJiwveTVIL10PuQ6Ef7DryT8M1HaM+d8fnkz8DgOivd3" +
       "A5+TP/siQb/3O51P7+96yLaY5wWW+4B73l87OYmlnr4ttmNcl/G3fvfBX73/" +
       "2eO478E9waeqe4a2N976YsXA8aPyKkT+64/+m3f+8xe/Xibg/gbXnMy4sikA" +
       "AA==");
}
