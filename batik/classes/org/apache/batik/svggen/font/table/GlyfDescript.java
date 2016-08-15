package org.apache.batik.svggen.font.table;
public abstract class GlyfDescript extends org.apache.batik.svggen.font.table.Program implements org.apache.batik.svggen.font.table.GlyphDescription {
    public static final byte onCurve = 1;
    public static final byte xShortVector = 2;
    public static final byte yShortVector = 4;
    public static final byte repeat = 8;
    public static final byte xDual = 16;
    public static final byte yDual = 32;
    protected org.apache.batik.svggen.font.table.GlyfTable parentTable;
    private int numberOfContours;
    private short xMin;
    private short yMin;
    private short xMax;
    private short yMax;
    protected GlyfDescript(org.apache.batik.svggen.font.table.GlyfTable parentTable,
                           short numberOfContours,
                           java.io.ByteArrayInputStream bais) { super(
                                                                  );
                                                                this.
                                                                  parentTable =
                                                                  parentTable;
                                                                this.
                                                                  numberOfContours =
                                                                  numberOfContours;
                                                                xMin =
                                                                  (short)
                                                                    (bais.
                                                                       read(
                                                                         ) <<
                                                                       8 |
                                                                       bais.
                                                                       read(
                                                                         ));
                                                                yMin =
                                                                  (short)
                                                                    (bais.
                                                                       read(
                                                                         ) <<
                                                                       8 |
                                                                       bais.
                                                                       read(
                                                                         ));
                                                                xMax =
                                                                  (short)
                                                                    (bais.
                                                                       read(
                                                                         ) <<
                                                                       8 |
                                                                       bais.
                                                                       read(
                                                                         ));
                                                                yMax =
                                                                  (short)
                                                                    (bais.
                                                                       read(
                                                                         ) <<
                                                                       8 |
                                                                       bais.
                                                                       read(
                                                                         ));
    }
    public void resolve() {  }
    public int getNumberOfContours() { return numberOfContours;
    }
    public short getXMaximum() { return xMax; }
    public short getXMinimum() { return xMin; }
    public short getYMaximum() { return yMax; }
    public short getYMinimum() { return yMin; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vumqKtF4mNjiuy8PXc2b2Br6LyBl0upmJgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Q/GId1+8992l7tEiubYXb3nb1Tt3/d0Q");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("b3go3vDdF++Zu9Q9VyQfOBLvtqv35L2Il8WVB0/fuCzujj1+yxXv/bVk5edf" +
       "v3blsdfn/6G8dHh8dfh+unJFTxzn9NWSU/nLQajpZin0/fuLJkEpyQtx5bm3" +
       "dpBx5VL5WwA/99F9z5fiypN36wlIt/g53QWOK4/doUtxr6TMnG6PxJXrZ9sD" +
       "KOXv6XbNuHL1pB0Yap853aQ46AVNimwnOAoNXnwboQEb+mvgbrNzp5z6oT2W" +
       "JPTIW63zcZfTVyOLQKC86X/ktJP9Xf9XlK++To1/4NutL++vZiqOvNsVo1yh" +
       "K/ftb4keO/5n7zja0ViXhy9896FfuP9DR0HKQ3vAJ3vjFLanb38JsucGcXlt" +
       "cfcrj/3ix/7x639QXhf6f20KKYmCMQAA");
}
