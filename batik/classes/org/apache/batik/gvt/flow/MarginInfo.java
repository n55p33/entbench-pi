package org.apache.batik.gvt.flow;
public class MarginInfo {
    public static final int ALIGN_START = 0;
    public static final int ALIGN_MIDDLE = 1;
    public static final int ALIGN_END = 2;
    public static final int ALIGN_FULL = 3;
    protected float top;
    protected float right;
    protected float bottom;
    protected float left;
    protected float indent;
    protected int alignment;
    protected float lineHeight;
    protected boolean fontSizeRelative;
    protected boolean flowRegionBreak;
    public MarginInfo(float top, float right, float bottom, float left, float indent,
                      int alignment,
                      float lineHeight,
                      boolean fontSizeRelative,
                      boolean flowRegionBreak) { super();
                                                 this.top = top;
                                                 this.right = right;
                                                 this.bottom = bottom;
                                                 this.left = left;
                                                 this.indent = indent;
                                                 this.alignment =
                                                   alignment;
                                                 this.lineHeight =
                                                   lineHeight;
                                                 this.fontSizeRelative =
                                                   fontSizeRelative;
                                                 this.flowRegionBreak =
                                                   flowRegionBreak;
    }
    public MarginInfo(float margin, int alignment) { super();
                                                     setMargin(margin);
                                                     this.indent =
                                                       0;
                                                     this.alignment =
                                                       alignment;
                                                     this.flowRegionBreak =
                                                       false; }
    public void setMargin(float margin) { this.top = margin;
                                          this.right = margin;
                                          this.bottom = margin;
                                          this.left = margin; }
    public float getTopMargin() { return top; }
    public float getRightMargin() { return right; }
    public float getBottomMargin() { return bottom; }
    public float getLeftMargin() { return left; }
    public float getIndent() { return indent; }
    public int getTextAlignment() { return alignment; }
    public float getLineHeight() { return lineHeight; }
    public boolean isFontSizeRelative() { return fontSizeRelative;
    }
    public boolean isFlowRegionBreak() { return flowRegionBreak; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALUaC5AcRbV375O7y/3zv+SSy+USuITsAhIkXgQul7tkce/D" +
                                                              "XRLh8rnMzvbuTW52ZjLTe7cJhl+VJIpixABBIaVWKD4VCGWJaClULESgQKv4" +
                                                              "KKLFpxBLEClJKaBGxfd6ZndmZ3cmbIq7qumd636v36dfv0/3HH+PVBg6WUwV" +
                                                              "FmJ7NWqEehU2JOgGjffIgmFshr4x8Y4y4e873x5YGySVo6R+XDD6RcGgfRKV" +
                                                              "48YoaZUUgwmKSI0BSuOIMaRTg+qTApNUZZTMkYxISpMlUWL9apwiwFZBj5Im" +
                                                              "gTFdiqUZjVgTMNIaBU7CnJNwt3u4K0pqRVXba4PPd4D3OEYQMmXTMhhpjO4W" +
                                                              "JoVwmklyOCoZrCujk1WaKu9NyioL0QwL7ZbXWCq4IrqmQAXtDzd8ePrQeCNX" +
                                                              "wSxBUVTGxTOGqaHKkzQeJQ12b69MU8Yeci0pi5KZDmBGOqJZomEgGgaiWWlt" +
                                                              "KOC+jirpVI/KxWHZmSo1ERliZGn+JJqgCylrmiHOM8xQxSzZOTJI25aT1pSy" +
                                                              "QMTbVoUP37Gz8QdlpGGUNEjKCLIjAhMMiIyCQmkqRnWjOx6n8VHSpMBij1Bd" +
                                                              "EmRpn7XSzYaUVASWhuXPqgU70xrVOU1bV7COIJueFpmq58RLcIOy/qtIyEIS" +
                                                              "ZJ1ry2pK2If9IGCNBIzpCQHszkIpn5CUOCNL3Bg5GTu+AACAOiNF2biaI1Wu" +
                                                              "CNBBmk0TkQUlGR4B01OSAFqhggHqjLR4Toq61gRxQkjSMbRIF9yQOQRQ1VwR" +
                                                              "iMLIHDcYnwlWqcW1So71eW9g3S3XKJuUIAkAz3Eqysj/TEBa7EIapgmqU9gH" +
                                                              "JmLtyujtwtzHDgYJAeA5LmAT5tEvnbr8vMUnnzZhFhaBGYztpiIbE4/F6p9f" +
                                                              "1NO5tgzZqNJUQ8LFz5Oc77Iha6Qro4GHmZubEQdD2cGTw7+8+voH6LtBUhMh" +
                                                              "laIqp1NgR02imtIkmeobqUJ1gdF4hFRTJd7DxyNkBrxHJYWavYOJhEFZhJTL" +
                                                              "vKtS5f+DihIwBaqoBt4lJaFm3zWBjfP3jEYImQEPqYVnATH/+C8jXwyPqyka" +
                                                              "FkRBkRQ1PKSrKL8RBo8TA92Oh2Ng9RNhQ03rYIJhVU+GBbCDcWoNJCdZOCGr" +
                                                              "U+F+QU9KSgQYCKGBadM3dQalmjUVCIDCF7m3uww7ZZMqx6k+Jh5Or+899dDY" +
                                                              "s6Ypoflb+gAHBdRCJrUQpxYCaiGkFrKpkUCAE5mNVM0VhfWYgJ0NrrW2c2TH" +
                                                              "FbsOtpeBKWlT5aDMIIC254WYHnv7Z332mHiiuW7f0tcueCJIyqOkWRBZWpAx" +
                                                              "YnTrSfBF4oS1XWtjEHzsGNDmiAEYvHRVpHFwQV6xwJqlSp2kOvYzMtsxQzZC" +
                                                              "4V4Me8eHovyTk0embth63flBEsx3+0iyAjwWog+hs8455Q73di82b8OBtz88" +
                                                              "cft+1d74eXEkG/4KMFGGdrcZuNUzJq5sEx4Ze2x/B1d7NThmJsBGAp+32E0j" +
                                                              "z690ZX00ylIFAidUPSXIOJTVcQ0b19Upu4fbZxN/nw1mMRM32hx4QtbO4784" +
                                                              "OlfDdp5pz2hnLil4DPj8iHb37379zme4urPhosER50co63K4KJysmTujJtts" +
                                                              "N+uUAtyrR4a+ddt7B7ZxmwWIZcUIdmDbA64JlhDU/OWn97zy+mvHXgrm7DzA" +
                                                              "IEanY5DqZHJCYj+p8RESqK2w+QEXJ4MvQKvp2KKAfUoJSYjJFDfWfxqWX/DI" +
                                                              "X29pNO1Ahp6sGZ135gns/gXryfXP7vxoMZ8mIGKItXVmg5l+e5Y9c7euC3uR" +
                                                              "j8wNL7Te+ZRwN0QA8LqGtI9yR1rNdVCdv9dxP42kYwbsSykFyzBpxaQLh3aJ" +
                                                              "BzuG3jLjzYIiCCbcnPvCX9/68u7n+CJX4c7HfpS7zrGvwUM4LKzRVP7H8BeA" +
                                                              "53/4oNKxw/TtzT1WgGnLRRhNywDnnT4pYb4A4f3Nr0/c9faDpgDuCOwCpgcP" +
                                                              "f/Xj0C2HzZUz05RlBZmCE8dMVUxxsFmL3C31o8Ix+v58Yv9P79t/wOSqOT/o" +
                                                              "9kJO+eBv//tc6MgbzxTx/LCFVMFMNi9CYzZNGndf/uqYIm34SsPPDjWX9YHX" +
                                                              "iJCqtCLtSdNI3Dkn5FlGOuZYLjsB4h1O4XBpGAmshFXAjktcDWfqYksP+NPl" +
                                                              "eL+MkTJJKWAc/+3NfCL0GTFVlamgeE8R5e0aDnB+DoxwMMLHhrFZbjhder4J" +
                                                              "ORL8MfHQS+/XbX3/8VN8GfIrBKcH6xc00waasFmBNjDPHXI3CcY4wF10cmB7" +
                                                              "o3zyNMw4CjOKkDgYgzpE+0yev7OgK2b8/udPzN31fBkJ9pEaWPd4n8BDB6kG" +
                                                              "n02NcUgUMtpll5sua6oKmkYuKikQvqAD3caS4g6pN6Ux7kL2/XjeD9fde/Q1" +
                                                              "7js1PkVrYVywyJu/hXEB23OwWVXobb1QXSsYNPOTnKVt5FPHfNY5js0OPjSC" +
                                                              "zU5TAVvPUlfYsV0zBxbyzjpM3vKSJV5o2/H6gRc/+5t7v3n7lLnHfTyWC2/+" +
                                                              "vwfl2I1v/rPA5nh6UsSJufBHw8fvaum59F2Ob+cJiN2RKUw4IdeycS98IPVB" +
                                                              "sL3yySCZMUoaRauw3SrIaYy+o1DMGdlqF4rfvPH8wsysQrpyedAitxd1kHVn" +
                                                              "KE7XVM7y3JCdlMzHdVkNT4tlQS1u4+OZr7mlkKVQBOrQJNWb3/zusY9uOHBJ" +
                                                              "EKNixSSyDlpptOEG0lg/33T8ttaZh9+4mVt+dmpzB5zD25XYrOamUIavIUgq" +
                                                              "DF6Ko4uWFEF2JRfzfJhlZGZ3NLJxYGxkc/fwZm7h9t7h9rvnTPa7u1A1Cy1q" +
                                                              "C4uoBl/0rPPc7ycXNlPYZIoI5EWCkVpToP7Ihg3R3mISXXsWEi2yyC3ykYh7" +
                                                              "iZvOWiIvEoxUmxL1DmwoJs6BsxCn1aLV6iMOZ/kbZy2OFwlGakxx+rZEo8Xk" +
                                                              "OfTJ5anPmvQSi9iSAnkIfzlSXAzIx6s1XWXgMWjcJUOdz7SQUDBVywUFB/N3" +
                                                              "lsg8LnabRaXNg/nv2YHsO4U8emGDM9Cl5DgrxuX3S+QS13CpRWepB5f3+XLp" +
                                                              "hQ2+K6YypqaKsXl/iWyiL2i3CLV7sHnCl00vbAblFE0U1eXDZ6HLDotMhweT" +
                                                              "P/Jl0gsbdAkZPmQGxdh8tEQ20ZxWWIRWeLD5mC+bXtiw5wRZSiopi1P3/n+8" +
                                                              "RE7RpM61aJ3rwekvfDn1wgZXhUeGm6jXPnqyRFbPgafTItbpweqzvqx6YTPS" +
                                                              "mICEawRq7WEqC1jzYX/UxfBzJTKMa7fKIrnKg+EXfBn2woY6Bs8Mh2kSMsz1" +
                                                              "OhUmivH7og+/mWL5Pf+rJK7DWgddRyJNsFxq9TpP5+XysRsPH40P3nNB0Eru" +
                                                              "LwfjBc+/WqaTVHZMVYMz5eXk/fwGwU5wX62/9Y8/6UiuL+XsEvsWn+F0Ev9f" +
                                                              "AnnkSu80383KUzf+pWXzpeO7SjiGXOLSknvK+/uPP7NxhXhrkF+XmJl3wTVL" +
                                                              "PlJXfr5do1OW1pX84n9ZfsmH22ejta4b3dZoW45XyeeF6irmHLX9JXzWd3yq" +
                                                              "vXexeQuswqDMPP7mYK7zg/JJVYrbVv2nT6Mk5P1v5KSchWOYpwxYUg6UriAv" +
                                                              "VB/5/+Uzdhqbf0BCnqRss6qZ6uFqtVXxwXSpAqPCoCXPYOmq8EL1FjdQ6TNW" +
                                                              "hQ1km/WgimGMJsWUEQhOlzIwnRmyJBoqXRleqD4Cz/IZm4NNPQQAUMZ6nvwV" +
                                                              "1UbDdGmjDZ4rLZGuLF0bXqg+Erf5jLVjs5CROtBGFHLMorpYNF26wPpjxBJo" +
                                                              "pHRdeKH6yLvaZyyMzbngTUEXETuVtfXQOV16WAbPFkuYLaXrwQvVR9bP+Yyt" +
                                                              "w2YN5HToOSGed+fly7Y6Lp7OLXKVJdNVpavDC9VH5I0+YxFs1ltbJD8ht3XR" +
                                                              "M126WA7P1ZZAV5euCy9UH3k3+4xtxWaQkWbJ6CuW8NsKGZouhWDduc2Salvp" +
                                                              "CvFC9RFa8BkTsdnOSBMopEhBYetjx6dyEA81of2ZA95kzC/4bMr81Ed86GhD" +
                                                              "1byjW17mGX/uc5xayN0TaVl2HjU73is1nSYkrsVa8+CZX3gFJhhZ4PnhBSSY" +
                                                              "+IM8B3ab8Aojs4vBM1IGrRNyD7gZNyQjFfzXCQeoNTYcI5XmixMEGCkDEHzN" +
                                                              "mJYznzkPuM2z+Yx5xLjQqWmeC8450wI5yrZleeUO/8AtW5qkzU/cxsQTR68Y" +
                                                              "uObUxfeY9/+iLOzbh7PMjJIZ5qcIfFIsb5Z6zpadq3JT5+n6h6uXZwvBJpNh" +
                                                              "29oX2iZJtkP5oKFttLgux42O3B35K8fWPf6rg5UvBElgGwkIjMzaVniLkdHS" +
                                                              "UFduixber0IpyG/tuzq/vffS8xJ/+0P2uiCQfzvkhh8TX7p3x4u3zj+2OEhm" +
                                                              "RkgFHhhl+PXKhr3KMBUn9VFSJxm9GWARZpEEOe/yth7NWMBP37heLHXW5Xrx" +
                                                              "6xFG2gtvrgu/uakBi6X6ejWt8BuzOihF7R5zZVwVYlrTXAh2j7WU2PJD8rUZ" +
                                                              "XA2wx7Fov6ZlL/ZrujS+j3tz29t9kRu4mb/i29f+D+W5p2P8KgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7C+zjyHmfdvdeu3e+3Tvbd+fzvW/9ODNZSqIoSrk4sUi9" +
       "SJEiJYoP0UnWlPgUn+JDopheEhttzmhQx0jPqYs6h6J10MZwYrdokABFgiuC" +
       "1g4SFEgQ9AU0NtIAdZMaiFs0bus27pD6v/a//13v+rYCOKJmvpn5/b755puP" +
       "nNEXv1m5P44qUBi4O9MNkmt6llxbuei1ZBfq8TWKRjk1inWNcNU4noG868uX" +
       "vnz5L7/zaevK+coDSuWdqu8HiZrYgR9P9ThwN7pGVy4f5/Zc3YuTyhV6pW5U" +
       "OE1sF6btOHmVrjx8ompSuUofQoABBBhAgEsIcOdYClR6h+6nHlHUUP0kXld+" +
       "qnKOrjwQLgt4SeXFGxsJ1Uj1DprhSgaghYeK3yIgVVbOosoLR9z3nG8i/BkI" +
       "fuPv/MSVf3qhclmpXLZ9voCzBCAS0IlSecTTvYUexR1N0zWl8piv6xqvR7bq" +
       "2nmJW6k8HtumryZppB8pqchMQz0q+zzW3CPLgluULpMgOqJn2LqrHf6633BV" +
       "E3B94pjrnmG/yAcEL9kAWGSoS/2wyn2O7WtJ5fnTNY44Xh0BAVD1QU9PrOCo" +
       "q/t8FWRUHt+Pnav6Jswnke2bQPT+IAW9JJWnb9looetQXTqqqV9PKk+dluP2" +
       "RUDqYqmIokpSefdpsbIlMEpPnxqlE+PzzfEPf+on/aF/vsSs6Uu3wP8QqPTc" +
       "qUpT3dAj3V/q+4qPfIj+RfWJ3/rk+UoFCL/7lPBe5jf+2rc+8gPPvfXVvcx7" +
       "z5BhFyt9mVxffn7x6B88Q7zSvlDAeCgMYrsY/BuYl+bPHZS8moVg5j1x1GJR" +
       "eO2w8K3pv5r/zBf0Pz9fuURWHlgGbuoBO3psGXih7erRQPf1SE10jaxc1H2N" +
       "KMvJyoPgnrZ9fZ/LGkasJ2TlPrfMeiAofwMVGaCJQkUPgnvbN4LD+1BNrPI+" +
       "CyuVyoPgqjwCrvdU9p/yO6lIsBV4OqwuVd/2A5iLgoJ/DOt+sgC6teAFsHoH" +
       "joM0AiYIB5EJq8AOLP2gwNwksOEGW5hRI9P2SQDgWmFg4f+/prOC1ZXtuXNA" +
       "4c+cnu4umCnDwNX06PryjRTvfevXrv/e+SPzP9AHcFCgt2v73q6VvV0DvV0r" +
       "ert23Fvl3Lmyk3cVve5HFIyHA2Y28HmPvML/OPWxT750AZhSuL0PKPM8EIVv" +
       "7XqJY19Alh5vCQyy8tZntx8Xf7p6vnL+Rh9aIAVZl4rqXOH5jjzc1dNz56x2" +
       "L7/+jb/80i++FhzPohuc8sHkvrlmMTlfOq3TKFjqGnB3x81/6AX116//1mtX" +
       "z1fuAzMeeLlEBVYJHMhzp/u4YZK+eujwCi73A8JGEHmqWxQdeqlLiRUF2+Oc" +
       "crAfLe8fAzp+uLDad4Pr2oEZl99F6TvDIn3X3jiKQTvFonSoH+bDX/p3//q/" +
       "IKW6D33v5ROrGa8nr56Y70Vjl8uZ/dixDcwiXQdy//Gz3N/+zDdf/2hpAEDi" +
       "5bM6vFqkBJjnYAiBmv/GV9f//mt//Pk/On9kNOcSsOClC9deZkcki/zKpduQ" +
       "BL29/xgP8BcumFiF1VwVfC/QbMNWF65eWOn/ufy+2q//109d2duBC3IOzegH" +
       "vncDx/nvwSs/83s/8e3nymbOLYv16lhnx2J7J/jO45Y7UaTuChzZx//w2b/7" +
       "FfWXgDsFLiy2c730ShdLHVwElV65TcwS2R4Yjc2Bn4dfe/xrzue+8at7H356" +
       "UTglrH/yjb/53WufeuP8iZXz5ZsWr5N19qtnaUbv2I/Id8HnHLj+qriKkSgy" +
       "9t7zceLAhb9w5MPDMAN0XrwdrLKL/n/+0mv//B+/9vqexuM3Lhw9EBf96r/5" +
       "v79/7bNf/90zvBew3EAtRxI5lZSIq0XS2NtTM6lcACHELQsfXASBq6ulpX+4" +
       "ZA2XRR8q09LwyjGqlGWdInk+PumEbhyuE/Hd9eWn/+gv3iH+xW9/q2RwY4B4" +
       "cs4xarjX96NF8kKhvidPe9yhGltArvHW+MeuuG99B7SogBaXYN2I2Qg4++yG" +
       "GXogff+D/+Ff/M4TH/uDC5Xz/coloDKtr5bOrnIReBk9tsA6kYU/+pH9JNs+" +
       "BJIrJdXKTeTLjKdvdkMHdfffN7uhIn2xSN538+S+VdVT6j+/X1uOhviHyqbH" +
       "txkkrkjIsggvEmqPvndHRPeyT5W/rtx+XvaLQPZ4TXjqf7Pu4hN/8j9vGu1y" +
       "KTtjqp6qr8Bf/NzTxI/8eVn/eE0paj+X3bzSg6D/uG79C97/OP/SA//yfOVB" +
       "pXJlefBEIapuWnhqBUTR8eFjBnjquKH8xoh4H/69erRmPnPaV5zo9vRqdjxH" +
       "wX0hXdxfOrWAPVVo+QfB9fTB8D992nLKkGNvzAWkayR4ADD16PE/+fuf//bH" +
       "X2+dLzzo/ZsCOtDKlWO5cVo8uPzsFz/z7MNvfP3nyhXmsGllb4hlerVIPlCO" +
       "74Xi9oNgAYrLZ6DCr9i+6paIG0nl4Q5NDsbX+VlnOist79imS7v66PeyK+Fm" +
       "1u89YP3eM1gXNz9WLInFjXE7yEWiFsniEOsje6wM2e3SvbPAmt8H2GcOwD5z" +
       "G7DlxPTvDuzFPdjeuHsW0uD7QPrsAdJnb4O0RLO5O6SX9kj7Ak2fBXV751Af" +
       "PbT15w+gPn8T1Ep581NnIwRx0sUwChIwO3XtEN6FJAiPHOMJXD99l7iKAX7h" +
       "ANcLt8D1s7fAVdx+4hDQ/ZFtWslZkF6/S0jFSL54AOnFW0D6W3cC6YFFkCSB" +
       "dxamT90lpmLSvnSA6aVbYHrjTjDd5+rGmVr6zPehpasHiK7eAtHfuyMtgYhM" +
       "98/E9Lm7xFQY0PsPML3/Fpj+wZ1guqi6tul7B7BOz71/eJewCiP64AGsD94C" +
       "1q/cCaxLxQuIoX4rQ//CXeL6ALheOcD1yi1wfflOcF0xQMjAgyeLqe6qRahd" +
       "5H/4FLp/cpfoigGEDtBBt0D3G3eC7nLxbmGqmyAgwiNddc4C95vfE1zZGHDq" +
       "wNPUr2HXylj+t+/OpT+5cpdXDx9bRD2KAaKrKxcr6787ORlR7F8PngLZuGOQ" +
       "IIx59LgxOvDNV3/uTz/9+z//8tdADEMdxjCF9I8DbYl//TtPf6T48ZW74/N0" +
       "wYcv3yHRapww5dOrrh1ROvW8c58bvA1KyWNfHTZisnP4oQWVQDvL6UJEMJTF" +
       "djCSbyCe30ECn5KzuGORjmxOUhdLnKUOd+UpbbUin8k3i3QmoXVlRc90bElZ" +
       "LiRSZGhnHRwnVVEadRsiMZAolXAFusebk9GmMRrR/TDD6R7hUiMVH2SG1lR8" +
       "zVOQpbcg19g69bQm0twgTc3YVGFkOIQ4ETebkrAV+x6FjaV1T7eEOsWag5Vh" +
       "kKbXj62okbXmjV1Db2FIhs4HO14MmlNI7nab0+XANKYjsdGaB6oiCObWG/Fk" +
       "FedTlmTU6cyE1rNOOBYUZcY484zkQ8YVJLqthlt721fwFUp65qyv2WtBWYnm" +
       "jBmTKi5ghE+NtwmSNkbVcD0V5YXa4Dit0UXY3nzCePKMsaxwxTYkKhC3nuPu" +
       "WCJQIiJdOTVJHaXt8c4O6OpkS2PKQpaIdYOM1t6kIyfdXGvpXDTRibG85TNc" +
       "EGeDbMYO1upw5OQTnZrU6otmmxFac31pV0MbHSldDx+wa0oJvJ45MFVbktxk" +
       "xBLQyo5CkYRHmTRUPD6o9aaurQx8iKLWJrFzI88eskwrm2R8rrAziqyj6qwW" +
       "8rsJM1uIgcAh2CBvTTQ3HAyEcW81Imhy1bEYxiZ3xMRz1lNfWrFZ02+JQ6A2" +
       "3F7VcK3nTUMfk/l8rgpih5esVObWpoBVs0hkhdpCxAiWpFK9H3prtDWllyS7" +
       "g9cJueuRvELVol09HNVJo00OiDFO5iExGca5Q4Y+SggsMaYR3EQHsxTqdIgO" +
       "a4/79YWtkjUpBdK451RnzkRwB9MGXq2xfKe/tkxzuF7R08YsWDdr5jSbOCue" +
       "WUzJfns3YSfTSU3cTm2GJofd5dzfutJ6KdX4AKvpUttEeEQeUalAdpxOjvTW" +
       "u3gFz3q4ivVINTS9tdA2h5RHJ7t0lWyTfNg151RH76C015mhSW/jL6LWhhF8" +
       "P1esvgWMfZ4noU0ueg243wzbRm3MoomZK+sxJUxadD9H2SWGkZbanERBYzD0" +
       "lHTRm2jd+nIw22JQC9oEwyad4ILFWK5KrsPa2JxW67aXkI6nB4u1QNVMrd+w" +
       "+tMZpWHdbDd28CgbUnNJ3cxZyur1FYua0ZtRwqMG1LUtcour6wBPGi6l9j0k" +
       "l/CVwSGr3pz0Jj1uPRf9zmwIQ0RrJW933HrnqH1nijtAbdyIj0Z0a4oHrVmn" +
       "XWet+thsT8fWpIpEc5KyRAEa4Auiu5SCMUVoCksMIgHqQxOhPQKeYE6MBriq" +
       "MYg2UV1vJYgE2SX6mIek2y2mKMw6azoQZaFsBLXaba07j5vzMDDcBWR2hrg2" +
       "JahImITZnFDtgdOPRqEjEJ0e6o1FpipahjQ3qeo4iqT6sj4b9hcxm4Q6PpLc" +
       "Gap2GZIk6mhDmg/9DaYgSN0b2nYqYUY1WaY6QZG7NetIU1yRwk4292cRb+D9" +
       "RsDXZClZ9YZ5PBh3PbvTm2+GUzEc9rcTsZltqbXLh3WH3cxzJomzSa4QDbHB" +
       "6C19GGx2M6eqe4vEaiKGi/fiDIGq9q6z2kqBCVlxq4GiEwzR7FZ90WLxJG+1" +
       "lkYC1TSsocs9ZwA3Rkx/MNCipZKOhZxao3Evayh6PYNxIDSeWR4V44NOCCH1" +
       "XnWVN9tVRa5Wdy7Z79iawPEyyVIzcTmpLmptIUwbxkLJxrC/rXnMlEHqVtaY" +
       "JAu2gbUarGt0tRAN87rl07bb6HKrlj1cIBiCtXNPb6QRZwVxb4pWl0ETGTVG" +
       "1C72ZumKSpJ4DKVCJ9lF04YKaVqC4ZiSeVuJVJYCqXndRafZoFyrK8Cs5Lex" +
       "fAd5m6FsRh7WzTtkT/XnaHetDClivoLC1rTHr0f1LTTpyVSD2YC1I6yPRh1D" +
       "CCh+vqL6XUMysrUkw11SrrfDMVvrWGEzHig1BDX9GDblaGfIHLbJAkZpeeRg" +
       "RCay6JmoC+novL3E9JRA0umqtR3T2EyHlOl2XJ10WvR6kJDt3bQWjTWR0DZt" +
       "LeMadWe+XcT8zunvcjzM1AltISqF5+kAWdGrfE7aBLFY+tyGkNtws5ViPkRQ" +
       "cmOJDY2Qx/JosNkKTIMe5VORw4YtHDgJBG4E41G2hWdJPqtJ5sCnp1NrvNt2" +
       "fX/WCOeLRqdhIOOoCi/bhtoNzW5KsFsiNJecAcurKlEf5oqQV9Gpiyse0Wtp" +
       "jChkWdz3aIRAakGLzKAN2ppv2hzWTuAty6/ZGRy0HYqFdHwDw8myyZiLPJtl" +
       "ME30RabPjO02Mc+V8cDXDDhdAyeANPiY47orSW7Ph7JNEeuEoBNeG5NI1/HR" +
       "vjtgU2VOr2K8YdXYhoyHg44XW325s3KSZVcy1nMn5qAx5+o0xDgzihpJnSUM" +
       "IWODoKuDWV90Vc/Ue60pqlfVro9D3SDbMgw9tKK+slhZmh41KHZKtxhjOOEh" +
       "WF7ICNwSx62BQUb4aDlsZstqdauqgDc+XnW5oUwixHLe2PZr1aWHYwGS78bM" +
       "tkGs2JEDHLSZhz2outM3GGuOwGyDU43Lx0jNwB2qHfZUCazifgvv4k1n4Ffr" +
       "46VgCkwSui4ap2ozGHnOPB3ZzmSz7nSRpco3zGY4bgoZ5tB1MCx6t21oOjyp" +
       "Yau4xjliNBd32x2Vwpbcw+sIu5VEOVgsahOZj+djjp35IzFB+9zQGM/RVVxl" +
       "uRVP5AI664gbTnCNeSxWczxb7PJVyCCbEU+JaFCHh01zCtSIJtgG8TGX9ofG" +
       "bCcRdRjabA23TtY2cMR1UN9qCjFPpQY+3LaMjZp6aLtfZxfQkrLH9elI2DZI" +
       "Td8t+XaLBFFWTCO7HU8ojBCoUzXdInxEqvMdFNS6zEBz1/1GZGy4YWsb7+JJ" +
       "FO50rWMnmVZzhqI/6mGyyGA7BDh7l8mHmuiMZ43EnfC1tAGxSoR5rjMSJzgb" +
       "TaixtEDgPI3n7ZQd4lRvNLYzEG523TBM2N6g6powgsxaSaIqVhtqeGICaV6Y" +
       "42jeraPyPGJVTyDVDSmY626/OQoaqdTv9evU1MgNEIUqAwUZ01Q2H2TOEja2" +
       "iodZ7QRc0cafcSqW1jo1YldbE400wF24GnHcEtst5bHLzRUyINGeRDhiOAs4" +
       "sBibyBTxSF6WY6ln13c7Atk5cwuzlQ0r2eSmF2SCl9G1rrcNqLiJxxnh11Ra" +
       "bNoMq8DOQtnV2f7WHahOlkGR0gtassMaMwpVfc7bTHi7bfMd3yGN3OXlTk5m" +
       "zRisM7LJSKslJbBajvEToYsDKxL6ODxG3Nhs0b66mKry2IT9TX0+jNmG0NK9" +
       "QZdpEy7aNaMslREeAppHiHAq6SGOGggk06E1qUOj5nwXrtVRLLuwLe1sum4j" +
       "BC1i8dAn3Gp1s+gs3H6vKtR0uas0h3Q3SBhrq884mHKrZrzQOo7CeZNBplmt" +
       "pDepV5VMkkjQC91FPQJayIm9RbdThbeD0K5xCOxDwJVj05Bp1lQKiba6szG6" +
       "fm1rKrIl6AOvuZI5f72b9hecqRozMlmEW32db0AEMJ9xvEcSPXU7XWNSb03U" +
       "gKuVYSEz8JyajRgVM0Zk5I9MqCcbuF/fBnMwAC3Gqjs8E+c11hI8ezPEwBoL" +
       "exKNcgYUUSOsK5maNt1R47ifrduzkEMheRdPY27YqHKIP8arvSilt8YKX0Kw" +
       "tFZn4lBhxDmTo7rsAHMabAV0KzfrcHvegpuCndKQHPc2seRD/Wpv0zY6vu/w" +
       "aauKtJCRkBtQKMl5qLMYv7IHMkvzjr8ZQXDKcdg4s2QrcvqQ7FEusp2JNOdS" +
       "shGhWlBjpVootxp+WzFib1iv66tEbSwQTQmkBirvdL3ftCNvSMttSs4lDdmt" +
       "N7Ke6ZM03q67DGjcm4+w3IQpSpxHC3FT92dNxkG52gYd8UtLYufhNpsLZlOI" +
       "7M5GxGEUhoRcs9YLo4oT/noax8210kz760SUs63Mh501RwSEzM1Zb93q0bX+" +
       "Sps0Z2PJmtQcD5ZM2xswVCwJvYnFujm59afejsKDtTx19XW3QeQwqXiN8Zib" +
       "TDoCozT9zVasCYuuNvBWXaUR0cogpfvVhbwGIxoZ6IoWVzFKTNkEH/SHNBNE" +
       "4RxE/M0tF64ynArC4VTTR8Pmjt6oym7H5AvfnAk9uTdLxcSQJ6xYa0qdBdd3" +
       "0jmtytF2shGn7QUHzXfJtj4fo8NZwPIDXYMMd4fNm3SIsbQ8EiltLIbqpku0" +
       "xSFKVqF51o9rbrKgui0rQeQpU6uDdjGupigdEQVxxK4tDBEHgRpZkknqxJEW" +
       "VJNIpdY4Hg2UILWkrpYu67zqbkJi0yfa077awp1ZrPksjzNB2LPwuZ6ssqa2" +
       "63VatcCoK5026uQE3FgwUavW01rNgdWtLXYrqYZ5AxlOl2im7sbVmSq69eFK" +
       "wBA7rvn83IliUW1BhCIjZp+yLKXB+RbO83OIZFo4oi5anWAVNzY4UyMH0XS8" +
       "62KmMt5NVn0jl4mJHoxn8yWJyp6dMb0B4XRBvDv2qHnu5w6XMvUcKAPN6NVk" +
       "LXk6AeLW6pZEd5Hi6rrAwq1OIqFrJxfgZRZPZtNma56yCzBf9XkbhmyazRcW" +
       "xjErilTQ9ZI0+mS8QJVmHqraGqFmKOQ3rWYqK9sNToVjq94O5LqtUInDocGo" +
       "nyS0mWaNOovgCDpqGRJnNCMTFTZ4zzUHW4dcMbkq+jbtaENe6GupnS30qEqG" +
       "uwGcpPka3hgG38ooGKpy9dQmJka+cSyrNZOxEMkaKZKvoDrbs7ypY/aHluVC" +
       "nDyyImTE4ILfFvs8lXntgdSZKmGvx+rwLrGwscTg4DnZ0umhLKFylDWz/qBu" +
       "JpvITOFUdXC7KTf1lZS08DRnbauPTdFcEbfi3I1mcseqrzBJqHPAsiJBkTv1" +
       "bYb1g01TcWlYidIVD62QJK+3k7YzTRveArbrbfDgBkloWOdaI7NT7mT/4d29" +
       "anqsfHV2dMxu5WJFwe/cxduk7Kwd4fLzQOXU0awTLxpPbMlWit3xZ291eq48" +
       "WPD5T7zxpsb+cu38wXYwllQuJkH4g66+0d0TTV0CLX3o1ru7THl48HiL9Suf" +
       "+LOnZz9ifewuTio9fwrn6SZ/hfni7w7ev/yF85ULRxuuNx1rvLHSqzdus16K" +
       "9CSN/NkNm63P3rhNX7xgHhxodnD6Fe7x");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("2J39/vaD+7E/tdt+7lgAKQW+cZvt+D8rkv8EBiHWk/3ZsjPfS24CWzs2oj+9" +
       "mz37MuPrR6zfWWQW22vjA9bje8P6JKlv36bsfxXJf0sqj5h6MgvCPedSV8f8" +
       "/vvb5VdsZ7AH/Nh7zu/chduU3V9k/lVSeRTwmxbbIGcy/O7bZVjssHEHDLl7" +
       "z/DybcoeK5JLSeUyYIiX24dnUTz38Nul+AK4JgcUJ/ee4ntvU/ZskTyRVN4B" +
       "KNK6ceYYnnvy7RIsNpb5A4L8vSf4gduUvVIkLwG3AwiSx5ubx+RefrvkXgaX" +
       "cEBOuPfkkNuUoUVyLalcKVwMWLo6N+yUHnOE74WFygcc5XvP8UdvU1ZEKOd+" +
       "6MBCb9xyPSb46tsl+D5wzQ8Izu89wdFtypgi6SeVx+24f9bW7THLwdtlWZwN" +
       "+OgBy4/ee5bSbcrmRTIFwSNgecYW8DFJ/q6O6SWVS8cH1YtTt0/d9MeX/Z81" +
       "lr/25uWHnnxT+LflWe2jP1RcpCsPGanrnjyzduL+gTDSDbskfnF/gi0s2Xws" +
       "qbznlkfnQRRTfBVgz13fyy+TyrvOkk8qF0B6UtIAs/m0ZFK5v/w+KWcD5sdy" +
       "SeWB/c1JERBGXgAixa0Xlqq7cV97f8gvO3djXH04EJXHv9dAnAjFX74hgC7/" +
       "onQY7Kb7PyldX37pTWr8k99q/vL+0PnSVfO8aOUhuvLg/vz7UcD84i1bO2zr" +
       "geEr33n0yxffdxjcP7oHfGzCJ7A9f/YJ754XJuWZ7Pw3n/xnP/yP3vzj8qjg" +
       "/wOnQ5hzOzYAAA==");
}
