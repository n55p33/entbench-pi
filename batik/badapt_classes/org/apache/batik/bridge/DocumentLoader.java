package org.apache.batik.bridge;
public class DocumentLoader {
    protected org.apache.batik.dom.svg.SVGDocumentFactory documentFactory;
    protected java.util.HashMap cacheMap = new java.util.HashMap();
    protected org.apache.batik.bridge.UserAgent userAgent;
    protected DocumentLoader() { super(); }
    public DocumentLoader(org.apache.batik.bridge.UserAgent userAgent) { super(
                                                                           );
                                                                         this.
                                                                           userAgent =
                                                                           userAgent;
                                                                         documentFactory =
                                                                           new org.apache.batik.dom.svg.SAXSVGDocumentFactory(
                                                                             userAgent.
                                                                               getXMLParserClassName(
                                                                                 ),
                                                                             true);
                                                                         documentFactory.
                                                                           setValidating(
                                                                             userAgent.
                                                                               isXMLParserValidating(
                                                                                 ));
    }
    public org.w3c.dom.Document checkCache(java.lang.String uri) {
        int n =
          uri.
          lastIndexOf(
            '/');
        if (n ==
              -1)
            n =
              0;
        n =
          uri.
            indexOf(
              '#',
              n);
        if (n !=
              -1) {
            uri =
              uri.
                substring(
                  0,
                  n);
        }
        org.apache.batik.bridge.DocumentLoader.DocumentState state;
        synchronized (cacheMap)  {
            state =
              (org.apache.batik.bridge.DocumentLoader.DocumentState)
                cacheMap.
                get(
                  uri);
        }
        if (state !=
              null)
            return state.
              getDocument(
                );
        return null;
    }
    public org.w3c.dom.Document loadDocument(java.lang.String uri)
          throws java.io.IOException { org.w3c.dom.Document ret =
                                         checkCache(
                                           uri);
                                       if (ret !=
                                             null)
                                           return ret;
                                       org.w3c.dom.svg.SVGDocument document =
                                         documentFactory.
                                         createSVGDocument(
                                           uri);
                                       org.apache.batik.dom.util.DocumentDescriptor desc =
                                         documentFactory.
                                         getDocumentDescriptor(
                                           );
                                       org.apache.batik.bridge.DocumentLoader.DocumentState state =
                                         new org.apache.batik.bridge.DocumentLoader.DocumentState(
                                         uri,
                                         document,
                                         desc);
                                       synchronized (cacheMap)  {
                                           cacheMap.
                                             put(
                                               uri,
                                               state);
                                       }
                                       return state.
                                         getDocument(
                                           );
    }
    public org.w3c.dom.Document loadDocument(java.lang.String uri,
                                             java.io.InputStream is)
          throws java.io.IOException { org.w3c.dom.Document ret =
                                         checkCache(
                                           uri);
                                       if (ret !=
                                             null)
                                           return ret;
                                       org.w3c.dom.svg.SVGDocument document =
                                         documentFactory.
                                         createSVGDocument(
                                           uri,
                                           is);
                                       org.apache.batik.dom.util.DocumentDescriptor desc =
                                         documentFactory.
                                         getDocumentDescriptor(
                                           );
                                       org.apache.batik.bridge.DocumentLoader.DocumentState state =
                                         new org.apache.batik.bridge.DocumentLoader.DocumentState(
                                         uri,
                                         document,
                                         desc);
                                       synchronized (cacheMap)  {
                                           cacheMap.
                                             put(
                                               uri,
                                               state);
                                       }
                                       return state.
                                         getDocument(
                                           );
    }
    public org.apache.batik.bridge.UserAgent getUserAgent() {
        return userAgent;
    }
    public void dispose() { synchronized (cacheMap)  {
                                cacheMap.
                                  clear(
                                    );
                            } }
    public int getLineNumber(org.w3c.dom.Element e) {
        java.lang.String uri =
          ((org.w3c.dom.svg.SVGDocument)
             e.
             getOwnerDocument(
               )).
          getURL(
            );
        org.apache.batik.bridge.DocumentLoader.DocumentState state;
        synchronized (cacheMap)  {
            state =
              (org.apache.batik.bridge.DocumentLoader.DocumentState)
                cacheMap.
                get(
                  uri);
        }
        if (state ==
              null) {
            return -1;
        }
        else {
            return state.
                     desc.
              getLocationLine(
                e);
        }
    }
    private class DocumentState extends org.apache.batik.util.CleanerThread.SoftReferenceCleared {
        private java.lang.String uri;
        private org.apache.batik.dom.util.DocumentDescriptor
          desc;
        public DocumentState(java.lang.String uri,
                             org.w3c.dom.Document document,
                             org.apache.batik.dom.util.DocumentDescriptor desc) {
            super(
              document);
            this.
              uri =
              uri;
            this.
              desc =
              desc;
        }
        public void cleared() { synchronized (cacheMap)  {
                                    cacheMap.
                                      remove(
                                        uri);
                                } }
        public org.apache.batik.dom.util.DocumentDescriptor getDocumentDescriptor() {
            return desc;
        }
        public java.lang.String getURI() {
            return uri;
        }
        public org.w3c.dom.Document getDocument() {
            return (org.w3c.dom.Document)
                     get(
                       );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6C+zz1nUfv8/250dsf5+dh10vcWzHyeYo+5Mi9WLtdCEp" +
       "UZREUaQkkiK31uFLEsWn+BApZtncYF2CFkiCzUlTLDGGIcHWwE2yYUU7bB08" +
       "DH2twYAURdcNWJO9sGZZgGZDs0fadZfU//09EiOuAF5d3nvuueece+6P5z5e" +
       "/TZ0TxxBtTBw9ys3SI6sPDnauM2jZB9a8dGQbfJaFFsm5WpxPAdlLxrPfOX6" +
       "d7/3yfWNq9A1FXqz5vtBoiV24MdTKw7cnWWy0PWz0p5reXEC3WA32k6D08R2" +
       "YdaOk+dZ6E3nmibQs+yJCDAQAQYiwJUIMHFGBRo9ZPmpR5UtND+Jt9Bfg66w" +
       "0LXQKMVLoKcvMgm1SPOO2fCVBoDDfeW7BJSqGucR9NSp7gedb1L4UzX45Z/9" +
       "iRv/6C7ougpdt/1ZKY4BhEhAJyr0oGd5uhXFhGlapgo94luWObMiW3PtopJb" +
       "hR6N7ZWvJWlknRqpLExDK6r6PLPcg0apW5QaSRCdqre0Ldc8ebtn6WoroOvb" +
       "znQ9aEiX5UDBB2wgWLTUDOukyd2O7ZsJ9M7LLU51fHYECEDTez0rWQenXd3t" +
       "a6AAevQwdq7mr+BZEtn+CpDeE6SglwR64rZMS1uHmuFoK+vFBHr8Mh1/qAJU" +
       "91eGKJsk0Fsvk1WcwCg9cWmUzo3Pt7kXPv4hn/GvVjKbluGW8t8HGj15qdHU" +
       "WlqR5RvWoeGD72U/rb3tVz52FYIA8VsvER9ofumvfucD73vytd840Py5W9BM" +
       "9I1lJC8an9cf/trbqefwu0ox7guD2C4H/4LmlfvzxzXP5yGYeW875VhWHp1U" +
       "vjb9NeWlL1rfugo9MICuGYGbesCPHjECL7RdK+pbvhVpiWUOoPst36Sq+gF0" +
       "L8iztm8dSifLZWwlA+hutyq6FlTvwERLwKI00b0gb/vL4CQfasm6yuchBEH3" +
       "ggd6EDzPQYdf9Z9ACrwOPAvWDM23/QDmo6DUP4YtP9GBbdewDrzegeMgjYAL" +
       "wkG0gjXgB2vruEKPbHNlwd3ASD3Qhg0004qOShcL/yyZ56VmN7IrV4DR3355" +
       "yrtgtjCBC2hfNF5Oyd53vvTib109nQLHNkmg94D+jg79HVX9HR36O7rYH3Tl" +
       "StXNW8p+D+MKRsUB8xsg34PPzX58+MGPPXMXcKgwuxuY9CoghW8PwNQZIgwq" +
       "3DOAW0KvfSb7SemvI1ehqxeRtJQVFD1QNudL/DvFuWcvz6Bb8b3+0T/47pc/" +
       "/eHgbC5dgObjKX5zy3KKPnPZqlFgWCYAvTP2731K+8UXf+XDz16F7gbzHmBd" +
       "ogHfBDDy5OU+LkzV509gr9TlHqDwMog8zS2rTrDqgWQdBdlZSTXcD1f5R4CN" +
       "Hy599+3gIY6dufova98clulbDu5RDtolLSpYff8s/Nzv/etvYpW5TxD4+rlv" +
       "2sxKnj8360tm16v5/ciZD8wjywJ0//4z/N/+1Lc/+pcrBwAU77pVh8+WKQVm" +
       "OxhCYOaf+o3tv/3673/+d66eOs2VBLo/jIIEzA7LzE/1LKugh+6gJ+jwPWci" +
       "AeBwAYfScZ4VfS8w7aWt6a5VOuofX393/Rf/+8dvHFzBBSUnnvS+78/grPxH" +
       "SOil3/qJ//VkxeaKUX64zsx2RnZAwzefcSaiSNuXcuQ/+dvv+Llf1z4HcBVg" +
       "WWwXVgVPUGUGqBo3uNL/vVV6dKmuXibvjM/7/8Updi7AeNH45O/84UPSH/7z" +
       "71TSXoxQzg/3WAufP3hYmTyVA/aPXZ7sjBavAV3jNe6v3HBf+x7gqAKOBoCt" +
       "eBIBlMgvOMcx9T33/rt/8S/f9sGv3QVdpaEHXAAntFbNM+h+4OBWvAYglYd/" +
       "6QOHwc3uA8mNSlXoJuWrgidOPeNNZeGPgKd/7Bn9W8+AMn26Sp8tkz9/4m3X" +
       "wlR3beOSqz1wB4aXBuXKgVP1/lYQq90OS8XYiogVANNKoA/cYWi7ZYJXVWiZ" +
       "/OhBuOYPZJ4D7ePV2zUwfs/dHoHpMv46A7HH/+/E1T/yH//3TT5SYe8two5L" +
       "7VX41c8+Qf3Yt6r2ZyBYtn4yv/njBGLVs7boF70/uvrMtV+9Ct2rQjeM40BY" +
       "0ty0hBYVBH/xSXQMguUL9RcDuUPU8vwpyL/9MgCf6/Yy/J59FEG+pC7zD9wK" +
       "cevggY/dA77sb1egKsPdxuXK7F84drc/Bb8r4Pl/5VPyKQsO4cij1HFM9NRp" +
       "UBSCT/V18/iTfJg/+xO3q93kdmbgHcW71dFM6ncvtjmbEJV7Tb6few0uKl8q" +
       "3D5Wvn0b5ZU7Kl+m0wS6zyjFBegA3PTp27jpVMuqkPhF458I3/ja54ovv3rA" +
       "bV0DMR9Uu93q6uYFXvklf/cdopGzuPuP+j/62jf/k/TjV4+n45suqv/WO6l/" +
       "Mhw3I2BZYVyyvPo6Lf8MeF447vqF21h+9YNY/v70BIzKAuKSWOvvK1bFJr8C" +
       "4PMe9Kh9hJTv/q07vqvMvh/gbFwtL0GLpe1r7okkj21c49kTV5fAchMAzrMb" +
       "t31iyBuVIcupfXRYo12SdfoDywqc7OEzZmwAlns/858/+dVPvOvrwKOG0D27" +
       "EkyAk5zrkUvLFfDffPVT73jTy9/4mSpIAZaUXnr3t14que7vpHGZVNgXn6j6" +
       "RKnqrIrwWS1OxlVQYZmVtnfEaT6yPRB+7Y6Xd/CHH/2689k/+IXD0u0yKF8i" +
       "tj728k//6dHHX756bsH8rpvWrOfbHBbNldAPHVv4/PS8RS9VC/q/fvnD//Qf" +
       "fPijB6kevbj86/mp9wu/+ydfPfrMN37zFuuPu93ghxjY5Mb7mEY8IE5+rKRa" +
       "GCHVpw6MN5TOXkkG2SYhqO6qs6NN0d6oQXdGE61efUDJ89FUcNt4s9mO0fmu" +
       "HQ3bXOQMc9MaDzC1Px2EK8bq8/QqnNGTnZh4Yb2xsWt5bIxn0WJbG61arByo" +
       "6jRbivUoMTttdbdMG929lqh9lcfDdrE0O00MM2tYbWLwi0afnsYtLRZGlEqv" +
       "u9N0bQYSQrW3ZANF9wq5iQIN5zG64yxZpmlypiRIwmxqLvBV0guplWqN5F5T" +
       "d+bTbs/J7RE1QCcbatJrNFNfihWmLgyGo+2U7uMqM3M42pkNzVGYb3pui1wg" +
       "1DBY9UZDdqzyq64TE8J8bMfDQSYjXqM+h42e05eCbcBNarP5wpom0ZoeeQvW" +
       "G6/s7UbOJDKQs9lMaDLD3hgJWRkRh5yrWPPYCYEMdUquia678uXpUHU8rRsG" +
       "6nZXpFgaoaKX9tYCPRQzXMnrKN11hemeD8itn9Sx/kge6+mqJ01NskEXNFlM" +
       "6TayIcf9QB3qMmKO3DVOS/pYGu5GdaqPhuSQC4nY1lh1YVN6IMTBDOlgcpdk" +
       "R/ZIbCuZmqiojDSl0NsuNli261qwmkTMvklxEi0O9g5udh2bHbDEkO5lo16b" +
       "jvstJE/HDcYR5zS3iZltzq7sPSd3E1NF1sPpjPB0Fk/oJAw1d+0bxRZd+UgP" +
       "W0znwOSWOINJor/AR057IKyHiL4gkeZ0m4Y8ulIGYo/Cx3Mi7U6UtYMNKDdf" +
       "eXprMh+0uF1HoQZUnRsA7ZpbVQszWyCsbSOnpuRMVNsrJhiJzoqVFHLVDUkR" +
       "Ho9CXZdJhiZmk0HNdlbLxdxYEttwr642I8GlcL+RD1cuqrWS2K3DLaMlbVGt" +
       "ne7llWcTo6y5cWQ18judcXfR8jh9TXJKXiNoP6IzAZ0ZCM/2CpskhDqcDiYG" +
       "slxiOoo6Mhd08MLznKbG6f3EG03xgccoieiH7SW3a20H7JYbixk61KMmY9RU" +
       "FzPVway+7VLcRHDEFSPAOpgwoc/hTaTLdLQpKZrb3lRU52N6Anxza7ucE/Vr" +
       "lJ0odGZPzBa5j8ZzHWVWzChYYPZousKiGHXmRNYSuxuVU6UgYpfKaNCzR4S3" +
       "DUhsJnoBHsWew7RRP1EEYbvIgl7YaNp8LYcb86TLGFFLzWSSoKcSKxqslYo7" +
       "lBv3Zkafs1E+z7p1otbrmguRUIZrSaz1SYMk+bbSV6JAnNdYEJKIiNgh5qIi" +
       "NurOWFSSLU0PW57nIghN2ASiLdsLqdHX616yd7r6sNaou21rudS7u6nQ8Fur" +
       "kTwXbI2EJ3SNydacWxsU+XJfBAZFzHVu2g12WH2puAKT6ZmduUuuHbm1QpXN" +
       "eU8gR/08YIYrhNLUsY/oQlMwqAnGYLatb7eO6e9Yv9GyxyotDpFVz50ImtkM" +
       "6upYcAyB3KNOpDQpyu9l2b4pDjUimktThhlMu+4+s2W3O6z3Jinit6ghC5zI" +
       "3w6svtFaDhejlGlg1hibFu0GuiBdRujDReiORSHZr9tchqme2TXazLK1YIaR" +
       "vtnhdcXFJ/U5A88xNe+1KFnNxfVegXt84bWm40VBDqzWIrGnxbiwCq+n7kfE" +
       "BGEcDZ7zDcVJ2YXmhNFWXBmDoSR2huM1utelnKz5Un0/cdfUECMw26DY0TZM" +
       "EZQJ8cWeh7XlBmB8MsR6PbGeN5MJpSqjyGoL3SWGuY1OqqYW6ogWP8I3qJKw" +
       "Kwo4gpwj7IwkLLSFyeOV1TKtdggbS0tFCyUvCJb26WzOJRO0KwxEneorNVP3" +
       "kzbWxKKUma/EYkJ0BGnUDkerPpPvaGTqdFrrUTBqEc688CcyydITcuWIkzGi" +
       "0wMqcIdUzxvsQx1G22ratqdwq7ltql1BUaw+4rGFDRMttbZnOAxppNqu3/SU" +
       "VW9dRPIYXTcypjOIjb2GtthVMTe16W7pL/psszPvOsR2xZPRjJooU2neKwZd" +
       "ZWfX1zUXHqF20lGQJBzjZtbA4UjZtrRtr1QzKrZJm/eLgpXSONkmhY7N3ICd" +
       "5utk6C3IXX8O83SYyF2EwBEpqGOLurHdNBHSpqnZqNf3uGQe9JJIYBhSrRuW" +
       "q88LzIwnktMTtimY5/vpmJKI3biQiAaRIwqcczKCb7moZikTV6Tn+/qUlo3Q" +
       "NyWiW3T2uGkh4WZObjZwHiJpbcHM/Qa7mmi5Mx/vB2TEk2JBqk2JjtZyc6HY" +
       "qNseoysZSQ2hrw9cL9+SFN7q14OAJLB2o59Sc9QqhuKWd/Z7Qmn0WcEbmKM9" +
       "uRBFoWf4uqoVwSwJkY6yqMMDWA7XaNIPOwoZRexooCLhhEcHfp9SfGbh7lru" +
       "nsPa053NmUwHZnwiL5bNBbpzUQrg5XBCS0OFNJJpxO+aQY1f4yKepjV1nk9a" +
       "fcXYWH7cHrfC7oTB28PNdlbrzmcLnqTpkObkUR3gtNQkOSC0LXZFHY961Hzt" +
       "WYbcoYtxirvOfutZTZ5oNUNY9IntTF/5EjvHW6FhLDo53++xityDVWIy2MmF" +
       "sx0tuCzNAy/o6IHDGltXa/hZW0fpvbI20Ia3CtRVxxXmtdqWlhpWjsYKueX9" +
       "DKV4qUBboL1MhEtPnOGyyNY7GDGTbEnoUr2MaOTOZNP3Q8Tj+112OOn3R8y6" +
       "aOdpkET95nZX246GjfYqJ1tY5LJM1DEsG1GSaCq2DbeXZjg2zfGerdYYfYsq" +
       "nUYG0Kw73Kewt2lskgaWRO1ezxfVyGzLaGed1WVVaOredk1vdxNrt5blnrrm" +
       "AVyNlrC673E65TQsJAbSNhdOSoZmSNcyeVaEk9mQHzc9eKES+g6L9wluFAbS" +
       "nCCwYFirJWz47WFWG/vdzUTL6K3kkI2dk/bbw5iT19iElbrrSdxtGInITwu4" +
       "FvPLVkDKyy3qbEIU3e2dlmIOSGcorIJGOxMa5nCB0e2iidfr01m6hic5oWqK" +
       "rc+5fIpn+swJuHFNpzbMxDLjEUuqm12D6hBFe4kEIrVmpllmypiMLoZy06dC" +
       "TXZac5dcEXrRWtANI+jEWKbz4yy19zzVhAWkvyg6BqdqUqgisBYbGoasYzbq" +
       "zpOCsy1PZXB31l3uTWvZaC3V0XRBzdk2Sy203EhteScsN1rW2TVjABI5QPhc" +
       "LHCjG8GYE5pjuM3WhIahKnNJT3p5wClmXFcbQT1uUJrZ5tr9/ULfSRO42eEY" +
       "r8mPcp+UwkWNa84DHsGRXFAculbAxK6puzofei04jGqsPG7gMYZ45njX2bUn" +
       "jX0t9uxlSulDdhS2+vG+he16WbIIaiHS7eWmsYgG2HhP9ImVNpj5+2xIuHkt" +
       "i7bR1G7Wx0vV5pMFicvj1CZnCCLs9tuNgSIRQjQtCk/a9igg0lE04ch+1soS" +
       "nRpyrd5kYe/3PJr5RkeJcQxZrvd8tOvQYUpvCkVc13hswTZlhgOftLZRtAQQ" +
       "g+fa0qXmdbrLoDsNsbviSIhVjEfrtalEuLy+U9TtEAfRElrbyXTCSeisxiRK" +
       "25R4V1uOFLYTBL46SmLL9pSZQMay6BV9viZgeJfud8h1snSXikLgS2LAT8er" +
       "JbdOzcmsFrdztJUtRxnNT/Yq4fE8IivifMj01MHYp+aeZ00CyqOGRZTU/ZbO" +
       "7dojfZDXQwKTDHYzRO3CiHuuAUKL+pjTSaHT9/VIdAIb2ZJSM5hidRbBDA4O" +
       "yVY+4yeJVjiTsVlr47WFtV4skuYuFZZcTXWWEp51YIJn2GwWxEhWmNuC6mDU" +
       "hNZrjc5skjfgNB0jaVtu+Bq3X41i2dwtMJdI86Q7RTc0VmMiAWnxvIYXhtny" +
       "191wvt4gcrOOMzCDEbtdjZKx2tQlpJTo4jWOdOMYX6cGPtiFaCdiUjZlJ83a" +
       "ntczOk0KjYEXvoXvEElwtKlDGxiiAiu0xwqDdRKJ6jEStks6VjgyfF6WHAZW" +
       "e+tOR6bHaMui+lzdDt2l3wLDR4udkaguLRKDJStIncZg3pdGsJ/7+HKB5QQy" +
       "MjpcT+y58EBOamgyWWaNLbnp4IKxiHfAQnJrxTPdQMgl3BgOeoRHrgetfiLs" +
       "6/1Jh0l5c0zqNVQdL7BODWnvRs25Z8VjqoYkQQOshJIGng5XaNpKQhjPZLq2" +
       "nGGjLF4N3PnAmm92neGmPmeN9mTUQWVJH7bgyN+uO5GPgggwI5exxfUQupnr" +
       "hARAYNkPd0FiBoVb7OCdF8gSv4v2RRMsg4RhIggE8GF1igvNuTynNnMOkfdz" +
       "TBJkfaw3m3oTz5rLeL/JUXMXt9ZsLta6CMxP8cbW2dTbQAt4tM5tQsMa/dFA" +
       "ZNccm7bkTT+OxrwdkE1aUtmpHyjuaj0dOt06k3vBCIQKsmtkqbvxonEE4pvM" +
       "JOemR3J8CmJqOe56NJ7KwdaYBf1uiG38abtdnxBh2qtznaLX4LUWu5kxKc4I" +
       "GDHAcUdscnGjFrTYeZ/vzsxJFgoNTiskOAJfzI4Qurt9NusRBPH+amPmp1/f" +
       "zs0j1SbV6a2CjdsuK9LXsWNxqHq6TF443dOrftegSyfRl08aHj8594igd9zu" +
       "skC1A/P5j7z8ijn5Qv1k3/KnEuj+JAj/omvtLPfSqcB7b7/bNK7uSpxtzf/6" +
       "R/7bE/MfW3/wdRzJvvOSnJdZ/vz41d/sv8f4W1ehu0436m+6xXGx0fMXt+cf" +
       "iKwkjfz5hU36d5xa9i2lxZ4ED3dsWe7ybunZ2N16q/T9h7G/9VlPNfoVwd+9" +
       "wzHO3yuTv5NADxhry3Cocq/7ZFfzLeVufYYZ1Sb9ye78mSd99vUc+FQFn7mo" +
       "+lPgsY5Vt/6MVP/Snc/BDkeednA0mPRywwpLl6nafaVMfj6BHixPAU90L8s+" +
       "f2aAL74RBvjQsQE+9MYY4OrhUkNlgJuV9MM0mSWRpXlV4392e+v9w4rgtTL5" +
       "pTtb4Zd/CCuUpxTQ0+D5xLEVPvHGWOG8g/+rO9R9tUx+Fei3shLxwmHDmX6/" +
       "9kPod3rs++lj/T79xuv3u3eo+70y+VoC3WvacRjEh5n90rnPwN9IoLt3gW2e" +
       "qfvbP4S618vC8p7HF47V/cIbOqtP/fk8LpVXHE+Oq//LHUzxzTL5RgI9BIa6" +
       "vKV1ODW5lUHuss+j3H94XcfaCfTwxdtI5anh4zfdcTzcyzO+9Mr1+x57Rfw3" +
       "1YWc07tz97PQfcvUdc+f857LXwsja2lXOt1/OPUNq7//mUCP3eZUP4GuHTKV" +
       "wP/jQP/dBLpxmT6B7qn+z9P9H/BtOKMDrA6Z8yR/DIwGSMrsn4S3OBM7HHfn" +
       "Vy5GCqcmfvT7mfhccPGuCyFBdcf05POd8sdnsF9+Zch96DutLxzuCxmuVhQl" +
       "l/tY6N7D1aXTEODp23I74XWNee57D3/l/nefhCsPHwQ+8+Nzsr3z1jdzel6Y" +
       "VHdpil9+7B+/8Pdf+f3qiO7/A7e2qfT8KwAA");
}
