package org.apache.batik.anim.values;
public class AnimatableAngleOrIdentValue extends org.apache.batik.anim.values.AnimatableAngleValue {
    protected boolean isIdent;
    protected java.lang.String ident;
    protected AnimatableAngleOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableAngleOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target,
                                       float v,
                                       short unit) { super(
                                                       target,
                                                       v,
                                                       unit);
    }
    public AnimatableAngleOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target,
                                       java.lang.String ident) {
        super(
          target);
        this.
          ident =
          ident;
        this.
          isIdent =
          true;
    }
    public boolean isIdent() { return isIdent; }
    public java.lang.String getIdent() { return ident;
    }
    public boolean canPace() { return false; }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableAngleOrIdentValue(
          target,
          0,
          org.w3c.dom.svg.SVGAngle.
            SVG_ANGLETYPE_UNSPECIFIED);
    }
    public java.lang.String getCssText() {
        if (isIdent) {
            return ident;
        }
        return super.
          getCssText(
            );
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableAngleOrIdentValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableAngleOrIdentValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableAngleOrIdentValue)
                result;
        }
        if (to ==
              null) {
            if (isIdent) {
                res.
                  hasChanged =
                  !res.
                     isIdent ||
                    !res.
                       ident.
                    equals(
                      ident);
                res.
                  ident =
                  ident;
                res.
                  isIdent =
                  true;
            }
            else {
                short oldUnit =
                  res.
                    unit;
                float oldValue =
                  res.
                    value;
                super.
                  interpolate(
                    res,
                    to,
                    interpolation,
                    accumulation,
                    multiplier);
                if (res.
                      unit !=
                      oldUnit ||
                      res.
                        value !=
                      oldValue) {
                    res.
                      hasChanged =
                      true;
                }
            }
        }
        else {
            org.apache.batik.anim.values.AnimatableAngleOrIdentValue toValue =
              (org.apache.batik.anim.values.AnimatableAngleOrIdentValue)
                to;
            if (isIdent ||
                  toValue.
                    isIdent) {
                if (interpolation >=
                      0.5) {
                    if (res.
                          isIdent !=
                          toValue.
                            isIdent ||
                          res.
                            unit !=
                          toValue.
                            unit ||
                          res.
                            value !=
                          toValue.
                            value ||
                          res.
                            isIdent &&
                          toValue.
                            isIdent &&
                          !toValue.
                             ident.
                          equals(
                            ident)) {
                        res.
                          isIdent =
                          toValue.
                            isIdent;
                        res.
                          ident =
                          toValue.
                            ident;
                        res.
                          unit =
                          toValue.
                            unit;
                        res.
                          value =
                          toValue.
                            value;
                        res.
                          hasChanged =
                          true;
                    }
                }
                else {
                    if (res.
                          isIdent !=
                          isIdent ||
                          res.
                            unit !=
                          unit ||
                          res.
                            value !=
                          value ||
                          res.
                            isIdent &&
                          isIdent &&
                          !res.
                             ident.
                          equals(
                            ident)) {
                        res.
                          isIdent =
                          isIdent;
                        res.
                          ident =
                          ident;
                        res.
                          unit =
                          unit;
                        res.
                          value =
                          value;
                        res.
                          hasChanged =
                          true;
                    }
                }
            }
            else {
                super.
                  interpolate(
                    res,
                    to,
                    interpolation,
                    accumulation,
                    multiplier);
            }
        }
        return res;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "3rL/AB4jA1aHIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "TP7zb/6ZZ/7zC18pv3/9P4o6w/YGLAAA");
}
