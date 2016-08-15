package org.apache.batik.css.engine.value.svg;
public class PointerEventsManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_ALL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          ALL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_FILL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          FILL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_FILLSTROKE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          FILLSTROKE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NONE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          NONE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_PAINTED_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          PAINTED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_STROKE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          STROKE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_VISIBLE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          VISIBLE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_VISIBLEFILL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          VISIBLEFILL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_VISIBLEFILLSTROKE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          VISIBLEFILLSTROKE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_VISIBLEPAINTED_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                      VISIBLEPAINTED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_VISIBLESTROKE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          VISIBLESTROKE_VALUE); }
    public boolean isInheritedProperty() { return true;
    }
    public boolean isAnimatableProperty() { return true;
    }
    public boolean isAdditiveProperty() { return false;
    }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT;
    }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_POINTER_EVENTS_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 VISIBLEPAINTED_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public PointerEventsManager() { super(
                                      ); }
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
       "rTz1+19DLZFAOykAAA==");
}
