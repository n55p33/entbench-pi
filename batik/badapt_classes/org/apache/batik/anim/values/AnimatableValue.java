package org.apache.batik.anim.values;
public abstract class AnimatableValue {
    protected static java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat(
      ("0.0#########################################################" +
       "##"),
      new java.text.DecimalFormatSymbols(
        java.util.Locale.
          ENGLISH));
    protected org.apache.batik.dom.anim.AnimationTarget target;
    protected boolean hasChanged = true;
    protected AnimatableValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          );
        this.
          target =
          target;
    }
    public static java.lang.String formatNumber(float f) {
        return decimalFormat.
          format(
            f);
    }
    public abstract org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                             org.apache.batik.anim.values.AnimatableValue to,
                                                                             float interpolation,
                                                                             org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                             int multiplier);
    public abstract boolean canPace();
    public abstract float distanceTo(org.apache.batik.anim.values.AnimatableValue other);
    public abstract org.apache.batik.anim.values.AnimatableValue getZeroValue();
    public java.lang.String getCssText() {
        return null;
    }
    public boolean hasChanged() { boolean ret =
                                    hasChanged;
                                  hasChanged =
                                    false;
                                  return ret;
    }
    public java.lang.String toStringRep() {
        return getCssText(
                 );
    }
    public java.lang.String toString() { return getClass(
                                                  ).
                                           getName(
                                             ) +
                                         "[" +
                                         toStringRep(
                                           ) +
                                         "]";
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
       "//DffuV3yoPR/wehBGEjpywAAA==");
}
