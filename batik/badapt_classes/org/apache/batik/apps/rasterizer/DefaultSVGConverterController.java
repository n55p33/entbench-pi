package org.apache.batik.apps.rasterizer;
public class DefaultSVGConverterController implements org.apache.batik.apps.rasterizer.SVGConverterController {
    public boolean proceedWithComputedTask(org.apache.batik.transcoder.Transcoder transcoder,
                                           java.util.Map hints,
                                           java.util.List sources,
                                           java.util.List dest) {
        return true;
    }
    public boolean proceedWithSourceTranscoding(org.apache.batik.apps.rasterizer.SVGConverterSource source,
                                                java.io.File dest) {
        java.lang.System.
          out.
          println(
            "About to transcoder source of type: " +
            source.
              getClass(
                ).
              getName(
                ));
        return true;
    }
    public boolean proceedOnSourceTranscodingFailure(org.apache.batik.apps.rasterizer.SVGConverterSource source,
                                                     java.io.File dest,
                                                     java.lang.String errorCode) {
        return true;
    }
    public void onSourceTranscodingSuccess(org.apache.batik.apps.rasterizer.SVGConverterSource source,
                                           java.io.File dest) {
        
    }
    public DefaultSVGConverterController() {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
