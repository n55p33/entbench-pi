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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "sv/+zto/4W6/URJ8/S6a+EaR/PcIegBo");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("4li3ReFvHov6229E1BT47sm7X8VFlkdvuXu6vy+pfPGlq5cfeUn89f1p7eGd" +
       "xvsY6PI6tu2Th+sn8hf9QAPslpT7o3a//Ps/EfS936WrgXnyMFsK8L/3LfxB" +
       "BD1x9xYi6N7y/2StP4ygR+9UC8xkID1J/UcR9LbbUQPK4nD8mPIcFEHXzlKC" +
       "/sv/k3QXIujKMV0EXdxnTpJcBK0DkiJ7yX/D4xJbhVEgKxGwZnrudBx55CMP" +
       "v56PnAg9nzkVMJbXlw+Du5g/uKT0ykv06Ie/1fzJ/QUzxZbzvGjlMgNd2t91" +
       "OwoQn7pja4dtXSTf8+0Hf/q+Zw+D2Qf3DB+PsRO8vfv2t7n6xRxbXEDK/+Uj" +
       "//wH/sFLv1UeUv9/jik97FcuAAA=");
}
