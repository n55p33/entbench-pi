package org.apache.batik.swing.svg;
public class SVGUserAgentAdapter implements org.apache.batik.swing.svg.SVGUserAgent {
    public SVGUserAgentAdapter() { super(); }
    public void displayError(java.lang.String message) { java.lang.System.
                                                           err.println(message);
    }
    public void displayError(java.lang.Exception ex) { ex.printStackTrace(
                                                            ); }
    public void displayMessage(java.lang.String message) { java.lang.System.
                                                             out.println(
                                                                   message);
    }
    public void showAlert(java.lang.String message) { java.lang.System.err.
                                                        println(
                                                          message); }
    public java.lang.String showPrompt(java.lang.String message) { return "";
    }
    public java.lang.String showPrompt(java.lang.String message, java.lang.String defaultValue) {
        return defaultValue;
    }
    public boolean showConfirm(java.lang.String message) { return false;
    }
    public float getPixelUnitToMillimeter() { return 0.26458332F;
    }
    public float getPixelToMM() { return getPixelUnitToMillimeter(
                                           ); }
    public java.lang.String getDefaultFontFamily() { return "Serif";
    }
    public float getMediumFontSize() { return 9.0F * 25.4F / (72.0F *
                                                                getPixelUnitToMillimeter(
                                                                  ));
    }
    public float getLighterFontWeight(float f) { int weight =
                                                   (int)
                                                     ((f +
                                                         50) /
                                                        100) *
                                                   100;
                                                 switch (weight) {
                                                     case 100:
                                                         return 100;
                                                     case 200:
                                                         return 100;
                                                     case 300:
                                                         return 200;
                                                     case 400:
                                                         return 300;
                                                     case 500:
                                                         return 400;
                                                     case 600:
                                                         return 400;
                                                     case 700:
                                                         return 400;
                                                     case 800:
                                                         return 400;
                                                     case 900:
                                                         return 400;
                                                     default:
                                                         throw new java.lang.IllegalArgumentException(
                                                           "Bad Font Weight: " +
                                                           f);
                                                 }
    }
    public float getBolderFontWeight(float f) { int weight =
                                                  (int)
                                                    ((f +
                                                        50) /
                                                       100) *
                                                  100;
                                                switch (weight) {
                                                    case 100:
                                                        return 600;
                                                    case 200:
                                                        return 600;
                                                    case 300:
                                                        return 600;
                                                    case 400:
                                                        return 600;
                                                    case 500:
                                                        return 600;
                                                    case 600:
                                                        return 700;
                                                    case 700:
                                                        return 800;
                                                    case 800:
                                                        return 900;
                                                    case 900:
                                                        return 900;
                                                    default:
                                                        throw new java.lang.IllegalArgumentException(
                                                          "Bad Font Weight: " +
                                                          f);
                                                }
    }
    public java.lang.String getLanguages() {
        return "en";
    }
    public java.lang.String getUserStyleSheetURI() {
        return null;
    }
    public java.lang.String getXMLParserClassName() {
        return org.apache.batik.util.XMLResourceDescriptor.
          getXMLParserClassName(
            );
    }
    public boolean isXMLParserValidating() {
        return false;
    }
    public java.lang.String getMedia() { return "screen";
    }
    public java.lang.String getAlternateStyleSheet() {
        return null;
    }
    public void openLink(java.lang.String uri,
                         boolean newc) { 
    }
    public boolean supportExtension(java.lang.String s) {
        return false;
    }
    public void handleElement(org.w3c.dom.Element elt,
                              java.lang.Object data) {
        
    }
    public org.apache.batik.bridge.ScriptSecurity getScriptSecurity(java.lang.String scriptType,
                                                                    org.apache.batik.util.ParsedURL scriptURL,
                                                                    org.apache.batik.util.ParsedURL docURL) {
        return new org.apache.batik.bridge.RelaxedScriptSecurity(
          scriptType,
          scriptURL,
          docURL);
    }
    public void checkLoadScript(java.lang.String scriptType,
                                org.apache.batik.util.ParsedURL scriptURL,
                                org.apache.batik.util.ParsedURL docURL)
          throws java.lang.SecurityException {
        org.apache.batik.bridge.ScriptSecurity s =
          getScriptSecurity(
            scriptType,
            scriptURL,
            docURL);
        if (s !=
              null) {
            s.
              checkLoadScript(
                );
        }
    }
    public org.apache.batik.bridge.ExternalResourceSecurity getExternalResourceSecurity(org.apache.batik.util.ParsedURL resourceURL,
                                                                                        org.apache.batik.util.ParsedURL docURL) {
        return new org.apache.batik.bridge.RelaxedExternalResourceSecurity(
          resourceURL,
          docURL);
    }
    public void checkLoadExternalResource(org.apache.batik.util.ParsedURL resourceURL,
                                          org.apache.batik.util.ParsedURL docURL)
          throws java.lang.SecurityException {
        org.apache.batik.bridge.ExternalResourceSecurity s =
          getExternalResourceSecurity(
            resourceURL,
            docURL);
        if (s !=
              null) {
            s.
              checkLoadExternalResource(
                );
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ae3DcxBlfnRPbseP4kcQJSey8nEAevUuAlIeB4jg2cTgn" +
       "xk4ccCCOrNuzlegkRdqzz6Yuj0IJDKWZECB0SgozodAOENpC004JpJOWRwlM" +
       "eT/Ko1PKAC0pybRD/wBKv2+lO+nkk8x1evXMrnW7++3u99vfft+30j5wnEw0" +
       "DVJPVRZmwzo1wy0q6xANk8aaFdE0N0JZr3RHkfiPrR+uPydEinvIlAHRbJdE" +
       "k7bKVImZPaROVk0mqhI111MaQ4kOg5rUGBSZrKk9ZLpstiV0RZZk1q7FKDbo" +
       "Fo0oqRYZM+S+JKNtdgeM1EVhJhE+k0iTt7oxSiZLmj7sNJ/pat7sqsGWCWcs" +
       "k5Gq6HZxUIwkmaxEorLJGlMGWaZrynC/orEwTbHwdmWVDcG66KoxECx4uPLT" +
       "z3YPVHEIpoqqqjGuntlJTU0ZpLEoqXRKWxSaMHeSb5GiKCl3NWakIZoeNAKD" +
       "RmDQtLZOK5h9BVWTiWaNq8PSPRXrEk6IkfnZneiiISbsbjr4nKGHUmbrzoVB" +
       "23kZbS0tx6h427LI3ju2Vv2siFT2kEpZ7cLpSDAJBoP0AKA00UcNsykWo7Ee" +
       "Uq3CYndRQxYVecRe6RpT7ldFloTlT8OChUmdGnxMBytYR9DNSEpMMzLqxTmh" +
       "7F8T44rYD7rWOrpaGrZiOShYJsPEjLgIvLNFJuyQ1Rgjc70SGR0bLoYGIFqS" +
       "oGxAyww1QRWhgNRYFFFEtT/SBdRT+6HpRA0IaDAyy7dTxFoXpR1iP+1FRnra" +
       "dVhV0GoSBwJFGJnubcZ7glWa5Vkl1/ocX3/eLVeqa9UQEWDOMSopOP9yEKr3" +
       "CHXSODUo7ANLcPLS6O1i7eFdIUKg8XRPY6vNoW+evHB5/ZGnrTazc7TZ0Led" +
       "SqxXOtA35YU5zUvOKcJplOqaKePiZ2nOd1mHXdOY0sHC1GZ6xMpwuvJI55OX" +
       "Xf0T+rcQKWsjxZKmJBPAo2pJS+iyQo2LqEoNkdFYG5lE1Vgzr28jJfAclVVq" +
       "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" +
       "bDEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KftXGflCVHjINCLOSg1bcK1o5LGWbVuO");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ERk3XIpum9qeEh0K4HfPKoBHQYp3AojPXwBfO6XsDzLyH8B6cyAAAJ7N8r58" +
       "iO8rZ53Dbwbp+R2+588f3zdOKfuvGfmjqPB6gK9lTJXYjtqeG7UVx7LXJ+bw" +
       "18+qxydB+sAO5wfOH+efnlL2Zxn57yBqBzhZQ7diJ4PJWxvjhDL/x1lBPg3S" +
       "h3YgP3Q+II84qi9nDHu33hzp3sUs87tbjTKWOQOTNIM6NrLn42D3CmcFewWk" +
       "n9+B/fnXCOy9p4C9PyN3gVgSgMXzjydvivXus87SbAX6zA7rZ87devceOaXs" +
       "sYy8ceuFGBAwxyAaDI/Pzr2HzsML/foO36+fP763nlL2bEae2tps9rLKR2vb" +
       "4GcG+DWkTuC8clacbwHp1R3OV88fJ3JKWTUjUFR4A8A5YZn8s/8gfwHv7V5L" +
       "jwCFzxoyvRWkL+6AfvH8gZ5WhmfkKgBqhddwiopt6eCtf/vV0KuHQN9xVo0+" +
       "DNKXd0C/fP5AmVPKehnpRIU7duuKckKJ5FmxZUr8yg7bV84f2+SUMjkjfFR4" +
       "EGDDbLCOuEpkHE7NE0hHZ30dLYP0hzukf3g+SE++ybya49JPwTzNyHNAn55v" +
       "uNn3sxnT4Svp3nvOOimfAukbO5TfOB+UJ99j9vxTAGabJXuLCHQT+74XREQa" +
       "GW64+078yKS0z6rOGkjf2gH91rmqM/+dbSBlu55JRdvXPWc/u/Rl7O5nHf8E" +
       "dfsBbg7+x04RzPszkkSF180UV7eNXXsn1J+eQSqZlyoUAcCdULb/zy6VWw63" +
       "qckD+I9ftyG8veqT3zMThkyG5Sdz2B86RSQfycgHt0EzrwWWH/GGFgdWtD7o" +
       "583X9aMGlm4a+zdgzwX4wlnNqgRk8fROgE+dvwBzwRxK5+M3nmoH8H/wyIfO" +
       "O6jHtjL3XsrIz0SFy0BA2oLxFH0rmBNm9bEzSOWOnVfZu7qTytVznWwnBHLK" +
       "btdettu190kgFWAumVsB64WdXTPMPp4+aTjwzQzn1Iq5sM6yZZabUAXglnbC" +
       "OqddwRsL67M3ddR7fytn+McZ+YdR4QeumcdJ+CcM5Ve+H+wpcJE3uBKW3W95" +
       "6LoLqNtLk9ovvnT5jje+JPyb/FbUtYuNdzKFO6axbR+9jnDk+aIfGFMrF8yd" +
       "28sJfg7vN6LCwzc/mYoKtwCajXrvlS3/b4JY48b8UeG2/P9R7s8DL3+SG/Dl" +
       "/4/y/YuocOmQLypc3D4cZfldMBbAkj1+MbODvfem2zn+0FEzyvcH7v9eGrhW" +
       "5eh1quyALL8afHCYFW8vBz+nffqlbu9Hv1395PY6l2Yrm03Wyh1M4fbtzbK8" +
       "0exA7ImbtnbQ1kXyme/c80t3Pn1weHfPdsCHJn1kbI/f+O4U4fhRfttp89k3" +
       "/so7/u5Lv59foPh/pn/4ObM9AAA=");
}
