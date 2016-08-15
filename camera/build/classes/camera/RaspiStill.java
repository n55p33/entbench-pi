package camera;
public class RaspiStill implements ent.runtime.ENT_Attributable {
    private final java.lang.String _raspistillPath = "/opt/vc/bin/raspistill";
    private int _picTimeout = 30000;
    private int _picWidth = 1024;
    private int _picHeight = 768;
    private java.lang.String _picName = "example.jpg";
    private java.lang.String _picType = "jpg";
    private java.lang.String _picNames = "example%d.jpg";
    private int _picLapse = 1000;
    private int _quality = 100;
    public int ENT_attribute() { if (_picHeight <= 1200) { return camera.EntMode.
                                                                    LOW_MODE;
                                 }
                                 else
                                     if (_picHeight <=
                                           1536) {
                                         return camera.EntMode.
                                                  MID_MODE;
                                     }
                                     else {
                                         return camera.EntMode.
                                                  HIGH_MODE;
                                     } }
    public RaspiStill(int width, int height) { super();
                                               _picWidth = width;
                                               _picHeight = height;
    }
    public void TakePicture(int timeout, java.lang.String name) throws java.lang.Exception {
        java.lang.StringBuilder sb =
          new java.lang.StringBuilder(
          _raspistillPath);
        sb.
          append(
            " -n -bm");
        sb.
          append(
            " -w " +
            _picWidth);
        sb.
          append(
            " -h " +
            _picHeight);
        sb.
          append(
            " -e " +
            _picType);
        sb.
          append(
            " -q " +
            _quality);
        sb.
          append(
            " -t 1");
        sb.
          append(
            " -o " +
            name);
        java.lang.System.
          out.
          println(
            sb.
              toString(
                ));
        java.lang.Runtime.
          getRuntime(
            ).
          exec(
            sb.
              toString(
                ));
    }
    public void TakePictures() { if (_picLapse < 1000) { try {
                                                             if (_picName.
                                                                   indexOf(
                                                                     '.') !=
                                                                   -1)
                                                                 _picType =
                                                                   _picName.
                                                                     substring(
                                                                       _picName.
                                                                         lastIndexOf(
                                                                           '.') +
                                                                         1);
                                                             java.lang.StringBuilder sb =
                                                               new java.lang.StringBuilder(
                                                               _raspistillPath);
                                                             sb.
                                                               append(
                                                                 " -n -bm");
                                                             sb.
                                                               append(
                                                                 " -t " +
                                                                 _picTimeout);
                                                             sb.
                                                               append(
                                                                 " -w " +
                                                                 _picWidth);
                                                             sb.
                                                               append(
                                                                 " -h " +
                                                                 _picHeight);
                                                             sb.
                                                               append(
                                                                 " -e " +
                                                                 _picType);
                                                             sb.
                                                               append(
                                                                 " -tl " +
                                                                 _picLapse);
                                                             sb.
                                                               append(
                                                                 " -q " +
                                                                 _quality);
                                                             sb.
                                                               append(
                                                                 " -o " +
                                                                 _picNames);
                                                             java.lang.System.
                                                               out.
                                                               println(
                                                                 sb.
                                                                   toString(
                                                                     ));
                                                             java.lang.Runtime.
                                                               getRuntime(
                                                                 ).
                                                               exec(
                                                                 sb.
                                                                   toString(
                                                                     ));
                                                             java.lang.Thread.
                                                               sleep(
                                                                 _picTimeout);
                                                         }
                                                         catch (java.lang.Exception e) {
                                                             java.lang.System.
                                                               exit(
                                                                 e.
                                                                   hashCode(
                                                                     ));
                                                         }
                                 }
                                 else {
                                     try {
                                         int npics =
                                           _picTimeout /
                                           _picLapse;
                                         java.lang.System.
                                           out.
                                           format(
                                             "Taking %d pictures",
                                             npics);
                                         for (int i =
                                                0;
                                              i <
                                                npics;
                                              i++) {
                                             TakePicture(
                                               _picLapse,
                                               "example" +
                                               i +
                                               "%d.jpg");
                                             java.lang.Thread.
                                               sleep(
                                                 _picLapse);
                                         }
                                     }
                                     catch (java.lang.Exception e) {
                                         java.lang.System.
                                           err.
                                           println(
                                             e);
                                     }
                                 } }
    public void TakePictures(int lapse, int timeout) {
        _picLapse =
          lapse;
        _picTimeout =
          timeout;
        TakePictures(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1470704419000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "6OSfmX8DEHdUj+IeAAA=");
    public RaspiStill() { super(); }
    public ent.runtime.ENT_Attributable ENT_copy() {
        camera.RaspiStill ENT_ld =
          new camera.RaspiStill(
          );
        ENT_ld.
          _picTimeout =
          this.
            _picTimeout;
        ENT_ld.
          _picWidth =
          this.
            _picWidth;
        ENT_ld.
          _picHeight =
          this.
            _picHeight;
        ENT_ld.
          _picName =
          this.
            _picName;
        ENT_ld.
          _picType =
          this.
            _picType;
        ENT_ld.
          _picNames =
          this.
            _picNames;
        ENT_ld.
          _picLapse =
          this.
            _picLapse;
        ENT_ld.
          _quality =
          this.
            _quality;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1470704419000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "LgAA");
}
