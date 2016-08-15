package org.apache.batik.ext.awt.image.codec.tiff;
public class TIFFDecodeParam implements org.apache.batik.ext.awt.image.codec.util.ImageDecodeParam {
    private boolean decodePaletteAsShorts = false;
    private java.lang.Long ifdOffset = null;
    private boolean convertJPEGYCbCrToRGB = true;
    public TIFFDecodeParam() { super(); }
    public void setDecodePaletteAsShorts(boolean decodePaletteAsShorts) {
        this.
          decodePaletteAsShorts =
          decodePaletteAsShorts;
    }
    public boolean getDecodePaletteAsShorts() { return decodePaletteAsShorts;
    }
    public byte decode16BitsTo8Bits(int s) { return (byte) (s >> 8 & 65535);
    }
    public byte decodeSigned16BitsTo8Bits(short s) { return (byte) (s + java.lang.Short.
                                                                          MIN_VALUE >>
                                                                      8);
    }
    public void setIFDOffset(long offset) { ifdOffset = new java.lang.Long(
                                                          offset);
    }
    public java.lang.Long getIFDOffset() { return ifdOffset;
    }
    public void setJPEGDecompressYCbCrToRGB(boolean convertJPEGYCbCrToRGB) {
        this.
          convertJPEGYCbCrToRGB =
          convertJPEGYCbCrToRGB;
    }
    public boolean getJPEGDecompressYCbCrToRGB() { return convertJPEGYCbCrToRGB;
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
