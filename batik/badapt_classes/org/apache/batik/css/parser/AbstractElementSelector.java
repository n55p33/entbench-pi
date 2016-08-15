package org.apache.batik.css.parser;
public abstract class AbstractElementSelector implements org.w3c.css.sac.ElementSelector {
    protected java.lang.String namespaceURI;
    protected java.lang.String localName;
    protected AbstractElementSelector(java.lang.String uri, java.lang.String name) {
        super(
          );
        namespaceURI =
          uri;
        localName =
          name;
    }
    public java.lang.String getNamespaceURI() { return namespaceURI;
    }
    public java.lang.String getLocalName() { return localName; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ya4wcRxHu3fM9fW8/8ePOvqwdne3sxjg2Mmeb2JtzfM7e" +
                                                              "Q3e2JdbE697Z3tvxzc6MZ3rv9i6YJJbABonIOI5jEPEvB4NxHkJEgESiQxEk" +
                                                              "UQApiXkEFIPgTyBYxEIEhHlV9czsPPZhRUKsND293VXVXdVVX1XP1Ruk3jRI" +
                                                              "D1N5lM/qzIwOqnyMGibLxBVqmgdgLCU9WUf/cuTdke1h0pAk7TlqDkvUZHtl" +
                                                              "pmTMJFktqyanqsTMEcYyyDFmMJMZ05TLmpokS2RzKK8rsiTzYS3DkOAQNRKk" +
                                                              "i3JuyOkCZ0O2AE5WJ2AnMbGT2O7g9ECCtEqaPuuSL/eQxz0zSJl31zI56Uwc" +
                                                              "o9M0VuCyEkvIJh8oGmSjrimzk4rGo6zIo8eUrbYJ9ie2lpmg7/mOD26dyXUK" +
                                                              "EyyiqqpxoZ45zkxNmWaZBOlwRwcVljePk8+QugRZ6CHmJJJwFo3BojFY1NHW" +
                                                              "pYLdtzG1kI9rQh3uSGrQJdwQJ2v9QnRq0LwtZkzsGSQ0cVt3wQzarilpa2lZ" +
                                                              "puITG2PnnjzS+a060pEkHbI6gduRYBMcFkmCQVk+zQxzdybDMknSpcJhTzBD" +
                                                              "poo8Z590tylPqpQX4Pgds+BgQWeGWNO1FZwj6GYUJK4ZJfWywqHsf/VZhU6C" +
                                                              "rktdXS0N9+I4KNgiw8aMLAW/s1kWTMlqhpPeIEdJx8gDQACsjXnGc1ppqQUq" +
                                                              "hQHSbbmIQtXJ2AS4njoJpPUaOKDByYqqQtHWOpWm6CRLoUcG6MasKaBqFoZA" +
                                                              "Fk6WBMmEJDilFYFT8pzPjZEdjz2k7lPDJAR7zjBJwf0vBKaeANM4yzKDQRxY" +
                                                              "jK0bEufp0hdPhwkB4iUBYovmO5++ee+mnvlXLZqVFWhG08eYxFPSpXT7G6vi" +
                                                              "/dvrcBtNumbKePg+zUWUjdkzA0UdEGZpSSJORp3J+fEfffKRK+y9MGkZIg2S" +
                                                              "phTy4EddkpbXZYUZ9zOVGZSzzBBpZmomLuaHSCP0E7LKrNHRbNZkfIgsUMRQ" +
                                                              "gyb+g4myIAJN1AJ9Wc1qTl+nPCf6RZ0Q0gkP6YGnl1g/7BNOsrGclmcxKlFV" +
                                                              "VrXYmKGh/mYMECcNts3F0uD1UzFTKxjggjHNmIxR8IMcsyck08TIBCCM7U6D" +
                                                              "r1OJIywA+wRTGDp+FP1N/7+tVESdF82EQnAcq4JgoEAc7dOUDDNS0rnCnsGb" +
                                                              "z6ZetxwNg8O2FidbYPGotXhULB6FxaPW4tEqi5NQSKy5GDdhHT8c3hTAAOBw" +
                                                              "a//Eg/uPnu6rA7/TZxaA5ZG0z5eP4i5WOACfkp7rbptbe33zy2GyIEG6YdUC" +
                                                              "VTC97DYmAbikKTu2W9OQqdyEscaTMDDTGZrEMoBX1RKHLaVJm2YGjnOy2CPB" +
                                                              "SWcYuLHqyaTi/sn8hZlHDz18d5iE/TkCl6wHeEP2MUT2EoJHgthQSW7HqXc/" +
                                                              "eO78Cc1FCV/ScXJlGSfq0Bf0iqB5UtKGNfSF1IsnIsLszYDinELUAUD2BNfw" +
                                                              "gdCAA+ioSxMonNWMPFVwyrFxC88Z2ow7Ity1S/QXg1u0Y1Sugydqh6l44+xS" +
                                                              "HdtllnujnwW0EAlj54T+1C9/+octwtxObunwFAUTjA948AyFdQvk6nLd9oDB" +
                                                              "GNC9c2Hs8SdunDosfBYo7qi0YATbOOAYHCGY+bOvHn/7N9cvXQu7fs5Js25o" +
                                                              "HGKEZYolPXGKtNXQExZc724JIBGjDB0nclAFF5WzMk0rDGPrnx3rNr/wp8c6" +
                                                              "LVdQYMTxpE23F+COf2QPeeT1I3/rEWJCEqZk12wumYXzi1zJuw2DzuI+io++" +
                                                              "ufrLr9CnIGMASpvyHBPAGxZmCAvNl0OFJjgx+0at7Ivj28SpbhU0d4v2HjSH" +
                                                              "4CRibjs260xvdPgD0FNYpaQz195vO/T+SzeFLv7KzOsMw1QfsPwPm/VFEL8s" +
                                                              "iF77qJkDunvmRz7VqczfAolJkCgBQpujBuBo0ec6NnV9469+8PLSo2/UkfBe" +
                                                              "0qJoNLOXiigkzeD+zMwBBBf1T9xrHf1Mk5OfiqRM+bIBNH9v5YMdzOtcHMXc" +
                                                              "d5d9e8fli9eFG+qWjJX2OUBW8MGuqO/dyL/y1sd+dvlL52esCqG/OtwF+Jb/" +
                                                              "Y1RJn/zd38tMLoCuQvUS4E/Grn51RXzXe4LfRRzkjhTLMxmgtsv70Sv5v4b7" +
                                                              "Gn4YJo1J0inZ9fQhqhQwjpNQQ5pOkQ01t2/eXw9axc9ACVFXBdHOs2wQ69wM" +
                                                              "Cn2kxn5bJXjrgydih30kCG8hIjoPCJY7sdlYDhrVuDlpxV2YkLnZwfEhEVoW" +
                                                              "XmL7cWwSljfsrOp8g/7NYrnUby/XX2Wz4zU3W40bgFHRJKqM2HYL7nSixk6t" +
                                                              "qTtFuwGbuyzv5nB7KqThEspJE7XrFBd0xa/Dqf2ctxd03UAJOYDVi7XQzBZJ" +
                                                              "lEAmlaKBugdRY3W1cl5cRS6dPHcxM/r0Ziukuv0l8iDcAJ/5+b9+HL3w29cq" +
                                                              "VGLNXNPvUtg0UwJBvNoXxMPipuNGxDvtZ3//vcjkng9TNuFYz20KI/zfC0ps" +
                                                              "qI4Lwa28cvKPKw7syh39EBVQb8CcQZHfGL762v3rpbNhca2zQrXsOuhnGvAH" +
                                                              "aIvB4P6qHvCF6R0lR+lGv1gLzzbbUbZVrkIqOmEIu4cDqb6lhrAaaU+vMSew" +
                                                              "8RhktEnGR4JR74bR1O0Cvna2wYG4tY2s3z4YPDttlXbWsA82+XJrVGOtofGJ" +
                                                              "GnMPY1MEAARrJHyw4ppi9n9hClhjWZUrEKbm5WXfX6xvBtKzFzuall08+AsR" +
                                                              "kqV7fSsEV7agKN7k4ek36AbLykLBViuV6OJ1ipOVNe5oCIOiI5T4nMXzBbjV" +
                                                              "VOLhpA5aL+UXoUwLUnJSL95eujOctLh0sKjV8ZI8DtKBBLvn9Ao1oJVxiyEP" +
                                                              "utmmFye25HYnVmLx1ueISeJrmYMfBet7GVwnL+4feejmtqet+4Gk0Lk5lLIw" +
                                                              "QRqtq0oJg9ZWlebIatjXf6v9+eZ1YdsDu6wNu56/0uOeccAFHf1jRaByNiOl" +
                                                              "AvrtSzte+snphjchDRwmIcrJosPltUlRLwD4H0648O/52ipK+oH+r8zu2pT9" +
                                                              "869F9Uesq/aq6vQp6drlB986u/wSlP4Lh0g9ZCxWFEXTfbPqOJOmjSRpk83B" +
                                                              "ImwRpMhUGSJNBVU+XmBDmQRpR1emWMkLu9jmbCuN4u2Sk76yD2YV7uRQKc8w" +
                                                              "Y49WUDMClSFfuCO+z3gOjBd0PcDgjpSOcnG57inpvs93fP9Md91eCEefOl7x" +
                                                              "jWYhXUoR3i97bs7otIDtP/ALwfNvfPDQcQDfUF/G7a9ca0qfuaAkt+bqUolh" +
                                                              "XXdoG7foVoh8DZuvF3Gck9AGexSxKORmmG+K9a+ILjbP/BcP/e0X5RcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "jo3atJ/iIm2RmG1JXTyaq4NZaVJUrIoyEKoq31YSFvYR0YjMaI1YdaOpYDRc" +
       "KciNQpspxWhDWY0ppjft8etROEdGMY2ve+40YXnDi3pU0lyHYgmG18rSdOaN" +
       "YS9qzVIU6XbgVCcQL1h1ykwsoXVl3eW7cS3YLEoNEh/3ZYAmfbGtU0ytiq5L" +
       "vif3FoqEpn1/GnDRwqHWWFvqgHSNr67aa6JVHSDWoGBR6+KcSVNZHsni2Dc7" +
       "K84mO1FZaa7kqrXwMUkaFdasoMX1wcIMSYcalOlBrSwPihxCrB0JjWdUOZyh" +
       "QSktz/hmGFpTeRJgdbQwpf0xxYWuTtGUw/KzIkti2MCn25u47HlGw2ksCGux" +
       "nIgjn+zKdmUy1afVZI2H3bSVRpJlIfUCFgzM1bimCwE5rknzbq9mljWzVMVk" +
       "ZmMy+NiIxlWOLhoeN+5pFZfocEanMiw77DTF5eV4zDELD6tITGE0dUcxM3Jo" +
       "gWlUtGjJKSGzQILuclwXO/Vm2MVxZu00MLfo0uPE2JB8FNp2a6OhlfbMGdtM" +
       "Uoy0jqDRPngtgggNa9Q4dphCWde0pR2utLBQpkyEMSsW04n7g1W4Qlx63hAn" +
       "liZ3pHA51avrRkETizM1aEbVuBdVqjAScZqiYC0Q08uBhG96Bmdhaz8U0lAr" +
       "BI63WCqL5iC2O4pPuwFvhSNrwMTNchupluscXEENr1tw2wW/nkaoN2zUq41W" +
       "Y6QFK1haVdd9r6r6Fg5aIxjEB18GFgONiGTSIqdDXeZXHM3ZS2HgmfUS3rHj" +
       "gccuRpRA9/DxqDC18abdH3iDomZPWJOJGktbJqJeOUIFs1bdNNHZuBYN+l2l" +
       "Hs/KIDVvsoQltPSI4Appac4tQfzwSnO+9AROcahKzXC8ddAo6XyDVRtFjSA1" +
       "nbNqyXIyW0xH7qBkNGpyUHPDTjPkYYyJ9d5a55t9pd/URy2YqkkNRUJWeiRh" +
       "ZliQVyPXWkynqkvVdHfsLupNMVq3SpRiNjBKS4Skyw1smyp0G1KhwyxlHsYV" +
       "HtaQaWWggA3RU09lWyXrR9ut3p1vwg/urH6M7Xdy4wF38gFD6Jy0d1B/eFCa" +
       "fy7uX37sfx89KD08Hzu1f8j4cHYZEJeU/A4gkJTdEwf/2fb1wZvdZ+Vb1xee" +
       "ufa8yn28uLN3/jgPofOh6/20pa0168iQO0DSkzffprP5dd7hudgXn/mnB4Zv" +
       "WbzjR7gOePiEnidF/jb74pepNyof3IFOH5ySXXfReJzpyvGzsQu+Fka+Mzx2" +
       "QvbgwQrck034o+Cp7q1A9eSx0qED3PhMabR1oFsc7773Fn3PZsV7QujiXAt7" +
       "J0/LDt3umVc6HDgqN29413ETM8d6as/Ep/7vTfzgLfquZcUvh9AdwETm2LHb" +
       "oX3P/Sj2JSF0300uvbLj+/uvu3Hf3hIrn3n+4rn7nh/9ZX7vc3CTe56BzukR" +
       "yJqPnKceqZ/1fE03ckPOb09XvfzrN0Podbe4lcsO/fJKrv1vbHmeD6HX3Ign" +
       "hE6D8ijlb4XQpZOUIXQm/z5K90IIXTikA4NuK0dJPgGkA5Ks+knvBhcV20Po" +
       "5NSRuN9zoXxl7nmllTlgOXqJlGFF/v+I/biOtv+QuKp89nm6986Xqx/fXmIp" +
       "lpSmmZRzDHT79j7tABsevam0fVln20/84K7PnX98H8fu2ip86M5HdHv4xtdF" +
       "pO2F+QVP+vv3/e6bP/H8N/JDz/8BOgVwBrgiAAA=");
}
