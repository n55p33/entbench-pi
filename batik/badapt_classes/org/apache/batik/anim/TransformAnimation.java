package org.apache.batik.anim;
public class TransformAnimation extends org.apache.batik.anim.SimpleAnimation {
    protected short type;
    protected float[] keyTimes2;
    protected float[] keyTimes3;
    public TransformAnimation(org.apache.batik.anim.timing.TimedElement timedElement,
                              org.apache.batik.dom.anim.AnimatableElement animatableElement,
                              int calcMode,
                              float[] keyTimes,
                              float[] keySplines,
                              boolean additive,
                              boolean cumulative,
                              org.apache.batik.anim.values.AnimatableValue[] values,
                              org.apache.batik.anim.values.AnimatableValue from,
                              org.apache.batik.anim.values.AnimatableValue to,
                              org.apache.batik.anim.values.AnimatableValue by,
                              short type) { super(
                                              timedElement,
                                              animatableElement,
                                              calcMode ==
                                                CALC_MODE_PACED
                                                ? CALC_MODE_LINEAR
                                                : calcMode,
                                              calcMode ==
                                                CALC_MODE_PACED
                                                ? null
                                                : keyTimes,
                                              keySplines,
                                              additive,
                                              cumulative,
                                              values,
                                              from,
                                              to,
                                              by);
                                            this.
                                              calcMode =
                                              calcMode;
                                            this.
                                              type =
                                              type;
                                            if (calcMode !=
                                                  CALC_MODE_PACED) {
                                                return;
                                            }
                                            int count =
                                              this.
                                                values.
                                                length;
                                            float[] cumulativeDistances1;
                                            float[] cumulativeDistances2 =
                                              null;
                                            float[] cumulativeDistances3 =
                                              null;
                                            switch (type) {
                                                case org.w3c.dom.svg.SVGTransform.
                                                       SVG_TRANSFORM_ROTATE:
                                                    cumulativeDistances3 =
                                                      (new float[count]);
                                                    cumulativeDistances3[0] =
                                                      0.0F;
                                                case org.w3c.dom.svg.SVGTransform.
                                                       SVG_TRANSFORM_SCALE:
                                                case org.w3c.dom.svg.SVGTransform.
                                                       SVG_TRANSFORM_TRANSLATE:
                                                    cumulativeDistances2 =
                                                      (new float[count]);
                                                    cumulativeDistances2[0] =
                                                      0.0F;
                                                default:
                                                    cumulativeDistances1 =
                                                      (new float[count]);
                                                    cumulativeDistances1[0] =
                                                      0.0F;
                                            }
                                            for (int i =
                                                   1;
                                                 i <
                                                   this.
                                                     values.
                                                     length;
                                                 i++) {
                                                switch (type) {
                                                    case org.w3c.dom.svg.SVGTransform.
                                                           SVG_TRANSFORM_ROTATE:
                                                        cumulativeDistances3[i] =
                                                          cumulativeDistances3[i -
                                                                                 1] +
                                                            ((org.apache.batik.anim.values.AnimatableTransformListValue)
                                                               this.
                                                                 values[i -
                                                                          1]).
                                                            distanceTo3(
                                                              this.
                                                                values[i]);
                                                    case org.w3c.dom.svg.SVGTransform.
                                                           SVG_TRANSFORM_SCALE:
                                                    case org.w3c.dom.svg.SVGTransform.
                                                           SVG_TRANSFORM_TRANSLATE:
                                                        cumulativeDistances2[i] =
                                                          cumulativeDistances2[i -
                                                                                 1] +
                                                            ((org.apache.batik.anim.values.AnimatableTransformListValue)
                                                               this.
                                                                 values[i -
                                                                          1]).
                                                            distanceTo2(
                                                              this.
                                                                values[i]);
                                                    default:
                                                        cumulativeDistances1[i] =
                                                          cumulativeDistances1[i -
                                                                                 1] +
                                                            ((org.apache.batik.anim.values.AnimatableTransformListValue)
                                                               this.
                                                                 values[i -
                                                                          1]).
                                                            distanceTo1(
                                                              this.
                                                                values[i]);
                                                }
                                            }
                                            switch (type) {
                                                case org.w3c.dom.svg.SVGTransform.
                                                       SVG_TRANSFORM_ROTATE:
                                                    float totalLength =
                                                      cumulativeDistances3[count -
                                                                             1];
                                                    keyTimes3 =
                                                      (new float[count]);
                                                    keyTimes3[0] =
                                                      0.0F;
                                                    for (int i =
                                                           1;
                                                         i <
                                                           count -
                                                           1;
                                                         i++) {
                                                        keyTimes3[i] =
                                                          cumulativeDistances3[i] /
                                                            totalLength;
                                                    }
                                                    keyTimes3[count -
                                                                1] =
                                                      1.0F;
                                                case org.w3c.dom.svg.SVGTransform.
                                                       SVG_TRANSFORM_SCALE:
                                                case org.w3c.dom.svg.SVGTransform.
                                                       SVG_TRANSFORM_TRANSLATE:
                                                    totalLength =
                                                      cumulativeDistances2[count -
                                                                             1];
                                                    keyTimes2 =
                                                      (new float[count]);
                                                    keyTimes2[0] =
                                                      0.0F;
                                                    for (int i =
                                                           1;
                                                         i <
                                                           count -
                                                           1;
                                                         i++) {
                                                        keyTimes2[i] =
                                                          cumulativeDistances2[i] /
                                                            totalLength;
                                                    }
                                                    keyTimes2[count -
                                                                1] =
                                                      1.0F;
                                                default:
                                                    totalLength =
                                                      cumulativeDistances1[count -
                                                                             1];
                                                    this.
                                                      keyTimes =
                                                      (new float[count]);
                                                    this.
                                                      keyTimes[0] =
                                                      0.0F;
                                                    for (int i =
                                                           1;
                                                         i <
                                                           count -
                                                           1;
                                                         i++) {
                                                        this.
                                                          keyTimes[i] =
                                                          cumulativeDistances1[i] /
                                                            totalLength;
                                                    }
                                                    this.
                                                      keyTimes[count -
                                                                 1] =
                                                      1.0F;
                                            }
    }
    protected void sampledAtUnitTime(float unitTime,
                                     int repeatIteration) {
        if (calcMode !=
              CALC_MODE_PACED ||
              type ==
              org.w3c.dom.svg.SVGTransform.
                SVG_TRANSFORM_SKEWX ||
              type ==
              org.w3c.dom.svg.SVGTransform.
                SVG_TRANSFORM_SKEWY) {
            super.
              sampledAtUnitTime(
                unitTime,
                repeatIteration);
            return;
        }
        org.apache.batik.anim.values.AnimatableTransformListValue value1;
        org.apache.batik.anim.values.AnimatableTransformListValue value2;
        org.apache.batik.anim.values.AnimatableTransformListValue value3 =
          null;
        org.apache.batik.anim.values.AnimatableTransformListValue nextValue1;
        org.apache.batik.anim.values.AnimatableTransformListValue nextValue2;
        org.apache.batik.anim.values.AnimatableTransformListValue nextValue3 =
          null;
        org.apache.batik.anim.values.AnimatableTransformListValue accumulation;
        float interpolation1 =
          0.0F;
        float interpolation2 =
          0.0F;
        float interpolation3 =
          0.0F;
        if (unitTime !=
              1) {
            switch (type) {
                case org.w3c.dom.svg.SVGTransform.
                       SVG_TRANSFORM_ROTATE:
                    int keyTimeIndex =
                      0;
                    while (keyTimeIndex <
                             keyTimes3.
                               length -
                             1 &&
                             unitTime >=
                             keyTimes3[keyTimeIndex +
                                         1]) {
                        keyTimeIndex++;
                    }
                    value3 =
                      (org.apache.batik.anim.values.AnimatableTransformListValue)
                        this.
                          values[keyTimeIndex];
                    nextValue3 =
                      (org.apache.batik.anim.values.AnimatableTransformListValue)
                        this.
                          values[keyTimeIndex +
                                   1];
                    interpolation3 =
                      (unitTime -
                         keyTimes3[keyTimeIndex]) /
                        (keyTimes3[keyTimeIndex +
                                     1] -
                           keyTimes3[keyTimeIndex]);
                default:
                    keyTimeIndex =
                      0;
                    while (keyTimeIndex <
                             keyTimes2.
                               length -
                             1 &&
                             unitTime >=
                             keyTimes2[keyTimeIndex +
                                         1]) {
                        keyTimeIndex++;
                    }
                    value2 =
                      (org.apache.batik.anim.values.AnimatableTransformListValue)
                        this.
                          values[keyTimeIndex];
                    nextValue2 =
                      (org.apache.batik.anim.values.AnimatableTransformListValue)
                        this.
                          values[keyTimeIndex +
                                   1];
                    interpolation2 =
                      (unitTime -
                         keyTimes2[keyTimeIndex]) /
                        (keyTimes2[keyTimeIndex +
                                     1] -
                           keyTimes2[keyTimeIndex]);
                    keyTimeIndex =
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
                    value1 =
                      (org.apache.batik.anim.values.AnimatableTransformListValue)
                        this.
                          values[keyTimeIndex];
                    nextValue1 =
                      (org.apache.batik.anim.values.AnimatableTransformListValue)
                        this.
                          values[keyTimeIndex +
                                   1];
                    interpolation1 =
                      (unitTime -
                         keyTimes[keyTimeIndex]) /
                        (keyTimes[keyTimeIndex +
                                    1] -
                           keyTimes[keyTimeIndex]);
            }
        }
        else {
            value1 =
              (value2 =
                 (value3 =
                    (org.apache.batik.anim.values.AnimatableTransformListValue)
                      this.
                        values[this.
                                 values.
                                 length -
                                 1]));
            nextValue1 =
              (nextValue2 =
                 (nextValue3 =
                    null));
            interpolation1 =
              (interpolation2 =
                 (interpolation3 =
                    1.0F));
        }
        if (cumulative) {
            accumulation =
              (org.apache.batik.anim.values.AnimatableTransformListValue)
                this.
                  values[this.
                           values.
                           length -
                           1];
        }
        else {
            accumulation =
              null;
        }
        switch (type) {
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_ROTATE:
                this.
                  value =
                  org.apache.batik.anim.values.AnimatableTransformListValue.
                    interpolate(
                      (org.apache.batik.anim.values.AnimatableTransformListValue)
                        this.
                          value,
                      value1,
                      value2,
                      value3,
                      nextValue1,
                      nextValue2,
                      nextValue3,
                      interpolation1,
                      interpolation2,
                      interpolation3,
                      accumulation,
                      repeatIteration);
                break;
            default:
                this.
                  value =
                  org.apache.batik.anim.values.AnimatableTransformListValue.
                    interpolate(
                      (org.apache.batik.anim.values.AnimatableTransformListValue)
                        this.
                          value,
                      value1,
                      value2,
                      nextValue1,
                      nextValue2,
                      interpolation1,
                      interpolation2,
                      accumulation,
                      repeatIteration);
                break;
        }
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
       "HgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
