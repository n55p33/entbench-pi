package org.apache.batik.css.engine.value.svg;
public class ShapeRenderingManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_CRISPEDGES_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          CRISPEDGES_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_GEOMETRICPRECISION_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          GEOMETRICPRECISION_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OPTIMIZESPEED_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          OPTIMIZESPEED_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_SHAPE_RENDERING_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public ShapeRenderingManager() { super(
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
       "JuVVgt0vvfbnv/1nnvtyefT3v+DF8JNDKQAA");
}
