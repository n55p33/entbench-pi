package org.apache.batik.ext.awt.image.spi;
public class ImageWriterParams {
    private java.lang.Integer resolution;
    private java.lang.Float jpegQuality;
    private java.lang.Boolean jpegForceBaseline;
    private java.lang.String compressionMethod;
    public ImageWriterParams() { super(); }
    public java.lang.Integer getResolution() { return this.resolution; }
    public java.lang.Float getJPEGQuality() { return this.jpegQuality; }
    public java.lang.Boolean getJPEGForceBaseline() { return this.jpegForceBaseline;
    }
    public java.lang.String getCompressionMethod() { return this.
                                                              compressionMethod;
    }
    public void setResolution(int dpi) { this.resolution = new java.lang.Integer(
                                                             dpi);
    }
    public void setJPEGQuality(float quality, boolean forceBaseline) {
        this.
          jpegQuality =
          new java.lang.Float(
            quality);
        this.
          jpegForceBaseline =
          forceBaseline
            ? java.lang.Boolean.
                TRUE
            : java.lang.Boolean.
                FALSE;
    }
    public void setCompressionMethod(java.lang.String method) {
        this.
          compressionMethod =
          method;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "m/dfKJGFwfggAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
