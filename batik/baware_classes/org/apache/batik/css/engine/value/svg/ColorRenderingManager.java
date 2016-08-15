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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9a+85eee/XJ57Pe/n51knD8pAAA=");
}
