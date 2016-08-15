package org.apache.batik.gvt.flow;
public class BlockInfo {
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
    protected java.util.List fontList;
    protected java.util.Map fontAttrs;
    protected float ascent = -1;
    protected float descent = -1;
    protected boolean flowRegionBreak;
    public BlockInfo(float top, float right, float bottom, float left, float indent,
                     int alignment,
                     float lineHeight,
                     java.util.List fontList,
                     java.util.Map fontAttrs,
                     boolean flowRegionBreak) { super();
                                                this.top = top;
                                                this.right = right;
                                                this.bottom = bottom;
                                                this.left = left;
                                                this.indent = indent;
                                                this.alignment = alignment;
                                                this.lineHeight =
                                                  lineHeight;
                                                this.fontList = fontList;
                                                this.fontAttrs = fontAttrs;
                                                this.flowRegionBreak =
                                                  flowRegionBreak;
    }
    public BlockInfo(float margin, int alignment) { super();
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
    public void initLineInfo(java.awt.font.FontRenderContext frc) {
        float fontSize =
          12;
        java.lang.Float fsFloat =
          (java.lang.Float)
            fontAttrs.
            get(
              java.awt.font.TextAttribute.
                SIZE);
        if (fsFloat !=
              null)
            fontSize =
              fsFloat.
                floatValue(
                  );
        java.util.Iterator i =
          fontList.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.gvt.font.GVTFont font =
              (org.apache.batik.gvt.font.GVTFont)
                i.
                next(
                  );
            org.apache.batik.gvt.font.GVTLineMetrics lm =
              font.
              getLineMetrics(
                "",
                frc);
            this.
              ascent =
              lm.
                getAscent(
                  );
            this.
              descent =
              lm.
                getDescent(
                  );
            break;
        }
        if (ascent ==
              -1) {
            ascent =
              fontSize *
                0.8F;
            descent =
              fontSize *
                0.2F;
        }
    }
    public float getTopMargin() { return top; }
    public float getRightMargin() { return right; }
    public float getBottomMargin() { return bottom; }
    public float getLeftMargin() { return left; }
    public float getIndent() { return indent; }
    public int getTextAlignment() { return alignment; }
    public float getLineHeight() { return lineHeight; }
    public java.util.List getFontList() { return fontList; }
    public java.util.Map getFontAttrs() { return fontAttrs; }
    public float getAscent() { return ascent; }
    public float getDescent() { return descent; }
    public boolean isFlowRegionBreak() { return flowRegionBreak; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVbDXAV1RW+7wVCSMgv8iOY8BdAQN4rCFWMVUNIIPYRYgJM" +
                                                              "DUjY7LvvZcm+3WX3vuQRxKIzCrbVWsWfWmQ6LRa1KE7Hn9pWBsfaarWd8af1" +
                                                              "b7T0Z6a01lqno+3U/p1z7763+/a9XfrSJjN7s7n3nnvO+e65555z7+b4+2Si" +
                                                              "ZZImqrEI22NQK9KusW7JtGi8TZUsazPU9ct3l0l/2XGma02YlPeRmkHJ2ihL" +
                                                              "Fu1QqBq3+kijollM0mRqdVEaR4puk1rUHJaYomt9ZJpidaYMVZEVtlGPU+yw" +
                                                              "VTJjpF5izFQG0ox22gMw0hgDSaJckmirt7klRqbIurHH6T7T1b3N1YI9Uw4v" +
                                                              "i5G62C5pWIqmmaJGY4rFWjImWWbo6p6kqrMIzbDILnW1DcGVsdUFEMx/tPbj" +
                                                              "T24brOMQTJU0TWdcPauHWro6TOMxUuvUtqs0Ze0m15GyGKlydWakOZZlGgWm" +
                                                              "UWCa1dbpBdJXUy2datO5Oiw7Urkho0CMzMsfxJBMKWUP081lhhEqmK07JwZt" +
                                                              "5+a0FVoWqHjnsuihu3fUfaeM1PaRWkXrRXFkEIIBkz4AlKYGqGm1xuM03kfq" +
                                                              "NZjsXmoqkqqM2jPdYClJTWJpmP4sLFiZNqjJeTpYwTyCbmZaZrqZUy/BDcr+" +
                                                              "a2JClZKg63RHV6FhB9aDgpUKCGYmJLA7m2TCkKLFGZnjpcjp2PxZ6ACkk1KU" +
                                                              "Deo5VhM0CSpIgzARVdKS0V4wPS0JXSfqYIAmI7N8B0WsDUkekpK0Hy3S069b" +
                                                              "NEGvyRwIJGFkmrcbHwlmaZZnllzz837Xpbfu1TZoYRICmeNUVlH+KiBq8hD1" +
                                                              "0AQ1KawDQThlaewuafrTB8OEQOdpns6iz5PXfnjFBU2nnhd9Zhfps2lgF5VZ" +
                                                              "v3x0oObl89qWrClDMSoM3VJw8vM056us225pyRjgYabnRsTGSLbxVM+Prt7/" +
                                                              "EH0vTCo7Sbmsq+kU2FG9rKcMRaXmeqpRU2I03kkmUy3exts7ySR4jykaFbWb" +
                                                              "EgmLsk4yQeVV5Tr/GyBKwBAIUSW8K1pCz74bEhvk7xmDEDIJHjIFnvlE/PDf" +
                                                              "jGyNDuopGpVkSVM0Pdpt6qi/FQWPMwDYDkYHwOqHopaeNsEEo7qZjEpgB4PU" +
                                                              "bkgOs2hC1Ueia1VdHuoE/hG0L2PcRs6gTlNHQiGA+zzvYldhnWzQ1Tg1++VD" +
                                                              "6bXtHz7S/6IwJDR+Gw1GFgCziGAW4cwiwCyCzCI5ZiQU4jzOQaZiOmEyhmBZ" +
                                                              "g1+dsqT3mit3HpxfBnZkjEwAJMPQdX7e/tLmrP2sw+6XTzRUj857d8WzYTIh" +
                                                              "RhokmaUlFbeLVjMJjkgestfqlAHYeZwNYK5rA8Cdy9RlGgf/47cR2KNU6MPU" +
                                                              "xHpGznGNkN2ecCFG/TeHovKTU/eMXL/1858Kk3C+z0eWE8FdIXk3euqcR272" +
                                                              "rvVi49YeOPPxibv26c6qz9tEsntfASXqMN9rBV54+uWlc6XH+5/e18xhnwxe" +
                                                              "mUmwisDhNXl55DmVlqyDRl0qQOGEbqYkFZuyGFeyQVMfcWq4edbz93PALKpw" +
                                                              "leHLJfay47+xdbqB5QxhzmhnHi34BvCZXuO+N372+ws53Nm9ota1yfdS1uLy" +
                                                              "TzhYA/dE9Y7ZbjYphX7v3NN9x53vH9jGbRZ6LCjGsBnLNvBLMIUA843P737z" +
                                                              "l+8efS2cs/MQgw06PQBxTianJNaTygAlgdsiRx7wbyp4ArSa5i0a2KeSUKQB" +
                                                              "leLC+kftwhWP//HWOmEHKtRkzeiCsw/g1J+7lux/ccdfm/gwIRn3Vwczp5tw" +
                                                              "2lOdkVtNU9qDcmSuf6Xxqz+W7gP3Dy7XUkYp96KVHIPK/LWO66k3PWDBulRS" +
                                                              "MA3D9oa0snunfLC5+7diszm3CIHoN+2B6C1bX9/1Ep/kClz5WI96V7vWNXgI" +
                                                              "l4XVCfD/DT8heP6FD4KOFcKxN7TZu8vc3PZiGBmQfElAPJivQHRfwy+HDp95" +
                                                              "WCjg3X49nenBQ1/4d+TWQ2LmRIyyoCBMcNOIOEWog8UalG5eEBdO0fG7E/u+" +
                                                              "/8C+A0Kqhvwdtx0Cyod/8c+XIvecfqGI44clpEsi0lyFxixMGldf/uwIldbd" +
                                                              "XPuD2xrKOsBrdJKKtKbsTtPOuHtMCLKs9IBrupzoh1e4lcOpYSS0FGYBKy72" +
                                                              "FFyoT9s44K8W1/vljJQpWoHg+Ge7GA10aCxiYT3SCI+t+uXti+umN6/5y3x7" +
                                                              "Mov0dQVht37/e319i+tk0bmYrXuCrweOVchvp37EbR3luSjnHGrQHBvgedB2" +
                                                              "Dg8K+9z+P4YHQAbZABgHxLGblRSNYzaCgtrhx7iOj5Y6I2+3d4D+9pDa+sHF" +
                                                              "3/qMwG6ez2pz+j911emX7xs9cVyYKy5/Rpb55U+FSRvugAsDdnFnUj9af8mp" +
                                                              "3/9m6zXZOarBolsY2ExGatyBjvC7nytucLw2lj/D9fCctmf4dNb9X8Xdf48g" +
                                                              "6MVie45dtcNuo8T77QjgFrAwJg3oukolrTg113Q1b/tUrgfhPQQKSSwWWu44" +
                                                              "JR9EV8raL9/22p+rt/755Id8svJzXve2DBoJx1aPxSJuLt44coNkDUK/Vae6" +
                                                              "tteppz6BEftgRBmM0dpkQgSbydvE7d4TJ731zLPTd75cRsIdpBKcWbxD4vEQ" +
                                                              "mQyBCLUGIfjNGJdfISZipAKKOq4qKVC+oAL3wjnFd9n2lMH4vjj63RmPXXrs" +
                                                              "yLs8IDD4EI2FwU6XbQhdxYMdLBdjsawwhPAj9cxgWATdOfe5ng89EjDPe7AQ" +
                                                              "oTFPiywBwNAYscKK3YZomM0r6zAhyfMJ/OjICUIfevWinx/7yl0jwjEEbMMe" +
                                                              "upl/36QO3PDrvxXYHI+5i+zMHvq+6PHDs9oue4/TO8EvUjdnCpMoSCAc2pUP" +
                                                              "pT4Kzy9/Lkwm9ZE62T6q2SqpaQwp+0ilYmXPb2KkOq89/6hB5NUtueD+PG9o" +
                                                              "4GLrDbvd++0Elre3OpH2TJyX5fAssC1ogdf4eDonlhSKFOnUGE1Ss+HXXz/6" +
                                                              "1+sPXBzGUG/iMIoOqNQ5/brSeCJ00/E7G6sOnf4it/zs0DcKW+blUiyWc1Mo" +
                                                              "w9cIRMoWP1zCuEPRJNUTMc8IEJaRqtZY5/qu/t7NrT2buYU7a4fb701ns9/P" +
                                                              "F0LTbHNrLgINvhzI+s3bg/TC4ktY3FJEIT8WjEwRCm3sXLcu1l5MozvGoNFC" +
                                                              "m93CAI24l/jamDXyY8HIZKFRe9e6YuocHoM6i2xeiwLU4SIfHbM6fiwYqRTq" +
                                                              "dGyJxYrpc/9/rw+PCGbBc77N7PwCfQh/ebi4GpBkTjZMnYHHoHGPDtUBw0KU" +
                                                              "zHQjtym4hH+kROHPg2eJzWWJj/BPOBvZo4Uy+lGDMzCV5CArJuWTJUrZCM9S" +
                                                              "m89SHymfDpTSjxp814DOmJ4qJubJEsWcDc8ym9EyHzF/GCimHzUjE1SaKIrl" +
                                                              "c2PAcrnNZrmPkC8GCulHDVhC2gqRQTExXypRzLnwRG1GUR8xXwkU048a1pyk" +
                                                              "KkktZUvqXf+vlijpPHhW2LxW+Ej6ZqCkftTgqvAQfAP1W0dvlSjqHHhW2sxW" +
                                                              "+oh6OlBUP2pGKhIQcGUTqk0eQX81htm/0GZ1oY+gvwsU1I8aZh8FxdtITrTN" +
                                                              "I+mZMUi6yua1ykfSPwVK6kcNy0myZJ/l9MEYjHS1zWi1j5gfBYrpRw2JaZz6" +
                                                              "yvlxiXLibn2RzekiHzn/ESinHzUkrnjx0UOTkFKsNanE7yAkj7z/DJA3Uyyh" +
                                                              "4z/lxHPf5OLrypwI5seNfleC/NDv6A2HjsQ33b8ie3ZxBdgrbPXLVTpMVddQ" +
                                                              "NfnnYJCEbeSXoE5G807N7b95qjm5tpQbGKxrOssdC/49BxKHpf55nVeUH9/w" +
                                                              "h1mbLxvcWcJlyhwPSt4hH9x4/IX1i+Tbw/zGV6RaBTfF+UQt+QlWpUlZ2tTy" +
                                                              "jzAX5Of4i+HZYs/rFq81Opbjl+P7kXqyd9c5zsU4amiqf3ofmoZFDViFRdlG" +
                                                              "yUwqAkXPWdGEYV2J56w6VPv/OAPA+lBlPkDoXbfbWm4vHSA/0uIA8b9nMvvs" +
                                                              "RhphEfTkkQ4oeigEHqb9cQPHaUEAhihOqAkyNUVTGL95FtfJoRkOZHPGAbKp" +
                                                              "2IZ7sGHrncuv/3vI/EgD1F0Z0LYKi+UARZKyzbohLIpbogNFZLygmMdVED+7" +
                                                              "S4fCjzRA3csD2lqxuISRGoCiByOuomC0jBcYuG+YtkZm6WD4kQYoHAto68Ji" +
                                                              "PeyZAMZaniAVRWPDeKExFx7LVskqHQ0/0gCNrw5owyAxtJmRakAjBnlYUSy2" +
                                                              "jBcWmKOnbYXSpWPhRxqgbyKgjesqwQYEWHQ66Z6Dw8B44YBnhyO2MiOl4+BH" +
                                                              "GqCrFdCWxkJjpA49J+w6rXk5pQOHPp5LZNTWabR0OPxIA1TeH9B2AxZ77SWS" +
                                                              "n7Q6WFw7Xlg0wbPXVmhv6Vj4kQboe0tA25exOMhIFWDR4c6KHSRuHs/w4lpb" +
                                                              "nWtLR8KPNEDbewPaDmNxpwgvOvLSbgeKu8bTb+6z9dlXOhR+pAHqHgtoexCL" +
                                                              "bwi/2erkyw4O3xwvHPDE7zpbmetKx8GPNEDXxwLansDiBCOVgMM6WgyIR8cL" +
                                                              "CLyr2W9rs790IPxIA5R9JqDtWSx+wEi9YnUUOZhw8Hj6/3KDC5aX++YTb8Bn" +
                                                              "FnxALj56lh85Ulsx48iW1/nBQe7D5CkxUpFIq6r7itL1Xm6YNKFwEKeIC0v+" +
                                                              "9U/oRUbO9f0IFfJU/MWn6iei/88YOadYf0bKoHT3fBm2Xm9PRiby3+5+r4Gp" +
                                                              "Of3wUI2/uLu8DqNDF3x9Q9z1Q5bpuhgVd7oZkYDOdgPNz4ymnW1+XKc/C/JO" +
                                                              "Tfin/tkTjnS3/aHMiSNXdu398NP3i48hZVUaHcVRqmJkkvgukw9aVvDRjXu0" +
                                                              "7FjlG5Z8UvPo5IXZ86R6IbBj7LMdi8REKmSgbczyfCloNec+GHzz6KUnf3qw" +
                                                              "/JUwCW0jGAdO3VZ4+50x0iZp3BYr/Nhsq2TyTxhblty757ILEh+8nb1mDuV/" +
                                                              "VeDt3y+/duyaV2+febQpTKo6yUS8aMjwa/l1e7QeKg+bfaRasdozICKMokhq" +
                                                              "3pdsNWjGEv4TAMfFhrM6V4uf0jIyv/AzvsIPkCvBYqm5Vk9rcRymOkaqnBox" +
                                                              "M56DprRheAicGnsqseSXq2syOBtgj/2xjYaR/cqx/KTBl3F7bnV7P4wLvcdf" +
                                                              "8e2P/wELxkIDBjQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "umTMh2sWchqUS60CW47xnhCpcFn29CRC");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("hpU42lAM0cJSRzDloBvXyKzPeRz1eMsn1CY+nK76fXS2Smi2JvbwXuKVZ3XP" +
       "x+pFOuNUZesdlwhm4xiKWmp9YXHccLmOapSGwpUugVf5OQQtJkKtCXYtcaOn" +
       "VVFjXatyhh8jNRXs0cDeUsaIKq7HnNOmXdTD1KBXmpvoYtBtR62uTOPFDVTn" +
       "YJvlhGFdKdJtpcPB/ZmFqrIK12qLIS8tlKLQtalJRWma5blZZ1hVSCpQFfKA" +
       "1R4qlYijy3DYC2uEOyDalbg+qqelUVVwwvVqKmH2Ul8QQ2nFDFIkMa1ZCZp3" +
       "RRiHO8OJolpwAMy+Na7APNVXx4O5FFbqtQFTUZHaejnleEqcsq7Z0fXNKtSj" +
       "Oj/dEKw2D4tYWwPb4mWN2zB2lZ4vayiL0kJTw3p9Sa2xra45Xglimii4YQ9k" +
       "ESKpNEW7nKVU3AjucBE+K2pkQxpWpksEqhbjorp0KsAgwoO175YnySReC0aQ" +
       "YFWM7rXWUM0SSiYRTuGpTASVBIKlMOGnZUiRhZEz6dpowo1rfF+LeNgoydhI" +
       "7q4gQeFZ3pfslMa7fVtfuxVH8gczjWxtkEmjr7TXXh+dIqFS1OhkAzfSjU8D" +
       "X7NpLlyzOtXrnsgm5lDnXatpx/0qSjgeu5YbqkhavusDe+mW/WTYDFYaXI61" +
       "Bc/CohvD3UnTqLQxwZpiDBL1NuC8VJPLDBy1erFOE01t1Gg03v/+7DHiD2/s" +
       "8ea9+ePag0BpzcCygj+6gSeY26JjkSr55/bCseDaIw+385oP70fIeIV3nhb/" +
       "nEeHfeGjL78iDb9Y2g+OwoLCXYHtvNeQN7JxpKsLoKdnTo866efh34ehH9/4" +
       "6P94ZPIT6xduINz0sWM4j3f5D/qv/i75bvEXzxVuOQgEuSYw/epGz14d/nHe" +
       "k4PQsyZXBYG880CyefhQFsDF7STLnfQvzqUz/jN4z3bu87LDKKC9wwqVrMLe" +
       "PccqHAkT2suirfbuAJPgy0Gf91aqdeKz8I2tSgdKtHfnjcQSZRl7t17NOvu/" +
       "6gM71h+4qaz3/5x4LP8/gY+CK9mfaFfaIGFlS5K93dsQOfm3nyGYx7LkwaBw" +
       "j2oBo5zFpW/jz/cOF9PeQ29CDvdnmdnfns5ODs7NkcNRDk+fUQZlyWXAbyUH" +
       "E9vZzn2uM4f8nnqz/J7IKW0/7s3nVz2jLLN+e8WgcAHwY7O/qU9kWHqzDDNr" +
       "6O0YejefYeOMMjxLngsKFwHDZh7ecSLF979Zio+Dy99R9G8+xf4ZZcMsoYLC" +
       "WwDFnqycPIf0myWYBf6EO4LhzSd4RpTmXhaluTcB5hcQpA+DTw7J3VDY5knk" +
       "ssjCaEcuuvnk5DPKsn9P914ICpcyEwNsbuOqSJZDjvzN0NB0xzG9+RzdM8py" +
       "OMZOQ68OiTkkaL5Zgo+C64M7gh+8+QRfPKPsZ7MkDgp3A4Ltk2Nrcpd+8fUg" +
       "bmNrDoWS3Azn+aHdiB+6+UL5xBllv5AlP7d1nu1TgnRyqVx4PYzbIJ1DqXzs" +
       "ZhizF3cjvnjzpfLZM8r+dpa8vDVmjcPAmkNyn36z5LJIvw/vyH345pP74hll" +
       "X8qSzweF84AcIZ/E7u++WXZZOPRLO3Yv3Xx2//CMsn+cJa+CQ6Tqt08IPzok" +
       "+eUbeo0A6MLBS4fZG1QPX/MG8/atW/Err1y886FXuH+fv3d38GbsXb3CnUpo" +
       "GEdD6o/c3+54sqLmvO/aBtg7OZl/FhTedupbkOAwk33l8v/1bf2vB4UHTqof" +
       "FG4B6dGarwFndrxmULgt/z5a7zeBnhzWy4Lf8pujVX4b9A6qZLffcHLJXR1S" +
       "tX0HId4eaB4+ojXbc/x9rzcPR07kT151js7fNd8/84bM7u2or77SGXzwB+gX" +
       "ty8Qigafplkvd/YKd2zfZcw7zc7NT5za235ft1NP/+jCr9711P4Z/8IW8KEG" +
       "H8H22Mlv67VMJ8jfr0v/6UO/9tyXXvnD/E2G/w+Ta7nRBEAAAA==");
}
