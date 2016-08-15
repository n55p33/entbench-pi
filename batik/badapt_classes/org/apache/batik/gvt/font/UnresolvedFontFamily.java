package org.apache.batik.gvt.font;
public class UnresolvedFontFamily implements org.apache.batik.gvt.font.GVTFontFamily {
    protected org.apache.batik.gvt.font.GVTFontFace fontFace;
    public UnresolvedFontFamily(org.apache.batik.gvt.font.GVTFontFace fontFace) {
        super(
          );
        this.
          fontFace =
          fontFace;
    }
    public UnresolvedFontFamily(java.lang.String familyName) { this(
                                                                 new org.apache.batik.gvt.font.GVTFontFace(
                                                                   familyName));
    }
    public org.apache.batik.gvt.font.GVTFontFace getFontFace() {
        return fontFace;
    }
    public java.lang.String getFamilyName() { return fontFace.
                                                getFamilyName(
                                                  ); }
    public org.apache.batik.gvt.font.GVTFont deriveFont(float size,
                                                        java.text.AttributedCharacterIterator aci) {
        return null;
    }
    public org.apache.batik.gvt.font.GVTFont deriveFont(float size,
                                                        java.util.Map attrs) {
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5r1/A7BHpqJ5HgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "aUX4kTYoAAA=");
}
