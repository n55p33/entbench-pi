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
          1471028785000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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");
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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0aC3BU1fXu5kNICPnxE0gIIVBB3fWL0viDmEDoAmmC6RjE" +
       "8Pbt3c2Dt+8937ubbLBRcdqCdsqgBbR+aB2xUAbBYepop2rp0KqodcZ/reOn" +
       "WivWWmUctCNt7Tn3vt339u0nRMHM5Ozbe8+59/zPufft3o9IiWWSBqqxABsy" +
       "qBVo01inZFo00qpKlrUSxvrk24ukT685snyBn5T2kvH9krVMlizarlA1YvWS" +
       "ekWzmKTJ1FpOaQQpOk1qUXNAYoqu9ZKJitURN1RFVtgyPUIRoUcyQ6RGYsxU" +
       "wglGO+wFGKkPASdBzklwoXe6JUTGybox5KBPcaG3umYQM+7sZTFSHVorDUjB" +
       "BFPUYEixWEvSJGcYujoUU3UWoEkWWKteYKtgaeiCLBU0PVj12fEt/dVcBXWS" +
       "pumMi2d1UUtXB2gkRKqc0TaVxq1ryfWkKEQqXMiMNIdSmwZh0yBsmpLWwQLu" +
       "K6mWiLfqXByWWqnUkJEhRmZmLmJIphS3l+nkPMMKZcyWnRODtI1paYWUWSJu" +
       "OyO49fZrqg8UkapeUqVo3ciODEww2KQXFErjYWpaCyMRGuklNRoYu5uaiqQq" +
       "621L11pKTJNYAsyfUgsOJgxq8j0dXYEdQTYzITPdTIsX5Q5lfyuJqlIMZJ3k" +
       "yCokbMdxELBcAcbMqAR+Z5MUr1O0CCMzvBRpGZu/AwhAOiZOWb+e3qpYk2CA" +
       "1AoXUSUtFuwG19NigFqigwOajEzNuyjq2pDkdVKM9qFHevA6xRRgjeWKQBJG" +
       "JnrR+EpgpakeK7ns89Hyizdfpy3R/MQHPEeorCL/FUDU4CHqolFqUogDQThu" +
       "Xmi7NOmxTX5CAHmiB1ngPPz9o5ef2XDwKYEzLQfOivBaKrM+eWd4/PPTW+cu" +
       "KEI2ygzdUtD4GZLzKOu0Z1qSBmSYSekVcTKQmjzY9cRVN+6hH/pJeQcplXU1" +
       "EQc/qpH1uKGo1FxMNWpKjEY6yFiqRVr5fAcZA88hRaNidEU0alHWQYpVPlSq" +
       "8++goigsgSoqh2dFi+qpZ0Ni/fw5aRBCquGfNMH/HCL+mhEwogX79TgNSrKk" +
       "KZoe7DR1lN8KQsYJg277g2Hw+nVBS0+Y4IJB3YwFJfCDfmpPYGRKgyyoxMH8" +
       "QctQgsukmCIvT2AUddEYJCFzCLKtORRAvzO+8R2TqIO6QZ8PzDPdmxxUiKsl" +
       "uhqhZp+8NbGo7ei+vmeE42Gw2NpjpAWYCAgmApwJnkqBiQBnIgBMBPIxQXw+" +
       "vvcEZEa4BRh1HaQHwBk3t3v10jWbmorAH43BYrDIWEBtyqhTrU4OSSX+Pnl/" +
       "beX6mW+ec8hPikOkVpJZQlKx7Cw0Y5DQ5HV2zI8LQwVzCkmjq5BgBTR1mUYg" +
       "j+UrKPYqZfoANXGckQmuFVJlDgM6mL/I5OSfHLxjcEPPDWf7iT+zduCWJZD2" +
       "kLwTM346szd7c0audas2Hvls//Zh3ckeGcUoVUOzKFGGJq93eNXTJ89rlB7q" +
       "e2y4mat9LGR3JkE0QuJs8O6RkZxaUokeZSkDgaO6GZdUnErpuJz1m/qgM8Ld" +
       "toY/TwC3qMBonQX/19vhyz9xdpKBcLJwc/QzjxS8kFzSbdzz5+c+OI+rO1Vz" +
       "qlzNQjdlLa48h4vV8oxW47jtSpNSwHvjjs6fbvto4yrus4AxK9eGzQhbIb+B" +
       "CUHNP3zq2tfeenPnS/60n/sYFPpEGPqlZFpIHCflBYSE3eY4/ECeVCFzoNc0" +
       "X6mBfypRRQqrFAPrP1Wzz3non5urhR+oMJJyozNHXsAZP20RufGZaz5v4Mv4" +
       "ZKzTjs4cNJH865yVF5qmNIR8JDe8UP+zJ6V7oIxA6raU9ZRn41Kug1Iu+RRo" +
       "2zglluSAKMmZSQADrTsRtiBglTjYZ8CueOd2rpE3NXf+TVSz03IQCLyJu4M/" +
       "6Xl17bPc+mWYEnAc9650BTykDpfrVQurfAl/Pvj/H/6jNXBAVI7aVrt8Nabr" +
       "l2EkgfO5BRrOTAGCw7Vvrbv7yANCAG999yDTTVtv+TKweaswqWiCZmX1IW4a" +
       "0QgJcRC0IHczC+3CKdrf3z/8293DGwVXtZklvQ061gde+e+zgTvePpyjUkBs" +
       "6ZJoZc9HLxe+jmGZaR0h0hU3Vz26pbaoHdJJBylLaMq1CdoRca8JXZyVCLvM" +
       "5bRXfMAtHJqGEd88sAIOzOeAs3KRLT1+XOJ6XshIkaJlsYtfFyczD0xpl+Ku" +
       "Ldi/uuKJ31n3/f2AUFQuh/W0aLt3lcmvx5/gDoubLEiH/nT0qUbY+1ER+eKT" +
       "EflrNgthU4lAl7AIfL5bNhWDQXC1aQOKqWtx5NfuSb6JbVChs/OHhkuvO345" +
       "67kbdsz6K/hXLylTLCjFEJw52mYXzSd73/rwhcr6fbwyFWOM2w6Ted7IPk5k" +
       "nBK4VaoQfDc5kucUh4cYzeM62f4/PaOn4Ydqp6zuefHCl3fdun1QOFKB/OGh" +
       "m/LFCjV80zv/5oGY1UXkSCke+t7g3runtl76Iad3yjlSNyez20Wwg0N77p74" +
       "MX9T6R/9ZEwvqZbtQ2yPpCawSPaCpq3UyRYOuhnzmYcwceJoSbcr0705zbWt" +
       "t5FwJ4pilpEUaoQVfYSXTplTfIvDeQjO4pbx42MA05aiSSqna4HCrFItJg4P" +
       "SxH0GI5F/YIuVbnqnMrVquoaxfKZmhMdr6IH0udnmMzlG/UZvrGM+6Oj6DfG" +
       "3/bub5pji0bT6uJYwwjNLH6fAVael9/dvKw8edM/pq68tH/NKLrWGR4f8i75" +
       "q2V7Dy+eI9/m50d04QFZR/tMopZMu5eblCVMLbMkzBLW59YTpkdwBjcw/352" +
       "2g6E20Ek5ESBuUEE0OqWyGho4RcF0NdnjWKPNCN399UWNxjvl9Y/MvnXF+/a" +
       "8SZvFI0kyZ1f+AYXFNj8RgSzLfehIdO4rnuoPnnLS59U9nzy+NGsNJLZIy+T" +
       "jBYntOZgPp/sPdQtkax+wDv/4PKrq9WDx3kGr5BkSLfWChOOmcmMjtrGLhnz" +
       "l98fmrTm+SLibyfl0EBE2iV+OCFj4VRArX44oSaNyy4XpXGwLHWcd6knJXy2" +
       "0nFgWBiqPvs4cavdad+a+zjheE52k56P1GOWEs5IidORpEEHgk6+0+YCttyC" +
       "4GY+tQHBLULIH5wSfdxrC3Xv6PWRj3QEfXzb06stT69cQ+zGaL698nzRE53c" +
       "CxQZUqEcXGvQWHBpZ9vib+DKZsQdhdVWIrg7maomi7/GHUyzayKr/uD31WIv" +
       "u1jeV6hYIoiKSokglq6SP8+ukvhVQbAuu+zhd01sy6kRWAXCYE+Bub0IdiMQ" +
       "axXKy/vyhUTBZHtngRUPINjmBOj2UxmgB+xYODD6AM1H6hGtmDNSnCNh3cU3" +
       "ebSAKh5H8LCjikdOpSoO2fIcGr0q8pF6RLOvKZxcJTKU7egrjXRwZl9g5Iwy" +
       "IxVhz32lCHv6K0SYOAs/PVJ0vVxg7lUEL6aj6+lC0fXaaKML4WEErmr4VIEN" +
       "3kBwyPGwP5xKD3vFdpNXRu9h+UhHqIaHc+nj/QL6+ADBO44+3j2V+njPFuq9" +
       "0esjH+mJdAeOUkQG+rSAPo4h+Jejj49PpT6O2UIdG70+8pGOkIy9qvgyvyp8" +
       "PMK+cFRx/BSqwlcq1hSfo1JFXtITDpW7uKdwmSsK6KMSQWlaH74xJ0MfYmKa" +
       "61ZgdVrCKYgYgP/TbWOf7lUOfzNW4xSPDo3RGDVr3/nFzs83bLzIj7fmJQN4" +
       "ZwIHJ1eREa3cj/Zuq6/Y+vaP+WGRkKIjKFVd7tJShI8BRkot/r4fv0U9bx4m" +
       "F+CUkbLOro4VXR0rr0qHZZ2jygkjqXJ15laN8G/aW5lZSuE10jcjtyDEw3Vx" +
       "gaUYGRf3dL53eThvLMB5slCVBo1IYeiw4aTqcMT/qoj9djn16fXpaa4CDc3D" +
       "/BPo7KGroFI8o6nH83d9vt8R8Iv8nTdt3RFZcf85qevmRQwO1LpxlkoHqJrl" +
       "t1paChSATAMOa+3IrB19UOcjLRCfFxaYW4DgXLBnjLIuKkVUfGmBiB2OKc87" +
       "afnNUUUdzs0GOWbY8swYvSrykXrE9WV6RV3q9rBDMxJM2J+r4orCdI3pW0dO" +
       "0qqbZsJgNNKWlKmBtzp8kSUILmOkFm9p4wZ4XVilgoIvVODee0xY11Uqabn7" +
       "Occcl5+U9MrIlHynWrxPm5L1cyfxEx15346qssk7rnxVvA9I/YxmXIiURROq" +
       "6r42dj2XGiaNKtyk48RNF2+ffd9jpGnkIGWkCCBK4usRdL2MNBSmY6SEf7qp" +
       "VoPM+ahgD4Bu7DWMTMiFDZgA3ZgynFO8mLA//3TjRRkpd/CgZIgHNwrKCij4" +
       "uNZIed5FJ5DHFtopMzOT+VzJiDguRCaO5EJpEvdreNyV/1gudeWcED+X65P3" +
       "71i6/Lqj8+8XPwOQVWn9elylIkTGiF8k8EXx2npm3tVSa5UumXt8/INjZ6eS" +
       "a41g2EkH01xd6TDEh4H+OtXzjtxqTr8qf23nxY//aVPpC1D0VxGfBBlgVfZb" +
       "kqSRgKy/KpT9NrVHMvnL+5a5dw5demb049ftrsD79smL3ye/tGv1i7dN2dng" +
       "JxXQbUDdoEn++uaKIa2LygNmL6lUrLYksAirKJKa8ap2PIaWhEderhdbnZXp" +
       "UfwRCURP9nvq7J/elKv6IDUX6QktgstUhkiFMyIs47n5TxiGh8AZsU2JsF0k" +
       "MLQG+G1faJlhpF7jj1UNnmkW5z2d+ob5Iz5d/397fDjTSCsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "LtVAm+oFgVH37Zhft5oEPI+tGaFzDEN7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("iF8ty6vyrKuLQzJMjGqDGXbKkKrKzZXbtQ2iOzUwDBTLKGBkqjwYoqw1R1hc" +
       "rXsu74wGkLjU2lU0qreng8lA77QFrVURtMTu0A2LasFwZbJiGMOVYUwTCK03" +
       "3Pgkpq+q0VAgFLnW6dfavU7ouIOUnkB82tfbWsRgIl3D+y6+ln1lmPBwSYtk" +
       "ZSrhbWiG1EaVeklHYMpbNaDGbLShx/zUbipmYhLGpKt3GkYDn8Vl27UqIc+K" +
       "NS6yZmEDBolFQBRWrJY00J71iqVYRiZtfFntQXQ4S1dh7E38hqeWK3Y8h2GR" +
       "B2W51C7ycVdFUVPjVWFheCyjgYxFupPm0Od7oNZQUE2syZuarFiLIliUh37Q" +
       "rjcDi6okChx21yW9Lg/Lsq3149l4wbVlB7chKBJJQixTiTa0KMTkfGpuBC3d" +
       "J/uk2BDd8ogQp0tcVvylvLCFmcupGwbjmFHTXnv1PqyY5Boh2twMGRuhFoTc" +
       "0tA7g4QIqnW7Non17rLREgKu3A86RWNAgTzTLamgbVu6nfpqVeKGtmVMa2lZ" +
       "hpxFjUhrMlxp1tX2asJiQavVeutbs+2x+25ve+yBfGvv6GT8j7CpF5/1+1hY" +
       "uCAugtAXpXB38jJ/ZT+qXz24vnqzfe2Hjv009tqwgPwQv6+zoa+I1omf1rMT" +
       "H4/c6jB9fhLw0+9/7nmZ/kzp3MGuazMs3AP8+m+Yyloxj3GyPWg0P5IiE6Dw" +
       "E4DDywe785fP2Ng/rZ29XDtbI9x6Q37viTOeZed39h4NC/dpSsgoomxmRxwz" +
       "xLcc2W3vsdv+4WIn34PZzScBq48dyPfYKyPf3km7Pnh4NIuw3SjcWjCX7/RZ" +
       "oVN0V46OdOUkmOP7kRsqMh5LipudBMoHqWTg6bBwOTsCZ7nAbxamsqW42e7v" +
       "3QvHMRVxd6JlD7qtn0DCwkO3OuORndl96Ib/3mz/LyJ9/vmLF17/PPcftoc5" +
       "D//TcQ9VuKBGpnn8ZN2x6/Our6h6ruN7tmec8h+1994eFh5/+WAJC3cAmImw" +
       "97YtHRoWHj2bLizclX8ep8KBzLeiAnMAeBy7FxZeczNsgAngcUwyLFw6jQnm" +
       "zz+P4w3Dwr07vLBwfntxHGUMRgco2SXjHvpP44fIJ62D1HUyo+wdSwoHUZMn" +
       "ycsv5ypHJMePsWez5v/cOjwTGG3/u3Vd+sLz/eG7v4d8ZnuMXjLFNM1GuUAV" +
       "7t6e6M8Hzc4VvvGWox2Odb731A/u/6V7njxMcvdvGd5F8DHeHrv5mXXccsP8" +
       "lHn6r17/L9/y2ed/P/+x7f8D0N1LFFI3AAA=");
}
