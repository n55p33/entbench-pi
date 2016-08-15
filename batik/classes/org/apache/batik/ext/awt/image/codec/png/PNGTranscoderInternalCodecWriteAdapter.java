package org.apache.batik.ext.awt.image.codec.png;
public class PNGTranscoderInternalCodecWriteAdapter implements org.apache.batik.transcoder.image.PNGTranscoder.WriteAdapter {
    public void writeImage(org.apache.batik.transcoder.image.PNGTranscoder transcoder,
                           java.awt.image.BufferedImage img,
                           org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException {
        org.apache.batik.transcoder.TranscodingHints hints =
          transcoder.
          getTranscodingHints(
            );
        int n =
          -1;
        if (hints.
              containsKey(
                org.apache.batik.transcoder.image.PNGTranscoder.
                  KEY_INDEXED)) {
            n =
              ((java.lang.Integer)
                 hints.
                 get(
                   org.apache.batik.transcoder.image.PNGTranscoder.
                     KEY_INDEXED)).
                intValue(
                  );
            if (n ==
                  1 ||
                  n ==
                  2 ||
                  n ==
                  4 ||
                  n ==
                  8)
                img =
                  org.apache.batik.ext.awt.image.rendered.IndexImage.
                    getIndexedImage(
                      img,
                      1 <<
                        n);
        }
        org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam params =
          org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.
          getDefaultEncodeParam(
            img);
        if (params instanceof org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB) {
            ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB)
               params).
              setBackgroundRGB(
                new int[] { 255,
                255,
                255 });
        }
        if (hints.
              containsKey(
                org.apache.batik.transcoder.image.PNGTranscoder.
                  KEY_GAMMA)) {
            float gamma =
              ((java.lang.Float)
                 hints.
                 get(
                   org.apache.batik.transcoder.image.PNGTranscoder.
                     KEY_GAMMA)).
              floatValue(
                );
            if (gamma >
                  0) {
                params.
                  setGamma(
                    gamma);
            }
            params.
              setChromaticity(
                org.apache.batik.transcoder.image.PNGTranscoder.
                  DEFAULT_CHROMA);
        }
        else {
            params.
              setSRGBIntent(
                org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.
                  INTENT_PERCEPTUAL);
        }
        float PixSzMM =
          transcoder.
          getUserAgent(
            ).
          getPixelUnitToMillimeter(
            );
        int numPix =
          (int)
            (1000 /
               PixSzMM +
               0.5);
        params.
          setPhysicalDimension(
            numPix,
            numPix,
            1);
        try {
            java.io.OutputStream ostream =
              output.
              getOutputStream(
                );
            org.apache.batik.ext.awt.image.codec.png.PNGImageEncoder pngEncoder =
              new org.apache.batik.ext.awt.image.codec.png.PNGImageEncoder(
              ostream,
              params);
            pngEncoder.
              encode(
                img);
            ostream.
              flush(
                );
        }
        catch (java.io.IOException ex) {
            throw new org.apache.batik.transcoder.TranscoderException(
              ex);
        }
    }
    public PNGTranscoderInternalCodecWriteAdapter() {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1Yb2wcRxWfu/P/2PGfJE5IEydxLhZOndtGNNDKptR27eTS" +
       "8x/FbgCH5jLenfNtvLe72Z21zy6GNBU48CGKgtum0PqTqwJqmwpRAYJWRpVo" +
       "qwJSSwQU1BSJD4Q/EY2QyocA5c3M7u3enu0kfOKkm9ubee/Ne2/ee783+/w1" +
       "VG5bqIXoNEFnTGIn+nQ6jC2bKL0atu1RmEvLT8bwP45fHbw3iirG0Postgdk" +
       "bJN+lWiKPYa2q7pNsS4Te5AQhXEMW8Qm1hSmqqGPoU2qncyZmiqrdMBQCCM4" +
       "iq0UasSUWuq4Q0nSFUDR9hRoInFNpO7wcmcK1cqGOeOTbwmQ9wZWGGXO38um" +
       "qCF1Ek9hyaGqJqVUm3bmLXSnaWgzE5pBEyRPEye1A64LDqcOlLig9aX6D2+c" +
       "zzZwF2zAum5Qbp59hNiGNkWUFKr3Z/s0krNPoS+hWAqtCxBTFE95m0qwqQSb" +
       "etb6VKB9HdGdXK/BzaGepApTZgpRtKtYiIktnHPFDHOdQUIVdW3nzGDtzoK1" +
       "wsoSEx+/U1p48njD92KofgzVq/oIU0cGJShsMgYOJblxYtndikKUMdSow2GP" +
       "EEvFmjrrnnSTrU7omDpw/J5b2KRjEovv6fsKzhFssxyZGlbBvAwPKPdfeUbD" +
       "E2Brs2+rsLCfzYOBNSooZmUwxJ3LUjap6gpFO8IcBRvjDwIBsFbmCM0aha3K" +
       "dAwTqEmEiIb1CWkEQk+fANJyAwLQomjrqkKZr00sT+IJkmYRGaIbFktAVc0d" +
       "wVgo2hQm45LglLaGTilwPtcGu849oh/SoygCOitE1pj+64CpJcR0hGSIRSAP" +
       "BGPt3tQTuPmVs1GEgHhTiFjQ/OCL1+/vaFl+Q9DcsQLN0PhJItO0vDS+/u1t" +
       "ve33xpgaVaZhq+zwiyznWTbsrnTmTagwzQWJbDHhLS4f+dnnT3+X/DWKapKo" +
       "QjY0Jwdx1CgbOVPViHWQ6MTClChJVE10pZevJ1ElPKdUnYjZoUzGJjSJyjQ+" +
       "VWHw/+CiDIhgLqqBZ1XPGN6ziWmWP+dNhFAlfFErfNuQ+OxhA0VnpKyRIxKW" +
       "sa7qhjRsGcx+W4KKMw6+zUrjEPWTkm04FoSgZFgTEoY4yBJ3gWUmnqaSmoPj" +
       "l2SoRrJkQmgNDx4ctbBusxkryWJYx1ovW/6spVLSrWAT5hIsFs3/Cy3yzFcb" +
       "piMROMZt4SKiQf4dMjQQkpYXnJ6+6y+m3xIBypLK9TJFQ6BYQiiW4IrxkguK" +
       "JbhiCa5YAhRL3JpiKBLh+mxkCoqQgoCYhNICtb22feThwyfOtsYgls3pMjhN" +
       "RtpahHG9fv3xQCMtX2qqm911Zf9rUVSWQk1Ypg7WGGR1WxNQDOVJt17UjgP6" +
       "+SC0MwBCDD0tQyYK1MDVwMiVUmVMEYvNU7QxIMGDSFYMpNUBakX90fLF6UeP" +
       "fvmuKIoW4w7bshxKJmMfZmhRQIV4uN6sJLd+/uqHl56YM/zKUwRkHv6WcDIb" +
       "WsMRE3ZPWt67E7+cfmUuzt1eDchAMWQyFN2W8B5Fha3TAwlmSxUYnDGsHNbY" +
       "kufjGpq1jGl/hodyIxs2iahmIRRSkOPLp0fMZ377yz9/gnvSg6L6QA8xQmhn" +
       "oPwxYU280DX6ETlqEQJ0710c/sbj1+aP8XAEit0rbRhnYy+UPTgd8OBX3jj1" +
       "7vtXli5H/RCmgP/OOLRReW7Lxo/gE4Hvf9iXlSw2IUpXU69bP3cWCqjJdm7z" +
       "dYNSqkEhYcERf0iHMFQzKh7XCMuff9Xv2f/y3841iOPWYMaLlo6bC/DnP9aD" +
       "Tr91/J8tXExEZlDu+88nE/iwwZfcbVl4humRf/Sd7U+9jp8BpIHqbquzhBds" +
       "xP2B+AEe4L64i493h9Y+xYY9djDGi9Mo0HKl5fOXP6g7+sGr17m2xT1b8NwH" +
       "sNkpokicAmy2G7mDByD8l602m2zcnAcdNocL1SFsZ0HY3cuDX2jQlm/AtmOw" +
       "rQxF3B6yoPTli0LJpS6v/N1PX2s+8XYMRftRjWZgpR/zhEPVEOnEzkIlzpuf" +
       "uV/oMV0FQwP3ByrxUMkEO4UdK59vX86k/ERmf7j5+13PLV7hYWkKGXcEBbbx" +
       "sZ0NHSJs2eO+fMFZ/FPhoaz3G3BWQGaEP2+hqKsEPWgBIlwAKYKNeBAqmPe3" +
       "r9ZV8Y5w6czCojL07H7R+zQVdyp90Ii/8Ot//zxx8Q9vrgBs1dQw92lkimhF" +
       "isOWRXAzwBtOv+S9t/7CH38Un+i5HaRhcy03wRL2fwcYsXd15Air8vqZv2wd" +
       "vS974jZAY0fInWGR3xl4/s2DbfKFKO+uBV6UdOXFTJ1Bx8KmFoFrhM7MZDN1" +
       "POV2F6JoHQuaOHz3uVHUEU45Ud15SLKhr8DKg7XGY1mBNVRRYvxEY14oSrcZ" +
       "ih7fNp5ZfsPT42QYlClJ9s8j6lhLuC9zyKGmQ7mJnwtpGylOnDW19QX25WVi" +
       "sjPnMk+wYYSimmmWRUJBC7WvcVm21Byg4JR73ZDmmt6ffPrqCyKdwneTEDE5" +
       "u/D1jxLnFkRqiQvc7pI7VJBHXOK4pg1sSLAE37XWLpyj/0+X5n787bn5qIsO" +
       "D1JUNmWo4hJ4DxtGRZXq+h/LJ5voMfMUtd1aC8vq7ZaSO7m4R8ovLtZXbV58" +
       "6De8PhTuerWQ6RlH0wKJEkyaCtMiGZVbVyswyuQ/pyj6+K323xTFYOTWmYKb" +
       "Qq93K9wUlfPfIO809HBr8wKXWkgBl2sWLpOrcYF+MAap56B/XokaKGEMUp6m" +
       "qCFMCfvz3yDdYxD7Ph30XeIhSPJVkA4k7HHe9LKtgec4e3+QEJflfKQUIe8R" +
       "3edNQq3AEmwXmQv4ux6v7DribQ9cXBYPDz5y/ZPPinZV1vDsLH83kEKVoiku" +
       "lO5dq0rzZFUcar+x/qXqPV6iFLXLQd14wEOx4a3l1lD/ZscLbdy7S12v/uJs" +
       "xTuQ4sdQBFO04VjgTYvwFDSBDmDmsZSPmoF3hbyx7Gz/5sx9HZm//543Hy7K" +
       "bludPi1ffu7hX13YsgQN6LokhJmukPwYqlHtB2b0I0SessZQnWr35UFFkKJi" +
       "LYmqHF095ZCkkkLrWdJh9haI+8V1Z11hlt1jKGotLVWltz9o1KaJ1WM4usLB" +
       "DGDWnyl6CeWhn2OaIQZ/pnCUG0ttT8sPfK3+J+ebYv1QOIrMCYqvtJ3xArIG" +
       "30v5UOtWVnGdiKVTA6bpXS+q500R8U8JGjZPUWSvOxtAIfb3aS7uW/yRDYv/" +
       "BQPlLfByFgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "24yXsNcdFVWSEsywN5NYSrFTKXI1a0GPeprgJSWSw/EV4cyDwHWFYTCqeQ7m" +
       "JzBVUUr0YI57q1XVCOmNSYRhup6SttJaNROO5jRDHykYXmoFYakQhEzb2Ehs" +
       "qy943tQZJSmFMqO57FdnPsHWu2prsJpjSbcVEorT7hVlU0ZprZkMl7iDW10F" +
       "aYsLnF8UjGafWjcThveAQssFPQ2KxXBY6FILRxqQclchFlFzrBa1ZDzzSibv" +
       "lCvMzGZkcmjZCRepZFwvNzwTFrz1rM1aEY7480K13PYpdVA0SaE7EJpci+Qi" +
       "NOKHMeeMQ4TEZx1zaBFzHmbbDFKAVzJhF/gGpoY80y9yJtWN2OIKEwpwjEQr" +
       "HUVTfyaP5am5LGwSa71xxaESBu7QGcqzZMOLlIJ1TEYoGwXNdYdoYQJjIi37" +
       "tMfPpSKVaCnSninsmBtbHZGv9oZtu21SYxwp+lN9RSG4zdHayJXmU2+0Iam5" +
       "QK3nfGEsdhK40LawrjljlsvWFJlwZL+6sURH5Apa3ySatkHggdGP+QKbms3i" +
       "2PXp9aCb0mIo15bmfBCSaloQyzTdS6qFzSiY45w4XDjFMuEJsykxG+KeVF63" +
       "KHQmjhx3KQuOx83tkuANAmrBO7M+lpbVSGnFYboI1iIlpYi3EuFq6I8ZIRCb" +
       "w4rZDYkQhdtrdL0hVMW3egO2N43KAm3xRlnrzXl+4UsTl6oWquuCg6bd1tpn" +
       "6MaQIvhqS+ItSyx3g3Qxi2lKMa22XJGa5oBBKd+iW4xZcNJF21vyM68tmf1u" +
       "O1JKJUMfmsnaYKNQmtkh6vfmZn8Q+bLZIRvGCk35di+alJZLp4EgU6MRjMaC" +
       "yC8QyZ/VwH4fIGLa5zF2TEVIbTSfcdWC0C72klYbw4oRv5ZopIeNk54FQGDc" +
       "w6VVf1Tj026PxARC6vn9UUteTBpFgyGqI50zVk5Mdz2xnNSU0ExpyukZU8cc" +
       "8N1xOe5XQ4rRgA8tO3alKvXgDT1KBovOqiqqWFcRw94AR6ecGFVreK2gGs4o" +
       "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" +
       "sQedPcqzXHPTdZLpysnsyoVAj2IQJp/Isdx3tDxvyFbjMvi+42B5nrh+/va6" +
       "rnQmd6WtA51KEJ49yIodLCj8Ohf0kO/ePF+yuzFogTBFD3Stmz0dEj3xasJ3" +
       "Mtk48uMo1zY6pe2Zk+73qtruBOKpqvvZAucy35cVXgRdSDJf3Ck4OLZtxhF0" +
       "08qztN1+8n9cJuJEwjGCHnttNyVZqvfua65+t9eV6mdfuHjLW18Y/XV+WXB0" +
       "pXgrA91ixLZ9PDN3rH7eD3TDyi29dZun8/OfZyPoba/1mieCzoIyN+uZLfcH" +
       "I+jya+GOoHP573He5yLo/lfnBVzW0ToccP16BN19Iy6gHyiPUz8fQW++HjWg" +
       "BOVxyo9G0KXTlGD8/Pc43W8DD9nRRdD5beU4ySeAdECSVV/wr5Or3CZe0zPH" +
       "kOoAe3OXuvPHudQRy/E7kmwK8r8UHCJRvP1TwVX1cy9Q/fe+XP3U9o5GteXN" +
       "JpNyCwPdvL0uOkKzh24o7VDW+c7jr9z++VsfPUTe27cK7zDmmG4PXP8SBHf8" +
       "KL+22PzhW7/wzt954Vt56vR/AVzkq3zrIQAA");
}
