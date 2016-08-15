package org.apache.batik.apps.svgbrowser;
public class SVGInputHandler implements org.apache.batik.apps.svgbrowser.SquiggleInputHandler {
    public static final java.lang.String[] SVG_MIME_TYPES = { "image/svg+xml" };
    public static final java.lang.String[] SVG_FILE_EXTENSIONS = { ".svg",
    ".svgz" };
    public java.lang.String[] getHandledMimeTypes() { return SVG_MIME_TYPES;
    }
    public java.lang.String[] getHandledExtensions() { return SVG_FILE_EXTENSIONS;
    }
    public java.lang.String getDescription() { return ""; }
    public void handle(org.apache.batik.util.ParsedURL purl, org.apache.batik.apps.svgbrowser.JSVGViewerFrame svgViewerFrame) {
        svgViewerFrame.
          getJSVGCanvas(
            ).
          loadSVGDocument(
            purl.
              toString(
                ));
    }
    public boolean accept(java.io.File f) { return f != null &&
                                              f.
                                              isFile(
                                                ) &&
                                              accept(
                                                f.
                                                  getPath(
                                                    )); }
    public boolean accept(org.apache.batik.util.ParsedURL purl) {
        if (purl ==
              null) {
            return false;
        }
        java.lang.String path =
          purl.
          getPath(
            );
        if (path ==
              null)
            return false;
        return accept(
                 path);
    }
    public boolean accept(java.lang.String path) { if (path ==
                                                         null)
                                                       return false;
                                                   for (int i =
                                                          0;
                                                        i <
                                                          SVG_FILE_EXTENSIONS.
                                                            length;
                                                        i++) {
                                                       if (path.
                                                             endsWith(
                                                               SVG_FILE_EXTENSIONS[i])) {
                                                           return true;
                                                       }
                                                   }
                                                   return false;
    }
    public SVGInputHandler() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "YonBz/a+4jEFHbeDP+LT0v8CiPkAHcghAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Oo6gm6N+fZA5jN1OUhZ8SG9zX9z2B9WJkbKMZUawPN9heLSps0Rjrvc3MjKI" +
       "BGEwCFsLp7bgtwNc2+iIO9JWumTUxvA49I1dTRT1cFRdyVrFVaI1YZnBfLDV" +
       "QP47Ef2exUuIJdmDjbPu1PFemGMqiI3GYtNjcpSiCI/q4XLoDDGS20XN1XaR" +
       "0a4hhklVwyeOPpyn+brd6NA1Xp4FsZxPzPYAbSOmxTZNl27grrHyvfYOkWAc" +
       "fCb3ZK3Dw+wU3TRIi7dbPcUwQbL+/mJp4VNvbsnjkXIl5/hAxF9iDWdf9UxR" +
       "PH+8Clb+LkF33lk8tfty4Wixk3jjLWUwKxmGo53eVy7WcJ+80ymJcv32C594" +
       "+RV19EXs4uH63jKBHkj84K862kZzTjFyubyXzi7R/xC4XjwU4sXzS3knarpF" +
       "4RdKhe/VfJe1xs/fpe7ni+JzCfSYoR0Kq3KWqx1v5zInBvrZN1p2Ot337cR8" +
       "L7iwQzGxt17MX7pL3d8rii8k0DtOxOzmiebFR2vSp+T84vch56NHftg4lLPx" +
       "1sv51bvU/WpRfCWBHgZydrQYfLIER7vi7ImEf//7kPBtxUsKXB84lPADb42E" +
       "5zYsnr4lTvdneMoDZLMJe0T3xkdE+sKcnltapkVUJLlaOfiv3UWFXy+Kf5JA" +
       "l8zST267KLvxLfVEnV/7PtT5WPHyBw5VeqTat0CdF87C3kNHezyU5exV8I27" +
       "qOD3iuJfARUUe+VBcjsVXJZ939Ek70QL//qt0AJ3qAXuLdVC8fjPSoL/dBep" +
       "/6govnUsdfH0+yfi/eFbId5HDsX7yFsuHlsSvH4X8f5bUfzJncT7zpsRL0+g" +
       "K+dOXhVHRx6/5bTn/oSi8qVXrtz/7ldm/3a/uX10ivABFrpfTx3n9E7/qftL" +
       "QaTpVsn6A/t9/6D8+7MEuvZGQZ9AD548lOz/r33jP0+gd962MQjq4u8U7QUo" +
       "ga6ep02g+8r/03T3gNFO6AoFlzenSS4l0D2ApLi9HBzF5Kktpv1JifzCqUTh" +
       "0IlK4zz6RsY5bnL6UFOxSVse0z3aUE33");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("B3VvKl9+pT/82Ou1L+4PVSmOtNsVvdzPQpf357vKTotN2Wfu2NtRX5d6L3zv" +
       "4a888PxR4vPwnuEThz7F29O3P7XUdYOkPGe0+0fv/ofv+8VX/qDcY/u/uIob" +
       "4j8tAAA=");
}
