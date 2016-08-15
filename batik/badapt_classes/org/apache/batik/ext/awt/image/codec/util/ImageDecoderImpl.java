package org.apache.batik.ext.awt.image.codec.util;
public abstract class ImageDecoderImpl implements org.apache.batik.ext.awt.image.codec.util.ImageDecoder {
    protected org.apache.batik.ext.awt.image.codec.util.SeekableStream input;
    protected org.apache.batik.ext.awt.image.codec.util.ImageDecodeParam param;
    public ImageDecoderImpl(org.apache.batik.ext.awt.image.codec.util.SeekableStream input,
                            org.apache.batik.ext.awt.image.codec.util.ImageDecodeParam param) {
        super(
          );
        this.
          input =
          input;
        this.
          param =
          param;
    }
    public ImageDecoderImpl(java.io.InputStream input, org.apache.batik.ext.awt.image.codec.util.ImageDecodeParam param) {
        super(
          );
        this.
          input =
          new org.apache.batik.ext.awt.image.codec.util.ForwardSeekableStream(
            input);
        this.
          param =
          param;
    }
    public org.apache.batik.ext.awt.image.codec.util.ImageDecodeParam getParam() {
        return param;
    }
    public void setParam(org.apache.batik.ext.awt.image.codec.util.ImageDecodeParam param) {
        this.
          param =
          param;
    }
    public org.apache.batik.ext.awt.image.codec.util.SeekableStream getInputStream() {
        return input;
    }
    public int getNumPages() throws java.io.IOException {
        return 1;
    }
    public java.awt.image.Raster decodeAsRaster()
          throws java.io.IOException { return decodeAsRaster(
                                                0);
    }
    public java.awt.image.Raster decodeAsRaster(int page)
          throws java.io.IOException { java.awt.image.RenderedImage im =
                                         decodeAsRenderedImage(
                                           page);
                                       return im.
                                         getData(
                                           );
    }
    public java.awt.image.RenderedImage decodeAsRenderedImage()
          throws java.io.IOException { return decodeAsRenderedImage(
                                                0);
    }
    public abstract java.awt.image.RenderedImage decodeAsRenderedImage(int page)
          throws java.io.IOException;
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
       "kdYkxlVC0Dc7k3DY2XDWpFBHJ1uOMPU7DsYEFNlbiP0e7zooz41X3mzlj7Ya" +
       "vFLbfHdR7w7kHc7tVoPl3N7kNb3fX21iv4nPxhu5ta7PBLotzMQm0cExO8UX" +
       "DItT5KYvjY3ZylzWIkHvxTa1nY+ZiRBJw7XIrMbYaIz2zGqNdquzuWwM3IVO" +
       "uTSN03qILNx83I+iMVv3fd4fxy0V76aIRDCDDuJYyWi6ZKve0DCmGN7brVsz" +
       "tl+1NaTGVW1rZkzkEeh6IbS1ypYl8UgM+HpMb2fKfI2m9WFbpCYaX2uZ0xoy" +
       "D1E1JOPYTi3Bbi2Dqoc2F7Vx3tlieV1rIfpwVWP6q3g3RLnQxvGMwbxe26iv" +
       "lm5rjhMjd9tcmts60+vhvX7QQnU7WfvZdkWMe2jdyjyWpDCtu5u1em5E9n3G" +
       "2vYGqMsPqDUrD9eO0a9ji3oVS4e+N4vFWRVdpb06SpHpUum4jQUFFJtn7eZk" +
       "q45b4aYtt5xg0O+kPSmbtzTPg3f2brBwuZXf92qs2+hJTqNp8t6MwSqTSV+1" +
       "xr144vfFCdWBp4Og26lEUzjesgu62avW2t06tw2NdsoOVZ5obyamqjre3Bg4" +
       "jk/GjOU7Lp1gtdBczKwJGeaNJrlrEFRvmLfazfZCRoZjSa1U7ZTIrNlqYSm9" +
       "NF0Zjk9bdXZLtaRxbbYiyHrdMrDtnDfbytwS+0pVZ7cTVxx6VcGm1vPlgkrG" +
       "dr8p5uh8MOZ7eLrpx0C2KzWS8ZqWqNWup496Y4XWDWXMzTudKUxw1kDpLrn+" +
       "bGt4uDEmtDwYx36CYkNDJieR0mBkjdlWvPGQkDlUW05WbU2jNG8kC72Kwe+0" +
       "HsWaQw7e9oAfatW+PCWGUuh1Y40jejQ5rSBwsu5h1AKt76ZKPxfcmq5xfEJs" +
       "B2Nt0rXbWpIEC7vuTuRmFeE8IeIih7FaGdrfjWb6jtho2nxuYcMe37N3hNSZ" +
       "dmkdU82s0+07y5Rdo8NK1qvPhj2l2jXTKu1PZvCq2cP5iEPnoZ52yVZtyq4o" +
       "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" +
       "3/EL3/NPXv7T8qD5/wHcT4iasC0AAA==");
}
