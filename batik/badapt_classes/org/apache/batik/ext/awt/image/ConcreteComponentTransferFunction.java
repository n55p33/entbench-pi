package org.apache.batik.ext.awt.image;
public class ConcreteComponentTransferFunction implements org.apache.batik.ext.awt.image.ComponentTransferFunction {
    private int type;
    private float slope;
    private float[] tableValues;
    private float intercept;
    private float amplitude;
    private float exponent;
    private float offset;
    private ConcreteComponentTransferFunction() { super(); }
    public static org.apache.batik.ext.awt.image.ComponentTransferFunction getIdentityTransfer() {
        org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction f =
          new org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction(
          );
        f.
          type =
          IDENTITY;
        return f;
    }
    public static org.apache.batik.ext.awt.image.ComponentTransferFunction getTableTransfer(float[] tableValues) {
        org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction f =
          new org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction(
          );
        f.
          type =
          TABLE;
        if (tableValues ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (tableValues.
              length <
              2) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        f.
          tableValues =
          (new float[tableValues.
                       length]);
        java.lang.System.
          arraycopy(
            tableValues,
            0,
            f.
              tableValues,
            0,
            tableValues.
              length);
        return f;
    }
    public static org.apache.batik.ext.awt.image.ComponentTransferFunction getDiscreteTransfer(float[] tableValues) {
        org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction f =
          new org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction(
          );
        f.
          type =
          DISCRETE;
        if (tableValues ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (tableValues.
              length <
              2) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        f.
          tableValues =
          (new float[tableValues.
                       length]);
        java.lang.System.
          arraycopy(
            tableValues,
            0,
            f.
              tableValues,
            0,
            tableValues.
              length);
        return f;
    }
    public static org.apache.batik.ext.awt.image.ComponentTransferFunction getLinearTransfer(float slope,
                                                                                             float intercept) {
        org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction f =
          new org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction(
          );
        f.
          type =
          LINEAR;
        f.
          slope =
          slope;
        f.
          intercept =
          intercept;
        return f;
    }
    public static org.apache.batik.ext.awt.image.ComponentTransferFunction getGammaTransfer(float amplitude,
                                                                                            float exponent,
                                                                                            float offset) {
        org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction f =
          new org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction(
          );
        f.
          type =
          GAMMA;
        f.
          amplitude =
          amplitude;
        f.
          exponent =
          exponent;
        f.
          offset =
          offset;
        return f;
    }
    public int getType() { return type; }
    public float getSlope() { return slope;
    }
    public float[] getTableValues() { return tableValues;
    }
    public float getIntercept() { return intercept;
    }
    public float getAmplitude() { return amplitude;
    }
    public float getExponent() { return exponent;
    }
    public float getOffset() { return offset;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVaDXAdVRW+76VN0vw0P/0LbZM2fzD9ew8qFTAVSEN/Ul/b" +
       "0IQiKSXd7Lsv2Wbf7rJ7X/MSqPzMaKOjpdZSEGln1GILFMp0ZJRRoA5jgQFx" +
       "gAoiAoqMIpWx1RFRFDzn3n1v9+17u51oM2Zm79vsPefcc7577jnn3t0j75PJ" +
       "lkkaqMYibMSgVmSlxrok06LxDlWyrB541iffVST99YZ3118WJsW9ZOqgZK2T" +
       "JYuuUqgat3pJvaJZTNJkaq2nNI4cXSa1qLldYoqu9ZIZitWZNFRFVtg6PU6R" +
       "YJNkxkiNxJip9KcY7bQFMFIfA02iXJNou7e7LUYqZN0YccjrXOQdrh6kTDpj" +
       "WYxUx7ZJ26VoiilqNKZYrC1tkkWGro4MqDqL0DSLbFOX2RCsjS3Lg6DpkaoP" +
       "Pto9WM0hmCZpms64edZGaunqdhqPkSrn6UqVJq0byRdIUYyUu4gZaYllBo3C" +
       "oFEYNGOtQwXaV1ItlezQuTksI6nYkFEhRhpzhRiSKSVtMV1cZ5BQymzbOTNY" +
       "Oz9rrbAyz8Q7F0X33nVD9bEiUtVLqhStG9WRQQkGg/QCoDTZT02rPR6n8V5S" +
       "o8Fkd1NTkVRl1J7pWksZ0CSWgunPwIIPUwY1+ZgOVjCPYJuZkpluZs1LcIey" +
       "/5ucUKUBsHWmY6uwcBU+BwPLFFDMTEjgdzbLpCFFizMyz8uRtbHlc0AArCVJ" +
       "ygb17FCTNAkekFrhIqqkDUS7wfW0ASCdrIMDmozM9hWKWBuSPCQN0D70SA9d" +
       "l+gCqikcCGRhZIaXjEuCWZrtmSXX/Ly/fvmum7Q1WpiEQOc4lVXUvxyYGjxM" +
       "G2mCmhTWgWCsWBjbJ818fCxMCBDP8BALmh/cfObKxQ3HnxE0cwrQbOjfRmXW" +
       "Jx/sn/ri3I4FlxWhGqWGbik4+TmW81XWZfe0pQ2IMDOzErEzkuk8vvHEdbc+" +
       "QE+FSVknKZZ1NZUEP6qR9aShqNRcTTVqSozGO8kUqsU7eH8nKYH7mKJR8XRD" +
       "ImFR1kkmqfxRsc7/B4gSIAIhKoN7RUvomXtDYoP8Pm0QQkrgIt1wNRDxx38Z" +
       "saKDepJGJVnSFE2Pdpk62m9FIeL0A7aD0X7w+qGopadMcMGobg5EJfCDQWp3" +
       "4MqUhllUScL0Q3TSZJMy2gGW6RrI6DElzYJpWpXSZEQigs5n/H+GTSMa04ZD" +
       "IZioud4wocIKW6OrcWr2yXtTK1aeebjvOeGCuGxsHBm5EjSJCE0iXBMeVEGT" +
       "CNckclZNSCjEFZiOGgkvgTkegmgB4bpiQfeWtVvHmorAPY3hSTBBSNqUk7Y6" +
       "nJCSyQN98tHaytHGNy96KkwmxUitJLOUpGIWajcHIL7JQ3YIqOiHhObklfmu" +
       "vIIJ0dRlGoew5pdfbCml+nZq4nNGprskZLIeru+of84pqD85fvfwbZtuuTBM" +
       "wrmpBIecDFEQ2bswAWQDfYs3hBSSW7Xz3Q+O7tuhO8EkJzdlUmoeJ9rQ5HUR" +
       "Lzx98sL50qN9j+9o4bBPgWDPJFicEEcbvGPkxKq2TNxHW0rB4IRuJiUVuzIY" +
       "l7FBUx92nnDfreH308EtKnDxLoFrkb2a+S/2zjSwnSV8Hf3MYwXPK5/tNvb/" +
       "8oU/forDnUlBVa7aoZuyNlfYQ2G1PMDVOG7bY1IKdG/c3fWNO9/fuZn7LFA0" +
       "FxqwBVtcEzCFAPMXn7nxtbfePHgy7Pg5IyWGqUAxRdNZK7GDlAdYCcOd7ygE" +
       "cVOlfJFZLddo4KBKQpH6VYor619VrRc9+qdd1cIRVHiS8aPFZxfgPD9vBbn1" +
       "uRv+3sDFhGTM2w5oDplIBtMcye2mKY2gHunbXqr/5tPSfkgrEMotZZTy6Ew4" +
       "CITP2jJu/4W8vdjTdwk2rZbb+3MXmKu+6pN3nzxduen0E2e4trkFmnuy10lG" +
       "m/AvbM5Pg/hZ3ui0RrIGge7i4+uvr1aPfwQSe0GiDLHZ2mBC0EznuIZNPbnk" +
       "Vz95aubWF4tIeBUpU3Upvkriq4xMAfem1iDE27RxxZVicodLoanmppI84/Me" +
       "IMDzCk/dyqTBONijP5z1/eWHDrzJ3cwQMuZw/hJMATlhlZf5zsp+4OVLfnHo" +
       "6/uGRaGwwD+cefjq/rlB7b/97Q/zIOeBrEAR4+HvjR65d3bH5ac4vxNRkLsl" +
       "nZ+2ICo7vEsfSP4t3FT80zAp6SXVsl1Wb5LUFK7TXiglrUytDaV3Tn9uWShq" +
       "oLZsxJzrjWauYb2xzEmXcI/UeF9ZKHzNgGuevbDnecNXiPCbTs5yATaL8sOC" +
       "HzcTI+emTkxP3al+C9KckoSott0uG5d2bZXHWrreETN9XgEGQTfjcPRrm17d" +
       "9jyPmaWYSHsy1rnSJCRcV8CuFjp/An8huD7GC3XFB6L8qu2wa8D52SIQPTXQ" +
       "5TwGRHfUvjV077sPCQO8/uUhpmN7v/JJZNdeEQfFTqI5r5h384jdhDAHm6tR" +
       "u8agUTjHqj8c3fGjwzt2Cq1qc+vilbDte+iVfz8fufs3zxYosooUezeICz6U" +
       "rYOm586NMOiqL1f9eHdt0SpIwZ2kNKUpN6ZoZzzXD0usVL9rspwdiuObtmk4" +
       "MYyEFsIciASK7aXYrBXho803WnXkencdXPNt/5zv491SoHf7cTMy2VJ1uzBY" +
       "b08J/nS77q9luCx1KQ9H/HeL17j+cRqHKjXa6jX6GJcMNM6Pm5FyhimXRyUr" +
       "98wmuyB5NhXTf335iSet7/7+mHCzQsvds0s8fKhUfj15gi93HHFDVrfZmVBy" +
       "ga3bBWKJXvs/blWALYm1gW62w53k3gVNlGhcoq3+AcSF34HvNb9wy4Hm3/KE" +
       "XqpYENkhhBXYobt4Th9569RLlfUP86p3EkZCe2HlHm3kn1zkHEhw9KuwSfHb" +
       "RN6K544nCGyfuln4FG8XYrOEk4YZKTZS/aoio9crmqRyiVfDY5VqA2IbvAmb" +
       "UcOpJMKCl/9fx+xqDfNfpEOFrRt6YaZPbNYUPZI9CYLOdIEQVZ9TU6zj5joJ" +
       "+o2pe373WMvAivHs0vBZw1n2Yfj/PJizhf5T7lXl6dvfm91z+eDWcWy45nk8" +
       "wivy/nVHnl19vrwnzA+bROWQd0iVy9SWG6fLYOecMrXcyNzsuMho4ennMe0W" +
       "MeUBtfPugL492HwVvEfGqReeEkB+Z345ig/aDVflGhRvtXHG27lwNdlRqckn" +
       "3t4TGG/9uBmZwpepTA2+I0p4NP3Wf6Fpsz1Ws4+m3w7U1I8bNJXwfJ2lhMN7" +
       "Nf3OODWdA1eLPVaLj6aHAzX142akFHZ1/PSnkKL3j1PR8+BqtYdq9VH0aKCi" +
       "ftwsc4pYSM1HAtRMO8Ptyg7H/4qJ54TRNZxr/xXKRNZLz3qe5nOOhimu3u8U" +
       "mVegB2/feyC+4b6LMpn+8+BBTDeWqHQ7VV26VPD7sawdi1HtK+Baatux1Au6" +
       "g1R+KuKxCIC1+GsFz1lGTYDUgHBzIqDvGWyehPQ1QFlnHIBS2EgGK+x6zJnR" +
       "42dzvOANt4hwHrBQBK91l9tmLR83WNg8VQCoNltiWzBQrjjL+GAnA9B6BZsX" +
       "GKkGtHowiftA9fOJggqjTo9tWM85g6rbltg9TqjeDoDqHWx+LRzrKsXip9o+" +
       "aL0xUWhh6FNt29RzhtaQLXEoGK2wI4rHxgQf8XQAZH/B5j1GagAyfHEjmT6A" +
       "nZrIlThimzdyzgBL2xLTwYAVcVFFDmAOah/7oxbiEj8Ua3K1lExKPqD9YwJA" +
       "q8K+mXCN2SaOBYCGza5cdMoCWANMLg/oq8SmmJESDFF2JdyVRSFUMgEo4Bzz" +
       "tXaHbcod40fBjzXA0rqAvtnYTINKClDoxtMO7ksODNMnAIZp2IcHEvtsW/aN" +
       "HwY/1gBTWwP6cJjQfEamZvKVOBdBUuaA0ThRPlEP137bov3jB8OPNcDgpQF9" +
       "F2OzhJEKLHVyNi0OFJGJhOKgbc/B8UPhxxpg7hUBfe3YfEZA0Z6zK3KgaJso" +
       "KHCP96Btz4Pjh8KPNcDcWEAfnoCGVjNSDlCsdG+7HCTWTBQSeGR4zDbn2PiR" +
       "8GMNsPa6gL7N2PTALgeQ2ODs6xwcrjkXOKQZaTzrVw74dq4u70ss8fWQ/PCB" +
       "qtJZB655VZwfZr7wqYiR0kRKVd3vj1z3xYZJEwoHtUK8TeJH9PgOtiF4D8nI" +
       "ZP6LBoX6BVeCkTo/LkaKoHVTK4xML0QNlNC6KVUoY7yUMD7/ddPpjJQ5dLBd" +
       "FDduEhOkAwneWsL5YLtc7RxSipd0abGTnuOeNF4tzTjbXGdZ3K/sEQL+nV3m" +
       "jC8lvrTrk48eWLv+pjOfvk98MiCr0ugoSimPkRLx9QIXiueEjb7SMrKK1yz4" +
       "aOojU1ozO/MaobCzYOY4Xk3aYcdioD/N9rxOt1qyb9VfO7j8iZ+NFb8UJqHN" +
       "JCTBpmVz/uvMtJEySf3mWP5bpE2Syd/zty24Z+TyxYk/v85fGBNxpDvXn75P" +
       "Pnloy8t76g42hEl5J7iZFqdp/p71qhFtI5W3m72kUrFWpkFF3JlLas4rqqno" +
       "+hJ+gcdxseGszD7FD04Yacp/O5f/mU6Zqg9Tc4We0uIopjJGyp0nYmY8R60p" +
       "w/AwOE/sqcT2emyu5oU/+GNfbJ1hZF5eTllm8JCwJRspvEeeoS/xW7zb+R8+" +
       "o3SbgysAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "M5Xze+/bhzF0R+z5P2Jra80+IstuPSo8");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("wPHBXOwPg6O6h6N68rXsoaauX8c51PlbriV89Yy6f54Xvx5D9xlaPFABfjPe" +
       "7qsgr/rKoaH+yVu9Rjw69gmsedNi1fS5PazP3USs5w7fUu/Wx752BuDfz4t/" +
       "EUNXAGAuX5s6Be2/fLdo82UAbg8t9xeJ9htnoP3DvPh3O/P2zKjYf3YK4H//" +
       "bgHnKwz2HmD7JgI+f9iqWHCYFa3++AzU/zUv/ggQEECd75KUwlMwf/NmuPR2" +
       "D/P2JmK+5ZBYZyeA/+kZwP8sL/77zrlxyXGkU3D/j3eB+3J+8X5wvLSH+6V3" +
       "gPvtrX6eu/WMugv5xe/H0O15AO8tvg4OoJ2D3gW0e/bd+LN70D5786FdOaPu" +
       "3ry4M4YuAmhsvjGksPohtrveBbb78ov5HpBX9rC9cvOxPXxG3aN58UAM3b3P" +
       "u7vNJAWNHSJ88N1a7xFwvLqH8NWbj/CHz6h7Ji+eiqG78qn02Dr3Ib6rNwPf" +
       "63v4Xr/5+Opn1DXzAt7h6xxbMD/EV363+PI1/V/Yw/cLNx/f82fUoXnxbAzd" +
       "CfBhR1feD+E9927h5TuRvrwH78s3Hx51Rh2dFzjITQG88eES/iE44p2AS2Po" +
       "ibfc0J5vzn3wuj/d7P4oonzxtcsXH3ht9q92O732/8xxBwVd1BPbPrqX8sj5" +
       "BT/U9J0e7tjtrPQLcLMYevTsDD+Gbiu+cyTnuF2veQw9eFqvGLoFlEdbfySG" +
       "3nuj1qAlKI+2/CiYgU+2BPcvvo+2k2Lo0mG7GLqwOznaRAWjgyb5qbbb5HN8" +
       "e8Nuw2q6e8558KjnFRP9vW9l04MuRzeU5yoo/lK1v3kq2f2p6gXlS6+R9Me/" +
       "2/yZ3YZ2xZayLB/lIgXdvttbXwyab8B64tTR9se6QHzge3f/0h1P7z833b0T" +
       "+DAKjsj22I03j2OOHxfbvbNffeAfPPezr/1Bsdvi/wG1MKOn6zYAAA==");
}
