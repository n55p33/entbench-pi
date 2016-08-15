package org.apache.batik.svggen;
public abstract class AbstractSVGConverter implements org.apache.batik.svggen.SVGConverter, org.apache.batik.svggen.ErrorConstants {
    protected org.apache.batik.svggen.SVGGeneratorContext generatorContext;
    protected java.util.Map descMap = new java.util.HashMap();
    protected java.util.List defSet = new java.util.LinkedList();
    public AbstractSVGConverter(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          );
        if (generatorContext ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_CONTEXT_NULL);
        this.
          generatorContext =
          generatorContext;
    }
    public java.util.List getDefinitionSet() { return defSet; }
    public final java.lang.String doubleString(double value) { return generatorContext.
                                                                 doubleString(
                                                                   value);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2QSquKrouqLa3SiCNd6GFsbg+/G+vpdn7cY6lxJ6gNEhkkZgGMMXa2seV4bO" +
       "cpaQrELt94u0F3Wt4ZDf5iIpLBqsOym06XQlkMianxb8ZIITCpEtx3w9avWi" +
       "aKdJIZnxC8mTtkOF4nZoYndMdFHD5sQG1WvasM711CK0+JZEOJtRY2Gp9krF" +
       "57XVwPK7hcLoGsygaeDWJNyyDbhBOvm6xYT1OYf2Ot1W06WLIZMn8FTQx6tO" +
       "g7B6iW2PAJAnKrxKmxilDnOv7fGFE/gzfjocqpJLohs+DX1lzMwJxlwYadPs" +
       "rZq5ZYmWzFirVT6amB1Gni7CON9FsOx3vHqT9te2oNfSAQxvO32jY7c6C45v" +
       "YzEsSnwjowiaWG2t8VDcZvM6aeWEZcD6rrXDjG1n6A9gXQ7AvKrYgFW6CZ5k" +
       "OJjiPbNV403HNLJRjGk6s9fYrDXv1vGJO3WivSZzMjdwJXUpF34Tr60XeC+T" +
       "kECqRzUKnFxGJMO6awtW0kZtm/twR9kutnYPt+cNEmu0tmzPh6m2256MxHTb" +
       "7jpSMuGJAplv5GKP88YGZZ00D0g08RuO6Nc3Swc28aW51na4QhYU22T76pSg" +
       "dFUJNW4xoy02wAl2hXoZKYjizkI6+Nww867b8iZEk8FUdxhP3CyzGJJsAdiz" +
       "g6yjwhgviuhkD+utXthuFxRqtgvSCNIdr6vT/bjfTMQWvmr6MyYiOl14rxSi" +
       "SNWExJqyEj+ReqHWrve8SZwbk9lQXMTYolOrTUlVDbnxUhw3oyFb911vaniU" +
       "RYwDSjJZsECbSNzf2SOS2KMJMiVbvG1OMXwui3St2WgxbZk167NeIaE1wIzP" +
       "o+6u0PnhBs+0rcT5hIXxWOabeJPhVRH2+7aBmeR6geyUgiDmmw0Jm0y6jJnO" +
       "BobHmOmMmO0eIZo12N04xWSUq6YO54yjD0haC5Z5JlhTS0c3WyZE2/Rsveym" +
       "iUWuW31dnggLUd9MNIBHO0kISU9sDHu5UVO6iIIHphABE225fpPIZBPdtRrc" +
       "ot2fRUgEN8ZCczbHJp0mmTV2YKXYoFYv7yeMFioArhGvEHaqRIR1tj3f8S16" +
       "Jy1zZKAOd3QtRtbcThX3mx2AAzThpYgjmmF74qeig0rT7TyZGJpQJ/l+fcwi" +
       "CjpGxbGtBtlgIjkBy9eInZPvR7LhtahdXdiLAbYfbL2M5lpy2pDq1ITxmovR" +
       "LFPWui6uaq0OLPO7RlJv8vkAbfVGadwOp/4+EtCl3YUBOGb7ZGq1B4q5Ge3R" +
       "GhY3ENTZU54m7C1V7SEF0kPYfezkUqsjeIxYiPQo1QYdMWxta7mGs42s36co" +
       "dbPh+uqYkifWEFE8C1lJZuTv53KrnUylVjqBG1S7bprw0uebnBzmCk5KZg2l" +
       "w9htNuf+AoTAGivoPS+xrpmgo6QbNXlv2Pa9EW621KnQbRVdbIumdH0QYDOl" +
       "kL2YXKziVX87J1S1T8icscbTVNJb4nIxFn1gjtBszLpssi6oGG8tfVd1Ryuf" +
       "d0ycyFG8QA1mT9Y0ry0Rk9aCM3cDDN9ua7tN4dBk3pvXuz0PVSJPprqCgy8k" +
       "ZrDqydmmHfidzWipdsUSr/x2Oxn0l+36arNd46g7wCaOtZi27B1jyHpqzWvL" +
       "XNxQcpAXuYcQOLZXLCOXEXVdZIotTAGeSX436+apw+VkX2bGfa3VQ3Y5L0i1" +
       "rNEa4wXcdodbP/OzXa9e9xkW9bOAZ8jlVhLlvD+lBqqm9hK9g6nxoOkP+WCl" +
       "jWCP25uM2ZOaHrLAmuJS962tFqFRzV8uG3C3Bou75ioRse7OpNq2VyDiGB8O" +
       "sJq/Ycl9z5qJNU4TaTQrliN0g4ltF2lPUK02S2XAMdFraLKnZkNtPo+7K9R1" +
       "uwg8Ujs2rHYTXZxhXg0rwiHqRl3Zo6mGPO41aay2dJbDhc8Ibtsb2pgt9KJB" +
       "aKGCvRstErAT3YpjyqSSpIXEbr++GaWoUy+SdtfrcTYtUPPRfrfXmxaC1qZC" +
       "D0FIJ6YpGsFYhNxhneVChtNtb7Ed7D28USfkTWsBjoLaapf1Zlibb+sIp+Uc" +
       "NZZpSetKmCCI+nI1qAU7bs+YnsPXxbmFjF2ENRKaJlAZVUO6sS4sODHpuTwz" +
       "64kw3i7RTVN2hPqsA7bHmdleCuzIRRmrm5OL7W7VhQd6CwUr8M4YeLq7nUtt" +
       "Q+LitmPXVhw664gSFeabmgDPO35ca1HNburJHRLEgNZPvNqSlAZwo2mTc13W" +
       "6pwdRYMhM6wrjZk1YvWOkKxGIsdodalTY/JdynbJwCS667jf1F2YsWmw2oSK" +
       "wSCywjCqWq6CaGeQZkOtt5xG9aBjZf0IqXlkjiPifBppYp0lzUTjVlMa7yOS" +
       "4C+anRBbdIkaWImKenNWYGlrmwk5J8x91uL9hTaha+sI58YrxiD8xLSbaXtJ" +
       "qDaLdsYO0+xzaZHh9HjbaUpCizFrzDpHeu1lOyb7eUedrZR1A8vM4RiDBxY1" +
       "Wof20pFxmF8YAU03GXplzYbpqqGFIHYjcNpYZ0bD6zaAdIN8po1SiyyiqAA7" +
       "vq2RL3O2648c1WBotBPq6JZGg36zEbCER1Gch062Xs/p9iU3XxY8ugjA7Ifd" +
       "eOWpXWVudrXW2NxizBbrKcaCyKejlpb53c2+FQzzPM/6yoAdUcESn/TcWldo" +
       "NJYIwoT4YLOOQjcp6v3Vjg2nroRxQGSt3pk2A2DwxcTXRWXJcCmPTHh60PGY" +
       "WF5RM8eehkKoLExi2lP9JWmOMAqT59rK1bvFoDlud2LHLvB1q07WyCmWubHY" +
       "USgUi+h5E+U6TTPOaL3lFrII4wmh70VtNmJxvDxGf/ztZTKerJI2p1fUG7dT" +
       "Njhv4wSf333Ao+Nk0SPK8U3d2X1J9bkOXbrzPH9fcpYQPzrJHt28z13D6Q3g" +
       "CfGH70U8iOMqAXv4Z0OZDnnfva68q1TIFz/x2uv6/EvISQbyYyn0aBqE3+Ua" +
       "W8O9IGYMvXjvtM+0uvE/S57/0if+57OL716/8jauEZ+/JOdllv9u+savkB/W" +
       "/sUR9MBpKv2O/yJc7PTSxQT6tdhIs9hfXEijv+901qrpfgE8k+NZm1zOS545" +
       "zd0Tn995cLr73AF9/j5tr5evH6sS6WnfMG2/uvG7M3/62Il33VfOKlH6ypmH" +
       "f+7b5ajOi1NVvHY64jNl5U3wsMcjsm/DMkengWnf1Tznr9y252KxKPPHQaa6" +
       "RtXty/ex3Jvl60sp9PiB/iz56pzp/6/fjv55Cr3rbhfw5fXBM3f80efw5xTt" +
       "J16//sjTry9/q7qDPv0DyaM09IiZue75i5xz5athDKa60uLRw7VOWH39dAo9" +
       "fY8YL/PTVaES+ysH+p8BfnOZPoUeqr7P0/3nFLp2RgdYHQrnSf5rCj0ASMri" +
       "W+FdctuH+6z8yjl0OPaYytBPfTtDn3Y5f0VdIkr1R6uT6M+Y48uYN1+fzD72" +
       "zfaXDlfkmqsURcnlERp6+HBbf4og778ntxNeV0cf+dYTP/noh07Q7omDwGfe" +
       "e0625+9+Hz3wwrS6QS7+49M/9fK/ef33q1T7/wV9LexkAScAAA==");
}
