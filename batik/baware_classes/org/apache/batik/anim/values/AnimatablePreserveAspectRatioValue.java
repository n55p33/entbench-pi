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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "MzT33O2ae7thSTcOop6g+AFwuxuGVc2q5VMMUa+bIeD+DxzFkJ7raDc/818/" +
       "9zt//5lvgdDfgc7ne2LgxceCYD/KTtb+7stfeOLeF//4M/mOBQhM+Nvff+xD" +
       "Wa8vvTFYj2WwuPyAoCcGIZPvMBQ5Q3anmHgPcD3tb4w2vPZiuxTQ+MEfM54T" +
       "k41UVKfrghuvB4k8qJJ6p1nmhtUG3V1JDVxqbBxGTNjYtE3UI/sKu1g4zhKd" +
       "e0a5gm6I0mjUn2grvUmXqVLX69KNYWtoNUcCPgGrFbqjm5zWboJfRWIBynlh" +
       "3BCINVeHURk1DJTpVjqiHcFzGK5X4TrWdmqMasa9XocpjmcxhSKVxsRr9Q11" +
       "3vGQMdfuWs6k4+m9BJMmnApLip86GIl7bQ4vuuWe0BsHk6koD/uTZt8k5q2g" +
       "rJuJzK9cnms024gdilq5Z7Raxc2C5pnpiluuVrQeBROkPsR6jRZjD8yp3WME" +
       "es4Z7cWcaCw9XWta43G5E5JoCWvMDGHRiaptDkvhVlCFiaDEVEylvGhxrWIQ" +
       "pcNoJPSZscjE8aQTivOBNFOMVbpsCfOYEudeO6wYNkoQlYEzZyzNHbNFrFop" +
       "cKghC5smkgh9JLactO7RPQGRvZI5W00FZ1CciCFRcoQypVNdB1lQotlXZhLl" +
       "CqSLEe6mglaJir72LHeFiq1U9nRyJXNDk2tQrbU+ojq015kgiDqP7U2LHCz6" +
       "pTLTJhdm1JpIHadViorOiFXlaDGNTK7DDZDGqiUiajKnGgQutkm6gYvTLm1b" +
       "8yptNnm8MlJwdIqNi4ORQE2mvmJSXOyMOp0ZUedDfSPZ4+G4WPD0wEcIdjNf" +
       "zU3PC+Z1VywPZRvm3LkgDkclR5kmXWMpLWEWn9FjYtlxyGaoy6RA1zxb64yi" +
       "WZvm6VpolQhqQyC9pjNfdUrllaXzM5pGiEZ/BHCZqFawvRKGF5e0TPYbpkc2" +
       "12OPK9KSZSCa3neRMVVfTzodWSsaw4AYjvQ5JacUM6MmlNYXa5HhlMrVdFEt" +
       "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" +
       "Iku+F0JXZH17x8TnD/BeOYL46puAmMez");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("HwTfz+xD/Jm3XKk7O2fU5bPIX4bQfcBs54rvngpoOb6/ehP4HsoKnwDfz+/j" +
       "+/m3Ht/9Z9RdzZJLIKKG7vaKdqTk48qH8HYuv6E3DyH09Gs/A8weNL3jtnfK" +
       "27e10ldeunrp7S+N/8P2Nvzg/evlHnRJjSzr+MOAY/kLnq+oei6Ky9tnAl6O" +
       "79EQevysuSqELmwzGZKdR7aN3hlCj9yxUQjdk/07Tvt4CF07TQtmtvz/cbqn" +
       "gIcc0YFht5njJE+H0DlAkmWf8bbOt3Ny1XBocg+9lk6OLTSeOXFJnT8iP7hQ" +
       "jrbPyG9JX32p0//oq5Vf2L7ikywxTbNeLvWgi9sHhXmn2aX0u+7a20FfF9rP" +
       "fv+BX7r87oOlywNbho/s+BhvT935vVzT9sL8hVv662//lff/k5f+KL8r+381" +
       "navh3S8AAA==");
}
