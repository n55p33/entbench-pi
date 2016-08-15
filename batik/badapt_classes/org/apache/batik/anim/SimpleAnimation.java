package org.apache.batik.anim;
public class SimpleAnimation extends org.apache.batik.anim.InterpolatingAnimation {
    protected org.apache.batik.anim.values.AnimatableValue[] values;
    protected org.apache.batik.anim.values.AnimatableValue from;
    protected org.apache.batik.anim.values.AnimatableValue to;
    protected org.apache.batik.anim.values.AnimatableValue by;
    public SimpleAnimation(org.apache.batik.anim.timing.TimedElement timedElement,
                           org.apache.batik.dom.anim.AnimatableElement animatableElement,
                           int calcMode,
                           float[] keyTimes,
                           float[] keySplines,
                           boolean additive,
                           boolean cumulative,
                           org.apache.batik.anim.values.AnimatableValue[] values,
                           org.apache.batik.anim.values.AnimatableValue from,
                           org.apache.batik.anim.values.AnimatableValue to,
                           org.apache.batik.anim.values.AnimatableValue by) {
        super(
          timedElement,
          animatableElement,
          calcMode,
          keyTimes,
          keySplines,
          additive,
          cumulative);
        this.
          from =
          from;
        this.
          to =
          to;
        this.
          by =
          by;
        if (values ==
              null) {
            if (from !=
                  null) {
                values =
                  (new org.apache.batik.anim.values.AnimatableValue[2]);
                values[0] =
                  from;
                if (to !=
                      null) {
                    values[1] =
                      to;
                }
                else
                    if (by !=
                          null) {
                        values[1] =
                          from.
                            interpolate(
                              null,
                              null,
                              0.0F,
                              by,
                              1);
                    }
                    else {
                        throw timedElement.
                          createException(
                            "values.to.by.missing",
                            new java.lang.Object[] { null });
                    }
            }
            else {
                if (to !=
                      null) {
                    values =
                      (new org.apache.batik.anim.values.AnimatableValue[2]);
                    values[0] =
                      animatableElement.
                        getUnderlyingValue(
                          );
                    values[1] =
                      to;
                    this.
                      cumulative =
                      false;
                    toAnimation =
                      true;
                }
                else
                    if (by !=
                          null) {
                        this.
                          additive =
                          true;
                        values =
                          (new org.apache.batik.anim.values.AnimatableValue[2]);
                        values[0] =
                          by.
                            getZeroValue(
                              );
                        values[1] =
                          by;
                    }
                    else {
                        throw timedElement.
                          createException(
                            "values.to.by.missing",
                            new java.lang.Object[] { null });
                    }
            }
        }
        this.
          values =
          values;
        if (this.
              keyTimes !=
              null &&
              calcMode !=
              CALC_MODE_PACED) {
            if (this.
                  keyTimes.
                  length !=
                  values.
                    length) {
                throw timedElement.
                  createException(
                    "attribute.malformed",
                    new java.lang.Object[] { null,
                    org.apache.batik.util.SMILConstants.
                      SMIL_KEY_TIMES_ATTRIBUTE });
            }
        }
        else {
            if (calcMode ==
                  CALC_MODE_LINEAR ||
                  calcMode ==
                  CALC_MODE_SPLINE ||
                  calcMode ==
                  CALC_MODE_PACED &&
                  !values[0].
                  canPace(
                    )) {
                int count =
                  values.
                    length ==
                  1
                  ? 2
                  : values.
                      length;
                this.
                  keyTimes =
                  (new float[count]);
                for (int i =
                       0;
                     i <
                       count;
                     i++) {
                    this.
                      keyTimes[i] =
                      (float)
                        i /
                        (count -
                           1);
                }
            }
            else
                if (calcMode ==
                      CALC_MODE_DISCRETE) {
                    int count =
                      values.
                        length;
                    this.
                      keyTimes =
                      (new float[count]);
                    for (int i =
                           0;
                         i <
                           count;
                         i++) {
                        this.
                          keyTimes[i] =
                          (float)
                            i /
                            count;
                    }
                }
                else {
                    int count =
                      values.
                        length;
                    float[] cumulativeDistances =
                      new float[count];
                    cumulativeDistances[0] =
                      0;
                    for (int i =
                           1;
                         i <
                           count;
                         i++) {
                        cumulativeDistances[i] =
                          cumulativeDistances[i -
                                                1] +
                            values[i -
                                     1].
                            distanceTo(
                              values[i]);
                    }
                    float totalLength =
                      cumulativeDistances[count -
                                            1];
                    this.
                      keyTimes =
                      (new float[count]);
                    this.
                      keyTimes[0] =
                      0;
                    for (int i =
                           1;
                         i <
                           count -
                           1;
                         i++) {
                        this.
                          keyTimes[i] =
                          cumulativeDistances[i] /
                            totalLength;
                    }
                    this.
                      keyTimes[count -
                                 1] =
                      1;
                }
        }
        if (calcMode ==
              CALC_MODE_SPLINE &&
              keySplines.
                length !=
              (this.
                 keyTimes.
                 length -
                 1) *
              4) {
            throw timedElement.
              createException(
                "attribute.malformed",
                new java.lang.Object[] { null,
                org.apache.batik.util.SMILConstants.
                  SMIL_KEY_SPLINES_ATTRIBUTE });
        }
    }
    protected void sampledAtUnitTime(float unitTime,
                                     int repeatIteration) {
        org.apache.batik.anim.values.AnimatableValue value;
        org.apache.batik.anim.values.AnimatableValue accumulation;
        org.apache.batik.anim.values.AnimatableValue nextValue;
        float interpolation =
          0;
        if (unitTime !=
              1) {
            int keyTimeIndex =
              0;
            while (keyTimeIndex <
                     keyTimes.
                       length -
                     1 &&
                     unitTime >=
                     keyTimes[keyTimeIndex +
                                1]) {
                keyTimeIndex++;
            }
            value =
              values[keyTimeIndex];
            if (calcMode ==
                  CALC_MODE_LINEAR ||
                  calcMode ==
                  CALC_MODE_PACED ||
                  calcMode ==
                  CALC_MODE_SPLINE) {
                nextValue =
                  values[keyTimeIndex +
                           1];
                interpolation =
                  (unitTime -
                     keyTimes[keyTimeIndex]) /
                    (keyTimes[keyTimeIndex +
                                1] -
                       keyTimes[keyTimeIndex]);
                if (calcMode ==
                      CALC_MODE_SPLINE &&
                      unitTime !=
                      0) {
                    org.apache.batik.ext.awt.geom.Cubic c =
                      keySplineCubics[keyTimeIndex];
                    float tolerance =
                      0.001F;
                    float min =
                      0;
                    float max =
                      1;
                    java.awt.geom.Point2D.Double p;
                    for (;
                         ;
                         ) {
                        float t =
                          (min +
                             max) /
                          2;
                        p =
                          c.
                            eval(
                              t);
                        double x =
                          p.
                          getX(
                            );
                        if (java.lang.Math.
                              abs(
                                x -
                                  interpolation) <
                              tolerance) {
                            break;
                        }
                        if (x <
                              interpolation) {
                            min =
                              t;
                        }
                        else {
                            max =
                              t;
                        }
                    }
                    interpolation =
                      (float)
                        p.
                        getY(
                          );
                }
            }
            else {
                nextValue =
                  null;
            }
        }
        else {
            value =
              values[values.
                       length -
                       1];
            nextValue =
              null;
        }
        if (cumulative) {
            accumulation =
              values[values.
                       length -
                       1];
        }
        else {
            accumulation =
              null;
        }
        this.
          value =
          value.
            interpolate(
              this.
                value,
              nextValue,
              interpolation,
              accumulation,
              repeatIteration);
        if (this.
              value.
              hasChanged(
                )) {
            markDirty(
              );
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "XTdZurZ+l7/i8N7/AG1VBI0sHwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fYgIrbLpHO7/QlJGLV872P+tMn6cpp772Ha/FOdZ9H7n/xLc5Sf+w/+sdH5H" +
       "0rmLuV/CV+HXf/5p6sPfqvDPon+J/WxxZ1IGpnCG2/yl7X8/es/D//wIuqpC" +
       "N/Tj8n+quWkZU1Wg7PhkTQCWCBfeXyxfD7Xa7dPs9q7L/nZu2st558zOwX0J" +
       "XdndIdWUDVFcgapIy1UYz1ftzbJ5byXuo/L2faUuHE9zK7wOiOOu6dmHsgsr" +
       "m48Examajg54J2HrECJLPkD163tmGaVO3h2qDce/dbryAC+Luyj8/fdWOFf5" +
       "x5nUf/0T/+Vp5cOrj/0AZcZzl7R4echf5F7/jcEP6z9zBD1wqoM7liUXkW5f" +
       "lPy1yATrKE+5IP9nDvKv5HcQftm8WIm4en7/qSSgShJQBfvR+7z7WNn8KNCW" +
       "Xor6oJn7gOsFdDb7Jee7uvR919SquuAQfj58MfC8BK7aceCpnWRtsrIlqjjR" +
       "8Afunuay0sjjc3mrsvo7FF8+D8tmdWKl7v2stGzEg4mWzfjUPO07zbN8lMtm" +
       "cqe9lc/zw7QVdtn82H3EGN/nXVo2YdloB0ruA5sf1OGcNVU3fB+UXdk8F58v" +
       "lS96yLmNiJf1z379O2+ZfueffPeOaHixMuS04PZZhHh3mX7fcXldMNTiFYBr" +
       "vcH/2A33je9VufAxTQdBPxYisCYpLtSRx9APXf39f/prb//Y7zwAHfWhayC4" +
       "G32tKsmhR0EtbMYrsJwpgh/5yMGo8kdAc6NiFbqD+YPW3lk9XT0Yyql5PnGS" +
       "C993bJ7vu1w5H1vTJ+5uTaBQfTSI/AQEXdM4DXnZqYnah8K7bPdl81cPxLxy" +
       "T8IvkVYuST94TNoH70HaT9+DtPL2p05oetCK/O2ptZyj6NM/IEXPg6t5TFHz" +
       "HhT9je+HoqPEvxs9P/OnoAc7pge7Bz2f/77oWe7uRs/PvSk9h2B4BZjCQ81b" +
       "2K16+fy37z7jA1XwARYSV1ts56JQAvzG1W+e1LRTM4qBt91cu9hJfLxxlh0P" +
       "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");
}
