package org.apache.batik.svggen.font.table;
public class KerningPair {
    private int left;
    private int right;
    private short value;
    protected KerningPair(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        left =
          raf.
            readUnsignedShort(
              );
        right =
          raf.
            readUnsignedShort(
              );
        value =
          raf.
            readShort(
              );
    }
    public int getLeft() { return left; }
    public int getRight() { return right; }
    public short getValue() { return value; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YDYxUVxW+u8v+/y/sLn/LwrLQsKUzBYuGLNLCdheWzv6E" +
                                                              "pTRdhOXNmzszj33z3uO9O7sDiLY1htUoQVwo1ZZEQwUJLUSttrGtmEbbptWk" +
                                                              "Ba3VlBo1Ea3EEmM1otZz7n1v3s/sDCFRJ3n3vbn3nHPPOffc75x7z10jpZZJ" +
                                                              "FlGNhdg+g1qhXo0NS6ZFYz2qZFnboG9MfrRE+suuq4Nri0nZKKlLStaALFm0" +
                                                              "T6FqzBolbYpmMUmTqTVIaQw5hk1qUXNCYoqujZJmxepPGaoiK2xAj1Ek2C6Z" +
                                                              "EdIoMWYq0TSj/bYARtoioEmYaxLeEBzujpAaWTf2ueRzPeQ9nhGkTLlzWYw0" +
                                                              "RPZIE1I4zRQ1HFEs1p0xye2Gru5LqDoL0QwL7VHX2C7YElmT44KOC/Uf3DiS" +
                                                              "bOAumC1pms64edZWaunqBI1FSL3b26vSlLWXfIqUREi1h5iRzogzaRgmDcOk" +
                                                              "jrUuFWhfS7V0qkfn5jBHUpkho0KMLPELMSRTStlihrnOIKGC2bZzZrB2cdZa" +
                                                              "YWWOicduD08/uqvhWyWkfpTUK9oIqiODEgwmGQWH0lSUmtaGWIzGRkmjBos9" +
                                                              "Qk1FUpX99ko3WUpCk1galt9xC3amDWryOV1fwTqCbWZaZrqZNS/OA8r+VxpX" +
                                                              "pQTY2uLaKizsw34wsEoBxcy4BHFns8waV7QYI+1BjqyNnfcBAbCWpyhL6tmp" +
                                                              "ZmkSdJAmESKqpCXCIxB6WgJIS3UIQJOR+XmFoq8NSR6XEnQMIzJANyyGgKqS" +
                                                              "OwJZGGkOknFJsErzA6vkWZ9rg+sOH9A2a8WkCHSOUVlF/auBaVGAaSuNU5PC" +
                                                              "PhCMNV2R41LLC1PFhABxc4BY0Hzvk9fvWbno4iuCZsEMNEPRPVRmY/KpaN0b" +
                                                              "C3tWrC1BNSoM3VJw8X2W8102bI90ZwxAmJasRBwMOYMXt/74wYfO0veKSVU/" +
                                                              "KZN1NZ2COGqU9ZShqNTcRDVqSozG+kkl1WI9fLyflMN3RNGo6B2Kxy3K+sks" +
                                                              "lXeV6fw/uCgOItBFVfCtaHHd+TYkluTfGYMQUg4PqYGnjYgffzMihZN6ioYl" +
                                                              "WdIUTQ8Pmzrab4UBcaLg22Q4ClE/Hrb0tAkhGNbNRFiCOEhSZ2AikaBaOK4j" +
                                                              "QklRlYbvoyaISgxLihnCUDP+H5Nk0NLZk0VFsAgLgxCgwu7ZrKsxao7J0+mN" +
                                                              "vdefHntNhBduCdtHjIRg3pCYN8TnDYl5QzhviM8b8sxLior4dHNwfrHesFrj" +
                                                              "sO8BeGtWjOzcsnuqowQCzZicBa5G0g5fAupxwcFB9DH5fFPt/iVXVr1UTGZF" +
                                                              "SJMks7SkYj7ZYCYAqeRxezPXRCE1uRlisSdDYGozdZnGAKDyZQpbSoU+QU3s" +
                                                              "Z2SOR4KTv3CnhvNnjxn1JxdPTD68/dN3FpNif1LAKUsBz5B9GKE8C9mdQTCY" +
                                                              "SW79oasfnD9+UHdhwZdlnOSYw4k2dAQDIuieMblrsfTM2AsHO7nbKwG2mQTb" +
                                                              "DBBxUXAOH+p0OwiOtlSAwXHdTEkqDjk+rmJJU590e3ikNvLvORAWdbgN58HT" +
                                                              "ae9L/sbRFgPbVhHZGGcBK3iG+PiI8cQvfvqHj3B3O8mk3lMFjFDW7QEwFNbE" +
                                                              "oarRDdttJqVA986J4S8fu3ZoB49ZoFg604Sd2PYAcMESgps/+8ret9+9cupy" +
                                                              "sRvnjFQaps5gg9NYJmsnDpHaAnbChMtdlQADVZCAgdN5vwYhqsQV3IC4t/5Z" +
                                                              "v2zVM3863CBCQYUeJ5JW3lyA2z9vI3notV1/W8TFFMmYg123uWQC2Ge7kjeY" +
                                                              "prQP9cg8/GbbYy9LT0CKAFi2lP2UI22Rvd1RqbmQMDinooe2SlpMT22QAeGs" +
                                                              "PsBsvrBrONmdvL0rl3m2w9w/1JuRqYEKcb612CyzvJvHvz89hdaYfOTy+7Xb" +
                                                              "33/xOjfVX6l5Y2VAMrpFeGKzPAPiW4PgtlmykkB318XBTzSoF2+AxFGQyI0a" +
                                                              "MgFhM77IsqlLy3/5w5dadr9RQor7SJWqS7E+iW9SUgm7g1pJAOeMcfc9IjIm" +
                                                              "K6BpwK8MyTqGcMeQTE4Hrk77zOvemzIYX6n9z7Z+Z93pk1d4lBpCxgLOX4L5" +
                                                              "wofKvN53geHspY/97PSXjk+KimFFfjQM8M39x5AafeQ3f89xOcfBGaqZAP9o" +
                                                              "+Nzj83vWv8f5XUBC7s5Mbo4DUHd5V59N/bW4o+xHxaR8lDTIdn29XVLTuM1H" +
                                                              "oaa0nKIbanDfuL8+FMVQdxZwFwbB0DNtEArd3ArfSI3ftQH0w4KENMPTbqNC" +
                                                              "exD9igj/GOAst/G2C5s7HLApN0wFzmA0ADXVBYQyQA0aZ/6EjElvJB21IHkq" +
                                                              "KcDKCbusXD28W57qHP6dCIB5MzAIuuYz4S9uf2vP6xyJKzA9b3OM9iRfSOOe" +
                                                              "NNAgdP4QfkXw/Bsf1BU7RHnW1GPXiIuzRSIGcMFIDBgQPtj07vjjV58SBgTD" +
                                                              "LkBMp6Y//2Ho8LTAVnHSWJpT7Ht5xGlDmIPNA6jdkkKzcI6+358/+P0zBw8J" +
                                                              "rZr8dXMvHAuf+vm/Xg+d+PWrMxRqJYp9WvQiJiRI/9oIg+79XP3zR5pK+iCx" +
                                                              "95OKtKbsTdP+mD88y6101LNY7gnGDVnbNFwYRoq6YA1EWsZ2HTaDIv7uzgti" +
                                                              "m/xB3wLPYjs+F+cJehEqt2EznBvd+bgZKTWVRJInxe0BLZO3qOVceJbY8yzJ" +
                                                              "o6VWUMt83KDlBAIO59hmBw6+HvR87wQqSA5mzmrjXzm4BHoB4zJ58aPMSEdV" +
                                                              "RXbhg//KSOCk5K1U3PRBMNjb8h1meaCfemT6ZGzoyVUY6Mi4C+ojpht3qHSC" +
                                                              "qoFM1ObLRAP8+O7C+jt1R3/7XGdi460cDbBv0U2Kf/zfDpuwKz+kBFV5+ZE/" +
                                                              "zt+2Prn7Fqr89oCXgiK/OXDu1U3L5aPF/K5C5JucOw4/U7d/G1eZlKVNzb9x" +
                                                              "l2bXtd7Zdl32unYFA9qNJx7NB/zRXFWANVDFObUJ/v9CgbHD2ByCHJaAkzxk" +
                                                              "JL5l3YCeutluLVwYYUevwfs/4/dCKzwh25TQrXshH2sBSx8rMPZVbKYZqQAv" +
                                                              "bM0il+uGY/8DNzTiGB67Vtu2rL51N+RjLWDqNwqMncHma8INvBbD/5brhq//" +
                                                              "N9yQYaTac4eBxfPcnBtTccsnP32yvqL15P1vcbzJ3sTVAHLE06rqLe8832WG" +
                                                              "SeMKN6hGFHsiVV5gpOPm9yuA9/zN1T8vOL8NdWchTqjm8OVl+S4jrXlYAPDF" +
                                                              "h5f+OUYagvSgCn976Z5npMqlA1Hiw0vyAyhPgAQ/LxrOMa6Bn0+wpA6JkjpT" +
                                                              "5E8i2UVuvtkie/LOUh9e8+txB1vT4oJ8TD5/csvggesffVLcD8iqtH8/SqmG" +
                                                              "okdcVWTxeUleaY6sss0rbtRdqFzmZLJGobC7URZ4orkXkquB4TU/cHK2OrMH" +
                                                              "6LdPrXvxJ1Nlb0KJt4MUSXDc3ZF7+MgYaUiMOyK5xR3kMn6k717xlX3rV8b/" +
                                                              "/Ct+vCOiGFyYn35Mvnx656Wjc0/B0b+6n5RCkqYZfiq6d5+2lcoT5iipVaze" +
                                                              "DKgIUhRJ9VWOdbgTJLw4536x3Vmb7cXbJQj23KI5904OjsKT1Nyop7UYz1iQ" +
                                                              "S90e3729k+LShhFgcHs8B4soNg9kcDUgHsciA4bhnClKnjU4Fsj5a6pL/BOb" +
                                                              "y/8B3Qfi2TobAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+/rffvob+anw/wGnyl22nCUAAA==");
}
