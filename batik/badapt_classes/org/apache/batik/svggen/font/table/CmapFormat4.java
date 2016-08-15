package org.apache.batik.svggen.font.table;
public class CmapFormat4 extends org.apache.batik.svggen.font.table.CmapFormat {
    public int language;
    private int segCountX2;
    private int searchRange;
    private int entrySelector;
    private int rangeShift;
    private int[] endCode;
    private int[] startCode;
    private int[] idDelta;
    private int[] idRangeOffset;
    private int[] glyphIdArray;
    private int segCount;
    private int first;
    private int last;
    protected CmapFormat4(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          raf);
        format =
          4;
        segCountX2 =
          raf.
            readUnsignedShort(
              );
        segCount =
          segCountX2 /
            2;
        endCode =
          (new int[segCount]);
        startCode =
          (new int[segCount]);
        idDelta =
          (new int[segCount]);
        idRangeOffset =
          (new int[segCount]);
        searchRange =
          raf.
            readUnsignedShort(
              );
        entrySelector =
          raf.
            readUnsignedShort(
              );
        rangeShift =
          raf.
            readUnsignedShort(
              );
        last =
          -1;
        for (int i =
               0;
             i <
               segCount;
             i++) {
            endCode[i] =
              raf.
                readUnsignedShort(
                  );
            if (endCode[i] >
                  last)
                last =
                  endCode[i];
        }
        raf.
          readUnsignedShort(
            );
        for (int i =
               0;
             i <
               segCount;
             i++) {
            startCode[i] =
              raf.
                readUnsignedShort(
                  );
            if (i ==
                  0 ||
                  startCode[i] <
                  first)
                first =
                  startCode[i];
        }
        for (int i =
               0;
             i <
               segCount;
             i++) {
            idDelta[i] =
              raf.
                readUnsignedShort(
                  );
        }
        for (int i =
               0;
             i <
               segCount;
             i++) {
            idRangeOffset[i] =
              raf.
                readUnsignedShort(
                  );
        }
        int count =
          (length -
             16 -
             segCount *
             8) /
          2;
        glyphIdArray =
          (new int[count]);
        for (int i =
               0;
             i <
               count;
             i++) {
            glyphIdArray[i] =
              raf.
                readUnsignedShort(
                  );
        }
    }
    public int getFirst() { return first; }
    public int getLast() { return last; }
    public int mapCharCode(int charCode) { try { if (charCode < 0 ||
                                                       charCode >=
                                                       65534) return 0;
                                                 for (int i = 0; i <
                                                                   segCount;
                                                      i++) { if (endCode[i] >=
                                                                   charCode) {
                                                                 if (startCode[i] <=
                                                                       charCode) {
                                                                     if (idRangeOffset[i] >
                                                                           0) {
                                                                         return glyphIdArray[idRangeOffset[i] /
                                                                                               2 +
                                                                                               (charCode -
                                                                                                  startCode[i]) -
                                                                                               (segCount -
                                                                                                  i)];
                                                                     }
                                                                     else {
                                                                         return (idDelta[i] +
                                                                                   charCode) %
                                                                           65536;
                                                                     }
                                                                 }
                                                                 else {
                                                                     break;
                                                                 }
                                                             }
                                                 }
                                           }
                                           catch (java.lang.ArrayIndexOutOfBoundsException e) {
                                               java.lang.System.
                                                 err.
                                                 println(
                                                   "error: Array out of bounds - " +
                                                   e.
                                                     getMessage(
                                                       ));
                                           }
                                           return 0;
    }
    public java.lang.String toString() { return new java.lang.StringBuffer(
                                           80).
                                           append(
                                             super.
                                               toString(
                                                 )).
                                           append(
                                             ", segCountX2: ").
                                           append(
                                             segCountX2).
                                           append(
                                             ", searchRange: ").
                                           append(
                                             searchRange).
                                           append(
                                             ", entrySelector: ").
                                           append(
                                             entrySelector).
                                           append(
                                             ", rangeShift: ").
                                           append(
                                             rangeShift).
                                           append(
                                             ", endCode: ").
                                           append(
                                             intToStr(
                                               endCode)).
                                           append(
                                             ", startCode: ").
                                           append(
                                             intToStr(
                                               startCode)).
                                           append(
                                             ", idDelta: ").
                                           append(
                                             intToStr(
                                               idDelta)).
                                           append(
                                             ", idRangeOffset: ").
                                           append(
                                             intToStr(
                                               idRangeOffset)).
                                           toString(
                                             );
    }
    private static java.lang.String intToStr(int[] array) {
        int nSlots =
          array.
            length;
        java.lang.StringBuffer workBuff =
          new java.lang.StringBuffer(
          nSlots *
            8);
        workBuff.
          append(
            '[');
        for (int i =
               0;
             i <
               nSlots;
             i++) {
            workBuff.
              append(
                array[i]);
            if (i <
                  nSlots -
                  1) {
                workBuff.
                  append(
                    ',');
            }
        }
        workBuff.
          append(
            ']');
        return workBuff.
          toString(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "RTjjkkkwWMEVmI+GSLzUbaKC1RnZJ3pJhnX0kNUIuZapDr1KfYKh42nIsO2N" +
       "xDk9RsKrg203SwgvE73JvCbLuCGWKkgp8zcZsCGt08CrskqiSp0uNwRugMtG" +
       "TdNnYzXs+gJl6UNVwJbVLO4bRq/c9kyrZ5JKB+9GkjnGGdbFAS9VMW45VCZ4" +
       "GAgXakaRs0nS4teVrdHtV5cti5MRa0w3F6HismNbrk0cutw0Gn1K0qc83FaM" +
       "mqD0R2yQqOJmWEXmisOaprQot2nf4JwwFZapHg8ocV5mJ2jSjsgKjkzX/dgK" +
       "qGxm9jrdIYuSlWYftTQ/WM49OFuW7NGIHmlwqbcIJ1RQ1zQs3UgdLNH7KLA7" +
       "dckPkT5aDkscV2NwUarW0hi2SpFIZhTlzOcsVZ0q5LiFTDxhRntiLK2dcs3R" +
       "O7OerzLWpjHrNDfGfKak1hrOkBFKBy6+7TZb/Q3PZdLKo5pDwydjTJ3XFzBp" +
       "LzlgUqspvRY1LRW0uW8NlmszZCtsNpzBCdOLxSgbe+JML4coh5IlZtkaC127" +
       "D9xyPAWMB79tqQ9H8dxLSnPHqVCTLEyqQO3Htuotx1F7Gw90rzJx67WpOW6t" +
       "2XY2DB3f1tezQdLW5v0ytlXW8GqwHib9qOcygYTAES+EdZgsG4iX9JodBhVn" +
       "fqkewYOqz/Xmq5iS10p95K03AZz1KsFgHbk1BzXRzCkD37rdNGJjTGgzZ6GG" +
       "yFAU6rM1SdeqE3oEgDG8gbcxd8prfgUkks14UJVwD163pg6nyuxgtXUyWJ5R" +
       "LdOqat4yEWNhgxu1qNQbUmiYtuzhdgMjrY4545pJA6mQQb89bDVnEUNL80ws" +
       "lyY+ViF82iw3mCmtkiFVEeqk1KeHBO4yDXVLlaO0pI+p0nSDZ9s+U1528VHY" +
       "XG0r6pglxiDodn1mOLcU3l35dcdM6gvSF31umA3xSsnoq1YMlNoiRQudAA/b" +
       "Q+OQGcwSx4xTuzfTRU5vxDg9N5g4iSlyIigdZbn1huQCa88mXnvGKPMuM66b" +
       "WLeyXeDAiTeIBb0V66NOIK86m46XqfPlnG+XnYnBCIMyCvetFkjphTLSZDfC" +
       "qrxEF1St30uVrblNU72uV1BdxWrqukzWsbCOWMpmWM6mbuyWrUGwmrZnTVhV" +
       "22wYjGEhrVGWpBBKk+5QbQysLIZ4t4dv4UVVqszohTfKunPL9qK+vrG76HKN" +
       "BvNhosA2zgzRJSJ4SwlXmzRfl1gK0UiKNufCpLkewBIYv0QIGwlJu4LNGBmm" +
       "0U4LL2+NnhAZKSOMW8PlBGmJzVLajpZEKLVlSlb6eHk5aPZFe7NodKRY08Yc" +
       "EZZpTZlIjWgxdFZew5bjBcHwg4RA3HQ5t8obCzUbvhcpfY1ZqOhS4SKzn3hN" +
       "zx2T4rKNoCnKGH7FddvsVgktmgjaJtwMN2CBUXa7tIziXFVVpmWkTmvzqpTh" +
       "s+l4VikTithZV9SaHEZVoGCTTpAJ2szrhSU5s9e1pTRF13atNGCx2bDDwFtG" +
       "GepxAzbpBtnlh1OnMqusGtXlGvF52YmsCt1MJzO/jrfdiObZdY9BJEsh++gW" +
       "DxKW74wkkVsNBbOrrxdua+EZztxpdRl7CQ8EDN72NxMYa0rdKbwqqcm8MRl6" +
       "Yz3IWiBKtMTBdIALBhgwriFwReJX7mhgKRUzWbGTsIcO8GnGrTCMw2CqmWlB" +
       "RRzAYEW4NXU6wuyqIviMH+FrUhDmYqdDxhxPpmJdl9rz5Wggtrx+pk7FtWhk" +
       "bp1SfU2LUkOKejEzYuqRRXCZFhMmkiiosh7FVWB+22itIOtUG67RflgaCSnh" +
       "AUabdK+pwvSUa6PMWO+nw2m9WTVjZKDAQQOJmgHaZtylUsLsBowRbY+f1Kr6" +
       "qGHqnQnMinDsR+KaFbKlXnamIVErZyWsz1jYhHV7Kdcq4RiLBpk5ZExcWBpN" +
       "zGp6E7VnMg22UZvx9QprTRtNIE1N6GyHMx/IYqtHAcIZLcVdUQlVHjvVFdYz" +
       "o9p2NVXrkYdXW42oP6M001aWcL9Ge0RswjTieWD5gvHrcmQvKHzIVFrEOnam" +
       "zQrcMlSsGZAu7uM4/n35Fs3bd7d19FCx");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("S3Z4QHPhonnF79zF7tCu6tm8+OzhZmLxdxk6dajv2GbisfMdUP6N/cnzzl0W" +
       "39e/8KnX3tCGP4tc3P/kMEqg+5Ig/B5XX+vusaEuFfc/egjjej78o+Aa7cMY" +
       "nd7TPCL03X5J+W+3qfvvefH1BLpq6kn7cI/2iK//5Z123Y4PeBZtj4BrvE/b" +
       "+NtP25+eX3ehmOp/J9AVQBsj30Lan7xX0vKvL/w+afy3h7QLRw3YgoZrt6Hv" +
       "/ry4lEDv8+SQsOTo4KvSEY0XLr8HGh8+oPHj+zR+/NsuvguP3Kbusbx4CKhm" +
       "Ehxtf//OEW0PvwfacrKKcwuv79P2+l3QVnw9lgpP9U5C3BaUPHcbKvNxLzwJ" +
       "qLR9sFQBhJ6i8qm7oTIFynDsmG1+YPCxWw717w6iq1964/rVR98Q/sXu7MHB" +
       "YfH7GOiqsXLd40e0jt1fDiPdsAuq79sd2AoLKkoJ9Nw7HwFOoEvJwZfyCy/t" +
       "eu4l0BO365lA9+Y/x7sgCfToOV3yDy3FzfH2tQS6cbo9gFL8Hm+HJtC1o3Zg" +
       "qN3N8SZ/IYHuAU3y25fDg+8033NXh5/TCycjy6E/ekd9PhaMnj9xdKD4946D" +
       "z/yr3T94vKJ++Y0e+4PfbPzs7kiu6spZlo9ylYGu7E4HF4PmRwWePXe0g7Eu" +
       "d1781oO/dN8LB+HtwR3gIyM5hu3psw+/Ul6YFMdVs7/36C9/78+/8QfFN6X/" +
       "B1xKgdB3MwAA");
}
