package org.apache.batik.css.engine;
public class FontFaceRule implements org.apache.batik.css.engine.Rule {
    public static final short TYPE = (short) 3;
    org.apache.batik.css.engine.StyleMap sm;
    org.apache.batik.util.ParsedURL purl;
    public FontFaceRule(org.apache.batik.css.engine.StyleMap sm, org.apache.batik.util.ParsedURL purl) {
        super(
          );
        this.
          sm =
          sm;
        this.
          purl =
          purl;
    }
    public short getType() { return TYPE; }
    public org.apache.batik.util.ParsedURL getURL() { return purl;
    }
    public org.apache.batik.css.engine.StyleMap getStyleMap() { return sm;
    }
    public java.lang.String toString(org.apache.batik.css.engine.CSSEngine eng) {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        sb.
          append(
            "@font-face { ");
        sb.
          append(
            sm.
              toString(
                eng));
        sb.
          append(
            " }\n");
        return sb.
          toString(
            );
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
      ("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" +
       "d/zhwx9+4pvFzdf/Ah5jSvH4JgAA");
}
