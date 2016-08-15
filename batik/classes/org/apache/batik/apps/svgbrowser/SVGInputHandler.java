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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+LnBz/a+4jEFHbeDP+LT0v8C0fxTysghAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "icKhE5XGeezNjHPc5PShpmKTtjyme7Sh");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("mu4P6t5SvvLqYPSJN2pf2h+qUhxptyt6eYCBruzPd5WdFpuyz961t6O+Lvdf" +
       "/P4jX33whaPE55E9wycOfYq3Z+58aqnrBkl5zmj3j9/7jz7wd1/93XKP7f8C" +
       "I883IT8tAAA=");
}
