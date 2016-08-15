package org.apache.batik.dom.svg;
public class SVGTextContentSupport {
    public static int getNumberOfChars(org.w3c.dom.Element elt) { final org.apache.batik.dom.svg.SVGOMElement svgelt =
                                                                    (org.apache.batik.dom.svg.SVGOMElement)
                                                                      elt;
                                                                  return ((org.apache.batik.dom.svg.SVGTextContent)
                                                                            svgelt.
                                                                            getSVGContext(
                                                                              )).
                                                                    getNumberOfChars(
                                                                      );
    }
    public static org.w3c.dom.svg.SVGRect getExtentOfChar(org.w3c.dom.Element elt,
                                                          final int charnum) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        if (charnum <
              0 ||
              charnum >=
              getNumberOfChars(
                elt)) {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        }
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return new org.w3c.dom.svg.SVGRect(
          ) {
            public float getX() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getExtent(
                           svgelt,
                           context,
                           charnum).
                         getX(
                           );
            }
            public void setX(float x)
                  throws org.w3c.dom.DOMException {
                throw svgelt.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.rect",
                    null);
            }
            public float getY() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getExtent(
                           svgelt,
                           context,
                           charnum).
                         getY(
                           );
            }
            public void setY(float y)
                  throws org.w3c.dom.DOMException {
                throw svgelt.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.rect",
                    null);
            }
            public float getWidth() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getExtent(
                           svgelt,
                           context,
                           charnum).
                         getWidth(
                           );
            }
            public void setWidth(float width)
                  throws org.w3c.dom.DOMException {
                throw svgelt.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.rect",
                    null);
            }
            public float getHeight() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getExtent(
                           svgelt,
                           context,
                           charnum).
                         getHeight(
                           );
            }
            public void setHeight(float height)
                  throws org.w3c.dom.DOMException {
                throw svgelt.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.rect",
                    null);
            }
        };
    }
    protected static java.awt.geom.Rectangle2D getExtent(org.apache.batik.dom.svg.SVGOMElement svgelt,
                                                         org.apache.batik.dom.svg.SVGTextContent context,
                                                         int charnum) {
        java.awt.geom.Rectangle2D r2d =
          context.
          getExtentOfChar(
            charnum);
        if (r2d ==
              null)
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        return r2d;
    }
    public static org.w3c.dom.svg.SVGPoint getStartPositionOfChar(org.w3c.dom.Element elt,
                                                                  final int charnum)
          throws org.w3c.dom.DOMException {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        if (charnum <
              0 ||
              charnum >=
              getNumberOfChars(
                elt)) {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        }
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return new org.apache.batik.dom.svg.SVGTextContentSupport.SVGTextPoint(
          svgelt) {
            public float getX() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getStartPos(
                           this.
                             svgelt,
                           context,
                           charnum).
                         getX(
                           );
            }
            public float getY() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getStartPos(
                           this.
                             svgelt,
                           context,
                           charnum).
                         getY(
                           );
            }
        };
    }
    protected static java.awt.geom.Point2D getStartPos(org.apache.batik.dom.svg.SVGOMElement svgelt,
                                                       org.apache.batik.dom.svg.SVGTextContent context,
                                                       int charnum) {
        java.awt.geom.Point2D p2d =
          context.
          getStartPositionOfChar(
            charnum);
        if (p2d ==
              null)
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        return p2d;
    }
    public static org.w3c.dom.svg.SVGPoint getEndPositionOfChar(org.w3c.dom.Element elt,
                                                                final int charnum)
          throws org.w3c.dom.DOMException {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        if (charnum <
              0 ||
              charnum >=
              getNumberOfChars(
                elt)) {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        }
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return new org.apache.batik.dom.svg.SVGTextContentSupport.SVGTextPoint(
          svgelt) {
            public float getX() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getEndPos(
                           this.
                             svgelt,
                           context,
                           charnum).
                         getX(
                           );
            }
            public float getY() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getEndPos(
                           this.
                             svgelt,
                           context,
                           charnum).
                         getY(
                           );
            }
        };
    }
    protected static java.awt.geom.Point2D getEndPos(org.apache.batik.dom.svg.SVGOMElement svgelt,
                                                     org.apache.batik.dom.svg.SVGTextContent context,
                                                     int charnum) {
        java.awt.geom.Point2D p2d =
          context.
          getEndPositionOfChar(
            charnum);
        if (p2d ==
              null)
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        return p2d;
    }
    public static void selectSubString(org.w3c.dom.Element elt,
                                       int charnum,
                                       int nchars) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        if (charnum <
              0 ||
              charnum >=
              getNumberOfChars(
                elt)) {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        }
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        context.
          selectSubString(
            charnum,
            nchars);
    }
    public static float getRotationOfChar(org.w3c.dom.Element elt,
                                          final int charnum) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        if (charnum <
              0 ||
              charnum >=
              getNumberOfChars(
                elt)) {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        }
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return context.
          getRotationOfChar(
            charnum);
    }
    public static float getComputedTextLength(org.w3c.dom.Element elt) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return context.
          getComputedTextLength(
            );
    }
    public static float getSubStringLength(org.w3c.dom.Element elt,
                                           int charnum,
                                           int nchars) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        if (charnum <
              0 ||
              charnum >=
              getNumberOfChars(
                elt)) {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        }
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return context.
          getSubStringLength(
            charnum,
            nchars);
    }
    public static int getCharNumAtPosition(org.w3c.dom.Element elt,
                                           final float x,
                                           final float y)
          throws org.w3c.dom.DOMException {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return context.
          getCharNumAtPosition(
            x,
            y);
    }
    public static class SVGTextPoint extends org.apache.batik.dom.svg.SVGOMPoint {
        org.apache.batik.dom.svg.SVGOMElement
          svgelt;
        SVGTextPoint(org.apache.batik.dom.svg.SVGOMElement elem) {
            super(
              );
            svgelt =
              elem;
        }
        public void setX(float x) throws org.w3c.dom.DOMException {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  NO_MODIFICATION_ALLOWED_ERR,
                "readonly.point",
                null);
        }
        public void setY(float y) throws org.w3c.dom.DOMException {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  NO_MODIFICATION_ALLOWED_ERR,
                "readonly.point",
                null);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "WzPsBwCnckyTUw604hmg9b/I6GyhW+frDxQHWIcdEx0zBBgbpOJwKre1tG7Y" +
           "X5lznSpPMMEJHmfDF4WC7mfzhx1lfOl/oYwcRXXuDjNvt/Dtdange+1Fr8TE" +
           "axzp+dONNfNP3/sOTwCFVy11EPtpS1Hc2dw1r9YNkhZKqhO5Xec/07ZLlboa" +
           "RRUwcgmeENQnoMksRQ2UMLopn6KoyU8JgcZ/3XSnKKp16CAjiomb5BvAHUjY" +
           "9Jt6Xp8rZi7Pue5zAW8mL1i69VaWdiX/FR64428z84hgifeZ0PCf3rnroRuf" +
           "ekZ0cJKCJycZlzmAA6KZLKS/5WW55XlV71h9s+GF2Svz8NQsLuzEzCJXd9EN" +
           "zq2zwnqhr88xQ4V2590zm1/+yVT1WwCse1EAUzR3b3HlmNMtqDv2RovxDkoF" +
           "3oB1rX5qYsu69J9/xWtzVFSR++kT0pWzD759rP0MNGpz+lEVIC/J8ZJ224S6" +
           "m0hjRhzVy2ZvDq4IXGSseMC0gfk1Zu85uV5sddYXVln/T1FncYIofmsCfcw4" +
           "Mbo1S03ZcDzHWfG8Zs1XEBCDvg3OiiuJUoGtIl9WJKIDup7PnzWXdQ4IViko" +
           "svjuF/mUDRf/AyvGdbvpGAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1ae8zj2FX39+3s7Ox0d2d2u68u+97Zom3KZzuJ89CUUsdJ" +
           "/IgTO47jJKZ01vEjduJX/IgTly3tItqKQil0W4poFwm1oq22DyEqkFDRIgRt" +
           "1QqpqOIl0VYIiUKp6P5BQRQo1873nm+2rEBEys319bnnnnPuOb977r154TvQ" +
           "zWEAFXzP3sxsL9rT19He3Mb2oo2vh3sMi/FKEOoaYSthKIK2a+rjn730ve+/" +
           "z7y8C52XoVcrrutFSmR5bijooWevdI2FLh21tmzdCSPoMjtXVgocR5YNs1YY" +
           "XWWhVx3rGkFX2AMRYCACDESAcxFg/IgKdLpdd2OHyHoobhQuobdBOyx03lcz" +
           "8SLosZNMfCVQnH02fK4B4HAhe5aAUnnndQA9eqj7VufrFP5AAX7uV99y+bdv" +
           "gi7J0CXLHWTiqECICAwiQ7c5ujPVgxDXNF2ToTtdXdcGemAptpXmcsvQXaE1" +
           "c5UoDvRDI2WNsa8H+ZhHlrtNzXQLYjXygkP1DEu3tYOnmw1bmQFd7z3Sdath" +
           "O2sHCl60gGCBoaj6QZdzC8vVIuiR0z0OdbzSAQSg6y2OHpne4VDnXAU0QHdt" +
           "585W3Bk8iALLnQHSm70YjBJBD9yQaWZrX1EXyky/FkH3n6bjt68A1a25IbIu" +
           "EXTPabKcE5ilB07N0rH5+U7vDe99q0u5u7nMmq7amfwXQKeHT3USdEMPdFfV" +
           "tx1vex37QeXez797F4IA8T2niLc0v/vTL73p9Q+/+MUtzY+cQcNN57oaXVM/" +
           "Or3jqw8ST9VvysS44HuhlU3+Cc1z9+f331xd+yDy7j3kmL3cO3j5ovAnk7d/" +
           "Uv/2LnSRhs6rnh07wI/uVD3Ht2w9IHVXD5RI12joVt3ViPw9Dd0C6qzl6ttW" +
           "zjBCPaKhc3bedN7Ln4GJDMAiM9EtoG65hndQ95XIzOtrH4Kgu8AXug+Cdu6G" +
           "8s/2N4IU2PQcHVZUxbVcD+YDL9M/hHU3mgLbmvAUeP0CDr04AC4Ie8EMVoAf" +
           "mPr+C81z4HAFXEkiRRBAeRy50SD2fS8A2ANczf//GGSdaXo52dkBk/DgaQiw" +
           "QfRQnq3pwTX1ubjReunT1768exgS+zaKoKtg3L3tuHv5uHtg3D0w7t6Z417Z" +
           "b+U9EKLQzk4+9t2ZMNvJB1O3ACAA4PG2pwY/xTz97sdvAl7nJ+cy6wNS+MYo" +
           "TRzBBp2Dowp8F3rxQ8k7pJ9BdqHdk3CbKQCaLmbd+QwkD8HwyukwO4vvpXd9" +
           "63uf+eAz3lHAncDvfRy4vmcWx4+fNnXgqboGkPGI/eseVT537fPPXNmFzgFw" +
           "AIAYKcCBAdY8fHqME/F89QAbM11uBgobXuAodvbqANAuRmbgJUctuQ/ckdfv" +
           "BDa+kDk48PKde/c9Pv/N3r7az8q7tz6TTdopLXLs/fGB/5G//NN/KOXmPoDp" +
           "S8cWvoEeXT0GDRmzSzkI3HnkA2Kg64Dubz7Ev/8D33nXT+YOACieOGvAK1lJ" +
           "AEgAUwjM/HNfXP7VN77+0a/tHjoNtD6p24WX0Q0M8tojMQCi2CDgMme5MnQd" +
           "T7MMS5naeuac/3HpSfRz//Tey9vpt0HLgfe8/oczOGp/TQN6+5ff8q8P52x2" +
           "1GxFOzLVEdkWJl99xBkPAmWTybF+x5899GtfUD4CABeAXGileo5bO/vxkgl1" +
           "TwQ9+XIxynWz/AREaD6ze3mfp/LyxzLz7Bsxey5mxSPh8Qg5GYTH8pRr6vu+" +
           "9t3bpe/+wUu5bicTneMO0VX8q1sfzIpH14D9fafhgFJCE9CVX+y9+bL94vcB" +
           "RxlwVAHqhVwAAGp9wn32qW++5a//8I/uffqrN0G7beii7SlaW8kjEboVhIAe" +
           "mgDb1v5PvGnrC0nmHJdzVaHrlN+60P350zkg4FM3BqF2lqccxfH9/87Z02f/" +
           "9t+uM0IOP2csz6f6y/ALH36AeOO38/5HOJD1fnh9PWiDnO6ob/GTzr/sPn7+" +
           "j3ehW2TosrqfMEqKHWfRJYMkKTzIIkFSeeL9yYRnu7pfPcS5B09j0LFhTyPQ" +
           "0WIB6hl1Vr94Fug8CBz2nv3AvOc06OxAeeVNeZfH8vJKVvzoiRj/AfjsgO9/" +
           "Zd+sPWvYrth3Eftpw6OHeYMPVq/zIAh0Ow9eeAtsWVnKCnzLtHJDD7maFc31" +
           "zk4E3Vzcq+4h2TN9toQ3gaH8eGpbajZmnjyDXoblKnZui2YEvN5WrxxIKYFk" +
           "GrjJlbldPQjiy7mHZxOyt81AT8nb/B/LCzz4jiNmrAeS2ff83fu+8ktPfAO4" +
           "GQPdvMpcAHjXsRF7cZbfv/OFDzz0que++Z4cXcE0SW9/8p/zbGl4A62zajcr" +
           "elnBHaj6QKbqIM9bWCWMujky6lqu7ctGFx9YDlg3VvvJK/zMXd9YfPhbn9om" +
           "pqdD6RSx/u7nfv4He+99bvfYduCJ6zLy4322W4Jc6Nv3LRxAj73cKHmP9t9/" +
           "5pnf//gz79pKddfJ5LYF9m6f+vP//Mreh775pTOyqXO297+Y2Oj2z1LlkMYP" +
           "Piw6aU7WQ2k9KnThVTOME7jKsjV2ind7fFKmKyNPblAsG8SJxihaSIli0yo1" +
           "XVEraWa1igUlSoeNKHUqbGSPm8XFgNDw1aTdoZmmPO4j/mzQ0zwSKc6n7VZJ" +
           "8YKRMlx2Hc+XJpPlmkSpIF6NYAdW0y7t2etFYKdYFUvTasmtpit3xfPjoSz5" +
           "Hl6xkDmhIfRCrtqS32yEzsAYesWmWEraPsHZZAMIviousV5f6mtCgshTHKOL" +
           "hFDv2u2BbCbRQhqJE3toYRZGDJ01lRK401UniS0O0bnt22FaCDpVeoEkrUgQ" +
           "5o1uU7GWDVsEawVjYUzBSdrtQYVJFokFD0aDAC61x+2exDjzqrlg9eqGilRx" +
           "bdro3GX9zszXZwRfnphteTAc2MMSyLH4/shGRWYxGc4nMjP3JnynEUVtfdOd" +
           "WutBX1fZuQBrPOP7ZWs5sVBJ8tCkpqbqujcadf1Ox0MkAL/D+YinZ4X5Zmkp" +
           "dIV1Oky/R9W9Bl7pJZ02pgjIMqaQ+lBBw3lt2vbGNodOgxa7EAXVqomUEJaV" +
           "KsfUxLBprv3lplYuzaoiS0R0pzOJWgbFRDIftFZLeSVVmiRHLofooF2k+ou4" +
           "r5N9jrCGMsO3uqzuDK2+JNSQJUnFNNlkRljLnSJW0eE7jKV4FFYr+qaFyVyT" +
           "qjjeJk7omumMGqw0p5myomP9elBYRjRD9XuTooBOzIlQnzaSdiBPrclCnc40" +
           "WBlt7LYsSiSCsoU5TfIeZRF4MOU2JqkgiU1KHW/SRglGFbrUckD26XGrpuEa" +
           "vWwKad8jTXOkyF00XY6EVYseiARf71HtNcHNnBCRkqncRznPLWMpPphFdcll" +
           "ZQxexulQ1Yeu7vWFAc5VdNpnm9W03O5RU6wXI45C4qLVJzfhaN2tz6NId2ae" +
           "1egOIt5hGjWsSE3rm3oQ8wOlzDjDvqMker9BR2RLI6ZyjZuCjc1o2olmqOKK" +
           "PZtx17zMph16JYtVf8MBTqNya66v5xxf3SCFmlHiSx3OaDRakVH0RhE97CRR" +
           "ASXW/khCRxZLasuuiNsdsYKMNpbvBuVaqYwQBVkYDSRLEwmtN3MjARt2xpVg" +
           "VKDq/aHgT7qNsZTY6xGC+oXA4ZSywalzs7GcDQrKHG3MwJQatWEozJ0BwtL2" +
           "jFDizXIhWWY4XfQ2HM613P50oAwanZoxly1FnuCsMBfmDM02minbMvzmIDTb" +
           "abO9BvunUCcIXBc2nha6gtZNGlHSGyNwTTW5wdQv8W0cpzdJEa81iIXINxco" +
           "0xp0TVFaaStR18VqYpbouG12kLkVBLMSi5d7tZRvqhw2EWelMc+qCxZRkE2j" +
           "NRw0cQAiFGtx3WZlMm0ION7uYFPeEGfpChVdYTzTDL/MaN3CgpIroU3ys7WA" +
           "6a063UaDJYNpxtiod1ptiRz249GSHkq2vSmSVhcf1TsepdnoQDVFMfAn2MIb" +
           "s92a7CyEwaw9tRFv2vOHkymdyFO/aOkW0i04UzKZywLPDMar+aaiUVQdKeCx" +
           "0ex0Zj2ES+hKiJd68yLZ5VHcrVBw1+xbDjwvj0JjLJqFAdVNEr+3qfnORiF0" +
           "0dP4FTWuokynj25gYN1WTPXtNAoTqtmZKBO8NA9rDGzOFCLmmSQdjXy8zAqO" +
           "zFIEFUvouBWm5nwaBxRRmupy2vZqKEvIZsux0hkmwuFSizhz5RKp5hqxIs6W" +
           "OpsmVd8vVddIWg/LXMDJmExKyCIRSGtM1JBJuFa4Ua3IFQvlNYGTlTpSJV13" +
           "vinEZL1E6o3JAgiB9MIq3hria45wArhWDNulUrVewRbLpMypHoaNInk2lctM" +
           "Q0rnQ7zRGOMENwm9cSSprRBjdW7Rt2c1eNpbY8aSNdJgwHQ3q6QFNoP1qeZ4" +
           "ZLpa4mCeWXIV1FG1OWlYA8kU0CHnDJvFuF91g4nSYOqzuuoVCpEuBkGBERdE" +
           "F7cRFFu4hNfUZmZqVSUxojoAqGyVxqWh0IhKLFOqiYjAO9isEpDShseAgZFA" +
           "HOstneb7AKltv9Mb88vEAMuoTaJJcVosOZo3awSUylBFsbk0N4lbqFNhozRJ" +
           "8aY2lrUirxGLMesxFMfjwz7wh5naS3oDdV1Cw8rSl1dwanaKpWqpssYTERsu" +
           "i7MyOtEwpsPKLZxtpTiuYrDIlwZobSInmLDujtvCkBlXRTxlSSTqtKthGti+" +
           "79aqq2Tcw2p1Qx5VPQsrs4SPV4s0X+fpTqnsFtRiHS44mrsqybVxr08va1HT" +
           "depGIa2Rti7MV7BdXYBpKjIjb1xKq2WMSsUNHBYNulEqFGbNKNQ2puT2ho1Y" +
           "LhQ0rMrAzbE8gjcWLYeSsCgKY7Tbm4TSLFxXyE6P79k9W9Tc2NAtmxjyKNKW" +
           "2qVQSNNxOK7U1Crtp40F6tT18SyYtye0PCITWYEFfNynNptFsYDNEjSwEHJR" +
           "IiudpUVurC4tTJQePkjleBJ268msVrRLdLWmzzh+iZnJRi9HyaDhjcpguwdW" +
           "asoJyi1c0WqaYyAl25yLVFUg2GAwtjc2pod+HQCHjygrQq6r7HoUbGyZqCOD" +
           "EK7D7cI42WgwPF4yxeUYbNtjFS/zIU8XjCbcKCYUqdTXSw425KonU3GxsoiL" +
           "7YBidY+quzV/wBKOwc3LAcwuJ6W6GpMaK6/qURv3WWMaICGcjhLeHUeVwmA+" +
           "k7DqhqvFiunWnOqytvKTYEjONhJf0ptrTFCpylzdgLWcWhLFNGA3lgZW8Io0" +
           "afTMUiqHoxYpB9VuizAlYc7Om5LNtBCvwPVD2QjTeM5VulVZd/oBZRCqpgzJ" +
           "TtMjo3pvxUrlscqNOXm0JNsOW5vH3blTNitRWRFoy8A3Bk6lcDqthhVn3dAa" +
           "s4gHpggraR9LGy3XbCtGn2k1g1GNhwMk0vUWTpXVukCKS92lQIppOIIs0H5g" +
           "t4fj+tKNeYWx2hyZlBOyUjI6sligK4USWivXedRtrhGuaLoVPgySYZdDTGbs" +
           "6PIwngZB1CkjMNfzB0hfbRTp+pJtDwsKQxXsnsrImD1CnGHbr0bFca9T6Na7" +
           "5TrRDvqsXeOkEinrm43PFCVG706ZdqU3pbsVhlAFVx2qpdqGgoXBklywqzIa" +
           "DkcpHzYSwlUXG3GYVJCy6czqU5iukBtzVDCC5rpPjWhVawG0bDRmU59jkk6g" +
           "oxFZnYwxO3UHPt/tthjKMZrt8oioOkZqrlHb4GzYmySqMB7HzXlvFcHNSAM7" +
           "K72AtoOa2FLWqV/QuF7P6PElOOTEhGhLGxRt8ZE/QCm1qIFgqE96C1PuLE0O" +
           "G+sqjFRl1p56iiAME3Xm6K1e3/W6i1DoF4dd1vPdSsfbDGvMTJXh0njgdjo+" +
           "WiHwueU5U6yxwimQqdaZqDL2a4FsVflYB4nSqOawqFWpS8pIs8ZwW6iUy8Va" +
           "WiubM8vQZYQnjFLgBp4AAnshIyrTIZiNKtupg+OVjsx2BjA2GmHY2JaqqFkP" +
           "C2S7OFiltV4/ZOO0lRLMWKu3eumymCbu0gxqtXW/LBWxOpI6KFzYSCI6SohQ" +
           "R1v4MBVK0xJlO71utGyuioK3WjcXXrvkNdBgjC0nYVypM3V4PYpSqT0QCoWF" +
           "iPijtFnF6gGPdHuknxbslkQTMFOTmWKxPKg4iDkXzFTaFOVVc1mmx+Qg1LsE" +
           "MjMWqBzXsFjCQk2bjCXbhUW07aoT2jOckDDUpNydeugAKclqM6VGBlmTQ7Dc" +
           "NojmalbiLCtmhiCoaLs+Yjp0M/arvJuOxlq/TEvWwgtX87gNg5VKMGB8syK1" +
           "6conwRYt27oZr2z3fGd+UHB4bwU2zdmL/ivYNa7PHnD3aMCjQ9P8fOXO01cg" +
           "xw9Nj87GoGyD/NCNbqnyzfFHn33ueY37GLq7f6aoRND5/cvDIz67gM3rbnwK" +
           "0M1v6I4Our7w7D8+IL7RfPoVnPE/ckrI0yw/0X3hS+Rr1V/ZhW46PPa67u7w" +
           "ZKerJw+7LgZ6FAeueOLI66FDs17KzPUYMOdr9s36mrPP2c+cqJ18orb+cOq8" +
           "9vjJ75uP+cHT2XETWBW3p7zPvEyveyLo/uy8OCmp+TFxk+u21qruZxbNOz+b" +
           "FesIOhfq0fisgc6tPEs78sTNDzu/OH7UmjfE15vp4X0zPfx/aqbs8W05wS/f" +
           "mOBnc4L3Z8UvbLWeZPV3Hmn4i69EQ2C5245fgh0Yfe+VXaSBELn/ulv77U2z" +
           "+unnL1247/nhX+S3R4e3wbey0AUjtu3jJ7LH6uf9QDesXNdbt+ezfv7z4X1/" +
           "OEu0CLoJlLkGv76l/o0IuvssakAJyuOUvxlBl09TAifNf4/TfSyCLh7RAbjY" +
           "Vo6TfBxwByRZ9RP+gT2fePlLj9z2652T6HU4o3f9sBk9BnhPnECq/A8XB6gS" +
           "b/9ycU39zPNM760vVT62vRdTbSVNMy4XWOiW7RXdITI9dkNuB7zOU099/47P" +
           "3vrkAYTesRX4KBCOyfbI2bdRLceP8vuj9Pfu+503/NbzX89PdP8bFh9Gbwkj" +
           "AAA=");
    }
    public SVGTextContentSupport() { super(
                                       );
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
