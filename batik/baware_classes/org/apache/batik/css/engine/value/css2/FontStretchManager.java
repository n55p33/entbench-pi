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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ABLEkxfqL8Y6h4X9hVM4e/9lqDnX7WWgOVsRQL6kLvMPXcKW95VW/ih4a8fY" +
       "UruMLVegKvOxiuWZKr1ZJh+uxuSeBHowiPwESKmD+O5aXAWmCZDE8mSn6ux5" +
       "UFwtOXHF/K4Eqr3x6nQI8oAvHaCtTFtlgh8con1H53mh6jK/AjDmvuYRdlQv" +
       "/7N3EL7M/sUyGZQJeSLue2xHvXmCOwsQVwO3uWk72In8NyqPLwfoWM5LQj7/" +
       "5xYSePQjZ42xPohrP/2fPvv1v/Pst4DbMdB9lTGAt53rkU/LUP9nvvS5J3/o" +
       "lW9/ugJVgKiLv/GDJz5Wtjp/c6o+UaoqVnELK8cJV2GfrlXa3nW2TSLLBctF" +
       "dhzHwi8/9q3tL/3Rlw8x6uWpdYlY/9Qrf+vPjj7zytVzXwbP3hKcn+c5fB1U" +
       "Qr/j2MIR9Mzdeqk4yD/86sv/9O+//MmDVI9djHMH4DPuy//2/3z96PPf/p3b" +
       "hFD3Ov5bGNjkej5EYho/ediG1F/15g1hWUt3Hkqj+JQgcBgRYaMzHqc+PxPn" +
       "RDgQcFrZ93pb0SHEtAlnklnrbHQ4byWNrdGeh/VckcPpzqLtaKT1fWRJR8S4" +
       "H3Xjha8G22WozWVnmaSEoje4UBKWQdhoBlQ0SfVadzOrKS3JkupBA9W6sK53" +
       "2l20pmMoihZd2HS4mK6LOD/T19NJm9tzycjqGLnvisU0avSnrSlZa3VJnIFV" +
       "fWk105U5cCQydzXflTFh0FqObM5Zr2QhVJhQDYNRQRbsEqfRsZG7XDieqI4z" +
       "S+tWV2FlR5svlxLfThnBEJWRQNn03vR6yX7C8ZJb1HtMg7fpgTMXe4w2NPPU" +
       "CshQ1LjhajJihhnjFjtTDJJmYzZAw3UjCYZIw01H+WCNsYyL0ZQrd6P9lsj8" +
       "bEDvYZZeuMtcWbOLWF2gTGCicSr3QxiEvio9WLfdUHb2vtRGvSBU6vFc5Bqs" +
       "1WWnAet2M2ZRdxibLuqD4USkhtzSVkfWfGHP65rs4Kkz5GbLmZLIg3Gyl8L5" +
       "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");
}
