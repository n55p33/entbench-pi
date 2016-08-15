package org.apache.batik.css.engine.sac;
public abstract class AbstractElementSelector implements org.w3c.css.sac.ElementSelector, org.apache.batik.css.engine.sac.ExtendedSelector {
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
    public boolean equals(java.lang.Object obj) { if (obj == null ||
                                                        obj.
                                                        getClass(
                                                          ) !=
                                                        getClass(
                                                          )) { return false;
                                                  }
                                                  org.apache.batik.css.engine.sac.AbstractElementSelector s =
                                                    (org.apache.batik.css.engine.sac.AbstractElementSelector)
                                                      obj;
                                                  return s.
                                                           namespaceURI.
                                                    equals(
                                                      namespaceURI) &&
                                                    s.
                                                      localName.
                                                    equals(
                                                      localName);
    }
    public java.lang.String getNamespaceURI() { return namespaceURI;
    }
    public java.lang.String getLocalName() { return localName;
    }
    public void fillAttributeSet(java.util.Set attrSet) {
        
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/wEvdmPcgx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "nVlTubFziGVGblrZuDacDHieTNmsypIpXW91fKaj1GJz7o9Fvx+4eu4tlfGq" +
       "FeWyEg2paMpWk/aGDWU/DVx3SlijETnZT3Cz0+X9JJtHYSylY8JQZGKB4QvS" +
       "I+x9KPE9SZWZajuV6TbVbnLdAd2ZSxrLMTE5jGRpjEn9bhCReyqT1WQ7i8hR" +
       "HK+3NnQL3VqYvBXUlE3Nsac6OY8GFcttyHLSZ5zaLOJWOFuR1VlNsIbNfEdX" +
       "nUmQpExjHPXq9F7dVzsamc+pkJG7OJ2BwX5SazHkJum0adtTJpbJmywnA38m" +
       "bGzO6PT5pi2m7UWbNMdw09in+/EgmVakmTeRE03uuOsBtl+KU7ZXywBjDYN5" +
       "v80qArsx2NUo30stvlvBJA0nKs2pg7Zqi6ayrg0Hdie37Y2arQnDpYPuVKxG" +
       "ubTv61JbadZ0V9vyuRfvp+xYGih1MGB1bGd6XcKP5/GkUZny7WRYFceukVN0" +
       "N4uYTb264yqpHmlLKlWttCvv6HxM+tx2GOWpF2Ss2x4xYjaqsFbeqRLYDh2R" +
       "zUrFSzFuEwbJbFtdztfLrrmedEfTobtd02GPFJTJ1OEMhVeDrd5MFxbujrUd" +
       "JcteFOq4py2VVqbKbmJv+WiyG9E9Ndi0pzW939pudZ4ksY1JS0SjmlJSd0Qo" +
       "3R6hzSYVx+12s2WrvmXpla4G44Ux5wFLOr7YwJhO26O0pbGWzE6TMO046Nf2" +
       "7cV6tZ5JQaXN+MRemfWzDTPuK/W1IteTZFoXyFl9bPGj0axdTa2muU/JfJeh" +
       "YaB08bkhTKjhnhvvuv6w0xH7VSzuSPkqkElsXDPSlFDNTa/JtFV2mctCbo06" +
       "S2fYdjttq2NxvaDdTntUZz622pK9XNWUZs+qrmRrQOjtnkVN4VyNFgzDkuta" +
       "TAOq29iMnVZ7KMWWnM2agOlnrWU3i5n5aus6YTNvJBt/O8vGtGPVpFwe8SCJ" +
       "e+N2qugZS6D+RqGqOyDlKTtGRyBQV1FnYsnNzaYepdKyvs8pNGq4YK7tZ7W4" +
       "P5qmVd91tmK+aYpNVt0rqNFTYWojNtpwj2hvV11y3ehVppka143Uj21iahho" +
       "RZhPMHypMO6g1wsojd9H9dkSYFEf9PKpEIV0SjGpU9Ed0BoxUTzobr1IrLad" +
       "Lb7ix8N2TehTQiWQ2vut15XiLj9JM03OmUlWW++TaMKt4+5uRFAxtu5RdLWf" +
       "p76njGb4OqqnkVINF5Oc5IYSLXXqiy67wtGKhzONqpMLuOtKimlNu20w0EUM" +
       "pzLap+1RnuH43E873mTXqlRaDUMRw5hwzc7Sn9oYtuwmmLfsBNFAthpuYmKo" +
       "5yYVQjcpfFuZbmAmrTg63BycKHRIfbyqOp3+FKrK94iN1QOjkSfpZBRXdbpX" +
       "C43hJl1TGBq7VW1UXZvkTuPoWsdKW4tNTTVBe7hDG2O+IfiLcJdt5dl+Opu2" +
       "SYBpeUZN3RyduAuXVIwO52Q0nmfbQcvbyvgYXbZTTpOHktIWqHDU68zVvM5v" +
       "p4uOzfotdjrIyUY9MMSZOfYo+GJD9nQrEAaRtlhynEhWJ73RmK5MeDXXK3zg" +
       "dZeCKS5kvdkZRtVdLkSDucoYHBp1N3GHFMWuKi4Udyu2Y1yZ4FGikapgWtW8" +
       "G/VHlE3V8HnUcZIlFSb8WK7iLQKrAC8UycbYl/DZessPBJd3BpOVOp7jLKr4" +
       "+25XMIUWTbix11ylem0u0NTKrA4Yd1FLiWUrytiVoY3MhY/TFWBW1m2BGPDT" +
       "qce0Xd0cdEe9JW3OKk5rg6PoFiwIwuD5uNdi1TnEjdaGJQi0NdlmMoyHxa4j" +
       "LRdjGmw2lpd2iZmI53OUINi1FZNdRpgkeSq7o2onXqPmqJLz5oRPtmYaOdW6" +
       "Mogq3Kzm87MMG+jdao9UtYjmyalpmbSlSRbnL+uEb9dHfqO2w6bdOZA3Mzzo" +
       "qXiaDPeTeD4gEiOiCbAK9UFPqiyoQHOw4X7bGdQknM1nfjrGlD6JzRcVnKIw" +
       "1iHtZJ8tVzvQpzZRa0FPxvOsacq5Nwyl/Vpb1LTlLN631+x2NRviTCTHy6rf" +
       "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" +
       "iepEJY12IXTNGLlf830HqN55WP/QGx1yXRyl7PjomSeeKDqfg1f/xBP9b40n" +
       "Lhr1E3d59pNF80qM3LBAzF892D438VN/UROfhpdwYqLwrTfxc3d59jNF89Mx" +
       "8jA0kbt0Qn5u39/9C9j3pqLzO+Eln9gnf2uD+eK57WU0mKj7EmJe1H9p/NUv" +
       "fSb/wmuHY1lNjUCMVO70qdCtXysVNeZ336VOfv4RyZ/0P/D6H/4n+XtPQexN" +
       "Z24oghi5eTc3nC7LR86rbxIoS5+/WMr6B3eZxF8umtfgkjZtx2nHcWhrSVxU" +
       "pm63RO/d+bZxPrmf/2YmN42RJ+/w8UFRRn37LV9BHb7c0X/u1RsPPPnq7N+U" +
       "9fezr2se5JAHzMRxLta1LtxfD0Jg2qWBDx6qXEH585snG9VdNqAYuQe2pfq/" +
       "cWD6Yox8+12YClArby7y/E6MvOV2PFA6bC9S/jPo+6uUMXJf+XuR7l/EyEPn" +
       "dHDQw81Fkn8FpUOS4vbLZWj8jfTahf3vZIGVU/fEG03dGcvFan8RwOVHbaf7" +
       "WyKerJMvvMry3//15ucOXxvojprnhZQHOOT+w4cPZ3vkc3eUdirrOvPebzz6" +
       "8w+++3QpPHpQ+HyxX9DtmdvX9XtuEJeV+PwfP/mPPvgzr/5+WZ36v5ni6qJt" +
       "KAAA");
}
