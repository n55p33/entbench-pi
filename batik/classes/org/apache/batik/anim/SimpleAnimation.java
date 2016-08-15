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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "u26ydG39Ln/F4b3/AV96Ka4sHwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6e+zr1nkY78+Pa187vtdO85gX23F83cRhcimJlCjtZmkk" +
       "ipQokRIpUhLFdnEovt8USZGUOq9ttjVBA2Rp63Qp0Hp/JNnWwk2KYcEGDB08" +
       "dFvTtSjWLli3Ak26YcC6ZQGSP9YNy7bukPq978NJsQrgEXn4fed87+87h+f1" +
       "b0EPJTEER6G3M70wvaUX6S3Ha95Kd5Ge3BoxTU6JE10jPCVJRND3svqeX73+" +
       "J9/9jHXjCHpYht6qBEGYKqkdBslMT0Iv0zUGun7WS3q6n6TQDcZRMgXZpraH" +
       "MHaS3magx86hptBN5oQEBJCAABKQigSkewYFkN6iB1ufKDGUIE020F+DrjDQ" +
       "w5FakpdCz18cJFJixT8ehqs4ACM8Uj4vAFMVchFD7z7l/cDzHQx/FkZe/dsf" +
       "vfEPHoCuy9B1OxBKclRARAomkaHHfd1f63HS1TRdk6EnA13XBD22Fc/eV3TL" +
       "0FOJbQZKuo31UyGVndtIj6s5zyT3uFryFm/VNIxP2TNs3dNOnh4yPMUEvL79" +
       "jNcDh1TZDxi8ZgPCYkNR9ROUB1070FLoucsYpzzeHAMAgHrV11MrPJ3qwUAB" +
       "HdBTB915SmAiQhrbgQlAHwq3YJYUevqeg5ayjhTVVUz95RR652U47vAKQD1a" +
       "CaJESaG3XQarRgJaevqSls7p51uTD336R4NhcFTRrOmqV9L/CEB69hLSTDf0" +
       "WA9U/YD4+PuZn1Pe/mufPIIgAPy2S8AHmH/0V7/zkQ88+8ZXDzB/8S4w07Wj" +
       "q+nL6hfWT/zuu4iXOg+UZDwShYldKv8C55X5c8dvbhcR8Ly3n45Yvrx18vKN" +
       "2b9c/fgv6988gq7R0MNq6G19YEdPqqEf2Z4eD/RAj5VU12joUT3QiOo9DV0F" +
       "94wd6IfeqWEkekpDD3pV18Nh9QxEZIAhShFdBfd2YIQn95GSWtV9EUEQdBVc" +
       "0OPgegE6/Kr/FJIQK/R1RFGVwA5ChIvDkv8E0YN0DWRrIWtg9S6ShNsYmCAS" +
       "xiaiADuw9OMXAM1HBNuPPL0LbisXuVVaWPTnOHZR8nUjv3IFiPxdlx3eA74y" +
       "DD1Nj19WX932yO986eXfOjp1gGOJpNCLYLpbh+luVdPdKqe7dWk66MqVapYf" +
       "KKc9KBWoxAXODcLe4y8Jf2X0sU++5wFgTVH+IJBnCYrcO/oSZ+GAroKeCmwS" +
       "euNz+U8sfqx2BB1dDKMlqaDrWonOlcHvNMjdvOw+dxv3+if++E++/HOvhGeO" +
       "dCEuH/v3nZilf77nslDjUNU1EPHOhn//u5WvvPxrr9w8gh4ETg8CXaoAwwQx" +
       "5NnLc1zw09snMa/k5SHAsBHGvuKVr04C1bXUisP8rKfS9hPV/ZNAxo+Vhvs0" +
       "uD50bMnVf/n2rVHZ/sDBOkqlXeKiiql/WYh+8d/9zn9BK3GfhN/r5xKaoKe3" +
       "z7l8Odj1yrmfPLMBMdZ1APeHn+N+9rPf+sQPVwYAIF6424Q3y5YArg5UCMT8" +
       "N7+6+fff+PoXvnZ0ZjQpyHnbtWerxSmTZT907T5Mgtl+8IweEDI84Fql1dyc" +
       "B36o2YatrD29tNL/ff3F+lf+26dvHOzAAz0nZvSBNx/grP8v9KAf/62P/o9n" +
       "q2GuqGXKOpPZGdghDr71bORuHCu7ko7iJ37vmZ//DeUXQUQFUSyx93oVmB6r" +
       "ZPBYxfnbUuilu7tlavsgU90SbV/XyiJEP64XAAZ8B4YW+gesgxuXfJzgxNBL" +
       "9ymOYjBLamfHCQV55alvuL/wx79ySBaXs88lYP2Tr/7Un9769KtH51L0C3dk" +
       "yfM4hzRdGetbDnr/U/C7Aq7/W16lvsuOQ5h+ijjOFe8+TRZRVAB2nr8fWdUU" +
       "1H/+8iv/5O+/8okDG09dzFAkKMB+5d/+n9++9bk/+s27BMkH7EpmL95bZpV6" +
       "DyJ47e++8Ds/9toL/wGMI0OP2Akoy7qxeZdsfw7n269/45u/95ZnvlRFkQfX" +
       "SlLNfe1ymXRnFXShuKmE+Pip85TBAXoOXO89dp73HoS4/P+Rj4Cph/Edqe7P" +
       "a+hDRMDKpn24/0tpGbVC5WD/t8r4cZp67mPbVCnOs+j9zv819dYf/4//s9L5" +
       "HUnnLuZ+CV9GXv+Fp4kPf7PCP4v+JfazxZ1JGZjCGW7jl/3/fvSeh//FEXRV" +
       "hm6ox+X/QvG2ZUyVgbKTkzUBWCJceH+xfD3UardPs9u7LvvbuWkv550zOwf3" +
       "JXRld4dUUzbd4gpURVq2wni+am+WzXsrcR+Vt+8rdWEHilfhtUEc9/TAPJRd" +
       "eNl8JCpO1XR0wDsJW4cQWfIBqt8w0MsodfLuUG3Y4a3TlQd4WdxF4e+/t8LZ" +
       "yj/OpP4bH/+vT4sftj72fZQZz13S4uUhf4l9/TcHP6j+zBH0wKkO7liWXES6" +
       "fVHy12IdrKMC8YL8nznIv5LfQfhl82Il4ur5/aeSgCpJQBXsR+/z7mNl88NA" +
       "W2op6oNm7gOuFtDZ7Jec7+o6DD1dqeqCQ/j58MXA8xK44OPAA59k7V5lS0Rx" +
       "ouEP3D3NZaWRJ+fyVmX1dyi+fB6WjXVipd79rLRsuIOJlg1/ap7mneZZPgpl" +
       "M7/T3spn6TBthV02P3IfMSb3ebctm03ZKAdK7gObH9RhnzVVN3IflF3ZPJec" +
       "L5Uvesi5jYiX1c987dtvWXz7n37njmh4sTJklej2WYR4d5l+33F5XTBUEgvA" +
       "YW9MfuSG98Z3q1z4mKKCoJ9MY7AmKS7UkcfQD139g3/262//2O8+AB1R0DUQ" +
       "3DVKqUpy6FFQC+uJBZYzRfRDHzkYVf4IaG5UrEJ3MH/Q2jurp6sHQzk1zydO" +
       "cuH7js3zfZcr52Nr+vjdrQkUqo9GcZiCoKtrpyEvOzVR81B4l+2+bP76gZhX" +
       "7kn4JdLKJekHj0n74D1I+6l7kFbe/uQJTQ8aceifWss5ij71fVL0PLgaxxQ1" +
       "7kHRT38vFB2l4d3o+Zk/Az34MT34Pej53PdEz3p3N3p+/k3pOQTDK8AUHmrc" +
       "wm/Vyue/c/cZH6iCD7CQpNpiOxeFUuA3nnrzpKZd6HECvO2m4+En8fHGWXY8" +
       "bFJdIrT9PRMKnPSJs8GYMDBvf+o/fea3/9YL3wC+OYIeqswXeOW5GSfbcgvw" +
       "J1//7DOPvfpHn6oWakB+i7/x3ac/Uo76S/djt2w+f4HVp0tWharwY5QkZau1" +
       "la6dcnspvzwIMtSfndv0+r8eYgndPfkxc1mRu+rCCFJ8oOwbwgRvErzrN1jU" +
       "YmtFtxi4KjudMV1X9kl0ue6N6t1G0dqmSKLFSrCFPTjZb3GSGBQxOWPme3JA" +
       "9NZJv5iwDjGwwkiwzZgMp/zGtV22587FXs22BDemSaEutrNMb0UtWLYX3Xxh" +
       "NPwmjmY6DOPO3hii9kpc09vaPEKphmKNcMPaBMaC9tzGgnEbO3xVy+s7xJjv" +
       "gg4iK/tWq8W6egizgccncertFDlejMNIs2A5hMOGiwpyY5uEixnhFC26ka5W" +
       "XmRFrWHT9xsJqGoUf7eLw4klMF058cbuUhmx83TSLKzJ1Epy1lYpj+Cx0cpf" +
       "YLo0pca+1Je4ebeJRF0Y2cVCz607GSNv+Cid1xTPopuRvxl5g81+HxeUF9mD" +
       "ibMxB0Ixbe92sLjOVFIlJxs1cWjPyefTKY7DbW09pW2fYKJtQmI6shooVqaw" +
       "1EKIJoO1pKCzeFiLYWEciSOyNdx3HVwI0FqXV/2w15eWWGc8JmBT3zTXI6PX" +
       "WA63Yrr0nS5fsA6M2YInz9O1HIWG2O9nc5bWUMfcq3s7zce4zSZDR3ITEdYb" +
       "zWjqeaNBltJhK0Zpx92R7NB0+xg/Zhv+ZrnMFj1h0xlR/lAWNWFXX9RSvph1" +
       "2DQFPAq7fNgKDMqM2KZbj9si2VmGpAFmikd7pjvGB0uMF31k5PM1he9hgY4X" +
       "Y8dSTYTrrsa1sUW5MqHvp7ziKvNgSblrz3K6Yw4XVaI77k33FN1QesJ0k9Ke" +
       "T3TT3OVrwqxDd2gmavFsd5qQ3S7OA00tdvOmUB+rXr9m9tMZlrC5saRHK0Ip" +
       "usvemC5YAuOKYN5jktpIaW+DAJfmcSfd+XFn4UTdUbjY2Alt1OvmhFf4NOqy" +
       "HcHGuiqRSM2i5TcjeDPFVxjfbTM8n9D9JqajQeyhir4No640sUjZqbeW9bmc" +
       "oTsgdrfZ0FBtUcj2Upz7tJKGGd0PhmzWQqnlNGP92ciJrFm9YHVsG6RxXvSM" +
       "LUfGhh0NldHYX/aFhtQT040XNpLNMp5vI3xTH9GrhTxyyXS5YOKWPupxFqdI" +
       "mwW72+4bs2QXjV1hOxHr/BrpC8w4761AlRphC2TJYuvWmrQyF0d9kezTs6FH" +
       "c2KRzIYIPtlNVdGsKcuRPZNrnqQJ3GzVy0bZaNe3I3LQMDG3tuTqfO7IOyqy" +
       "zDzuDkiLWeVCr06Z3dSHrQVtMDPP6I8lQZhSvgybQRa4Sjuii/mC5hh5tTKk" +
       "nDKWgygiYqnZNBr4ohVwQ7jZnhUhP8VIm3RXi1yicpWCjWFhDDB9amJzb9gT" +
       "m/64yDee6W4GOeNa21RGO5NmO++sNWIX9/xkNxtH3cC0MRqIZ8vkY2y1Tg0u" +
       "HQpsf410xkuuqFkLO57RbJKOBrYy8bRV1yImzR03XMGO6A537cmem3pdtTA8" +
       "mxJ7yojfSKKJUyOnT7FMs/DlVpr1xAUTOmEgjBU6RHRxbsqk5sMwNiJlO1dt" +
       "blZrdUNaCrmZnRHooMnp+6Iw5BQdSg10NkHXe7WN5rBLOmp/5hAzK19Y09xm" +
       "onpH58hOa8shM1yvq/iINScOOzK6ASH5GeaQvbAlif0JNxK6eRH0iSRW1sBh" +
       "Y3vZX8QDu2/0+2tBzmptKmlZfamZUPs8HsKGicYuhqpybvV7ccqwPCXmE6kj" +
       "x2iGMGqwR6hCr/sOKRsbEOjjCStFErGnrBbnO409urRmREBkQ9hpNr16hndi" +
       "Yj1bmY0w1Bp006FqfDAnBjSsphxqxBtfmw6lMGpqCWaKuiHMp6hL1PY2N3bT" +
       "fCeoWkQN+zW+2Vfo3tJF8ZGFJvN2I5x7G6dFOcjaK7CWOkFQjXVBwukPNJ31" +
       "oibSbSCw6Unu3te2ugIv1nXWWjXXdXmq9Gyt2ym0tBktF6OwZg2NRGVUuNmZ" +
       "x6Hhml1S8hIt3O+W9YCU68PhVN4zwlzcAduYMztxCc/VutATEq8V8ZjJkK65" +
       "IVfLFenRJrLDdJqkzai1Xra36xWH5ojMDiVFQJGxHhvMthNhiM3OGvyMJLui" +
       "kQpTJvbriN6xczSabVgGsC73JSw0DZKW29okdxdGThhE4MB2Dm8oWyNJP4hU" +
       "h5Ezkt6w7Vp7PmnOomzFslF/hQYjv8W09v08HOQbF+6RBYojyKaHkB0YW3Ts" +
       "4SZkFmMBHlKkKIirXCc30aAJbxcsVkQhEmgO7O64tZaDcB4ysiHO53GOwLCD" +
       "cIWJtPGtaxOKLGizGTwQI5YW62xfjwbsUAThK0K2se6pZp2MbCHa6cEmFn1l" +
       "weU473hBs0PDsuTVqQjJE0wZr5SZnWi9nlJQDtZbbZ24FeGhbzR4A9Gpcb5k" +
       "93M+kJag2Ki3/Uwe4XaESb5m8XaXXOGstdRnZE4uCYPDUFab9TACGXiKW3C2" +
       "m7rrHiMUadbHm44EB/jaxYs0hfvFmp81ovlgT2dbEp4NUn3YbrcKtgF3av1+" +
       "MCU75EK3Kccb9/fzQa1jwvMOtW85op2Q9SHGYk0P66j1LFO3lhf0XYLx7T4s" +
       "wsJoMHVSPke6ywa5dWZ1uI15+jBDQcnCECvWxvQ8ypoxsgA5QF0jsACTG1ex" +
       "A6tDMO1M1XfwclGXsrZUZIYwaUzRpkKQtJ31cq9AJog9bYRcKLHiuHD24khM" +
       "ts2lNtr5PRHnJ0KjgWnEsohWfVxmQwcJmREfJO2JVaBash32cx1lFwRqbZN6" +
       "z+npg0i1s+GSFYeFaCZYczPClokKytiNm6yLOByRMUV1+JHY2qD9cCI2JoUp" +
       "6D6qkY7LwuGU3Wl0FBVeTaSU5qboZhpj58sEqzW7WhY2zXVEGHF9Z2S6MZ51" +
       "VpPlcLysF3E2bxdCBgdmqkjeXkHZscsxwZ7B2YbkNLDOfDLfSJP+xBL1dpxp" +
       "RbMFI/aoKWE5Wmdpgg7rGDl29xtOU2x8rEa84WhRxnOprs/7tamA2wSsdxgi" +
       "CE2p27bbXuTVA4eSaSLdja1wNdO8nFTtpG6Ke6GurxV06od7adZgET8b9KmV" +
       "MRQRjqixOxHLSKqA8X1PsUeKyvGbsSCh21EjC2YOO0lrOcORO1Fm0GG05yTd" +
       "HsZDVEaHK18yJsYgKFZ+bcVpaGOxQNSOwC0dHMELWpluYGzTbIXYjh1x6gIU" +
       "L9nG29CIvc/zqVkfBHmn08c8e+rM2eZax6IEX0lWC7Hc3nTu0UONwufjoGfG" +
       "G33DjQYSuV0lHDLpM7uiV+vSOpXGsNanVz0UqdsZvkcjSVUmMbJvMB6dm15D" +
       "7DSEhu5S2CrJO2qbTpE0HkkJjxEYnuotf7RF5/B+L9dr7k4eyHimLPhxgYTp" +
       "bB8SswnSRrhh1Oh0sogh61FPAUFxPAh9NF7yQofO5kOHr42WHV1t1XK0SSqD" +
       "UYhtdiJhkB7VpucMvBQWLAsTZq1oCDjBDHm9OZ0U9amzbuM63eiTqD6asLsB" +
       "Y3YW81FHcqfyWiC9/kxvy7k6nSNOnImmSvUybdFkYpKrY+JaYqdLSyaMDdJs" +
       "S2yvNXK9ZORHROQMNJ/oGD7NcSvLlnNujzKBD0Rp9wvZSyyhQe9JnxqwxbSD" +
       "9HrjTO22mqEpjJwm7yUzvuGOTJ2Zr22nveV9Tve26miGUJMJH+jzbDNpFy7O" +
       "i8D8tu7a32tbKzCyoWfMOWkaNsap3uNEri+NQQZU4mYaMLZS7+mCZE6nPq/2" +
       "2YxZ4cI8ITeW5Y/XDCJnxYCkUCSWWWuYT2c7XR6LspcR9twLRpOtu8lr28HK" +
       "8+tKavHUvO2ITZRTuFbmdrkZi84YOwbJmDUNBma4bhZg+oCbOBw1YbDUL3CU" +
       "jzFDYSJOnAw7I3y4zSZ2Q5mLwbAj0A0f2ceLueJTai3NiRRWlZFBrgmwjOKj" +
       "fjehSANp5M26FU2Uvllm1yw317Uu3t/1MXgjNwNbkIrxamJ1yT3s9nozzh+H" +
       "HLnU+kxq9OOiIaVrepoVXFtUeWceIBYTezWYRfH+Ng2mhuH2VAqsuCZ9ZbDt" +
       "zHrtnbNl+IzCs52wxT18oSAgWiM7vskutxY+Z7qg4OA6RNBYTkF4kpWuv+dB" +
       "RNCCzOK36ILfJWDZKG1bYAlhNDCLmo1qI2prZwtJ39NUvK55FFPbmKzek4xR" +
       "TUOLTUf3A3/dQoo8mpB6usoNBmkDka+lTo62673YmfDejufpviNyPo7Hs2w+" +
       "WfRaDdi1+8oGmXYxPydwHjEX29VuadfIrLkotpJtM1OLpVNpv8oTm2p2ZwIS" +
       "hny4CrXVhm4Z+5XVUxAnAlV0jwt0ACkGYp+gMBZv4iYjEe0FuV6Ns85miYva" +
       "FAl23Y24bbR22gDtMAFCYWsU6S46rbGCJcO82y2X9l/5/rYcnqx2V07PAzle" +
       "tdv7xe9jV6E4t/F+ugVV/R6GLp0hObcFdW7vESp3R5+51zGf6sPkFz7+6mva" +
       "9Iv1o+M929sp9GgaRh/09Ez3zg11vPF8cSeMBtfnj8n4/OWdsDNG77sNdmn/" +
       "+NwOeL9s8Arqq/fZZf5XZfPrQN6JUp4a0brpPLDT8iP1XXd2stDWzsT/z99s" +
       "U+fCtm4KXb90NKX8zv7OO067HU5oqV967foj73ht/vuH76onp6geZaBHjK3n" +
       "nf/2de7+4SjWjcPe+qOHfe6o+vtaCr3trt8rAE/lX0XtvznA/n4K3bgMm0IP" +
       "Vf/n4f4gha6dwaXQw4eb8yB/mEIPAJDy9uvRm3w4ocvvw0AYoCcwT0VUXLlo" +
       "kaeyf+rNZH/OiF+48AWhOoV48j1seziH+LL65ddGkx/9TuuLh0MloPzaV9M8" +
       "wkBXD+dbTr+pPX/P0U7Genj40nef+NVHXzxxiycOBJ/Z9Dnanrv7CQ7Sj9Lq" +
       "zMX+H7/jH37o77329WoP8/8BUQdhPR4qAAA=");
}
