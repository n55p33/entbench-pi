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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "6GJvyX8AP39/XpEhAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZfBsT5XpObqrtyt1e9vDRZabNohFutPXME3AHt2mzYFmzOvVqDFRc2c15+x4" +
       "nI3t9YDq7HhOV/QK1qpkVMCza5VMu3mKaElFmGSNjJIwlnEXDjZxtkEm0UiU" +
       "qbTbZR2lG84HKbGuI3W7M0a9VUr2+uJcT9Mk6bWb6TqEc9xU+RbQs8RKBmYn" +
       "yJcYUFfHYgzg73nOGdibGpbolUEtD3yi1h12hfmYQMbLeW3Q2QSpQ2/FMVMZ" +
       "5o6oxVZKNlXXl6c1coO0/Ya96HsZniYVeC1zlXq/P2itqWpWI+uuMlmYyUSf" +
       "TKLQ7E+9JucuWn0dzltdNsURkUf7rXmdCpdNRpjvknC1q8iblYnoA9JWVsPx" +
       "WhvH9RhZJbprdlLU0hc7ahZKFoJys3pYkwWTnlo7vtPta93dSsrmNVrEZ83W" +
       "uO8ZKNpsoNpIiCsja8jzaJjBnSSRVjgMT5qLOcNskMGSyc1+ixt7+RZm6yFq" +
       "9uqLcE7VRii9c3x1YNfHLWzQa3qVMdvYAtVPkYBy8Xpc5yzGl+WgjXiMpSGB" +
       "SFgh38V8zpuj7qyxqy5W6bZTU7uowppcs66pLF+hxMYKadQHXg2eb/CQ6GT+" +
       "2u+NiWYzYgerjSqPLHXkWhwHlk8WrctDWd8Mu/FsrfcVz5zqas5HQLhMshoY" +
       "PUnpepbfRidpsOxMImFdV6z6MprUt4M5STbYWX1er4zmU6RNoT2OYYWYdmxk" +
       "IeIWQVXXrVpzaE40Y10ZLSjUCbVOVQ1GDbBuTKcdbdLwiQEvkiq1VhNvXYGH" +
       "yrDWghszw6hnia3WemTU2GW9oZcZnWEX2XjBzKw6GJYQBuZWWkyohV1X32YC" +
       "FZszu8KNp6la1bditzG2dpHbna9EsToighG20jsLaU1oEYNbPVaAFW2iyHJe" +
       "b7YbmEY0ZKMlJ+YkmSYKYgwNXlcU1DMtudkba3qrVR0rlUo9sVp9CYkG/KAZ" +
       "8i1W5DtTkURs1cJsbNVM29560d4N5C3RHE3Tesfh+ZYtxaG7U/pJpbvZmBN/" +
       "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");
}
