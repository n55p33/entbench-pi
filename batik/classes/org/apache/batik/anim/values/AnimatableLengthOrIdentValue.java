package org.apache.batik.anim.values;
public class AnimatableLengthOrIdentValue extends org.apache.batik.anim.values.AnimatableLengthValue {
    protected boolean isIdent;
    protected java.lang.String ident;
    protected AnimatableLengthOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableLengthOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target,
                                        short type,
                                        float v,
                                        short pcInterp) {
        super(
          target,
          type,
          v,
          pcInterp);
    }
    public AnimatableLengthOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target,
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
        return new org.apache.batik.anim.values.AnimatableLengthOrIdentValue(
          target,
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_NUMBER,
          0.0F,
          percentageInterpretation);
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
        org.apache.batik.anim.values.AnimatableLengthOrIdentValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableLengthOrIdentValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableLengthOrIdentValue)
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
                short oldLengthType =
                  res.
                    lengthType;
                float oldLengthValue =
                  res.
                    lengthValue;
                short oldPercentageInterpretation =
                  res.
                    percentageInterpretation;
                super.
                  interpolate(
                    res,
                    to,
                    interpolation,
                    accumulation,
                    multiplier);
                if (res.
                      lengthType !=
                      oldLengthType ||
                      res.
                        lengthValue !=
                      oldLengthValue ||
                      res.
                        percentageInterpretation !=
                      oldPercentageInterpretation) {
                    res.
                      hasChanged =
                      true;
                }
            }
        }
        else {
            org.apache.batik.anim.values.AnimatableLengthOrIdentValue toValue =
              (org.apache.batik.anim.values.AnimatableLengthOrIdentValue)
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
                            lengthType !=
                          toValue.
                            lengthType ||
                          res.
                            lengthValue !=
                          toValue.
                            lengthValue ||
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
                          lengthType =
                          toValue.
                            lengthType;
                        res.
                          lengthValue =
                          toValue.
                            lengthValue;
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
                            lengthType !=
                          lengthType ||
                          res.
                            lengthValue !=
                          lengthValue ||
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
                          ident =
                          ident;
                        res.
                          lengthType =
                          lengthType;
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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "uthb8h8NUFJ9kSEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
