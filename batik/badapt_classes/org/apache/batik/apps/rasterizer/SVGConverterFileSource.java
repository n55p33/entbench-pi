package org.apache.batik.apps.rasterizer;
public class SVGConverterFileSource implements org.apache.batik.apps.rasterizer.SVGConverterSource {
    java.io.File file;
    java.lang.String ref;
    public SVGConverterFileSource(java.io.File file) { super();
                                                       this.file = file; }
    public SVGConverterFileSource(java.io.File file, java.lang.String ref) {
        super(
          );
        this.
          file =
          file;
        this.
          ref =
          ref;
    }
    public java.lang.String getName() { java.lang.String name = file.getName(
                                                                       );
                                        if (ref != null && !"".equals(ref)) {
                                            name +=
                                              '#' +
                                              ref;
                                        }
                                        return name; }
    public java.io.File getFile() { return file; }
    public java.lang.String toString() { return getName(); }
    public java.lang.String getURI() { try { java.lang.String uri = file.
                                               toURL(
                                                 ).
                                               toString(
                                                 );
                                             if (ref != null && !"".equals(
                                                                      ref)) {
                                                 uri +=
                                                   '#' +
                                                   ref;
                                             }
                                             return uri; }
                                       catch (java.net.MalformedURLException e) {
                                           throw new java.lang.Error(
                                             e.
                                               getMessage(
                                                 ));
                                       } }
    public boolean equals(java.lang.Object o) { if (o == null || !(o instanceof org.apache.batik.apps.rasterizer.SVGConverterFileSource)) {
                                                    return false;
                                                }
                                                return file.
                                                  equals(
                                                    ((org.apache.batik.apps.rasterizer.SVGConverterFileSource)
                                                       o).
                                                      file);
    }
    public int hashCode() { return file.hashCode(
                                          ); }
    public java.io.InputStream openStream() throws java.io.FileNotFoundException {
        return new java.io.FileInputStream(
          file);
    }
    public boolean isSameAs(java.lang.String srcStr) {
        if (file.
              toString(
                ).
              equals(
                srcStr)) {
            return true;
        }
        return false;
    }
    public boolean isReadable() { return file.
                                    canRead(
                                      ); }
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
