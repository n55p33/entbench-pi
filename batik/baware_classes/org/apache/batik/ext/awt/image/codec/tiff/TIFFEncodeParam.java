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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "YIZzfeGAr+YuKfjgyvxISDw+WVO+eHL3r8wN/eyHPFUxUp5Iy7Lz5VHHfSm4" +
       "w4TEeawyXyXlL8mFSxhZc97b+IzMwh8EEg6b8qWMNJ2PPCOz+a9Tdg4jjcGy" +
       "ICVlY8KsVBUjS/ykGCmB1Fm6hpEFXqWhJKTOknWM1LpLQvv811luISMVdjlG" +
       "Ss0bZ5ElUDsUwdsLzFfo4InjFVvz7eCMuY281Gke/BBh4VRWlRNxfiqAFPBP" +
       "+bLbpOlu66TzxOTOzls++Odvmp8qiLIwMYG1VMZImfnVBK+0pODU1Flbtq7S" +
       "HWvOzX10zurspvQ8U2F7fC61BxEu3EIa2nK96z1+oyn3Ov9LRzb/6JcHS8+E" +
       "SWgvCQmMzN9b+B51RkvrpGFvrPAd0n5B5x8YNK/52viW9Yn3Xsm9sJz/frq7" +
       "/KD4wtF9z9+95EhjmFR2gJkpcZrhL3hvG1d6qDiqD5BqyWjLgIpQiyTIeS+o" +
       "zsVhJ+BHfpwXi87q3FP80IWRlYXv5hZ+HlQhq2NU36qmFb4ZVx0jlfYTs2dc" +
       "u9VpTXMJ2E+srsR0CJM9GewNsMfB2C5Ny766POeQxp2P6DVT8KO48Hp+i3eX" +
       "/A34UNpn5jsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qxlTryiYq1rTINmE+GbjNBOBN9yGg2H2");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("BOcGQSINZ8bYiS2hApPDoppQccj6xVGiNEsqGxMLJqkxUdKChlVr2IfrYoxp" +
       "k9nKx1rtHrmhtE2lTHCW1G2xsc5TY40zR2h7UtcZL9E8MKl1Q72aNEgMI/zq" +
       "lGnPHdtc4n3bNYeSo8N8kVKIVrG8ksVUCzAhWPDEougsSceISbilz5otyjeE" +
       "4dxHBtycsClrzSz7niYHPIGOhRqwcgyXSRer6o65Ljr1IsSXZlYcBLi3WlJI" +
       "L5CZsolNHG+JhQq3mkbhwqQdjGNlUY/rkkO4WlqtdOjyugHMY572xqrpYxSn" +
       "xsWBAIM4ZGahArDN4XJgLZu0goKZecPpT7y43nbj2I0aw2bXQ6cY7dVGBr8w" +
       "Ba5WWsIauvJXDGssBNurorzID5NE0ldxr4Zqpq6uOwIuUAI2TVAM5qI4aLMe" +
       "NZtDSzD6CjPV2lhRKdYl0dXKltcgR0rbo5xmrQJksqo0N22GGDBUs1mfKBaP" +
       "1UFQR/sYsUqZ0SrVK2pTqA7XFjdJsNa6CAZgqFdt4xSmh2WPG8yDeqix7CgC" +
       "XTJWyvUSYyt9U1P5pgnkTk/t2GsryVowUJzpOdhkVm+CiZexscwpNptXLZJw" +
       "a2ASuJ4Am1CnJUvsOR0OZ7F0GU6hTnfA+YGDeouazc42ynI2jSWCm2BMdxyE" +
       "sDPtVoX1zEpGaAnjBx42AQObMjDbhOAOR7oryEuvVxlZYtJGFyt8kEwdG1je" +
       "qIoo6AZEzrxDiIuUhu0ha0gyFDbTgIW5uNdrdxNcNFg9mkk+vWZm6IBnsWYM" +
       "Rk3DlnlDTTbJcFrroWuYTQwVyuYA0/YsVRUK84rTsKuulpsoaQ+bcXEsckWF" +
       "ZqoeGrOQsqF5cpSMXLi9QZgUFmlaHVq1uCa0FCneTDYTk0EtcphoM7mBzIvt" +
       "tBdraKu1rM/R9bjHdio8T3BpUWoIi2VttZKpTZsQzSna9UV8tBpCG4MiLLxM" +
       "WnXNbZGT9VjrdAXOsMe9MuMy/ShCy2UzbA974mJlUkO/NJ/BLXPU9EcxCE1T" +
       "UnVqbeDHxChFFKIXTitomTIUCMe1mjgYmwM2UfU1RvI4X5wzc5czw3pdSBNO" +
       "4FLTLxa5RWS56Fpn2nFvSpXF3qxtqbaId4sll2uOyqQ5D9YgLB1HXDopl9LQ" +
       "892oj44qJKIS9TKetMJqqy1V7G6jnpaLzsauclGDGaRzqN6R6SFabA3Hy4jo" +
       "W70UDIBFHC4PjMhzKTLyeGxRsmEcTtAp24XgSqSPG1O7OvGtht9JIdUDIUW3" +
       "WYsDspE2ig24pa0sclBZdgxXnnkaU9Uiqryor5v6ugnj6814xSzbbl/fCG1l" +
       "WHRSX9Q6RZxW3Xiio8i6SvJoqT0emNNJBGuzIm32tXWFHVXra4uc12ZiUlqZ" +
       "6lTwKws5bIiuMOl1Kq2i7/mDEtHpNSglZv2eilcImN0g9TrPKf3ErfD1piig" +
       "Xa6G0m5RryoTCKvWRqxrw8BFYtgb35gtL//dlS1735kv4++/wbEykSzjf1/B" +
       "yvY26+EseWz/iUf+ubFwbNf/oSceecn7dvvPd48MXn9ZD8G2D1+zC4eezWS7" +
       "8B641Lsd+Q68T7z76WcW3M+W957+8tmTfcf9ETN7inIIzZ2gpdde+rFpL396" +
       "ebBl9LPv/sb9wpu0t1/BRvhXHsN5vMmf7z37O9QPyf/idOG6/Q2kF7x0c7TS" +
       "40e3jZ7xlCD0bOHI5tEH9pVzNtPFA+B4x0457zj+OOpA/Rd/FvXqrfnkeRfd" +
       "+XzqnhPy7s2Sc0HhjqUSEMc2qezb3Kk7X+xpyuFmswunbt9neOueyT21Y/jU" +
       "tWF46qAAm1N5+ASaj2TJKwBN/wjNiz5Nihx9cUD9gaugfnd28SFwfHxH/ePX" +
       "XrmlE/JyAsWgcDtQ7nh/o09W8mMHBF93tbrNHlw/tyP43DXX7cdyJm84geWb" +
       "sgQBLP1jLE89dsASvVqW2X7Bz+xYfubasDydF8j3+bIHZnySsjtZQgSFWwHV" +
       "jOVQT5VjRJtXQTR3RtmuqM/viH7+2turcEKemCWgC9623NI72Ol1wI+/Wn6v" +
       "AMcf7vj94bXn9/YT8uZZ8pZtfxSObhk7IPhjV0Ew326Z7Vr9xo7gN66AYG6I" +
       "rwbS9ze2rHmODYxrcVL3zH//h/2bvy67V+3Fbp5vz/r1XBzWCaJaZ8ly67Bb" +
       "B7vYjhm7dhWyynbZ5ePSX+7g/uUVyypr0HhRi3jHCXlPZkm0HX4P0Twm2Vyt" +
       "D70Y1K1kD4QTXwvH/v3dHb9/bXrKBYP2Pz5BOO/Pkp8MCmeBDTSP7rM5bATv" +
       "uVqP8CBAdGZbd/t9bT3CB0/I++kseQpQXF5A8bBP+OdXq0oaoL17R/Hua67K" +
       "7Rj9r0/g+fEs+UhQ+AGgymwr114MdmR/2mGlfvRqwy7gjU7dv2N8/7VX6qdO" +
       "yHs+Sz4JyC5PIHs4BPv5q1UvAXDv3j47dcHbZ1et3i/nrH7lBMa/miW/HBTu" +
       "2qn36E69w3r99FVQzSKTwo8AULstqacueBHp6vX6WyfkfTZLXgAslxdjWfjy" +
       "AcvfuFqFIoVsf+6WJXPNFfq7OZ0vnED197Pkc4eGX3JvJ/FhZf7nq6B5b3bx" +
       "MQBouKM5vPbK/JMT8r6SJX90aOTdZ1j43QOGX7oShgnw48de/8/eZb7vgn8j" +
       "2f6DhvzcM2dvvveZ0X/d7tve+5eLW5jCzWpomodfPT10fiNwJaqeU79l+yKq" +
       "m/P5n0HhNZe9cRnMcrOvXCX/Y1v/60Hh0cupHxRuyL8P1/3zoPDgyXVBLX0/" +
       "gNvV+j9B4b5L1QoK14H0cOm/CAovu1hpUBKkh0t+NyicO14S3D//Plzub4LC" +
       "mYNyQeHG7cnhIt8DrYMi2enfurm+j+6m3b5bnGwj4fsOGfp2qe6uF7Oe/SqH" +
       "X/3PRJD/z83emlTI717PeP6ZDvuO79R/dvvXA7IppWnWys1M4abtvyDkjWbr" +
       "Wg9fsrW9tm6kX/O9O37xlsf21uDu2AI+6HSHsL3y4u/5tyw3yN/MT//9vb/8" +
       "hp975sv5G8r/D3dS65GASAAA");
}
