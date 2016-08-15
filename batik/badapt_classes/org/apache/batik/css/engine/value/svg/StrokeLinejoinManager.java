package org.apache.batik.css.engine.value.svg;
public class StrokeLinejoinManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_MITER_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          MITER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_ROUND_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          ROUND_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BEVEL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          BEVEL_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_STROKE_LINEJOIN_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 MITER_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public StrokeLinejoinManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "7nnnnJTJ9j2nZ0fjz2HPNnvsGpiwAcfmwLPBtsOG0ZuwGGsJM50qMfYsNt/3" +
       "m3AdxCqnGqsXBT7WpHbV5VroxDWw0AQcmw1P3FYzPnoLFWMtYYWflRh7CZuf" +
       "WBZazVI0o1gFu2OhBSPXqy69MNzz18BwjTg2Fx5qa09Hb7hirCWM80aJsV9j" +
       "c4aT8WC4jiRkSzjwM6uu7HGN8cv/hTGynDQWvPbDM+rUvP8irPtz6ZkjdZVT" +
       "jtx1TlTKuTvuGqh8UhlF8Z6iPO/lusFSslCwxjpT6eLrHU7mfa77SQg/0ApN" +
       "zlms73EyZ0RWOFoN5mBkM57nZHoJRjhaWS9enj9ASi3EA2JB66X8EHZ/kBKk" +
       "EN9euo84qXbpYFHrxUvyMcwOJPh6UXc2zk0jm8uFje3PbMh//srBqHEkGHmO" +
       "bHN9dar4Q8sp5DLWX1q90skjnevuvfyFJ637PEmhO3bgLOOgfLNuDXMnljlF" +
       "Z3PmKl+78Mr4U1XznLrSd5/olU2AGXKRuHubFrjgMlty91zvHl3+4q/2lr8F" +
       "FfFmEqJwMticf3eQ1TNwVNwcyy9T4XQnbt5aFz42vGJJ6q/vidsZkncnE6Tv" +
       "lc4eu+ftA1OPNoXJuA4yFkpmlhWXGquH1Q1MGjTipFY212RBRPQbVXw18Hjc" +
       "YRRziLCLbc7aXC9e9HLSnF/Z51+PVyvaEDNWaRk1idNAFT3O7XFOrr5DX0bX" +
       "Awxuj+cwk7UKBfQGQLY31qXrzi3pmE5dRJvhwpUDtp+JV2yu/hdDOMpz7B4A" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
