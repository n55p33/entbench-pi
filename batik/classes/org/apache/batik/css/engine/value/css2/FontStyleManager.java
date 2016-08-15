package org.apache.batik.css.engine.value.css2;
public class FontStyleManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_ALL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ALL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_ITALIC_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ITALIC_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NORMAL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NORMAL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OBLIQUE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          OBLIQUE_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FONT_STYLE_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NORMAL_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public FontStyleManager() { super(); }
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
       "m5/5/R8cEOhhMCkAAA==");
}
