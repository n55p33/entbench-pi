package org.apache.batik.css.engine.value.svg;
public class ColorRenderingManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OPTIMIZEQUALITY_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          OPTIMIZEQUALITY_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OPTIMIZESPEED_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          OPTIMIZESPEED_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_COLOR_RENDERING_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public ColorRenderingManager() { super(
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
      ("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" +
       "Jcj+8PmffcXvPv6t4ujv/wDn+6AVQykAAA==");
}
