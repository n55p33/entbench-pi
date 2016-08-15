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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0aa3BU1fns5knIG3kICY8kwPAwi1ZsadAKMUBwgZRA2gY1" +
       "3L17klxy997rvWeTDRZFOo7YqQ5VVOpofrRYUFEcptbWVku1PlBrR/FRtWqr" +
       "naq1jjBtbae2td93zr17H7t7aTrSzOzZu+d833e+9/edc3PoQ1JimWQm1Vgr" +
       "GzWo1dqhsS7JtGiyXZUsaxPM9cm3Fkl/vuy99cuipLSXVA9K1jpZsugqhapJ" +
       "q5c0KprFJE2m1npKk4jRZVKLmsMSU3Stl0xWrM6UoSqywtbpSYoAPZIZJ3US" +
       "Y6aSSDPaaRNgpDEOnMQ4J7EVweW2OKmUdWPUBZ/mAW/3rCBkyt3LYqQ2vk0a" +
       "lmJppqixuGKxtoxJFhm6Ojqg6qyVZljrNnWprYK18aU5Kmi6v+bjT/YM1nIV" +
       "TJI0TWdcPGsjtXR1mCbjpMad7VBpyrqcXEmK4mSiB5iRlrizaQw2jcGmjrQu" +
       "FHBfRbV0ql3n4jCHUqkhI0OMzPETMSRTStlkujjPQKGc2bJzZJB2dlZaIWWO" +
       "iDcviu299bLaI0WkppfUKFo3siMDEww26QWF0lSCmtaKZJIme0mdBsbupqYi" +
       "qcp229L1ljKgSSwN5nfUgpNpg5p8T1dXYEeQzUzLTDez4vVzh7J/lfSr0gDI" +
       "OsWVVUi4CudBwAoFGDP7JfA7G6V4SNGSjMwKYmRlbLkYAAC1LEXZoJ7dqliT" +
       "YILUCxdRJW0g1g2upw0AaIkODmgyMr0gUdS1IclD0gDtQ48MwHWJJYCawBWB" +
       "KIxMDoJxSmCl6QEreezz4frlN1yhrdGiJAI8J6msIv8TAWlmAGkj7acmhTgQ" +
       "iJUL47dIUx7eHSUEgCcHgAXMg18/eeHimUefEjAz8sBsSGyjMuuT9yeqn29o" +
       "X7CsCNkoN3RLQeP7JOdR1mWvtGUMyDBTshRxsdVZPLrxia/tvJt+ECUVnaRU" +
       "1tV0CvyoTtZThqJSczXVqCkxmuwkE6iWbOfrnaQMnuOKRsXshv5+i7JOUqzy" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17eazs1nkf79PbtbwnyYuiaNezVWnsR3LIGc5Aqh0OZyOH" +
       "HM7KWZpY5k7OcF+GHLpqHCONjQZxjEROXdTRH4WTOIliB0aDBilSqCkax7CR" +
       "Iom7pEVjp2iRtI5RC0XTok6bHnLu/t67lio1F+AZkuc753y/bzvfOTz31W9D" +
       "F8IAKnmutdUtN7qpptHNlVW5GW09NbzJsJWBGISqQlliGE7Auxflp3712p9/" +
       "91PG9XPQxSX0oOg4biRGpuuEIzV0rY2qsNC1o7ctS7XDCLrOrsSNCMeRacGs" +
       "GUbPs9Ddx5pG0A32gAUYsAADFuCCBZg8ogKN7lWd2KbyFqIThT70t6A9Frro" +
       "yTl7EfTkyU48MRDt/W4GBQLQw+X8WQCgisZpAD1xiH2H+RbAny7BL//dD13/" +
       "0l3QtSV0zXTGOTsyYCICgyyhe2zVltQgJBVFVZbQ/Y6qKmM1MEXLzAq+l9AD" +
       "oak7YhQH6qGQ8pexpwbFmEeSu0fOsQWxHLnBITzNVC3l4OmCZok6wPquI6w7" +
       "hO38PQB41QSMBZooqwdNzq9NR4mgx0+3OMR4owcIQNNLthoZ7uFQ5x0RvIAe" +
       "2OnOEh0dHkeB6eiA9IIbg1Ei6OE7dprL2hPltairL0bQQ6fpBrsqQHWlEETe" +
       "JILeeZqs6Alo6eFTWjqmn2/3X/jkR5yuc67gWVFlK+f/Mmj02KlGI1VTA9WR" +
       "1V3De55jf0Z8129+4hwEAeJ3niLe0fyjv/n6D7zvsdd+Z0fz/beh4aWVKkcv" +
       "yp+T7vu9R6hn63flbFz23NDMlX8CeWH+g/2a51MPeN67DnvMK28eVL42+u3F" +
       "R39J/dY56CoNXZRdK7aBHd0vu7ZnWmrQUR01ECNVoaErqqNQRT0NXQL3rOmo" +
       "u7e8poVqREPnreLVRbd4BiLSQBe5iC6Be9PR3IN7T4yM4j71IAi6BC7oHnA9" +
       "Du3+it8IMmHDtVVYlEXHdFx4ELg5/hBWnUgCsjVgCVj9Gg7dOAAmCLuBDovA" +
       "Dgx1vwI0s+GNaMWFc5u2GImSpbKqo0dGHhqEvOpmbnLeX+VgaY78erK3B5Ty" +
       "yOmQYAFv6rqWogYvyi/HjdbrX3jxq+cOXWRfZhFUBePf3I1/sxj/Zj7+zd34" +
       "N+84PrS3Vwz7jpyPnR0ALa5BPAAU9zw7/iHmw5946i5ggF5yHqjgHCCF7xyw" +
       "qaMIQhdxUgZmDL32meRHhB9GzkHnTkbenHfw6mrefJDHy8O4eOO0x92u32sf" +
       "/9M//+LPvOQe+d6JUL4fEm5tmbv0U6elHLiyqoAgedT9c0+Iv/bib7504xx0" +
       "HsQJEBsjEdgyCDuPnR7jhGs/fxAmcywXAGDNDWzRyqsOYtvVyAjc5OhNof77" +
       "ivv7gYzvy239GXBV9o2/+M1rH/Ty8h07c8mVdgpFEYb/+tj72X/zu/8ZK8R9" +
       "ELGvHZsDx2r0/LEokXd2rYgH9x/ZwCRQVUD37z8z+OlPf/vjf6MwAEDx9O0G" +
       "vJGXFIgOQIVAzH/7d/w//MYffe7r5w6NZi+CrniBGwHvUZX0EGdeBd17Bk4w" +
       "4HuPWAKBxgI95IZzY+rYrmJqZmHQwFD/4tp70F/7s09e35mCBd4cWNL7vncH" +
       "R++/rwF99Ksf+h+PFd3syflEdyS2I7Jd9HzwqGcyCMRtzkf6I7//6N/7sviz" +
       "IA6D2BeamVqEs72dGArk74ygZ29xVcW1d+6681MwxkQMdDUqNA0X7Z4rypu5" +
       "iIreoKIOy4vHw+Mec9Ipj6UwL8qf+vp37hW+809eL/CdzIGOGwgnes/vbDIv" +
       "nkhB9+8+HR66YmgAOvy1/g9et177LuhxCXqUQSAM+QDEqvSEOe1TX7j0b//p" +
       "P3vXh3/vLuhcG7pquaLSFgvPhK4Al1BDA4S51PvgD+zMIbkMiusFVOgW8MWL" +
       "hw9t6e785Q1wvbBvSy/c3mfy8smivJEXzxzY50UvlixTPmWcV8/o8JRSzhc9" +
       "nc8fESCv99w5RhbGspvgX/n5p3/3h195+o8L6V02Q5AakoF+m4zjWJvvvPqN" +
       "b/3+vY9+oQhL5yUxLKaAq6dTtVszsRMJViGOew7R5lNtfrN3ZQd29xtBxluc" +
       "AqXAVHQVHgudnWGrnHuQmIMuGkXtwXT7VzZWbs/PnrHoCEwbBMbNfqIGv/TA" +
       "N9af/dNf2SVhp7O6U8TqJ17+O39585MvnzuW+j59S/Z5vM0u/S3Uce9OHX8J" +
       "/vbA9X/yK1dD/mKnjgeo/RzsicMkzPNyOE+exVYxRPtPvvjSP/78Sx/fwXjg" +
       "ZObXAgubX/lX//trNz/zza/cJrW4ABwziA5N/SCanSnFdm6MR5PpQ/+Lt6SP" +
       "/Yf/eUvkKXKA2wj2VPsl/OpnH6Y+8K2i/dFknLd+LL01aQKOdNS2/Ev2fz/3" +
       "1MV/fg66tISuy/sLuCL7AVPcErhKeLCqA4u8E/UnFyC7bPv5w2TjkdOaPTbs" +
       "6TTgSKLgPqcuvPYoyrbTPagILIvbx6hz+e0HgS400xGtoh0HwpZVZHMFMV28" +
       "20UwPoLuAgEgv2156aHmzu3ncPvz0G4Gy6GBJY3rqPlkeFC3ywdN9+bhchJU" +
       "prexgefubANcEXCOFPHlj/2XhycfMD78JhLBx08p9nSXv8i9+pXOe+WfOgfd" +
       "daiWW9aaJxs9f1IZVwMVLI6dyQmVPLpTSSG/nT7y4gOFhM+Yje0z6oqVzgoo" +
       "UM5FvdPMGeTB/pxHHcbohw/WQc/sz0jP7ILC7O1YpoDkxg0Ok4+DkPz/q+v0" +
       "dgYL3MUVb40y+fMkL6IDD/nIWR6SFz+4c4+8+KG8+FBehLf6Qf4o5YVyq2Hn" +
       "z/pu2KJ1XqzP0NfHzqj70bz4aF54O07OoP2xtEgy2OKhcQbhJ/Li+aIKz4sX" +
       "dhiIN5Q97WgfKp4u7kR8cvnx1H46dZBWnUil9vXwE3fIpvLbv3YQoe7eRajD" +
       "xU7rKA8r2P7k92L7FGNPg+u5fcaeuwNjL78Rxu7ZMVaE+fBQxcc4+/Sb5Oz9" +
       "4EL2OUPuwNnffyOcPeSpwJ3ADKeD1ShI4jwQocSDlRp7isvPfk8ud162B5Lc" +
       "C+WbxE0kf/4Ht+fjrsKFwLQSFtuMx3wpAisAS75xkH8IahAChm6sLOJgwrh+" +
       "NJnsNupOMcq9YUbBpHLfUWes6+jP//h//NTXfvLpb4DZn4EuFFsaYG44NmI/" +
       "zrdBf+zVTz9698vf/PFi5QmkKnz0Pf+12FR69Sy4efHzJ6A+nEMdF0GNFcOI" +
       "K1aKqnKI9lTgOg8C+v872uj+QRcPafLgj0VEEWtMUc0JK2uH7mBrmlrU1smA" +
       "TEx0GYoK2eOmjURfjsiyvkAxFiXWVrqt14lgM1MnzdGyzbvEwh9WBIH3XC0Y" +
       "LabtluxF0kxYx+jAagQjuD2KZn7giD66WjUiSVTLkVLHsgAlukREiJNgnPHZ" +
       "Mi4pNQxTS3VYVWRs4A5RxrRnQxsV9KCTzVxU8Y1wTDBRx9zOl9NQTAdcXbax" +
       "9tqCNzFgSY5Njx3PBbLeQ1feMox13xA9xq/ISM8L2kyrbKOO11vjq9FS6LF2" +
       "yI2n2DiykHQWcNWpO/a3SSR544VLDpb0ksGm40VVHI+bA1Ec9XWv2eIdbogz" +
       "REtI1FmZ79lTZTaYNpawTc5gLKAa622EsUAY5c0aES2b8TzfTONOL43clGkb" +
       "dpVf+XrV3wpLaxX0nZkXLHpoTZxWerZZ3ZSk1QRecKhDCxOGRiYzRR50wlU0" +
       "H6E2Ja08TlQIoeFtA1+et+webo/NRsUcWQFIl4ZJeSV37FUwjNvdhjaSBMS3" +
       "MAdfUd2pvzZohOeyQWvCjUcTgHgdr1aDYa8jlyUmWzKNsmItRXo2482mvDHj" +
       "cr0usSKNzNaep017bRcLTa7ZSpJydThrI9aYsiOxt2RoW0VspRFKsecvTF/2" +
       "yuU6i1qrnj4eJ/2Ko011r+/pFa82QZX5oqUOs2nGTppqhm+EzCAY2NLGAaI3" +
       "aT6cCcLUxKlYaSSk2+40BwSjkUSnKuDjfme84pLewh5ZErtekCSFsq350mUI" +
       "xbfMyYJmp1SqjJgZoqN6OfYShBTpNd+09S0Hep8qY5SWrSYYJxriNS7pzhhm" +
       "QYlJY9bo0SnXdJl0bFNWddgKVDXLcC2w+ujWCJSOyZB0janaIb2pTciZZZOd" +
       "9YoQZduY6EOTmbI4odDTlFC742lLp+SuTs45Ha3Bqto17amqtVZkVgsb4biz" +
       "XXFxPKlvVd8p1905QYVUf+32sRE7VAFWXgFKnm2izpTbNhuT0BiloSIsB2yQ" +
       "miIcbZio1KKmgiOOpmgkINRm606i5cTwmbGczQWfWqd2nKxbVXMm8RrwtSHn" +
       "xHxvFM5DY1MpmWCEqZ9tfaGnwMlCqA85Rmi32gMqEjclvNZJaanC1ZZ62hg3" +
       "jPqYWtaXo0GWSog4Lfco1V21GWs1aiPlvuK5xHaWdWmedIbEjAxJAYfb7ACJ" +
       "yHXc6Q/6+lJvaasGTQwFclybdZjJvK+jETOepj2/MRyjOimlZDbVkTiqdtkO" +
       "jPFZs+WWxPFwTIoc0mjzFBV1kJGlTlB+O6lXl3PF29aCUm2Jz/AFHUh8p7ke" +
       "1O2aUCK0LSxEKYyKqVbeNODpep0Ecp2E10NNb8y6NFMjG5RAEe5mLkWognIj" +
       "vkemUz2xTZJx19UacPmISWoOommsUfKDSK7jtRLRcnuL6kRdW7Y4ddp8MKC6" +
       "NMkxOrwcCtWlzrCW4BJLsJhoMDI8XS79VtqeuWCKn243giHGdI0uK3ivaaDN" +
       "MYcLgelX+JnW7SOY7MwHwjQ2Gd7dtAPDotRhZcTDVJup9ytjrMEwnYEUllEC" +
       "Q2slZqHEXhhr/Xm3t3QrNmU0p3Uy1ePAW6cabxmEq2JGl0I1otFaOROaTXQk" +
       "qXCE2WXTGOWXa2U5Xnd1LUK57cyL+Ykb03Tf3vg0X+PqkYvDTtKOpwvM4Ee1" +
       "0riE4hWlhPPhnJTFIJEH40xvjGuyl2mSkqXVkqbCaTqP0P5aXGXKcKJY0pJo" +
       "GeHEV4c+kDxaXiNrL2HLaVCKbTsr1RR9g80WDTcLFIPCiWjdb5JGr2mLlWoV" +
       "7s8wLMrgxWoSVNJ2hzFMOzObujjpTawRPx+3Z7TDNo0BI1tbGvGnrWZXVOxQ" +
       "B+tWeOgPhgsz0uoSN9DixqCODnto2jBGTnediprtkoRWWvbCDb/cwnh5XeGZ" +
       "bduU5tKssqBYY4LRXpA1+uJoUtm2s/ow7mOON4n1Pt2oKh4Ik7yqj/tUU8i2" +
       "4iIJt9w6Hk8Qi3NTmpWaXSZcyy6dSqrpdGc1tiuj7bbTCAyxFiV2J6rQtYVm" +
       "MdXYR2C1VuoxvodPVpVsXds4Ut8vNQOG5/pxZwIiM0sObC9ZbMujgO6QKiG7" +
       "pXDjC7OBptNTFe+YTdaRynaDUkMMxzi7w5oWQajqYKI4Va3RYQKTFnwTtwRk" +
       "XePCdYsiLb85ZezMMLTYovAE0StNVpAFhl5pHN6y7dFMs/uYR2adTBrUR2gf" +
       "DgcZWWY2cn+I8u6qG6yARUzIqGZFmzhupnCZb+EOXmPlyYqVtfaYrpRJDmmS" +
       "m21EUaQUzsLEa6uDQQ1Ou+1wW8JUu5VK5sqcE/batQYwl1Uxo8Sb3ardG9YT" +
       "t7Wuqr2GrK0wNOVr7cSzKi1yIldoPq1ikVrWFmGWwtasPUq6ge3XvCHXa1bV" +
       "SnseTNDqRGoh1c5G8FrTsTQjTEqlhnIJIzIZVft9rcSXULGyWHcE3cKyiCFV" +
       "p8F3sU2gG2LQKWGrMbuWbEmW6pu5EoslLLBZi+tPDGQpZrVtjGyt0XidldtS" +
       "rCqItBSwCBullTGrqn5nOCm1NqRXh/FEFvQRb5aq3iZCN2RZWatIs5FEydQw" +
       "Mgn2gpZSn9X6mEaoG7lnJiO8QrZSjIAx26siGNGYelMjWdtOv6qOSzzfSuhS" +
       "iR3q9axPKXF7UU2rdZjinTSTZRHT/YjQ2o5G+iqsWjCMSnxcwlKCRTBVGJJu" +
       "MpssTIdNGEuubEizOx4pmgB3RwNNaflcd+H0pvVgGwte2XMQRB8TsxjoCIMV" +
       "OvG1Gul3Pbu1Dg0qWnMRqVfrAzyTm5IfJXW4O9hgE71MqBzFtJvNxoq0YXHQ" +
       "nHkmWo/grOZ0N81Bb1HnSM2GQ4THJmXgdDrPE+zQM6PyaBujNZpuaJjDRhMN" +
       "R8rWBFeZ2azutcXypNSrrRZzCktCY7FyunJmRqW6VGcQK5U6ARvZZH8oalup" +
       "EYWrYDvr2YuSXx8zNTocOiuxU/M1BdhGTAKRC9mIqcz1+pq2BMxbZngPFh03" +
       "0qwMzG10Z7CqIyqNaNEy2saZ34vdspH0oylqmmUq3C5EFRE2mYKzSYcuKWUH" +
       "ieWw6liRjEn1kaZyxKCML2dNW10ZhLP0quaypmlhrZlQSUQsGEpgMK0ua75N" +
       "JSK28rmKkwqJv20ycX2h8MGy6jjpymrX6lRPo2OJTWhiXpmLXcqjUjAZ44k0" +
       "WvCJiDgbstNFlW2JHmHjzKPQ+WQVkgN1hChNikVYMgCeyTuUiWlNhCEWLM6V" +
       "WjKd4tFqySsJodVKmMi3S1Pdr9fatrISuwbC1cMSH2oxggiiOVha3R4+ySph" +
       "TR8taF43KnM5YKoGLqgzrquh/QaKE2CaZcxuovQbTZyHSb+1wJCgX2NTBodL" +
       "uJZJK9eL+MmCF3AJT2zEEAkNMFrqSonBD+1mN42jCd8hbLw2NZZsiU0QoVZd" +
       "hLhCmkwG1zS1HEsMaKojtRk1HVRKBEi4WGIQxctGH1vMKyO8TZVbGWe11nUV" +
       "rOyHHL9GE4bIfMEg26pd6mRIvxIthm21iWvbmW5K62nQ6G1Ls26njul9h0hr" +
       "TjjTGsuFXQIxj8oGSWpFBlmm67xOL2mjC5LDaSfWe9lCL00DPpWbNslzA2NF" +
       "qbXZxAIBuhZUhi3WqNWbXaNm2lSzLKxczdMxC44wYoSyUrDKpJ422HiTBiK0" +
       "sMxiPa49rXuc1xp2tKVNd9eVWtsBltSp+uRsDiazlj0eyAvguuX2IjHWriz4" +
       "nVSDLWHMYO1wVOmAFVVpyWGhxrasVc2qscKKVhxdyFY10u7RXSwik3lTlJua" +
       "bjhYLUT0ISnOV9yyyelyrR7FUtyR4DFV7XTGg0jc9r2N3DWZteo2tnGvYfC0" +
       "j5fmE2+YcuuWEpqLKjdP7fa0xYEcTlkTc0TGbHHN+CE3qS23kdblqwrdqa+5" +
       "QXlM1/vdStRu0f21pm/oWajhMDmiy/NhD5tW+glnzKfochgpQs9eG9oQnWO4" +
       "M3FZvDrneLnum5GOaN2AqFA+2RJUcVTt+FZnrG8Crt3jh/h4ZPpDs7OJ+huq" +
       "Qwz8uD8eDBGR5hyltLVW9bXZHcVwHyzzDF0nerNRxOmEgJAWKQ4EsLZTs7ga" +
       "9+yI103Hk0W8OZCFWMVL/flo3J22um3HqCYoPiGbGslMkWHV6tLV9cQuh8oC" +
       "FnGnjPiVbSerjoylOuF0Ew5qHIPPwircpFdzbMDUF9ncmtbk8mbLxq0lOkeW" +
       "QoLGlYFfDTA0ZLM56UdTAqb6QuIRK5IL3G571Ry3lGGHs2i3a1H8dkw1QeJj" +
       "y23cHi022Tbx8KavZ1QSdFgN2xiWSwvz5mohrFJ8KBHkuNEhcZ7bDpNRPe2X" +
       "TJCoS5U2yHH6A6GvRTEzWMEgfmKNspN2U7ReiztppMYbvuuojsq2LTHtlQl5" +
       "ZS2sdGpKqjvvmCrJpd6WRA1U8mx9pgn9GrwQiQlAyBhgHemUugzMl4dYkiJG" +
       "yW4ImTcbw1I/8zeElcHbbb1ssciIWZIxMwZrqrLHEI3KIkWiJim5jjO3pDJY" +
       "VMBofVzGWWlEpRKmwcOqlggNOcZnOtyo19ywy67QEk5M6ly1v16YsqePxMVy" +
       "s7Kw1mxVXi/8ZiWuey0/5VcsSVuNEdMXsBbq9x0zMpbA2cu8H25DwhSResd2" +
       "eht93tfaluqWdB0VSp7HLqy1HzMJDZJCigtbrNMdG0ablDtKOC3Rrin1eqje" +
       "1Kp4vOGSzLG8LOQkfcBs2PmsC5bOWjJytkSpWWe3xIgImCFJ5lsrv/7mtnzu" +
       "L3a3Ds+krSwir/j8m9jVSY99JzjcGCz+LkKnzjEd2xg8tg8L5R/yHr3TUbPi" +
       "I97nPvbyKwr/c+i5/T3gQQRdiVzv/Za6Ua1jXV3abV8fsvH9effvBVdnn43O" +
       "6f3JI6C335z84E5Qp/ajLxQEFw62AN/3Bo8gFXuueZuv5UVyePehYpCvnrHp" +
       "/S/y4rcj6O7i6zaQlRjtOjrS0ZffzD74");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("KTk9mL98Ely/vC+nX3575HQcwh+eUffv8uLrEXSfrkbsqX3zI4T/8q0izDf3" +
       "v7SP8EtvP8L/dEbdn+TFNyPo2iHCYxvwRxD/+K1CzD+W/cY+xN94+yG+fkbd" +
       "f8uLP4ugS7LoDA7OX5zaMr4kua6lis4R4m+/BcRFpMl9/Lf2Ef/W24N474jg" +
       "aznBHnRn2HvF17TvRtBVxdx9Z50UXzyTI4h/8RYgFhEs/+D5lX2IX3nblbp3" +
       "zxl1+Tf6vUsRdA+w26UauEch7BDf3uW3gO+B/OUj4PqDfXx/8Pbje+iMuofz" +
       "4kGgPYCPAjOOmhaHBz5/hO4db+r7YgR93x2PnOaH5x665eD77rC2/IVXrl1+" +
       "9yvTf7073nRwoPoKC13WYss6foji2P1FL1A1sxDAld2RCq9A9WQEPXLWnBRB" +
       "F3c3OYC9J3aNbkTQO2/bKILO5z/HaZ+JoOunaSPoQvF7nO45INkjOjDs7uY4" +
       "yfsj6C5Akt/e9HYut3cyOzh0pAe+lyqOJRRPnzieUfxXwsFRinj3fwkvyl98" +
       "hel/5PXqz+1OjMqWmGV5L5dZ6NLu8GrRaX4c48k79nbQ18Xus9+971evvOcg" +
       "Rblvx/CR9R7j7fHbn81s2V5UnKbMfv3d//CFX3jlj4rvef8XhB76AC4yAAA=");
}
