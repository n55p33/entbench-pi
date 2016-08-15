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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "as5mUyEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6e+zr5nUY77V97Xvt+F47zWNe/IqvmzhKfhQl6rVbZ6ZI" +
       "UaRESZRIihLbxeH7Ib7Eh0Sxc5MG2BIsQBq0TpcCrbc/0nYrnKQYWqzY0MLD" +
       "sLVdiwItiq0d0Lobhi5dGjTZsG5YtnUfqd9T92G7WAXwEx/nfN95n/M9Xv8W" +
       "9EAcQZUwcHemGyRHepYcOW7jKNmFenw0YBqsHMW6hrtyHPPg3cvqB3/++p9/" +
       "94vWjcvQFQl6t+z7QSInduDHMz0O3I2uMdD1s7c9V/fiBLrBOPJGhtPEdmHG" +
       "jpNbDPTwOdQEusmckAADEmBAAlySAGNnUADpXbqfeniBIftJvIZ+CLrEQFdC" +
       "tSAvgZ692EkoR7J33A1bcgB6eKh4ngOmSuQsgp455X3P820Mf6kCv/r3P3Hj" +
       "n9wHXZeg67bPFeSogIgEDCJBj3i6p+hRjGmarknQY76ua5we2bJr5yXdEvR4" +
       "bJu+nKSRfiqk4mUa6lE55pnkHlEL3qJUTYLolD3D1l3t5OkBw5VNwOt7z3jd" +
       "c0gW7wGD12xAWGTIqn6Ccv/K9rUEevoQ45THm0MAAFAf9PTECk6Hut+XwQvo" +
       "8b3uXNk3YS6JbN8EoA8EKRglgZ64a6eFrENZXcmm/nICvf8Qjt1/AlBXS0EU" +
       "KAn0nkOwsiegpScOtHROP98af98XftCn/MslzZquugX9DwGkpw6QZrqhR7qv" +
       "6nvERz7C/Lj83l/+3GUIAsDvOQDew/zTv/2dlz761Bu/tof563eAmSiOriYv" +
       "q19RHv3tD+AvdO4ryHgoDGK7UP4FzkvzZ4+/3MpC4HnvPe2x+Hh08vGN2b9e" +
       "fvrn9G9ehq7R0BU1cFMP2NFjauCFtqtHfd3XIznRNRq6qvsaXn6noQfBPWP7" +
       "+v7txDBiPaGh+93y1ZWgfAYiMkAXhYgeBPe2bwQn96GcWOV9FkIQ9CC4oEfA" +
       "9WFo/yv/E2gBW4Gnw7Iq+7YfwGwUFPzHsO4nCpCtBSvA6ldwHKQRMEE4iExY" +
       "BnZg6ccfAJoHj4KCSwzcli5yVFhY+FfYd1bwdWN76RIQ+QcOHd4FvkIFrqZH" +
       "L6uvpt3ed7728m9cPnWAY4kk0PNguKP9cEflcEfFcEcHw0GXLpWjfE8x7F6p" +
       "QCUr4Nwg7D3yAve3Bp/83AfvA9YUbu8H8ixA4btHX/wsHNBl0FOBTUJvfHn7" +
       "w/NPVS9Dly+G0YJU8Opagc4Wwe80yN08dJ879Xv9s9/486//+CvBmSNdiMvH" +
       "/n07ZuGfHzwUahSougYi3ln3H3lG/sWXf/mVm5eh+4HTg0CXyMAwQQx56nCM" +
       "C3566yTmFbw8ABg2gsiT3eLTSaC6llhRsD17U2r70fL+MSDjhwvDfQJco2NL" +
       "Lv+Lr+8Oi/Z79tZRKO2AizKmvsiFP/V7v/Un9VLcJ+H3+rmExunJrXMuX3R2" +
       "vXTux85sgI90HcD9wZfZH/vStz77/aUBAIjn7jTgzaLFgasDFQIx/51fW//+" +
       "m3/4ld+9fGY0Cch5qeLaanbKZPEeunYPJsFo33tGDwgZLnCtwmpuCr4XaLZh" +
       "y4qrF1b6v68/j/zin37hxt4OXPDmxIw++tYdnL3/a13o07/xif/xVNnNJbVI" +
       "WWcyOwPbx8F3n/WMRZG8K+jIfvh3nvyJX5V/CkRUEMViO9fLwPRYKYPHSs7f" +
       "k0Av3NktE9sDmeqItz1dK4oQ/bheABiV2zC0wNtj7d244OMEJ4JeuEdxFIFR" +
       "EntznFDgVx5/c/WT3/jqPlkcZp8DYP1zr/69vzj6wquXz6Xo527Lkudx9mm6" +
       "NNZ37fX+F+B3CVz/t7gKfRcv9mH6cfw4VzxzmizCMAPsPHsvssohyP/89Vf+" +
       "+T965bN7Nh6/mKF6oAD76r/9P7959OU/+vU7BMn77FJmz99dZqV69yJ47Wee" +
       "+61PvfbcfwD9SNBDdgzKMiwy75Dtz+F8+/U3v/k773rya2UUuV+R43Lsa4dl" +
       "0u1V0IXiphTiI6fOUwQH6GlwfejYeT60F6L4/yMfAVMPottS3V9V1/uIgBZN" +
       "e3//N5IiagXy3v6PivhxmnruYdtkIc6z6P3+/zVxlc/8x/9Z6vy2pHMHcz/A" +
       "l+DXf/IJ/OPfLPHPon+B/VR2e1IGpnCGW/s5779f/uCVf3UZelCCbqjH5f9c" +
       "dtMipkpA2fHJnABMES58v1i+7mu1W6fZ7QOH/nZu2MO8c2bn4L6ALu1un2qK" +
       "BssuQWWkHZUYz5btzaL5UCnuy8Xthwtd2L7slnhtEMdd3Tf3ZVeraF4Ks1M1" +
       "Xd7jnYStfYgs+ADVb+DrRZQ6+bavNuzg6HTmAT5md1D4R+6u8FHpH2dS/9XP" +
       "/Jcn+I9bn3wHZcbTB1o87PIfj17/9f73qj96GbrvVAe3TUsuIt26KPlrkQ7m" +
       "UT5/Qf5P7uVfym8v/KJ5vhRx+fyRU0lApSSgEvYT9/j2yaL5fqAttRD1XjP3" +
       "AFcz6Gz0A+d7UAkCV5fLumAffj5+MfC8AK7KceCpnGTtbmlLeHai4Y/eOc1t" +
       "CiOPz+Wt0upvU3zxTBWNdWKl7r2stGjYvYkWzfTUPM3bzbN45IpGuN3eiufF" +
       "ftgSu2h+4B5ijO/xLS2addHIe0ruAbvdq8M+a07EiNwmxsIP5G1yZOqgCOhl" +
       "CZg56do+Z7rs8YzopVJ3pw1xxxgbW0GUlMPD9yDth4rm6fh8SX7RE88teLys" +
       "fvF3v/2u+bd/5Tu3Rd2LFehIDm+dRaJnijT/vsP5ByXHFoBD3xj/wA33je+W" +
       "OfdhWQXJJZ5EYO6TXahXj6EfePDf/4t/+d5P/vZ90GUSugaSiEbKZekPXQU1" +
       "tw5YdrUs/Jsv7Y13+xBobpSsQrcxvxfU+8unq3uDPHWDR09y7seO3eBjhxX6" +
       "sdV+9s5WCwriq2EUJCC469pJaD2dzx6X90X7qaL53J6Uz9yV7APCboKrdkxY" +
       "7S6E/chdCCtuP39C0bWCIqYM+Cf2+OF72yN7inDAwxffIQ/PgKt9zEP7Ljx8" +
       "+e3wcHWl79jAPq6mXzog6yfeIVnPguvFY7JevAtZ/+BtiTYqPEPH0iQ4ddNz" +
       "dP3Dd0hXsdbRPaarexe6fubt0PXYGV0zfaNH+3L1kLyf/Utokzomj7oLeV99" +
       "O+Q9fEyeb+6XhIgDwr72loTtg+Al4IEP1I5aR9Xi+RfuPPR9xS2ogK7E5Qpq" +
       "8cSeEPI+x1VvnkxZ5kBOIMjddNzWiZ/cOCt+9muQB4S23zahIDY+etYZE/jm" +
       "rc//py/+5o889yYIiQPogTKjgmB4bsRxWqzw/t3Xv/Tkw6/+0efLeTgQ5PzT" +
       "z/9Z6Za/ci92i+aXLrD6RMEqV9b1jBwno3LqrGun3B7klftBAfKX5za5kVBo" +
       "TGMnP0aQ8DqmzY2FNxDqHDwYV4ZivcmhVLWdNZOg35VpbBXiyq6aNyWBX5LV" +
       "uJ4YcVyr1MVFfZNOXYHuNfl16vjzgImmjZ60M8VJIOyGw9GEaqYjA5tKFc60" +
       "p83UtvEBMUF3QTChG51KswIrGTvExxsphZXNYjPZ6AacLjZVhmfGycrMkbkn" +
       "ONJGcHwlZHBSGrtCc6x6tXGbVU1qZ86pyE8dtbbobq2GUVsprr3Ta4tBmCbz" +
       "te3WWMQzm47MawNf7u+seQ8fW4KUyEE24AmlZuQkk/ghF64VZqibNZKOMXG3" +
       "XPOzYJVxGTIadSKHGRG06VjTXjoRsnFERJ2NHfaWtZzqscYQZTdjtt61Sb7u" +
       "ojV6W89a2jAge3E+X27IuZQiErfbbR2u2uao8ZLsy0uNSmqBOMGHzdGiYTqm" +
       "vagjLbgFJy2razfxvjRM++gul2oVO1n3x4I9nzSjusQENa812QzIqhX6JN8y" +
       "u25oK6mSeQTf7+drNU26mCEi817Fn5j1CeGPF0NHcwe0PctUkuRHHifE6A4X" +
       "0DwiiQE1RhsjH28NR2mCEkMqmyeLjF0a6bBlmfMBV6/C67lSZXdSv4tjstKh" +
       "x5gsrqeiL7cCF3f9nF8Hk21FXntcuEJRz2vuEI7Ulp473exi0e/tFGQyaOkR" +
       "jbPTwWbuhp4Vzl2mvRrvfE92E25F610kifUIpbBObk6IORdMJVtwYyKmQjHr" +
       "IbN5nwyWWezsagtMwExyPQu8fLnrN+bhKt5OpXXPFm2OtfgI67C8te1WPbPX" +
       "l4neLqrg9rCf8KuVvqL5NUZaHs6h1gIjRA3fDmb9wWreTUeRKSmepfCraruj" +
       "9DtKmgrUBrEnq27fEtfDrQVrIoZ0M7y24nhkyJjd7TCTfL899vwa3YodCyO2" +
       "URffmqzfdWR1I3bcNtxbddX6UvfoGlFr+qNuOiPM+oLN9U68UUxhJ5tVYp6Q" +
       "jamKNpCmqI6bVUnY0SNmkg8rDLNmN7vKUKHYOpz3DCA3kkdWFCNVx3QYD8f9" +
       "mmBL65WcDJvWhFm6s3CpjcJWxO00uL7C1qjTjJukMlJWVU+JrQYXbvqhGoxg" +
       "E7W5GOOGayxK5zwSpqzuZbTSMNTlCoyBzcTInAQVmoI7foOaZEtuTC4bdNyU" +
       "wzTrDkXTyJXR0kTNHaGgmmmKLELnhMKRoWXmDN5fWsxyy3eRhdmVh4kU0QMj" +
       "UUeJNqADUfKbI7mmT6PMdQacYLY3rmV1DGzeCsa8TIkms4XrGolUomY3RIUs" +
       "mI7Qnkeu+uJ2QWoJWVlIszqOyrWgKbhsV5PSYW269kxA+FYJ7HQsIx0EaTYU" +
       "Q+eECPPU5nbUoD2T2w6kMJkwWL+1pEKcHWvzCUM0s0rUo4fLlB+sXE8WfCIc" +
       "kykh9NDVSlUdoA6LzZ1wSZIbh8MqaryThiFG4muBCLP5MEBmctpr0/m4A9xl" +
       "gCfVbO5YZGMoGhTRRrU4Fb12k131zG07nYjVXTegFwGO1oUaE+k9lm8Z6UZs" +
       "1X2nXutXW8QIrmNNv5cvsYY3cohVhGnWSMhpvGMMiCraHtkT0m7VmjNc8aZc" +
       "pdvvbyZKRtEMV03FnqzLq54VTvquRFeNyWKY0sFYbMvLcXs0TgaUkW+5fN2T" +
       "DG+rLaLKuA13YSN3pMzHR6N+Wo0zbM5ilU0zJ5JKu5IZbEyRLVEe6W5l3WpO" +
       "4nymuyrT86igLbMKqylkb6gO2zpP5Q4SaTVFF2p41mXatfrS9Eb+DNem9NJp" +
       "cNWODsPMoIdqukNZtdzujsOtbtVid+Wps4bgij1OcxKKbus2RcszbFIt1rk1" +
       "pcuOZXdoZiGZwWEdVpg5ATcSHp1ssS3iLYixPDEEvL7JJErnvbAJt2b52AhX" +
       "fJ8BMTLHRnywSPtJfdiSBN/heobnpurCYEeD5rRBY1YXVRYi3nYdedcXTIRI" +
       "FytNaa+WXDgU7LSqImvbDpfDed/PsP6I5FdLEPQ5EWd2dLed8jZuB2OjFk61" +
       "pE01lv7ac/jNQFl1TK9VawxgsrdKInZHYzYqLgxqEyluqNdZlZysM9bG21VL" +
       "jLhOc9rNQWDrEwLbo9p42m22OmgghtnU5mYgpvqrXX0YOgyfY4QbCfN1vsOI" +
       "eIaMB1UtNSpjfStgKLLUsabe6izglZl6OhxjnRmxq4+Hgt+eDGmvl+ZmjDVD" +
       "EcliEm1mcAxTmpNVO2hDM9drb0kpGzNlkLoLw42GH2y1dsfljK47XE+2dgez" +
       "2p5nNdxufWr3mU1nB6vjlleNFtMav6alebhQqhV+EQswGk5zkE1Btt9tiDXD" +
       "w5Y0bQtbIRqozSHWcHJyi2easkDYToWGkwnSgacMvsw7wFo0RbN2G3eODFkV" +
       "YQlYW+96U8yhyBWNtNxJl7AW3kjz4ayDYKwdLXVR6HfhRdW2UWkpjpGdDu/0" +
       "dmoYsreTRbi73QSDhrgmpNWijmuso2+IyWJRbQw2LLJros5Ot0ebGT5r+t2G" +
       "jdc7ZkXokHmzw1txj6TQKtpw0U7F3WySieX6BIi9o96s0xr5gAqqaVppL4kH" +
       "Wt9p5dv1vK3BmzBZtge2HVko3odBwZgiWwmBK7hRd6Xdml7CCwsmWsuqtvE7" +
       "WmMnxWq9ujHscY3bcdXedNbTW2HgrJUO5YY8zPTodWXlES2GU8XdNHEEL6Oq" +
       "syStV4NkKHY77b7IGVNK0fydRKFoi7VrxEydGF47XW4pVpnN1gzea8/FltOf" +
       "GDuVX03WLcujfVOZieI6Xc+yDSVObQLICHW5zXZCsQnLyz3eTBcu1SCcFZYH" +
       "6bSpL6UkqwfxYO6Idq0GrLkiZs5UxWp65Hb1YFBJxJYh5511Xw/QVYcWG421" +
       "PyRbmc6Rgb5wLXWb8u2Yn2zaLcUY+dvEAdWhpfcV3G43iFpn1qg0UStrLNBp" +
       "HRnRuGpFGU0OFGHSmZPePOS2cL8lz/EKkrWmGwGNJtiwEcO+BM+xtNvoNRhx" +
       "uJmM5qttv0avJ7Y1rwrYDGY8VZTlPgXqkziS+IFOVettddSqI1lTZ0c9ZpqP" +
       "iXasLigq9XEXm5uobAnCarMZcWN4PJ9vxZzHE3U46KSxOtmMHW036HlMklfw" +
       "7agykStq1M60INCjKAFBEm1WtCWbt+r2VtDmHWSek/NsRYsGuu6uDINjUr45" +
       "dKor1fInGhF2qIxZqn1Us2tJxjfGiE4xzeEUCaeCOastmo05Opr1pvM5PMBX" +
       "Tr5G2uqYXDSauBNXE4chwl4wJ9Kdg6+HyHSWybKoYmhTj7y5RBtjoSL19I69" +
       "xdNZL980yZnA58psJ9aMVn9s2VMD1zUMZnSyCs8Vx0eaE09FukaM1gM3biNM" +
       "t6KZPZ72DZaYMppPYJTRbU/ri3HfoeoVzZ21hNUURUylNRVkT8AXUptg5bqd" +
       "5J2Gwsq1RjUcSEQtNN0BJnJw1g3DkdVuzk0bqw7Esa6H7jZkyGG/G6DrHUdV" +
       "lrS3nVfUnDMYSx6vFspiwkylxURuNofJVE6TRpWvNzamL+Wpt5IIjJ7OBVqT" +
       "arWZJLl13F9iVrZSO3yMUl2KqZPetJERCLMAGlQkSUCJZreVLw2eW+x6zNIh" +
       "p9Zq0dezeZWdDCtod8ftcLxf2/iFXdbw5m5IxXQ8jNn5VFCWw+WSHc5SC92C" +
       "ejkYo9NwWjFoWWTQeeS3GDHFhgLMCGFIi9nUpBcVbrzh85HdJ7JK6DSq1nph" +
       "V2spGSNuH0OG+nDlBrTXIPtOZzYm+4FT5de9odFqzHKcUDyDbZm0ALfoIFuK" +
       "277s1oZjmcoIH2lYeJJnojXWJ5EVDVptt93AZ4gLJlLVGTfER4tZN5Db481I" +
       "hROKhUOGyaJknrL1uCHiaJ6TgmyTRs7o4gqVCVMHKafOUU5HIUy2t2Q4uTqV" +
       "bSer9IIeE9UQY+Iv7DXnsxVyi8U56bpDbxbOa1okpiNnx+xCdbCrLsdzo1dV" +
       "fXrdhN1pZdrlxIq5pYTNMOV9owEMZ2B4lZ0RDSfSeLHZzZrLjd7it7UqNvKq" +
       "4WbVGnQ6nVT0Z+EoaERWf1CtzOAwsyVXUXugQMycjO0kQbdjNfr9Eb4VunBu" +
       "ELCaZtiKJTZBquojqjJTnXCK40mlIgkgp7Cao5h515xZ8NC2Lb7n8HrUa3i8" +
       "LPB+q7ohpOkKZtKw1q6sMsngMcNfNgaCojhOZ6dsep4yjLnZiE97IeKTHI1W" +
       "kJhvcSjaj1IxXWiRDi/qfKfj6UnXWQ7MHM7Zjut7XcrmbGm5Zeq8CSqZVY4g" +
       "Bhvxteocjhkf1DlgcgpKCTzz55FipvpIY82au3FSXQurBLxbVfAa4lXGixa9" +
       "qxjLaEO0rYmgKkvD7FbUBYG0mlul0rQaph22bIqnCWdKEG0lpTKQU3hXkFMD" +
       "GYa1+VaiLVIE9S+qIoloVYUInUkLJpuRvrJYipuquY1tvu4TTH2ybQpynxWa" +
       "DsFN0rYkr8mg01fUuuNM52tpPEJ5M+ftdcaQyoRorLFahtDjRuSlaMYkrqcm" +
       "RjLUbNzV+J3YAlMvULTJccMTdj0Mw158sVh++DfvbFnksXIF6PRImuOWGw7/" +
       "7B2sfGTn9n5O18vK3xXo4BjTufWyc8vSULFw/uTdTpqVe+Nf+cyrr2mTn0Yu" +
       "Hy/n30qgq0kQfszVN7p7rqvjvY+Ly3Y0uP74mIw/Ply2O2P0nmt2B1sL5zZh" +
       "yrW7Vgn1B/fYgHizaH4PyDuWvdAFaSERfDspzknccfVpE9jamfh//60Wni6s" +
       "+CfQ9YPTUcVRj/ffduByf0hQ/dpr1x9632vCv9tv7Z8c5LvKQA8Zqeue3349" +
       "d38ljHTDLjm7ut8CCcu/P0mg99xxywzwVPyV1H5jD/unCXTjEDaBHij/z8P9" +
       "WQJdO4NLoCv7m/Mg/zWB7gMgxe1/C99i");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("744ujigAYYA3vnkqouzSRYs8lf3jbyX7c0b83IXNpfIg7MmWbLo/Cvuy+vXX" +
       "BuMf/E7zp/fnmlRXzvOil4cY6MH9EavTbd1n79rbSV9XqBe+++jPX33+xC0e" +
       "3RN8ZtPnaHv6zoeIel6YlMd+8l963y9838++9oflOuv/A+GmhfmhLAAA");
}
