package org.apache.batik.dom.svg;
public abstract class AbstractSVGPathSegList extends org.apache.batik.dom.svg.AbstractSVGList implements org.w3c.dom.svg.SVGPathSegList, org.apache.batik.dom.svg.SVGPathSegConstants {
    public static final java.lang.String SVG_PATHSEG_LIST_SEPARATOR = " ";
    protected AbstractSVGPathSegList() { super(); }
    protected java.lang.String getItemSeparator() { return SVG_PATHSEG_LIST_SEPARATOR;
    }
    protected abstract org.w3c.dom.svg.SVGException createSVGException(short type,
                                                                       java.lang.String key,
                                                                       java.lang.Object[] args);
    public org.w3c.dom.svg.SVGPathSeg initialize(org.w3c.dom.svg.SVGPathSeg newItem)
          throws org.w3c.dom.DOMException,
        org.w3c.dom.svg.SVGException { return (org.w3c.dom.svg.SVGPathSeg)
                                                initializeImpl(
                                                  newItem);
    }
    public org.w3c.dom.svg.SVGPathSeg getItem(int index)
          throws org.w3c.dom.DOMException {
        return (org.w3c.dom.svg.SVGPathSeg)
                 getItemImpl(
                   index);
    }
    public org.w3c.dom.svg.SVGPathSeg insertItemBefore(org.w3c.dom.svg.SVGPathSeg newItem,
                                                       int index)
          throws org.w3c.dom.DOMException,
        org.w3c.dom.svg.SVGException { return (org.w3c.dom.svg.SVGPathSeg)
                                                insertItemBeforeImpl(
                                                  newItem,
                                                  index);
    }
    public org.w3c.dom.svg.SVGPathSeg replaceItem(org.w3c.dom.svg.SVGPathSeg newItem,
                                                  int index)
          throws org.w3c.dom.DOMException,
        org.w3c.dom.svg.SVGException { return (org.w3c.dom.svg.SVGPathSeg)
                                                replaceItemImpl(
                                                  newItem,
                                                  index);
    }
    public org.w3c.dom.svg.SVGPathSeg removeItem(int index)
          throws org.w3c.dom.DOMException {
        return (org.w3c.dom.svg.SVGPathSeg)
                 removeItemImpl(
                   index);
    }
    public org.w3c.dom.svg.SVGPathSeg appendItem(org.w3c.dom.svg.SVGPathSeg newItem)
          throws org.w3c.dom.DOMException,
        org.w3c.dom.svg.SVGException { return (org.w3c.dom.svg.SVGPathSeg)
                                                appendItemImpl(
                                                  newItem);
    }
    protected org.apache.batik.dom.svg.SVGItem createSVGItem(java.lang.Object newItem) {
        org.w3c.dom.svg.SVGPathSeg pathSeg =
          (org.w3c.dom.svg.SVGPathSeg)
            newItem;
        return createPathSegItem(
                 pathSeg);
    }
    protected void doParse(java.lang.String value,
                           org.apache.batik.dom.svg.ListHandler handler)
          throws org.apache.batik.parser.ParseException {
        org.apache.batik.parser.PathParser pathParser =
          new org.apache.batik.parser.PathParser(
          );
        org.apache.batik.dom.svg.AbstractSVGPathSegList.PathSegListBuilder builder =
          new org.apache.batik.dom.svg.AbstractSVGPathSegList.PathSegListBuilder(
          handler);
        pathParser.
          setPathHandler(
            builder);
        pathParser.
          parse(
            value);
    }
    protected void checkItemType(java.lang.Object newItem) {
        if (!(newItem instanceof org.w3c.dom.svg.SVGPathSeg)) {
            createSVGException(
              org.w3c.dom.svg.SVGException.
                SVG_WRONG_TYPE_ERR,
              "expected SVGPathSeg",
              null);
        }
    }
    protected org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem createPathSegItem(org.w3c.dom.svg.SVGPathSeg pathSeg) {
        org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem pathSegItem =
          null;
        short type =
          pathSeg.
          getPathSegType(
            );
        switch (type) {
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_ARC_ABS:
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_ARC_REL:
                pathSegItem =
                  new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegArcItem(
                    pathSeg);
                break;
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_CLOSEPATH:
                pathSegItem =
                  new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem(
                    pathSeg);
                break;
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_CURVETO_CUBIC_ABS:
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_CURVETO_CUBIC_REL:
                pathSegItem =
                  new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoCubicItem(
                    pathSeg);
                break;
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_CURVETO_CUBIC_SMOOTH_ABS:
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_CURVETO_CUBIC_SMOOTH_REL:
                pathSegItem =
                  new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoCubicSmoothItem(
                    pathSeg);
                break;
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_CURVETO_QUADRATIC_ABS:
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_CURVETO_QUADRATIC_REL:
                pathSegItem =
                  new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoQuadraticItem(
                    pathSeg);
                break;
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS:
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL:
                pathSegItem =
                  new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoQuadraticSmoothItem(
                    pathSeg);
                break;
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_LINETO_ABS:
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_LINETO_REL:
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_MOVETO_ABS:
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_MOVETO_REL:
                pathSegItem =
                  new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegMovetoLinetoItem(
                    pathSeg);
                break;
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_LINETO_HORIZONTAL_REL:
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_LINETO_HORIZONTAL_ABS:
                pathSegItem =
                  new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegLinetoHorizontalItem(
                    pathSeg);
                break;
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_LINETO_VERTICAL_REL:
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_LINETO_VERTICAL_ABS:
                pathSegItem =
                  new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegLinetoVerticalItem(
                    pathSeg);
                break;
            default:
        }
        return pathSegItem;
    }
    protected class SVGPathSegItem extends org.apache.batik.dom.svg.AbstractSVGItem implements org.w3c.dom.svg.SVGPathSeg, org.w3c.dom.svg.SVGPathSegClosePath {
        protected short type;
        protected java.lang.String letter;
        protected float x;
        protected float y;
        protected float x1;
        protected float y1;
        protected float x2;
        protected float y2;
        protected float r1;
        protected float r2;
        protected float angle;
        protected boolean largeArcFlag;
        protected boolean sweepFlag;
        protected SVGPathSegItem() { super(
                                       );
        }
        public SVGPathSegItem(short type,
                              java.lang.String letter) {
            super(
              );
            this.
              type =
              type;
            this.
              letter =
              letter;
        }
        public SVGPathSegItem(org.w3c.dom.svg.SVGPathSeg pathSeg) {
            super(
              );
            type =
              pathSeg.
                getPathSegType(
                  );
            switch (type) {
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CLOSEPATH:
                    letter =
                      PATHSEG_CLOSEPATH_LETTER;
                    break;
                default:
            }
        }
        protected java.lang.String getStringValue() {
            return letter;
        }
        public short getPathSegType() { return type;
        }
        public java.lang.String getPathSegTypeAsLetter() {
            return letter;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1aC2wcxRmeOz9iO37HdoITO4ljQhPSOwIEikxTHGMTp+fE" +
           "ikNUnBJnb2983mRvd9mds8+hKQ+pTdqqiIbwFEStFBSKgKCq9KECSkVboNBW" +
           "PAqlFVC1VXmkUWIeSWh49P9ndm/39m4v2KJE2rn1zP/4/n/++eef2TxwlJRZ" +
           "JmmnGouwSYNakV6NDUqmRRM9qmRZm6BvRL69RHp365vrLwmT8mFSOyZZA7Jk" +
           "0T6FqglrmLQpmsUkTabWekoTyDFoUoua4xJTdG2YNCtWf8pQFVlhA3qCIsFm" +
           "yYyRBokxU4mnGe23BTDSFgMkUY4k2u0f7oqRalk3Jl3yeR7yHs8IUqZcXRYj" +
           "9bHt0rgUTTNFjcYUi3VlTHKuoauTSVVnEZphke3qKtsF62Kr8lzQ8XDdidM3" +
           "j9VzF8yRNE1n3DxrI7V0dZwmYqTO7e1Vacq6hnyTlMTIbA8xI50xR2kUlEZB" +
           "qWOtSwXoa6iWTvXo3BzmSCo3ZATEyOJcIYZkSilbzCDHDBIqmG07ZwZrF2Wt" +
           "FVbmmXjrudF9t2+t/0kJqRsmdYo2hHBkAMFAyTA4lKbi1LS6EwmaGCYNGkz2" +
           "EDUVSVV22jPdaClJTWJpmH7HLdiZNqjJdbq+gnkE28y0zHQza94oDyj7r7JR" +
           "VUqCrS2urcLCPuwHA6sUAGaOShB3NkvpDkVLMLLQz5G1sfOrQACss1KUjelZ" +
           "VaWaBB2kUYSIKmnJ6BCEnpYE0jIdAtBkpDVQKPrakOQdUpKOYET66AbFEFBV" +
           "ckcgCyPNfjIuCWap1TdLnvk5uv7Sm67V1mphEgLMCSqriH82MLX7mDbSUWpS" +
           "WAeCsXp57Dap5bE9YUKAuNlHLGh+/o2py1a0H35K0MwvQLMhvp3KbEQ+EK99" +
           "bkHPsktKEEaFoVsKTn6O5XyVDdojXRkDMkxLViIORpzBwxt/d9X199MjYVLV" +
           "T8plXU2nII4aZD1lKCo1r6AaNSVGE/2kkmqJHj7eT2bBe0zRqOjdMDpqUdZP" +
           "SlXeVa7zv8FFoyACXVQF74o2qjvvhsTG+HvGIITUwkOWwvMWEf/ewIaReHRM" +
           "T9GoJEuaounRQVNH+60oZJw4+HYsGoeo3xG19LQJIRjVzWRUgjgYo/ZAQk9F" +
           "rfFktDsOgS7JbGjzFYOgeIgmMf9EMNaMz0VLBm2dMxEKwTQs8CcBFdbPWl1N" +
           "UHNE3pde0zv10MgzIsBwUdheYmQ1KI4IxRGuOAKKI6A4Ulhxp/tnP6MpEgpx" +
           "9U2IR0QAzN8OyARAW71s6Op12/Z0lEDoGROl4PwSIO3I2ZJ63HTh5PgR+VBj" +
           "zc7Fr618IkxKY6QRMKQlFXeYbjMJuUveYS/v6jhsVu6escizZ+BmZ+oyTUDK" +
           "Cto7bCkV+jg1sZ+RJo8EZ0fDtRsN3k8K4ieH75i4YfN154VJOHebQJVlkOGQ" +
           "fRCTezaJd/rTQyG5dbvfPHHotl26myhy9h1nu8zjRBs6/AHid8+IvHyR9MjI" +
           "Y7s6udsrIZEzCRYe5Mh2v46cPNTl5HS0pQIMHtXNlKTikOPjKjZm6hNuD4/c" +
           "Bv7eBGHRiAtzETyn7ZXKf3G0xcB2roh0jDOfFXzP+PKQcc9f/vjWBdzdzvZS" +
           "56kLhijr8qQ0FNbIk1eDG7abTEqB7tU7Bm+59ejuLTxmgWJJIYWd2PZAKoMp" +
           "BDd/66lrXnn9tQMvhrNxHmKk0jB1BiueJjJZOyvQrIYidoLCpS4kyIoqSMDA" +
           "6bxSgxBVRhUprlJcWx/Wnb3ykf/cVC9CQYUeJ5JWnFmA23/WGnL9M1tPtnMx" +
           "IRl3ZddtLplI9XNcyd2mKU0ijswNz7fd+aR0D2wakKgtZSfluZdwNxA+b6u4" +
           "/efx9kLf2MXYnG154z93iXmqpxH55heP12w+/vgUR5tbfnmne0AyukSEYbM0" +
           "A+Ln+vPTWskaA7oLD6//er16+DRIHAaJMqRia4MJSTOTExw2ddmsv/76iZZt" +
           "z5WQcB+pUnUp0SfxdUYqIcCpNQb5NmN85TIxuRM43fXcVJJnfF4HOnhh4anr" +
           "TRmMO3vnL+b+9NKD+1/jgWZwEW3Z4KpDMW3wfGQH10eFFxG25/B2OTZfdAK2" +
           "3EjHoZb3RWttEYG+eQ1zSeHcFI9pdCgNW8mgqaRg9Y3bpcv5g9vkPZ2D/xJl" +
           "yVkFGARd833R729+efuzfG1XYMLHflRZ40nnsDF4Eku9MOET+BeC52N8EDp2" +
           "iBKgsceuQxZlCxHDwDhZVuTkkGtAdFfj6zvufvNBYYC/UPMR0z37vvtJ5KZ9" +
           "YrWKanZJXkHp5REVrTAHmwFEt7iYFs7R98ahXb+6b9dugaoxtzbrhaPHgy99" +
           "9Gzkjr8/XaAUKIP4NVl2OkMiMDDp5s6OMOny79Q9enNjSR9sFv2kIq0p16Rp" +
           "f8IrE8pxKx33TJdbJ/MOr3E4NYyEluMsYM88ONjxxYBFe0QU7Zy+v0gy2YrN" +
           "Gj70JWx6hKyuGS5I7OgOWmWhsJApfgNWGTa9eespkNVnmjMBtj9asVKbuEDO" +
           "FmhuJcZ1jhXxDD9QyK5nEp+FZ8TAfN5ZgyVoTmHHLxHc2uL+Fy7+88Ef3DYh" +
           "ArPIMvPxzfvvBjV+4z9O5aV8XkoVWHk+/uHoA3e39qw+wvndmga5OzP5ZTPU" +
           "hS7v+fen3g93lP82TGYNk3rZPrRvltQ0VgrDcFC1nJM8HOxzxnMPneKE1ZWt" +
           "2Rb4l75Hrb+a8q6nUpazdnwFFOb+I3aqPuKPyhDhLxk3MM/NL0uCuJmrOeaG" +
           "N4+kyTNFkplf5R211RwNAHldUZBB3LCDqZQxMbdbfDCvnybMVniO2YqOBcD8" +
           "dlGYQdyQ5QSWdXZax58NnvchhgGgS3mZGP+8KuMzbPcMDDtuQzseYNjeooYF" +
           "cYNhk/jyPR/CW6aJcD48U7aOqQCEdxZFGMTNSDizshDEu2YA8R1byTsBEH9Y" +
           "FGIQN0CcLAjxRzOA+K6t5N0AiAeLQgziRi+eXwjifTOA+J6t5L0AiA8VhRjE" +
           "jV4sCPHQDCC+byt5PwDiI0UhBnEDRLPgRP9sBhBP2EpOBEB8tCjEIG6EWNCL" +
           "j00TYjs8J20lJwMgPlEUYhA3pErYX8VloB/lb6aJ8hx4Ttl6TgWg/H1RlEHc" +
           "jFSrkpmEU4rc5+zsRbL/rLiuq1TSPlX+f2aaVnbC84GN84MAK18qamUQN4P6" +
           "foJSA03Ejj/5kL5cBGnBsoQXmzXEvrd1fj0aPfVnGF8Vp1ReElwq96i6RfEd" +
           "z1NtQXfy/Cx14MZ9+xMb7l0ZtovoTVBh2J9KXMV4o9mWU/gO8E8QbhX5au3e" +
           "f/6yM7lmOpeZ2Nd+hutK/HshlLDLg2tpP5Qnb3y7ddPqsW3TuJdc6HORX+SP" +
           "Bx54+oql8t4w/94iytu87zS5TF25RW2VSVna1HKPhUuyUXCWvTZDs0UQiF9v" +
           "1LpxFhCygaxFTkzHioxNYfM2I7VJysTRlNf82LvFjfcjn9np899Zi5pxbAlY" +
           "UmdbVHcGZxQ4fQaxFjH4wyJjH2NzUjjDXmPOVMZcZ5z6PzijBcdWgCVNtkVN" +
           "03dGEGuwwaHKImOzsSllpCXXGd1WzD2ZZJ0SKvtMTuHg+txvMk4WjE7z0w5k" +
           "snl5n5LF50/5of11FXP3X/kyT2LZT5TVkI5G06rqPaJ63ssNk44qfBaqxYHV" +
           "4F5qZmReEDYGGXWcb5GhJkENljQVogZKaL2U8xmp91NChcB/vXTtjFS5dJDV" +
           "xYuXZDFIBxJ87TAch37h0zgUZyAT8uwQ9tTxZdB8phnPsni/PGBe5/8VwMnB" +
           "afGfAUbkQ/vXrb926qJ7xZcPWZV27kQps2NklvgIk83jiwOlObLK1y47Xftw" +
           "5dnOdtcgALtraL5n1XfDmjHwyrrV903A6sx+GnjlwKWP/2FP+fNhEtpCQhIj" +
           "c7bk34lkjDRsoFti+VeMsOfxjxVdy+6aXL1i9Njf+K03EVeSC4LpR+QXD179" +
           "wt55B9rDZHY/KYOdnGb4Zc3lk9pGKo+bw6RGsXozABGkKJKac39Zi8EtYVLn" +
           "frHdWZPtxe9mjHTkX97mf22sUvUJaq7R01qC72yw57o9zn6esxWmDcPH4PbY" +
           "U4nt17AZyOBsQJyOxAYMw7nbLm81eGK4KrB6DK3ir/h20f8AHSsgDCYkAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "TWHtpNsDuf4l+KB5UMl//9b5E9+VVz8Edrek+Gqabx7zQPWOkLzD8fTrR+my" +
           "bMYJSHuuO14z7z67C5K3jQtkXw+dpL9sGMye/+R///Tv/cRzXwEpUq90aZWn" +
           "LyAzOpUj88v8I+7f+fxnnnzbS3/0yeLtGWhN/tE3rn0k5/pvbyVdXvzrvPjy" +
           "kVjXcrGGxbcpVk1SrnjbNY1csvP8424PQHzL0qZXP0DXky529MdW1Ta81jPR" +
           "N/tbdN6vNWkj7Er9uucMbGHYX3fJuZtJdIeTorIF6vwowHuBBqOtmi+uDNQ3" +
           "klbZZgblSDIWi3lXW1PkMKXwITNj2guUIdtDV9ZCHh8L2MKj5HZVnvjuaNw1" +
           "h2O7jgpoYPhQDfXrK5jpkXAcVLcCVIcCqFw2TQuWsrXXE5We7wedcLkeTnnV" +
           "lRs8MVr4osihoFT8Br4S2QYq0lGtgaxidu1LLZ8a9jeKgjV7bkVqUIuZF/vs" +
           "IPKTkSup2th0Q2lDUOEoXKr1rCcZHXjKt9Ox1YoGlOzZWG3R7iaUv5luRDx0" +
           "s1EdzG/CNVwihtSMc0fTugsvK1YzXIiq59Z6Xm1jis0NnbS6o4WiT8Spg2p0" +
           "WolnI0niKUefjuY12ZNoZhmqS2koywGpRLZr1hZMmlANmIlb3nbQmhDG3OBq" +
           "DipvqdZG5MlqUCOyuNuUK4ay9qcLqd80q7KqLxp2sJE8TupqWCvrIpVMhN2R" +
           "Ryr4YtxPh+tJqDbmY2k1CWv41h+2w5qCSeSm39O7U8Udzj1t2yZoAu8u/E6l" +
           "qayVmILHKSVrvj9x4qVBoSlcTqGK21uIiW9MQ9imcRfjKGwjYXWP0eZVdtgg" +
           "177aaU/5jruFSWIkA7lg2BEMte31pHEv8ukmzRpzhV84PUNblGeBS8KtTWVL" +
           "D7YqWg+JjdOMmz1RHi3a8RAGa4BtC8s1jTWSEdZR+0Mbr/HuKiJcmeVYdrBF" +
           "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" +
           "973x0K/d956jeP/QDvDJwjiF7enzb66R");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          "fpQWd822v/GOf/TBX3r5D4uTgv8LIriWWUYvAAA=";
    }
    public class SVGPathSegMovetoLinetoItem extends org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem implements org.w3c.dom.svg.SVGPathSegMovetoAbs, org.w3c.dom.svg.SVGPathSegMovetoRel, org.w3c.dom.svg.SVGPathSegLinetoAbs, org.w3c.dom.svg.SVGPathSegLinetoRel {
        public SVGPathSegMovetoLinetoItem(short type,
                                          java.lang.String letter,
                                          float x,
                                          float y) {
            super(
              type,
              letter);
            this.
              x =
              x;
            this.
              y =
              y;
        }
        public SVGPathSegMovetoLinetoItem(org.w3c.dom.svg.SVGPathSeg pathSeg) {
            super(
              );
            type =
              pathSeg.
                getPathSegType(
                  );
            switch (type) {
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_REL:
                    letter =
                      PATHSEG_LINETO_REL_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegLinetoRel)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegLinetoRel)
                         pathSeg).
                        getY(
                          );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_ABS:
                    letter =
                      PATHSEG_LINETO_ABS_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegLinetoAbs)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegLinetoAbs)
                         pathSeg).
                        getY(
                          );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_MOVETO_REL:
                    letter =
                      PATHSEG_MOVETO_REL_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegMovetoRel)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegMovetoRel)
                         pathSeg).
                        getY(
                          );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_MOVETO_ABS:
                    letter =
                      PATHSEG_MOVETO_ABS_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegMovetoAbs)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegMovetoAbs)
                         pathSeg).
                        getY(
                          );
                    break;
                default:
            }
        }
        public float getX() { return x; }
        public float getY() { return y; }
        public void setX(float x) { this.
                                      x =
                                      x;
                                    resetAttribute(
                                      ); }
        public void setY(float y) { this.
                                      y =
                                      y;
                                    resetAttribute(
                                      ); }
        protected java.lang.String getStringValue() {
            return letter +
            ' ' +
            java.lang.Float.
              toString(
                x) +
            ' ' +
            java.lang.Float.
              toString(
                y);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "mb9i88H/ALAcAlDnGwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "+e++7jef/mp+f/C/YkkGDfsmAAA=");
    }
    public class SVGPathSegCurvetoCubicItem extends org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem implements org.w3c.dom.svg.SVGPathSegCurvetoCubicAbs, org.w3c.dom.svg.SVGPathSegCurvetoCubicRel {
        public SVGPathSegCurvetoCubicItem(short type,
                                          java.lang.String letter,
                                          float x1,
                                          float y1,
                                          float x2,
                                          float y2,
                                          float x,
                                          float y) {
            super(
              type,
              letter);
            this.
              x =
              x;
            this.
              y =
              y;
            this.
              x1 =
              x1;
            this.
              y1 =
              y1;
            this.
              x2 =
              x2;
            this.
              y2 =
              y2;
        }
        public SVGPathSegCurvetoCubicItem(org.w3c.dom.svg.SVGPathSeg pathSeg) {
            super(
              );
            this.
              type =
              pathSeg.
                getPathSegType(
                  );
            switch (type) {
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_CUBIC_ABS:
                    letter =
                      PATHSEG_CURVETO_CUBIC_ABS_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicAbs)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicAbs)
                         pathSeg).
                        getY(
                          );
                    x1 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicAbs)
                         pathSeg).
                        getX1(
                          );
                    y1 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicAbs)
                         pathSeg).
                        getY1(
                          );
                    x2 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicAbs)
                         pathSeg).
                        getX2(
                          );
                    y2 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicAbs)
                         pathSeg).
                        getY2(
                          );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_CUBIC_REL:
                    letter =
                      PATHSEG_CURVETO_CUBIC_REL_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicRel)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicRel)
                         pathSeg).
                        getY(
                          );
                    x1 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicRel)
                         pathSeg).
                        getX1(
                          );
                    y1 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicRel)
                         pathSeg).
                        getY1(
                          );
                    x2 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicRel)
                         pathSeg).
                        getX2(
                          );
                    y2 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicRel)
                         pathSeg).
                        getY2(
                          );
                    break;
                default:
            }
        }
        public float getX() { return x; }
        public float getY() { return y; }
        public void setX(float x) { this.
                                      x =
                                      x;
                                    resetAttribute(
                                      ); }
        public void setY(float y) { this.
                                      y =
                                      y;
                                    resetAttribute(
                                      ); }
        public float getX1() { return x1;
        }
        public float getY1() { return y1;
        }
        public void setX1(float x1) { this.
                                        x1 =
                                        x1;
                                      resetAttribute(
                                        );
        }
        public void setY1(float y1) { this.
                                        y1 =
                                        y1;
                                      resetAttribute(
                                        );
        }
        public float getX2() { return x2;
        }
        public float getY2() { return y2;
        }
        public void setX2(float x2) { this.
                                        x2 =
                                        x2;
                                      resetAttribute(
                                        );
        }
        public void setY2(float y2) { this.
                                        y2 =
                                        y2;
                                      resetAttribute(
                                        );
        }
        protected java.lang.String getStringValue() {
            return letter +
            ' ' +
            java.lang.Float.
              toString(
                x1) +
            ' ' +
            java.lang.Float.
              toString(
                y1) +
            ' ' +
            java.lang.Float.
              toString(
                x2) +
            ' ' +
            java.lang.Float.
              toString(
                y2) +
            ' ' +
            java.lang.Float.
              toString(
                x) +
            ' ' +
            java.lang.Float.
              toString(
                y);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1Ze2wcxRmfOz/i2PEzbydxXgbkEO4IkFSR05DEOInDJTnF" +
           "YBGn5LK3N2dvvLe77M7Z59CUh6BJoYUoGBJKCVJrFCgPoyr0oQIKilSgUFQo" +
           "glIEVAKpKW3URFXhDwr0+2b2bvf27tY6hGvJ4/XM930z32++18w8eY5UWSZp" +
           "oxoLsVGDWqFujUUl06KJLlWyrOugLyYfq5D+vffsjrVBUt1PGgYla7ssWXSz" +
           "QtWE1U8WKZrFJE2m1g5KE8gRNalFzWGJKbrWT2YrVk/KUBVZYdv1BEWCPsmM" +
           "kGaJMVOJpxntsQUwsigCKwnzlYQ3eoc7I2SGrBujDvk8F3mXawQpU85cFiNN" +
           "kf3SsBROM0UNRxSLdWZMcqmhq6MDqs5CNMNC+9XVNgTbIqsLIFj2TOOnnx8Z" +
           "bOIQzJQ0TWdcPWsXtXR1mCYipNHp7VZpyrqJfI9UREidi5iR9kh20jBMGoZJ" +
           "s9o6VLD6eqqlU106V4dlJVUbMi6IkaX5QgzJlFK2mChfM0ioYbbunBm0XZLT" +
           "VmhZoOL9l4bHju1t+kUFaewnjYrWi8uRYREMJukHQGkqTk1rYyJBE/2kWYPN" +
           "7qWmIqnKAXunWyxlQJNYGrY/Cwt2pg1q8jkdrGAfQTczLTPdzKmX5AZl/1eV" +
           "VKUB0HWOo6vQcDP2g4K1CizMTEpgdzZL5ZCiJRhZ7OXI6dh+LRAA67QUZYN6" +
           "bqpKTYIO0iJMRJW0gXAvmJ42AKRVOhigyUhrSaGItSHJQ9IAjaFFeuiiYgio" +
           "pnMgkIWR2V4yLgl2qdWzS679Obdj3T03a1u1IAnAmhNUVnH9dcDU5mHaRZPU" +
           "pOAHgnHGisgD0pznDwcJAeLZHmJB86vvXtiwsu30y4JmQRGanfH9VGYxeTze" +
           "8MbCro61FbiMGkO3FNz8PM25l0Xtkc6MARFmTk4iDoayg6d3/W73rT+n/wiS" +
           "2h5SLetqOgV21CzrKUNRqbmFatSUGE30kOlUS3Tx8R4yDb4jikZF785k0qKs" +
           "h1SqvKta5/8DREkQgRDVwreiJfXstyGxQf6dMQghdfBLVhISuJHwn8AebBmJ" +
           "hwf1FA1LsqQpmh6Omjrqb4Uh4sQB28FwHKx+KGzpaRNMMKybA2EJ7GCQ2gMJ" +
           "PRW2hgfCG+Ng6JLMevu2RGHiXjqA8SeEtmb8X2bJoK4zRwIB2IaF3iCggv9s" +
           "1dUENWPyWHpT94WnY68KA0OnsFFiZBtMHBITh/jEIZg4BBOHik/c7vzblTaH" +
           "KdO70nFF7mE0RQIBvpRZuDZhDbCXQxAVgG9GR++N2/YdXlYBZmiMVMJGBIF0" +
           "WV566nJCRzbex+SJlvoDSz9YdSZIKiOkBdaTllTMNhvNAYhj8pDt6jPikLic" +
           "/LHElT8w8Zm6TBMQvkrlEVtKjT5MTexnZJZLQja7oR+HS+eWousnp4+P3NZ3" +
           "y+VBEsxPGThlFUQ7ZI9ioM8F9HZvqCgmt/HQ2U8nHjioO0EjLwdlU2cBJ+qw" +
           "zGssXnhi8ool0rOx5w+2c9inQ1BnEjghxMs27xx5MakzG99RlxpQOKmbKUnF" +
           "oSzGtWzQ1EecHm7Fzfx7FphFIzppB3hrzPZa/hdH5xjYzhVWj3bm0YLnj2/3" +
           "Gg//+fW/X8nhzqaaRleN0EtZpyu8obAWHsiaHbO9zqQU6N4/Hr3v/nOH9nCb" +
           "BYrlxSZsx7YLwhpsIcB858s3vfvhB+NvBXN2HmCQ39NxKJMyOSVrUKcGHyVh" +
           "toud9UB4VCF4oNW0X6+BfSpJRYqrFB3rv40XrXr2n/c0CTtQoSdrRisnF+D0" +
           "z99Ebn1172dtXExAxvTsYOaQiZg/05G80TSlUVxH5rY3Fz34kvQwZA+I2JZy" +
           "gPIgXMMxqMn3dfSn3jTEl6ippGAbhu18dkV0n3y4PfqxyFXzizAIutmPhX/U" +
           "987+1/gm16DnYz/qXe/ya4gQLgtrEuB/BT8B+P0SfxF07BB5oaXLTk5LctnJ" +
           "MDKw8g6fcjJfgfDBlg+HfnL2KaGAN3t7iOnhsbu+Ct0zJnZOlDjLC6oMN48o" +
           "c4Q62KzF1S31m4VzbP7bxMHfPnbwkFhVS37C7oZ69Km3v3gtdPyvrxTJD1XW" +
           "oG6KQvUqNFRh0uh9+bsjVLrmB43PHWmp2AxRo4fUpDXlpjTtSbhlQo1mpeOu" +
           "7XKKJ97hVg63hpHACtwF7JkH1T63PKzkQqKS4wNrbDDwT6fr+2qGIUCXCtaP" +
           "/3bzqXqKNXxkNWe6PMdKOCvhYzuxuchyh+p803AV/TH5yFvn6/vOv3CBw5t/" +
           "anBHpu2SIfa2GZuLcW/nelPpVskaBLqrTu/4TpN6+nOQ2A8SZaggrJ0m5PpM" +
           "Xhyzqaum/eXFM3P2vVFBgptJLeCR2CzxlECmQyymsMNqImNcvUHEohEMTk1c" +
           "VVKgfEEHhoPFxQNNd8pgPDQc+PXcU+tOnviAx0SDi1hUGO+H7FA4VDzeY3sJ" +
           "NpcWRtFSrJ4dzBqvbUutWPqMXCnnKh6ntOFzxnwMQMamnw9FsdkjkOn9miBi" +
           "x27byhe4qTwa85HabCmb/evVeIFdX9l6dpTW013CQb1XJscuqqKRLip1suHB" +
           "Z/z2sROJnY+uCtrIbYB0aB84nbXWo5i8WnA7P8g59cj7DUc/+k37wKZyykDs" +
           "a5uk0MP/F4PXrCgd471Leen2T1qvWz+4r4yKbrEHIq/Ix7c/+cqWi+WjQX5q" +
           "FcVcwWk3n6kzP6rWmhSO51p+HF2eM5zZaCfzwWDusA3njvK9rBSrj5sc9Bm7" +
           "BZsMI5UDlN3Aw67jTqPfhDvxflYIwSFbj0PlQ1CK1UfNu3zGfojNnQKC3R4I" +
           "vj8FEPBYuxTWf7etx93lQ1CKtXisddLpMR8cHsTmKOAAx/sbimXxymFdSTjY" +
           "3DeV2NxrK3hv+diUYp0Mm5M+2DyOzU8FNtxGHnJw+NlUuUkrLG/MVmasfBxK" +
           "sfqoecpn7JfYTEAth5FilcdPnplKDI7ZihwrH4NSrD56vugzdgab5wQGu70Y" +
           "PD9V/rAcFHjIVuSh8jEoxTqZP7zuA8QfsXkFDyZZY3A5xO+nEohHbG0eKR+I" +
           "UqyTAfGeDxDvY/O2AGK3F4h3ptIrxm1txssHohSrj55nfcY+weYjOzJc4fGK" +
           "j6cSg5O2IifLx6AUq4+e//EZ+wyb83Zk8GJwYSod4glbkSfKx6AU6yQOEQiW" +
           "BiJQiZ1f2JHhCo9DfDmVQEzY2kyUD0Qp1smAaPQBAu8PArV2ZPAAEaibAiDm" +
           "49glsL5TtjanfIDg7QpsLsvej043TJ1RmdGE54q02UemDwBtPmNLsJnLSAO4" +
           "i7hC6pPUND80bXFQmveNnOcZaS39XMK54LAdLvMFBo7K8wpefMUrpfz0icaa" +
           "uSeuf4efknMviTPgvJtMq6rruOg+OlYbJk0qfItmiPsngyO1gpF5pdbGSAW0" +
           "qEKgQ1BfxsisYtRACa2b8nJGmryUYKz8r5vuSkZqHTpGqsWHm2QNSAcS/PyW" +
           "kQV0/dd/0sJ9yYgLorxrGB5CZk9mEzkW91MBXifwd/zs0T8tXvJj8sSJbTtu" +
           "vrDmUfFUIavSgQMopS5CpolXEy4Urw+WlpSWlVW9tePzhmemX5S9ZWkWC3bc" +
           "boErY+wGbzLw4q7Vc49vteeu898dX/fCHw5XvxnEO6aAxMjMPa5XdPFk3Jkx" +
           "0iZZtCdSeBXcJ5n8gaGz48ej61cm//Uev/sj4up4YWn6mPzWyRv/dHTeeFuQ" +
           "1PWQKkVL0Ew/qVWsa0a1XVQeNvtJvWJ1Z2CJIEWR1Lx75gY0eQmdmuNiw1mf" +
           "68WHLkaWFV6yFz4P1qr6CDU36WktgWLqI6TO6RE747mBSRuGh8HpsbcS22uw" +
           "WZvB3QDrjUW2G0b2DWLaLQYPHd3F4j6/rw5s45/4de3/ALHqphbjIwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL16CbDk1lmu7thjjye2Z+xszpA4djIBnE5ddavVGw4hUner" +
           "1WqpW2p1t7oVYKJd6tbW2lot8COkAk4RKgk8Z3kFMVWvzAuLg1lCAUUFTLGm" +
           "QlGEYn31IMB7VYQlBaliNzzekfpuc2fm5jkZc6vuf3XP+c85//dvZ332C9D5" +
           "MIBKvmdvDduL9rU02l/atf1o62vhPkXXWCkINbVtS2E4AWXXlDf8+KV/fOGD" +
           "5uVz0F0i9HLJdb1IiizPDcda6NmJptLQpePSrq05YQRdppdSIsFxZNkwbYXR" +
           "4zT0shNNI+gqfSgCDESAgQhwIQKMHXOBRvdpbuy08xaSG4Vr6L9AezR0l6/k" +
           "4kXQo9d34kuB5Bx0wxYIQA8X8v9nAFTROA2gR46w7zDfAPhDJfipj3zz5Z+8" +
           "A7okQpcsl8/FUYAQERhEhO51NEfWghBTVU0VoQdcTVN5LbAk28oKuUXowdAy" +
           "XCmKA+1ISXlh7GtBMeax5u5VcmxBrERecARPtzRbPfzvvG5LBsD6qmOsO4RE" +
           "Xg4AXrSAYIEuKdphkztXlqtG0OtPtzjCeHUAGEDTux0tMr2joe50JVAAPbiz" +
           "nS25BsxHgeUagPW8F4NRIujKLTvNde1LykoytGsR9NBpPnZXBbjuKRSRN4mg" +
           "V55mK3oCVrpyykon7POF4Vvf/y0u6Z4rZFY1xc7lvwAaPXyq0VjTtUBzFW3X" +
           "8N430x+WXvWp956DIMD8ylPMO56f+dYvvv0tDz//Gzuer7oJz0heakp0TXlG" +
           "vv+zr20/1rojF+OC74VWbvzrkBfuzx7UPJ76IPJeddRjXrl/WPn8+NcW7/oR" +
           "7a/PQRf70F2KZ8cO8KMHFM/xLVsLepqrBVKkqX3oHs1V20V9H7obfNOWq+1K" +
           "R7oealEfutMuiu7yiv+BinTQRa6iu8G35ere4bcvRWbxnfoQBL0M/EJvgaC9" +
           "b4KKn7135DSCZNj0HA2WFMm1XA9mAy/HH8KaG8lAtyYsA69fwaEXB8AFYS8w" +
           "YAn4gakdVKieA4eJAWMycHRJifhZjwUD85qRJ4b93Nf8/5RR0hzr5c3eHjDD" +
           "a08nARvED+nZqhZcU56K8e4Xf+zaZ84dBcWBliKIAgPv7wbeLwbeBwPvg4H3" +
           "bz7w1eN/23GQaJHXjmVL6UeaA+3tFaK8Ipdt5w3AliuQFUC7ex/jv4l653vf" +
           "cAdwQ39zJzDEOcAK3zptt4/zSL/IlgpwZuj5j26+ffZt5XPQuevzb44HFF3M" +
           "m7N51jzKjldPx93N+r305Of/8bkPP+EdR+B1Cf0gMdzYMg/sN5zWfOApmgpS" +
           "5XH3b35E+ulrn3ri6jnoTpAtQIaMJODRIPk8fHqM6wL88cNkmWM5DwDrXuBI" +
           "dl51mOEuRmbgbY5LCpe4v/h+AOj4Uu7xjwHXv3YQAsXfvPblfk5fsXOh3Gin" +
           "UBTJ+Ot5/2N/+Ft/WS3UfZi3L52YCXktevxErsg7u1RkhQeOfWASaBrg++OP" +
           "sv/1Q1948h2FAwCON95swKs5bYMcAUwI1Pwdv7H+o8/9yTO/e+7IafYiMFnG" +
           "sm0p6RHICzmm+88ACUb76mN5QK6xQSTmXnN16jqeaumWJNta7qX/dulNlZ/+" +
           "m/df3vmBDUoO3egtX7qD4/LX4NC7PvPN//Rw0c2eks91xzo7Ztsl0Jcf94wF" +
           "gbTN5Ui//Xde999+XfoYSMUg/YVWphUZ7UKhgwug0WNnrHcCywHWSA7mCPiJ" +
           "Bz+3+v7Pf2KX/09PKKeYtfc+9V3/sf/+p86dmHXfeMPEd7LNbuYt3Oi+nUX+" +
           "A/zsgd//m//mlsgLdpn3wfZB+n/kKP/7fgrgPHqWWMUQxF8898TP/9ATT+5g" +
           "PHj9pNMFa6pP/P6//+b+R//00zfJcedD0wt2i61XgpVcoe98MbC/WwwUFeWc" +
           "oDunqke5s3tSYfy33owUeOGC+c0F3c8BFtaBirq35+T14cn0c72hTqwKrykf" +
           "/N2/u2/2d7/wxUL265eVJ6ONkfydpu/PySO54l59OteSUmgCPvT54Tdetp9/" +
           "AfQogh4VMMWEowBMBul1sXnAff7u//lLv/yqd372DugcAV0EyFVCKtIcdA/I" +
           "LxpQn62m/je8fRdfmzzgLhdQoRvAFwVXbkxAq4PYXN08AeX00Zy86cawvlXT" +
           "U+rf2yWIQzNfySe2TVU5ms+OJ65iTOYM63E5IYsqLCf9HazO/5cGdrwPFf/d" +
           "cXaoEvm6+HiaeOhfR7b87j//5xvcoJjdbhK9p9qL8LPff6X9tr8u2h9PM3nr" +
           "h9MblwhgD3HcFvkR5x/OveGuXz0H3S1Cl5WDDcpMsuM8eYtgUR4e7lrAJua6" +
           "+usX2LvV5ONH0+hrT6ePE8OenuCOwxZ859z598Vjl0fTPTABnEf2G/tFvL5j" +
           "5zcFvZqTr9lpPf/8WjBThMVGJ49my5Xsoh80AjFjK1cPM9EMbHyAiq8u7UZe" +
           "/XXH7oidyAi3tvzsUC5g6fuPMwvtgU3G+/7PB3/zA2/8HDAHBZ1PclUBK5xI" +
           "P8M433d957Mfet3LnvrT9xWTHHDg2XteuFKkD/UsdDm5lpN3HsK6ksPii+Uk" +
           "LYURU8xLmpoju1mGu9MGIn7ZaKNLTRIN+9jhD10RNWSjpGNHH2WwhbDdTN6q" +
           "6dyQV90R2l8R/Lhc63RHfbdDTVxigffcGj2oDhE1SWit0WAaYq3Vnpp1nPIW" +
           "U6+HU4P2jAqItsF626Dscf2BZfPGlOA8w+53Z9jAHwjV6ZiYm51NUC4hMiIn" +
           "OtKIFnWzl1AoPGda1XJWRUqlSnPT1Ba1qcCLvpd6dDjrdYQ1ES+nU7tcH1C0" +
           "LWyDUWzQ24W+rnVKCdhlLIMZPo0qbM9Y2FIjDIU5n3GR0K1Mm8JADAiqizgV" +
           "ozboNo3xULKJTOhRAzkQJsgimK3gwRSfiQs1qeBdoc2GDrPqSRQzG1F+Cjb9" +
           "3HQDttPtwcbN7AVX1Tyl0Uf4XoDHy06yahJVZy5tOH/arCmENRyu9Cof4uMR" +
           "U54OxylPq4LIKGvHXNeZzjqstYfMsF1qzWdDYyL31yHdJ5bIZDRy3bQpyqM+" +
           "l1FceSKoCiuE82g+rjjtheUPSb8xE/1tsKb0fms67lqqVbPGrZWJlJc40/NE" +
           "Kmx59RndqWvrtT2tlOszVLWp2VRmrHp/Jc1rnJFRNjFAnLapM2XLW8hy7OJO" +
           "eS7Sk5ljit6IbtmoTC7jSlRaTQlJ27jLRSBYzXi8GHcZKl6RXG+1nqwqwWJL" +
           "4V0YWQkLdthYC05/7Q6weewK29TmqOGiFyzg9iZCfKOybi5XatDDdG6iZPSE" +
           "VbOBM69hog1XtNkMaL5MCiOvnnBKh0UMdFBpWxkz6fqGmol0TWxb1NgUG6N5" +
           "v66aJXqMYfUGNxUXw7q89geTRX9UtihmTAllY44lDoUi2GA8G5mWsZ2aAS/1" +
           "+hFPUlyrjy0lgtBiy1oYlue7jLHqC2Nkhm5pw0bWqpDx9UZrJKvL6qRclSpx" +
           "pY+5mGMOpzOXbKlKZ1pzSGksslN/hJGGS/as0OiU/cztbBQK02iRdCi8WU+S" +
           "eWRtwrha3qKUw417kquTrVlvkWqTTGsycjvw6hVCtpjealQlhlmTZZCaXZ5H" +
           "K6XOYGPCmaxQq+NJW6OuVmGhUQ0mJRfeWDxi1nhai9YjY4ZU2lkwAO61lh1C" +
           "ivhpr1str0b2lK9O0uYY3XZkdGmtRKLRrK3K60FoVvh1MoikGtzsjLsrzhh3" +
           "ZptAsyh9HkbbXsrpdZXhDFPVcXpm9vmYIjduE9Nk3KHMjV4hsAodrjnfMesj" +
           "ZxmsZXRqoiGHI01iQw7S0qCX+dJ4yDCDrYwhXarRa3OIwVDsWEBMQ2/3SkOj" +
           "TtGMlsTIuEda8+Uaa/JaN3Lk5hyRKW+AZuNNH0f6ElG12oaRtMKKOu0OBXYr" +
           "kP6khQruot4cYOWRGxKEJeIRQ+L9iQkvu33RQHF8RII9uNJIMtmeSORAHTXK" +
           "LkE0nG55zPXxxB+LcUc0O3J7zqXYzOi1euNSaYjAC3VuL3DRsZgZQ/XwPlEW" +
           "ZrV63aXa40zW0hJP2YnX4bPWQuVFkNRGK1yVJrY9YYZmMsQW5rLpd6L6krVW" +
           "tKXANNm1JyCBiU59gjNcsgrs7iwaLCc1ZqKlrkiJNLeUGt64RPIlTfDi0PXR" +
           "ElsditVtaYZ3w5TtTUybmHINsd+yPKZJtEgxWbcNJ4JJDpk2XXJpeaNyd0lv" +
           "VHuKKDhVWm+yXhjOXdNqep5dDkZpbVNClJblchXc7S4NM2VCpJGmNUZaZb1W" +
           "a2ynPjcaOPJg6hIen/UiIeMqXU0hnQaR6WmD8E2in/k+XjWDjBUl2FTJWrpc" +
           "ZOZMWFZlp7yg3SUCV3sGDJd0AZ43XTNbS9LY1oblbgQSVdz0ZEwgQ0si5VEr" +
           "W3PT+hCFyaCawO6IbLltGV8EdsqLYdpY0BvTD/sK3qw1w2qiJyZeGib4fIiQ" +
           "TpurtobpgGK2I34WTAdKj9zOzMiL1dYUR2dtAvWGQnleL+E671PjxTog8GqQ" +
           "oOV5MA8QF1bK7UnEebwajK3QJUqdctZqdWW3UmkgajTvpliaTMLFSOIs0YDL" +
           "tV6zPOHt6Swla8GiSmRVdJVwGxEr9RFK3Bps35gzTLpm3Kqq8251Oenadcv3" +
           "e5hsxpWmupqV3eoWZfV1uiXmmZVh/ThyWHMOT1vNRqkCG06l3nEXGbyea/BW" +
           "Qg2ONqKgG+MwPmniJbbM6ylRbuB4zZPm9GRVo5XIpZjOYNM06rqypHRD7+C2" +
           "USJ1l0YGUg8bVqOGNXLNUI5L7aicUa44sjtLul33mCHa9BSUqyODjKjw1YqD" +
           "zjKZbcgpQ+qsK29WhDnjq412wxPrrYFTTapGpLLbJEgnVKcyF7xefcAl0/WQ" +
           "GJvl2GyV5HA5owMHR6ssKTg+gqVjD9Wnfmdu+8tJxMumzXkVx9dGcWM+GFCt" +
           "hjkz6lXTJ7F2tCEa1IqsTOpVdpCtuPWARzfDQO50NpO6HpSQda8/bc/bkcTC" +
           "VTlbz9eD4TxdDQWtzjLqYNROzEUWp7Fibs2S3yxXsRk8IWtbInHrcDJKqm18" +
           "U4tgycVJP0b4vi4hPTGmFQF2NZv1Z+FKwul1MIlhdOIP6yV3xCEgC4mSYQRU" +
           "2amxPjM3t8CNYwfW5gRTZZFkRuCGH1G01h4j7Sy1u22H226dkBmu+85QSaZk" +
           "1zO7DJgTFTCZGXq3S5oeS6TccKg2fYPtcEqJnSvTUjRyEwtLy3zHqpjT3qhE" +
           "NggMnXUybVENqaGvCOOI4AMKVTN8ncjTOBLYNTNvu+7ArLvRiMhSd8NwjOS4" +
           "mxYRqqvlauS2HAu3UqQhb00NXU82UrNGSnLbkWEtmWl9Qp237LrqT4Rypdrm" +
           "5MqcCpV4vR6MacuvhDGJi3CGhOMR5S5KcTsK+vICL0t4E3VlYPua1RRcrME2" +
           "jVpLWTY6UwUuraqNzUDcbledUKrFqzLDwgTKzoO2oaKNCq1pLjKprBMhK6EB" +
           "ugVLrC7ZX8P9tAHaKmvBKglLbl5bE8pM2QirqltfZWw9EByTH9UqfokkEI2p" +
           "ZaLU1rON0IlDrOouk0ErwPlgWQuVFu40cDFk+rVpxx5WsU29sZysWd3sJKlu" +
           "L/obnpCXZdbmKu1BZaoP42rW073l0OUG7eoY7SfLJtFl8UWcTgS9oUVpq1rw" +
           "RnMrVFXaZ8ZNhQwnzmCEYSkcypYzT7cOofKT5aLa0WbIMA0GVTMpqdZ04ZcZ" +
           "p8aUkM52lE2bxDBKe6RLbUpDexpPVwHdg5mZI4U6ng5Cfe1piu82KH0x6WKR" +
           "CbaStqKyrm8POv2GaJmbgESHfNCp1ZPYyFRDkmsbrhc3ygu205rBAaYQ5LI/" +
           "i3mzuex66WQtso0sxpqcHs5XRGcriosqVktHJRc4JCn3ytpgXOpP19sJpve0" +
           "TtpJFvAIwXqDKoGaVT/qB6lTidIwJD0z123N1ZVFaaMtlqOMUlC9N1jWFd6o" +
           "jZC+pdNpHZuu0ZIGw12xtNnKzaq4avaozYL3VNSw5RWvD3Ke+pYbdTlLwC0K" +
           "5NOKjlCk2fZaHb3jzLhutkBW22mnzAHnczCJ5XAsbrJYMENEFsO6kiVjVsdB" +
           "W4Yd0rVJtARLp37HaHB+SIeJtiyj1QlVGTtqr1tD12VkqjmdDR6xzpAOKZfm" +
           "sRFqNcx23Wenw06zLM8Jzkm0oTtSRImvtubMoIbSmEonDIF7jUFz42s6Mw18" +
           "PStbiiTFvBbrqKavXCaxJqyRUBGzrgdBPDJKI3shU2Alpfcjx2JD19iOKoZP" +
           "1HxV7vGYUF53BwaYa/U0tMJFNMbaEiI3XarnBNvpYpA1g1oS8ytxTU783joU" +
           "SAfhhjym8DBY3qy4WRlWVbgcUq3twqC9IA16eK0trlpON1sJrQqDzy19o8JZ" +
           "WJ40o3lCLZshT8mTKE6CjjPViWlfSniDYzyfr7XB9n3e3aLTYFMSbJ8X7JnQ" +
           "ijQ2Mx0NLLz5liishHZVVmSvGwCL9+SM3qDrxkxBW0mkaXGz1VTnsN4mN7V5" +
           "krrdUV3CUmbJsFJtrrLEqkqt0rIlilFb5TV8rlA1t2lIvQxtast6RXFgeKol" +
           "cLhEYx9dCG7dYTNhO05glZxoGhFzFVbgBqsZXe5u4PVMCKWyVJnPOG2YRFQi" +
           "UBURaVP9rjCu0GmjZizKGueoTjy0NhVHrzcFkl5JAjGrb4kMZSvroN7uTKt1" +
           "YRUZAr3u1yej+rjbQBsOzo/jntkk/VBWeASJN4KY4FWuEyynAtIry0hHoCWa" +
           "W7CkCkJiWYeDTS1EazCqalUYo8m1b8rL/gYrNtr+i9vaP1CcWBxddn4ZZxXp" +
           "zU7YivOqi4cXY4d/T5+wPXRwW3NwrvbYrc/VTl4IYXL4IluMNTs/0Xzdre5J" +
           "i2PgZ9791NPq6Acr5w5O6hoRdNfB9fWxrPeBbt5861M3prgjPj76+vV3/9WV" +
           "ydvMd76IS6XXnxLydJc/zDz76d5XK997Drrj6CDshtvr6xs9fv3x18VAi+LA" +
           "nVx3CPa6I9O9MrfUa4DJ3nNguvecca562s32CjfbOdcZp6DfdUbdd+fkOyLo" +
           "TkOL5sWR+LEffueLOS0tCt59I64nD3A9eftxffiMuo/m5Ht2uBancH3vV4Cr" +
           "OAd/FIj4vgNc77s9uPaOGXaXEv/9DHDP5ORjAFwIjHbTM8HEs9RjwE/fDsAf" +
           "OAD8gZcI8E+cAfincvLsDnBhzf9xDO4TX6mXXgFiPHUA7qnb76WfOqPuF3Py" +
           "sxF0Po++yik3/bnbAewjB8A+cvuBffqMus/k5Fd2wBangf3qV+qObwQyft8B" +
           "sO97idzx985A9wc5+e38PvLQbCf88bO3A90PHKD7gZcI3Z+dge5/5+R/7dAt" +
           "TqP749vhlM8coHvm9jvlF86o+9ucfP4g2pBTTvmXtwPYxw+Affz2A/uXM+pe" +
           "yMnfH0TbaWD/cDv88UcPgP3oS+OPe+dvjW7v7pxAB9GGXO+Pe3u3A91zB+ie" +
           "e4nQPXAGupfn5N6DaDuN7r6vAN1r8sKvAXJ88gDdJ18Mugi6xw+8SFMiTf1S" +
           "vrn38Bl1j+TkoQi6H/jm7plGcdecs37dMdDXvKiL+Qi6cuvXawU72K3AL/JB" +
           "HNhrPHTDA9zdo1Hlx56+dOHVT0//oHj3dfSw8x4auqDHtn3ysvvE911+oOlW" +
           "obx7dlfffqGRxyLooVvJFkF3AJpD2PvaHfdbIugVN+MGnICe5IQj6PJpTuBX" +
           "xd+TfEgEXTzmA/uu3cdJlhroHbDkn3X/UKFv+/JfGOZ2SXcvOh466a1Fgnrw" +
           "S9n+qMnJx2b5brB4Vn24c4t3D6uvKc89TQ2/5Yv1H9w9dlNsKcvyXi7Q0N27" +
           "d3dFp/nu79Fb9nbY113kYy/c/+P3vOlwm3r/TuDjyDkh2+tv/rKs6/hR8RYs" +
           "+9lXf/KtH3/6T4r3Af8Pfwmg9+8uAAA=");
    }
    public class SVGPathSegCurvetoQuadraticItem extends org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem implements org.w3c.dom.svg.SVGPathSegCurvetoQuadraticAbs, org.w3c.dom.svg.SVGPathSegCurvetoQuadraticRel {
        public SVGPathSegCurvetoQuadraticItem(short type,
                                              java.lang.String letter,
                                              float x1,
                                              float y1,
                                              float x,
                                              float y) {
            super(
              type,
              letter);
            this.
              x =
              x;
            this.
              y =
              y;
            this.
              x1 =
              x1;
            this.
              y1 =
              y1;
        }
        public SVGPathSegCurvetoQuadraticItem(org.w3c.dom.svg.SVGPathSeg pathSeg) {
            super(
              );
            this.
              type =
              pathSeg.
                getPathSegType(
                  );
            switch (type) {
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_QUADRATIC_ABS:
                    letter =
                      PATHSEG_CURVETO_QUADRATIC_ABS_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticAbs)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticAbs)
                         pathSeg).
                        getY(
                          );
                    x1 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticAbs)
                         pathSeg).
                        getX1(
                          );
                    y1 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticAbs)
                         pathSeg).
                        getY1(
                          );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_QUADRATIC_REL:
                    letter =
                      PATHSEG_CURVETO_QUADRATIC_REL_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticRel)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticRel)
                         pathSeg).
                        getY(
                          );
                    x1 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticRel)
                         pathSeg).
                        getX1(
                          );
                    y1 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticRel)
                         pathSeg).
                        getY1(
                          );
                    break;
                default:
            }
        }
        public float getX() { return x; }
        public float getY() { return y; }
        public void setX(float x) { this.
                                      x =
                                      x;
                                    resetAttribute(
                                      ); }
        public void setY(float y) { this.
                                      y =
                                      y;
                                    resetAttribute(
                                      ); }
        public float getX1() { return x1;
        }
        public float getY1() { return y1;
        }
        public void setX1(float x1) { this.
                                        x1 =
                                        x1;
                                      resetAttribute(
                                        );
        }
        public void setY1(float y1) { this.
                                        y1 =
                                        y1;
                                      resetAttribute(
                                        );
        }
        protected java.lang.String getStringValue() {
            return letter +
            ' ' +
            java.lang.Float.
              toString(
                x1) +
            ' ' +
            java.lang.Float.
              toString(
                y1) +
            ' ' +
            java.lang.Float.
              toString(
                x) +
            ' ' +
            java.lang.Float.
              toString(
                y);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "8W3s/wDPAyK6zx8AAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "v/7AV7ITwv8FQ3ALCOsqAAA=");
    }
    public class SVGPathSegArcItem extends org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem implements org.w3c.dom.svg.SVGPathSegArcAbs, org.w3c.dom.svg.SVGPathSegArcRel {
        public SVGPathSegArcItem(short type,
                                 java.lang.String letter,
                                 float r1,
                                 float r2,
                                 float angle,
                                 boolean largeArcFlag,
                                 boolean sweepFlag,
                                 float x,
                                 float y) {
            super(
              type,
              letter);
            this.
              x =
              x;
            this.
              y =
              y;
            this.
              r1 =
              r1;
            this.
              r2 =
              r2;
            this.
              angle =
              angle;
            this.
              largeArcFlag =
              largeArcFlag;
            this.
              sweepFlag =
              sweepFlag;
        }
        public SVGPathSegArcItem(org.w3c.dom.svg.SVGPathSeg pathSeg) {
            super(
              );
            type =
              pathSeg.
                getPathSegType(
                  );
            switch (type) {
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_ARC_ABS:
                    letter =
                      PATHSEG_ARC_ABS_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegArcAbs)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegArcAbs)
                         pathSeg).
                        getY(
                          );
                    r1 =
                      ((org.w3c.dom.svg.SVGPathSegArcAbs)
                         pathSeg).
                        getR1(
                          );
                    r2 =
                      ((org.w3c.dom.svg.SVGPathSegArcAbs)
                         pathSeg).
                        getR2(
                          );
                    angle =
                      ((org.w3c.dom.svg.SVGPathSegArcAbs)
                         pathSeg).
                        getAngle(
                          );
                    largeArcFlag =
                      ((org.w3c.dom.svg.SVGPathSegArcAbs)
                         pathSeg).
                        getLargeArcFlag(
                          );
                    sweepFlag =
                      ((org.w3c.dom.svg.SVGPathSegArcAbs)
                         pathSeg).
                        getSweepFlag(
                          );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_ARC_REL:
                    letter =
                      PATHSEG_ARC_REL_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegArcRel)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegArcRel)
                         pathSeg).
                        getY(
                          );
                    r1 =
                      ((org.w3c.dom.svg.SVGPathSegArcRel)
                         pathSeg).
                        getR1(
                          );
                    r2 =
                      ((org.w3c.dom.svg.SVGPathSegArcRel)
                         pathSeg).
                        getR2(
                          );
                    angle =
                      ((org.w3c.dom.svg.SVGPathSegArcRel)
                         pathSeg).
                        getAngle(
                          );
                    largeArcFlag =
                      ((org.w3c.dom.svg.SVGPathSegArcRel)
                         pathSeg).
                        getLargeArcFlag(
                          );
                    sweepFlag =
                      ((org.w3c.dom.svg.SVGPathSegArcRel)
                         pathSeg).
                        getSweepFlag(
                          );
                    break;
                default:
            }
        }
        public float getX() { return x; }
        public float getY() { return y; }
        public void setX(float x) { this.
                                      x =
                                      x;
                                    resetAttribute(
                                      ); }
        public void setY(float y) { this.
                                      y =
                                      y;
                                    resetAttribute(
                                      ); }
        public float getR1() { return r1;
        }
        public float getR2() { return r2;
        }
        public void setR1(float r1) { this.
                                        r1 =
                                        r1;
                                      resetAttribute(
                                        );
        }
        public void setR2(float r2) { this.
                                        r2 =
                                        r2;
                                      resetAttribute(
                                        );
        }
        public float getAngle() { return angle;
        }
        public void setAngle(float angle) {
            this.
              angle =
              angle;
            resetAttribute(
              );
        }
        public boolean getSweepFlag() { return sweepFlag;
        }
        public void setSweepFlag(boolean sweepFlag) {
            this.
              sweepFlag =
              sweepFlag;
            resetAttribute(
              );
        }
        public boolean getLargeArcFlag() {
            return largeArcFlag;
        }
        public void setLargeArcFlag(boolean largeArcFlag) {
            this.
              largeArcFlag =
              largeArcFlag;
            resetAttribute(
              );
        }
        protected java.lang.String getStringValue() {
            return letter +
            ' ' +
            java.lang.Float.
              toString(
                r1) +
            ' ' +
            java.lang.Float.
              toString(
                r2) +
            ' ' +
            java.lang.Float.
              toString(
                angle) +
            ' ' +
            (largeArcFlag
               ? "1"
               : "0") +
            ' ' +
            (sweepFlag
               ? "1"
               : "0") +
            ' ' +
            java.lang.Float.
              toString(
                x) +
            ' ' +
            java.lang.Float.
              toString(
                y);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1ae2wcxRmfO78d22c7ieM87LycgEN6R3hVkXk5xk6cXhzL" +
           "TixwSi57e3PnTfZ2l905+xyaFGirpFSllAaSVhD1jyBoFRJUgVpEQaFIEASl" +
           "4tFSSnmordTQNoKoKpUKLf2+2b3bvb3bdQ9xteS5vZnv+2a+33yvnbmT50mN" +
           "oZNuqrAwm9WoER5U2KigGzQxIAuGsQP6YuLRKuHvu8+NbAyS2knSMiUY20TB" +
           "oEMSlRPGJOmSFIMJikiNEUoTyDGqU4Pq0wKTVGWSLJSM4bQmS6LEtqkJigQT" +
           "gh4lbQJjuhTPMDpsCWCkKworifCVRPrdw31R0iSq2qxN3ukgH3CMIGXanstg" +
           "pDW6V5gWIhkmyZGoZLC+rE4u0VR5NiWrLEyzLLxXvtKCYGv0yiIIVj0a+ujj" +
           "u6daOQTzBUVRGVfPGKOGKk/TRJSE7N5BmaaNW8hBUhUl8xzEjPREc5NGYNII" +
           "TJrT1qaC1TdTJZMeULk6LCepVhNxQYysLBSiCbqQtsSM8jWDhHpm6c6ZQdsV" +
           "eW1NLYtUvPeSyJGju1t/UkVCkyQkKeO4HBEWwWCSSQCUpuNUN/oTCZqYJG0K" +
           "bPY41SVBlvZbO91uSClFYBnY/hws2JnRqM7ntLGCfQTd9IzIVD2vXpIblPWt" +
           "JikLKdC1w9bV1HAI+0HBRgkWpicFsDuLpXqfpCQYWe7myOvY8yUgANa6NGVT" +
           "an6qakWADtJumogsKKnIOJiekgLSGhUMUGdkiadQxFoTxH1CisbQIl10o+YQ" +
           "UDVwIJCFkYVuMi4JdmmJa5cc+3N+5Oq7blW2KEESgDUnqCjj+ucBU7eLaYwm" +
           "qU7BD0zGpnXR+4SOpw4HCQHihS5ik+anX7lw/fruM2dNmqUlaLbH91KRxcQT" +
           "8ZZXlg30bqzCZdRrqiHh5hdozr1s1Brpy2oQYTryEnEwnBs8M/bcTbf9mP41" +
           "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" +
           "QqlcXT2tSgkbm2OVxGbEUnCkfGy8WOfC5qQPNqewecjEhtvID20cHq6Um8Cr" +
           "S3DcUma8fBy8WH3UfMJn7ElsHoO6D9xkbIPLTx6vJAYTliIT5WPgxeqj53M+" +
           "Y2execbC4DIXBr+olD/gAdukpchk+Rh4sc7lD6/5APFrbF7Gl5icMTgc4leV" +
           "BGK3pc3u8oHwYp0LiPd8gPgDNm9ZQFzmAuL3lfKKLtBCtLQRywfCi9VHz/M+" +
           "Yx9gc46RevCKfiVlHhw7HOP9StlDL+iQsnRJlQ+DF+tc9vAvHyw+weYfgIXh" +
           "wMJhEh9VAItFOd+QLYXk8rHwYvVWNVDnM9aATZCRJjCJ8RlKNTzLQ8KRPBSB" +
           "qkqZxeWgh2bpo5UPhRert1mMcJ0X+ODRgU0I8DBceNimEWitlGmsBWUyllKZ" +
           "8vHwYvVRd6XP2GpsljESAtOICnoKXh7FEtbRVSnr2AiqzFoqzZaPhhfrXNYR" +
           "9oHkUmx6ARKjGBKHgayrACSLcewi0OegpddBH0h4uw6bL+QO4Bs0XWVUZDTh" +
           "OoNv85HpA8U1PmPXYXMVIy0YVPgZ5YQgZ3iE3Wyj9MXP5ciHkbaiazhO3MlI" +
           "pMwLPUMnnUU/IDAvvcVTx0P1i47vfIOfqOQvppuipD6ZkWXH0YLzmKFW02lS" +
           "4jvTZJ5MahygYUY6vdbGSBW0qEJgi0kdZWRBKWqghNZJuZ2RVjcllDz800k3" +
           "xkijTcdIrfngJNkJ0oEEHye0HKDXfvYbUtyXrHl0WHBAx5PtwrlMIc/ivILC" +
           "oyf+s5DcMVHG/GFITDx9fOvIrReuetC8AhNlYf9+lDIvSurM2zguFI+aVnpK" +
           "y8mq3dL7ccujDWtyJ3Jt5oJtb1vqqCqgYg1oeKS7xHU/ZPTkr4nePHH10788" +
           "XPtqkAR2kYDAyPxdjh9lmL9A6MtqGZ107YoWXzFMCDq/uOrr/cHsteuTH7zF" +
           "T4WJeSWxzJs+Jr7+0M2v3dN5ojtI5g2TGklJ0OwkaZSMG2aVMSpO65OkWTIG" +
           "s7BEkCIJcsH9RQuavIC+zHGx4GzO9+IFKiOrii9viq+dG2V1huqb1IySQDHN" +
           "UTLP7jF3xnVal9E0F4PdY20ltjdgszGLuwHWG4tu07Tc3Vbd1zQeMQZLBX5+" +
           "fxGQ+CM+7f0vOz57lzImAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "fkysQVoxAAA=");
    }
    public class SVGPathSegLinetoHorizontalItem extends org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem implements org.w3c.dom.svg.SVGPathSegLinetoHorizontalAbs, org.w3c.dom.svg.SVGPathSegLinetoHorizontalRel {
        public SVGPathSegLinetoHorizontalItem(short type,
                                              java.lang.String letter,
                                              float value) {
            super(
              type,
              letter);
            this.
              x =
              value;
        }
        public SVGPathSegLinetoHorizontalItem(org.w3c.dom.svg.SVGPathSeg pathSeg) {
            super(
              );
            this.
              type =
              pathSeg.
                getPathSegType(
                  );
            switch (type) {
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_HORIZONTAL_ABS:
                    letter =
                      PATHSEG_LINETO_HORIZONTAL_ABS_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegLinetoHorizontalAbs)
                         pathSeg).
                        getX(
                          );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_HORIZONTAL_REL:
                    letter =
                      PATHSEG_LINETO_HORIZONTAL_REL_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegLinetoHorizontalRel)
                         pathSeg).
                        getX(
                          );
                    break;
                default:
            }
        }
        public float getX() { return x; }
        public void setX(float x) { this.
                                      x =
                                      x;
                                    resetAttribute(
                                      ); }
        protected java.lang.String getStringValue() {
            return letter +
            ' ' +
            java.lang.Float.
              toString(
                x);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "zr1x2hGDw0dX4TsGjlf4Iw5X/wsq67n0mxkAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "opOhJAAA");
    }
    public class SVGPathSegLinetoVerticalItem extends org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem implements org.w3c.dom.svg.SVGPathSegLinetoVerticalAbs, org.w3c.dom.svg.SVGPathSegLinetoVerticalRel {
        public SVGPathSegLinetoVerticalItem(short type,
                                            java.lang.String letter,
                                            float value) {
            super(
              type,
              letter);
            this.
              y =
              value;
        }
        public SVGPathSegLinetoVerticalItem(org.w3c.dom.svg.SVGPathSeg pathSeg) {
            super(
              );
            type =
              pathSeg.
                getPathSegType(
                  );
            switch (type) {
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_VERTICAL_ABS:
                    letter =
                      PATHSEG_LINETO_VERTICAL_ABS_LETTER;
                    y =
                      ((org.w3c.dom.svg.SVGPathSegLinetoVerticalAbs)
                         pathSeg).
                        getY(
                          );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_VERTICAL_REL:
                    letter =
                      PATHSEG_LINETO_VERTICAL_REL_LETTER;
                    y =
                      ((org.w3c.dom.svg.SVGPathSegLinetoVerticalRel)
                         pathSeg).
                        getY(
                          );
                    break;
                default:
            }
        }
        public float getY() { return y; }
        public void setY(float y) { this.
                                      y =
                                      y;
                                    resetAttribute(
                                      ); }
        protected java.lang.String getStringValue() {
            return letter +
            ' ' +
            java.lang.Float.
              toString(
                y);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "zpoyOHj0FL5d4HiFP+Jw9b9I/voHkxkAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "JAAA");
    }
    public class SVGPathSegCurvetoCubicSmoothItem extends org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem implements org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothAbs, org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothRel {
        public SVGPathSegCurvetoCubicSmoothItem(short type,
                                                java.lang.String letter,
                                                float x2,
                                                float y2,
                                                float x,
                                                float y) {
            super(
              type,
              letter);
            this.
              x =
              x;
            this.
              y =
              y;
            this.
              x2 =
              x2;
            this.
              y2 =
              y2;
        }
        public SVGPathSegCurvetoCubicSmoothItem(org.w3c.dom.svg.SVGPathSeg pathSeg) {
            super(
              );
            type =
              pathSeg.
                getPathSegType(
                  );
            switch (type) {
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_CUBIC_SMOOTH_ABS:
                    letter =
                      PATHSEG_CURVETO_CUBIC_SMOOTH_ABS_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothAbs)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothAbs)
                         pathSeg).
                        getY(
                          );
                    x2 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothAbs)
                         pathSeg).
                        getX2(
                          );
                    y2 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothAbs)
                         pathSeg).
                        getY2(
                          );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_CUBIC_SMOOTH_REL:
                    letter =
                      PATHSEG_CURVETO_CUBIC_SMOOTH_REL_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothRel)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothRel)
                         pathSeg).
                        getY(
                          );
                    x2 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothRel)
                         pathSeg).
                        getX2(
                          );
                    y2 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothRel)
                         pathSeg).
                        getY2(
                          );
                    break;
                default:
            }
        }
        public float getX() { return x; }
        public float getY() { return y; }
        public void setX(float x) { this.
                                      x =
                                      x;
                                    resetAttribute(
                                      ); }
        public void setY(float y) { this.
                                      y =
                                      y;
                                    resetAttribute(
                                      ); }
        public float getX2() { return x2;
        }
        public float getY2() { return y2;
        }
        public void setX2(float x2) { this.
                                        x2 =
                                        x2;
                                      resetAttribute(
                                        );
        }
        public void setY2(float y2) { this.
                                        y2 =
                                        y2;
                                      resetAttribute(
                                        );
        }
        protected java.lang.String getStringValue() {
            return letter +
            ' ' +
            java.lang.Float.
              toString(
                x2) +
            ' ' +
            java.lang.Float.
              toString(
                y2) +
            ' ' +
            java.lang.Float.
              toString(
                x) +
            ' ' +
            java.lang.Float.
              toString(
                y);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "vs34H+of1ivXHwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "OansjKoW5sbuioXy37onBUq4YHlLQQ9zWIVOoKLu7Tl5XXDa6dysnlMZ4Q35" +
           "fb//mQdmn/mlF4oZ35xSnl5jjOjt5Hs5J4/n4nr1WQ/bE4M14Ks8P/y6q9bz" +
           "nwU9CqBHGYSXYOSDQJDctCKPuM/f96e/8qsPv+MT90AHXegSwKt0xcK5QReB" +
           "V1GB0Cwl8b7m7btVFefL7GoBFboFfFFw7Va388LRinzh9m4np0/k5I23LuY7" +
           "NT0j/nM7t3Cs3Gt5UIsx+SSW7YNWMSZzF+1NctIrqlo5oXawOv9fEtjxPlL8" +
           "u+fuC7Sb58T74PDIv40s6V1//a+3mEER026zZs+0F+Dnvv8a/rZ/Ktrvg0ve" +
           "+rHk1vQAvD/s26I/Zv+fg9df+PUD6D4BuiofvZzMRCvKXbYAEvLg+I0FvMDc" +
           "VH9zcr3LJJ88CZ6vPes0Tg17NqztFyt4zrnz50t7k68k54DbP48e1g+LVfq1" +
           "O7sp6PWcfPlO6vnjV4D4EBQvOfka1h3RKvqphGDNWPL1Y/8zAy89QMTXDaue" +
           "V3/V3hxbp/zAnTU/O54X0PTlvT+hXfCC8R1/+77f/s43fBKoow+d3+aiAlo4" +
           "5XSGUf7O9W3Pvf/Rlz39l99RhDZgwLP/+dlrhftQ7oYuJzdy8o5jWNdyWFyR" +
           "StJiEDJFNFKVHNnt/Nq9FpjiF4w2vPxMrxJQreMPjQgqGvNJYmujrBR3FhW8" +
           "vYpRshWzRrPSJXRqzcfUkixnY5mhiLYyjOsjbIgut5jiaSDLDxluO5zwqMFT" +
           "JktRJNbppWWWE3hihs+aG5zQJ7aHm2VhqJv0FO9S3mYw83hyOPNEj7KxupYN" +
           "6yEW1juM6/mpNKwzTRjLFilcmlWyUoMa8rYoeNRsQzNtskO63ZHBzy0zpRPD" +
           "41NpgE6QJjG2Kjo8H2NNDvXhAdcwmhOG64pjumuXuVp3k41cI1t6NsPb0400" +
           "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" +
           "2P0202++6x+vTd+2fseLOLZ53ZlJnu3yR5nnPka+Sf7uA+iek02nW06Jb270" +
           "5M1bTZd8NYx8Z3rThtOjJ2p8Va611wDrubBT4+73DnuYZ03uXGFyO0O7y47j" +
           "t9+l7n/l5FtD6N6VGi6K7ee9TX7bi9mZLAredSuui0e4Lr70uD5wl7pncvJd" +
           "O1zLM7i++4vAVew5PwHwPHCE64GXBte5PcPuAOAH7gLuQzn5IAAXAKXddv9t" +
           "6+rKHvCzLwXgB48AP/glAvyTdwH80zl5bge40OYP7cF9+Iu10msA1MNH4B5+" +
           "6a30o3ep++Wc/HwInc9XH3rGTH/hpQD2miNgr3npgX3sLnUfz8mv7YAtzwL7" +
           "9S/WHN8AAD16BOzRL5E5/sFd0P1RTn43P/E7Vtspe/zES4HuiSN0T3yJ0P3V" +
           "XdD9TU7+bIdueRbdn38R6Aob/HKA6k1H6N70YtCF0EXPd0NVDlXl89rm/75L" +
           "3Wdy8qkQugxsc3c0W5w05aVftQf6Dy/qWC6EHv9891ZuyqVexIUYkAM9cssF" +
           "vN2lMfnHn71y/6uf5f+ouPFxcrHrIg3dr0WWdfrA69TzBc9XNb0QxcXd8ZdX" +
           "/Py/EHrkTnMLoXsALSD8647730PolbfjBpyAnub8XAhdPcsJrKv4PcV37iCE" +
           "Lu35QD64ezjNch70DljyxwvesUDf9oXfMMr1kpw7lXEe2WxhAQ99Pgs4aXL6" +
           "mkmepRbXKo8zymh3sfKG/JFn+8NvfKH2g7trLrIlZlney/00dN/uxs1JVvrE" +
           "HXs77utC782fvfwTF994nD5f3k14v35Oze11t79TQtheWNwCyX7+1T/z1h9+" +
           "9i+KM8L/AvB4r5vvKgAA");
    }
    public class SVGPathSegCurvetoQuadraticSmoothItem extends org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem implements org.w3c.dom.svg.SVGPathSegCurvetoQuadraticSmoothAbs, org.w3c.dom.svg.SVGPathSegCurvetoQuadraticSmoothRel {
        public SVGPathSegCurvetoQuadraticSmoothItem(short type,
                                                    java.lang.String letter,
                                                    float x,
                                                    float y) {
            super(
              type,
              letter);
            this.
              x =
              x;
            this.
              y =
              y;
        }
        public SVGPathSegCurvetoQuadraticSmoothItem(org.w3c.dom.svg.SVGPathSeg pathSeg) {
            super(
              );
            type =
              pathSeg.
                getPathSegType(
                  );
            switch (type) {
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS:
                    letter =
                      PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticSmoothAbs)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticSmoothAbs)
                         pathSeg).
                        getY(
                          );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL:
                    letter =
                      PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticSmoothRel)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticSmoothRel)
                         pathSeg).
                        getY(
                          );
                    break;
                default:
            }
        }
        public float getX() { return x; }
        public float getY() { return y; }
        public void setX(float x) { this.
                                      x =
                                      x;
                                    resetAttribute(
                                      ); }
        public void setY(float y) { this.
                                      y =
                                      y;
                                    resetAttribute(
                                      ); }
        protected java.lang.String getStringValue() {
            return letter +
            ' ' +
            java.lang.Float.
              toString(
                x) +
            ' ' +
            java.lang.Float.
              toString(
                y);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "lT6F/oG/YvPhfwHkXS5hwxsAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "eP1vPfX1/GbgfwFNm2Bz3yYAAA==");
    }
    protected class PathSegListBuilder extends org.apache.batik.parser.DefaultPathHandler {
        protected org.apache.batik.dom.svg.ListHandler
          listHandler;
        public PathSegListBuilder(org.apache.batik.dom.svg.ListHandler listHandler) {
            super(
              );
            this.
              listHandler =
              listHandler;
        }
        public void startPath() throws org.apache.batik.parser.ParseException {
            listHandler.
              startList(
                );
        }
        public void endPath() throws org.apache.batik.parser.ParseException {
            listHandler.
              endList(
                );
        }
        public void movetoRel(float x, float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegMovetoLinetoItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_MOVETO_REL,
                  PATHSEG_MOVETO_REL_LETTER,
                  x,
                  y));
        }
        public void movetoAbs(float x, float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegMovetoLinetoItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_MOVETO_ABS,
                  PATHSEG_MOVETO_ABS_LETTER,
                  x,
                  y));
        }
        public void closePath() throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_CLOSEPATH,
                  PATHSEG_CLOSEPATH_LETTER));
        }
        public void linetoRel(float x, float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegMovetoLinetoItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_LINETO_REL,
                  PATHSEG_LINETO_REL_LETTER,
                  x,
                  y));
        }
        public void linetoAbs(float x, float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegMovetoLinetoItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_LINETO_ABS,
                  PATHSEG_LINETO_ABS_LETTER,
                  x,
                  y));
        }
        public void linetoHorizontalRel(float x)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegLinetoHorizontalItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_LINETO_HORIZONTAL_REL,
                  PATHSEG_LINETO_HORIZONTAL_REL_LETTER,
                  x));
        }
        public void linetoHorizontalAbs(float x)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegLinetoHorizontalItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_LINETO_HORIZONTAL_ABS,
                  PATHSEG_LINETO_HORIZONTAL_ABS_LETTER,
                  x));
        }
        public void linetoVerticalRel(float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegLinetoVerticalItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_LINETO_VERTICAL_REL,
                  PATHSEG_LINETO_VERTICAL_REL_LETTER,
                  y));
        }
        public void linetoVerticalAbs(float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegLinetoVerticalItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_LINETO_VERTICAL_ABS,
                  PATHSEG_LINETO_VERTICAL_ABS_LETTER,
                  y));
        }
        public void curvetoCubicRel(float x1,
                                    float y1,
                                    float x2,
                                    float y2,
                                    float x,
                                    float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoCubicItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_CURVETO_CUBIC_REL,
                  PATHSEG_CURVETO_CUBIC_REL_LETTER,
                  x1,
                  y1,
                  x2,
                  y2,
                  x,
                  y));
        }
        public void curvetoCubicAbs(float x1,
                                    float y1,
                                    float x2,
                                    float y2,
                                    float x,
                                    float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoCubicItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_CURVETO_CUBIC_ABS,
                  PATHSEG_CURVETO_CUBIC_ABS_LETTER,
                  x1,
                  y1,
                  x2,
                  y2,
                  x,
                  y));
        }
        public void curvetoCubicSmoothRel(float x2,
                                          float y2,
                                          float x,
                                          float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoCubicSmoothItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_CURVETO_CUBIC_SMOOTH_REL,
                  PATHSEG_CURVETO_CUBIC_SMOOTH_REL_LETTER,
                  x2,
                  y2,
                  x,
                  y));
        }
        public void curvetoCubicSmoothAbs(float x2,
                                          float y2,
                                          float x,
                                          float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoCubicSmoothItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_CURVETO_CUBIC_SMOOTH_ABS,
                  PATHSEG_CURVETO_CUBIC_SMOOTH_ABS_LETTER,
                  x2,
                  y2,
                  x,
                  y));
        }
        public void curvetoQuadraticRel(float x1,
                                        float y1,
                                        float x,
                                        float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoQuadraticItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_CURVETO_QUADRATIC_REL,
                  PATHSEG_CURVETO_QUADRATIC_REL_LETTER,
                  x1,
                  y1,
                  x,
                  y));
        }
        public void curvetoQuadraticAbs(float x1,
                                        float y1,
                                        float x,
                                        float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoQuadraticItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_CURVETO_QUADRATIC_ABS,
                  PATHSEG_CURVETO_QUADRATIC_ABS_LETTER,
                  x1,
                  y1,
                  x,
                  y));
        }
        public void curvetoQuadraticSmoothRel(float x,
                                              float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoQuadraticSmoothItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL,
                  PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL_LETTER,
                  x,
                  y));
        }
        public void curvetoQuadraticSmoothAbs(float x,
                                              float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoQuadraticSmoothItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS,
                  PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS_LETTER,
                  x,
                  y));
        }
        public void arcRel(float rx, float ry,
                           float xAxisRotation,
                           boolean largeArcFlag,
                           boolean sweepFlag,
                           float x,
                           float y) throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegArcItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_ARC_REL,
                  PATHSEG_ARC_REL_LETTER,
                  rx,
                  ry,
                  xAxisRotation,
                  largeArcFlag,
                  sweepFlag,
                  x,
                  y));
        }
        public void arcAbs(float rx, float ry,
                           float xAxisRotation,
                           boolean largeArcFlag,
                           boolean sweepFlag,
                           float x,
                           float y) throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegArcItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_ARC_ABS,
                  PATHSEG_ARC_ABS_LETTER,
                  rx,
                  ry,
                  xAxisRotation,
                  largeArcFlag,
                  sweepFlag,
                  x,
                  y));
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "yU+VZTs1Lg/3egv/Yf6IT0f+C8e1HInJLgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "jmjhmC/s3X+nWngGoP/OTgt/cDZauLA9");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("63Rb7E+ehj0bZu/REHrwMPap7bqhftwPHjsLDXx/p4E/emM0cOM0DWSnf/ae" +
           "OlEDx33g6TvVQB3IurftmxO9ARr40dM0kB1F2SuD2W6ngXEkyn522um4B1TO" +
           "Av89O/xvemPwv8p0scXfyZrGCfiP2//Us2Wn4f9xIOmDO/wPng3+E2vXvclp" +
           "qJms6YfQDx1FfbvoH5wF9sd32B9/PbG/9zTs78sa/rbYj9tduFPs7wKY/9wO" +
           "+9Nng/1yTnD5iMvnj4+sPlxeuK6liNlp7r3lEV2Zp+kqewdjTwmhS6J/QkJQ" +
           "z0IxP7pTTPX1VMw++GMa2JymgfdnTbjVwHHXiF6LBpIQuv/4exY52YMhhLzG" +
           "VzYCH3r42Cti29eapF948epdb31x9q/zNxRuvnp0Nw3dpUaWdfi076HrS56v" +
           "qEau1Lu3Z3+9XAMfCqGHbydbCJ0HbQZh7y9vqT8cQm85iRpQgvYw5UdD6NpR" +
           "yhC6mP8/TPfXQujKAV1mifziMMknAHdAkl3+rLev0Kdvt8zaVFQxsvLF1P1T" +
           "9du12YcPu2r+E+DUsu/Q+vs7blk4z1/y21/kjrav+T0rfenF7uD936t8fvsK" +
           "hmSJaZpxuYuGLm/fBsmZZgvlT9yW2z6vS52nfnDvL979w/sr+vduBT4Im0Oy" +
           "PX7y+w4t2wvzNxTSX3nr33/3337xG/k54f8HzWGJs305AAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "eXivKx8oAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "LoWaXjoW0+++UTE9Ai75QEzymyqm/PGz");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("BcHXb03wlYLgG3nx1ah050GMPQPya28U5LvAZR+AtN8ckPvHseOlY6R/dGuq" +
       "rxyr9Y/z4t+CAGa4oRIUiDuK6gVnlfvNN4r78VK+17z7RT9I3H/6mnD/17x4" +
       "JSq9JVD8/PTWOar+1pvh9h8+gPzhH5A9f/fV7Pl/5sW3ozy1cbzkPJx//mbg" +
       "/OgBzo++6ThfKgj++jVp9W/y4i8BWNH3FVc+B+xfvVGwT4Lr5w7A/tzrBXt+" +
       "+ncC7Kdygr3Lt57W9u7OiwtR6d6jaS1HeRjIH7td7n9EmEti7+IbkERxCu59" +
       "4PrMgSQ+8+ZI4oRWyUNI124JKf/oGYiubCtBIZoHbz9Hvuumjvz88HawO8N9" +
       "NOUVXT2cF/eDWUD2itrz0q+LiWfIx/J84I3KswKuLxzI8ws/IMt6+jaWVc6L" +
       "a7ll6Ypk5cZy8B209+gxyqfeAMp8fi/qf+sA5W+96SiLYLFXvw3K/ON+rwK+" +
       "+nf+c5AknfSh97/OU7rXjh9Pexj8emSVRaUHz+8/P8/40E3/drA7Ki998YUr" +
       "l9/+wuzf7z5nDo+z3zUqXVZj2z55/OzE/SU/UFSjkOVdu8NoRX6/9+xBJnge" +
       "ePC5Acqc7b0P7Ki74BPiPGpACcqTlDjIL85Sgly/+HuSjgCR+5gOfPvsbk6S" +
       "jEDvgCS/HfuHGnv3a9FYcQR0FwweOmmfxbTwqs571OTkOdv827T4t5HDBYl4" +
       "948jN6QvvUBSP/a9xud353wlW9xu814ug8/I3ZHjotN8UePxW/Z22NelwdPf" +
       "v+/Ldz11uABz347hY185wds7zz9R23P8qDgDu/3dt/+zH/mVF/6kOJ32fwGS" +
       "C7mHzzMAAA==");
}
