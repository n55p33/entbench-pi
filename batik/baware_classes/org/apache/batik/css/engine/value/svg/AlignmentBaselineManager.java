package org.apache.batik.css.engine.value.svg;
public class AlignmentBaselineManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AFTER_EDGE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AFTER_EDGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_ALPHABETIC_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          ALPHABETIC_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BASELINE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          BASELINE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BEFORE_EDGE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          BEFORE_EDGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_HANGING_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          HANGING_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_IDEOGRAPHIC_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          IDEOGRAPHIC_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_MATHEMATICAL_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                    MATHEMATICAL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_MIDDLE_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                              MIDDLE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_TEXT_AFTER_EDGE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TEXT_AFTER_EDGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_TEXT_BEFORE_EDGE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TEXT_BEFORE_EDGE_VALUE);
    }
    public boolean isInheritedProperty() {
        return false;
    }
    public boolean isAnimatableProperty() {
        return true;
    }
    public boolean isAdditiveProperty() {
        return false;
    }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT;
    }
    public java.lang.String getPropertyName() {
        return org.apache.batik.util.CSSConstants.
                 CSS_ALIGNMENT_BASELINE_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public AlignmentBaselineManager() { super(
                                          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "jPgeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XvTZV/7eE9/KTwD/D+an3YZTKQAA");
}
