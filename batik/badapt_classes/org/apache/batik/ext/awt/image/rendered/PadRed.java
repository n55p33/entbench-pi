package org.apache.batik.ext.awt.image.rendered;
public class PadRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    static final boolean DEBUG = false;
    org.apache.batik.ext.awt.image.PadMode padMode;
    java.awt.RenderingHints hints;
    public PadRed(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                  java.awt.Rectangle bounds,
                  org.apache.batik.ext.awt.image.PadMode padMode,
                  java.awt.RenderingHints hints) { super(src, bounds, src.
                                                           getColorModel(
                                                             ),
                                                         fixSampleModel(
                                                           src,
                                                           bounds),
                                                         bounds.
                                                           x,
                                                         bounds.
                                                           y,
                                                         null);
                                                   this.padMode = padMode;
                                                   if (DEBUG) { java.lang.System.
                                                                  out.
                                                                  println(
                                                                    "Src: " +
                                                                    src +
                                                                    " Bounds: " +
                                                                    bounds +
                                                                    " Off: " +
                                                                    src.
                                                                      getTileGridXOffset(
                                                                        ) +
                                                                    ", " +
                                                                    src.
                                                                      getTileGridYOffset(
                                                                        ));
                                                   }
                                                   this.
                                                     hints =
                                                     hints;
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        java.awt.Rectangle srcR =
          src.
          getBounds(
            );
        java.awt.Rectangle wrR =
          wr.
          getBounds(
            );
        if (wrR.
              intersects(
                srcR)) {
            java.awt.Rectangle r =
              wrR.
              intersection(
                srcR);
            java.awt.image.WritableRaster srcWR;
            srcWR =
              wr.
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
            src.
              copyData(
                srcWR);
        }
        if (padMode ==
              org.apache.batik.ext.awt.image.PadMode.
                ZERO_PAD) {
            handleZero(
              wr);
        }
        else
            if (padMode ==
                  org.apache.batik.ext.awt.image.PadMode.
                    REPLICATE) {
                handleReplicate(
                  wr);
            }
            else
                if (padMode ==
                      org.apache.batik.ext.awt.image.PadMode.
                        WRAP) {
                    handleWrap(
                      wr);
                }
        return wr;
    }
    protected static class ZeroRecter {
        java.awt.image.WritableRaster wr;
        int bands;
        static int[] zeros = null;
        public ZeroRecter(java.awt.image.WritableRaster wr) {
            super(
              );
            this.
              wr =
              wr;
            this.
              bands =
              wr.
                getSampleModel(
                  ).
                getNumBands(
                  );
        }
        public void zeroRect(java.awt.Rectangle r) {
            synchronized (this)  {
                if (zeros ==
                      null ||
                      zeros.
                        length <
                      r.
                        width *
                      bands)
                    zeros =
                      (new int[r.
                                 width *
                                 bands]);
            }
            for (int y =
                   0;
                 y <
                   r.
                     height;
                 y++) {
                wr.
                  setPixels(
                    r.
                      x,
                    r.
                      y +
                      y,
                    r.
                      width,
                    1,
                    zeros);
            }
        }
        public static org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter getZeroRecter(java.awt.image.WritableRaster wr) {
            if (org.apache.batik.ext.awt.image.GraphicsUtil.
                  is_INT_PACK_Data(
                    wr.
                      getSampleModel(
                        ),
                    false))
                return new org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter_INT_PACK(
                  wr);
            else
                return new org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter(
                  wr);
        }
        public static void zeroRect(java.awt.image.WritableRaster wr) {
            org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter zr =
              getZeroRecter(
                wr);
            zr.
              zeroRect(
                wr.
                  getBounds(
                    ));
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "3hmdEq84fPRfXRMsn3ofAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "oaFPW+sh7O5YmwtDvOZOh3o7hIXAyOMVUu0tq3zF6Qm1TqhhrWp71PUXocgv" +
           "m0tD0iKyaWlVvbsN6Gnay9aD+mjDASTbVEUisVwdAUtG2kgbINKlZmBxSrG0" +
           "K0yCLeKvseqg023V2gPVlwnWQcMVLap6OtFhdQNvl40OsUPmE5fuym1i1OGN" +
           "BQ3TlDMN+hulmmoEz7ijWXM0MSeq2xqxLdyZy7xkYM60DfAq99am5rbhYD5r" +
           "dYxagNRYNtJMsjKewxpLBq4q4O2wFdKL2c7ZtIlmnTDzrYbX68E6ks0mFlrI" +
           "etvnnArObbsrtm064y067ydVIsKm6tbfNcZDZjIdaKM8BbuoyjAZiThms7N0" +
           "EY1XFm2ZaTR1Rg1llzCDlipS/NQN0nVvpzfoFrJLhJyu2mlNXO9kVl2Fs0mn" +
           "jmzxSTb1ORaDp0yrMQ9FZ1jR2nJq1p02g25a1SyXtQka04S2g8lqFyUXbbBx" +
           "xGIsy1tNGCBzmKSwwAVkY2GTW5tjx6PWtmFszHHSVBViPWjNRzwp08J0upob" +
           "Uj0K08xaL0ZuFs7zvO6z/VWLDPpbjG810iqCbFSr3a9vh1OeJs2a09ss0yZf" +
           "9bnNXNkEKK9NR21/igRg2uGZgyzaC5nx3ZxsjEAwQMnRtr22LEto9/VcqGCT" +
           "MG62Pb8r+gKaMgNYSOstBB13KBWNN11OCiOnFwdeyprDCovmfs9bdBUW3fQt" +
           "e7fGoi0dxTDR57tVRCaC6VTxl/oQ6++yBSFY9kAkV7BtDdgG2+twK4LLoxpl" +
           "0bFDd0eNGedFOCbyKW5UR83dmqOlis1bo/7Cpec7f7zl2LWDNY1pbS0MkJwY" +
           "NqY7ppZO40lGwaTXV1m5gal8x9IYllkE463j2/p44+HrMbzZwrnH5mGzhbkL" +
           "1al1owaY8VHNxMGkc9VMH4SVhcuO88pwmzGGWmHXVtQam6YtrSYBORdxtFeb" +
           "GDmBz+fMQoCDthWblYW909UQpbxYjMTUGiUpmyErYaJYitlaBpVKp6rOpJkt" +
           "KH6/wVrxWDalBaflDVtpdesdRCB0PpsbRI2L05AnWJ9Uc3iBN3NqJUnDDbej" +
           "zDWIMXsyb1kygbO1qVpn58NQ4mf5ptFJmE4XUXeNfpfeZRq8I9PuiMe2HYmL" +
           "avEI+G/u9lVEGu62vfHCXLHjal5RYtx1uzlhNg1tm8JTE+3Rq63mx9kKlqqB" +
           "0NkGZMYLS75JEWMhqjIqiOOQeRvth5PlQhTWrCIrus/SuyoyQTBUHtsksmTb" +
           "rkCT7bnoCFpHq1J1NZDrLYNMO2JNZFkxFqXqZiok6IwJrW27rU1imJyMw+Fk" +
           "3MMck+BwbqY0nNVW7gT1zGmjJMyKdHuWDuRhpx7nqzbFThITUcW4meZxa90f" +
           "Bwus1sBRz+W9XSYumWRqTeiFG89D3WvPFl2wpx008GWQ5NTICuHNwO8wkzBp" +
           "8VUHMedg9qzZir8QK9O60pakBJFUgJ1VEFFqHEz73Q2MMtORLGIYPSCIeqOy" +
           "kSh0vAuXIvBUjWtVc24ztUPGB+4xZtK67euDVbthsjNTnFEJCNhNsHv/gWJb" +
           "/9pbO254vDxZOftWY+mhRcVPvIUThewex4Ap9FAUh2lxI62X4x4uCsvzpLdD" +
           "l27/z50nn7sXgorD8Wfu9YFGeTD+yQ+99rrOfAo5Ojmk4lLo+sl3M4d+rpb5" +
           "1cUz7RfBE5zwEFw+0z7o4M4D7VKb2d0O3i5dDT5xdjVY3M0rgeUZZbOfv88h" +
           "26eL5JMpdCM/udK/68HPJnT0g4U+9a3OfM4PckkVxcl+Wb87UcXuLaji6OBY" +
           "99NH8bdaEvzafST/N0XyuRR61DLSw/cMl5zxl78DUZ8sClvgefVE1Ff/f4r6" +
           "2/cR9fNF8pvnjFz8/+xByt96K1JmKfTwQV+nvnf81r4gAfPsqTs+V9t/YqV9" +
           "5vWbN975Ov/H+8uU08+gHiKhG+ba887fRZ7LX49iw9wjzUP7m8mofH0xhb73" +
           "22QN6Oc0W0r1B/sevpRCz96/hxS6Vr7Pt/rjFHrqXq1S6CpIz1P/WQq9/W7U" +
           "gBKk5yn/PIVuXaYs7x3B+zzdV4CVDnQApPaZ8yT/EfQOSIrsX0Z3Od3eXxln" +
           "Vy4C5JnTPPGtnOYcpj5/4Yak/Jzx9DZjvf+g8WXts6+P6R/9RutT++9ONE/J" +
           "86KXGyT04P4TmLMbkefu2dtpX9dHL37zsV986IVTlH5sz/Bhvp3j7d13/8hj" +
           "4Edp+VlG/qvv/KX3/4vX/6I8bP9/Ul2CIWcqAAA=");
    }
    protected static class ZeroRecter_INT_PACK extends org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter {
        final int base;
        final int scanStride;
        final int[] pixels;
        final int[] zeros;
        final int x0;
        final int y0;
        public ZeroRecter_INT_PACK(java.awt.image.WritableRaster wr) {
            super(
              wr);
            java.awt.image.SinglePixelPackedSampleModel sppsm;
            sppsm =
              (java.awt.image.SinglePixelPackedSampleModel)
                wr.
                getSampleModel(
                  );
            scanStride =
              sppsm.
                getScanlineStride(
                  );
            java.awt.image.DataBufferInt db =
              (java.awt.image.DataBufferInt)
                wr.
                getDataBuffer(
                  );
            x0 =
              wr.
                getMinY(
                  );
            y0 =
              wr.
                getMinX(
                  );
            base =
              db.
                getOffset(
                  ) +
                sppsm.
                getOffset(
                  x0 -
                    wr.
                    getSampleModelTranslateX(
                      ),
                  y0 -
                    wr.
                    getSampleModelTranslateY(
                      ));
            pixels =
              db.
                getBankData(
                  )[0];
            if (wr.
                  getWidth(
                    ) >
                  10)
                zeros =
                  (new int[wr.
                             getWidth(
                               )]);
            else
                zeros =
                  null;
        }
        public void zeroRect(java.awt.Rectangle r) {
            final int rbase =
              base +
              (r.
                 x -
                 x0) +
              (r.
                 y -
                 y0) *
              scanStride;
            if (r.
                  width >
                  10) {
                for (int y =
                       0;
                     y <
                       r.
                         height;
                     y++) {
                    int sp =
                      rbase +
                      y *
                      scanStride;
                    java.lang.System.
                      arraycopy(
                        zeros,
                        0,
                        pixels,
                        sp,
                        r.
                          width);
                }
            }
            else {
                int sp =
                  rbase;
                int end =
                  sp +
                  r.
                    width;
                int adj =
                  scanStride -
                  r.
                    width;
                for (int y =
                       0;
                     y <
                       r.
                         height;
                     y++) {
                    while (sp <
                             end)
                        pixels[sp++] =
                          0;
                    sp +=
                      adj;
                    end +=
                      scanStride;
                }
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "A+wRQJCCKgAA");
    }
    protected void handleZero(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        java.awt.Rectangle srcR =
          src.
          getBounds(
            );
        java.awt.Rectangle wrR =
          wr.
          getBounds(
            );
        org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter zr =
          org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter.
          getZeroRecter(
            wr);
        java.awt.Rectangle ar =
          new java.awt.Rectangle(
          wrR.
            x,
          wrR.
            y,
          wrR.
            width,
          wrR.
            height);
        java.awt.Rectangle dr =
          new java.awt.Rectangle(
          wrR.
            x,
          wrR.
            y,
          wrR.
            width,
          wrR.
            height);
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "WrR: " +
                wrR +
                " srcR: " +
                srcR);
        }
        if (ar.
              x <
              srcR.
                x) {
            int w =
              srcR.
                x -
              ar.
                x;
            if (w >
                  ar.
                    width)
                w =
                  ar.
                    width;
            dr.
              width =
              w;
            zr.
              zeroRect(
                dr);
            ar.
              x +=
              w;
            ar.
              width -=
              w;
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "WrR: [" +
                ar.
                  x +
                "," +
                ar.
                  y +
                "," +
                ar.
                  width +
                "," +
                ar.
                  height +
                "] s rcR: " +
                srcR);
        }
        if (ar.
              y <
              srcR.
                y) {
            int h =
              srcR.
                y -
              ar.
                y;
            if (h >
                  ar.
                    height)
                h =
                  ar.
                    height;
            dr.
              x =
              ar.
                x;
            dr.
              y =
              ar.
                y;
            dr.
              width =
              ar.
                width;
            dr.
              height =
              h;
            zr.
              zeroRect(
                dr);
            ar.
              y +=
              h;
            ar.
              height -=
              h;
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "WrR: [" +
                ar.
                  x +
                "," +
                ar.
                  y +
                "," +
                ar.
                  width +
                "," +
                ar.
                  height +
                "] srcR: " +
                srcR);
        }
        if (ar.
              y +
              ar.
                height >
              srcR.
                y +
              srcR.
                height) {
            int h =
              ar.
                y +
              ar.
                height -
              (srcR.
                 y +
                 srcR.
                   height);
            if (h >
                  ar.
                    height)
                h =
                  ar.
                    height;
            int y0 =
              ar.
                y +
              ar.
                height -
              h;
            dr.
              x =
              ar.
                x;
            dr.
              y =
              y0;
            dr.
              width =
              ar.
                width;
            dr.
              height =
              h;
            zr.
              zeroRect(
                dr);
            ar.
              height -=
              h;
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "WrR: [" +
                ar.
                  x +
                "," +
                ar.
                  y +
                "," +
                ar.
                  width +
                "," +
                ar.
                  height +
                "] srcR: " +
                srcR);
        }
        if (ar.
              x +
              ar.
                width >
              srcR.
                x +
              srcR.
                width) {
            int w =
              ar.
                x +
              ar.
                width -
              (srcR.
                 x +
                 srcR.
                   width);
            if (w >
                  ar.
                    width)
                w =
                  ar.
                    width;
            int x0 =
              ar.
                x +
              ar.
                width -
              w;
            dr.
              x =
              x0;
            dr.
              y =
              ar.
                y;
            dr.
              width =
              w;
            dr.
              height =
              ar.
                height;
            zr.
              zeroRect(
                dr);
            ar.
              width -=
              w;
        }
    }
    protected void handleReplicate(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        java.awt.Rectangle srcR =
          src.
          getBounds(
            );
        java.awt.Rectangle wrR =
          wr.
          getBounds(
            );
        int x =
          wrR.
            x;
        int y =
          wrR.
            y;
        int width =
          wrR.
            width;
        int height =
          wrR.
            height;
        java.awt.Rectangle r;
        {
            int minX =
              srcR.
                x >
              x
              ? srcR.
                  x
              : x;
            int maxX =
              srcR.
                x +
              srcR.
                width -
              1 <
              x +
              width -
              1
              ? srcR.
                  x +
              srcR.
                width -
              1
              : x +
              width -
              1;
            int minY =
              srcR.
                y >
              y
              ? srcR.
                  y
              : y;
            int maxY =
              srcR.
                y +
              srcR.
                height -
              1 <
              y +
              height -
              1
              ? srcR.
                  y +
              srcR.
                height -
              1
              : y +
              height -
              1;
            int x0 =
              minX;
            int w =
              maxX -
              minX +
              1;
            int y0 =
              minY;
            int h =
              maxY -
              minY +
              1;
            if (w <
                  0) {
                x0 =
                  0;
                w =
                  0;
            }
            if (h <
                  0) {
                y0 =
                  0;
                h =
                  0;
            }
            r =
              new java.awt.Rectangle(
                x0,
                y0,
                w,
                h);
        }
        if (y <
              srcR.
                y) {
            int repW =
              r.
                width;
            int repX =
              r.
                x;
            int wrX =
              r.
                x;
            int wrY =
              y;
            if (x +
                  width -
                  1 <=
                  srcR.
                    x) {
                repW =
                  1;
                repX =
                  srcR.
                    x;
                wrX =
                  x +
                    width -
                    1;
            }
            else
                if (x >=
                      srcR.
                        x +
                      srcR.
                        width) {
                    repW =
                      1;
                    repX =
                      srcR.
                        x +
                        srcR.
                          width -
                        1;
                    wrX =
                      x;
                }
            java.awt.image.WritableRaster wr1 =
              wr.
              createWritableChild(
                wrX,
                wrY,
                repW,
                1,
                repX,
                srcR.
                  y,
                null);
            src.
              copyData(
                wr1);
            wrY++;
            int endY =
              srcR.
                y;
            if (y +
                  height <
                  endY)
                endY =
                  y +
                    height;
            if (wrY <
                  endY) {
                int[] pixels =
                  wr.
                  getPixels(
                    wrX,
                    wrY -
                      1,
                    repW,
                    1,
                    (int[])
                      null);
                while (wrY <
                         srcR.
                           y) {
                    wr.
                      setPixels(
                        wrX,
                        wrY,
                        repW,
                        1,
                        pixels);
                    wrY++;
                }
            }
        }
        if (y +
              height >
              srcR.
                y +
              srcR.
                height) {
            int repW =
              r.
                width;
            int repX =
              r.
                x;
            int repY =
              srcR.
                y +
              srcR.
                height -
              1;
            int wrX =
              r.
                x;
            int wrY =
              srcR.
                y +
              srcR.
                height;
            if (wrY <
                  y)
                wrY =
                  y;
            if (x +
                  width <=
                  srcR.
                    x) {
                repW =
                  1;
                repX =
                  srcR.
                    x;
                wrX =
                  x +
                    width -
                    1;
            }
            else
                if (x >=
                      srcR.
                        x +
                      srcR.
                        width) {
                    repW =
                      1;
                    repX =
                      srcR.
                        x +
                        srcR.
                          width -
                        1;
                    wrX =
                      x;
                }
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "wr: " +
                    wr.
                      getBounds(
                        ));
                java.lang.System.
                  out.
                  println(
                    "req: [" +
                    wrX +
                    ", " +
                    wrY +
                    ", " +
                    repW +
                    ", 1]");
            }
            java.awt.image.WritableRaster wr1 =
              wr.
              createWritableChild(
                wrX,
                wrY,
                repW,
                1,
                repX,
                repY,
                null);
            src.
              copyData(
                wr1);
            wrY++;
            int endY =
              y +
              height;
            if (wrY <
                  endY) {
                int[] pixels =
                  wr.
                  getPixels(
                    wrX,
                    wrY -
                      1,
                    repW,
                    1,
                    (int[])
                      null);
                while (wrY <
                         endY) {
                    wr.
                      setPixels(
                        wrX,
                        wrY,
                        repW,
                        1,
                        pixels);
                    wrY++;
                }
            }
        }
        if (x <
              srcR.
                x) {
            int wrX =
              srcR.
                x;
            if (x +
                  width <=
                  srcR.
                    x) {
                wrX =
                  x +
                    width -
                    1;
            }
            int xLoc =
              x;
            int[] pixels =
              wr.
              getPixels(
                wrX,
                y,
                1,
                height,
                (int[])
                  null);
            while (xLoc <
                     wrX) {
                wr.
                  setPixels(
                    xLoc,
                    y,
                    1,
                    height,
                    pixels);
                xLoc++;
            }
        }
        if (x +
              width >
              srcR.
                x +
              srcR.
                width) {
            int wrX =
              srcR.
                x +
              srcR.
                width -
              1;
            if (x >=
                  srcR.
                    x +
                  srcR.
                    width) {
                wrX =
                  x;
            }
            int xLoc =
              wrX +
              1;
            int endX =
              x +
              width -
              1;
            int[] pixels =
              wr.
              getPixels(
                wrX,
                y,
                1,
                height,
                (int[])
                  null);
            while (xLoc <
                     endX) {
                wr.
                  setPixels(
                    xLoc,
                    y,
                    1,
                    height,
                    pixels);
                xLoc++;
            }
        }
    }
    protected void handleWrap(java.awt.image.WritableRaster wr) {
        handleZero(
          wr);
    }
    protected static java.awt.image.SampleModel fixSampleModel(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                                                               java.awt.Rectangle bounds) {
        int defSz =
          org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
          getDefaultTileSize(
            );
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
              bounds.
                width)
            w =
              bounds.
                width;
        int h =
          sm.
          getHeight(
            );
        if (h <
              defSz)
            h =
              defSz;
        if (h >
              bounds.
                height)
            h =
              bounds.
                height;
        return sm.
          createCompatibleSampleModel(
            w,
            h);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "oCSqHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UXTEb7opAAA=");
}
