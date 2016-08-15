package org.apache.batik.ext.awt.image.codec.tiff;
public class TIFFRegistryEntry extends org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry {
    static final byte[] sig1 = { (byte) 73, (byte) 73, 42, 0 };
    static final byte[] sig2 = { (byte) 77, (byte) 77, 0, 42 };
    static org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[]
      magicNumbers =
      { new org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber(
      0,
      sig1),
    new org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber(
      0,
      sig2) };
    static final java.lang.String[] exts = { "tiff", "tif" };
    static final java.lang.String[] mimeTypes = { "image/tiff",
    "image/tif" };
    public TIFFRegistryEntry() { super("TIFF", exts, mimeTypes,
                                       magicNumbers); }
    public org.apache.batik.ext.awt.image.renderable.Filter handleStream(java.io.InputStream inIS,
                                                                         org.apache.batik.util.ParsedURL origURL,
                                                                         boolean needRawData) {
        final org.apache.batik.ext.awt.image.renderable.DeferRable dr =
          new org.apache.batik.ext.awt.image.renderable.DeferRable(
          );
        final java.io.InputStream is =
          inIS;
        final java.lang.String errCode;
        final java.lang.Object[] errParam;
        if (origURL !=
              null) {
            errCode =
              ERR_URL_FORMAT_UNREADABLE;
            errParam =
              (new java.lang.Object[] { "TIFF",
               origURL });
        }
        else {
            errCode =
              ERR_STREAM_FORMAT_UNREADABLE;
            errParam =
              (new java.lang.Object[] { "TIFF" });
        }
        java.lang.Thread t =
          new java.lang.Thread(
          ) {
            public void run() {
                org.apache.batik.ext.awt.image.renderable.Filter filt;
                try {
                    org.apache.batik.ext.awt.image.codec.tiff.TIFFDecodeParam param =
                      new org.apache.batik.ext.awt.image.codec.tiff.TIFFDecodeParam(
                      );
                    org.apache.batik.ext.awt.image.codec.util.SeekableStream ss =
                      org.apache.batik.ext.awt.image.codec.util.SeekableStream.
                      wrapInputStream(
                        is,
                        true);
                    org.apache.batik.ext.awt.image.rendered.CachableRed cr =
                      new org.apache.batik.ext.awt.image.codec.tiff.TIFFImage(
                      ss,
                      param,
                      0);
                    cr =
                      new org.apache.batik.ext.awt.image.rendered.Any2sRGBRed(
                        cr);
                    filt =
                      new org.apache.batik.ext.awt.image.renderable.RedRable(
                        cr);
                }
                catch (java.io.IOException ioe) {
                    filt =
                      org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                        getBrokenLinkImage(
                          TIFFRegistryEntry.this,
                          errCode,
                          errParam);
                }
                catch (java.lang.ThreadDeath td) {
                    filt =
                      org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                        getBrokenLinkImage(
                          TIFFRegistryEntry.this,
                          errCode,
                          errParam);
                    dr.
                      setSource(
                        filt);
                    throw td;
                }
                catch (java.lang.Throwable t) {
                    filt =
                      org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                        getBrokenLinkImage(
                          TIFFRegistryEntry.this,
                          errCode,
                          errParam);
                }
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
       "3/yBm46aHNZ8SrLXL3784ODgE7ef97xjd7txMpXs6e7tN186UvqV78lvXv4e" +
       "/eZLJbOX38hvvnKfup8rir977Dcv389vfv6C37z0Fv2GBFf10KDVe/jNq2/a" +
       "bx6xDVs93g54+ZxsX31D2Uo26SWwzH6wdoAeVIr///DuvT9wbMCzIrxna8m3" +
       "jlxyDqAFTP23thZaVP+dcwJ137RAIAV57MT5aNfZ3P7J//yF3/ybz30TZGAj" +
       "6MFdsRoCmcQpD90j219/9YtPv+2l3//Jcg8BuMr8r333qY8VXP/pW1PrqUIt" +
       "vsRvWgqjcbnsV5VCs7vlZVfA9L/5nrWNbnx50AiH+NGProrSEpdTbhkvZbsl" +
       "cvVGEhkZLUcML+qK3Yz5KUr0xHEkZivPihvG2FwojlrXBo5XEUXHt6yV2Zz1" +
       "ug2vO+RWrYbQ6spJKHXHnqEPeXwxFKrThuEz1DDrd3HSHHUIPRF03B8Zg50i" +
       "I+FgsBvqrl+XHM9W200UmaP1Fgy3q3XWneb0ZGya6+rc6M64rWDsOH/d3WS0" +
       "GLgCv6RrG73tIqOopwwRuh7VseEw8TlXr7QZfsJ36F5cnfkjP+FCHePWzMob" +
       "O0Lfn1Y2XEqOgoXL8KuUU5R+1s17rRBb+cYwWHc7rEDMVvTITCvGMBWNIKUp" +
       "th1tOv1mqOBmtl2OaNeHaRfldM+si3qSqUojG4TYuolnjUbTGitDuZa1JrzS" +
       "DYU2587o3krBGqaXxi3G6/EKJ+kMtxYDr7mdYf1WjTR7QpuEVxPGSWtNaoKM" +
       "Paa75Cejaoq1kkl1Qs/Hoj80eakeVVWrr0aZbCw8Y9RrkXl3O5j1nAqxGffd" +
       "eWewiBQqImBzEYizIcLkiz7jER7JucJqoU6XK9OwLXrQIwd9ZSoMJ2Gt7uR9" +
       "MkqCrJqELtGtYU12HeyiMJYGLXcz4xmTV/p9gauIVh9PMlwfU+N611/YEW9w" +
       "7srlKxJNrpI2J4x6S1GS2hW/tTAnQ+Aamq1I8oAJur0J66/QOUowq1EsWqIV" +
       "N8MqLbtqhlSqtG8NqfWobtUMN0THE3hMdxhcXo49nINFdCKgFlHpEGN6o6fN" +
       "fh7DxHSGL7yaTlN1R28FwojZbAJ51Jt3LZpbaZ32eiqYXXSWTHsTLpYWvaGX" +
       "r4VtRhpWj2t3t3idIxv6fFrVqNG0I/bFzXoUE9zKW9uduUaFeUMlqRqMTa04" +
       "0AVzqHSb04WwbLcafY+WicqGlzx+0dWIsdQPIiOq+Pmg3ZiOcJUS8cWog7XZ" +
       "3YCuugsl5sRkNpGEuVsN1brQtCfZbretVGGp2p40p9OFLyxY13IpGkUZGUWH" +
       "Olyp1vMN0bXFxdIgsG0ehtt+E221o2W9ommkR7W0+dhu2WENH6DLoRqK03kf" +
       "zMicWx0Jqxki8QvJNVUkKOgm+WzSd1u9mjbr+UJbnFDWUpm3tAQBMctzDC5U" +
       "5X7uGvNqs21PFyMXaSYpwZNz2cP7sSfMMHhU4UC8Lcb51M9EypYGXiWbzDjN" +
       "CCmjwwxioTpowGSVaVELZ7vsdCSmZa88qoErnhQguMPbk7Bl8Bt1wWZupy97" +
       "Uy9bcJVVva3VE0nCdTwbJZ0oX5lD2KumFVMbN7hMHusNKtHoMdGgSGIX+YHU" +
       "sH3S9FEsjtFtvZUwep7seknYNvK0sqlTnS7Hm3yjq6fUFPCaZzRhrYxN1+sS" +
       "I2HjpmNV3cjuMGp0evXpIMHJ6cSRJ+tqrb6uVBsdxDbGc4yihn0bpStoNe5s" +
       "DZyFXY02qrKqGlF1hfV5aQ5i28/4JPA5vTb3TA8nuaaO1p0+PJwmSoqHET7j" +
       "SZywA2/cbXS23pSiaGneH7TGdns7zpKM7RBLpuFKjLWppBwi21wNU3e1ZT7H" +
       "tvgIro0H5NacrHBE1FMyxbCt2pX58cqh1oGD1CsYU0ejkdJm8d4wU/s9hzBI" +
       "tdpBE53JW1s5mndaIjtLl1wVq9lhpy6a3Tjt42FWaegbWI712oarRn7CEOba" +
       "Xpm9OdaUq/mg4q9gdCcmUa2u5zmL06qXRliLbGUpCiNDdOdVrRUZrWPSaS1k" +
       "nBqYBszaudxWwmU9j+kZKs/kpotl8jARlYrqdCd6wOXcwsrq9YXOEw63q2+b" +
       "FSyraMsA7sFZOqWJRm2FqzV21dmFYPhyRW7LiBOsUbiKtBdJC5bHuFOpkTuL" +
       "p23MbHtMa2yuCakbKdoUd+YCzrRHPjPjgobXHAkerVPyYtKuB5yZ8mOtPtmE" +
       "SJfoDUJ1YpmVKGEqiDJbNOHAoZFo2U9XnLmdsLFDWya+S1mZX+zGZtXDd8vh" +
       "UmMzhIxVK24RY5yernkTpQRlm8QqjnUFVG/HiEMrTqfdUnSswmfwDkN2dSuT" +
       "lH5TjMACTAe2U9gBs5RgfZyhVZflu1JdJtqhFYs4wiQbhqrNA3I2dZZVE5uM" +
       "7La8SU2yCH4BF/txm1gSIla3+7NZLYIdFdEG9CLyZJ+nDbZK2S2LMWYwsdpG" +
       "KqlUuy5ZiaXxupqYPUfFOp5nrw3XG9OtDZ4pjanWt1pYZbXtIrXcVBwWzbME" +
       "TEL1cTgequNK7iIikieav6MqYCpdtdFqVvcxFmHIhSx2V8pI7IcJqTkDeDeH" +
       "GRRBALSJXD4gYh64fINrUQMUwKwMD1BngvV6zCzOOkKfxjuWhWhjOKc0fRIH" +
       "mi7YVTCnLNbrWWtc4+1wHjEbynPhJRj5jg+3UbRSITisPnPw5UTtjhMsSSQ9" +
       "x2sCNswFeJKsphS2WI5Hc3mwlPpomBu9hp7oSIuRd0t1EvdyzsJgeYj39DVb" +
       "Se1xYBt8f0NMmlsq66sttIp7CLJSUynfrKN0q/n8sLmjZ7A/b68UFMlNlui0" +
       "Dbq7WeV5Y9iV4FV9LNQxjgTeteI6lXHS7u9QpBmpdVZG+CgRCawimu4MI3oV" +
       "ptZBYgnbrLYtkehumjZLsE7P4dgWpc5n8rxDTadUpa+sREvIuysLp9o1Tzda" +
       "ltufrQezSBynZJeemtEIzYNJ38zbKsKM5mZjh2R43+OCAT6uDVTDmgoDr8WS" +
       "aL2NhPEES5HNdB3yXhtWVQfz5pbuwVPX3RnepNbPqYW8VFaYLox1HE5reZ0Z" +
       "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" +
       "xoOeYUWHHx1Ke/+bN9oZO3PIA3jRhcNn");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("xUmaJy+ciN2f4pS/9sr1q+95Rfh3+y/5RyctH6Ghq1psWacPPpx6fsgLVM0o" +
       "1X5kfwzCK2/fiqDn3/QpuQi6UtxKHf5o3/6/R9CtN9O++IZY3E+3fT2Cnrl/" +
       "W9CqvJ9u9T8i6Ml7tYqgB0B5mvpPIuidd6MGlMVHiVOUfxpBN85Tgv7L+2m6" +
       "P4ugayd0EfTQ/uEUySUIcAckxeMl78ih3ugw4v0+bqWXzkb8sas98Uaudgok" +
       "njvz0bs8ln30gTreH8y+I3/9ldHkU6+3vrI/IydbUp4XXK7S0MP743rHH7nf" +
       "d09uR7weGjz/3cd+8ZEPHMHOY3uBTzDjlGzP3v1AWtf2ovIIWf5P3vOPPvpz" +
       "r/xeue/9fwHB3YaSLy8AAA==");
}
