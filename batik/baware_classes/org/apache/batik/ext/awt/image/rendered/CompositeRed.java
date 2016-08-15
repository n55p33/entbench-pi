package org.apache.batik.ext.awt.image.rendered;
public class CompositeRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    org.apache.batik.ext.awt.image.CompositeRule rule;
    java.awt.CompositeContext[] contexts;
    public CompositeRed(java.util.List srcs, org.apache.batik.ext.awt.image.CompositeRule rule) {
        super(
          );
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            srcs.
            get(
              0);
        java.awt.image.ColorModel cm =
          fixColorModel(
            src);
        this.
          rule =
          rule;
        org.apache.batik.ext.awt.image.SVGComposite comp =
          new org.apache.batik.ext.awt.image.SVGComposite(
          rule);
        contexts =
          (new java.awt.CompositeContext[srcs.
                                           size(
                                             )]);
        int idx =
          0;
        java.util.Iterator i =
          srcs.
          iterator(
            );
        java.awt.Rectangle myBounds =
          null;
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.image.rendered.CachableRed cr =
              (org.apache.batik.ext.awt.image.rendered.CachableRed)
                i.
                next(
                  );
            contexts[idx++] =
              comp.
                createContext(
                  cr.
                    getColorModel(
                      ),
                  cm,
                  null);
            java.awt.Rectangle newBound =
              cr.
              getBounds(
                );
            if (myBounds ==
                  null) {
                myBounds =
                  newBound;
                continue;
            }
            switch (rule.
                      getRule(
                        )) {
                case org.apache.batik.ext.awt.image.CompositeRule.
                       RULE_IN:
                    if (myBounds.
                          intersects(
                            newBound))
                        myBounds =
                          myBounds.
                            intersection(
                              newBound);
                    else {
                        myBounds.
                          width =
                          0;
                        myBounds.
                          height =
                          0;
                    }
                    break;
                case org.apache.batik.ext.awt.image.CompositeRule.
                       RULE_OUT:
                    myBounds =
                      newBound;
                    break;
                default:
                    myBounds.
                      add(
                        newBound);
            }
        }
        if (myBounds ==
              null)
            throw new java.lang.IllegalArgumentException(
              "Composite Operation Must have some source!");
        if (rule.
              getRule(
                ) ==
              org.apache.batik.ext.awt.image.CompositeRule.
                RULE_ARITHMETIC) {
            java.util.List vec =
              new java.util.ArrayList(
              srcs.
                size(
                  ));
            i =
              srcs.
                iterator(
                  );
            while (i.
                     hasNext(
                       )) {
                org.apache.batik.ext.awt.image.rendered.CachableRed cr =
                  (org.apache.batik.ext.awt.image.rendered.CachableRed)
                    i.
                    next(
                      );
                java.awt.Rectangle r =
                  cr.
                  getBounds(
                    );
                if (r.
                      x !=
                      myBounds.
                        x ||
                      r.
                        y !=
                      myBounds.
                        y ||
                      r.
                        width !=
                      myBounds.
                        width ||
                      r.
                        height !=
                      myBounds.
                        height)
                    cr =
                      new org.apache.batik.ext.awt.image.rendered.PadRed(
                        cr,
                        myBounds,
                        org.apache.batik.ext.awt.image.PadMode.
                          ZERO_PAD,
                        null);
                vec.
                  add(
                    cr);
            }
            srcs =
              vec;
        }
        java.awt.image.SampleModel sm =
          fixSampleModel(
            src,
            cm,
            myBounds);
        int defSz =
          org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
          getDefaultTileSize(
            );
        int tgX =
          defSz *
          (int)
            java.lang.Math.
            floor(
              myBounds.
                x /
                defSz);
        int tgY =
          defSz *
          (int)
            java.lang.Math.
            floor(
              myBounds.
                y /
                defSz);
        init(
          srcs,
          myBounds,
          cm,
          sm,
          tgX,
          tgY,
          null);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        genRect(
          wr);
        return wr;
    }
    public java.awt.image.Raster getTile(int x, int y) { int tx =
                                                           tileGridXOff +
                                                           x *
                                                           tileWidth;
                                                         int ty =
                                                           tileGridYOff +
                                                           y *
                                                           tileHeight;
                                                         java.awt.Point pt =
                                                           new java.awt.Point(
                                                           tx,
                                                           ty);
                                                         java.awt.image.WritableRaster wr =
                                                           java.awt.image.Raster.
                                                           createWritableRaster(
                                                             sm,
                                                             pt);
                                                         genRect(
                                                           wr);
                                                         return wr;
    }
    public void emptyRect(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter zr =
          org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter.
          getZeroRecter(
            wr);
        zr.
          zeroRect(
            new java.awt.Rectangle(
              wr.
                getMinX(
                  ),
              wr.
                getMinY(
                  ),
              wr.
                getWidth(
                  ),
              wr.
                getHeight(
                  )));
    }
    public void genRect(java.awt.image.WritableRaster wr) {
        java.awt.Rectangle r =
          wr.
          getBounds(
            );
        int idx =
          0;
        java.util.Iterator i =
          srcs.
          iterator(
            );
        boolean first =
          true;
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.image.rendered.CachableRed cr =
              (org.apache.batik.ext.awt.image.rendered.CachableRed)
                i.
                next(
                  );
            if (first) {
                java.awt.Rectangle crR =
                  cr.
                  getBounds(
                    );
                if (r.
                      x <
                      crR.
                        x ||
                      r.
                        y <
                      crR.
                        y ||
                      r.
                        x +
                      r.
                        width >
                      crR.
                        x +
                      crR.
                        width ||
                      r.
                        y +
                      r.
                        height >
                      crR.
                        y +
                      crR.
                        height)
                    emptyRect(
                      wr);
                cr.
                  copyData(
                    wr);
                if (!cr.
                      getColorModel(
                        ).
                      isAlphaPremultiplied(
                        ))
                    org.apache.batik.ext.awt.image.GraphicsUtil.
                      coerceData(
                        wr,
                        cr.
                          getColorModel(
                            ),
                        true);
                first =
                  false;
            }
            else {
                java.awt.Rectangle crR =
                  cr.
                  getBounds(
                    );
                if (crR.
                      intersects(
                        r)) {
                    java.awt.Rectangle smR =
                      crR.
                      intersection(
                        r);
                    java.awt.image.Raster ras =
                      cr.
                      getData(
                        smR);
                    java.awt.image.WritableRaster smWR =
                      wr.
                      createWritableChild(
                        smR.
                          x,
                        smR.
                          y,
                        smR.
                          width,
                        smR.
                          height,
                        smR.
                          x,
                        smR.
                          y,
                        null);
                    contexts[idx].
                      compose(
                        ras,
                        smWR,
                        smWR);
                }
            }
            idx++;
        }
    }
    public void genRect_OVER(java.awt.image.WritableRaster wr) {
        java.awt.Rectangle r =
          wr.
          getBounds(
            );
        java.awt.image.ColorModel cm =
          getColorModel(
            );
        java.awt.image.BufferedImage bi =
          new java.awt.image.BufferedImage(
          cm,
          wr.
            createWritableTranslatedChild(
              0,
              0),
          cm.
            isAlphaPremultiplied(
              ),
          null);
        java.awt.Graphics2D g2d =
          org.apache.batik.ext.awt.image.GraphicsUtil.
          createGraphics(
            bi);
        g2d.
          translate(
            -r.
               x,
            -r.
               y);
        java.util.Iterator i =
          srcs.
          iterator(
            );
        boolean first =
          true;
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.image.rendered.CachableRed cr =
              (org.apache.batik.ext.awt.image.rendered.CachableRed)
                i.
                next(
                  );
            if (first) {
                java.awt.Rectangle crR =
                  cr.
                  getBounds(
                    );
                if (r.
                      x <
                      crR.
                        x ||
                      r.
                        y <
                      crR.
                        y ||
                      r.
                        x +
                      r.
                        width >
                      crR.
                        x +
                      crR.
                        width ||
                      r.
                        y +
                      r.
                        height >
                      crR.
                        y +
                      crR.
                        height)
                    emptyRect(
                      wr);
                cr.
                  copyData(
                    wr);
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  coerceData(
                    wr,
                    cr.
                      getColorModel(
                        ),
                    cm.
                      isAlphaPremultiplied(
                        ));
                first =
                  false;
            }
            else {
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  drawImage(
                    g2d,
                    cr);
            }
        }
    }
    protected static java.awt.image.SampleModel fixSampleModel(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                                                               java.awt.image.ColorModel cm,
                                                               java.awt.Rectangle bounds) {
        int defSz =
          org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
          getDefaultTileSize(
            );
        int tgX =
          defSz *
          (int)
            java.lang.Math.
            floor(
              bounds.
                x /
                defSz);
        int tgY =
          defSz *
          (int)
            java.lang.Math.
            floor(
              bounds.
                y /
                defSz);
        int tw =
          bounds.
            x +
          bounds.
            width -
          tgX;
        int th =
          bounds.
            y +
          bounds.
            height -
          tgY;
        java.awt.image.SampleModel sm =
          src.
          getSampleModel(
            );
        int w =
          sm.
          getWidth(
            );
        if (w <
              defSz)
            w =
              defSz;
        if (w >
              tw)
            w =
              tw;
        int h =
          sm.
          getHeight(
            );
        if (h <
              defSz)
            h =
              defSz;
        if (h >
              th)
            h =
              th;
        if (w <=
              0 ||
              h <=
              0) {
            w =
              1;
            h =
              1;
        }
        return cm.
          createCompatibleSampleModel(
            w,
            h);
    }
    protected static java.awt.image.ColorModel fixColorModel(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        if (cm.
              hasAlpha(
                )) {
            if (!cm.
                  isAlphaPremultiplied(
                    ))
                cm =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    coerceColorModel(
                      cm,
                      true);
            return cm;
        }
        int b =
          src.
          getSampleModel(
            ).
          getNumBands(
            ) +
          1;
        if (b >
              4)
            throw new java.lang.IllegalArgumentException(
              "CompositeRed can only handle up to three band images");
        int[] masks =
          new int[4];
        for (int i =
               0;
             i <
               b -
               1;
             i++)
            masks[i] =
              16711680 >>
                8 *
                i;
        masks[3] =
          255 <<
            8 *
            (b -
               1);
        java.awt.color.ColorSpace cs =
          cm.
          getColorSpace(
            );
        return new java.awt.image.DirectColorModel(
          cs,
          8 *
            b,
          masks[0],
          masks[1],
          masks[2],
          masks[3],
          true,
          java.awt.image.DataBuffer.
            TYPE_INT);
    }
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
      ("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" +
       "3P6HO1v/RLj9dknw1btY4mtF8T9i6AFg");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("iWPbFpW/c6zq770eVXMQuye//So+ZHn0lm9P999Lap9/8eqVR14Uf2t/Wnv4" +
       "TeO9NHTFSBzn5OH6iftLQagDcUvK/VF7UP79nxj6zm8z1MA8eXhbKvC/9xz+" +
       "OIaeuDuHGLqn/D/Z6k9i6NE7tQIzGShPUv9pDL3ldtSAsjgcP6Y8B8XQtbOU" +
       "oP/y/yTdhRi675guhi7tb06SXALcAUlxezl43eMSV6M4VLQYeDM/dzqPPIqR" +
       "h18rRk6kns+cShjLz5cPk7tkfPCR0ssvDtnv/0bzp/YfmGmOstsVXK7Q0OX9" +
       "t25HCeJTd+R2yOsS+e5vPvgz977rMJl9cC/w8Rg7Ids7b/81V6+YY4sPkHb/" +
       "6pF/8T3/+MXfLQ+p/z/GjbdHVy4AAA==");
}
