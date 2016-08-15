package org.apache.batik.ext.awt.image.spi;
public class DefaultBrokenLinkProvider extends org.apache.batik.ext.awt.image.spi.BrokenLinkProvider {
    static org.apache.batik.ext.awt.image.renderable.Filter brokenLinkImg =
      null;
    static final java.lang.String MESSAGE_RSRC = "resources.Messages";
    static final java.awt.Color BROKEN_LINK_COLOR = new java.awt.Color(255,
                                                                       255,
                                                                       255,
                                                                       190);
    public static java.lang.String formatMessage(java.lang.Object base, java.lang.String code,
                                                 java.lang.Object[] params) {
        java.lang.ClassLoader cl =
          null;
        try {
            cl =
              org.apache.batik.ext.awt.image.spi.DefaultBrokenLinkProvider.class.
                getClassLoader(
                  );
            cl =
              base.
                getClass(
                  ).
                getClassLoader(
                  );
        }
        catch (java.lang.SecurityException se) {
            
        }
        org.apache.batik.i18n.LocalizableSupport ls;
        ls =
          new org.apache.batik.i18n.LocalizableSupport(
            MESSAGE_RSRC,
            base.
              getClass(
                ),
            cl);
        return ls.
          formatMessage(
            code,
            params);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getBrokenLinkImage(java.lang.Object base,
                                                                               java.lang.String code,
                                                                               java.lang.Object[] params) {
        synchronized (org.apache.batik.ext.awt.image.spi.DefaultBrokenLinkProvider.class)  {
            if (brokenLinkImg !=
                  null)
                return brokenLinkImg;
            java.awt.image.BufferedImage bi;
            bi =
              new java.awt.image.BufferedImage(
                100,
                100,
                java.awt.image.BufferedImage.
                  TYPE_INT_ARGB);
            java.util.Hashtable ht =
              new java.util.Hashtable(
              );
            ht.
              put(
                BROKEN_LINK_PROPERTY,
                formatMessage(
                  base,
                  code,
                  params));
            bi =
              new java.awt.image.BufferedImage(
                bi.
                  getColorModel(
                    ),
                bi.
                  getRaster(
                    ),
                bi.
                  isAlphaPremultiplied(
                    ),
                ht);
            java.awt.Graphics2D g2d =
              bi.
              createGraphics(
                );
            g2d.
              setColor(
                BROKEN_LINK_COLOR);
            g2d.
              fillRect(
                0,
                0,
                100,
                100);
            g2d.
              setColor(
                java.awt.Color.
                  black);
            g2d.
              drawRect(
                2,
                2,
                96,
                96);
            g2d.
              drawString(
                "Broken Image",
                6,
                50);
            g2d.
              dispose(
                );
            brokenLinkImg =
              new org.apache.batik.ext.awt.image.renderable.RedRable(
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  wrap(
                    bi));
            return brokenLinkImg;
        }
    }
    public DefaultBrokenLinkProvider() { super(
                                           );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
