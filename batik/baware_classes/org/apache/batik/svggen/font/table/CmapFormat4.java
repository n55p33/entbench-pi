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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "WJ/g5iAah4tWd1lZl2dtq6+1bNzFcfz7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("8i2at+9u6+ihYpfs8IAm0Gye8Tt3sTu0y3o2Tz57uJlY/F2GTh3qO7aZeOx8" +
       "B5R/Y3/yvHOXxff1L3zqtTdU7mcqF/c/OQxj6L7Y87/H1taafaypS8X9Xz2E" +
       "cT1v/lFwDfdhDE/vaR4J+m6/pPy32+T99zz5egxd1bWYOtyjPdLrf32nXbfj" +
       "DZ4l2yPgGu3LNvr2y/an5+ddKLr63zF0BcjWl28R7U/eq2j515fxvmjjb49o" +
       "F44KDAoZrt1Gvvvz5FIMvc+RfcKQw4OvSkcyXrj8HmR8+EDGT+zL+Ilv+/Bd" +
       "eOQ2eY/lyUPANGPvaPv7d45ke/g9yJaLVZxbeH1fttfvQrbi6/G8YKp3GsRt" +
       "Iclzt5Eyb/fCk0BK040nuaCnpHzqbqRMgTEcO2abHxh87JZD/buD6MqX3rh+" +
       "9dE3hH+5O3twcFj8vj50dZnY9vEjWsfuL/uhtjQLqe/bHdjyCylKMfTcOx8B" +
       "jqFL8cGX8gsv7WruxdATt6sZQ/fmP8erVGLo0XOq5B9aipvj5ZEYunG6PIBS" +
       "/B4vh8bQtaNyoKndzfEifyGG7gFF8tuX/YPvNN9zV4ef0wsnZ5ZDPnpHez42" +
       "GT1/4uhA8e8dB5/5k90/eLyifPmN3uAHvtn4md2RXMWWsyxv5WofurI7HVw0" +
       "mh8VePbc1g7autx98VsP/tJ9LxxMbw/uAB85yTFsT599+JV0/Lg4rpr9/Ud/" +
       "+Xt/7o0/KL4p/T+p6kN3dzMAAA==");
}
