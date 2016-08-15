package org.apache.batik.svggen.font.table;
public class CmapTable implements org.apache.batik.svggen.font.table.Table {
    private int version;
    private int numTables;
    private org.apache.batik.svggen.font.table.CmapIndexEntry[] entries;
    private org.apache.batik.svggen.font.table.CmapFormat[] formats;
    protected CmapTable(org.apache.batik.svggen.font.table.DirectoryEntry de,
                        java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        raf.
          seek(
            de.
              getOffset(
                ));
        long fp =
          raf.
          getFilePointer(
            );
        version =
          raf.
            readUnsignedShort(
              );
        numTables =
          raf.
            readUnsignedShort(
              );
        entries =
          (new org.apache.batik.svggen.font.table.CmapIndexEntry[numTables]);
        formats =
          (new org.apache.batik.svggen.font.table.CmapFormat[numTables]);
        for (int i =
               0;
             i <
               numTables;
             i++) {
            entries[i] =
              new org.apache.batik.svggen.font.table.CmapIndexEntry(
                raf);
        }
        for (int i =
               0;
             i <
               numTables;
             i++) {
            raf.
              seek(
                fp +
                  entries[i].
                  getOffset(
                    ));
            int format =
              raf.
              readUnsignedShort(
                );
            formats[i] =
              org.apache.batik.svggen.font.table.CmapFormat.
                create(
                  format,
                  raf);
        }
    }
    public org.apache.batik.svggen.font.table.CmapFormat getCmapFormat(short platformId,
                                                                       short encodingId) {
        for (int i =
               0;
             i <
               numTables;
             i++) {
            if (entries[i].
                  getPlatformId(
                    ) ==
                  platformId &&
                  entries[i].
                  getEncodingId(
                    ) ==
                  encodingId) {
                return formats[i];
            }
        }
        return null;
    }
    public int getType() { return cmap; }
    public java.lang.String toString() { java.lang.StringBuffer sb =
                                           new java.lang.StringBuffer(
                                           numTables *
                                             8).
                                           append(
                                             "cmap\n");
                                         for (int i =
                                                0;
                                              i <
                                                numTables;
                                              i++) {
                                             sb.
                                               append(
                                                 '\t').
                                               append(
                                                 entries[i].
                                                   toString(
                                                     )).
                                               append(
                                                 '\n');
                                         }
                                         for (int i =
                                                0;
                                              i <
                                                numTables;
                                              i++) {
                                             sb.
                                               append(
                                                 '\t').
                                               append(
                                                 formats[i].
                                                   toString(
                                                     )).
                                               append(
                                                 '\n');
                                         }
                                         return sb.
                                           toString(
                                             ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "MhmNtx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "8bAnVDO26naJNasTw1Eft1KUX+hTlI/Gqp07MKkuJS+HPX7JhjO/QcCaU+96" +
       "tbyOdmkuUezmhmtvwwDWNkYTqcP5ercTVRCI09Zyhg4rw36/tpltR9YAy1fa" +
       "fEHXpfVw7VfHXSfXExS14UzaDPq2I5AbfLKsRVhFCJnpnOpuaIVwuuxEG5sK" +
       "rDebFX1G+9RmF643gxlZbzg20iCnmtvKmgEnVUS1vRUTWqhF1FSBk2ll012x" +
       "nQ5RJShJSVbxope7QxBttW5L3PCxn5KOiDH2zO20rblnyFvXGpIKF9bmfBuj" +
       "5hO0t8bxeV4NI5QnIryXxwTT5VOkSw+NXp1Aie28hiMYYePbjPPzWM522Egi" +
       "FdVoj7oDW0BgdDkyFincUlf1Djq0Brskjp0hK2ueam9JlUJTEMy0MkCa8dAN" +
       "dgTBtJYs3cm6U2+RwE2PQms13HTJeZtbD0Nh291ZHYay6BFv4BbeWzlzVNjF" +
       "q9yqNFW9H1fQcdIIa0EzimdktdJEY3ibeTrc2C5Mwss65hzfjcYg47ISOOSE" +
       "llXH5a040mJ1HtvMvErig1mw2Q1nCwWtN0jH2QT9qGkmy/nIqgUK302XghG6" +
       "qenSLo3HSzdttMeTBTYS1vgCV6co47lGXZCnThqma3WJc41epYMlHQo14ABd" +
       "RYnUN9aRNuRoLfdZL/GQecznOD+lkyav1ltpSDdMlV7kKO6Nd060WMfddd/c" +
       "hQA60ya8iqYtC+4ic8Sw1hmxIXcVu5t3cUFaVJABAjx00NYSydGSyoiN5EqC" +
       "cxFKDPNVWlujgmMZs4ScZITLhsu0Poobg1mINTZuP+Ex2SQbHTOuw0ZC4aOo" +
       "U89nLadhy25daDB9e1Bb4/E82Lk6SKh6rSUzN9lKQFKokqGm3FOW6ya36q6n" +
       "CuHTLpXrAIpWfj6kicGq0iDhQbyr2v1Ic4Wq5hHzpiANanDuAP8ZLSuV6trr" +
       "zpeu0HBIEVnWXJjiO61oXuErIhJhDlffWsEcLNBJuiIrmqBS+VqdZLC69VS/" +
       "vu1zrUineb+dLxU/WzQWTXE0jxZLA+SPg8ARdqHihLtUN5pbuCYsK/DEFqbU" +
       "kJJgG6cXqyrRNbBEQWqN7rzu1CoY4Yaip8YISTZ1pGowcmeWN3AiWYc7ZMXq" +
       "VZZY2bg9qXl13Wu4jEdwg7UaTDBXHlVCLm+12qpaD8NFHNF8Om2zKjvuYUId" +
       "biti39ZrdktErVqlFvtCX4Hn+srPBN831amep2E77JJw3lwn7Z1UJ/sLAraI" +
       "alvYBI3BgufxPpFP+dXOdHF3s6IXVNdKF/QkZ3JuE/YldZcziqnGvXBbU8O+" +
       "PWvSHIHXcBLztkaXpLCua+gqK6aoORqPLaSS4mtJ8rcT3qNjrMfydMULRsOm" +
       "nupLm0ZAel5bGV0v2OhUj9Zm+ZJAByGWLGATCSdoy8hrqLk0NcmBxaoZxmtn" +
       "WR2JkjDs415zYfa3Xi9MJwvKsAI51IeRN2VzinOdDmoxc0s2aQYjCElWLGyx" +
       "bGeRnTe0mpR6PtdhQbDS1QWKzUXMxHrMUDQMkXaHDow2Z/1k3A+VzhavVanM" +
       "CLSKYwzifmY7O5JpN+mov2V6Q4kT5ojMbjskPUqiSrs32jZtQapZhIiMl8OR" +
       "Cc/QxnSKOnCAsDtCJsVN1sDgwPGy9lwLyUCJk1ZEiSRO1cjcmDMA+1w1mYUy" +
       "FqdLeLXz5zOM7k84BGfCodSqVByUZ3mhrdvpYCHWpDVm4CG8HLJgpY4kwsZ2" +
       "wJr2eMDYSj+MNls0ZnodkJUkrlO1xmLXiZGAV3G0mfRNHbWIRaVbZcjJQnT4" +
       "vMqtwLq7XK3qDl+Puhg5iAMmWjIMozT1eVf2QxmkZE2H35iTkBnXFJOyZ5PV" +
       "Qlw0RgJpTarTAbqYYzXRFXsE2pqnEqbriLaywHpZGXOIo9sblmi2mLFW1YhV" +
       "LcCiqez0SLLHp8K07mtURo6m6Sjt0UnCt3Yet6ksZa89Gve5fsrCO3a9XMGm" +
       "3udMl48zFLx0v+tdxev4R9/cNsGD5Y7I8fcBawcvHrz/TewEZK+x1ZSfHE+V" +
       "v8vQuVPmU7tKpw4Pjs9Y/vEb2GAqtz6LHd8n7vTlQLnb+6kPvvSyNvzpWrGv" +
       "UvQuxNA9sR+809G3unNq7Eugp7ffeb+SK7cNT04PfueD/+ux6Q+Y730Tp7FP" +
       "nZPzfJc/z73ye73vVf/lRejS8VnCLZ90nGV64ewJwr2hHiehNz1zjvDEsSmK" +
       "vb3ydJA4NAVxfoPvxPx3smvpFecOyE6fy53bXro7Mv2w3DH/uZL1Z8+xHh0h" +
       "FfevFMW/i6H7DT0+2T0sGsMTj/yp19ubOt1r2fBvj/W/drTB2T3Uv/v3o/9p" +
       "JX7lNZ79WlH8YgxdAQoe2Wh0otov/R1Ue6hoLLau+4eq9f/+VfsPr/Hst4ri" +
       "8zF0NfZPNlDff6Lbb7wZ3TIQosdfVhRnxI/e8gXX/qsj9TMvX7v6yMuzr+2P" +
       "AY6+DLqHha6uEsc5fbZ2qn45CPWVVYp9z/6kLSj/vhBDz74+7gCfjo8PXX5/" +
       "z/mlGHr8tThj6K7i7zTLl2PokTuwFLvYZeU0/Vdj6Pp5eiBK+X+a7msxdO8J" +
       "HehqXzlN8ocxdAmQFNX/GtxmB3x/npldOAWOh/5WmvKh1zPlMcvpDx0KQC0/" +
       "1zsCv2T/wd5N9bMvM/z7vt346f2HFqoj5+VydZU9PKdwjgH0mTv2dtTX5f7b" +
       "vvPA5+55/gjsH9gLfOL7p2R76vafNJBuEJcfIeS/9si///6fffmPyg35vwW/" +
       "B7D+RykAAA==");
}
