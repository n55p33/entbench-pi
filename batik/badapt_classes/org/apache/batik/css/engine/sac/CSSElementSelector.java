package org.apache.batik.css.engine.sac;
public class CSSElementSelector extends org.apache.batik.css.engine.sac.AbstractElementSelector {
    public CSSElementSelector(java.lang.String uri, java.lang.String name) {
        super(
          uri,
          name);
    }
    public short getSelectorType() { return SAC_ELEMENT_NODE_SELECTOR; }
    public boolean match(org.w3c.dom.Element e, java.lang.String pseudoE) {
        java.lang.String name =
          getLocalName(
            );
        if (name ==
              null) {
            return true;
        }
        java.lang.String eName;
        if (e.
              getPrefix(
                ) ==
              null)
            eName =
              e.
                getNodeName(
                  );
        else
            eName =
              e.
                getLocalName(
                  );
        return eName.
          equals(
            name);
    }
    public int getSpecificity() { return getLocalName() == null ? 0 : 1; }
    public java.lang.String toString() { java.lang.String name = getLocalName(
                                                                   );
                                         if (name == null) { return "*"; }
                                         return name; }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ye4xUVxk/M/t+P3iWxwLLgmHBmdKWGlxaC9PdsjgLK0uJ" +
                                                              "LsJw5s6Zmcveufdy75nd2a1oizFQEwnBpaVq+UOpbQ0tTbVRo20wTUqbVpNW" +
                                                              "Yq2m1EQT8UEsMal/oNbvO+fO3Dt3HhuMdZI5c+ec7/vO+V6/7zv3/DVSZ1uk" +
                                                              "h+k8xKdNZocGdT5KLZslIhq17T0wF1MeraF/P3B15+YgqR8n7WlqjyjUZkMq" +
                                                              "0xL2OFmu6janusLsnYwlkGPUYjazJilXDX2cLFDt4YypqYrKR4wEQ4K91IqS" +
                                                              "Lsq5pcaznA07AjhZHoWThMVJwlv9ywNR0qoY5rRLvthDHvGsIGXG3cvmpDN6" +
                                                              "iE7ScJarWjiq2nwgZ5H1pqFNpzSDh1iOhw5pmxwT7IhuKjFB73MdH9w4me4U" +
                                                              "JphHdd3gQj17N7MNbZIloqTDnR3UWMY+TL5IaqKkxUPMSV80v2kYNg3Dpnlt" +
                                                              "XSo4fRvTs5mIIdTheUn1poIH4mRVsRCTWjTjiBkVZwYJjdzRXTCDtisL2kot" +
                                                              "S1Q8vT48++iBzudrSMc46VD1MTyOAofgsMk4GJRl4syytyYSLDFOunRw9hiz" +
                                                              "VKqpM46nu201pVOeBffnzYKTWZNZYk/XVuBH0M3KKtywCuolRUA5/+qSGk2B" +
                                                              "rgtdXaWGQzgPCjarcDArSSHuHJbaCVVPcLLCz1HQse/TQACsDRnG00Zhq1qd" +
                                                              "wgTpliGiUT0VHoPQ01NAWmdAAFqcLKkoFG1tUmWCplgMI9JHNyqXgKpJGAJZ" +
                                                              "OFngJxOSwEtLfF7y+Ofazi0nHtC360ESgDMnmKLh+VuAqcfHtJslmcUgDyRj" +
                                                              "a3/0EbrwxeNBQoB4gY9Y0vzwC9fv2dBz8VVJs7QMza74IabwmHIu3v7mssi6" +
                                                              "zTV4jEbTsFV0fpHmIstGnZWBnAkIs7AgERdD+cWLu1/53IPfY38JkuZhUq8Y" +
                                                              "WjYDcdSlGBlT1Zh1H9OZRTlLDJMmpiciYn2YNMBzVNWZnN2VTNqMD5NaTUzV" +
                                                              "G+I/mCgJItBEzfCs6kkj/2xSnhbPOZMQ0gBf0grf5UR+xC8nLJw2MixMFaqr" +
                                                              "uhEetQzU3w4D4sTBtulwHKJ+ImwbWQtCMGxYqTCFOEgzZ0GxkTYFZwrbVAlH" +
                                                              "xsYQFYB7jGkM4z6E4Wb+vzbKocbzpgIBcMYyPxRokEXbDS3BrJgym902eP3Z" +
                                                              "2OsyzDA1HFtxchvsHZJ7h8TeIdg7JPcOwd6h0r1JICC2nI9nkL4Hz00ABgAI" +
                                                              "t64b27/j4PHeGgg6c6oWzI6kvUXFKOICRR7dY8qF7raZVVc2vhwktVHSTRWe" +
                                                              "pRrWlq1WClBLmXASuzUOZcqtFis91QLLnGUoLAFgValqOFIajUlm4Twn8z0S" +
                                                              "8rUMszZcuZKUPT+5eGbqob1fujVIgsUFAresA2xD9lGE9QJ89/mBoZzcjmNX" +
                                                              "P7jwyBHDhYiiipMvlCWcqEOvPyj85okp/SvpC7EXj/QJszcBhHMKngd07PHv" +
                                                              "UYRAA3k0R10aQeGkYWWohkt5GzfztGVMuTMiWrvE83wIi5Z8XvY6OSp+cXWh" +
                                                              "ieMiGd0YZz4tRLW4a8x8/Ne/+NPtwtz5wtLh6QjGGB/wgBkK6xaw1eWG7R6L" +
                                                              "MaB798zo109fO7ZPxCxQrC63YR+OEQAxcCGY+SuvHn7nvSvnLgfdOOdQzbNx" +
                                                              "aIpyBSVxnjRXURJ2W+ueB8AQUwyjpu9+HeJTTao0rjFMrH92rNn4wl9PdMo4" +
                                                              "0GAmH0Yb5hbgzt+yjTz4+oF/9AgxAQWLsWszl0wi/DxX8lbLotN4jtxDby1/" +
                                                              "7BJ9HGoF4LOtzjABuUFhg6DQfDH0ZoIT625I1l2cv1O4dJOguVWMd6A5BCcR" +
                                                              "a5txWGN7U6M4+zwtVUw5efn9tr3vv3Rd6FLck3kjYYSaAzL4cFibA/GL/NC1" +
                                                              "ndppoLvj4s7Pd2oXb4DEcZCoADjbuyzA0FxR3DjUdQ2/+dnLCw++WUOCQ6RZ" +
                                                              "M2hiiIoUJE0Q+8xOA/zmzE/dI10/1QhDp1CVlChfMoHmX1HesYMZkwtXzPxo" +
                                                              "0Q+2PHn2iohBU8pY6hX4MRzWF6JRfOr9ZdEbjUUSLLK8Uuciuq5zR2fPJnY9" +
                                                              "sVH2F93F3cAgNLvP/Opfb4TO/O61MmWniRvmxzU2yTTPnrW4ZVGlGBFNnYtW" +
                                                              "77af+v2P+1LbbqZI4FzPHGUA/68AJforg77/KJeO/nnJnrvTB28C71f4zOkX" +
                                                              "+fTI+dfuW6ucCooOVkJ9SedbzDTgNSxsajFo1XVUE2faRNivLgRAFzp2JXz7" +
                                                              "nQDoL4+5ZWKngGSVWKtk9d4qa5/F4TOQsClWaDBEzShqGtDHY9m4DQVezQCe" +
                                                              "Tzpt8G2jB5XjfaN/kCF4SxkGSbfgqfDX9r596A3hrEaMjoKJPJEBUeQpVZ1S" +
                                                              "9w/hE4Dvv/GLx8YJ2U52R5yedmWhqcU0tMi6KrfQYgXCR7rfm/jW1WekAv6m" +
                                                              "30fMjs9+9cPQiVmZT/JmtLrkcuLlkbcjqQ4O+/F0q6rtIjiG/njhyE+eOnIs" +
                                                              "6DhpmJM6QDOLF1wYKLR284uNLk9678MdPz3ZXTMEeTpMGrO6ejjLhhPFsdpg" +
                                                              "Z+MeL7hXKTdynTOjxTkJ9Ocx7pM47JbPd/2X8IoTEVPMjxSCfB6uLYbvRifI" +
                                                              "N958flRi9eWAr17OwzZ86nYllDAyIaffdkumXSWBpnCAu1pdhnIlLUjGHVfj" +
                                                              "T8zzDNW+IW4YGqO635H4N+2xrvERWLcjX3IijokiN2/dSqxVDHSsytrDOBzl" +
                                                              "pB3Rx2QKtEuKyqfnsmKNqpekgt+CX/4ILNiNa0vgu8Mxw46bt2Al1ipWeqzK" +
                                                              "2jdxmOWkkRueRs81w+n/hRlyiLUl91BskRaXvAGTb22UZ892NC46e//bolMo" +
                                                              "vFlpBfRPZjXNA0NeSKo3LZZUhV6tsmM0xc93oA7PcU+GoIBRKPBtyfRdTpZW" +
                                                              "YYLbgnzw8jwN99FyPCAdRi/leeix/ZQAAuLXS3eBk2aXDjaVD16S50E6kODj" +
                                                              "9808IH1irvcCW6G4WqC3zym5QGkbKgJhwVyB4Ok7VxfVT/EuNF9isvJtaEy5" +
                                                              "cHbHzgeu3/mEvAAqGp2ZQSktUFjkXbTQdq2qKC0vq377uhvtzzWtyde7Lnlg" +
                                                              "N5mWeiIeoCdgYuwt8d2O7L7CJemdc1te+vnx+regUu8jAQr4vs/zJlK+doMr" +
                                                              "Vhb63X3R0gIKLaq4tg2s+8b03RuSf/ut6PCJLLjLKtPHlMtP7v/lqcXn4HrX" +
                                                              "MkzqoJSz3DhpVu17p/XdTJm0xkmbag/m4IggRaVaUXVuxzShmMTCLo452wqz" +
                                                              "+PqAk97SjqP0pQvchqaYtc3I6gmnvre4M0UvaZ3Ua86apo/BnfF0ZSmJxOgN" +
                                                              "CNtYdMQ08w1Zw1pT4EW6PDTj+Ip4xOHSfwAbTNLyJxkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
