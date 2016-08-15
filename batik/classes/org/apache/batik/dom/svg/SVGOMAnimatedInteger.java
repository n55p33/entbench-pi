package org.apache.batik.dom.svg;
public class SVGOMAnimatedInteger extends org.apache.batik.dom.svg.AbstractSVGAnimatedValue implements org.w3c.dom.svg.SVGAnimatedInteger {
    protected int defaultValue;
    protected boolean valid;
    protected int baseVal;
    protected int animVal;
    protected boolean changing;
    public SVGOMAnimatedInteger(org.apache.batik.dom.svg.AbstractElement elt,
                                java.lang.String ns,
                                java.lang.String ln,
                                int val) { super(elt, ns, ln);
                                           defaultValue = val; }
    public int getBaseVal() { if (!valid) { update(); }
                              return baseVal; }
    protected void update() { org.w3c.dom.Attr attr = element.getAttributeNodeNS(
                                                                namespaceURI,
                                                                localName);
                              if (attr == null) { baseVal = defaultValue;
                              }
                              else {
                                  baseVal =
                                    java.lang.Integer.
                                      parseInt(
                                        attr.
                                          getValue(
                                            ));
                              }
                              valid = true; }
    public void setBaseVal(int baseVal) throws org.w3c.dom.DOMException {
        try {
            this.
              baseVal =
              baseVal;
            valid =
              true;
            changing =
              true;
            element.
              setAttributeNS(
                namespaceURI,
                localName,
                java.lang.String.
                  valueOf(
                    baseVal));
        }
        finally {
            changing =
              false;
        }
    }
    public int getAnimVal() { if (hasAnimVal) { return animVal; }
                              if (!valid) { update(); }
                              return baseVal; }
    public org.apache.batik.anim.values.AnimatableValue getUnderlyingValue(org.apache.batik.dom.anim.AnimationTarget target) {
        return new org.apache.batik.anim.values.AnimatableIntegerValue(
          target,
          getBaseVal(
            ));
    }
    protected void updateAnimatedValue(org.apache.batik.anim.values.AnimatableValue val) {
        if (val ==
              null) {
            hasAnimVal =
              false;
        }
        else {
            hasAnimVal =
              true;
            this.
              animVal =
              ((org.apache.batik.anim.values.AnimatableIntegerValue)
                 val).
                getValue(
                  );
        }
        fireAnimatedAttributeListeners(
          );
    }
    public void attrAdded(org.w3c.dom.Attr node, java.lang.String newv) {
        if (!changing) {
            valid =
              false;
        }
        fireBaseAttributeListeners(
          );
        if (!hasAnimVal) {
            fireAnimatedAttributeListeners(
              );
        }
    }
    public void attrModified(org.w3c.dom.Attr node,
                             java.lang.String oldv,
                             java.lang.String newv) {
        if (!changing) {
            valid =
              false;
        }
        fireBaseAttributeListeners(
          );
        if (!hasAnimVal) {
            fireAnimatedAttributeListeners(
              );
        }
    }
    public void attrRemoved(org.w3c.dom.Attr node,
                            java.lang.String oldv) {
        if (!changing) {
            valid =
              false;
        }
        fireBaseAttributeListeners(
          );
        if (!hasAnimVal) {
            fireAnimatedAttributeListeners(
              );
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "IwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "WixqGbztWrNZ1sSm1GRl16sbtJHhprodBpt+YnQGDXOJpBEmGpnUMyfjUG5g" +
       "215/zFjOJDOFvqrxNSVAnDxmNmHomWNGMbXqgqb5uTKU4ybXXdKEkzTb4zxC" +
       "ZlK8th3M25qMWVeYGT6Z83Ur542tUl8gouhlQT5VycVqxyhdfFczpJ05k3pS" +
       "TxjVoxEyY3ooO1/kjoDMzQ4bAvnBOG+bImU38FmDM1Y5PO1D7nAueaIvh0TP" +
       "sZYitYR9IecYrr3zOlrijhvN6tj2h8PVGN9QI3q06RoMY3bzPudYDrdcbJiW" +
       "Y+ULQvCZntOHSRV3eD+NAl+0GGnGCQtDqzfgFTVdrBpbl5I2FGoQFt5gTWs3" +
       "71QpO8YHYpL7QrjpYmHYgsX+zG6Mgt1oiEW90c6nOCLcWSO/kSu+MFstqjsi" +
       "ZwIRHXDdbiT4/cU8GFu5v+yR6/VOksh8NMpxo4bX4PGwS/NYj2Nnw4VFLns8" +
       "HHCuyTrABCLc1Jd9tGVq3W08pLgeP2wlm14V36ZCXq8ul3S0a1nqsF5tTSMn" +
       "NnBrpOEtYTaTq2LaE7Yp6q8pyZuGODtlBASN1vxKa+6MDoV32a5CtLtkB+Ua" +
       "OxvJ/GQ5E3KZWZujVF856HzIZ525YbbikI5hMaFwpr7dLOcW0d+xIrmjq3Ej" +
       "cafWeLROFYgJmqE2gnRilnYjPYGaOCSA3M+NRj4QZZ3brWbixBM3POknXn1r" +
       "99RVfypy9a1nxTuz0YhGA3lHkKOFFDbqvg1k3c+dZXUu2Llb7Zs2lfaorTeI" +
       "mjYpLaV2K+jWEgAuG2DbuGtQSEpALXmTMqYmDYJxjVqDD72ttR0PqsvZsrUR" +
       "DNztTr2xAY/X42ViZv52vlamGypABKCgSc2YIrWxsJsJ49kUs70FjCZinbIn" +
       "g3zN1Cezfh2ztzJK1DfWjGmJKwTnZGaA6SnGpUutvm1QAuISmUKIOxQFLgup" +
       "rjJvNlktnJElz7tjhxI2SyzHha7clSl+5fAkxQj+bibnLUfuz+Na329q3qKt" +
       "Ih3SC9Ask+ZrceF79fm61eRV0nKrDa5lKfik1SAykWDRbEw34E1NJ+NZVjPz" +
       "EY0lIwdPEZTHR7PqqJqDjyvcx5YuK6QZOdMYCvK3ljnFyTpW8wRYCGaI4C4U" +
       "sS7UpXTW1qShzHvjKQ8T1Vxy2tm6yehajDFdu82klBCMemsj3qBDRt915GBM" +
       "pA4VqFHarLrs1GiLwc7LUnFstplstR5ZOc2y8hruoIo8QE29Z0Gki8rzXTTm" +
       "sZ3Ddau9eJjCM6iPN0ZIm8XGYOH3U8ye79J1rgckvGQSId4Ezo7o9WWNTsIO" +
       "HorbLkt7outUF6AnWnWlxJgwnZpMczs34zrsPK1vx40GgupVtTdYRi2YHNqp" +
       "nWI9m5DanrEK4c5uM2+Rm2jqw8KaSBpB0k4aLuFkdkMR1yDrnw4xeWrUOVXA" +
       "aI6DG1BfiLRqB0KRLOpQE3c6HjVQC5/jYCmS3ea07tNY153NN0GHY4XpaLpd" +
       "wzKv+qseKpg2KTDrGaElO8NYBm6ya9qWPO07wipUYG+ncfSEZV1ZkJdJm263" +
       "EbjjiNioruq8w40dI+HFXbhVYxNhRlm11a13wjiJBs1pa9Q3MK6/cLCOYcg7" +
       "d87tzAVQjLnsmmNKTEfhQE1lLDe28ynSrTEGuVpIE4e0xFYOwca6VdsBeTZZ" +
       "PZitxbqqTind0OvtDGcjfQ5JQ6neaXprh+jtCC+ritVNlEho7iDukBvRO4Ha" +
       "aANhtW7SayaKCCXPoTWdTtkEInqswpFMM6ypsOPLuFW167bU3xj6UqKbaNfj" +
       "GirUgYJWe7pDTSzus+i0tdbiTRq1q6MGQa/GXWE3GvjajJw0FSU38x5HGJ2Y" +
       "i5GFvSUwJlh2OrEOEf0qAtU0YVsXEy1GBoiu8Uuo4cFKpBB0ppPUcCFE8jKo" +
       "TdlcW2B1tY4ya1lWYBabLloJHVmjEWIS88VsgYytqG3FzbknNnfh2l2KG2cw" +
       "8NHUbK7ktGZ6hC51pzDE1GXgu9Odsev1q/RK7mMho5oyLLeEQGxWqUhuwAIL" +
       "TcmwrrXiMSI1MriprZdjmJhN+2bEwxDbcZZUewU8uZzUfWKuNPKtPklXQT+k" +
       "RqPBqs/7tUl957qY3Z2rM30ht1qIHld1mDFoTXB8ez4z4sFyg5O7GSdtHd6w" +
       "BL2WI1DqpbUVOkvHBMkLKyLt8azXXsV01iLiDSM1WzWoI42b7DhrQlWjyWri" +
       "tpWtqckmbTicVaVaLeDc6vNJQrgk3YR01ZkyY2ombGKi70AQy27srEPoEDXo" +
       "tqaIP9CZBcFmGVodI4vAqunKMnXjfABCPpIuvRGVKkO0g0+dGoTluV8dCOos" +
       "lXghmjrwyKInK6YpGZMdEaLrOjJR0IaMqIYdzdSqlqO1STWkA7qaTIL6ekk7" +
       "4VJxbQWpzepO214sJUiyajy7oWUPyU0PiiZUDjOwNva3IRNTPLmEqC3dxsNR" +
       "Y046BpWHpgXvnFrN2kmTZLrBd9oS6SKNXIKb/iAcTSPFGHQRLrVlhuohQ64u" +
       "9ELe9IeeiMOLDpUshjgHwY1Yi1HTx7bGdjOaDwiolvoddCKiTURwKDilWc1L" +
       "eihHmENhOcA65DAzh0Y6W83qqVxfQlgrlajaaNVnTZHs9By876JdUuToZjJE" +
       "KJ2iebk98mQuWHdqPZL1JulQsha1KobOzZlZzdboYkTzLs6mUD/rQbZKBuP2" +
       "FIqrcY+E02FA0Z4zX/ErWCXpQGbmnZ0R2/ZMxciuBW2ytKmxfhDGDVSt4z6y" +
       "6PRlR9pGtmZ59hyeSY2uPc36SWuheFOL76hVOUoaVUReTHfzgVdzh7Hqd91+" +
       "oxkaBK0QrXQGUXlHgwiW3lkNn52zXmTI7WjC650toRkwpEU21WGVlN0wGbdc" +
       "9rkWvtx2urK38Ot5QLWaeYu2NX7spb0a1G81e3nKDaGeHAxJl9USEuV7va0p" +
       "0K5r0Ho7XBp9S9zy+UZudz19s8V1R0k3QkuZT/pDq6O7ckIhIKNBAnrhxK7F" +
       "8bye1jF6gYNlSutEODKqaK/X0udW3FMznuxXJWMrctXYmaDsuk42p+2UIkJH" +
       "mPpbxOAEo+rxDVFejPXxwjXX7MpbmNVJxkeIlkQ7z55xTWiT49Cm09+sLG2Y" +
       "eVmnibi+OYyEuYqYCrkcx0jsUZwJAyuszqrsSuiHVbEfLf3cnUxGbhPpr/zu" +
       "MieDpuz2rFgaboXQBDzXFlIa12N1Y3jVlcl5oUhpwPmsmlgdBL9xQ57Q6dCf" +
       "Mt0lMu/iucByEG3b0nwsz2q98azl28x41WOHzbRGmFQCDVRmkfZdI44Svt7J" +
       "uS2d0f21jfWX+kxN4i1BytNmL9tpIB9YDJVNKJkD3aMjpeOxvun0gybtylbc" +
       "iLfzyMQpn0U2PZcc7mR+y7S5CTEYhS09Dx2VlobJtEE0h7hnJlRgDeBOlRbr" +
       "Im3CcJpMuqTm9WeoKhRjwBt6IvTcKoQlS2HQjEY8Fdp2dwWS0t66qW4Rbema" +
       "3YVUXebImGB4FkdXzU0tU5Ua7vFSg6gpuyXbR3DL91NqKHFyjRQMZz2UDF2f" +
       "eiSsp4lKkhuRkDIzUzo+aesKowYNK6Y2WSvakq0GSm0b2nIIInQcrnejti3O" +
       "bXQ3xJA2LNTqNtXcbCMm7czHWNtnscQY7JKeKHEMH3PoeKzh8npQNWt4nxxl" +
       "cY4vFi5IM7wp4UIoDHJ0rD9xe5ztW4ns9+2wv+02h7EsrrWeKjLapB0iVK85" +
       "VfLBEqvzESbr8URkI7HXHuiLYXfDxVBAa/KGylpLvrOcZgiqhCosttFO0rCN" +
       "kRJgWVeIGXM83IZ522rkm3DDp+NlHOVxPdh14E4wlAYNdQQ7XNoOAqI70IbD" +
       "EaF6Ut+Lkmjc8XIY2rLQJFw1WCjJuBYfGXjkD7g1ZW3g+qAHr1s0F6rNbWvV" +
       "5K14TCw7znawQaeNjYNKFpSQsm7xo12f1Q2FSBV9GDVRraPpSWeFwAaznRBz" +
       "HGsILtsRhw067pPdbD5AnTEPnJkyWYz4OYkTdZDmsTwWLjs01UU6c0FswNXB" +
       "ttr2RlbM9sIkwYTQVmfZ1kEXYRo0EML3KL8mxnUCRglfnOqMMemzi3lMNYmV" +
       "TmvEjOwZMYsutpK+nHNEJDVTSJnl0LSzxewatoQGUS2ButCCxUaN0Sjtdott" +
       "hx95bdshj5S7PCc3Ab6D/Z39q6eK6n0ne2Ll36XK0anx8f8ze2JnNsIvHJ/A" +
       "PF0c2aQN5exB6rlj1GJX/933ugtQHl584aMvvqROfgo+ODpreC6qXI08/4O2" +
       "lmj2mVmvgpGevff2O1NehTjdA//tj/7nx6cfMp5/DYerT57j8/yQP8t88XeH" +
       "3638nYPKxZMd8Tsuadze6bnb98GvBVoUB+70tt3wd58o4Xoh8+8ChT9SAn9+" +
       "Y/JUzXfflXz/3kzuc5Tz9+/z7h8U1eeiyrW1FvXO7P+e2tXnX20n7eyQZcNn" +
       "b992fScoHzlC95HXio57VXRfus+7LxfVz0SVS7GvAgu96+Zh4h1tz5dof/Z1" +
       "oC0Pq78HFPMIrfnG6PLCKUG7JPgndyc4XqOPnV2j/QmDZ4rmFwuh7PwbRfUr" +
       "QOPhbRr/R6cy+NXXIYMTe86OZJC98fb8z+/z7itF9Zt7e+6eOTo4RfdbrwNd" +
       "YcqVD4LysSN0H3tDNXyswGfuei5enIQc7n0t0OVUCgDEcrQ/vI88/qiovhpV" +
       "HgXEM1fVAjs33XV5THY82wfumK2cqdzlD48mLK4HnHYq5fj7r9cvPAfKjx/J" +
       "8cffGL9wZqX8m5LgP9xHNF8vqn8XVd6ydw7HUezkCPHMivjT1+sVYFA+e4T1" +
       "s2+MzRyUBAfHWrxxdtF3o6g8Nq6XPf/bfYTwraL6Boi/EuhS3o88B/2/vl7o" +
       "XVB++gj6T78x0C+epkv/vYR5gvVC5d5YLxwUja9ElYcKrMeHSufg/sXrhdsA" +
       "5ReP4P7iG6rpU7glmofug7S4XnHhcgSSIICU1xwvOQ/0wpXXAjSLKm+92425" +
       "4vrPY3dczt1fKFV+/qXrV97x0uxflpfGTi59XqUrV/TYts9eFTjzfMkPNN0s" +
       "xXB1f3HALxEdh7W73RaKKhdBXTB94a176scAv3ejBpSgPkv5zqOVc5YyqjxY" +
       "/j9L9wQIKad0IKPYP5wleQqMDkiKx6f9");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("42UJv+oVpzMJdOl6sgtnMuAjGytN89FX09hJl7OX04qsubxlfZzhxvt71reU" +
       "L79Ejn/gm8hP7S/HKba02xWjXKErl/f39E6y5KfuOdrxWJeIZ155+Beuvu84" +
       "o394z/CpvZ/h7cm730TDHT8q747tfvUdv/S9//ClPy5Pkf8fiYYmFv4uAAA=");
}
