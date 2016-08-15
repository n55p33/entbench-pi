package org.apache.batik.dom.svg;
public class SVGOMAnimatedNumber extends org.apache.batik.dom.svg.AbstractSVGAnimatedValue implements org.w3c.dom.svg.SVGAnimatedNumber {
    protected float defaultValue;
    protected boolean allowPercentage;
    protected boolean valid;
    protected float baseVal;
    protected float animVal;
    protected boolean changing;
    public SVGOMAnimatedNumber(org.apache.batik.dom.svg.AbstractElement elt,
                               java.lang.String ns,
                               java.lang.String ln,
                               float val) { this(elt, ns, ln, val, false);
    }
    public SVGOMAnimatedNumber(org.apache.batik.dom.svg.AbstractElement elt,
                               java.lang.String ns,
                               java.lang.String ln,
                               float val,
                               boolean allowPercentage) { super(elt, ns, ln);
                                                          defaultValue = val;
                                                          this.allowPercentage =
                                                            allowPercentage;
    }
    public float getBaseVal() { if (!valid) { update(); }
                                return baseVal; }
    protected void update() { org.w3c.dom.Attr attr = element.getAttributeNodeNS(
                                                                namespaceURI,
                                                                localName);
                              if (attr == null) { baseVal = defaultValue;
                              }
                              else {
                                  java.lang.String v =
                                    attr.
                                    getValue(
                                      );
                                  int len =
                                    v.
                                    length(
                                      );
                                  if (allowPercentage &&
                                        len >
                                        1 &&
                                        v.
                                        charAt(
                                          len -
                                            1) ==
                                        '%') {
                                      baseVal =
                                        0.01F *
                                          java.lang.Float.
                                          parseFloat(
                                            v.
                                              substring(
                                                0,
                                                len -
                                                  1));
                                  }
                                  else {
                                      baseVal =
                                        java.lang.Float.
                                          parseFloat(
                                            v);
                                  }
                              }
                              valid = true; }
    public void setBaseVal(float baseVal) throws org.w3c.dom.DOMException {
        try {
            this.
              baseVal =
              baseVal;
            valid =
              true;
            changing =
              true;
            element.
              setAttributeNS(
                namespaceURI,
                localName,
                java.lang.String.
                  valueOf(
                    baseVal));
        }
        finally {
            changing =
              false;
        }
    }
    public float getAnimVal() { if (hasAnimVal) { return animVal;
                                }
                                if (!valid) { update(); }
                                return baseVal; }
    public org.apache.batik.anim.values.AnimatableValue getUnderlyingValue(org.apache.batik.dom.anim.AnimationTarget target) {
        return new org.apache.batik.anim.values.AnimatableNumberValue(
          target,
          getBaseVal(
            ));
    }
    protected void updateAnimatedValue(org.apache.batik.anim.values.AnimatableValue val) {
        if (val ==
              null) {
            hasAnimVal =
              false;
        }
        else {
            hasAnimVal =
              true;
            this.
              animVal =
              ((org.apache.batik.anim.values.AnimatableNumberValue)
                 val).
                getValue(
                  );
        }
        fireAnimatedAttributeListeners(
          );
    }
    public void attrAdded(org.w3c.dom.Attr node, java.lang.String newv) {
        if (!changing) {
            valid =
              false;
        }
        fireBaseAttributeListeners(
          );
        if (!hasAnimVal) {
            fireAnimatedAttributeListeners(
              );
        }
    }
    public void attrModified(org.w3c.dom.Attr node,
                             java.lang.String oldv,
                             java.lang.String newv) {
        if (!changing) {
            valid =
              false;
        }
        fireBaseAttributeListeners(
          );
        if (!hasAnimVal) {
            fireAnimatedAttributeListeners(
              );
        }
    }
    public void attrRemoved(org.w3c.dom.Attr node,
                            java.lang.String oldv) {
        if (!changing) {
            valid =
              false;
        }
        fireBaseAttributeListeners(
          );
        if (!hasAnimVal) {
            fireAnimatedAttributeListeners(
              );
        }
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
      ("H4sIAAAAAAAAALV6C8zr1n2fvut7fW3H8b12Xq6b+JFcp7GVXEokJVFzm0ai" +
       "HhRFinqRFJmuNxTf4vslkuq8pgHSBA2QBpvTZWhroECKZl2aFNuMDSu6uS22" +
       "NmvRrkOxdsOWBFuBZWuzNdjWFc227JD63ve713bsfQDPRx3+zzn/3/9NnvPF" +
       "b1auRGGl6nt2rttefFPN4psbu3Ezzn01uklSjakURqqC21IULUHfLfndv3zt" +
       "z7/9GeP6pcq9YuUtkut6sRSbnhvN1cizt6pCVa6d9PZt1YniynVqI20lKIlN" +
       "G6LMKH6Oqrzp1NC4coM6YgECLECABahkAeqcUIFBb1bdxMGLEZIbR0Hlr1cO" +
       "qMq9vlywF1eeOjuJL4WSczjNtEQAZriv+M0BUOXgLKw8eYx9j/k2wJ+tQi/8" +
       "rR++/vfuqVwTK9dMd1GwIwMmYrCIWHnQUZ21GkYdRVEVsfKwq6rKQg1NyTZ3" +
       "Jd9i5ZHI1F0pTkL1WEhFZ+KrYbnmieQelAtsYSLHXngMTzNVWzn6dUWzJR1g" +
       "ffsJ1j3CQdEPAD5gAsZCTZLVoyGXLdNV4soT50ccY7wxBgRg6FVHjQ3veKnL" +
       "rgQ6Ko/sdWdLrg4t4tB0dUB6xUvAKnHlsTtOWsjal2RL0tVbceXR83TT/SNA" +
       "dX8piGJIXHnbebJyJqClx85p6ZR+vjn5/k//iEu4l0qeFVW2C/7vA4MePzdo" +
       "rmpqqLqyuh/44LPUT0lv/9VPXqpUAPHbzhHvaf7hX/vWh97/+Mu/taf53gto" +
       "mPVGleNb8ufXD/3+O/Fn2vcUbNzne5FZKP8M8tL8p4dPnst84HlvP56xeHjz" +
       "6OHL838ufPQX1T+5VHlgVLlX9uzEAXb0sOw5vmmr4VB11VCKVWVUuV91Fbx8" +
       "PqpcBfeU6ar7XkbTIjUeVS7bZde9XvkbiEgDUxQiugruTVfzju59KTbK+8yv" +
       "VCpXwVW5Aa6nK/u/9xRNXLkFGZ6jQpIsuabrQdPQK/BHkOrGayBbA1oDq7eg" +
       "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" +
       "57haOihPTcAnWB+5C9a3Fs2b48qDBdaj");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("faxzcB96vXARcP3eIdzfe0M1fQK3RPP4XZA+WTTfE4MiCCCdq463vQ3oY6/p" +
       "MAjwkguOThbnwB697Yj2/lix/KUXr933jhfZPyxPDx4f/b2fqtynJbZ9+ojE" +
       "qft7/VDVzFIK9+8PTPgloO87zGoXHRuLK/eAtuD54L176mfjylsvogaUoD1N" +
       "+YFDxzlNGVeulP9P09VARjmhAwXF/uY0CQJmByTFLeofeWX9Fc+6nSqfy8iT" +
       "HZwqgA9NrIxBj7ySwo6HnD6lWBTN5Vn7owI32Z+2vyV/+UVy8iPfav78/pSk" +
       "bEu7XTHLfVTl6v7A5nGR/NQdZzua617imW8/9Mv3P31U0D+0Z/jE3E/x9sTF" +
       "RxL7jh+Xhwh3/+gd/+D7f+HFr5b71v8P82dutwQxAAA=");
}
