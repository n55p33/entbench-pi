package org.apache.batik.dom.svg;
public class SVGOMViewElement extends org.apache.batik.dom.svg.SVGOMElement implements org.w3c.dom.svg.SVGViewElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_PRESERVE_ASPECT_RATIO_VALUE));
             t.put(null, SVG_VIEW_BOX_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected static final org.apache.batik.dom.svg.AttributeInitializer
      attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      2);
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
                                    "xMidYMid meet");
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_ZOOM_AND_PAN_ATTRIBUTE,
                                    SVG_MAGNIFY_VALUE);
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio
      preserveAspectRatio;
    protected SVGOMViewElement() { super(
                                     ); }
    public SVGOMViewElement(java.lang.String prefix,
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
        externalResourcesRequired =
          createLiveAnimatedBoolean(
            null,
            SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
            false);
        preserveAspectRatio =
          createLiveAnimatedPreserveAspectRatio(
            );
    }
    public java.lang.String getLocalName() {
        return SVG_VIEW_TAG;
    }
    public org.w3c.dom.svg.SVGStringList getViewTarget() {
        throw new java.lang.UnsupportedOperationException(
          "SVGViewElement.getViewTarget is not implemented");
    }
    public short getZoomAndPan() { return org.apache.batik.dom.svg.SVGZoomAndPanSupport.
                                     getZoomAndPan(
                                       this);
    }
    public void setZoomAndPan(short val) {
        org.apache.batik.dom.svg.SVGZoomAndPanSupport.
          setZoomAndPan(
            this,
            val);
    }
    public org.w3c.dom.svg.SVGAnimatedRect getViewBox() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFitToViewBox.getViewBox is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
        return preserveAspectRatio;
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMViewElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7C+zr1nkf79/2vbbjx7UdP+LEdvzKYqu5pEjqVcdtqCcl" +
       "USRFUZTEpnUo8vAlvkRSIqnOaxp0TdAASbA5TQa0xoqlWGe4TdGlWLG1m4ds" +
       "fSUY1qLY1gJLgmLA0nVBG2DtHtnWHfKv/+P+771/272eAB5R53zn8fvO933n" +
       "O+d8ev07yG1RiJQC38kMx4+vgDS+YjuVK3EWgOjKgKnwShgBreUoUSTCvJfU" +
       "p3753r/83ufMywfIRRl5QPE8P1Ziy/ciAUS+swUag9x7kttxgBvFyGXGVrYK" +
       "uoktB2WsKH6BQd51qmqMPMMcDQGFQ0DhENBiCCh1QgUr3Q28jdvKayheHK2R" +
       "v4VcYJCLgZoPL0aevLqRQAkVd98MXyCALdye/5YgqKJyGiLvP8Z+iPkawJ8v" +
       "oa984Ucu/8otyL0ycq/lTfLhqHAQMexERu5ygbsEYURpGtBk5D4PAG0CQktx" +
       "rF0xbhm5P7IMT4k3IThmUp65CUBY9HnCubvUHFu4UWM/PIanW8DRjn7dpjuK" +
       "AbE+dIL1EGE3z4cA77TgwEJdUcFRlVtXlqfFyBNnaxxjfGYICWDVSy6ITf+4" +
       "q1s9BWYg9x/OnaN4BjqJQ8szIOlt/gb2EiOP3rDRnNeBoq4UA7wUI4+cpeMP" +
       "iyDVHQUj8iox8uBZsqIlOEuPnpmlU/PzHfbDn/lRj/YOijFrQHXy8d8OKz1+" +
       "ppIAdBACTwWHFe96nvlp5aHf+NQBgkDiB88QH9L8k7/53Y983+Nv/PYhzXuv" +
       "Q8MtbaDGL6lfWt7ze+9rPde4JR/G7YEfWfnkX4W8EH9+X/JCGkDNe+i4xbzw" +
       "ylHhG8JvLj7+GvjTA+TOPnJR9Z2NC+XoPtV3A8sBYQ94IFRioPWRO4CntYry" +
       "PnIJvjOWBw5zOV2PQNxHbnWKrIt+8RuySIdN5Cy6BN8tT/eP3gMlNov3NEAQ" +
       "5BJ8kMfg80Hk8POBPImRj6Km7wJUURXP8nyUD/0cf4QCL15C3proEkr9Co38" +
       "TQhFEPVDA1WgHJhgX6D5LhptoShJPW4kWSDJTQSsfCWXsuD/c/tpju9ycuEC" +
       "ZP37ziq+A3WG9h0NhC+pr2yane/+0ktfOzhWhD1nYuQ52OWVwy6vFF1egV1e" +
       "gV1eOdslcuFC0dO7864PJxhOzwoqOjSBdz03+eHBxz711C1QsoLkVsjbA0iK" +
       "3tgSt05MQ78wgCqUT+SNLyY/Lv0YdoAcXG1S8+HCrDvz6nxuCI8N3jNnVel6" +
       "7d77yW//5Zd/+mX/RKmustF7Xb+2Zq6rT51lbOirQIPW76T559+v/OpLv/Hy" +
       "MwfIrdAAQKMXK1BIoT15/GwfV+nsC0f2L8dyGwSs+6GrOHnRkdG6MzZDPznJ" +
       "KWb8nuL9Psjje3Ihfhw+P7SX6uI7L30gyNN3H0pIPmlnUBT29cVJ8LP/4d/8" +
       "CVGw+8gU33tqcZuA+IVT6p83dm+h6PedyIAYAgDp/uMX+b/7+e988ocKAYAU" +
       "T1+vw2fytAXVHk4hZPPf/u31H37zG1/6g4NjobkQI3cEoR9DHQFaeowzL0Lu" +
       "Pgcn7PADJ0OCFsSBLeSC88zUc33N0i1l6YBcUP/3vc+Wf/W/fubyoSg4MOdI" +
       "kr7vzRs4yX9PE/n4137kvz9eNHNBzVewE7adkB2axQdOWqbCUMnycaQ//vuP" +
       "/b3fUn4WGlho1CJrBwo7hRRsQIp5Qwv8zxfplTNl5Tx5Ijot/1er2ClP4yX1" +
       "c3/w53dLf/7Pv1uM9mpX5fR0j5TghUMJy5P3p7D5h88qO61EJqQj32A/etl5" +
       "43uwRRm2qELjFXEhNDbpVcKxp77t0h/9y68+9LHfuwU56CJ3Or6idZVCz5A7" +
       "oICDyIR2Kg1+8COHk5vcDpPLBVTkGvBFxqPHkvGuPPO98FH3kqFeXwPy9Mki" +
       "fSZP/saRtF0MNkvHUs+I2p3nNHhmUg72xi7//SB0DQvsuXdx5dC7OCp49rp2" +
       "llpCkwNZ0fbVTW5ji9F+5Jx57+ZJoyjC8+T7D0deeUu8O6R9pPh1CU7uczc2" +
       "z93cSzuxcI/8L85ZfuKP/8c1AlQY5us4J2fqy+jrP/No6wf+tKh/YiHz2o+n" +
       "1y5e0KM9qYu/5v7FwVMX//UBcklGLqt7d1lSnE1ud2ToIkZHPjR0qa8qv9rd" +
       "O/RtXjheAd531jqf6vasbT5ZNOF7Tp2/33nGHD+Yc/nD8PnQXnY+dFYYLyDF" +
       "C399eTzIXz8IhTIqnPK9UP4V/FyAz//Nn7zBPOPQe7m/tXeh3n/sQwVwTX8g" +
       "dR0xVKy47xVLyvFMQTn84DVyWChq24d6kPU9DaRAE3Nbd6I3haCN30zQhsds" +
       "yNUR6cCH2rOBugEbPnp9NtxSsCFPxBjOguUpTsHoaYy8W4mhVi2ht9734JKU" +
       "70pAeATtQzd0Zajr1DqD74ffOr5i1X0RPuM9vvEN8Ok3MDsFviNI74G6B0KI" +
       "Md83FV6gANYbKwTam+MqXDTKs9x85pu+7wDFO4PLeJu4WvCR9rikG+Dy3wqu" +
       "BwJo2EG4BVQUQLUTcik8QtR4a4j4a1s4gy54U3TFaNIL0NTfhl+pXcHy3+k5" +
       "cvdiIXd58rEjJA/bjvrMkaZJUN6gOj1jO7W8mDozoOlbHhC0v/ecLBaMDzei" +
       "n/5Pn/v6Z5/+JjSSA+S2bW7AoG08taKwm3xv/pOvf/6xd73yrU8XXhPkuvTx" +
       "Z/+s2On82NuD9WgOa1KIHKNE8ajwcoCWIzt/beBDy4VqtN1vPNGX7//m6me+" +
       "/YuHm8qzC8EZYvCpV37qr6585pWDU1v5p6/ZTZ+uc7idLwZ9957DIfLkeb0U" +
       "Nbr/+csv/7NfePmTh6O6/+qNacfbuL/47/7P16988Vu/c5090a0OnI2/9sTG" +
       "932RJqM+dfRhJKWFJ2oquICrNfT6hOewGr1TneFkxWw6Au6t622jxnrdqm5S" +
       "S6k2bco1jJDxUj2ubWVvOdoGLtk0xpYEhlNzInQXwtgf2ouW0Vr5Ib1aS7Gd" +
       "Lq2pxihjaRp0BxVnoPhDR2CHOoHiGrHcLvEaq1STQMC3cmmJymhlu916qI4v" +
       "G/UOWGVsc9ApSwuLI+brZnctla2t34ywsrVgzLjDaypvrcaMSTdAo1zD4knf" +
       "p7NFP02AMWkuWHzSnXC9BbeaSv3RwDIsdukHttLthBjJrlf1vtgdSuPloD+y" +
       "fdG1skFnE08W6bjWpsyqw46HNudNJgNGEFdRs0+WBbfjLnbZWK2LCiF0XGfd" +
       "C2seqDBziGXeIhajUm8ki81Jp4GFImWbgwG/UrvjbNaJh4NKhEkaiQ7XUSR0" +
       "R1HcBSW8PzAkVLQYyp7x3WUjW7q11PXJJhV1Bakjs3V0IY7LkrdupcOhg8NV" +
       "xnHtNr4CpbFhWYFKS27QdtbtdN0bq6Nk3cNjLIndOTaT5OGArYBFMitz6WAz" +
       "7PS6rraejkWt1TXXwHPUZMEGapZ54007VraTchDM5MAhd9Vl4k/4eVnPSKM7" +
       "5lduMKiqfGC1qUHTH42oNYWNpoNyPx0ymGYYa0kyIn3jM4absb1ZrA0w0574" +
       "rUmdyfBa05AlyEYTFZNxOOvMduIqG4iNpVBRp6RfrZasTSsbGWucoaWYbe02" +
       "CW0kkYM3oZ+WUISzskzATTouuwok1VrO+B1bpdrWYLEaNmMRw0bS0BhMV+21" +
       "2A+Hht1f1gw6HA7pcTz1exRn8Uw9C7phW2rSTa1XFakMi7ltGc9ac3eqtpqC" +
       "KQ96RK+hdtY1UY2w9aahuz5AI62cRTVnQg2SQWpLAyFFzalR5sYCviJsaQiS" +
       "NrZrZj4hJHXGkhOy01rQnLXLtJ1Y4fXtNuoClfDmIaix3NjHUD7rkuvIpVN8" +
       "ZLWksoItNXNmsCO/LAntJJrz0WC3jZxqGExmjrHQZI9V+vakV6tr4mZOEKFp" +
       "8liSUUEtE7t+fuZbb9kzp8sqg8GoMdkEY2/WxCTDGyrsMOzjhFbpT0C/MWzZ" +
       "UghKg9SoDbipZe/W7lBCE2ycTjvdsTPmapBOKpUJcda00TbudKaDIdnqsfVB" +
       "Su8GaHnWbmbi3BxBwUn61HoYDG1z7pS7JRJLwCAREnoR8dQwopP6UnH6dMuX" +
       "JV0cRxSF9tbsdDxNWXORDH2WbjpiA1BCSxeGCkxkOahXE9TUF7FHJR2K9yXC" +
       "x7ZJpSavVT9dGyXGrAzj2kzV6XltMGhKG6gXsmAvqVWru8ualD4yhLbptvsr" +
       "Wut3DDtZgSBVaK65mHu9hcK1gyqhYrQehzZGl80xFdXEARwZ3uoSc7kzUdlI" +
       "XeKtSn3WTmVpNyuXNngckNxq1AnX0PI4TWHVnnTGelNTV7azqcVEv7MIOmLH" +
       "USpjg+mNHExSxkl9GtbGix4U0Qnw7e1sVGYiDKc6TIwvSL1m97l5I6tu7JU9" +
       "5nVC6K8SNfGNzmhmjNl2XYJGdbbSCbDT0KWHSTFaJSzVa2Ol0DbRfqsV4+wo" +
       "mwjN7QwwnmHOtAXBmEPQY0gXOG7bi+RSb+UmDNnqNuwVPeHbu6WYG8h4OJ61" +
       "yeoadHpCFNmdjYxzVW7jTdUBM6tvtao/mrYIWmPrVCr3KjSaxstuL5AZsdu3" +
       "d7t0Vh80E0Vu4GipgdbRapfukTXgTGqJR+ryBNvY5HxYDc3t2pN8vNoQW1sC" +
       "cHFYQ+dRaePN+moqV8MRVl60udkStIIFtWpWoPtAoLrL4XUd7PBFxXOplThg" +
       "pdSJlDRgAkB0Bg7jLDJ1tGGrcsc2Gj1xbKjyeiv5LWvqJBPBnQxBKULLYIPz" +
       "W3rO4cFoGJnjxY4PUHYlcfycmUUrlikThCKw805KpdX2OuG08kis1caYsBO0" +
       "WQfdWWyZrG5YnjC5TbNhUVvTHFfWFsFMJ22DN6vEIo2JOsNkaBZ38VYqhu2d" +
       "jo4YIA9tf9ndlGvophcaJK7zdWiaZUffVAA5iZuKuJCsSCTp6kCqoXF3lKTr" +
       "ti4ooBpWXUGsYG17wRnTsYAqqAgNfkPsgUkCTCChHO0Fqb4FyoxqtuP+RkmG" +
       "0bjarO3YSdOYeKlpkWW4YJaEuUuuqrOxQ7fFiSSnrgZXOSpUs4YGsIFNc1ng" +
       "ZZWKzm9Td6lWMHGy8e0uGxrBFEtavDLoMjsGH0R8MmR2mhVpK3fJ9GZ0vzsl" +
       "VH6mmqWu503ZmUUCtEwOgagSTY9brwaOiI+JUF0p84wySWba3JmZ746WTILP" +
       "l9XpUKWt8hI02tMIjzI5RjO93mO7Qnu07Hmm058ux3av3d3tcG4LhQy3Zig/" +
       "rxHkdLVTG+sxj5lkZbAsbTAVbICn6fhccPuApuH6JRBkgvLNRtaINqVKm+EI" +
       "UgnkWMSljr4IMBvUe4O0XWorZID2JmPHqAq9eETKFDlUBa5OtBi3vBDqJbKV" +
       "TTC5Kg8q8WAxjaBoEElq2POIJfvkbLys96uN+pIYdtLxjFwGkYmDnbBE2blN" +
       "0i26LmcrIugz1Z7Bqj2+XiZBl9j6FUswFbdDDOsM9COmoN1kwqQ2btSSqLTt" +
       "sxuM69bGPI01TTaROoutku0I0UDDist6ZeDJpFVzGbHdqXVdaFhsYGdEdTxX" +
       "tdbOmHf7UycVmo3AQomOWql0epv6zumI7Z031XBcJ3hQabcm47rfTjbGvEl2" +
       "vKast9TKtLyrbjODafNNqseImmuyQR3r12PDK/e1aES3h9NSWWuwjcnU9SLN" +
       "YStzJxEGnQnoCIEkzeQWdOUkGueCcNkc4U1Ws1r8WuJKwUYRm3YlrITYyBYM" +
       "pcaG2qRnL7NeWd+NbLCkMGBUUWIk2o7IJA1+TpemWBapFb2Bp7Eh9lQ1GupL" +
       "k+W0bbeJ7RrQpxh1DaJibwej8pZa1DStZ7jlLW9A1yAs4zMgxhtJ5oYCQRC4" +
       "urF9r1zrqyK1XlTX+ExZiBIts6EwpHd9Q5zr2SSZ96rLDCMBJ3s7hYvVnccv" +
       "uoTItNQZSkdOj+mkeslOxc2s4u4qC8JDZXxAVuhOeQY2bWy9TYVyfbSdMw7g" +
       "m/aKzQKXHVlVS11NlcgdUWBalaeOVlVL/WYv2sV1dQZGcD3z01pMqmFUd3cs" +
       "OhyUrPHChKbIdgcpm43YaRxKwmxcgatmKRrgxkK33SaDVx2qLbTAxh3Yqdao" +
       "10gd1BuLkJm4SZPk4lHbrNUIACxunMnQxm+2seTNRZyUoW1mxBrRa3LarkR5" +
       "VL3cqGOtapSw9XEl3kSTiilVpWghqhwba8F25mV9OyypHl1b+8BZGqnMxTvo" +
       "LA+7w5GqMTSfZJgtAJ2Iq85kky6FUd0M50PTaDTV9aQ0kP2NuGjJntWUSYUX" +
       "zHTDl8Jxw4ykVAgW1e1otWovl3qt2i5j7cyQFloM2DWI3WzpudNaPNNb0w1p" +
       "V12+Ot1V4h3eTjvYYi1kLrNe9w2tvOUWsgpXZX5HjabZcsT5ao11dvUytDVD" +
       "fd0vVXboBtsu7K4yVdYUtR4pKN5quw280duOOjoxwtIZaKd4otsdfsHOlS3j" +
       "idHW5jYLThIbY3rV1up4XOuQzlQMO11JnE6ms2HJkLtktli3Y+i/BtiG7TAl" +
       "W+unFb+2xXfVeW9eEaiklJWrUMpqSTOuzUsLIUqFttYOuI3a35k0M4dbFrZr" +
       "j9yIB1XCg9YEcjjY+NFySlCZW8GmQb1CEXxCLzWJJ8rz+bRDy1RVC9qTYMJv" +
       "JjFcL3timbG5SV/BQi5NFp7jhLuxoPOTXsuWg/KOkyTgJmBdZ6L+tjtFF2uC" +
       "WC0dcSCXfDMhZwZve7PyLiSIHVm3O7Nawurttqbz7RphECvKHKB+OaJ3Rm8u" +
       "UcSIHgxKvl0jPJ31S0mpLwqRHwsNbh24yTbaDWmnRvPUcptOMchwDPUoZcPi" +
       "/WVVdIyeVzFq0tbp1EsjYchrwbo+sawB3TW6M86otNhZ3aBjIrVaPc4AzYoh" +
       "dBrs1qjxZLqY2fW6lnqZxTtUXMedMBkOwUqYUgs0jsxSvcy7TWWAk3TSme8o" +
       "rqn06i2PESbAM+YUPQKcPuyX+gPCw0g5UHAq7mMRldAZwYxXtAPkyrg3NeMN" +
       "XcZmHhOz7E7IZlB+UIc36wK1NYT+kupintUVPbldZcayxLHulFk3+zW2TAdN" +
       "2Z4RS5L2hNEG7W4mnCg2RLpkYqWlUF7MqRrdBi2msSN3+lStkFEzS2UtM5Na" +
       "H9TqItkAbCB5qOkypSopktVOWq7KQ3ndQI1yxgc6Dueql4ReIDiNMp5Wa+UF" +
       "hjsqGTRnrq3TPRtUetUdq1X57oTqTTmuQTkNrzZcLdcqOut5TqsKUHmp0wxh" +
       "9jIOJZZEKZM70lDV+/W5a9W2TL9n0czWqAass9rpZWlAY6xcbmxdXTPagHTI" +
       "fpeUDLDoel0UqwvLlk6iAr20XFFELdxc8G13t0a31ajcaGB85g6jsFVuCuv1" +
       "oolhaFZX8FmtBvfH4U5eSijNtYEK97IKvgvJ6bo99Wpc1ms6mtLxuytxxVUZ" +
       "XqsvxYmCpXWN2GU4qjk6nZkldmq0xtnYGDGDZMhvGaETMNW1kA4Ha00y6n1u" +
       "Wx/hIWMSW3zuCShaStFKYydYwaYT1req3nXqqL4ph82KCpRkPbFWlcmA6zo8" +
       "2lhFLpeHuAhmu9JfWxObH0tis0UYqx2bNYw5FAGaV8xk3qpX11qrXFotQOIQ" +
       "OL9CyyhUxYxbeWXJngVpl2JlHpNEH6+MAnIZrycuGE/UXqw3KxIWyc6Q7MEt" +
       "Azmz5kHsEeP1TOvFqCETQ4dwVTKar1x9vNTLfL0pVDmqV677FEUVh2Cfe3un" +
       "ZPcVh3/HsSV/jWO//Wljnnz4+Ky1+FxE9nEIR9+nzlpPXdVcODo2fTw/Nk0I" +
       "9fRp6akL+vxg7LEbRZYUh2Jf+sQrr2rcz5cP9rdJn46RO2I/+JADtsA51eNd" +
       "sKXnb3wAOCoCa05uaH7rE//lUfEHzI+9jWv7J86M82yT/2j0+u/0PqD+nQPk" +
       "luP7mmtCfq6u9MLVtzR3hiDehJ541V3NY1cfdmPwWe0nYHX2sPtkis896T7n" +
       "su4Xzil7LU/+QYy81zq+kqAch7G24PiyIioq/uQp+fqpGLl161vaieB96e3c" +
       "/xUZf/+YBXflmSX4RHsWRG+HBTFyKQitrRKDN+XDr51T9k/z5Fdi5JETPlzN" +
       "hLz89RPA//gmAN+fZ+bhEi/vAb/8duf8xTfF+q/OKfvNPPkXMXKXAWLGVxWH" +
       "3YsrdYLvjZvA954jQ/ITe3w/8c7j+7fnlP1+nnwtRu6G+HK7JCohfDuyXo9d" +
       "x3od3pHn8RAnHPj6TXDgvqMZ/uyeA599");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("5znwjXPKvpUnf3jIAdn3XcrTeMW7nh7fFpl+eAr1H90E6iIIIg9s+8Ie9Rfe" +
       "GdQXTgj+uCD4zjnQ/yxPvg2hR6ehn9HeP7kJlMW18rPw+bk9yp975+f2f55T" +
       "9r08+W8xcudeupt+eiTaT1xHtI8uMYU83u+YAX9xEwx4Ps/M6722Z8Br7zgD" +
       "Llw6p+yOPDmIkYcgA65zNXvEjCvnMONG1XLeXLjlJniT6zzy/fD5yp43X3nn" +
       "efPgOWUP58nlGHkf5E3nzS70nzqHQ/tb/BOu3HcTXHn6iCu/vufKr79drryp" +
       "k3Ph6XPKns2Tx2PkYciVG8VgLE+gPnETUB/IMx+Fz1f3UL/6zkM9JyDvQh6Q" +
       "d+F56BR5IGF9DRzN9eXTc31cUMAt3QTcJ/PMBnx+dw/3d995uC+eU/aDeVKH" +
       "bhuc2bOhRsfhQ/MTrI23FacG2XY2+jiPo3zkmj83HAbkq7/06r23P/zq9N8X" +
       "AbjHQfN3MMjt+sZxTodunXq/GIRAtwou3HEYyBUU0LoQ1Y3iU2LkFpjmA77Q" +
       "OaTux8i7r0cNKWF6mpLZC8NpSugHFN+n6Ti4xJzQxcjFw5fTJAJsHZLkr5Pg" +
       "SNKuH2F4HFRztEk83E0+clqsipXp/jeboeMqp4N7871h8c+Uo33c5vC/KS+p" +
       "X351wP7od6s/fxhcrDrKbpe3cjuDXDqMcy4azfeCT96wtaO2LtLPfe+eX77j" +
       "2aN96z2HAz4R8VNje+L6YbwdN4iLwNvdrz38lQ//w1e/UYTP/D+9i/yZMjQA" +
       "AA==");
}
