package org.apache.batik.css.engine.value.svg;
public class TextAnchorManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_START_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          START_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_MIDDLE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          MIDDLE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_END_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          END_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_TEXT_ANCHOR_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 START_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public TextAnchorManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "jSD9o9s//8jvPfWd/Njv/wCRu9joMykAAA==");
}
