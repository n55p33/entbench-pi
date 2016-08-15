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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dpH1f13YSRhGJwAA");
}
