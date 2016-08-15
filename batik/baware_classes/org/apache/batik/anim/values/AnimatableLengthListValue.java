package org.apache.batik.anim.values;
public class AnimatableLengthListValue extends org.apache.batik.anim.values.AnimatableValue {
    protected short[] lengthTypes;
    protected float[] lengthValues;
    protected short percentageInterpretation;
    protected AnimatableLengthListValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableLengthListValue(org.apache.batik.dom.anim.AnimationTarget target,
                                     short[] types,
                                     float[] values,
                                     short pcInterp) { super(
                                                         target);
                                                       this.
                                                         lengthTypes =
                                                         types;
                                                       this.
                                                         lengthValues =
                                                         values;
                                                       this.
                                                         percentageInterpretation =
                                                         pcInterp;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableLengthListValue toLengthList =
          (org.apache.batik.anim.values.AnimatableLengthListValue)
            to;
        org.apache.batik.anim.values.AnimatableLengthListValue accLengthList =
          (org.apache.batik.anim.values.AnimatableLengthListValue)
            accumulation;
        boolean hasTo =
          to !=
          null;
        boolean hasAcc =
          accumulation !=
          null;
        boolean canInterpolate =
          !(hasTo &&
              toLengthList.
                lengthTypes.
                length !=
              lengthTypes.
                length) &&
          !(hasAcc &&
              accLengthList.
                lengthTypes.
                length !=
              lengthTypes.
                length);
        short[] baseLengthTypes;
        float[] baseLengthValues;
        if (!canInterpolate &&
              hasTo &&
              interpolation >=
              0.5) {
            baseLengthTypes =
              toLengthList.
                lengthTypes;
            baseLengthValues =
              toLengthList.
                lengthValues;
        }
        else {
            baseLengthTypes =
              lengthTypes;
            baseLengthValues =
              lengthValues;
        }
        int len =
          baseLengthTypes.
            length;
        org.apache.batik.anim.values.AnimatableLengthListValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableLengthListValue(
                target);
            res.
              lengthTypes =
              (new short[len]);
            res.
              lengthValues =
              (new float[len]);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableLengthListValue)
                result;
            if (res.
                  lengthTypes ==
                  null ||
                  res.
                    lengthTypes.
                    length !=
                  len) {
                res.
                  lengthTypes =
                  (new short[len]);
                res.
                  lengthValues =
                  (new float[len]);
            }
        }
        res.
          hasChanged =
          percentageInterpretation !=
            res.
              percentageInterpretation;
        res.
          percentageInterpretation =
          percentageInterpretation;
        for (int i =
               0;
             i <
               len;
             i++) {
            float toV =
              0;
            float accV =
              0;
            short newLengthType =
              baseLengthTypes[i];
            float newLengthValue =
              baseLengthValues[i];
            if (canInterpolate) {
                if (hasTo &&
                      !org.apache.batik.anim.values.AnimatableLengthValue.
                      compatibleTypes(
                        newLengthType,
                        percentageInterpretation,
                        toLengthList.
                          lengthTypes[i],
                        toLengthList.
                          percentageInterpretation) ||
                      hasAcc &&
                      !org.apache.batik.anim.values.AnimatableLengthValue.
                      compatibleTypes(
                        newLengthType,
                        percentageInterpretation,
                        accLengthList.
                          lengthTypes[i],
                        accLengthList.
                          percentageInterpretation)) {
                    newLengthValue =
                      target.
                        svgToUserSpace(
                          newLengthValue,
                          newLengthType,
                          percentageInterpretation);
                    newLengthType =
                      org.w3c.dom.svg.SVGLength.
                        SVG_LENGTHTYPE_NUMBER;
                    if (hasTo) {
                        toV =
                          to.
                            target.
                            svgToUserSpace(
                              toLengthList.
                                lengthValues[i],
                              toLengthList.
                                lengthTypes[i],
                              toLengthList.
                                percentageInterpretation);
                    }
                    if (hasAcc) {
                        accV =
                          accumulation.
                            target.
                            svgToUserSpace(
                              accLengthList.
                                lengthValues[i],
                              accLengthList.
                                lengthTypes[i],
                              accLengthList.
                                percentageInterpretation);
                    }
                }
                else {
                    if (hasTo) {
                        toV =
                          toLengthList.
                            lengthValues[i];
                    }
                    if (hasAcc) {
                        accV =
                          accLengthList.
                            lengthValues[i];
                    }
                }
                newLengthValue +=
                  interpolation *
                    (toV -
                       newLengthValue) +
                    multiplier *
                    accV;
            }
            if (!res.
                   hasChanged) {
                res.
                  hasChanged =
                  newLengthType !=
                    res.
                      lengthTypes[i] ||
                    newLengthValue !=
                    res.
                      lengthValues[i];
            }
            res.
              lengthTypes[i] =
              newLengthType;
            res.
              lengthValues[i] =
              newLengthValue;
        }
        return res;
    }
    public short[] getLengthTypes() { return lengthTypes;
    }
    public float[] getLengthValues() { return lengthValues;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        float[] vs =
          new float[lengthValues.
                      length];
        return new org.apache.batik.anim.values.AnimatableLengthListValue(
          target,
          lengthTypes,
          vs,
          percentageInterpretation);
    }
    public java.lang.String getCssText() {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        if (lengthValues.
              length >
              0) {
            sb.
              append(
                formatNumber(
                  lengthValues[0]));
            sb.
              append(
                org.apache.batik.anim.values.AnimatableLengthValue.
                  UNITS[lengthTypes[0] -
                          1]);
        }
        for (int i =
               1;
             i <
               lengthValues.
                 length;
             i++) {
            sb.
              append(
                ',');
            sb.
              append(
                formatNumber(
                  lengthValues[i]));
            sb.
              append(
                org.apache.batik.anim.values.AnimatableLengthValue.
                  UNITS[lengthTypes[i] -
                          1]);
        }
        return sb.
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
       "syI9rH00n+QbZxx6/8us+E2A3Jt/3Yay");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("UsAO0ZGOvvZWzsFPyemhrPFJ+Pzivpx+8Z2R03EWfv+Mvn+fFd8CyP2mDvhT" +
       "5+ZHHP6rt8thdrj/1X0Ov/rOc/ifz+j7o6z4DkCuHnJ47AD+iMU/fLssZh/L" +
       "fm2fxV9751l8/Yy+/5YVfwKQS6ri9w/uX5w6Mr40DwJXV/wjjr/3NjjOI03m" +
       "47+xz/FvvDMc7x0BfDMD2EPuzPZe/jXtDYDco9m776zD/ItnesTin70NFvMI" +
       "ln3w/Po+i19/x5W6d+WMvuwb/d4lgFyBdjvT4+AohB3yt3f5bfD3YNb4CHx+" +
       "b5+/33vn+Xv4jL7rWfEQ1B7krwlXHH2dXx740hF373pL3xcB8kN3vHKaXZ57" +
       "+JaL77vL2uqXX7l6+b2vjP7N7nrTwYXqu3nksrF03eOXKI7VL4axbti5AO7e" +
       "XakIc66eBMgjZ61JALm4q2QM7D2xG3QDIO++7SCAnM9+jsM+A5Brp2EBciH/" +
       "PQ73HJTsERycdlc5DvJBgNwFQbLqzXDncnsns4NDR3rwB6niWELx9InrGfl/" +
       "JRxcpVju/i/hRfUrr7Ddj79e/bndjVHVVbbbDMtlHrm0u7yaI82uYzx5R2wH" +
       "uC52nn3j/l+++30HKcr9O4KPrPcYbY/f/m4m5YUgv025/dX3/qMX/sErf5B/" +
       "z/u/WTWaPi4yAAA=");
}
