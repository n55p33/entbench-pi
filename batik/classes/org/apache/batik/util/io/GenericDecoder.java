package org.apache.batik.util.io;
public class GenericDecoder implements org.apache.batik.util.io.CharDecoder {
    protected java.io.Reader reader;
    public GenericDecoder(java.io.InputStream is, java.lang.String enc) throws java.io.IOException {
        super(
          );
        reader =
          new java.io.InputStreamReader(
            is,
            enc);
        reader =
          new java.io.BufferedReader(
            reader);
    }
    public GenericDecoder(java.io.Reader r) { super();
                                              reader = r;
                                              if (!(r instanceof java.io.BufferedReader)) {
                                                  reader =
                                                    new java.io.BufferedReader(
                                                      reader);
                                              } }
    public int readChar() throws java.io.IOException { return reader.
                                                         read(
                                                           );
    }
    public void dispose() throws java.io.IOException { reader.
                                                         close(
                                                           );
                                                       reader =
                                                         null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "OPzov8DwqHayGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
