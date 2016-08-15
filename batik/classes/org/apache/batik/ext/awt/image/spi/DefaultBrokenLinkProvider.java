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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "G1fnK4cNrzf+1svf+LE3Xv731RHFI04qqQmY+93l/P5Cne+8+c1v/e4Tz325" +
       "OtJ7cKWmByNcvfhw572GS9cVKuUej6rXXz7T7trJ+Wi1ZRWd7tT+zNuZ6ixW" +
       "rntGYGV2ReldCIsogx4A8pTZz0fFWXNHJy55Ysx3nxuT8MLAKHfWT8sOR7tO" +
       "eHx2VwQUFncV/CcPWn2+TF6+z/nU37xP2ZfK5G9k0ENaKchB7vuQ/2JxeP+l" +
       "+9D8Upl8OoOeqM5Ss5MN/IO/nMHIZ95uI/Ei14O2Z37/dPmxPGb92Inff+wd" +
       "+P21qjPv5/KVp5xB3+cr0r97H32/WiZfzqCnLePCkT3tnyjdP1f6K+9E6SKD" +
       "3n/PiwDlSeYzd1xQOlyq0b78xo1H3veG+K8OgXN68eXRCfSImXvexYOnC/nr" +
       "UWKYTqXQo4djqIN3/cMMeuntrywAtwdppcOvHer94wx6/v71gNNV74u1/mkG" +
       "PXOvWqANkF6k/g0QLnejBpQgvUj5NYBgVylB+9X7It3XM+ixczoQ54fMRZJv" +
       "AO6ApMz+i+g0atvfx62OO3uxuHZ57DtzlKffzlEuDJcvXwLg6m7b6YCUH263" +
       "3da+8sZo+iPfRX/hcMtA89T9vuTyCMDKw4WHs0HtxXtyO+V1ffjK95781Uc/" +
       "dDoAP3kQ+DzkLsj2wt2P8Sk/yqqD9/0/eN/f++gvvvH71SHO/wWQKj4SdCgA" +
       "AA==");
}
