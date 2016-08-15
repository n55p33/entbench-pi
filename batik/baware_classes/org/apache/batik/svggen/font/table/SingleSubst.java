package org.apache.batik.svggen.font.table;
public abstract class SingleSubst extends org.apache.batik.svggen.font.table.LookupSubtable {
    public abstract int getFormat();
    public abstract int substitute(int glyphId);
    public static org.apache.batik.svggen.font.table.SingleSubst read(java.io.RandomAccessFile raf,
                                                                      int offset)
          throws java.io.IOException { org.apache.batik.svggen.font.table.SingleSubst s =
                                         null;
                                       raf.seek(offset);
                                       int format =
                                         raf.
                                         readUnsignedShort(
                                           );
                                       if (format ==
                                             1) {
                                           s =
                                             new org.apache.batik.svggen.font.table.SingleSubstFormat1(
                                               raf,
                                               offset);
                                       }
                                       else
                                           if (format ==
                                                 2) {
                                               s =
                                                 new org.apache.batik.svggen.font.table.SingleSubstFormat2(
                                                   raf,
                                                   offset);
                                           }
                                       return s;
    }
    public SingleSubst() { super(); }
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
       "+b8BD/vaZZsiAAA=");
}
