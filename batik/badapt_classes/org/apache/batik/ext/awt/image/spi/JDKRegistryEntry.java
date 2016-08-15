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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "VXPEeacSOJLNj9wZ78y7HmqLGWspPMvhpqviC0/1NpzQ2dRCMzEb+DREcDhJ" +
           "8Wmq6zDTUnqrMPDJDRd1e4Ne0DWthcIl664szNllr5dY3I42lR1N6DDf2GRa" +
           "VzKUpab7jBgQfo+WauJwovCK5Up+2Gp1JuvMDvoKsRJDdNiuRzy1RkVn3dlN" +
           "Vl1rst6NxZmHbmybaw3XPWGNai1+jPZrlj2YjJiZK65pWWP1NbyUGngL99oS" +
           "s1mpm3VDb+zoSGcqthqb+q7Xc9l5pvWsiT2UpkyFs9xoWIfllupvVtsG2/fT" +
           "kcDEkbOBK1OO3C3cCUvlvjDAm4TqmK41j5f+hvT7ieD2Jonv62F70FK8fKqm" +
           "YWWXZ858J48ZkUWU4Wyt1av+mPXzVtClZvGkF8vLhTYY8yCYRsWkbcfMJmY7" +
           "Y8YGqqha7obkJkrMC01dZQej7Q6fD9uD+ZBzgnDiOHbVqYBZkCaYYe1ihqm0" +
           "a6wriQ5pKOJoGXXWS7g1cteohI9tSYpphek54xnXoTdUlY1CeTBJ1tgoC6QW" +
           "q7VrElxtyXHei6c1j9PSWQtvDVYVj3eU1A0W7pLj4E0l57ZWezaMJhg6F7fD" +
           "hdZeThWp39e8lk4Zmcxadl1a91jPqUkrDaMVo0O2QkPVdqvuRtd8xh6RRsDv" +
           "OjZFBCODpJbBdtvSNKVPDkaqa87CLo3FlMlMZrOl22E7ZuLVcqpvbRJpOLJU" +
           "mp2umIQaq4HrmmN6mOZbLewazfo67LYplhzVg/rS95EGuh3I1mwctCuo5EVk" +
           "k8/8eY2YJ92+gsTtFk9lLN/MqPkgx6rwQsepVUiv2Aiv8CspXNeSYNfi7NSV" +
           "5V0+qNdsbDNqjzcD4Fm60DWcdGCgLjwwhjpqt1uybbEZ32VmdDfNG20jMVUb" +
           "pncqyo8ZZ+MBfnNr0zUmERsBZdZmm3FLn8n6mOHGY0mYbglxE1qCVA3QYWZ4" +
           "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" +
           "5CtfLc/O/i+C0m2qriwAAA==");
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
       "0x88+a38+On/AO7XdRRLJgAA");
}
