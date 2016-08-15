package org.apache.batik.gvt.font;
public class AWTFontFamily implements org.apache.batik.gvt.font.GVTFontFamily {
    public static final java.text.AttributedCharacterIterator.Attribute TEXT_COMPOUND_DELIMITER =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXT_COMPOUND_DELIMITER;
    protected org.apache.batik.gvt.font.GVTFontFace fontFace;
    protected java.awt.Font font;
    public AWTFontFamily(org.apache.batik.gvt.font.GVTFontFace fontFace) {
        super(
          );
        this.
          fontFace =
          fontFace;
    }
    public AWTFontFamily(java.lang.String familyName) { this(new org.apache.batik.gvt.font.GVTFontFace(
                                                               familyName));
    }
    public AWTFontFamily(org.apache.batik.gvt.font.GVTFontFace fontFace,
                         java.awt.Font font) { super();
                                               this.fontFace =
                                                 fontFace;
                                               this.font =
                                                 font; }
    public java.lang.String getFamilyName() { return fontFace.
                                                getFamilyName(
                                                  ); }
    public org.apache.batik.gvt.font.GVTFontFace getFontFace() {
        return fontFace;
    }
    public org.apache.batik.gvt.font.GVTFont deriveFont(float size,
                                                        java.text.AttributedCharacterIterator aci) {
        if (font !=
              null)
            return new org.apache.batik.gvt.font.AWTGVTFont(
              font,
              size);
        return deriveFont(
                 size,
                 aci.
                   getAttributes(
                     ));
    }
    public org.apache.batik.gvt.font.GVTFont deriveFont(float size,
                                                        java.util.Map attrs) {
        if (font !=
              null)
            return new org.apache.batik.gvt.font.AWTGVTFont(
              font,
              size);
        java.util.Map fontAttributes =
          new java.util.HashMap(
          attrs);
        fontAttributes.
          put(
            java.awt.font.TextAttribute.
              SIZE,
            new java.lang.Float(
              size));
        fontAttributes.
          put(
            java.awt.font.TextAttribute.
              FAMILY,
            fontFace.
              getFamilyName(
                ));
        fontAttributes.
          remove(
            TEXT_COMPOUND_DELIMITER);
        return new org.apache.batik.gvt.font.AWTGVTFont(
          fontAttributes);
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
      ("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");
}
