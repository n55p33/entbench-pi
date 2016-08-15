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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "P/jw33nld8qD0f8HydaoJacsAAA=");
}
