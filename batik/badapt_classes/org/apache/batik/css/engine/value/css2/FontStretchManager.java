package org.apache.batik.css.engine.value.css2;
public class FontStretchManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_ALL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ALL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_CONDENSED_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          CONDENSED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_EXPANDED_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          EXPANDED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_EXTRA_CONDENSED_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          EXTRA_CONDENSED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_EXTRA_EXPANDED_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          EXTRA_EXPANDED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_NARROWER_VALUE, org.apache.batik.css.engine.value.ValueConstants.
                                                NARROWER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_NORMAL_VALUE, org.apache.batik.css.engine.value.ValueConstants.
                                              NORMAL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_SEMI_CONDENSED_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SEMI_CONDENSED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_SEMI_EXPANDED_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SEMI_EXPANDED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_ULTRA_CONDENSED_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ULTRA_CONDENSED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_ULTRA_EXPANDED_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ULTRA_EXPANDED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_WIDER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          WIDER_VALUE); }
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
                 CSS_FONT_STRETCH_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NORMAL_VALUE;
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value ==
              org.apache.batik.css.engine.value.ValueConstants.
                NARROWER_VALUE) {
            sm.
              putParentRelative(
                idx,
                true);
            org.apache.batik.css.engine.CSSStylableElement p =
              org.apache.batik.css.engine.CSSEngine.
              getParentCSSStylableElement(
                elt);
            if (p ==
                  null) {
                return org.apache.batik.css.engine.value.ValueConstants.
                         SEMI_CONDENSED_VALUE;
            }
            org.apache.batik.css.engine.value.Value v =
              engine.
              getComputedStyle(
                p,
                pseudo,
                idx);
            if (v ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    NORMAL_VALUE) {
                return org.apache.batik.css.engine.value.ValueConstants.
                         SEMI_CONDENSED_VALUE;
            }
            if (v ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    CONDENSED_VALUE) {
                return org.apache.batik.css.engine.value.ValueConstants.
                         EXTRA_CONDENSED_VALUE;
            }
            if (v ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    EXPANDED_VALUE) {
                return org.apache.batik.css.engine.value.ValueConstants.
                         SEMI_EXPANDED_VALUE;
            }
            if (v ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    SEMI_EXPANDED_VALUE) {
                return org.apache.batik.css.engine.value.ValueConstants.
                         NORMAL_VALUE;
            }
            if (v ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    SEMI_CONDENSED_VALUE) {
                return org.apache.batik.css.engine.value.ValueConstants.
                         CONDENSED_VALUE;
            }
            if (v ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    EXTRA_CONDENSED_VALUE) {
                return org.apache.batik.css.engine.value.ValueConstants.
                         ULTRA_CONDENSED_VALUE;
            }
            if (v ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    EXTRA_EXPANDED_VALUE) {
                return org.apache.batik.css.engine.value.ValueConstants.
                         EXPANDED_VALUE;
            }
            if (v ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    ULTRA_CONDENSED_VALUE) {
                return org.apache.batik.css.engine.value.ValueConstants.
                         ULTRA_CONDENSED_VALUE;
            }
            return org.apache.batik.css.engine.value.ValueConstants.
                     EXTRA_EXPANDED_VALUE;
        }
        else
            if (value ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    WIDER_VALUE) {
                sm.
                  putParentRelative(
                    idx,
                    true);
                org.apache.batik.css.engine.CSSStylableElement p =
                  org.apache.batik.css.engine.CSSEngine.
                  getParentCSSStylableElement(
                    elt);
                if (p ==
                      null) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             SEMI_CONDENSED_VALUE;
                }
                org.apache.batik.css.engine.value.Value v =
                  engine.
                  getComputedStyle(
                    p,
                    pseudo,
                    idx);
                if (v ==
                      org.apache.batik.css.engine.value.ValueConstants.
                        NORMAL_VALUE) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             SEMI_EXPANDED_VALUE;
                }
                if (v ==
                      org.apache.batik.css.engine.value.ValueConstants.
                        CONDENSED_VALUE) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             SEMI_CONDENSED_VALUE;
                }
                if (v ==
                      org.apache.batik.css.engine.value.ValueConstants.
                        EXPANDED_VALUE) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             EXTRA_EXPANDED_VALUE;
                }
                if (v ==
                      org.apache.batik.css.engine.value.ValueConstants.
                        SEMI_EXPANDED_VALUE) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             EXPANDED_VALUE;
                }
                if (v ==
                      org.apache.batik.css.engine.value.ValueConstants.
                        SEMI_CONDENSED_VALUE) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NORMAL_VALUE;
                }
                if (v ==
                      org.apache.batik.css.engine.value.ValueConstants.
                        EXTRA_CONDENSED_VALUE) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             CONDENSED_VALUE;
                }
                if (v ==
                      org.apache.batik.css.engine.value.ValueConstants.
                        EXTRA_EXPANDED_VALUE) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             ULTRA_EXPANDED_VALUE;
                }
                if (v ==
                      org.apache.batik.css.engine.value.ValueConstants.
                        ULTRA_CONDENSED_VALUE) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             EXTRA_CONDENSED_VALUE;
                }
                return org.apache.batik.css.engine.value.ValueConstants.
                         ULTRA_EXPANDED_VALUE;
            }
        return value;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public FontStretchManager() { super();
    }
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
      ("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");
}
