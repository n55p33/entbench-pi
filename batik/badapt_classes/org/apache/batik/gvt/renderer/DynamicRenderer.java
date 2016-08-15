package org.apache.batik.gvt.renderer;
public class DynamicRenderer extends org.apache.batik.gvt.renderer.StaticRenderer {
    static final int COPY_OVERHEAD = 1000;
    static final int COPY_LINE_OVERHEAD = 10;
    public DynamicRenderer() { super(); }
    public DynamicRenderer(java.awt.RenderingHints rh, java.awt.geom.AffineTransform at) {
        super(
          rh,
          at);
    }
    org.apache.batik.ext.awt.geom.RectListManager damagedAreas;
    protected org.apache.batik.ext.awt.image.rendered.CachableRed setupCache(org.apache.batik.ext.awt.image.rendered.CachableRed img) {
        return img;
    }
    public void flush(java.awt.Rectangle r) { return; }
    public void flush(java.util.Collection areas) { return;
    }
    protected void updateWorkingBuffers() { if (rootFilter ==
                                                  null) {
                                                rootFilter =
                                                  rootGN.
                                                    getGraphicsNodeRable(
                                                      true);
                                                rootCR =
                                                  null;
                                            }
                                            rootCR = renderGNR(
                                                       );
                                            if (rootCR ==
                                                  null) {
                                                workingRaster =
                                                  null;
                                                workingOffScreen =
                                                  null;
                                                workingBaseRaster =
                                                  null;
                                                currentOffScreen =
                                                  null;
                                                currentBaseRaster =
                                                  null;
                                                currentRaster =
                                                  null;
                                                return;
                                            }
                                            java.awt.image.SampleModel sm =
                                              rootCR.
                                              getSampleModel(
                                                );
                                            int w = offScreenWidth;
                                            int h = offScreenHeight;
                                            if (workingBaseRaster ==
                                                  null ||
                                                  workingBaseRaster.
                                                  getWidth(
                                                    ) <
                                                  w ||
                                                  workingBaseRaster.
                                                  getHeight(
                                                    ) <
                                                  h) { sm =
                                                         sm.
                                                           createCompatibleSampleModel(
                                                             w,
                                                             h);
                                                       workingBaseRaster =
                                                         java.awt.image.Raster.
                                                           createWritableRaster(
                                                             sm,
                                                             new java.awt.Point(
                                                               0,
                                                               0));
                                                       workingRaster =
                                                         workingBaseRaster.
                                                           createWritableChild(
                                                             0,
                                                             0,
                                                             w,
                                                             h,
                                                             0,
                                                             0,
                                                             null);
                                                       workingOffScreen =
                                                         new java.awt.image.BufferedImage(
                                                           rootCR.
                                                             getColorModel(
                                                               ),
                                                           workingRaster,
                                                           rootCR.
                                                             getColorModel(
                                                               ).
                                                             isAlphaPremultiplied(
                                                               ),
                                                           null);
                                            }
                                            if (!isDoubleBuffered) {
                                                currentOffScreen =
                                                  workingOffScreen;
                                                currentBaseRaster =
                                                  workingBaseRaster;
                                                currentRaster =
                                                  workingRaster;
                                            }
    }
    public void repaint(org.apache.batik.ext.awt.geom.RectListManager devRLM) {
        if (devRLM ==
              null)
            return;
        org.apache.batik.ext.awt.image.rendered.CachableRed cr;
        java.awt.image.WritableRaster syncRaster;
        java.awt.image.WritableRaster copyRaster;
        updateWorkingBuffers(
          );
        if (rootCR ==
              null ||
              workingBaseRaster ==
              null) {
            return;
        }
        cr =
          rootCR;
        syncRaster =
          workingBaseRaster;
        copyRaster =
          workingRaster;
        java.awt.Rectangle srcR =
          rootCR.
          getBounds(
            );
        java.awt.Rectangle dstR =
          workingRaster.
          getBounds(
            );
        if (dstR.
              x <
              srcR.
                x ||
              dstR.
                y <
              srcR.
                y ||
              dstR.
                x +
              dstR.
                width >
              srcR.
                x +
              srcR.
                width ||
              dstR.
                y +
              dstR.
                height >
              srcR.
                y +
              srcR.
                height)
            cr =
              new org.apache.batik.ext.awt.image.rendered.PadRed(
                cr,
                dstR,
                org.apache.batik.ext.awt.image.PadMode.
                  ZERO_PAD,
                null);
        boolean repaintAll =
          false;
        java.awt.Rectangle dr =
          copyRaster.
          getBounds(
            );
        synchronized (syncRaster)  {
            if (repaintAll) {
                cr.
                  copyData(
                    copyRaster);
            }
            else {
                java.awt.Graphics2D g2d =
                  null;
                if (false) {
                    java.awt.image.BufferedImage tmpBI =
                      new java.awt.image.BufferedImage(
                      workingOffScreen.
                        getColorModel(
                          ),
                      copyRaster.
                        createWritableTranslatedChild(
                          0,
                          0),
                      workingOffScreen.
                        isAlphaPremultiplied(
                          ),
                      null);
                    g2d =
                      org.apache.batik.ext.awt.image.GraphicsUtil.
                        createGraphics(
                          tmpBI);
                    g2d.
                      translate(
                        -copyRaster.
                          getMinX(
                            ),
                        -copyRaster.
                          getMinY(
                            ));
                }
                if (isDoubleBuffered &&
                      currentRaster !=
                      null &&
                      damagedAreas !=
                      null) {
                    damagedAreas.
                      subtract(
                        devRLM,
                        COPY_OVERHEAD,
                        COPY_LINE_OVERHEAD);
                    damagedAreas.
                      mergeRects(
                        COPY_OVERHEAD,
                        COPY_LINE_OVERHEAD);
                    java.awt.Color fillColor =
                      new java.awt.Color(
                      0,
                      0,
                      255,
                      50);
                    java.awt.Color borderColor =
                      new java.awt.Color(
                      0,
                      0,
                      0,
                      50);
                    java.util.Iterator iter =
                      damagedAreas.
                      iterator(
                        );
                    while (iter.
                             hasNext(
                               )) {
                        java.awt.Rectangle r =
                          (java.awt.Rectangle)
                            iter.
                            next(
                              );
                        if (!dr.
                              intersects(
                                r))
                            continue;
                        r =
                          dr.
                            intersection(
                              r);
                        java.awt.image.Raster src =
                          currentRaster.
                          createWritableChild(
                            r.
                              x,
                            r.
                              y,
                            r.
                              width,
                            r.
                              height,
                            r.
                              x,
                            r.
                              y,
                            null);
                        org.apache.batik.ext.awt.image.GraphicsUtil.
                          copyData(
                            src,
                            copyRaster);
                        if (g2d !=
                              null) {
                            g2d.
                              setPaint(
                                fillColor);
                            g2d.
                              fill(
                                r);
                            g2d.
                              setPaint(
                                borderColor);
                            g2d.
                              draw(
                                r);
                        }
                    }
                }
                java.awt.Color fillColor =
                  new java.awt.Color(
                  255,
                  0,
                  0,
                  50);
                java.awt.Color borderColor =
                  new java.awt.Color(
                  0,
                  0,
                  0,
                  50);
                java.util.Iterator iter =
                  devRLM.
                  iterator(
                    );
                while (iter.
                         hasNext(
                           )) {
                    java.awt.Rectangle r =
                      (java.awt.Rectangle)
                        iter.
                        next(
                          );
                    if (!dr.
                          intersects(
                            r))
                        continue;
                    r =
                      dr.
                        intersection(
                          r);
                    java.awt.image.WritableRaster dst =
                      copyRaster.
                      createWritableChild(
                        r.
                          x,
                        r.
                          y,
                        r.
                          width,
                        r.
                          height,
                        r.
                          x,
                        r.
                          y,
                        null);
                    cr.
                      copyData(
                        dst);
                    if (g2d !=
                          null) {
                        g2d.
                          setPaint(
                            fillColor);
                        g2d.
                          fill(
                            r);
                        g2d.
                          setPaint(
                            borderColor);
                        g2d.
                          draw(
                            r);
                    }
                }
            }
        }
        if (org.apache.batik.util.HaltingThread.
              hasBeenHalted(
                ))
            return;
        java.awt.image.BufferedImage tmpBI =
          workingOffScreen;
        workingBaseRaster =
          currentBaseRaster;
        workingRaster =
          currentRaster;
        workingOffScreen =
          currentOffScreen;
        currentRaster =
          copyRaster;
        currentBaseRaster =
          syncRaster;
        currentOffScreen =
          tmpBI;
        damagedAreas =
          devRLM;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Za5AU1RW+M/t+P4AFgV1gWaR4zYBvXV/LugtrZh/ZxU05" +
       "qENvz53ZZnu62+47u8MaErEqQpIKJQaQpITyB4pRFJOKFY3RIrHiIxqrVIwx" +
       "lo+olWCMpZSlJlFjzrndPf2YByEl2aq+23Pvuefec+453znn9uH3SZmhkzaq" +
       "sBDbolEj1KOwIUE3aLxbFgxjA/TFxNtKhI+uOz5wYZCUR0n9uGD0i4JBeyUq" +
       "x40oaZUUgwmKSI0BSuM4Y0inBtUnBSapSpTMkoy+lCZLosT61ThFglFBj5Am" +
       "gTFdGksz2mcxYKQ1AjsJ852Eu/zDnRFSK6raFod8jou82zWClClnLYORxshm" +
       "YVIIp5kkhyOSwTozOlmhqfKWpKyyEM2w0Gb5XEsFV0bOzVFB+wMNn3x2y3gj" +
       "V8EMQVFUxsUzhqmhypM0HiENTm+PTFPG9eRbpCRCalzEjHRE7EXDsGgYFrWl" +
       "dahg93VUSae6VS4OszmVayJuiJFFXiaaoAspi80Q3zNwqGSW7HwySLswK60p" +
       "ZY6Ie1aEd992XePPSkhDlDRIyghuR4RNMFgkCgqlqTGqG13xOI1HSZMChz1C" +
       "dUmQpWnrpJsNKakILA3Hb6sFO9Ma1fmajq7gHEE2PS0yVc+Kl+AGZf0qS8hC" +
       "EmRtcWQ1JezFfhCwWoKN6QkB7M6aUjohKXFGFvhnZGXs+BoQwNSKFGXjanap" +
       "UkWADtJsmogsKMnwCJiekgTSMhUMUGdkbkGmqGtNECeEJI2hRfrohswhoKri" +
       "isApjMzyk3FOcEpzfafkOp/3By7eeYOyXgmSAOw5TkUZ918Dk9p8k4ZpguoU" +
       "/MCcWLs8sldoeXRHkBAgnuUjNml+8c0Tl69sO/qUSTMvD83g2GYqsph4cKz+" +
       "+fndyy4swW1Uaqoh4eF7JOdeNmSNdGY0QJiWLEccDNmDR4efuPrGe+h7QVLd" +
       "R8pFVU6nwI6aRDWlSTLV11GF6gKj8T5SRZV4Nx/vIxXwHpEUavYOJhIGZX2k" +
       "VOZd5Sr/DSpKAAtUUTW8S0pCtd81gY3z94xGCKmAh9TCEyLmH//PyKbwuJqi" +
       "YUEUFElRw0O6ivIbYUCcMdDteHgMrH4ibKhpHUwwrOrJsAB2ME6tgeQkC8Mh" +
       "xOEk9PAVW8DGJHHY+h1CS9P+D2tkUM4ZU4EAHMF8PwDI4DvrVRmoY+Lu9Nqe" +
       "E/fHnjGNCx3C0hAjq2DZkLlsiC8bgmVD9rIh37IkEOCrzcTlzcOGo5oApwfU" +
       "rV02cu2Vm3a0l4CVaVOloOcgkLZ7ok+3gww2nMfEI81104teX/N4kJRGSLMg" +
       "srQgYzDp0pMAU+KE5cm1YxCXnPCw0BUeMK7pqkjjgE6FwoTFpVKdpDr2MzLT" +
       "xcEOXuim4cKhI+/+ydF9U9tGv706SILeiIBLlgGY4fQhxPEsXnf4kSAf34bt" +
       "xz85sner6mCCJ8TYkTFnJsrQ7rcHv3pi4vKFwoOxR7d2cLVXAWYzAXwM4LDN" +
       "v4YHcjpt+EZZKkHghKqnBBmHbB1Xs3FdnXJ6uKE28feZYBY16INz4TnPckr+" +
       "H0dbNGxnm4aNduaTgoeHS0a0/X987t2zubrtSNLgSgFGKOt0oRcya+Y41eSY" +
       "7QadUqB7bd/QD/e8v30jt1mgWJxvwQ5suwG14AhBzd956vpX3nj94LFg1s4D" +
       "DMJ3egyyoExWSOwn1UWEhNXOdPYD6CcDOqDVdFylgH1KCUkYkyk61ucNS9Y8" +
       "+PedjaYdyNBjm9HKkzNw+s9YS2585rpP2zibgIjR19GZQ2ZC+gyHc5euC1tw" +
       "H5ltL7T+6ElhPwQHAGRDmqYcYwnXAeGHdi6XfzVvz/GNnY/NEsNt/F7/cmVJ" +
       "MfGWYx/WjX742Am+W2+a5T7rfkHrNM0LmzMzwH62H5zWC8Y40J1zdOCaRvno" +
       "Z8AxChxFAF1jUAdcy3gsw6Iuq/jTrx9v2fR8CQn2kmpZFeK9AncyUgXWTY1x" +
       "wNaMdtnl5uFOVULTyEUlOcLndKCCF+Q/up6Uxriypx+a/fOLDx14nVuZxlm0" +
       "5nrQRZZxXZTfg7Bdis2KXLssNNV3gkELyfH3HGYpV5hiITMmQCK1HnI1wx5v" +
       "zY4nqZoKdSUSgCkbdEExECb4ttYVsZF+bNbyoQuw6TaV1/k/6hk7ujRzYB7v" +
       "LMFY6QlJvNJxUPGeF89/6dCuvVNmrrSscCjwzZvzr0F57Ka3/pFjrzwI5Mnj" +
       "fPOj4cO3z+2+9D0+30FjnN2RyY3vENGcuWfdk/o42F7+2yCpiJJG0aosRgU5" +
       "jRgXhWzasMsNqD48497M2EwDO7PRZr4/EriW9ccBJ6+Ad6TG9zof9DfhuYTh" +
       "WW1Z32q/4fL8wnRH3FKoDwqBJNWb37rj4Kfbtl8QROwpm8Stg1YaHbqBNBYw" +
       "Nx/e01qz+83vc6+B0z6OTK82/YC3y7FZZdo0oLbByyAGkkiKIPvQu7HIPhmp" +
       "6x4cujo2ONozvL6n6wpvpoPZxEh6zICsREpBEJq0kvWzhjaJOzqG3jGN64w8" +
       "E0y6WXeHfzD68uZneYirxLxng61QV1YD+ZErvjaam/8S/gLw/Bsf3DR2mElv" +
       "c7eVeS/Mpt6ahohZxMp9AoS3Nr8xcfvx+0wB/CbtI6Y7dn/vy9DO3WbcMuu3" +
       "xTkllHuOWcOZ4mCTxN0tKrYKn9H71yNbH7l763ZzV83eaqQHiu37/vDFs6F9" +
       "bz6dJwEukawaHIEjYIZzzDy8Z2MKdMV3G351S3NJL2RMfaQyrUjXp2lf3Gv6" +
       "FUZ6zHVYTl3ouIMlGh4MI4HlcAYOWnPUi54M9Ua8DrUKnjWWoa7J41D4shFh" +
       "H1+mCngDvm7CRsjjBoW4o1GhG0T6BnqyvoAjCZ9Imf9eJL7oIngusxa9LEck" +
       "wl9uzC8J8e2/tAgrRmrjQgpK+HiXToVsFMutitAxslFtGEASY3S/oMBU3Sfq" +
       "tiKiZvKFZP5XTnxFqj8kz7OF00lroXsE7g0Hb9p9ID5455qgFVOhfK9iqrZK" +
       "ppNUdrHCu8FWTyjs5zcnTlx5rf7Wtx/uSK49lcIM+9pOUnrh7wXgqcsL445/" +
       "K0/e9Le5Gy4d33QKNdYCn5b8LH/Sf/jpdWeKtwb5NZEZ8HKul7yTOr2+Xq1T" +
       "ltYVr3cvzp4rJmikA54u61y7/IbsytL8Vgw1RZWmqwxMjcZ9Fl1XhKcvubIR" +
       "zTLsswsatoReYBf+8VA3kGD5MAyL49zbiyRtd2Czh5FqA9Sh4Uyujv2OS+z9" +
       "KtI43r/LmwO3w9NraaK3iHa9DpfNgQtNLa7EZlcOLIJdJGXK17q3iI6OYHMX" +
       "Jhpy2hjnJJIV4fBfipHSSVWKOyo7dLpUthSeAUvugVNXWaGpBVTmgZhsljMs" +
       "THHMionXLG1s6bjwo3YrochD67ok3fnIL6PRpY2iSZwv3/Jdjt59qFJ8NfXE" +
       "OzYU0qw8Lbj9hbDDw6Y45n9GYl/lpZ15ye6/FzzdS/Aa2IPrjrrvnZC7Prjg" +
       "rktMDS4qgL8O/cNff/P5/dNHDpuJE+I8IysKfeXI/bSCN1FLitymOUf78bqL" +
       "jr779ui19knVY/ObjO1yM/NVyzj2O7/F4U8jw3k8WsQfn8PmIdsf8cdPHd97" +
       "+DT4Xj2OLYNnxHKgkZP43r5czC80tYicrxQZexWbY6DctBaHYuAbqg45enJt" +
       "OgE+ZPhU8tLpgiMsBndZcu06dTgqNDU/HOHPmznXvxTRCy8a/8xIhU41KMKZ" +
       "TxVvfSV3Eow0+C7X8VZoTs53PPPbk3j/gYbK2QeuepmnYtnvQ7WQVCXSsuwu" +
       "vV3v5ZpOExKXqdYsxM1S40NGWove+zNSab9yAT4w530EtpJvHlRR0LopP2Gk" +
       "0U8Jzsb/u+n+CVmDQwcFufniJvkcuAMJvn6h2XiwsvhnCy8qZgLeBDp7krNO" +
       "dpKunHuxB8b4V1k7+KSHLLQ8cuDKgRtOnHeneTMtysL0NHKpgarQvCTP5qaL" +
       "CnKzeZWvX/ZZ/QNVS2xAbDI37HjEPJfFQhIY0NB+5vqubY2O7O3tKwcvfuz3" +
       "O8pfACjfSAICIzM25t78ZLQ0ROyNkdzqF/J4fp/cuezHWy5dmfjgVeuKhcf4" +
       "+YXpY+KxQ9e+eOucg21BUtNHyqBAoRl+JQXmD/nTpB4ldZLRk4EtAhdJkD2l" +
       "dT2auoDXjFwvljrrsr34XYOR9txbhdyvQdWyOkX1tWpaiSMbKM5rnB67RvGk" +
       "92lN801welw3L7qZyOFpgK3GIv2aZl+6VCc07vBG/jAFbYDfBuBwoOk/ys2D" +
       "i7EhAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "syT/C4wOSMri/w6O1+I77n53a3/F81ix");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("2aXz0cSJxR75VhY7E4C87RzO7K6mHr/ik9ERnH32pSH3/d9o/sz+RpHiyMUu" +
       "ULqfge7bX246CROevuNox2NdoZ775kM//8Czx4j10J7hUzc/w9tbb399h3CD" +
       "eHfhpvj3b/7F7/03L31xd6b+d+7OGIUzLAAA");
}
