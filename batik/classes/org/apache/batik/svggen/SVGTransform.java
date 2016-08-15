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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "GiwxQR+NCYrz5rN6QlCbpNtMaIQhRrPIq01SVAL0GgOE78O0Au06Ljrc0XE3" +
       "kIE7J5m0TSvuGI+M0USlvGASSDpZHXUyfgmJU1yIqwM3sId9yJszI3wS2o3q" +
       "UFQb2VgnwedPAs3gnJhA62BVj+FcXuCxro9NcpMOgHMA3yq1ft3MLMcDaNqj" +
       "KKZqGbfmVYuUJuhk4ntMqu3W3IhOplNZruLLOMudTUKTKm33IMiC7WqTWrgO" +
       "SltdcxMnBl+bJd3EqsbWtMkiFroOh/lAncyx+TqzMEMVnSWXggiOtwV4J/oE" +
       "FTCbti2MUCKHcgnEUg4IfBsgltInqRxNGSJvQS6i4CbOuFQG7SwFb6db1mBT" +
       "cuajOtVkWIgPDNuoVuWQ6hFWWse2WIfL40VrO5+g8KAXWz22PfapNkxEGZN0" +
       "JJRW4k7IQt2JaWFNc6wQIr/0UF4ztr1cI3jD24yoQJ1CdDsSURsWzUZtNpvZ" +
       "dcjC+0CTU8Ve6agTj3gfTRehPYqyiRHtqmtFtsemb3QyzBcbFu+tUkt3e2wq" +
       "Ob7i6N2e0G0JGCfo46a/nW+GCDvhg84mTFehsVC5te2oJA++f5lRQ7C8uKa4" +
       "XGPQ4PJ6OmtCaI1WPQ7bbueW1G9UScwjGIydmC1/0eryfQFrTi2nyc1Gu1Vr" +
       "O+AbCJQxjaRaVVB2ixqdroqCj/N3vav4bNdf3XHCQ+XJyUkKUzeRomP3Kk4M" +
       "9l1PF8WzJ2d15e/yxbTX2aP007PSSnE69cTtMpPlydSnPvjCiyL9i/WDozNm" +
       "OqzcHzruO0wplswLx65vu/0p3LRMzJ6efX7ug//t8dX3q+99FVmgN16g8yLK" +
       "fzN96QvDNws/eVC56+Qk9KaU8flBN86ff17xpTDy7dW5U9AnTiT7vYXEngTP" +
       "jSPJ3rh1JuaWWnCp1IL92l84wn/FlEAhTS4JD5WGeDj0OVc9yd6X+N5/h5TA" +
       "DxfF+8LKPaGzZIbHUzx7h6xDXwoEX3OP8/elEv7gKx1bnZ22bDhN7TxWNL4Z" +
       "PIMjqQ1ehdQOTmxncyfRFX8/UAJ87A6y+Mmi+EhYebCUxUnOs7S6U15//B+C" +
       "18URr4t/eF6BnT17ezsr00/7w+sXf+mZL//Qi8/8VZmNuU8LGM7v+sotriKc" +
       "GfOtl77+jT997ROfLrOcd/NcsDeEi3c4br6ice7mRUn+A+czmE8BBl/eC2X/" +
       "Divv+S6z5cUVGWAWEDAL6LxZHOfj/5FnSI/tqXFHkz3RtGXICUZxoUg6uvtz" +
       "0frL099fOE6m/NLfU0/CymVTspVQvdUp9F1gqYrqz7vpyZQHezzH1D9yemCO" +
       "mY4tFYnQ4779RQDNOTy5EQQ601sSn+6JLyc7szHdSpXPWuVv3aHvd4ri14H3" +
       "Egq69mzcAfx30/37k3eA+WxR/MwrOYFPfBdOoNyEnwbP7x05gd97tdvEK/q6" +
       "f1kCfO4ObH6hKP4wLNOKseSHt2P0j14No2lYeeCs0IrU92M33T7b35gSPv3i" +
       "1fsefXH9H/au5PhW0/1k5T45Ms2zWccz9cuuL8laycH9+xykW77+XVh59DZ7" +
       "VpFQLCsluf92D//vAecX4YEale+zcH8eVq6cwgFU+8pZkL8ANgRAiupX3WOz" +
       "ePvtNtAuH4Q+J4RATNhe8pKfXjofcp0I/+FXEv6ZKO2Zcz6/vBl4HAdF+7uB" +
       "zwmfeZGg3vft9i/u73oIJpfnBZb7gHveXzs5iaWevi22Y1yXR2/9zoO/ev+z" +
       "x3Hfg3uCT1X3DG1vvPXFioHlhuVViPx3Hv2Nd/6rF79WJuD+P8evAWOyKQAA");
}
