package org.apache.batik.swing.svg;
public class SVGFileFilter extends javax.swing.filechooser.FileFilter {
    public boolean accept(java.io.File f) { boolean accept = false;
                                            java.lang.String fileName = null;
                                            if (f != null) { if (f.isDirectory(
                                                                     )) {
                                                                 accept =
                                                                   true;
                                                             }
                                                             else {
                                                                 fileName =
                                                                   f.
                                                                     getPath(
                                                                       ).
                                                                     toLowerCase(
                                                                       );
                                                                 if (fileName.
                                                                       endsWith(
                                                                         ".svg") ||
                                                                       fileName.
                                                                       endsWith(
                                                                         ".svgz"))
                                                                     accept =
                                                                       true;
                                                             }
                                            }
                                            return accept;
    }
    public java.lang.String getDescription() { return ".svg, .svgz";
    }
    public SVGFileFilter() { super(); }
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
       "kCAAAA==");
}
