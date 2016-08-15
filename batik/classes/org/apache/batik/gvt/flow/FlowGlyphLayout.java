package org.apache.batik.gvt.flow;
public class FlowGlyphLayout extends org.apache.batik.gvt.text.GlyphLayout {
    public static final char SOFT_HYPHEN = 173;
    public static final char ZERO_WIDTH_SPACE = 8203;
    public static final char ZERO_WIDTH_JOINER = 8205;
    public static final char SPACE = ' ';
    public FlowGlyphLayout(java.text.AttributedCharacterIterator aci, int[] charMap,
                           java.awt.geom.Point2D offset,
                           java.awt.font.FontRenderContext frc) {
        super(
          aci,
          charMap,
          offset,
          frc);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALUZDXAU1fnlEkLID/mRPyMJEAIaxDul0mpDrRAScngkNwnS" +
                                                              "MaDHZu/d3ZK93XX3XXLBouJUoXXKWAtIO5p2plgog+I4dVrbYukwRR2tM6Kt" +
                                                              "Rcef2k5ra53KdKqd2tZ+33u7tz93F0c73sy+23vv+3nfz/t+3h1/h8ywTNJO" +
                                                              "NRZmkwa1wr0ai0umRZM9qmRZm2EuId9XKf39prcGrg6R6hEyOyNZm2TJon0K" +
                                                              "VZPWCGlTNItJmkytAUqTiBE3qUXNcYkpujZC5ipWNGuoiqywTXqSIsAWyYyR" +
                                                              "ZokxUxnNMRq1CTDSFoOdRPhOImuDy90xUi/rxqQLvsAD3uNZQcisy8tipCm2" +
                                                              "QxqXIjmmqJGYYrHuvEkuNXR1Mq3qLEzzLLxDXW2rYGNsdZEKOh5pfO+DezJN" +
                                                              "XAUXSJqmMy6eNUQtXR2nyRhpdGd7VZq1bia3ksoYqfMAM9IZc5hGgGkEmDrS" +
                                                              "ulCw+waq5bI9OheHOZSqDRk3xMgSPxFDMqWsTSbO9wwUapgtO0cGaRcXpBVS" +
                                                              "Fol44NLI/vtuanq0kjSOkEZFG8btyLAJBkxGQKE0O0pNa20ySZMjpFkDYw9T" +
                                                              "U5FUZadt6RZLSWsSy4H5HbXgZM6gJufp6grsCLKZOZnpZkG8FHco+9eMlCql" +
                                                              "QdZ5rqxCwj6cBwFrFdiYmZLA72yUqjFFSzKyKIhRkLHzOgAA1JlZyjJ6gVWV" +
                                                              "JsEEaREuokpaOjIMrqelAXSGDg5oMtJalijq2pDkMSlNE+iRAbi4WAKoWVwR" +
                                                              "iMLI3CAYpwRWag1YyWOfdwbW7LtF69dCpAL2nKSyivuvA6T2ANIQTVGTwjkQ" +
                                                              "iPUrYgeleSf3hggB4LkBYAHzoy+fv3Zl+6mnBMxFJWAGR3dQmSXkw6Ozn1/Y" +
                                                              "03V1JW6jxtAtBY3vk5yfsri90p03IMLMK1DExbCzeGrozA23H6Nvh0htlFTL" +
                                                              "uprLgh81y3rWUFRqbqAaNSVGk1Eyi2rJHr4eJTPhPaZoVMwOplIWZVFSpfKp" +
                                                              "ap3/BhWlgASqqBbeFS2lO++GxDL8PW8QQmbCQ+rh6STiw78Z2RbJ6FkakWRJ" +
                                                              "UzQ9Ejd1lN+KQMQZBd1mIqPg9WMRS8+Z4IIR3UxHJPCDDLUX0uMsklL1CXBY" +
                                                              "fWKDOmlkYtIkeFMYvcz4lOnnUb4LJioqQPULgwdfhTPTr6tJaibk/bl1vecf" +
                                                              "TjwjnAoPgq0ZRrqAZViwDHOWYWAZRpbhAEtSUcE5zUHWwsBgnjE46BBp67uG" +
                                                              "b9y4fW9HJXiWMVEFukXQDl/G6XGjgRPCE/KJloadS1674nSIVMVIiySznKRi" +
                                                              "AllrpiE0yWP26a0fhVzkpoTFnpSAuczUZZqEiFQuNdhUavRxauI8I3M8FJyE" +
                                                              "hUczUj5dlNw/OXVoYveW2y4PkZA/CyDLGRDAED2OsbsQozuDp78U3cY9b713" +
                                                              "4uAu3Y0DvrTiZMMiTJShI+gLQfUk5BWLpccSJ3d1crXPgjjNJDhXEALbgzx8" +
                                                              "YabbCdkoSw0InNLNrKTikqPjWpYx9Ql3hjtpM3+fA25Rh+euFZ6V9kHk37g6" +
                                                              "z8BxvnBq9LOAFDwlfGHYeOC3z/35M1zdTvZo9KT9Ycq6PRELibXw2NTsuu1m" +
                                                              "k1KAe/VQ/JsH3tmzlfssQCwtxbATxx6IVGBCUPOdT9187vXXDr8Ycv2cQcrO" +
                                                              "jULlky8IifOkdhohgdtydz8Q8VSICug1nddr4J9KSpFGVYoH69+Ny6547K/7" +
                                                              "moQfqDDjuNHKjybgzl+4jtz+zE3vt3MyFTJmXFdnLpgI4xe4lNeapjSJ+8jv" +
                                                              "Ptv2rSelByAhQBC2lJ2Ux9UqroMqLvkCRpZxTCwlwoXCLtmTAd3JkGCjjHIl" +
                                                              "+mtRPH3DuVGLcV4iUW2rO/Nz63t/fFQkqo4SwIHsd/RIjfxK9swfBMKFJRAE" +
                                                              "3Nyjka9veWnHs9x/ajCo4DzuvsETMiD4eJy3qWDX2WjGZniute16rcgiW//P" +
                                                              "KI/1nTTBImmqZ6GWYBkITmmWcZLIp0k+D8ZYVj7meWwy9f2lz902tfR34EIj" +
                                                              "pEaxIK6CnkpUMx6cd4+//vbZhraHeZipQnXbqvaXgcVVnq9441ZoxGFN3irt" +
                                                              "DnFTycKBH7fdYVV8u7y3M87dAfE+L0z4IXwq4PkvPmg6nBAmbOmxq5HFhXLE" +
                                                              "MJBb1zT9g59pZFfL62P3v/WQ8MFguRYApnv3f+3D8L794lyLmnZpUVnpxRF1" +
                                                              "rfBIHNbj7pZMx4Vj9P3pxK6fHt21R+yqxV+h9UID8tBv/vNs+NAbT5coDioV" +
                                                              "uy+5EgNdIa3P8RtACLT+q40/u6elsg9MHSU1OU25OUejSS9FsKqVG/WcN7dW" +
                                                              "5hNe0dAwUHGsQBsUb2Chr67gLaqb2o698LlfH/nGwQkh8DTmC+At+NegOnrH" +
                                                              "m//keijK5CUsGsAfiRy/v7Xnmrc5vptSEbszX1ygwfFxcVcdy/4j1FH9yxCZ" +
                                                              "OUKaZLsl3CKpOUxUI3BALKdPhLbRt+5vaUT93l0oGRYGXcrDNpjMvZaqYj6r" +
                                                              "NIvDV0F4+rqBY1zMxxU4XMYtE8LXMAOiiiapHG89JEeVBxv8FcVhrceiIYHn" +
                                                              "ZA+Rd1AO6Ih0jWIKc9ZE1ano4UI3CoulfKPN5xubeBhxFf3q7Ht//3hnet3H" +
                                                              "KTdxrv0jCkr8vQisvKK8uwW38uQdf2ndfE1m+8eoHBcFfChI8gebjj+9Ybl8" +
                                                              "b4g3vMIDihplP1K33+61JoXOXvOfyaXC+tx6wvQ4XMoNzH9fXrAD4XYQQXds" +
                                                              "mrUsDhnwFRkNLfxiGnCjaBbrlEWlK6DerMF4zbLzx/N/uObI1Gu8WDPyJOgt" +
                                                              "+DOedzxsLqcGeTKMeRKaVwh+q9Y7q4sKqyk42eE+GIagLaWmfXXCt7l6GhF2" +
                                                              "4rDM8pb/fhfx3A0l5HtefLdhy7tPnC8KRv5qd5NkdLsHdDlmhPnB9qxfsjIA" +
                                                              "d+WpgW1N6qkPePquk2TItdagCQLkfbWxDT1j5su/OD1v+/OVJNRHalVdSvZJ" +
                                                              "vM0gs6C+p1YGOsu88UW7DpqogaGJi0qKhC82HU5Ydhi4yFNADhcKrQUIeBU8" +
                                                              "y+1Ca3mwS+CtaLMbMKJghTQ1W9787uH3d++5KoRl6oxxDJAgX5MLN5DD+627" +
                                                              "jh9oq9v/xt3cM4DyQ0j0K6XDWqUd1qotflWGv7YFSv350+yUkbrhwb7Nif4b" +
                                                              "4v29AxxvnZ2+8avP876RkSo5Y0eXIj8VfRGOt+Bwp8C5tawNSmjzYnuPF5fQ" +
                                                              "Jr7cRcjiOnw5MJ0qcLi7nBrKsWCkaaR3aDDxpej6zf2J4fjanl6c3xeQ6uAn" +
                                                              "kOoSm+Ul00jVgC9Tn1iqciwYafZItXEwOtA7VEqs73xMsVbD02Xz7Crp+t5c" +
                                                              "6fRXV9694dxY6/I8OH+P4/wGWYxYRz6x6OW2AbG7rBWPTiNu3pNBCtz4p5oE" +
                                                              "ruc83DyxgmCUayt3g8pr3sN37J9KDj54hVP+X8cgbOnGZSodp6qPFITTwDUX" +
                                                              "JpYFRbfo4uZXfniqsWb+1PUviX7GuZ2th0IglVNVb/3kea82TJpS+EbqRbA2" +
                                                              "+NdPGLmw7O0bhAL84pt9XMCfhCqoFDzU6TB6IU/BaQtCgr34txfuNCO1LhyE" +
                                                              "OPHiBTkD1AEEX580Cm1+yW3ztt+jyXyF32oF95j7UafBY+ilvmzJ/wRxip+c" +
                                                              "+BskIZ+Y2jhwy/nPPiguhWRV2smTbR00HOJ+qlBALSlLzaFV3d/1wexHZi1z" +
                                                              "XKdZbNh18Is8Od2C4Gygw7QGbkyszsLFybnDa5741d7qs3Aot5IKCarcrcX1" +
                                                              "et7IgU9vjRU3VlBs8quc7q5vT16zMvW3V5yUFeiDgvAJ+cUjN75w74LD7SFS" +
                                                              "B6kQTgXN80Zi/aQ2ROVxc4Q0KFZvHrYIVKCk9nVts9G3Jfx7hOvFVmdDYRav" +
                                                              "FBnpKG5Yiy9ioXqYoOY6PaclkQz0fXXujO/fGfu81OYMI4DgznhuBAZF6kRr" +
                                                              "gJMmYpsMw+nna1cZPG7Ey6fSl/krDq/8D0M2M34gHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ulsNFUFijWqLjlqcUiPqPRATm5OeZOfRLmKoXHJJsdGsV5VmEKG4FzfoISGG" +
       "ciivqmrcpPV5O7X4ObpwOlErSORm0EhnVWw3SpfoopHPKdUk9RQfwPLcYpuN" +
       "bbPOkM0pNe1g9mSmr9hWRTARcVLjuUUm1yeVISWk/XBNL4aE3XYXcdTuoQMt" +
       "axpcSi02CrnmxZTquP6w11ibedv0VsHa49bYWJQde7KrgBiRWByi9bSkVeXW" +
       "I7pO6jvXSDq4QGE2H+qD0WbtR6Mt7LpiVRbGvWY3x7Spg9ghGSAtsjKqjdC6" +
       "3p/gePG4/rNv8aypPBY5+UrGcprFxE+9hZOC7Mzh9cmJU/l3FbrwZcWZE6cz" +
       "56JQcXL7zL0+filfIr3+yVdfU7ifqR4cnSd/Tww9HHv+dzlqCrLy2aVi6PqF" +
       "LxSK161P3fEB1P6jHfnLr11/6F2vzf9o/yrz+MOahxnoIS1xnLMvT870r/qh" +
       "qpklIQ/vD6D98ueXYug77vnhRAxdLn5KYn9xD//LMfT2u8HH0AOgPQv5qzF0" +
       "4yJkDF0pf8/C/VoMXTuFi6Gr+85ZkP8AVgcgRffX/ZOXynclu3zJfEaS2aXz" +
       "Wjsxjye/3UHSGUW/cO4NQPn92vF7l2T/Bdtt+SuvDdiPfxP7mf0nCLIj7nbF" +
       "Kg8x0IP7ryFO3t28556rHa91tf/ytx7/+YdfPDadx/cEnxr4Gdqeu/v7/u7G" +
       "j8s39Ltfete/+9C/fu3PyxP1fwBGV0xoWCgAAA==");
}
