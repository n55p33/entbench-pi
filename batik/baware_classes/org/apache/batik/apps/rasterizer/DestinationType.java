package org.apache.batik.apps.rasterizer;
public final class DestinationType {
    public static final java.lang.String PNG_STR = "image/png";
    public static final java.lang.String JPEG_STR = "image/jpeg";
    public static final java.lang.String TIFF_STR = "image/tiff";
    public static final java.lang.String PDF_STR = "application/pdf";
    public static final int PNG_CODE = 0;
    public static final int JPEG_CODE = 1;
    public static final int TIFF_CODE = 2;
    public static final int PDF_CODE = 3;
    public static final java.lang.String PNG_EXTENSION = ".png";
    public static final java.lang.String JPEG_EXTENSION = ".jpg";
    public static final java.lang.String TIFF_EXTENSION = ".tif";
    public static final java.lang.String PDF_EXTENSION = ".pdf";
    public static final org.apache.batik.apps.rasterizer.DestinationType PNG =
      new org.apache.batik.apps.rasterizer.DestinationType(
      PNG_STR,
      PNG_CODE,
      PNG_EXTENSION);
    public static final org.apache.batik.apps.rasterizer.DestinationType JPEG =
      new org.apache.batik.apps.rasterizer.DestinationType(
      JPEG_STR,
      JPEG_CODE,
      JPEG_EXTENSION);
    public static final org.apache.batik.apps.rasterizer.DestinationType TIFF =
      new org.apache.batik.apps.rasterizer.DestinationType(
      TIFF_STR,
      TIFF_CODE,
      TIFF_EXTENSION);
    public static final org.apache.batik.apps.rasterizer.DestinationType PDF =
      new org.apache.batik.apps.rasterizer.DestinationType(
      PDF_STR,
      PDF_CODE,
      PDF_EXTENSION);
    private java.lang.String type;
    private int code;
    private java.lang.String extension;
    private DestinationType(java.lang.String type, int code, java.lang.String extension) {
        super(
          );
        this.
          type =
          type;
        this.
          code =
          code;
        this.
          extension =
          extension;
    }
    public java.lang.String getExtension() { return extension; }
    public java.lang.String toString() { return type; }
    public int toInt() { return code; }
    protected org.apache.batik.transcoder.Transcoder getTranscoder() {
        switch (code) {
            case PNG_CODE:
                return (org.apache.batik.transcoder.image.PNGTranscoder)
                         ent.runtime.ENT_Runtime.
                         putObj(
                           new org.apache.batik.transcoder.image.PNGTranscoder(
                             ),
                           new java.lang.Integer[] { org.apache.batik.apps.rasterizer.EntMode.
                                                       DYNAMIC_MODE });
            case JPEG_CODE:
                return (org.apache.batik.transcoder.image.JPEGTranscoder)
                         ent.runtime.ENT_Runtime.
                         putObj(
                           new org.apache.batik.transcoder.image.JPEGTranscoder(
                             ),
                           new java.lang.Integer[] { org.apache.batik.apps.rasterizer.EntMode.
                                                       DYNAMIC_MODE });
            case TIFF_CODE:
                return (org.apache.batik.transcoder.image.TIFFTranscoder)
                         ent.runtime.ENT_Runtime.
                         putObj(
                           new org.apache.batik.transcoder.image.TIFFTranscoder(
                             ),
                           new java.lang.Integer[] { org.apache.batik.apps.rasterizer.EntMode.
                                                       DYNAMIC_MODE });
            case PDF_CODE:
                try {
                    java.lang.Class pdfClass =
                      java.lang.Class.
                      forName(
                        "org.apache.fop.svg.PDFTranscoder");
                    return (org.apache.batik.transcoder.Transcoder)
                             pdfClass.
                             newInstance(
                               );
                }
                catch (java.lang.Exception e) {
                    return null;
                }
            default:
                return null;
        }
    }
    public org.apache.batik.apps.rasterizer.DestinationType[] getValues() {
        return new org.apache.batik.apps.rasterizer.DestinationType[] { PNG,
        JPEG,
        TIFF,
        PDF };
    }
    public java.lang.Object readResolve() {
        switch (code) {
            case PNG_CODE:
                return PNG;
            case JPEG_CODE:
                return JPEG;
            case TIFF_CODE:
                return TIFF;
            case PDF_CODE:
                return PDF;
            default:
                throw new java.lang.Error(
                  "unknown code:" +
                  code);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KPd6kevWEMdUjYq82hxATdNsGwnZSWNt2rav9ecrcqORMUubbPT25dc1wIbE" +
       "gDpUaGgzIxU6FeLWna+MTzo2Rc0DEls7A1+FdtKMVHtWl3jINSXn8pt5YUt8" +
       "4HB12eTDV79mWkPmUlUlTI8SKVl2HsM4vks1nSYkrthK81CGHz2GVEZmnWvt" +
       "y2Cekv3Bx1IxO0PNxLydYXaO/5xtU6BIb1tIEfy/sx1oo9xux0ip+eFsshtW" +
       "UdAEP6/TfEcpHXLPejODRiaea9AcE+UGl0/zW4uZIJIy7y0OiCcOr+/afXb5" +
       "PeaFDVEWdu1CKhXgfubdkeyEcrYvtQyt0nXzPx334Ni5mRBUawps+8M022hJ" +
       "L/irhqYy1XOZwWjM3ml448iqx1/YV/oyhJtNJCQwMn5T7oFfWkvBTH5TR+7B" +
       "N0Qnfsuief5Pdl6+MPHRm5mDgJD7INXbfkB89ei1r9w65Uh9mFTESAmsKmia" +
       "n0S27lQ2UnFE7ydVktGWBhGBiiTIrlP1cWjVAs6guF4sdVZlS/G6DyNzci8U" +
       "5F6SKpfVHVRfo6aUuBU0K+ySTJx0zclTmubpYJc4IilfxTenzSBUNNDRqWmZ" +
       "+xbkuMZ9e23+6IqGewv/xK8D/wM7TGj+0SwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "f9GTKqRhqwkDIrZpkx0O8cly5vDFRLRW");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("FN9QSuVilVx2lHgNJf06DsVUjemYRXgaYxj2Wp6q8t8v9krs0fx13mHa7F28" +
       "yDvnn517hwtOjhK28r/sleiJDMxjb0Pznk/sMlDCoPDUeUmyeQbQFz/1xpvy" +
       "6OeQvV2uTiMqXIs8/0O2slbsY1NdATO9fH76CpXnCB/lkPz2p/7rk8yH9Y9f" +
       "INnwA6dwnp7yF6m3frfzovT39gqXDzNKbstePjnolZN5JPcHSrQK8nzLrGab" +
       "TfLUIWeztNbC0+AidpwlTr9nPhLp2S+Z6a1K5G1npkJduv8ObQ9mxb1R4UFN" +
       "iYgTL6kPtejSlXd6d3p80qzi0t5J+p4EF7mjj/z+0/f4HdqeyIpHo8LVyNtm" +
       "3J2i7cb3QNv1rPK94KJ2tFHff9qeu0NbNtulp6LCvZFHbtPi0CPCnv4eCHs2" +
       "q8zauR1h3EUIA5vZD7xIkSJFfkf67pDCdwnJipeiwkNAN5lAcMPs/zrbjxEe" +
       "iwov3pbuHB322T/VPefIy98DR7L/BOW5Pf6OI/5FOPLuRP3aHdo+khV1wFnA" +
       "ijzpLQSm8YXzTWOel7pNBH3zHz3/+z/65vN/miciXjVCTgiwQDvjQ4ZjY779" +
       "1te/+YcPPfWlPP/5HlEIt7br9Bcgt3/gceK7jZziBw95+MCBKbgzD33fLxwJ" +
       "rfG92p5MctFuwej7LzTqDm2jrOhGhQcCRZB3X9YcaO+xzKltxuIRyeRFSE6i" +
       "wvVTaf1ZivITt31KtP38RfrSm9evvu9N9t9uJXvwicq1QeGqurLt4/mPx+6v" +
       "+IGiGjkvrm2zIf2cwHlUeOadPjqIgAc8fMgFNNsO/uGo8NiZg6PCPdnP8b4f" +
       "Aww73RfYvfz3eD8BrHbULypc2d4c7yJHhcugS3arZFpwaZxcOhm9HAii8I6+" +
       "4VjA8/yJvZh/73UQUqy2X3zdkr78Zm/4I9+p/tw2O1+yhc0mm+Uq2DbbDwUO" +
       "w5Jnz53tYK4r3Ze++/BXrr1wEEI9vAV8pNDHsH3g7Ex4wvGjPHd982vv+6ev" +
       "/vybf5wn7f0/njrKEYg3AAA=");
}
