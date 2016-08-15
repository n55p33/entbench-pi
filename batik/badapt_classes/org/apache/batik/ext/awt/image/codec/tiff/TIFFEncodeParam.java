package org.apache.batik.ext.awt.image.codec.tiff;
public class TIFFEncodeParam implements org.apache.batik.ext.awt.image.codec.util.ImageEncodeParam {
    public static final int COMPRESSION_NONE = 1;
    public static final int COMPRESSION_GROUP3_1D = 2;
    public static final int COMPRESSION_GROUP3_2D = 3;
    public static final int COMPRESSION_GROUP4 = 4;
    public static final int COMPRESSION_LZW = 5;
    public static final int COMPRESSION_JPEG_BROKEN = 6;
    public static final int COMPRESSION_JPEG_TTN2 = 7;
    public static final int COMPRESSION_PACKBITS = 32773;
    public static final int COMPRESSION_DEFLATE = 32946;
    private int compression = COMPRESSION_NONE;
    private boolean writeTiled = false;
    private int tileWidth;
    private int tileHeight;
    private java.util.Iterator extraImages;
    private org.apache.batik.ext.awt.image.codec.tiff.TIFFField[] extraFields;
    private boolean convertJPEGRGBToYCbCr = true;
    private com.sun.image.codec.jpeg.JPEGEncodeParam jpegEncodeParam = null;
    private int deflateLevel = java.util.zip.Deflater.DEFAULT_COMPRESSION;
    public TIFFEncodeParam() { super(); }
    public int getCompression() { return compression; }
    public void setCompression(int compression) { switch (compression) { case COMPRESSION_NONE:
                                                                         case COMPRESSION_PACKBITS:
                                                                         case COMPRESSION_JPEG_TTN2:
                                                                         case COMPRESSION_DEFLATE:
                                                                             break;
                                                                         default:
                                                                             throw new java.lang.Error(
                                                                               "TIFFEncodeParam0");
                                                  }
                                                  this.
                                                    compression =
                                                    compression;
    }
    public boolean getWriteTiled() { return writeTiled;
    }
    public void setWriteTiled(boolean writeTiled) {
        this.
          writeTiled =
          writeTiled;
    }
    public void setTileSize(int tileWidth,
                            int tileHeight) {
        this.
          tileWidth =
          tileWidth;
        this.
          tileHeight =
          tileHeight;
    }
    public int getTileWidth() { return tileWidth;
    }
    public int getTileHeight() { return tileHeight;
    }
    public synchronized void setExtraImages(java.util.Iterator extraImages) {
        this.
          extraImages =
          extraImages;
    }
    public synchronized java.util.Iterator getExtraImages() {
        return extraImages;
    }
    public void setDeflateLevel(int deflateLevel) {
        if (deflateLevel <
              1 &&
              deflateLevel >
              9 &&
              deflateLevel !=
              java.util.zip.Deflater.
                DEFAULT_COMPRESSION) {
            throw new java.lang.Error(
              "TIFFEncodeParam1");
        }
        this.
          deflateLevel =
          deflateLevel;
    }
    public int getDeflateLevel() { return deflateLevel;
    }
    public void setJPEGCompressRGBToYCbCr(boolean convertJPEGRGBToYCbCr) {
        this.
          convertJPEGRGBToYCbCr =
          convertJPEGRGBToYCbCr;
    }
    public boolean getJPEGCompressRGBToYCbCr() {
        return convertJPEGRGBToYCbCr;
    }
    public void setJPEGEncodeParam(com.sun.image.codec.jpeg.JPEGEncodeParam jpegEncodeParam) {
        if (jpegEncodeParam !=
              null) {
            jpegEncodeParam =
              (com.sun.image.codec.jpeg.JPEGEncodeParam)
                jpegEncodeParam.
                clone(
                  );
            jpegEncodeParam.
              setTableInfoValid(
                false);
            jpegEncodeParam.
              setImageInfoValid(
                true);
        }
        this.
          jpegEncodeParam =
          jpegEncodeParam;
    }
    public com.sun.image.codec.jpeg.JPEGEncodeParam getJPEGEncodeParam() {
        return jpegEncodeParam;
    }
    public void setExtraFields(org.apache.batik.ext.awt.image.codec.tiff.TIFFField[] extraFields) {
        this.
          extraFields =
          extraFields;
    }
    public org.apache.batik.ext.awt.image.codec.tiff.TIFFField[] getExtraFields() {
        return extraFields;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1bDXAcxZXuXdmSrB9Lln+RkfwnQ/zDLjZwGOQ4yLJky6wl" +
       "RZJlkDFiNNu7Gmt2ZpjplVYivgCpHE5IKIcYQlJBlSocTIixCUnqIDlyTuUw" +
       "SUFchYEkQAVIuLoYCH/FkdzFd+Te65ndmZ2dGXmVU1Q1vaPpft3v+/r169fd" +
       "M8feIbMNnTRShUXYuEaNSJvCugXdoPFWWTCMPng2KH6tRPjwxrOdV4VJ6QCZ" +
       "OywYu0TBoO0SlePGAGmQFIMJikiNTkrjKNGtU4PqowKTVGWALJSMjpQmS6LE" +
       "dqlxigX6BT1G5gmM6dJQmtEOqwJGGmKgSZRrEm1xZzfHSJWoauN28SWO4q2O" +
       "HCyZstsyGKmN7RdGhWiaSXI0JhmsOaOTdZoqjydllUVohkX2y1dYFOyMXVFA" +
       "wcpHa/507tBwLadgvqAoKuPwjB5qqPIojcdIjf20TaYp42byj6QkRiodhRlp" +
       "imUbjUKjUWg0i9YuBdpXUyWdalU5HJatqVQTUSFGVuRXogm6kLKq6eY6Qw3l" +
       "zMLOhQHt8hxaE2UBxHvWRQ9/7cbax0pIzQCpkZReVEcEJRg0MgCE0tQQ1Y2W" +
       "eJzGB8g8BTq7l+qSIEsTVk/XGVJSEVgauj9LCz5Ma1TnbdpcQT8CNj0tMlXP" +
       "wUtwg7L+m52QhSRgXWRjNRG243MAWCGBYnpCALuzRGaNSEqckWVuiRzGpmuh" +
       "AIiWpSgbVnNNzVIEeEDqTBORBSUZ7QXTU5JQdLYKBqgzUu9bKXKtCeKIkKSD" +
       "aJGuct1mFpSaw4lAEUYWuovxmqCX6l295Oifdzo333WLskMJkxDoHKeijPpX" +
       "glCjS6iHJqhOYRyYglVrY/cKi548GCYECi90FTbL/PNnPrhmfePJn5tllnqU" +
       "6RraT0U2KB4Zmvvcha1rripBNco11ZCw8/OQ81HWbeU0ZzTwMItyNWJmJJt5" +
       "sufU9bc+TN8Ok4oOUiqqcjoFdjRPVFOaJFN9O1WoLjAa7yBzqBJv5fkdpAzu" +
       "Y5JCzaddiYRBWQeZJfNHpSr/HyhKQBVIUQXcS0pCzd5rAhvm9xmNEFIGF9kE" +
       "V5SYf/yXETk6rKZoVBAFRVLUaLeuIn4jCh5nCLgdjg6B1Y9EDTWtgwlGVT0Z" +
       "FcAOhqmVgSNTGGNRKQXdHxXBG4lRJiUS0b6O9vY2BR9048CNoNVpf+f2Moh/" +
       "/lgoBF1zodsxyDCmdqhynOqD4uH01rYPjg8+YxodDhSLOUauAhUipgoRrgJ3" +
       "o6BChKsQ4SpEUIWISwUSCvGWF6AqpkFAd46AYwDPXLWmd9/Omw6uLAFL1MZm" +
       "QV9g0ZV5M1Sr7T2yLn9QPFFXPbHi1Q0/C5NZMVIniCwtyDjhtOhJcGXiiDXa" +
       "q4Zg7rKnkOWOKQTnPl0VaRw8mN9UYtVSro5SHZ8zssBRQ3aCw6Ec9Z9ePPUn" +
       "J+8bu63/s5eGSTh/1sAmZ4PDQ3HOX86nN7m9hVe9NXec/dOJew+ott/Im4ay" +
       "s2eBJGJY6bYNNz2D4trlwg8HnzzQxGmfA36dCTAOwWU2utvIc0vNWRePWMoB" +
       "cELVU4KMWVmOK9iwro7ZT7jRzuP3C8AsKnGc1sM1ag1c/ou5izRMF5tGjnbm" +
       "QsGnkE/2avf/5vSbl3G6s7NNjSNM6KWs2eHhsLI67svm2Wbbp1MK5X57X/dX" +
       "73nnjr3cZqHEKq8GmzBtBc8GXQg0f/7nN7/02qtHXgjbds5gik8PQaSUyYHE" +
       "56QiACS0dpGtD3hIGbwGWk3TbgXsU0pIwpBMcWD9T83qDT/84121ph3I8CRr" +
       "RuunrsB+fsFWcuszN/65kVcTEnGGtjmzi5luf75dc4uuC+OoR+a2Mw1ff1q4" +
       "HyYQcNqGNEG5HyacA8I77QqO/1KeXu7KuxKT1YbT+PPHlyOSGhQPvfB+df/7" +
       "P/mAa5sfijn7epegNZvmhclFGah+sds57RCMYSh3+cnOG2rlk+egxgGoUQRn" +
       "bHTp4CwzeZZhlZ5d9vJPf7bopudKSLidVMiqEG8X+CAjc8C6qTEMfjajfeoa" +
       "s3PHyiGp5VBJAfiCB0jwMu+ua0tpjJM98fjiH2w+OvkqtzLNrGMpl69D15/n" +
       "VXlAbw/sh5+/8sWjX7l3zAwJ1vh7M5fckr90yUO3//6/CijnfswjXHHJD0SP" +
       "fbO+dcvbXN52KCjdlCmcrsAp27IbH059FF5Z+lSYlA2QWtEKoPsFOY3DdACC" +
       "RiMbVUOQnZefHwCa0U5zzmFe6HZmjmbdrsyeJuEeS+N9tct7LcEuvBqujdbA" +
       "3uj2XnyKNC0KVYp0QLybpHrd77915M+33bEpjMNn9iiqDqzU2uU60xin/9Ox" +
       "exoqD79+J+94dC5YaQdv/mKersXkEm4KJXgbAe9j8JCfARxJEWSXF1ocoCws" +
       "sFq7dnX3tPX2dnR1DnZ2dbblT9o4MfamhwyYYKUU+NNRKzbd2H2TeLCp+99N" +
       "I7vAQ8Ast/Ch6Jf7f73/We6ty3EK78sS65igYap3TBW1pv5/hb8QXB/jhXrj" +
       "AzPGq2u1As3luUgTB0mgtbsARA/UvTbyzbOPmADcpu0qTA8e/uJfI3cdNl2w" +
       "uVxZVbBicMqYSxYTDiZ7ULsVQa1wifY/nDjw44cO3GFqVZcffLfB2vKRX/3v" +
       "s5H7Xv+FR1xXIllLTvQ1oVwEtiC/b0xA275Q8y+H6kraYfLvIOVpRbo5TTvi" +
       "+UOgzEgPOTrLXgbZw8KChh3DSGgt9IE5dWO6CZOdpi02+zrK1sKBtcmy1U0e" +
       "AwtvroXHYbxJBo0KTLox+bTHcPBrAhZ4zuGwvadrd/dlgxu2YWa/C9rwNKBt" +
       "sdrdEgCNq69NG5pfE97QNnpCu3ka0LZZ7W4LgDYLb8anDc2vCfQHbmiXe+Ga" +
       "mAaunVajOwNwzcab26eNy68JCHWcuGIDe7xAfW4aoHqsFnsCQJXizZ3TBuXX" +
       "BCOLnaB2drdtH9za03VtW6cXuC9NA9x1VsvXBYArw5vD0wbn14RrkHFwfX2d" +
       "G72g3VMkNBzQe6129/pDu5Ub4/3ThubXBKyXndC6W1qv3drR1+uFbHIayASr" +
       "WSEA2WN48+C0kfk1wch8J7Jtbe2xlr42L2BHzx9YFT7FHSnRalUsAEb4zQlv" +
       "PLCmLNN0aRRCGxeUyoBKGanELThYnxjWytcN4dEiIVwMF7Vaoz4QHjchYPJY" +
       "oa5+0oxUjOkSo30Qx5lbun2Y7DEVvN5xvw+4GFJVmQqKO77Bf0V30PFEkRhx" +
       "LyJhaZnwwfhvgRj9pBmsFgHeHilu7ly6e+OpIjVdClfSaivpo+kzgZr6SUNv" +
       "oKY7qJQcZl6qPlukqivgkqzGJB9VzwSq6icNRg7BvS504G6lARFug8fqo0cY" +
       "41vwg+INF9cuarrqw5VWoO9R1rFXf9ePfzQwcHGtaBb2Wge59ugfOlouvpI6" +
       "xddBqN3uHA7khxO0z8LBfxm57m/cLwaxVLQFEvPESknCIju7Fz1jdfONlbxN" +
       "B5vg747ILe9tevCTJmcrfFZgdvknPv36c/dPnDhmLmFwScjIOr/jtcIzPdze" +
       "XB2wRWt35kfbrz755hv9+7J9MxeTV0w7XgJBo70F08Eo39vDnDfOy8c8X+Rw" +
       "aIJrxDKEEZ/hcDZwOPhJZ4eDeaxreJs438QzWbmh8tS/Gg/8x2NZVl7Kb6qa" +
       "uNYQjOyfyROObZJOcWNtPGvDf8fW0KoDTMlB2uSDq05/dnLV7/jmYblk9At6" +
       "i570OPdzyLx/7LW3z1Q3HOcb7NzOkehq94Fp4Xlo3jEn76MaTN7LWe5lxZ3g" +
       "cMvQNI2cl2W/WaRlb4ArZRlMysey/xJo2X7SEE2LqjJKdYaBdM/2rX3q9a1D" +
       "rXyUPunS+lyRWl8Gl2K1q3hrbUWeflr7ScOqbb9Gk45js2y3fQJis4iRVvJ6" +
       "CctGEJ9DIB9bKFwkts1waZZ2mg+2ikBsftKMVMVpQoagNEZHqewRJ4QqA5TN" +
       "2I2uyzXK/0qJ6xzX0SgvudTaz7KovPq8RoDp2/GBg1wc9A1+p/V8E+7I7Ycn" +
       "413f3pD1kDdiGKdql8iI2aHNvPzYAybFXXzg2tvav5179xtPNCW3FnO0ic8a" +
       "pzi8xP+XgfdZ6++83Ko8fftb9X1bhm8q4pRymYsld5Xf2XXsF9svEu8O85cx" +
       "zP32gpc48oWa87cYK3TK0rqSv6m4KmcaNWgJDXDdYpnGLW5rto3PZVW58zc/" +
       "UV7S86QqtCogbzUmjYzMTVLW6lpq2YNg2VQjNvh8CB+08C3AUH0OUWV2bByy" +
       "EB0qngw/URdgx/TQz1FfGsAIbm6E1gEjRh4jXqu4WaOqFLdZWj8DLM3HvOVw" +
       "PWBBfaB4lvxEA0i4JiBvKybNjFSDyezJrXj5JGZzsXmmLAan5+MWoOPFc+En" +
       "6m8xT3LQuwII6cJkBxBiuAgJXW4T0jFThOAW4SkL1aniCfETdeENc0X4MUW/" +
       "PY4GAli5AZPdEM0DK0hIrzRBXZz0zwAn3MfivsJpC9jp4jnxEw1AmwzIkzAZ" +
       "glgjaTJhb5/YVIgzRcWFcL1o4XmxeCr8RAPgsoC8UUxU03f05e/P2FxoM8AF" +
       "35htgestC9BbAVzw1LF5yc0+Ah1ojMOCTVcVMOW4x46sX93+zuVlzsrnAhj7" +
       "PCafMaejNnubyDWSDswAZbjjxSfoDy1YHxZNGVZ4qwdRfjUG8PCVgLyvYnKn" +
       "GcTkc0Retjma8uzlb5mSPrYQfRzAkc8Q8xOdKoiZDGDkW5h8HZZuYDXb8lc4" +
       "TrP5xkx5nUbQtMKs0/wtihJf0QDE3w3IewSTB4GNZAEbTr8z5XHIdA1kB0CZ" +
       "b0GaXzwbfqJTxSyPB1DyI0y+z8gFYCC4Ws9Gunm7Ek5T+cFMBbfrQed6C2F9" +
       "8eT4iQZgfyog72lMTgIvyQBenIHuT2fKaFoBlPWaU6jgnaypefET9TWaUCkn" +
       "4EwAOS9g8ktG6iyjyd/icVrL6RlgBYM6cgkoa23nhgreOpmaFT/RANCvBeT9" +
       "DpOXgZCkJyGlNiGvzJSZXEnw2MFEFSueED9Rf9/yLkf+xwBW3sXkD46QpT27" +
       "P+w0kbMzwAjGFmQ1KNprweotnhE/0QDA/x2Qdw6T/3TEJjkyyLs2GR/9f5CR" +
       "gRnO9YUDvpq7pOCDK/MjIfH4ZE354sndvzY39LMf8lTFSHkiLcvOl0cd96Xg" +
       "DhMS57HKfJWUvyQXLmFkzXlv4zMyC38QSDhsypcy0nQ+8ozM5r9O2TmMNAbL" +
       "gpSUjQmzUlWMLPGTYqQEUmfpGkYWeJWGkpA6S9YxUusuCe3zX2e5hYxU2OUY" +
       "KTVvnEWWQO1QBG8vMF+hgyeOV2zNt4Mz5jbyUqd58EOEhVNZVU7E+akAUsA/" +
       "5ctuk6a7rZPOE5M7O2/54B++bX6qIMrCxATWUhkjZeZXE7zSkoJTU2dt2bpK" +
       "d6w5N/fROauzm9LzTIXt8bnUHkS4cAtpaMv1rvf4jabc6/wvHdn8k18eLD0T" +
       "JqG9JCQwMn9v4XvUGS2tk4a9scJ3SPsFnX9g0LzmG+Nb1ifeeyX3wnL+++nu" +
       "8oPiC0f3PX/3kiONYVLZAWamxGmGv+C9bVzpoeKoPkCqJaMtAypCLZIg572g" +
       "OheHnYAf+XFeLDqrc0/xQxdGVha+m1v4eVCFrI5RfauaVvhmXHWMVNpPzJ5x" +
       "7VanNc0lYD+xuhLTIUz2ZLA3wB4HY7s0Lfvq8pzvadz5iF4zBT+KC6/nt3h3" +
       "yf8BKD7Vt+Y7AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Dj2s9RJWSEczDNMlrG4nGwKtmHXKxJLB");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "T32peEP5/wEwmjO2gEgAAA==");
}
