package org.apache.batik.css.dom;
public class CSSOMViewCSS implements org.w3c.dom.css.ViewCSS {
    protected org.apache.batik.css.engine.CSSEngine cssEngine;
    public CSSOMViewCSS(org.apache.batik.css.engine.CSSEngine engine) { super(
                                                                          );
                                                                        cssEngine =
                                                                          engine;
    }
    public org.w3c.dom.views.DocumentView getDocument() {
        return (org.w3c.dom.views.DocumentView)
                 cssEngine.
                 getDocument(
                   );
    }
    public org.w3c.dom.css.CSSStyleDeclaration getComputedStyle(org.w3c.dom.Element elt,
                                                                java.lang.String pseudoElt) {
        if (elt instanceof org.apache.batik.css.engine.CSSStylableElement) {
            return new org.apache.batik.css.dom.CSSOMComputedStyle(
              cssEngine,
              (org.apache.batik.css.engine.CSSStylableElement)
                elt,
              pseudoElt);
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYfWwUxxWfO+Pvb/Nhlw8DxhAZyG1oAhU1oYHDBJMztjBB" +
       "7dFwzO3O3S3s7S67c/bZSdoEKQ2RqpQSQmjV8BcIBdEkqhq1lZqIKmqTKG2l" +
       "JPQjrUKrtn+kTVGDqqZV6dd7s7u3e3t3pkitpZ1bz7x5M+/N7/3em710jdTb" +
       "FulnOo/xGZPZsRGdT1DLZkpco7a9D/pS8jN19M8H39+zOUoakqQjR+0xmdps" +
       "p8o0xU6SZapuc6rLzN7DmIIzJixmM2uKctXQk2Shao/mTU2VVT5mKAwF9lMr" +
       "Qbop55aaLnA26irgZFkCdiKJnUjbwsPDCdImG+aML94XEI8HRlAy769lc9KV" +
       "OEynqFTgqiYlVJsPFy2yzjS0maxm8Bgr8thhbaPrgt2JjRUuGHix86MbJ3Jd" +
       "wgXzqa4bXJhn72W2oU0xJUE6/d4RjeXto+RzpC5BWgPCnAwmvEUlWFSCRT1r" +
       "fSnYfTvTC/m4IczhnqYGU8YNcbKyXIlJLZp31UyIPYOGJu7aLiaDtStK1jpW" +
       "Vpj49Drp1DMHu75RRzqTpFPVJ3E7MmyCwyJJcCjLp5llb1MUpiRJtw6HPcks" +
       "lWrqrHvSPbaa1SkvwPF7bsHOgskssabvKzhHsM0qyNywSuZlBKDc/+ozGs2C" +
       "rYt8Wx0Ld2I/GNiiwsasDAXcuVPmHVF1hZPl4RklGwfvAwGY2phnPGeUlpqn" +
       "U+ggPQ5ENKpnpUmAnp4F0XoDAGhxsrimUvS1SeUjNMtSiMiQ3IQzBFLNwhE4" +
       "hZOFYTGhCU5pceiUAudzbc+WJx/Ud+lREoE9K0zWcP+tMKk/NGkvyzCLQRw4" +
       "E9vWJk7TRS8fjxICwgtDwo7Mtx66fs/6/suvOzJLqsiMpw8zmafkc+mOt5bG" +
       "hzbX4TaaTMNW8fDLLBdRNuGODBdNYJhFJY04GPMGL+/9wWceucg+iJKWUdIg" +
       "G1ohDzjqlo28qWrMupfpzKKcKaOkmelKXIyPkkZ4T6g6c3rHMxmb8VEyTxNd" +
       "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" +
       "hdlmFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6aczr2FV+39vfLO/NTDszDJ39TelMyuckzqpXhiZ2HNtx" +
       "HMeOsxjoq3c78RYvsZMydFoJOlBRCkxLi9oREi2FaroIUYGEigYhaKtWSEUV" +
       "m0RbISQKpaLzg4IoUK6db3/vTRkBkXxzc+85555z7jnnHp+bF78FnQ0DqOB7" +
       "9tqwvWhXS6PduV3djda+Fu5SdJWVglBTUVsKwxEYu6489unL3/nue80rO9A5" +
       "EbpHcl0vkiLLc0NOCz17pak0dPlwtGNrThhBV+i5tJLgOLJsmLbC6BoN3XYE" +
       "NYKu0vsswIAFGLAA5yzArUMogHSH5sYOmmFIbhQuoZ+CTtHQOV/J2IugR48T" +
       "8aVAcvbIsLkEgMKF7PcYCJUjpwH0yIHsW5lvEPh9Bfj5X3nLld8+DV0WocuW" +
       "y2fsKICJCCwiQrc7miNrQdhSVU0VobtcTVN5LbAk29rkfIvQ3aFluFIUB9qB" +
       "krLB2NeCfM1Dzd2uZLIFsRJ5wYF4uqXZ6v6vs7otGUDWew9l3UqIZ+NAwEsW" +
       "YCzQJUXbRzmzsFw1gh4+iXEg49UeAACo5x0tMr2Dpc64EhiA7t7unS25BsxH" +
       "geUaAPSsF4NVIuiBWxLNdO1LykIytOsRdP9JOHY7BaAu5orIUCLotSfBckpg" +
       "lx44sUtH9udbzJve8zaXcHdynlVNsTP+LwCkh04gcZquBZqraFvE25+i3y/d" +
       "+9nndiAIAL/2BPAW5nd/8uU3v/Ghlz6/hfnBm8AM5LmmRNeVj8h3fvl16JPN" +
       "0xkbF3wvtLLNPyZ5bv7s3sy11Aeed+8BxWxyd3/yJe5PZs9+XPvmDnSJhM4p" +
       "nh07wI7uUjzHt2wt6GquFkiRppLQRc1V0XyehM6DPm252nZ0oOuhFpHQGTsf" +
       "Ouflv4GKdEAiU9F50Ldc3dvv+1Jk5v3UhyDoPHigN4LnKrT95N8RNIVNz9Fg" +
       "SZFcy/VgNvAy+UNYcyMZ6NaEZWD1Czj04gCYIOwFBiwBOzC1vQklDGHVc2CU" +
       "5wf9saUloLObWZj//0g7zeS6kpw6BVT+upMObwNfITxb1YLryvNxu/PyJ69/" +
       "cefAAfY0EkFPgOV2t8vt5svtguV2wXK7R5eDTp3KV3lNtux2U8GWLIBzg7B3" +
       "+5P8T1Bvfe6x08Ca/OQM0GcGCt86+qKH4YDMg54CbBJ66QPJO8ZvL+5AO8fD" +
       "aMYqGLqUobNZ8DsIcldPus/N6F5+1ze+86n3P+MdOtKxuLzn3zdiZv752Eml" +
       "Bp6iqSDiHZJ/6hHpM9c/+8zVHegMcHoQ6CIJGCaIIQ+dXOOYn17bj3mZLGeB" +
       "wLoXOJKdTe0HqkuRGXjJ4Ui+23fm/buAjm/LDPc+8OzuWXL+nc3e42fta7bW" +
       "kW3aCSnymPojvP/hv/zTf0Byde+H38tHDjRei64dcfmM2OXcue86tIFRoGkA" +
       "7m8+wP7y+771rh/LDQBAPH6zBa9mLQpcHWwhUPNPf375V1/76ke+snNoNBE4" +
       "82LZtpT0QMhsHLr0CkKC1V5/yA8IGTZwrcxqrgqu46mWbkmyrWVW+h+Xnyh9" +
       "5p/ec2VrBzYY2TejN35/AofjP9CGnv3iW/71oZzMKSU7sg51dgi2jYP3HFJu" +
       "BYG0zvhI3/FnD37wc9KHQUQFUSy0NloemE7tOU7G1Gtv5ZaaawDjyjyzk/fy" +
       "LYZznKfyNldPTgnK55CseTg86irHvfFIInJdee9Xvn3H+Nt/8HIu2/FM5qhl" +
       "9CX/2tYYs+aRFJC/72RcIKTQBHCVl5gfv2K/9F1AUQQUFRDfwkEAYlJ6zI72" +
       "oM+e/+s//KN73/rl09AODl2yPUnFpdwloYvAF7TQBOEs9X/0zVtTSC6A5kou" +
       "KnSD8FsTuj//dQYw+OStoxGeJSKHDn3/vw9s+Z1/+283KCGPQzc5f0/gi/CL" +
       "H3oAffqbOf5hQMiwH0pvjNMgaTvELX/c+Zedx8798Q50XoSuKHsZ4Viy48zN" +
       "RJAFhftpIsgaj80fz2i2x/e1g4D3upPB6MiyJ0PR4fkA+hl01r90IvrcmWn5" +
       "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" +
       "YYayVCIAAA==");
}
