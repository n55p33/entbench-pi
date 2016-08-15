package org.apache.batik.svggen.font;
public class Font {
    private java.lang.String path;
    private org.apache.batik.svggen.font.table.TableDirectory tableDirectory =
      null;
    private org.apache.batik.svggen.font.table.Table[] tables;
    private org.apache.batik.svggen.font.table.Os2Table os2;
    private org.apache.batik.svggen.font.table.CmapTable cmap;
    private org.apache.batik.svggen.font.table.GlyfTable glyf;
    private org.apache.batik.svggen.font.table.HeadTable head;
    private org.apache.batik.svggen.font.table.HheaTable hhea;
    private org.apache.batik.svggen.font.table.HmtxTable hmtx;
    private org.apache.batik.svggen.font.table.LocaTable loca;
    private org.apache.batik.svggen.font.table.MaxpTable maxp;
    private org.apache.batik.svggen.font.table.NameTable name;
    private org.apache.batik.svggen.font.table.PostTable post;
    public Font() { super(); }
    public org.apache.batik.svggen.font.table.Table getTable(int tableType) {
        for (int i =
               0;
             i <
               tables.
                 length;
             i++) {
            if (tables[i] !=
                  null &&
                  tables[i].
                  getType(
                    ) ==
                  tableType) {
                return tables[i];
            }
        }
        return null;
    }
    public org.apache.batik.svggen.font.table.Os2Table getOS2Table() { return os2;
    }
    public org.apache.batik.svggen.font.table.CmapTable getCmapTable() {
        return cmap;
    }
    public org.apache.batik.svggen.font.table.HeadTable getHeadTable() {
        return head;
    }
    public org.apache.batik.svggen.font.table.HheaTable getHheaTable() {
        return hhea;
    }
    public org.apache.batik.svggen.font.table.HmtxTable getHmtxTable() {
        return hmtx;
    }
    public org.apache.batik.svggen.font.table.LocaTable getLocaTable() {
        return loca;
    }
    public org.apache.batik.svggen.font.table.MaxpTable getMaxpTable() {
        return maxp;
    }
    public org.apache.batik.svggen.font.table.NameTable getNameTable() {
        return name;
    }
    public org.apache.batik.svggen.font.table.PostTable getPostTable() {
        return post;
    }
    public int getAscent() { return hhea.getAscender(); }
    public int getDescent() { return hhea.getDescender(); }
    public int getNumGlyphs() { return maxp.getNumGlyphs(); }
    public org.apache.batik.svggen.font.Glyph getGlyph(int i) { return glyf.
                                                                  getDescription(
                                                                    i) !=
                                                                  null
                                                                  ? new org.apache.batik.svggen.font.Glyph(
                                                                  glyf.
                                                                    getDescription(
                                                                      i),
                                                                  hmtx.
                                                                    getLeftSideBearing(
                                                                      i),
                                                                  hmtx.
                                                                    getAdvanceWidth(
                                                                      i))
                                                                  : null;
    }
    public java.lang.String getPath() { return path;
    }
    public org.apache.batik.svggen.font.table.TableDirectory getTableDirectory() {
        return tableDirectory;
    }
    protected void read(java.lang.String pathName) {
        path =
          pathName;
        java.io.File f =
          new java.io.File(
          pathName);
        if (!f.
              exists(
                )) {
            return;
        }
        try {
            java.io.RandomAccessFile raf =
              new java.io.RandomAccessFile(
              f,
              "r");
            tableDirectory =
              new org.apache.batik.svggen.font.table.TableDirectory(
                raf);
            tables =
              (new org.apache.batik.svggen.font.table.Table[tableDirectory.
                                                              getNumTables(
                                                                )]);
            for (int i =
                   0;
                 i <
                   tableDirectory.
                   getNumTables(
                     );
                 i++) {
                tables[i] =
                  org.apache.batik.svggen.font.table.TableFactory.
                    create(
                      tableDirectory.
                        getEntry(
                          i),
                      raf);
            }
            raf.
              close(
                );
            os2 =
              (org.apache.batik.svggen.font.table.Os2Table)
                getTable(
                  org.apache.batik.svggen.font.table.Table.
                    OS_2);
            cmap =
              (org.apache.batik.svggen.font.table.CmapTable)
                getTable(
                  org.apache.batik.svggen.font.table.Table.
                    cmap);
            glyf =
              (org.apache.batik.svggen.font.table.GlyfTable)
                getTable(
                  org.apache.batik.svggen.font.table.Table.
                    glyf);
            head =
              (org.apache.batik.svggen.font.table.HeadTable)
                getTable(
                  org.apache.batik.svggen.font.table.Table.
                    head);
            hhea =
              (org.apache.batik.svggen.font.table.HheaTable)
                getTable(
                  org.apache.batik.svggen.font.table.Table.
                    hhea);
            hmtx =
              (org.apache.batik.svggen.font.table.HmtxTable)
                getTable(
                  org.apache.batik.svggen.font.table.Table.
                    hmtx);
            loca =
              (org.apache.batik.svggen.font.table.LocaTable)
                getTable(
                  org.apache.batik.svggen.font.table.Table.
                    loca);
            maxp =
              (org.apache.batik.svggen.font.table.MaxpTable)
                getTable(
                  org.apache.batik.svggen.font.table.Table.
                    maxp);
            name =
              (org.apache.batik.svggen.font.table.NameTable)
                getTable(
                  org.apache.batik.svggen.font.table.Table.
                    name);
            post =
              (org.apache.batik.svggen.font.table.PostTable)
                getTable(
                  org.apache.batik.svggen.font.table.Table.
                    post);
            hmtx.
              init(
                hhea.
                  getNumberOfHMetrics(
                    ),
                maxp.
                  getNumGlyphs(
                    ) -
                  hhea.
                  getNumberOfHMetrics(
                    ));
            loca.
              init(
                maxp.
                  getNumGlyphs(
                    ),
                head.
                  getIndexToLocFormat(
                    ) ==
                  0);
            glyf.
              init(
                maxp.
                  getNumGlyphs(
                    ),
                loca);
        }
        catch (java.io.IOException e) {
            e.
              printStackTrace(
                );
        }
    }
    public static org.apache.batik.svggen.font.Font create() {
        return new org.apache.batik.svggen.font.Font(
          );
    }
    public static org.apache.batik.svggen.font.Font create(java.lang.String pathName) {
        org.apache.batik.svggen.font.Font f =
          new org.apache.batik.svggen.font.Font(
          );
        f.
          read(
            pathName);
        return f;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "1eglTDcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "iwNUJzRkIgpTRFvpXlnXZ/igOW32rJ7P");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "+I23/fIzf7L5qvH/A6zbTuLEQgAA");
}
