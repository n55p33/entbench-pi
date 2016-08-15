package org.apache.batik.ext.awt.image.rendered;
public final class BumpMap {
    private java.awt.image.RenderedImage texture;
    private double surfaceScale;
    private double surfaceScaleX;
    private double surfaceScaleY;
    private double scaleX;
    private double scaleY;
    public BumpMap(java.awt.image.RenderedImage texture, double surfaceScale,
                   double scaleX,
                   double scaleY) { super();
                                    this.texture = texture;
                                    this.surfaceScaleX = surfaceScale * scaleX;
                                    this.surfaceScaleY = surfaceScale * scaleY;
                                    this.surfaceScale = surfaceScale;
                                    this.scaleX = scaleX;
                                    this.scaleY = scaleY; }
    public double getSurfaceScale() { return surfaceScale; }
    public double[][][] getNormalArray(final int x, final int y, final int w,
                                       final int h) { final double[][][] N =
                                                        new double[h][w][4];
                                                      java.awt.Rectangle srcRect =
                                                        new java.awt.Rectangle(
                                                        x -
                                                          1,
                                                        y -
                                                          1,
                                                        w +
                                                          2,
                                                        h +
                                                          2);
                                                      java.awt.Rectangle srcBound =
                                                        new java.awt.Rectangle(
                                                        texture.
                                                          getMinX(
                                                            ),
                                                        texture.
                                                          getMinY(
                                                            ),
                                                        texture.
                                                          getWidth(
                                                            ),
                                                        texture.
                                                          getHeight(
                                                            ));
                                                      if (!srcRect.
                                                            intersects(
                                                              srcBound))
                                                          return N;
                                                      srcRect =
                                                        srcRect.
                                                          intersection(
                                                            srcBound);
                                                      final java.awt.image.Raster r =
                                                        texture.
                                                        getData(
                                                          srcRect);
                                                      srcRect =
                                                        r.
                                                          getBounds(
                                                            );
                                                      final java.awt.image.DataBufferInt db =
                                                        (java.awt.image.DataBufferInt)
                                                          r.
                                                          getDataBuffer(
                                                            );
                                                      final int[] pixels =
                                                        db.
                                                        getBankData(
                                                          )[0];
                                                      final java.awt.image.SinglePixelPackedSampleModel sppsm;
                                                      sppsm =
                                                        (java.awt.image.SinglePixelPackedSampleModel)
                                                          r.
                                                          getSampleModel(
                                                            );
                                                      final int scanStride =
                                                        sppsm.
                                                        getScanlineStride(
                                                          );
                                                      final int scanStridePP =
                                                        scanStride +
                                                        1;
                                                      final int scanStrideMM =
                                                        scanStride -
                                                        1;
                                                      double prpc =
                                                        0;
                                                      double prcc =
                                                        0;
                                                      double prnc =
                                                        0;
                                                      double crpc =
                                                        0;
                                                      double crcc =
                                                        0;
                                                      double crnc =
                                                        0;
                                                      double nrpc =
                                                        0;
                                                      double nrcc =
                                                        0;
                                                      double nrnc =
                                                        0;
                                                      double invNorm;
                                                      final double quarterSurfaceScaleX =
                                                        surfaceScaleX /
                                                        4.0F;
                                                      final double quarterSurfaceScaleY =
                                                        surfaceScaleY /
                                                        4.0F;
                                                      final double halfSurfaceScaleX =
                                                        surfaceScaleX /
                                                        2.0F;
                                                      final double halfSurfaceScaleY =
                                                        surfaceScaleY /
                                                        2;
                                                      final double thirdSurfaceScaleX =
                                                        surfaceScaleX /
                                                        3.0F;
                                                      final double thirdSurfaceScaleY =
                                                        surfaceScaleY /
                                                        3.0F;
                                                      final double twoThirdSurfaceScaleX =
                                                        surfaceScaleX *
                                                        2 /
                                                        3.0F;
                                                      final double twoThirdSurfaceScaleY =
                                                        surfaceScaleY *
                                                        2 /
                                                        3.0F;
                                                      final double pixelScale =
                                                        1.0 /
                                                        255;
                                                      if (w <=
                                                            0)
                                                          return N;
                                                      if (h <=
                                                            0)
                                                          return N;
                                                      final int xEnd =
                                                        java.lang.Math.
                                                        min(
                                                          srcRect.
                                                            x +
                                                            srcRect.
                                                              width -
                                                            1,
                                                          x +
                                                            w);
                                                      final int yEnd =
                                                        java.lang.Math.
                                                        min(
                                                          srcRect.
                                                            y +
                                                            srcRect.
                                                              height -
                                                            1,
                                                          y +
                                                            h);
                                                      final int offset =
                                                        db.
                                                        getOffset(
                                                          ) +
                                                        sppsm.
                                                        getOffset(
                                                          srcRect.
                                                            x -
                                                            r.
                                                            getSampleModelTranslateX(
                                                              ),
                                                          srcRect.
                                                            y -
                                                            r.
                                                            getSampleModelTranslateY(
                                                              ));
                                                      int yloc =
                                                        y;
                                                      if (yloc <
                                                            srcRect.
                                                              y) {
                                                          yloc =
                                                            srcRect.
                                                              y;
                                                      }
                                                      if (yloc ==
                                                            srcRect.
                                                              y) {
                                                          if (yloc ==
                                                                yEnd) {
                                                              final double[][] NRow =
                                                                N[yloc -
                                                                    y];
                                                              int xloc =
                                                                x;
                                                              if (xloc <
                                                                    srcRect.
                                                                      x)
                                                                  xloc =
                                                                    srcRect.
                                                                      x;
                                                              int p =
                                                                offset +
                                                                (xloc -
                                                                   srcRect.
                                                                     x) +
                                                                scanStride *
                                                                (yloc -
                                                                   srcRect.
                                                                     y);
                                                              crcc =
                                                                (pixels[p] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              if (xloc !=
                                                                    srcRect.
                                                                      x) {
                                                                  crpc =
                                                                    (pixels[p -
                                                                              1] >>>
                                                                       24) *
                                                                      pixelScale;
                                                              }
                                                              else
                                                                  if (xloc <
                                                                        xEnd) {
                                                                      crnc =
                                                                        (pixels[p +
                                                                                  1] >>>
                                                                           24) *
                                                                          pixelScale;
                                                                      final double[] n =
                                                                        NRow[xloc -
                                                                               x];
                                                                      n[0] =
                                                                        2 *
                                                                          surfaceScaleX *
                                                                          (crcc -
                                                                             crnc);
                                                                      invNorm =
                                                                        1.0 /
                                                                          java.lang.Math.
                                                                          sqrt(
                                                                            n[0] *
                                                                              n[0] +
                                                                              1);
                                                                      n[0] *=
                                                                        invNorm;
                                                                      n[1] =
                                                                        0;
                                                                      n[2] =
                                                                        invNorm;
                                                                      n[3] =
                                                                        crcc *
                                                                          surfaceScale;
                                                                      p++;
                                                                      xloc++;
                                                                      crpc =
                                                                        crcc;
                                                                      crcc =
                                                                        crnc;
                                                                  }
                                                                  else {
                                                                      crpc =
                                                                        crcc;
                                                                  }
                                                              for (;
                                                                   xloc <
                                                                     xEnd;
                                                                   xloc++) {
                                                                  crnc =
                                                                    (pixels[p +
                                                                              1] >>>
                                                                       24) *
                                                                      pixelScale;
                                                                  final double[] n =
                                                                    NRow[xloc -
                                                                           x];
                                                                  n[0] =
                                                                    surfaceScaleX *
                                                                      (crpc -
                                                                         crnc);
                                                                  invNorm =
                                                                    1.0 /
                                                                      java.lang.Math.
                                                                      sqrt(
                                                                        n[0] *
                                                                          n[0] +
                                                                          1);
                                                                  n[0] *=
                                                                    invNorm;
                                                                  n[1] =
                                                                    0;
                                                                  n[2] =
                                                                    invNorm;
                                                                  n[3] =
                                                                    crcc *
                                                                      surfaceScale;
                                                                  p++;
                                                                  crpc =
                                                                    crcc;
                                                                  crcc =
                                                                    crnc;
                                                              }
                                                              if (xloc <
                                                                    x +
                                                                    w &&
                                                                    xloc ==
                                                                    srcRect.
                                                                      x +
                                                                    srcRect.
                                                                      width -
                                                                    1) {
                                                                  final double[] n =
                                                                    NRow[xloc -
                                                                           x];
                                                                  n[0] =
                                                                    2 *
                                                                      surfaceScaleX *
                                                                      (crpc -
                                                                         crcc);
                                                                  invNorm =
                                                                    1.0 /
                                                                      java.lang.Math.
                                                                      sqrt(
                                                                        n[0] *
                                                                          n[0] +
                                                                          n[1] *
                                                                          n[1] +
                                                                          1);
                                                                  n[0] *=
                                                                    invNorm;
                                                                  n[1] *=
                                                                    invNorm;
                                                                  n[2] =
                                                                    invNorm;
                                                                  n[3] =
                                                                    crcc *
                                                                      surfaceScale;
                                                              }
                                                              return N;
                                                          }
                                                          final double[][] NRow =
                                                            N[yloc -
                                                                y];
                                                          int p =
                                                            offset +
                                                            scanStride *
                                                            (yloc -
                                                               srcRect.
                                                                 y);
                                                          int xloc =
                                                            x;
                                                          if (xloc <
                                                                srcRect.
                                                                  x)
                                                              xloc =
                                                                srcRect.
                                                                  x;
                                                          p +=
                                                            xloc -
                                                              srcRect.
                                                                x;
                                                          crcc =
                                                            (pixels[p] >>>
                                                               24) *
                                                              pixelScale;
                                                          nrcc =
                                                            (pixels[p +
                                                                      scanStride] >>>
                                                               24) *
                                                              pixelScale;
                                                          if (xloc !=
                                                                srcRect.
                                                                  x) {
                                                              crpc =
                                                                (pixels[p -
                                                                          1] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              nrpc =
                                                                (pixels[p +
                                                                          scanStrideMM] >>>
                                                                   24) *
                                                                  pixelScale;
                                                          }
                                                          else
                                                              if (xloc <
                                                                    xEnd) {
                                                                  crnc =
                                                                    (pixels[p +
                                                                              1] >>>
                                                                       24) *
                                                                      pixelScale;
                                                                  nrnc =
                                                                    (pixels[p +
                                                                              scanStridePP] >>>
                                                                       24) *
                                                                      pixelScale;
                                                                  final double[] n =
                                                                    NRow[xloc -
                                                                           x];
                                                                  n[0] =
                                                                    -twoThirdSurfaceScaleX *
                                                                      (2 *
                                                                         crnc +
                                                                         nrnc -
                                                                         2 *
                                                                         crcc -
                                                                         nrcc);
                                                                  n[1] =
                                                                    -twoThirdSurfaceScaleY *
                                                                      (2 *
                                                                         nrcc +
                                                                         nrnc -
                                                                         2 *
                                                                         crcc -
                                                                         crnc);
                                                                  invNorm =
                                                                    1.0 /
                                                                      java.lang.Math.
                                                                      sqrt(
                                                                        n[0] *
                                                                          n[0] +
                                                                          n[1] *
                                                                          n[1] +
                                                                          1);
                                                                  n[0] *=
                                                                    invNorm;
                                                                  n[1] *=
                                                                    invNorm;
                                                                  n[2] =
                                                                    invNorm;
                                                                  n[3] =
                                                                    crcc *
                                                                      surfaceScale;
                                                                  p++;
                                                                  xloc++;
                                                                  crpc =
                                                                    crcc;
                                                                  nrpc =
                                                                    nrcc;
                                                                  crcc =
                                                                    crnc;
                                                                  nrcc =
                                                                    nrnc;
                                                              }
                                                              else {
                                                                  crpc =
                                                                    crcc;
                                                                  nrpc =
                                                                    nrcc;
                                                              }
                                                          for (;
                                                               xloc <
                                                                 xEnd;
                                                               xloc++) {
                                                              crnc =
                                                                (pixels[p +
                                                                          1] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              nrnc =
                                                                (pixels[p +
                                                                          scanStridePP] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              final double[] n =
                                                                NRow[xloc -
                                                                       x];
                                                              n[0] =
                                                                -thirdSurfaceScaleX *
                                                                  (2 *
                                                                     crnc +
                                                                     nrnc -
                                                                     (2 *
                                                                        crpc +
                                                                        nrpc));
                                                              n[1] =
                                                                -halfSurfaceScaleY *
                                                                  (nrpc +
                                                                     2 *
                                                                     nrcc +
                                                                     nrnc -
                                                                     (crpc +
                                                                        2 *
                                                                        crcc +
                                                                        crnc));
                                                              invNorm =
                                                                1.0 /
                                                                  java.lang.Math.
                                                                  sqrt(
                                                                    n[0] *
                                                                      n[0] +
                                                                      n[1] *
                                                                      n[1] +
                                                                      1);
                                                              n[0] *=
                                                                invNorm;
                                                              n[1] *=
                                                                invNorm;
                                                              n[2] =
                                                                invNorm;
                                                              n[3] =
                                                                crcc *
                                                                  surfaceScale;
                                                              p++;
                                                              crpc =
                                                                crcc;
                                                              nrpc =
                                                                nrcc;
                                                              crcc =
                                                                crnc;
                                                              nrcc =
                                                                nrnc;
                                                          }
                                                          if (xloc <
                                                                x +
                                                                w &&
                                                                xloc ==
                                                                srcRect.
                                                                  x +
                                                                srcRect.
                                                                  width -
                                                                1) {
                                                              final double[] n =
                                                                NRow[xloc -
                                                                       x];
                                                              n[0] =
                                                                -twoThirdSurfaceScaleX *
                                                                  (2 *
                                                                     crcc +
                                                                     nrcc -
                                                                     (2 *
                                                                        crpc +
                                                                        nrpc));
                                                              n[1] =
                                                                -twoThirdSurfaceScaleY *
                                                                  (2 *
                                                                     nrcc +
                                                                     nrpc -
                                                                     (2 *
                                                                        crcc +
                                                                        crpc));
                                                              invNorm =
                                                                1.0 /
                                                                  java.lang.Math.
                                                                  sqrt(
                                                                    n[0] *
                                                                      n[0] +
                                                                      n[1] *
                                                                      n[1] +
                                                                      1);
                                                              n[0] *=
                                                                invNorm;
                                                              n[1] *=
                                                                invNorm;
                                                              n[2] =
                                                                invNorm;
                                                              n[3] =
                                                                crcc *
                                                                  surfaceScale;
                                                          }
                                                          yloc++;
                                                      }
                                                      for (;
                                                           yloc <
                                                             yEnd;
                                                           yloc++) {
                                                          final double[][] NRow =
                                                            N[yloc -
                                                                y];
                                                          int p =
                                                            offset +
                                                            scanStride *
                                                            (yloc -
                                                               srcRect.
                                                                 y);
                                                          int xloc =
                                                            x;
                                                          if (xloc <
                                                                srcRect.
                                                                  x)
                                                              xloc =
                                                                srcRect.
                                                                  x;
                                                          p +=
                                                            xloc -
                                                              srcRect.
                                                                x;
                                                          prcc =
                                                            (pixels[p -
                                                                      scanStride] >>>
                                                               24) *
                                                              pixelScale;
                                                          crcc =
                                                            (pixels[p] >>>
                                                               24) *
                                                              pixelScale;
                                                          nrcc =
                                                            (pixels[p +
                                                                      scanStride] >>>
                                                               24) *
                                                              pixelScale;
                                                          if (xloc !=
                                                                srcRect.
                                                                  x) {
                                                              prpc =
                                                                (pixels[p -
                                                                          scanStridePP] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              crpc =
                                                                (pixels[p -
                                                                          1] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              nrpc =
                                                                (pixels[p +
                                                                          scanStrideMM] >>>
                                                                   24) *
                                                                  pixelScale;
                                                          }
                                                          else
                                                              if (xloc <
                                                                    xEnd) {
                                                                  crnc =
                                                                    (pixels[p +
                                                                              1] >>>
                                                                       24) *
                                                                      pixelScale;
                                                                  prnc =
                                                                    (pixels[p -
                                                                              scanStrideMM] >>>
                                                                       24) *
                                                                      pixelScale;
                                                                  nrnc =
                                                                    (pixels[p +
                                                                              scanStridePP] >>>
                                                                       24) *
                                                                      pixelScale;
                                                                  final double[] n =
                                                                    NRow[xloc -
                                                                           x];
                                                                  n[0] =
                                                                    -halfSurfaceScaleX *
                                                                      (prnc +
                                                                         2 *
                                                                         crnc +
                                                                         nrnc -
                                                                         (prcc +
                                                                            2 *
                                                                            crcc +
                                                                            nrcc));
                                                                  n[1] =
                                                                    -thirdSurfaceScaleY *
                                                                      (2 *
                                                                         prcc +
                                                                         prnc -
                                                                         (2 *
                                                                            crcc +
                                                                            crnc));
                                                                  invNorm =
                                                                    1.0 /
                                                                      java.lang.Math.
                                                                      sqrt(
                                                                        n[0] *
                                                                          n[0] +
                                                                          n[1] *
                                                                          n[1] +
                                                                          1);
                                                                  n[0] *=
                                                                    invNorm;
                                                                  n[1] *=
                                                                    invNorm;
                                                                  n[2] =
                                                                    invNorm;
                                                                  n[3] =
                                                                    crcc *
                                                                      surfaceScale;
                                                                  p++;
                                                                  xloc++;
                                                                  prpc =
                                                                    prcc;
                                                                  crpc =
                                                                    crcc;
                                                                  nrpc =
                                                                    nrcc;
                                                                  prcc =
                                                                    prnc;
                                                                  crcc =
                                                                    crnc;
                                                                  nrcc =
                                                                    nrnc;
                                                              }
                                                              else {
                                                                  prpc =
                                                                    prcc;
                                                                  crpc =
                                                                    crcc;
                                                                  nrpc =
                                                                    nrcc;
                                                              }
                                                          for (;
                                                               xloc <
                                                                 xEnd;
                                                               xloc++) {
                                                              prnc =
                                                                (pixels[p -
                                                                          scanStrideMM] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              crnc =
                                                                (pixels[p +
                                                                          1] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              nrnc =
                                                                (pixels[p +
                                                                          scanStridePP] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              final double[] n =
                                                                NRow[xloc -
                                                                       x];
                                                              n[0] =
                                                                -quarterSurfaceScaleX *
                                                                  (prnc +
                                                                     2 *
                                                                     crnc +
                                                                     nrnc -
                                                                     (prpc +
                                                                        2 *
                                                                        crpc +
                                                                        nrpc));
                                                              n[1] =
                                                                -quarterSurfaceScaleY *
                                                                  (nrpc +
                                                                     2 *
                                                                     nrcc +
                                                                     nrnc -
                                                                     (prpc +
                                                                        2 *
                                                                        prcc +
                                                                        prnc));
                                                              invNorm =
                                                                1.0 /
                                                                  java.lang.Math.
                                                                  sqrt(
                                                                    n[0] *
                                                                      n[0] +
                                                                      n[1] *
                                                                      n[1] +
                                                                      1);
                                                              n[0] *=
                                                                invNorm;
                                                              n[1] *=
                                                                invNorm;
                                                              n[2] =
                                                                invNorm;
                                                              n[3] =
                                                                crcc *
                                                                  surfaceScale;
                                                              p++;
                                                              prpc =
                                                                prcc;
                                                              crpc =
                                                                crcc;
                                                              nrpc =
                                                                nrcc;
                                                              prcc =
                                                                prnc;
                                                              crcc =
                                                                crnc;
                                                              nrcc =
                                                                nrnc;
                                                          }
                                                          if (xloc <
                                                                x +
                                                                w &&
                                                                xloc ==
                                                                srcRect.
                                                                  x +
                                                                srcRect.
                                                                  width -
                                                                1) {
                                                              final double[] n =
                                                                NRow[xloc -
                                                                       x];
                                                              n[0] =
                                                                -halfSurfaceScaleX *
                                                                  (prcc +
                                                                     2 *
                                                                     crcc +
                                                                     nrcc -
                                                                     (prpc +
                                                                        2 *
                                                                        crpc +
                                                                        nrpc));
                                                              n[1] =
                                                                -thirdSurfaceScaleY *
                                                                  (nrpc +
                                                                     2 *
                                                                     nrcc -
                                                                     (prpc +
                                                                        2 *
                                                                        prcc));
                                                              invNorm =
                                                                1.0 /
                                                                  java.lang.Math.
                                                                  sqrt(
                                                                    n[0] *
                                                                      n[0] +
                                                                      n[1] *
                                                                      n[1] +
                                                                      1);
                                                              n[0] *=
                                                                invNorm;
                                                              n[1] *=
                                                                invNorm;
                                                              n[2] =
                                                                invNorm;
                                                              n[3] =
                                                                crcc *
                                                                  surfaceScale;
                                                          }
                                                      }
                                                      if (yloc <
                                                            y +
                                                            h &&
                                                            yloc ==
                                                            srcRect.
                                                              y +
                                                            srcRect.
                                                              height -
                                                            1) {
                                                          final double[][] NRow =
                                                            N[yloc -
                                                                y];
                                                          int p =
                                                            offset +
                                                            scanStride *
                                                            (yloc -
                                                               srcRect.
                                                                 y);
                                                          int xloc =
                                                            x;
                                                          if (xloc <
                                                                srcRect.
                                                                  x)
                                                              xloc =
                                                                srcRect.
                                                                  x;
                                                          p +=
                                                            xloc -
                                                              srcRect.
                                                                x;
                                                          crcc =
                                                            (pixels[p] >>>
                                                               24) *
                                                              pixelScale;
                                                          prcc =
                                                            (pixels[p -
                                                                      scanStride] >>>
                                                               24) *
                                                              pixelScale;
                                                          if (xloc !=
                                                                srcRect.
                                                                  x) {
                                                              prpc =
                                                                (pixels[p -
                                                                          scanStridePP] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              crpc =
                                                                (pixels[p -
                                                                          1] >>>
                                                                   24) *
                                                                  pixelScale;
                                                          }
                                                          else
                                                              if (xloc <
                                                                    xEnd) {
                                                                  crnc =
                                                                    (pixels[p +
                                                                              1] >>>
                                                                       24) *
                                                                      pixelScale;
                                                                  prnc =
                                                                    (pixels[p -
                                                                              scanStrideMM] >>>
                                                                       24) *
                                                                      pixelScale;
                                                                  final double[] n =
                                                                    NRow[xloc -
                                                                           x];
                                                                  n[0] =
                                                                    -twoThirdSurfaceScaleX *
                                                                      (2 *
                                                                         crnc +
                                                                         prnc -
                                                                         2 *
                                                                         crcc -
                                                                         prcc);
                                                                  n[1] =
                                                                    -twoThirdSurfaceScaleY *
                                                                      (2 *
                                                                         crcc +
                                                                         crnc -
                                                                         2 *
                                                                         prcc -
                                                                         prnc);
                                                                  invNorm =
                                                                    1.0 /
                                                                      java.lang.Math.
                                                                      sqrt(
                                                                        n[0] *
                                                                          n[0] +
                                                                          n[1] *
                                                                          n[1] +
                                                                          1);
                                                                  n[0] *=
                                                                    invNorm;
                                                                  n[1] *=
                                                                    invNorm;
                                                                  n[2] =
                                                                    invNorm;
                                                                  n[3] =
                                                                    crcc *
                                                                      surfaceScale;
                                                                  p++;
                                                                  xloc++;
                                                                  crpc =
                                                                    crcc;
                                                                  prpc =
                                                                    prcc;
                                                                  crcc =
                                                                    crnc;
                                                                  prcc =
                                                                    prnc;
                                                              }
                                                              else {
                                                                  crpc =
                                                                    crcc;
                                                                  prpc =
                                                                    prcc;
                                                              }
                                                          for (;
                                                               xloc <
                                                                 xEnd;
                                                               xloc++) {
                                                              crnc =
                                                                (pixels[p +
                                                                          1] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              prnc =
                                                                (pixels[p -
                                                                          scanStrideMM] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              final double[] n =
                                                                NRow[xloc -
                                                                       x];
                                                              n[0] =
                                                                -thirdSurfaceScaleX *
                                                                  (2 *
                                                                     crnc +
                                                                     prnc -
                                                                     (2 *
                                                                        crpc +
                                                                        prpc));
                                                              n[1] =
                                                                -halfSurfaceScaleY *
                                                                  (crpc +
                                                                     2 *
                                                                     crcc +
                                                                     crnc -
                                                                     (prpc +
                                                                        2 *
                                                                        prcc +
                                                                        prnc));
                                                              invNorm =
                                                                1.0 /
                                                                  java.lang.Math.
                                                                  sqrt(
                                                                    n[0] *
                                                                      n[0] +
                                                                      n[1] *
                                                                      n[1] +
                                                                      1);
                                                              n[0] *=
                                                                invNorm;
                                                              n[1] *=
                                                                invNorm;
                                                              n[2] =
                                                                invNorm;
                                                              n[3] =
                                                                crcc *
                                                                  surfaceScale;
                                                              p++;
                                                              crpc =
                                                                crcc;
                                                              prpc =
                                                                prcc;
                                                              crcc =
                                                                crnc;
                                                              prcc =
                                                                prnc;
                                                          }
                                                          if (xloc <
                                                                x +
                                                                w &&
                                                                xloc ==
                                                                srcRect.
                                                                  x +
                                                                srcRect.
                                                                  width -
                                                                1) {
                                                              final double[] n =
                                                                NRow[xloc -
                                                                       x];
                                                              n[0] =
                                                                -twoThirdSurfaceScaleX *
                                                                  (2 *
                                                                     crcc +
                                                                     prcc -
                                                                     (2 *
                                                                        crpc +
                                                                        prpc));
                                                              n[1] =
                                                                -twoThirdSurfaceScaleY *
                                                                  (2 *
                                                                     crcc +
                                                                     crpc -
                                                                     (2 *
                                                                        prcc +
                                                                        prpc));
                                                              invNorm =
                                                                1.0 /
                                                                  java.lang.Math.
                                                                  sqrt(
                                                                    n[0] *
                                                                      n[0] +
                                                                      n[1] *
                                                                      n[1] +
                                                                      1);
                                                              n[0] *=
                                                                invNorm;
                                                              n[1] *=
                                                                invNorm;
                                                              n[2] =
                                                                invNorm;
                                                              n[3] =
                                                                crcc *
                                                                  surfaceScale;
                                                          }
                                                      }
                                                      return N;
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
       "dEgsAAA=");
}
