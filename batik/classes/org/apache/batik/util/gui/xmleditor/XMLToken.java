package org.apache.batik.util.gui.xmleditor;
public class XMLToken {
    private int context;
    private int startOffset;
    private int endOffset;
    public XMLToken(int context, int startOffset, int endOffset) { super(
                                                                     );
                                                                   this.context =
                                                                     context;
                                                                   this.
                                                                     startOffset =
                                                                     startOffset;
                                                                   this.
                                                                     endOffset =
                                                                     endOffset;
    }
    public int getContext() { return context; }
    public int getStartOffset() { return startOffset; }
    public int getEndOffset() { return endOffset; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "kLor/3Xq+k7WzrK1fYC767961vx9//ifV0xCjstX8bsj/CLy4kfvxt/2rZx/" +
       "HyAz7vuSK7cvkNnu8xY/sfr34w+d+vPj0GkRuiDvpM2CZEUZ7IggVQx2c2mQ" +
       "Wh/qP5z2bXOcJ/Y2gHuOOv6BYY9C877DgXpGndXPHkHjLM+A7gLPvTtAde9R" +
       "ND4G5RUqZ3kwLy9mxY/sgt9p1zfXIG5yyWXwW95m6HvufSFnektW0Nv1fPs1" +
       "1751WLN7wHPfjmb3XUOzwTU0y6rsrlI3gTnyw21mdjXFhq9RsbvBc/+OYvdf" +
       "Q7Hp96PYfsJ4NbVmr6pWLiY5BtbhZPFS7VIh+3356gOfyKqPgN0qyF+kAIdm" +
       "2pK1q8mdC0u+uIuGAnixAsFycWHVcjG3g1fJPM4zt7y0fRs5omv5+9YVxPG5" +
       "fWGMA15sPvBPH/zyLzz8dRBsNHRynQUCiLEDI3JR9q73sy9++N6bnv3GB/LN" +
       "F8yk8P5X7n5HJnVxPYuzQs4KZdfUuzNTR3kWy0hByOb7parsWVs4YE81BLuu" +
       "8wNYG567gSwHVHP3wwgzbRYLQjJBanDBhpESFvtMgG1ipm0tVB11+cBZNAMr" +
       "mJTq9MpK6AZONSp1uDYnp3M1bWGpiGhh6IE9eYnPR1jTdbA5PNEp05i4XbSj" +
       "z8fdXjukvcJwEgBpIjfEoyRpm5zXn8oqrHEoEjYJf02XWkqtltrg0496qlKq" +
       "WZv6gndYci4sjNmYsiiJ48Hwhj5WYspSJ2OctcfNKVGoT/ApoqjFdS0ym95C" +
       "6kqsTMzaTb7VKISzsWEMUXzmYgbBE8P1nOUrg4VJKB3U1AjKXHYtkqexZavL" +
       "FydDasl6usXi0xmt6mMBL48dPoyXKtscDdrYHGsNaLZQwldIyvSHbZ4GeZhF" +
       "9NUazqwVCR1s3FFqFdqD6WSEsHiHGI8Yujwzlku6WlhYouctYrTrBUuDY5dh" +
       "u6FKNUufFIehpQdVuxo2ELg2DMb+Sl+KGC+M8bTV6wQS2SVSfTiYT3tzGmb5" +
       "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");
}
