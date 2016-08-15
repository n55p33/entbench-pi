package org.apache.batik.svggen.font.table;
public abstract class KernSubtable {
    protected KernSubtable() { super(); }
    public abstract int getKerningPairCount();
    public abstract org.apache.batik.svggen.font.table.KerningPair getKerningPair(int i);
    public static org.apache.batik.svggen.font.table.KernSubtable read(java.io.RandomAccessFile raf)
          throws java.io.IOException { org.apache.batik.svggen.font.table.KernSubtable table =
                                         null;
                                       raf.readUnsignedShort(
                                             );
                                       raf.readUnsignedShort(
                                             );
                                       int coverage = raf.
                                         readUnsignedShort(
                                           );
                                       int format = coverage >>
                                         8;
                                       switch (format) { case 0:
                                                             table =
                                                               new org.apache.batik.svggen.font.table.KernSubtableFormat0(
                                                                 raf);
                                                             break;
                                                         case 2:
                                                             table =
                                                               new org.apache.batik.svggen.font.table.KernSubtableFormat2(
                                                                 raf);
                                                             break;
                                                         default:
                                                             break;
                                       }
                                       return table;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "A1dBz6JcGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/wYiouyp/SIAAA==");
}
