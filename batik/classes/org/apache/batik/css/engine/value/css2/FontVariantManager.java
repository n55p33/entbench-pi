package org.apache.batik.css.engine.value.css2;
public class FontVariantManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_NORMAL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NORMAL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SMALL_CAPS_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SMALL_CAPS_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FONT_VARIANT_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NORMAL_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public FontVariantManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3yRI/+iOz73+9576dn7y938WWemvPCkAAA==");
}
