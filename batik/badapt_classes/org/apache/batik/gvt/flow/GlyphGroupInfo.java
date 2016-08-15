package org.apache.batik.gvt.flow;
class GlyphGroupInfo {
    int start;
    int end;
    int glyphCount;
    int lastGlyphCount;
    boolean hideLast;
    float advance;
    float lastAdvance;
    int range;
    org.apache.batik.gvt.font.GVTGlyphVector gv;
    boolean[] hide;
    public GlyphGroupInfo(org.apache.batik.gvt.font.GVTGlyphVector gv, int start,
                          int end,
                          boolean[] glyphHide,
                          boolean glyphGroupHideLast,
                          float[] glyphPos,
                          float[] advAdj,
                          float[] lastAdvAdj,
                          boolean[] space) { super();
                                             this.gv = gv;
                                             this.start = start;
                                             this.end = end;
                                             this.hide = (new boolean[this.
                                                                        end -
                                                                        this.
                                                                          start +
                                                                        1]);
                                             this.hideLast =
                                               glyphGroupHideLast;
                                             java.lang.System.
                                               arraycopy(
                                                 glyphHide,
                                                 this.
                                                   start,
                                                 this.
                                                   hide,
                                                 0,
                                                 this.
                                                   hide.
                                                   length);
                                             float adv = glyphPos[2 *
                                                                    end +
                                                                    2] -
                                               glyphPos[2 *
                                                          start];
                                             float ladv =
                                               adv;
                                             adv += advAdj[end];
                                             int glyphCount =
                                               end -
                                               start +
                                               1;
                                             for (int g =
                                                    start;
                                                  g <
                                                    end;
                                                  g++) { if (glyphHide[g])
                                                             glyphCount--;
                                             }
                                             int lastGlyphCount =
                                               glyphCount;
                                             for (int g =
                                                    end; g >=
                                                           start;
                                                  g--) { ladv +=
                                                           lastAdvAdj[g];
                                                         if (!space[g])
                                                             break;
                                                         lastGlyphCount--;
                                             }
                                             if (hideLast)
                                                 lastGlyphCount--;
                                             this.glyphCount =
                                               glyphCount;
                                             this.lastGlyphCount =
                                               lastGlyphCount;
                                             this.advance =
                                               adv;
                                             this.lastAdvance =
                                               ladv; }
    public org.apache.batik.gvt.font.GVTGlyphVector getGlyphVector() {
        return gv;
    }
    public int getStart() { return start; }
    public int getEnd() { return end; }
    public int getGlyphCount() { return glyphCount; }
    public int getLastGlyphCount() { return lastGlyphCount;
    }
    public boolean[] getHide() { return hide; }
    public boolean getHideLast() { return hideLast; }
    public float getAdvance() { return advance; }
    public float getLastAdvance() { return lastAdvance; }
    public void setRange(int range) { this.range = range;
    }
    public int getRange() { return this.range; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALUaC5AcRbV375u73Df/3yW5XBISwi4gQcMBcjlyl4NNct4l" +
       "B15CLrOzfXeTzM4MM713e8HwszCR0lTEABHh1DIQxEAolAJLgVgUAQSpIqCA" +
       "FOCvAI0pSaFIgYrvdc/uzM7uTFzxtmp6Z7rf6/ft9173zOGTpMwySRPVWISN" +
       "GdSKrNFYt2RaNNGuSpa1EfoG5NtLpPe3vrt+VZiU95PaYclaJ0sW7VComrD6" +
       "yTxFs5ikydRaT2kCMbpNalFzRGKKrvWTaYrVlTRURVbYOj1BEaBPMmOkQWLM" +
       "VOIpRrvsCRiZFwNOopyTaJt3uDVGJsu6MeaAz3SBt7tGEDLp0LIYqY9tl0ak" +
       "aIopajSmWKw1bZIzDV0dG1J1FqFpFtmurrRVcFlsZZ4Kmh+s++DjfcP1XAVT" +
       "JE3TGRfP6qGWro7QRIzUOb1rVJq0ribXkpIYqXYBM9ISyxCNAtEoEM1I60AB" +
       "9zVUSyXbdS4Oy8xUbsjIECMLcycxJFNK2tN0c55hhkpmy86RQdoFWWmFlHki" +
       "3npmdP/tW+sfKiF1/aRO0XqRHRmYYECkHxRKk3FqWm2JBE30kwYNjN1LTUVS" +
       "lZ22pRstZUiTWArMn1ELdqYManKajq7AjiCbmZKZbmbFG+QOZT+VDarSEMg6" +
       "3ZFVSNiB/SBglQKMmYMS+J2NUrpD0RKMzPdiZGVsuRwAALUiSdmwniVVqknQ" +
       "QRqFi6iSNhTtBdfThgC0TAcHNBmZ7Tsp6tqQ5B3SEB1Aj/TAdYshgJrEFYEo" +
       "jEzzgvGZwEqzPVZy2efk+gv3XqOt1cIkBDwnqKwi/9WA1ORB6qGD1KSwDgTi" +
       "5OWx26Tpj+0JEwLA0zzAAuaRL526ZEXT0WcEzJwCMBvi26nMBuSD8doX57Yv" +
       "W1WCbFQauqWg8XMk56us2x5pTRsQYaZnZ8TBSGbwaM+xL15/Hz0RJlVdpFzW" +
       "1VQS/KhB1pOGolKzk2rUlBhNdJFJVEu08/EuUgH3MUWjonfD4KBFWRcpVXlX" +
       "uc6fQUWDMAWqqAruFW1Qz9wbEhvm92mD2L8yuBbY9/yfkc3RYT1Jo5IsaYqm" +
       "R7tNHeW3ohBx4qDb4WgcvH5H1NJTJrhgVDeHohL4wTC1B4ZGWHRQ1UejneqY" +
       "Mdxp6imjC5iIoJMZEzt9GqWbMhoKgeLnepe9Citmra4mqDkg70+tXnPqgYHn" +
       "hEvhMrD1wsgZQDEiKEY4xQhQjCDFSC5FEgpxQlORsrAu2GYHrHIIs5OX9V51" +
       "2bY9zSXgVsZoKSgWQZtz0k27Ewoy8XtAPtJYs3Phm+c8GSalMdIoySwlqZg9" +
       "2swhiEvyDnvpTo5DInLywQJXPsBEZuoyTUA48ssL9iyV+gg1sZ+Rqa4ZMtkK" +
       "12XUP1cU5J8cPTB6Q991Z4dJODcFIMkyiF6I3o2BOxugW7xLv9C8dbvf/eDI" +
       "bbt0Jwjk5JRMKszDRBmava7gVc+AvHyB9PDAY7tauNonQZBmEiwqiH9NXho5" +
       "MaY1E69RlkoQeFA3k5KKQxkdV7FhUx91eriPNvD7qeAW1bjoZsG1zF6F/B9H" +
       "pxvYzhA+jX7mkYLng4t6jbtefeFPn+HqzqSOOlfO76Ws1RWucLJGHpgaHLfd" +
       "aFIKcG8c6P7mrSd3b+Y+CxCLChFswbYdwhSYENR80zNXv/bWmwdfDjt+ziBf" +
       "p+JQ9qSzQmI/qQoQEqgtcfiBcKdCTECvadmkgX8qg4oUVykurH/WLT7n4b/s" +
       "rRd+oEJPxo1WnH4Cp3/WanL9c1v/0cSnCcmYbh2dOWAihk9xZm4zTWkM+Ujf" +
       "cHzet56W7oJsABHYUnZSHlQncR1M4pLP9A0m4F6Rzr6NPJ70UV4L5AQHXIC9" +
       "qbgFC1lJgt1G7IR2bvc2eU9L9x9FsppVAEHATbs3+vW+V7Y/z72iEkMF9iNP" +
       "Na5AACHF5ZL1wlqfwC8E17/xQithh0gMje12dlqQTU+GkQbOlwXUk7kCRHc1" +
       "vrXjznfvFwJ407cHmO7Zf/Mnkb37halFjbMor8xw44g6R4iDTStytzCICsfo" +
       "eOfIrp/eu2u34KoxN2OvgYL0/l//6/nIgd8+WyBdlCh2nXoe+n420k/NtY0Q" +
       "6NKv1v1sX2NJBwSZLlKZ0pSrU7Qr4Z4RSjQrFXcZy6mdeIdbNDQMI6HlYAPs" +
       "uCB3O5P1CO6xgv6W6mNPWN9/+yEhZyF/8xRQ9x6qlF9PHuP+hjRWZVd0ox22" +
       "KphY0OKfkSs/ZXZP6MloGzBiQua7VJdTSWTSrhwmbG70ksX+PuzS4Pg9i164" +
       "bnzR78AR+kmlYkEuhVVUoHx14bx3+K0Tx2vmPcBTSykuRtu2uXV/flmfU61z" +
       "/ddhExNx9XO2g+PfRa77NkYq4rquUknz+iU+dqYLeOvcnLqE72+d1HjfS5/9" +
       "1aFv3DYqvCZgrXvwZn60QY3f+PsP+aLJqwQKLH8Pfn/08J2z2y8+wfGdlIzY" +
       "Len8+g5M4eCee1/y7+Hm8qfCpKKf1Mv2frJPUlOY6PpB2VZmkwl7zpzx3P2Q" +
       "KP5bsyXHXG/8cZH1FgPuZV3KcpZwgzBkiPD0t5VjLOXtcmzO4pYJ422EwaSK" +
       "JqkcrxWSq0q1IVHHX4LNFwzHomGBl8k+Im+hHLCd0jWKKTAzJqpWRY9kt7Iw" +
       "WMg35uX4xjruko6i36i95Q8/aRlaXUy5in1NpylI8Xk+WHm5v7t5WXn6xj/P" +
       "3njx8LYiKs/5Hh/yTvmDdYef7Vwi3xLmu2XhAXm77Fyk1ly7V5mUpUwtN4Av" +
       "Etbn1hOmx+ZMbmD+fHbWDoTbQURfI2CML4sk+IqMhhZ+EQCeyuvFOmd+4Qpq" +
       "TdJgvObZ+eiMH194aPxNXuwZaVI4vmDbw4e6suliNtKYD9dSuwBcKtLFFZ8y" +
       "pANaEss13WyDO27uTLaYqKnFGtmAzTWnjcQQD3Qprz7wicP4fKWY1w4MNwUF" +
       "BmzEjrcVm3g2IlybHxHwMYHNYGGyiiDLsbHRAnznawFje7G5GRtLcBIAuy/f" +
       "B7EjHehYO7PN5fx5ZQCB/dgsttwbzNwg4jp6HJD3vfxeTd97j5/KS1e5+6l1" +
       "ktHqhPAlWDrM8B4ArJWsYYA77+j6LfXq0Y95sVAtyeBm1gYzQc10zu7Lhi6r" +
       "+M3Pn5y+7cUSEu4gVeA2iQ6Jb2TJJNhBUmtYVxNp4/OXiPUzWglNPReV5Anv" +
       "q1g+MId3Vgl3y92iTYFrob1CF3r3obZPjhf2SeLZ7ZUGTAXrAoKlyXduF2Az" +
       "hePeis13xDwHfAX9H1i+B5vvQq1OtUQhmoeKpLkIrmabZrMPzR86gf17+Zrx" +
       "w2akagg3he16SiuonsMTwOpD2NzPSK0qWawzkPyPiiQ/zWYhw0oh8o8EasoP" +
       "m5HKYSVBY5I4AOjxMPpokYxibmqxSbX4MPp4IKN+2FCOS4mRTN1znYfPJyaA" +
       "z6ewOcpINdqzzZ/2sSJp18K12Ka92If2LwJ15IcNAcGEKpUWcrnniuRyOlxL" +
       "bDpLfLh8MZBLP2xGwkMjeHe+h8XjRbKINzmFUAEWXw1k0Q+bkVJcFXh/uYfJ" +
       "1wKYTBcilv0tcP+7iLmyCcE8OM/vFQ4/ZDl44/7xxIa7z8mcJaxmkNh04yyV" +
       "jlDVNVW1KEhyS8cz4Oqx2ejxaswRVNTR+ceOfqgBxcOJgLGT2LwNAXOIMtcZ" +
       "HncNR+HvnM4r/puU7VEGZjsyB65NtkSbileGH2qAwB8GjH2EzfsQjkEZvdms" +
       "7qjhbxOlBjw0v8KW5Yri1eCH6i9qqCxgrAIb2NGUgxrW2GVGVgmh0EQpYQFc" +
       "W2xJthSvBD/UAEEbA8amYlPDSE1mYTiFhKOL2onSBebDuC1QvHhd+KEGyDs/" +
       "YGwhNrMZaQBdxPILK0cfcyZAH5gEyTy4ErZQieL14YcaIPOKgDHcr4aWQjUE" +
       "+libyVGOFs6YKK9ogmvYFmW4eC34oQZIuipgDLfqofOgNrO1kK1fHU2snChN" +
       "oD8kbXGSxWvCDzVA2o6AsbXYtOGGh+YUqY4iVk+UInCfmLKlSRWvCD/UAGF7" +
       "A8Y2YbNeVBMxT8XuKGPDBCiDv3vGjdWoLdFo8crwQ/UI7DrIuYBLvS1AI3iU" +
       "FdoMJYVFWQ/uCziU52itdERXEo5+tkyAfupwbAafQvzSxevHDzVA/IBDsxAW" +
       "maEdotrqyW6ZHDWo/w81pMEZc791wdPhmXnf0Ylvv+QHxusqZ4xvekW84Mp8" +
       "nzU5RioHU6rqfgniui83TDqocAVOFudp/DVmaCcjs3y/wAGr4x/yHRoT8LsY" +
       "mVoInpESaN2Q1zNS74WEjSf/d8N9GWKSAwcVnbhxg3wFZgcQvN0trDUTJnfe" +
       "toi3RmlxtjrHrW1eEk87nZFcm6pFOWeX/IvHzMuKlPjmcUA+Mn7Z+mtOnX+3" +
       "+AhEVqWd/IS0OkYqxPcofFJ84bHQd7bMXOVrl31c++CkxZltWoNg2HH0OY43" +
       "olOHDPSN2Z4vJKyW7IcSrx288PFf7ik/HiahzSQkMTJlc/77tbSRgv3j5lj+" +
       "W/M+yeSfbrQuu2Ps4hWDf32dv3wgee8tvfAD8suHrnrplpkHm8KkuouUwQ6U" +
       "pvmLv0vHtB4qj5j9pEax1qSBRZhFkdScV/K16MYSfgvJ9WKrsybbi58QMdKc" +
       "/zVC/odXVeCx1FwNlR/fFdTESLXTIyzjeWeUMgwPgtNjmxLbDhEQ0RrgjwOx" +
       "dYaR+Vijqt/ga7mzUADmJ+mhO/gt3n37P+nLjF8NLQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JWSTpMZEDUvoG/Watq2npq63462B9dtR");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("QoZeGDjBGgQF43XiJ4uUbS2CrUttq1sy7jY2q+aqE+Byhmy47kyyiLXGqTw8" +
       "RloTkTPM7agjjMNopyh2s81OtLEK53wP9rUlr/cyhEhpZwYbhDbHOWo5H+7y" +
       "lS7oi4mZMmZMr9zCRFk4W52F5iqdZpoozyDeXm1i2JRRN19gfXcEudYUNuO6" +
       "V0cZyKNWRJumWAwrXj/9pzf3Wuwd5RvAo+OlKwctCr7zJt58ZXd6y3n0wvTo" +
       "98zJ/xMvTE9sP1WKDbIn73SEtDwg8/XPvva6Nv0Z5OLBm9ROXHko9oM/5+hb" +
       "3TnR1MP7vcfT+74fAtfsgI3Z2fe2x6hvgXOhlN9eGOdsIf7gnLL/VSTfiyuP" +
       "mHp84oxT+Tb6WNS/f7eXjCebPYOw2BirvA9ciwOEi7ce4R+fU/YnRfKHceUy" +
       "QMgd7fYdY/uje8VWnAgUDrAJbzm2C5fPKbtSJJfiygMAG36wd3iE7MJ994qs" +
       "mBKfPED2ybce2WPnlD1eJFfjytsP9fJ4y+8Y4LV7BVjsaCkHAJW3HuAz55Q9" +
       "VyTvA7YOAKRu3dc8Bvn+ewBZ7E1VngSXdgBSe+tBfuScshtF8sG48iAASR7u" +
       "Kx1D+9C9jt9T4LIOoFlvPbT2OWV/vkjqceXhA2hHG8DH8Br3Cq8YOfcAnvvW" +
       "w+ufU1bsGl34eHEMQD+1dXuM7hP3iq44JZEcoEveenTMOWWzIhnvvR51ZnP6" +
       "GCF1DwjLs+LFiYL0AGH61iC8cEzQLJk852jaheJo2gUBuL5Ij2fFfvdtNxW3" +
       "vq0dg17eA+irRea7S9L9L3vrh3V9TplbJMbe1c+O9vePsZlvBlsG1OP0JxnF" +
       "+fL33PK51/4TJfVbr1+9/O7XF/9uf/748DOih6jKZSNxnJMnQk/cPxCEumGX" +
       "mB/an8cKSkbjuPLeO34oAoas+CsYvhDt6UHeY7ejjyuXQHqSMo8r185SxpX7" +
       "y/+TdC+DqX9MByKM/c1JkldA64CkuH11f+jt9Ob8/ghttj9t956TGlNCffRu" +
       "g3Ei9n7+1Nm38sO8w3Ojyf7TvJvqt18f0Z/5Yetn9p9XqI6c50Url6nKg/sv" +
       "PcpGi7Onz96xtcO2HiBf/NEjP/fQC4fR/CN7ho+19wRvT9/+WwbcDeLy64P8" +
       "F9/9jz76d1//nfKswP8DWXwmFDE5AAA=");
}
