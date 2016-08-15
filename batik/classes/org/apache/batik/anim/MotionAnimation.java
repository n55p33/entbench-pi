package org.apache.batik.anim;
public class MotionAnimation extends org.apache.batik.anim.InterpolatingAnimation {
    protected org.apache.batik.ext.awt.geom.ExtendedGeneralPath path;
    protected org.apache.batik.ext.awt.geom.PathLength pathLength;
    protected float[] keyPoints;
    protected boolean rotateAuto;
    protected boolean rotateAutoReverse;
    protected float rotateAngle;
    public MotionAnimation(org.apache.batik.anim.timing.TimedElement timedElement,
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
                           org.apache.batik.ext.awt.geom.ExtendedGeneralPath path,
                           float[] keyPoints,
                           boolean rotateAuto,
                           boolean rotateAutoReverse,
                           float rotateAngle,
                           short rotateAngleUnit) {
        super(
          timedElement,
          animatableElement,
          calcMode,
          keyTimes,
          keySplines,
          additive,
          cumulative);
        this.
          rotateAuto =
          rotateAuto;
        this.
          rotateAutoReverse =
          rotateAutoReverse;
        this.
          rotateAngle =
          org.apache.batik.anim.values.AnimatableAngleValue.
            rad(
              rotateAngle,
              rotateAngleUnit);
        if (path ==
              null) {
            path =
              new org.apache.batik.ext.awt.geom.ExtendedGeneralPath(
                );
            if (values ==
                  null ||
                  values.
                    length ==
                  0) {
                if (from !=
                      null) {
                    org.apache.batik.anim.values.AnimatableMotionPointValue fromPt =
                      (org.apache.batik.anim.values.AnimatableMotionPointValue)
                        from;
                    float x =
                      fromPt.
                      getX(
                        );
                    float y =
                      fromPt.
                      getY(
                        );
                    path.
                      moveTo(
                        x,
                        y);
                    if (to !=
                          null) {
                        org.apache.batik.anim.values.AnimatableMotionPointValue toPt =
                          (org.apache.batik.anim.values.AnimatableMotionPointValue)
                            to;
                        path.
                          lineTo(
                            toPt.
                              getX(
                                ),
                            toPt.
                              getY(
                                ));
                    }
                    else
                        if (by !=
                              null) {
                            org.apache.batik.anim.values.AnimatableMotionPointValue byPt =
                              (org.apache.batik.anim.values.AnimatableMotionPointValue)
                                by;
                            path.
                              lineTo(
                                x +
                                  byPt.
                                  getX(
                                    ),
                                y +
                                  byPt.
                                  getY(
                                    ));
                        }
                        else {
                            throw timedElement.
                              createException(
                                "values.to.by.path.missing",
                                new java.lang.Object[] { null });
                        }
                }
                else {
                    if (to !=
                          null) {
                        org.apache.batik.anim.values.AnimatableMotionPointValue unPt =
                          (org.apache.batik.anim.values.AnimatableMotionPointValue)
                            animatableElement.
                            getUnderlyingValue(
                              );
                        org.apache.batik.anim.values.AnimatableMotionPointValue toPt =
                          (org.apache.batik.anim.values.AnimatableMotionPointValue)
                            to;
                        path.
                          moveTo(
                            unPt.
                              getX(
                                ),
                            unPt.
                              getY(
                                ));
                        path.
                          lineTo(
                            toPt.
                              getX(
                                ),
                            toPt.
                              getY(
                                ));
                        this.
                          cumulative =
                          false;
                    }
                    else
                        if (by !=
                              null) {
                            org.apache.batik.anim.values.AnimatableMotionPointValue byPt =
                              (org.apache.batik.anim.values.AnimatableMotionPointValue)
                                by;
                            path.
                              moveTo(
                                0,
                                0);
                            path.
                              lineTo(
                                byPt.
                                  getX(
                                    ),
                                byPt.
                                  getY(
                                    ));
                            this.
                              additive =
                              true;
                        }
                        else {
                            throw timedElement.
                              createException(
                                "values.to.by.path.missing",
                                new java.lang.Object[] { null });
                        }
                }
            }
            else {
                org.apache.batik.anim.values.AnimatableMotionPointValue pt =
                  (org.apache.batik.anim.values.AnimatableMotionPointValue)
                    values[0];
                path.
                  moveTo(
                    pt.
                      getX(
                        ),
                    pt.
                      getY(
                        ));
                for (int i =
                       1;
                     i <
                       values.
                         length;
                     i++) {
                    pt =
                      (org.apache.batik.anim.values.AnimatableMotionPointValue)
                        values[i];
                    path.
                      lineTo(
                        pt.
                          getX(
                            ),
                        pt.
                          getY(
                            ));
                }
            }
        }
        this.
          path =
          path;
        pathLength =
          new org.apache.batik.ext.awt.geom.PathLength(
            path);
        int segments =
          0;
        org.apache.batik.ext.awt.geom.ExtendedPathIterator epi =
          path.
          getExtendedPathIterator(
            );
        while (!epi.
                 isDone(
                   )) {
            int type =
              epi.
              currentSegment(
                );
            if (type !=
                  org.apache.batik.ext.awt.geom.ExtendedPathIterator.
                    SEG_MOVETO) {
                segments++;
            }
            epi.
              next(
                );
        }
        int count =
          keyPoints ==
          null
          ? segments +
          1
          : keyPoints.
              length;
        float totalLength =
          pathLength.
          lengthOfPath(
            );
        if (this.
              keyTimes !=
              null &&
              calcMode !=
              CALC_MODE_PACED) {
            if (this.
                  keyTimes.
                  length !=
                  count) {
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
                  CALC_MODE_SPLINE) {
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
                    epi =
                      path.
                        getExtendedPathIterator(
                          );
                    this.
                      keyTimes =
                      (new float[count]);
                    int j =
                      0;
                    for (int i =
                           0;
                         i <
                           count -
                           1;
                         i++) {
                        while (epi.
                                 currentSegment(
                                   ) ==
                                 org.apache.batik.ext.awt.geom.ExtendedPathIterator.
                                   SEG_MOVETO) {
                            j++;
                            epi.
                              next(
                                );
                        }
                        this.
                          keyTimes[i] =
                          pathLength.
                            getLengthAtSegment(
                              j) /
                            totalLength;
                        j++;
                        epi.
                          next(
                            );
                    }
                    this.
                      keyTimes[count -
                                 1] =
                      1.0F;
                }
        }
        if (keyPoints !=
              null) {
            if (keyPoints.
                  length !=
                  this.
                    keyTimes.
                    length) {
                throw timedElement.
                  createException(
                    "attribute.malformed",
                    new java.lang.Object[] { null,
                    org.apache.batik.util.SMILConstants.
                      SMIL_KEY_POINTS_ATTRIBUTE });
            }
        }
        else {
            epi =
              path.
                getExtendedPathIterator(
                  );
            keyPoints =
              (new float[count]);
            int j =
              0;
            for (int i =
                   0;
                 i <
                   count -
                   1;
                 i++) {
                while (epi.
                         currentSegment(
                           ) ==
                         org.apache.batik.ext.awt.geom.ExtendedPathIterator.
                           SEG_MOVETO) {
                    j++;
                    epi.
                      next(
                        );
                }
                keyPoints[i] =
                  pathLength.
                    getLengthAtSegment(
                      j) /
                    totalLength;
                j++;
                epi.
                  next(
                    );
            }
            keyPoints[count -
                        1] =
              1.0F;
        }
        this.
          keyPoints =
          keyPoints;
    }
    protected void sampledAtUnitTime(float unitTime,
                                     int repeatIteration) {
        org.apache.batik.anim.values.AnimatableValue value;
        org.apache.batik.anim.values.AnimatableValue accumulation;
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
            if (keyTimeIndex ==
                  keyTimes.
                    length -
                  1 &&
                  calcMode ==
                  CALC_MODE_DISCRETE) {
                keyTimeIndex =
                  keyTimes.
                    length -
                    2;
                interpolation =
                  1;
            }
            else {
                if (calcMode ==
                      CALC_MODE_LINEAR ||
                      calcMode ==
                      CALC_MODE_PACED ||
                      calcMode ==
                      CALC_MODE_SPLINE) {
                    if (unitTime ==
                          0) {
                        interpolation =
                          0;
                    }
                    else {
                        interpolation =
                          (unitTime -
                             keyTimes[keyTimeIndex]) /
                            (keyTimes[keyTimeIndex +
                                        1] -
                               keyTimes[keyTimeIndex]);
                    }
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
            }
            float point =
              keyPoints[keyTimeIndex];
            if (interpolation !=
                  0) {
                point +=
                  interpolation *
                    (keyPoints[keyTimeIndex +
                                 1] -
                       keyPoints[keyTimeIndex]);
            }
            point *=
              pathLength.
                lengthOfPath(
                  );
            java.awt.geom.Point2D p =
              pathLength.
              pointAtLength(
                point);
            float ang;
            if (rotateAuto) {
                ang =
                  pathLength.
                    angleAtLength(
                      point);
                if (rotateAutoReverse) {
                    ang +=
                      java.lang.Math.
                        PI;
                }
            }
            else {
                ang =
                  rotateAngle;
            }
            value =
              new org.apache.batik.anim.values.AnimatableMotionPointValue(
                null,
                (float)
                  p.
                  getX(
                    ),
                (float)
                  p.
                  getY(
                    ),
                ang);
        }
        else {
            java.awt.geom.Point2D p =
              pathLength.
              pointAtLength(
                pathLength.
                  lengthOfPath(
                    ));
            float ang;
            if (rotateAuto) {
                ang =
                  pathLength.
                    angleAtLength(
                      pathLength.
                        lengthOfPath(
                          ));
                if (rotateAutoReverse) {
                    ang +=
                      java.lang.Math.
                        PI;
                }
            }
            else {
                ang =
                  rotateAngle;
            }
            value =
              new org.apache.batik.anim.values.AnimatableMotionPointValue(
                null,
                (float)
                  p.
                  getX(
                    ),
                (float)
                  p.
                  getY(
                    ),
                ang);
        }
        if (cumulative) {
            java.awt.geom.Point2D p =
              pathLength.
              pointAtLength(
                pathLength.
                  lengthOfPath(
                    ));
            float ang;
            if (rotateAuto) {
                ang =
                  pathLength.
                    angleAtLength(
                      pathLength.
                        lengthOfPath(
                          ));
                if (rotateAutoReverse) {
                    ang +=
                      java.lang.Math.
                        PI;
                }
            }
            else {
                ang =
                  rotateAngle;
            }
            accumulation =
              new org.apache.batik.anim.values.AnimatableMotionPointValue(
                null,
                (float)
                  p.
                  getX(
                    ),
                (float)
                  p.
                  getY(
                    ),
                ang);
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
              null,
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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "6ZMmUyEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "pNC1M7gUurK/OQ/yX1PoPgBS3P636C32");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("7ujiiAIQBngTWKciyi9dtMhT2T/+VrI/Z8TPXdhcKg/CnmzJZvujsC9rX3tt" +
       "MP7+bzd/an+uSfOU3a7o5SEGenB/xOp0W/fZu/Z20tcV6oXvPPpzV58/cYtH" +
       "9wSf2fQ52p6+8yGinh+l5bGf3S+/7xe+52de+6NynfX/AQxzZYehLAAA");
}
