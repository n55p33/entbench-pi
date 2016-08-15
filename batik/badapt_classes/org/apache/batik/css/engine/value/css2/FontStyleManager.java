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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UVreIdj99os+++O//sQ3yjO//wPKiBxQMCkAAA==");
}
