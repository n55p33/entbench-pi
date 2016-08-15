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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
