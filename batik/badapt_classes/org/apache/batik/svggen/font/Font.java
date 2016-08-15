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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "zJKiq0w3AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1slAhLIog5BAq43RCSVkkZkVS6xYq1fl");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "jf8PurdZ+8RCAAA=");
}
