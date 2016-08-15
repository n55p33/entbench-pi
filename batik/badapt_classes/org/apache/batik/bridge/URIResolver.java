package org.apache.batik.bridge;
public class URIResolver {
    protected org.apache.batik.dom.svg.SVGOMDocument document;
    protected java.lang.String documentURI;
    protected org.apache.batik.bridge.DocumentLoader documentLoader;
    public URIResolver(org.w3c.dom.svg.SVGDocument doc, org.apache.batik.bridge.DocumentLoader dl) {
        super(
          );
        document =
          (org.apache.batik.dom.svg.SVGOMDocument)
            doc;
        documentLoader =
          dl;
    }
    public org.w3c.dom.Element getElement(java.lang.String uri, org.w3c.dom.Element ref)
          throws java.net.MalformedURLException,
        java.io.IOException { org.w3c.dom.Node n = getNode(
                                                     uri,
                                                     ref);
                              if (n == null) { return null;
                              }
                              else
                                  if (n.
                                        getNodeType(
                                          ) ==
                                        org.w3c.dom.Node.
                                          DOCUMENT_NODE) {
                                      throw new java.lang.IllegalArgumentException(
                                        );
                                  }
                                  else {
                                      return (org.w3c.dom.Element)
                                               n;
                                  } }
    public org.w3c.dom.Node getNode(java.lang.String uri,
                                    org.w3c.dom.Element ref)
          throws java.net.MalformedURLException,
        java.io.IOException,
        java.lang.SecurityException { java.lang.String baseURI =
                                        getRefererBaseURI(
                                          ref);
                                      if (baseURI ==
                                            null &&
                                            uri.
                                            charAt(
                                              0) ==
                                            '#') {
                                          return getNodeByFragment(
                                                   uri.
                                                     substring(
                                                       1),
                                                   ref);
                                      }
                                      org.apache.batik.util.ParsedURL purl =
                                        new org.apache.batik.util.ParsedURL(
                                        baseURI,
                                        uri);
                                      if (documentURI ==
                                            null)
                                          documentURI =
                                            document.
                                              getURL(
                                                );
                                      java.lang.String frag =
                                        purl.
                                        getRef(
                                          );
                                      if (frag !=
                                            null &&
                                            documentURI !=
                                            null) {
                                          org.apache.batik.util.ParsedURL pDocURL =
                                            new org.apache.batik.util.ParsedURL(
                                            documentURI);
                                          if (pDocURL.
                                                sameFile(
                                                  purl)) {
                                              return document.
                                                getElementById(
                                                  frag);
                                          }
                                      }
                                      org.apache.batik.util.ParsedURL pDocURL =
                                        null;
                                      if (documentURI !=
                                            null) {
                                          pDocURL =
                                            new org.apache.batik.util.ParsedURL(
                                              documentURI);
                                      }
                                      org.apache.batik.bridge.UserAgent userAgent =
                                        documentLoader.
                                        getUserAgent(
                                          );
                                      userAgent.
                                        checkLoadExternalResource(
                                          purl,
                                          pDocURL);
                                      java.lang.String purlStr =
                                        purl.
                                        toString(
                                          );
                                      if (frag !=
                                            null) {
                                          purlStr =
                                            purlStr.
                                              substring(
                                                0,
                                                purlStr.
                                                  length(
                                                    ) -
                                                  (frag.
                                                     length(
                                                       ) +
                                                     1));
                                      }
                                      org.w3c.dom.Document doc =
                                        documentLoader.
                                        loadDocument(
                                          purlStr);
                                      if (frag !=
                                            null)
                                          return doc.
                                            getElementById(
                                              frag);
                                      return doc;
    }
    protected java.lang.String getRefererBaseURI(org.w3c.dom.Element ref) {
        return ((org.apache.batik.dom.AbstractNode)
                  ref).
          getBaseURI(
            );
    }
    protected org.w3c.dom.Node getNodeByFragment(java.lang.String frag,
                                                 org.w3c.dom.Element ref) {
        return ref.
          getOwnerDocument(
            ).
          getElementById(
            frag);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZfWwUxxWfO39/fwA25cOAMVQYchcKtI1MScDY2OT8IRus" +
       "xhSOud2588Le7rI7a5+dkhKkCipVCCghpAL6DwQV0RC1idJWBVFFbRKlrRpC" +
       "mqZVaNX+kzZFDaqaVqVfb2a/93x2kYqlnd2bee/NvDfv/d6b8ZU7qMTQUQtR" +
       "aIxOasSIdSl0EOsGETtlbBg7oC8pPFuE/7Lng/5Hoqh0FNWOYaNPwAbplogs" +
       "GqNosaQYFCsCMfoJERnHoE4Moo9jKqnKKJonGb1ZTZYEifapImEEI1hPoAZM" +
       "qS6lTEp6bQEULU7ASuJ8JfHN4eGOBKoWVG3SI5/vI+/0jTDKrDeXQVF9Yh8e" +
       "x3GTSnI8IRm0I6ej1ZoqT2ZklcZIjsb2yRtsE2xPbMgzQeuLdR/fOz5Wz00w" +
       "ByuKSrl6xhAxVHmciAlU5/V2ySRrHEBPoaIEqvIRU9SWcCaNw6RxmNTR1qOC" +
       "1dcQxcx2qlwd6kgq1QS2IIqWBYVoWMdZW8wgXzNIKKe27pwZtF3qamtpmafi" +
       "M6vjp57dU//tIlQ3iuokZZgtR4BFUJhkFAxKsimiG5tFkYijqEGBzR4muoRl" +
       "acre6UZDyiiYmrD9jllYp6kRnc/p2Qr2EXTTTYGquqtemjuU/askLeMM6Nrk" +
       "6Wpp2M36QcFKCRampzH4nc1SvF9SRIqWhDlcHdseBwJgLcsSOqa6UxUrGDpQ" +
       "o+UiMlYy8WFwPSUDpCUqOKBO0YKCQpmtNSzsxxmSZB4Zohu0hoCqghuCsVA0" +
       "L0zGJcEuLQjtkm9/7vRvPPak0qNEUQTWLBJBZuuvAqaWENMQSROdQBxYjNXt" +
       "idO46drRKEJAPC9EbNG88sW7j61pufG6RbNwGpqB1D4i0KRwIVX71qLOVY8U" +
       "sWWUa6ohsc0PaM6jbNAe6chpgDBNrkQ2GHMGbwz9+IlDl8mHUVTZi0oFVTaz" +
       "4EcNgprVJJno24hCdEyJ2IsqiCJ28vFeVAbfCUkhVu9AOm0Q2ouKZd5VqvLf" +
       "YKI0iGAmqoRvSUmrzreG6Rj/zmkIoTJ4UDU8K5H1x98UjcTH1CyJYwErkqLG" +
       "B3WV6W/EAXFSYNuxeAq8fn/cUE0dXDCu6pk4Bj8YI/ZASpfEDInvHOq13V6P" +
       "Mf/SHpjkHNNpzkQkAuZeFA52GeKkR5VFoieFU+aWrrsvJN+0HIk5v20NipbD" +
       "ZDFrshifLGZNFvNNhiIRPsdcNqm1nbAZ+yGsAVerVw3v3r73aGsR+JE2UQyW" +
       "ZKStgfzS6cW+A9hJ4WpjzdSy22tfjaLiBGrEAjWxzNLFZj0DQCTst2O1OgWZ" +
       "x0sAS30JgGUuXRWICPhTKBHYUspV0IP1UzTXJ8FJTywQ44WTw7TrRzfOTDw9" +
       "8qWHoygaxHw2ZQnAFWMfZEjtInJbONank1t35IOPr54+qHpRH0giTu7L42Q6" +
       "tIa9IGyepNC+FL+cvHawjZu9AlCZYogiALyW8BwBUOlwAJrpUg4Kp1U9i2U2" +
       "5Ni4ko7p6oTXw92zgX/PBbeoYlHWBE+HHXb8zUabNNY2W+7M/CykBU8AnxvW" +
       "zv3yZ39Yx83t5Io6X5IfJrTDh09MWCNHogbPbXfohADd+2cGv/bMnSO7uM8C" +
       "xfLpJmxjbSfgEmwhmPnLrx947ze3L9yKen5OIUGbKahzcq6SrB9VzqAkzLbS" +
       "Ww/gmwxIwLymbacC/imlJZySCQusf9atWPvyn47VW34gQ4/jRmtmF+D1f2IL" +
       "OvTmnr+1cDERgeVXz2YemQXaczzJm3UdT7J15J6+ufi51/A5gH+AXEOaIhxF" +
       "o9wGUa75fIoWMhyZWCfERDUbM8YzseGRbVtVwcwSu5wBmpWFsMYhTKgY8Ir7" +
       "wQbO9DBv1zMb8ukQH+tgzQrDH0/BkPWVVknh+K2PakY+un6XGyBYm/ndpw9r" +
       "HZbHsmZlDsQ3h/GuBxtjQLf+Rv8X6uUb90DiKEgUALONAZ2tPOBsNnVJ2a9+" +
       "+GrT3reKULQbVcqgYjfmcYsqIGCIMQYgndMefczyl4lyaOq5qihP+bwOtmdL" +
       "pveGrqxG+f5Nfbf5pY2Xzt/mjqtZMhZy/iKWNwJAzSt8Dysuv/2Zdy6dOD1h" +
       "1QirCgNkiG/+Pwbk1OHf/T3P5Bwap6lfQvyj8StnF3Ru+pDzexjFuNty+bkO" +
       "cN7j/dTl7F+jraU/iqKyUVQv2BX1CJZNFvmjUEUaTpkNVXdgPFgRWuVPh4vB" +
       "i8L46Js2jI5ejoVvRs2+a0KAWMu2cAU87TZWtIcBMYL4Rx9n+SRv21nzkIM/" +
       "FZquUlglEUMQVDODWIrKxVkj0xfGA31OfFoAzdqNrOm3Jn20oO9uC+q6DJ64" +
       "vah4AV0/b+nKmsF8lQpxU1TlqAR1i6NVPY8Mtpkxq7wPrf+J+1z/GnjW2ytY" +
       "X2D9eMb1F+KmqFYMYCDr/WxouakZlpvzpl3tTsv/SlGo0PUnIw8LEAO8xYXO" +
       "IvwcdeHwqfPiwMW1Fho0Buv7Lji+fusX//pJ7Mxv35imzKygqvaQTMaJ7Juz" +
       "mE0ZwJ8+fkzzgvn92pO//15bZsv91Iisr2WWKpD9XgJKtBeGtPBSXjv8xwU7" +
       "No3tvY9yb0nInGGR3+y78sa2lcLJKD+TWiiTd5YNMnUEsaVSJ3D4VnYEEGa5" +
       "6wBz2MYuhqfHdoCesNd6LhbyHbeQKcQays92OcB+7nbib46/JmA3JLDXfMbJ" +
       "6ZkdvhYetwqhsT4sszqTiDuHEl05gWiuxZl4Tiapsd4Bd4yLP8gaSlFlhlB7" +
       "WtYz5YWSOVvkz5x1WUeXxvs112KcvRme3bbFdt+/sQuxzmBsrhkX/dUQVZGV" +
       "5NnPp1hzyK3VfLhIBFOX6GTQgMdYc4SiMjBgP4SLC6j+DXUHuEWPPgCLznMw" +
       "64RtlhOzWHQaxC3EGrJVxMqonjHPzVB/foM1ZyhqAPNYhyR9CwAQZB7P/blR" +
       "nnsARuEx3QbPWVuzs/dvlEKs/5ObXZ7BMldYc9GyDPOPLZPdOs44AXjSs8zz" +
       "/w/L5CDt+64pWDE8P+/O07qnE144X1fefH7nuzyTuHdp1ZAT0qYs+8s133ep" +
       "ppO0xDWrtoo3jb9eoqi5wFkGzoTWB1/0dyz6V+zQ8dNTVMLffrrvA2Z5dCDK" +
       "+vCTXKOoCEjY53VtmkLHqlpzkWBqd+0+bza7+6qB5YHkyO+cnURmWrfOSeHq" +
       "+e39T9799EXrVC7IeGqKSalKoDLrgsBNhssKSnNklfasulf7YsWKqO1MDdaC" +
       "PXde6PO0LohWje34gtCR1WhzT67vXdh4/adHS29CPbILRTBkjF359X1OM6EK" +
       "2ZXw6hDf/yz4Wbpj1dcnN61J//nX/ASFrAuuRYXpk8KtS7vfPjn/Apy5q3pR" +
       "CZROJMcPHlsnlSEijOujqEYyunKwRJAiYbkXlZuKdMAkvWICKkFwTszKVW4X" +
       "25w1bi+706GoNe/aeZqbMDhtTgA2qaYiMjE1ULh4PYHLcNvhK01NCzF4Pe5W" +
       "zs3XPSls/UrdD443FnVDgAXU8YsvM8yUW6v478d5B9/Xegut/gN/EXj+zR62" +
       "6ayDveGM1mnfFS91L4vhWGuNFSUTfZrm0EbWaVaI/Jw1N3Osn6JIu90bwv13" +
       "+Py3+Cdr3v0vbBc1+CsbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "skt6lJnvWVjOpqphA3ZLzV6pEAlaocbmEBG2+qbfrhgjZ8WgE8OtjVG9RLLD" +
       "WWUQOMuVW46Hngr3YDRBOtaCw9bBbIo1q8pARNtw33Tbs8Gs0fQQbmWHwpI3" +
       "nChxjHww8SOENjp2bshYeFwhWjWqsppNKTyKJVnpxq461OMBh7Y1O1cPozKx" +
       "0GE19KcI4vTKg1WUL+pm0l/P3UgYTQZCr9wLE7OV4+NeBVaXSTKPrCrmUAiC" +
       "FkXej6oorvsexnF9p1mdznv9oK50gmGdni6iyipmyqSdD6JZdS3mLNzqdMZ5" +
       "eF2u+AJmSESv34QnnK5P5OKMHFhMyxdYupdvFlhr1mp1hGIprifYYBZqrtqV" +
       "7Ybik3KJ0MR1V1RGfWkkrP0qRkl1uGyJulgoIT2zlu8Rzak6EHslfilH2kwJ" +
       "YlfzJwXfT9yJ3gy7LSNXnHN6uOKNwkQXHF8u1OXCmhhW5gJttA3NqJe5YJYU" +
       "ZxxNsdEyKa5QjlGmq8hHUawvRWNTyYtiWw5gxB+Fq8Ss+562nCIyM2L5Dlsk" +
       "raGDasm6n2dVQsPrbWpa6kxG84E8kwq0PljU58MCTTRKC7g5ZbphixsO5w0i" +
       "sQZxqTAODI1KuO5IWDXyrY7XY1cD17YW3WHC1hHVHqD8WnNrQ3KmrcfVRlwb" +
       "8fXyEBGNsWX5tXHYWuVHIogSYeIjcmS0+j5SpMQpX64PDDB+tbNuDqkhwQ9l" +
       "yi8UatMF7VeSBIkRothoBnCp4HDNVmUII1Su7FottFCYoqqidstWmKwnYVd2" +
       "UL42ybkzH674aD6vOI5D5VZNzgtsO78Qq4rt6sW4vewk9oSro0hOXiclFk5G" +
       "FZmcsANCVT0vqmF8UW40+3DUmEz7lN1oLWbFPBuYS6LrGmAZ5+quDOdgMRHK" +
       "cMmtF2fd5ZqCJYsZm5ynUrTSdWElX51Uy9Vqa+qxjTKudNw+LRh9u0l4c79O" +
       "ar7fpy1yaaiCHxpqeeZzfZdCB01ZaAynslIaUjnC1riFAoJ/0BijnJZMSuVo" +
       "KmsFRJC7NFZtDEWcGE/qy0U7X6xOUWpQavUxfhqXtKaKrJMCJzoLsCe2yBLa" +
       "QxBritTotlcLw/Fs6iwr/YAuR+pwYSE1Z1108864wY+p3kAadg3fMuiWvqBC" +
       "sM+drUOrH497NX0mLqcGH/blQW0ZgW1Bf9mOJ37SZ7nCFCvGqKjD5VypY5MK" +
       "Iii8Kw6aWjCZ1zBXmAG7aqEMoRWGsy4hkZHWz6FkI2kXhgrY9/v56ZA2fITx" +
       "5GahkG9bbHNemzKVmR8NKmuGK0WFckUu1qvIVJmHATInkdZ0ASfjElYS1k0Q" +
       "3geoaaltuooShUjjOiHZppmJyntmriVyAivgSC9GyTzlW6UeHlZzYhyheXi4" +
       "zsMN2ctHuUisSyjc8EVwMnx9emRcv7xT+61ZMuLgYvL/kIbYdD2YFo8cJHCy" +
       "32no2GXW4Rz5NssJpSfwe29035idvj/0tmeek6kPozt72eEggM4FtvNThhIp" +
       "xiFSNwFKj9840zDIrlu3WcvPv+1f7pm8QXvLy7jeuf8Yn8dJ/tbg+S92HpV+" +
       "ZQc6eZDDvOYi+CjSlaOZy/OeEoSeNTmSv7z3QLO3pxq7FzzdPc12j6fGtnN3" +
       "/bzYazZzfyz5vpfrz2Z/P6N3++GEf/plgWIFGfK7r4+8j3dflmOylGB3IBjp" +
       "JZIiM2OitZIU50C9KfkMTLd3ceqgLyP/3rR4RwCdnyvB3rBpy9Nbg3znS6VP" +
       "DqfUs4anDjSYgd0FnjftafBNP34NZuxmUL9+DOrk1h2fSYv3H9yuHEqfKlLo" +
       "6cH6qFZ+Iy2eDaAzQCukLSsHedfDs3TQkanpgz+Cmu7Yd9v37KnpPS9XTZ3r" +
       "qunEFmCjod9+kWug302L50GYAjJv7iq9uuArzBjfGmom6cd+BEkzl7oMnmf3" +
       "JH32xyPp9Q3iMy8i7h+nxac34qYzWV+3PWG+b/8f2Yr7By9H3FUA3Xzo3jy9" +
       "BLz7mo9wNh+OSB9/7uLZu55j/jq7Oj74uOMcAZ1VQ8M4fMFyqH7a8RRVzyQ4" +
       "t7lucbK/zwXQXTe4Dwyg05tKxu1nN/Bf3DPmw/ABdCr7Pwz3ZRAatnCA1KZy" +
       "GOTPA+gkAEmrf+Fc54Zic8+0OnF0HTrQ720vpd9DS9fDRxac7COo/cUh3HwG" +
       "dVX6xHM98ue+W/rw5mZbMoQkSamcJaAzm0v2gwXmwRtS26d1uvvY9y988twj" +
       "+4vhhQ3DWxs9xNv9179GbplOkF38Jp++6/de95HnvpYl//8XpISzf50mAAA=");
}
