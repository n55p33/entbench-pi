package org.apache.batik.transcoder.wmf.tosvg;
public class WMFUtilities {
    public static java.lang.String decodeString(org.apache.batik.transcoder.wmf.tosvg.WMFFont wmfFont,
                                                byte[] bstr) { try {
                                                                   switch (wmfFont.
                                                                             charset) {
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_ANSI:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_ANSI);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_DEFAULT:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_DEFAULT);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_SHIFTJIS:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_SHIFTJIS);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_HANGUL:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_HANGUL);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_JOHAB:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_JOHAB);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_GB2312:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_GB2312);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_CHINESEBIG5:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_CHINESEBIG5);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_GREEK:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_GREEK);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_TURKISH:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_TURKISH);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_VIETNAMESE:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_VIETNAMESE);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_HEBREW:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_HEBREW);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_ARABIC:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_ARABIC);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_RUSSIAN:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_CYRILLIC);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_THAI:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_THAI);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_EASTEUROPE:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_EASTEUROPE);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_OEM:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_OEM);
                                                                       default:
                                                                   }
                                                               }
                                                               catch (java.io.UnsupportedEncodingException e) {
                                                                   
                                                               }
                                                               return new java.lang.String(
                                                                 bstr);
    }
    public static int getHorizontalAlignment(int align) {
        int v =
          align;
        v =
          v %
            org.apache.batik.transcoder.wmf.WMFConstants.
              TA_BASELINE;
        v =
          v %
            org.apache.batik.transcoder.wmf.WMFConstants.
              TA_BOTTOM;
        if (v >=
              6)
            return org.apache.batik.transcoder.wmf.WMFConstants.
                     TA_CENTER;
        else
            if (v >=
                  2)
                return org.apache.batik.transcoder.wmf.WMFConstants.
                         TA_RIGHT;
            else
                return org.apache.batik.transcoder.wmf.WMFConstants.
                         TA_LEFT;
    }
    public static int getVerticalAlignment(int align) {
        int v =
          align;
        if (v /
              org.apache.batik.transcoder.wmf.WMFConstants.
                TA_BASELINE !=
              0)
            return org.apache.batik.transcoder.wmf.WMFConstants.
                     TA_BASELINE;
        v =
          v %
            org.apache.batik.transcoder.wmf.WMFConstants.
              TA_BASELINE;
        if (v /
              org.apache.batik.transcoder.wmf.WMFConstants.
                TA_BOTTOM !=
              0)
            return org.apache.batik.transcoder.wmf.WMFConstants.
                     TA_BOTTOM;
        else
            return org.apache.batik.transcoder.wmf.WMFConstants.
                     TA_TOP;
    }
    public WMFUtilities() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "PcZfsTn+H4JMhw0YHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
