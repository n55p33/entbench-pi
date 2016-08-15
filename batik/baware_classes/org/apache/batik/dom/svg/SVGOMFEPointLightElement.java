package org.apache.batik.dom.svg;
public class SVGOMFEPointLightElement extends org.apache.batik.dom.svg.SVGOMElement implements org.w3c.dom.svg.SVGFEPointLightElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_X_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_Y_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_Z_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      z;
    protected SVGOMFEPointLightElement() {
        super(
          );
    }
    public SVGOMFEPointLightElement(java.lang.String prefix,
                                    org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() {
        x =
          createLiveAnimatedNumber(
            null,
            SVG_X_ATTRIBUTE,
            0.0F);
        y =
          createLiveAnimatedNumber(
            null,
            SVG_Y_ATTRIBUTE,
            0.0F);
        z =
          createLiveAnimatedNumber(
            null,
            SVG_Z_ATTRIBUTE,
            0.0F);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_POINT_LIGHT_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getX() {
        return x;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getY() {
        return y;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getZ() {
        return z;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFEPointLightElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "BEw15yIiAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e8w011nffK/t7xbH32c7cYyJnTj5khJv+s51d3bjhGR3" +
       "Z++zs7Mzs7cp4Mz9snPbue8GlxBRHJXKjVqHplJw+0doKQoJQkArUSq3VZsg" +
       "IlQqSltUCKCqTYEgUpWLMC2cmX3v38VxYvWV5rxnz3nOOc/vOc/5zTPnnM9/" +
       "HXogCqFK4Dtbw/HjQy2PD22nehhvAy06HNJVVgojTW07UhQJoOw55V0/feNP" +
       "Xv2UefMAuixCj0qe58dSbPlexGmR76SaSkM3Tks7juZGMXSTtqVUgpPYcmDa" +
       "iuJnaehNZ5rG0C36WAUYqAADFeBSBbh5KgUavVnzErddtJC8ONpAfxO6REOX" +
       "A6VQL4aePt9JIIWSe9QNWyIAPVwtfs8BqLJxHkLvPMG+x3wb4E9X4Jf+wffd" +
       "/Jn7oBsidMPy+EIdBSgRg0FE6EFXc2UtjJqqqqki9LCnaSqvhZbkWLtSbxF6" +
       "JLIMT4qTUDsxUlGYBFpYjnlquQeVAluYKLEfnsDTLc1Rj389oDuSAbA+dop1" +
       "j7BblAOA1y2gWKhLinbc5P615akx9I6LLU4w3hoBAdD0iqvFpn8y1P2eBAqg" +
       "R/Zz50ieAfNxaHkGEH3AT8AoMfTEXTstbB1IyloytOdi6PGLcuy+CkhdKw1R" +
       "NImht14UK3sCs/TEhVk6Mz9fZz744se8vndQ6qxqilPofxU0eupCI07TtVDz" +
       "FG3f8MFn6B+VHvvFTx5AEBB+6wXhvcw///5vfOT9T73y5b3Md95BZiLbmhI/" +
       "p3xOfuhX395+X+O+Qo2rgR9ZxeSfQ166P3tU82wegJX32EmPReXhceUr3L9f" +
       "ffwntd8/gK4PoMuK7yQu8KOHFd8NLEcLe5qnhVKsqQPomuap7bJ+AF0Bedry" +
       "tH3pRNcjLR5A9ztl0WW//A1MpIMuChNdAXnL0/3jfCDFZpnPAwiCroAHes/R" +
       "U/y9u0hiSIVN39VgSZE8y/NhNvQL/BGsebEMbGvCMvD6NRz5SQhcEPZDA5aA" +
       "H5jaUYXqu3CUAlea9ybjbof1gb/SlmHGBVWATg4Lbwv+P42TF3hvZpcugal4" +
       "+0UicMAa6vuOqoXPKS8lrc43vvDcLx+cLIwjS8UQCoY+3A99WA59CIY+BEMf" +
       "3m1o6NKlcsS3FCrsJx5M2xoQAKDGB9/Hf+/wo598133A44LsfmDzAyAK352h" +
       "26eUMSiJUQF+C73ymewH5z+AHEAH56m2UBsUXS+aswVBnhDhrYtL7E793njh" +
       "a3/yxR993j9dbOe4+4gDbm9ZrOF3XTRw6CuaCljxtPtn3in93HO/+PytA+h+" +
       "QAyADGMJOC/gmacujnFuLT97zIsFlgcAYN0PXckpqo7J7Hpshn52WlLO/ENl" +
       "/mFg44cK534veAZH3l7+L2ofDYr0LXtPKSbtAoqSdz/EBz/2X37lf+GluY8p" +
       "+saZlx6vxc+eoYWisxslATx86gNCqGlA7jc/w/79T3/9hb9ROgCQePedBrxV" +
       "pG1AB2AKgZn/1pc3//Wrv/W5Xzs4cZpLMXQtCP0YrBlNzU9wFlXQm++BEwz4" +
       "3lOVALM4oIfCcW7NPNdXLd2SZEcrHPUvbrwH/bk/ePHm3hUcUHLsSe9/7Q5O" +
       "y7+jBX38l7/vT58qu7mkFG+2U7Odiu3p8tHTnpthKG0LPfIf/I9P/sMvST8G" +
       "iBeQXWTttJK/oNIMUDlvcIn/mTI9vFCHFsk7orP+f36JnYlAnlM+9Wt/9Ob5" +
       "H/2rb5Tang9hzk73WAqe3XtYkbwzB92/7eJi70uRCeSIV5jvuem88iroUQQ9" +
       "KoDMokkISCc/5xxH0g9c+Y1//W8f++iv3gcddKHrji+pXalcZ9A14OBaZAK+" +
       "yoMPf2Q/udlVkNwsoUK3gS8LnjjxjDcdc/z0yDOmd14BRfp0md4qkr927G2X" +
       "g0R2LOWCq12/R4cXJuXgiOyK328FIWOJvYg6DvdRx3HFe+7It00ZUA4wBeUr" +
       "ScGxpbYfuce8d4ukUVZhRfKBvebVb8p2e9nHy19XwOS+7+703C2it1OGe/zP" +
       "J478id/9s9scqCTmOwQtF9qL8Oc/+0T7u3+/bH/KkEXrp/LbX2Ig0j1ti/2k" +
       "+8cH77r87w6gKyJ0UzkKo+eSkxS8I4LQMTqOrUGofa7+fBi4j3mePXkDvP0i" +
       "O58Z9iI3n748Qb6QLvLXL9DxWwsrfxA8zxz5zjMXnfESVGbYO/vjQZH9LuCU" +
       "URmsHznlX4K/S+D5f8VTdFgU7KOaR9pHodU7T2KrALzbH81dRwglKx545Svl" +
       "ZKaAH37XbX5YLlTKB+tgO/BULddUoeC603VTOtr0tRxtdP6tdAs8Hzgywwfu" +
       "YobvucuyLM1Q2nYGoo78WPX33ztkaXqWW1iASYovmwvqf++3oP6Hj9T/8F3U" +
       "174p9bdFRrqgjv4tqEMdqUPdRR3nm1Jndyd13NdUp2yeXwKM+QB2SB4ixe/o" +
       "zgPeV2Q/VCQCkNYtT3KOR3+b7Si3jn12Dj4/gWPesh2yqG5e0Gn2TesEmOyh" +
       "U9qlffCp9yP//VNf+bvv/iqgmyH0QFpQAWCZM9y895Ef/vynn3zTS7/9I2X8" +
       "ASw1/6FXn/hI0evHXhNZkWTHsJ4oYPFlSE9LUTwu4wVNLZDdm2XZ0HJBZJUe" +
       "fdrBzz/y1fVnv/ZT+8+2i5R6QVj75Et/+y8PX3zp4MzH8rtv+14922b/wVwq" +
       "/eYjC4fQ0/capWzR/Z9ffP4XfuL5F/ZaPXL+06/jJe5P/fr//crhZ377l+7w" +
       "lXG/A2bjW57Y+MYrfSIaNI//aFRsE/kM5daVMQxWerzu74hBFBLLkWEzPOD8" +
       "pRUl2xESe314OOqLgrkLkF3S0BpKBUZxe0JGqCmhlDDlMstp0xy3tlcrutMz" +
       "hZUTLwwrDlcVX+AoEumsEHk+jGnJXSOCaEkwDOOsprqzKEPWOHCf1IMnCiit" +
       "6CS8ZRWioQ66i54Qb/zMHUbTDdMLO6o5JYYJ0tnidMvutRKTtqbKxuw3Em2Z" +
       "Go5lBUJADwcEzdGZ3yPFhe9RPV4c1Na9Tj7lev54Ngxbvdm4xkhGZWi3hnNx" +
       "uHZdAakKnNixlosQW/kdN+MbTS7ocLYQLHkNEWp0k2d2Has19DoRT2b+RN2K" +
       "A6Nmbjpbsio0G9UYUzqjJZssjJW9WzmkKXRMz9X4fqcxaCVRVOvxQRD5QkbS" +
       "o1UoNFepPmLQtbsYJsRGMTpthEDSZSPYIcaOqXdm03l3lsezHep0KUdR/eG6" +
       "J+EMAT4cpXGlbi352aItsIPpuDHSopbGZLVhvmCEBbqZtWtcEqyjBrpBM1X0" +
       "Jht0PZ1Zw34VxNyS34yqVh2ZOvmaQKkhre4IMR7intSLNwtJsDIktStZNZL0" +
       "KtdaOKO1JQ4XK9iy2s2OgSz4Vbct8Sir1sbBWmqDOjDTJDufORknYq4cq6PI" +
       "pPiova2zGIbJrV2Y91S55krbdMU1WsyOiMcoh6ORmU9RrzFfzNerloN5CbmR" +
       "eqlosVtzRRNdQ3NWTbzrCKO14gwVdoBPmmOurmN01mwJI3w4EyRrso7nI2OI" +
       "rLsrYRCODGqsL5swP1vx7Xhm9JoTa7Lb2sPuAkvak7Y/RvKpNV43cbFJtOYc" +
       "grc6VVPsbqZ2f9Jeiv4cay9Z2MlWC7pP6u6C6Vgzbk05FMd5jpfxAmaMBDTu" +
       "RCjvKk2csaaIaqU7qoGOCH8wa9bpWStC7B0arBKcxiKyXs2HYzLq7BZUbWlt" +
       "tk7fIFjdixgVpeWN0xwvfBQVW1kdx6Q6OsbEAYp0bSEbM2PVto1VlOls2E/d" +
       "0ET7NSHmZnGjv1nP57tEaXJbzHLj8drVAnw2WG6am4nIOsO+M8vwfqVuM3pb" +
       "W7e4TcOoulEmOrrE8VUHn4/Sui4Mp92ua1maZy2dUb5Jsajdq/TT1gqZzowx" +
       "u1hMGxVamfaQ1bbOdVCuMmmP2hbvR1JfbS1RpkIbijo0sGqX6DlNuGfrs7RJ" +
       "TO1RWlO6WbM/yKfStm1XE7rX67QCJMcoWEYa021oMHyHsXcthErMtLPAJRhz" +
       "1Wbik6KQ8YaEgdVtDETKpCR0Wp3Ci1nSrsCbRLfWtfVSGFJmJjejXDG3Cypw" +
       "aRO3+bpq1Dgj6vMJzgycTmUQCLMptyOwvsxFnZbRVJMFTVe8cC6rW8wHXhQQ" +
       "1blR31pTOm11fZdc8g0rYfmZJmO4wqRwvb7R7IAathbGgqtOZ2ITSZaskSV8" +
       "vkUFb0713NGstw1dbTbo5rapdhfrHttdVNe9br6ZL/ubAdmwOztUoZtUjyNF" +
       "jV1nM2dYURLZqDQngOmGDacjNJBpbxk26b4ZT/rISCHTMGrUWvNRHdilostk" +
       "DqvpHMVhohnhajCNXH8NiMi0Bi74GGCMXNhZ4iRcNDwxaVBphncq7bqxiKN2" +
       "jTSVXUWNrbi/XAQtQtpuqtlUNLFMRskxt+RQXNuZqwVsk/MB1RWpLWtV+kGU" +
       "ET5cX3I1boOBxZIN6kR7kbamdd1DsQ0DV8aoLlcoN94wo/VWURedhhjUNWEg" +
       "MwsyZKQlYyZIe91NYoWlPJwkphHJ4Oy4GS3bMyPBVo2I6RtbrDPe1VFNTzR4" +
       "wdQJVbcEnwA+wQeV9cbAmMk4m/eFPLNsvlvL/BG9FPvNnhI2m6u+kDqdltUJ" +
       "RH5m090xvDARjHYCuF6pVN1O5m8bjDlYeGK15ZJwgEpcn29Elbkii/mYG3MW" +
       "KXrsUGjW4VxbKoGWtlvjgNMmlDNRG9W5Z8xWxpIQEVbiQo8eqtnYnMCyMN/B" +
       "NdwhVxgViW626M3JeoWorIaYM7KWsabJao6QiUfjwwCeu0uVTMmWhAtcy8Cs" +
       "LG3qa3nK1hDObvWMBO6PMwZn6oFDZ1Rn2O8ss7QuGZRX2xLNSZ+bo/N6w0+9" +
       "oFZpLLKupUu85qzn4xBps5i2pozWxOa6WTSdx1UNd6s+uZzG7HjOz7tbU0X9" +
       "Qd9z4lrNC3Y9sPxweCH0bFRRJuA91kRwm56sCGIYrDlyRdJLSl3o/nSlxwHu" +
       "iYZSRRis58cesZqxPrWomO2escSYhUVocLU+rAjmsuVNYnfohNh0QvNrSQxt" +
       "jqBlypWc5XiFCSaSSt1pT5m6AEatz67UYcKreHVcx5i+g60mu4mkOpw51JXe" +
       "CEUmSbrLa2Qi6/3UW8BeZ+ejAc+ujU41wuurbmvCwpan53rLHWj9Tuxoqz6x" +
       "1ZMtt1AxPFVYL8EJSSQVQK9jOKcCnHS1STWu0fTGrqiiMBt23J3EzHQ3m1bt" +
       "BpG2BRdfcYozG7FEnuLVqLqOVDvIa8PAsNlm1COyqRyvWiRiMSSBtXyqyTSw" +
       "WZdtIQuY2rS1ATGFw1GVGfF2BdQuW0l9a3iG5vqDFSK53T69Be+z6WIItwH1" +
       "7iYZpUtEamwzOJLMxYSq8l5vvml2TLcBuF2ZUGSamlmFgUN7JUT1GPV53Al6" +
       "DWkbTGyRtmrMOFHdaczNI1mUugGeqyDKoch+ZtjVuTkdsaZd63P8OnGdxQyZ" +
       "rcfoyFZkZhg2nUavaTJhf91vo7Eib8bmaGLOgpVsi4NkhM3MydjsmLLiLDeK" +
       "o5s6I/dGPTbCa8M5Q+VSruLrnExpgpKGuILE63puBNXqNBSAgrput/SVsjWI" +
       "esygqLYh4XUN7W/BbFca1fpylem6Tlc76rzfn0+QmruqchjPWDRPBgpJN9L+" +
       "EGdVOVzDeqUi6XFWS5KgZTfTUKYDNiVgNJ/6m0kdz2qjerKl9GqCEjJYlnNt" +
       "itbrjEuxg7qhN/JqDV6RPYKpb9LRLF8uPL5BiPCsttSMhhA42hwXif7EbsMY" +
       "kZo1LRgslmKLWnohb1Ajmxam2HDnxe0cxB71DO2J62hUnTBEgvCkSK1Ne973" +
       "pnEzmxrsZt0mndVks1J1hMMbZC1PDFveNUzfHqzYKdtRGa0S4vUZRuIsNzKr" +
       "vsxntQ7Zn9S1+nwysphq2qtM7cogperdHJ61d2nWxYbrGF/sxkqlisVNhO3a" +
       "u6wuWDzMV9TljtzlpJ7azAYsfZOzwv687dmaH6e6OahSCazXtHzbJIjY5NWY" +
       "XA5qrXbTqUcrSRD13nSMNkF4NMvsTqdHVPp2C+9WvWS863M5kSmMbTayUF82" +
       "Nlg7npt5aGD6DHFxZBxpQY5VFpWgHQykjU61HLIdRIJNTcezqjjlZh0tGu6o" +
       "RazMWDIbBYFFrWDWRHi00WhHOCe7wUALK2NXiOYNSzHcMRWkltXXd66TmRU4" +
       "3PVilQ02mOu1Z8Dw4N09I0EbeUX0dkOMCqKlIKSqqcFs0haJ2mIjrQaakxNE" +
       "yCC96obvbjyjLmr5RJ4jiDBsjsGqRzZurzmyI6wt1oBsnaTdUavTbxM4MxMY" +
       "FaF7tEvtujBltE1ENwa7AWtTDG6AtE/RaX82pwcTYkDrzagR8zKszRc1WUFb" +
       "VMxmhljJ23JjS/FNymqrUkvAanM1InewpWaNrB86ZOzlqmu6iKY06tXJrDLh" +
       "zSD2RXMnVzxXH+xczW5FJhrhjtiIZclL1Y0gqaK1SOVVV9Z6abUzWvdGij0z" +
       "B/ly6qdbrh1MambQCwLJanUcPxVlrDva1p0Buqyj4Gth27EafKY7CexZQxCD" +
       "kOt2O9xiEqWGfIwEk8EiXk5aXZZcdOOWCrckUZenC23UQIhVB2UrsipPyJR1" +
       "0YY709jdFPP7JI2T2FhnJouA78ryru5WpwajyWjSHZu7NkzvNHGeLuRhoKy9" +
       "mimL2qJHj+QWOXJF0meiLi+6PWW4nicjBMUClMZQhQ13dgPZkBtn2+ni68xq" +
       "WozAmLpOtniEHXKumzOJosnVOKqkayFZ6n3dit2lqMNbDkcUPqTUBoOJrUog" +
       "ENugS+4STNVkI+YtGV3z/pBGUsJR2U17MVO7io4Me+7MHhJtq2kqgzEbDsh5" +
       "lZP9VICjbVsYiGseNwR+hFvYcsJtlGWKGVm0aRIOD1coZ5puKsxsWVu6znS7" +
       "lVbcBoyXj5C5vhaXy3jc7MR1XdxuvG6y0TvovBFWUldD/UCbDJGKKu8iicjr" +
       "mOUZKVPhtJUKbNTaRQOKpNgWO9R9dMcTNclKx9sKNZgG414ld4dq11zmE3Mz" +
       "cCXMXvN0hXOkvFvJE12EW50MrW4HFvhiLzdL/s7r2015uNwkOjnl/xa2h/ZV" +
       "TxfJB0/20cq/y9DRifDx/zP7aGc2xy8dbzm+t9hyzHDl7E7jHY5Gi42UJ+92" +
       "1l9uonzuEy+9rE5+HD042sd/IYauxX7w1x0t1ZwzI18FPT1z9w2jcXnV4XRv" +
       "/Euf+L0nhO82P/o6DkzfcUHPi13+s/Hnf6n3XuXvHUD3neyU33YJ43yjZ8/v" +
       "j18PtTgJPeHcLvmT5zc0EfCIRxMhXtzQPJ3qe+5m3uOY5HP3qPsnRfKPYug7" +
       "Lc+KywsvWtNxaCvVmnEcWnISa/udzU+c8bMfjqH7U99STx3wH7+ek5ey4LMn" +
       "JniwKKyARz4ygfx6TBBDV4LQSqVYe007/Ow96n6+SL4QQ4+f2uG8EYr6nzgF" +
       "/MVvA/AjReFT4FkfAV6/3jn/0GtifeUedf+mSH4hhh40tJj2Fclhjty1eYrv" +
       "X34b+J4sCp8GT3iEL3zj8X3lHnW/UiRfAj4K8C2PyevpO5DX+UOSU/BffiPA" +
       "b4/Ab9948L9xj7r/ViT/aQ9+VeT/wymuX38jcH38CNfH33hc/+MedV8rkt/Z" +
       "4xIv4PrdbwPXo0XhE+B54QjXC68X12sT8P++R93/KZKvAxbztIzxVe3YX2+e" +
       "9deTihLuH34bcIsZhBrgefEI7otvONxL0D3qylPdVwHPgmm8eCp7ctK6PMX6" +
       "F6/rSB/0e7cLW8XVk8dvuye6v9uofOHlG1ff9vLsP5d3lk7uH16joat64jhn" +
       "T7vP5C8HoaZbpTWu7c++gxLiNaDF3Q5nY+g+kBaKX7q6l34wht5yJ2kgCdKz" +
       "kjeOnOKsZAw9UP4/K/dIDF0/lYuhy/vMWRHgX/cBkSL7WHDscXe+lHFyonwc" +
       "3V06E6AduVc5U4+81kydNDl7H6oI6spLvscBWLK/5vuc8sWXh8zHvlH78f19" +
       "LMWRduVp7VUaurK/GnYSxD19196O+7rcf9+rD/30tfccB5wP7RU+dfUzur3j" +
       "zjefOm4Ql3eVdv/ibT/7wX/68m+V56R/BYyvUPF9LQAA");
}
