package org.apache.batik.anim.values;
public class AnimatableLengthValue extends org.apache.batik.anim.values.AnimatableValue {
    protected static final java.lang.String[] UNITS = { "", "%", "em", "ex",
    "px",
    "cm",
    "mm",
    "in",
    "pt",
    "pc" };
    protected short lengthType;
    protected float lengthValue;
    protected short percentageInterpretation;
    protected AnimatableLengthValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableLengthValue(org.apache.batik.dom.anim.AnimationTarget target,
                                 short type,
                                 float v,
                                 short pcInterp) { super(
                                                     target);
                                                   lengthType =
                                                     type;
                                                   lengthValue =
                                                     v;
                                                   percentageInterpretation =
                                                     pcInterp;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableLengthValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableLengthValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableLengthValue)
                result;
        }
        short oldLengthType =
          res.
            lengthType;
        float oldLengthValue =
          res.
            lengthValue;
        short oldPercentageInterpretation =
          res.
            percentageInterpretation;
        res.
          lengthType =
          lengthType;
        res.
          lengthValue =
          lengthValue;
        res.
          percentageInterpretation =
          percentageInterpretation;
        if (to !=
              null) {
            org.apache.batik.anim.values.AnimatableLengthValue toLength =
              (org.apache.batik.anim.values.AnimatableLengthValue)
                to;
            float toValue;
            if (!compatibleTypes(
                   res.
                     lengthType,
                   res.
                     percentageInterpretation,
                   toLength.
                     lengthType,
                   toLength.
                     percentageInterpretation)) {
                res.
                  lengthValue =
                  target.
                    svgToUserSpace(
                      res.
                        lengthValue,
                      res.
                        lengthType,
                      res.
                        percentageInterpretation);
                res.
                  lengthType =
                  org.w3c.dom.svg.SVGLength.
                    SVG_LENGTHTYPE_NUMBER;
                toValue =
                  toLength.
                    target.
                    svgToUserSpace(
                      toLength.
                        lengthValue,
                      toLength.
                        lengthType,
                      toLength.
                        percentageInterpretation);
            }
            else {
                toValue =
                  toLength.
                    lengthValue;
            }
            res.
              lengthValue +=
              interpolation *
                (toValue -
                   res.
                     lengthValue);
        }
        if (accumulation !=
              null) {
            org.apache.batik.anim.values.AnimatableLengthValue accLength =
              (org.apache.batik.anim.values.AnimatableLengthValue)
                accumulation;
            float accValue;
            if (!compatibleTypes(
                   res.
                     lengthType,
                   res.
                     percentageInterpretation,
                   accLength.
                     lengthType,
                   accLength.
                     percentageInterpretation)) {
                res.
                  lengthValue =
                  target.
                    svgToUserSpace(
                      res.
                        lengthValue,
                      res.
                        lengthType,
                      res.
                        percentageInterpretation);
                res.
                  lengthType =
                  org.w3c.dom.svg.SVGLength.
                    SVG_LENGTHTYPE_NUMBER;
                accValue =
                  accLength.
                    target.
                    svgToUserSpace(
                      accLength.
                        lengthValue,
                      accLength.
                        lengthType,
                      accLength.
                        percentageInterpretation);
            }
            else {
                accValue =
                  accLength.
                    lengthValue;
            }
            res.
              lengthValue +=
              multiplier *
                accValue;
        }
        if (oldPercentageInterpretation !=
              res.
                percentageInterpretation ||
              oldLengthType !=
              res.
                lengthType ||
              oldLengthValue !=
              res.
                lengthValue) {
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public static boolean compatibleTypes(short t1,
                                          short pi1,
                                          short t2,
                                          short pi2) {
        return t1 ==
          t2 &&
          (t1 !=
             org.w3c.dom.svg.SVGLength.
               SVG_LENGTHTYPE_PERCENTAGE ||
             pi1 ==
             pi2) ||
          t1 ==
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_NUMBER &&
          t2 ==
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_PX ||
          t1 ==
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_PX &&
          t2 ==
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_NUMBER;
    }
    public int getLengthType() { return lengthType;
    }
    public float getLengthValue() { return lengthValue;
    }
    public boolean canPace() { return true;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableLengthValue o =
          (org.apache.batik.anim.values.AnimatableLengthValue)
            other;
        float v1 =
          target.
          svgToUserSpace(
            lengthValue,
            lengthType,
            percentageInterpretation);
        float v2 =
          target.
          svgToUserSpace(
            o.
              lengthValue,
            o.
              lengthType,
            o.
              percentageInterpretation);
        return java.lang.Math.
          abs(
            v1 -
              v2);
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableLengthValue(
          target,
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_NUMBER,
          0.0F,
          percentageInterpretation);
    }
    public java.lang.String getCssText() {
        return formatNumber(
                 lengthValue) +
        UNITS[lengthType -
                1];
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "PoPb4HDx8hONlH9uGca3y/8DByCH7U0kAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16aazs1nkY79PbtbwnybIVWcuT9OxYHudyVpLT542zcThD" +
       "zsoZztBxnrmTw30dDl3ViZHERtO6RiOnSpAIKGB3CWQ7KBy0QJxCRpfITWA0" +
       "TtAmBRKlRYomdQ1YP5IUddL0kHP3d9+1FAm9AM89c853zvn27zvLy9+FLgQ+" +
       "VHAdc6OaTrgrJ+HuyqzthhtXDnZ7VG3E+4EsNU0+CBjQdlt85leu/fn3P69d" +
       "Pwdd5KCHedt2Qj7UHTuYyIFjxrJEQdcOW9umbAUhdJ1a8TEPR6FuwpQehLco" +
       "6N4jQ0PoJrWPAgxQgAEKcI4CjB9CgUH3y3ZkNbMRvB0GHvR3oB0KuuiKGXoh" +
       "9PTxSVze5629aUY5BWCGy9nvOSAqH5z40I0D2rc030HwFwrwC//ox67/i3ug" +
       "axx0TbenGToiQCIEi3DQfZZsCbIf4JIkSxz0oC3L0lT2dd7U0xxvDnoo0FWb" +
       "DyNfPmBS1hi5sp+veci5+8SMNj8SQ8c/IE/RZVPa/3VBMXkV0PrOQ1q3FHay" +
       "dkDgVR0g5iu8KO8POW/othRCT50ccUDjzT4AAEMvWXKoOQdLnbd50AA9tJWd" +
       "ydsqPA193VYB6AUnAquE0GN3nTTjtcuLBq/Kt0Po0ZNwo20XgLqSMyIbEkKP" +
       "nATLZwJSeuyElI7I57uDD37uk3bXPpfjLMmimeF/GQx68sSgiazIvmyL8nbg" +
       "fe+nfo5/569/9hwEAeBHTgBvYf7l3379ox948pVXtzDvPgVmKKxkMbwtflF4" +
       "4Lcfbz5XvydD47LrBHom/GOU5+o/2uu5lbjA8t55MGPWubvf+crk3y9//Jfl" +
       "75yDrpLQRdExIwvo0YOiY7m6KfuEbMs+H8oSCV2RbamZ95PQJVCndFvetg4V" +
       "JZBDEjpv5k0Xnfw3YJECpshYdAnUdVtx9usuH2p5PXEhCLoEPug+8D0Fbf/y" +
       "/yEkw5pjyTAv8rZuO/DIdzL6A1i2QwHwVoMFoPUGHDiRD1QQdnwV5oEeaPJe" +
       "BxhmwTFvRrlx6xYf8oIpU7Kthto8a97N1M39/7VQklF8fb2zA4Tx+ElXYAIr" +
       "6jqmJPu3xReiRvv1r9z+zXMHprHHqxAqg7V3t2vv5mvvZmvvbtfePXVtaGcn" +
       "X/IdGQ5b2QPJGcAHAO9433PTj/c+8dln7gFK567PA7afA6Dw3Z1089BrkLlv" +
       "FIHqQq+8uP6J+aeK56Bzx71thjdoupoNH2U+8sAX3jxpZafNe+0zf/LnX/25" +
       "551DezvmvvfcwJ0jMzN+5iSHfUeUJeAYD6d//w3+V2//+vM3z0HngW8A/jDk" +
       "gf4CV/PkyTWOmfOtfdeY0XIBEKw4vsWbWde+P7saar6zPmzJRf9AXn8Q8PiB" +
       "TL+fBd8H9xQ+/5/1Puxm5Tu2qpIJ7QQVuev90NT9pd/71p9Wcnbve+lrR+Le" +
       "VA5vHfEM2WTXch/w4KEOML4sA7g/eHH0s1/47mc+lisAgHj2tAVvZmUTeAQg" +
       "QsDmn3rV+/3X/vCLv3vuQGl2QuiK6zshsBpZSg7ozLqg+8+gEyz43kOUgHMx" +
       "wQyZ4tyc2ZYj6YqeKzNQ1L+89p7Sr/6vz13fqoIJWvY16QM/eILD9h9qQD/+" +
       "mz/2F0/m0+yIWXA7ZNsh2NZjPnw4M+77/CbDI/mJbz/x87/B/xLwvcDfBXoq" +
       "5y5sZ8uGnPJHQui5O8xUcqytqW5tFKzB8L4qh7mk4Xzc+/NyN2NRPhuU91Wy" +
       "4qngqMUcN8ojactt8fO/+73759/716/n9B3Pe44qCM27t7Y6mRU3EjD9u066" +
       "hy4faACu+srgR6+br3wfzMiBGUXgAIOhD/xUckyd9qAvXPov3/g37/zEb98D" +
       "netAV02Hlzp8bpnQFWAScqABF5e4H/noVh3Wl0FxPScVuoP4vOGxA126N2u8" +
       "Ab7mni41T7eZrHw6L29mxQ/v6+dFNxJMXTyhnFfPmPCEUM7nM53PfhYBv547" +
       "I5H1dQsYXrwX/OHnH3rN+MU/+fI2sJ/MFE4Ay5994e/+9e7nXjh3JJ169o6M" +
       "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" +
       "33ey4o9D6IEDAg9P/A8p/O9vgcKHoT3V");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("/toehV97+yn8szP6/iIrvgcUU+TtES/mpH37kLTX36rwMu/29T3Svv72kLZz" +
       "CPCNDGBn5+707eQx5S9D6Kqkb6/gGOeE9P7qLZCY++4fBt+reyS++rZLb+f+" +
       "M/quZcXlELoP6Ccn+86h8z6gb+fKW6DvoawxczC/s0ff77z99P3QGX3vzop3" +
       "AOkB+pog1spJfq+sHlL3yJt6ChJCj5z6VDJ79PXoHY+0tw+Lxa+8dO3yu16a" +
       "/eft84D9x79XKOiyEpnm0ScSR+oXXV9W9Jz4K9sHE25O0TMh9PhZkTiELm4r" +
       "GfI7T28HvQfgfeqgEDqf/TsK+74Qun4SNoQu5P+PwhUAVw/hwLLbylGQ3RC6" +
       "B4BkVdjdmtvO8ZzowIge+kFiOJJGPXvs1j5/Qb9/wx5t39DfFr/6Um/wydeR" +
       "L21fOoomn6bZLJcp6NL20WU+aXZL//RdZ9uf62L3ue8/8CtX3rOfmD2wRfhQ" +
       "c4/g9tTpbwrblhvmrwDTf/Wur33wn770h/nt4f8DAZ31+towAAA=");
}
