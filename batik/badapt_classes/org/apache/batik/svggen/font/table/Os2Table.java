package org.apache.batik.svggen.font.table;
public class Os2Table implements org.apache.batik.svggen.font.table.Table {
    private int version;
    private short xAvgCharWidth;
    private int usWeightClass;
    private int usWidthClass;
    private short fsType;
    private short ySubscriptXSize;
    private short ySubscriptYSize;
    private short ySubscriptXOffset;
    private short ySubscriptYOffset;
    private short ySuperscriptXSize;
    private short ySuperscriptYSize;
    private short ySuperscriptXOffset;
    private short ySuperscriptYOffset;
    private short yStrikeoutSize;
    private short yStrikeoutPosition;
    private short sFamilyClass;
    private org.apache.batik.svggen.font.table.Panose panose;
    private int ulUnicodeRange1;
    private int ulUnicodeRange2;
    private int ulUnicodeRange3;
    private int ulUnicodeRange4;
    private int achVendorID;
    private short fsSelection;
    private int usFirstCharIndex;
    private int usLastCharIndex;
    private short sTypoAscender;
    private short sTypoDescender;
    private short sTypoLineGap;
    private int usWinAscent;
    private int usWinDescent;
    private int ulCodePageRange1;
    private int ulCodePageRange2;
    protected Os2Table(org.apache.batik.svggen.font.table.DirectoryEntry de,
                       java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        raf.
          seek(
            de.
              getOffset(
                ));
        version =
          raf.
            readUnsignedShort(
              );
        xAvgCharWidth =
          raf.
            readShort(
              );
        usWeightClass =
          raf.
            readUnsignedShort(
              );
        usWidthClass =
          raf.
            readUnsignedShort(
              );
        fsType =
          raf.
            readShort(
              );
        ySubscriptXSize =
          raf.
            readShort(
              );
        ySubscriptYSize =
          raf.
            readShort(
              );
        ySubscriptXOffset =
          raf.
            readShort(
              );
        ySubscriptYOffset =
          raf.
            readShort(
              );
        ySuperscriptXSize =
          raf.
            readShort(
              );
        ySuperscriptYSize =
          raf.
            readShort(
              );
        ySuperscriptXOffset =
          raf.
            readShort(
              );
        ySuperscriptYOffset =
          raf.
            readShort(
              );
        yStrikeoutSize =
          raf.
            readShort(
              );
        yStrikeoutPosition =
          raf.
            readShort(
              );
        sFamilyClass =
          raf.
            readShort(
              );
        byte[] buf =
          new byte[10];
        raf.
          read(
            buf);
        panose =
          new org.apache.batik.svggen.font.table.Panose(
            buf);
        ulUnicodeRange1 =
          raf.
            readInt(
              );
        ulUnicodeRange2 =
          raf.
            readInt(
              );
        ulUnicodeRange3 =
          raf.
            readInt(
              );
        ulUnicodeRange4 =
          raf.
            readInt(
              );
        achVendorID =
          raf.
            readInt(
              );
        fsSelection =
          raf.
            readShort(
              );
        usFirstCharIndex =
          raf.
            readUnsignedShort(
              );
        usLastCharIndex =
          raf.
            readUnsignedShort(
              );
        sTypoAscender =
          raf.
            readShort(
              );
        sTypoDescender =
          raf.
            readShort(
              );
        sTypoLineGap =
          raf.
            readShort(
              );
        usWinAscent =
          raf.
            readUnsignedShort(
              );
        usWinDescent =
          raf.
            readUnsignedShort(
              );
        ulCodePageRange1 =
          raf.
            readInt(
              );
        ulCodePageRange2 =
          raf.
            readInt(
              );
    }
    public int getVersion() { return version; }
    public short getAvgCharWidth() { return xAvgCharWidth; }
    public int getWeightClass() { return usWeightClass; }
    public int getWidthClass() { return usWidthClass; }
    public short getLicenseType() { return fsType; }
    public short getSubscriptXSize() { return ySubscriptXSize; }
    public short getSubscriptYSize() { return ySubscriptYSize; }
    public short getSubscriptXOffset() { return ySubscriptXOffset;
    }
    public short getSubscriptYOffset() { return ySubscriptYOffset;
    }
    public short getSuperscriptXSize() { return ySuperscriptXSize;
    }
    public short getSuperscriptYSize() { return ySuperscriptYSize;
    }
    public short getSuperscriptXOffset() { return ySuperscriptXOffset;
    }
    public short getSuperscriptYOffset() { return ySuperscriptYOffset;
    }
    public short getStrikeoutSize() { return yStrikeoutSize; }
    public short getStrikeoutPosition() { return yStrikeoutPosition;
    }
    public short getFamilyClass() { return sFamilyClass; }
    public org.apache.batik.svggen.font.table.Panose getPanose() {
        return panose;
    }
    public int getUnicodeRange1() { return ulUnicodeRange1; }
    public int getUnicodeRange2() { return ulUnicodeRange2; }
    public int getUnicodeRange3() { return ulUnicodeRange3; }
    public int getUnicodeRange4() { return ulUnicodeRange4; }
    public int getVendorID() { return achVendorID; }
    public short getSelection() { return fsSelection; }
    public int getFirstCharIndex() { return usFirstCharIndex; }
    public int getLastCharIndex() { return usLastCharIndex; }
    public short getTypoAscender() { return sTypoAscender; }
    public short getTypoDescender() { return sTypoDescender; }
    public short getTypoLineGap() { return sTypoLineGap; }
    public int getWinAscent() { return usWinAscent; }
    public int getWinDescent() { return usWinDescent; }
    public int getCodePageRange1() { return ulCodePageRange1; }
    public int getCodePageRange2() { return ulCodePageRange2; }
    public int getType() { return OS_2; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVcDXQcxX2fO9mSLH/ow/gDf8iyLRv8dYe/ICBDYssfiJ4t" +
                                                              "Pds4WA7Iq72RtPZpd9mdk08mboCEYmjhYWIDzovdpM+EQDAOLX6BBnim1CUu" +
                                                              "Ia8mECApEJryoAUSaAtNSij9/2fnbu/2bkbs0dN7N7famf/M7/eb//5ndmdu" +
                                                              "H3yPjHYd0kxNFmPDNnVj60zWpTkuTbanNNfdCud69LurtP+85u1NF0dJdTeZ" +
                                                              "MKC5G3XNpesNmkq63WSmYbpMM3XqbqI0iRZdDnWpM6QxwzK7ySTD7Ri0U4Zu" +
                                                              "sI1WkmKBbZqTII0aY47Rm2a0Q1TAyMwEIIlzJPHVwey2BBmnW/awX3xqXvH2" +
                                                              "vBwsOei35TLSkNilDWnxNDNS8YThsraMQxbZVmq4P2WxGM2w2K7USiHBFYmV" +
                                                              "RRLM+WH9Rx/fMdDAJZiomabFOD13M3Wt1BBNJki9f3Zdig6615I/JVUJMjav" +
                                                              "MCOtiWyjcWg0Do1m2fqlAP14aqYH2y1Oh2VrqrZ1BMTI7MJKbM3RBkU1XRwz" +
                                                              "1FDLBHduDGxbcmw9lkUUDy2KH7z7moa/riL13aTeMLcgHB1AMGikGwSlg73U" +
                                                              "cVcnkzTZTRpN6Owt1DG0lLFX9HSTa/SbGktD92dlwZNpmzq8TV8r6Efg5qR1" +
                                                              "Zjk5en3cocR/o/tSWj9wnexz9Riux/NAsM4AYE6fBn4nTEbtNswkI7OCFjmO" +
                                                              "rX8CBcC0ZpCyASvX1ChTgxOkyXORlGb2x7eA65n9UHS0BQ7oMDJNWilqbWv6" +
                                                              "bq2f9qBHBsp1eVlQagwXAk0YmRQsxmuCXpoW6KW8/nlv06rbrzMvN6MkApiT" +
                                                              "VE8h/rFg1Bww2kz7qEPhOvAMxy1M3KVNfmJ/lBAoPClQ2Cvzo69+8KXFzad+" +
                                                              "4pWZXqJMZ+8uqrMe/VjvhLMz2hdcXIUwam3LNbDzC5jzq6xL5LRlbIgwk3M1" +
                                                              "YmYsm3lq8z9sv/4B+k6U1HWQat1KpQfBjxp1a9A2UtTZQE3qaIwmO8gYaibb" +
                                                              "eX4HqYHjhGFS72xnX59LWQcZleKnqi3+P0jUB1WgRHVwbJh9VvbY1tgAP87Y" +
                                                              "hJAa+JD58JlBvD/+zcg18QFrkMY1XTMN04p3ORbyd+MQcXpB24F4L3j97rhr" +
                                                              "pR1wwbjl9Mc18IMBms0Y6u+nZrzPwgil9aZovNNdthUPYuhndsVbyCDHiXsi" +
                                                              "EZB/RvDiT8F1c7mVSlKnRz+YXrPug4d6nvUcCy8GoQ4ji6DRmNdojDca8xqN" +
                                                              "YaMx3mgs2yiJRHhb52DjXjdDJ+2Gyx3i7bgFW66+Yuf+OVXgX/aeUaAwFp1T" +
                                                              "MO60+zEhG8h79BNN4/fOfm3p01EyKkGaNJ2ltRQOI6udfghQ+m5xDY/rhRHJ" +
                                                              "Hxha8gYGHNEcS6dJiEuyAULUUmsNUQfPM3JOXg3ZYQsv0Lh80CiJn5y6Z88N" +
                                                              "2752QZREC8cCbHI0hDE078IInovUrcEYUKre+pvf/ujEXfssPxoUDC7ZMbHI" +
                                                              "EjnMCXpDUJ4efWGLdrLniX2tXPYxEK2ZBlcXBMLmYBsFwaYtG7iRSy0Q7rOc" +
                                                              "QS2FWVmN69iAY+3xz3A3beTH54BbTMCrbzJ8viguR/6NuZNtTKd4bo1+FmDB" +
                                                              "B4ZLt9hHXv7Zvy3ncmfHkPq8wX8LZW15cQsra+IRqtF3260OpVDu1Xu6vnno" +
                                                              "vZt3cJ+FEnNLNdiKaTvEK+hCkPmmn1z7yuuvHXsh6vs5I2Nsx2JwadNkJscT" +
                                                              "s8h4BU9ocL4PCUJfCmpAx2m90gQXNfoMvOjw2vpj/bylJ9+9vcFzhRScyXrS" +
                                                              "4pEr8M+fu4Zc/+w1/93Mq4noOPT6svnFvHg+0a95teNow4gjc8PzMw8/ox2B" +
                                                              "kQGisWvspTzARrkMUc58KiNLP0NIWWs4FJ12GK5dZzhrOZW3aVixzZqZtAZX" +
                                                              "6xAV3fUQ5LlLrOTFLuDpCtRdRBlhPDFr3NG5LqNTG6lwuzZM5rn5l13hlZ03" +
                                                              "M+vR73jh/fHb3n/yAy5S4dQu38s2anab59iYzM9A9VOCYfFyzR2AcitObfpK" +
                                                              "Q+rUx1BjN9TISXU6EJgzBT4pSo+u+eVTT0/eebaKRNeTupSlJddr/PImY+C6" +
                                                              "ou4AxPSM/cUveT61pxaSBjzKkJwwhAtDMkUnsF9nlfaYdYM2432899Epj6y6" +
                                                              "7+hr3L9tr47p3L4Fh5mCeM5vEPyQ8sDPL3rxvgN37fGmGAvkcTRgN/V/OlO9" +
                                                              "N/7L74sk5xG0xPQnYN8df/Db09ove4fb+6EMrVszxUMjDAe+7bIHBj+Mzqk+" +
                                                              "HSU13aRBFxPybVoqjQGiGyahbnaWDpP2gvzCCaU3e2rLheoZwTCa12wwiPpD" +
                                                              "MhxjaTweH4ib47ALp8KnWcST5mDcjBB+0MlNzuPpQkyWZMNUje0YcNNGA0Fq" +
                                                              "rKJSMIIR08XeKBjNccTcku51YeQ1BiHQDomp6LKunfr+1q5/9Xzg3BIGXrlJ" +
                                                              "34/ftu2lXT/lYbwWx/atWd55IzfMAfLGkAYP9qfwF4HP/+IH4eIJb0rX1C7m" +
                                                              "lS25iSX6sNIZAwTi+5pe3/3tt497BIKeFyhM9x+89dPY7Qe9wOzdncwtukHI" +
                                                              "t/HuUDw6mGxHdLNVrXCL9W+d2Pfj7++72UPVVDjXXge3ksd/8clPY/f8+kyJ" +
                                                              "KV6VIe4w84MmjK6FfeMRWntL/eN3NFWth1lBB6lNm8a1adqRLPTQGjfdm9dZ" +
                                                              "/l2P77WCGnYMI5GF0AfemI7pZZh0eS64WhrHOgr9vgU+s4SLzpL4veH5PSab" +
                                                              "ix1cZs0A8uqh/vYBzfmykWQD3HKb6Br82pF3DPd/oyECO0V64r80SHJXSJLN" +
                                                              "gmiWcCmSaSVJmTWQTLtfpkb/AOP3m3jyqgDaoZBoZ8JntmhvtgTtV5VoZdaM" +
                                                              "jAO02BlSsPtCgj0XPnNEc3MkYL+uBCuzZqS6z816vxmA+Y2QMLHyuaKhuRKY" +
                                                              "typhyqxh9jKM4Vd3DJtdtQWmbqXw/nkZeFtFi60SvAeUeGXWBXi3y/DeGRIv" +
                                                              "tjJPtDhPgvceJV6ZNSONefp6TyxKIT5cBuL5os35EsR/qUQssy5AvF2O+Dtl" +
                                                              "ID5PtHmeBPH3lIhl1h5iGGxG8OL7ykB8vmjzfAni40rEMusAYqkfPxQSMfbl" +
                                                              "AtHmAgniR5SIZdZwH1WgsdwvTpaBeaFodaEE84+VmGXWAcwKX348JGYcmRaJ" +
                                                              "VhdJMP+dErPMmpEJw/gMeje10kzmFk+HhItBabFocLEE7hklXJk1TK19uF15" +
                                                              "j1aCkP8xJGScji0RjS6RQP4nJWSZNcwi3PXaoJEazs0igmDPhgQ7DT4x0VxM" +
                                                              "AvYlJViZNcwibM20XJp9mrHgMzxE6eIWAU4vlzGzjgtUcQmnXys5yaxhCE+n" +
                                                              "rjQNHe4uNsMtMl2Kp4MzuTfKwHuBaPECCd63lHhl1kV4l5XC+3YZeJeKFpdK" +
                                                              "8P5WiVdmXYR3eSm8vysD7zLR4jIJ3g+VeGXWRXhXlML7UUi8uJizXLS4XIL3" +
                                                              "j0q8MmuGD+sGtlEzaTkda0th/aSMG7wVorUVpbFGqpRYZdaAtc/dQsXjvBKx" +
                                                              "LjKqjKFvpWhtpQRrnRKrzJqRhrS73nBchjfdHWbSu3EOiBsZW4bjXiiavFAC" +
                                                              "uFEJWGaNjusmtBHwNpWB9yLR4kUSvFOVeGXWcLePd6TWalcH5/UehAbd4dwy" +
                                                              "3OELor0vSNDOUqKVWcNMiKNdSxVwW8qYVlwsGrxYAne+Eq7MGqcVCBeXpzdo" +
                                                              "dimw55URwi4RzV0iAbtECVZmDWEBn6SY3BNYKa+NlfHUp0201ibBukKJVWYt" +
                                                              "nvqYnh+UBLuyDKddJZpbJQHbpgQrs8YYlmqHgaxL65dPbiKrygB8qWjyUgng" +
                                                              "NUrAMutiwKVmN5F2BWAvq9S6QrWd7k0Zur+swP+qSWDLRR4cXnJ64QLe+Z9h" +
                                                              "ysv3IeAj85mybTT8cfmxGw8eTXbeuxQfl2PtOxkZwyx7SYoO0VRe27OxpoIl" +
                                                              "rY1845C/PvTqhDt/81hr/5owuxPwXPMI+w/w/1kZhyyUL0wEoTxz479P23rZ" +
                                                              "wM4QGw1mBVQKVnn/xgfPbJiv3xnlu6S8haui3VWFRm2FiwF1DmVpxyx8/D83" +
                                                              "5wj12O/48JUKR6BBr/YdEF06ckWhS9cpTHlJfzk4u8iJtVytyOvB5CpG6vop" +
                                                              "2+YtbfErwb8Ito901aoXWfHEBhvPR7bm2DRiXgt8DMHGCC+EzFRBdpciD3eX" +
                                                              "RShMbkCI/BUQPqT5avRVQA3uFjiUDApKg+HVkJkqGO9R5A1j4sBkBNQIrpT4" +
                                                              "YriVEmMGJ+H9XRteDJmpgvA3FHl/hsnXYB6JYhQuxPhaXF+pywQnb2lBKB1e" +
                                                              "C5mpgu8BRd43MfkLzzESBkxN/KXqvKvktkqJgUssw4LRcHgxZKYKwkcVed/B" +
                                                              "5DAjjSBGieUkX49vVVKPfYLUvvB6yEwVnH+gyDuOyfcCemwvoceIaxLl6oGL" +
                                                              "FzcIUjeE10NmquD8qCLvbzH5G0YmFvhH3gN5X5FHKqnITYLWTeEVkZkqWJ9W" +
                                                              "5D2DyamAIttLKvJUJRW5RdC6JbwiMlMF6+cVeS9g8lxWkRLLeb4iP6ukIrcJ" +
                                                              "WreFV0RmqmD9uiLvDUx+WaRIqTjyq0opgstzBwStA+EVkZkqWL+ryPstJm8x" +
                                                              "MingIyWvmxEfyX8eTQ4JYofCayIzVfD+gyLvY0z+q0iT0rHkw0ppgo8oDgti" +
                                                              "h8NrIjOV845WK/JqMYkw0oCaFC2n5uSIRislBy65HhGcjoSXQ2aqoDxRkTcJ" +
                                                              "kwmMnJMvR8FyrS9JfSWn798VvL4bXhKZqYJ2iyJvDibTvel7cDnYF2NGBcRo" +
                                                              "wrzp8LlXMLo3vBgyUwXhJYq8OCbnMzIGxPBXj//Z12FBpe5v0SnuF2TuD6+D" +
                                                              "zFTB9RJF3ipMVnpho3iF2pfjwkrKcVxwOh5eDpmpgvIGRV4HJmuK5VgWkEP1" +
                                                              "dPhzy/Gw4PRweDlkpgrKWxV5uPs32lksx/KAHCNuYv48cpwUnE6Gl0NmqqCs" +
                                                              "KfJ0TL5SLMeKgBxXV0oO3HbzmOD0WHg5ZKYKyqYiD42jBiNj+fPjvM0BvhIj" +
                                                              "bvwud2jFR6ZPCDpPhFdCZqpge50ibx8mQ4yMw9lGwd4DX4o9lXKKFvg8Jfg8" +
                                                              "FV4KmamC7n5F3q2YfN17DlRia4Ovx4g7wj9PzDgtSJ0Or4fMVMH5kCLvbkzu" +
                                                              "8GJG8c4JX44DlVxqOSM4nQkvh8xUQfmvFHnHMDniLbUU7czw1ThayZu25wSl" +
                                                              "58KrITNVMD6hyHsYkwc85yje+eHL8YNK3qGcFZzOhpdDZqqg/Lgi70lMfuTd" +
                                                              "oQR3lvhiPFqpwIF3KC8KRi+GF0NmqiB8RpH3LCZ/740phRtXfClOV3IR7hXB" +
                                                              "55XwUshMFXR/och7GZOz2UW4gn0xvhbPV3J8fVUQejW8FjJTBd/fKPLexOQ1" +
                                                              "b3wtse3G1+P1SurxhiD1Rng9ZKYKzu8r8v4Dk3dK6BG8ZXu3UnrgGxzeFKTe" +
                                                              "DK+HzFTB+RNF3qeY/J6RGi+G0oAKf/j/UCHDSG32VSj4S/qpRe9b8t4RpD90" +
                                                              "tL52ytErX+J7hnLv8RmXILV96VQq/7feecfVtkP7DK7cOO+X3/xHs1U1jMwZ" +
                                                              "eWMUI6P5N2KvqvYs6xiZobJkZBR+5ZuMZ2SKxISRau8gv3wDDOLB8gCFf+eX" +
                                                              "m8hInV8OqvIO8otMZqQKiuDhFO5wuCWsgb+sAH9fH/N+X5/xdotNz+8qvhV7" +
                                                              "0kg9nDPJf80H7rniL9fK7o9Ke6/X6tFPHL1i03UfXHiv95oRPaXt3Yu1jE2Q" +
                                                              "Gu+NJ7xS3GM1W1pbtq7qyxd8POGHY+Zld6M1eoD9i2S678lkAyERG91rWuAF" +
                                                              "HG5r7j0crxxb9eRz+6ufj5LIDhLRGJm4o/hNBBk77ZCZOxLFP/Pepjn8zSBt" +
                                                              "C741fNnivt/9ir/rgXg/C58hL9+jv3Df1T+/c+qx5igZ20FGGzih569IWDts" +
                                                              "bqb6kNNNxhvuugxAhFoMLVXwG/IJeCVo+Nqt3BNYkHN87iy+pAacvfjn88Wv" +
                                                              "9qlLWXuos8ZKm0msZnyCjPXPeD0T2KaWtu2AgX9GdCWmPHd7BnsD/LEnsdG2" +
                                                              "s28XGDvD5oGA5uJD8LffVXxXJDZZtej/AC8qznd4TwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV8CbDrWHmm3+u96Y1ulqbTNN1NszSCJ9uSbJkGgmVZtmVJ" +
       "lmVblj2ERrtka7N2O2kC1LBkYxLSMDAVusIUTALFmhoyyUxIQRISmAA1ZCAT" +
       "mGFLDRmyMECqQlLDJBnJ9n2+9757b9/33p1bpWNd/Wf5vnP+85//6OicD363" +
       "cF3gFwDPtZa65YYX1DS8MLOQC+HSU4MLJIWwoh+oSsMSg2CYPXtUfvCjt//w" +
       "R79o3HG+cP20cJfoOG4ohqbrBJwauFasKlTh9t3TpqXaQVi4g5qJsQhGoWmB" +
       "lBmEj1CFp+xLGhYeovYggBkEMIMAriGA9V2sLNGtqhPZjTyF6ITBovDawjmq" +
       "cL0n5/DCwgMHM/FEX7S32bBrBlkON+b/8xmpdeLUL9x/kfuG8yWE3w6Aj//r" +
       "V9/xG9cUbp8WbjedQQ5HzkCEWSHTwi22akuqH9QVRVWmhac6qqoMVN8ULXO1" +
       "xj0t3BmYuiOGka9erKT8YeSp/rrMXc3dIufc/EgOXf8iPc1ULWXvv+s0S9Qz" +
       "rs/Ycd0wJPLnGcGbzQyYr4myupfk2rnpKGHhOYdTXOT4UDeLkCW9wVZDw71Y" +
       "1LWOmD0o3LlpO0t0dHAQ+qajZ1Gvc6OslLBwz7GZ5nXtifJc1NVHw8Ldh+Ox" +
       "G1EW66Z1ReRJwsLTD0db55S10j2HWmlf+3yXedlbf9JpO+fXmBVVtnL8N2aJ" +
       "7juUiFM11VcdWd0kvOVF1DvEZ3ziLecLhSzy0w9F3sT5Dz/1g1e++L5PfmYT" +
       "58eOiNOTZqocPiq/V7rti/c2Hq5dk8O40XMDM2/8A8zX6s9uJY+kXtbznnEx" +
       "x1x4YU/4Se4PJ6/7gPrX5ws3dwrXy64V2ZkePVV2bc+0VL+lOqovhqrSKdyk" +
       "OkpjLe8UbsjuKdNRN097mhaoYadwrbV+dL27/j+rIi3LIq+iG7J709HcvXtP" +
       "DI31feoVCoUbsqvw/Oy6t7D5W/+GhVeDhmuroCiLjum4IOu7Of8AVJ1QyurW" +
       "AKVM6+dg4EZ+poKg6+ugmOmBoe4JYl1XHVDL6gYMRclSwV5QHuY3F3I98/6/" +
       "l5DmHO9Izp3Lqv/ew53fyvpN27UU1X9UfjzCmj/48KN/fP5iZ9jWTlgAskIv" +
       "bAq9sC70wqbQC3mhF9aFXtgrtHDu3Lqsp+WFb5o5a6R51t0zQ3jLw4OfIF/z" +
       "lgevyfTLS67NajiPCh5vjxs7A9FZm0E509LCJ9+ZvJ7/6eL5wvmDhjUHnD26" +
       "OU/O5ubwotl76HCHOirf29/8nR9+5B2PubuudcBSb3v8pSnzHvvg4ar1XVlV" +
       "Mhu4y/5F94sff/QTjz10vnBtZgYy0xeKmapmVuW+w2Uc6LmP7FnBnMt1GWHN" +
       "9W3RykV7puvm0PDdZPdk3ea3re+fmtXxbbkqPyO7fnyr2+vfXHqXl4dP2+hI" +
       "3miHWKyt7MsH3rv/7At/Ca2re88g375viBuo4SP7jECe2e3r7v7UnQ4MfVXN" +
       "4n3tnewvv/27b/4XawXIYjz3qAIfysNG1vmzJsyq+Y2fWXzlG19/75fO75Qm" +
       "LNzk+W6Y9RNVSS/yzEWFW0/gmRX4/B2kzI5YWQ654jw0cmxXMTUz1+BcUf/v" +
       "7c8rffxv3nrHRhWs7MmeJr34yTPYPX8WVnjdH7/67+9bZ3NOzsexXbXtom2M" +
       "4127nOu+Ly5zHOnr/+TZ7/oj8d2Zmc1MW2Cu1LW1Or+uhvNr5k8PC6VT9E/c" +
       "9NVcaZdNJ/SXeynvXpdpuhc40VFcuy5nJiYgMou5VglwHe1F6/BCXu/bLrtN" +
       "fNde4k6vmcqql1NZp0Py4DnB/m53sGfvc3MelX/xS9+/lf/+7/5gXUkH/aT9" +
       "WkaL3iMbxc6D+9Ms+2cetjFtMTCyePAnmVfdYX3yR1mO0yzHNamen1m59IBO" +
       "bmNfd8NXP/X7z3jNF68pnCcKN1uuqBDiunsXbsr6lRoYmYFMvR9/5Uankhuz" +
       "4I78Li1crJjCumIK6UYX717/99wM4MPHWzYid3N2xuHu/9OzpDf8+T9cUglr" +
       "m3bE6H4o/RT84K/c03jFX6/T74xLnvq+9FLLn7mEu7TlD9h/d/7B6z99vnDD" +
       "tHCHvPU3edGK8i47zXysYM8JzXzSA/KD/tLGOXjkovG897Bh21fsYbO2G3Gy" +
       "+zx2fn/zIUt2S17Ld2fXfdseft9hS3ausL5prpM8sA4fyoMX7BmOGzzfjDNn" +
       "Yms2/jn7O5dd/5RfeWb5g83Qf2dj63/cf9EB8bLB8IY4c3/zljmxeVnftDNr" +
       "GG+dL/CxO78x/5XvfGjjWB1uy0OR1bc8/rP/fOGtj5/f584+9xKPcn+ajUu7" +
       "rqxb84DMe8cDJ5WyTkH8r4889p9+/bE3b1DdedA5a2Zzjw/96T9+7sI7v/nZ" +
       "I3yCazLHezNs5CGaB8SmTh85tqu88mBD3p9dz9k25HOOacjxMQ2Z33bWhMmw" +
       "cGtaj/WGIfpjUwmNdVx6Ww35Tz/Mpn2G6x/GK1wm3vu2mPewH4VXPBXeKBir" +
       "pm6Ea78+f8gegiZdJrRnZ9cDW2gPHAPNOA20WzJoeSUei8y8TGTPyq4Ht8ge" +
       "PAaZexpk12vrGVD+36sOYfIuE1OO47lbTM89BlN8Gky3LweRFMi+6YXCIBuc" +
       "jwKXXAG4h7bgHjoG3GOXCW5yHLjXXia4HNDztuCedwy4f3kacE/dV3ObqdtR" +
       "8N54BfCev4X3/GPg/dxlwpscD+/nrwDeC7bwXnAMvLedFp6XDUMna94vXwG8" +
       "F27hvfAYeO+6bHjH6t6/uUx4eYM+vIX38DHwfvU08O46UHvHN+97rgDgi7YA" +
       "X3QMwF+7bIAn6N+vXybAfGQAtgCBYwB++DQAb1vmr8bmqhuFx7XuRy4TW25N" +
       "XrzF9uJjsH38NNju3GFj981ID+P7zcvElzsoL9nie8kx+H7nVCNsQIi2aS0v" +
       "jrCHkX3iMpHdk10XtsguHIPs9081wnqi4wbq3vTu4VPMKtl1ikME/uAK/EBw" +
       "SwA8hsDnTjXiRdbIMWVXUbPprK6W8seH/ZfPXwG44hZc8Rhw//UKwJWPAvel" +
       "KwBX2oIrHQPuq1cADjoK3H+/AnDlLbjyMeC+dQXg4KPA/fllgstf70JbcNAx" +
       "4L5zGnBPyfoHrzqK63fwo4D95RVMMuAtMPgYYN87FTAtGKjbF0xHmZnvX8Hg" +
       "gWyBIccA++FpgN0RBYTpB2E+Yes4yuZV0+Fq+/srULbKFl3lGHT/eDplCyjx" +
       "ScD90xWAq27BVY8Gd+7a04C7NZ8CufVAzhRu83LnUKueu+4KWhXdQkOPgfaU" +
       "U7kEa2i4egK2W65gyK1tsdWOwXbn6YbcHFu+VtQSvaOQ3XUF1uOlW2QvPQbZ" +
       "s07VSfPptrNu0PAITTt3zxW8B3hkC+yRY4Ddf6oqWwPbNOeRyB64AkV72RbZ" +
       "y45B9oLTmQ+rkQ0FrKgfP8qfe+EVoHv5Ft3Lj0F34UrQHTXMnwOfFN06t/Tc" +
       "ubBwXflC9UIxT4UcXf41ueMWSZYpZzfBerU+S6WZjmjtgXrmzJIf2nubyW9e" +
       "Xz40s6p7nt4d63fi+SvcC5sl70P2jjw13sAv3LbLjHId/ZGf+5+/+Ll/9dxv" +
       "nC+cIwvXxflL49TfXyIT5R8UvOmDb3/2Ux7/5s+tF3mySuVf97zv5cuz5+rH" +
       "sM5ltTx4aR48skf1npzqYL1Wmptxer0ooyoX2R56L3it5V4F2/CZf9aGg059" +
       "74/iZVzoy6lQ1no1e0C1QTcBdVxDzSXFxagyUcFOA8MnQaCZJByySgCP69XO" +
       "olrmQnbqKTVbmRdRW3IbzYk9MybjDr5yY8WjgWYfr/cooYJhjmmXGqOoI6J2" +
       "s1H3mqS/dOujgVgPmYE5q4FlzZEisCzNpaCoMFWmqom2BtJVUJVAEHEUW4na" +
       "0JKdtSdKcZ4yhM3ijMPPKsXV2BvOo6EkOgyjKY1IqdSoyA9ZAEWiEkMUFVIZ" +
       "qlO620BakMB4asDY80UFGg/sieTRNCQspEWnaHJTBXfGHl3pp8mqW10OhniV" +
       "M4sjeBoFndJ4bncxaboYdjpFcQJXObssFvulYX1JJ81Ox1qRbJtP1GUZw2xn" +
       "DIqJAKULIW6XYywJeqoJIUNqMGdMCx87KYMzA3QyNAJfpPupNOXtBcyWx2mL" +
       "LiflbnU0MNsYMbF5jqNoYNyucSmo0QpeJ6ema4sS0cNLEA2NwxKGMeTcrGnQ" +
       "VDH1SqWEdECSH5F0pqR0oxea4+VMHutF3C3ZZW1h1dkSLC4m7fKy1DPKvL/w" +
       "pyWMHnaqNNmVaIjD5qOSwCWrEoFTWFuJ8FYqyXZSs+ajEb4sd9vVVdV2RdA3" +
       "qRIkDlWakvU2VqrTLXPeSgaWXoVGMi8789VwOuQ8ptJLwhLeKloUIdTag6EI" +
       "DqTWPMRrZcVKpoxnrxbokEf9SlPTkQVXms7miOpAsitzoAuGg/Gsljhquqpx" +
       "ZpSCTD2g4fqkWdEwB3aGTSlkgmTeqfYaxMzu+QLawORGceo1lvVBLJQaxlBP" +
       "e/Ol0OOsllROq2q9gji1UXtQxPpVl8ZJZmxaC2kcV6RFWastsDYWeCWVt/qi" +
       "ngj1eXFic/0gtaOG4LnjSneMgo4VFyu+5K/omKnQ87pnDvkmaoA+oZewJCnP" +
       "V9VFkzV6cZ1OlyUa6vKMZpOghdVdtmH1y4145VZqANoViJWoALA3ngoLkp4C" +
       "aLTwaRXkZ7FB0auyochCZ5SINkQxEr5qILPVopJSCMVZUkdP5hBdmtiTwIas" +
       "BbqqBTEIY8C8Miq1x30xLHW9vobNUq8k1urlUTic9pvQQuwkdg/VJ6IpSaoA" +
       "tzM1mBktYlAtp46A1KhxX55aatdZmBDAFmcjrDTWuUylJdKo8bE0KYV6nUWr" +
       "E4OsiwCJIyhpYTEOAitZL6F9wp/Tk5IwpJki7EE9TloqAN2XBQ8rwwRMQbNa" +
       "1Td8jysliTSzarRcQjs0ZgfFSSUCnKm/YhPdtGri1I0ZRgmNETuJDEcJeGnZ" +
       "wNumEJjNKQZyMW4OUaIkV21+YHUdbgVMBJ+NdFipOPFIbizRltuHZ2YF52xG" +
       "cWe4LKLpgpmIdArZelBemiTXNiSkjM+EmYKTQLm1TCGzKunEuFIBJpEG9HhB" +
       "F0BRHYn1hPBKQ7pXKQKrptFCjWoNYxgY1HqaDXnFUnPZnbdEhixbIdfvdSqR" +
       "oulGH7CRFJ+AvsG1yXZqiFmVt9pMUx5UFNJsRsv6iBqN7IAZ9TWWhsieoEPT" +
       "ST+Ii5SBFhsm6SDLyhRFmXIVKfenXLOByg2p3SkaeLNYRTsdx41HvtycjLq+" +
       "CnixBkazpqAFAZu6I7xRndJZ5ObMoTOlxUckrGrjFqX4lGMK5VBgJ2mzW55i" +
       "lixgNGVPsIBIxEnYqprcYFnsV/2e3B+UiTFvM5WaWZ8AULqC6pCkDtsIjElD" +
       "uuFLKxKNTT3iwAoTTZlw2FVgyS0BhI1jGDylwprRFuLqNF5Cjmxr7Tm7QBMB" +
       "pabjEiL3M4sHdLhFSEDlSrHn8XhUEqJK7GSspiEkkwDRdBiKUcyuOIybXcBo" +
       "zFnbdkqr6jKK4rYQGJU4QDplJkjLZCIqzJwM5GGAGjA2qrkyBbONEak1bK+e" +
       "lu1aUe8LjObScW+WlGNvBkpLi6wBtVgmVgY3kJeCP4C9po/SgBbBUxkEkhJY" +
       "g+gF7Lg9dlgJYoeI2zpQFGtIqDJuAuszGWVXdIKCblrG5v2WGYzjwBuu6lzW" +
       "A0YygnZNhmKLTGc8DmCCLJVbXUSZrgy/Nx1DIm+mq+liGtanQiWt85A26iOU" +
       "Rfm9IUFFuNcIOYXDLIPFCR9iWgi1YIatipVEqymN+A5ilSDDmhYhGoi5KjQz" +
       "QK0tQQ64rC+RAaz0IwgNyqIjSkjNnKzoWr3G9xoTjViuuHJdNsOepHndPuCP" +
       "0hI2Y2rDzkAYVZqkvsKGsDdwgQhQ+eGwCKqqJHY5Rh1G3sAiFcUH2Y49ARoV" +
       "N4LrKTugQXkUq8NKyUvFATZbdedkkhj1EKfnIycgao6liRNlQpdhqIzWak1v" +
       "VllWqoDhQ1Qt9OGqB1EwYSB2Q6WRuMku+2iAsxTkp7HOQFWtZbfq8VwecjoD" +
       "8mDP6tUYsEpV4WCOpK1iyvadCYMqGohLxZobq7AmAZUm7fPBKh3RM7yuAlWp" +
       "08ZmAL1azIH2YJSNVRxGpOxS4t3FLGuz1lI0JEcc4x5b1uNVoyGOILXsU4bq" +
       "TpNhQyyVk8RkPZw20pk4TNQ2bEpwtU55aNcZy4MhYuPyDMOAIm0xq4j1+vPl" +
       "eEozo5lanMgM06oXiYXfJQd0p8MVUUHtZtUty0N5HiGlidovYWa7j2debYXq" +
       "Ro7mA6UFAtaElQ5hnZbgWySUGZkwKlvCELQmUjJOQTEcKwjSWWl0XaNa8/qE" +
       "rS20hIDbLAh02rDaIaWin415VdsalBFzIFQCpjOtJ0MTQDwVAqEwhGtVrNNV" +
       "iaVB11IArSnspNpXa0lvpThyEkbzdicE29EITyp2K20rFMP7QoOqjQGlzGqz" +
       "KgBUyyOW5zPTKegqNA8UEJUtdgJqKDBfkl2+wndUOEFh2p51K4Sm0tzYCSlQ" +
       "ZSCGGIdGycKwisXYqFgSlQVHscN+a6Ypdk2ZglaZrVbHjZYzoTtIiyjWNdXu" +
       "VL3p1Ciqgwo8Nvx2T/drsT4CAnhArTwKjtU2wg5EyUxL8jQo1rMR1ADjCbbS" +
       "7OV83MehdleqYD5a9ggIZxXQXTYbvSJfgX20OGiTwoCkGN02x3LDHogDnrSH" +
       "4/6QCjVvLoH1HgvZ0Gy50HHRnWLuFCWd0DbiUB+GPMK7U0WkZ/VesYxZg4AN" +
       "G/qsKLBOZuQhej6hgAhrZD12Mais0FIlTu06MCn3aaq9jMSuEXHdSbj0jOUi" +
       "NWqzLg3zCoSToRL2x7a0EBLQmU9VIiTMSnEQ19WR2hLGmGBCSxBXW1wnDmck" +
       "G+IGq8eySvKVKTPoMarmVYbLtNsZIjIWUYgbQEgz4MDFqB8ES6QeE+UegIdW" +
       "B0fYsG2rGNuGrI5hlQzEbLXSFtqjqss5hsb2bKXVHRMu+k06CuqTxVxj0/6A" +
       "1iSrniWs647JIYPOVJkm7cw/CJQkHnoipoqEq4jNJgoDvJ3hrctJV4BglGxN" +
       "ZJsTSd5QSJoFlKbP0nbm+WdzC1qdqaXifGUTWRc1OiGWubWZ/W42q8bcEsh5" +
       "adgt1SKihMxKYjYGoCnZGsgzs8jNBhWuz8IOOR5MGTkxIVYQXbIproKiqds4" +
       "a+j9Kj6E0yKf0vV4YpG8uY4n0eWiQHo122/r9CptVtTOuD6CY2vVWs30cCT3" +
       "bUdYBshSTI1GE3D8WZ9pq3DEBHRIW+WuB9OraKh1k3aEiWyz0VAqkNXO6nDO" +
       "wxYiNABoMlVJtUt4ShdlkbHJK7Yw4SB1YKPxMsCrK4qDZx0S0gE+b1NOMASL" +
       "pqqjkYlGpLkSqAEsdDJPqbhAaTtq4UDQCq3mShzOFbEYGqA4oFvVhHf9Ee9J" +
       "RGvhcZNMD+uhDCr9QJjFWDelZt3FrEvE3tgIvT7nO1zXX5ELzvAHVcjBZCPr" +
       "b+2xNIigZs/EgukYlmaCaYoxUW9ERJMcZ+7MLArsEGsnjDfGatnsD56PBjHR" +
       "W2OWKZVVKsOxaMltBBypRl1SYCVZQr0m5frFeMDgvdGiy49lhja7jDJI+WSM" +
       "Lia8lQQtP53UHRVoLqp0ayHzDUwVvJWSTXPtBEFGXGLC3IovmnUpbDb4qY2P" +
       "m5hTGUwgjJl0RYCxtPbIK5aLJVPConmX5MeT0IkXE8cARhgVLfGuopBTTyL7" +
       "bcnT+36ATiaWvWjrYkpVEIWVzK6/1DF0MZ4tR7qjMyO/TkehmXQzZwchyti4" +
       "Hi9qg0rfHyvVeXEa+UCQsMBiMMYpjoNlwSErcJ9SgWnNWAYx1FHrMxSxl9Jw" +
       "iMqanbYSVB0KkhqlfS0zZ2EvnU+TZVodTNzM7HBqudpLPbdj+ZMSCiMNkI2H" +
       "CwMPQbRk+CDiJlHKJgJLd4AETMDSfGoslyOqmDTdYbqCqzW2DPnThIb7raRk" +
       "Y3y/yzsOmOoaK5FmDKWOFVUGqCFGJsSPiWxySpgJUcJt3kuXKQriKIQks1K5" +
       "B2adctTlsum4D06UJlGsyPOxMajJ3rBtkdpqDkeoSYb8Mlz2YgxpeK1K7Hpl" +
       "YBJKWtNPJLQTurViSXSFsdZuYkbMclXJLuOcKeghitPtVqMBNFcEhymebOKQ" +
       "KnADg5bmjQ6IjfrsYoiIMcf361BEzMwR");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "f9wG64clXAAA");
}
