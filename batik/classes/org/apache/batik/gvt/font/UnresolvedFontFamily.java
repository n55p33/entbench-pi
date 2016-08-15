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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZfXBU1RW/uwkhH+STT0ECCQEK6K5YtWLUGmICoRtICcZx" +
       "UcLL27vZR96+93jvbrKJxSrTjtROqSJ+tCP5p1goojCdOq21OjhO/RhpO+BX" +
       "raMy1Zn6UUcZq+3Utvace9/b97EflFa7M+/u23vPufeec8/5nXPPHn6fTLFM" +
       "0kw1FmHjBrUiXRrrk0yLJjpVybI2Qd+gfE+Z9NGWt9evCpOKOKlLSVavLFm0" +
       "W6FqwoqT+YpmMUmTqbWe0gRy9JnUouaoxBRdi5OZitWTNlRFVlivnqBIMCCZ" +
       "MdIoMWYqQxlGe+wJGJkfg51E+U6iHcHh9hiZJuvGuEs+x0Pe6RlByrS7lsVI" +
       "Q2ybNCpFM0xRozHFYu1Zk6wwdHV8WNVZhGZZZJt6sa2CdbGL81TQerT+k09v" +
       "TzVwFUyXNE1nXDxrI7V0dZQmYqTe7e1SadraTm4iZTFS4yFmpC3mLBqFRaOw" +
       "qCOtSwW7r6VaJt2pc3GYM1OFIeOGGGnxT2JIppS2p+nje4YZKpktO2cGaRfm" +
       "pBVS5ol414ro3nu2NPy0jNTHSb2i9eN2ZNgEg0XioFCaHqKm1ZFI0EScNGpw" +
       "2P3UVCRVmbBPuslShjWJZeD4HbVgZ8agJl/T1RWcI8hmZmSmmznxktyg7F9T" +
       "kqo0DLLOcmUVEnZjPwhYrcDGzKQEdmezlI8oWoKRBUGOnIxtXwMCYJ2apiyl" +
       "55Yq1yToIE3CRFRJG472g+lpw0A6RQcDNBmZW3RS1LUhySPSMB1EiwzQ9Ykh" +
       "oKriikAWRmYGyfhMcEpzA6fkOZ/311+++0ZtrRYmIdhzgsoq7r8GmJoDTBtp" +
       "kpoU/EAwTlseu1ua9diuMCFAPDNALGh+/o3TV53XfOwZQTOvAM2GoW1UZoPy" +
       "/qG6E+d2LltVhtuoNHRLwcP3Sc69rM8eac8agDCzcjPiYMQZPLbxqetuPkTf" +
       "C5PqHlIh62omDXbUKOtpQ1GpuYZq1JQYTfSQKqolOvl4D5kK7zFFo6J3QzJp" +
       "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" +
       "/BWbd/8NX/n6eXkeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
