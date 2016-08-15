package org.apache.batik.css.engine.value.svg;
public class WritingModeManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_LR_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                                           LR_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LR_TB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          LR_TB_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_RL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          RL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_RL_TB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          RL_TB_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_TB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TB_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_TB_RL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TB_RL_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return false; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_WRITING_MODE_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 LR_TB_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public WritingModeManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "YP+P3/HrH/6Hr3yrOvf7f6eTUMg3KQAA");
}
