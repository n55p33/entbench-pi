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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "DyPOZVOQIAAA");
}
