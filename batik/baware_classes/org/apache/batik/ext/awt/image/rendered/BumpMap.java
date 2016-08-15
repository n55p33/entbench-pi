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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "SCwAAA==");
}
