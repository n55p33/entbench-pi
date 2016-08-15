package org.apache.batik.svggen.font.table;
public class GlyfTable implements org.apache.batik.svggen.font.table.Table {
    private byte[] buf = null;
    private org.apache.batik.svggen.font.table.GlyfDescript[] descript;
    protected GlyfTable(org.apache.batik.svggen.font.table.DirectoryEntry de,
                        java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        raf.
          seek(
            de.
              getOffset(
                ));
        buf =
          (new byte[de.
                      getLength(
                        )]);
        raf.
          read(
            buf);
    }
    public void init(int numGlyphs, org.apache.batik.svggen.font.table.LocaTable loca) {
        if (buf ==
              null) {
            return;
        }
        descript =
          (new org.apache.batik.svggen.font.table.GlyfDescript[numGlyphs]);
        java.io.ByteArrayInputStream bais =
          new java.io.ByteArrayInputStream(
          buf);
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            int len =
              loca.
              getOffset(
                i +
                  1) -
              loca.
              getOffset(
                i);
            if (len >
                  0) {
                bais.
                  reset(
                    );
                bais.
                  skip(
                    loca.
                      getOffset(
                        i));
                short numberOfContours =
                  (short)
                    (bais.
                       read(
                         ) <<
                       8 |
                       bais.
                       read(
                         ));
                if (numberOfContours >=
                      0) {
                    descript[i] =
                      new org.apache.batik.svggen.font.table.GlyfSimpleDescript(
                        this,
                        numberOfContours,
                        bais);
                }
                else {
                    descript[i] =
                      new org.apache.batik.svggen.font.table.GlyfCompositeDescript(
                        this,
                        bais);
                }
            }
        }
        buf =
          null;
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            if (descript[i] ==
                  null)
                continue;
            descript[i].
              resolve(
                );
        }
    }
    public org.apache.batik.svggen.font.table.GlyfDescript getDescription(int i) {
        return descript[i];
    }
    public int getType() { return glyf; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5mesSX8fAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ajo9z8UqopM7a7lhNnKYd+N5SMWdVoPNl7o7pV1FHrUdGdkYHXGYuXIa9DOH" +
       "r+BNQSK5Tb/Gj9a9VuAthXonZledNo5PZimaSdsusbRw121XHTEOgnpHUFRH" +
       "DGx/5TFNg65tDdSuGItKMrGIGamuGG3mNdBdgmC9thDMZ44tho2Vrky4eaDH" +
       "81EvwuIQ9VvLPtznpnl/hqDNliSPcbSiNtRGZOBWHKXViSQJYJKyvoQNbJRX" +
       "4A6V4EirhrD9OY9VA1MYYgnMt3Ehyes0vDPns5U05yJr3h1UUMlcVJoqMqbj" +
       "Lli/53qUybE05rDZoNsQEQeVcnXuV2tJulvUwbo+isJGZc5TOUN1cWKiCKZD" +
       "zeJllCRqxSWH1mpaa2wpdKGTAzq0iLm8nuw6FCFUqtUe0s8IAhG7k3bSt2p2" +
       "DxmlWoLT3bUAspkVFQYupW0jLiUFUxS6mNUP/cnO0m2aSqpkg+DGnLKTuCjj" +
       "el2+EVanOdzCKiHRMlNXlDNOxwFiLNLWZrfuWCCbMrmxEWLDmeYgQ0uKlD7b" +
       "UhTU1VW96nYVS+65epfecUO3Pl46DT7uoWHaR/n2HPXsZBEv4YmpjJ2qZyyY" +
       "ScDhER5urW69b/gbp0ZMNqtIa465kYLDXOYQruvYeSMYLOIJ7NKJESjTXG1X" +
       "eluimaXYtCdWNyNCg+lYmCaqizUFhctcg195qh/V1CSIJWqXswopCXGVw2dS" +
       "iG5bWRPzeaynmR0zliREI12bru16CF5ZthwT93kY87WZvFSn2GqG9Sb1iDft" +
       "bJ23kRWJ2jI/7HphP3L5TizUK51OZ0HrFjFYYdlgSWvLEMYq7Q4I2d2IaLlk" +
       "xAw2emPhdT06Y4RZ3IiWor6ZVVXFRfMIVp2lKwb9YOpW/JoQ2RMUbnf86RLl" +
       "pknCdq2kWRmZOSkQOKFHKiXOCaPaNsNoWcmCbSXF17CyjLc7R5zADOzNVdfZ" +
       "RuI0y7vT+raGrsJ1LlRxbMJijapGaDkPS0NZnOLCRt9V516+6k8ddGth9ZVf" +
       "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" +
       "KfmkKgAA");
}
