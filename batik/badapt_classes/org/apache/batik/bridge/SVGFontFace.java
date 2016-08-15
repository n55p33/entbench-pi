package org.apache.batik.bridge;
public class SVGFontFace extends org.apache.batik.bridge.FontFace {
    org.w3c.dom.Element fontFaceElement;
    org.apache.batik.gvt.font.GVTFontFamily fontFamily = null;
    public SVGFontFace(org.w3c.dom.Element fontFaceElement, java.util.List srcs,
                       java.lang.String familyName,
                       float unitsPerEm,
                       java.lang.String fontWeight,
                       java.lang.String fontStyle,
                       java.lang.String fontVariant,
                       java.lang.String fontStretch,
                       float slope,
                       java.lang.String panose1,
                       float ascent,
                       float descent,
                       float strikethroughPosition,
                       float strikethroughThickness,
                       float underlinePosition,
                       float underlineThickness,
                       float overlinePosition,
                       float overlineThickness) { super(srcs, familyName,
                                                        unitsPerEm,
                                                        fontWeight,
                                                        fontStyle,
                                                        fontVariant,
                                                        fontStretch,
                                                        slope,
                                                        panose1,
                                                        ascent,
                                                        descent,
                                                        strikethroughPosition,
                                                        strikethroughThickness,
                                                        underlinePosition,
                                                        underlineThickness,
                                                        overlinePosition,
                                                        overlineThickness);
                                                  this.fontFaceElement = fontFaceElement;
    }
    public org.apache.batik.gvt.font.GVTFontFamily getFontFamily(org.apache.batik.bridge.BridgeContext ctx) {
        if (fontFamily !=
              null)
            return fontFamily;
        org.w3c.dom.Element fontElt =
          org.apache.batik.bridge.SVGUtilities.
          getParentElement(
            fontFaceElement);
        if (fontElt.
              getNamespaceURI(
                ).
              equals(
                SVG_NAMESPACE_URI) &&
              fontElt.
              getLocalName(
                ).
              equals(
                SVG_FONT_TAG)) {
            return new org.apache.batik.bridge.SVGFontFamily(
              this,
              fontElt,
              ctx);
        }
        fontFamily =
          super.
            getFontFamily(
              ctx);
        return fontFamily;
    }
    public org.w3c.dom.Element getFontFaceElement() { return fontFaceElement;
    }
    protected org.w3c.dom.Element getBaseElement(org.apache.batik.bridge.BridgeContext ctx) {
        if (fontFaceElement !=
              null)
            return fontFaceElement;
        return super.
          getBaseElement(
            ctx);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+FxeqzF37St8knuTvdLm3H8B/m/QqQodAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6e+zr1n0f77XvtX3t+F5fN3bqJY4f13mp+1EUqQfnNKlI" +
       "iZQoiRJJiZLYh8OXKIrvN8XOaxpgS9AAabA6XQo07j8JugVuU3TrtmLL4GHY" +
       "2qLFgAzFXsCaYBuwdlmA5o92w7KtO6R+7/vw0m0CeHR0+D3f8/18z/dxHnrr" +
       "O9C1KIRqvmfvDduLj/Q8PtrZzaN47+vRETNuzuQw0jXSlqNoDtpeU1/6tZt/" +
       "+r3Pb29dha5L0NOy63qxHJueG/F65Nmpro2hm2etfVt3ohi6Nd7JqQwnsWnD" +
       "YzOKXx1Dj5/rGkN3xiciwEAEGIgAVyLA3TMq0Oldups4ZNlDduMogP4KdGUM" +
       "XffVUrwYevEiE18OZeeYzaxCADg8Wv4WAaiqcx5CL5xiP2C+C/AXavAbf+Mn" +
       "bv36Q9BNCbppukIpjgqEiMEgEvSEozuKHkZdTdM1CXrK1XVN0ENTts2ikluC" +
       "bkem4cpxEuqnSiobE18PqzHPNPeEWmILEzX2wlN4G1O3tZNf1za2bACsz5xh" +
       "PSCkynYA8IYJBAs3sqqfdHnYMl0tht5/uccpxjsjQAC6PuLo8dY7HephVwYN" +
       "0O3D3Nmya8BCHJquAUiveQkYJYaeuy/TUte+rFqyob8WQ++5TDc7vAJUj1WK" +
       "KLvE0Lsvk1WcwCw9d2mWzs3Pd9iPfu4n3YF7tZJZ01W7lP9R0On5S514faOH" +
       "uqvqh45PfGT88/IzX//MVQgCxO++RHyg+Xt/+bs/8kPPv/3bB5q/cA+aqbLT" +
       "1fg19cvKk994L/lh/KFSjEd9LzLLyb+AvDL/2fGbV3MfeN4zpxzLl0cnL9/m" +
       "/9n6k1/Vv30VujGErquenTjAjp5SPcc3bT2kdVcP5VjXhtBjuquR1fsh9Aio" +
       "j01XP7RON5tIj4fQw3bVdN2rfgMVbQCLUkWPgLrpbryTui/H26qe+xAEPQIe" +
       "6AnwvAAdPtV3DInw1nN0WFZl13Q9eBZ6Jf4I1t1YAbrdwgqweguOvCQEJgh7" +
       "oQHLwA62+vELJTQ1Q4cFkaaAeihgp0elffn/3zjnJaZb2ZUrQN3vvezsNqAa" +
       "eLamh6+pbyRE/7u/+trvXj01/mNtxNDLYLCjw2BH1WBHh8GOzg0GXblSjfED" +
       "5aCH6QSTYQG3BgHviQ8LP8584jMvPQTsyM8eBposSeH7x13yLBAMq3CnAmuE" +
       "3v5i9tPiT9WvQlcvBtBSUNB0o+w+K8PeaXi7c9lx7sX35qf/8E+/9vOve2cu" +
       "dCEiH3v23T1Lz3zpskpDT9U1EOvO2H/kBfk3Xvv663euQg8DdwchLpaBSYLo" +
       "8fzlMS546Ksn0a7Ecg0A3nihI9vlq5MQdSPehl521lLN9ZNV/Smg48dLk30G" +
       "PB88tuHqu3z7tF+WP3CwjXLSLqGooukPC/6X/vU//yO0UvdJ4L15LpUJevzq" +
       "OWcvmd2s3PqpMxuYh7oO6P7dF2c/94XvfPpHKwMAFC/fa8A7ZUkCJwdTCNT8" +
       "V387+Dff/IMv//7VM6OJQbZLFNtU81OQZTt04wEgwWgfOJMHBAsbuFVpNXcW" +
       "ruNp5saUFVsvrfR/3HwF+Y3/8rlbBzuwQcuJGf3QOzM4a/9BAvrk7/7Ef32+" +
       "YnNFLZPVmc7OyA4R8Okzzt0wlPelHPlP/4v3/cJvyV8CsRTEr8gs9Cok3a50" +
       "cLtC/u4Yerp0ygxVjzTPOSoXGiBQAIYv3sepeDmrssZr6m9y3/rGl4qvvXWA" +
       "qcggLEK1+y1A7l4DlVb/ygM89yw1/Qn9l97+o/8g/ng5gaXQj59O2kvlHH0A" +
       "PB86nrQPXbbME5RPng8nhwlpn7y7Vb0rM/PRITMD+B9+wFouNB1gqOlx/oNf" +
       "v/1N6xf/8FcOue1ysrxErH/mjZ/5s6PPvXH13Iri5buS+vk+h1VFhftdB9x/" +
       "Bj5XwPO/yqfEWzYcsspt8ji1vXCa23w/vzCb9xCrGoL6T197/R/8zdc/fYBx" +
       "+2JC7YP14q/8y//5e0df/Nbv3COuA6f25Eqn+D2Kj12svUNRIYUrpB+pyqMS" +
       "WmWyh9mnyuL90fmYfHGKzq11X1M///t//C7xj//RdyupLy6Wz4egiewfdPxk" +
       "WbxQquzZywloIEdbQIe9zf7YLfvt7wGOEuCogiQaTUOQ+vILAeuY+toj//Yf" +
       "/5NnPvGNh6CrFHQDqEkDSa6M/dBjIOjq0RZkzdz/+I8czDd7FBS3KqjQXeAP" +
       "tvye6te1B5soVa51zzLHe/771FY+9e//211KqBLePaz2Un8JfusXnyM/9u2q" +
       "/1nmKXs/n9+9HAD7grO+ja86f3L1pev/9Cr0iATdUo83HaJsJ2U8l8BCOzrZ" +
       "iYCNyYX3FxfNhxXiq6eZ9b2X3ebcsJdz3pm5gnpJXdZvXEpzlZbfexJVTr7P" +
       "B5MrUFWZV11erMo7ZfHBc+b5cWBYm+O1zHE0LZvrhxRZlnRZLA6zydx35qcX" +
       "5boDnpeP5Xr5PnL96DvIdeMgl2Pa+5PQ98G7VmRGGh+VdEe0OKdO6S9J/2Pv" +
       "KH01ZH4FZNprjaP2UQVfu7d8D5XVD4GUHFVbwjKcmK5sn0j97M5W75zENRFs" +
       "EYHh3tnZ7dOock6uj/8fywX858mzsD/2wHbss//x87/3sy9/Exg5A11LSwME" +
       "tn0uN7BJuUP9a2994X2Pv/Gtz1arCbCUED/5yrc/WXJ1HoSuLKpdgXkC67kS" +
       "llAtwsdyFE+qBYCulcgqFq+ew9ONwTICiPjnRhvfvDPAomH35DMWJb2RLfLc" +
       "2rh5Z421N0TaRbEuNxKSdj4UMsSP6GkPnbOqshz5RG2wbjSj9hhvK6uV4rbH" +
       "7LxhcD7pWQvHZkiBWHmzvGswAh0IdiLzCEIVC5YZNQec71iL/m7JC35gEn2R" +
       "CfBhA15KDgpr3WC6tFwtUWq6rNSUdooXiNNOeEqk217QXYRM33BYOuvrOSf0" +
       "V1yPaft2Nu82OASfbMb8okYXynbdCLstwzQdf0DQbJfqFuqo0W+uF3Oes6zc" +
       "HJHDBmsO1fV4ak5362wWrDmSF02ZkayYXiEOz9gTs+tE5GJN7bistSWGfWGF" +
       "bR2yVs9ogqxPsnqTVEh9q23a22JHBpQtxplJb7D9ONU8hNuHQmFbFLdZmYMJ" +
       "KfcnliBwjQEzZBBpIKMLcWCZjBxZ5nhiJX1Wl+TAmLWzgM+WcYHzuLpxt9Yq" +
       "cAxTIhbinMx7EzqSB6N1YfC8K04VrDapd6QpTiAL2loXqwnXj9d6zC+mmdw1" +
       "ljHQeED3UFbcMf44FhmjlU8p0RvGdY5bJJ15jycofOg42U6ZoKTHjJRI6THD" +
       "BDeXtpVIw9pwN6rP2gMcWcJNVhAJjdKk4Z4fq7vMXA/HxJDa6kx9ME3pxOJI" +
       "pjXyOI7a9RqU1nd4vx7ydW9P29SQsrLZfrl0ti4fTVpLfMZTmsFL7KQY2hSy" +
       "bGdWtzlvBkXmk3uHizWHtxfpWoBjIgNiscHaJVRSm8piJFJDgSDRfdEmbGXW" +
       "ofuT3kJe2hPe5tvBnKGMbnuxJ/smWfcCtjvnFgjTXQYY2R0syeZWtAR3GZP6" +
       "yLMmw9y0jM1qzc26mlj3DaO1lQlpsxvTpJzVi4Zq22gd7Ab2Bd5o2kbOdBml" +
       "5xKEZCdpR5qMXIptWBzTpqcZB2P51BMxjiU7MNvuGgbREbLNRN40a4qaoqum" +
       "tse50KWl2sD32Q6PrJneIBfGRaM9HCdNOR635uuA1ZZcMOvj1m6Smk1j54oW" +
       "O7T2RSH1p0SAEoFKr1J3NbPg3a47CgMuX5ojZyMYowm9WCCh5RUILu6IxCIy" +
       "z8DZvB6YDoai3tLNBv56UQwilJEmNOM2vDktaZQQtnuCP+oaSeCZPmY3BUsO" +
       "kbC7tbdtBIw959iBzbFFY9yf1faKNx1wJhPSw0V/QfVtnsspzd8MleHawFSt" +
       "FwukMQ2IDksvfZoAjiD26mLf6A6GuKGa01gYemKP68xCvd7H03VvPpwsV1pU" +
       "x6SWPZnrE5uRewmxaro2RgXGHqR8ApvjDb2lmxg+WCVsF3NIFOdobtnIlkw3" +
       "pRxhTGxsk9M0MxgJ/XBOz8dRyJLqek0oOp1QAb6ZmgmcIO2lFRE87mP00hSs" +
       "UGp1rATF4HiZDVuMn/sh4+tqCg+oLumNvbpEMIRN+IltulKL5Ehh6oRNebDe" +
       "TLC90M1lrM/1pqvQ87DuhnYX5DBLRCFYI6YLc3NWG9BZfcsiOdXbNhkChRu7" +
       "AJuZeIbX8OG6S6L+dmbv9wO1v3T5hmnFJrtPcHjVgek4gWGSaqnTNjXUQli1" +
       "+kKKNtW9NQnnrYVOrOb1XI1EAxus4ppYxPMaKgz3FtcdY6MuUmM2Wc4upkG9" +
       "O18ufWJIzwMfW0o932op5mg33QUJO+thrNtFHZUc0xI3biS01HR9Ldkru50U" +
       "xgzKYiADNP0pyaxJhMOD7QxuJ14zkZIAURe6NupY07U2Ds1+Y7XckwxvZDOl" +
       "mIc0N9skmWrMBqGNwblML2XC27c1Y9oAZi60CHIxYPF2Y9+poWix7TQplMjm" +
       "JvCoGsM1G3w8XFpwYHomM9o3ENaa5T1VGhoUNd8kGpkQc8HyydVEWUSbpoig" +
       "g11LgeNQVzFrNBgYMYWIDcXAJ3DMpXonTtB0vM5Zc7Ergtak2GLZoC3Ig07h" +
       "axQw5Vk4RtNwkEWSTnF5rzbUOblu8s5CEfiWTPLCvDXwyLXMd6SU8iYMyzcs" +
       "hO9i9JxQWxOOaDlxz1G2BOGJuZ3wJhZLNq6icVDgYXPueAxXi0d5mmw28qqu" +
       "m3vd78/jmrRrTxpkjuGimdSsFRxw86apSNnIddBFB2d72bKIdaljBv6UpnF7" +
       "2pTtgiAmI4HEFSSOxDBY9xVsbm+XadYv9pICd/R1D5+C8DQTFsyyz1qx7/ZI" +
       "UU6WC7njwWRLVtqcu93FVG1GBmmtJgBLKmzZRoQh7bVwWq/VNm2Ja07duTtU" +
       "F/BCiMcMt5ByxdSmGWL3LbYXdWurAkda61rN6WHj0MtlH5EbQcEuDTPWlmra" +
       "tjJcmWbLVhQ3mn7o55ztblS1p6kdHKV2Mlmnix4iOhRtu0Sq2ujYWshWtuuj" +
       "KpHv3dpyqCqsCJN+JugwTg48T2yoLFfX/ISq06N2Px7Vx0TdDWiOSqlQQHqs" +
       "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" +
       "/6A6vv7fWFvsebgmAAA=");
}
