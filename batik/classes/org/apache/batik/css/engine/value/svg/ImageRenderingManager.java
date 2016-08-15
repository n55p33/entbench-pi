package org.apache.batik.css.engine.value.svg;
public class ImageRenderingManager extends org.apache.batik.css.engine.value.IdentifierManager {
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
                                                         CSS_IMAGE_RENDERING_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public ImageRenderingManager() { super(
                                       );
    }
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
      ("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");
}
