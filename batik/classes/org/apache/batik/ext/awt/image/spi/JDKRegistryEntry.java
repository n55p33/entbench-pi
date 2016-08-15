package org.apache.batik.ext.awt.image.spi;
public class JDKRegistryEntry extends org.apache.batik.ext.awt.image.spi.AbstractRegistryEntry implements org.apache.batik.ext.awt.image.spi.URLRegistryEntry {
    public static final float PRIORITY = 1000 * org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.
                                                  PRIORITY;
    public JDKRegistryEntry() { super("JDK", PRIORITY, new java.lang.String[0],
                                      new java.lang.String[] { "image/gif" });
    }
    public boolean isCompatibleURL(org.apache.batik.util.ParsedURL purl) {
        try {
            new java.net.URL(
              purl.
                toString(
                  ));
        }
        catch (java.net.MalformedURLException mue) {
            return false;
        }
        return true;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter handleURL(org.apache.batik.util.ParsedURL purl,
                                                                      boolean needRawData) {
        final java.net.URL url;
        try {
            url =
              new java.net.URL(
                purl.
                  toString(
                    ));
        }
        catch (java.net.MalformedURLException mue) {
            return null;
        }
        final org.apache.batik.ext.awt.image.renderable.DeferRable dr =
          new org.apache.batik.ext.awt.image.renderable.DeferRable(
          );
        final java.lang.String errCode;
        final java.lang.Object[] errParam;
        if (purl !=
              null) {
            errCode =
              ERR_URL_FORMAT_UNREADABLE;
            errParam =
              (new java.lang.Object[] { "JDK",
               url });
        }
        else {
            errCode =
              ERR_STREAM_FORMAT_UNREADABLE;
            errParam =
              (new java.lang.Object[] { "JDK" });
        }
        java.lang.Thread t =
          new java.lang.Thread(
          ) {
            public void run() {
                org.apache.batik.ext.awt.image.renderable.Filter filt =
                  null;
                try {
                    java.awt.Toolkit tk =
                      java.awt.Toolkit.
                      getDefaultToolkit(
                        );
                    java.awt.Image img =
                      tk.
                      createImage(
                        url);
                    if (img !=
                          null) {
                        java.awt.image.RenderedImage ri =
                          loadImage(
                            img,
                            dr);
                        if (ri !=
                              null) {
                            filt =
                              new org.apache.batik.ext.awt.image.renderable.RedRable(
                                org.apache.batik.ext.awt.image.GraphicsUtil.
                                  wrap(
                                    ri));
                        }
                    }
                }
                catch (java.lang.ThreadDeath td) {
                    filt =
                      org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                        getBrokenLinkImage(
                          JDKRegistryEntry.this,
                          errCode,
                          errParam);
                    dr.
                      setSource(
                        filt);
                    throw td;
                }
                catch (java.lang.Throwable t) {
                    
                }
                if (filt ==
                      null)
                    filt =
                      org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                        getBrokenLinkImage(
                          JDKRegistryEntry.this,
                          errCode,
                          errParam);
                dr.
                  setSource(
                    filt);
            }
        };
        t.
          start(
            );
        return dr;
    }
    public java.awt.image.RenderedImage loadImage(java.awt.Image img,
                                                  final org.apache.batik.ext.awt.image.renderable.DeferRable dr) {
        if (img instanceof java.awt.image.RenderedImage)
            return (java.awt.image.RenderedImage)
                     img;
        org.apache.batik.ext.awt.image.spi.JDKRegistryEntry.MyImgObs observer =
          new org.apache.batik.ext.awt.image.spi.JDKRegistryEntry.MyImgObs(
          );
        java.awt.Toolkit.
          getDefaultToolkit(
            ).
          prepareImage(
            img,
            -1,
            -1,
            observer);
        observer.
          waitTilWidthHeightDone(
            );
        if (observer.
              imageError)
            return null;
        int width =
          observer.
            width;
        int height =
          observer.
            height;
        dr.
          setBounds(
            new java.awt.geom.Rectangle2D.Double(
              0,
              0,
              width,
              height));
        java.awt.image.BufferedImage bi =
          new java.awt.image.BufferedImage(
          width,
          height,
          java.awt.image.BufferedImage.
            TYPE_INT_ARGB);
        java.awt.Graphics2D g2d =
          bi.
          createGraphics(
            );
        observer.
          waitTilImageDone(
            );
        if (observer.
              imageError)
            return null;
        dr.
          setProperties(
            new java.util.HashMap(
              ));
        g2d.
          drawImage(
            img,
            0,
            0,
            null);
        g2d.
          dispose(
            );
        return bi;
    }
    public static class MyImgObs implements java.awt.image.ImageObserver {
        boolean widthDone = false;
        boolean heightDone = false;
        boolean imageDone = false;
        int width = -1;
        int height = -1;
        boolean imageError = false;
        int IMG_BITS = ALLBITS | ERROR | ABORT;
        public void clear() { width = -1;
                              height = -1;
                              widthDone =
                                false;
                              heightDone =
                                false;
                              imageDone =
                                false; }
        public boolean imageUpdate(java.awt.Image img,
                                   int infoflags,
                                   int x,
                                   int y,
                                   int width,
                                   int height) {
            synchronized (this)  {
                boolean notify =
                  false;
                if ((infoflags &
                       WIDTH) !=
                      0)
                    this.
                      width =
                      width;
                if ((infoflags &
                       HEIGHT) !=
                      0)
                    this.
                      height =
                      height;
                if ((infoflags &
                       ALLBITS) !=
                      0) {
                    this.
                      width =
                      width;
                    this.
                      height =
                      height;
                }
                if ((infoflags &
                       IMG_BITS) !=
                      0) {
                    if (!widthDone ||
                          !heightDone ||
                          !imageDone) {
                        widthDone =
                          true;
                        heightDone =
                          true;
                        imageDone =
                          true;
                        notify =
                          true;
                    }
                    if ((infoflags &
                           ERROR) !=
                          0) {
                        imageError =
                          true;
                    }
                }
                if (!widthDone &&
                      this.
                        width !=
                      -1) {
                    notify =
                      true;
                    widthDone =
                      true;
                }
                if (!heightDone &&
                      this.
                        height !=
                      -1) {
                    notify =
                      true;
                    heightDone =
                      true;
                }
                if (notify)
                    notifyAll(
                      );
            }
            return true;
        }
        public synchronized void waitTilWidthHeightDone() {
            while (!widthDone ||
                     !heightDone) {
                try {
                    wait(
                      );
                }
                catch (java.lang.InterruptedException ie) {
                    
                }
            }
        }
        public synchronized void waitTilWidthDone() {
            while (!widthDone) {
                try {
                    wait(
                      );
                }
                catch (java.lang.InterruptedException ie) {
                    
                }
            }
        }
        public synchronized void waitTilHeightDone() {
            while (!heightDone) {
                try {
                    wait(
                      );
                }
                catch (java.lang.InterruptedException ie) {
                    
                }
            }
        }
        public synchronized void waitTilImageDone() {
            while (!imageDone) {
                try {
                    wait(
                      );
                }
                catch (java.lang.InterruptedException ie) {
                    
                }
            }
        }
        public MyImgObs() { super(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "ybM6Mk95wDTf3gA9WToXc1xtGnVbUbM9bHRYferEyHK5yCtdh6cbsDRSt3Vz" +
           "JOeLCiWBtMvwsnZdGubRrhHPKgYj7syo7yCTkWniFByoKIlvYa27WKS1oL3U" +
           "UjyLHamtd1e1WMubGPi0mTfykK+kdnstIDtvgKKVanuqGtWEVFoSMY3RnTcd" +
           "ZdO2NxOaEkq1nFT2W0klbcvaJt2JWzWrE7kTq8Qi6E/bJtLUY6HV0hrbNN/u" +
           "LHTAcbtlfY4p2KgNsseJUM2kGtk0pUVqrhea7bd4xIjgxmyx3a1iLu31l+2h" +
           "4zkjfzTvLrcTz14yveVQzCo4Q/AmlSfOdrPsNyRhJC5Sm62oq4whBXi1jAXe" +
           "hvmWP/BVyeC0jFE2QCfd6VKf2nNAIV4EcYSNtqtarRpsqEED2cSDTt7qCboR" +
           "zzrw1PfGynwVVpYr1R8tjIBJbH9Sa5p5pdOsrYwBge1SUZPgdqPBgExWnNUH" +
           "IU65KiF2l7X6qIN5QWc17NWnRLwdm9SKbEwkuMPORDqidAflx3G0mC1YA1st" +
           "MgudIygKxp3SsQ+TGC/EnuXZo12F6uiNBkifagN7mTIqbbWJuUTDdXTmralc" +
           "aUrjoI7V6d2a2pGdfq1F2nStt2NbS3kltpqdjVvNlBk/ItA5umpW6m4jF1TL" +
           "wOMKbtrg82mV1mr4aMIlmNlUKpVe3nKGihzWu8TCt2pCPR9oddmfJwGdpgOp" +
           "ji76PrxZyehqU4c7KI3go3qjIftjdtis8ZImeKY2gjmVCsVNn5F3o5huoTZY" +
           "JSZqs61Me2ZvpvjTietl2/pkO2z60zj3Wupi1N8OK0hl0euQSR8LufXSdWRm" +
           "wLmW6vTEbUo0Ry4Fw5ONF/pCWAeJWmVMVBSqXzXIub1NhHVED/o03zQb62yW" +
           "rZp0PpyrY1kZdP2anVeE7lwiSW2GMnSF0vVZIooMBrepmLUriJZsNI8htqjc" +
           "BrkoCOVLQ6DDBsrL6aCaCiB91kdzQSLEZEHiNXRhJ2l/1MXokFQr0SCebbH1" +
           "uC3x8FjpdRM101NzvG3EehosNmii4dJ0RplDbkC5jVDnJ7QMO/6E1wi80u4u" +
           "+6GrtpdqDjfgjYVYbSAkX4MRjncjZc3ocNjXJtGs6ejpyoZnfW6FMEtcWoPP" +
           "Wd10GyuCldiWYOpSp8qtpZR0Zv2RNDQ2aHPpej0an5pjd5oSiqvaMavAawbf" +
           "jGjEHKW1WMC1aIiweriR58QwCEw8UjHLVTrEjlCqGD/tZDUbE+e1MdrhOW4a" +
           "bokGz/DYeFTfqjJZSxi5txNXeque+2sMtmrtHdzRHCqyt8LQ6HSKz/wfur/t" +
           "h8fLnZbjOwO2gxUd//Q+dhiyOxM8OCGYHe9UlbtNReW8E7hTpxQXjjZ7ni23" +
           "Xk6OXYdFOVnFWpRqUbEP/Y7zrhGUe9Cf/sjLr6iTH0MODve5qAS6dHi744TY" +
           "JTDMe8/fbGfKKxQn5xK/8pE/eIb/XvOD93Hy+s4zTJ4d8t8xr/7q4LuVf30A" +
           "PXB8SnHb5Y5bkV689WziSgRmVeTxt5xQvONY91cLVX8neL5wqPsvnN0lPDH6" +
           "bda8UFpz7zR3OV579S59nymKH0+gi4qjHd7UObu3lfqWeuJ0P3Gvba3TFMqG" +
           "Tx8LW2xol/vsbxwK+8bfjLCXDr3l0DUfO3bN0imPt03PFuVYP38X5fxSUXw+" +
           "gR4pXXweqHKy39g/UcfPfRvqeLZoLK59fO1QHV+7D3UcHO7VPgrWDcWMfM/a" +
           "aeo9XeE/36XvS0XxHxPoya1sJbzliMXJAXnLGcvrJ4L/8rcreB08f3wo+B/f" +
           "t+BF8cV7ivubd+n7raL4cgJdOy3uHQT99W9X0AZ43jwU9M2/JUF/9y59v1cU" +
           "vw0WlUNBzzXpV/4GTHrhkT3u/v23IOkf3aXvG0XxtROTDk+fxp0S9A/uR9As" +
           "gS4fXR86ijD1v8YdJLCWPX3b/cf9nT3lM69cvfzUK/P/Wl6+Ob5X9zANXdY3" +
           "jnP6pPtU/VIQabpVCv7w/tw7KF//O4Gevzd/CfQAKEuB/nyP9xcJ9Nzd8cAy" +
           "Ub5PY72ZQE+fhwVogPIU9IWDBHrbnaABJChPQ14EZjwLCeiX79NwlxPoygkc" +
           "yCL2ldMgj4DRAUhRfTS4w2HV/hpCduFU5nHo36W3PHEvbzlGOX1jqFBBeSv2" +
           "KLPY7O/F3lRee4Uaf/830R/b31hSHHm3K0a5TEMP7S9PHWcn7z53tKOxLpEv" +
           "fOux1x/+rqM06rE9wydz7RRv77zzlaC+GyTlJZ7dF5763Pt+/JWvlGdn/xeR" +
           "YpbariwAAA==");
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
       "HbsWn3vzf/zBf//CV6vjp/8HcGSI1EsmAAA=");
}
