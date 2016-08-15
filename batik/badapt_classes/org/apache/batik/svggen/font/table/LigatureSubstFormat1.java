package org.apache.batik.svggen.font.table;
public class LigatureSubstFormat1 extends org.apache.batik.svggen.font.table.LigatureSubst {
    private int coverageOffset;
    private int ligSetCount;
    private int[] ligatureSetOffsets;
    private org.apache.batik.svggen.font.table.Coverage coverage;
    private org.apache.batik.svggen.font.table.LigatureSet[] ligatureSets;
    protected LigatureSubstFormat1(java.io.RandomAccessFile raf, int offset)
          throws java.io.IOException { super();
                                       coverageOffset = raf.readUnsignedShort(
                                                              );
                                       ligSetCount = raf.readUnsignedShort(
                                                           );
                                       ligatureSetOffsets = (new int[ligSetCount]);
                                       ligatureSets = (new org.apache.batik.svggen.font.table.LigatureSet[ligSetCount]);
                                       for (int i = 0; i < ligSetCount; i++) {
                                           ligatureSetOffsets[i] =
                                             raf.
                                               readUnsignedShort(
                                                 );
                                       }
                                       raf.seek(offset + coverageOffset);
                                       coverage = org.apache.batik.svggen.font.table.Coverage.
                                                    read(
                                                      raf);
                                       for (int i = 0; i < ligSetCount;
                                            i++) { ligatureSets[i] =
                                                     new org.apache.batik.svggen.font.table.LigatureSet(
                                                       raf,
                                                       offset +
                                                         ligatureSetOffsets[i]);
                                       } }
    public int getFormat() { return 1; }
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
      ("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");
}
