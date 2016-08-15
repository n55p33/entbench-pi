package org.apache.batik.ext.awt.image.codec.png;
public class PNGRegistryEntry extends org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry {
    static final byte[] signature = { (byte) 137, 80, 78, 71, 13, 10, 26,
    10 };
    public PNGRegistryEntry() { super("PNG", "png", "image/png", 0, signature);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter handleStream(java.io.InputStream inIS,
                                                                         org.apache.batik.util.ParsedURL origURL,
                                                                         boolean needRawData) {
        final org.apache.batik.ext.awt.image.renderable.DeferRable dr =
          new org.apache.batik.ext.awt.image.renderable.DeferRable(
          );
        final java.io.InputStream is =
          inIS;
        final boolean raw =
          needRawData;
        final java.lang.String errCode;
        final java.lang.Object[] errParam;
        if (origURL !=
              null) {
            errCode =
              ERR_URL_FORMAT_UNREADABLE;
            errParam =
              (new java.lang.Object[] { "PNG",
               origURL });
        }
        else {
            errCode =
              ERR_STREAM_FORMAT_UNREADABLE;
            errParam =
              (new java.lang.Object[] { "PNG" });
        }
        java.lang.Thread t =
          new java.lang.Thread(
          ) {
            public void run() {
                org.apache.batik.ext.awt.image.renderable.Filter filt;
                try {
                    org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam param =
                      new org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam(
                      );
                    param.
                      setExpandPalette(
                        true);
                    if (raw)
                        param.
                          setPerformGammaCorrection(
                            false);
                    else {
                        param.
                          setPerformGammaCorrection(
                            true);
                        param.
                          setDisplayExponent(
                            2.2F);
                    }
                    org.apache.batik.ext.awt.image.rendered.CachableRed cr =
                      new org.apache.batik.ext.awt.image.codec.png.PNGRed(
                      is,
                      param);
                    dr.
                      setBounds(
                        new java.awt.geom.Rectangle2D.Double(
                          0,
                          0,
                          cr.
                            getWidth(
                              ),
                          cr.
                            getHeight(
                              )));
                    cr =
                      new org.apache.batik.ext.awt.image.rendered.Any2sRGBRed(
                        cr);
                    cr =
                      new org.apache.batik.ext.awt.image.rendered.FormatRed(
                        cr,
                        org.apache.batik.ext.awt.image.GraphicsUtil.
                          sRGB_Unpre);
                    java.awt.image.WritableRaster wr =
                      (java.awt.image.WritableRaster)
                        cr.
                        getData(
                          );
                    java.awt.image.ColorModel cm =
                      cr.
                      getColorModel(
                        );
                    java.awt.image.BufferedImage image;
                    image =
                      new java.awt.image.BufferedImage(
                        cm,
                        wr,
                        cm.
                          isAlphaPremultiplied(
                            ),
                        null);
                    cr =
                      org.apache.batik.ext.awt.image.GraphicsUtil.
                        wrap(
                          image);
                    filt =
                      new org.apache.batik.ext.awt.image.renderable.RedRable(
                        cr);
                }
                catch (java.io.IOException ioe) {
                    filt =
                      org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                        getBrokenLinkImage(
                          PNGRegistryEntry.this,
                          errCode,
                          errParam);
                }
                catch (java.lang.ThreadDeath td) {
                    filt =
                      org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                        getBrokenLinkImage(
                          PNGRegistryEntry.this,
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
                          PNGRegistryEntry.this,
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
      ("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" +
       "XBwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "i4Sd0Xu1Xs+ztrsxECERnKhpY33b7mM9tA7bFjakPWco5r5VuHJLsjFc1eAU" +
       "rrVrKj802mMwZ7qWowgbw/LlCVoLsGUrlwSQ12pqKo3XorC1CJzHZWLVMjXY" +
       "bfT0gSkkmTMFqBQHxjzpD1I2tBgNZWR/SdTorsbMWoE27QYdyUvaXURT4wLZ" +
       "D9phMajJyGK22Y0pjDTs3MRnaqQSQrisNzv0JsjFVPP3GW31RHK8rodrMZDE" +
       "1NcotNtLkNFKwpY9AFPNDbti9/rOmRZCfSK09mm885IgsLOo3djVFNXtIl7e" +
       "6zP8Llil1mZRm/bhcX0zZdDewIjkfpNp22ayyNC6yjB70Zr6YopuOjG5bfTb" +
       "FFxo2rbR7IzaO5YbIWHQGBlBc0vMVWGciANkjDLhbo50UXkGJnidWvRkEMJt" +
       "dylgTYJYe5JT7BFd2ctMfTXEWGO6DQoWk0S7y+gbdLgn+Wa+8AcyM+jb3c3U" +
       "tu3WOG/5/jDT0x1IwjyqAdOqQ+ih3R+5dDiSvUQcBV6dkFOdCsQwITOlCUf4" +
       "xjGaNUdraz2CXG4Hq5qQkQUO506TpalloKJuCx9QXdjq8qQUZQNPFUYCWH3j" +
       "BE7s2ERRkbwnqI5bkHUDTiO2PU36e3QQrRqaqCINbACyopQfcPlkxk5i0wk9" +
       "n87jEA7SoLXO5VarMZ+ks5mimmhP2do7EW4V2rYIY7QdajgxjbRZQ9jrjOsK" +
       "0WiHsgM2QtqotQhWxWwSr/uzFKX0bb9ngryc0EfUlJmuGky/Q1muPcbxmhHg" +
       "1J7tqIk5EgWaptqsNV1yijhTwjrF6YoxKZq57LQcmUHmTpHHfEfKkoybtju5" +
       "N+t07c5OGnX8Ub2+sqWWt1h0O8Suxc7lzmoimvWWZY4GBbvK9w5vectoCyJ2" +
       "6clO7PRbgdeyAlaJzVWx6aFB05B2Cywd4z7D9eDGjgar26bSaDpRUcPhdnOX" +
       "blpSS2nP89m4Tq8IerklzFYznKIuMaakKR1zS9neT1BhIqwLSmCaPsL0JUMA" +
       "WfhqyAlcEM4oWVqydnewIexhv43VYXmaLNuCM9frPtdtL1JB39vJpCcxe3c3" +
       "JbfLkYG0+xhb7/t1RBXmuNeMh92dMHYXSx5G1eF+MyQTDEa7q25nXHTwLb62" +
       "B7nIEsu2rfp5Q6+PaKAGbcpNNDaphUQwHXnZrq2GI1k3bAerCTlWjB1THPFg" +
       "cpAshmxb9abX8+JU7THkHA+zHY6HktBus5mEGqwktCxVm3Zgvq8yObdIMYNm" +
       "xQVJJPDA0VDBVLTeaCoskWbd7A26Ertb+HjS0I2lyjWxIunh02k2V8lmaAjK" +
       "ZKgInQRV6S3A74ZMMly86c7MHcurUwXJnFEM82svbdn73KMJxZxrfUxOmnmy" +
       "d6cZyCVwUpz77dgxYsToFOlkUqzoYcNp5qJos6it1Wu2PsH7a4pHyBAereMU" +
       "aeTIlFtjC2/bprK45vB9zJ2OOyq+Y9NhazXvz+sTn7RTmo34PSl7vNRTJy61" +
       "XtV6Aj3wZtNWzs6HLTeSm9Nda+/hO86N9gyi0TTbqOUKP0Snvj5n6UwkCG45" +
       "snCx3kBbXRJj3FUHZxQab03Fepeg5J3XtWibINss351u6yKn+1bP3M5MeMsU" +
       "RX0tIkstsFpzpwncZs138FTT2u1N19DsIt/EVtIfqR5tb5hgTaMuJxOpF5h+" +
       "l4rDHrHosuEcGWdUY9+vu9Ou3zYnio2DXGCyHXgYEoyHA44v0ki3cCfS2HmK" +
       "WUIX4zgSrGvreJ832/p0gbTbhIXnij/z+L0QwjxPgKZZvW36gZ+I2swndqTr" +
       "DBCh7i0b7aab+3pAEW4nQvkiIyOHC5GuR+sbLMqoWqS4286CzloBhzHBNrdC" +
       "bESkvJDAQzXx6viw4RJoslvocyYKB4udhYgwZndUg2juOSeqjZpdrUA2e282" +
       "xucjcaijnsWNm3iRc0g0w2xZqolDLLfgvLZuqbY+7ezAovmDHyyX0x//5pb5" +
       "T1Q7GmffBYDVfVmx+yZW8vmFHaCz7drqdxO6cpZ88YDp/NQBKrcWn3nQcX+1" +
       "rfi5j73yqtn/cfToZPtHTaFH0zD6+561tbwLog7bheaZGk+W4p8F14dO1PjQ" +
       "1c33c0Pv6bJrVZfl99vVun7o08s7hW54zAVRlqppbJ3s0YG65+45HD6c+1cf" +
       "nWhD8X6bKQ8vwtCz9KBq+0feYBvsX5fFp1PosaUemJ51uWXkTY6lYyswrbjc" +
       "uDxmXC+14vPx/syb7dxcOkFKoTtXD7bLU7qn7vnO5vBtiPH5V28/8q5Xtf94" +
       "OCA4/X7jURF6xM487+KhyoXnm1Fs2W5l9aOHI5aour2WQt/+jZ6/p9B1UFYG" +
       "/MyB+wspdPcb4S43Jsv7Rd6fT6Fn35gXcFX3i1xfTKGnHsQF9APlRepfTKG3" +
       "348aUILyIuUvgVG4Sgnar+4X6X41hW6d06XQzcPDRZJfA9IBSfn476JTb3rx" +
       "TbopidxjSXdc47ANeckb8muXw/3Mz558Mz+7gBAvXNpJrz71Ot31zg4fe71k" +
       "fOFVXv7o15o/fjh9Nzy9KEopj4jQw4cPAc52zt/zQGmnsm6y7//64z/36PtO" +
       "Mefxg8LngHFBt+fuf9RN+1FaHU4Xv/iuf/tdP/HqH1Wbsv8XqA+FQYMnAAA=");
}
