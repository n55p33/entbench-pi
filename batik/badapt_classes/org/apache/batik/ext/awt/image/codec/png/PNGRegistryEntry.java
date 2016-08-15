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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZDWwcxRUenx3/xY5/yB/5cRLHoc0PtwmFUmSakhiHOD07" +
       "VpxEqkNymdub822yt7vsztnn0BSIhBIqNYI0BFqBJdTQ0DQkFIHoD1Aj1ACC" +
       "IhFCKUUk/VOblqISVaVVaUvfm9m9/bmzA6qEpZvbm31v5r1533zvzfjEe2SK" +
       "Y5M2ZvA4H7WYE+82eD+1HZbu0qnjbIa+pHpfJf3bjgt918VI9SCZlqVOr0od" +
       "tk5jetoZJPM1w+HUUJnTx1gaNfpt5jB7mHLNNAbJDM3pyVm6pmq810wzFNhK" +
       "7QRpoZzbWirPWY87ACfzE2CJIixR1kRfdyZIg2pao7747IB4V+ANSub8uRxO" +
       "mhO76DBV8lzTlYTm8M6CTZZbpj46pJs8zgo8vku/xl2CDYlrSpag/bGmDz68" +
       "O9ssluAyahgmF+45m5hj6sMsnSBNfm+3znLOLeRrpDJBpgaEOelIeJMqMKkC" +
       "k3re+lJgfSMz8rkuU7jDvZGqLRUN4mRReBCL2jTnDtMvbIYRarnru1AGbxcW" +
       "vZVelrh473Ll8H07mh+vJE2DpEkzBtAcFYzgMMkgLCjLpZjtrEmnWXqQtBgQ" +
       "7AFma1TX9riRbnW0IYPyPITfWxbszFvMFnP6awVxBN/svMpNu+heRgDK/TUl" +
       "o9Mh8HWm76v0cB32g4P1GhhmZyjgzlWp2q0ZaU4WRDWKPnZ8GQRAtSbHeNYs" +
       "TlVlUOggrRIiOjWGlAGAnjEEolNMAKDNyZwJB8W1tqi6mw6xJCIyItcvX4FU" +
       "nVgIVOFkRlRMjARRmhOJUiA+7/Vdf/BWY70RIxVgc5qpOto/FZTaIkqbWIbZ" +
       "DPaBVGxYljhCZz5zIEYICM+ICEuZp7568YYVbeMvSpm5ZWQ2pnYxlSfVo6lp" +
       "r83rWnpdJZpRa5mOhsEPeS52Wb/7prNgAcPMLI6IL+Pey/FNp79y+3H2bozU" +
       "95Bq1dTzOcBRi2rmLE1n9k3MYDblLN1D6piR7hLve0gNPCc0g8nejZmMw3gP" +
       "qdJFV7UpfsMSZWAIXKJ6eNaMjOk9W5RnxXPBIoTUwIc0wGc5kX/imxNdyZo5" +
       "plCVGpphKv22if47CjBOCtY2q6QA9bsVx8zbAEHFtIcUCjjIMvcF7kw6whUt" +
       "B+FXVGAjVbEAWv19N21iQ0BB9ihwrT0aR9RZn/J8BfT/spGKCgjNvCgx6LCn" +
       "1pt6mtlJ9XB+bffFk8mXJehwo7grx8l1YEJcmhAXJggaBRPiwoS4MCEOJsSj" +
       "JpCKCjHzdDRFAgLCuRuIAWQalg5s37DzQHslINEaqYJYoGh7KEN1+ezhUX5S" +
       "PdXauGfRuVXPx0hVgrRSleepjglnjT0EVKbudnd7Qwpyl59CFgZSCOY+21RZ" +
       "GhhsolTijlJrDjMb+zmZHhjBS3C4lZWJ00tZ+8n4/SN3bL1tZYzEwlkDp5wC" +
       "hIfq/cj1RU7viLJFuXGb9l/44NSRvabPG6E05GXPEk30oT2KjejyJNVlC+mT" +
       "yWf2dohlrwNe5xT2IVBmW3SOEC11ehSPvtSCwxnTzlEdX3lrXM+ztjni9wjQ" +
       "tojn6QCLqbhP58JnlbtxxTe+nWlhO0uCHHEW8UKkkC8OWA/+8tU/fU4st5dt" +
       "mgJlwgDjnQGGw8FaBZe1+LDdbDMGcu/c3//Ne9/bv01gFiQWl5uwA9suYDYI" +
       "ISzznS/e8tb5c0fPxnycc0jx+RRUSoWik9hP6idxEma7wrcHGFIH1kDUdGwx" +
       "AJ9aRqMpneHG+nfTklVP/uVgs8SBDj0ejFZcegC///K15PaXd/yjTQxToWKG" +
       "9tfMF5O0f5k/8hrbpqNoR+GOM/O/9QJ9EBIIkLaj7WGCh4lYAyKCdo3wf6Vo" +
       "r468uxabJU4Q/OH9FaikkurdZ99v3Pr+sxeFteFSLBjrXmp1Snhhc0UBhp8V" +
       "Jaf11MmC3NXjfTc36+MfwoiDMKIKZOxstIEsCyFkuNJTan713PMzd75WSWLr" +
       "SL1u0vQ6KjYZqQN0MycLPFuwvnSDDO5ILTTNwlVS4nxJBy7wgvKh685ZXCz2" +
       "nh/OeuL6Y2PnBMosOcbcIqvOC7GqKOj9jX389WvfOHbPkRFZEiydmM0ierP/" +
       "tVFP7fvtP0uWXPBYmXIloj+onHhgTtfqd4W+Tyio3VEoTVdAyr7uVcdzf4+1" +
       "V/8sRmoGSbPqFtBbqZ7HbToIRaPjVdVQZIfehwtAWe10FglzXpTMAtNGqcxP" +
       "k/CM0vjcGGGvFgxhH3wUd2MrUfaqIOKhR6h8RrTLsLlShC8GZOGICp3D7JpB" +
       "9QhpNE8yNoditFiqh45/mMAG8imHi+0qa8Obp57+qfOdPzwugdBeRjhScD5y" +
       "rFZ9O3f691Lh8jIKUm7GI8o3tr656xVBwbWYlzd7qxXIupC/A/zfXPRyHjq1" +
       "EID8tHRSfnOi/p+FVMrW0lBBrQVzBlRbszicBLqNYc02jRy64tZrn8Y0yENL" +
       "Jt54gRiNfXfxq7eNLf6NYKVazQF4wrqVOVAEdN4/cf7dM43zT4rMXYXL7y59" +
       "+CRWetAKnZ9EVJqw2VJwysOj39ZykEOHXXhc1b9TPdDRL+CBegMypB/BXwV8" +
       "/osfDCV2yJC2drkHgoXFEwGS2aSsFJlU2dt6fvcDFx6VmIxSUESYHTj89Y/i" +
       "Bw/LVCmPlYtLTnZBHXm0lAjFZjtat2iyWYTGuj+e2vuTR/bul1a1hg9J3UY+" +
       "9+gv/vNK/P5fv1Sm/q5KjXJWTAoVRVKfHo6A9OjGu5qevru1ch3EuofU5g3t" +
       "ljzrSYe5qsbJpwIb0D+v+vzl+oaR4aRimZdRggbg7y4JB5fB9AkYDB/j2PSJ" +
       "sbcDo+nMGOJZIZl0lxG/gOMqAYX4OBiYMibHEb9nc7fYQPqGY7NpMKxbvHfy" +
       "qKGZ8eKVBbwsNd4m80MpsVcA3c8v70w79LsfdQyt/SRnDOxru8QpAn8vAAQs" +
       "mxjPUVNe2PfnOZtXZ3d+guPCgggeo0N+r/fESzddoR6KiVsRmfhKblPCSp1h" +
       "CNXbDHKKEQbNYokGET0JBWyWi/hOUujdPsm7fdjshcynYqAlLiYRv7O0dsKO" +
       "NVagzHIhgD819+SA7Rew2SCR0lmuTisEXCrmJvFXTSKXCsGy3S/ECFLF/Inu" +
       "fQRNHN13eCy98eFVHmMCHdVx07pSZ8NMD9V0+DxaNKMVh2+Dz2rXjNXRIsN3" +
       "NOJB8eAxkWpkuSuFAZXhvQj7rcew8nyA28zFIbxbUHJxIO+ExIXklk0JIbct" +
       "sP0jVFCTMk2dUaN86IRLRyYBw0PY3MNJQ5YaaZ2FbVt5iUsNqHKg1EfygLJV" +
       "h7zog+TQJCD5GMW8C0hOmqPXJVjnzy65vZU3jurJsabaWWNb3pRJ3LsVbABu" +
       "yeR1PViJBp6rLZtlJMobZF1qia/vc/LZj3urA5QMrfDjuNQ+yUnHx9HGbYvf" +
       "Qd0fcNI2uS5oie+g1hOczJ5IC+yDNij9FKSBctIgCW1Q8scQhagkzC++g3LP" +
       "cFLvy0H+kg9BkXEYHUTw8TnLQ1nnJZbJsbR4Lx3S1L483rmH0FCoCHNHEX8z" +
       "LoW/AN0sDuUZ8Q8ELyfk5b8QkuqpsQ19t178/MPygkTV6Z49OMpUKBTkXU0x" +
       "ryyacDRvrOr1Sz+c9ljdEo/AWqTBPvvMDWzQNbCXLQT9nMjtgdNRvER46+j1" +
       "z/78QPUZqIu2kQoKhLOt9PRWsPLArNsSpQUR5GBxrdG59Nujq1dk/vq2OB+T" +
       "klNxVD6pnj22/fVDs4+2xcjUHkAksEFBHCtvHDU2MXXYHiSNmtNdABNhFKg0" +
       "QtXWNNyfFP+1INbFXc7GYi9er3HSXlppll5K1uvmCLPXmnkjLTIt1AB+T+g/" +
       "G15qzltWRMHvCZTyWUm2svCuTCZ6LcsrxOsesgRNaRMnzbPiEZs3/gd0gygK" +
       "XBwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "NX3yM9jRyfaPmEKPpmH0tzwjN7wLTR22C/UzMZ4sm38WXB8+EePDVzffzxW9" +
       "Z8iuVUNW3G9X6/phTC/vFDrhMRVEWSqmsXGyRwfqnrvncPhw7l99dDIXmPtt" +
       "pjyshqFnKEHV90+8yTbYT5fFZ1PoMVsJdM+43DP6FsfSsRHoRlxuXB4PHC81" +
       "4nN7f+6tdm4unSCl0J2rB9vlKd1T93xnc/g2RPvia7cfec9r8z85HBCcfr/x" +
       "KAM9Ymaed/FQ5cLzzSg2TKfS+tHDEUtU3V5Poe/6Vs/fU+g6KCsF/vGB+0sp" +
       "dPdb4S43Jsv7Rd5fSaFn35wXcFX3i1xfTqGnHsQF5APlRepfTaF33o8aUILy" +
       "IuWvAStcpQT9V/eLdL+RQrfO6VLo5uHhIslvgtYBSfn4z6NTb3rpLYYpiZxj" +
       "VrEc7bANeckbimuXw/3Mz558Kz+7gBAvXNpJrz71Ot31zg4fe72sfek1mvvY" +
       "N1o/czh91zxlvy9beYSBHj58CHC2c/6+B7Z22tbN0Qe++fgvP/riKeY8fhD4" +
       "HDAuyPbc/Y+6+36UVofT+199zz/53p977c+qTdn/C3m8Jg+DJwAA");
}
