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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALUZDXAU1fnlEkLID/nhVyQBQlADeKeI7djgD0SQ6AVSgnQa" +
       "lLC3+y5Zsre77r5LLlGq4nSgnZahFMF2JDNMsVAGgTp1tNNq6TiiVuqMSLXq" +
       "KNp2WlvrVKbVdmpb+33v7d7+3R3VqZnZd7vvfd973//Py9H3yATbIi1UZ3E2" +
       "alI7vlJnPZJlU6VTk2x7Pcz1y/vKpb9uemfNNTFS2UcmD0p2tyzZdJVKNcXu" +
       "I82qbjNJl6m9hlIFMXosalNrWGKqofeRaardlTE1VVZZt6FQBNggWUnSKDFm" +
       "qakso13OBow0J4GSBKcksTy83JEktbJhjnrgM33gnb4VhMx4Z9mMNCS3SMNS" +
       "IstULZFUbdaRs8gi09BGBzSDxWmOxbdoVzsiuDl5dUQErSfqP/xo12ADF8EU" +
       "SdcNxtmz11Hb0IapkiT13uxKjWbsO8hXSHmS1PiAGWlLuocm4NAEHOpy60EB" +
       "9XVUz2Y6Dc4Oc3eqNGUkiJF5wU1MyZIyzjY9nGbYoYo5vHNk4HZunlvBZYTF" +
       "+xcl9uzb1PBIOanvI/Wq3ovkyEAEg0P6QKA0k6KWvVxRqNJHGnVQdi+1VElT" +
       "xxxNN9nqgC6xLKjfFQtOZk1q8TM9WYEegTcrKzPDyrOX5gblfE1Ia9IA8Drd" +
       "41VwuArngcFqFQiz0hLYnYNSMaTqCiNzwhh5HttuAQBAnZihbNDIH1WhSzBB" +
       "moSJaJI+kOgF09MHAHSCAQZoMTKr6KYoa1OSh6QB2o8WGYLrEUsANYkLAlEY" +
       "mRYG4zuBlmaFtOTTz3trlu28U1+tx0gZ0KxQWUP6awCpJYS0jqapRcEPBGLt" +
       "wuReafoTO2KEAPC0ELCAeeyu8zcsbjn5rIC5uADM2tQWKrN++WBq8ouzO9uv" +
       "KUcyqkzDVlH5Ac65l/U4Kx05EyLM9PyOuBh3F0+uO/Xle47Qd2OkuotUyoaW" +
       "zYAdNcpGxlQ1at1EdWpJjCpdZBLVlU6+3kUmwntS1amYXZtO25R1kQqNT1Ua" +
       "/BtElIYtUETV8K7qacN9NyU2yN9zJiFkIjykFp5WIv74LyMbE4NGhiYkWdJV" +
       "3Uj0WAbybycg4qRAtoOJFFj9UMI2shaYYMKwBhIS2MEgdRYALZNYb0m6nTas" +
       "zHL44l4SRyMzP9vtc8jdlJGyMhD87LDba+Axqw1NoVa/vCe7YuX5Y/3PC5NC" +
       "N3DkwshlcGJcnBjnJ8bxxHj0RFJWxg+aiicL7YJuhsDLIczWtvfefvPmHa3l" +
       "YFbmSAUIFkFbA+mm0wsFbvzul4831Y3Ne/PKp2KkIkmaJJllJQ2zx3JrAOKS" +
       "POS4bm0KEpGXD+b68gEmMsuQqQLhqFhecHapMoaphfOMTPXt4GYr9MtE8VxR" +
       "kH5y8oGRezfcfUWMxIIpAI+cANEL0XswcOcDdFvY9QvtW7/9nQ+P791qeEEg" +
       "kFPcVBjBRB5aw6YQFk+/vHCu9Gj/E1vbuNgnQZBmEjgVxL+W8BmBGNPhxmvk" +
       "pQoYRguRNFxyZVzNBi1jxJvhNtrI36eCWdSg0zXDc43jhfwXV6ebOM4QNo12" +
       "FuKC54Nre839v37hj1dxcbupo96X83sp6/CFK9ysiQemRs9s11uUAtwbD/R8" +
       "+/73tm/kNgsQ8wsd2IZjJ4QpUCGI+avP3vHquTcPno15ds4gX2dTUPbk8kzi" +
       "PKkuwSScdolHD4Q7DWICWk3brTrYp5pWpZRG0bH+Vb/gykf/vLNB2IEGM64Z" +
       "Lb7wBt78RSvIPc9v+nsL36ZMxnTrycwDEzF8irfzcsuSRpGO3L1nmr/zjLQf" +
       "sgFEYFsdozyo1nIZ1HLOZzLSXjiYMDUDWTa+Xs1QBUsm6tQ6gLEogqEYGYEl" +
       "Ig/y4eIEIgp6bW82ZYP3w/ZMHXay4JKezfKOtp7fiQx3UQEEATftcOKbG17Z" +
       "cpqbUhXGF5xHsup80QPikM+OG4SKP4a/Mnj+gw+qFidENmnqdFLa3HxOM80c" +
       "UN5eoggNMpDY2nRu6MF3HhYMhHN+CJju2PP1j+M79wj7EIXR/Eht4scRxZFg" +
       "B4drkbp5pU7hGKv+cHzrTw5v3S6oagqm+ZVQxT788r9Pxx9467kCOaZcdRS+" +
       "FB0mnx6mBnUjGLrxa/U/3dVUvgoiUxepyurqHVnapfh3hLrOzqZ8yvIKLj7h" +
       "Zw0Vw0jZQqGDlgLGwC1cHH1bzamf2d/7/SOCxUKmFiq4Dh+qkl/PnOKmhud1" +
       "5CPALLSGOfBc6kSAS4V5fOn/UQ2AvxpWpND4rLZGwS0obrw++Y1/f/4Ld4/P" +
       "fxssoI9UqTZkXnCfAsWuD+f9o+fePVPXfIwnogr0QkepwS4h2gQEansu/Xoc" +
       "1ogo/AXHsvHnet97J8OsYUgRc8TPrlwBI50dqGF4L+yl0SMvff5Xh761d0RY" +
       "TAkXD+HN/OdaLbXtN//gvhKpGgp4fQi/L3H0wVmd173L8b30jdhtuWgtCIrw" +
       "cJccyXwQa618OkYm9pEG2ek9N0haFpNiH4jadhtS6E8D68HeSTQKHfnyZHY4" +
       "7PiODRcOfm+uYAHPbRRqLCM8VW7mGJfycSEOl3PNxPA1jspUdUnjeNdCItao" +
       "PiBq/hU49JqeRmMCz807IschH9B6GTrFNOOuiQpXNeL5thcWC9lGc8A2urlB" +
       "eoJ+Y/Lu3/64bWDFJyltca7lAsUrfs8BLS8sbm5hUp7Z9qdZ668b3PwJqtQ5" +
       "IRsKb/mD7qPP3XSJvDvGO2thAZGOPIjUEdR7tUVZ1tKDcXu+0D7XnlA9Dou4" +
       "gvn3FXk9EK4HEXmtEmu8YjLAVmRUtLCLEuAjkVmsieYUrrZWZkzG66Oxx2f8" +
       "aNmh8Td5YWjmSOH4gmP3hQLUxJRhaFTSi29xF1+6JZht2uFZ5GSbRW69uZY7" +
       "UY/Y+4s4bMu5Zr64cLE2jJ5u+6ov7voR68fvPrGh46rbS7kqDrLwUxyUvI/e" +
       "F/VR/EzjMBh1OvweEsdybBxKaXNnibVdOHwDh6ygpATs7qhV4MRYUVV/Kikj" +
       "zv18uGAWswcNq0gW4wRfXYKZ/TgssP2taDCE+C4p++VdZ9+v2/D+k+cjySrY" +
       "eXVLZocXwC/BsmFG+KpgtWQPAtzSk2tua9BOfsQLhRpJhqxur7UUauUCfZoD" +
       "PWHiaz9/avrmF8tJbBWphuStrJJ4y0smQa9JQRCakjOvv0GY/kgVDA2cVRJh" +
       "vqgS+cLFfLJcmHbeuSYj4EXwXOY412WhZs61/0OF7R8axEmmZTAIGVQJ9Yh1" +
       "JbZlXmLch8MUjjqOw2GxzYGiPIeonwtP3DkmXoT6E160PRIlshg28DZER7Gx" +
       "s5fw4Bai9IefgtKlzllLi1D6WElKi2H7KL2qEKWPl6A058tE+RP5XyUJ3Sf6" +
       "TvTZFEFvaC525cv7q4Pb9owrax+60u0lbgSCmWFertFhqvm2ckJgUGxd8Bxw" +
       "yDgQFpvHaDGZFUMNhRBfeF6PwzK+9S9KBJrTODzNSKMtZUyNKsvZrbrKuBIK" +
       "xLSKYUNVPI2cupDt/E+eDTVr9C4TM/rMyP9JxN2+fGy8vmrG+K2viJbEvX+v" +
       "hQosndU0f+Hqe680LZpWOdO1Igqa/OcVRqYVzADALv5wul8WsK8x0hCGhUjP" +
       "f/1wbzBS7cFB2Ste/CBvQdMNIPj6tummogWFU1GvirrJyyZXFjTcvD6mXUgf" +
       "PlufH0gs/B9Xbh2ZFf+66pePj9+85s7zn3tI3OXJmjQ2hrvUQG8nrhXztei8" +
       "oru5e1Wubv9o8olJC1zvaRQEe6Z/sc8qx8CLTDSBWaGLLrstf9/16sFlT/5y" +
       "R+UZSFEbSZkEDcPGaOuTM7Pg1huT0XsMqNv5DVxH+3dHr1uc/svrvC4kkZYy" +
       "DN8vnz10+0u7Zx5siZGaLjIBAgPN8Z7sxlF9HZWHrT5Sp9orc0Ai7ALdSeCS" +
       "ZDJaq4T/0uJyccRZl5/Fm2BGWqP3Q9H7c0i0I9RaYWR1XqtBR17jzQT+o+Z4" +
       "QHXWNEMI3oyvTV8tnB61AUban+w2Tff6jJgmd9uu4qXv3/grDh/8FwjkWUPU" +
       "HgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
