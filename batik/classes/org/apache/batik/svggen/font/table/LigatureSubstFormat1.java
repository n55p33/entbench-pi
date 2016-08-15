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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
