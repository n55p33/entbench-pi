package org.apache.batik.ext.awt.image.codec.tiff;
public class TIFFDecodeParam implements org.apache.batik.ext.awt.image.codec.util.ImageDecodeParam {
    private boolean decodePaletteAsShorts = false;
    private java.lang.Long ifdOffset = null;
    private boolean convertJPEGYCbCrToRGB = true;
    public TIFFDecodeParam() { super(); }
    public void setDecodePaletteAsShorts(boolean decodePaletteAsShorts) {
        this.
          decodePaletteAsShorts =
          decodePaletteAsShorts;
    }
    public boolean getDecodePaletteAsShorts() { return decodePaletteAsShorts;
    }
    public byte decode16BitsTo8Bits(int s) { return (byte) (s >> 8 & 65535);
    }
    public byte decodeSigned16BitsTo8Bits(short s) { return (byte) (s + java.lang.Short.
                                                                          MIN_VALUE >>
                                                                      8);
    }
    public void setIFDOffset(long offset) { ifdOffset = new java.lang.Long(
                                                          offset);
    }
    public java.lang.Long getIFDOffset() { return ifdOffset;
    }
    public void setJPEGDecompressYCbCrToRGB(boolean convertJPEGYCbCrToRGB) {
        this.
          convertJPEGYCbCrToRGB =
          convertJPEGYCbCrToRGB;
    }
    public boolean getJPEGDecompressYCbCrToRGB() { return convertJPEGYCbCrToRGB;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/PJTJy5zL9NMGjM4fgmmfldW5Q29HdhPv3nPL049dmTEbAlaC2czD97Uf66T" +
       "I7t++/cclfM8lqdd8eAPBp95fHrHivc5vp1QELslnVuuICnbuIufTv7N31z2" +
       "Uz8pHyT1otVAbxDkFIbpIDSNRqarhibbte5uAM1upy2bMGd6k5ljW28qs8sk" +
       "fCM0ftd6slcNmnAxPCErsEPe7OUj/KObo3yBj/NxuCOTLMo1XYJDFvVki+oi" +
       "RKHzjFp1WKaM0XajP6HqzHBXWKxi/amIAdVQSkLyG7YaycV9W8S9LX2/Nz1i" +
       "Wh4EE27Sk8F9G97a+jpPrRVYbwcyWnBUU6jLjrxebwrxGfz54PkPPsg8TpgN" +
       "WUOH1RXOybaF6NFFXdMjQHBHw5Whx6+eNgXw+qEHmO499Ohngf2HzHxpni3m" +
       "5bT3ThzzfGGKg0M/cje32C4co+tPZ3b86Mkde0yuGtydciccBE//8t+vB479" +
       "5rU8TVh5RFVlKijZ5ODLtkwT3fYxhVr1SN2PDzSUdEG17iYVKUXalqLdUbfP" +
       "lhupiMNg9rnF9mNLPDQOI775YAez1uK4FIe1plO2FcxsHe5IaIanx3LangKR" +
       "IJqRgEMo1+ULYTNSKcWsQwLHmsrIeJ41MdADIVWJe3iPjpH3RfD0Wrv3FuBd" +
       "Lsp7IWwIV8hR0GmytX2dqzd2RDr0AXX96pW4uN7DdbII12l79wXZ3flfGfEc" +
       "fJythV0sfBnNfemmmn7uud044ej6MRhmFTre8kA4uevQiei6Jxb5rVI/CLZj" +
       "qnaHTIep7OCmAim5SlcPP9DbdeDd8Qd/90JLfOVYzgI413SDbh//nw1BOr9w" +
       "yvGycn7Xe9MHViS2jKGtn+3RkpfkUz3PvLb6dvGgn99emAUq59bDjdTmDvEq" +
       "nbKUrriDep67tV4Nz/2Wa9zvdWvb+TxelW1YC6F6WjsrX3GP5lR3F+n99uDw" +
       "MCNTIZZX5a1jCHCflXvxtZGR0mFVitpxsvNG0V2858KJdo3PP5QVuhHXFsCz" +
       "xRJ6y9j1VQi1iDoOF1k7isMBUFW8gKq4xm21PHYL1MLR58GTtGRLjl0thVDz" +
       "uxH/v89hf48vlEjWdarH9cJpzsp3iyj0KRyOM9JoNlCL7l4pMWNAXYqvG21b" +
       "GhllNP++tgVO3CoLtMIzbKlxeOwWKIT6+Swwzsh6X34bvFDEBudweJ6RaaYN" +
       "+qW4QqMuSyDA92ydnr0FOq3O6HS3pZjdY9dpIdTPp9NSGZqYIiq9UESlF3F4" +
       "hZEavEPtWmX2STj3iK3F87fKM2fCs89Sxb6xa7EQahFx3y2ydgWHt0EVcY8q" +
       "ErYq3rlVDoXN1xFLniNjV0Uh1BtV2/eK6OMDHP7AyAxQA/afWEaSmk4Nw92J" +
       "Ojzlj7equAbgOW7JeHzs6imEWkT6T4us/QOHv4Jm4sU146ivH/8vNJNmpM5z" +
       "l46XQFNzftozf44Snz1RVzHlxH1v8TY4+5NRDTS0sZQsO68pHN9lIEhM4nLW" +
       "mJcW/HTn8zHSetNX/pCU8IWCwAmI45cy0nIz+FAj+NuJW85IU3FcwOJvJ1YV" +
       "tD+FsKAXgNEJXcvIxHzQAAmjE7KekXovJOzP3064RkaqbDhGyswPJ8hkoA4g" +
       "+DlFyxyy6u3jqXkPlfY5Tj/E0TNMupFXZVGcl9KoAv6jceZ8kTJ/Ng6LZ06s" +
       "7X3w2t1PmJfioixs345UqkOk3Lyfz55R5haklqFVtqb1+vjnKm/LnOYmmAzb" +
       "wTrDEVHtkJU09OXpnhtjoyV7cfzOyeUv/Wxv2UU/8W0iPgFasU25N3ZpLQWH" +
       "w02h3MsPOM/xq+y21u+MrlgY+8uv+Z0oMS9LZhaGD4uXTj3w5sGpJ5v8pLob" +
       "3EyJ0jS/Slw1qqyn4rA+SGolozMNLAIVSZBdNyvjMewE/DmZ68VSZ212Fn9S" +
       "YaQ592Ip94eoKlkdofpKNaVEkUwtnCftGdMynmNeStM8CPaMZUocN2/j/QRa" +
       "A/wxHOrRtMy9W+VpjSefcP7+Ah2X30qG8WvBfwEk8oZMUCIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "kPqUGQtJtqOmlsTPYl4j/L6yZGZgldTHZkvjp2tpsTIzacOM5WnXmy2atj3c" +
       "EaP+Stp1UgQXSKu+1Y2116g3+Rafp/lki2VCJaFC2xGIVd3iWojTrgWs1ojW" +
       "CyypLZuh10jBHwFp1+WwR802y7Tu7uJehI3QrR6xFtzzuqjRZQVkU0etaBXm" +
       "XKe+6ojLgK/1EE2Wo2StM6KDm6KwmQfiuk8EfoXbOHFvSswTSqhUCdiujmsD" +
       "Wq7XRs0hWcnxQIdV4LNWCSdV2944zzOx3WF3jXkrrvARDMPcPFH8HJEVoSoq" +
       "VQlT3F2/Q4d034tMF0XTlu/grJq0jebWm9fTHFUSrt3N2KxNtRQTxallT0pp" +
       "OW5hzXBZC520AhL2bSV3e0RQGYwGupSbG6bdFDcW003RShUdNvDVUjXlZk+K" +
       "sZ1negjDERa9y9Rec4ohsdVuVCIW1jGcWy5tJomHPaoj5A1Z3DJppqIGFhI7" +
       "Y0WEfBfN3TTlKtUaGkwUbVpdjCctUdjBQmW7bNQnpkQQtrwKRa1tZ1yC12ke" +
       "80V2W9EMNmej2mLYC9XlJNFqWUO31+mG7ewa2JTdrvyGnqizlhYu7Qlio13E" +
       "lZtk2qwF9X6bpLDdzOIW3UW31UTyLVLZOiqmd+pWZ0R2iSVViavAcQcOqi2q" +
       "wnBgwLOJs9O2uiwQFTamHTkdVMVmp5O5QUeouGOT3Slk2NqFqKtK6mYxsD0/" +
       "oNX6nHMljsrbjSThmussTPJ42Mh38JCZMLtGzmI8R9lc3TBd13C0WWOEYn1t" +
       "NdzWvCFbrWOaOyEU3JG7qJr3sJZkNJsTGqi9AquqY3BtZ6NpbR0fdgKsYfTD" +
       "vrVVG9sAGRFs5HjTJKG7npLQiTHZtvgakqNS3g76uwnix1NcyXprklYCuify" +
       "440crixFifVGgnNIEuxQhaO05rrh2DO0vYna0droclUj1pqRo/Kuh2fDLhFG" +
       "xFBvCZINDwTFr+06NsxnSVeYsJyPzBdMj9xO11bFt8aDfm6TATIbyFx1LtvD" +
       "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" +
       "x/70u//m8cl3r559GadzbzpH5/khf4H7+O9Q36L+5EXonuNd7VtuApxFevrs" +
       "Xva1UI+T0Juc2dF+49kTMgqU+aFy5ud3E0/Uf/utxG/bm8+545gLJwBMCfDB" +
       "u5zX/GRRvT+GHov0uHfb3e3b7YRtfUs7Mcsf+0abYKcnLRvedyyER4rGCijP" +
       "Hgrh2VdHCKd5/Hd36fv3RfVvAP/mHfgvxXjC6799BbyWYG8FxT3k1X1VFX47" +
       "Td1jeXGJ8x/uIoNPFtXPxtAj++MNpNmx4mjit4vHbdWv7GL9RCQ/90pF8hQo" +
       "20ORbP+fi+RSVOi1xPrUXYTyG0X1azH0TXuhiJbp6doZ0RQAv3Iihv/8CsRw" +
       "/5EY3nMohve86q4gKgE+exeOf6+oPh1DDxSXX8je/gylaHv+hMnPvFJdvwGU" +
       "Hz9k8sdf/aX+R3fp+5Oi+kPAn3mOv+kJf597pUosAuyHD/n78KuuxL0//4u7" +
       "MPmXRfX5GPpmwFtxsFT4NDcI9Sg6e8R0SqdfeKXuu+j/6CHPH331dfqVu/T9" +
       "j6L6EmDXvDu7pzz4374cdrMYun7urlFxceKxW64+7q/rqb/8wvWrr39B+u/l" +
       "dZvjK3X3sdBVI3Gc0+fcp94vA4INq+Tnvv2pd1A+/ncMPfWSr0QBt1w8Sg7+" +
       "YY//jzF086XgA59YPk/jfj2Gnrg7LsAqn6ewLlwEgfROWCAYgfo09KUYeu3t" +
       "oAEkqE9DXo2hG+chwfzl8zTc/TF07QQuhi7vX06DPAhGByDF6/XgNoea+4sM" +
       "2YVTueih1ZfW8/A3sp5jlNP3jAoRlJdqj3LNZH+t9hn1Ey8w/A9+tfkz+3tO" +
       "qiPneTHKVRa6sr9ydZyvvuWOox2Ndbn/1Nce/OR9bzvKrR/cE3yyAk/R9qbb" +
       "Xyoi3CAurwHlv/b6//hdP/fCn5VnrP8MatDPsu0sAAA=");
}
