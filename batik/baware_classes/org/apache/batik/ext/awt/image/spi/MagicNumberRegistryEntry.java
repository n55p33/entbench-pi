package org.apache.batik.ext.awt.image.spi;
public abstract class MagicNumberRegistryEntry extends org.apache.batik.ext.awt.image.spi.AbstractRegistryEntry implements org.apache.batik.ext.awt.image.spi.StreamRegistryEntry {
    public static final float PRIORITY = 1000;
    public static class MagicNumber {
        int offset;
        byte[] magicNumber;
        byte[] buffer;
        public MagicNumber(int offset, byte[] magicNumber) { super();
                                                             this.offset =
                                                               offset;
                                                             this.magicNumber =
                                                               (byte[])
                                                                 magicNumber.
                                                                 clone(
                                                                   );
                                                             buffer = (new byte[magicNumber.
                                                                                  length]);
        }
        int getReadlimit() { return offset + magicNumber.
                                               length; }
        boolean isMatch(java.io.InputStream is) throws java.io.StreamCorruptedException {
            int idx =
              0;
            is.
              mark(
                getReadlimit(
                  ));
            try {
                while (idx <
                         offset) {
                    int rn =
                      (int)
                        is.
                        skip(
                          offset -
                            idx);
                    if (rn ==
                          -1)
                        return false;
                    idx +=
                      rn;
                }
                idx =
                  0;
                while (idx <
                         buffer.
                           length) {
                    int rn =
                      is.
                      read(
                        buffer,
                        idx,
                        buffer.
                          length -
                          idx);
                    if (rn ==
                          -1)
                        return false;
                    idx +=
                      rn;
                }
                for (int i =
                       0;
                     i <
                       magicNumber.
                         length;
                     i++) {
                    if (magicNumber[i] !=
                          buffer[i])
                        return false;
                }
            }
            catch (java.io.IOException ioe) {
                return false;
            }
            finally {
                try {
                    is.
                      reset(
                        );
                }
                catch (java.io.IOException ioe) {
                    throw new java.io.StreamCorruptedException(
                      ioe.
                        getMessage(
                          ));
                }
            }
            return true;
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
           "hRqnblJv7BRy5IRUiAnOpD+DMYUabxwTWIQkOf0hhW3WKTfG+3WEdCbEGptR" +
           "rXE2jIcCns216QrFrRzvrUbqvtVzuuRWqrOYOh2bmoDUaxLK1EnFEYuFtwbL" +
           "7F2/uwnigEbbq3Q39KSRI7XXW4yeqqLTyEnYjNFpnHN5zyKZprvssujInNfq" +
           "443CLbtLb6W6iOQOOCSqb+hkKqDimHSRfR9v8lu28BW/5a+dqc7Tmzpbn0f2" +
           "YMkvKODEgR9iy53IYkJDcYe1IU7kow7tdRl800Uzfj6AB4wtYWt2NYxnc3G7" +
           "JbZzmqFYd0JyM1YamSI+6Nl+VkvoniKYYkp3OzEzHHV8LMuSrO/0smZhTbbd" +
           "eG/EPaSOLPRiGzH9jHfkfTSeWeNstGcUcd4uyGJX9LTW3ul6Mrusi21dlwYb" +
           "jKVVZTVCJgxLu0qDy5Om4LSaMDNCgBGISzRVV5TL5p2FoKp0jx+vqHk/y3oz" +
           "1cNScd2ksngzDraZqrFSb9/stC2s3x/2s66aDoi80cKaJN+M2pMWmtMRxZk2" +
           "NqrLeTrFSWwuttecVojJYJfXmqlu47Q8oj2n4+uBZS+DnST28bHMpruB4Q1H" +
           "W9zSl/M1bZvJasZavGiFuRhFNrbktiwrKta0oxZUzrc2gdH2ectQe9FewAiV" +
           "RQkhsRIx35jxqqdl+703o6w+STETeKgm6Hw3GYyVaJLkBNyatjU9y+ANNhtv" +
           "6trULtpzwMtcwDxgXpYUr80aZxSsv2lapOfNmoLX3w9nm4Y10IZ4mVz2G4dg" +
           "FqZKSVkrnHcltTXQjKKnxmuyofc6hD7Gcd/sx8g6XU2tlFxPJINmtsRkMuC0" +
           "oYuosI2Ylh1HfjtGCdQn6gLemjd3ylZAOVOdW5tdJ5218Pbaa1lppBDKylvk" +
           "bb+7Q4VJluOIr5BIarTXphuCRXp7OlBiq77ujWatuqaj0xUXG+p01x4UsJR3" +
           "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");
    }
    org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[]
      magicNumbers;
    public MagicNumberRegistryEntry(java.lang.String name,
                                    float priority,
                                    java.lang.String ext,
                                    java.lang.String mimeType,
                                    int offset,
                                    byte[] magicNumber) {
        super(
          name,
          priority,
          ext,
          mimeType);
        magicNumbers =
          (new org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[1]);
        magicNumbers[0] =
          new org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber(
            offset,
            magicNumber);
    }
    public MagicNumberRegistryEntry(java.lang.String name,
                                    java.lang.String ext,
                                    java.lang.String mimeType,
                                    int offset,
                                    byte[] magicNumber) {
        this(
          name,
          PRIORITY,
          ext,
          mimeType,
          offset,
          magicNumber);
    }
    public MagicNumberRegistryEntry(java.lang.String name,
                                    float priority,
                                    java.lang.String ext,
                                    java.lang.String mimeType,
                                    org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[] magicNumbers) {
        super(
          name,
          priority,
          ext,
          mimeType);
        this.
          magicNumbers =
          magicNumbers;
    }
    public MagicNumberRegistryEntry(java.lang.String name,
                                    java.lang.String ext,
                                    java.lang.String mimeType,
                                    org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[] magicNumbers) {
        this(
          name,
          PRIORITY,
          ext,
          mimeType,
          magicNumbers);
    }
    public MagicNumberRegistryEntry(java.lang.String name,
                                    float priority,
                                    java.lang.String[] exts,
                                    java.lang.String[] mimeTypes,
                                    int offset,
                                    byte[] magicNumber) {
        super(
          name,
          priority,
          exts,
          mimeTypes);
        magicNumbers =
          (new org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[1]);
        magicNumbers[0] =
          new org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber(
            offset,
            magicNumber);
    }
    public MagicNumberRegistryEntry(java.lang.String name,
                                    java.lang.String[] exts,
                                    java.lang.String[] mimeTypes,
                                    int offset,
                                    byte[] magicNumbers) {
        this(
          name,
          PRIORITY,
          exts,
          mimeTypes,
          offset,
          magicNumbers);
    }
    public MagicNumberRegistryEntry(java.lang.String name,
                                    float priority,
                                    java.lang.String[] exts,
                                    java.lang.String[] mimeTypes,
                                    org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[] magicNumbers) {
        super(
          name,
          priority,
          exts,
          mimeTypes);
        this.
          magicNumbers =
          magicNumbers;
    }
    public MagicNumberRegistryEntry(java.lang.String name,
                                    java.lang.String[] exts,
                                    java.lang.String[] mimeTypes,
                                    org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[] magicNumbers) {
        this(
          name,
          PRIORITY,
          exts,
          mimeTypes,
          magicNumbers);
    }
    public MagicNumberRegistryEntry(java.lang.String name,
                                    java.lang.String[] exts,
                                    java.lang.String[] mimeTypes,
                                    org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[] magicNumbers,
                                    float priority) {
        super(
          name,
          priority,
          exts,
          mimeTypes);
        this.
          magicNumbers =
          magicNumbers;
    }
    public int getReadlimit() { int maxbuf =
                                  0;
                                for (int i =
                                       0;
                                     i <
                                       magicNumbers.
                                         length;
                                     i++) {
                                    int req =
                                      magicNumbers[i].
                                      getReadlimit(
                                        );
                                    if (req >
                                          maxbuf)
                                        maxbuf =
                                          req;
                                }
                                return maxbuf;
    }
    public boolean isCompatibleStream(java.io.InputStream is)
          throws java.io.StreamCorruptedException {
        for (int i =
               0;
             i <
               magicNumbers.
                 length;
             i++) {
            if (magicNumbers[i].
                  isMatch(
                    is))
                return true;
        }
        return false;
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
       "KcPV3WLmrW+7Opr0sOvjzghjr77pqqNuju68Q1ovn37r4eHh2556PVgm7Mv9" +
       "ptX2meNq++yPVG2f/hGr7TNFY59+vmr7Zxfc++c5+cJJtX36omr7Ulo66e8U" +
       "5n/qApFfyckv7jPxEy9EJn7jKPzfuP1MvJXo82D+p29m93MX2P1vcvKre7t/" +
       "7YWw+0+OlP+T27f7VqI/zFi3N36HPF+9wO5/l5Pf2Nv9lRfC7u8fKf/927f7" +
       "VqLPA7bnTf7GBSb/Xk6+tjf56y+AyQeXd7K739sy+ZaiP3SKF6N3o+jpjy6w" +
       "+z/n5D/t7f7927F7x/vITocdjp5Y8kjOkTO/7ih4rzvvhOIR8EP7JRzhROpK" +
       "Da788S9+8s/f877WpfyJ1l1JvmQF0/FTT7B2k6a//bmPvOpFz/zhB4onfqXS" +
       "Hd/KG/3WzYH7jvwQLDQv7waP/Gx6vNy8h2aICUNwi5NKeXDvjT99Pm8QZyN3" +
       "tXTBtPFocPmfN9exdKzQ/etzM8N3nVPqfz2vUkVLwL9gsVY7bB4WmfEXF7km" +
       "J//jjFteYdryteMRWQCagIXWNdNunmTaKYWQH1ohEPCX7ANJuc7qqQ/8lw/9" +
       "9s8/+U0Q7eFxtHPub4PcF37uB4++BZwcHNye7o/murPFEyNKCqNR8dxVVXL1" +
       "iybOPwkC69nVj2xSdOVnB3BIdI4/VEXq1lG+qs3jhhV1t0SbRlGii3Z9N643" +
       "GNxpTTub6ZxFx6N028WjGpQsdaSlqVCjHlWtFVwRvG3V9TapNJ3Eg6qOUSLT" +
       "kT23UfO9xSRYeJIIZfOJg/jRjIwEWUQnbWrmOHRSq1eTer3R7Y/SURYg7XYj" +
       "bWZQWVbbUAwtDH7WFT1Xd6mwi/dmbr9mzgXSs3hzKXnWjAVrWKxcTngTaY9d" +
       "c1vWmuzMSnBFTmZyZG0lkuqTHh70m6yPr2ZWxoqzMPRMFu17FSuSVg2CG+PV" +
       "uTlEQy4wdD8guna8ZrYro43pa2PMkObQJiejvqs3Kx0CruhwlyMmUytuYUhd" +
       "D/XFjFPxAT3F+3V/KW0WKdxqqH1jVHWXc3aFMqMRxo91naUiVhzLrqT7lVEq" +
       "zGR0vWbRSHX70cqf6UaT4EN8hCIhNGkidgJLgQt0Hg+raUvaxFLs+B2ihrEU" +
       "n9X8JhsPeCVeYLzOG3a3sWZsG/UrWzTEXWbMtwlkNkLbfYVnW5ykGK0xSzZ4" +
       "aWRS2JbmRsw0G9oTqjbyarJYNXRnvN7KNXIamVYUiJ0t22IiccPW604jyhaY" +
       "wUdVytdnEd5eM6upha8htjtdWy0OqwZTlukSzZolrMamUh1zlsDYyazuTax4" +
       "KDFDakXbnBQOUB3rjxNfNclmx9zii7VISktJw406OQiXW4ERFj4aoCNltphh" +
       "Rr0jo2Q6XfWwjHQHWo3l+kg6jTbhqkJVBCn1FkFn2ie2ZZJvq4kXLNxqdyoS" +
       "zrzDCMrQ2MwaG5qt4H6XRyZkb7idsC0DIeMeb6vDluAO6r6FIm2O6wxmOAkT" +
       "Q7xvrXR1HGyY2TreplYYlgfbGqTSdLWmU2OunnVkmCPJZKh1eWY88IkY9/m1" +
       "zq2mOk47eiBSWAotG10Zs7oKbHXmk0271VSTtchNVQ0zdU6Ou2GXLNujOOYU" +
       "eDmguXJ1KTdbxJo16+NOhC5qGsGt6dBqND1T8KaEJK77MDPcTLztYqxw1bQN" +
       "p03EFdu8MkTZmSBzstY1Z/aaxmGPzGSBd5ElJpFszyT7kkfUaaXR2aod2MP1" +
       "mUkiQwak2IT3s60rkIq2kQVmhg2FPtanu5EkYK02nlJBo9UerlKU7UBtC00y" +
       "ehiTCTrFzFmAamZ7shpiseTGDsrZ40FZqqzE4WaDUAsI70jJPFUrbWI6pHST" +
       "zwR92jEh14MWGOMvKltiSA5GGy3qbOwY25KkRm1RTGT6cBXFTHJAjGNpuhlU" +
       "JuXRsp7hw4m/0tq006H7k/aWx/tx3zf8tO+3Q3uJbZKlWW4GamUBD1YSFXBV" +
       "fObiwxXeMTZDgIkMu+gOOutOiGIE2uLSiWaqcHsgusxy1R/Mp3O341D9LLbl" +
       "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" +
       "XQOs4at9hV47A0Eqk+0N7jltfNQTB1sJ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("LDHqioYHscJuEIbRxagSUKYHx7Ws2YxHGbpqsKjldVyDLQ9cbM62TG4x9/Cu" +
       "ozs1xK+yaEYbwaKDdJbqpmLC9bHe2YqdMbIYNdJpMowzmm5XYZ5f+IPexsVV" +
       "CjUX5LazcsuBKbCOozFdlU3R+ZLMRqlF2/KWcGHKmgLUFrpSSlekgaPZdEOk" +
       "5pzlpCPILsdce9JYxAnUdBM66Wcb1BIEHxrYqtcbYtvWIsQSQ1dnFYiOq54f" +
       "KIQtwwit1nujoM9sA4YfTcr2yvDDYLBYwqMxqg3riWoJYYQImh2Ua60yjUFL" +
       "1mt3FkGZjEmO6EzCrdOgLHPKWrQw15eU5iUiMXTajXoWOJnfpzI4BUgWKP25" +
       "qdGOk5bL7Fzxq+XWUsIdvlrmV46CRtPxOmaTJQIvKoHv0nivZhlBX7JaXaPZ" +
       "JQnfEoMaUGumD9UJZ6vBQJiJvJoyZWZKM1aCaBMotse65NK8M9GdqGPEWCoY" +
       "/SlCtIit4yWQjvfh7nDD1BpTog9bmB4tOkm5QlHcZFTFk9ZIkCV6PAozJ0Ta" +
       "03rG1LcIrJXRJtJvsd2w0+m86U3547H7b+/x2EPFo72TnfE/wkO99KL3Y1Hp" +
       "HmkZRoEkR/udl8Unf6l+7ej42s2eaz9y6tXYy6IS8kO8X2ejQJXWZ16t5zs+" +
       "XnWrzfTFTsBPvveZZ5XJp6qXjp66tqPSvZHr/Q1bTVT7lCa7jUaLEytyA0o/" +
       "ATS8cvR0/soFD/bPe+eg8M4uCLd+IH/w5AX38v07B49FpftXasSokmLnWxxz" +
       "xjeexO3g8dt+cbG37+H84muAqo8f2ff4C2Pfwdm4Pny8NYtwvDjaRbCw7/xe" +
       "oXNyV0+2dBUiXTcIYi9SFSyVVS/fCVQ0Us/JG6LSlXwL3NoDebO01Z3EzZ7+" +
       "3r10XVuV9jtaDsq39QokKj1yqz0e+Z7dR274783u/yLy55994J5XPMv/+91m" +
       "zuP/dNxLle7RYts+vbPu1PFlL1A1o/Dxvbs9TsVL7YM3R6Unnr9YotIdgOYm" +
       "HPzUTg6NSo9dLBeV7ip+T0thwOZbSYE+AD3NPYhKL70ZN+AE9DQnGZUePM8J" +
       "+i9+T/ONo9J9e76odHl3cJplCloHLPkh4x3nT+uHwJPOEXSdRZSDU6BwVDUF" +
       "SF55vlQ5ETm9jT3vtfjn1vGewHj3363r8heeHY7f8T3kU7tt9LItZVneyj1U" +
       "6e7djv6i0Xxf4atv2dpxW5cHr//BS3753tccg9xLdgrvK/iUbo/ffM86tvai" +
       "Ypd59i9f8S/e+Jln/6B42fb/AUm14B1SNwAA");
}
