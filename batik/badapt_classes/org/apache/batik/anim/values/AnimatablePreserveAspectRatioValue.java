package org.apache.batik.anim.values;
public class AnimatablePreserveAspectRatioValue extends org.apache.batik.anim.values.AnimatableValue {
    protected static final java.lang.String[] ALIGN_VALUES = { null, org.apache.batik.util.SVGConstants.
                                                                       SVG_NONE_VALUE,
    org.apache.batik.util.SVGConstants.
      SVG_XMINYMIN_VALUE,
    org.apache.batik.util.SVGConstants.
      SVG_XMIDYMIN_VALUE,
    org.apache.batik.util.SVGConstants.
      SVG_XMAXYMIN_VALUE,
    org.apache.batik.util.SVGConstants.
      SVG_XMINYMID_VALUE,
    org.apache.batik.util.SVGConstants.
      SVG_XMIDYMID_VALUE,
    org.apache.batik.util.SVGConstants.
      SVG_XMAXYMID_VALUE,
    org.apache.batik.util.SVGConstants.
      SVG_XMINYMAX_VALUE,
    org.apache.batik.util.SVGConstants.
      SVG_XMIDYMAX_VALUE,
    org.apache.batik.util.SVGConstants.
      SVG_XMAXYMAX_VALUE };
    protected static final java.lang.String[] MEET_OR_SLICE_VALUES =
      { null,
    org.apache.batik.util.SVGConstants.
      SVG_MEET_VALUE,
    org.apache.batik.util.SVGConstants.
      SVG_SLICE_VALUE };
    protected short align;
    protected short meetOrSlice;
    protected AnimatablePreserveAspectRatioValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatablePreserveAspectRatioValue(org.apache.batik.dom.anim.AnimationTarget target,
                                              short align,
                                              short meetOrSlice) {
        super(
          target);
        this.
          align =
          align;
        this.
          meetOrSlice =
          meetOrSlice;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatablePreserveAspectRatioValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatablePreserveAspectRatioValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatablePreserveAspectRatioValue)
                result;
        }
        short newAlign;
        short newMeetOrSlice;
        if (to !=
              null &&
              interpolation >=
              0.5) {
            org.apache.batik.anim.values.AnimatablePreserveAspectRatioValue toValue =
              (org.apache.batik.anim.values.AnimatablePreserveAspectRatioValue)
                to;
            newAlign =
              toValue.
                align;
            newMeetOrSlice =
              toValue.
                meetOrSlice;
        }
        else {
            newAlign =
              align;
            newMeetOrSlice =
              meetOrSlice;
        }
        if (res.
              align !=
              newAlign ||
              res.
                meetOrSlice !=
              newMeetOrSlice) {
            res.
              align =
              align;
            res.
              meetOrSlice =
              meetOrSlice;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public short getAlign() { return align;
    }
    public short getMeetOrSlice() { return meetOrSlice;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatablePreserveAspectRatioValue(
          target,
          org.w3c.dom.svg.SVGPreserveAspectRatio.
            SVG_PRESERVEASPECTRATIO_NONE,
          org.w3c.dom.svg.SVGPreserveAspectRatio.
            SVG_MEETORSLICE_MEET);
    }
    public java.lang.String toStringRep() {
        if (align <
              1 ||
              align >
              10) {
            return null;
        }
        java.lang.String value =
          ALIGN_VALUES[align];
        if (align ==
              org.w3c.dom.svg.SVGPreserveAspectRatio.
                SVG_PRESERVEASPECTRATIO_NONE) {
            return value;
        }
        if (meetOrSlice <
              1 ||
              meetOrSlice >
              2) {
            return null;
        }
        return value +
        ' ' +
        MEET_OR_SLICE_VALUES[meetOrSlice];
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "DNh/mRXfDaG7VWP7fWmUX7579Qjia28B");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Yh7Pvh88P7sP8WffdqXu7JzRl+8ifxVC9wKzlTTfPRXQcnx//RbwPZg1Pg6e" +
       "X9jH9wtvP777zui7khWXQEQN3e3nWU7L11UP4e1cflP3HULoqde/AphdZnrX" +
       "LXeUt/dqlS+/fOXSO18W/v32S/jB3dfLNHRJjyzr+KWAY/ULnq/pRi6Ky9sr" +
       "Al6O75EQeuysvSqELmwrGZKdh7eD3h1CD992UAjdlf07TvtYCF09TQt2tvz/" +
       "cbongYcc0YFlt5XjJE+F0DlAklWf9rbOt3Myazg0uQdfTyfHEo2nT3ygzi+Q" +
       "H3xMjrZXyG8qX3m5O/jIa9Vf3N7gUyw5TbNZLtHQxe1lwnzS7IP0e+4428Fc" +
       "FzrPfu/+X738zEHqcv+W4SM7Psbbk7e/K0fYXpjfbkt//Z3/9AO/9PIf59/J" +
       "/h/KjDVi2S8AAA==");
}
