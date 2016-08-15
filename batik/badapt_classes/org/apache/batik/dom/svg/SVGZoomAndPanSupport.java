package org.apache.batik.dom.svg;
public class SVGZoomAndPanSupport implements org.apache.batik.util.SVGConstants {
    protected SVGZoomAndPanSupport() { super(); }
    public static void setZoomAndPan(org.w3c.dom.Element elt, short val) throws org.w3c.dom.DOMException {
        switch (val) {
            case org.w3c.dom.svg.SVGZoomAndPan.
                   SVG_ZOOMANDPAN_DISABLE:
                elt.
                  setAttributeNS(
                    null,
                    SVG_ZOOM_AND_PAN_ATTRIBUTE,
                    SVG_DISABLE_VALUE);
                break;
            case org.w3c.dom.svg.SVGZoomAndPan.
                   SVG_ZOOMANDPAN_MAGNIFY:
                elt.
                  setAttributeNS(
                    null,
                    SVG_ZOOM_AND_PAN_ATTRIBUTE,
                    SVG_MAGNIFY_VALUE);
                break;
            default:
                throw ((org.apache.batik.dom.AbstractNode)
                         elt).
                  createDOMException(
                    org.w3c.dom.DOMException.
                      INVALID_MODIFICATION_ERR,
                    "zoom.and.pan",
                    new java.lang.Object[] { new java.lang.Integer(
                      val) });
        }
    }
    public static short getZoomAndPan(org.w3c.dom.Element elt) { java.lang.String s =
                                                                   elt.
                                                                   getAttributeNS(
                                                                     null,
                                                                     SVG_ZOOM_AND_PAN_ATTRIBUTE);
                                                                 if (s.
                                                                       equals(
                                                                         SVG_MAGNIFY_VALUE)) {
                                                                     return org.w3c.dom.svg.SVGZoomAndPan.
                                                                              SVG_ZOOMANDPAN_MAGNIFY;
                                                                 }
                                                                 return org.w3c.dom.svg.SVGZoomAndPan.
                                                                          SVG_ZOOMANDPAN_DISABLE;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ye2wUxxmfO7+N37wcHgaMoYLAXWhCW2SaxjY2mJzxCROq" +
       "Hg3nud053+K93WV3zj47pQmRIpyqpYgAIVXDX0R5KAlR1ait2kRUkZpESSuR" +
       "oqZpFVKplUofqEGV0j9om37fzN7t3t4ZRFX1pJ3bm/nmm+/x+x5zL14jNY5N" +
       "upjBI3zGYk5k0OBxajtMHdCp4+yDuaTyZBX9+8Gre7aFSW2CtGSoM6JQhw1p" +
       "TFedBFmpGQ6nhsKcPYypuCNuM4fZU5RrppEgizVnOGvpmqLxEVNlSLCf2jHS" +
       "Tjm3tVSOs2GXAScrYyBJVEgS7Qsu98ZIk2JaMx55p498wLeClFnvLIeTttgh" +
       "OkWjOa7p0Zjm8N68Te60TH1mQjd5hOV55JC+1TXB7tjWMhN0v9L6yY0TmTZh" +
       "goXUMEwu1HP2MsfUp5gaI63e7KDOss5h8nVSFSMLfMSc9MQKh0bh0CgcWtDW" +
       "owLpm5mRyw6YQh1e4FRrKSgQJ2tKmVjUplmXTVzIDBzquau72Azari5qK7Us" +
       "U/H0ndFTTx5s+14VaU2QVs0YQ3EUEILDIQkwKMummO30qSpTE6TdAGePMVuj" +
       "ujbrerrD0SYMynPg/oJZcDJnMVuc6dkK/Ai62TmFm3ZRvbQAlPurJq3TCdB1" +
       "iaer1HAI50HBRg0Es9MUcOduqZ7UDJWTVcEdRR177gcC2FqXZTxjFo+qNihM" +
       "kA4JEZ0aE9ExgJ4xAaQ1JgDQ5mTZvEzR1hZVJukESyIiA3RxuQRUDcIQuIWT" +
       "xUEywQm8tCzgJZ9/ru3ZfvwhY5cRJiGQWWWKjvIvgE1dgU17WZrZDOJAbmza" +
       "GDtDl7w2FyYEiBcHiCXND752/b5NXRffkjTLK9CMpg4xhSeV86mWSysGNmyr" +
       "QjHqLdPR0Pklmosoi7srvXkLMsySIkdcjBQWL+792VceeYH9JUwah0mtYuq5" +
       "LOCoXTGzlqYzeyczmE05U4dJAzPUAbE+TOrgPaYZTM6OptMO48OkWhdTtab4" +
       "DSZKAws0USO8a0baLLxblGfEe94ihNTBQ7bBs4bIj/jmZDyaMbMsShVqaIYZ" +
       "jdsm6u9EIeOkwLaZaApQPxl1zJwNEIya9kSUAg4yzF1QzWzUmQIo7d+ZMM1s" +
       "n6HGqTGWsyzThmQDSLP+D2fkUc+F06EQuGBFMAHoEDu7TF1ldlI5lesfvP5y" +
       "8h0JLgwI10KcbIZjI/LYiDg2AsdG4NhIpWNJKCROW4THS2eDqyYh6CHrNm0Y" +
       "e3D3+Fx3FaDMmq4GOyNpd0n1GfAyQyGdJ5ULHc2za65seSNMqmOkgyo8R3Us" +
       "Jn32BKQpZdKN5KYU1CWvPKz2lQesa7apMBWy03xlwuVSb04xG+c5WeTjUChe" +
       "GKbR+UtHRfnJxbPTR/c/fFeYhEsrAh5ZA8kMt8cxjxfzdU8wE1Ti23rs6icX" +
       "zhwxvZxQUmIKlbFsJ+rQHcRD0DxJZeNq+mrytSM9wuwNkLM5hRgDJ3cFzyhJ" +
       "Ob2F9I261IPCadPOUh2XCjZu5BnbnPZmBFDbxfsigEULxmA3POvdoBTfuLrE" +
       "wnGpBDbiLKCFKA9fHLOe/vUv/nS3MHehkrT6WoAxxnt92QuZdYg81e7Bdp/N" +
       "GNB9eDb+xOlrxw4IzALF2koH9uA4AFkLXAhmfuytwx98dOX85bCHc04aLNvk" +
       "EN5MzRf1xCXSfBM94cD1nkiQAHXggMDpecAAiGppjaZ0hrH1z9Z1W1796/E2" +
       "CQUdZgpI2nRrBt78Hf3kkXcO/qNLsAkpWIA9s3lkMqsv9Dj32TadQTnyR99b" +
       "+dSb9GmoD5CTHW2WiTRLhBmI8NtWof9dYrwnsPZ5HNY5fvyXhpivUUoqJy5/" +
       "3Lz/49evC2lLOy2/u0eo1SsRhsP6PLBfGsxPu6iTAbp7Lu75apt+8QZwTABH" +
       "BfKuM2pDjsyXgMOlrqn7zU/fWDJ+qYqEh0ijblJ1iIo4Iw0AcOZkIL3mrS/d" +
       "J507XQ9Dm1CVlClfNoEGXlXZdYNZiwtjz/5w6fe3P3vuigCaJXks9zP8jBg3" +
       "4rC5AMRaK5eCdtxDofjUBkugH4Ue35B47+Sku6wsCDGhJhT7VrTzyvkaGtGM" +
       "nX/01Dl19Jktsu3oKG0SBqEHfulX/3o3cvZ3b1eoSw3ctDbrbIrpPvHCeGRJ" +
       "PRkRvZ6X0z5sOfn7H/VM9N9OKcG5rlsUC/y9CpTYOH9pCIry5qN/Xrbv3sz4" +
       "bVSFVQFzBlk+P/Li2zvXKyfDorGVBaGsIS7d1Os3LBxqM+jgDVQTZ5pF3Kwt" +
       "YqUDobEdnk0uVjZVzswVwRfG10FAoCPuFoE82H4TroGMEXad7WJxIWJx+m5F" +
       "dCZ4+QIElDYW6OGxXMqBJkDLQs6fcnvjz8bHlbme+B8kAO+osEHSLX4u+q39" +
       "7x96V7iqHrFRNJAPF4AhXzlrk+p9Cp8QPP/GB9XCCdljdgy4je7qYqeLUWyT" +
       "DTe5mpYqED3S8dHkd6++JBUI3gQCxGzu1Dc+jRw/JaNJXpfWlt1Y/HvklUmq" +
       "g8M4SrfmZqeIHUN/vHDkx88dORZ2s/r9nNRAMrR50YOhYvu3qNToUtIdj7f+" +
       "5ERH1RBE6TCpzxna4RwbVkuRWufkUj4vePcrD7euzGhx6Ew3gnHFdCIAp1Bp" +
       "auv0w2nH6MhgXmEWBqbYLLqFMU6a4Zbhtb9ib8o1EX6lOameMjV5y/wCDvvk" +
       "Qu9/WQ5wos8S86PFwOnEtXXw9LuB03/b4YjDlyuE4nwcK9sOfx4Qhz18k+p+" +
       "FIcZsN2E33Y4mfTsNPu/sFMemvdK9xOsqp1lf4XI67vy8rnW+qXnHnhf1Ibi" +
       "FbsJIj6d03Uf9PwwrLVsltaEek2yybDE1+MukCpdnTipglHIPiepvwnyVqIG" +
       "Shj9lN/mpC1ICeElvv10Jzlp9Ogg6coXP8lp4A4k+HrGKqC/TfQc+DdIRN75" +
       "86HyvkI4avGtHFXc4m+bMaOJv6wKQZ+Tf1rBLe/c7j0PXf/cM7JtV3Q6O4tc" +
       "FkCoyxtEsQyumZdbgVftrg03Wl5pWFfIQO1SYC8alvtg2QcAthAZywINrdNT" +
       "7Gs/OL/99Z/P1b4HufMACVEoOgd8fxhJS0FXnIP+40CsPKVByyA67d4N35m5" +
       "d1P6b78VLZubAlfMT59ULj/74C9Pdp6HjnzBMKmB5MryCdKoOTtmjL1MmbIT" +
       "pFlzBvMgInDRqF6SL1sQxBT/zBJ2cc3ZXJzFSx/0cuU1oPyqDO3tNLP7zZyh" +
       "uhl3gTdT8l9aoZOAiAts8GZ8dfKQzJqyJFYlYyOWVSiR9ZcsEc+TldLNpNj9" +
       "vHjF4YX/AAeYO2fOFgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL06a6zkVnnem+wmuyTZTQIhTcmTDVUy4Xo8Hs+MGwp4bM/Y" +
       "M/Y8PS+3ZePn2DN+jR8ztmkoIFHSogJqEwoSpFILaovCQ1VRK1VUqaoWEKgS" +
       "FepLKqCqUmkpKvlRikpbeuy59869d+8GRa06ks94zvne33e+851z5oXvQOcD" +
       "Hyp4rpXMLTfc1+Jwf2Fh+2HiacF+i8N6kh9oKmlJQSCAvmvKI5+9/L0ffNC4" +
       "sgddEKG7JcdxQyk0XScYaIFrrTWVgy7vemlLs4MQusItpLUER6FpwZwZhE9y" +
       "0KuOoYbQVe5QBBiIAAMR4FwEmNhBAaTbNSeyyQxDcsJgBb0DOsdBFzwlEy+E" +
       "Hj5JxJN8yT4g08s1ABRuzX6PgVI5cuxDDx3pvtX5OoWfK8DP/trbrvzuTdBl" +
       "EbpsOsNMHAUIEQImInSbrdmy5geEqmqqCN3paJo61HxTssw0l1uE7grMuSOF" +
       "ka8dGSnrjDzNz3nuLHebkunmR0ro+kfq6aZmqYe/zuuWNAe63rPTdathI+sH" +
       "Cl4ygWC+LinaIcrNS9NRQ+jB0xhHOl5tAwCAeouthYZ7xOpmRwId0F1b31mS" +
       "M4eHoW86cwB63o0AlxC674ZEM1t7krKU5tq1ELr3NFxvOwSgLuaGyFBC6DWn" +
       "wXJKwEv3nfLSMf98p/Om97/dYZy9XGZVU6xM/lsB0gOnkAaarvmao2hbxNse" +
       "5z4k3fP5Z/YgCAC/5hTwFub3f+6ltz7xwItf3ML8+BkwXXmhKeE15ePyHV99" +
       "HfkYflMmxq2eG5iZ809onod/72DkydgDM++eI4rZ4P7h4IuDP5u985Pat/eg" +
       "Syx0QXGtyAZxdKfi2p5paX5TczRfCjWVhS5qjkrm4yx0C3jnTEfb9nZ1PdBC" +
       "FrrZyrsuuPlvYCIdkMhMdAt4Nx3dPXz3pNDI32MPgqBbwAPh4HkY2n7y7xB6" +
       "CjZcW4MlRXJMx4V7vpvpH8CaE8rAtgYsg6hfwoEb+SAEYdefwxKIA0M7GFBd" +
       "Gw7WIJTGTdF1bcJRe5IzjDzP9UHqAZHm/T/wiDM9r2zOnQMueN3pBGCBucO4" +
       "lqr515Rnozr90qevfXnvaEIcWCiE3gjY7m/Z7uds9wHbfcB2/yy20LlzObdX" +
       "Z+y3zgauWoJJD9LhbY8Nf7b11DOP3ASizNvcDOycgcI3zsrkLk2weTJUQKxC" +
       "L354867xzxf3oL2T6TUTGXRdytB7WVI8Sn5XT0+rs+hefu+3vveZDz3t7ibY" +
       "iXx9MO+vx8zm7SOnjeu7iqaCTLgj//hD0ueuff7pq3vQzSAZgAQYSiBggcUe" +
       "OM3jxPx98jAXZrqcBwrrrm9LVjZ0mMAuhYbvbnY9udfvyN/vBDa+IwvoR8Dz" +
       "hoMIz7+z0bu9rH31Nkoyp53SIs+1PzX0PvbXf/5PaG7uw7R8+dhCN9TCJ4+l" +
       "gozY5XzS37mLAcHXNAD3dx/u/epz33nvT+cBACBefxbDq1lLghQAXAjM/J4v" +
       "rv7mG1//+Nf2dkETQhc93w3BXNHU+EjPbAi6/WX0BAzfsBMJZBMLUMgC5+rI" +
       "sV3V1E1JtrQsUP/z8qPI5/7l/Ve2oWCBnsNIeuJHE9j1/1gdeueX3/bvD+Rk" +
       "zinZarYz2w5smyLv3lEmfF9KMjnid/3F/R/5gvQxkGxBggvMVMtzFpSbAcr9" +
       "Buf6P563+6fGkKx5MDge/yen2LGq45rywa999/bxd//opVzak2XLcXfzkvfk" +
       "NsKy5qEYkH/t6cnOSIEB4Movdn7mivXiDwBFEVBUQBILuj5IOPGJ4DiAPn/L" +
       "3/7xn9zz1FdvgvYa0CXLldSGlM8z6CIIcC0wQK6Kvbe8devcza2guZKrCl2n" +
       "/DYo7s1/3QQEfOzGKaaRVR27WXrvf3Qt+d1///3rjJAnlzMW21P4IvzCR+8j" +
       "3/ztHH83yzPsB+LrkzCo0Ha4pU/a/7b3yIU/3YNuEaErykH5N5asKJs7Iih5" +
       "gsOaEJSIJ8ZPli/btfrJoyz2utMZ5hjb0/lll/zBewadvV86nlJ+CD7nwPPf" +
       "2ZOZO+vYLpp3kQcr90NHS7fnxefAhD1f2q/uFzP8t+RUHs7bq1nzE1s3haDA" +
       "jWTLBNPkQpDXngBLNx3Jypm/NQRhZilXDzmMQS0K/HJ1YVVzUq8B1XceUpkF" +
       "9rcF3DavZW0pJ7ENC+yGIfSTW6h8AbtjR4xzQS34vn/44Fc+8PpvAL+2oPPr" +
       "zObAncc4dqKsPP6FF567/1XPfvN9ebICmWr8zkf/NS82+Btonb3SWdPImuah" +
       "qvdlqg7zdZ+TgpDPk4um5tq+bDj3fNMGaXh9UPvBT9/1jeVHv/WpbV13OnZP" +
       "AWvPPPtLP9x//7N7x6rp119X0B7H2VbUudC3H1jYhx5+OS45RuMfP/P0H/72" +
       "0+/dSnXXydqQBlufT/3lf31l/8Pf/NIZ5cjNlvu/cGx42/eZcsAShx8OmWml" +
       "zSiObb1bLXTQ6kZh5hLvzjhiOjHISWkoxYtZyW6lMTnorpg56kRqEUMLbRyd" +
       "jNF0Ua56fXvAesnKm80JdjylpsUB1iasASKZYWk5GC1Fjx4Oo4G7Er3GuO1Z" +
       "I1df0c1xcYG7NlrV0041RMOyOGhMEa+Fyjbs2HYBjgsxlnJIedGZYZ3IW9RZ" +
       "NG3Oltiy2K3H0iLkGZX0yoWEiiQhEetTvFBr+lpVagwnJTJsDl2+0uobG8QT" +
       "Gppab9hes19xjKCt9GaJF5GdiC/r4ggb+J5Hz8107HSba89ecTE97lhDjtRL" +
       "C2YoLGw0HA+7Qak5JYaKP0vqrTE9H1b7QYTXRHZZakl8jGFeGa9tOI20Gs6a" +
       "YzUhDOdGdzlZdKWqVxQXdq1TqQlapSgwiN1fqJjRHWNYiywgwrReDRcT3ugU" +
       "1zhXSWZFwRZEY+5ORzy9iRCmV+IDfeRhc4mtoFq1TXWDADNqznjYGPKczg8V" +
       "nO+3jaJsFMm5MgmpibvhPBuzB8mmMusbiFZuDPz2cN5vlcK2PV6MPMueCuOU" +
       "perpKpKiaolIJd/EVu3qKBjBTBGEpyDEWFBAymNpVOqPg+Ksj9IjmuUotr/c" +
       "tPnItrtocTX0BLoiqERT6/HjaBEtZF/zfao4nPGJ05vDbktUqJYDxpSKumzD" +
       "hFkpCXbDRsXBWu4TVi/yWytUINU6YkqajzAEixWZ+mBepAOcHyldNVqJ1RHV" +
       "mghjhVYHA6RanStkqbGaikK8aLiFVcc0+CVRbtFiUaJxOp63yjEh9ZHWnOpj" +
       "wJBrOh0ghjhuRUt6mLAmgQ7iqD8YUQrbj9iJEI/oZNO3ayGZzlsiDvsRKurr" +
       "jTHDlEHLbPYnk0l7sWbXcxpR5yOkOhF9keq2CNlOpSYVUlZ1U2okM9qsK4xJ" +
       "TjtUFSvBMtaZDnR9uRC4Nk7y3rwcG0NtXKvYk2ESNDt24vcXzIpTe4Nib2nZ" +
       "buCaIKutp0uOD5Ihu1SVRb0/4QpVvDRWNG3G4K3RRjKKdjiLVhjXJd2p0Eyt" +
       "1SzVEiW16SI2KqstIu2NCJkuCF1/3pNmosBXul7Id8s1EImGKoSSXKaGYpvY" +
       "BMXRsFuTirLEcbFsNXVaw8um0RHq/apcD8oyu4AXtkglEi/zwdAYryR2Ji7U" +
       "wK5EOM1q3eWGk0SJ8Pq92ELS1qZDs4mEL4cjYl5O0gbSTyfpyO6zblUtiDyP" +
       "BE6Faa6E5iRIUsGw+9SQ6xWokr4cKYVGsUL3o2a9wROMS1NRVWgglmqxmKUF" +
       "+rqHJTWj2OLmGxYpthWZFRcszM1Mal4iArVZ7hisN+m02iA5TcoCMyxp1CqZ" +
       "GRWS8Tt2caahFFpoxGhDonh7VW52k46nFh2kqRNJP2mqLWzEMUoplSpYoA07" +
       "/MruLueJWxugo6DloKV6u++JaruDtWcjhJyse+20ZPW1QKpKHl+fJEU0tjbR" +
       "eCgXy3GzoGATTViMSENrtuVBYRQyA91pxXJPGMAKrDe0mUEHPmFgIlFb8mFN" +
       "iRexnqqj2oZGBLOE+kHFVKapsYnXYtwf2WzbkhtBq+D3GWVAFam4JWqdVcH2" +
       "k3DI45to0wERgxmDOdVClUaaGK2uXGrgbKmCsD1SUnvdkVGakgsxwuqO7PRE" +
       "u96g5FgPzDk94mKbQHvdterWBT3ifHrjNL06JZtcm2y0CVxnuK4Gr0dr2Bmi" +
       "PKMZS1+oTFwijp0QL/UjUZ3Na4hWrase3Gl26rhGyYW4a/nxpsymBNcoLV0G" +
       "j4gy0VhyU8Kw9SgJNzFeU7vTGiaTjFIsS1xnvaQ7GJ8OdCQmp0O9zuNlhUKc" +
       "pdknmOl8zlOephCE2fS8hSQWDZ9BUlxEJkgVr8B0ieyPVHHusSVn4NfDao3R" +
       "0eVyqnThVYcLiKU3YQk8QK0lvwrWOLVAS4Kk9gUnGeC4XFCHMt60XQojBWZS" +
       "mpjCgDPqNlvrhBNXx9WZv3GCnogxYAHS18nU8Mz1aOSuWgkGo1wKl3FtTZYs" +
       "rpuU4KioucgwGBhBr9Lj6noziHtRxRQI2atyURWTvLBQ64sbgagzdb0d8SWP" +
       "WgTJdM4Dg62cajqC9QnVKqxmK9oomgvZaiEm65bZTZFQuuKS5VDbH8IgXovV" +
       "aR+nbIQcW6Sld1y6ObWmwBcd0dyEixTGNhVdQ3voOjLnpNSaLgM87dUW9Tla" +
       "9kmM4AdSG9NINYwpV1+M6stozpRHGorVy9XCcBlVNgFJNY2WIVTHvpAm66XU" +
       "DJu8M4WLCGUheGsZBhHqtpvFYX1FM3pkTWHURZW1iMqI5g43qBJSsi+zvtdb" +
       "M6TWHLR6g+VgLVamxRQLurpTZeAxj3fwbltpYr4VjEg4wUlPmHUZ3CNZP8FW" +
       "HXjqy2s0SMsyWObG/UZat5aFHsyZpXQ9bSc65frNcV1qBuywqiLdAOXq8Yov" +
       "LObUuC+ImNdA25twthpRrkyrzrIYjRfiOA02481AbyLFBuGSvajh0rUSUxZ8" +
       "t8nTU0mtTloxC56CjTVUUiwX+ixtUbNJpduMp/yq3lpSXD+o6IqzXqQ1mbFk" +
       "WyvUa0uiW3ADmhly03JUWKF4NcYr46q5YvzGoNMieo0yYUxTy18WPKBnrd/r" +
       "wc06PiVJ1Vqo86S80KrA7Ro3miQCJWiY7YEgoNBhTWWWaqVQaNVHLDrvk3Ez" +
       "jRBKKSwGG7gldVpTT59YITKDmfXSGtmreY0vD33dFlcay4w68JqhlnENTLeB" +
       "WApgH3c6A4L3B1hx1jVm6whddQR3FLLqoqoXMHrAIIM6WM5JL40dqTzYyONl" +
       "NJhEIEcvymutp/hUVYvSphFX6A06dxhgI5bwkLonRevipuQwFd6YT216Ul/J" +
       "M45bNfhRRSqLshHKuCnXXISeVqwuqGT5xRhL4A1JrdfLfoTDkz62cYPasFbp" +
       "NTZdhw6n0w3ORfUiCsvl2YKykoguOxuljYPwict9I0VqwJaFBquIQadEo+is" +
       "bOtC0OlFcNDgNXuttvG4G6w8xNLLU7ZSXSc135kUVlOHcQwdYWWzIQctdlFR" +
       "i+hIx3ubjc+NAyuUaG1ZShKZopECHy1JT3UE05tbDNszNW+9cZLxim0OjQVu" +
       "dWDbIxGW1GhrvUaKrdTy8O58XlHcaa9meWWivCwwfrO9ImFB7ysFSmUHnSpW" +
       "qzBgSrFlad0MmcZUKdsFmZe6rXVl0+6LBUFH/DqnwUp1UexNdVjhq61wjPYr" +
       "3XKoNJakm8QhHfSTyBZVeT7WQ39eRCcW5k0aOtvvIsMZWZOsdTgv9RUiNAgx" +
       "2bAdX+0I1WYAdzkYx0W4h8hlJtJ5ghzTbneu1vTYaA2LjanD9grlIhn02uN6" +
       "khCVqlruoJiNqUivIldrY06MZMLSeQHDR9wCrpZJvKd6FWbhpHW+bdcx3k9I" +
       "te12hdBecAhvy6zgNay0vubnrEMNVo3KkEOCflwX4LTeKikKKk5baWMYw0Ul" +
       "GiFuL1lRXTTscL1qKiZGZFjoXFCFmoVLrtglTCIMak2xpurtftpaJa3GzJol" +
       "3cl4aA5wUQlopSBYKtfxOgt8zSwa5dkUJght1i3p3cacILIt0Nte2S70znzD" +
       "fXR9Ajaf2QD7CnZf8dkMz+UMd0d3+efC6UP440d3u/Occ4fb/UeuO5jO94/D" +
       "cfPo5izbjt5/oyuVfCv68Xc/+7za/QSyd3BkNguhi6HrvdHS1pp1jOseoPT4" +
       "jbfdfH6jtDvK+cK7//k+4c3GU6/gjPrBU3KeJvk7/Atfar5B+ZU96Kajg53r" +
       "7rpOIj158jjnkq+Fke8IJw517j9ywl2Zzd8EnicOnPDE2efEZ3p0bxdC2+g5" +
       "dSy5d2DFA9/dnfkOLJb5XUJ2eaod3HMKxyJqGkLnA8P1w5zi5hTFcyej4d7j" +
       "FKkuT8eK5mUmz5HfkTV+CN0eaOHuzuIsjjevXVPdBXfwo44Wjh875h3ukUHv" +
       "zTofBU/9wKD1/0ODnttNpDgH+OWXOQj+QNY8A9SfH1c/60x3qv7iK1E1DqFX" +
       "n3X/k51k33vdVfP2elT59POXb33t86O/yq9Ajq4wL3LQraCQso4fPB57v+D5" +
       "mm7malzcHkN6+deHDnx+1tVUCN0E2lzo57bQHwHyngUNIEF7HPKjIXTlNCQI" +
       "xPz7ONyvh9ClHVwIXdi+HAf5DUAdgGSvv+mdcUq5PaeNzx3LMwdBlDvkrh/l" +
       "kCOU4zcpWW7K/xJwmEei7Z8Crimfeb7VeftLlU9sb3IUS0rTjMqtHHTL9lLp" +
       "KBc9fENqh7QuMI/94I7PXnz0MG/esRV4F9DHZHvw7DsT2vbC/JYj/YPX/t6b" +
       "fuv5r+eHpv8DHjX00KshAAA=");
}
