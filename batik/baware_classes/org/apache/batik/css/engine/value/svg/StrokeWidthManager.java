package org.apache.batik.css.engine.value.svg;
public class StrokeWidthManager extends org.apache.batik.css.engine.value.LengthManager {
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_LENGTH_OR_INHERIT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_STROKE_WIDTH_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NUMBER_1;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (lu.
              getLexicalUnitType(
                ) ==
              org.w3c.css.sac.LexicalUnit.
                SAC_INHERIT) {
            return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                     INHERIT_VALUE;
        }
        return super.
          createValue(
            lu,
            engine);
    }
    protected int getOrientation() { return BOTH_ORIENTATION;
    }
    public StrokeWidthManager() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "9B/JfLV5Ax4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
