package org.apache.batik.bridge;
public class SVGAnimateElementBridge extends org.apache.batik.bridge.SVGAnimationElementBridge {
    public java.lang.String getLocalName() { return SVG_ANIMATE_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGAnimateElementBridge(
                                                            ); }
    protected org.apache.batik.anim.AbstractAnimation createAnimation(org.apache.batik.dom.anim.AnimationTarget target) {
        org.apache.batik.anim.values.AnimatableValue from =
          parseAnimatableValue(
            SVG_FROM_ATTRIBUTE);
        org.apache.batik.anim.values.AnimatableValue to =
          parseAnimatableValue(
            SVG_TO_ATTRIBUTE);
        org.apache.batik.anim.values.AnimatableValue by =
          parseAnimatableValue(
            SVG_BY_ATTRIBUTE);
        return new org.apache.batik.anim.SimpleAnimation(
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
            ),
          from,
          to,
          by);
    }
    protected int parseCalcMode() { if (animationType == org.apache.batik.anim.AnimationEngine.
                                                           ANIM_TYPE_CSS &&
                                          !targetElement.
                                          isPropertyAdditive(
                                            attributeLocalName) ||
                                          animationType ==
                                          org.apache.batik.anim.AnimationEngine.
                                            ANIM_TYPE_XML &&
                                          !targetElement.
                                          isAttributeAdditive(
                                            attributeNamespaceURI,
                                            attributeLocalName)) {
                                        return org.apache.batik.anim.SimpleAnimation.
                                                 CALC_MODE_DISCRETE;
                                    }
                                    java.lang.String calcModeString =
                                      element.
                                      getAttributeNS(
                                        null,
                                        SVG_CALC_MODE_ATTRIBUTE);
                                    if (calcModeString.
                                          length(
                                            ) ==
                                          0) {
                                        return getDefaultCalcMode(
                                                 );
                                    }
                                    else
                                        if (calcModeString.
                                              equals(
                                                org.apache.batik.util.SMILConstants.
                                                  SMIL_LINEAR_VALUE)) {
                                            return org.apache.batik.anim.SimpleAnimation.
                                                     CALC_MODE_LINEAR;
                                        }
                                        else
                                            if (calcModeString.
                                                  equals(
                                                    org.apache.batik.util.SMILConstants.
                                                      SMIL_DISCRETE_VALUE)) {
                                                return org.apache.batik.anim.SimpleAnimation.
                                                         CALC_MODE_DISCRETE;
                                            }
                                            else
                                                if (calcModeString.
                                                      equals(
                                                        org.apache.batik.util.SMILConstants.
                                                          SMIL_PACED_VALUE)) {
                                                    return org.apache.batik.anim.SimpleAnimation.
                                                             CALC_MODE_PACED;
                                                }
                                                else
                                                    if (calcModeString.
                                                          equals(
                                                            org.apache.batik.util.SMILConstants.
                                                              SMIL_SPLINE_VALUE)) {
                                                        return org.apache.batik.anim.SimpleAnimation.
                                                                 CALC_MODE_SPLINE;
                                                    }
                                    throw new org.apache.batik.bridge.BridgeException(
                                      ctx,
                                      element,
                                      org.apache.batik.bridge.ErrorConstants.
                                        ERR_ATTRIBUTE_VALUE_MALFORMED,
                                      new java.lang.Object[] { SVG_CALC_MODE_ATTRIBUTE,
                                      calcModeString });
    }
    protected boolean parseAdditive() { java.lang.String additiveString =
                                          element.
                                          getAttributeNS(
                                            null,
                                            SVG_ADDITIVE_ATTRIBUTE);
                                        if (additiveString.
                                              length(
                                                ) ==
                                              0 ||
                                              additiveString.
                                              equals(
                                                org.apache.batik.util.SMILConstants.
                                                  SMIL_REPLACE_VALUE)) {
                                            return false;
                                        }
                                        else
                                            if (additiveString.
                                                  equals(
                                                    org.apache.batik.util.SMILConstants.
                                                      SMIL_SUM_VALUE)) {
                                                return true;
                                            }
                                        throw new org.apache.batik.bridge.BridgeException(
                                          ctx,
                                          element,
                                          org.apache.batik.bridge.ErrorConstants.
                                            ERR_ATTRIBUTE_VALUE_MALFORMED,
                                          new java.lang.Object[] { SVG_ADDITIVE_ATTRIBUTE,
                                          additiveString });
    }
    protected boolean parseAccumulate() {
        java.lang.String accumulateString =
          element.
          getAttributeNS(
            null,
            SVG_ACCUMULATE_ATTRIBUTE);
        if (accumulateString.
              length(
                ) ==
              0 ||
              accumulateString.
              equals(
                org.apache.batik.util.SMILConstants.
                  SMIL_NONE_VALUE)) {
            return false;
        }
        else
            if (accumulateString.
                  equals(
                    org.apache.batik.util.SMILConstants.
                      SMIL_SUM_VALUE)) {
                return true;
            }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          element,
          org.apache.batik.bridge.ErrorConstants.
            ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_ACCUMULATE_ATTRIBUTE,
          accumulateString });
    }
    protected org.apache.batik.anim.values.AnimatableValue[] parseValues() {
        boolean isCSS =
          animationType ==
          org.apache.batik.anim.AnimationEngine.
            ANIM_TYPE_CSS;
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
            if (i !=
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
            org.apache.batik.anim.values.AnimatableValue val =
              eng.
              parseAnimatableValue(
                element,
                animationTarget,
                attributeNamespaceURI,
                attributeLocalName,
                isCSS,
                valuesString.
                  substring(
                    start,
                    end));
            if (!checkValueType(
                   val)) {
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
                val);
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
    protected float[] parseKeyTimes() { java.lang.String keyTimesString =
                                          element.
                                          getAttributeNS(
                                            null,
                                            SVG_KEY_TIMES_ATTRIBUTE);
                                        int len =
                                          keyTimesString.
                                          length(
                                            );
                                        if (len ==
                                              0) {
                                            return null;
                                        }
                                        java.util.ArrayList keyTimes =
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
                                            while (keyTimesString.
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
                                            if (i !=
                                                  len) {
                                                c =
                                                  keyTimesString.
                                                    charAt(
                                                      i);
                                                while (c !=
                                                         ' ' &&
                                                         c !=
                                                         ';') {
                                                    i++;
                                                    if (i ==
                                                          len) {
                                                        break;
                                                    }
                                                    c =
                                                      keyTimesString.
                                                        charAt(
                                                          i);
                                                }
                                            }
                                            end =
                                              i++;
                                            try {
                                                float keyTime =
                                                  java.lang.Float.
                                                  parseFloat(
                                                    keyTimesString.
                                                      substring(
                                                        start,
                                                        end));
                                                keyTimes.
                                                  add(
                                                    new java.lang.Float(
                                                      keyTime));
                                            }
                                            catch (java.lang.NumberFormatException nfEx) {
                                                throw new org.apache.batik.bridge.BridgeException(
                                                  ctx,
                                                  element,
                                                  nfEx,
                                                  org.apache.batik.bridge.ErrorConstants.
                                                    ERR_ATTRIBUTE_VALUE_MALFORMED,
                                                  new java.lang.Object[] { SVG_KEY_TIMES_ATTRIBUTE,
                                                  keyTimesString });
                                            }
                                        }
                                        len =
                                          keyTimes.
                                            size(
                                              );
                                        float[] ret =
                                          new float[len];
                                        for (int j =
                                               0;
                                             j <
                                               len;
                                             j++) {
                                            ret[j] =
                                              ((java.lang.Float)
                                                 keyTimes.
                                                 get(
                                                   j)).
                                                floatValue(
                                                  );
                                        }
                                        return ret;
    }
    protected float[] parseKeySplines() {
        java.lang.String keySplinesString =
          element.
          getAttributeNS(
            null,
            SVG_KEY_SPLINES_ATTRIBUTE);
        int len =
          keySplinesString.
          length(
            );
        if (len ==
              0) {
            return null;
        }
        java.util.List keySplines =
          new java.util.ArrayList(
          7);
        int count =
          0;
        int i =
          0;
        int start =
          0;
        int end;
        char c;
        outer: while (i <
                        len) {
            while (keySplinesString.
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
            if (i !=
                  len) {
                c =
                  keySplinesString.
                    charAt(
                      i);
                while (c !=
                         ' ' &&
                         c !=
                         ',' &&
                         c !=
                         ';') {
                    i++;
                    if (i ==
                          len) {
                        break;
                    }
                    c =
                      keySplinesString.
                        charAt(
                          i);
                }
                end =
                  i++;
                if (c ==
                      ' ') {
                    do  {
                        if (i ==
                              len) {
                            break;
                        }
                        c =
                          keySplinesString.
                            charAt(
                              i++);
                    }while(c ==
                             ' '); 
                    if (c !=
                          ';' &&
                          c !=
                          ',') {
                        i--;
                    }
                }
                if (c ==
                      ';') {
                    if (count ==
                          3) {
                        count =
                          0;
                    }
                    else {
                        throw new org.apache.batik.bridge.BridgeException(
                          ctx,
                          element,
                          org.apache.batik.bridge.ErrorConstants.
                            ERR_ATTRIBUTE_VALUE_MALFORMED,
                          new java.lang.Object[] { SVG_KEY_SPLINES_ATTRIBUTE,
                          keySplinesString });
                    }
                }
                else {
                    count++;
                }
            }
            else {
                end =
                  i++;
            }
            try {
                float keySplineValue =
                  java.lang.Float.
                  parseFloat(
                    keySplinesString.
                      substring(
                        start,
                        end));
                keySplines.
                  add(
                    new java.lang.Float(
                      keySplineValue));
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  element,
                  nfEx,
                  org.apache.batik.bridge.ErrorConstants.
                    ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_KEY_SPLINES_ATTRIBUTE,
                  keySplinesString });
            }
        }
        len =
          keySplines.
            size(
              );
        float[] ret =
          new float[len];
        for (int j =
               0;
             j <
               len;
             j++) {
            ret[j] =
              ((java.lang.Float)
                 keySplines.
                 get(
                   j)).
                floatValue(
                  );
        }
        return ret;
    }
    protected int getDefaultCalcMode() { return org.apache.batik.anim.SimpleAnimation.
                                                  CALC_MODE_LINEAR;
    }
    protected boolean canAnimateType(int type) {
        return true;
    }
    public SVGAnimateElementBridge() { super(
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
       "8YeHAD0ydoLtAj8uar902kmKnfN9B0y+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("75DJf1ky+a+ymyH6JdPxlfjW9vUnh/b1Z/+X9lUUv3tkW9+50baKr79XFP/u" +
       "HGP5k5LYd97IWL5367YLpd7/vCj+456Tc/recdJS/uh2bGl/fLAIf3zbLeXC" +
       "fee0FfkiF+4+3NKApfBBkbJZ9v3OkYgXLr/VCO0a4Pb5/dj939sr4qPntD1W" +
       "FA/HlYdAcEsYppI48WGYVprdsZRvf6sLWUhJHEhJ3B4pLxx3+JlSnGvniPre" +
       "ongyrjwAdqGDFNDD35fH8cmFp96MmFlceectEkqLjLhHb8hg32dda5995crl" +
       "d74y+939vn6YGX0PXblsJo5zMoHpxPtdQWiYdqmHe/bpTEEp1/cDJm7xmwxs" +
       "T+rRr7IL79/3r8WVq2f7A+gq/57sB8eVe4/7AVL7l5NdWiBwB12KVzQ43Mrq" +
       "b5h6e/DvB0e6yvZY9ehJ4ynB46E3WowThydPn4rCyn8xODyeSPb/ZPCC9rlX" +
       "huMf+XbrZ/c5oZqj5HlB5TIImPbpqQcB08nEobPUDmnd1X/2uw98/p5nDo9j" +
       "HtgzfGzIJ3h78uZJl6QbxGWaZP6P3vkPfuDnX/lqmar1fwDEgBJv+zEAAA==");
}
