package org.apache.batik.css.engine.value.svg;
public class TextRenderingManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OPTIMIZESPEED_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          OPTIMIZESPEED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_GEOMETRICPRECISION_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          GEOMETRICPRECISION_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_OPTIMIZELEGIBILITY_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                          OPTIMIZELEGIBILITY_VALUE);
    }
    public boolean isInheritedProperty() {
        return true;
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
                 CSS_TEXT_RENDERING_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public TextRenderingManager() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "oLYX5jcJNn902+de/3tPfjs/+fs/Hs9bQj8pAAA=");
}
