package org.apache.batik.bridge;
public class SVGAnimateTransformElementBridge extends org.apache.batik.bridge.SVGAnimateElementBridge {
    public java.lang.String getLocalName() { return SVG_ANIMATE_TRANSFORM_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGAnimateTransformElementBridge(
                                                            ); }
    protected org.apache.batik.anim.AbstractAnimation createAnimation(org.apache.batik.dom.anim.AnimationTarget target) {
        short type =
          parseType(
            );
        org.apache.batik.anim.values.AnimatableValue from =
          null;
        org.apache.batik.anim.values.AnimatableValue to =
          null;
        org.apache.batik.anim.values.AnimatableValue by =
          null;
        if (element.
              hasAttributeNS(
                null,
                SVG_FROM_ATTRIBUTE)) {
            from =
              parseValue(
                element.
                  getAttributeNS(
                    null,
                    SVG_FROM_ATTRIBUTE),
                type,
                target);
        }
        if (element.
              hasAttributeNS(
                null,
                SVG_TO_ATTRIBUTE)) {
            to =
              parseValue(
                element.
                  getAttributeNS(
                    null,
                    SVG_TO_ATTRIBUTE),
                type,
                target);
        }
        if (element.
              hasAttributeNS(
                null,
                SVG_BY_ATTRIBUTE)) {
            by =
              parseValue(
                element.
                  getAttributeNS(
                    null,
                    SVG_BY_ATTRIBUTE),
                type,
                target);
        }
        return new org.apache.batik.anim.TransformAnimation(
          timedElement,
          this,
          parseCalcMode(
            ),
          parseKeyTimes(
            ),
          parseKeySplines(
            ),
          parseAdditive(
            ),
          parseAccumulate(
            ),
          parseValues(
            type,
            target),
          from,
          to,
          by,
          type);
    }
    protected short parseType() { java.lang.String typeString =
                                    element.
                                    getAttributeNS(
                                      null,
                                      SVG_TYPE_ATTRIBUTE);
                                  if (typeString.equals("translate")) {
                                      return org.w3c.dom.svg.SVGTransform.
                                               SVG_TRANSFORM_TRANSLATE;
                                  }
                                  else
                                      if (typeString.
                                            equals(
                                              "scale")) {
                                          return org.w3c.dom.svg.SVGTransform.
                                                   SVG_TRANSFORM_SCALE;
                                      }
                                      else
                                          if (typeString.
                                                equals(
                                                  "rotate")) {
                                              return org.w3c.dom.svg.SVGTransform.
                                                       SVG_TRANSFORM_ROTATE;
                                          }
                                          else
                                              if (typeString.
                                                    equals(
                                                      "skewX")) {
                                                  return org.w3c.dom.svg.SVGTransform.
                                                           SVG_TRANSFORM_SKEWX;
                                              }
                                              else
                                                  if (typeString.
                                                        equals(
                                                          "skewY")) {
                                                      return org.w3c.dom.svg.SVGTransform.
                                                               SVG_TRANSFORM_SKEWY;
                                                  }
                                  throw new org.apache.batik.bridge.BridgeException(
                                    ctx,
                                    element,
                                    org.apache.batik.bridge.ErrorConstants.
                                      ERR_ATTRIBUTE_VALUE_MALFORMED,
                                    new java.lang.Object[] { SVG_TYPE_ATTRIBUTE,
                                    typeString });
    }
    protected org.apache.batik.anim.values.AnimatableValue parseValue(java.lang.String s,
                                                                      short type,
                                                                      org.apache.batik.dom.anim.AnimationTarget target) {
        float val1;
        float val2 =
          0;
        float val3 =
          0;
        int i =
          0;
        char c =
          ',';
        int len =
          s.
          length(
            );
        while (i <
                 len) {
            c =
              s.
                charAt(
                  i);
            if (c ==
                  ' ' ||
                  c ==
                  ',') {
                break;
            }
            i++;
        }
        val1 =
          java.lang.Float.
            parseFloat(
              s.
                substring(
                  0,
                  i));
        if (i <
              len) {
            i++;
        }
        int count =
          1;
        if (i <
              len &&
              c ==
              ' ') {
            while (i <
                     len) {
                c =
                  s.
                    charAt(
                      i);
                if (c !=
                      ' ') {
                    break;
                }
                i++;
            }
            if (c ==
                  ',') {
                i++;
            }
        }
        while (i <
                 len &&
                 s.
                 charAt(
                   i) ==
                 ' ') {
            i++;
        }
        int j =
          i;
        if (i <
              len &&
              type !=
              org.w3c.dom.svg.SVGTransform.
                SVG_TRANSFORM_SKEWX &&
              type !=
              org.w3c.dom.svg.SVGTransform.
                SVG_TRANSFORM_SKEWY) {
            while (i <
                     len) {
                c =
                  s.
                    charAt(
                      i);
                if (c ==
                      ' ' ||
                      c ==
                      ',') {
                    break;
                }
                i++;
            }
            val2 =
              java.lang.Float.
                parseFloat(
                  s.
                    substring(
                      j,
                      i));
            if (i <
                  len) {
                i++;
            }
            count++;
            if (i <
                  len &&
                  c ==
                  ' ') {
                while (i <
                         len) {
                    c =
                      s.
                        charAt(
                          i);
                    if (c !=
                          ' ') {
                        break;
                    }
                    i++;
                }
                if (c ==
                      ',') {
                    i++;
                }
            }
            while (i <
                     len &&
                     s.
                     charAt(
                       i) ==
                     ' ') {
                i++;
            }
            j =
              i;
            if (i <
                  len &&
                  type ==
                  org.w3c.dom.svg.SVGTransform.
                    SVG_TRANSFORM_ROTATE) {
                while (i <
                         len) {
                    c =
                      s.
                        charAt(
                          i);
                    if (c ==
                          ',' ||
                          c ==
                          ' ') {
                        break;
                    }
                    i++;
                }
                val3 =
                  java.lang.Float.
                    parseFloat(
                      s.
                        substring(
                          j,
                          i));
                if (i <
                      len) {
                    i++;
                }
                count++;
                while (i <
                         len &&
                         s.
                         charAt(
                           i) ==
                         ' ') {
                    i++;
                }
            }
        }
        if (i !=
              len) {
            return null;
        }
        org.apache.batik.dom.svg.SVGOMTransform t =
          new org.apache.batik.dom.svg.SVGOMTransform(
          );
        switch (type) {
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_TRANSLATE:
                if (count ==
                      2) {
                    t.
                      setTranslate(
                        val1,
                        val2);
                }
                else {
                    t.
                      setTranslate(
                        val1,
                        0.0F);
                }
                break;
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SCALE:
                if (count ==
                      2) {
                    t.
                      setScale(
                        val1,
                        val2);
                }
                else {
                    t.
                      setScale(
                        val1,
                        val1);
                }
                break;
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_ROTATE:
                if (count ==
                      3) {
                    t.
                      setRotate(
                        val1,
                        val2,
                        val3);
                }
                else {
                    t.
                      setRotate(
                        val1,
                        0.0F,
                        0.0F);
                }
                break;
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SKEWX:
                t.
                  setSkewX(
                    val1);
                break;
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SKEWY:
                t.
                  setSkewY(
                    val1);
                break;
        }
        return new org.apache.batik.anim.values.AnimatableTransformListValue(
          target,
          t);
    }
    protected org.apache.batik.anim.values.AnimatableValue[] parseValues(short type,
                                                                         org.apache.batik.dom.anim.AnimationTarget target) {
        java.lang.String valuesString =
          element.
          getAttributeNS(
            null,
            SVG_VALUES_ATTRIBUTE);
        int len =
          valuesString.
          length(
            );
        if (len ==
              0) {
            return null;
        }
        java.util.ArrayList values =
          new java.util.ArrayList(
          7);
        int i =
          0;
        int start =
          0;
        int end;
        char c;
        outer: while (i <
                        len) {
            while (valuesString.
                     charAt(
                       i) ==
                     ' ') {
                i++;
                if (i ==
                      len) {
                    break outer;
                }
            }
            start =
              i++;
            if (i <
                  len) {
                c =
                  valuesString.
                    charAt(
                      i);
                while (c !=
                         ';') {
                    i++;
                    if (i ==
                          len) {
                        break;
                    }
                    c =
                      valuesString.
                        charAt(
                          i);
                }
            }
            end =
              i++;
            java.lang.String valueString =
              valuesString.
              substring(
                start,
                end);
            org.apache.batik.anim.values.AnimatableValue value =
              parseValue(
                valueString,
                type,
                target);
            if (value ==
                  null) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  element,
                  org.apache.batik.bridge.ErrorConstants.
                    ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_VALUES_ATTRIBUTE,
                  valuesString });
            }
            values.
              add(
                value);
        }
        org.apache.batik.anim.values.AnimatableValue[] ret =
          new org.apache.batik.anim.values.AnimatableValue[values.
                                                             size(
                                                               )];
        return (org.apache.batik.anim.values.AnimatableValue[])
                 values.
                 toArray(
                   ret);
    }
    protected boolean canAnimateType(int type) {
        return type ==
          org.apache.batik.util.SVGTypes.
            TYPE_TRANSFORM_LIST;
    }
    public SVGAnimateTransformElementBridge() {
        super(
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
       "+vOncPbey1BzbtjLQHO2IIDnkrp8fvBswp/Nr4BAvKd+1Dqqlf8/UnV8uipv" +
       "lMUHD1YvH78PRGxUJZygh2l7qlvxeTYGHuNqN05iVAYJKDDxjY3bqti8C6Tc" +
       "lXeUyhwdsrYDVpUldpCiem7e1hueP5EVzP7DZ8w4HySAn/rTz/zuTz3zTTBF" +
       "LHRPWpoPzMy5EfmkzIn/7iuffeJtL/3xpyoAAugj/+3vPP6RkuvwThqXRa8s" +
       "+ieqPl6qKlUrPKdG8ajCCUOvtL2jZwqhvQXQmh4nfMiLj37T+dk/+5VDMnfZ" +
       "DS8RG5986e/91dGnX7p6LoV+5qYs9nyfQxpdCf32YwuH0NN3GqXqQf2nL734" +
       "L3/pxU8cpHr0YkLYB+87v/IH//t3jz73x1+9RbZxt+u/hYmNr7+XxiOmc/Lh" +
       "UMVodDRR9FJskW7p0OMaM49ZyPiCYNkNlW0YfD+U6K6+T2itocH0rLcgFc/A" +
       "dE8voqLXmxotjRVtcu5KpJStLSke9+DagJyQlihKdsbnO86ZSV05HYuyxcD+" +
       "sp+z+zUji8IebgVbPS+aiRWp4TZuNlo7uJUiLRRtIWmzTow9qYO6jtPcjZb2" +
       "agjSpplt5v7SqTU5duHO9yGDTvh9mIYNDjZibGU1jL40r2vTUZtB/U40X0jx" +
       "JJ47lGTG9naZS8o44GfroO9Fo60u2Y1w06eoOue0t0NUIVC5L8/rDGkEpJUx" +
       "gZOPHN4uqIk0nq1arUl/qS7hLusOEmkhohHneGIQOJi+2dkRUtiC3py7nX2T" +
       "aLgjnVHr+yEvtfvarC36U45aTtu4M8xyHVOCuS6qa0NcKb7b8CdYV26NGJtk" +
       "l0Rd4IxuS/fmG6c/2st8LXdNL5x356HfnAajvJZw8/bOqakoKqSOtFvupiJD" +
       "5IxC7BW+A/5sKUlpzRNqsDGnnKzFoPu+To8lbj7YdPw8ii3EJgfKLF4air8J" +
       "e6QwG2FpnPbGke5S63g+lMVZQixrcq2FtML5Gt4xNprXdqyfNe1xr+9nW3Iy" +
       "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" +
       "4UDwzADFWzDAU2Vl2f79xwb4/jdjABAYQejHhhYb+i3tcOX4MPJYpWdvUkn3" +
       "t0eqZ2+PDoefIBymagiMUXH7yTtY7u+XxSdi6JoWGmpsnHY/GeqDNw11GGYV" +
       "xaGqxRfpKzN+8i2Y8Z0nfqQcm1F5s370qTf0o8/foe3nyuJz5XSU11NOTyzF" +
       "c3Aqx9A90doP4zONf+YtaFyCAvR94Osfa+x/dzS+62wBqdaFny+LT1ekr9zB" +
       "AF8si1+MoQcrA1QnNiee8NytPaE6loiO/a48VTzrVBnnl95qVMHg+9qxcV77" +
       "7hjnakVw9ZJd/sUd7PKvyuIrAGDO2QUsWx+4/bJVHY0ezjhe/sfP/N6Pv/zM" +
       "f6xOF++3I1kNO6F1i+s25/p8+5Vvvva1tz/xxeo0/u6VGh3Wlcv3lG6+hnTh" +
       "dlEl+0On9ny81OfZY5ue2BaKoflbvP1ROkJ5TOyHp3hwcrHk/xXrSrMv3xIg" +
       "q4OX38ivQJWP/OatvaOa/Cq1Os2q7nUNz4rXt4r4u4CZy8dXg/yyE52ExzvO" +
       "juVI1/eMMhRO2g6XTWz/6PTGGmjMbyn85iB8NVhZPHMHp/z6Hdr+oCy+BrBK" +
       "K4U5yH4H8j88DsYqZP/pWwjZx8rKG0Cb7zn0Pfy+9ZC9ckbw1YrgT+6gzZ+W" +
       "xR/F0MPA605uA90Gy+8Dr7auoZ5bv77xZrTPY+ipN7pyVN6ZeM9N1x8PV/a0" +
       "L7587f53vzz7d4c4P7lW9wAH3W8mrnv+iPvc871BaJh2peoDhwPvoPr5bzH0" +
       "7ttkO8C9V2f5zrcO9K/H0PXL9MBlqt/zdP8dLAhndIDV4eE8yV+AIAEk5eNf" +
       "Bid+j7zxLa0LlsqvXHzDOJ2TR99oTs69lDxzAZOr26knaX9yuJ/6gvall1n+" +
       "R19v/sLhzpDmqkVRcrkfwOfh+tLpq8PTt+V2wute+tnvPPzlBz5w8prz8EHg" +
       "Mzc/J9v7bn0pp78N4uoaTfHP3/1rP/CLL3+jOsr/v3LUwAI2LAAA");
}
