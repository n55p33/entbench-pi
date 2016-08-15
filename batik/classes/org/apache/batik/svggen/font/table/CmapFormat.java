package org.apache.batik.svggen.font.table;
public abstract class CmapFormat {
    protected int format;
    protected int length;
    protected int version;
    protected CmapFormat(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        length =
          raf.
            readUnsignedShort(
              );
        version =
          raf.
            readUnsignedShort(
              );
    }
    protected static org.apache.batik.svggen.font.table.CmapFormat create(int format,
                                                                          java.io.RandomAccessFile raf)
          throws java.io.IOException { switch (format) {
                                           case 0:
                                               return new org.apache.batik.svggen.font.table.CmapFormat0(
                                                 raf);
                                           case 2:
                                               return new org.apache.batik.svggen.font.table.CmapFormat2(
                                                 raf);
                                           case 4:
                                               return new org.apache.batik.svggen.font.table.CmapFormat4(
                                                 raf);
                                           case 6:
                                               return new org.apache.batik.svggen.font.table.CmapFormat6(
                                                 raf);
                                       }
                                       return null;
    }
    public int getFormat() { return format;
    }
    public int getLength() { return length;
    }
    public int getVersion() { return version;
    }
    public abstract int mapCharCode(int charCode);
    public abstract int getFirst();
    public abstract int getLast();
    public java.lang.String toString() { return new java.lang.StringBuffer(
                                           ).
                                           append(
                                             "format: ").
                                           append(
                                             format).
                                           append(
                                             ", length: ").
                                           append(
                                             length).
                                           append(
                                             ", version: ").
                                           append(
                                             version).
                                           toString(
                                             );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Aa2nmNPrIAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "839YHuD9fz5GPRovKwAA");
}
