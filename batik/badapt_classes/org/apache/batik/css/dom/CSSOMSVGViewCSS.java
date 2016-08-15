package org.apache.batik.css.dom;
public class CSSOMSVGViewCSS extends org.apache.batik.css.dom.CSSOMViewCSS {
    public CSSOMSVGViewCSS(org.apache.batik.css.engine.CSSEngine engine) {
        super(
          engine);
    }
    public org.w3c.dom.css.CSSStyleDeclaration getComputedStyle(org.w3c.dom.Element elt,
                                                                java.lang.String pseudoElt) {
        if (elt instanceof org.apache.batik.css.engine.CSSStylableElement) {
            return new org.apache.batik.css.dom.CSSOMSVGComputedStyle(
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
      ("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" +
       "B/2mDH9+Vch/Qrzi8LX/AiGXaqQJFAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU5e+zr1lm+v9v7bNd7+1hbyvq+LWs9fo7zju4Yc5zYiWM7" +
       "Tuw4iQe79TuOn/EjD49CW2m0YlI3QTeGtPWvTsDUrRNiAgkNFSHYpk1IQxMM" +
       "JLYJITEYE+sfDMSAcez83vfeThMiUk5Ozvm+75zveb7znde+B52JQggOfGdj" +
       "On68q6/j3blT2Y03gR7tUnSFk8NI13BHjiIBjF1TH/3cpR/88COzyzvQWQm6" +
       "S/Y8P5Zjy/eioR75zlLXaOjS4Wjb0d0ohi7Tc3kpI0lsOQhtRfFVGrr1CGoM" +
       "XaH3t4CALSBgC0i+BQQ7hAJIb9O9xMUzDNmLowX0y9ApGjobqNn2YuiR40QC" +
       "OZTdPTJczgGgcD77LwKmcuR1CD18wPuW5+sY/iiMvPyb77/8e6ehSxJ0yfL4" +
       "bDsq2EQMFpGg21zdVfQwwjRN1yToDk/XNV4PLdmx0nzfEnRnZJmeHCehfiCk" +
       "bDAJ9DBf81Byt6kZb2Gixn54wJ5h6Y62/++M4cgm4PWeQ163HBLZOGDwogU2" +
       "Fhqyqu+j3GJbnhZDD53EOODxSg8AANRzrh7P/IOlbvFkMADdudWdI3smwseh" +
       "5ZkA9IyfgFVi6P6bEs1kHciqLZv6tRi67yQct50CUBdyQWQoMfT2k2A5JaCl" +
       "+09o6Yh+vse++6UPeB1vJ9+zpqtOtv/zAOnBE0hD3dBD3VP1LeJtT9Efk+/5" +
       "wos7EASA334CeAvzB7/05nvf9eAbX9rC/PQNYPrKXFfja+qryu1fewf+ZON0" +
       "to3zgR9ZmfKPcZ6bP7c3c3UdAM+754BiNrm7P/nG8M+nz35a/+4OdLELnVV9" +
       "J3GBHd2h+m5gOXpI6p4eyrGudaELuqfh+XwXOgf6tOXp29G+YUR63IVucfKh" +
       "s37+H4jIACQyEZ0Dfcsz/P1+IMezvL8OIAg6B77QbeD7CLT95L8x9D5k5rs6" +
       "IquyZ3k+woV+xn+E6F6sANnOEAVYvY1EfhICE0T80ERkYAczfW9CjSJE810E" +
       "5/k+w4ukaOkr0N/NjCz4/yW/zri7vDp1Cgj+HSfd3gEe0/EdTQ+vqS8nzfab" +
       "n732lZ0DN9iTSwy9E6y4u11xN19xF6y4C1bcPbEidOpUvtDd2cpb7QLd2MDL" +
       "Qfy77Un+F6mnX3z0NDCrYHULEGwGitw8DOOHcaGbRz8VGCf0xsdXz4m/UtiB" +
       "do7H02y3YOhihs5lUfAg2l056Uc3onvphe/84PWPPeMfetSxAL3n6NdjZo76" +
       "6Em5hr6qayD0HZJ/6mH589e+8MyVHegW4P0g4sUysFAQTB48ucYxh726H/wy" +
       "Xs4Ahg0/dGUnm9qPWBfjWeivDkdyhd+e9+8AMr41s+D7wfeJPZPOf7PZu4Ks" +
       "vXtrIJnSTnCRB9ef44NPfuMv/qmUi3s/Dl86crLxenz1iO9nxC7lXn7HoQ0I" +
       "oa4DuL/7OPcbH/3eC+/LDQBAPHajBa9kLQ58HqgQiPmDX1r8zbe++erXdw6N" +
       "JgaHX6I4lro+YDIbhy6+BZNgtScO9wNihwMcLLOaKyPP9TXLsGTF0TMr/a9L" +
       "j6Of/5eXLm/twAEj+2b0rh9P4HD8p5rQs195/78/mJM5pWZn16HMDsG2AfGu" +
       "Q8pYGMqbbB/r5/7ygd/6ovxJEFpBOIusVM8j1Kk9x8k29fYYevyGnql7JjCu" +
       "zDnbeS9XMZLjPJW3u5l4ckpQPlfKmoeio65y3BuPZCTX1I98/ftvE7//x2/m" +
       "vB1PaY5aBiMHV7fGmDUPrwH5e0/GhY4czQBc+Q32Fy47b/wQUJQARRVEuagf" +
       "grC0PmZHe9Bnzv3tn/zpPU9/7TS0Q0AXHV/WCDl3SegC8AU9moGItg5+/r1b" +
       "U1idB83lnFXoOua3JnRf/u802OCTN49GRJaRHDr0ff/Zd5Tn//4/rhNCHodu" +
       "cBCfwJeQ1z5xP/6e7+b4hwEhw35wfX2oBtnbIW7x0+6/7Tx69s92oHMSdFnd" +
       "Sw1F2UkyN5NAOhTt54sgfTw2fzy12Z7jVw8C3jtOBqMjy54MRYdHBOhn0Fn/" +
       "4tHo8yPwOQW+/5N9M3FnA9sD9U5871R/+OBYD4L1KeDbZ4q7td1Cho/lVB7J" +
       "2ytZ8zNbNWXdd4IgEOU5KcAwLE928oWbMTAxR72yT10EOSrQyZW5U9v3mMu5" +
       "OWXc724Tu234y9pyTmJrErWbms+7t1D5OXf7ITHaBznih/7hI1/98GPfAjql" +
       "oDPLTN5AlUdWZJMsbf7V1z76wK0vf/tDeUwDziw++/i/5kkI+1YcZw2ZNZ19" +
       "Vu/PWOXzpICWo5jJw5Cu5dy+pSlzoeWCaL3cywmRZ+78lv2J73xmm++dtNsT" +
       "wPqLL//aj3ZfennnSJb92HWJ7lGcbaadb/ptexIOoUfeapUcg/jH15/5o995" +
       "5oXtru48njO2wZXoM3/131/d/fi3v3yDhOUWx/8/KDa+9RudctTF9j+0ODXG" +
       "K3W4HhsJwpYQqtTGRxWLKpeFDaaX5pJvNmXd2ahiv8OUDZig6CJZSNRanGrr" +
       "5bI2rhQr8Cblq2Qs4iKx6AZ40ZRt2GpMCNkqEHIXpwhfEuVejNtm3BabA2xN" +
       "4b1ZfTiXWr0O3AmXmqcVa8WGWu1aqkb3a2qxro8RHYXhRjLUErsTKl0PZSol" +
       "EpZb3Rq3SFN+HEpC2/FRWuJW6Fo2LIlESjXXRDqtkdZdDRphijarwkJFSbE3" +
       "DRpmKgWJXwxqIVPrdEiCXa1lgVTGRn+0KE/hQSovGu68iRJDqTLuk6ugabpO" +
       "QBXsUSVuDBlbYYfOqu0VK9SqbbvqsOXLk1mlZzuKxDS1Rj0qNOv20GzyNr20" +
       "Nopdr9l9IeACnpqwvBsUvY0vUUQjWLTjypxvrVGXWtcbwQxdCV7b1xdzurli" +
       "Iq3TKFadfn1EOTNO00rmYI7WrNgl2QgeUX1vJZVVVAxbnL2BhTHVi/B1M2WC" +
       "eWHW9k0R6828cAoT0gae6x4xiLqDqodzozITlMvtclHsUOveYEwrs4iKxpI5" +
       "YgStNJq4hY5SG4txhy+GInBAryQ4rtDXSuXicD7zeF/3A65bZmYwZkrYlNmY" +
       "viTFToeYjgKmOqSbRd1zeyIviOiG09B4kbpa3eqVSylDCzOJlUxXWi5K2LyK" +
       "K6LEV6bSRNyUF5jqIaKUjmUMRWsGUdCA4lad2TAa6YQpBhJeoh2lmkijiU7a" +
       "XG0zD/ucWSm3sXg+HZNMXZFEAu37I6qQFNtWW0E9iscLLJsOiGA5wJqyx/HJ" +
       "ZjiMFZGqzBNpSlrMZtgyAhojxCjF2kpC2NPKjFGx7rIxlesE1+LmRnsupFXb" +
       "a/BzCqM8MbCisuFNVrIMF4AdOe5obKbrFRsqiSBUWB2tNkh81LZaOmk1i3Kt" +
       "hAQVr1SDUcXQSKuI9nBpQ63njI3QvYpX1GpTtzHb9MsCKQsMOy4Ytuj6UeSW" +
       "hpOZ7bvd9ppzeSZZhyUClV3D4MihUusjw7ZH90h30JLRqdmaL2y/iC/GIdOP" +
       "iILkdPoO0eHTzsDpalIHXFvqFDrW+gojFOWUhXErKNSHI3NDwGbZ3awwikUx" +
       "erkIyuiyowv1cF2mK27bbktlHo/q/fI8bWuwmraDil/H7J7DaugADQpzamCg" +
       "wOQYF1MMlm8uKFgIe6xvjma9pjMWFt1Bs+S5dGQVad4hB6OFPZqx84VuC4VN" +
       "oJicWm4GXgUpisYgKY3pwsCaclZcVoRJl2T7ZBDiIT2sB5NZBPdluqroms10" +
       "C2q/hG9kDZvGmyHZVPnyBlu3ZvS8O7Xt9ozE2UXTXteWppt6XdVvSei8GDQL" +
       "sLYUzIFZwwDXIRa1zeqIIJL2vDzSOUtzHGShOEtZNUpYFSV4ZyNoYl8iFm4H" +
       "7ZOhg1EG8F8NHafswOLW1aiFDlo1fDCeKgzRxeexvsA31Qnlkuo49fqbrtpq" +
       "LlB56jRoOZZpF1a9BToVO0GtsRErw3avEGHWYtVpMHRsr+aqNMX0Vk+DaaWs" +
       "EWmtXO2NvU4q1ds9y++J5SBkF1Tf3LQHGyLyQr6upXGDMkqLVZnDa0wBKwRr" +
       "fGR24MZUdESyxdhdY7JoR0KPWqEhCOoq46bqYMmN6zLObVgrbid1pYyvxl2N" +
       "QldLTpmr9FrQk0ZglhWPssiEiYLu2G8iup2SGoIYDFLiS0xNGvfndosV0jZM" +
       "dLFQYqex2fPoVmMpEC6LNZCauJHriKZzeNidST47k3gQJ+ami/Um2MzlvDVb" +
       "h5FGbRn2GrplBOt0wRpEix40AqXH99sNWVkwNs8uY29lmILJMqueKS0JuAMT" +
       "fNqLUL/V5EJvXay1wnSDbtSaJ8wHU2ZK+whakpIWZ8Ddqa4LMYMgfru4sphA" +
       "UkrFKexOuVm1VOoPN0WaTroV3ofhBC4oSqPp+UMfw+Lloj3rm6RHANeBUVdi" +
       "NVYl21XB7tIRL0yNtjvprLs12qHnmDHkul2hPU46qjZzmmjfYWZRSxCH8tIT" +
       "4lVNCVooXOtN+LDG9HBbIMgU3FDITmc6GdBFt04NtICWdRmrJa0QHvT0om5G" +
       "5dRsdshpS/JCDONHkajqQx5NDbgS6ctGZd2gCrLVrQ4JpmpuBrbYs12l2xwr" +
       "HjYd0pXESNQCNfMHLiks2ouF2INlk9YKIqIUVIawV8sJzaFmAdH7HN2oT1Te" +
       "rhqtadsVyvwwLToyKxjNEJ8J2NQbjlSapuJQrBANwg7nKCqJlqz34WaBYIti" +
       "Y1KfFuPlEuEogyujBmKgCjsNOCY1QJCJI8+1m65oVmJHHM3nneF66fmNSa1W" +
       "EZA6cI1Src+MWlIaJgVWWrFIw2cEPZ7GGIzPlhyneKWYK1WiBtzi0mWrYqcp" +
       "RynTDVzXxr2S0bIXujPtwIu4WlIDdlDotEwHpweTfuJX/HJho+CGq1YwLhxG" +
       "w25dFVSsHI7WSVuJHIqIQ7k4C7vl3rwwbRiExcHgqI03aRWvreqMYYyxYqJ1" +
       "o826V67XJopdXhvDeNrvNjt0GeuX+iACDVvNKmzDPZrkqGnNhLsDa4DjTYZY" +
       "M7iPJ4nup3B3VRkLNGc05kFCtVfWqlntDmSqns5ScTxhEtXqKnC5xJIF2fDg" +
       "SdkZ0HOjFg7xUVHuuU1wwjRIuCUrZNRz00HVxuWeUt0UqOISVSvrts8OO1RU" +
       "QfGgMFDGvjmkyS44d6akPrUDtlofFm0mnQV13TWZlr8cDCmfGVOYuYCLupFs" +
       "RnqlORGScTeeDKjZplQfVft4EWjED0fEXFvQqyKdBgVZj2lnBDNcyUgZtVAV" +
       "MIncxPgwmXbwmcYtNNUKl2Oqr6yry1mFqig1vl6qlRdVRls6HXbGRXixabbL" +
       "GEzZUzosznB3xTnmcq1v4s5kuZTWU6mEjVCPnw5xISqQtZDrVwalnt5sr7SW" +
       "EvjFudlZe0PSTGNYV6ylkaQGuHIvmn5SdSuam5bjSWkJr8SGWgpXOK3y1ZHY" +
       "5VZMo8eUsEpcri+rDst4oebyVLxoVQzTYppEoPm+zIeL6tK2SHTMB0RhSA40" +
       "idZTyw37MdeN4p6ltkTJWJB+oSGyJiHNCqkV+tYKQ020AgdJP6jJhFlINYw0" +
       "qkq0MUtisjCccqFRQPozXiuu2lHI4h7fqg3DZNrj2bjOKctBEfbMCoKYo3rb" +
       "85C5Wah1cF3liwG6Uuq0skG1Wa8/6Y+tjdZpsey8pszmVVlgy8hc7ZHtOlB/" +
       "I1ykTaTotjoNWFRnyCBMrTo9QTCLnMiLAUWAVD5L8a/9ZLesO/IL5cGzAbhc" +
       "ZRPUT3C72E49kjWPH5Ss8s/Zk6XmoyWrw8oElN2YHrjZa0B+W3r1+Zdf0fqf" +
       "Qnf2KjpSDF2I/eBnHX2pO0dIZbfWp25+M2Tyx5DDSsMXn//n+4X3zJ7+Caqt" +
       "D53Y50mSv8u89mXyCfXXd6DTB3WH655pjiNdPV5tuBjqcRJ6wrGawwMHkn0o" +
       "kxgCvrt7kt29ccXzhlZwKreCre5PFMx2coCd/ULCXVnpbVVS8zp49uSne3mp" +
       "kMqRk7eotm2yBtxSL5t6nFUqkljX+Hjj6PukHztKOivo4TyfA7SAtLK66L4G" +
       "ctNb/LiL7bGCVwxdOlG0zyqQ9133ILh9xFI/+8ql8/e+MvrrvG598NB0gYbO" +
       "G4njHC0BHemfDULdsHJeL2wLQkH+83wM3Xezp4QYOg3afL/PbaE/GEN33wga" +
       "QIL2KOSLQJYnIWPoTP57FO5DMXTxEC6Gzm47R0FeAtQBSNb9cPDWVdaD9489" +
       "Oa5PHXfZAwXd+eMUdMTLHzvmm/lr7r4fJdv33Gvq669Q7AferH5qW5MHFpGm" +
       "GZXzNHRu+zxw4IuP3JTaPq2znSd/ePvnLjy+Hzdu32740EOO7O2hGxfA224Q" +
       "5yXr9A/v/f13//Yr38zrWv8L3AaL7mYfAAA=");
}
