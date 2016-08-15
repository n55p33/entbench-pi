package org.apache.batik.ext.awt.image.codec.util;
public abstract class SimpleRenderedImage implements java.awt.image.RenderedImage {
    protected int minX;
    protected int minY;
    protected int width;
    protected int height;
    protected int tileWidth;
    protected int tileHeight;
    protected int tileGridXOffset = 0;
    protected int tileGridYOffset = 0;
    protected java.awt.image.SampleModel sampleModel = null;
    protected java.awt.image.ColorModel colorModel = null;
    protected java.util.List sources = new java.util.ArrayList();
    protected java.util.Map properties = new java.util.HashMap();
    public SimpleRenderedImage() { super(); }
    public int getMinX() { return minX; }
    public final int getMaxX() { return getMinX() + getWidth(); }
    public int getMinY() { return minY; }
    public final int getMaxY() { return getMinY() + getHeight(); }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public java.awt.Rectangle getBounds() { return new java.awt.Rectangle(
                                              getMinX(
                                                ),
                                              getMinY(
                                                ),
                                              getWidth(
                                                ),
                                              getHeight(
                                                )); }
    public int getTileWidth() { return tileWidth; }
    public int getTileHeight() { return tileHeight; }
    public int getTileGridXOffset() { return tileGridXOffset; }
    public int getTileGridYOffset() { return tileGridYOffset; }
    public int getMinTileX() { return XToTileX(getMinX()); }
    public int getMaxTileX() { return XToTileX(getMaxX() - 1); }
    public int getNumXTiles() { return getMaxTileX() - getMinTileX() + 1;
    }
    public int getMinTileY() { return YToTileY(getMinY()); }
    public int getMaxTileY() { return YToTileY(getMaxY() - 1); }
    public int getNumYTiles() { return getMaxTileY() - getMinTileY() + 1;
    }
    public java.awt.image.SampleModel getSampleModel() { return sampleModel;
    }
    public java.awt.image.ColorModel getColorModel() { return colorModel;
    }
    public java.lang.Object getProperty(java.lang.String name) { name = name.
                                                                          toLowerCase(
                                                                            );
                                                                 return properties.
                                                                   get(
                                                                     name);
    }
    public java.lang.String[] getPropertyNames() { java.lang.String[] names =
                                                     new java.lang.String[properties.
                                                                            size(
                                                                              )];
                                                   properties.
                                                     keySet(
                                                       ).
                                                     toArray(
                                                       names);
                                                   return names;
    }
    public java.lang.String[] getPropertyNames(java.lang.String prefix) {
        java.lang.String[] propertyNames =
          getPropertyNames(
            );
        if (propertyNames ==
              null) {
            return null;
        }
        prefix =
          prefix.
            toLowerCase(
              );
        java.util.List names =
          new java.util.ArrayList(
          );
        for (int i =
               0;
             i <
               propertyNames.
                 length;
             i++) {
            if (propertyNames[i].
                  startsWith(
                    prefix)) {
                names.
                  add(
                    propertyNames[i]);
            }
        }
        if (names.
              size(
                ) ==
              0) {
            return null;
        }
        java.lang.String[] prefixNames =
          new java.lang.String[names.
                                 size(
                                   )];
        names.
          toArray(
            prefixNames);
        return prefixNames;
    }
    public static int XToTileX(int x, int tileGridXOffset,
                               int tileWidth) {
        x -=
          tileGridXOffset;
        if (x <
              0) {
            x +=
              1 -
                tileWidth;
        }
        return x /
          tileWidth;
    }
    public static int YToTileY(int y, int tileGridYOffset,
                               int tileHeight) {
        y -=
          tileGridYOffset;
        if (y <
              0) {
            y +=
              1 -
                tileHeight;
        }
        return y /
          tileHeight;
    }
    public int XToTileX(int x) { return XToTileX(
                                          x,
                                          getTileGridXOffset(
                                            ),
                                          getTileWidth(
                                            ));
    }
    public int YToTileY(int y) { return YToTileY(
                                          y,
                                          getTileGridYOffset(
                                            ),
                                          getTileHeight(
                                            ));
    }
    public static int tileXToX(int tx, int tileGridXOffset,
                               int tileWidth) {
        return tx *
          tileWidth +
          tileGridXOffset;
    }
    public static int tileYToY(int ty, int tileGridYOffset,
                               int tileHeight) {
        return ty *
          tileHeight +
          tileGridYOffset;
    }
    public int tileXToX(int tx) { return tx *
                                    tileWidth +
                                    tileGridXOffset;
    }
    public int tileYToY(int ty) { return ty *
                                    tileHeight +
                                    tileGridYOffset;
    }
    public java.util.Vector getSources() {
        return null;
    }
    public java.awt.image.Raster getData() {
        java.awt.Rectangle rect =
          new java.awt.Rectangle(
          getMinX(
            ),
          getMinY(
            ),
          getWidth(
            ),
          getHeight(
            ));
        return getData(
                 rect);
    }
    public java.awt.image.Raster getData(java.awt.Rectangle bounds) {
        int startX =
          XToTileX(
            bounds.
              x);
        int startY =
          YToTileY(
            bounds.
              y);
        int endX =
          XToTileX(
            bounds.
              x +
              bounds.
                width -
              1);
        int endY =
          YToTileY(
            bounds.
              y +
              bounds.
                height -
              1);
        java.awt.image.Raster tile;
        if (startX ==
              endX &&
              startY ==
              endY) {
            tile =
              getTile(
                startX,
                startY);
            return tile.
              createChild(
                bounds.
                  x,
                bounds.
                  y,
                bounds.
                  width,
                bounds.
                  height,
                bounds.
                  x,
                bounds.
                  y,
                null);
        }
        else {
            java.awt.image.SampleModel sm =
              sampleModel.
              createCompatibleSampleModel(
                bounds.
                  width,
                bounds.
                  height);
            java.awt.image.WritableRaster dest =
              java.awt.image.Raster.
              createWritableRaster(
                sm,
                bounds.
                  getLocation(
                    ));
            for (int j =
                   startY;
                 j <=
                   endY;
                 j++) {
                for (int i =
                       startX;
                     i <=
                       endX;
                     i++) {
                    tile =
                      getTile(
                        i,
                        j);
                    java.awt.Rectangle intersectRect =
                      bounds.
                      intersection(
                        tile.
                          getBounds(
                            ));
                    java.awt.image.Raster liveRaster =
                      tile.
                      createChild(
                        intersectRect.
                          x,
                        intersectRect.
                          y,
                        intersectRect.
                          width,
                        intersectRect.
                          height,
                        intersectRect.
                          x,
                        intersectRect.
                          y,
                        null);
                    dest.
                      setDataElements(
                        0,
                        0,
                        liveRaster);
                }
            }
            return dest;
        }
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster dest) {
        java.awt.Rectangle bounds;
        java.awt.image.Raster tile;
        if (dest ==
              null) {
            bounds =
              getBounds(
                );
            java.awt.Point p =
              new java.awt.Point(
              minX,
              minY);
            java.awt.image.SampleModel sm =
              sampleModel.
              createCompatibleSampleModel(
                width,
                height);
            dest =
              java.awt.image.Raster.
                createWritableRaster(
                  sm,
                  p);
        }
        else {
            bounds =
              dest.
                getBounds(
                  );
        }
        int startX =
          XToTileX(
            bounds.
              x);
        int startY =
          YToTileY(
            bounds.
              y);
        int endX =
          XToTileX(
            bounds.
              x +
              bounds.
                width -
              1);
        int endY =
          YToTileY(
            bounds.
              y +
              bounds.
                height -
              1);
        for (int j =
               startY;
             j <=
               endY;
             j++) {
            for (int i =
                   startX;
                 i <=
                   endX;
                 i++) {
                tile =
                  getTile(
                    i,
                    j);
                java.awt.Rectangle intersectRect =
                  bounds.
                  intersection(
                    tile.
                      getBounds(
                        ));
                java.awt.image.Raster liveRaster =
                  tile.
                  createChild(
                    intersectRect.
                      x,
                    intersectRect.
                      y,
                    intersectRect.
                      width,
                    intersectRect.
                      height,
                    intersectRect.
                      x,
                    intersectRect.
                      y,
                    null);
                dest.
                  setDataElements(
                    0,
                    0,
                    liveRaster);
            }
        }
        return dest;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVcDZQU1ZV+3cPPMDA/DP8/M/Iz6AF0WolsIKPEYfgb0gPj" +
       "zIgwiENNdc1MQXVXUVU902CIaM4KiUeOi/iXEzExKEZBXE9MNhoNWXfFrK7n" +
       "YIhGPSjZbLIYdcVE3R93N3vve6+6qqv7PWhj7/Y59bq63rvv3fu9e+9779Z7" +
       "ffh9MtyxSb2Wchvd7ZbmNC5Pue2K7WiJFkNxnC541qPeXab88fozaxZHyYhu" +
       "UjWgOG2q4mgrdM1ION2kTk85rpJSNWeNpiWQot3WHM0eVFzdTHWTCbrTmrQM" +
       "XdXdNjOhYYF1ih0nYxXXtfXetKu18gpcUhcHTmKUk1hzOLspTsaoprXdLz45" +
       "ULwlkIMlk35bjktq4luUQSWWdnUjFtcdtyljk/mWaWzvN0y3Ucu4jVuMhRyC" +
       "1fGFeRDMerz6k09vH6ihEIxTUinTpeI5HZpjGoNaIk6q/afLDS3pbCNfI2Vx" +
       "MjpQ2CUNca/RGDQag0Y9af1SwH2llkonW0wqjuvVNMJSkSGXzMytxFJsJcmr" +
       "aac8Qw3lLpedEoO0M7LSMinzRLxzfmz/3dfXPFFGqrtJtZ7qRHZUYMKFRroB" +
       "UC3Zq9lOcyKhJbrJ2BR0dqdm64qh7+A9Xevo/SnFTUP3e7Dgw7Sl2bRNHyvo" +
       "R5DNTquuaWfF66MKxX8N7zOUfpB1oi8rk3AFPgcBK3RgzO5TQO84ybCteirh" +
       "kgvCFFkZG74CBYB0ZFJzB8xsU8NSCjwgtUxFDCXVH+sE1Uv1Q9HhJiig7ZKp" +
       "wkoRa0tRtyr9Wg9qZKhcO8uCUqMoEEjikgnhYrQm6KWpoV4K9M/7a67Ye0Nq" +
       "VSpKIsBzQlMN5H80ENWHiDq0Ps3WwA4Y4Zh58buUic/siRIChSeECrMyP/rq" +
       "h1ddXH/sBVZmWoEya3u3aKrbox7srToxvWXu4jJko9wyHR07P0dyamXtPKcp" +
       "Y4GHmZitETMbvcxjHc9v2PWI9m6UVLSSEapppJOgR2NVM2nphmav1FKarbha" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Gc06tbQYrrCaiAyXZDKBadQuYxyfRzFE");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("X3pxBapSNrAhw2m2+DamjvCl2AITHniJeK2mD4w99MqRTaBeuzgzi0w6iOwy" +
       "J08dvFUOvWKLoZY6Z5nGDOsPyILqtTBPs7qlYWoKU7Nkzbph19cbPLDUAcew" +
       "yDwYDMziMKlXDJFgpstJ0YgQz2tMxhW5PqCrXX2FTxEqUdkqU/H5RsPGbD0Y" +
       "ceHIDpNWOpOtkdYvkXCBJTujaKR3klF7ogL+PCO3q4gprRAxodr91XDVtqvy" +
       "0G7n/U4QTwweKzVS0AeMlEdD2zKTGJmz6YTA8uOeHyoztKn4HN2cmgWXMuoj" +
       "Dsec0jRotoNU9pmOjWpYdbaQV6TJTcuuVAAxdKcZpcioU3cJuYNoYEIvyoHd" +
       "bwk8MVqRdYrAOhScNCaLZBh2RwNMT3gRU8SwbONih69jILjM1wRn2MDSCWzN" +
       "kw7JolgrHow5L1TcQVMxVNqYzgo8NpNxsmtWYaM+FhN+UIiLtF8YEHSvTAtg" +
       "Zpr2cIaZmDWft8rTGk4VU0afosTCCpllhS8ZA4xyCZ5c2EVTa8K1ZqKlKlJV" +
       "7UhlTS8MzBYsMaxd4Y1WudjotgcNWE01iG0s0oYUobWhEy7jsBG506m7YNu1" +
       "mkXMsaKBjoiG0LcmIuKVlVWNN6C4N2a44ZwTpAWj9dR0MERK1ThtE+3iEA+H" +
       "ZafjDghk0Ig78AJmEwhvE3kSDESjzqjlFgcC0sWGo14ymxAI1Q3QNDGg7qJv" +
       "9NFJiHVoV2gKiYpLhFwTKn2UsQyxmwyCChBGly/N5sVBf4pgwDGP2ny12xJo" +
       "nYc6i2SWJu3A0aEJnGK9FWHYfKWJ1NygKru0BnXiBOopbLdtMzy78pPVJAzL" +
       "Md2Q6oPpoOUumDTq1LupXulWUWESNQbhuNpGy92Cb/Qa6IRftcuLOjSNO1MB" +
       "GMCq0E1njeUS9gfNRnWGS7oCt0sGupjD0ggZSfn2uKUopG2jsNBbMr2BzZdp" +
       "PI/2bY9hrETAF3q3TtkVtlTl1aTcsqZzMEkMB6lL1VHTr2Klfq9fXtSEpcvL" +
       "uu/7hjPzonmr700mbCtmhwGT9urtaWVY6DbiOtdnq7yYV6CypyvjQFrMEiKF" +
       "Lb+BjYcNJ0VKodBl5FlJxioTxxbKs1pl2imqPENNVlqpUF1gI7m2AnObWSfs" +
       "QO1COWETm+qjw6ioTgJvTkis1S6lkBY0+3Ctka4KM95zmCU6ZXTeXca9Mjwq" +
       "catx5DnKaDEDnm1UXFolECyoFK1IJViRy7TWdKBhQjpoF6uqxBICM6ikEeXD" +
       "SX451AKvNCr0q7owwfIdN8aUaFYee6LTVmYgEMfLdmeCjMQIHffyKjdNJ6I7" +
       "xQ0QHhFGjQQhGQst64gdQj1aHUgQUgAzkiHsU1GxZyhjLg1tD0rcwFGaA5gY" +
       "2cZwVsdrSUBKBdWqV8iGLnnTQr6+kvr1ejU/U83VXO96/VVaHMps3ozKs3Jd" +
       "q7d43eK9aIwjCPK67BXBL9zYq4v71m9pDpdFz+xalvGpG3g7kV77hvvbt0N3" +
       "ilIYBaIc7Rbcrf8u5k6ssz3yRuvIKqy9g9dFD594cXps6Wi2XuaR09ZLr9fK" +
       "fPQdzzyrDH60ePD+kMhWL3j+t9rqYvtydnO/x0FLrzn9jSS5Xi6+W3r12Xf8" +
       "wUPs640338CC0lecwHmyyZ8gn/vlzqvl9+/nbjlciHXVQvbjlS4fX351IVCj" +
       "OHDZY4uwHjkUfyb53APg4Lfi50++UNxp/9pvLb95Yz1nrCD83TPyvpglvxXl" +
       "7tDViDRdPvuJ72ztt1/oTdjR9tYXPn9I7aXZxWx5i7SlJt0Atf3DLvLJF+T3" +
       "B2fk/WGW/PctPzE9ye/3boLfoer0LT/9/FX3Z2fk/UWWfPVQddMT1P74PFQ3" +
       "31Kbf31Ut7d/Rt6t2cW/PFTdSX5/dbOqy5bMLbb8Fueuur17zsi7N0vuAv4Y" +
       "UNst2TrktnfhZrlli+/esuX2lvPn9tAZeQ9nCRgj7gLcjqz72pF74GYNM1sD" +
       "/7YtubedP7lXn5GXmfXeKzfkml7sKuHBkHj/4ZA4UmUwEOi2uqP8+M3q8xvB" +
       "8b1byt97/pQrZ+RVswSKci8ClNljSwx3/Ao3yy/zNe/Z8nvP+fN74xl5zSy5" +
       "HOVevOV3TZv9tpsl+EpwvH9L8P3nT5A4I4/Kkg6w0C3Bk4sedyy758Hyw1uW" +
       "Hz5/lvwZeUKWMMdZTq/Jkr1Zlg+B4yNblh85f5bKGXlallyJcndvxvyM6ImQ" +
       "Zu8FFyBfD72f2tL7qfOn55+Rl22x2LO29MT0WvTs83Cln97S+/T503vrGXnf" +
       "mSXJxpVSscNn/MIT/NLzUN/Pb/n9/Pnze/cZed+XJe88Zp0nora97z4Pep/d" +
       "0vvs+dN75oy8D2bJ9x+zzpP03nce1vm5Lb3PnT+9f3RG3key5AcPrXN6Lev8" +
       "oZvgl8XbuVeB4/Nbfp8/f37PnZH38Sz5sSh3D+B3Yn36u3YMf/wmGGaTwdwT" +
       "4PidLcPfOX+Gnzkj719myT/bhDLH17K/b0fwUzdBMFvZvd4a8qUtwS+dD8G9" +
       "XYFPrZn8whksfzFL/vWmG9KbhdrLdcHj65g3++d2vJ+/Cd7fkF18Ehx/suX9" +
       "J+ev2F8/I+83suTfA3pHKFOis94XcMaS/fUW1M2S/Wf/6RO/9l3PPvGf17s4" +
       "7zTDsRgggX6NLxscqfOV577w5V9/8SMfX+90Xu8nyLBdOPlJiKu/+HDsQw5r" +
       "4i86LsrMie9tRbn+H+WuXL098LWPzWMxNOexF6nfvNko/Nhmeftj68Xtj22W" +
       "qn/7mx4jB230CoWQKPPY6x5z1WSb8xbRkZ7+9kuXLr3p8lO+vwbyqZM2t/6d" +
       "refe+63tHoG9/3htPV71XCPK3W6rrr7bcLX3m3562P7+ptKBZb5kZ5kt23PV" +
       "bJPxQd5mk73pXTr8cAfITK+J9PMbpOubbWBmyateyLh+/4y8L2fJ70W52+QM" +
       "14bGGcX/57a7rDvVr51Dp9q7Z2sI93ydnMmfn8Hmf2fJH1+jZ+0kvCb6v252" +
       "WHgUQKpsiVZugOjO6n7mmmxv2b1RwHdJVnT/ltN579+WkfqrKHcnz3rXCrP/" +
       "+jz4bjcQ7l21gfDrw/fiGXzvy5ILgO90w/dE4LZ/9zk8TdwbbvkOz92QNwS/" +
       "8QyCj2TJA6cqdP9l50HwTVuCb/o6EfymMwg+lSWPn67BJ87DYrUtQe1vx2LL" +
       "Z/CFs+QS4JvtBQVKPalQ6Dz4elu+3t8O3zecwRfJktdu+QIdn9Tv5fMw4O0z" +
       "8b1zeiZ+lQH3zyBIZgl2ukI750HwXVuC7/o6EZycQTDT2P7odA0yNzvzeBhA" +
       "2T4l3jv/p8T78hl5WVy0/x1R7kI2edzuyc3K7baGrj/Pc99ZCA/CvXt3W0PH" +
       "avZxlKxtcyenKzcrp5eDu//IFsWPnL+cwjPy4ixxNy/t2mIkHnB+6ckVA2II" +
       "Jg07zt55cP7ZLeefPW/j33vNmtzbzyD+zix564549jPZ8Xv6Jvhls6Xc4wDJ" +
       "V7b8vnKu/A5U9MgJFU0CM8omIhtVrUn+/TME8A+y5N2g98uevzyQwHt3Evi7" +
       "NyKBFEyYrvFVsuwTSw9e9cHEzUf+5I8/e/HOlz3L/YfNdPXgQ3x3Ebk7tdi2" +
       "j34R58j57X6gauZaPHet03vW88T9D0W5p677A2pR7tbsX8Zi/wc29X8wyj15" +
       "PfWzaVf2/2jdZ6Pco2fXBbXW/4/W+sdR7sHTakW5W0B6tPRHwazzWqVBSZAe" +
       "LfljwGGdLAnuv/5/tNxPAue4KwfmxpuTo0U+BloHRbLTj69n2r+UbqzvwaOG" +
       "v367f/8LWcthlaNfH8vorj+7ebCcJ6a330b4xLM49ZavVn908/Uz2RZXq6yV" +
       "O4ncHZsPsa0bzZYEvfLU1g7aur371Nfu+em7XnWwfOmeDeBdJzyC7RXX/tQY" +
       "6vjR+uNgq8+87FPf9mPP/u561/v/A8QSTdAPVQAA");
}
