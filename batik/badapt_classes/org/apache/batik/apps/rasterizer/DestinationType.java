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
      1471028784000L;
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
       "+xbkqMZ9e23+6IqGewv/xK8D/wMJY0Xd0SwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "X/SkCmnYasKAiG3aZIdDfLKcOXwxEa0l");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("xTeUUrlYJZcdJV5DSb+OQzHVW8BzGZ7GGIa9lqeq/PeLvRJ7NH+dd5g2excv" +
       "8s75Z+fe4YKTo4St/C97JXoiA/PY29C85xO7DJQwKDx1XpJsngH0xU+9+ZY8" +
       "+nlkb5er04gK1yLP/4itrBX72FRXwEwvn5++QuU5wkc5JL/9qf/6JPNR/RMX" +
       "SDb80Cmcp6f8Rert3+28KP3kXuHyYUbJbdnLJwe9cjKP5P5AiVZBnm+Z1Wyz" +
       "SZ465GyW1lp4GlzEjrPE6ffMRyI9+yUzvVWJvO3MVKhL99+h7cGsuDcqPKgp" +
       "EXHiJfWhFl268m7vTo9PmlVc2jtJ35PgInf0kd9/+h6/Q9sTWfFoVLgaeduM" +
       "u1O03fgeaLueVb4fXNSONur7T9tzd2jLZrv0VFS4N/LIbVocekTY098DYc9m" +
       "lVk7tyOMuwhhYDP7gRcpUqTI70rfHVL4LiFZ8VJUeAjoJhMIbpj9X2f7McJj" +
       "UeHF29Kdo8M++6e65xx5+XvgSPafoDy3x99xxL8IR96bqF+7Q9vHsqIOOAtY" +
       "kSe9hcA0vnC+aczzUreJoG/9w+d//0ffev5P80TEq0bICQEWaGd8yHBszLff" +
       "/vo3//Chp76U5z/fIwrh1nad/gLk9g88Tny3kVP84CEPHzgwBXfmoe/7hSOh" +
       "Nb5X25NJLtotGH3/hUbdoW2UFd2o8ECgCPLuy5oD7T2WObXNWDwimbwIyUlU" +
       "uH4qrT9LUX7itk+Jtp+/SF966/rVD7zF/tutZA8+Ubk2KFxVV7Z9PP/x2P0V" +
       "P1BUI+fFtW02pJ8TOI8Kz7zbRwcR8ICHD7mAZtvBPxwVHjtzcFS4J/s53vfj" +
       "gGGn+wK7l/8e7yeA1Y76RYUr25vjXeSocBl0yW6VTAsujZNLJ6OXA0EU3tU3" +
       "HAt4nj+xF/PvvQ5CitX2i69b0pff6g1/5DvVn99m50u2sNlks1wF22b7ocBh" +
       "WPLsubMdzHWl+9J3H/7KtRcOQqiHt4CPFPoYtg+dnQlPOH6U565vfu0D//TV" +
       "f/TWH+dJe/8Pi1I/Zog3AAA=");
}
