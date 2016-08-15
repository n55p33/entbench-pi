package org.apache.batik.css.engine.value.svg;
public class DominantBaselineManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_ALPHABETIC_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          ALPHABETIC_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_CENTRAL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          CENTRAL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_HANGING_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          HANGING_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_IDEOGRAPHIC_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          IDEOGRAPHIC_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_MATHEMATICAL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          MATHEMATICAL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_MIDDLE_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                              MIDDLE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_NO_CHANGE_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                 NO_CHANGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_RESET_SIZE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          RESET_SIZE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_TEXT_AFTER_EDGE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TEXT_AFTER_EDGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_TEXT_BEFORE_EDGE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TEXT_BEFORE_EDGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_TEXT_BOTTOM_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TEXT_BOTTOM_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_TEXT_TOP_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TEXT_TOP_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_USE_SCRIPT_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          USE_SCRIPT_VALUE);
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
                 CSS_DOMINANT_BASELINE_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public DominantBaselineManager() { super(
                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
