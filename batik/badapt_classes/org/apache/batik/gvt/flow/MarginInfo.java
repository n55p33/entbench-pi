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
    public static final long jlc$SourceLastModified$jl7 = 1471028784000L;
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
                                                              "XA2wx7Fov6ZlL/Zrtml8H/fmtrf7IjdwM3/Ft6/9H0FyDPf8KgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "cqQnaeTPbtpsfebmbfriBfPgQLOD069w");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("j8fu7Pe3H9iP/and9nPHAnAp8I07bMf/eZH8JzAIsZ7sz5ad+V5yE9jasRH9" +
       "2d3s2ZcZXz9i/c4is9heYw9Ys/eG9UlS37lD2f8qkv+WVB429WQWhHvOpa6O" +
       "+f33t8uv2M7gDvhx95zfuQt3KLu/yPyrpPII4DcptkHOZPi9t8uw2GHjDxjy" +
       "957hlTuUPVokl5PKFcAQK7cPz6J47qG3S/F5cI0PKI7vPcX33qHsmSJ5PKm8" +
       "A1CkdePMMTz3xNslWGwsTw8ITu89wfffoeyVInkRuB1AkDze3Dwm99LbJfcS" +
       "uIQDcsK9JwffoQwpkutJ5WrhYsDS1b1pp/SYI3QvLFQ+4Cjfe44/foeyIkI5" +
       "9yMHFnrzlusxwVffLsGXwTU/IDi/9wRHdyhjioRIKo/ZMXHW1u0xy8HbZVmc" +
       "DfjwAcsP33uW0h3K5kUyAcEjYHnGFvAxyeldHdNLKpePD6oXp26fvOWPL/s/" +
       "ayx//Y0rDz7xhvBvy7PaR3+ouERXHjRS1z15Zu3E/cUw0g27JH5pf4ItLNl8" +
       "JKm857ZH50EUU3wVYM/d2Msvk8q7zpJPKhdAelLSALP5tGRSub/8PilnA+bH" +
       "cknl4v7mpAgIIy8AkeLWC0vV3byvvT/kl527Oa4+HIjKY99vIE6E4i/dFECX" +
       "f1E6DHbT/Z+Ubiy/9AbF/sy3W7+yP3S+dNU8L1p5kK48sD//fhQwv3Db1g7b" +
       "ujh85buPfPnSy4fB/SN7wMcmfALbc2ef8O57YVKeyc5/64l/9qP/6I0/KY8K" +
       "/j8CVWrxOzYAAA==");
}
