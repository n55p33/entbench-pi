package org.apache.batik.css.engine.sac;
public class CSSClassCondition extends org.apache.batik.css.engine.sac.CSSAttributeCondition {
    public CSSClassCondition(java.lang.String localName, java.lang.String namespaceURI,
                             java.lang.String value) { super(localName,
                                                             namespaceURI,
                                                             true,
                                                             value);
    }
    public short getConditionType() { return SAC_CLASS_CONDITION;
    }
    public boolean match(org.w3c.dom.Element e, java.lang.String pseudoE) {
        if (!(e instanceof org.apache.batik.css.engine.CSSStylableElement))
            return false;
        java.lang.String attr =
          ((org.apache.batik.css.engine.CSSStylableElement)
             e).
          getCSSClass(
            );
        java.lang.String val =
          getValue(
            );
        int attrLen =
          attr.
          length(
            );
        int valLen =
          val.
          length(
            );
        int i =
          attr.
          indexOf(
            val);
        while (i !=
                 -1) {
            if (i ==
                  0 ||
                  java.lang.Character.
                  isSpaceChar(
                    attr.
                      charAt(
                        i -
                          1))) {
                if (i +
                      valLen ==
                      attrLen ||
                      java.lang.Character.
                      isSpaceChar(
                        attr.
                          charAt(
                            i +
                              valLen))) {
                    return true;
                }
            }
            i =
              attr.
                indexOf(
                  val,
                  i +
                    valLen);
        }
        return false;
    }
    public java.lang.String toString() { return '.' + getValue();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ye2wcRxmfu4vfdvzIs3k4LycoD24bWlcKTkuTq904nBMT" +
                                                              "pxE4JJe5vbm7jfd2N7tz9tkl0BahpEhEIbhNqEgEUqoW1DYVagQIWgVVoq1a" +
                                                              "kFoiSkFNkUAiPCIaIZU/ApTvm9nb3ds7OwQBlnZuPfN938z3+n3f7DPXSJ1j" +
                                                              "k25m8DiftJgT7zf4MLUdlkno1HH2wlxKPR2jfz14ddeWKKkfJXPz1BlSqcMG" +
                                                              "NKZnnFGyXDMcTg2VObsYyyDHsM0cZo9TrpnGKFmgOYMFS9dUjQ+ZGYYE+6id" +
                                                              "JJ2Uc1tLFzkbdAVwsjwJJ1HESZRt4eW+JGlVTWvSJ18cIE8EVpCy4O/lcNKR" +
                                                              "PEzHqVLkmq4kNYf3lWyy0TL1yZxu8jgr8fhhvdc1wc5kb5UJVj/f/sGNk/kO" +
                                                              "YYJ51DBMLtRz9jDH1MdZJkna/dl+nRWcI+TzJJYkLQFiTnqS5U0V2FSBTcva" +
                                                              "+lRw+jZmFAsJU6jDy5LqLRUPxMmqSiEWtWnBFTMszgwSGrmru2AGbVd62kot" +
                                                              "q1R8bKMyffpgx3djpH2UtGvGCB5HhUNw2GQUDMoKaWY72zIZlhklnQY4e4TZ" +
                                                              "GtW1KdfTXY6WMygvgvvLZsHJosVssadvK/Aj6GYXVW7annpZEVDuf3VZneZA" +
                                                              "14W+rlLDAZwHBZs1OJidpRB3LsucMc3IcLIizOHp2PNJIADWhgLjedPbao5B" +
                                                              "YYJ0yRDRqZFTRiD0jByQ1pkQgDYnS2YUira2qDpGcyyFERmiG5ZLQNUkDIEs" +
                                                              "nCwIkwlJ4KUlIS8F/HNt19YTDxo7jCiJwJkzTNXx/C3A1B1i2sOyzGaQB5Kx" +
                                                              "dUPycbrwxeNRQoB4QYhY0nzvc9fv3dR96VVJs7QGze70YabylHo+PffNZYn1" +
                                                              "W2J4jEbLdDR0foXmIsuG3ZW+kgUIs9CTiIvx8uKlPT/5zEPfYX+KkuZBUq+a" +
                                                              "erEAcdSpmgVL05l9PzOYTTnLDJImZmQSYn2QNMB7UjOYnN2dzTqMD5I5upiq" +
                                                              "N8X/YKIsiEATNcO7ZmTN8rtFeV68lyxCSAM8pBWeFUT+iV9OMkreLDCFqtTQ" +
                                                              "DFMZtk3U31EAcdJg27yShqgfUxyzaEMIKqadUyjEQZ65C6qDtDk4k+JQVUmM" +
                                                              "jAhfQj5lhOpxjDbr/7RPCfWdNxGJgCuWhYFAhxzaYeoZZqfU6eL2/uvPpV6X" +
                                                              "QYaJ4VqKk82wdVxuHRdbx2HruNw6DlvHq7YmkYjYcT4eQToe3DYGAAAI3Lp+" +
                                                              "5MDOQ8dXxyDirIk5YHMkXV1RiRI+SpShPaVe6GqbWnVl88tRMidJuqjKi1TH" +
                                                              "wrLNzgFkqWNuVremoUb5pWJloFRgjbNNlWUAqWYqGa6URnOc2TjPyfyAhHIh" +
                                                              "w5RVZi4jNc9PLp2ZeHjfF26PkmhldcAt6wDYkH0YMd3D7p4wKtSS237s6gcX" +
                                                              "Hj9q+vhQUW7KVbKKE3VYHY6JsHlS6oaV9GLqxaM9wuxNgN+cguMBGrvDe1TA" +
                                                              "T18ZylGXRlA4a9oFquNS2cbNPG+bE/6MCNZO8T4fwqIF83EZPD1ugopfXF1o" +
                                                              "4bhIBjfGWUgLUSruHrHO/vJnf7hDmLtcVdoD7cAI430BJENhXQKzOv2w3Wsz" +
                                                              "BnTvnhn+2mPXju0XMQsUa2pt2INjAhAMXAhm/tKrR95578r5y1E/zjmU8mIa" +
                                                              "OqKSpyTOk+ZZlITd1vnnASTUASUwanoeMCA+taxG0zrDxPp7+9rNF/98okPG" +
                                                              "gQ4z5TDadHMB/vxt28lDrx/8W7cQE1GxEvs288kkvM/zJW+zbTqJ5yg9/Nby" +
                                                              "r79Cz0KhAHB2tCkm8DYmbBATmi+GxkxwYtGNy6KL83eJQfi1VxDeLsY70SaC" +
                                                              "nYi1LTisdYL5UZmCgaYqpZ68/H7bvvdfui4UquzKguEwRK0+GYE4rCuB+EVh" +
                                                              "/NpBnTzQ3Xlp12c79Es3QOIoSFQBn53dNuBoqSJ4XOq6hl/9+OWFh96MkegA" +
                                                              "adZNmhmgIg9JEyQAc/IAwSXrE/dK/080wtAhVCVVyldNoA9W1PZuf8Hiwh9T" +
                                                              "31/0wtanzl0RgWhJGUuDAj+Cw0YvJMVffbgwBkOyQoJNls/Uu4i+6/wj0+cy" +
                                                              "u5/cLDuMrsp+oB/a3Wd/8Y834md+81qN0tPETeujOhtnemDPGG5ZUS6GRFvn" +
                                                              "Q9a7c0/99gc9ue23UilwrvsmtQD/XwFKbJgZ+cNHeeWRPy7Ze0/+0C2A/oqQ" +
                                                              "OcMivz30zGv3r1NPRUUPK/G+qvetZOoLGhY2tRk06waqiTNtIuzXeAHQiY5d" +
                                                              "BU/cDYB4beCtETsenM3EOktW75tl7dM4fApQI8e412aIylHROqCTR4ppB8q8" +
                                                              "VgCacbcT/tjwIfV4z/DvZAzeVoNB0i14WvnKvrcPvyG81Yjh4dkoEBoQRoGC" +
                                                              "1SGV/xD+IvD8Ex88N07IjrIr4ba1K72+FvPQJutnuYhWKqAc7Xpv7BtXn5UK" +
                                                              "hPv+EDE7Pv3lD+MnpmVCycvRmqr7SZBHXpCkOjgcwNOtmm0XwTHw+wtHf/j0" +
                                                              "0WNR10uDnNQBnNnc82HEa/DmVxpdnvS+R9t/dLIrNgCJOkgai4Z2pMgGM5XB" +
                                                              "2uAU0wEv+LcpP3TdM6PFOYlsKIPcx3HYI9/v/g/xFScSlpgf8qJ8Hq4thqfX" +
                                                              "jfLeW0+QmVhDSRAVB4mWq+Y87MUn7lDjGbMQx68NYFW/ZjqzZNAEDnBdqytQ" +
                                                              "ruYFyajravxJBd6h5jekTVNn1Ag7Ev/NB6xr/g+s24VrS+AZck00dOvWnYl1" +
                                                              "FgMdm2XtURwe4aSRm4FmxTfDF/8bZihx0ll1lcICv7jqC4786qA+d669cdG5" +
                                                              "B94Wdc77MtAK0JUt6nogh4L5VG/ZLKsJtVplv2OJn69CFbnJTY9D7aWqOP9J" +
                                                              "yTTNydJZmKDhlS9BntNwparFA9JhDFI+AYAfpoQIFr9BurOcNPt0sKl8CZJ8" +
                                                              "E6QDCb5+yypnU++/cbP1vkZ6LilFqlsoEQULbhYFgZ5pTQX0iy95ZXQsym95" +
                                                              "cOE9t3PXg9fvelLeYFSdTk2hlBbARHmZ8lqGVTNKK8uq37H+xtznm9aWobpT" +
                                                              "HtjPpKWBcE9AplsYeUtC7b3T43X575zf+tJPj9e/BUVmP4lQgKb9ge9o8qMR" +
                                                              "3BGK0KvtT1ZjP7RX4t7Rt/6JyXs2Zf/ya9GdurVi2cz0KfXyUwd+fmrxebif" +
                                                              "tAySOqhCrDRKmjXnvkljD1PH7VHSpjn9JTgiSNGoXlFY5mKSUMxgYRfXnG3e" +
                                                              "LN5/OVldXSyrvxpAJz/B7O1m0ci4panFn6n4xFjuuoqWFWLwZwINRU5Csewd" +
                                                              "YqnkkGWVe4mGbkuARb42LuP4gnjF4eK/AGXuCrzlFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
